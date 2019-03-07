package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import android.media.MediaRecorder;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class MyAudioRecorder implements d {
    private boolean bVG;
    private int bVJ;
    private State bVK;
    private short bVL;
    private int bVM;
    private short bVN;
    private int bVO;
    private int bVP;
    private int bVQ;
    private RandomAccessFile bVr;
    private byte[] buffer;
    private int bufferSize;
    private String filePath;
    private int payloadSize;
    private Thread writeThread;
    private static final int[] bVF = {44100, 22050, 11025, 8000};
    private static Object mLock = new Object();
    private static AudioRecord bVH = null;
    private static MediaRecorder bVI = null;

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
            bVH = null;
            bVI = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, bVF[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.afB() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, bVF[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State afB() {
        return this.bVK;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.bVJ = 0;
        this.filePath = null;
        try {
            this.bVG = z;
            if (this.bVG) {
                if (i4 == 2) {
                    this.bVN = (short) 16;
                } else {
                    this.bVN = (short) 8;
                }
                if (i3 == 2) {
                    this.bVL = (short) 1;
                } else {
                    this.bVL = (short) 2;
                }
                this.bVO = i;
                this.bVM = i2;
                this.bVP = i4;
                this.bVQ = (i2 * 120) / 1000;
                this.bufferSize = (((this.bVQ * 2) * this.bVN) * this.bVL) / 8;
                if (this.bufferSize < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.bVQ = this.bufferSize / (((this.bVN * 2) * this.bVL) / 8);
                    BdLog.w(MyAudioRecorder.class.getName() + "Increasing buffer size to " + Integer.toString(this.bufferSize));
                }
                bVH = new AudioRecord(i, i2, i3, i4, this.bufferSize);
                if (bVH.getRecordingState() == 3) {
                    bVH.stop();
                }
                if (bVH.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                bVI = new MediaRecorder();
                bVI.setAudioSource(1);
                bVI.setOutputFormat(1);
                bVI.setAudioEncoder(1);
            }
            this.bVJ = 0;
            this.filePath = null;
            this.bVK = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while initializing recording");
            }
            this.bVK = State.ERROR;
        }
    }

    public boolean nz(String str) {
        try {
            if (this.bVK == State.INITIALIZING) {
                this.filePath = str;
                if (!this.bVG) {
                    bVI.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while setting output path");
            }
            this.bVK = State.ERROR;
            return false;
        }
    }

    public boolean prepare() {
        try {
            if (this.bVK == State.INITIALIZING) {
                if (this.bVG) {
                    if ((this.filePath != null) & (bVH.getState() == 1)) {
                        if (this.bVr != null) {
                            this.bVr.close();
                            this.bVr = null;
                        }
                        this.bVr = new RandomAccessFile(this.filePath, "rw");
                        this.bVr.setLength(0L);
                        this.bVr.writeBytes("RIFF");
                        this.bVr.writeInt(0);
                        this.bVr.writeBytes("WAVE");
                        this.bVr.writeBytes("fmt ");
                        this.bVr.writeInt(Integer.reverseBytes(16));
                        this.bVr.writeShort(Short.reverseBytes((short) 1));
                        this.bVr.writeShort(Short.reverseBytes(this.bVL));
                        this.bVr.writeInt(Integer.reverseBytes(this.bVM));
                        this.bVr.writeInt(Integer.reverseBytes(((this.bVM * this.bVN) * this.bVL) / 8));
                        this.bVr.writeShort(Short.reverseBytes((short) ((this.bVL * this.bVN) / 8)));
                        this.bVr.writeShort(Short.reverseBytes(this.bVN));
                        this.bVr.writeBytes("data");
                        this.bVr.writeInt(0);
                        this.buffer = new byte[((this.bVQ * this.bVN) / 8) * this.bVL];
                        this.bVK = State.READY;
                    } else {
                        BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on uninitialized recorder");
                        this.bVK = State.ERROR;
                        return false;
                    }
                } else {
                    bVI.prepare();
                    this.bVK = State.READY;
                }
                return true;
            }
            BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on illegal state");
            release();
            this.bVK = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured in prepare()");
            }
            this.bVK = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.bVK == State.RECORDING) {
            stop();
        } else {
            if ((this.bVK == State.READY) & this.bVG) {
                try {
                    this.bVr.close();
                } catch (IOException e) {
                    BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.bVG) {
            if (bVH != null) {
                bVH.release();
            }
        } else if (bVI != null) {
            bVI.release();
        }
    }

    public void start() {
        if (this.bVK == State.READY) {
            if (this.bVG) {
                this.payloadSize = 0;
                bVH.startRecording();
                bVH.read(this.buffer, 0, this.buffer.length);
            } else {
                bVI.start();
            }
            this.bVK = State.RECORDING;
            return;
        }
        BdLog.e(MyAudioRecorder.class.getName() + "start() called on illegal state");
        this.bVK = State.ERROR;
    }

    public void stop() {
        BdLog.e(MyAudioRecorder.class.getName() + "audioRecorder.stop()");
        bVH.stop();
        try {
            this.bVr.seek(4L);
            this.bVr.writeInt(Integer.reverseBytes(this.payloadSize + 36));
            this.bVr.seek(40L);
            this.bVr.writeInt(Integer.reverseBytes(this.payloadSize));
            this.bVr.close();
            BdLog.e(MyAudioRecorder.class.getName() + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
            this.bVK = State.ERROR;
        }
        this.bVK = State.STOPPED;
    }

    private short b(byte b, byte b2) {
        return (short) ((b2 << 8) | b);
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean nx(String str) {
        if (nz(str)) {
            return prepare();
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean afx() {
        synchronized (mLock) {
            if (this.writeThread == null || !this.writeThread.isAlive()) {
                this.writeThread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.MyAudioRecorder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MyAudioRecorder.this.afw();
                    }
                });
                this.writeThread.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void afy() {
        this.bVK = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean afz() {
        return this.bVK == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afw() {
        if (bVH != null) {
            try {
                start();
                while (afz()) {
                    bVH.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.bVr.write(this.buffer);
                        this.payloadSize += this.buffer.length;
                        if (this.bVN == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short b = b(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (b > this.bVJ) {
                                    this.bVJ = b;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.bVJ) {
                                    this.bVJ = this.buffer[i2];
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
