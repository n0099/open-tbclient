package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import android.media.MediaRecorder;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class MyAudioRecorder implements i {
    private short afA;
    private int afB;
    private short afC;
    private int afD;
    private int afE;
    private int afF;
    private int afG;
    private int afa;
    private RandomAccessFile afd;
    private Thread afu;
    private boolean afv;
    private int afy;
    private State afz;
    private byte[] buffer;
    private String filePath;
    private static final int[] aft = {44100, 22050, 11025, 8000};
    private static Object mLock = new Object();
    private static AudioRecord afw = null;
    private static MediaRecorder afx = null;

    /* loaded from: classes.dex */
    public enum State {
        INITIALIZING,
        READY,
        RECORDING,
        ERROR,
        STOPPED;

        /* JADX DEBUG: Replace access to removed values field (afI) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static State[] valuesCustom() {
            State[] valuesCustom = values();
            int length = valuesCustom.length;
            State[] stateArr = new State[length];
            System.arraycopy(valuesCustom, 0, stateArr, 0, length);
            return stateArr;
        }
    }

    public static MyAudioRecorder c(Boolean bool) {
        MyAudioRecorder myAudioRecorder;
        synchronized (mLock) {
            afw = null;
            afx = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, aft[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.we() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, aft[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State we() {
        return this.afz;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.afy = 0;
        this.filePath = null;
        try {
            this.afv = z;
            if (this.afv) {
                if (i4 == 2) {
                    this.afC = (short) 16;
                } else {
                    this.afC = (short) 8;
                }
                if (i3 == 2) {
                    this.afA = (short) 1;
                } else {
                    this.afA = (short) 2;
                }
                this.afD = i;
                this.afB = i2;
                this.afE = i4;
                this.afF = (i2 * SocialAPIErrorCodes.ERROR_INVALID_AUTHORIZED_CODE) / 1000;
                this.afa = (((this.afF * 2) * this.afC) * this.afA) / 8;
                if (this.afa < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.afa = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.afF = this.afa / (((this.afC * 2) * this.afA) / 8);
                    BdLog.w(String.valueOf(MyAudioRecorder.class.getName()) + "Increasing buffer size to " + Integer.toString(this.afa));
                }
                afw = new AudioRecord(i, i2, i3, i4, this.afa);
                if (afw.getRecordingState() == 3) {
                    afw.stop();
                }
                if (afw.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                afx = new MediaRecorder();
                afx.setAudioSource(1);
                afx.setOutputFormat(1);
                afx.setAudioEncoder(1);
            }
            this.afy = 0;
            this.filePath = null;
            this.afz = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "Unknown error occured while initializing recording");
            }
            this.afz = State.ERROR;
        }
    }

    public boolean ea(String str) {
        try {
            if (this.afz == State.INITIALIZING) {
                this.filePath = str;
                if (!this.afv) {
                    afx.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + e.getMessage());
            } else {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "Unknown error occured while setting output path");
            }
            this.afz = State.ERROR;
            return false;
        }
    }

    public boolean prepare() {
        try {
            if (this.afz == State.INITIALIZING) {
                if (this.afv) {
                    if ((this.filePath != null) & (afw.getState() == 1)) {
                        if (this.afd != null) {
                            this.afd.close();
                            this.afd = null;
                        }
                        this.afd = new RandomAccessFile(this.filePath, "rw");
                        this.afd.setLength(0L);
                        this.afd.writeBytes("RIFF");
                        this.afd.writeInt(0);
                        this.afd.writeBytes("WAVE");
                        this.afd.writeBytes("fmt ");
                        this.afd.writeInt(Integer.reverseBytes(16));
                        this.afd.writeShort(Short.reverseBytes((short) 1));
                        this.afd.writeShort(Short.reverseBytes(this.afA));
                        this.afd.writeInt(Integer.reverseBytes(this.afB));
                        this.afd.writeInt(Integer.reverseBytes(((this.afB * this.afC) * this.afA) / 8));
                        this.afd.writeShort(Short.reverseBytes((short) ((this.afA * this.afC) / 8)));
                        this.afd.writeShort(Short.reverseBytes(this.afC));
                        this.afd.writeBytes("data");
                        this.afd.writeInt(0);
                        this.buffer = new byte[((this.afF * this.afC) / 8) * this.afA];
                        this.afz = State.READY;
                    } else {
                        BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "prepare() method called on uninitialized recorder");
                        this.afz = State.ERROR;
                        return false;
                    }
                } else {
                    afx.prepare();
                    this.afz = State.READY;
                }
                return true;
            }
            BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "prepare() method called on illegal state");
            release();
            this.afz = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + e.getMessage());
            } else {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "Unknown error occured in prepare()");
            }
            this.afz = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.afz == State.RECORDING) {
            stop();
        } else {
            if ((this.afz == State.READY) & this.afv) {
                try {
                    this.afd.close();
                } catch (IOException e) {
                    BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.afv) {
            if (afw != null) {
                afw.release();
            }
        } else if (afx != null) {
            afx.release();
        }
    }

    public void start() {
        if (this.afz == State.READY) {
            if (this.afv) {
                this.afG = 0;
                afw.startRecording();
                afw.read(this.buffer, 0, this.buffer.length);
            } else {
                afx.start();
            }
            this.afz = State.RECORDING;
            return;
        }
        BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "start() called on illegal state");
        this.afz = State.ERROR;
    }

    public void stop() {
        BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "audioRecorder.stop()");
        afw.stop();
        try {
            this.afd.seek(4L);
            this.afd.writeInt(Integer.reverseBytes(this.afG + 36));
            this.afd.seek(40L);
            this.afd.writeInt(Integer.reverseBytes(this.afG));
            this.afd.close();
            BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "I/O exception occured while closing output file");
            this.afz = State.ERROR;
        }
        this.afz = State.STOPPED;
    }

    private short a(byte b, byte b2) {
        return (short) ((b2 << 8) | b);
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean dY(String str) {
        if (ea(str)) {
            return prepare();
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean vZ() {
        synchronized (mLock) {
            if (this.afu == null || !this.afu.isAlive()) {
                this.afu = new Thread(new g(this));
                this.afu.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public void wa() {
        this.afz = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean wb() {
        return this.afz == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vY() {
        if (afw != null) {
            try {
                start();
                while (wb()) {
                    afw.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.afd.write(this.buffer);
                        this.afG += this.buffer.length;
                        if (this.afC == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short a = a(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (a > this.afy) {
                                    this.afy = a;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.afy) {
                                    this.afy = this.buffer[i2];
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
