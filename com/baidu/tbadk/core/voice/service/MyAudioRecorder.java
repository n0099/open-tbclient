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
    private Thread anF;
    private boolean anG;
    private int anJ;
    private State anK;
    private short anL;
    private int anM;
    private short anN;
    private int anO;
    private int anP;
    private int anQ;
    private int anR;
    private int ann;
    private RandomAccessFile anp;
    private byte[] buffer;
    private String filePath;
    private static final int[] anE = {44100, 22050, 11025, 8000};
    private static Object mLock = new Object();
    private static AudioRecord anH = null;
    private static MediaRecorder anI = null;

    /* loaded from: classes.dex */
    public enum State {
        INITIALIZING,
        READY,
        RECORDING,
        ERROR,
        STOPPED;

        /* JADX DEBUG: Replace access to removed values field (anT) with 'values()' method */
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
            anH = null;
            anI = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, anE[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.xs() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, anE[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State xs() {
        return this.anK;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.anJ = 0;
        this.filePath = null;
        try {
            this.anG = z;
            if (this.anG) {
                if (i4 == 2) {
                    this.anN = (short) 16;
                } else {
                    this.anN = (short) 8;
                }
                if (i3 == 2) {
                    this.anL = (short) 1;
                } else {
                    this.anL = (short) 2;
                }
                this.anO = i;
                this.anM = i2;
                this.anP = i4;
                this.anQ = (i2 * SocialAPIErrorCodes.ERROR_INVALID_AUTHORIZED_CODE) / 1000;
                this.ann = (((this.anQ * 2) * this.anN) * this.anL) / 8;
                if (this.ann < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.ann = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.anQ = this.ann / (((this.anN * 2) * this.anL) / 8);
                    BdLog.w(String.valueOf(MyAudioRecorder.class.getName()) + "Increasing buffer size to " + Integer.toString(this.ann));
                }
                anH = new AudioRecord(i, i2, i3, i4, this.ann);
                if (anH.getRecordingState() == 3) {
                    anH.stop();
                }
                if (anH.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                anI = new MediaRecorder();
                anI.setAudioSource(1);
                anI.setOutputFormat(1);
                anI.setAudioEncoder(1);
            }
            this.anJ = 0;
            this.filePath = null;
            this.anK = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "Unknown error occured while initializing recording");
            }
            this.anK = State.ERROR;
        }
    }

    public boolean dW(String str) {
        try {
            if (this.anK == State.INITIALIZING) {
                this.filePath = str;
                if (!this.anG) {
                    anI.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + e.getMessage());
            } else {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "Unknown error occured while setting output path");
            }
            this.anK = State.ERROR;
            return false;
        }
    }

    public boolean prepare() {
        try {
            if (this.anK == State.INITIALIZING) {
                if (this.anG) {
                    if ((this.filePath != null) & (anH.getState() == 1)) {
                        if (this.anp != null) {
                            this.anp.close();
                            this.anp = null;
                        }
                        this.anp = new RandomAccessFile(this.filePath, "rw");
                        this.anp.setLength(0L);
                        this.anp.writeBytes("RIFF");
                        this.anp.writeInt(0);
                        this.anp.writeBytes("WAVE");
                        this.anp.writeBytes("fmt ");
                        this.anp.writeInt(Integer.reverseBytes(16));
                        this.anp.writeShort(Short.reverseBytes((short) 1));
                        this.anp.writeShort(Short.reverseBytes(this.anL));
                        this.anp.writeInt(Integer.reverseBytes(this.anM));
                        this.anp.writeInt(Integer.reverseBytes(((this.anM * this.anN) * this.anL) / 8));
                        this.anp.writeShort(Short.reverseBytes((short) ((this.anL * this.anN) / 8)));
                        this.anp.writeShort(Short.reverseBytes(this.anN));
                        this.anp.writeBytes("data");
                        this.anp.writeInt(0);
                        this.buffer = new byte[((this.anQ * this.anN) / 8) * this.anL];
                        this.anK = State.READY;
                    } else {
                        BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "prepare() method called on uninitialized recorder");
                        this.anK = State.ERROR;
                        return false;
                    }
                } else {
                    anI.prepare();
                    this.anK = State.READY;
                }
                return true;
            }
            BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "prepare() method called on illegal state");
            release();
            this.anK = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + e.getMessage());
            } else {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "Unknown error occured in prepare()");
            }
            this.anK = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.anK == State.RECORDING) {
            stop();
        } else {
            if ((this.anK == State.READY) & this.anG) {
                try {
                    this.anp.close();
                } catch (IOException e) {
                    BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.anG) {
            if (anH != null) {
                anH.release();
            }
        } else if (anI != null) {
            anI.release();
        }
    }

    public void start() {
        if (this.anK == State.READY) {
            if (this.anG) {
                this.anR = 0;
                anH.startRecording();
                anH.read(this.buffer, 0, this.buffer.length);
            } else {
                anI.start();
            }
            this.anK = State.RECORDING;
            return;
        }
        BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "start() called on illegal state");
        this.anK = State.ERROR;
    }

    public void stop() {
        BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "audioRecorder.stop()");
        anH.stop();
        try {
            this.anp.seek(4L);
            this.anp.writeInt(Integer.reverseBytes(this.anR + 36));
            this.anp.seek(40L);
            this.anp.writeInt(Integer.reverseBytes(this.anR));
            this.anp.close();
            BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "I/O exception occured while closing output file");
            this.anK = State.ERROR;
        }
        this.anK = State.STOPPED;
    }

    private short a(byte b, byte b2) {
        return (short) ((b2 << 8) | b);
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean dU(String str) {
        if (dW(str)) {
            return prepare();
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean xo() {
        synchronized (mLock) {
            if (this.anF == null || !this.anF.isAlive()) {
                this.anF = new Thread(new g(this));
                this.anF.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public void xp() {
        this.anK = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean isRecording() {
        return this.anK == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xn() {
        if (anH != null) {
            try {
                start();
                while (isRecording()) {
                    anH.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.anp.write(this.buffer);
                        this.anR += this.buffer.length;
                        if (this.anN == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short a = a(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (a > this.anJ) {
                                    this.anJ = a;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.anJ) {
                                    this.anJ = this.buffer[i2];
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
