package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import android.media.MediaRecorder;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class MyAudioRecorder implements d {
    private boolean bVK;
    private int bVN;
    private State bVO;
    private short bVP;
    private int bVQ;
    private short bVR;
    private int bVS;
    private int bVT;
    private int bVU;
    private RandomAccessFile bVv;
    private byte[] buffer;
    private int bufferSize;
    private String filePath;
    private int payloadSize;
    private Thread writeThread;
    private static final int[] bVJ = {44100, 22050, 11025, 8000};
    private static Object mLock = new Object();
    private static AudioRecord bVL = null;
    private static MediaRecorder bVM = null;

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
            bVL = null;
            bVM = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, bVJ[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.afy() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, bVJ[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State afy() {
        return this.bVO;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.bVN = 0;
        this.filePath = null;
        try {
            this.bVK = z;
            if (this.bVK) {
                if (i4 == 2) {
                    this.bVR = (short) 16;
                } else {
                    this.bVR = (short) 8;
                }
                if (i3 == 2) {
                    this.bVP = (short) 1;
                } else {
                    this.bVP = (short) 2;
                }
                this.bVS = i;
                this.bVQ = i2;
                this.bVT = i4;
                this.bVU = (i2 * 120) / 1000;
                this.bufferSize = (((this.bVU * 2) * this.bVR) * this.bVP) / 8;
                if (this.bufferSize < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.bVU = this.bufferSize / (((this.bVR * 2) * this.bVP) / 8);
                    BdLog.w(MyAudioRecorder.class.getName() + "Increasing buffer size to " + Integer.toString(this.bufferSize));
                }
                bVL = new AudioRecord(i, i2, i3, i4, this.bufferSize);
                if (bVL.getRecordingState() == 3) {
                    bVL.stop();
                }
                if (bVL.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                bVM = new MediaRecorder();
                bVM.setAudioSource(1);
                bVM.setOutputFormat(1);
                bVM.setAudioEncoder(1);
            }
            this.bVN = 0;
            this.filePath = null;
            this.bVO = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while initializing recording");
            }
            this.bVO = State.ERROR;
        }
    }

    public boolean nA(String str) {
        try {
            if (this.bVO == State.INITIALIZING) {
                this.filePath = str;
                if (!this.bVK) {
                    bVM.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while setting output path");
            }
            this.bVO = State.ERROR;
            return false;
        }
    }

    public boolean prepare() {
        try {
            if (this.bVO == State.INITIALIZING) {
                if (this.bVK) {
                    if ((this.filePath != null) & (bVL.getState() == 1)) {
                        if (this.bVv != null) {
                            this.bVv.close();
                            this.bVv = null;
                        }
                        this.bVv = new RandomAccessFile(this.filePath, "rw");
                        this.bVv.setLength(0L);
                        this.bVv.writeBytes("RIFF");
                        this.bVv.writeInt(0);
                        this.bVv.writeBytes("WAVE");
                        this.bVv.writeBytes("fmt ");
                        this.bVv.writeInt(Integer.reverseBytes(16));
                        this.bVv.writeShort(Short.reverseBytes((short) 1));
                        this.bVv.writeShort(Short.reverseBytes(this.bVP));
                        this.bVv.writeInt(Integer.reverseBytes(this.bVQ));
                        this.bVv.writeInt(Integer.reverseBytes(((this.bVQ * this.bVR) * this.bVP) / 8));
                        this.bVv.writeShort(Short.reverseBytes((short) ((this.bVP * this.bVR) / 8)));
                        this.bVv.writeShort(Short.reverseBytes(this.bVR));
                        this.bVv.writeBytes("data");
                        this.bVv.writeInt(0);
                        this.buffer = new byte[((this.bVU * this.bVR) / 8) * this.bVP];
                        this.bVO = State.READY;
                    } else {
                        BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on uninitialized recorder");
                        this.bVO = State.ERROR;
                        return false;
                    }
                } else {
                    bVM.prepare();
                    this.bVO = State.READY;
                }
                return true;
            }
            BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on illegal state");
            release();
            this.bVO = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured in prepare()");
            }
            this.bVO = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.bVO == State.RECORDING) {
            stop();
        } else {
            if ((this.bVO == State.READY) & this.bVK) {
                try {
                    this.bVv.close();
                } catch (IOException e) {
                    BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.bVK) {
            if (bVL != null) {
                bVL.release();
            }
        } else if (bVM != null) {
            bVM.release();
        }
    }

    public void start() {
        if (this.bVO == State.READY) {
            if (this.bVK) {
                this.payloadSize = 0;
                bVL.startRecording();
                bVL.read(this.buffer, 0, this.buffer.length);
            } else {
                bVM.start();
            }
            this.bVO = State.RECORDING;
            return;
        }
        BdLog.e(MyAudioRecorder.class.getName() + "start() called on illegal state");
        this.bVO = State.ERROR;
    }

    public void stop() {
        BdLog.e(MyAudioRecorder.class.getName() + "audioRecorder.stop()");
        bVL.stop();
        try {
            this.bVv.seek(4L);
            this.bVv.writeInt(Integer.reverseBytes(this.payloadSize + 36));
            this.bVv.seek(40L);
            this.bVv.writeInt(Integer.reverseBytes(this.payloadSize));
            this.bVv.close();
            BdLog.e(MyAudioRecorder.class.getName() + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
            this.bVO = State.ERROR;
        }
        this.bVO = State.STOPPED;
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
        this.bVO = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean afw() {
        return this.bVO == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aft() {
        if (bVL != null) {
            try {
                start();
                while (afw()) {
                    bVL.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.bVv.write(this.buffer);
                        this.payloadSize += this.buffer.length;
                        if (this.bVR == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short b = b(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (b > this.bVN) {
                                    this.bVN = b;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.bVN) {
                                    this.bVN = this.buffer[i2];
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
