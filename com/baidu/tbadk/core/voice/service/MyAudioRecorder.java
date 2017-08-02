package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import android.media.MediaRecorder;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class MyAudioRecorder implements d {
    private Thread apA;
    private boolean apB;
    private int apE;
    private State apF;
    private short apG;
    private int apH;
    private short apI;
    private int apJ;
    private int apK;
    private int apL;
    private int apM;
    private int aph;
    private RandomAccessFile apj;
    private byte[] buffer;
    private String filePath;
    private static final int[] apz = {44100, 22050, 11025, 8000};
    private static Object mLock = new Object();
    private static AudioRecord apC = null;
    private static MediaRecorder apD = null;

    /* loaded from: classes.dex */
    public enum State {
        INITIALIZING,
        READY,
        RECORDING,
        ERROR,
        STOPPED
    }

    public static MyAudioRecorder c(Boolean bool) {
        MyAudioRecorder myAudioRecorder;
        synchronized (mLock) {
            apC = null;
            apD = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, apz[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.xy() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, apz[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State xy() {
        return this.apF;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.apE = 0;
        this.filePath = null;
        try {
            this.apB = z;
            if (this.apB) {
                if (i4 == 2) {
                    this.apI = (short) 16;
                } else {
                    this.apI = (short) 8;
                }
                if (i3 == 2) {
                    this.apG = (short) 1;
                } else {
                    this.apG = (short) 2;
                }
                this.apJ = i;
                this.apH = i2;
                this.apK = i4;
                this.apL = (i2 * 120) / 1000;
                this.aph = (((this.apL * 2) * this.apI) * this.apG) / 8;
                if (this.aph < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.aph = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.apL = this.aph / (((this.apI * 2) * this.apG) / 8);
                    BdLog.w(MyAudioRecorder.class.getName() + "Increasing buffer size to " + Integer.toString(this.aph));
                }
                apC = new AudioRecord(i, i2, i3, i4, this.aph);
                if (apC.getRecordingState() == 3) {
                    apC.stop();
                }
                if (apC.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                apD = new MediaRecorder();
                apD.setAudioSource(1);
                apD.setOutputFormat(1);
                apD.setAudioEncoder(1);
            }
            this.apE = 0;
            this.filePath = null;
            this.apF = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while initializing recording");
            }
            this.apF = State.ERROR;
        }
    }

    public boolean ew(String str) {
        try {
            if (this.apF == State.INITIALIZING) {
                this.filePath = str;
                if (!this.apB) {
                    apD.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while setting output path");
            }
            this.apF = State.ERROR;
            return false;
        }
    }

    public boolean prepare() {
        try {
            if (this.apF == State.INITIALIZING) {
                if (this.apB) {
                    if ((this.filePath != null) & (apC.getState() == 1)) {
                        if (this.apj != null) {
                            this.apj.close();
                            this.apj = null;
                        }
                        this.apj = new RandomAccessFile(this.filePath, "rw");
                        this.apj.setLength(0L);
                        this.apj.writeBytes("RIFF");
                        this.apj.writeInt(0);
                        this.apj.writeBytes("WAVE");
                        this.apj.writeBytes("fmt ");
                        this.apj.writeInt(Integer.reverseBytes(16));
                        this.apj.writeShort(Short.reverseBytes((short) 1));
                        this.apj.writeShort(Short.reverseBytes(this.apG));
                        this.apj.writeInt(Integer.reverseBytes(this.apH));
                        this.apj.writeInt(Integer.reverseBytes(((this.apH * this.apI) * this.apG) / 8));
                        this.apj.writeShort(Short.reverseBytes((short) ((this.apG * this.apI) / 8)));
                        this.apj.writeShort(Short.reverseBytes(this.apI));
                        this.apj.writeBytes("data");
                        this.apj.writeInt(0);
                        this.buffer = new byte[((this.apL * this.apI) / 8) * this.apG];
                        this.apF = State.READY;
                    } else {
                        BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on uninitialized recorder");
                        this.apF = State.ERROR;
                        return false;
                    }
                } else {
                    apD.prepare();
                    this.apF = State.READY;
                }
                return true;
            }
            BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on illegal state");
            release();
            this.apF = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured in prepare()");
            }
            this.apF = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.apF == State.RECORDING) {
            stop();
        } else {
            if ((this.apF == State.READY) & this.apB) {
                try {
                    this.apj.close();
                } catch (IOException e) {
                    BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.apB) {
            if (apC != null) {
                apC.release();
            }
        } else if (apD != null) {
            apD.release();
        }
    }

    public void start() {
        if (this.apF == State.READY) {
            if (this.apB) {
                this.apM = 0;
                apC.startRecording();
                apC.read(this.buffer, 0, this.buffer.length);
            } else {
                apD.start();
            }
            this.apF = State.RECORDING;
            return;
        }
        BdLog.e(MyAudioRecorder.class.getName() + "start() called on illegal state");
        this.apF = State.ERROR;
    }

    public void stop() {
        BdLog.e(MyAudioRecorder.class.getName() + "audioRecorder.stop()");
        apC.stop();
        try {
            this.apj.seek(4L);
            this.apj.writeInt(Integer.reverseBytes(this.apM + 36));
            this.apj.seek(40L);
            this.apj.writeInt(Integer.reverseBytes(this.apM));
            this.apj.close();
            BdLog.e(MyAudioRecorder.class.getName() + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
            this.apF = State.ERROR;
        }
        this.apF = State.STOPPED;
    }

    private short b(byte b, byte b2) {
        return (short) ((b2 << 8) | b);
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean eu(String str) {
        if (ew(str)) {
            return prepare();
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean xu() {
        synchronized (mLock) {
            if (this.apA == null || !this.apA.isAlive()) {
                this.apA = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.MyAudioRecorder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MyAudioRecorder.this.xt();
                    }
                });
                this.apA.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void xv() {
        this.apF = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean isRecording() {
        return this.apF == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xt() {
        if (apC != null) {
            try {
                start();
                while (isRecording()) {
                    apC.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.apj.write(this.buffer);
                        this.apM += this.buffer.length;
                        if (this.apI == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short b = b(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (b > this.apE) {
                                    this.apE = b;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.apE) {
                                    this.apE = this.buffer[i2];
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
