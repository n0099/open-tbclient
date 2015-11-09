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
    private int afA;
    private State afB;
    private short afC;
    private int afD;
    private short afE;
    private int afF;
    private int afG;
    private int afH;
    private int afI;
    private int afd;
    private RandomAccessFile afg;
    private Thread afw;
    private boolean afx;
    private byte[] buffer;
    private String filePath;
    private static final int[] afv = {44100, 22050, 11025, 8000};
    private static Object mLock = new Object();
    private static AudioRecord afy = null;
    private static MediaRecorder afz = null;

    /* loaded from: classes.dex */
    public enum State {
        INITIALIZING,
        READY,
        RECORDING,
        ERROR,
        STOPPED;

        /* JADX DEBUG: Replace access to removed values field (afK) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static State[] valuesCustom() {
            State[] valuesCustom = values();
            int length = valuesCustom.length;
            State[] stateArr = new State[length];
            System.arraycopy(valuesCustom, 0, stateArr, 0, length);
            return stateArr;
        }
    }

    public static MyAudioRecorder d(Boolean bool) {
        MyAudioRecorder myAudioRecorder;
        synchronized (mLock) {
            afy = null;
            afz = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, afv[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.vR() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, afv[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State vR() {
        return this.afB;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.afA = 0;
        this.filePath = null;
        try {
            this.afx = z;
            if (this.afx) {
                if (i4 == 2) {
                    this.afE = (short) 16;
                } else {
                    this.afE = (short) 8;
                }
                if (i3 == 2) {
                    this.afC = (short) 1;
                } else {
                    this.afC = (short) 2;
                }
                this.afF = i;
                this.afD = i2;
                this.afG = i4;
                this.afH = (i2 * SocialAPIErrorCodes.ERROR_INVALID_AUTHORIZED_CODE) / 1000;
                this.afd = (((this.afH * 2) * this.afE) * this.afC) / 8;
                if (this.afd < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.afd = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.afH = this.afd / (((this.afE * 2) * this.afC) / 8);
                    BdLog.w(String.valueOf(MyAudioRecorder.class.getName()) + "Increasing buffer size to " + Integer.toString(this.afd));
                }
                afy = new AudioRecord(i, i2, i3, i4, this.afd);
                if (afy.getRecordingState() == 3) {
                    afy.stop();
                }
                if (afy.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                afz = new MediaRecorder();
                afz.setAudioSource(1);
                afz.setOutputFormat(1);
                afz.setAudioEncoder(1);
            }
            this.afA = 0;
            this.filePath = null;
            this.afB = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "Unknown error occured while initializing recording");
            }
            this.afB = State.ERROR;
        }
    }

    public boolean dJ(String str) {
        try {
            if (this.afB == State.INITIALIZING) {
                this.filePath = str;
                if (!this.afx) {
                    afz.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + e.getMessage());
            } else {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "Unknown error occured while setting output path");
            }
            this.afB = State.ERROR;
            return false;
        }
    }

    public boolean vS() {
        try {
            if (this.afB == State.INITIALIZING) {
                if (this.afx) {
                    if ((this.filePath != null) & (afy.getState() == 1)) {
                        if (this.afg != null) {
                            this.afg.close();
                            this.afg = null;
                        }
                        this.afg = new RandomAccessFile(this.filePath, "rw");
                        this.afg.setLength(0L);
                        this.afg.writeBytes("RIFF");
                        this.afg.writeInt(0);
                        this.afg.writeBytes("WAVE");
                        this.afg.writeBytes("fmt ");
                        this.afg.writeInt(Integer.reverseBytes(16));
                        this.afg.writeShort(Short.reverseBytes((short) 1));
                        this.afg.writeShort(Short.reverseBytes(this.afC));
                        this.afg.writeInt(Integer.reverseBytes(this.afD));
                        this.afg.writeInt(Integer.reverseBytes(((this.afD * this.afE) * this.afC) / 8));
                        this.afg.writeShort(Short.reverseBytes((short) ((this.afC * this.afE) / 8)));
                        this.afg.writeShort(Short.reverseBytes(this.afE));
                        this.afg.writeBytes("data");
                        this.afg.writeInt(0);
                        this.buffer = new byte[((this.afH * this.afE) / 8) * this.afC];
                        this.afB = State.READY;
                    } else {
                        BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "prepare() method called on uninitialized recorder");
                        this.afB = State.ERROR;
                        return false;
                    }
                } else {
                    afz.prepare();
                    this.afB = State.READY;
                }
                return true;
            }
            BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "prepare() method called on illegal state");
            release();
            this.afB = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + e.getMessage());
            } else {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "Unknown error occured in prepare()");
            }
            this.afB = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.afB == State.RECORDING) {
            stop();
        } else {
            if ((this.afB == State.READY) & this.afx) {
                try {
                    this.afg.close();
                } catch (IOException e) {
                    BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.afx) {
            if (afy != null) {
                afy.release();
            }
        } else if (afz != null) {
            afz.release();
        }
    }

    public void start() {
        if (this.afB == State.READY) {
            if (this.afx) {
                this.afI = 0;
                afy.startRecording();
                afy.read(this.buffer, 0, this.buffer.length);
            } else {
                afz.start();
            }
            this.afB = State.RECORDING;
            return;
        }
        BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "start() called on illegal state");
        this.afB = State.ERROR;
    }

    public void stop() {
        BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "audioRecorder.stop()");
        afy.stop();
        try {
            this.afg.seek(4L);
            this.afg.writeInt(Integer.reverseBytes(this.afI + 36));
            this.afg.seek(40L);
            this.afg.writeInt(Integer.reverseBytes(this.afI));
            this.afg.close();
            BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "I/O exception occured while closing output file");
            this.afB = State.ERROR;
        }
        this.afB = State.STOPPED;
    }

    private short a(byte b, byte b2) {
        return (short) ((b2 << 8) | b);
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean dH(String str) {
        if (dJ(str)) {
            return vS();
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean vM() {
        synchronized (mLock) {
            if (this.afw == null || !this.afw.isAlive()) {
                this.afw = new Thread(new g(this));
                this.afw.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public void vN() {
        this.afB = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean vO() {
        return this.afB == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vL() {
        if (afy != null) {
            try {
                start();
                while (vO()) {
                    afy.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.afg.write(this.buffer);
                        this.afI += this.buffer.length;
                        if (this.afE == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short a = a(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (a > this.afA) {
                                    this.afA = a;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.afA) {
                                    this.afA = this.buffer[i2];
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
