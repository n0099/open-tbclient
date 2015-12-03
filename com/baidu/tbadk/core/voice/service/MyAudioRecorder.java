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
    private int agJ;
    private RandomAccessFile agM;
    private Thread ahc;
    private boolean ahd;
    private int ahg;
    private State ahh;
    private short ahi;
    private int ahj;
    private short ahk;
    private int ahl;
    private int ahm;
    private int ahn;
    private int aho;
    private byte[] buffer;
    private String filePath;
    private static final int[] ahb = {44100, 22050, 11025, 8000};
    private static Object mLock = new Object();
    private static AudioRecord ahe = null;
    private static MediaRecorder ahf = null;

    /* loaded from: classes.dex */
    public enum State {
        INITIALIZING,
        READY,
        RECORDING,
        ERROR,
        STOPPED;

        /* JADX DEBUG: Replace access to removed values field (ahq) with 'values()' method */
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
            ahe = null;
            ahf = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, ahb[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.wI() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, ahb[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State wI() {
        return this.ahh;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.ahg = 0;
        this.filePath = null;
        try {
            this.ahd = z;
            if (this.ahd) {
                if (i4 == 2) {
                    this.ahk = (short) 16;
                } else {
                    this.ahk = (short) 8;
                }
                if (i3 == 2) {
                    this.ahi = (short) 1;
                } else {
                    this.ahi = (short) 2;
                }
                this.ahl = i;
                this.ahj = i2;
                this.ahm = i4;
                this.ahn = (i2 * SocialAPIErrorCodes.ERROR_INVALID_AUTHORIZED_CODE) / 1000;
                this.agJ = (((this.ahn * 2) * this.ahk) * this.ahi) / 8;
                if (this.agJ < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.agJ = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.ahn = this.agJ / (((this.ahk * 2) * this.ahi) / 8);
                    BdLog.w(String.valueOf(MyAudioRecorder.class.getName()) + "Increasing buffer size to " + Integer.toString(this.agJ));
                }
                ahe = new AudioRecord(i, i2, i3, i4, this.agJ);
                if (ahe.getRecordingState() == 3) {
                    ahe.stop();
                }
                if (ahe.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                ahf = new MediaRecorder();
                ahf.setAudioSource(1);
                ahf.setOutputFormat(1);
                ahf.setAudioEncoder(1);
            }
            this.ahg = 0;
            this.filePath = null;
            this.ahh = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "Unknown error occured while initializing recording");
            }
            this.ahh = State.ERROR;
        }
    }

    public boolean dR(String str) {
        try {
            if (this.ahh == State.INITIALIZING) {
                this.filePath = str;
                if (!this.ahd) {
                    ahf.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + e.getMessage());
            } else {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "Unknown error occured while setting output path");
            }
            this.ahh = State.ERROR;
            return false;
        }
    }

    public boolean wJ() {
        try {
            if (this.ahh == State.INITIALIZING) {
                if (this.ahd) {
                    if ((this.filePath != null) & (ahe.getState() == 1)) {
                        if (this.agM != null) {
                            this.agM.close();
                            this.agM = null;
                        }
                        this.agM = new RandomAccessFile(this.filePath, "rw");
                        this.agM.setLength(0L);
                        this.agM.writeBytes("RIFF");
                        this.agM.writeInt(0);
                        this.agM.writeBytes("WAVE");
                        this.agM.writeBytes("fmt ");
                        this.agM.writeInt(Integer.reverseBytes(16));
                        this.agM.writeShort(Short.reverseBytes((short) 1));
                        this.agM.writeShort(Short.reverseBytes(this.ahi));
                        this.agM.writeInt(Integer.reverseBytes(this.ahj));
                        this.agM.writeInt(Integer.reverseBytes(((this.ahj * this.ahk) * this.ahi) / 8));
                        this.agM.writeShort(Short.reverseBytes((short) ((this.ahi * this.ahk) / 8)));
                        this.agM.writeShort(Short.reverseBytes(this.ahk));
                        this.agM.writeBytes("data");
                        this.agM.writeInt(0);
                        this.buffer = new byte[((this.ahn * this.ahk) / 8) * this.ahi];
                        this.ahh = State.READY;
                    } else {
                        BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "prepare() method called on uninitialized recorder");
                        this.ahh = State.ERROR;
                        return false;
                    }
                } else {
                    ahf.prepare();
                    this.ahh = State.READY;
                }
                return true;
            }
            BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "prepare() method called on illegal state");
            release();
            this.ahh = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + e.getMessage());
            } else {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "Unknown error occured in prepare()");
            }
            this.ahh = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.ahh == State.RECORDING) {
            stop();
        } else {
            if ((this.ahh == State.READY) & this.ahd) {
                try {
                    this.agM.close();
                } catch (IOException e) {
                    BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.ahd) {
            if (ahe != null) {
                ahe.release();
            }
        } else if (ahf != null) {
            ahf.release();
        }
    }

    public void start() {
        if (this.ahh == State.READY) {
            if (this.ahd) {
                this.aho = 0;
                ahe.startRecording();
                ahe.read(this.buffer, 0, this.buffer.length);
            } else {
                ahf.start();
            }
            this.ahh = State.RECORDING;
            return;
        }
        BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "start() called on illegal state");
        this.ahh = State.ERROR;
    }

    public void stop() {
        BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "audioRecorder.stop()");
        ahe.stop();
        try {
            this.agM.seek(4L);
            this.agM.writeInt(Integer.reverseBytes(this.aho + 36));
            this.agM.seek(40L);
            this.agM.writeInt(Integer.reverseBytes(this.aho));
            this.agM.close();
            BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "I/O exception occured while closing output file");
            this.ahh = State.ERROR;
        }
        this.ahh = State.STOPPED;
    }

    private short a(byte b, byte b2) {
        return (short) ((b2 << 8) | b);
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean dP(String str) {
        if (dR(str)) {
            return wJ();
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean wD() {
        synchronized (mLock) {
            if (this.ahc == null || !this.ahc.isAlive()) {
                this.ahc = new Thread(new g(this));
                this.ahc.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public void wE() {
        this.ahh = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean wF() {
        return this.ahh == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wC() {
        if (ahe != null) {
            try {
                start();
                while (wF()) {
                    ahe.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.agM.write(this.buffer);
                        this.aho += this.buffer.length;
                        if (this.ahk == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short a = a(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (a > this.ahg) {
                                    this.ahg = a;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.ahg) {
                                    this.ahg = this.buffer[i2];
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
