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
    private int afK;
    private RandomAccessFile afN;
    private Thread agd;
    private boolean age;
    private int agh;
    private State agi;
    private short agj;
    private int agk;
    private short agl;
    private int agm;
    private int agn;
    private int ago;
    private int agp;
    private byte[] buffer;
    private String filePath;
    private static final int[] agc = {44100, 22050, 11025, 8000};
    private static Object mLock = new Object();
    private static AudioRecord agf = null;
    private static MediaRecorder agg = null;

    /* loaded from: classes.dex */
    public enum State {
        INITIALIZING,
        READY,
        RECORDING,
        ERROR,
        STOPPED;

        /* JADX DEBUG: Replace access to removed values field (agr) with 'values()' method */
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
            agf = null;
            agg = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, agc[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.vX() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, agc[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State vX() {
        return this.agi;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.agh = 0;
        this.filePath = null;
        try {
            this.age = z;
            if (this.age) {
                if (i4 == 2) {
                    this.agl = (short) 16;
                } else {
                    this.agl = (short) 8;
                }
                if (i3 == 2) {
                    this.agj = (short) 1;
                } else {
                    this.agj = (short) 2;
                }
                this.agm = i;
                this.agk = i2;
                this.agn = i4;
                this.ago = (i2 * SocialAPIErrorCodes.ERROR_INVALID_AUTHORIZED_CODE) / 1000;
                this.afK = (((this.ago * 2) * this.agl) * this.agj) / 8;
                if (this.afK < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.afK = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.ago = this.afK / (((this.agl * 2) * this.agj) / 8);
                    BdLog.w(String.valueOf(MyAudioRecorder.class.getName()) + "Increasing buffer size to " + Integer.toString(this.afK));
                }
                agf = new AudioRecord(i, i2, i3, i4, this.afK);
                if (agf.getRecordingState() == 3) {
                    agf.stop();
                }
                if (agf.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                agg = new MediaRecorder();
                agg.setAudioSource(1);
                agg.setOutputFormat(1);
                agg.setAudioEncoder(1);
            }
            this.agh = 0;
            this.filePath = null;
            this.agi = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "Unknown error occured while initializing recording");
            }
            this.agi = State.ERROR;
        }
    }

    public boolean dF(String str) {
        try {
            if (this.agi == State.INITIALIZING) {
                this.filePath = str;
                if (!this.age) {
                    agg.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + e.getMessage());
            } else {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "Unknown error occured while setting output path");
            }
            this.agi = State.ERROR;
            return false;
        }
    }

    public boolean vY() {
        try {
            if (this.agi == State.INITIALIZING) {
                if (this.age) {
                    if ((this.filePath != null) & (agf.getState() == 1)) {
                        if (this.afN != null) {
                            this.afN.close();
                            this.afN = null;
                        }
                        this.afN = new RandomAccessFile(this.filePath, "rw");
                        this.afN.setLength(0L);
                        this.afN.writeBytes("RIFF");
                        this.afN.writeInt(0);
                        this.afN.writeBytes("WAVE");
                        this.afN.writeBytes("fmt ");
                        this.afN.writeInt(Integer.reverseBytes(16));
                        this.afN.writeShort(Short.reverseBytes((short) 1));
                        this.afN.writeShort(Short.reverseBytes(this.agj));
                        this.afN.writeInt(Integer.reverseBytes(this.agk));
                        this.afN.writeInt(Integer.reverseBytes(((this.agk * this.agl) * this.agj) / 8));
                        this.afN.writeShort(Short.reverseBytes((short) ((this.agj * this.agl) / 8)));
                        this.afN.writeShort(Short.reverseBytes(this.agl));
                        this.afN.writeBytes("data");
                        this.afN.writeInt(0);
                        this.buffer = new byte[((this.ago * this.agl) / 8) * this.agj];
                        this.agi = State.READY;
                    } else {
                        BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "prepare() method called on uninitialized recorder");
                        this.agi = State.ERROR;
                        return false;
                    }
                } else {
                    agg.prepare();
                    this.agi = State.READY;
                }
                return true;
            }
            BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "prepare() method called on illegal state");
            release();
            this.agi = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + e.getMessage());
            } else {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "Unknown error occured in prepare()");
            }
            this.agi = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.agi == State.RECORDING) {
            stop();
        } else {
            if ((this.agi == State.READY) & this.age) {
                try {
                    this.afN.close();
                } catch (IOException e) {
                    BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.age) {
            if (agf != null) {
                agf.release();
            }
        } else if (agg != null) {
            agg.release();
        }
    }

    public void start() {
        if (this.agi == State.READY) {
            if (this.age) {
                this.agp = 0;
                agf.startRecording();
                agf.read(this.buffer, 0, this.buffer.length);
            } else {
                agg.start();
            }
            this.agi = State.RECORDING;
            return;
        }
        BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "start() called on illegal state");
        this.agi = State.ERROR;
    }

    public void stop() {
        BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "audioRecorder.stop()");
        agf.stop();
        try {
            this.afN.seek(4L);
            this.afN.writeInt(Integer.reverseBytes(this.agp + 36));
            this.afN.seek(40L);
            this.afN.writeInt(Integer.reverseBytes(this.agp));
            this.afN.close();
            BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "I/O exception occured while closing output file");
            this.agi = State.ERROR;
        }
        this.agi = State.STOPPED;
    }

    private short a(byte b, byte b2) {
        return (short) ((b2 << 8) | b);
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean dD(String str) {
        if (dF(str)) {
            return vY();
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean vS() {
        synchronized (mLock) {
            if (this.agd == null || !this.agd.isAlive()) {
                this.agd = new Thread(new g(this));
                this.agd.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public void vT() {
        this.agi = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean vU() {
        return this.agi == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vR() {
        if (agf != null) {
            try {
                start();
                while (vU()) {
                    agf.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.afN.write(this.buffer);
                        this.agp += this.buffer.length;
                        if (this.agl == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short a = a(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (a > this.agh) {
                                    this.agh = a;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.agh) {
                                    this.agh = this.buffer[i2];
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
