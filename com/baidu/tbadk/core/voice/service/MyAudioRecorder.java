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
    private int aiJ;
    private RandomAccessFile aiM;
    private Thread ajd;
    private boolean aje;
    private int ajh;
    private State aji;
    private short ajj;
    private int ajk;
    private short ajl;
    private int ajm;
    private int ajn;
    private int ajo;
    private int ajp;
    private byte[] buffer;
    private String filePath;
    private static final int[] ajc = {44100, 22050, 11025, 8000};
    private static Object mLock = new Object();
    private static AudioRecord ajf = null;
    private static MediaRecorder ajg = null;

    /* loaded from: classes.dex */
    public enum State {
        INITIALIZING,
        READY,
        RECORDING,
        ERROR,
        STOPPED;

        /* JADX DEBUG: Replace access to removed values field (ajr) with 'values()' method */
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
            ajf = null;
            ajg = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, ajc[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.xi() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, ajc[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State xi() {
        return this.aji;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.ajh = 0;
        this.filePath = null;
        try {
            this.aje = z;
            if (this.aje) {
                if (i4 == 2) {
                    this.ajl = (short) 16;
                } else {
                    this.ajl = (short) 8;
                }
                if (i3 == 2) {
                    this.ajj = (short) 1;
                } else {
                    this.ajj = (short) 2;
                }
                this.ajm = i;
                this.ajk = i2;
                this.ajn = i4;
                this.ajo = (i2 * SocialAPIErrorCodes.ERROR_INVALID_AUTHORIZED_CODE) / 1000;
                this.aiJ = (((this.ajo * 2) * this.ajl) * this.ajj) / 8;
                if (this.aiJ < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.aiJ = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.ajo = this.aiJ / (((this.ajl * 2) * this.ajj) / 8);
                    BdLog.w(String.valueOf(MyAudioRecorder.class.getName()) + "Increasing buffer size to " + Integer.toString(this.aiJ));
                }
                ajf = new AudioRecord(i, i2, i3, i4, this.aiJ);
                if (ajf.getRecordingState() == 3) {
                    ajf.stop();
                }
                if (ajf.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                ajg = new MediaRecorder();
                ajg.setAudioSource(1);
                ajg.setOutputFormat(1);
                ajg.setAudioEncoder(1);
            }
            this.ajh = 0;
            this.filePath = null;
            this.aji = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "Unknown error occured while initializing recording");
            }
            this.aji = State.ERROR;
        }
    }

    public boolean ec(String str) {
        try {
            if (this.aji == State.INITIALIZING) {
                this.filePath = str;
                if (!this.aje) {
                    ajg.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + e.getMessage());
            } else {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "Unknown error occured while setting output path");
            }
            this.aji = State.ERROR;
            return false;
        }
    }

    public boolean prepare() {
        try {
            if (this.aji == State.INITIALIZING) {
                if (this.aje) {
                    if ((this.filePath != null) & (ajf.getState() == 1)) {
                        if (this.aiM != null) {
                            this.aiM.close();
                            this.aiM = null;
                        }
                        this.aiM = new RandomAccessFile(this.filePath, "rw");
                        this.aiM.setLength(0L);
                        this.aiM.writeBytes("RIFF");
                        this.aiM.writeInt(0);
                        this.aiM.writeBytes("WAVE");
                        this.aiM.writeBytes("fmt ");
                        this.aiM.writeInt(Integer.reverseBytes(16));
                        this.aiM.writeShort(Short.reverseBytes((short) 1));
                        this.aiM.writeShort(Short.reverseBytes(this.ajj));
                        this.aiM.writeInt(Integer.reverseBytes(this.ajk));
                        this.aiM.writeInt(Integer.reverseBytes(((this.ajk * this.ajl) * this.ajj) / 8));
                        this.aiM.writeShort(Short.reverseBytes((short) ((this.ajj * this.ajl) / 8)));
                        this.aiM.writeShort(Short.reverseBytes(this.ajl));
                        this.aiM.writeBytes("data");
                        this.aiM.writeInt(0);
                        this.buffer = new byte[((this.ajo * this.ajl) / 8) * this.ajj];
                        this.aji = State.READY;
                    } else {
                        BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "prepare() method called on uninitialized recorder");
                        this.aji = State.ERROR;
                        return false;
                    }
                } else {
                    ajg.prepare();
                    this.aji = State.READY;
                }
                return true;
            }
            BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "prepare() method called on illegal state");
            release();
            this.aji = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + e.getMessage());
            } else {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "Unknown error occured in prepare()");
            }
            this.aji = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.aji == State.RECORDING) {
            stop();
        } else {
            if ((this.aji == State.READY) & this.aje) {
                try {
                    this.aiM.close();
                } catch (IOException e) {
                    BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.aje) {
            if (ajf != null) {
                ajf.release();
            }
        } else if (ajg != null) {
            ajg.release();
        }
    }

    public void start() {
        if (this.aji == State.READY) {
            if (this.aje) {
                this.ajp = 0;
                ajf.startRecording();
                ajf.read(this.buffer, 0, this.buffer.length);
            } else {
                ajg.start();
            }
            this.aji = State.RECORDING;
            return;
        }
        BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "start() called on illegal state");
        this.aji = State.ERROR;
    }

    public void stop() {
        BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "audioRecorder.stop()");
        ajf.stop();
        try {
            this.aiM.seek(4L);
            this.aiM.writeInt(Integer.reverseBytes(this.ajp + 36));
            this.aiM.seek(40L);
            this.aiM.writeInt(Integer.reverseBytes(this.ajp));
            this.aiM.close();
            BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "I/O exception occured while closing output file");
            this.aji = State.ERROR;
        }
        this.aji = State.STOPPED;
    }

    private short a(byte b, byte b2) {
        return (short) ((b2 << 8) | b);
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean ea(String str) {
        if (ec(str)) {
            return prepare();
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean xd() {
        synchronized (mLock) {
            if (this.ajd == null || !this.ajd.isAlive()) {
                this.ajd = new Thread(new g(this));
                this.ajd.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public void xe() {
        this.aji = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean xf() {
        return this.aji == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xc() {
        if (ajf != null) {
            try {
                start();
                while (xf()) {
                    ajf.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.aiM.write(this.buffer);
                        this.ajp += this.buffer.length;
                        if (this.ajl == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short a = a(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (a > this.ajh) {
                                    this.ajh = a;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.ajh) {
                                    this.ajh = this.buffer[i2];
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
