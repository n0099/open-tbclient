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
    private RandomAccessFile aeC;
    private Thread aeT;
    private boolean aeU;
    private int aeX;
    private State aeY;
    private short aeZ;
    private int aez;
    private int afa;
    private short afb;
    private int afc;
    private int afd;
    private int afe;
    private int aff;
    private byte[] buffer;
    private String filePath;
    private static final int[] aeS = {44100, 22050, 11025, 8000};
    private static Object mLock = new Object();
    private static AudioRecord aeV = null;
    private static MediaRecorder aeW = null;

    /* loaded from: classes.dex */
    public enum State {
        INITIALIZING,
        READY,
        RECORDING,
        ERROR,
        STOPPED;

        /* JADX DEBUG: Replace access to removed values field (afh) with 'values()' method */
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
            aeV = null;
            aeW = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, aeS[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.wb() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, aeS[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State wb() {
        return this.aeY;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.aeX = 0;
        this.filePath = null;
        try {
            this.aeU = z;
            if (this.aeU) {
                if (i4 == 2) {
                    this.afb = (short) 16;
                } else {
                    this.afb = (short) 8;
                }
                if (i3 == 2) {
                    this.aeZ = (short) 1;
                } else {
                    this.aeZ = (short) 2;
                }
                this.afc = i;
                this.afa = i2;
                this.afd = i4;
                this.afe = (i2 * SocialAPIErrorCodes.ERROR_INVALID_AUTHORIZED_CODE) / 1000;
                this.aez = (((this.afe * 2) * this.afb) * this.aeZ) / 8;
                if (this.aez < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.aez = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.afe = this.aez / (((this.afb * 2) * this.aeZ) / 8);
                    BdLog.w(String.valueOf(MyAudioRecorder.class.getName()) + "Increasing buffer size to " + Integer.toString(this.aez));
                }
                aeV = new AudioRecord(i, i2, i3, i4, this.aez);
                if (aeV.getRecordingState() == 3) {
                    aeV.stop();
                }
                if (aeV.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                aeW = new MediaRecorder();
                aeW.setAudioSource(1);
                aeW.setOutputFormat(1);
                aeW.setAudioEncoder(1);
            }
            this.aeX = 0;
            this.filePath = null;
            this.aeY = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "Unknown error occured while initializing recording");
            }
            this.aeY = State.ERROR;
        }
    }

    public boolean dW(String str) {
        try {
            if (this.aeY == State.INITIALIZING) {
                this.filePath = str;
                if (!this.aeU) {
                    aeW.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + e.getMessage());
            } else {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "Unknown error occured while setting output path");
            }
            this.aeY = State.ERROR;
            return false;
        }
    }

    public boolean prepare() {
        try {
            if (this.aeY == State.INITIALIZING) {
                if (this.aeU) {
                    if ((this.filePath != null) & (aeV.getState() == 1)) {
                        if (this.aeC != null) {
                            this.aeC.close();
                            this.aeC = null;
                        }
                        this.aeC = new RandomAccessFile(this.filePath, "rw");
                        this.aeC.setLength(0L);
                        this.aeC.writeBytes("RIFF");
                        this.aeC.writeInt(0);
                        this.aeC.writeBytes("WAVE");
                        this.aeC.writeBytes("fmt ");
                        this.aeC.writeInt(Integer.reverseBytes(16));
                        this.aeC.writeShort(Short.reverseBytes((short) 1));
                        this.aeC.writeShort(Short.reverseBytes(this.aeZ));
                        this.aeC.writeInt(Integer.reverseBytes(this.afa));
                        this.aeC.writeInt(Integer.reverseBytes(((this.afa * this.afb) * this.aeZ) / 8));
                        this.aeC.writeShort(Short.reverseBytes((short) ((this.aeZ * this.afb) / 8)));
                        this.aeC.writeShort(Short.reverseBytes(this.afb));
                        this.aeC.writeBytes("data");
                        this.aeC.writeInt(0);
                        this.buffer = new byte[((this.afe * this.afb) / 8) * this.aeZ];
                        this.aeY = State.READY;
                    } else {
                        BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "prepare() method called on uninitialized recorder");
                        this.aeY = State.ERROR;
                        return false;
                    }
                } else {
                    aeW.prepare();
                    this.aeY = State.READY;
                }
                return true;
            }
            BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "prepare() method called on illegal state");
            release();
            this.aeY = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + e.getMessage());
            } else {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "Unknown error occured in prepare()");
            }
            this.aeY = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.aeY == State.RECORDING) {
            stop();
        } else {
            if ((this.aeY == State.READY) & this.aeU) {
                try {
                    this.aeC.close();
                } catch (IOException e) {
                    BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.aeU) {
            if (aeV != null) {
                aeV.release();
            }
        } else if (aeW != null) {
            aeW.release();
        }
    }

    public void start() {
        if (this.aeY == State.READY) {
            if (this.aeU) {
                this.aff = 0;
                aeV.startRecording();
                aeV.read(this.buffer, 0, this.buffer.length);
            } else {
                aeW.start();
            }
            this.aeY = State.RECORDING;
            return;
        }
        BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "start() called on illegal state");
        this.aeY = State.ERROR;
    }

    public void stop() {
        BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "audioRecorder.stop()");
        aeV.stop();
        try {
            this.aeC.seek(4L);
            this.aeC.writeInt(Integer.reverseBytes(this.aff + 36));
            this.aeC.seek(40L);
            this.aeC.writeInt(Integer.reverseBytes(this.aff));
            this.aeC.close();
            BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "I/O exception occured while closing output file");
            this.aeY = State.ERROR;
        }
        this.aeY = State.STOPPED;
    }

    private short a(byte b, byte b2) {
        return (short) ((b2 << 8) | b);
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean dU(String str) {
        if (dW(str)) {
            return prepare();
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean vW() {
        synchronized (mLock) {
            if (this.aeT == null || !this.aeT.isAlive()) {
                this.aeT = new Thread(new g(this));
                this.aeT.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public void vX() {
        this.aeY = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean vY() {
        return this.aeY == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vV() {
        if (aeV != null) {
            try {
                start();
                while (vY()) {
                    aeV.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.aeC.write(this.buffer);
                        this.aff += this.buffer.length;
                        if (this.afb == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short a = a(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (a > this.aeX) {
                                    this.aeX = a;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.aeX) {
                                    this.aeX = this.buffer[i2];
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
