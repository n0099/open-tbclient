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
    private int ahR;
    private RandomAccessFile ahT;
    private Thread aij;
    private boolean aik;
    private int ain;
    private State aio;
    private short aip;
    private int aiq;
    private short air;
    private int ais;
    private int ait;
    private int aiu;
    private int aiv;
    private byte[] buffer;
    private String filePath;
    private static final int[] aii = {44100, 22050, 11025, 8000};
    private static Object mLock = new Object();
    private static AudioRecord ail = null;
    private static MediaRecorder aim = null;

    /* loaded from: classes.dex */
    public enum State {
        INITIALIZING,
        READY,
        RECORDING,
        ERROR,
        STOPPED;

        /* JADX DEBUG: Replace access to removed values field (aix) with 'values()' method */
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
            ail = null;
            aim = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, aii[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.wW() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, aii[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State wW() {
        return this.aio;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.ain = 0;
        this.filePath = null;
        try {
            this.aik = z;
            if (this.aik) {
                if (i4 == 2) {
                    this.air = (short) 16;
                } else {
                    this.air = (short) 8;
                }
                if (i3 == 2) {
                    this.aip = (short) 1;
                } else {
                    this.aip = (short) 2;
                }
                this.ais = i;
                this.aiq = i2;
                this.ait = i4;
                this.aiu = (i2 * SocialAPIErrorCodes.ERROR_INVALID_AUTHORIZED_CODE) / 1000;
                this.ahR = (((this.aiu * 2) * this.air) * this.aip) / 8;
                if (this.ahR < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.ahR = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.aiu = this.ahR / (((this.air * 2) * this.aip) / 8);
                    BdLog.w(String.valueOf(MyAudioRecorder.class.getName()) + "Increasing buffer size to " + Integer.toString(this.ahR));
                }
                ail = new AudioRecord(i, i2, i3, i4, this.ahR);
                if (ail.getRecordingState() == 3) {
                    ail.stop();
                }
                if (ail.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                aim = new MediaRecorder();
                aim.setAudioSource(1);
                aim.setOutputFormat(1);
                aim.setAudioEncoder(1);
            }
            this.ain = 0;
            this.filePath = null;
            this.aio = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "Unknown error occured while initializing recording");
            }
            this.aio = State.ERROR;
        }
    }

    public boolean ec(String str) {
        try {
            if (this.aio == State.INITIALIZING) {
                this.filePath = str;
                if (!this.aik) {
                    aim.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + e.getMessage());
            } else {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "Unknown error occured while setting output path");
            }
            this.aio = State.ERROR;
            return false;
        }
    }

    public boolean prepare() {
        try {
            if (this.aio == State.INITIALIZING) {
                if (this.aik) {
                    if ((this.filePath != null) & (ail.getState() == 1)) {
                        if (this.ahT != null) {
                            this.ahT.close();
                            this.ahT = null;
                        }
                        this.ahT = new RandomAccessFile(this.filePath, "rw");
                        this.ahT.setLength(0L);
                        this.ahT.writeBytes("RIFF");
                        this.ahT.writeInt(0);
                        this.ahT.writeBytes("WAVE");
                        this.ahT.writeBytes("fmt ");
                        this.ahT.writeInt(Integer.reverseBytes(16));
                        this.ahT.writeShort(Short.reverseBytes((short) 1));
                        this.ahT.writeShort(Short.reverseBytes(this.aip));
                        this.ahT.writeInt(Integer.reverseBytes(this.aiq));
                        this.ahT.writeInt(Integer.reverseBytes(((this.aiq * this.air) * this.aip) / 8));
                        this.ahT.writeShort(Short.reverseBytes((short) ((this.aip * this.air) / 8)));
                        this.ahT.writeShort(Short.reverseBytes(this.air));
                        this.ahT.writeBytes("data");
                        this.ahT.writeInt(0);
                        this.buffer = new byte[((this.aiu * this.air) / 8) * this.aip];
                        this.aio = State.READY;
                    } else {
                        BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "prepare() method called on uninitialized recorder");
                        this.aio = State.ERROR;
                        return false;
                    }
                } else {
                    aim.prepare();
                    this.aio = State.READY;
                }
                return true;
            }
            BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "prepare() method called on illegal state");
            release();
            this.aio = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + e.getMessage());
            } else {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "Unknown error occured in prepare()");
            }
            this.aio = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.aio == State.RECORDING) {
            stop();
        } else {
            if ((this.aio == State.READY) & this.aik) {
                try {
                    this.ahT.close();
                } catch (IOException e) {
                    BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.aik) {
            if (ail != null) {
                ail.release();
            }
        } else if (aim != null) {
            aim.release();
        }
    }

    public void start() {
        if (this.aio == State.READY) {
            if (this.aik) {
                this.aiv = 0;
                ail.startRecording();
                ail.read(this.buffer, 0, this.buffer.length);
            } else {
                aim.start();
            }
            this.aio = State.RECORDING;
            return;
        }
        BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "start() called on illegal state");
        this.aio = State.ERROR;
    }

    public void stop() {
        BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "audioRecorder.stop()");
        ail.stop();
        try {
            this.ahT.seek(4L);
            this.ahT.writeInt(Integer.reverseBytes(this.aiv + 36));
            this.ahT.seek(40L);
            this.ahT.writeInt(Integer.reverseBytes(this.aiv));
            this.ahT.close();
            BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "I/O exception occured while closing output file");
            this.aio = State.ERROR;
        }
        this.aio = State.STOPPED;
    }

    private short a(byte b, byte b2) {
        return (short) ((b2 << 8) | b);
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean ea(String str) {
        if (ec(str)) {
            return prepare();
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean wR() {
        synchronized (mLock) {
            if (this.aij == null || !this.aij.isAlive()) {
                this.aij = new Thread(new g(this));
                this.aij.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public void wS() {
        this.aio = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean wT() {
        return this.aio == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wQ() {
        if (ail != null) {
            try {
                start();
                while (wT()) {
                    ail.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.ahT.write(this.buffer);
                        this.aiv += this.buffer.length;
                        if (this.air == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short a = a(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (a > this.ain) {
                                    this.ain = a;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.ain) {
                                    this.ain = this.buffer[i2];
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
