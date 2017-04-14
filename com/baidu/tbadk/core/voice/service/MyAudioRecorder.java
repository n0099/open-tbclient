package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import android.media.MediaRecorder;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class MyAudioRecorder implements i {
    private int anB;
    private RandomAccessFile anD;
    private Thread anT;
    private boolean anU;
    private int anX;
    private State anY;
    private short anZ;
    private int aoa;
    private short aob;
    private int aoc;
    private int aod;
    private int aoe;
    private int aof;
    private byte[] buffer;
    private String filePath;
    private static final int[] anS = {44100, 22050, 11025, 8000};
    private static Object mLock = new Object();
    private static AudioRecord anV = null;
    private static MediaRecorder anW = null;

    /* loaded from: classes.dex */
    public enum State {
        INITIALIZING,
        READY,
        RECORDING,
        ERROR,
        STOPPED;

        /* JADX DEBUG: Replace access to removed values field (aoh) with 'values()' method */
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
            anV = null;
            anW = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, anS[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.xO() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, anS[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State xO() {
        return this.anY;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.anX = 0;
        this.filePath = null;
        try {
            this.anU = z;
            if (this.anU) {
                if (i4 == 2) {
                    this.aob = (short) 16;
                } else {
                    this.aob = (short) 8;
                }
                if (i3 == 2) {
                    this.anZ = (short) 1;
                } else {
                    this.anZ = (short) 2;
                }
                this.aoc = i;
                this.aoa = i2;
                this.aod = i4;
                this.aoe = (i2 * 120) / 1000;
                this.anB = (((this.aoe * 2) * this.aob) * this.anZ) / 8;
                if (this.anB < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.anB = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.aoe = this.anB / (((this.aob * 2) * this.anZ) / 8);
                    BdLog.w(String.valueOf(MyAudioRecorder.class.getName()) + "Increasing buffer size to " + Integer.toString(this.anB));
                }
                anV = new AudioRecord(i, i2, i3, i4, this.anB);
                if (anV.getRecordingState() == 3) {
                    anV.stop();
                }
                if (anV.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                anW = new MediaRecorder();
                anW.setAudioSource(1);
                anW.setOutputFormat(1);
                anW.setAudioEncoder(1);
            }
            this.anX = 0;
            this.filePath = null;
            this.anY = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "Unknown error occured while initializing recording");
            }
            this.anY = State.ERROR;
        }
    }

    public boolean ec(String str) {
        try {
            if (this.anY == State.INITIALIZING) {
                this.filePath = str;
                if (!this.anU) {
                    anW.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + e.getMessage());
            } else {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "Unknown error occured while setting output path");
            }
            this.anY = State.ERROR;
            return false;
        }
    }

    public boolean prepare() {
        try {
            if (this.anY == State.INITIALIZING) {
                if (this.anU) {
                    if ((this.filePath != null) & (anV.getState() == 1)) {
                        if (this.anD != null) {
                            this.anD.close();
                            this.anD = null;
                        }
                        this.anD = new RandomAccessFile(this.filePath, "rw");
                        this.anD.setLength(0L);
                        this.anD.writeBytes("RIFF");
                        this.anD.writeInt(0);
                        this.anD.writeBytes("WAVE");
                        this.anD.writeBytes("fmt ");
                        this.anD.writeInt(Integer.reverseBytes(16));
                        this.anD.writeShort(Short.reverseBytes((short) 1));
                        this.anD.writeShort(Short.reverseBytes(this.anZ));
                        this.anD.writeInt(Integer.reverseBytes(this.aoa));
                        this.anD.writeInt(Integer.reverseBytes(((this.aoa * this.aob) * this.anZ) / 8));
                        this.anD.writeShort(Short.reverseBytes((short) ((this.anZ * this.aob) / 8)));
                        this.anD.writeShort(Short.reverseBytes(this.aob));
                        this.anD.writeBytes("data");
                        this.anD.writeInt(0);
                        this.buffer = new byte[((this.aoe * this.aob) / 8) * this.anZ];
                        this.anY = State.READY;
                    } else {
                        BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "prepare() method called on uninitialized recorder");
                        this.anY = State.ERROR;
                        return false;
                    }
                } else {
                    anW.prepare();
                    this.anY = State.READY;
                }
                return true;
            }
            BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "prepare() method called on illegal state");
            release();
            this.anY = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + e.getMessage());
            } else {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "Unknown error occured in prepare()");
            }
            this.anY = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.anY == State.RECORDING) {
            stop();
        } else {
            if ((this.anY == State.READY) & this.anU) {
                try {
                    this.anD.close();
                } catch (IOException e) {
                    BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.anU) {
            if (anV != null) {
                anV.release();
            }
        } else if (anW != null) {
            anW.release();
        }
    }

    public void start() {
        if (this.anY == State.READY) {
            if (this.anU) {
                this.aof = 0;
                anV.startRecording();
                anV.read(this.buffer, 0, this.buffer.length);
            } else {
                anW.start();
            }
            this.anY = State.RECORDING;
            return;
        }
        BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "start() called on illegal state");
        this.anY = State.ERROR;
    }

    public void stop() {
        BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "audioRecorder.stop()");
        anV.stop();
        try {
            this.anD.seek(4L);
            this.anD.writeInt(Integer.reverseBytes(this.aof + 36));
            this.anD.seek(40L);
            this.anD.writeInt(Integer.reverseBytes(this.aof));
            this.anD.close();
            BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "I/O exception occured while closing output file");
            this.anY = State.ERROR;
        }
        this.anY = State.STOPPED;
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
    public boolean xK() {
        synchronized (mLock) {
            if (this.anT == null || !this.anT.isAlive()) {
                this.anT = new Thread(new g(this));
                this.anT.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public void xL() {
        this.anY = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean isRecording() {
        return this.anY == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xJ() {
        if (anV != null) {
            try {
                start();
                while (isRecording()) {
                    anV.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.anD.write(this.buffer);
                        this.aof += this.buffer.length;
                        if (this.aob == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short a = a(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (a > this.anX) {
                                    this.anX = a;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.anX) {
                                    this.anX = this.buffer[i2];
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
