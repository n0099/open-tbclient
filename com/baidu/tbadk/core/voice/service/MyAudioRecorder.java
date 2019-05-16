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
    private boolean cdF;
    private int cdI;
    private State cdJ;
    private short cdK;
    private int cdL;
    private short cdM;
    private int cdN;
    private int cdO;
    private int cdP;
    private RandomAccessFile cdq;
    private String filePath;
    private int payloadSize;
    private Thread writeThread;
    private static final int[] cdE = {44100, 22050, 11025, 8000};
    private static Object mLock = new Object();
    private static AudioRecord cdG = null;
    private static MediaRecorder cdH = null;

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
            cdG = null;
            cdH = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, cdE[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.akx() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, cdE[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State akx() {
        return this.cdJ;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.cdI = 0;
        this.filePath = null;
        try {
            this.cdF = z;
            if (this.cdF) {
                if (i4 == 2) {
                    this.cdM = (short) 16;
                } else {
                    this.cdM = (short) 8;
                }
                if (i3 == 2) {
                    this.cdK = (short) 1;
                } else {
                    this.cdK = (short) 2;
                }
                this.cdN = i;
                this.cdL = i2;
                this.cdO = i4;
                this.cdP = (i2 * 120) / 1000;
                this.bufferSize = (((this.cdP * 2) * this.cdM) * this.cdK) / 8;
                if (this.bufferSize < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.cdP = this.bufferSize / (((this.cdM * 2) * this.cdK) / 8);
                    BdLog.w(MyAudioRecorder.class.getName() + "Increasing buffer size to " + Integer.toString(this.bufferSize));
                }
                cdG = new AudioRecord(i, i2, i3, i4, this.bufferSize);
                if (cdG.getRecordingState() == 3) {
                    cdG.stop();
                }
                if (cdG.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                cdH = new MediaRecorder();
                cdH.setAudioSource(1);
                cdH.setOutputFormat(1);
                cdH.setAudioEncoder(1);
            }
            this.cdI = 0;
            this.filePath = null;
            this.cdJ = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while initializing recording");
            }
            this.cdJ = State.ERROR;
        }
    }

    public boolean oK(String str) {
        try {
            if (this.cdJ == State.INITIALIZING) {
                this.filePath = str;
                if (!this.cdF) {
                    cdH.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while setting output path");
            }
            this.cdJ = State.ERROR;
            return false;
        }
    }

    public boolean prepare() {
        try {
            if (this.cdJ == State.INITIALIZING) {
                if (this.cdF) {
                    if ((this.filePath != null) & (cdG.getState() == 1)) {
                        if (this.cdq != null) {
                            this.cdq.close();
                            this.cdq = null;
                        }
                        this.cdq = new RandomAccessFile(this.filePath, "rw");
                        this.cdq.setLength(0L);
                        this.cdq.writeBytes("RIFF");
                        this.cdq.writeInt(0);
                        this.cdq.writeBytes("WAVE");
                        this.cdq.writeBytes("fmt ");
                        this.cdq.writeInt(Integer.reverseBytes(16));
                        this.cdq.writeShort(Short.reverseBytes((short) 1));
                        this.cdq.writeShort(Short.reverseBytes(this.cdK));
                        this.cdq.writeInt(Integer.reverseBytes(this.cdL));
                        this.cdq.writeInt(Integer.reverseBytes(((this.cdL * this.cdM) * this.cdK) / 8));
                        this.cdq.writeShort(Short.reverseBytes((short) ((this.cdK * this.cdM) / 8)));
                        this.cdq.writeShort(Short.reverseBytes(this.cdM));
                        this.cdq.writeBytes("data");
                        this.cdq.writeInt(0);
                        this.buffer = new byte[((this.cdP * this.cdM) / 8) * this.cdK];
                        this.cdJ = State.READY;
                    } else {
                        BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on uninitialized recorder");
                        this.cdJ = State.ERROR;
                        return false;
                    }
                } else {
                    cdH.prepare();
                    this.cdJ = State.READY;
                }
                return true;
            }
            BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on illegal state");
            release();
            this.cdJ = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured in prepare()");
            }
            this.cdJ = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.cdJ == State.RECORDING) {
            stop();
        } else {
            if ((this.cdJ == State.READY) & this.cdF) {
                try {
                    this.cdq.close();
                } catch (IOException e) {
                    BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.cdF) {
            if (cdG != null) {
                cdG.release();
            }
        } else if (cdH != null) {
            cdH.release();
        }
    }

    public void start() {
        if (this.cdJ == State.READY) {
            if (this.cdF) {
                this.payloadSize = 0;
                cdG.startRecording();
                cdG.read(this.buffer, 0, this.buffer.length);
            } else {
                cdH.start();
            }
            this.cdJ = State.RECORDING;
            return;
        }
        BdLog.e(MyAudioRecorder.class.getName() + "start() called on illegal state");
        this.cdJ = State.ERROR;
    }

    public void stop() {
        BdLog.e(MyAudioRecorder.class.getName() + "audioRecorder.stop()");
        cdG.stop();
        try {
            this.cdq.seek(4L);
            this.cdq.writeInt(Integer.reverseBytes(this.payloadSize + 36));
            this.cdq.seek(40L);
            this.cdq.writeInt(Integer.reverseBytes(this.payloadSize));
            this.cdq.close();
            BdLog.e(MyAudioRecorder.class.getName() + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
            this.cdJ = State.ERROR;
        }
        this.cdJ = State.STOPPED;
    }

    private short b(byte b, byte b2) {
        return (short) ((b2 << 8) | b);
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean oI(String str) {
        if (oK(str)) {
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
        this.cdJ = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean akv() {
        return this.cdJ == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aks() {
        if (cdG != null) {
            try {
                start();
                while (akv()) {
                    cdG.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.cdq.write(this.buffer);
                        this.payloadSize += this.buffer.length;
                        if (this.cdM == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short b = b(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (b > this.cdI) {
                                    this.cdI = b;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.cdI) {
                                    this.cdI = this.buffer[i2];
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
