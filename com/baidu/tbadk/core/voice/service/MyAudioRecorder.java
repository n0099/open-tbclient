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
    private int aiE;
    private RandomAccessFile aiH;
    private Thread aiY;
    private boolean aiZ;
    private int ajc;
    private State ajd;
    private short aje;
    private int ajf;
    private short ajg;
    private int ajh;
    private int aji;
    private int ajj;
    private int ajk;
    private byte[] buffer;
    private String filePath;
    private static final int[] aiX = {44100, 22050, 11025, 8000};
    private static Object mLock = new Object();
    private static AudioRecord aja = null;
    private static MediaRecorder ajb = null;

    /* loaded from: classes.dex */
    public enum State {
        INITIALIZING,
        READY,
        RECORDING,
        ERROR,
        STOPPED;

        /* JADX DEBUG: Replace access to removed values field (ajm) with 'values()' method */
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
            aja = null;
            ajb = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, aiX[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.xc() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, aiX[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State xc() {
        return this.ajd;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.ajc = 0;
        this.filePath = null;
        try {
            this.aiZ = z;
            if (this.aiZ) {
                if (i4 == 2) {
                    this.ajg = (short) 16;
                } else {
                    this.ajg = (short) 8;
                }
                if (i3 == 2) {
                    this.aje = (short) 1;
                } else {
                    this.aje = (short) 2;
                }
                this.ajh = i;
                this.ajf = i2;
                this.aji = i4;
                this.ajj = (i2 * SocialAPIErrorCodes.ERROR_INVALID_AUTHORIZED_CODE) / 1000;
                this.aiE = (((this.ajj * 2) * this.ajg) * this.aje) / 8;
                if (this.aiE < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.aiE = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.ajj = this.aiE / (((this.ajg * 2) * this.aje) / 8);
                    BdLog.w(String.valueOf(MyAudioRecorder.class.getName()) + "Increasing buffer size to " + Integer.toString(this.aiE));
                }
                aja = new AudioRecord(i, i2, i3, i4, this.aiE);
                if (aja.getRecordingState() == 3) {
                    aja.stop();
                }
                if (aja.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                ajb = new MediaRecorder();
                ajb.setAudioSource(1);
                ajb.setOutputFormat(1);
                ajb.setAudioEncoder(1);
            }
            this.ajc = 0;
            this.filePath = null;
            this.ajd = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "Unknown error occured while initializing recording");
            }
            this.ajd = State.ERROR;
        }
    }

    public boolean ee(String str) {
        try {
            if (this.ajd == State.INITIALIZING) {
                this.filePath = str;
                if (!this.aiZ) {
                    ajb.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + e.getMessage());
            } else {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "Unknown error occured while setting output path");
            }
            this.ajd = State.ERROR;
            return false;
        }
    }

    public boolean prepare() {
        try {
            if (this.ajd == State.INITIALIZING) {
                if (this.aiZ) {
                    if ((this.filePath != null) & (aja.getState() == 1)) {
                        if (this.aiH != null) {
                            this.aiH.close();
                            this.aiH = null;
                        }
                        this.aiH = new RandomAccessFile(this.filePath, "rw");
                        this.aiH.setLength(0L);
                        this.aiH.writeBytes("RIFF");
                        this.aiH.writeInt(0);
                        this.aiH.writeBytes("WAVE");
                        this.aiH.writeBytes("fmt ");
                        this.aiH.writeInt(Integer.reverseBytes(16));
                        this.aiH.writeShort(Short.reverseBytes((short) 1));
                        this.aiH.writeShort(Short.reverseBytes(this.aje));
                        this.aiH.writeInt(Integer.reverseBytes(this.ajf));
                        this.aiH.writeInt(Integer.reverseBytes(((this.ajf * this.ajg) * this.aje) / 8));
                        this.aiH.writeShort(Short.reverseBytes((short) ((this.aje * this.ajg) / 8)));
                        this.aiH.writeShort(Short.reverseBytes(this.ajg));
                        this.aiH.writeBytes("data");
                        this.aiH.writeInt(0);
                        this.buffer = new byte[((this.ajj * this.ajg) / 8) * this.aje];
                        this.ajd = State.READY;
                    } else {
                        BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "prepare() method called on uninitialized recorder");
                        this.ajd = State.ERROR;
                        return false;
                    }
                } else {
                    ajb.prepare();
                    this.ajd = State.READY;
                }
                return true;
            }
            BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "prepare() method called on illegal state");
            release();
            this.ajd = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + e.getMessage());
            } else {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "Unknown error occured in prepare()");
            }
            this.ajd = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.ajd == State.RECORDING) {
            stop();
        } else {
            if ((this.ajd == State.READY) & this.aiZ) {
                try {
                    this.aiH.close();
                } catch (IOException e) {
                    BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.aiZ) {
            if (aja != null) {
                aja.release();
            }
        } else if (ajb != null) {
            ajb.release();
        }
    }

    public void start() {
        if (this.ajd == State.READY) {
            if (this.aiZ) {
                this.ajk = 0;
                aja.startRecording();
                aja.read(this.buffer, 0, this.buffer.length);
            } else {
                ajb.start();
            }
            this.ajd = State.RECORDING;
            return;
        }
        BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "start() called on illegal state");
        this.ajd = State.ERROR;
    }

    public void stop() {
        BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "audioRecorder.stop()");
        aja.stop();
        try {
            this.aiH.seek(4L);
            this.aiH.writeInt(Integer.reverseBytes(this.ajk + 36));
            this.aiH.seek(40L);
            this.aiH.writeInt(Integer.reverseBytes(this.ajk));
            this.aiH.close();
            BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "I/O exception occured while closing output file");
            this.ajd = State.ERROR;
        }
        this.ajd = State.STOPPED;
    }

    private short a(byte b, byte b2) {
        return (short) ((b2 << 8) | b);
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean ec(String str) {
        if (ee(str)) {
            return prepare();
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean wX() {
        synchronized (mLock) {
            if (this.aiY == null || !this.aiY.isAlive()) {
                this.aiY = new Thread(new g(this));
                this.aiY.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public void wY() {
        this.ajd = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean wZ() {
        return this.ajd == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wW() {
        if (aja != null) {
            try {
                start();
                while (wZ()) {
                    aja.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.aiH.write(this.buffer);
                        this.ajk += this.buffer.length;
                        if (this.ajg == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short a = a(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (a > this.ajc) {
                                    this.ajc = a;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.ajc) {
                                    this.ajc = this.buffer[i2];
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
