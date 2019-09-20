package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import android.media.MediaRecorder;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class MyAudioRecorder implements d {
    private byte[] buffer;
    private int bufferSize;
    private boolean cfJ;
    private int cfM;
    private State cfN;
    private short cfO;
    private int cfP;
    private short cfQ;
    private int cfR;
    private int cfS;
    private int cfT;
    private RandomAccessFile cft;
    private String filePath;
    private int payloadSize;
    private Thread writeThread;
    private static final int[] cfI = {44100, 22050, 11025, 8000};
    private static Object mLock = new Object();
    private static AudioRecord cfK = null;
    private static MediaRecorder cfL = null;

    /* loaded from: classes.dex */
    public enum State {
        INITIALIZING,
        READY,
        RECORDING,
        ERROR,
        STOPPED
    }

    public static MyAudioRecorder d(Boolean bool) {
        MyAudioRecorder myAudioRecorder;
        synchronized (mLock) {
            cfK = null;
            cfL = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, cfI[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.alQ() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, cfI[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State alQ() {
        return this.cfN;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.cfM = 0;
        this.filePath = null;
        try {
            this.cfJ = z;
            if (this.cfJ) {
                if (i4 == 2) {
                    this.cfQ = (short) 16;
                } else {
                    this.cfQ = (short) 8;
                }
                if (i3 == 2) {
                    this.cfO = (short) 1;
                } else {
                    this.cfO = (short) 2;
                }
                this.cfR = i;
                this.cfP = i2;
                this.cfS = i4;
                this.cfT = (i2 * 120) / 1000;
                this.bufferSize = (((this.cfT * 2) * this.cfQ) * this.cfO) / 8;
                if (this.bufferSize < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.cfT = this.bufferSize / (((this.cfQ * 2) * this.cfO) / 8);
                    BdLog.w(MyAudioRecorder.class.getName() + "Increasing buffer size to " + Integer.toString(this.bufferSize));
                }
                cfK = new AudioRecord(i, i2, i3, i4, this.bufferSize);
                if (cfK.getRecordingState() == 3) {
                    cfK.stop();
                }
                if (cfK.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                cfL = new MediaRecorder();
                cfL.setAudioSource(1);
                cfL.setOutputFormat(1);
                cfL.setAudioEncoder(1);
            }
            this.cfM = 0;
            this.filePath = null;
            this.cfN = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while initializing recording");
            }
            this.cfN = State.ERROR;
        }
    }

    public boolean pi(String str) {
        try {
            if (this.cfN == State.INITIALIZING) {
                this.filePath = str;
                if (!this.cfJ) {
                    cfL.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while setting output path");
            }
            this.cfN = State.ERROR;
            return false;
        }
    }

    public boolean prepare() {
        try {
            if (this.cfN == State.INITIALIZING) {
                if (this.cfJ) {
                    if ((this.filePath != null) & (cfK.getState() == 1)) {
                        if (this.cft != null) {
                            this.cft.close();
                            this.cft = null;
                        }
                        this.cft = new RandomAccessFile(this.filePath, "rw");
                        this.cft.setLength(0L);
                        this.cft.writeBytes("RIFF");
                        this.cft.writeInt(0);
                        this.cft.writeBytes("WAVE");
                        this.cft.writeBytes("fmt ");
                        this.cft.writeInt(Integer.reverseBytes(16));
                        this.cft.writeShort(Short.reverseBytes((short) 1));
                        this.cft.writeShort(Short.reverseBytes(this.cfO));
                        this.cft.writeInt(Integer.reverseBytes(this.cfP));
                        this.cft.writeInt(Integer.reverseBytes(((this.cfP * this.cfQ) * this.cfO) / 8));
                        this.cft.writeShort(Short.reverseBytes((short) ((this.cfO * this.cfQ) / 8)));
                        this.cft.writeShort(Short.reverseBytes(this.cfQ));
                        this.cft.writeBytes("data");
                        this.cft.writeInt(0);
                        this.buffer = new byte[((this.cfT * this.cfQ) / 8) * this.cfO];
                        this.cfN = State.READY;
                    } else {
                        BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on uninitialized recorder");
                        this.cfN = State.ERROR;
                        return false;
                    }
                } else {
                    cfL.prepare();
                    this.cfN = State.READY;
                }
                return true;
            }
            BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on illegal state");
            release();
            this.cfN = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured in prepare()");
            }
            this.cfN = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.cfN == State.RECORDING) {
            stop();
        } else {
            if ((this.cfN == State.READY) & this.cfJ) {
                try {
                    this.cft.close();
                } catch (IOException e) {
                    BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.cfJ) {
            if (cfK != null) {
                cfK.release();
            }
        } else if (cfL != null) {
            cfL.release();
        }
    }

    public void start() {
        if (this.cfN == State.READY) {
            if (this.cfJ) {
                this.payloadSize = 0;
                cfK.startRecording();
                cfK.read(this.buffer, 0, this.buffer.length);
            } else {
                cfL.start();
            }
            this.cfN = State.RECORDING;
            return;
        }
        BdLog.e(MyAudioRecorder.class.getName() + "start() called on illegal state");
        this.cfN = State.ERROR;
    }

    public void stop() {
        BdLog.e(MyAudioRecorder.class.getName() + "audioRecorder.stop()");
        cfK.stop();
        try {
            this.cft.seek(4L);
            this.cft.writeInt(Integer.reverseBytes(this.payloadSize + 36));
            this.cft.seek(40L);
            this.cft.writeInt(Integer.reverseBytes(this.payloadSize));
            this.cft.close();
            BdLog.e(MyAudioRecorder.class.getName() + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
            this.cfN = State.ERROR;
        }
        this.cfN = State.STOPPED;
    }

    private short b(byte b, byte b2) {
        return (short) ((b2 << 8) | b);
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean pg(String str) {
        if (pi(str)) {
            return prepare();
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean alM() {
        synchronized (mLock) {
            if (this.writeThread == null || !this.writeThread.isAlive()) {
                this.writeThread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.MyAudioRecorder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MyAudioRecorder.this.alL();
                    }
                });
                this.writeThread.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void alN() {
        this.cfN = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean alO() {
        return this.cfN == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alL() {
        if (cfK != null) {
            try {
                start();
                while (alO()) {
                    cfK.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.cft.write(this.buffer);
                        this.payloadSize += this.buffer.length;
                        if (this.cfQ == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short b = b(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (b > this.cfM) {
                                    this.cfM = b;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.cfM) {
                                    this.cfM = this.buffer[i2];
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
