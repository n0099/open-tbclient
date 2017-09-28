package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import android.media.MediaRecorder;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class MyAudioRecorder implements d {
    private Thread apG;
    private boolean apH;
    private int apK;
    private State apL;
    private short apM;
    private int apN;
    private short apO;
    private int apP;
    private int apQ;
    private int apR;
    private int apq;
    private RandomAccessFile apr;
    private byte[] buffer;
    private String filePath;
    private int payloadSize;
    private static final int[] apF = {44100, 22050, 11025, 8000};
    private static Object mLock = new Object();
    private static AudioRecord apI = null;
    private static MediaRecorder apJ = null;

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
            apI = null;
            apJ = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, apF[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.xh() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, apF[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State xh() {
        return this.apL;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.apK = 0;
        this.filePath = null;
        try {
            this.apH = z;
            if (this.apH) {
                if (i4 == 2) {
                    this.apO = (short) 16;
                } else {
                    this.apO = (short) 8;
                }
                if (i3 == 2) {
                    this.apM = (short) 1;
                } else {
                    this.apM = (short) 2;
                }
                this.apP = i;
                this.apN = i2;
                this.apQ = i4;
                this.apR = (i2 * 120) / 1000;
                this.apq = (((this.apR * 2) * this.apO) * this.apM) / 8;
                if (this.apq < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.apq = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.apR = this.apq / (((this.apO * 2) * this.apM) / 8);
                    BdLog.w(MyAudioRecorder.class.getName() + "Increasing buffer size to " + Integer.toString(this.apq));
                }
                apI = new AudioRecord(i, i2, i3, i4, this.apq);
                if (apI.getRecordingState() == 3) {
                    apI.stop();
                }
                if (apI.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                apJ = new MediaRecorder();
                apJ.setAudioSource(1);
                apJ.setOutputFormat(1);
                apJ.setAudioEncoder(1);
            }
            this.apK = 0;
            this.filePath = null;
            this.apL = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while initializing recording");
            }
            this.apL = State.ERROR;
        }
    }

    public boolean et(String str) {
        try {
            if (this.apL == State.INITIALIZING) {
                this.filePath = str;
                if (!this.apH) {
                    apJ.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while setting output path");
            }
            this.apL = State.ERROR;
            return false;
        }
    }

    public boolean prepare() {
        try {
            if (this.apL == State.INITIALIZING) {
                if (this.apH) {
                    if ((this.filePath != null) & (apI.getState() == 1)) {
                        if (this.apr != null) {
                            this.apr.close();
                            this.apr = null;
                        }
                        this.apr = new RandomAccessFile(this.filePath, "rw");
                        this.apr.setLength(0L);
                        this.apr.writeBytes("RIFF");
                        this.apr.writeInt(0);
                        this.apr.writeBytes("WAVE");
                        this.apr.writeBytes("fmt ");
                        this.apr.writeInt(Integer.reverseBytes(16));
                        this.apr.writeShort(Short.reverseBytes((short) 1));
                        this.apr.writeShort(Short.reverseBytes(this.apM));
                        this.apr.writeInt(Integer.reverseBytes(this.apN));
                        this.apr.writeInt(Integer.reverseBytes(((this.apN * this.apO) * this.apM) / 8));
                        this.apr.writeShort(Short.reverseBytes((short) ((this.apM * this.apO) / 8)));
                        this.apr.writeShort(Short.reverseBytes(this.apO));
                        this.apr.writeBytes("data");
                        this.apr.writeInt(0);
                        this.buffer = new byte[((this.apR * this.apO) / 8) * this.apM];
                        this.apL = State.READY;
                    } else {
                        BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on uninitialized recorder");
                        this.apL = State.ERROR;
                        return false;
                    }
                } else {
                    apJ.prepare();
                    this.apL = State.READY;
                }
                return true;
            }
            BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on illegal state");
            release();
            this.apL = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured in prepare()");
            }
            this.apL = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.apL == State.RECORDING) {
            stop();
        } else {
            if ((this.apL == State.READY) & this.apH) {
                try {
                    this.apr.close();
                } catch (IOException e) {
                    BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.apH) {
            if (apI != null) {
                apI.release();
            }
        } else if (apJ != null) {
            apJ.release();
        }
    }

    public void start() {
        if (this.apL == State.READY) {
            if (this.apH) {
                this.payloadSize = 0;
                apI.startRecording();
                apI.read(this.buffer, 0, this.buffer.length);
            } else {
                apJ.start();
            }
            this.apL = State.RECORDING;
            return;
        }
        BdLog.e(MyAudioRecorder.class.getName() + "start() called on illegal state");
        this.apL = State.ERROR;
    }

    public void stop() {
        BdLog.e(MyAudioRecorder.class.getName() + "audioRecorder.stop()");
        apI.stop();
        try {
            this.apr.seek(4L);
            this.apr.writeInt(Integer.reverseBytes(this.payloadSize + 36));
            this.apr.seek(40L);
            this.apr.writeInt(Integer.reverseBytes(this.payloadSize));
            this.apr.close();
            BdLog.e(MyAudioRecorder.class.getName() + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
            this.apL = State.ERROR;
        }
        this.apL = State.STOPPED;
    }

    private short b(byte b, byte b2) {
        return (short) ((b2 << 8) | b);
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean er(String str) {
        if (et(str)) {
            return prepare();
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean xd() {
        synchronized (mLock) {
            if (this.apG == null || !this.apG.isAlive()) {
                this.apG = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.MyAudioRecorder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MyAudioRecorder.this.xc();
                    }
                });
                this.apG.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void xe() {
        this.apL = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean isRecording() {
        return this.apL == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xc() {
        if (apI != null) {
            try {
                start();
                while (isRecording()) {
                    apI.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.apr.write(this.buffer);
                        this.payloadSize += this.buffer.length;
                        if (this.apO == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short b = b(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (b > this.apK) {
                                    this.apK = b;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.apK) {
                                    this.apK = this.buffer[i2];
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
