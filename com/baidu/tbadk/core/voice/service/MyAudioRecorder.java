package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import android.media.MediaRecorder;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class MyAudioRecorder implements d {
    private boolean bVH;
    private int bVK;
    private State bVL;
    private short bVM;
    private int bVN;
    private short bVO;
    private int bVP;
    private int bVQ;
    private int bVR;
    private RandomAccessFile bVs;
    private byte[] buffer;
    private int bufferSize;
    private String filePath;
    private int payloadSize;
    private Thread writeThread;
    private static final int[] bVG = {44100, 22050, 11025, 8000};
    private static Object mLock = new Object();
    private static AudioRecord bVI = null;
    private static MediaRecorder bVJ = null;

    /* loaded from: classes.dex */
    public enum State {
        INITIALIZING,
        READY,
        RECORDING,
        ERROR,
        STOPPED
    }

    public static MyAudioRecorder d(Boolean bool) {
        MyAudioRecorder myAudioRecorder;
        synchronized (mLock) {
            bVI = null;
            bVJ = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, bVG[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.afB() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, bVG[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State afB() {
        return this.bVL;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.bVK = 0;
        this.filePath = null;
        try {
            this.bVH = z;
            if (this.bVH) {
                if (i4 == 2) {
                    this.bVO = (short) 16;
                } else {
                    this.bVO = (short) 8;
                }
                if (i3 == 2) {
                    this.bVM = (short) 1;
                } else {
                    this.bVM = (short) 2;
                }
                this.bVP = i;
                this.bVN = i2;
                this.bVQ = i4;
                this.bVR = (i2 * 120) / 1000;
                this.bufferSize = (((this.bVR * 2) * this.bVO) * this.bVM) / 8;
                if (this.bufferSize < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.bVR = this.bufferSize / (((this.bVO * 2) * this.bVM) / 8);
                    BdLog.w(MyAudioRecorder.class.getName() + "Increasing buffer size to " + Integer.toString(this.bufferSize));
                }
                bVI = new AudioRecord(i, i2, i3, i4, this.bufferSize);
                if (bVI.getRecordingState() == 3) {
                    bVI.stop();
                }
                if (bVI.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                bVJ = new MediaRecorder();
                bVJ.setAudioSource(1);
                bVJ.setOutputFormat(1);
                bVJ.setAudioEncoder(1);
            }
            this.bVK = 0;
            this.filePath = null;
            this.bVL = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while initializing recording");
            }
            this.bVL = State.ERROR;
        }
    }

    public boolean nz(String str) {
        try {
            if (this.bVL == State.INITIALIZING) {
                this.filePath = str;
                if (!this.bVH) {
                    bVJ.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while setting output path");
            }
            this.bVL = State.ERROR;
            return false;
        }
    }

    public boolean prepare() {
        try {
            if (this.bVL == State.INITIALIZING) {
                if (this.bVH) {
                    if ((this.filePath != null) & (bVI.getState() == 1)) {
                        if (this.bVs != null) {
                            this.bVs.close();
                            this.bVs = null;
                        }
                        this.bVs = new RandomAccessFile(this.filePath, "rw");
                        this.bVs.setLength(0L);
                        this.bVs.writeBytes("RIFF");
                        this.bVs.writeInt(0);
                        this.bVs.writeBytes("WAVE");
                        this.bVs.writeBytes("fmt ");
                        this.bVs.writeInt(Integer.reverseBytes(16));
                        this.bVs.writeShort(Short.reverseBytes((short) 1));
                        this.bVs.writeShort(Short.reverseBytes(this.bVM));
                        this.bVs.writeInt(Integer.reverseBytes(this.bVN));
                        this.bVs.writeInt(Integer.reverseBytes(((this.bVN * this.bVO) * this.bVM) / 8));
                        this.bVs.writeShort(Short.reverseBytes((short) ((this.bVM * this.bVO) / 8)));
                        this.bVs.writeShort(Short.reverseBytes(this.bVO));
                        this.bVs.writeBytes("data");
                        this.bVs.writeInt(0);
                        this.buffer = new byte[((this.bVR * this.bVO) / 8) * this.bVM];
                        this.bVL = State.READY;
                    } else {
                        BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on uninitialized recorder");
                        this.bVL = State.ERROR;
                        return false;
                    }
                } else {
                    bVJ.prepare();
                    this.bVL = State.READY;
                }
                return true;
            }
            BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on illegal state");
            release();
            this.bVL = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured in prepare()");
            }
            this.bVL = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.bVL == State.RECORDING) {
            stop();
        } else {
            if ((this.bVL == State.READY) & this.bVH) {
                try {
                    this.bVs.close();
                } catch (IOException e) {
                    BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.bVH) {
            if (bVI != null) {
                bVI.release();
            }
        } else if (bVJ != null) {
            bVJ.release();
        }
    }

    public void start() {
        if (this.bVL == State.READY) {
            if (this.bVH) {
                this.payloadSize = 0;
                bVI.startRecording();
                bVI.read(this.buffer, 0, this.buffer.length);
            } else {
                bVJ.start();
            }
            this.bVL = State.RECORDING;
            return;
        }
        BdLog.e(MyAudioRecorder.class.getName() + "start() called on illegal state");
        this.bVL = State.ERROR;
    }

    public void stop() {
        BdLog.e(MyAudioRecorder.class.getName() + "audioRecorder.stop()");
        bVI.stop();
        try {
            this.bVs.seek(4L);
            this.bVs.writeInt(Integer.reverseBytes(this.payloadSize + 36));
            this.bVs.seek(40L);
            this.bVs.writeInt(Integer.reverseBytes(this.payloadSize));
            this.bVs.close();
            BdLog.e(MyAudioRecorder.class.getName() + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
            this.bVL = State.ERROR;
        }
        this.bVL = State.STOPPED;
    }

    private short b(byte b, byte b2) {
        return (short) ((b2 << 8) | b);
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean nx(String str) {
        if (nz(str)) {
            return prepare();
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean afx() {
        synchronized (mLock) {
            if (this.writeThread == null || !this.writeThread.isAlive()) {
                this.writeThread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.MyAudioRecorder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MyAudioRecorder.this.afw();
                    }
                });
                this.writeThread.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void afy() {
        this.bVL = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean afz() {
        return this.bVL == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afw() {
        if (bVI != null) {
            try {
                start();
                while (afz()) {
                    bVI.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.bVs.write(this.buffer);
                        this.payloadSize += this.buffer.length;
                        if (this.bVO == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short b = b(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (b > this.bVK) {
                                    this.bVK = b;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.bVK) {
                                    this.bVK = this.buffer[i2];
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
