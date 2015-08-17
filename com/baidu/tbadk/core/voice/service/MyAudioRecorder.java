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
    private RandomAccessFile afD;
    private Thread afT;
    private boolean afU;
    private int afX;
    private State afY;
    private short afZ;
    private int aga;
    private short agb;
    private int agc;
    private int agd;
    private int age;
    private int agf;
    private byte[] buffer;
    private String filePath;
    private static final int[] afS = {44100, 22050, 11025, 8000};
    private static Object mLock = new Object();
    private static AudioRecord afV = null;
    private static MediaRecorder afW = null;

    /* loaded from: classes.dex */
    public enum State {
        INITIALIZING,
        READY,
        RECORDING,
        ERROR,
        STOPPED;

        /* JADX DEBUG: Replace access to removed values field (agh) with 'values()' method */
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
            afV = null;
            afW = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, afS[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.vS() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, afS[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State vS() {
        return this.afY;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.afX = 0;
        this.filePath = null;
        try {
            this.afU = z;
            if (this.afU) {
                if (i4 == 2) {
                    this.agb = (short) 16;
                } else {
                    this.agb = (short) 8;
                }
                if (i3 == 2) {
                    this.afZ = (short) 1;
                } else {
                    this.afZ = (short) 2;
                }
                this.agc = i;
                this.aga = i2;
                this.agd = i4;
                this.age = (i2 * SocialAPIErrorCodes.ERROR_INVALID_AUTHORIZED_CODE) / 1000;
                this.afA = (((this.age * 2) * this.agb) * this.afZ) / 8;
                if (this.afA < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.afA = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.age = this.afA / (((this.agb * 2) * this.afZ) / 8);
                    BdLog.w(String.valueOf(MyAudioRecorder.class.getName()) + "Increasing buffer size to " + Integer.toString(this.afA));
                }
                afV = new AudioRecord(i, i2, i3, i4, this.afA);
                if (afV.getRecordingState() == 3) {
                    afV.stop();
                }
                if (afV.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                afW = new MediaRecorder();
                afW.setAudioSource(1);
                afW.setOutputFormat(1);
                afW.setAudioEncoder(1);
            }
            this.afX = 0;
            this.filePath = null;
            this.afY = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "Unknown error occured while initializing recording");
            }
            this.afY = State.ERROR;
        }
    }

    public boolean dy(String str) {
        try {
            if (this.afY == State.INITIALIZING) {
                this.filePath = str;
                if (!this.afU) {
                    afW.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + e.getMessage());
            } else {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "Unknown error occured while setting output path");
            }
            this.afY = State.ERROR;
            return false;
        }
    }

    public boolean vT() {
        try {
            if (this.afY == State.INITIALIZING) {
                if (this.afU) {
                    if ((this.filePath != null) & (afV.getState() == 1)) {
                        if (this.afD != null) {
                            this.afD.close();
                            this.afD = null;
                        }
                        this.afD = new RandomAccessFile(this.filePath, "rw");
                        this.afD.setLength(0L);
                        this.afD.writeBytes("RIFF");
                        this.afD.writeInt(0);
                        this.afD.writeBytes("WAVE");
                        this.afD.writeBytes("fmt ");
                        this.afD.writeInt(Integer.reverseBytes(16));
                        this.afD.writeShort(Short.reverseBytes((short) 1));
                        this.afD.writeShort(Short.reverseBytes(this.afZ));
                        this.afD.writeInt(Integer.reverseBytes(this.aga));
                        this.afD.writeInt(Integer.reverseBytes(((this.aga * this.agb) * this.afZ) / 8));
                        this.afD.writeShort(Short.reverseBytes((short) ((this.afZ * this.agb) / 8)));
                        this.afD.writeShort(Short.reverseBytes(this.agb));
                        this.afD.writeBytes("data");
                        this.afD.writeInt(0);
                        this.buffer = new byte[((this.age * this.agb) / 8) * this.afZ];
                        this.afY = State.READY;
                    } else {
                        BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "prepare() method called on uninitialized recorder");
                        this.afY = State.ERROR;
                        return false;
                    }
                } else {
                    afW.prepare();
                    this.afY = State.READY;
                }
                return true;
            }
            BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "prepare() method called on illegal state");
            release();
            this.afY = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + e.getMessage());
            } else {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "Unknown error occured in prepare()");
            }
            this.afY = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.afY == State.RECORDING) {
            stop();
        } else {
            if ((this.afY == State.READY) & this.afU) {
                try {
                    this.afD.close();
                } catch (IOException e) {
                    BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.afU) {
            if (afV != null) {
                afV.release();
            }
        } else if (afW != null) {
            afW.release();
        }
    }

    public void start() {
        if (this.afY == State.READY) {
            if (this.afU) {
                this.agf = 0;
                afV.startRecording();
                afV.read(this.buffer, 0, this.buffer.length);
            } else {
                afW.start();
            }
            this.afY = State.RECORDING;
            return;
        }
        BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "start() called on illegal state");
        this.afY = State.ERROR;
    }

    public void stop() {
        BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "audioRecorder.stop()");
        afV.stop();
        try {
            this.afD.seek(4L);
            this.afD.writeInt(Integer.reverseBytes(this.agf + 36));
            this.afD.seek(40L);
            this.afD.writeInt(Integer.reverseBytes(this.agf));
            this.afD.close();
            BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "I/O exception occured while closing output file");
            this.afY = State.ERROR;
        }
        this.afY = State.STOPPED;
    }

    private short a(byte b, byte b2) {
        return (short) ((b2 << 8) | b);
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean dw(String str) {
        if (dy(str)) {
            return vT();
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean vN() {
        synchronized (mLock) {
            if (this.afT == null || !this.afT.isAlive()) {
                this.afT = new Thread(new g(this));
                this.afT.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public void vO() {
        this.afY = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean vP() {
        return this.afY == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vM() {
        if (afV != null) {
            try {
                start();
                while (vP()) {
                    afV.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.afD.write(this.buffer);
                        this.agf += this.buffer.length;
                        if (this.agb == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short a = a(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (a > this.afX) {
                                    this.afX = a;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.afX) {
                                    this.afX = this.buffer[i2];
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
