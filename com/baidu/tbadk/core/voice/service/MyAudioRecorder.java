package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import android.media.MediaRecorder;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class MyAudioRecorder implements i {
    private Thread anI;
    private boolean anJ;
    private int anM;
    private State anN;
    private short anO;
    private int anP;
    private short anQ;
    private int anR;
    private int anS;
    private int anT;
    private int anU;
    private int anq;
    private RandomAccessFile ans;
    private byte[] buffer;
    private String filePath;
    private static final int[] anH = {44100, 22050, 11025, 8000};
    private static Object mLock = new Object();
    private static AudioRecord anK = null;
    private static MediaRecorder anL = null;

    /* loaded from: classes.dex */
    public enum State {
        INITIALIZING,
        READY,
        RECORDING,
        ERROR,
        STOPPED;

        /* JADX DEBUG: Replace access to removed values field (anW) with 'values()' method */
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
            anK = null;
            anL = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, anH[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.wV() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, anH[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State wV() {
        return this.anN;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.anM = 0;
        this.filePath = null;
        try {
            this.anJ = z;
            if (this.anJ) {
                if (i4 == 2) {
                    this.anQ = (short) 16;
                } else {
                    this.anQ = (short) 8;
                }
                if (i3 == 2) {
                    this.anO = (short) 1;
                } else {
                    this.anO = (short) 2;
                }
                this.anR = i;
                this.anP = i2;
                this.anS = i4;
                this.anT = (i2 * 120) / 1000;
                this.anq = (((this.anT * 2) * this.anQ) * this.anO) / 8;
                if (this.anq < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.anq = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.anT = this.anq / (((this.anQ * 2) * this.anO) / 8);
                    BdLog.w(String.valueOf(MyAudioRecorder.class.getName()) + "Increasing buffer size to " + Integer.toString(this.anq));
                }
                anK = new AudioRecord(i, i2, i3, i4, this.anq);
                if (anK.getRecordingState() == 3) {
                    anK.stop();
                }
                if (anK.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                anL = new MediaRecorder();
                anL.setAudioSource(1);
                anL.setOutputFormat(1);
                anL.setAudioEncoder(1);
            }
            this.anM = 0;
            this.filePath = null;
            this.anN = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "Unknown error occured while initializing recording");
            }
            this.anN = State.ERROR;
        }
    }

    public boolean dZ(String str) {
        try {
            if (this.anN == State.INITIALIZING) {
                this.filePath = str;
                if (!this.anJ) {
                    anL.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + e.getMessage());
            } else {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "Unknown error occured while setting output path");
            }
            this.anN = State.ERROR;
            return false;
        }
    }

    public boolean prepare() {
        try {
            if (this.anN == State.INITIALIZING) {
                if (this.anJ) {
                    if ((this.filePath != null) & (anK.getState() == 1)) {
                        if (this.ans != null) {
                            this.ans.close();
                            this.ans = null;
                        }
                        this.ans = new RandomAccessFile(this.filePath, "rw");
                        this.ans.setLength(0L);
                        this.ans.writeBytes("RIFF");
                        this.ans.writeInt(0);
                        this.ans.writeBytes("WAVE");
                        this.ans.writeBytes("fmt ");
                        this.ans.writeInt(Integer.reverseBytes(16));
                        this.ans.writeShort(Short.reverseBytes((short) 1));
                        this.ans.writeShort(Short.reverseBytes(this.anO));
                        this.ans.writeInt(Integer.reverseBytes(this.anP));
                        this.ans.writeInt(Integer.reverseBytes(((this.anP * this.anQ) * this.anO) / 8));
                        this.ans.writeShort(Short.reverseBytes((short) ((this.anO * this.anQ) / 8)));
                        this.ans.writeShort(Short.reverseBytes(this.anQ));
                        this.ans.writeBytes("data");
                        this.ans.writeInt(0);
                        this.buffer = new byte[((this.anT * this.anQ) / 8) * this.anO];
                        this.anN = State.READY;
                    } else {
                        BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "prepare() method called on uninitialized recorder");
                        this.anN = State.ERROR;
                        return false;
                    }
                } else {
                    anL.prepare();
                    this.anN = State.READY;
                }
                return true;
            }
            BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "prepare() method called on illegal state");
            release();
            this.anN = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + e.getMessage());
            } else {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "Unknown error occured in prepare()");
            }
            this.anN = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.anN == State.RECORDING) {
            stop();
        } else {
            if ((this.anN == State.READY) & this.anJ) {
                try {
                    this.ans.close();
                } catch (IOException e) {
                    BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.anJ) {
            if (anK != null) {
                anK.release();
            }
        } else if (anL != null) {
            anL.release();
        }
    }

    public void start() {
        if (this.anN == State.READY) {
            if (this.anJ) {
                this.anU = 0;
                anK.startRecording();
                anK.read(this.buffer, 0, this.buffer.length);
            } else {
                anL.start();
            }
            this.anN = State.RECORDING;
            return;
        }
        BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "start() called on illegal state");
        this.anN = State.ERROR;
    }

    public void stop() {
        BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "audioRecorder.stop()");
        anK.stop();
        try {
            this.ans.seek(4L);
            this.ans.writeInt(Integer.reverseBytes(this.anU + 36));
            this.ans.seek(40L);
            this.ans.writeInt(Integer.reverseBytes(this.anU));
            this.ans.close();
            BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "I/O exception occured while closing output file");
            this.anN = State.ERROR;
        }
        this.anN = State.STOPPED;
    }

    private short a(byte b, byte b2) {
        return (short) ((b2 << 8) | b);
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean dX(String str) {
        if (dZ(str)) {
            return prepare();
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean wR() {
        synchronized (mLock) {
            if (this.anI == null || !this.anI.isAlive()) {
                this.anI = new Thread(new g(this));
                this.anI.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public void wS() {
        this.anN = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean isRecording() {
        return this.anN == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wQ() {
        if (anK != null) {
            try {
                start();
                while (isRecording()) {
                    anK.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.ans.write(this.buffer);
                        this.anU += this.buffer.length;
                        if (this.anQ == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short a = a(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (a > this.anM) {
                                    this.anM = a;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.anM) {
                                    this.anM = this.buffer[i2];
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
