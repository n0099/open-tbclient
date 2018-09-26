package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import android.media.MediaRecorder;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class MyAudioRecorder implements d {
    private Thread aDH;
    private boolean aDI;
    private int aDL;
    private State aDM;
    private short aDN;
    private int aDO;
    private short aDP;
    private int aDQ;
    private int aDR;
    private int aDS;
    private int aDr;
    private RandomAccessFile aDs;
    private byte[] buffer;
    private String filePath;
    private int payloadSize;
    private static final int[] aDG = {44100, 22050, 11025, 8000};
    private static Object mLock = new Object();
    private static AudioRecord aDJ = null;
    private static MediaRecorder aDK = null;

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
            aDJ = null;
            aDK = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, aDG[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.CA() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, aDG[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State CA() {
        return this.aDM;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.aDL = 0;
        this.filePath = null;
        try {
            this.aDI = z;
            if (this.aDI) {
                if (i4 == 2) {
                    this.aDP = (short) 16;
                } else {
                    this.aDP = (short) 8;
                }
                if (i3 == 2) {
                    this.aDN = (short) 1;
                } else {
                    this.aDN = (short) 2;
                }
                this.aDQ = i;
                this.aDO = i2;
                this.aDR = i4;
                this.aDS = (i2 * 120) / 1000;
                this.aDr = (((this.aDS * 2) * this.aDP) * this.aDN) / 8;
                if (this.aDr < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.aDr = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.aDS = this.aDr / (((this.aDP * 2) * this.aDN) / 8);
                    BdLog.w(MyAudioRecorder.class.getName() + "Increasing buffer size to " + Integer.toString(this.aDr));
                }
                aDJ = new AudioRecord(i, i2, i3, i4, this.aDr);
                if (aDJ.getRecordingState() == 3) {
                    aDJ.stop();
                }
                if (aDJ.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                aDK = new MediaRecorder();
                aDK.setAudioSource(1);
                aDK.setOutputFormat(1);
                aDK.setAudioEncoder(1);
            }
            this.aDL = 0;
            this.filePath = null;
            this.aDM = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while initializing recording");
            }
            this.aDM = State.ERROR;
        }
    }

    public boolean fR(String str) {
        try {
            if (this.aDM == State.INITIALIZING) {
                this.filePath = str;
                if (!this.aDI) {
                    aDK.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while setting output path");
            }
            this.aDM = State.ERROR;
            return false;
        }
    }

    public boolean prepare() {
        try {
            if (this.aDM == State.INITIALIZING) {
                if (this.aDI) {
                    if ((this.filePath != null) & (aDJ.getState() == 1)) {
                        if (this.aDs != null) {
                            this.aDs.close();
                            this.aDs = null;
                        }
                        this.aDs = new RandomAccessFile(this.filePath, "rw");
                        this.aDs.setLength(0L);
                        this.aDs.writeBytes("RIFF");
                        this.aDs.writeInt(0);
                        this.aDs.writeBytes("WAVE");
                        this.aDs.writeBytes("fmt ");
                        this.aDs.writeInt(Integer.reverseBytes(16));
                        this.aDs.writeShort(Short.reverseBytes((short) 1));
                        this.aDs.writeShort(Short.reverseBytes(this.aDN));
                        this.aDs.writeInt(Integer.reverseBytes(this.aDO));
                        this.aDs.writeInt(Integer.reverseBytes(((this.aDO * this.aDP) * this.aDN) / 8));
                        this.aDs.writeShort(Short.reverseBytes((short) ((this.aDN * this.aDP) / 8)));
                        this.aDs.writeShort(Short.reverseBytes(this.aDP));
                        this.aDs.writeBytes("data");
                        this.aDs.writeInt(0);
                        this.buffer = new byte[((this.aDS * this.aDP) / 8) * this.aDN];
                        this.aDM = State.READY;
                    } else {
                        BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on uninitialized recorder");
                        this.aDM = State.ERROR;
                        return false;
                    }
                } else {
                    aDK.prepare();
                    this.aDM = State.READY;
                }
                return true;
            }
            BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on illegal state");
            release();
            this.aDM = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured in prepare()");
            }
            this.aDM = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.aDM == State.RECORDING) {
            stop();
        } else {
            if ((this.aDM == State.READY) & this.aDI) {
                try {
                    this.aDs.close();
                } catch (IOException e) {
                    BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.aDI) {
            if (aDJ != null) {
                aDJ.release();
            }
        } else if (aDK != null) {
            aDK.release();
        }
    }

    public void start() {
        if (this.aDM == State.READY) {
            if (this.aDI) {
                this.payloadSize = 0;
                aDJ.startRecording();
                aDJ.read(this.buffer, 0, this.buffer.length);
            } else {
                aDK.start();
            }
            this.aDM = State.RECORDING;
            return;
        }
        BdLog.e(MyAudioRecorder.class.getName() + "start() called on illegal state");
        this.aDM = State.ERROR;
    }

    public void stop() {
        BdLog.e(MyAudioRecorder.class.getName() + "audioRecorder.stop()");
        aDJ.stop();
        try {
            this.aDs.seek(4L);
            this.aDs.writeInt(Integer.reverseBytes(this.payloadSize + 36));
            this.aDs.seek(40L);
            this.aDs.writeInt(Integer.reverseBytes(this.payloadSize));
            this.aDs.close();
            BdLog.e(MyAudioRecorder.class.getName() + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
            this.aDM = State.ERROR;
        }
        this.aDM = State.STOPPED;
    }

    private short b(byte b, byte b2) {
        return (short) ((b2 << 8) | b);
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean fP(String str) {
        if (fR(str)) {
            return prepare();
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean Cw() {
        synchronized (mLock) {
            if (this.aDH == null || !this.aDH.isAlive()) {
                this.aDH = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.MyAudioRecorder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MyAudioRecorder.this.Cv();
                    }
                });
                this.aDH.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void Cx() {
        this.aDM = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean isRecording() {
        return this.aDM == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cv() {
        if (aDJ != null) {
            try {
                start();
                while (isRecording()) {
                    aDJ.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.aDs.write(this.buffer);
                        this.payloadSize += this.buffer.length;
                        if (this.aDP == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short b = b(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (b > this.aDL) {
                                    this.aDL = b;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.aDL) {
                                    this.aDL = this.buffer[i2];
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
