package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import android.media.MediaRecorder;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class MyAudioRecorder implements d {
    private Thread aqA;
    private boolean aqB;
    private int aqE;
    private State aqF;
    private short aqG;
    private int aqH;
    private short aqI;
    private int aqJ;
    private int aqK;
    private int aqL;
    private int aqM;
    private int aqi;
    private RandomAccessFile aqk;
    private byte[] buffer;
    private String filePath;
    private static final int[] aqz = {44100, 22050, 11025, 8000};
    private static Object mLock = new Object();
    private static AudioRecord aqC = null;
    private static MediaRecorder aqD = null;

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
            aqC = null;
            aqD = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, aqz[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.xI() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, aqz[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State xI() {
        return this.aqF;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.aqE = 0;
        this.filePath = null;
        try {
            this.aqB = z;
            if (this.aqB) {
                if (i4 == 2) {
                    this.aqI = (short) 16;
                } else {
                    this.aqI = (short) 8;
                }
                if (i3 == 2) {
                    this.aqG = (short) 1;
                } else {
                    this.aqG = (short) 2;
                }
                this.aqJ = i;
                this.aqH = i2;
                this.aqK = i4;
                this.aqL = (i2 * 120) / 1000;
                this.aqi = (((this.aqL * 2) * this.aqI) * this.aqG) / 8;
                if (this.aqi < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.aqi = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.aqL = this.aqi / (((this.aqI * 2) * this.aqG) / 8);
                    BdLog.w(MyAudioRecorder.class.getName() + "Increasing buffer size to " + Integer.toString(this.aqi));
                }
                aqC = new AudioRecord(i, i2, i3, i4, this.aqi);
                if (aqC.getRecordingState() == 3) {
                    aqC.stop();
                }
                if (aqC.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                aqD = new MediaRecorder();
                aqD.setAudioSource(1);
                aqD.setOutputFormat(1);
                aqD.setAudioEncoder(1);
            }
            this.aqE = 0;
            this.filePath = null;
            this.aqF = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while initializing recording");
            }
            this.aqF = State.ERROR;
        }
    }

    public boolean ez(String str) {
        try {
            if (this.aqF == State.INITIALIZING) {
                this.filePath = str;
                if (!this.aqB) {
                    aqD.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while setting output path");
            }
            this.aqF = State.ERROR;
            return false;
        }
    }

    public boolean prepare() {
        try {
            if (this.aqF == State.INITIALIZING) {
                if (this.aqB) {
                    if ((this.filePath != null) & (aqC.getState() == 1)) {
                        if (this.aqk != null) {
                            this.aqk.close();
                            this.aqk = null;
                        }
                        this.aqk = new RandomAccessFile(this.filePath, "rw");
                        this.aqk.setLength(0L);
                        this.aqk.writeBytes("RIFF");
                        this.aqk.writeInt(0);
                        this.aqk.writeBytes("WAVE");
                        this.aqk.writeBytes("fmt ");
                        this.aqk.writeInt(Integer.reverseBytes(16));
                        this.aqk.writeShort(Short.reverseBytes((short) 1));
                        this.aqk.writeShort(Short.reverseBytes(this.aqG));
                        this.aqk.writeInt(Integer.reverseBytes(this.aqH));
                        this.aqk.writeInt(Integer.reverseBytes(((this.aqH * this.aqI) * this.aqG) / 8));
                        this.aqk.writeShort(Short.reverseBytes((short) ((this.aqG * this.aqI) / 8)));
                        this.aqk.writeShort(Short.reverseBytes(this.aqI));
                        this.aqk.writeBytes("data");
                        this.aqk.writeInt(0);
                        this.buffer = new byte[((this.aqL * this.aqI) / 8) * this.aqG];
                        this.aqF = State.READY;
                    } else {
                        BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on uninitialized recorder");
                        this.aqF = State.ERROR;
                        return false;
                    }
                } else {
                    aqD.prepare();
                    this.aqF = State.READY;
                }
                return true;
            }
            BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on illegal state");
            release();
            this.aqF = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured in prepare()");
            }
            this.aqF = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.aqF == State.RECORDING) {
            stop();
        } else {
            if ((this.aqF == State.READY) & this.aqB) {
                try {
                    this.aqk.close();
                } catch (IOException e) {
                    BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.aqB) {
            if (aqC != null) {
                aqC.release();
            }
        } else if (aqD != null) {
            aqD.release();
        }
    }

    public void start() {
        if (this.aqF == State.READY) {
            if (this.aqB) {
                this.aqM = 0;
                aqC.startRecording();
                aqC.read(this.buffer, 0, this.buffer.length);
            } else {
                aqD.start();
            }
            this.aqF = State.RECORDING;
            return;
        }
        BdLog.e(MyAudioRecorder.class.getName() + "start() called on illegal state");
        this.aqF = State.ERROR;
    }

    public void stop() {
        BdLog.e(MyAudioRecorder.class.getName() + "audioRecorder.stop()");
        aqC.stop();
        try {
            this.aqk.seek(4L);
            this.aqk.writeInt(Integer.reverseBytes(this.aqM + 36));
            this.aqk.seek(40L);
            this.aqk.writeInt(Integer.reverseBytes(this.aqM));
            this.aqk.close();
            BdLog.e(MyAudioRecorder.class.getName() + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
            this.aqF = State.ERROR;
        }
        this.aqF = State.STOPPED;
    }

    private short b(byte b, byte b2) {
        return (short) ((b2 << 8) | b);
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean ex(String str) {
        if (ez(str)) {
            return prepare();
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean xE() {
        synchronized (mLock) {
            if (this.aqA == null || !this.aqA.isAlive()) {
                this.aqA = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.MyAudioRecorder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MyAudioRecorder.this.xD();
                    }
                });
                this.aqA.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void xF() {
        this.aqF = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean isRecording() {
        return this.aqF == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xD() {
        if (aqC != null) {
            try {
                start();
                while (isRecording()) {
                    aqC.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.aqk.write(this.buffer);
                        this.aqM += this.buffer.length;
                        if (this.aqI == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short b = b(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (b > this.aqE) {
                                    this.aqE = b;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.aqE) {
                                    this.aqE = this.buffer[i2];
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
