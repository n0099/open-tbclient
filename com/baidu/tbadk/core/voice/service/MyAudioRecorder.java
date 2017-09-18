package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import android.media.MediaRecorder;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class MyAudioRecorder implements d {
    private int aqB;
    private State aqC;
    private short aqD;
    private int aqE;
    private short aqF;
    private int aqG;
    private int aqH;
    private int aqI;
    private int aqJ;
    private int aqg;
    private RandomAccessFile aqh;
    private Thread aqx;
    private boolean aqy;
    private byte[] buffer;
    private String filePath;
    private static final int[] aqw = {44100, 22050, 11025, 8000};
    private static Object mLock = new Object();
    private static AudioRecord aqz = null;
    private static MediaRecorder aqA = null;

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
            aqz = null;
            aqA = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, aqw[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.xI() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, aqw[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State xI() {
        return this.aqC;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.aqB = 0;
        this.filePath = null;
        try {
            this.aqy = z;
            if (this.aqy) {
                if (i4 == 2) {
                    this.aqF = (short) 16;
                } else {
                    this.aqF = (short) 8;
                }
                if (i3 == 2) {
                    this.aqD = (short) 1;
                } else {
                    this.aqD = (short) 2;
                }
                this.aqG = i;
                this.aqE = i2;
                this.aqH = i4;
                this.aqI = (i2 * 120) / 1000;
                this.aqg = (((this.aqI * 2) * this.aqF) * this.aqD) / 8;
                if (this.aqg < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.aqg = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.aqI = this.aqg / (((this.aqF * 2) * this.aqD) / 8);
                    BdLog.w(MyAudioRecorder.class.getName() + "Increasing buffer size to " + Integer.toString(this.aqg));
                }
                aqz = new AudioRecord(i, i2, i3, i4, this.aqg);
                if (aqz.getRecordingState() == 3) {
                    aqz.stop();
                }
                if (aqz.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                aqA = new MediaRecorder();
                aqA.setAudioSource(1);
                aqA.setOutputFormat(1);
                aqA.setAudioEncoder(1);
            }
            this.aqB = 0;
            this.filePath = null;
            this.aqC = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while initializing recording");
            }
            this.aqC = State.ERROR;
        }
    }

    public boolean ez(String str) {
        try {
            if (this.aqC == State.INITIALIZING) {
                this.filePath = str;
                if (!this.aqy) {
                    aqA.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while setting output path");
            }
            this.aqC = State.ERROR;
            return false;
        }
    }

    public boolean prepare() {
        try {
            if (this.aqC == State.INITIALIZING) {
                if (this.aqy) {
                    if ((this.filePath != null) & (aqz.getState() == 1)) {
                        if (this.aqh != null) {
                            this.aqh.close();
                            this.aqh = null;
                        }
                        this.aqh = new RandomAccessFile(this.filePath, "rw");
                        this.aqh.setLength(0L);
                        this.aqh.writeBytes("RIFF");
                        this.aqh.writeInt(0);
                        this.aqh.writeBytes("WAVE");
                        this.aqh.writeBytes("fmt ");
                        this.aqh.writeInt(Integer.reverseBytes(16));
                        this.aqh.writeShort(Short.reverseBytes((short) 1));
                        this.aqh.writeShort(Short.reverseBytes(this.aqD));
                        this.aqh.writeInt(Integer.reverseBytes(this.aqE));
                        this.aqh.writeInt(Integer.reverseBytes(((this.aqE * this.aqF) * this.aqD) / 8));
                        this.aqh.writeShort(Short.reverseBytes((short) ((this.aqD * this.aqF) / 8)));
                        this.aqh.writeShort(Short.reverseBytes(this.aqF));
                        this.aqh.writeBytes("data");
                        this.aqh.writeInt(0);
                        this.buffer = new byte[((this.aqI * this.aqF) / 8) * this.aqD];
                        this.aqC = State.READY;
                    } else {
                        BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on uninitialized recorder");
                        this.aqC = State.ERROR;
                        return false;
                    }
                } else {
                    aqA.prepare();
                    this.aqC = State.READY;
                }
                return true;
            }
            BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on illegal state");
            release();
            this.aqC = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured in prepare()");
            }
            this.aqC = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.aqC == State.RECORDING) {
            stop();
        } else {
            if ((this.aqC == State.READY) & this.aqy) {
                try {
                    this.aqh.close();
                } catch (IOException e) {
                    BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.aqy) {
            if (aqz != null) {
                aqz.release();
            }
        } else if (aqA != null) {
            aqA.release();
        }
    }

    public void start() {
        if (this.aqC == State.READY) {
            if (this.aqy) {
                this.aqJ = 0;
                aqz.startRecording();
                aqz.read(this.buffer, 0, this.buffer.length);
            } else {
                aqA.start();
            }
            this.aqC = State.RECORDING;
            return;
        }
        BdLog.e(MyAudioRecorder.class.getName() + "start() called on illegal state");
        this.aqC = State.ERROR;
    }

    public void stop() {
        BdLog.e(MyAudioRecorder.class.getName() + "audioRecorder.stop()");
        aqz.stop();
        try {
            this.aqh.seek(4L);
            this.aqh.writeInt(Integer.reverseBytes(this.aqJ + 36));
            this.aqh.seek(40L);
            this.aqh.writeInt(Integer.reverseBytes(this.aqJ));
            this.aqh.close();
            BdLog.e(MyAudioRecorder.class.getName() + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
            this.aqC = State.ERROR;
        }
        this.aqC = State.STOPPED;
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
            if (this.aqx == null || !this.aqx.isAlive()) {
                this.aqx = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.MyAudioRecorder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MyAudioRecorder.this.xD();
                    }
                });
                this.aqx.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void xF() {
        this.aqC = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean isRecording() {
        return this.aqC == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xD() {
        if (aqz != null) {
            try {
                start();
                while (isRecording()) {
                    aqz.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.aqh.write(this.buffer);
                        this.aqJ += this.buffer.length;
                        if (this.aqF == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short b = b(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (b > this.aqB) {
                                    this.aqB = b;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.aqB) {
                                    this.aqB = this.buffer[i2];
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
