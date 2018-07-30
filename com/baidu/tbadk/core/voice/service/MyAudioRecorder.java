package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import android.media.MediaRecorder;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class MyAudioRecorder implements d {
    private Thread aAG;
    private boolean aAH;
    private int aAK;
    private State aAL;
    private short aAM;
    private int aAN;
    private short aAO;
    private int aAP;
    private int aAQ;
    private int aAR;
    private int aAq;
    private RandomAccessFile aAr;
    private byte[] buffer;
    private String filePath;
    private int payloadSize;
    private static final int[] aAF = {44100, 22050, 11025, 8000};
    private static Object mLock = new Object();
    private static AudioRecord aAI = null;
    private static MediaRecorder aAJ = null;

    /* loaded from: classes.dex */
    public enum State {
        INITIALIZING,
        READY,
        RECORDING,
        ERROR,
        STOPPED
    }

    public static MyAudioRecorder b(Boolean bool) {
        MyAudioRecorder myAudioRecorder;
        synchronized (mLock) {
            aAI = null;
            aAJ = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, aAF[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.Br() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, aAF[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State Br() {
        return this.aAL;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.aAK = 0;
        this.filePath = null;
        try {
            this.aAH = z;
            if (this.aAH) {
                if (i4 == 2) {
                    this.aAO = (short) 16;
                } else {
                    this.aAO = (short) 8;
                }
                if (i3 == 2) {
                    this.aAM = (short) 1;
                } else {
                    this.aAM = (short) 2;
                }
                this.aAP = i;
                this.aAN = i2;
                this.aAQ = i4;
                this.aAR = (i2 * 120) / 1000;
                this.aAq = (((this.aAR * 2) * this.aAO) * this.aAM) / 8;
                if (this.aAq < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.aAq = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.aAR = this.aAq / (((this.aAO * 2) * this.aAM) / 8);
                    BdLog.w(MyAudioRecorder.class.getName() + "Increasing buffer size to " + Integer.toString(this.aAq));
                }
                aAI = new AudioRecord(i, i2, i3, i4, this.aAq);
                if (aAI.getRecordingState() == 3) {
                    aAI.stop();
                }
                if (aAI.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                aAJ = new MediaRecorder();
                aAJ.setAudioSource(1);
                aAJ.setOutputFormat(1);
                aAJ.setAudioEncoder(1);
            }
            this.aAK = 0;
            this.filePath = null;
            this.aAL = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while initializing recording");
            }
            this.aAL = State.ERROR;
        }
    }

    public boolean fw(String str) {
        try {
            if (this.aAL == State.INITIALIZING) {
                this.filePath = str;
                if (!this.aAH) {
                    aAJ.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while setting output path");
            }
            this.aAL = State.ERROR;
            return false;
        }
    }

    public boolean prepare() {
        try {
            if (this.aAL == State.INITIALIZING) {
                if (this.aAH) {
                    if ((this.filePath != null) & (aAI.getState() == 1)) {
                        if (this.aAr != null) {
                            this.aAr.close();
                            this.aAr = null;
                        }
                        this.aAr = new RandomAccessFile(this.filePath, "rw");
                        this.aAr.setLength(0L);
                        this.aAr.writeBytes("RIFF");
                        this.aAr.writeInt(0);
                        this.aAr.writeBytes("WAVE");
                        this.aAr.writeBytes("fmt ");
                        this.aAr.writeInt(Integer.reverseBytes(16));
                        this.aAr.writeShort(Short.reverseBytes((short) 1));
                        this.aAr.writeShort(Short.reverseBytes(this.aAM));
                        this.aAr.writeInt(Integer.reverseBytes(this.aAN));
                        this.aAr.writeInt(Integer.reverseBytes(((this.aAN * this.aAO) * this.aAM) / 8));
                        this.aAr.writeShort(Short.reverseBytes((short) ((this.aAM * this.aAO) / 8)));
                        this.aAr.writeShort(Short.reverseBytes(this.aAO));
                        this.aAr.writeBytes("data");
                        this.aAr.writeInt(0);
                        this.buffer = new byte[((this.aAR * this.aAO) / 8) * this.aAM];
                        this.aAL = State.READY;
                    } else {
                        BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on uninitialized recorder");
                        this.aAL = State.ERROR;
                        return false;
                    }
                } else {
                    aAJ.prepare();
                    this.aAL = State.READY;
                }
                return true;
            }
            BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on illegal state");
            release();
            this.aAL = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured in prepare()");
            }
            this.aAL = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.aAL == State.RECORDING) {
            stop();
        } else {
            if ((this.aAL == State.READY) & this.aAH) {
                try {
                    this.aAr.close();
                } catch (IOException e) {
                    BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.aAH) {
            if (aAI != null) {
                aAI.release();
            }
        } else if (aAJ != null) {
            aAJ.release();
        }
    }

    public void start() {
        if (this.aAL == State.READY) {
            if (this.aAH) {
                this.payloadSize = 0;
                aAI.startRecording();
                aAI.read(this.buffer, 0, this.buffer.length);
            } else {
                aAJ.start();
            }
            this.aAL = State.RECORDING;
            return;
        }
        BdLog.e(MyAudioRecorder.class.getName() + "start() called on illegal state");
        this.aAL = State.ERROR;
    }

    public void stop() {
        BdLog.e(MyAudioRecorder.class.getName() + "audioRecorder.stop()");
        aAI.stop();
        try {
            this.aAr.seek(4L);
            this.aAr.writeInt(Integer.reverseBytes(this.payloadSize + 36));
            this.aAr.seek(40L);
            this.aAr.writeInt(Integer.reverseBytes(this.payloadSize));
            this.aAr.close();
            BdLog.e(MyAudioRecorder.class.getName() + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
            this.aAL = State.ERROR;
        }
        this.aAL = State.STOPPED;
    }

    private short b(byte b, byte b2) {
        return (short) ((b2 << 8) | b);
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean fu(String str) {
        if (fw(str)) {
            return prepare();
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean Bn() {
        synchronized (mLock) {
            if (this.aAG == null || !this.aAG.isAlive()) {
                this.aAG = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.MyAudioRecorder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MyAudioRecorder.this.Bm();
                    }
                });
                this.aAG.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void Bo() {
        this.aAL = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean isRecording() {
        return this.aAL == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bm() {
        if (aAI != null) {
            try {
                start();
                while (isRecording()) {
                    aAI.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.aAr.write(this.buffer);
                        this.payloadSize += this.buffer.length;
                        if (this.aAO == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short b = b(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (b > this.aAK) {
                                    this.aAK = b;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.aAK) {
                                    this.aAK = this.buffer[i2];
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
