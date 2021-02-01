package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import android.media.MediaRecorder;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.yy.mediaframework.stat.VideoDataStatistic;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class MyAudioRecorder implements d {
    private byte[] buffer;
    private int bufferSize;
    private String filePath;
    private boolean fpG;
    private int fpJ;
    private State fpK;
    private short fpL;
    private int fpM;
    private short fpN;
    private int fpO;
    private int fpP;
    private int fpQ;
    private RandomAccessFile fpp;
    private int payloadSize;
    private Thread writeThread;
    private static final int[] fpF = {44100, 22050, RequestResponseCode.REQUEST_LOGIN_PB_AT, 8000};
    private static Object mLock = new Object();
    private static AudioRecord fpH = null;
    private static MediaRecorder fpI = null;

    /* loaded from: classes.dex */
    public enum State {
        INITIALIZING,
        READY,
        RECORDING,
        ERROR,
        STOPPED
    }

    public static MyAudioRecorder m(Boolean bool) {
        MyAudioRecorder myAudioRecorder;
        synchronized (mLock) {
            fpH = null;
            fpI = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, fpF[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.bvK() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, fpF[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State bvK() {
        return this.fpK;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.fpJ = 0;
        this.filePath = null;
        try {
            this.fpG = z;
            if (this.fpG) {
                if (i4 == 2) {
                    this.fpN = (short) 16;
                } else {
                    this.fpN = (short) 8;
                }
                if (i3 == 2) {
                    this.fpL = (short) 1;
                } else {
                    this.fpL = (short) 2;
                }
                this.fpO = i;
                this.fpM = i2;
                this.fpP = i4;
                this.fpQ = (i2 * 120) / 1000;
                this.bufferSize = (((this.fpQ * 2) * this.fpN) * this.fpL) / 8;
                if (this.bufferSize < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.fpQ = this.bufferSize / (((this.fpN * 2) * this.fpL) / 8);
                    BdLog.w(MyAudioRecorder.class.getName() + "Increasing buffer size to " + Integer.toString(this.bufferSize));
                }
                fpH = new AudioRecord(i, i2, i3, i4, this.bufferSize);
                if (fpH.getRecordingState() == 3) {
                    fpH.stop();
                }
                if (fpH.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                fpI = new MediaRecorder();
                fpI.setAudioSource(1);
                fpI.setOutputFormat(1);
                fpI.setAudioEncoder(1);
            }
            this.fpJ = 0;
            this.filePath = null;
            this.fpK = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while initializing recording");
            }
            this.fpK = State.ERROR;
        }
    }

    public boolean BQ(String str) {
        try {
            if (this.fpK == State.INITIALIZING) {
                this.filePath = str;
                if (!this.fpG) {
                    fpI.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while setting output path");
            }
            this.fpK = State.ERROR;
            return false;
        }
    }

    public boolean prepare() {
        try {
            if (this.fpK == State.INITIALIZING) {
                if (this.fpG) {
                    if ((this.filePath != null) & (fpH.getState() == 1)) {
                        if (this.fpp != null) {
                            this.fpp.close();
                            this.fpp = null;
                        }
                        this.fpp = new RandomAccessFile(this.filePath, VideoDataStatistic.AnchorHiidoCoreStatisticKey.CaptureRealResolutionWidth);
                        this.fpp.setLength(0L);
                        this.fpp.writeBytes("RIFF");
                        this.fpp.writeInt(0);
                        this.fpp.writeBytes("WAVE");
                        this.fpp.writeBytes("fmt ");
                        this.fpp.writeInt(Integer.reverseBytes(16));
                        this.fpp.writeShort(Short.reverseBytes((short) 1));
                        this.fpp.writeShort(Short.reverseBytes(this.fpL));
                        this.fpp.writeInt(Integer.reverseBytes(this.fpM));
                        this.fpp.writeInt(Integer.reverseBytes(((this.fpM * this.fpN) * this.fpL) / 8));
                        this.fpp.writeShort(Short.reverseBytes((short) ((this.fpL * this.fpN) / 8)));
                        this.fpp.writeShort(Short.reverseBytes(this.fpN));
                        this.fpp.writeBytes("data");
                        this.fpp.writeInt(0);
                        this.buffer = new byte[((this.fpQ * this.fpN) / 8) * this.fpL];
                        this.fpK = State.READY;
                    } else {
                        BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on uninitialized recorder");
                        this.fpK = State.ERROR;
                        return false;
                    }
                } else {
                    fpI.prepare();
                    this.fpK = State.READY;
                }
                return true;
            }
            BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on illegal state");
            release();
            this.fpK = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured in prepare()");
            }
            this.fpK = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.fpK == State.RECORDING) {
            stop();
        } else {
            if ((this.fpK == State.READY) & this.fpG) {
                try {
                    this.fpp.close();
                } catch (IOException e) {
                    BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.fpG) {
            if (fpH != null) {
                fpH.release();
            }
        } else if (fpI != null) {
            fpI.release();
        }
    }

    public void start() {
        if (this.fpK == State.READY) {
            if (this.fpG) {
                this.payloadSize = 0;
                fpH.startRecording();
                fpH.read(this.buffer, 0, this.buffer.length);
            } else {
                fpI.start();
            }
            this.fpK = State.RECORDING;
            return;
        }
        BdLog.e(MyAudioRecorder.class.getName() + "start() called on illegal state");
        this.fpK = State.ERROR;
    }

    public void stop() {
        BdLog.e(MyAudioRecorder.class.getName() + "audioRecorder.stop()");
        fpH.stop();
        try {
            this.fpp.seek(4L);
            this.fpp.writeInt(Integer.reverseBytes(this.payloadSize + 36));
            this.fpp.seek(40L);
            this.fpp.writeInt(Integer.reverseBytes(this.payloadSize));
            this.fpp.close();
            BdLog.e(MyAudioRecorder.class.getName() + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
            this.fpK = State.ERROR;
        }
        this.fpK = State.STOPPED;
    }

    private short b(byte b2, byte b3) {
        return (short) ((b3 << 8) | b2);
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean BO(String str) {
        if (BQ(str)) {
            return prepare();
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean bvH() {
        synchronized (mLock) {
            if (this.writeThread == null || !this.writeThread.isAlive()) {
                this.writeThread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.MyAudioRecorder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MyAudioRecorder.this.bvG();
                    }
                });
                this.writeThread.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void bvI() {
        this.fpK = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean isRecording() {
        return this.fpK == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvG() {
        if (fpH != null) {
            try {
                start();
                while (isRecording()) {
                    fpH.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.fpp.write(this.buffer);
                        this.payloadSize += this.buffer.length;
                        if (this.fpN == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short b2 = b(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (b2 > this.fpJ) {
                                    this.fpJ = b2;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.fpJ) {
                                    this.fpJ = this.buffer[i2];
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
