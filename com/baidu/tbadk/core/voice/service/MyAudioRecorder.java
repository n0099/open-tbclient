package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import android.media.MediaRecorder;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class MyAudioRecorder implements d {
    private boolean aME;
    private int aMH;
    private State aMI;
    private short aMJ;
    private int aMK;
    private short aML;
    private int aMM;
    private int aMN;
    private int aMO;
    private RandomAccessFile aMp;
    private byte[] buffer;
    private int bufferSize;
    private String filePath;
    private int payloadSize;
    private Thread writeThread;
    private static final int[] aMD = {44100, 22050, 11025, 8000};
    private static Object mLock = new Object();
    private static AudioRecord aMF = null;
    private static MediaRecorder aMG = null;

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
            aMF = null;
            aMG = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, aMD[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.FU() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, aMD[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State FU() {
        return this.aMI;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.aMH = 0;
        this.filePath = null;
        try {
            this.aME = z;
            if (this.aME) {
                if (i4 == 2) {
                    this.aML = (short) 16;
                } else {
                    this.aML = (short) 8;
                }
                if (i3 == 2) {
                    this.aMJ = (short) 1;
                } else {
                    this.aMJ = (short) 2;
                }
                this.aMM = i;
                this.aMK = i2;
                this.aMN = i4;
                this.aMO = (i2 * 120) / 1000;
                this.bufferSize = (((this.aMO * 2) * this.aML) * this.aMJ) / 8;
                if (this.bufferSize < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.aMO = this.bufferSize / (((this.aML * 2) * this.aMJ) / 8);
                    BdLog.w(MyAudioRecorder.class.getName() + "Increasing buffer size to " + Integer.toString(this.bufferSize));
                }
                aMF = new AudioRecord(i, i2, i3, i4, this.bufferSize);
                if (aMF.getRecordingState() == 3) {
                    aMF.stop();
                }
                if (aMF.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                aMG = new MediaRecorder();
                aMG.setAudioSource(1);
                aMG.setOutputFormat(1);
                aMG.setAudioEncoder(1);
            }
            this.aMH = 0;
            this.filePath = null;
            this.aMI = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while initializing recording");
            }
            this.aMI = State.ERROR;
        }
    }

    public boolean gA(String str) {
        try {
            if (this.aMI == State.INITIALIZING) {
                this.filePath = str;
                if (!this.aME) {
                    aMG.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while setting output path");
            }
            this.aMI = State.ERROR;
            return false;
        }
    }

    public boolean prepare() {
        try {
            if (this.aMI == State.INITIALIZING) {
                if (this.aME) {
                    if ((this.filePath != null) & (aMF.getState() == 1)) {
                        if (this.aMp != null) {
                            this.aMp.close();
                            this.aMp = null;
                        }
                        this.aMp = new RandomAccessFile(this.filePath, "rw");
                        this.aMp.setLength(0L);
                        this.aMp.writeBytes("RIFF");
                        this.aMp.writeInt(0);
                        this.aMp.writeBytes("WAVE");
                        this.aMp.writeBytes("fmt ");
                        this.aMp.writeInt(Integer.reverseBytes(16));
                        this.aMp.writeShort(Short.reverseBytes((short) 1));
                        this.aMp.writeShort(Short.reverseBytes(this.aMJ));
                        this.aMp.writeInt(Integer.reverseBytes(this.aMK));
                        this.aMp.writeInt(Integer.reverseBytes(((this.aMK * this.aML) * this.aMJ) / 8));
                        this.aMp.writeShort(Short.reverseBytes((short) ((this.aMJ * this.aML) / 8)));
                        this.aMp.writeShort(Short.reverseBytes(this.aML));
                        this.aMp.writeBytes("data");
                        this.aMp.writeInt(0);
                        this.buffer = new byte[((this.aMO * this.aML) / 8) * this.aMJ];
                        this.aMI = State.READY;
                    } else {
                        BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on uninitialized recorder");
                        this.aMI = State.ERROR;
                        return false;
                    }
                } else {
                    aMG.prepare();
                    this.aMI = State.READY;
                }
                return true;
            }
            BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on illegal state");
            release();
            this.aMI = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured in prepare()");
            }
            this.aMI = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.aMI == State.RECORDING) {
            stop();
        } else {
            if ((this.aMI == State.READY) & this.aME) {
                try {
                    this.aMp.close();
                } catch (IOException e) {
                    BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.aME) {
            if (aMF != null) {
                aMF.release();
            }
        } else if (aMG != null) {
            aMG.release();
        }
    }

    public void start() {
        if (this.aMI == State.READY) {
            if (this.aME) {
                this.payloadSize = 0;
                aMF.startRecording();
                aMF.read(this.buffer, 0, this.buffer.length);
            } else {
                aMG.start();
            }
            this.aMI = State.RECORDING;
            return;
        }
        BdLog.e(MyAudioRecorder.class.getName() + "start() called on illegal state");
        this.aMI = State.ERROR;
    }

    public void stop() {
        BdLog.e(MyAudioRecorder.class.getName() + "audioRecorder.stop()");
        aMF.stop();
        try {
            this.aMp.seek(4L);
            this.aMp.writeInt(Integer.reverseBytes(this.payloadSize + 36));
            this.aMp.seek(40L);
            this.aMp.writeInt(Integer.reverseBytes(this.payloadSize));
            this.aMp.close();
            BdLog.e(MyAudioRecorder.class.getName() + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
            this.aMI = State.ERROR;
        }
        this.aMI = State.STOPPED;
    }

    private short b(byte b, byte b2) {
        return (short) ((b2 << 8) | b);
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean gy(String str) {
        if (gA(str)) {
            return prepare();
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean FQ() {
        synchronized (mLock) {
            if (this.writeThread == null || !this.writeThread.isAlive()) {
                this.writeThread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.MyAudioRecorder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MyAudioRecorder.this.FP();
                    }
                });
                this.writeThread.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void FR() {
        this.aMI = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean FS() {
        return this.aMI == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FP() {
        if (aMF != null) {
            try {
                start();
                while (FS()) {
                    aMF.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.aMp.write(this.buffer);
                        this.payloadSize += this.buffer.length;
                        if (this.aML == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short b = b(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (b > this.aMH) {
                                    this.aMH = b;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.aMH) {
                                    this.aMH = this.buffer[i2];
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
