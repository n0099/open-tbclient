package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import android.media.MediaRecorder;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class MyAudioRecorder implements d {
    private boolean beA;
    private int beD;
    private State beE;
    private short beF;
    private int beG;
    private short beH;
    private int beI;
    private int beJ;
    private int beK;
    private int bei;
    private RandomAccessFile bej;
    private Thread bez;
    private byte[] buffer;
    private String filePath;
    private int payloadSize;
    private static final int[] bey = {44100, 22050, 11025, 8000};
    private static Object mLock = new Object();
    private static AudioRecord beB = null;
    private static MediaRecorder beC = null;

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
            beB = null;
            beC = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, bey[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.Ez() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, bey[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State Ez() {
        return this.beE;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.beD = 0;
        this.filePath = null;
        try {
            this.beA = z;
            if (this.beA) {
                if (i4 == 2) {
                    this.beH = (short) 16;
                } else {
                    this.beH = (short) 8;
                }
                if (i3 == 2) {
                    this.beF = (short) 1;
                } else {
                    this.beF = (short) 2;
                }
                this.beI = i;
                this.beG = i2;
                this.beJ = i4;
                this.beK = (i2 * 120) / 1000;
                this.bei = (((this.beK * 2) * this.beH) * this.beF) / 8;
                if (this.bei < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.bei = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.beK = this.bei / (((this.beH * 2) * this.beF) / 8);
                    BdLog.w(MyAudioRecorder.class.getName() + "Increasing buffer size to " + Integer.toString(this.bei));
                }
                beB = new AudioRecord(i, i2, i3, i4, this.bei);
                if (beB.getRecordingState() == 3) {
                    beB.stop();
                }
                if (beB.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                beC = new MediaRecorder();
                beC.setAudioSource(1);
                beC.setOutputFormat(1);
                beC.setAudioEncoder(1);
            }
            this.beD = 0;
            this.filePath = null;
            this.beE = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while initializing recording");
            }
            this.beE = State.ERROR;
        }
    }

    public boolean eT(String str) {
        try {
            if (this.beE == State.INITIALIZING) {
                this.filePath = str;
                if (!this.beA) {
                    beC.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while setting output path");
            }
            this.beE = State.ERROR;
            return false;
        }
    }

    public boolean prepare() {
        try {
            if (this.beE == State.INITIALIZING) {
                if (this.beA) {
                    if ((this.filePath != null) & (beB.getState() == 1)) {
                        if (this.bej != null) {
                            this.bej.close();
                            this.bej = null;
                        }
                        this.bej = new RandomAccessFile(this.filePath, "rw");
                        this.bej.setLength(0L);
                        this.bej.writeBytes("RIFF");
                        this.bej.writeInt(0);
                        this.bej.writeBytes("WAVE");
                        this.bej.writeBytes("fmt ");
                        this.bej.writeInt(Integer.reverseBytes(16));
                        this.bej.writeShort(Short.reverseBytes((short) 1));
                        this.bej.writeShort(Short.reverseBytes(this.beF));
                        this.bej.writeInt(Integer.reverseBytes(this.beG));
                        this.bej.writeInt(Integer.reverseBytes(((this.beG * this.beH) * this.beF) / 8));
                        this.bej.writeShort(Short.reverseBytes((short) ((this.beF * this.beH) / 8)));
                        this.bej.writeShort(Short.reverseBytes(this.beH));
                        this.bej.writeBytes("data");
                        this.bej.writeInt(0);
                        this.buffer = new byte[((this.beK * this.beH) / 8) * this.beF];
                        this.beE = State.READY;
                    } else {
                        BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on uninitialized recorder");
                        this.beE = State.ERROR;
                        return false;
                    }
                } else {
                    beC.prepare();
                    this.beE = State.READY;
                }
                return true;
            }
            BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on illegal state");
            release();
            this.beE = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured in prepare()");
            }
            this.beE = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.beE == State.RECORDING) {
            stop();
        } else {
            if ((this.beE == State.READY) & this.beA) {
                try {
                    this.bej.close();
                } catch (IOException e) {
                    BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.beA) {
            if (beB != null) {
                beB.release();
            }
        } else if (beC != null) {
            beC.release();
        }
    }

    public void start() {
        if (this.beE == State.READY) {
            if (this.beA) {
                this.payloadSize = 0;
                beB.startRecording();
                beB.read(this.buffer, 0, this.buffer.length);
            } else {
                beC.start();
            }
            this.beE = State.RECORDING;
            return;
        }
        BdLog.e(MyAudioRecorder.class.getName() + "start() called on illegal state");
        this.beE = State.ERROR;
    }

    public void stop() {
        BdLog.e(MyAudioRecorder.class.getName() + "audioRecorder.stop()");
        beB.stop();
        try {
            this.bej.seek(4L);
            this.bej.writeInt(Integer.reverseBytes(this.payloadSize + 36));
            this.bej.seek(40L);
            this.bej.writeInt(Integer.reverseBytes(this.payloadSize));
            this.bej.close();
            BdLog.e(MyAudioRecorder.class.getName() + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
            this.beE = State.ERROR;
        }
        this.beE = State.STOPPED;
    }

    private short b(byte b, byte b2) {
        return (short) ((b2 << 8) | b);
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean eR(String str) {
        if (eT(str)) {
            return prepare();
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean Ev() {
        synchronized (mLock) {
            if (this.bez == null || !this.bez.isAlive()) {
                this.bez = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.MyAudioRecorder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MyAudioRecorder.this.Eu();
                    }
                });
                this.bez.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void Ew() {
        this.beE = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean isRecording() {
        return this.beE == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Eu() {
        if (beB != null) {
            try {
                start();
                while (isRecording()) {
                    beB.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.bej.write(this.buffer);
                        this.payloadSize += this.buffer.length;
                        if (this.beH == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short b = b(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (b > this.beD) {
                                    this.beD = b;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.beD) {
                                    this.beD = this.buffer[i2];
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
