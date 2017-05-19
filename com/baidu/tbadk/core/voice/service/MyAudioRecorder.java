package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import android.media.MediaRecorder;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class MyAudioRecorder implements i {
    private int anG;
    private RandomAccessFile anI;
    private Thread anY;
    private boolean anZ;
    private int aoc;
    private State aod;
    private short aoe;
    private int aof;
    private short aog;
    private int aoh;
    private int aoi;
    private int aoj;
    private int aok;
    private byte[] buffer;
    private String filePath;
    private static final int[] anX = {44100, 22050, 11025, 8000};
    private static Object mLock = new Object();
    private static AudioRecord aoa = null;
    private static MediaRecorder aob = null;

    /* loaded from: classes.dex */
    public enum State {
        INITIALIZING,
        READY,
        RECORDING,
        ERROR,
        STOPPED;

        /* JADX DEBUG: Replace access to removed values field (aom) with 'values()' method */
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
            aoa = null;
            aob = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, anX[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.xc() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, anX[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State xc() {
        return this.aod;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.aoc = 0;
        this.filePath = null;
        try {
            this.anZ = z;
            if (this.anZ) {
                if (i4 == 2) {
                    this.aog = (short) 16;
                } else {
                    this.aog = (short) 8;
                }
                if (i3 == 2) {
                    this.aoe = (short) 1;
                } else {
                    this.aoe = (short) 2;
                }
                this.aoh = i;
                this.aof = i2;
                this.aoi = i4;
                this.aoj = (i2 * 120) / 1000;
                this.anG = (((this.aoj * 2) * this.aog) * this.aoe) / 8;
                if (this.anG < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.anG = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.aoj = this.anG / (((this.aog * 2) * this.aoe) / 8);
                    BdLog.w(String.valueOf(MyAudioRecorder.class.getName()) + "Increasing buffer size to " + Integer.toString(this.anG));
                }
                aoa = new AudioRecord(i, i2, i3, i4, this.anG);
                if (aoa.getRecordingState() == 3) {
                    aoa.stop();
                }
                if (aoa.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                aob = new MediaRecorder();
                aob.setAudioSource(1);
                aob.setOutputFormat(1);
                aob.setAudioEncoder(1);
            }
            this.aoc = 0;
            this.filePath = null;
            this.aod = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "Unknown error occured while initializing recording");
            }
            this.aod = State.ERROR;
        }
    }

    public boolean eb(String str) {
        try {
            if (this.aod == State.INITIALIZING) {
                this.filePath = str;
                if (!this.anZ) {
                    aob.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + e.getMessage());
            } else {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "Unknown error occured while setting output path");
            }
            this.aod = State.ERROR;
            return false;
        }
    }

    public boolean prepare() {
        try {
            if (this.aod == State.INITIALIZING) {
                if (this.anZ) {
                    if ((this.filePath != null) & (aoa.getState() == 1)) {
                        if (this.anI != null) {
                            this.anI.close();
                            this.anI = null;
                        }
                        this.anI = new RandomAccessFile(this.filePath, "rw");
                        this.anI.setLength(0L);
                        this.anI.writeBytes("RIFF");
                        this.anI.writeInt(0);
                        this.anI.writeBytes("WAVE");
                        this.anI.writeBytes("fmt ");
                        this.anI.writeInt(Integer.reverseBytes(16));
                        this.anI.writeShort(Short.reverseBytes((short) 1));
                        this.anI.writeShort(Short.reverseBytes(this.aoe));
                        this.anI.writeInt(Integer.reverseBytes(this.aof));
                        this.anI.writeInt(Integer.reverseBytes(((this.aof * this.aog) * this.aoe) / 8));
                        this.anI.writeShort(Short.reverseBytes((short) ((this.aoe * this.aog) / 8)));
                        this.anI.writeShort(Short.reverseBytes(this.aog));
                        this.anI.writeBytes("data");
                        this.anI.writeInt(0);
                        this.buffer = new byte[((this.aoj * this.aog) / 8) * this.aoe];
                        this.aod = State.READY;
                    } else {
                        BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "prepare() method called on uninitialized recorder");
                        this.aod = State.ERROR;
                        return false;
                    }
                } else {
                    aob.prepare();
                    this.aod = State.READY;
                }
                return true;
            }
            BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "prepare() method called on illegal state");
            release();
            this.aod = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + e.getMessage());
            } else {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "Unknown error occured in prepare()");
            }
            this.aod = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.aod == State.RECORDING) {
            stop();
        } else {
            if ((this.aod == State.READY) & this.anZ) {
                try {
                    this.anI.close();
                } catch (IOException e) {
                    BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.anZ) {
            if (aoa != null) {
                aoa.release();
            }
        } else if (aob != null) {
            aob.release();
        }
    }

    public void start() {
        if (this.aod == State.READY) {
            if (this.anZ) {
                this.aok = 0;
                aoa.startRecording();
                aoa.read(this.buffer, 0, this.buffer.length);
            } else {
                aob.start();
            }
            this.aod = State.RECORDING;
            return;
        }
        BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "start() called on illegal state");
        this.aod = State.ERROR;
    }

    public void stop() {
        BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "audioRecorder.stop()");
        aoa.stop();
        try {
            this.anI.seek(4L);
            this.anI.writeInt(Integer.reverseBytes(this.aok + 36));
            this.anI.seek(40L);
            this.anI.writeInt(Integer.reverseBytes(this.aok));
            this.anI.close();
            BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "I/O exception occured while closing output file");
            this.aod = State.ERROR;
        }
        this.aod = State.STOPPED;
    }

    private short a(byte b, byte b2) {
        return (short) ((b2 << 8) | b);
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean dZ(String str) {
        if (eb(str)) {
            return prepare();
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean wY() {
        synchronized (mLock) {
            if (this.anY == null || !this.anY.isAlive()) {
                this.anY = new Thread(new g(this));
                this.anY.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public void wZ() {
        this.aod = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean isRecording() {
        return this.aod == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wX() {
        if (aoa != null) {
            try {
                start();
                while (isRecording()) {
                    aoa.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.anI.write(this.buffer);
                        this.aok += this.buffer.length;
                        if (this.aog == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short a = a(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (a > this.aoc) {
                                    this.aoc = a;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.aoc) {
                                    this.aoc = this.buffer[i2];
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
