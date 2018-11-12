package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import android.media.MediaRecorder;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class MyAudioRecorder implements d {
    private RandomAccessFile aIN;
    private boolean aJc;
    private int aJf;
    private State aJg;
    private short aJh;
    private int aJi;
    private short aJj;
    private int aJk;
    private int aJl;
    private int aJm;
    private byte[] buffer;
    private int bufferSize;
    private String filePath;
    private int payloadSize;
    private Thread writeThread;
    private static final int[] aJb = {44100, 22050, 11025, 8000};
    private static Object mLock = new Object();
    private static AudioRecord aJd = null;
    private static MediaRecorder aJe = null;

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
            aJd = null;
            aJe = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, aJb[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.EP() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, aJb[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State EP() {
        return this.aJg;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.aJf = 0;
        this.filePath = null;
        try {
            this.aJc = z;
            if (this.aJc) {
                if (i4 == 2) {
                    this.aJj = (short) 16;
                } else {
                    this.aJj = (short) 8;
                }
                if (i3 == 2) {
                    this.aJh = (short) 1;
                } else {
                    this.aJh = (short) 2;
                }
                this.aJk = i;
                this.aJi = i2;
                this.aJl = i4;
                this.aJm = (i2 * 120) / 1000;
                this.bufferSize = (((this.aJm * 2) * this.aJj) * this.aJh) / 8;
                if (this.bufferSize < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.aJm = this.bufferSize / (((this.aJj * 2) * this.aJh) / 8);
                    BdLog.w(MyAudioRecorder.class.getName() + "Increasing buffer size to " + Integer.toString(this.bufferSize));
                }
                aJd = new AudioRecord(i, i2, i3, i4, this.bufferSize);
                if (aJd.getRecordingState() == 3) {
                    aJd.stop();
                }
                if (aJd.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                aJe = new MediaRecorder();
                aJe.setAudioSource(1);
                aJe.setOutputFormat(1);
                aJe.setAudioEncoder(1);
            }
            this.aJf = 0;
            this.filePath = null;
            this.aJg = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while initializing recording");
            }
            this.aJg = State.ERROR;
        }
    }

    public boolean gg(String str) {
        try {
            if (this.aJg == State.INITIALIZING) {
                this.filePath = str;
                if (!this.aJc) {
                    aJe.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while setting output path");
            }
            this.aJg = State.ERROR;
            return false;
        }
    }

    public boolean prepare() {
        try {
            if (this.aJg == State.INITIALIZING) {
                if (this.aJc) {
                    if ((this.filePath != null) & (aJd.getState() == 1)) {
                        if (this.aIN != null) {
                            this.aIN.close();
                            this.aIN = null;
                        }
                        this.aIN = new RandomAccessFile(this.filePath, "rw");
                        this.aIN.setLength(0L);
                        this.aIN.writeBytes("RIFF");
                        this.aIN.writeInt(0);
                        this.aIN.writeBytes("WAVE");
                        this.aIN.writeBytes("fmt ");
                        this.aIN.writeInt(Integer.reverseBytes(16));
                        this.aIN.writeShort(Short.reverseBytes((short) 1));
                        this.aIN.writeShort(Short.reverseBytes(this.aJh));
                        this.aIN.writeInt(Integer.reverseBytes(this.aJi));
                        this.aIN.writeInt(Integer.reverseBytes(((this.aJi * this.aJj) * this.aJh) / 8));
                        this.aIN.writeShort(Short.reverseBytes((short) ((this.aJh * this.aJj) / 8)));
                        this.aIN.writeShort(Short.reverseBytes(this.aJj));
                        this.aIN.writeBytes("data");
                        this.aIN.writeInt(0);
                        this.buffer = new byte[((this.aJm * this.aJj) / 8) * this.aJh];
                        this.aJg = State.READY;
                    } else {
                        BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on uninitialized recorder");
                        this.aJg = State.ERROR;
                        return false;
                    }
                } else {
                    aJe.prepare();
                    this.aJg = State.READY;
                }
                return true;
            }
            BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on illegal state");
            release();
            this.aJg = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured in prepare()");
            }
            this.aJg = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.aJg == State.RECORDING) {
            stop();
        } else {
            if ((this.aJg == State.READY) & this.aJc) {
                try {
                    this.aIN.close();
                } catch (IOException e) {
                    BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.aJc) {
            if (aJd != null) {
                aJd.release();
            }
        } else if (aJe != null) {
            aJe.release();
        }
    }

    public void start() {
        if (this.aJg == State.READY) {
            if (this.aJc) {
                this.payloadSize = 0;
                aJd.startRecording();
                aJd.read(this.buffer, 0, this.buffer.length);
            } else {
                aJe.start();
            }
            this.aJg = State.RECORDING;
            return;
        }
        BdLog.e(MyAudioRecorder.class.getName() + "start() called on illegal state");
        this.aJg = State.ERROR;
    }

    public void stop() {
        BdLog.e(MyAudioRecorder.class.getName() + "audioRecorder.stop()");
        aJd.stop();
        try {
            this.aIN.seek(4L);
            this.aIN.writeInt(Integer.reverseBytes(this.payloadSize + 36));
            this.aIN.seek(40L);
            this.aIN.writeInt(Integer.reverseBytes(this.payloadSize));
            this.aIN.close();
            BdLog.e(MyAudioRecorder.class.getName() + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
            this.aJg = State.ERROR;
        }
        this.aJg = State.STOPPED;
    }

    private short b(byte b, byte b2) {
        return (short) ((b2 << 8) | b);
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean ge(String str) {
        if (gg(str)) {
            return prepare();
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean EL() {
        synchronized (mLock) {
            if (this.writeThread == null || !this.writeThread.isAlive()) {
                this.writeThread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.MyAudioRecorder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MyAudioRecorder.this.EK();
                    }
                });
                this.writeThread.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void EM() {
        this.aJg = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean EN() {
        return this.aJg == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EK() {
        if (aJd != null) {
            try {
                start();
                while (EN()) {
                    aJd.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.aIN.write(this.buffer);
                        this.payloadSize += this.buffer.length;
                        if (this.aJj == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short b = b(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (b > this.aJf) {
                                    this.aJf = b;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.aJf) {
                                    this.aJf = this.buffer[i2];
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
