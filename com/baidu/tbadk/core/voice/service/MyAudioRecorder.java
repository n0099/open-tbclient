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
    private Thread aiF;
    private boolean aiG;
    private int aiJ;
    private State aiK;
    private short aiL;
    private int aiM;
    private short aiN;
    private int aiO;
    private int aiP;
    private int aiQ;
    private int aiR;
    private int ail;
    private RandomAccessFile aio;
    private byte[] buffer;
    private String filePath;
    private static final int[] aiE = {44100, 22050, 11025, 8000};
    private static Object mLock = new Object();
    private static AudioRecord aiH = null;
    private static MediaRecorder aiI = null;

    /* loaded from: classes.dex */
    public enum State {
        INITIALIZING,
        READY,
        RECORDING,
        ERROR,
        STOPPED;

        /* JADX DEBUG: Replace access to removed values field (aiT) with 'values()' method */
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
            aiH = null;
            aiI = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, aiE[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.xk() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, aiE[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State xk() {
        return this.aiK;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.aiJ = 0;
        this.filePath = null;
        try {
            this.aiG = z;
            if (this.aiG) {
                if (i4 == 2) {
                    this.aiN = (short) 16;
                } else {
                    this.aiN = (short) 8;
                }
                if (i3 == 2) {
                    this.aiL = (short) 1;
                } else {
                    this.aiL = (short) 2;
                }
                this.aiO = i;
                this.aiM = i2;
                this.aiP = i4;
                this.aiQ = (i2 * SocialAPIErrorCodes.ERROR_INVALID_AUTHORIZED_CODE) / 1000;
                this.ail = (((this.aiQ * 2) * this.aiN) * this.aiL) / 8;
                if (this.ail < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.ail = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.aiQ = this.ail / (((this.aiN * 2) * this.aiL) / 8);
                    BdLog.w(String.valueOf(MyAudioRecorder.class.getName()) + "Increasing buffer size to " + Integer.toString(this.ail));
                }
                aiH = new AudioRecord(i, i2, i3, i4, this.ail);
                if (aiH.getRecordingState() == 3) {
                    aiH.stop();
                }
                if (aiH.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                aiI = new MediaRecorder();
                aiI.setAudioSource(1);
                aiI.setOutputFormat(1);
                aiI.setAudioEncoder(1);
            }
            this.aiJ = 0;
            this.filePath = null;
            this.aiK = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "Unknown error occured while initializing recording");
            }
            this.aiK = State.ERROR;
        }
    }

    public boolean ef(String str) {
        try {
            if (this.aiK == State.INITIALIZING) {
                this.filePath = str;
                if (!this.aiG) {
                    aiI.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + e.getMessage());
            } else {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "Unknown error occured while setting output path");
            }
            this.aiK = State.ERROR;
            return false;
        }
    }

    public boolean prepare() {
        try {
            if (this.aiK == State.INITIALIZING) {
                if (this.aiG) {
                    if ((this.filePath != null) & (aiH.getState() == 1)) {
                        if (this.aio != null) {
                            this.aio.close();
                            this.aio = null;
                        }
                        this.aio = new RandomAccessFile(this.filePath, "rw");
                        this.aio.setLength(0L);
                        this.aio.writeBytes("RIFF");
                        this.aio.writeInt(0);
                        this.aio.writeBytes("WAVE");
                        this.aio.writeBytes("fmt ");
                        this.aio.writeInt(Integer.reverseBytes(16));
                        this.aio.writeShort(Short.reverseBytes((short) 1));
                        this.aio.writeShort(Short.reverseBytes(this.aiL));
                        this.aio.writeInt(Integer.reverseBytes(this.aiM));
                        this.aio.writeInt(Integer.reverseBytes(((this.aiM * this.aiN) * this.aiL) / 8));
                        this.aio.writeShort(Short.reverseBytes((short) ((this.aiL * this.aiN) / 8)));
                        this.aio.writeShort(Short.reverseBytes(this.aiN));
                        this.aio.writeBytes("data");
                        this.aio.writeInt(0);
                        this.buffer = new byte[((this.aiQ * this.aiN) / 8) * this.aiL];
                        this.aiK = State.READY;
                    } else {
                        BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "prepare() method called on uninitialized recorder");
                        this.aiK = State.ERROR;
                        return false;
                    }
                } else {
                    aiI.prepare();
                    this.aiK = State.READY;
                }
                return true;
            }
            BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "prepare() method called on illegal state");
            release();
            this.aiK = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + e.getMessage());
            } else {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "Unknown error occured in prepare()");
            }
            this.aiK = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.aiK == State.RECORDING) {
            stop();
        } else {
            if ((this.aiK == State.READY) & this.aiG) {
                try {
                    this.aio.close();
                } catch (IOException e) {
                    BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.aiG) {
            if (aiH != null) {
                aiH.release();
            }
        } else if (aiI != null) {
            aiI.release();
        }
    }

    public void start() {
        if (this.aiK == State.READY) {
            if (this.aiG) {
                this.aiR = 0;
                aiH.startRecording();
                aiH.read(this.buffer, 0, this.buffer.length);
            } else {
                aiI.start();
            }
            this.aiK = State.RECORDING;
            return;
        }
        BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "start() called on illegal state");
        this.aiK = State.ERROR;
    }

    public void stop() {
        BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "audioRecorder.stop()");
        aiH.stop();
        try {
            this.aio.seek(4L);
            this.aio.writeInt(Integer.reverseBytes(this.aiR + 36));
            this.aio.seek(40L);
            this.aio.writeInt(Integer.reverseBytes(this.aiR));
            this.aio.close();
            BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "I/O exception occured while closing output file");
            this.aiK = State.ERROR;
        }
        this.aiK = State.STOPPED;
    }

    private short a(byte b, byte b2) {
        return (short) ((b2 << 8) | b);
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean ed(String str) {
        if (ef(str)) {
            return prepare();
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean xf() {
        synchronized (mLock) {
            if (this.aiF == null || !this.aiF.isAlive()) {
                this.aiF = new Thread(new g(this));
                this.aiF.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public void xg() {
        this.aiK = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean xh() {
        return this.aiK == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xe() {
        if (aiH != null) {
            try {
                start();
                while (xh()) {
                    aiH.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.aio.write(this.buffer);
                        this.aiR += this.buffer.length;
                        if (this.aiN == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short a = a(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (a > this.aiJ) {
                                    this.aiJ = a;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.aiJ) {
                                    this.aiJ = this.buffer[i2];
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
