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
    private RandomAccessFile dgN;
    private boolean dhc;
    private int dhf;
    private State dhg;
    private short dhh;
    private int dhi;
    private short dhj;
    private int dhk;
    private int dhl;
    private int dhm;
    private String filePath;
    private int payloadSize;
    private Thread writeThread;
    private static final int[] dhb = {StreamConfig.Audio.AUDIO_FREQUENCY, 22050, RequestResponseCode.REQUEST_LOGIN_PB_AT, 8000};
    private static Object mLock = new Object();
    private static AudioRecord dhd = null;
    private static MediaRecorder dhe = null;

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
            dhd = null;
            dhe = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, dhb[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.aGx() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, dhb[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State aGx() {
        return this.dhg;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.dhf = 0;
        this.filePath = null;
        try {
            this.dhc = z;
            if (this.dhc) {
                if (i4 == 2) {
                    this.dhj = (short) 16;
                } else {
                    this.dhj = (short) 8;
                }
                if (i3 == 2) {
                    this.dhh = (short) 1;
                } else {
                    this.dhh = (short) 2;
                }
                this.dhk = i;
                this.dhi = i2;
                this.dhl = i4;
                this.dhm = (i2 * 120) / 1000;
                this.bufferSize = (((this.dhm * 2) * this.dhj) * this.dhh) / 8;
                if (this.bufferSize < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.dhm = this.bufferSize / (((this.dhj * 2) * this.dhh) / 8);
                    BdLog.w(MyAudioRecorder.class.getName() + "Increasing buffer size to " + Integer.toString(this.bufferSize));
                }
                dhd = new AudioRecord(i, i2, i3, i4, this.bufferSize);
                if (dhd.getRecordingState() == 3) {
                    dhd.stop();
                }
                if (dhd.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                dhe = new MediaRecorder();
                dhe.setAudioSource(1);
                dhe.setOutputFormat(1);
                dhe.setAudioEncoder(1);
            }
            this.dhf = 0;
            this.filePath = null;
            this.dhg = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while initializing recording");
            }
            this.dhg = State.ERROR;
        }
    }

    public boolean tP(String str) {
        try {
            if (this.dhg == State.INITIALIZING) {
                this.filePath = str;
                if (!this.dhc) {
                    dhe.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while setting output path");
            }
            this.dhg = State.ERROR;
            return false;
        }
    }

    public boolean prepare() {
        try {
            if (this.dhg == State.INITIALIZING) {
                if (this.dhc) {
                    if ((this.filePath != null) & (dhd.getState() == 1)) {
                        if (this.dgN != null) {
                            this.dgN.close();
                            this.dgN = null;
                        }
                        this.dgN = new RandomAccessFile(this.filePath, "rw");
                        this.dgN.setLength(0L);
                        this.dgN.writeBytes("RIFF");
                        this.dgN.writeInt(0);
                        this.dgN.writeBytes("WAVE");
                        this.dgN.writeBytes("fmt ");
                        this.dgN.writeInt(Integer.reverseBytes(16));
                        this.dgN.writeShort(Short.reverseBytes((short) 1));
                        this.dgN.writeShort(Short.reverseBytes(this.dhh));
                        this.dgN.writeInt(Integer.reverseBytes(this.dhi));
                        this.dgN.writeInt(Integer.reverseBytes(((this.dhi * this.dhj) * this.dhh) / 8));
                        this.dgN.writeShort(Short.reverseBytes((short) ((this.dhh * this.dhj) / 8)));
                        this.dgN.writeShort(Short.reverseBytes(this.dhj));
                        this.dgN.writeBytes("data");
                        this.dgN.writeInt(0);
                        this.buffer = new byte[((this.dhm * this.dhj) / 8) * this.dhh];
                        this.dhg = State.READY;
                    } else {
                        BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on uninitialized recorder");
                        this.dhg = State.ERROR;
                        return false;
                    }
                } else {
                    dhe.prepare();
                    this.dhg = State.READY;
                }
                return true;
            }
            BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on illegal state");
            release();
            this.dhg = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured in prepare()");
            }
            this.dhg = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.dhg == State.RECORDING) {
            stop();
        } else {
            if ((this.dhg == State.READY) & this.dhc) {
                try {
                    this.dgN.close();
                } catch (IOException e) {
                    BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.dhc) {
            if (dhd != null) {
                dhd.release();
            }
        } else if (dhe != null) {
            dhe.release();
        }
    }

    public void start() {
        if (this.dhg == State.READY) {
            if (this.dhc) {
                this.payloadSize = 0;
                dhd.startRecording();
                dhd.read(this.buffer, 0, this.buffer.length);
            } else {
                dhe.start();
            }
            this.dhg = State.RECORDING;
            return;
        }
        BdLog.e(MyAudioRecorder.class.getName() + "start() called on illegal state");
        this.dhg = State.ERROR;
    }

    public void stop() {
        BdLog.e(MyAudioRecorder.class.getName() + "audioRecorder.stop()");
        dhd.stop();
        try {
            this.dgN.seek(4L);
            this.dgN.writeInt(Integer.reverseBytes(this.payloadSize + 36));
            this.dgN.seek(40L);
            this.dgN.writeInt(Integer.reverseBytes(this.payloadSize));
            this.dgN.close();
            BdLog.e(MyAudioRecorder.class.getName() + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
            this.dhg = State.ERROR;
        }
        this.dhg = State.STOPPED;
    }

    private short b(byte b, byte b2) {
        return (short) ((b2 << 8) | b);
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean tN(String str) {
        if (tP(str)) {
            return prepare();
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean aGu() {
        synchronized (mLock) {
            if (this.writeThread == null || !this.writeThread.isAlive()) {
                this.writeThread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.MyAudioRecorder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MyAudioRecorder.this.aGt();
                    }
                });
                this.writeThread.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void aGv() {
        this.dhg = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean isRecording() {
        return this.dhg == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGt() {
        if (dhd != null) {
            try {
                start();
                while (isRecording()) {
                    dhd.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.dgN.write(this.buffer);
                        this.payloadSize += this.buffer.length;
                        if (this.dhj == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short b = b(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (b > this.dhf) {
                                    this.dhf = b;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.dhf) {
                                    this.dhf = this.buffer[i2];
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
