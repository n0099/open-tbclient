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
    private int aiN;
    private RandomAccessFile aiQ;
    private Thread ajh;
    private boolean aji;
    private int ajl;
    private State ajm;
    private short ajn;
    private int ajo;
    private short ajp;
    private int ajq;
    private int ajr;
    private int ajs;
    private int ajt;
    private byte[] buffer;
    private String filePath;
    private static final int[] ajg = {44100, 22050, 11025, 8000};
    private static Object mLock = new Object();
    private static AudioRecord ajj = null;
    private static MediaRecorder ajk = null;

    /* loaded from: classes.dex */
    public enum State {
        INITIALIZING,
        READY,
        RECORDING,
        ERROR,
        STOPPED;

        /* JADX DEBUG: Replace access to removed values field (ajv) with 'values()' method */
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
            ajj = null;
            ajk = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, ajg[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.yg() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, ajg[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State yg() {
        return this.ajm;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.ajl = 0;
        this.filePath = null;
        try {
            this.aji = z;
            if (this.aji) {
                if (i4 == 2) {
                    this.ajp = (short) 16;
                } else {
                    this.ajp = (short) 8;
                }
                if (i3 == 2) {
                    this.ajn = (short) 1;
                } else {
                    this.ajn = (short) 2;
                }
                this.ajq = i;
                this.ajo = i2;
                this.ajr = i4;
                this.ajs = (i2 * SocialAPIErrorCodes.ERROR_INVALID_AUTHORIZED_CODE) / 1000;
                this.aiN = (((this.ajs * 2) * this.ajp) * this.ajn) / 8;
                if (this.aiN < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.aiN = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.ajs = this.aiN / (((this.ajp * 2) * this.ajn) / 8);
                    BdLog.w(String.valueOf(MyAudioRecorder.class.getName()) + "Increasing buffer size to " + Integer.toString(this.aiN));
                }
                ajj = new AudioRecord(i, i2, i3, i4, this.aiN);
                if (ajj.getRecordingState() == 3) {
                    ajj.stop();
                }
                if (ajj.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                ajk = new MediaRecorder();
                ajk.setAudioSource(1);
                ajk.setOutputFormat(1);
                ajk.setAudioEncoder(1);
            }
            this.ajl = 0;
            this.filePath = null;
            this.ajm = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "Unknown error occured while initializing recording");
            }
            this.ajm = State.ERROR;
        }
    }

    public boolean ea(String str) {
        try {
            if (this.ajm == State.INITIALIZING) {
                this.filePath = str;
                if (!this.aji) {
                    ajk.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + e.getMessage());
            } else {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "Unknown error occured while setting output path");
            }
            this.ajm = State.ERROR;
            return false;
        }
    }

    public boolean yh() {
        try {
            if (this.ajm == State.INITIALIZING) {
                if (this.aji) {
                    if ((this.filePath != null) & (ajj.getState() == 1)) {
                        if (this.aiQ != null) {
                            this.aiQ.close();
                            this.aiQ = null;
                        }
                        this.aiQ = new RandomAccessFile(this.filePath, "rw");
                        this.aiQ.setLength(0L);
                        this.aiQ.writeBytes("RIFF");
                        this.aiQ.writeInt(0);
                        this.aiQ.writeBytes("WAVE");
                        this.aiQ.writeBytes("fmt ");
                        this.aiQ.writeInt(Integer.reverseBytes(16));
                        this.aiQ.writeShort(Short.reverseBytes((short) 1));
                        this.aiQ.writeShort(Short.reverseBytes(this.ajn));
                        this.aiQ.writeInt(Integer.reverseBytes(this.ajo));
                        this.aiQ.writeInt(Integer.reverseBytes(((this.ajo * this.ajp) * this.ajn) / 8));
                        this.aiQ.writeShort(Short.reverseBytes((short) ((this.ajn * this.ajp) / 8)));
                        this.aiQ.writeShort(Short.reverseBytes(this.ajp));
                        this.aiQ.writeBytes("data");
                        this.aiQ.writeInt(0);
                        this.buffer = new byte[((this.ajs * this.ajp) / 8) * this.ajn];
                        this.ajm = State.READY;
                    } else {
                        BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "prepare() method called on uninitialized recorder");
                        this.ajm = State.ERROR;
                        return false;
                    }
                } else {
                    ajk.prepare();
                    this.ajm = State.READY;
                }
                return true;
            }
            BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "prepare() method called on illegal state");
            release();
            this.ajm = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + e.getMessage());
            } else {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "Unknown error occured in prepare()");
            }
            this.ajm = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.ajm == State.RECORDING) {
            stop();
        } else {
            if ((this.ajm == State.READY) & this.aji) {
                try {
                    this.aiQ.close();
                } catch (IOException e) {
                    BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.aji) {
            if (ajj != null) {
                ajj.release();
            }
        } else if (ajk != null) {
            ajk.release();
        }
    }

    public void start() {
        if (this.ajm == State.READY) {
            if (this.aji) {
                this.ajt = 0;
                ajj.startRecording();
                ajj.read(this.buffer, 0, this.buffer.length);
            } else {
                ajk.start();
            }
            this.ajm = State.RECORDING;
            return;
        }
        BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "start() called on illegal state");
        this.ajm = State.ERROR;
    }

    public void stop() {
        BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "audioRecorder.stop()");
        ajj.stop();
        try {
            this.aiQ.seek(4L);
            this.aiQ.writeInt(Integer.reverseBytes(this.ajt + 36));
            this.aiQ.seek(40L);
            this.aiQ.writeInt(Integer.reverseBytes(this.ajt));
            this.aiQ.close();
            BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "I/O exception occured while closing output file");
            this.ajm = State.ERROR;
        }
        this.ajm = State.STOPPED;
    }

    private short a(byte b, byte b2) {
        return (short) ((b2 << 8) | b);
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean dY(String str) {
        if (ea(str)) {
            return yh();
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean yb() {
        synchronized (mLock) {
            if (this.ajh == null || !this.ajh.isAlive()) {
                this.ajh = new Thread(new g(this));
                this.ajh.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public void yc() {
        this.ajm = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean yd() {
        return this.ajm == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ya() {
        if (ajj != null) {
            try {
                start();
                while (yd()) {
                    ajj.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.aiQ.write(this.buffer);
                        this.ajt += this.buffer.length;
                        if (this.ajp == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short a = a(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (a > this.ajl) {
                                    this.ajl = a;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.ajl) {
                                    this.ajl = this.buffer[i2];
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
