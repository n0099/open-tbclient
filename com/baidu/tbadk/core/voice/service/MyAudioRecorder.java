package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import android.media.MediaRecorder;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class MyAudioRecorder implements d {
    private boolean bVJ;
    private int bVM;
    private State bVN;
    private short bVO;
    private int bVP;
    private short bVQ;
    private int bVR;
    private int bVS;
    private int bVT;
    private RandomAccessFile bVu;
    private byte[] buffer;
    private int bufferSize;
    private String filePath;
    private int payloadSize;
    private Thread writeThread;
    private static final int[] bVI = {44100, 22050, 11025, 8000};
    private static Object mLock = new Object();
    private static AudioRecord bVK = null;
    private static MediaRecorder bVL = null;

    /* loaded from: classes.dex */
    public enum State {
        INITIALIZING,
        READY,
        RECORDING,
        ERROR,
        STOPPED
    }

    public static MyAudioRecorder d(Boolean bool) {
        MyAudioRecorder myAudioRecorder;
        synchronized (mLock) {
            bVK = null;
            bVL = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, bVI[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.afy() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, bVI[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State afy() {
        return this.bVN;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.bVM = 0;
        this.filePath = null;
        try {
            this.bVJ = z;
            if (this.bVJ) {
                if (i4 == 2) {
                    this.bVQ = (short) 16;
                } else {
                    this.bVQ = (short) 8;
                }
                if (i3 == 2) {
                    this.bVO = (short) 1;
                } else {
                    this.bVO = (short) 2;
                }
                this.bVR = i;
                this.bVP = i2;
                this.bVS = i4;
                this.bVT = (i2 * 120) / 1000;
                this.bufferSize = (((this.bVT * 2) * this.bVQ) * this.bVO) / 8;
                if (this.bufferSize < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.bVT = this.bufferSize / (((this.bVQ * 2) * this.bVO) / 8);
                    BdLog.w(MyAudioRecorder.class.getName() + "Increasing buffer size to " + Integer.toString(this.bufferSize));
                }
                bVK = new AudioRecord(i, i2, i3, i4, this.bufferSize);
                if (bVK.getRecordingState() == 3) {
                    bVK.stop();
                }
                if (bVK.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                bVL = new MediaRecorder();
                bVL.setAudioSource(1);
                bVL.setOutputFormat(1);
                bVL.setAudioEncoder(1);
            }
            this.bVM = 0;
            this.filePath = null;
            this.bVN = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while initializing recording");
            }
            this.bVN = State.ERROR;
        }
    }

    public boolean nA(String str) {
        try {
            if (this.bVN == State.INITIALIZING) {
                this.filePath = str;
                if (!this.bVJ) {
                    bVL.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while setting output path");
            }
            this.bVN = State.ERROR;
            return false;
        }
    }

    public boolean prepare() {
        try {
            if (this.bVN == State.INITIALIZING) {
                if (this.bVJ) {
                    if ((this.filePath != null) & (bVK.getState() == 1)) {
                        if (this.bVu != null) {
                            this.bVu.close();
                            this.bVu = null;
                        }
                        this.bVu = new RandomAccessFile(this.filePath, "rw");
                        this.bVu.setLength(0L);
                        this.bVu.writeBytes("RIFF");
                        this.bVu.writeInt(0);
                        this.bVu.writeBytes("WAVE");
                        this.bVu.writeBytes("fmt ");
                        this.bVu.writeInt(Integer.reverseBytes(16));
                        this.bVu.writeShort(Short.reverseBytes((short) 1));
                        this.bVu.writeShort(Short.reverseBytes(this.bVO));
                        this.bVu.writeInt(Integer.reverseBytes(this.bVP));
                        this.bVu.writeInt(Integer.reverseBytes(((this.bVP * this.bVQ) * this.bVO) / 8));
                        this.bVu.writeShort(Short.reverseBytes((short) ((this.bVO * this.bVQ) / 8)));
                        this.bVu.writeShort(Short.reverseBytes(this.bVQ));
                        this.bVu.writeBytes("data");
                        this.bVu.writeInt(0);
                        this.buffer = new byte[((this.bVT * this.bVQ) / 8) * this.bVO];
                        this.bVN = State.READY;
                    } else {
                        BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on uninitialized recorder");
                        this.bVN = State.ERROR;
                        return false;
                    }
                } else {
                    bVL.prepare();
                    this.bVN = State.READY;
                }
                return true;
            }
            BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on illegal state");
            release();
            this.bVN = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured in prepare()");
            }
            this.bVN = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.bVN == State.RECORDING) {
            stop();
        } else {
            if ((this.bVN == State.READY) & this.bVJ) {
                try {
                    this.bVu.close();
                } catch (IOException e) {
                    BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.bVJ) {
            if (bVK != null) {
                bVK.release();
            }
        } else if (bVL != null) {
            bVL.release();
        }
    }

    public void start() {
        if (this.bVN == State.READY) {
            if (this.bVJ) {
                this.payloadSize = 0;
                bVK.startRecording();
                bVK.read(this.buffer, 0, this.buffer.length);
            } else {
                bVL.start();
            }
            this.bVN = State.RECORDING;
            return;
        }
        BdLog.e(MyAudioRecorder.class.getName() + "start() called on illegal state");
        this.bVN = State.ERROR;
    }

    public void stop() {
        BdLog.e(MyAudioRecorder.class.getName() + "audioRecorder.stop()");
        bVK.stop();
        try {
            this.bVu.seek(4L);
            this.bVu.writeInt(Integer.reverseBytes(this.payloadSize + 36));
            this.bVu.seek(40L);
            this.bVu.writeInt(Integer.reverseBytes(this.payloadSize));
            this.bVu.close();
            BdLog.e(MyAudioRecorder.class.getName() + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
            this.bVN = State.ERROR;
        }
        this.bVN = State.STOPPED;
    }

    private short b(byte b, byte b2) {
        return (short) ((b2 << 8) | b);
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean ny(String str) {
        if (nA(str)) {
            return prepare();
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean afu() {
        synchronized (mLock) {
            if (this.writeThread == null || !this.writeThread.isAlive()) {
                this.writeThread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.MyAudioRecorder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MyAudioRecorder.this.aft();
                    }
                });
                this.writeThread.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void afv() {
        this.bVN = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean afw() {
        return this.bVN == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aft() {
        if (bVK != null) {
            try {
                start();
                while (afw()) {
                    bVK.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.bVu.write(this.buffer);
                        this.payloadSize += this.buffer.length;
                        if (this.bVQ == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short b = b(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (b > this.bVM) {
                                    this.bVM = b;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.bVM) {
                                    this.bVM = this.buffer[i2];
                                }
                            }
                        }
                    } catch (IOException e) {
                    }
                }
                stop();
                release();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }
}
