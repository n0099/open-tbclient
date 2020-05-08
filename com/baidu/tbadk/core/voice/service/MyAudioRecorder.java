package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import android.media.MediaRecorder;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.searchbox.ui.CoolPraiseGuideLottieView;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class MyAudioRecorder implements d {
    private byte[] buffer;
    private int bufferSize;
    private boolean dLI;
    private int dLL;
    private State dLM;
    private short dLN;
    private int dLO;
    private short dLP;
    private int dLQ;
    private int dLR;
    private int dLS;
    private RandomAccessFile dLs;
    private String filePath;
    private int payloadSize;
    private Thread writeThread;
    private static final int[] dLH = {44100, 22050, RequestResponseCode.REQUEST_LOGIN_PB_AT, CoolPraiseGuideLottieView.ANIM_DURATION};
    private static Object mLock = new Object();
    private static AudioRecord dLJ = null;
    private static MediaRecorder dLK = null;

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
            dLJ = null;
            dLK = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, dLH[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.aRn() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, dLH[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State aRn() {
        return this.dLM;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.dLL = 0;
        this.filePath = null;
        try {
            this.dLI = z;
            if (this.dLI) {
                if (i4 == 2) {
                    this.dLP = (short) 16;
                } else {
                    this.dLP = (short) 8;
                }
                if (i3 == 2) {
                    this.dLN = (short) 1;
                } else {
                    this.dLN = (short) 2;
                }
                this.dLQ = i;
                this.dLO = i2;
                this.dLR = i4;
                this.dLS = (i2 * 120) / 1000;
                this.bufferSize = (((this.dLS * 2) * this.dLP) * this.dLN) / 8;
                if (this.bufferSize < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.dLS = this.bufferSize / (((this.dLP * 2) * this.dLN) / 8);
                    BdLog.w(MyAudioRecorder.class.getName() + "Increasing buffer size to " + Integer.toString(this.bufferSize));
                }
                dLJ = new AudioRecord(i, i2, i3, i4, this.bufferSize);
                if (dLJ.getRecordingState() == 3) {
                    dLJ.stop();
                }
                if (dLJ.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                dLK = new MediaRecorder();
                dLK.setAudioSource(1);
                dLK.setOutputFormat(1);
                dLK.setAudioEncoder(1);
            }
            this.dLL = 0;
            this.filePath = null;
            this.dLM = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while initializing recording");
            }
            this.dLM = State.ERROR;
        }
    }

    public boolean vx(String str) {
        try {
            if (this.dLM == State.INITIALIZING) {
                this.filePath = str;
                if (!this.dLI) {
                    dLK.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while setting output path");
            }
            this.dLM = State.ERROR;
            return false;
        }
    }

    public boolean prepare() {
        try {
            if (this.dLM == State.INITIALIZING) {
                if (this.dLI) {
                    if ((this.filePath != null) & (dLJ.getState() == 1)) {
                        if (this.dLs != null) {
                            this.dLs.close();
                            this.dLs = null;
                        }
                        this.dLs = new RandomAccessFile(this.filePath, "rw");
                        this.dLs.setLength(0L);
                        this.dLs.writeBytes("RIFF");
                        this.dLs.writeInt(0);
                        this.dLs.writeBytes("WAVE");
                        this.dLs.writeBytes("fmt ");
                        this.dLs.writeInt(Integer.reverseBytes(16));
                        this.dLs.writeShort(Short.reverseBytes((short) 1));
                        this.dLs.writeShort(Short.reverseBytes(this.dLN));
                        this.dLs.writeInt(Integer.reverseBytes(this.dLO));
                        this.dLs.writeInt(Integer.reverseBytes(((this.dLO * this.dLP) * this.dLN) / 8));
                        this.dLs.writeShort(Short.reverseBytes((short) ((this.dLN * this.dLP) / 8)));
                        this.dLs.writeShort(Short.reverseBytes(this.dLP));
                        this.dLs.writeBytes("data");
                        this.dLs.writeInt(0);
                        this.buffer = new byte[((this.dLS * this.dLP) / 8) * this.dLN];
                        this.dLM = State.READY;
                    } else {
                        BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on uninitialized recorder");
                        this.dLM = State.ERROR;
                        return false;
                    }
                } else {
                    dLK.prepare();
                    this.dLM = State.READY;
                }
                return true;
            }
            BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on illegal state");
            release();
            this.dLM = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured in prepare()");
            }
            this.dLM = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.dLM == State.RECORDING) {
            stop();
        } else {
            if ((this.dLM == State.READY) & this.dLI) {
                try {
                    this.dLs.close();
                } catch (IOException e) {
                    BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.dLI) {
            if (dLJ != null) {
                dLJ.release();
            }
        } else if (dLK != null) {
            dLK.release();
        }
    }

    public void start() {
        if (this.dLM == State.READY) {
            if (this.dLI) {
                this.payloadSize = 0;
                dLJ.startRecording();
                dLJ.read(this.buffer, 0, this.buffer.length);
            } else {
                dLK.start();
            }
            this.dLM = State.RECORDING;
            return;
        }
        BdLog.e(MyAudioRecorder.class.getName() + "start() called on illegal state");
        this.dLM = State.ERROR;
    }

    public void stop() {
        BdLog.e(MyAudioRecorder.class.getName() + "audioRecorder.stop()");
        dLJ.stop();
        try {
            this.dLs.seek(4L);
            this.dLs.writeInt(Integer.reverseBytes(this.payloadSize + 36));
            this.dLs.seek(40L);
            this.dLs.writeInt(Integer.reverseBytes(this.payloadSize));
            this.dLs.close();
            BdLog.e(MyAudioRecorder.class.getName() + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
            this.dLM = State.ERROR;
        }
        this.dLM = State.STOPPED;
    }

    private short b(byte b, byte b2) {
        return (short) ((b2 << 8) | b);
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean vv(String str) {
        if (vx(str)) {
            return prepare();
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean aRj() {
        synchronized (mLock) {
            if (this.writeThread == null || !this.writeThread.isAlive()) {
                this.writeThread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.MyAudioRecorder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MyAudioRecorder.this.aRi();
                    }
                });
                this.writeThread.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void aRk() {
        this.dLM = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean aRl() {
        return this.dLM == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRi() {
        if (dLJ != null) {
            try {
                start();
                while (aRl()) {
                    dLJ.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.dLs.write(this.buffer);
                        this.payloadSize += this.buffer.length;
                        if (this.dLP == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short b = b(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (b > this.dLL) {
                                    this.dLL = b;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.dLL) {
                                    this.dLL = this.buffer[i2];
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
