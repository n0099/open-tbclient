package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import android.media.MediaRecorder;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class MyAudioRecorder implements d {
    private short apA;
    private int apB;
    private short apC;
    private int apD;
    private int apE;
    private int apF;
    private int apd;
    private RandomAccessFile ape;
    private Thread apu;
    private boolean apv;
    private int apy;
    private State apz;
    private byte[] buffer;
    private String filePath;
    private int payloadSize;
    private static final int[] apt = {44100, 22050, 11025, 8000};
    private static Object mLock = new Object();
    private static AudioRecord apw = null;
    private static MediaRecorder apx = null;

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
            apw = null;
            apx = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, apt[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.xa() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, apt[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State xa() {
        return this.apz;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.apy = 0;
        this.filePath = null;
        try {
            this.apv = z;
            if (this.apv) {
                if (i4 == 2) {
                    this.apC = (short) 16;
                } else {
                    this.apC = (short) 8;
                }
                if (i3 == 2) {
                    this.apA = (short) 1;
                } else {
                    this.apA = (short) 2;
                }
                this.apD = i;
                this.apB = i2;
                this.apE = i4;
                this.apF = (i2 * 120) / 1000;
                this.apd = (((this.apF * 2) * this.apC) * this.apA) / 8;
                if (this.apd < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.apd = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.apF = this.apd / (((this.apC * 2) * this.apA) / 8);
                    BdLog.w(MyAudioRecorder.class.getName() + "Increasing buffer size to " + Integer.toString(this.apd));
                }
                apw = new AudioRecord(i, i2, i3, i4, this.apd);
                if (apw.getRecordingState() == 3) {
                    apw.stop();
                }
                if (apw.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                apx = new MediaRecorder();
                apx.setAudioSource(1);
                apx.setOutputFormat(1);
                apx.setAudioEncoder(1);
            }
            this.apy = 0;
            this.filePath = null;
            this.apz = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while initializing recording");
            }
            this.apz = State.ERROR;
        }
    }

    public boolean es(String str) {
        try {
            if (this.apz == State.INITIALIZING) {
                this.filePath = str;
                if (!this.apv) {
                    apx.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while setting output path");
            }
            this.apz = State.ERROR;
            return false;
        }
    }

    public boolean prepare() {
        try {
            if (this.apz == State.INITIALIZING) {
                if (this.apv) {
                    if ((this.filePath != null) & (apw.getState() == 1)) {
                        if (this.ape != null) {
                            this.ape.close();
                            this.ape = null;
                        }
                        this.ape = new RandomAccessFile(this.filePath, "rw");
                        this.ape.setLength(0L);
                        this.ape.writeBytes("RIFF");
                        this.ape.writeInt(0);
                        this.ape.writeBytes("WAVE");
                        this.ape.writeBytes("fmt ");
                        this.ape.writeInt(Integer.reverseBytes(16));
                        this.ape.writeShort(Short.reverseBytes((short) 1));
                        this.ape.writeShort(Short.reverseBytes(this.apA));
                        this.ape.writeInt(Integer.reverseBytes(this.apB));
                        this.ape.writeInt(Integer.reverseBytes(((this.apB * this.apC) * this.apA) / 8));
                        this.ape.writeShort(Short.reverseBytes((short) ((this.apA * this.apC) / 8)));
                        this.ape.writeShort(Short.reverseBytes(this.apC));
                        this.ape.writeBytes("data");
                        this.ape.writeInt(0);
                        this.buffer = new byte[((this.apF * this.apC) / 8) * this.apA];
                        this.apz = State.READY;
                    } else {
                        BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on uninitialized recorder");
                        this.apz = State.ERROR;
                        return false;
                    }
                } else {
                    apx.prepare();
                    this.apz = State.READY;
                }
                return true;
            }
            BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on illegal state");
            release();
            this.apz = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured in prepare()");
            }
            this.apz = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.apz == State.RECORDING) {
            stop();
        } else {
            if ((this.apz == State.READY) & this.apv) {
                try {
                    this.ape.close();
                } catch (IOException e) {
                    BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.apv) {
            if (apw != null) {
                apw.release();
            }
        } else if (apx != null) {
            apx.release();
        }
    }

    public void start() {
        if (this.apz == State.READY) {
            if (this.apv) {
                this.payloadSize = 0;
                apw.startRecording();
                apw.read(this.buffer, 0, this.buffer.length);
            } else {
                apx.start();
            }
            this.apz = State.RECORDING;
            return;
        }
        BdLog.e(MyAudioRecorder.class.getName() + "start() called on illegal state");
        this.apz = State.ERROR;
    }

    public void stop() {
        BdLog.e(MyAudioRecorder.class.getName() + "audioRecorder.stop()");
        apw.stop();
        try {
            this.ape.seek(4L);
            this.ape.writeInt(Integer.reverseBytes(this.payloadSize + 36));
            this.ape.seek(40L);
            this.ape.writeInt(Integer.reverseBytes(this.payloadSize));
            this.ape.close();
            BdLog.e(MyAudioRecorder.class.getName() + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
            this.apz = State.ERROR;
        }
        this.apz = State.STOPPED;
    }

    private short b(byte b, byte b2) {
        return (short) ((b2 << 8) | b);
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean eq(String str) {
        if (es(str)) {
            return prepare();
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean wW() {
        synchronized (mLock) {
            if (this.apu == null || !this.apu.isAlive()) {
                this.apu = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.MyAudioRecorder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MyAudioRecorder.this.wV();
                    }
                });
                this.apu.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void wX() {
        this.apz = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean isRecording() {
        return this.apz == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wV() {
        if (apw != null) {
            try {
                start();
                while (isRecording()) {
                    apw.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.ape.write(this.buffer);
                        this.payloadSize += this.buffer.length;
                        if (this.apC == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short b = b(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (b > this.apy) {
                                    this.apy = b;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.apy) {
                                    this.apy = this.buffer[i2];
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
