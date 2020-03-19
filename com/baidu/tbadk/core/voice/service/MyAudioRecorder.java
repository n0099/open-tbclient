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
    private boolean dlJ;
    private int dlM;
    private State dlN;
    private short dlO;
    private int dlP;
    private short dlQ;
    private int dlR;
    private int dlS;
    private int dlT;
    private RandomAccessFile dlu;
    private String filePath;
    private int payloadSize;
    private Thread writeThread;
    private static final int[] dlI = {StreamConfig.Audio.AUDIO_FREQUENCY, 22050, RequestResponseCode.REQUEST_LOGIN_PB_AT, 8000};
    private static Object mLock = new Object();
    private static AudioRecord dlK = null;
    private static MediaRecorder dlL = null;

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
            dlK = null;
            dlL = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, dlI[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.aIT() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, dlI[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State aIT() {
        return this.dlN;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.dlM = 0;
        this.filePath = null;
        try {
            this.dlJ = z;
            if (this.dlJ) {
                if (i4 == 2) {
                    this.dlQ = (short) 16;
                } else {
                    this.dlQ = (short) 8;
                }
                if (i3 == 2) {
                    this.dlO = (short) 1;
                } else {
                    this.dlO = (short) 2;
                }
                this.dlR = i;
                this.dlP = i2;
                this.dlS = i4;
                this.dlT = (i2 * 120) / 1000;
                this.bufferSize = (((this.dlT * 2) * this.dlQ) * this.dlO) / 8;
                if (this.bufferSize < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.dlT = this.bufferSize / (((this.dlQ * 2) * this.dlO) / 8);
                    BdLog.w(MyAudioRecorder.class.getName() + "Increasing buffer size to " + Integer.toString(this.bufferSize));
                }
                dlK = new AudioRecord(i, i2, i3, i4, this.bufferSize);
                if (dlK.getRecordingState() == 3) {
                    dlK.stop();
                }
                if (dlK.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                dlL = new MediaRecorder();
                dlL.setAudioSource(1);
                dlL.setOutputFormat(1);
                dlL.setAudioEncoder(1);
            }
            this.dlM = 0;
            this.filePath = null;
            this.dlN = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while initializing recording");
            }
            this.dlN = State.ERROR;
        }
    }

    public boolean ug(String str) {
        try {
            if (this.dlN == State.INITIALIZING) {
                this.filePath = str;
                if (!this.dlJ) {
                    dlL.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while setting output path");
            }
            this.dlN = State.ERROR;
            return false;
        }
    }

    public boolean prepare() {
        try {
            if (this.dlN == State.INITIALIZING) {
                if (this.dlJ) {
                    if ((this.filePath != null) & (dlK.getState() == 1)) {
                        if (this.dlu != null) {
                            this.dlu.close();
                            this.dlu = null;
                        }
                        this.dlu = new RandomAccessFile(this.filePath, "rw");
                        this.dlu.setLength(0L);
                        this.dlu.writeBytes("RIFF");
                        this.dlu.writeInt(0);
                        this.dlu.writeBytes("WAVE");
                        this.dlu.writeBytes("fmt ");
                        this.dlu.writeInt(Integer.reverseBytes(16));
                        this.dlu.writeShort(Short.reverseBytes((short) 1));
                        this.dlu.writeShort(Short.reverseBytes(this.dlO));
                        this.dlu.writeInt(Integer.reverseBytes(this.dlP));
                        this.dlu.writeInt(Integer.reverseBytes(((this.dlP * this.dlQ) * this.dlO) / 8));
                        this.dlu.writeShort(Short.reverseBytes((short) ((this.dlO * this.dlQ) / 8)));
                        this.dlu.writeShort(Short.reverseBytes(this.dlQ));
                        this.dlu.writeBytes("data");
                        this.dlu.writeInt(0);
                        this.buffer = new byte[((this.dlT * this.dlQ) / 8) * this.dlO];
                        this.dlN = State.READY;
                    } else {
                        BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on uninitialized recorder");
                        this.dlN = State.ERROR;
                        return false;
                    }
                } else {
                    dlL.prepare();
                    this.dlN = State.READY;
                }
                return true;
            }
            BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on illegal state");
            release();
            this.dlN = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured in prepare()");
            }
            this.dlN = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.dlN == State.RECORDING) {
            stop();
        } else {
            if ((this.dlN == State.READY) & this.dlJ) {
                try {
                    this.dlu.close();
                } catch (IOException e) {
                    BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.dlJ) {
            if (dlK != null) {
                dlK.release();
            }
        } else if (dlL != null) {
            dlL.release();
        }
    }

    public void start() {
        if (this.dlN == State.READY) {
            if (this.dlJ) {
                this.payloadSize = 0;
                dlK.startRecording();
                dlK.read(this.buffer, 0, this.buffer.length);
            } else {
                dlL.start();
            }
            this.dlN = State.RECORDING;
            return;
        }
        BdLog.e(MyAudioRecorder.class.getName() + "start() called on illegal state");
        this.dlN = State.ERROR;
    }

    public void stop() {
        BdLog.e(MyAudioRecorder.class.getName() + "audioRecorder.stop()");
        dlK.stop();
        try {
            this.dlu.seek(4L);
            this.dlu.writeInt(Integer.reverseBytes(this.payloadSize + 36));
            this.dlu.seek(40L);
            this.dlu.writeInt(Integer.reverseBytes(this.payloadSize));
            this.dlu.close();
            BdLog.e(MyAudioRecorder.class.getName() + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
            this.dlN = State.ERROR;
        }
        this.dlN = State.STOPPED;
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
    public boolean aIQ() {
        synchronized (mLock) {
            if (this.writeThread == null || !this.writeThread.isAlive()) {
                this.writeThread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.MyAudioRecorder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MyAudioRecorder.this.aIP();
                    }
                });
                this.writeThread.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void aIR() {
        this.dlN = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean isRecording() {
        return this.dlN == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIP() {
        if (dlK != null) {
            try {
                start();
                while (isRecording()) {
                    dlK.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.dlu.write(this.buffer);
                        this.payloadSize += this.buffer.length;
                        if (this.dlQ == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short b = b(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (b > this.dlM) {
                                    this.dlM = b;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.dlM) {
                                    this.dlM = this.buffer[i2];
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
