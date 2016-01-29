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
    private RandomAccessFile aiA;
    private Thread aiR;
    private boolean aiS;
    private int aiV;
    private State aiW;
    private short aiX;
    private int aiY;
    private short aiZ;
    private int aix;
    private int aja;
    private int ajb;
    private int ajc;
    private int ajd;
    private byte[] buffer;
    private String filePath;
    private static final int[] aiQ = {44100, 22050, 11025, 8000};
    private static Object mLock = new Object();
    private static AudioRecord aiT = null;
    private static MediaRecorder aiU = null;

    /* loaded from: classes.dex */
    public enum State {
        INITIALIZING,
        READY,
        RECORDING,
        ERROR,
        STOPPED;

        /* JADX DEBUG: Replace access to removed values field (ajf) with 'values()' method */
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
            aiT = null;
            aiU = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, aiQ[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.xF() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, aiQ[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State xF() {
        return this.aiW;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.aiV = 0;
        this.filePath = null;
        try {
            this.aiS = z;
            if (this.aiS) {
                if (i4 == 2) {
                    this.aiZ = (short) 16;
                } else {
                    this.aiZ = (short) 8;
                }
                if (i3 == 2) {
                    this.aiX = (short) 1;
                } else {
                    this.aiX = (short) 2;
                }
                this.aja = i;
                this.aiY = i2;
                this.ajb = i4;
                this.ajc = (i2 * SocialAPIErrorCodes.ERROR_INVALID_AUTHORIZED_CODE) / 1000;
                this.aix = (((this.ajc * 2) * this.aiZ) * this.aiX) / 8;
                if (this.aix < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.aix = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.ajc = this.aix / (((this.aiZ * 2) * this.aiX) / 8);
                    BdLog.w(String.valueOf(MyAudioRecorder.class.getName()) + "Increasing buffer size to " + Integer.toString(this.aix));
                }
                aiT = new AudioRecord(i, i2, i3, i4, this.aix);
                if (aiT.getRecordingState() == 3) {
                    aiT.stop();
                }
                if (aiT.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                aiU = new MediaRecorder();
                aiU.setAudioSource(1);
                aiU.setOutputFormat(1);
                aiU.setAudioEncoder(1);
            }
            this.aiV = 0;
            this.filePath = null;
            this.aiW = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "Unknown error occured while initializing recording");
            }
            this.aiW = State.ERROR;
        }
    }

    public boolean dT(String str) {
        try {
            if (this.aiW == State.INITIALIZING) {
                this.filePath = str;
                if (!this.aiS) {
                    aiU.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + e.getMessage());
            } else {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "Unknown error occured while setting output path");
            }
            this.aiW = State.ERROR;
            return false;
        }
    }

    public boolean xG() {
        try {
            if (this.aiW == State.INITIALIZING) {
                if (this.aiS) {
                    if ((this.filePath != null) & (aiT.getState() == 1)) {
                        if (this.aiA != null) {
                            this.aiA.close();
                            this.aiA = null;
                        }
                        this.aiA = new RandomAccessFile(this.filePath, "rw");
                        this.aiA.setLength(0L);
                        this.aiA.writeBytes("RIFF");
                        this.aiA.writeInt(0);
                        this.aiA.writeBytes("WAVE");
                        this.aiA.writeBytes("fmt ");
                        this.aiA.writeInt(Integer.reverseBytes(16));
                        this.aiA.writeShort(Short.reverseBytes((short) 1));
                        this.aiA.writeShort(Short.reverseBytes(this.aiX));
                        this.aiA.writeInt(Integer.reverseBytes(this.aiY));
                        this.aiA.writeInt(Integer.reverseBytes(((this.aiY * this.aiZ) * this.aiX) / 8));
                        this.aiA.writeShort(Short.reverseBytes((short) ((this.aiX * this.aiZ) / 8)));
                        this.aiA.writeShort(Short.reverseBytes(this.aiZ));
                        this.aiA.writeBytes("data");
                        this.aiA.writeInt(0);
                        this.buffer = new byte[((this.ajc * this.aiZ) / 8) * this.aiX];
                        this.aiW = State.READY;
                    } else {
                        BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "prepare() method called on uninitialized recorder");
                        this.aiW = State.ERROR;
                        return false;
                    }
                } else {
                    aiU.prepare();
                    this.aiW = State.READY;
                }
                return true;
            }
            BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "prepare() method called on illegal state");
            release();
            this.aiW = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + e.getMessage());
            } else {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "Unknown error occured in prepare()");
            }
            this.aiW = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.aiW == State.RECORDING) {
            stop();
        } else {
            if ((this.aiW == State.READY) & this.aiS) {
                try {
                    this.aiA.close();
                } catch (IOException e) {
                    BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.aiS) {
            if (aiT != null) {
                aiT.release();
            }
        } else if (aiU != null) {
            aiU.release();
        }
    }

    public void start() {
        if (this.aiW == State.READY) {
            if (this.aiS) {
                this.ajd = 0;
                aiT.startRecording();
                aiT.read(this.buffer, 0, this.buffer.length);
            } else {
                aiU.start();
            }
            this.aiW = State.RECORDING;
            return;
        }
        BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "start() called on illegal state");
        this.aiW = State.ERROR;
    }

    public void stop() {
        BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "audioRecorder.stop()");
        aiT.stop();
        try {
            this.aiA.seek(4L);
            this.aiA.writeInt(Integer.reverseBytes(this.ajd + 36));
            this.aiA.seek(40L);
            this.aiA.writeInt(Integer.reverseBytes(this.ajd));
            this.aiA.close();
            BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "I/O exception occured while closing output file");
            this.aiW = State.ERROR;
        }
        this.aiW = State.STOPPED;
    }

    private short a(byte b, byte b2) {
        return (short) ((b2 << 8) | b);
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean dR(String str) {
        if (dT(str)) {
            return xG();
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean xA() {
        synchronized (mLock) {
            if (this.aiR == null || !this.aiR.isAlive()) {
                this.aiR = new Thread(new g(this));
                this.aiR.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public void xB() {
        this.aiW = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean xC() {
        return this.aiW == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xz() {
        if (aiT != null) {
            try {
                start();
                while (xC()) {
                    aiT.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.aiA.write(this.buffer);
                        this.ajd += this.buffer.length;
                        if (this.aiZ == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short a = a(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (a > this.aiV) {
                                    this.aiV = a;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.aiV) {
                                    this.aiV = this.buffer[i2];
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
