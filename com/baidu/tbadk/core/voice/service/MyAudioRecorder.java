package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import android.media.MediaRecorder;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.ala.player.StreamConfig;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class MyAudioRecorder implements d {
    private byte[] buffer;
    private int bufferSize;
    private State dlA;
    private short dlB;
    private int dlC;
    private short dlD;
    private int dlE;
    private int dlF;
    private int dlG;
    private RandomAccessFile dlh;
    private boolean dlw;
    private int dlz;
    private String filePath;
    private int payloadSize;
    private Thread writeThread;
    private static final int[] dlv = {StreamConfig.Audio.AUDIO_FREQUENCY, 22050, RequestResponseCode.REQUEST_LOGIN_PB_AT, 8000};
    private static Object mLock = new Object();
    private static AudioRecord dlx = null;
    private static MediaRecorder dly = null;

    /* loaded from: classes.dex */
    public enum State {
        INITIALIZING,
        READY,
        RECORDING,
        ERROR,
        STOPPED
    }

    public static MyAudioRecorder g(Boolean bool) {
        MyAudioRecorder myAudioRecorder;
        synchronized (mLock) {
            dlx = null;
            dly = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, dlv[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.aIP() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, dlv[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State aIP() {
        return this.dlA;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.dlz = 0;
        this.filePath = null;
        try {
            this.dlw = z;
            if (this.dlw) {
                if (i4 == 2) {
                    this.dlD = (short) 16;
                } else {
                    this.dlD = (short) 8;
                }
                if (i3 == 2) {
                    this.dlB = (short) 1;
                } else {
                    this.dlB = (short) 2;
                }
                this.dlE = i;
                this.dlC = i2;
                this.dlF = i4;
                this.dlG = (i2 * 120) / 1000;
                this.bufferSize = (((this.dlG * 2) * this.dlD) * this.dlB) / 8;
                if (this.bufferSize < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.dlG = this.bufferSize / (((this.dlD * 2) * this.dlB) / 8);
                    BdLog.w(MyAudioRecorder.class.getName() + "Increasing buffer size to " + Integer.toString(this.bufferSize));
                }
                dlx = new AudioRecord(i, i2, i3, i4, this.bufferSize);
                if (dlx.getRecordingState() == 3) {
                    dlx.stop();
                }
                if (dlx.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                dly = new MediaRecorder();
                dly.setAudioSource(1);
                dly.setOutputFormat(1);
                dly.setAudioEncoder(1);
            }
            this.dlz = 0;
            this.filePath = null;
            this.dlA = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while initializing recording");
            }
            this.dlA = State.ERROR;
        }
    }

    public boolean ug(String str) {
        try {
            if (this.dlA == State.INITIALIZING) {
                this.filePath = str;
                if (!this.dlw) {
                    dly.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while setting output path");
            }
            this.dlA = State.ERROR;
            return false;
        }
    }

    public boolean prepare() {
        try {
            if (this.dlA == State.INITIALIZING) {
                if (this.dlw) {
                    if ((this.filePath != null) & (dlx.getState() == 1)) {
                        if (this.dlh != null) {
                            this.dlh.close();
                            this.dlh = null;
                        }
                        this.dlh = new RandomAccessFile(this.filePath, "rw");
                        this.dlh.setLength(0L);
                        this.dlh.writeBytes("RIFF");
                        this.dlh.writeInt(0);
                        this.dlh.writeBytes("WAVE");
                        this.dlh.writeBytes("fmt ");
                        this.dlh.writeInt(Integer.reverseBytes(16));
                        this.dlh.writeShort(Short.reverseBytes((short) 1));
                        this.dlh.writeShort(Short.reverseBytes(this.dlB));
                        this.dlh.writeInt(Integer.reverseBytes(this.dlC));
                        this.dlh.writeInt(Integer.reverseBytes(((this.dlC * this.dlD) * this.dlB) / 8));
                        this.dlh.writeShort(Short.reverseBytes((short) ((this.dlB * this.dlD) / 8)));
                        this.dlh.writeShort(Short.reverseBytes(this.dlD));
                        this.dlh.writeBytes("data");
                        this.dlh.writeInt(0);
                        this.buffer = new byte[((this.dlG * this.dlD) / 8) * this.dlB];
                        this.dlA = State.READY;
                    } else {
                        BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on uninitialized recorder");
                        this.dlA = State.ERROR;
                        return false;
                    }
                } else {
                    dly.prepare();
                    this.dlA = State.READY;
                }
                return true;
            }
            BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on illegal state");
            release();
            this.dlA = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured in prepare()");
            }
            this.dlA = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.dlA == State.RECORDING) {
            stop();
        } else {
            if ((this.dlA == State.READY) & this.dlw) {
                try {
                    this.dlh.close();
                } catch (IOException e) {
                    BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.dlw) {
            if (dlx != null) {
                dlx.release();
            }
        } else if (dly != null) {
            dly.release();
        }
    }

    public void start() {
        if (this.dlA == State.READY) {
            if (this.dlw) {
                this.payloadSize = 0;
                dlx.startRecording();
                dlx.read(this.buffer, 0, this.buffer.length);
            } else {
                dly.start();
            }
            this.dlA = State.RECORDING;
            return;
        }
        BdLog.e(MyAudioRecorder.class.getName() + "start() called on illegal state");
        this.dlA = State.ERROR;
    }

    public void stop() {
        BdLog.e(MyAudioRecorder.class.getName() + "audioRecorder.stop()");
        dlx.stop();
        try {
            this.dlh.seek(4L);
            this.dlh.writeInt(Integer.reverseBytes(this.payloadSize + 36));
            this.dlh.seek(40L);
            this.dlh.writeInt(Integer.reverseBytes(this.payloadSize));
            this.dlh.close();
            BdLog.e(MyAudioRecorder.class.getName() + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
            this.dlA = State.ERROR;
        }
        this.dlA = State.STOPPED;
    }

    private short b(byte b, byte b2) {
        return (short) ((b2 << 8) | b);
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean ue(String str) {
        if (ug(str)) {
            return prepare();
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean aIM() {
        synchronized (mLock) {
            if (this.writeThread == null || !this.writeThread.isAlive()) {
                this.writeThread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.MyAudioRecorder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MyAudioRecorder.this.aIL();
                    }
                });
                this.writeThread.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void aIN() {
        this.dlA = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean isRecording() {
        return this.dlA == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIL() {
        if (dlx != null) {
            try {
                start();
                while (isRecording()) {
                    dlx.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.dlh.write(this.buffer);
                        this.payloadSize += this.buffer.length;
                        if (this.dlD == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short b = b(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (b > this.dlz) {
                                    this.dlz = b;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.dlz) {
                                    this.dlz = this.buffer[i2];
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
