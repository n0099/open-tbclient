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
    private RandomAccessFile dgB;
    private boolean dgQ;
    private int dgT;
    private State dgU;
    private short dgV;
    private int dgW;
    private short dgX;
    private int dgY;
    private int dgZ;
    private int dha;
    private String filePath;
    private int payloadSize;
    private Thread writeThread;
    private static final int[] dgP = {StreamConfig.Audio.AUDIO_FREQUENCY, 22050, RequestResponseCode.REQUEST_LOGIN_PB_AT, 8000};
    private static Object mLock = new Object();
    private static AudioRecord dgR = null;
    private static MediaRecorder dgS = null;

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
            dgR = null;
            dgS = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, dgP[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.aGe() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, dgP[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State aGe() {
        return this.dgU;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.dgT = 0;
        this.filePath = null;
        try {
            this.dgQ = z;
            if (this.dgQ) {
                if (i4 == 2) {
                    this.dgX = (short) 16;
                } else {
                    this.dgX = (short) 8;
                }
                if (i3 == 2) {
                    this.dgV = (short) 1;
                } else {
                    this.dgV = (short) 2;
                }
                this.dgY = i;
                this.dgW = i2;
                this.dgZ = i4;
                this.dha = (i2 * 120) / 1000;
                this.bufferSize = (((this.dha * 2) * this.dgX) * this.dgV) / 8;
                if (this.bufferSize < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.dha = this.bufferSize / (((this.dgX * 2) * this.dgV) / 8);
                    BdLog.w(MyAudioRecorder.class.getName() + "Increasing buffer size to " + Integer.toString(this.bufferSize));
                }
                dgR = new AudioRecord(i, i2, i3, i4, this.bufferSize);
                if (dgR.getRecordingState() == 3) {
                    dgR.stop();
                }
                if (dgR.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                dgS = new MediaRecorder();
                dgS.setAudioSource(1);
                dgS.setOutputFormat(1);
                dgS.setAudioEncoder(1);
            }
            this.dgT = 0;
            this.filePath = null;
            this.dgU = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while initializing recording");
            }
            this.dgU = State.ERROR;
        }
    }

    public boolean tL(String str) {
        try {
            if (this.dgU == State.INITIALIZING) {
                this.filePath = str;
                if (!this.dgQ) {
                    dgS.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while setting output path");
            }
            this.dgU = State.ERROR;
            return false;
        }
    }

    public boolean prepare() {
        try {
            if (this.dgU == State.INITIALIZING) {
                if (this.dgQ) {
                    if ((this.filePath != null) & (dgR.getState() == 1)) {
                        if (this.dgB != null) {
                            this.dgB.close();
                            this.dgB = null;
                        }
                        this.dgB = new RandomAccessFile(this.filePath, "rw");
                        this.dgB.setLength(0L);
                        this.dgB.writeBytes("RIFF");
                        this.dgB.writeInt(0);
                        this.dgB.writeBytes("WAVE");
                        this.dgB.writeBytes("fmt ");
                        this.dgB.writeInt(Integer.reverseBytes(16));
                        this.dgB.writeShort(Short.reverseBytes((short) 1));
                        this.dgB.writeShort(Short.reverseBytes(this.dgV));
                        this.dgB.writeInt(Integer.reverseBytes(this.dgW));
                        this.dgB.writeInt(Integer.reverseBytes(((this.dgW * this.dgX) * this.dgV) / 8));
                        this.dgB.writeShort(Short.reverseBytes((short) ((this.dgV * this.dgX) / 8)));
                        this.dgB.writeShort(Short.reverseBytes(this.dgX));
                        this.dgB.writeBytes("data");
                        this.dgB.writeInt(0);
                        this.buffer = new byte[((this.dha * this.dgX) / 8) * this.dgV];
                        this.dgU = State.READY;
                    } else {
                        BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on uninitialized recorder");
                        this.dgU = State.ERROR;
                        return false;
                    }
                } else {
                    dgS.prepare();
                    this.dgU = State.READY;
                }
                return true;
            }
            BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on illegal state");
            release();
            this.dgU = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured in prepare()");
            }
            this.dgU = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.dgU == State.RECORDING) {
            stop();
        } else {
            if ((this.dgU == State.READY) & this.dgQ) {
                try {
                    this.dgB.close();
                } catch (IOException e) {
                    BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.dgQ) {
            if (dgR != null) {
                dgR.release();
            }
        } else if (dgS != null) {
            dgS.release();
        }
    }

    public void start() {
        if (this.dgU == State.READY) {
            if (this.dgQ) {
                this.payloadSize = 0;
                dgR.startRecording();
                dgR.read(this.buffer, 0, this.buffer.length);
            } else {
                dgS.start();
            }
            this.dgU = State.RECORDING;
            return;
        }
        BdLog.e(MyAudioRecorder.class.getName() + "start() called on illegal state");
        this.dgU = State.ERROR;
    }

    public void stop() {
        BdLog.e(MyAudioRecorder.class.getName() + "audioRecorder.stop()");
        dgR.stop();
        try {
            this.dgB.seek(4L);
            this.dgB.writeInt(Integer.reverseBytes(this.payloadSize + 36));
            this.dgB.seek(40L);
            this.dgB.writeInt(Integer.reverseBytes(this.payloadSize));
            this.dgB.close();
            BdLog.e(MyAudioRecorder.class.getName() + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
            this.dgU = State.ERROR;
        }
        this.dgU = State.STOPPED;
    }

    private short b(byte b, byte b2) {
        return (short) ((b2 << 8) | b);
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean tJ(String str) {
        if (tL(str)) {
            return prepare();
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean aGb() {
        synchronized (mLock) {
            if (this.writeThread == null || !this.writeThread.isAlive()) {
                this.writeThread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.MyAudioRecorder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MyAudioRecorder.this.aGa();
                    }
                });
                this.writeThread.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void aGc() {
        this.dgU = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean isRecording() {
        return this.dgU == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGa() {
        if (dgR != null) {
            try {
                start();
                while (isRecording()) {
                    dgR.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.dgB.write(this.buffer);
                        this.payloadSize += this.buffer.length;
                        if (this.dgX == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short b = b(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (b > this.dgT) {
                                    this.dgT = b;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.dgT) {
                                    this.dgT = this.buffer[i2];
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
