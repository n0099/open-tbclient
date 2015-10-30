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
    private int aeY;
    private int afA;
    private int afB;
    private int afC;
    private int afD;
    private RandomAccessFile afb;
    private Thread afr;
    private boolean afs;
    private int afv;
    private State afw;
    private short afx;
    private int afy;
    private short afz;
    private byte[] buffer;
    private String filePath;
    private static final int[] afq = {44100, 22050, 11025, 8000};
    private static Object mLock = new Object();
    private static AudioRecord aft = null;
    private static MediaRecorder afu = null;

    /* loaded from: classes.dex */
    public enum State {
        INITIALIZING,
        READY,
        RECORDING,
        ERROR,
        STOPPED;

        /* JADX DEBUG: Replace access to removed values field (afF) with 'values()' method */
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
            aft = null;
            afu = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, afq[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.vN() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, afq[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State vN() {
        return this.afw;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.afv = 0;
        this.filePath = null;
        try {
            this.afs = z;
            if (this.afs) {
                if (i4 == 2) {
                    this.afz = (short) 16;
                } else {
                    this.afz = (short) 8;
                }
                if (i3 == 2) {
                    this.afx = (short) 1;
                } else {
                    this.afx = (short) 2;
                }
                this.afA = i;
                this.afy = i2;
                this.afB = i4;
                this.afC = (i2 * SocialAPIErrorCodes.ERROR_INVALID_AUTHORIZED_CODE) / 1000;
                this.aeY = (((this.afC * 2) * this.afz) * this.afx) / 8;
                if (this.aeY < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.aeY = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.afC = this.aeY / (((this.afz * 2) * this.afx) / 8);
                    BdLog.w(String.valueOf(MyAudioRecorder.class.getName()) + "Increasing buffer size to " + Integer.toString(this.aeY));
                }
                aft = new AudioRecord(i, i2, i3, i4, this.aeY);
                if (aft.getRecordingState() == 3) {
                    aft.stop();
                }
                if (aft.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                afu = new MediaRecorder();
                afu.setAudioSource(1);
                afu.setOutputFormat(1);
                afu.setAudioEncoder(1);
            }
            this.afv = 0;
            this.filePath = null;
            this.afw = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "Unknown error occured while initializing recording");
            }
            this.afw = State.ERROR;
        }
    }

    public boolean dJ(String str) {
        try {
            if (this.afw == State.INITIALIZING) {
                this.filePath = str;
                if (!this.afs) {
                    afu.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + e.getMessage());
            } else {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "Unknown error occured while setting output path");
            }
            this.afw = State.ERROR;
            return false;
        }
    }

    public boolean vO() {
        try {
            if (this.afw == State.INITIALIZING) {
                if (this.afs) {
                    if ((this.filePath != null) & (aft.getState() == 1)) {
                        if (this.afb != null) {
                            this.afb.close();
                            this.afb = null;
                        }
                        this.afb = new RandomAccessFile(this.filePath, "rw");
                        this.afb.setLength(0L);
                        this.afb.writeBytes("RIFF");
                        this.afb.writeInt(0);
                        this.afb.writeBytes("WAVE");
                        this.afb.writeBytes("fmt ");
                        this.afb.writeInt(Integer.reverseBytes(16));
                        this.afb.writeShort(Short.reverseBytes((short) 1));
                        this.afb.writeShort(Short.reverseBytes(this.afx));
                        this.afb.writeInt(Integer.reverseBytes(this.afy));
                        this.afb.writeInt(Integer.reverseBytes(((this.afy * this.afz) * this.afx) / 8));
                        this.afb.writeShort(Short.reverseBytes((short) ((this.afx * this.afz) / 8)));
                        this.afb.writeShort(Short.reverseBytes(this.afz));
                        this.afb.writeBytes("data");
                        this.afb.writeInt(0);
                        this.buffer = new byte[((this.afC * this.afz) / 8) * this.afx];
                        this.afw = State.READY;
                    } else {
                        BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "prepare() method called on uninitialized recorder");
                        this.afw = State.ERROR;
                        return false;
                    }
                } else {
                    afu.prepare();
                    this.afw = State.READY;
                }
                return true;
            }
            BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "prepare() method called on illegal state");
            release();
            this.afw = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + e.getMessage());
            } else {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "Unknown error occured in prepare()");
            }
            this.afw = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.afw == State.RECORDING) {
            stop();
        } else {
            if ((this.afw == State.READY) & this.afs) {
                try {
                    this.afb.close();
                } catch (IOException e) {
                    BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.afs) {
            if (aft != null) {
                aft.release();
            }
        } else if (afu != null) {
            afu.release();
        }
    }

    public void start() {
        if (this.afw == State.READY) {
            if (this.afs) {
                this.afD = 0;
                aft.startRecording();
                aft.read(this.buffer, 0, this.buffer.length);
            } else {
                afu.start();
            }
            this.afw = State.RECORDING;
            return;
        }
        BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "start() called on illegal state");
        this.afw = State.ERROR;
    }

    public void stop() {
        BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "audioRecorder.stop()");
        aft.stop();
        try {
            this.afb.seek(4L);
            this.afb.writeInt(Integer.reverseBytes(this.afD + 36));
            this.afb.seek(40L);
            this.afb.writeInt(Integer.reverseBytes(this.afD));
            this.afb.close();
            BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "I/O exception occured while closing output file");
            this.afw = State.ERROR;
        }
        this.afw = State.STOPPED;
    }

    private short a(byte b, byte b2) {
        return (short) ((b2 << 8) | b);
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean dH(String str) {
        if (dJ(str)) {
            return vO();
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean vI() {
        synchronized (mLock) {
            if (this.afr == null || !this.afr.isAlive()) {
                this.afr = new Thread(new g(this));
                this.afr.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public void vJ() {
        this.afw = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean vK() {
        return this.afw == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vH() {
        if (aft != null) {
            try {
                start();
                while (vK()) {
                    aft.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.afb.write(this.buffer);
                        this.afD += this.buffer.length;
                        if (this.afz == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short a = a(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (a > this.afv) {
                                    this.afv = a;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.afv) {
                                    this.afv = this.buffer[i2];
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
