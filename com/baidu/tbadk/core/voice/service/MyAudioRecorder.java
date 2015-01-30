package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import android.media.MediaRecorder;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class MyAudioRecorder implements j {
    private Thread OI;
    private boolean OJ;
    private int OO;
    private State OP;
    private short OQ;
    private int OR;
    private short OS;
    private int OT;
    private int OV;
    private int OW;
    private int OX;
    private int Or;
    private RandomAccessFile Ot;
    private byte[] buffer;
    private String filePath;
    private static final int[] OH = {44100, 22050, 11025, 8000};
    private static Object mLock = new Object();
    private static AudioRecord OL = null;
    private static MediaRecorder OM = null;

    /* loaded from: classes.dex */
    public enum State {
        INITIALIZING,
        READY,
        RECORDING,
        ERROR,
        STOPPED;

        /* JADX DEBUG: Replace access to removed values field (OZ) with 'values()' method */
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
            OL = null;
            OM = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, OH[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.rc() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, OH[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State rc() {
        return this.OP;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.OO = 0;
        this.filePath = null;
        try {
            this.OJ = z;
            if (this.OJ) {
                if (i4 == 2) {
                    this.OS = (short) 16;
                } else {
                    this.OS = (short) 8;
                }
                if (i3 == 2) {
                    this.OQ = (short) 1;
                } else {
                    this.OQ = (short) 2;
                }
                this.OT = i;
                this.OR = i2;
                this.OV = i4;
                this.OW = (i2 * 120) / 1000;
                this.Or = (((this.OW * 2) * this.OS) * this.OQ) / 8;
                if (this.Or < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.Or = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.OW = this.Or / (((this.OS * 2) * this.OQ) / 8);
                    Log.w(MyAudioRecorder.class.getName(), "Increasing buffer size to " + Integer.toString(this.Or));
                }
                OL = new AudioRecord(i, i2, i3, i4, this.Or);
                if (OL.getRecordingState() == 3) {
                    OL.stop();
                }
                if (OL.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                OM = new MediaRecorder();
                OM.setAudioSource(1);
                OM.setOutputFormat(1);
                OM.setAudioEncoder(1);
            }
            this.OO = 0;
            this.filePath = null;
            this.OP = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                Log.e(MyAudioRecorder.class.getName(), e.getMessage());
            } else {
                Log.e(MyAudioRecorder.class.getName(), "Unknown error occured while initializing recording");
            }
            this.OP = State.ERROR;
        }
    }

    public boolean da(String str) {
        try {
            if (this.OP == State.INITIALIZING) {
                this.filePath = str;
                if (!this.OJ) {
                    OM.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                Log.e(MyAudioRecorder.class.getName(), e.getMessage());
            } else {
                Log.e(MyAudioRecorder.class.getName(), "Unknown error occured while setting output path");
            }
            this.OP = State.ERROR;
            return false;
        }
    }

    public boolean rd() {
        try {
            if (this.OP == State.INITIALIZING) {
                if (this.OJ) {
                    if ((this.filePath != null) & (OL.getState() == 1)) {
                        if (this.Ot != null) {
                            this.Ot.close();
                            this.Ot = null;
                        }
                        this.Ot = new RandomAccessFile(this.filePath, "rw");
                        this.Ot.setLength(0L);
                        this.Ot.writeBytes("RIFF");
                        this.Ot.writeInt(0);
                        this.Ot.writeBytes("WAVE");
                        this.Ot.writeBytes("fmt ");
                        this.Ot.writeInt(Integer.reverseBytes(16));
                        this.Ot.writeShort(Short.reverseBytes((short) 1));
                        this.Ot.writeShort(Short.reverseBytes(this.OQ));
                        this.Ot.writeInt(Integer.reverseBytes(this.OR));
                        this.Ot.writeInt(Integer.reverseBytes(((this.OR * this.OS) * this.OQ) / 8));
                        this.Ot.writeShort(Short.reverseBytes((short) ((this.OQ * this.OS) / 8)));
                        this.Ot.writeShort(Short.reverseBytes(this.OS));
                        this.Ot.writeBytes("data");
                        this.Ot.writeInt(0);
                        this.buffer = new byte[((this.OW * this.OS) / 8) * this.OQ];
                        this.OP = State.READY;
                    } else {
                        Log.e(MyAudioRecorder.class.getName(), "prepare() method called on uninitialized recorder");
                        this.OP = State.ERROR;
                        return false;
                    }
                } else {
                    OM.prepare();
                    this.OP = State.READY;
                }
                return true;
            }
            Log.e(MyAudioRecorder.class.getName(), "prepare() method called on illegal state");
            release();
            this.OP = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                Log.e(MyAudioRecorder.class.getName(), e.getMessage());
            } else {
                Log.e(MyAudioRecorder.class.getName(), "Unknown error occured in prepare()");
            }
            this.OP = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.OP == State.RECORDING) {
            stop();
        } else {
            if ((this.OP == State.READY) & this.OJ) {
                try {
                    this.Ot.close();
                } catch (IOException e) {
                    Log.e(MyAudioRecorder.class.getName(), "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.OJ) {
            if (OL != null) {
                OL.release();
            }
        } else if (OM != null) {
            OM.release();
        }
    }

    public void start() {
        if (this.OP == State.READY) {
            if (this.OJ) {
                this.OX = 0;
                OL.startRecording();
                OL.read(this.buffer, 0, this.buffer.length);
            } else {
                OM.start();
            }
            this.OP = State.RECORDING;
            return;
        }
        Log.e(MyAudioRecorder.class.getName(), "start() called on illegal state");
        this.OP = State.ERROR;
    }

    public void stop() {
        Log.e(MyAudioRecorder.class.getName(), "audioRecorder.stop()");
        OL.stop();
        try {
            this.Ot.seek(4L);
            this.Ot.writeInt(Integer.reverseBytes(this.OX + 36));
            this.Ot.seek(40L);
            this.Ot.writeInt(Integer.reverseBytes(this.OX));
            this.Ot.close();
            Log.e(MyAudioRecorder.class.getName(), "randomAccessWriter.close()");
        } catch (IOException e) {
            Log.e(MyAudioRecorder.class.getName(), "I/O exception occured while closing output file");
            this.OP = State.ERROR;
        }
        this.OP = State.STOPPED;
    }

    private short a(byte b, byte b2) {
        return (short) ((b2 << 8) | b);
    }

    @Override // com.baidu.tbadk.core.voice.service.j
    public boolean cY(String str) {
        if (da(str)) {
            return rd();
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.j
    public boolean qX() {
        synchronized (mLock) {
            if (this.OI == null || !this.OI.isAlive()) {
                this.OI = new Thread(new h(this));
                this.OI.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.j
    public void qY() {
        this.OP = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.j
    public boolean qZ() {
        return this.OP == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qW() {
        if (OL != null) {
            try {
                start();
                while (qZ()) {
                    OL.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.Ot.write(this.buffer);
                        this.OX += this.buffer.length;
                        if (this.OS == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short a = a(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (a > this.OO) {
                                    this.OO = a;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.OO) {
                                    this.OO = this.buffer[i2];
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
