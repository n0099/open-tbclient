package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import android.media.MediaRecorder;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class MyAudioRecorder implements i {
    private Thread aoI;
    private boolean aoJ;
    private int aoM;
    private State aoN;
    private short aoO;
    private int aoP;
    private short aoQ;
    private int aoR;
    private int aoS;
    private int aoT;
    private int aoU;
    private int aoq;
    private RandomAccessFile aos;
    private byte[] buffer;
    private String filePath;
    private static final int[] aoH = {44100, 22050, 11025, 8000};
    private static Object mLock = new Object();
    private static AudioRecord aoK = null;
    private static MediaRecorder aoL = null;

    /* loaded from: classes.dex */
    public enum State {
        INITIALIZING,
        READY,
        RECORDING,
        ERROR,
        STOPPED;

        /* JADX DEBUG: Replace access to removed values field (aoW) with 'values()' method */
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
            aoK = null;
            aoL = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, aoH[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.xn() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, aoH[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State xn() {
        return this.aoN;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.aoM = 0;
        this.filePath = null;
        try {
            this.aoJ = z;
            if (this.aoJ) {
                if (i4 == 2) {
                    this.aoQ = (short) 16;
                } else {
                    this.aoQ = (short) 8;
                }
                if (i3 == 2) {
                    this.aoO = (short) 1;
                } else {
                    this.aoO = (short) 2;
                }
                this.aoR = i;
                this.aoP = i2;
                this.aoS = i4;
                this.aoT = (i2 * 120) / 1000;
                this.aoq = (((this.aoT * 2) * this.aoQ) * this.aoO) / 8;
                if (this.aoq < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.aoq = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.aoT = this.aoq / (((this.aoQ * 2) * this.aoO) / 8);
                    BdLog.w(String.valueOf(MyAudioRecorder.class.getName()) + "Increasing buffer size to " + Integer.toString(this.aoq));
                }
                aoK = new AudioRecord(i, i2, i3, i4, this.aoq);
                if (aoK.getRecordingState() == 3) {
                    aoK.stop();
                }
                if (aoK.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                aoL = new MediaRecorder();
                aoL.setAudioSource(1);
                aoL.setOutputFormat(1);
                aoL.setAudioEncoder(1);
            }
            this.aoM = 0;
            this.filePath = null;
            this.aoN = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "Unknown error occured while initializing recording");
            }
            this.aoN = State.ERROR;
        }
    }

    public boolean et(String str) {
        try {
            if (this.aoN == State.INITIALIZING) {
                this.filePath = str;
                if (!this.aoJ) {
                    aoL.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + e.getMessage());
            } else {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "Unknown error occured while setting output path");
            }
            this.aoN = State.ERROR;
            return false;
        }
    }

    public boolean prepare() {
        try {
            if (this.aoN == State.INITIALIZING) {
                if (this.aoJ) {
                    if ((this.filePath != null) & (aoK.getState() == 1)) {
                        if (this.aos != null) {
                            this.aos.close();
                            this.aos = null;
                        }
                        this.aos = new RandomAccessFile(this.filePath, "rw");
                        this.aos.setLength(0L);
                        this.aos.writeBytes("RIFF");
                        this.aos.writeInt(0);
                        this.aos.writeBytes("WAVE");
                        this.aos.writeBytes("fmt ");
                        this.aos.writeInt(Integer.reverseBytes(16));
                        this.aos.writeShort(Short.reverseBytes((short) 1));
                        this.aos.writeShort(Short.reverseBytes(this.aoO));
                        this.aos.writeInt(Integer.reverseBytes(this.aoP));
                        this.aos.writeInt(Integer.reverseBytes(((this.aoP * this.aoQ) * this.aoO) / 8));
                        this.aos.writeShort(Short.reverseBytes((short) ((this.aoO * this.aoQ) / 8)));
                        this.aos.writeShort(Short.reverseBytes(this.aoQ));
                        this.aos.writeBytes("data");
                        this.aos.writeInt(0);
                        this.buffer = new byte[((this.aoT * this.aoQ) / 8) * this.aoO];
                        this.aoN = State.READY;
                    } else {
                        BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "prepare() method called on uninitialized recorder");
                        this.aoN = State.ERROR;
                        return false;
                    }
                } else {
                    aoL.prepare();
                    this.aoN = State.READY;
                }
                return true;
            }
            BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "prepare() method called on illegal state");
            release();
            this.aoN = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + e.getMessage());
            } else {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "Unknown error occured in prepare()");
            }
            this.aoN = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.aoN == State.RECORDING) {
            stop();
        } else {
            if ((this.aoN == State.READY) & this.aoJ) {
                try {
                    this.aos.close();
                } catch (IOException e) {
                    BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.aoJ) {
            if (aoK != null) {
                aoK.release();
            }
        } else if (aoL != null) {
            aoL.release();
        }
    }

    public void start() {
        if (this.aoN == State.READY) {
            if (this.aoJ) {
                this.aoU = 0;
                aoK.startRecording();
                aoK.read(this.buffer, 0, this.buffer.length);
            } else {
                aoL.start();
            }
            this.aoN = State.RECORDING;
            return;
        }
        BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "start() called on illegal state");
        this.aoN = State.ERROR;
    }

    public void stop() {
        BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "audioRecorder.stop()");
        aoK.stop();
        try {
            this.aos.seek(4L);
            this.aos.writeInt(Integer.reverseBytes(this.aoU + 36));
            this.aos.seek(40L);
            this.aos.writeInt(Integer.reverseBytes(this.aoU));
            this.aos.close();
            BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "I/O exception occured while closing output file");
            this.aoN = State.ERROR;
        }
        this.aoN = State.STOPPED;
    }

    private short b(byte b, byte b2) {
        return (short) ((b2 << 8) | b);
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean er(String str) {
        if (et(str)) {
            return prepare();
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean xj() {
        synchronized (mLock) {
            if (this.aoI == null || !this.aoI.isAlive()) {
                this.aoI = new Thread(new g(this));
                this.aoI.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public void xk() {
        this.aoN = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean isRecording() {
        return this.aoN == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xi() {
        if (aoK != null) {
            try {
                start();
                while (isRecording()) {
                    aoK.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.aos.write(this.buffer);
                        this.aoU += this.buffer.length;
                        if (this.aoQ == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short b = b(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (b > this.aoM) {
                                    this.aoM = b;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.aoM) {
                                    this.aoM = this.buffer[i2];
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
