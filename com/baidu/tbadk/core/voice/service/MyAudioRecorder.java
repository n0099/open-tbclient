package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import android.media.MediaRecorder;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class MyAudioRecorder implements d {
    private int bfP;
    private RandomAccessFile bfQ;
    private Thread bgf;
    private boolean bgg;
    private int bgj;
    private State bgk;
    private short bgl;
    private int bgm;
    private short bgn;
    private int bgo;
    private int bgp;
    private int bgq;
    private byte[] buffer;
    private String filePath;
    private int payloadSize;
    private static final int[] bge = {44100, 22050, 11025, 8000};
    private static Object mLock = new Object();
    private static AudioRecord bgh = null;
    private static MediaRecorder bgi = null;

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
            bgh = null;
            bgi = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, bge[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.ET() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, bge[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State ET() {
        return this.bgk;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.bgj = 0;
        this.filePath = null;
        try {
            this.bgg = z;
            if (this.bgg) {
                if (i4 == 2) {
                    this.bgn = (short) 16;
                } else {
                    this.bgn = (short) 8;
                }
                if (i3 == 2) {
                    this.bgl = (short) 1;
                } else {
                    this.bgl = (short) 2;
                }
                this.bgo = i;
                this.bgm = i2;
                this.bgp = i4;
                this.bgq = (i2 * 120) / 1000;
                this.bfP = (((this.bgq * 2) * this.bgn) * this.bgl) / 8;
                if (this.bfP < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.bfP = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.bgq = this.bfP / (((this.bgn * 2) * this.bgl) / 8);
                    BdLog.w(MyAudioRecorder.class.getName() + "Increasing buffer size to " + Integer.toString(this.bfP));
                }
                bgh = new AudioRecord(i, i2, i3, i4, this.bfP);
                if (bgh.getRecordingState() == 3) {
                    bgh.stop();
                }
                if (bgh.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                bgi = new MediaRecorder();
                bgi.setAudioSource(1);
                bgi.setOutputFormat(1);
                bgi.setAudioEncoder(1);
            }
            this.bgj = 0;
            this.filePath = null;
            this.bgk = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while initializing recording");
            }
            this.bgk = State.ERROR;
        }
    }

    public boolean fe(String str) {
        try {
            if (this.bgk == State.INITIALIZING) {
                this.filePath = str;
                if (!this.bgg) {
                    bgi.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while setting output path");
            }
            this.bgk = State.ERROR;
            return false;
        }
    }

    public boolean prepare() {
        try {
            if (this.bgk == State.INITIALIZING) {
                if (this.bgg) {
                    if ((this.filePath != null) & (bgh.getState() == 1)) {
                        if (this.bfQ != null) {
                            this.bfQ.close();
                            this.bfQ = null;
                        }
                        this.bfQ = new RandomAccessFile(this.filePath, "rw");
                        this.bfQ.setLength(0L);
                        this.bfQ.writeBytes("RIFF");
                        this.bfQ.writeInt(0);
                        this.bfQ.writeBytes("WAVE");
                        this.bfQ.writeBytes("fmt ");
                        this.bfQ.writeInt(Integer.reverseBytes(16));
                        this.bfQ.writeShort(Short.reverseBytes((short) 1));
                        this.bfQ.writeShort(Short.reverseBytes(this.bgl));
                        this.bfQ.writeInt(Integer.reverseBytes(this.bgm));
                        this.bfQ.writeInt(Integer.reverseBytes(((this.bgm * this.bgn) * this.bgl) / 8));
                        this.bfQ.writeShort(Short.reverseBytes((short) ((this.bgl * this.bgn) / 8)));
                        this.bfQ.writeShort(Short.reverseBytes(this.bgn));
                        this.bfQ.writeBytes("data");
                        this.bfQ.writeInt(0);
                        this.buffer = new byte[((this.bgq * this.bgn) / 8) * this.bgl];
                        this.bgk = State.READY;
                    } else {
                        BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on uninitialized recorder");
                        this.bgk = State.ERROR;
                        return false;
                    }
                } else {
                    bgi.prepare();
                    this.bgk = State.READY;
                }
                return true;
            }
            BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on illegal state");
            release();
            this.bgk = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured in prepare()");
            }
            this.bgk = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.bgk == State.RECORDING) {
            stop();
        } else {
            if ((this.bgk == State.READY) & this.bgg) {
                try {
                    this.bfQ.close();
                } catch (IOException e) {
                    BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.bgg) {
            if (bgh != null) {
                bgh.release();
            }
        } else if (bgi != null) {
            bgi.release();
        }
    }

    public void start() {
        if (this.bgk == State.READY) {
            if (this.bgg) {
                this.payloadSize = 0;
                bgh.startRecording();
                bgh.read(this.buffer, 0, this.buffer.length);
            } else {
                bgi.start();
            }
            this.bgk = State.RECORDING;
            return;
        }
        BdLog.e(MyAudioRecorder.class.getName() + "start() called on illegal state");
        this.bgk = State.ERROR;
    }

    public void stop() {
        BdLog.e(MyAudioRecorder.class.getName() + "audioRecorder.stop()");
        bgh.stop();
        try {
            this.bfQ.seek(4L);
            this.bfQ.writeInt(Integer.reverseBytes(this.payloadSize + 36));
            this.bfQ.seek(40L);
            this.bfQ.writeInt(Integer.reverseBytes(this.payloadSize));
            this.bfQ.close();
            BdLog.e(MyAudioRecorder.class.getName() + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
            this.bgk = State.ERROR;
        }
        this.bgk = State.STOPPED;
    }

    private short b(byte b, byte b2) {
        return (short) ((b2 << 8) | b);
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean fc(String str) {
        if (fe(str)) {
            return prepare();
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean EP() {
        synchronized (mLock) {
            if (this.bgf == null || !this.bgf.isAlive()) {
                this.bgf = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.MyAudioRecorder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MyAudioRecorder.this.EO();
                    }
                });
                this.bgf.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void EQ() {
        this.bgk = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean isRecording() {
        return this.bgk == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EO() {
        if (bgh != null) {
            try {
                start();
                while (isRecording()) {
                    bgh.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.bfQ.write(this.buffer);
                        this.payloadSize += this.buffer.length;
                        if (this.bgn == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short b = b(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (b > this.bgj) {
                                    this.bgj = b;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.bgj) {
                                    this.bgj = this.buffer[i2];
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
