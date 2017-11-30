package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import android.media.MediaRecorder;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class MyAudioRecorder implements d {
    private int apQ;
    private RandomAccessFile apR;
    private Thread aqg;
    private boolean aqh;
    private int aqk;
    private State aql;
    private short aqm;
    private int aqn;
    private short aqo;
    private int aqp;
    private int aqq;
    private int aqr;
    private byte[] buffer;
    private String filePath;
    private int payloadSize;
    private static final int[] aqf = {44100, 22050, 11025, 8000};
    private static Object mLock = new Object();
    private static AudioRecord aqi = null;
    private static MediaRecorder aqj = null;

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
            aqi = null;
            aqj = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, aqf[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.xi() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, aqf[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State xi() {
        return this.aql;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.aqk = 0;
        this.filePath = null;
        try {
            this.aqh = z;
            if (this.aqh) {
                if (i4 == 2) {
                    this.aqo = (short) 16;
                } else {
                    this.aqo = (short) 8;
                }
                if (i3 == 2) {
                    this.aqm = (short) 1;
                } else {
                    this.aqm = (short) 2;
                }
                this.aqp = i;
                this.aqn = i2;
                this.aqq = i4;
                this.aqr = (i2 * 120) / 1000;
                this.apQ = (((this.aqr * 2) * this.aqo) * this.aqm) / 8;
                if (this.apQ < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.apQ = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.aqr = this.apQ / (((this.aqo * 2) * this.aqm) / 8);
                    BdLog.w(MyAudioRecorder.class.getName() + "Increasing buffer size to " + Integer.toString(this.apQ));
                }
                aqi = new AudioRecord(i, i2, i3, i4, this.apQ);
                if (aqi.getRecordingState() == 3) {
                    aqi.stop();
                }
                if (aqi.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                aqj = new MediaRecorder();
                aqj.setAudioSource(1);
                aqj.setOutputFormat(1);
                aqj.setAudioEncoder(1);
            }
            this.aqk = 0;
            this.filePath = null;
            this.aql = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while initializing recording");
            }
            this.aql = State.ERROR;
        }
    }

    public boolean eE(String str) {
        try {
            if (this.aql == State.INITIALIZING) {
                this.filePath = str;
                if (!this.aqh) {
                    aqj.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while setting output path");
            }
            this.aql = State.ERROR;
            return false;
        }
    }

    public boolean prepare() {
        try {
            if (this.aql == State.INITIALIZING) {
                if (this.aqh) {
                    if ((this.filePath != null) & (aqi.getState() == 1)) {
                        if (this.apR != null) {
                            this.apR.close();
                            this.apR = null;
                        }
                        this.apR = new RandomAccessFile(this.filePath, "rw");
                        this.apR.setLength(0L);
                        this.apR.writeBytes("RIFF");
                        this.apR.writeInt(0);
                        this.apR.writeBytes("WAVE");
                        this.apR.writeBytes("fmt ");
                        this.apR.writeInt(Integer.reverseBytes(16));
                        this.apR.writeShort(Short.reverseBytes((short) 1));
                        this.apR.writeShort(Short.reverseBytes(this.aqm));
                        this.apR.writeInt(Integer.reverseBytes(this.aqn));
                        this.apR.writeInt(Integer.reverseBytes(((this.aqn * this.aqo) * this.aqm) / 8));
                        this.apR.writeShort(Short.reverseBytes((short) ((this.aqm * this.aqo) / 8)));
                        this.apR.writeShort(Short.reverseBytes(this.aqo));
                        this.apR.writeBytes("data");
                        this.apR.writeInt(0);
                        this.buffer = new byte[((this.aqr * this.aqo) / 8) * this.aqm];
                        this.aql = State.READY;
                    } else {
                        BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on uninitialized recorder");
                        this.aql = State.ERROR;
                        return false;
                    }
                } else {
                    aqj.prepare();
                    this.aql = State.READY;
                }
                return true;
            }
            BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on illegal state");
            release();
            this.aql = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured in prepare()");
            }
            this.aql = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.aql == State.RECORDING) {
            stop();
        } else {
            if ((this.aql == State.READY) & this.aqh) {
                try {
                    this.apR.close();
                } catch (IOException e) {
                    BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.aqh) {
            if (aqi != null) {
                aqi.release();
            }
        } else if (aqj != null) {
            aqj.release();
        }
    }

    public void start() {
        if (this.aql == State.READY) {
            if (this.aqh) {
                this.payloadSize = 0;
                aqi.startRecording();
                aqi.read(this.buffer, 0, this.buffer.length);
            } else {
                aqj.start();
            }
            this.aql = State.RECORDING;
            return;
        }
        BdLog.e(MyAudioRecorder.class.getName() + "start() called on illegal state");
        this.aql = State.ERROR;
    }

    public void stop() {
        BdLog.e(MyAudioRecorder.class.getName() + "audioRecorder.stop()");
        aqi.stop();
        try {
            this.apR.seek(4L);
            this.apR.writeInt(Integer.reverseBytes(this.payloadSize + 36));
            this.apR.seek(40L);
            this.apR.writeInt(Integer.reverseBytes(this.payloadSize));
            this.apR.close();
            BdLog.e(MyAudioRecorder.class.getName() + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
            this.aql = State.ERROR;
        }
        this.aql = State.STOPPED;
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
    public boolean xe() {
        synchronized (mLock) {
            if (this.aqg == null || !this.aqg.isAlive()) {
                this.aqg = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.MyAudioRecorder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MyAudioRecorder.this.xd();
                    }
                });
                this.aqg.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void xf() {
        this.aql = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean isRecording() {
        return this.aql == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xd() {
        if (aqi != null) {
            try {
                start();
                while (isRecording()) {
                    aqi.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.apR.write(this.buffer);
                        this.payloadSize += this.buffer.length;
                        if (this.aqo == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short b = b(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (b > this.aqk) {
                                    this.aqk = b;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.aqk) {
                                    this.aqk = this.buffer[i2];
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
