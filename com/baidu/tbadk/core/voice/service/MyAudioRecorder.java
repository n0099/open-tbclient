package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import android.media.MediaRecorder;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class MyAudioRecorder implements d {
    private byte[] buffer;
    private int bufferSize;
    private boolean cdG;
    private int cdJ;
    private State cdK;
    private short cdL;
    private int cdM;
    private short cdN;
    private int cdO;
    private int cdP;
    private int cdQ;
    private RandomAccessFile cdr;
    private String filePath;
    private int payloadSize;
    private Thread writeThread;
    private static final int[] cdF = {44100, 22050, 11025, 8000};
    private static Object mLock = new Object();
    private static AudioRecord cdH = null;
    private static MediaRecorder cdI = null;

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
            cdH = null;
            cdI = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, cdF[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.akx() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, cdF[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State akx() {
        return this.cdK;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.cdJ = 0;
        this.filePath = null;
        try {
            this.cdG = z;
            if (this.cdG) {
                if (i4 == 2) {
                    this.cdN = (short) 16;
                } else {
                    this.cdN = (short) 8;
                }
                if (i3 == 2) {
                    this.cdL = (short) 1;
                } else {
                    this.cdL = (short) 2;
                }
                this.cdO = i;
                this.cdM = i2;
                this.cdP = i4;
                this.cdQ = (i2 * 120) / 1000;
                this.bufferSize = (((this.cdQ * 2) * this.cdN) * this.cdL) / 8;
                if (this.bufferSize < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.cdQ = this.bufferSize / (((this.cdN * 2) * this.cdL) / 8);
                    BdLog.w(MyAudioRecorder.class.getName() + "Increasing buffer size to " + Integer.toString(this.bufferSize));
                }
                cdH = new AudioRecord(i, i2, i3, i4, this.bufferSize);
                if (cdH.getRecordingState() == 3) {
                    cdH.stop();
                }
                if (cdH.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                cdI = new MediaRecorder();
                cdI.setAudioSource(1);
                cdI.setOutputFormat(1);
                cdI.setAudioEncoder(1);
            }
            this.cdJ = 0;
            this.filePath = null;
            this.cdK = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while initializing recording");
            }
            this.cdK = State.ERROR;
        }
    }

    public boolean oJ(String str) {
        try {
            if (this.cdK == State.INITIALIZING) {
                this.filePath = str;
                if (!this.cdG) {
                    cdI.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while setting output path");
            }
            this.cdK = State.ERROR;
            return false;
        }
    }

    public boolean prepare() {
        try {
            if (this.cdK == State.INITIALIZING) {
                if (this.cdG) {
                    if ((this.filePath != null) & (cdH.getState() == 1)) {
                        if (this.cdr != null) {
                            this.cdr.close();
                            this.cdr = null;
                        }
                        this.cdr = new RandomAccessFile(this.filePath, "rw");
                        this.cdr.setLength(0L);
                        this.cdr.writeBytes("RIFF");
                        this.cdr.writeInt(0);
                        this.cdr.writeBytes("WAVE");
                        this.cdr.writeBytes("fmt ");
                        this.cdr.writeInt(Integer.reverseBytes(16));
                        this.cdr.writeShort(Short.reverseBytes((short) 1));
                        this.cdr.writeShort(Short.reverseBytes(this.cdL));
                        this.cdr.writeInt(Integer.reverseBytes(this.cdM));
                        this.cdr.writeInt(Integer.reverseBytes(((this.cdM * this.cdN) * this.cdL) / 8));
                        this.cdr.writeShort(Short.reverseBytes((short) ((this.cdL * this.cdN) / 8)));
                        this.cdr.writeShort(Short.reverseBytes(this.cdN));
                        this.cdr.writeBytes("data");
                        this.cdr.writeInt(0);
                        this.buffer = new byte[((this.cdQ * this.cdN) / 8) * this.cdL];
                        this.cdK = State.READY;
                    } else {
                        BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on uninitialized recorder");
                        this.cdK = State.ERROR;
                        return false;
                    }
                } else {
                    cdI.prepare();
                    this.cdK = State.READY;
                }
                return true;
            }
            BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on illegal state");
            release();
            this.cdK = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured in prepare()");
            }
            this.cdK = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.cdK == State.RECORDING) {
            stop();
        } else {
            if ((this.cdK == State.READY) & this.cdG) {
                try {
                    this.cdr.close();
                } catch (IOException e) {
                    BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.cdG) {
            if (cdH != null) {
                cdH.release();
            }
        } else if (cdI != null) {
            cdI.release();
        }
    }

    public void start() {
        if (this.cdK == State.READY) {
            if (this.cdG) {
                this.payloadSize = 0;
                cdH.startRecording();
                cdH.read(this.buffer, 0, this.buffer.length);
            } else {
                cdI.start();
            }
            this.cdK = State.RECORDING;
            return;
        }
        BdLog.e(MyAudioRecorder.class.getName() + "start() called on illegal state");
        this.cdK = State.ERROR;
    }

    public void stop() {
        BdLog.e(MyAudioRecorder.class.getName() + "audioRecorder.stop()");
        cdH.stop();
        try {
            this.cdr.seek(4L);
            this.cdr.writeInt(Integer.reverseBytes(this.payloadSize + 36));
            this.cdr.seek(40L);
            this.cdr.writeInt(Integer.reverseBytes(this.payloadSize));
            this.cdr.close();
            BdLog.e(MyAudioRecorder.class.getName() + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
            this.cdK = State.ERROR;
        }
        this.cdK = State.STOPPED;
    }

    private short b(byte b, byte b2) {
        return (short) ((b2 << 8) | b);
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean oH(String str) {
        if (oJ(str)) {
            return prepare();
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean akt() {
        synchronized (mLock) {
            if (this.writeThread == null || !this.writeThread.isAlive()) {
                this.writeThread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.MyAudioRecorder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MyAudioRecorder.this.aks();
                    }
                });
                this.writeThread.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void aku() {
        this.cdK = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean akv() {
        return this.cdK == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aks() {
        if (cdH != null) {
            try {
                start();
                while (akv()) {
                    cdH.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.cdr.write(this.buffer);
                        this.payloadSize += this.buffer.length;
                        if (this.cdN == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short b = b(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (b > this.cdJ) {
                                    this.cdJ = b;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.cdJ) {
                                    this.cdJ = this.buffer[i2];
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
