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
    private int ahM;
    private RandomAccessFile ahP;
    private Thread aif;
    private boolean aig;
    private int aij;
    private State aik;
    private short ail;
    private int aim;
    private short ain;
    private int aio;
    private int aip;
    private int aiq;
    private int air;
    private byte[] buffer;
    private String filePath;
    private static final int[] aie = {44100, 22050, 11025, 8000};
    private static Object mLock = new Object();
    private static AudioRecord aih = null;
    private static MediaRecorder aii = null;

    /* loaded from: classes.dex */
    public enum State {
        INITIALIZING,
        READY,
        RECORDING,
        ERROR,
        STOPPED;

        /* JADX DEBUG: Replace access to removed values field (ait) with 'values()' method */
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
            aih = null;
            aii = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, aie[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.wr() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, aie[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State wr() {
        return this.aik;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.aij = 0;
        this.filePath = null;
        try {
            this.aig = z;
            if (this.aig) {
                if (i4 == 2) {
                    this.ain = (short) 16;
                } else {
                    this.ain = (short) 8;
                }
                if (i3 == 2) {
                    this.ail = (short) 1;
                } else {
                    this.ail = (short) 2;
                }
                this.aio = i;
                this.aim = i2;
                this.aip = i4;
                this.aiq = (i2 * SocialAPIErrorCodes.ERROR_INVALID_AUTHORIZED_CODE) / 1000;
                this.ahM = (((this.aiq * 2) * this.ain) * this.ail) / 8;
                if (this.ahM < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.ahM = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.aiq = this.ahM / (((this.ain * 2) * this.ail) / 8);
                    BdLog.w(String.valueOf(MyAudioRecorder.class.getName()) + "Increasing buffer size to " + Integer.toString(this.ahM));
                }
                aih = new AudioRecord(i, i2, i3, i4, this.ahM);
                if (aih.getRecordingState() == 3) {
                    aih.stop();
                }
                if (aih.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                aii = new MediaRecorder();
                aii.setAudioSource(1);
                aii.setOutputFormat(1);
                aii.setAudioEncoder(1);
            }
            this.aij = 0;
            this.filePath = null;
            this.aik = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "Unknown error occured while initializing recording");
            }
            this.aik = State.ERROR;
        }
    }

    public boolean dU(String str) {
        try {
            if (this.aik == State.INITIALIZING) {
                this.filePath = str;
                if (!this.aig) {
                    aii.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + e.getMessage());
            } else {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "Unknown error occured while setting output path");
            }
            this.aik = State.ERROR;
            return false;
        }
    }

    public boolean ws() {
        try {
            if (this.aik == State.INITIALIZING) {
                if (this.aig) {
                    if ((this.filePath != null) & (aih.getState() == 1)) {
                        if (this.ahP != null) {
                            this.ahP.close();
                            this.ahP = null;
                        }
                        this.ahP = new RandomAccessFile(this.filePath, "rw");
                        this.ahP.setLength(0L);
                        this.ahP.writeBytes("RIFF");
                        this.ahP.writeInt(0);
                        this.ahP.writeBytes("WAVE");
                        this.ahP.writeBytes("fmt ");
                        this.ahP.writeInt(Integer.reverseBytes(16));
                        this.ahP.writeShort(Short.reverseBytes((short) 1));
                        this.ahP.writeShort(Short.reverseBytes(this.ail));
                        this.ahP.writeInt(Integer.reverseBytes(this.aim));
                        this.ahP.writeInt(Integer.reverseBytes(((this.aim * this.ain) * this.ail) / 8));
                        this.ahP.writeShort(Short.reverseBytes((short) ((this.ail * this.ain) / 8)));
                        this.ahP.writeShort(Short.reverseBytes(this.ain));
                        this.ahP.writeBytes("data");
                        this.ahP.writeInt(0);
                        this.buffer = new byte[((this.aiq * this.ain) / 8) * this.ail];
                        this.aik = State.READY;
                    } else {
                        BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "prepare() method called on uninitialized recorder");
                        this.aik = State.ERROR;
                        return false;
                    }
                } else {
                    aii.prepare();
                    this.aik = State.READY;
                }
                return true;
            }
            BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "prepare() method called on illegal state");
            release();
            this.aik = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + e.getMessage());
            } else {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "Unknown error occured in prepare()");
            }
            this.aik = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.aik == State.RECORDING) {
            stop();
        } else {
            if ((this.aik == State.READY) & this.aig) {
                try {
                    this.ahP.close();
                } catch (IOException e) {
                    BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.aig) {
            if (aih != null) {
                aih.release();
            }
        } else if (aii != null) {
            aii.release();
        }
    }

    public void start() {
        if (this.aik == State.READY) {
            if (this.aig) {
                this.air = 0;
                aih.startRecording();
                aih.read(this.buffer, 0, this.buffer.length);
            } else {
                aii.start();
            }
            this.aik = State.RECORDING;
            return;
        }
        BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "start() called on illegal state");
        this.aik = State.ERROR;
    }

    public void stop() {
        BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "audioRecorder.stop()");
        aih.stop();
        try {
            this.ahP.seek(4L);
            this.ahP.writeInt(Integer.reverseBytes(this.air + 36));
            this.ahP.seek(40L);
            this.ahP.writeInt(Integer.reverseBytes(this.air));
            this.ahP.close();
            BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "I/O exception occured while closing output file");
            this.aik = State.ERROR;
        }
        this.aik = State.STOPPED;
    }

    private short a(byte b, byte b2) {
        return (short) ((b2 << 8) | b);
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean dS(String str) {
        if (dU(str)) {
            return ws();
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean wm() {
        synchronized (mLock) {
            if (this.aif == null || !this.aif.isAlive()) {
                this.aif = new Thread(new g(this));
                this.aif.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public void wn() {
        this.aik = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean wo() {
        return this.aik == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wl() {
        if (aih != null) {
            try {
                start();
                while (wo()) {
                    aih.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.ahP.write(this.buffer);
                        this.air += this.buffer.length;
                        if (this.ain == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short a = a(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (a > this.aij) {
                                    this.aij = a;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.aij) {
                                    this.aij = this.buffer[i2];
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
