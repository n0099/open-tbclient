package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import android.media.MediaRecorder;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class MyAudioRecorder implements d {
    private short bgA;
    private int bgB;
    private int bgC;
    private int bgD;
    private int bgb;
    private RandomAccessFile bgc;
    private Thread bgr;
    private boolean bgt;
    private int bgw;
    private State bgx;
    private short bgy;
    private int bgz;
    private byte[] buffer;
    private String filePath;
    private int payloadSize;
    private static final int[] bgq = {44100, 22050, 11025, 8000};
    private static Object mLock = new Object();
    private static AudioRecord bgu = null;
    private static MediaRecorder bgv = null;

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
            bgu = null;
            bgv = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, bgq[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.EU() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, bgq[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State EU() {
        return this.bgx;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.bgw = 0;
        this.filePath = null;
        try {
            this.bgt = z;
            if (this.bgt) {
                if (i4 == 2) {
                    this.bgA = (short) 16;
                } else {
                    this.bgA = (short) 8;
                }
                if (i3 == 2) {
                    this.bgy = (short) 1;
                } else {
                    this.bgy = (short) 2;
                }
                this.bgB = i;
                this.bgz = i2;
                this.bgC = i4;
                this.bgD = (i2 * 120) / 1000;
                this.bgb = (((this.bgD * 2) * this.bgA) * this.bgy) / 8;
                if (this.bgb < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.bgb = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.bgD = this.bgb / (((this.bgA * 2) * this.bgy) / 8);
                    BdLog.w(MyAudioRecorder.class.getName() + "Increasing buffer size to " + Integer.toString(this.bgb));
                }
                bgu = new AudioRecord(i, i2, i3, i4, this.bgb);
                if (bgu.getRecordingState() == 3) {
                    bgu.stop();
                }
                if (bgu.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                bgv = new MediaRecorder();
                bgv.setAudioSource(1);
                bgv.setOutputFormat(1);
                bgv.setAudioEncoder(1);
            }
            this.bgw = 0;
            this.filePath = null;
            this.bgx = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while initializing recording");
            }
            this.bgx = State.ERROR;
        }
    }

    public boolean fe(String str) {
        try {
            if (this.bgx == State.INITIALIZING) {
                this.filePath = str;
                if (!this.bgt) {
                    bgv.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while setting output path");
            }
            this.bgx = State.ERROR;
            return false;
        }
    }

    public boolean prepare() {
        try {
            if (this.bgx == State.INITIALIZING) {
                if (this.bgt) {
                    if ((this.filePath != null) & (bgu.getState() == 1)) {
                        if (this.bgc != null) {
                            this.bgc.close();
                            this.bgc = null;
                        }
                        this.bgc = new RandomAccessFile(this.filePath, "rw");
                        this.bgc.setLength(0L);
                        this.bgc.writeBytes("RIFF");
                        this.bgc.writeInt(0);
                        this.bgc.writeBytes("WAVE");
                        this.bgc.writeBytes("fmt ");
                        this.bgc.writeInt(Integer.reverseBytes(16));
                        this.bgc.writeShort(Short.reverseBytes((short) 1));
                        this.bgc.writeShort(Short.reverseBytes(this.bgy));
                        this.bgc.writeInt(Integer.reverseBytes(this.bgz));
                        this.bgc.writeInt(Integer.reverseBytes(((this.bgz * this.bgA) * this.bgy) / 8));
                        this.bgc.writeShort(Short.reverseBytes((short) ((this.bgy * this.bgA) / 8)));
                        this.bgc.writeShort(Short.reverseBytes(this.bgA));
                        this.bgc.writeBytes("data");
                        this.bgc.writeInt(0);
                        this.buffer = new byte[((this.bgD * this.bgA) / 8) * this.bgy];
                        this.bgx = State.READY;
                    } else {
                        BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on uninitialized recorder");
                        this.bgx = State.ERROR;
                        return false;
                    }
                } else {
                    bgv.prepare();
                    this.bgx = State.READY;
                }
                return true;
            }
            BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on illegal state");
            release();
            this.bgx = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured in prepare()");
            }
            this.bgx = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.bgx == State.RECORDING) {
            stop();
        } else {
            if ((this.bgx == State.READY) & this.bgt) {
                try {
                    this.bgc.close();
                } catch (IOException e) {
                    BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.bgt) {
            if (bgu != null) {
                bgu.release();
            }
        } else if (bgv != null) {
            bgv.release();
        }
    }

    public void start() {
        if (this.bgx == State.READY) {
            if (this.bgt) {
                this.payloadSize = 0;
                bgu.startRecording();
                bgu.read(this.buffer, 0, this.buffer.length);
            } else {
                bgv.start();
            }
            this.bgx = State.RECORDING;
            return;
        }
        BdLog.e(MyAudioRecorder.class.getName() + "start() called on illegal state");
        this.bgx = State.ERROR;
    }

    public void stop() {
        BdLog.e(MyAudioRecorder.class.getName() + "audioRecorder.stop()");
        bgu.stop();
        try {
            this.bgc.seek(4L);
            this.bgc.writeInt(Integer.reverseBytes(this.payloadSize + 36));
            this.bgc.seek(40L);
            this.bgc.writeInt(Integer.reverseBytes(this.payloadSize));
            this.bgc.close();
            BdLog.e(MyAudioRecorder.class.getName() + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
            this.bgx = State.ERROR;
        }
        this.bgx = State.STOPPED;
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
            if (this.bgr == null || !this.bgr.isAlive()) {
                this.bgr = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.MyAudioRecorder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MyAudioRecorder.this.EP();
                    }
                });
                this.bgr.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void ER() {
        this.bgx = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean isRecording() {
        return this.bgx == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EP() {
        if (bgu != null) {
            try {
                start();
                while (isRecording()) {
                    bgu.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.bgc.write(this.buffer);
                        this.payloadSize += this.buffer.length;
                        if (this.bgA == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short b = b(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (b > this.bgw) {
                                    this.bgw = b;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.bgw) {
                                    this.bgw = this.buffer[i2];
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
