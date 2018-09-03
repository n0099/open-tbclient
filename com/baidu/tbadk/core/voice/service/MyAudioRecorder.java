package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import android.media.MediaRecorder;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class MyAudioRecorder implements d {
    private Thread aAD;
    private boolean aAE;
    private int aAH;
    private State aAI;
    private short aAJ;
    private int aAK;
    private short aAL;
    private int aAM;
    private int aAN;
    private int aAO;
    private int aAn;
    private RandomAccessFile aAo;
    private byte[] buffer;
    private String filePath;
    private int payloadSize;
    private static final int[] aAC = {44100, 22050, 11025, 8000};
    private static Object mLock = new Object();
    private static AudioRecord aAF = null;
    private static MediaRecorder aAG = null;

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
            aAF = null;
            aAG = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, aAC[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.Bo() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, aAC[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State Bo() {
        return this.aAI;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.aAH = 0;
        this.filePath = null;
        try {
            this.aAE = z;
            if (this.aAE) {
                if (i4 == 2) {
                    this.aAL = (short) 16;
                } else {
                    this.aAL = (short) 8;
                }
                if (i3 == 2) {
                    this.aAJ = (short) 1;
                } else {
                    this.aAJ = (short) 2;
                }
                this.aAM = i;
                this.aAK = i2;
                this.aAN = i4;
                this.aAO = (i2 * 120) / 1000;
                this.aAn = (((this.aAO * 2) * this.aAL) * this.aAJ) / 8;
                if (this.aAn < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.aAn = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.aAO = this.aAn / (((this.aAL * 2) * this.aAJ) / 8);
                    BdLog.w(MyAudioRecorder.class.getName() + "Increasing buffer size to " + Integer.toString(this.aAn));
                }
                aAF = new AudioRecord(i, i2, i3, i4, this.aAn);
                if (aAF.getRecordingState() == 3) {
                    aAF.stop();
                }
                if (aAF.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                aAG = new MediaRecorder();
                aAG.setAudioSource(1);
                aAG.setOutputFormat(1);
                aAG.setAudioEncoder(1);
            }
            this.aAH = 0;
            this.filePath = null;
            this.aAI = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while initializing recording");
            }
            this.aAI = State.ERROR;
        }
    }

    public boolean fw(String str) {
        try {
            if (this.aAI == State.INITIALIZING) {
                this.filePath = str;
                if (!this.aAE) {
                    aAG.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while setting output path");
            }
            this.aAI = State.ERROR;
            return false;
        }
    }

    public boolean prepare() {
        try {
            if (this.aAI == State.INITIALIZING) {
                if (this.aAE) {
                    if ((this.filePath != null) & (aAF.getState() == 1)) {
                        if (this.aAo != null) {
                            this.aAo.close();
                            this.aAo = null;
                        }
                        this.aAo = new RandomAccessFile(this.filePath, "rw");
                        this.aAo.setLength(0L);
                        this.aAo.writeBytes("RIFF");
                        this.aAo.writeInt(0);
                        this.aAo.writeBytes("WAVE");
                        this.aAo.writeBytes("fmt ");
                        this.aAo.writeInt(Integer.reverseBytes(16));
                        this.aAo.writeShort(Short.reverseBytes((short) 1));
                        this.aAo.writeShort(Short.reverseBytes(this.aAJ));
                        this.aAo.writeInt(Integer.reverseBytes(this.aAK));
                        this.aAo.writeInt(Integer.reverseBytes(((this.aAK * this.aAL) * this.aAJ) / 8));
                        this.aAo.writeShort(Short.reverseBytes((short) ((this.aAJ * this.aAL) / 8)));
                        this.aAo.writeShort(Short.reverseBytes(this.aAL));
                        this.aAo.writeBytes("data");
                        this.aAo.writeInt(0);
                        this.buffer = new byte[((this.aAO * this.aAL) / 8) * this.aAJ];
                        this.aAI = State.READY;
                    } else {
                        BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on uninitialized recorder");
                        this.aAI = State.ERROR;
                        return false;
                    }
                } else {
                    aAG.prepare();
                    this.aAI = State.READY;
                }
                return true;
            }
            BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on illegal state");
            release();
            this.aAI = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured in prepare()");
            }
            this.aAI = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.aAI == State.RECORDING) {
            stop();
        } else {
            if ((this.aAI == State.READY) & this.aAE) {
                try {
                    this.aAo.close();
                } catch (IOException e) {
                    BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.aAE) {
            if (aAF != null) {
                aAF.release();
            }
        } else if (aAG != null) {
            aAG.release();
        }
    }

    public void start() {
        if (this.aAI == State.READY) {
            if (this.aAE) {
                this.payloadSize = 0;
                aAF.startRecording();
                aAF.read(this.buffer, 0, this.buffer.length);
            } else {
                aAG.start();
            }
            this.aAI = State.RECORDING;
            return;
        }
        BdLog.e(MyAudioRecorder.class.getName() + "start() called on illegal state");
        this.aAI = State.ERROR;
    }

    public void stop() {
        BdLog.e(MyAudioRecorder.class.getName() + "audioRecorder.stop()");
        aAF.stop();
        try {
            this.aAo.seek(4L);
            this.aAo.writeInt(Integer.reverseBytes(this.payloadSize + 36));
            this.aAo.seek(40L);
            this.aAo.writeInt(Integer.reverseBytes(this.payloadSize));
            this.aAo.close();
            BdLog.e(MyAudioRecorder.class.getName() + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
            this.aAI = State.ERROR;
        }
        this.aAI = State.STOPPED;
    }

    private short b(byte b, byte b2) {
        return (short) ((b2 << 8) | b);
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean fu(String str) {
        if (fw(str)) {
            return prepare();
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean Bk() {
        synchronized (mLock) {
            if (this.aAD == null || !this.aAD.isAlive()) {
                this.aAD = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.MyAudioRecorder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MyAudioRecorder.this.Bj();
                    }
                });
                this.aAD.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void Bl() {
        this.aAI = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean isRecording() {
        return this.aAI == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bj() {
        if (aAF != null) {
            try {
                start();
                while (isRecording()) {
                    aAF.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.aAo.write(this.buffer);
                        this.payloadSize += this.buffer.length;
                        if (this.aAL == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short b = b(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (b > this.aAH) {
                                    this.aAH = b;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.aAH) {
                                    this.aAH = this.buffer[i2];
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
