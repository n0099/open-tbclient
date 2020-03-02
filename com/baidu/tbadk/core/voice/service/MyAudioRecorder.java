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
    private RandomAccessFile dkU;
    private boolean dlj;
    private int dlm;
    private State dln;
    private short dlo;
    private int dlp;
    private short dlq;
    private int dlr;
    private int dls;
    private int dlt;
    private String filePath;
    private int payloadSize;
    private Thread writeThread;
    private static final int[] dli = {StreamConfig.Audio.AUDIO_FREQUENCY, 22050, RequestResponseCode.REQUEST_LOGIN_PB_AT, 8000};
    private static Object mLock = new Object();
    private static AudioRecord dlk = null;
    private static MediaRecorder dll = null;

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
            dlk = null;
            dll = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, dli[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.aIO() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, dli[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State aIO() {
        return this.dln;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.dlm = 0;
        this.filePath = null;
        try {
            this.dlj = z;
            if (this.dlj) {
                if (i4 == 2) {
                    this.dlq = (short) 16;
                } else {
                    this.dlq = (short) 8;
                }
                if (i3 == 2) {
                    this.dlo = (short) 1;
                } else {
                    this.dlo = (short) 2;
                }
                this.dlr = i;
                this.dlp = i2;
                this.dls = i4;
                this.dlt = (i2 * 120) / 1000;
                this.bufferSize = (((this.dlt * 2) * this.dlq) * this.dlo) / 8;
                if (this.bufferSize < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.dlt = this.bufferSize / (((this.dlq * 2) * this.dlo) / 8);
                    BdLog.w(MyAudioRecorder.class.getName() + "Increasing buffer size to " + Integer.toString(this.bufferSize));
                }
                dlk = new AudioRecord(i, i2, i3, i4, this.bufferSize);
                if (dlk.getRecordingState() == 3) {
                    dlk.stop();
                }
                if (dlk.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                dll = new MediaRecorder();
                dll.setAudioSource(1);
                dll.setOutputFormat(1);
                dll.setAudioEncoder(1);
            }
            this.dlm = 0;
            this.filePath = null;
            this.dln = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while initializing recording");
            }
            this.dln = State.ERROR;
        }
    }

    public boolean uf(String str) {
        try {
            if (this.dln == State.INITIALIZING) {
                this.filePath = str;
                if (!this.dlj) {
                    dll.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while setting output path");
            }
            this.dln = State.ERROR;
            return false;
        }
    }

    public boolean prepare() {
        try {
            if (this.dln == State.INITIALIZING) {
                if (this.dlj) {
                    if ((this.filePath != null) & (dlk.getState() == 1)) {
                        if (this.dkU != null) {
                            this.dkU.close();
                            this.dkU = null;
                        }
                        this.dkU = new RandomAccessFile(this.filePath, "rw");
                        this.dkU.setLength(0L);
                        this.dkU.writeBytes("RIFF");
                        this.dkU.writeInt(0);
                        this.dkU.writeBytes("WAVE");
                        this.dkU.writeBytes("fmt ");
                        this.dkU.writeInt(Integer.reverseBytes(16));
                        this.dkU.writeShort(Short.reverseBytes((short) 1));
                        this.dkU.writeShort(Short.reverseBytes(this.dlo));
                        this.dkU.writeInt(Integer.reverseBytes(this.dlp));
                        this.dkU.writeInt(Integer.reverseBytes(((this.dlp * this.dlq) * this.dlo) / 8));
                        this.dkU.writeShort(Short.reverseBytes((short) ((this.dlo * this.dlq) / 8)));
                        this.dkU.writeShort(Short.reverseBytes(this.dlq));
                        this.dkU.writeBytes("data");
                        this.dkU.writeInt(0);
                        this.buffer = new byte[((this.dlt * this.dlq) / 8) * this.dlo];
                        this.dln = State.READY;
                    } else {
                        BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on uninitialized recorder");
                        this.dln = State.ERROR;
                        return false;
                    }
                } else {
                    dll.prepare();
                    this.dln = State.READY;
                }
                return true;
            }
            BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on illegal state");
            release();
            this.dln = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured in prepare()");
            }
            this.dln = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.dln == State.RECORDING) {
            stop();
        } else {
            if ((this.dln == State.READY) & this.dlj) {
                try {
                    this.dkU.close();
                } catch (IOException e) {
                    BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.dlj) {
            if (dlk != null) {
                dlk.release();
            }
        } else if (dll != null) {
            dll.release();
        }
    }

    public void start() {
        if (this.dln == State.READY) {
            if (this.dlj) {
                this.payloadSize = 0;
                dlk.startRecording();
                dlk.read(this.buffer, 0, this.buffer.length);
            } else {
                dll.start();
            }
            this.dln = State.RECORDING;
            return;
        }
        BdLog.e(MyAudioRecorder.class.getName() + "start() called on illegal state");
        this.dln = State.ERROR;
    }

    public void stop() {
        BdLog.e(MyAudioRecorder.class.getName() + "audioRecorder.stop()");
        dlk.stop();
        try {
            this.dkU.seek(4L);
            this.dkU.writeInt(Integer.reverseBytes(this.payloadSize + 36));
            this.dkU.seek(40L);
            this.dkU.writeInt(Integer.reverseBytes(this.payloadSize));
            this.dkU.close();
            BdLog.e(MyAudioRecorder.class.getName() + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
            this.dln = State.ERROR;
        }
        this.dln = State.STOPPED;
    }

    private short b(byte b, byte b2) {
        return (short) ((b2 << 8) | b);
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean ud(String str) {
        if (uf(str)) {
            return prepare();
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean aIL() {
        synchronized (mLock) {
            if (this.writeThread == null || !this.writeThread.isAlive()) {
                this.writeThread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.MyAudioRecorder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MyAudioRecorder.this.aIK();
                    }
                });
                this.writeThread.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void aIM() {
        this.dln = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean isRecording() {
        return this.dln == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIK() {
        if (dlk != null) {
            try {
                start();
                while (isRecording()) {
                    dlk.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.dkU.write(this.buffer);
                        this.payloadSize += this.buffer.length;
                        if (this.dlq == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short b = b(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (b > this.dlm) {
                                    this.dlm = b;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.dlm) {
                                    this.dlm = this.buffer[i2];
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
