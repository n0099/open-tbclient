package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import android.media.MediaRecorder;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class MyAudioRecorder implements d {
    private int apT;
    private RandomAccessFile apU;
    private Thread aqj;
    private boolean aqk;
    private int aqn;
    private State aqo;
    private short aqp;
    private int aqq;
    private short aqr;
    private int aqs;
    private int aqt;
    private int aqu;
    private byte[] buffer;
    private String filePath;
    private int payloadSize;
    private static final int[] aqi = {44100, 22050, 11025, 8000};
    private static Object mLock = new Object();
    private static AudioRecord aql = null;
    private static MediaRecorder aqm = null;

    /* loaded from: classes.dex */
    public enum State {
        INITIALIZING,
        READY,
        RECORDING,
        ERROR,
        STOPPED
    }

    public static MyAudioRecorder b(Boolean bool) {
        MyAudioRecorder myAudioRecorder;
        synchronized (mLock) {
            aql = null;
            aqm = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, aqi[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.xh() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, aqi[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State xh() {
        return this.aqo;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.aqn = 0;
        this.filePath = null;
        try {
            this.aqk = z;
            if (this.aqk) {
                if (i4 == 2) {
                    this.aqr = (short) 16;
                } else {
                    this.aqr = (short) 8;
                }
                if (i3 == 2) {
                    this.aqp = (short) 1;
                } else {
                    this.aqp = (short) 2;
                }
                this.aqs = i;
                this.aqq = i2;
                this.aqt = i4;
                this.aqu = (i2 * 120) / 1000;
                this.apT = (((this.aqu * 2) * this.aqr) * this.aqp) / 8;
                if (this.apT < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.apT = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.aqu = this.apT / (((this.aqr * 2) * this.aqp) / 8);
                    BdLog.w(MyAudioRecorder.class.getName() + "Increasing buffer size to " + Integer.toString(this.apT));
                }
                aql = new AudioRecord(i, i2, i3, i4, this.apT);
                if (aql.getRecordingState() == 3) {
                    aql.stop();
                }
                if (aql.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                aqm = new MediaRecorder();
                aqm.setAudioSource(1);
                aqm.setOutputFormat(1);
                aqm.setAudioEncoder(1);
            }
            this.aqn = 0;
            this.filePath = null;
            this.aqo = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while initializing recording");
            }
            this.aqo = State.ERROR;
        }
    }

    public boolean eE(String str) {
        try {
            if (this.aqo == State.INITIALIZING) {
                this.filePath = str;
                if (!this.aqk) {
                    aqm.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while setting output path");
            }
            this.aqo = State.ERROR;
            return false;
        }
    }

    public boolean prepare() {
        try {
            if (this.aqo == State.INITIALIZING) {
                if (this.aqk) {
                    if ((this.filePath != null) & (aql.getState() == 1)) {
                        if (this.apU != null) {
                            this.apU.close();
                            this.apU = null;
                        }
                        this.apU = new RandomAccessFile(this.filePath, "rw");
                        this.apU.setLength(0L);
                        this.apU.writeBytes("RIFF");
                        this.apU.writeInt(0);
                        this.apU.writeBytes("WAVE");
                        this.apU.writeBytes("fmt ");
                        this.apU.writeInt(Integer.reverseBytes(16));
                        this.apU.writeShort(Short.reverseBytes((short) 1));
                        this.apU.writeShort(Short.reverseBytes(this.aqp));
                        this.apU.writeInt(Integer.reverseBytes(this.aqq));
                        this.apU.writeInt(Integer.reverseBytes(((this.aqq * this.aqr) * this.aqp) / 8));
                        this.apU.writeShort(Short.reverseBytes((short) ((this.aqp * this.aqr) / 8)));
                        this.apU.writeShort(Short.reverseBytes(this.aqr));
                        this.apU.writeBytes("data");
                        this.apU.writeInt(0);
                        this.buffer = new byte[((this.aqu * this.aqr) / 8) * this.aqp];
                        this.aqo = State.READY;
                    } else {
                        BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on uninitialized recorder");
                        this.aqo = State.ERROR;
                        return false;
                    }
                } else {
                    aqm.prepare();
                    this.aqo = State.READY;
                }
                return true;
            }
            BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on illegal state");
            release();
            this.aqo = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured in prepare()");
            }
            this.aqo = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.aqo == State.RECORDING) {
            stop();
        } else {
            if ((this.aqo == State.READY) & this.aqk) {
                try {
                    this.apU.close();
                } catch (IOException e) {
                    BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.aqk) {
            if (aql != null) {
                aql.release();
            }
        } else if (aqm != null) {
            aqm.release();
        }
    }

    public void start() {
        if (this.aqo == State.READY) {
            if (this.aqk) {
                this.payloadSize = 0;
                aql.startRecording();
                aql.read(this.buffer, 0, this.buffer.length);
            } else {
                aqm.start();
            }
            this.aqo = State.RECORDING;
            return;
        }
        BdLog.e(MyAudioRecorder.class.getName() + "start() called on illegal state");
        this.aqo = State.ERROR;
    }

    public void stop() {
        BdLog.e(MyAudioRecorder.class.getName() + "audioRecorder.stop()");
        aql.stop();
        try {
            this.apU.seek(4L);
            this.apU.writeInt(Integer.reverseBytes(this.payloadSize + 36));
            this.apU.seek(40L);
            this.apU.writeInt(Integer.reverseBytes(this.payloadSize));
            this.apU.close();
            BdLog.e(MyAudioRecorder.class.getName() + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
            this.aqo = State.ERROR;
        }
        this.aqo = State.STOPPED;
    }

    private short b(byte b, byte b2) {
        return (short) ((b2 << 8) | b);
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean eC(String str) {
        if (eE(str)) {
            return prepare();
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean xd() {
        synchronized (mLock) {
            if (this.aqj == null || !this.aqj.isAlive()) {
                this.aqj = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.MyAudioRecorder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MyAudioRecorder.this.xc();
                    }
                });
                this.aqj.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void xe() {
        this.aqo = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean isRecording() {
        return this.aqo == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xc() {
        if (aql != null) {
            try {
                start();
                while (isRecording()) {
                    aql.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.apU.write(this.buffer);
                        this.payloadSize += this.buffer.length;
                        if (this.aqr == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short b = b(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (b > this.aqn) {
                                    this.aqn = b;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.aqn) {
                                    this.aqn = this.buffer[i2];
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
