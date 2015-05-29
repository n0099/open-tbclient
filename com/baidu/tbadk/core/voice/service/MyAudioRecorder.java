package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import android.media.MediaRecorder;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class MyAudioRecorder implements j {
    private RandomAccessFile aaA;
    private Thread aaQ;
    private boolean aaR;
    private int aaU;
    private State aaV;
    private short aaW;
    private int aaX;
    private short aaY;
    private int aaZ;
    private int aax;
    private int aba;
    private int abb;
    private int abc;
    private byte[] buffer;
    private String filePath;
    private static final int[] aaP = {44100, 22050, 11025, 8000};
    private static Object mLock = new Object();
    private static AudioRecord aaS = null;
    private static MediaRecorder aaT = null;

    /* loaded from: classes.dex */
    public enum State {
        INITIALIZING,
        READY,
        RECORDING,
        ERROR,
        STOPPED;

        /* JADX DEBUG: Replace access to removed values field (abe) with 'values()' method */
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
            aaS = null;
            aaT = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, aaP[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.uO() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, aaP[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State uO() {
        return this.aaV;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.aaU = 0;
        this.filePath = null;
        try {
            this.aaR = z;
            if (this.aaR) {
                if (i4 == 2) {
                    this.aaY = (short) 16;
                } else {
                    this.aaY = (short) 8;
                }
                if (i3 == 2) {
                    this.aaW = (short) 1;
                } else {
                    this.aaW = (short) 2;
                }
                this.aaZ = i;
                this.aaX = i2;
                this.aba = i4;
                this.abb = (i2 * 120) / 1000;
                this.aax = (((this.abb * 2) * this.aaY) * this.aaW) / 8;
                if (this.aax < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.aax = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.abb = this.aax / (((this.aaY * 2) * this.aaW) / 8);
                    Log.w(MyAudioRecorder.class.getName(), "Increasing buffer size to " + Integer.toString(this.aax));
                }
                aaS = new AudioRecord(i, i2, i3, i4, this.aax);
                if (aaS.getRecordingState() == 3) {
                    aaS.stop();
                }
                if (aaS.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                aaT = new MediaRecorder();
                aaT.setAudioSource(1);
                aaT.setOutputFormat(1);
                aaT.setAudioEncoder(1);
            }
            this.aaU = 0;
            this.filePath = null;
            this.aaV = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                Log.e(MyAudioRecorder.class.getName(), e.getMessage());
            } else {
                Log.e(MyAudioRecorder.class.getName(), "Unknown error occured while initializing recording");
            }
            this.aaV = State.ERROR;
        }
    }

    public boolean dx(String str) {
        try {
            if (this.aaV == State.INITIALIZING) {
                this.filePath = str;
                if (!this.aaR) {
                    aaT.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                Log.e(MyAudioRecorder.class.getName(), e.getMessage());
            } else {
                Log.e(MyAudioRecorder.class.getName(), "Unknown error occured while setting output path");
            }
            this.aaV = State.ERROR;
            return false;
        }
    }

    public boolean uP() {
        try {
            if (this.aaV == State.INITIALIZING) {
                if (this.aaR) {
                    if ((this.filePath != null) & (aaS.getState() == 1)) {
                        if (this.aaA != null) {
                            this.aaA.close();
                            this.aaA = null;
                        }
                        this.aaA = new RandomAccessFile(this.filePath, "rw");
                        this.aaA.setLength(0L);
                        this.aaA.writeBytes("RIFF");
                        this.aaA.writeInt(0);
                        this.aaA.writeBytes("WAVE");
                        this.aaA.writeBytes("fmt ");
                        this.aaA.writeInt(Integer.reverseBytes(16));
                        this.aaA.writeShort(Short.reverseBytes((short) 1));
                        this.aaA.writeShort(Short.reverseBytes(this.aaW));
                        this.aaA.writeInt(Integer.reverseBytes(this.aaX));
                        this.aaA.writeInt(Integer.reverseBytes(((this.aaX * this.aaY) * this.aaW) / 8));
                        this.aaA.writeShort(Short.reverseBytes((short) ((this.aaW * this.aaY) / 8)));
                        this.aaA.writeShort(Short.reverseBytes(this.aaY));
                        this.aaA.writeBytes("data");
                        this.aaA.writeInt(0);
                        this.buffer = new byte[((this.abb * this.aaY) / 8) * this.aaW];
                        this.aaV = State.READY;
                    } else {
                        Log.e(MyAudioRecorder.class.getName(), "prepare() method called on uninitialized recorder");
                        this.aaV = State.ERROR;
                        return false;
                    }
                } else {
                    aaT.prepare();
                    this.aaV = State.READY;
                }
                return true;
            }
            Log.e(MyAudioRecorder.class.getName(), "prepare() method called on illegal state");
            release();
            this.aaV = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                Log.e(MyAudioRecorder.class.getName(), e.getMessage());
            } else {
                Log.e(MyAudioRecorder.class.getName(), "Unknown error occured in prepare()");
            }
            this.aaV = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.aaV == State.RECORDING) {
            stop();
        } else {
            if ((this.aaV == State.READY) & this.aaR) {
                try {
                    this.aaA.close();
                } catch (IOException e) {
                    Log.e(MyAudioRecorder.class.getName(), "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.aaR) {
            if (aaS != null) {
                aaS.release();
            }
        } else if (aaT != null) {
            aaT.release();
        }
    }

    public void start() {
        if (this.aaV == State.READY) {
            if (this.aaR) {
                this.abc = 0;
                aaS.startRecording();
                aaS.read(this.buffer, 0, this.buffer.length);
            } else {
                aaT.start();
            }
            this.aaV = State.RECORDING;
            return;
        }
        Log.e(MyAudioRecorder.class.getName(), "start() called on illegal state");
        this.aaV = State.ERROR;
    }

    public void stop() {
        Log.e(MyAudioRecorder.class.getName(), "audioRecorder.stop()");
        aaS.stop();
        try {
            this.aaA.seek(4L);
            this.aaA.writeInt(Integer.reverseBytes(this.abc + 36));
            this.aaA.seek(40L);
            this.aaA.writeInt(Integer.reverseBytes(this.abc));
            this.aaA.close();
            Log.e(MyAudioRecorder.class.getName(), "randomAccessWriter.close()");
        } catch (IOException e) {
            Log.e(MyAudioRecorder.class.getName(), "I/O exception occured while closing output file");
            this.aaV = State.ERROR;
        }
        this.aaV = State.STOPPED;
    }

    private short a(byte b, byte b2) {
        return (short) ((b2 << 8) | b);
    }

    @Override // com.baidu.tbadk.core.voice.service.j
    public boolean dv(String str) {
        if (dx(str)) {
            return uP();
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.j
    public boolean uJ() {
        synchronized (mLock) {
            if (this.aaQ == null || !this.aaQ.isAlive()) {
                this.aaQ = new Thread(new h(this));
                this.aaQ.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.j
    public void uK() {
        this.aaV = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.j
    public boolean uL() {
        return this.aaV == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uI() {
        if (aaS != null) {
            try {
                start();
                while (uL()) {
                    aaS.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.aaA.write(this.buffer);
                        this.abc += this.buffer.length;
                        if (this.aaY == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short a = a(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (a > this.aaU) {
                                    this.aaU = a;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.aaU) {
                                    this.aaU = this.buffer[i2];
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
