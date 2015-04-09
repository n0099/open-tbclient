package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import android.media.MediaRecorder;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class MyAudioRecorder implements j {
    private Thread ZP;
    private boolean ZQ;
    private int ZT;
    private State ZU;
    private short ZV;
    private int ZW;
    private short ZX;
    private int ZY;
    private int ZZ;
    private int Zw;
    private RandomAccessFile Zz;
    private int aaa;
    private int aab;
    private byte[] buffer;
    private String filePath;
    private static final int[] ZO = {44100, 22050, 11025, 8000};
    private static Object mLock = new Object();
    private static AudioRecord ZR = null;
    private static MediaRecorder ZS = null;

    /* loaded from: classes.dex */
    public enum State {
        INITIALIZING,
        READY,
        RECORDING,
        ERROR,
        STOPPED;

        /* JADX DEBUG: Replace access to removed values field (aad) with 'values()' method */
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
            ZR = null;
            ZS = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, ZO[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.uf() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, ZO[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State uf() {
        return this.ZU;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.ZT = 0;
        this.filePath = null;
        try {
            this.ZQ = z;
            if (this.ZQ) {
                if (i4 == 2) {
                    this.ZX = (short) 16;
                } else {
                    this.ZX = (short) 8;
                }
                if (i3 == 2) {
                    this.ZV = (short) 1;
                } else {
                    this.ZV = (short) 2;
                }
                this.ZY = i;
                this.ZW = i2;
                this.ZZ = i4;
                this.aaa = (i2 * 120) / 1000;
                this.Zw = (((this.aaa * 2) * this.ZX) * this.ZV) / 8;
                if (this.Zw < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.Zw = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.aaa = this.Zw / (((this.ZX * 2) * this.ZV) / 8);
                    Log.w(MyAudioRecorder.class.getName(), "Increasing buffer size to " + Integer.toString(this.Zw));
                }
                ZR = new AudioRecord(i, i2, i3, i4, this.Zw);
                if (ZR.getRecordingState() == 3) {
                    ZR.stop();
                }
                if (ZR.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                ZS = new MediaRecorder();
                ZS.setAudioSource(1);
                ZS.setOutputFormat(1);
                ZS.setAudioEncoder(1);
            }
            this.ZT = 0;
            this.filePath = null;
            this.ZU = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                Log.e(MyAudioRecorder.class.getName(), e.getMessage());
            } else {
                Log.e(MyAudioRecorder.class.getName(), "Unknown error occured while initializing recording");
            }
            this.ZU = State.ERROR;
        }
    }

    public boolean dg(String str) {
        try {
            if (this.ZU == State.INITIALIZING) {
                this.filePath = str;
                if (!this.ZQ) {
                    ZS.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                Log.e(MyAudioRecorder.class.getName(), e.getMessage());
            } else {
                Log.e(MyAudioRecorder.class.getName(), "Unknown error occured while setting output path");
            }
            this.ZU = State.ERROR;
            return false;
        }
    }

    public boolean ug() {
        try {
            if (this.ZU == State.INITIALIZING) {
                if (this.ZQ) {
                    if ((this.filePath != null) & (ZR.getState() == 1)) {
                        if (this.Zz != null) {
                            this.Zz.close();
                            this.Zz = null;
                        }
                        this.Zz = new RandomAccessFile(this.filePath, "rw");
                        this.Zz.setLength(0L);
                        this.Zz.writeBytes("RIFF");
                        this.Zz.writeInt(0);
                        this.Zz.writeBytes("WAVE");
                        this.Zz.writeBytes("fmt ");
                        this.Zz.writeInt(Integer.reverseBytes(16));
                        this.Zz.writeShort(Short.reverseBytes((short) 1));
                        this.Zz.writeShort(Short.reverseBytes(this.ZV));
                        this.Zz.writeInt(Integer.reverseBytes(this.ZW));
                        this.Zz.writeInt(Integer.reverseBytes(((this.ZW * this.ZX) * this.ZV) / 8));
                        this.Zz.writeShort(Short.reverseBytes((short) ((this.ZV * this.ZX) / 8)));
                        this.Zz.writeShort(Short.reverseBytes(this.ZX));
                        this.Zz.writeBytes("data");
                        this.Zz.writeInt(0);
                        this.buffer = new byte[((this.aaa * this.ZX) / 8) * this.ZV];
                        this.ZU = State.READY;
                    } else {
                        Log.e(MyAudioRecorder.class.getName(), "prepare() method called on uninitialized recorder");
                        this.ZU = State.ERROR;
                        return false;
                    }
                } else {
                    ZS.prepare();
                    this.ZU = State.READY;
                }
                return true;
            }
            Log.e(MyAudioRecorder.class.getName(), "prepare() method called on illegal state");
            release();
            this.ZU = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                Log.e(MyAudioRecorder.class.getName(), e.getMessage());
            } else {
                Log.e(MyAudioRecorder.class.getName(), "Unknown error occured in prepare()");
            }
            this.ZU = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.ZU == State.RECORDING) {
            stop();
        } else {
            if ((this.ZU == State.READY) & this.ZQ) {
                try {
                    this.Zz.close();
                } catch (IOException e) {
                    Log.e(MyAudioRecorder.class.getName(), "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.ZQ) {
            if (ZR != null) {
                ZR.release();
            }
        } else if (ZS != null) {
            ZS.release();
        }
    }

    public void start() {
        if (this.ZU == State.READY) {
            if (this.ZQ) {
                this.aab = 0;
                ZR.startRecording();
                ZR.read(this.buffer, 0, this.buffer.length);
            } else {
                ZS.start();
            }
            this.ZU = State.RECORDING;
            return;
        }
        Log.e(MyAudioRecorder.class.getName(), "start() called on illegal state");
        this.ZU = State.ERROR;
    }

    public void stop() {
        Log.e(MyAudioRecorder.class.getName(), "audioRecorder.stop()");
        ZR.stop();
        try {
            this.Zz.seek(4L);
            this.Zz.writeInt(Integer.reverseBytes(this.aab + 36));
            this.Zz.seek(40L);
            this.Zz.writeInt(Integer.reverseBytes(this.aab));
            this.Zz.close();
            Log.e(MyAudioRecorder.class.getName(), "randomAccessWriter.close()");
        } catch (IOException e) {
            Log.e(MyAudioRecorder.class.getName(), "I/O exception occured while closing output file");
            this.ZU = State.ERROR;
        }
        this.ZU = State.STOPPED;
    }

    private short a(byte b, byte b2) {
        return (short) ((b2 << 8) | b);
    }

    @Override // com.baidu.tbadk.core.voice.service.j
    public boolean de(String str) {
        if (dg(str)) {
            return ug();
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.j
    public boolean ua() {
        synchronized (mLock) {
            if (this.ZP == null || !this.ZP.isAlive()) {
                this.ZP = new Thread(new h(this));
                this.ZP.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.j
    public void ub() {
        this.ZU = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.j
    public boolean uc() {
        return this.ZU == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tZ() {
        if (ZR != null) {
            try {
                start();
                while (uc()) {
                    ZR.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.Zz.write(this.buffer);
                        this.aab += this.buffer.length;
                        if (this.ZX == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short a = a(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (a > this.ZT) {
                                    this.ZT = a;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.ZT) {
                                    this.ZT = this.buffer[i2];
                                }
                            }
                        }
                    } catch (IOException e) {
                    }
                }
                stop();
                release();
            } catch (Throwable th) {
                Log.e("AudioRecord", "Recording Failed");
            }
        }
    }
}
