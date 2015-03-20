package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import android.media.MediaRecorder;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class MyAudioRecorder implements j {
    private Thread ZN;
    private boolean ZO;
    private int ZR;
    private State ZS;
    private short ZT;
    private int ZU;
    private short ZV;
    private int ZW;
    private int ZX;
    private int ZY;
    private int ZZ;
    private int Zu;
    private RandomAccessFile Zx;
    private byte[] buffer;
    private String filePath;
    private static final int[] ZM = {44100, 22050, 11025, 8000};
    private static Object mLock = new Object();
    private static AudioRecord ZP = null;
    private static MediaRecorder ZQ = null;

    /* loaded from: classes.dex */
    public enum State {
        INITIALIZING,
        READY,
        RECORDING,
        ERROR,
        STOPPED;

        /* JADX DEBUG: Replace access to removed values field (aab) with 'values()' method */
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
            ZP = null;
            ZQ = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, ZM[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.uf() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, ZM[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State uf() {
        return this.ZS;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.ZR = 0;
        this.filePath = null;
        try {
            this.ZO = z;
            if (this.ZO) {
                if (i4 == 2) {
                    this.ZV = (short) 16;
                } else {
                    this.ZV = (short) 8;
                }
                if (i3 == 2) {
                    this.ZT = (short) 1;
                } else {
                    this.ZT = (short) 2;
                }
                this.ZW = i;
                this.ZU = i2;
                this.ZX = i4;
                this.ZY = (i2 * 120) / 1000;
                this.Zu = (((this.ZY * 2) * this.ZV) * this.ZT) / 8;
                if (this.Zu < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.Zu = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.ZY = this.Zu / (((this.ZV * 2) * this.ZT) / 8);
                    Log.w(MyAudioRecorder.class.getName(), "Increasing buffer size to " + Integer.toString(this.Zu));
                }
                ZP = new AudioRecord(i, i2, i3, i4, this.Zu);
                if (ZP.getRecordingState() == 3) {
                    ZP.stop();
                }
                if (ZP.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                ZQ = new MediaRecorder();
                ZQ.setAudioSource(1);
                ZQ.setOutputFormat(1);
                ZQ.setAudioEncoder(1);
            }
            this.ZR = 0;
            this.filePath = null;
            this.ZS = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                Log.e(MyAudioRecorder.class.getName(), e.getMessage());
            } else {
                Log.e(MyAudioRecorder.class.getName(), "Unknown error occured while initializing recording");
            }
            this.ZS = State.ERROR;
        }
    }

    public boolean dg(String str) {
        try {
            if (this.ZS == State.INITIALIZING) {
                this.filePath = str;
                if (!this.ZO) {
                    ZQ.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                Log.e(MyAudioRecorder.class.getName(), e.getMessage());
            } else {
                Log.e(MyAudioRecorder.class.getName(), "Unknown error occured while setting output path");
            }
            this.ZS = State.ERROR;
            return false;
        }
    }

    public boolean ug() {
        try {
            if (this.ZS == State.INITIALIZING) {
                if (this.ZO) {
                    if ((this.filePath != null) & (ZP.getState() == 1)) {
                        if (this.Zx != null) {
                            this.Zx.close();
                            this.Zx = null;
                        }
                        this.Zx = new RandomAccessFile(this.filePath, "rw");
                        this.Zx.setLength(0L);
                        this.Zx.writeBytes("RIFF");
                        this.Zx.writeInt(0);
                        this.Zx.writeBytes("WAVE");
                        this.Zx.writeBytes("fmt ");
                        this.Zx.writeInt(Integer.reverseBytes(16));
                        this.Zx.writeShort(Short.reverseBytes((short) 1));
                        this.Zx.writeShort(Short.reverseBytes(this.ZT));
                        this.Zx.writeInt(Integer.reverseBytes(this.ZU));
                        this.Zx.writeInt(Integer.reverseBytes(((this.ZU * this.ZV) * this.ZT) / 8));
                        this.Zx.writeShort(Short.reverseBytes((short) ((this.ZT * this.ZV) / 8)));
                        this.Zx.writeShort(Short.reverseBytes(this.ZV));
                        this.Zx.writeBytes("data");
                        this.Zx.writeInt(0);
                        this.buffer = new byte[((this.ZY * this.ZV) / 8) * this.ZT];
                        this.ZS = State.READY;
                    } else {
                        Log.e(MyAudioRecorder.class.getName(), "prepare() method called on uninitialized recorder");
                        this.ZS = State.ERROR;
                        return false;
                    }
                } else {
                    ZQ.prepare();
                    this.ZS = State.READY;
                }
                return true;
            }
            Log.e(MyAudioRecorder.class.getName(), "prepare() method called on illegal state");
            release();
            this.ZS = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                Log.e(MyAudioRecorder.class.getName(), e.getMessage());
            } else {
                Log.e(MyAudioRecorder.class.getName(), "Unknown error occured in prepare()");
            }
            this.ZS = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.ZS == State.RECORDING) {
            stop();
        } else {
            if ((this.ZS == State.READY) & this.ZO) {
                try {
                    this.Zx.close();
                } catch (IOException e) {
                    Log.e(MyAudioRecorder.class.getName(), "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.ZO) {
            if (ZP != null) {
                ZP.release();
            }
        } else if (ZQ != null) {
            ZQ.release();
        }
    }

    public void start() {
        if (this.ZS == State.READY) {
            if (this.ZO) {
                this.ZZ = 0;
                ZP.startRecording();
                ZP.read(this.buffer, 0, this.buffer.length);
            } else {
                ZQ.start();
            }
            this.ZS = State.RECORDING;
            return;
        }
        Log.e(MyAudioRecorder.class.getName(), "start() called on illegal state");
        this.ZS = State.ERROR;
    }

    public void stop() {
        Log.e(MyAudioRecorder.class.getName(), "audioRecorder.stop()");
        ZP.stop();
        try {
            this.Zx.seek(4L);
            this.Zx.writeInt(Integer.reverseBytes(this.ZZ + 36));
            this.Zx.seek(40L);
            this.Zx.writeInt(Integer.reverseBytes(this.ZZ));
            this.Zx.close();
            Log.e(MyAudioRecorder.class.getName(), "randomAccessWriter.close()");
        } catch (IOException e) {
            Log.e(MyAudioRecorder.class.getName(), "I/O exception occured while closing output file");
            this.ZS = State.ERROR;
        }
        this.ZS = State.STOPPED;
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
            if (this.ZN == null || !this.ZN.isAlive()) {
                this.ZN = new Thread(new h(this));
                this.ZN.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.j
    public void ub() {
        this.ZS = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.j
    public boolean uc() {
        return this.ZS == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tZ() {
        if (ZP != null) {
            try {
                start();
                while (uc()) {
                    ZP.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.Zx.write(this.buffer);
                        this.ZZ += this.buffer.length;
                        if (this.ZV == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short a = a(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (a > this.ZR) {
                                    this.ZR = a;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.ZR) {
                                    this.ZR = this.buffer[i2];
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
