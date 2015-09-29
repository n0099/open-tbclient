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
    private int aeX;
    private int afA;
    private int afB;
    private int afC;
    private RandomAccessFile afa;
    private Thread afq;
    private boolean afr;
    private int afu;
    private State afv;
    private short afw;
    private int afx;
    private short afy;
    private int afz;
    private byte[] buffer;
    private String filePath;
    private static final int[] afp = {44100, 22050, 11025, 8000};
    private static Object mLock = new Object();
    private static AudioRecord afs = null;
    private static MediaRecorder aft = null;

    /* loaded from: classes.dex */
    public enum State {
        INITIALIZING,
        READY,
        RECORDING,
        ERROR,
        STOPPED;

        /* JADX DEBUG: Replace access to removed values field (afE) with 'values()' method */
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
            afs = null;
            aft = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, afp[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.vQ() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, afp[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State vQ() {
        return this.afv;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.afu = 0;
        this.filePath = null;
        try {
            this.afr = z;
            if (this.afr) {
                if (i4 == 2) {
                    this.afy = (short) 16;
                } else {
                    this.afy = (short) 8;
                }
                if (i3 == 2) {
                    this.afw = (short) 1;
                } else {
                    this.afw = (short) 2;
                }
                this.afz = i;
                this.afx = i2;
                this.afA = i4;
                this.afB = (i2 * SocialAPIErrorCodes.ERROR_INVALID_AUTHORIZED_CODE) / 1000;
                this.aeX = (((this.afB * 2) * this.afy) * this.afw) / 8;
                if (this.aeX < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.aeX = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.afB = this.aeX / (((this.afy * 2) * this.afw) / 8);
                    BdLog.w(String.valueOf(MyAudioRecorder.class.getName()) + "Increasing buffer size to " + Integer.toString(this.aeX));
                }
                afs = new AudioRecord(i, i2, i3, i4, this.aeX);
                if (afs.getRecordingState() == 3) {
                    afs.stop();
                }
                if (afs.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                aft = new MediaRecorder();
                aft.setAudioSource(1);
                aft.setOutputFormat(1);
                aft.setAudioEncoder(1);
            }
            this.afu = 0;
            this.filePath = null;
            this.afv = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "Unknown error occured while initializing recording");
            }
            this.afv = State.ERROR;
        }
    }

    public boolean dJ(String str) {
        try {
            if (this.afv == State.INITIALIZING) {
                this.filePath = str;
                if (!this.afr) {
                    aft.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + e.getMessage());
            } else {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "Unknown error occured while setting output path");
            }
            this.afv = State.ERROR;
            return false;
        }
    }

    public boolean vR() {
        try {
            if (this.afv == State.INITIALIZING) {
                if (this.afr) {
                    if ((this.filePath != null) & (afs.getState() == 1)) {
                        if (this.afa != null) {
                            this.afa.close();
                            this.afa = null;
                        }
                        this.afa = new RandomAccessFile(this.filePath, "rw");
                        this.afa.setLength(0L);
                        this.afa.writeBytes("RIFF");
                        this.afa.writeInt(0);
                        this.afa.writeBytes("WAVE");
                        this.afa.writeBytes("fmt ");
                        this.afa.writeInt(Integer.reverseBytes(16));
                        this.afa.writeShort(Short.reverseBytes((short) 1));
                        this.afa.writeShort(Short.reverseBytes(this.afw));
                        this.afa.writeInt(Integer.reverseBytes(this.afx));
                        this.afa.writeInt(Integer.reverseBytes(((this.afx * this.afy) * this.afw) / 8));
                        this.afa.writeShort(Short.reverseBytes((short) ((this.afw * this.afy) / 8)));
                        this.afa.writeShort(Short.reverseBytes(this.afy));
                        this.afa.writeBytes("data");
                        this.afa.writeInt(0);
                        this.buffer = new byte[((this.afB * this.afy) / 8) * this.afw];
                        this.afv = State.READY;
                    } else {
                        BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "prepare() method called on uninitialized recorder");
                        this.afv = State.ERROR;
                        return false;
                    }
                } else {
                    aft.prepare();
                    this.afv = State.READY;
                }
                return true;
            }
            BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "prepare() method called on illegal state");
            release();
            this.afv = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + e.getMessage());
            } else {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "Unknown error occured in prepare()");
            }
            this.afv = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.afv == State.RECORDING) {
            stop();
        } else {
            if ((this.afv == State.READY) & this.afr) {
                try {
                    this.afa.close();
                } catch (IOException e) {
                    BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.afr) {
            if (afs != null) {
                afs.release();
            }
        } else if (aft != null) {
            aft.release();
        }
    }

    public void start() {
        if (this.afv == State.READY) {
            if (this.afr) {
                this.afC = 0;
                afs.startRecording();
                afs.read(this.buffer, 0, this.buffer.length);
            } else {
                aft.start();
            }
            this.afv = State.RECORDING;
            return;
        }
        BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "start() called on illegal state");
        this.afv = State.ERROR;
    }

    public void stop() {
        BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "audioRecorder.stop()");
        afs.stop();
        try {
            this.afa.seek(4L);
            this.afa.writeInt(Integer.reverseBytes(this.afC + 36));
            this.afa.seek(40L);
            this.afa.writeInt(Integer.reverseBytes(this.afC));
            this.afa.close();
            BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "I/O exception occured while closing output file");
            this.afv = State.ERROR;
        }
        this.afv = State.STOPPED;
    }

    private short a(byte b, byte b2) {
        return (short) ((b2 << 8) | b);
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean dH(String str) {
        if (dJ(str)) {
            return vR();
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean vL() {
        synchronized (mLock) {
            if (this.afq == null || !this.afq.isAlive()) {
                this.afq = new Thread(new g(this));
                this.afq.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public void vM() {
        this.afv = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean vN() {
        return this.afv == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vK() {
        if (afs != null) {
            try {
                start();
                while (vN()) {
                    afs.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.afa.write(this.buffer);
                        this.afC += this.buffer.length;
                        if (this.afy == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short a = a(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (a > this.afu) {
                                    this.afu = a;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.afu) {
                                    this.afu = this.buffer[i2];
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
