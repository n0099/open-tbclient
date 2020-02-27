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
    private RandomAccessFile dkT;
    private boolean dli;
    private int dll;
    private State dlm;
    private short dln;
    private int dlo;
    private short dlp;
    private int dlq;
    private int dlr;
    private int dls;
    private String filePath;
    private int payloadSize;
    private Thread writeThread;
    private static final int[] dlh = {StreamConfig.Audio.AUDIO_FREQUENCY, 22050, RequestResponseCode.REQUEST_LOGIN_PB_AT, 8000};
    private static Object mLock = new Object();
    private static AudioRecord dlj = null;
    private static MediaRecorder dlk = null;

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
            dlj = null;
            dlk = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, dlh[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.aIM() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, dlh[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State aIM() {
        return this.dlm;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.dll = 0;
        this.filePath = null;
        try {
            this.dli = z;
            if (this.dli) {
                if (i4 == 2) {
                    this.dlp = (short) 16;
                } else {
                    this.dlp = (short) 8;
                }
                if (i3 == 2) {
                    this.dln = (short) 1;
                } else {
                    this.dln = (short) 2;
                }
                this.dlq = i;
                this.dlo = i2;
                this.dlr = i4;
                this.dls = (i2 * 120) / 1000;
                this.bufferSize = (((this.dls * 2) * this.dlp) * this.dln) / 8;
                if (this.bufferSize < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.dls = this.bufferSize / (((this.dlp * 2) * this.dln) / 8);
                    BdLog.w(MyAudioRecorder.class.getName() + "Increasing buffer size to " + Integer.toString(this.bufferSize));
                }
                dlj = new AudioRecord(i, i2, i3, i4, this.bufferSize);
                if (dlj.getRecordingState() == 3) {
                    dlj.stop();
                }
                if (dlj.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                dlk = new MediaRecorder();
                dlk.setAudioSource(1);
                dlk.setOutputFormat(1);
                dlk.setAudioEncoder(1);
            }
            this.dll = 0;
            this.filePath = null;
            this.dlm = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while initializing recording");
            }
            this.dlm = State.ERROR;
        }
    }

    public boolean uf(String str) {
        try {
            if (this.dlm == State.INITIALIZING) {
                this.filePath = str;
                if (!this.dli) {
                    dlk.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while setting output path");
            }
            this.dlm = State.ERROR;
            return false;
        }
    }

    public boolean prepare() {
        try {
            if (this.dlm == State.INITIALIZING) {
                if (this.dli) {
                    if ((this.filePath != null) & (dlj.getState() == 1)) {
                        if (this.dkT != null) {
                            this.dkT.close();
                            this.dkT = null;
                        }
                        this.dkT = new RandomAccessFile(this.filePath, "rw");
                        this.dkT.setLength(0L);
                        this.dkT.writeBytes("RIFF");
                        this.dkT.writeInt(0);
                        this.dkT.writeBytes("WAVE");
                        this.dkT.writeBytes("fmt ");
                        this.dkT.writeInt(Integer.reverseBytes(16));
                        this.dkT.writeShort(Short.reverseBytes((short) 1));
                        this.dkT.writeShort(Short.reverseBytes(this.dln));
                        this.dkT.writeInt(Integer.reverseBytes(this.dlo));
                        this.dkT.writeInt(Integer.reverseBytes(((this.dlo * this.dlp) * this.dln) / 8));
                        this.dkT.writeShort(Short.reverseBytes((short) ((this.dln * this.dlp) / 8)));
                        this.dkT.writeShort(Short.reverseBytes(this.dlp));
                        this.dkT.writeBytes("data");
                        this.dkT.writeInt(0);
                        this.buffer = new byte[((this.dls * this.dlp) / 8) * this.dln];
                        this.dlm = State.READY;
                    } else {
                        BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on uninitialized recorder");
                        this.dlm = State.ERROR;
                        return false;
                    }
                } else {
                    dlk.prepare();
                    this.dlm = State.READY;
                }
                return true;
            }
            BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on illegal state");
            release();
            this.dlm = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured in prepare()");
            }
            this.dlm = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.dlm == State.RECORDING) {
            stop();
        } else {
            if ((this.dlm == State.READY) & this.dli) {
                try {
                    this.dkT.close();
                } catch (IOException e) {
                    BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.dli) {
            if (dlj != null) {
                dlj.release();
            }
        } else if (dlk != null) {
            dlk.release();
        }
    }

    public void start() {
        if (this.dlm == State.READY) {
            if (this.dli) {
                this.payloadSize = 0;
                dlj.startRecording();
                dlj.read(this.buffer, 0, this.buffer.length);
            } else {
                dlk.start();
            }
            this.dlm = State.RECORDING;
            return;
        }
        BdLog.e(MyAudioRecorder.class.getName() + "start() called on illegal state");
        this.dlm = State.ERROR;
    }

    public void stop() {
        BdLog.e(MyAudioRecorder.class.getName() + "audioRecorder.stop()");
        dlj.stop();
        try {
            this.dkT.seek(4L);
            this.dkT.writeInt(Integer.reverseBytes(this.payloadSize + 36));
            this.dkT.seek(40L);
            this.dkT.writeInt(Integer.reverseBytes(this.payloadSize));
            this.dkT.close();
            BdLog.e(MyAudioRecorder.class.getName() + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
            this.dlm = State.ERROR;
        }
        this.dlm = State.STOPPED;
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
    public boolean aIJ() {
        synchronized (mLock) {
            if (this.writeThread == null || !this.writeThread.isAlive()) {
                this.writeThread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.MyAudioRecorder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MyAudioRecorder.this.aII();
                    }
                });
                this.writeThread.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void aIK() {
        this.dlm = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean isRecording() {
        return this.dlm == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aII() {
        if (dlj != null) {
            try {
                start();
                while (isRecording()) {
                    dlj.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.dkT.write(this.buffer);
                        this.payloadSize += this.buffer.length;
                        if (this.dlp == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short b = b(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (b > this.dll) {
                                    this.dll = b;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.dll) {
                                    this.dll = this.buffer[i2];
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
