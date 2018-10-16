package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import android.media.MediaRecorder;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class MyAudioRecorder implements d {
    private RandomAccessFile aHX;
    private boolean aIm;
    private int aIp;
    private State aIq;
    private short aIr;
    private int aIs;
    private short aIt;
    private int aIu;
    private int aIv;
    private int aIw;
    private byte[] buffer;
    private int bufferSize;
    private String filePath;
    private int payloadSize;
    private Thread writeThread;
    private static final int[] aIl = {44100, 22050, 11025, 8000};
    private static Object mLock = new Object();
    private static AudioRecord aIn = null;
    private static MediaRecorder aIo = null;

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
            aIn = null;
            aIo = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, aIl[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.EE() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, aIl[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State EE() {
        return this.aIq;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.aIp = 0;
        this.filePath = null;
        try {
            this.aIm = z;
            if (this.aIm) {
                if (i4 == 2) {
                    this.aIt = (short) 16;
                } else {
                    this.aIt = (short) 8;
                }
                if (i3 == 2) {
                    this.aIr = (short) 1;
                } else {
                    this.aIr = (short) 2;
                }
                this.aIu = i;
                this.aIs = i2;
                this.aIv = i4;
                this.aIw = (i2 * 120) / 1000;
                this.bufferSize = (((this.aIw * 2) * this.aIt) * this.aIr) / 8;
                if (this.bufferSize < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.aIw = this.bufferSize / (((this.aIt * 2) * this.aIr) / 8);
                    BdLog.w(MyAudioRecorder.class.getName() + "Increasing buffer size to " + Integer.toString(this.bufferSize));
                }
                aIn = new AudioRecord(i, i2, i3, i4, this.bufferSize);
                if (aIn.getRecordingState() == 3) {
                    aIn.stop();
                }
                if (aIn.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                aIo = new MediaRecorder();
                aIo.setAudioSource(1);
                aIo.setOutputFormat(1);
                aIo.setAudioEncoder(1);
            }
            this.aIp = 0;
            this.filePath = null;
            this.aIq = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while initializing recording");
            }
            this.aIq = State.ERROR;
        }
    }

    public boolean gf(String str) {
        try {
            if (this.aIq == State.INITIALIZING) {
                this.filePath = str;
                if (!this.aIm) {
                    aIo.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while setting output path");
            }
            this.aIq = State.ERROR;
            return false;
        }
    }

    public boolean prepare() {
        try {
            if (this.aIq == State.INITIALIZING) {
                if (this.aIm) {
                    if ((this.filePath != null) & (aIn.getState() == 1)) {
                        if (this.aHX != null) {
                            this.aHX.close();
                            this.aHX = null;
                        }
                        this.aHX = new RandomAccessFile(this.filePath, "rw");
                        this.aHX.setLength(0L);
                        this.aHX.writeBytes("RIFF");
                        this.aHX.writeInt(0);
                        this.aHX.writeBytes("WAVE");
                        this.aHX.writeBytes("fmt ");
                        this.aHX.writeInt(Integer.reverseBytes(16));
                        this.aHX.writeShort(Short.reverseBytes((short) 1));
                        this.aHX.writeShort(Short.reverseBytes(this.aIr));
                        this.aHX.writeInt(Integer.reverseBytes(this.aIs));
                        this.aHX.writeInt(Integer.reverseBytes(((this.aIs * this.aIt) * this.aIr) / 8));
                        this.aHX.writeShort(Short.reverseBytes((short) ((this.aIr * this.aIt) / 8)));
                        this.aHX.writeShort(Short.reverseBytes(this.aIt));
                        this.aHX.writeBytes("data");
                        this.aHX.writeInt(0);
                        this.buffer = new byte[((this.aIw * this.aIt) / 8) * this.aIr];
                        this.aIq = State.READY;
                    } else {
                        BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on uninitialized recorder");
                        this.aIq = State.ERROR;
                        return false;
                    }
                } else {
                    aIo.prepare();
                    this.aIq = State.READY;
                }
                return true;
            }
            BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on illegal state");
            release();
            this.aIq = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured in prepare()");
            }
            this.aIq = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.aIq == State.RECORDING) {
            stop();
        } else {
            if ((this.aIq == State.READY) & this.aIm) {
                try {
                    this.aHX.close();
                } catch (IOException e) {
                    BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.aIm) {
            if (aIn != null) {
                aIn.release();
            }
        } else if (aIo != null) {
            aIo.release();
        }
    }

    public void start() {
        if (this.aIq == State.READY) {
            if (this.aIm) {
                this.payloadSize = 0;
                aIn.startRecording();
                aIn.read(this.buffer, 0, this.buffer.length);
            } else {
                aIo.start();
            }
            this.aIq = State.RECORDING;
            return;
        }
        BdLog.e(MyAudioRecorder.class.getName() + "start() called on illegal state");
        this.aIq = State.ERROR;
    }

    public void stop() {
        BdLog.e(MyAudioRecorder.class.getName() + "audioRecorder.stop()");
        aIn.stop();
        try {
            this.aHX.seek(4L);
            this.aHX.writeInt(Integer.reverseBytes(this.payloadSize + 36));
            this.aHX.seek(40L);
            this.aHX.writeInt(Integer.reverseBytes(this.payloadSize));
            this.aHX.close();
            BdLog.e(MyAudioRecorder.class.getName() + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
            this.aIq = State.ERROR;
        }
        this.aIq = State.STOPPED;
    }

    private short b(byte b, byte b2) {
        return (short) ((b2 << 8) | b);
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean gd(String str) {
        if (gf(str)) {
            return prepare();
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean EB() {
        synchronized (mLock) {
            if (this.writeThread == null || !this.writeThread.isAlive()) {
                this.writeThread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.MyAudioRecorder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MyAudioRecorder.this.EA();
                    }
                });
                this.writeThread.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void EC() {
        this.aIq = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean isRecording() {
        return this.aIq == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EA() {
        if (aIn != null) {
            try {
                start();
                while (isRecording()) {
                    aIn.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.aHX.write(this.buffer);
                        this.payloadSize += this.buffer.length;
                        if (this.aIt == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short b = b(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (b > this.aIp) {
                                    this.aIp = b;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.aIp) {
                                    this.aIp = this.buffer[i2];
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
