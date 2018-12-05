package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import android.media.MediaRecorder;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class MyAudioRecorder implements d {
    private boolean aMC;
    private int aMF;
    private State aMG;
    private short aMH;
    private int aMI;
    private short aMJ;
    private int aMK;
    private int aML;
    private int aMM;
    private RandomAccessFile aMn;
    private byte[] buffer;
    private int bufferSize;
    private String filePath;
    private int payloadSize;
    private Thread writeThread;
    private static final int[] aMB = {44100, 22050, 11025, 8000};
    private static Object mLock = new Object();
    private static AudioRecord aMD = null;
    private static MediaRecorder aME = null;

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
            aMD = null;
            aME = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, aMB[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.FT() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, aMB[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State FT() {
        return this.aMG;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.aMF = 0;
        this.filePath = null;
        try {
            this.aMC = z;
            if (this.aMC) {
                if (i4 == 2) {
                    this.aMJ = (short) 16;
                } else {
                    this.aMJ = (short) 8;
                }
                if (i3 == 2) {
                    this.aMH = (short) 1;
                } else {
                    this.aMH = (short) 2;
                }
                this.aMK = i;
                this.aMI = i2;
                this.aML = i4;
                this.aMM = (i2 * 120) / 1000;
                this.bufferSize = (((this.aMM * 2) * this.aMJ) * this.aMH) / 8;
                if (this.bufferSize < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.aMM = this.bufferSize / (((this.aMJ * 2) * this.aMH) / 8);
                    BdLog.w(MyAudioRecorder.class.getName() + "Increasing buffer size to " + Integer.toString(this.bufferSize));
                }
                aMD = new AudioRecord(i, i2, i3, i4, this.bufferSize);
                if (aMD.getRecordingState() == 3) {
                    aMD.stop();
                }
                if (aMD.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                aME = new MediaRecorder();
                aME.setAudioSource(1);
                aME.setOutputFormat(1);
                aME.setAudioEncoder(1);
            }
            this.aMF = 0;
            this.filePath = null;
            this.aMG = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while initializing recording");
            }
            this.aMG = State.ERROR;
        }
    }

    public boolean gz(String str) {
        try {
            if (this.aMG == State.INITIALIZING) {
                this.filePath = str;
                if (!this.aMC) {
                    aME.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while setting output path");
            }
            this.aMG = State.ERROR;
            return false;
        }
    }

    public boolean prepare() {
        try {
            if (this.aMG == State.INITIALIZING) {
                if (this.aMC) {
                    if ((this.filePath != null) & (aMD.getState() == 1)) {
                        if (this.aMn != null) {
                            this.aMn.close();
                            this.aMn = null;
                        }
                        this.aMn = new RandomAccessFile(this.filePath, "rw");
                        this.aMn.setLength(0L);
                        this.aMn.writeBytes("RIFF");
                        this.aMn.writeInt(0);
                        this.aMn.writeBytes("WAVE");
                        this.aMn.writeBytes("fmt ");
                        this.aMn.writeInt(Integer.reverseBytes(16));
                        this.aMn.writeShort(Short.reverseBytes((short) 1));
                        this.aMn.writeShort(Short.reverseBytes(this.aMH));
                        this.aMn.writeInt(Integer.reverseBytes(this.aMI));
                        this.aMn.writeInt(Integer.reverseBytes(((this.aMI * this.aMJ) * this.aMH) / 8));
                        this.aMn.writeShort(Short.reverseBytes((short) ((this.aMH * this.aMJ) / 8)));
                        this.aMn.writeShort(Short.reverseBytes(this.aMJ));
                        this.aMn.writeBytes("data");
                        this.aMn.writeInt(0);
                        this.buffer = new byte[((this.aMM * this.aMJ) / 8) * this.aMH];
                        this.aMG = State.READY;
                    } else {
                        BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on uninitialized recorder");
                        this.aMG = State.ERROR;
                        return false;
                    }
                } else {
                    aME.prepare();
                    this.aMG = State.READY;
                }
                return true;
            }
            BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on illegal state");
            release();
            this.aMG = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured in prepare()");
            }
            this.aMG = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.aMG == State.RECORDING) {
            stop();
        } else {
            if ((this.aMG == State.READY) & this.aMC) {
                try {
                    this.aMn.close();
                } catch (IOException e) {
                    BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.aMC) {
            if (aMD != null) {
                aMD.release();
            }
        } else if (aME != null) {
            aME.release();
        }
    }

    public void start() {
        if (this.aMG == State.READY) {
            if (this.aMC) {
                this.payloadSize = 0;
                aMD.startRecording();
                aMD.read(this.buffer, 0, this.buffer.length);
            } else {
                aME.start();
            }
            this.aMG = State.RECORDING;
            return;
        }
        BdLog.e(MyAudioRecorder.class.getName() + "start() called on illegal state");
        this.aMG = State.ERROR;
    }

    public void stop() {
        BdLog.e(MyAudioRecorder.class.getName() + "audioRecorder.stop()");
        aMD.stop();
        try {
            this.aMn.seek(4L);
            this.aMn.writeInt(Integer.reverseBytes(this.payloadSize + 36));
            this.aMn.seek(40L);
            this.aMn.writeInt(Integer.reverseBytes(this.payloadSize));
            this.aMn.close();
            BdLog.e(MyAudioRecorder.class.getName() + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
            this.aMG = State.ERROR;
        }
        this.aMG = State.STOPPED;
    }

    private short b(byte b, byte b2) {
        return (short) ((b2 << 8) | b);
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean gx(String str) {
        if (gz(str)) {
            return prepare();
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean FP() {
        synchronized (mLock) {
            if (this.writeThread == null || !this.writeThread.isAlive()) {
                this.writeThread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.MyAudioRecorder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MyAudioRecorder.this.FO();
                    }
                });
                this.writeThread.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void FQ() {
        this.aMG = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean FR() {
        return this.aMG == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FO() {
        if (aMD != null) {
            try {
                start();
                while (FR()) {
                    aMD.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.aMn.write(this.buffer);
                        this.payloadSize += this.buffer.length;
                        if (this.aMJ == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short b = b(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (b > this.aMF) {
                                    this.aMF = b;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.aMF) {
                                    this.aMF = this.buffer[i2];
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
