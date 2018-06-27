package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import android.media.MediaRecorder;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class MyAudioRecorder implements d {
    private Thread aAM;
    private boolean aAN;
    private int aAQ;
    private State aAR;
    private short aAS;
    private int aAT;
    private short aAU;
    private int aAV;
    private int aAW;
    private int aAX;
    private RandomAccessFile aAx;
    private byte[] buffer;
    private int bufferSize;
    private String filePath;
    private int payloadSize;
    private static final int[] aAL = {44100, 22050, 11025, 8000};
    private static Object mLock = new Object();
    private static AudioRecord aAO = null;
    private static MediaRecorder aAP = null;

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
            aAO = null;
            aAP = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, aAL[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.Bz() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, aAL[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State Bz() {
        return this.aAR;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.aAQ = 0;
        this.filePath = null;
        try {
            this.aAN = z;
            if (this.aAN) {
                if (i4 == 2) {
                    this.aAU = (short) 16;
                } else {
                    this.aAU = (short) 8;
                }
                if (i3 == 2) {
                    this.aAS = (short) 1;
                } else {
                    this.aAS = (short) 2;
                }
                this.aAV = i;
                this.aAT = i2;
                this.aAW = i4;
                this.aAX = (i2 * 120) / 1000;
                this.bufferSize = (((this.aAX * 2) * this.aAU) * this.aAS) / 8;
                if (this.bufferSize < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.aAX = this.bufferSize / (((this.aAU * 2) * this.aAS) / 8);
                    BdLog.w(MyAudioRecorder.class.getName() + "Increasing buffer size to " + Integer.toString(this.bufferSize));
                }
                aAO = new AudioRecord(i, i2, i3, i4, this.bufferSize);
                if (aAO.getRecordingState() == 3) {
                    aAO.stop();
                }
                if (aAO.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                aAP = new MediaRecorder();
                aAP.setAudioSource(1);
                aAP.setOutputFormat(1);
                aAP.setAudioEncoder(1);
            }
            this.aAQ = 0;
            this.filePath = null;
            this.aAR = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while initializing recording");
            }
            this.aAR = State.ERROR;
        }
    }

    public boolean fy(String str) {
        try {
            if (this.aAR == State.INITIALIZING) {
                this.filePath = str;
                if (!this.aAN) {
                    aAP.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while setting output path");
            }
            this.aAR = State.ERROR;
            return false;
        }
    }

    public boolean prepare() {
        try {
            if (this.aAR == State.INITIALIZING) {
                if (this.aAN) {
                    if ((this.filePath != null) & (aAO.getState() == 1)) {
                        if (this.aAx != null) {
                            this.aAx.close();
                            this.aAx = null;
                        }
                        this.aAx = new RandomAccessFile(this.filePath, "rw");
                        this.aAx.setLength(0L);
                        this.aAx.writeBytes("RIFF");
                        this.aAx.writeInt(0);
                        this.aAx.writeBytes("WAVE");
                        this.aAx.writeBytes("fmt ");
                        this.aAx.writeInt(Integer.reverseBytes(16));
                        this.aAx.writeShort(Short.reverseBytes((short) 1));
                        this.aAx.writeShort(Short.reverseBytes(this.aAS));
                        this.aAx.writeInt(Integer.reverseBytes(this.aAT));
                        this.aAx.writeInt(Integer.reverseBytes(((this.aAT * this.aAU) * this.aAS) / 8));
                        this.aAx.writeShort(Short.reverseBytes((short) ((this.aAS * this.aAU) / 8)));
                        this.aAx.writeShort(Short.reverseBytes(this.aAU));
                        this.aAx.writeBytes("data");
                        this.aAx.writeInt(0);
                        this.buffer = new byte[((this.aAX * this.aAU) / 8) * this.aAS];
                        this.aAR = State.READY;
                    } else {
                        BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on uninitialized recorder");
                        this.aAR = State.ERROR;
                        return false;
                    }
                } else {
                    aAP.prepare();
                    this.aAR = State.READY;
                }
                return true;
            }
            BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on illegal state");
            release();
            this.aAR = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured in prepare()");
            }
            this.aAR = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.aAR == State.RECORDING) {
            stop();
        } else {
            if ((this.aAR == State.READY) & this.aAN) {
                try {
                    this.aAx.close();
                } catch (IOException e) {
                    BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.aAN) {
            if (aAO != null) {
                aAO.release();
            }
        } else if (aAP != null) {
            aAP.release();
        }
    }

    public void start() {
        if (this.aAR == State.READY) {
            if (this.aAN) {
                this.payloadSize = 0;
                aAO.startRecording();
                aAO.read(this.buffer, 0, this.buffer.length);
            } else {
                aAP.start();
            }
            this.aAR = State.RECORDING;
            return;
        }
        BdLog.e(MyAudioRecorder.class.getName() + "start() called on illegal state");
        this.aAR = State.ERROR;
    }

    public void stop() {
        BdLog.e(MyAudioRecorder.class.getName() + "audioRecorder.stop()");
        aAO.stop();
        try {
            this.aAx.seek(4L);
            this.aAx.writeInt(Integer.reverseBytes(this.payloadSize + 36));
            this.aAx.seek(40L);
            this.aAx.writeInt(Integer.reverseBytes(this.payloadSize));
            this.aAx.close();
            BdLog.e(MyAudioRecorder.class.getName() + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
            this.aAR = State.ERROR;
        }
        this.aAR = State.STOPPED;
    }

    private short b(byte b, byte b2) {
        return (short) ((b2 << 8) | b);
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean fw(String str) {
        if (fy(str)) {
            return prepare();
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean Bw() {
        synchronized (mLock) {
            if (this.aAM == null || !this.aAM.isAlive()) {
                this.aAM = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.MyAudioRecorder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MyAudioRecorder.this.Bv();
                    }
                });
                this.aAM.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void Bx() {
        this.aAR = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean isRecording() {
        return this.aAR == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bv() {
        if (aAO != null) {
            try {
                start();
                while (isRecording()) {
                    aAO.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.aAx.write(this.buffer);
                        this.payloadSize += this.buffer.length;
                        if (this.aAU == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short b = b(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (b > this.aAQ) {
                                    this.aAQ = b;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.aAQ) {
                                    this.aAQ = this.buffer[i2];
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
