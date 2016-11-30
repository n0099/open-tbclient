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
    private int ajB;
    private State ajC;
    private short ajD;
    private int ajE;
    private short ajF;
    private int ajG;
    private int ajH;
    private int ajI;
    private int ajJ;
    private int ajd;
    private RandomAccessFile ajg;
    private Thread ajx;
    private boolean ajy;
    private byte[] buffer;
    private String filePath;
    private static final int[] ajw = {44100, 22050, 11025, 8000};
    private static Object mLock = new Object();
    private static AudioRecord ajz = null;
    private static MediaRecorder ajA = null;

    /* loaded from: classes.dex */
    public enum State {
        INITIALIZING,
        READY,
        RECORDING,
        ERROR,
        STOPPED;

        /* JADX DEBUG: Replace access to removed values field (ajL) with 'values()' method */
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
            ajz = null;
            ajA = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, ajw[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.xp() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, ajw[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State xp() {
        return this.ajC;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.ajB = 0;
        this.filePath = null;
        try {
            this.ajy = z;
            if (this.ajy) {
                if (i4 == 2) {
                    this.ajF = (short) 16;
                } else {
                    this.ajF = (short) 8;
                }
                if (i3 == 2) {
                    this.ajD = (short) 1;
                } else {
                    this.ajD = (short) 2;
                }
                this.ajG = i;
                this.ajE = i2;
                this.ajH = i4;
                this.ajI = (i2 * SocialAPIErrorCodes.ERROR_INVALID_AUTHORIZED_CODE) / 1000;
                this.ajd = (((this.ajI * 2) * this.ajF) * this.ajD) / 8;
                if (this.ajd < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.ajd = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.ajI = this.ajd / (((this.ajF * 2) * this.ajD) / 8);
                    BdLog.w(String.valueOf(MyAudioRecorder.class.getName()) + "Increasing buffer size to " + Integer.toString(this.ajd));
                }
                ajz = new AudioRecord(i, i2, i3, i4, this.ajd);
                if (ajz.getRecordingState() == 3) {
                    ajz.stop();
                }
                if (ajz.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                ajA = new MediaRecorder();
                ajA.setAudioSource(1);
                ajA.setOutputFormat(1);
                ajA.setAudioEncoder(1);
            }
            this.ajB = 0;
            this.filePath = null;
            this.ajC = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "Unknown error occured while initializing recording");
            }
            this.ajC = State.ERROR;
        }
    }

    public boolean eh(String str) {
        try {
            if (this.ajC == State.INITIALIZING) {
                this.filePath = str;
                if (!this.ajy) {
                    ajA.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + e.getMessage());
            } else {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "Unknown error occured while setting output path");
            }
            this.ajC = State.ERROR;
            return false;
        }
    }

    public boolean prepare() {
        try {
            if (this.ajC == State.INITIALIZING) {
                if (this.ajy) {
                    if ((this.filePath != null) & (ajz.getState() == 1)) {
                        if (this.ajg != null) {
                            this.ajg.close();
                            this.ajg = null;
                        }
                        this.ajg = new RandomAccessFile(this.filePath, "rw");
                        this.ajg.setLength(0L);
                        this.ajg.writeBytes("RIFF");
                        this.ajg.writeInt(0);
                        this.ajg.writeBytes("WAVE");
                        this.ajg.writeBytes("fmt ");
                        this.ajg.writeInt(Integer.reverseBytes(16));
                        this.ajg.writeShort(Short.reverseBytes((short) 1));
                        this.ajg.writeShort(Short.reverseBytes(this.ajD));
                        this.ajg.writeInt(Integer.reverseBytes(this.ajE));
                        this.ajg.writeInt(Integer.reverseBytes(((this.ajE * this.ajF) * this.ajD) / 8));
                        this.ajg.writeShort(Short.reverseBytes((short) ((this.ajD * this.ajF) / 8)));
                        this.ajg.writeShort(Short.reverseBytes(this.ajF));
                        this.ajg.writeBytes("data");
                        this.ajg.writeInt(0);
                        this.buffer = new byte[((this.ajI * this.ajF) / 8) * this.ajD];
                        this.ajC = State.READY;
                    } else {
                        BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "prepare() method called on uninitialized recorder");
                        this.ajC = State.ERROR;
                        return false;
                    }
                } else {
                    ajA.prepare();
                    this.ajC = State.READY;
                }
                return true;
            }
            BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "prepare() method called on illegal state");
            release();
            this.ajC = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + e.getMessage());
            } else {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "Unknown error occured in prepare()");
            }
            this.ajC = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.ajC == State.RECORDING) {
            stop();
        } else {
            if ((this.ajC == State.READY) & this.ajy) {
                try {
                    this.ajg.close();
                } catch (IOException e) {
                    BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.ajy) {
            if (ajz != null) {
                ajz.release();
            }
        } else if (ajA != null) {
            ajA.release();
        }
    }

    public void start() {
        if (this.ajC == State.READY) {
            if (this.ajy) {
                this.ajJ = 0;
                ajz.startRecording();
                ajz.read(this.buffer, 0, this.buffer.length);
            } else {
                ajA.start();
            }
            this.ajC = State.RECORDING;
            return;
        }
        BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "start() called on illegal state");
        this.ajC = State.ERROR;
    }

    public void stop() {
        BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "audioRecorder.stop()");
        ajz.stop();
        try {
            this.ajg.seek(4L);
            this.ajg.writeInt(Integer.reverseBytes(this.ajJ + 36));
            this.ajg.seek(40L);
            this.ajg.writeInt(Integer.reverseBytes(this.ajJ));
            this.ajg.close();
            BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "I/O exception occured while closing output file");
            this.ajC = State.ERROR;
        }
        this.ajC = State.STOPPED;
    }

    private short a(byte b, byte b2) {
        return (short) ((b2 << 8) | b);
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean ef(String str) {
        if (eh(str)) {
            return prepare();
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean xk() {
        synchronized (mLock) {
            if (this.ajx == null || !this.ajx.isAlive()) {
                this.ajx = new Thread(new g(this));
                this.ajx.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public void xl() {
        this.ajC = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean xm() {
        return this.ajC == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj() {
        if (ajz != null) {
            try {
                start();
                while (xm()) {
                    ajz.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.ajg.write(this.buffer);
                        this.ajJ += this.buffer.length;
                        if (this.ajF == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short a = a(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (a > this.ajB) {
                                    this.ajB = a;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.ajB) {
                                    this.ajB = this.buffer[i2];
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
