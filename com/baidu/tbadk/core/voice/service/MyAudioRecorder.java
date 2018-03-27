package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import android.media.MediaRecorder;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class MyAudioRecorder implements d {
    private int bfS;
    private RandomAccessFile bfT;
    private Thread bgi;
    private boolean bgj;
    private int bgm;
    private State bgn;
    private short bgo;
    private int bgp;
    private short bgq;
    private int bgr;
    private int bgt;
    private int bgu;
    private byte[] buffer;
    private String filePath;
    private int payloadSize;
    private static final int[] bgh = {44100, 22050, 11025, 8000};
    private static Object mLock = new Object();
    private static AudioRecord bgk = null;
    private static MediaRecorder bgl = null;

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
            bgk = null;
            bgl = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, bgh[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.EU() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, bgh[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State EU() {
        return this.bgn;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.bgm = 0;
        this.filePath = null;
        try {
            this.bgj = z;
            if (this.bgj) {
                if (i4 == 2) {
                    this.bgq = (short) 16;
                } else {
                    this.bgq = (short) 8;
                }
                if (i3 == 2) {
                    this.bgo = (short) 1;
                } else {
                    this.bgo = (short) 2;
                }
                this.bgr = i;
                this.bgp = i2;
                this.bgt = i4;
                this.bgu = (i2 * 120) / 1000;
                this.bfS = (((this.bgu * 2) * this.bgq) * this.bgo) / 8;
                if (this.bfS < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.bfS = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.bgu = this.bfS / (((this.bgq * 2) * this.bgo) / 8);
                    BdLog.w(MyAudioRecorder.class.getName() + "Increasing buffer size to " + Integer.toString(this.bfS));
                }
                bgk = new AudioRecord(i, i2, i3, i4, this.bfS);
                if (bgk.getRecordingState() == 3) {
                    bgk.stop();
                }
                if (bgk.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                bgl = new MediaRecorder();
                bgl.setAudioSource(1);
                bgl.setOutputFormat(1);
                bgl.setAudioEncoder(1);
            }
            this.bgm = 0;
            this.filePath = null;
            this.bgn = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while initializing recording");
            }
            this.bgn = State.ERROR;
        }
    }

    public boolean fe(String str) {
        try {
            if (this.bgn == State.INITIALIZING) {
                this.filePath = str;
                if (!this.bgj) {
                    bgl.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while setting output path");
            }
            this.bgn = State.ERROR;
            return false;
        }
    }

    public boolean prepare() {
        try {
            if (this.bgn == State.INITIALIZING) {
                if (this.bgj) {
                    if ((this.filePath != null) & (bgk.getState() == 1)) {
                        if (this.bfT != null) {
                            this.bfT.close();
                            this.bfT = null;
                        }
                        this.bfT = new RandomAccessFile(this.filePath, "rw");
                        this.bfT.setLength(0L);
                        this.bfT.writeBytes("RIFF");
                        this.bfT.writeInt(0);
                        this.bfT.writeBytes("WAVE");
                        this.bfT.writeBytes("fmt ");
                        this.bfT.writeInt(Integer.reverseBytes(16));
                        this.bfT.writeShort(Short.reverseBytes((short) 1));
                        this.bfT.writeShort(Short.reverseBytes(this.bgo));
                        this.bfT.writeInt(Integer.reverseBytes(this.bgp));
                        this.bfT.writeInt(Integer.reverseBytes(((this.bgp * this.bgq) * this.bgo) / 8));
                        this.bfT.writeShort(Short.reverseBytes((short) ((this.bgo * this.bgq) / 8)));
                        this.bfT.writeShort(Short.reverseBytes(this.bgq));
                        this.bfT.writeBytes("data");
                        this.bfT.writeInt(0);
                        this.buffer = new byte[((this.bgu * this.bgq) / 8) * this.bgo];
                        this.bgn = State.READY;
                    } else {
                        BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on uninitialized recorder");
                        this.bgn = State.ERROR;
                        return false;
                    }
                } else {
                    bgl.prepare();
                    this.bgn = State.READY;
                }
                return true;
            }
            BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on illegal state");
            release();
            this.bgn = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured in prepare()");
            }
            this.bgn = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.bgn == State.RECORDING) {
            stop();
        } else {
            if ((this.bgn == State.READY) & this.bgj) {
                try {
                    this.bfT.close();
                } catch (IOException e) {
                    BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.bgj) {
            if (bgk != null) {
                bgk.release();
            }
        } else if (bgl != null) {
            bgl.release();
        }
    }

    public void start() {
        if (this.bgn == State.READY) {
            if (this.bgj) {
                this.payloadSize = 0;
                bgk.startRecording();
                bgk.read(this.buffer, 0, this.buffer.length);
            } else {
                bgl.start();
            }
            this.bgn = State.RECORDING;
            return;
        }
        BdLog.e(MyAudioRecorder.class.getName() + "start() called on illegal state");
        this.bgn = State.ERROR;
    }

    public void stop() {
        BdLog.e(MyAudioRecorder.class.getName() + "audioRecorder.stop()");
        bgk.stop();
        try {
            this.bfT.seek(4L);
            this.bfT.writeInt(Integer.reverseBytes(this.payloadSize + 36));
            this.bfT.seek(40L);
            this.bfT.writeInt(Integer.reverseBytes(this.payloadSize));
            this.bfT.close();
            BdLog.e(MyAudioRecorder.class.getName() + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
            this.bgn = State.ERROR;
        }
        this.bgn = State.STOPPED;
    }

    private short b(byte b, byte b2) {
        return (short) ((b2 << 8) | b);
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean fc(String str) {
        if (fe(str)) {
            return prepare();
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean EQ() {
        synchronized (mLock) {
            if (this.bgi == null || !this.bgi.isAlive()) {
                this.bgi = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.MyAudioRecorder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MyAudioRecorder.this.EP();
                    }
                });
                this.bgi.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void ER() {
        this.bgn = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean isRecording() {
        return this.bgn == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EP() {
        if (bgk != null) {
            try {
                start();
                while (isRecording()) {
                    bgk.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.bfT.write(this.buffer);
                        this.payloadSize += this.buffer.length;
                        if (this.bgq == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short b = b(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (b > this.bgm) {
                                    this.bgm = b;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.bgm) {
                                    this.bgm = this.buffer[i2];
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
