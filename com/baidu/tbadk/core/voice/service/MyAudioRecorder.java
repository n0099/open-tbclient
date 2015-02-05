package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import android.media.MediaRecorder;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class MyAudioRecorder implements j {
    private Thread OF;
    private boolean OG;
    private int OJ;
    private State OL;
    private short OM;
    private int OO;
    private short OP;
    private int OQ;
    private int OR;
    private int OS;
    private int OT;
    private int Oo;
    private RandomAccessFile Oq;
    private byte[] buffer;
    private String filePath;
    private static final int[] OE = {44100, 22050, 11025, 8000};
    private static Object mLock = new Object();
    private static AudioRecord OH = null;
    private static MediaRecorder OI = null;

    /* loaded from: classes.dex */
    public enum State {
        INITIALIZING,
        READY,
        RECORDING,
        ERROR,
        STOPPED;

        /* JADX DEBUG: Replace access to removed values field (OW) with 'values()' method */
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
            OH = null;
            OI = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, OE[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.qW() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, OE[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State qW() {
        return this.OL;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.OJ = 0;
        this.filePath = null;
        try {
            this.OG = z;
            if (this.OG) {
                if (i4 == 2) {
                    this.OP = (short) 16;
                } else {
                    this.OP = (short) 8;
                }
                if (i3 == 2) {
                    this.OM = (short) 1;
                } else {
                    this.OM = (short) 2;
                }
                this.OQ = i;
                this.OO = i2;
                this.OR = i4;
                this.OS = (i2 * 120) / 1000;
                this.Oo = (((this.OS * 2) * this.OP) * this.OM) / 8;
                if (this.Oo < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.Oo = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.OS = this.Oo / (((this.OP * 2) * this.OM) / 8);
                    Log.w(MyAudioRecorder.class.getName(), "Increasing buffer size to " + Integer.toString(this.Oo));
                }
                OH = new AudioRecord(i, i2, i3, i4, this.Oo);
                if (OH.getRecordingState() == 3) {
                    OH.stop();
                }
                if (OH.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                OI = new MediaRecorder();
                OI.setAudioSource(1);
                OI.setOutputFormat(1);
                OI.setAudioEncoder(1);
            }
            this.OJ = 0;
            this.filePath = null;
            this.OL = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                Log.e(MyAudioRecorder.class.getName(), e.getMessage());
            } else {
                Log.e(MyAudioRecorder.class.getName(), "Unknown error occured while initializing recording");
            }
            this.OL = State.ERROR;
        }
    }

    public boolean cX(String str) {
        try {
            if (this.OL == State.INITIALIZING) {
                this.filePath = str;
                if (!this.OG) {
                    OI.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                Log.e(MyAudioRecorder.class.getName(), e.getMessage());
            } else {
                Log.e(MyAudioRecorder.class.getName(), "Unknown error occured while setting output path");
            }
            this.OL = State.ERROR;
            return false;
        }
    }

    public boolean qX() {
        try {
            if (this.OL == State.INITIALIZING) {
                if (this.OG) {
                    if ((this.filePath != null) & (OH.getState() == 1)) {
                        if (this.Oq != null) {
                            this.Oq.close();
                            this.Oq = null;
                        }
                        this.Oq = new RandomAccessFile(this.filePath, "rw");
                        this.Oq.setLength(0L);
                        this.Oq.writeBytes("RIFF");
                        this.Oq.writeInt(0);
                        this.Oq.writeBytes("WAVE");
                        this.Oq.writeBytes("fmt ");
                        this.Oq.writeInt(Integer.reverseBytes(16));
                        this.Oq.writeShort(Short.reverseBytes((short) 1));
                        this.Oq.writeShort(Short.reverseBytes(this.OM));
                        this.Oq.writeInt(Integer.reverseBytes(this.OO));
                        this.Oq.writeInt(Integer.reverseBytes(((this.OO * this.OP) * this.OM) / 8));
                        this.Oq.writeShort(Short.reverseBytes((short) ((this.OM * this.OP) / 8)));
                        this.Oq.writeShort(Short.reverseBytes(this.OP));
                        this.Oq.writeBytes("data");
                        this.Oq.writeInt(0);
                        this.buffer = new byte[((this.OS * this.OP) / 8) * this.OM];
                        this.OL = State.READY;
                    } else {
                        Log.e(MyAudioRecorder.class.getName(), "prepare() method called on uninitialized recorder");
                        this.OL = State.ERROR;
                        return false;
                    }
                } else {
                    OI.prepare();
                    this.OL = State.READY;
                }
                return true;
            }
            Log.e(MyAudioRecorder.class.getName(), "prepare() method called on illegal state");
            release();
            this.OL = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                Log.e(MyAudioRecorder.class.getName(), e.getMessage());
            } else {
                Log.e(MyAudioRecorder.class.getName(), "Unknown error occured in prepare()");
            }
            this.OL = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.OL == State.RECORDING) {
            stop();
        } else {
            if ((this.OL == State.READY) & this.OG) {
                try {
                    this.Oq.close();
                } catch (IOException e) {
                    Log.e(MyAudioRecorder.class.getName(), "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.OG) {
            if (OH != null) {
                OH.release();
            }
        } else if (OI != null) {
            OI.release();
        }
    }

    public void start() {
        if (this.OL == State.READY) {
            if (this.OG) {
                this.OT = 0;
                OH.startRecording();
                OH.read(this.buffer, 0, this.buffer.length);
            } else {
                OI.start();
            }
            this.OL = State.RECORDING;
            return;
        }
        Log.e(MyAudioRecorder.class.getName(), "start() called on illegal state");
        this.OL = State.ERROR;
    }

    public void stop() {
        Log.e(MyAudioRecorder.class.getName(), "audioRecorder.stop()");
        OH.stop();
        try {
            this.Oq.seek(4L);
            this.Oq.writeInt(Integer.reverseBytes(this.OT + 36));
            this.Oq.seek(40L);
            this.Oq.writeInt(Integer.reverseBytes(this.OT));
            this.Oq.close();
            Log.e(MyAudioRecorder.class.getName(), "randomAccessWriter.close()");
        } catch (IOException e) {
            Log.e(MyAudioRecorder.class.getName(), "I/O exception occured while closing output file");
            this.OL = State.ERROR;
        }
        this.OL = State.STOPPED;
    }

    private short a(byte b, byte b2) {
        return (short) ((b2 << 8) | b);
    }

    @Override // com.baidu.tbadk.core.voice.service.j
    public boolean cV(String str) {
        if (cX(str)) {
            return qX();
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.j
    public boolean qR() {
        synchronized (mLock) {
            if (this.OF == null || !this.OF.isAlive()) {
                this.OF = new Thread(new h(this));
                this.OF.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.j
    public void qS() {
        this.OL = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.j
    public boolean qT() {
        return this.OL == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qQ() {
        if (OH != null) {
            try {
                start();
                while (qT()) {
                    OH.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.Oq.write(this.buffer);
                        this.OT += this.buffer.length;
                        if (this.OP == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short a = a(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (a > this.OJ) {
                                    this.OJ = a;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.OJ) {
                                    this.OJ = this.buffer[i2];
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
