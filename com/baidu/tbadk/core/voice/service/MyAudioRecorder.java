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
    private boolean dLE;
    private int dLH;
    private State dLI;
    private short dLJ;
    private int dLK;
    private short dLL;
    private int dLM;
    private int dLN;
    private int dLO;
    private RandomAccessFile dLo;
    private String filePath;
    private int payloadSize;
    private Thread writeThread;
    private static final int[] dLD = {44100, 22050, RequestResponseCode.REQUEST_LOGIN_PB_AT, CoolPraiseGuideLottieView.ANIM_DURATION};
    private static Object mLock = new Object();
    private static AudioRecord dLF = null;
    private static MediaRecorder dLG = null;

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
            dLF = null;
            dLG = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, dLD[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.aRq() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, dLD[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State aRq() {
        return this.dLI;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.dLH = 0;
        this.filePath = null;
        try {
            this.dLE = z;
            if (this.dLE) {
                if (i4 == 2) {
                    this.dLL = (short) 16;
                } else {
                    this.dLL = (short) 8;
                }
                if (i3 == 2) {
                    this.dLJ = (short) 1;
                } else {
                    this.dLJ = (short) 2;
                }
                this.dLM = i;
                this.dLK = i2;
                this.dLN = i4;
                this.dLO = (i2 * 120) / 1000;
                this.bufferSize = (((this.dLO * 2) * this.dLL) * this.dLJ) / 8;
                if (this.bufferSize < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.dLO = this.bufferSize / (((this.dLL * 2) * this.dLJ) / 8);
                    BdLog.w(MyAudioRecorder.class.getName() + "Increasing buffer size to " + Integer.toString(this.bufferSize));
                }
                dLF = new AudioRecord(i, i2, i3, i4, this.bufferSize);
                if (dLF.getRecordingState() == 3) {
                    dLF.stop();
                }
                if (dLF.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                dLG = new MediaRecorder();
                dLG.setAudioSource(1);
                dLG.setOutputFormat(1);
                dLG.setAudioEncoder(1);
            }
            this.dLH = 0;
            this.filePath = null;
            this.dLI = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while initializing recording");
            }
            this.dLI = State.ERROR;
        }
    }

    public boolean vu(String str) {
        try {
            if (this.dLI == State.INITIALIZING) {
                this.filePath = str;
                if (!this.dLE) {
                    dLG.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while setting output path");
            }
            this.dLI = State.ERROR;
            return false;
        }
    }

    public boolean prepare() {
        try {
            if (this.dLI == State.INITIALIZING) {
                if (this.dLE) {
                    if ((this.filePath != null) & (dLF.getState() == 1)) {
                        if (this.dLo != null) {
                            this.dLo.close();
                            this.dLo = null;
                        }
                        this.dLo = new RandomAccessFile(this.filePath, "rw");
                        this.dLo.setLength(0L);
                        this.dLo.writeBytes("RIFF");
                        this.dLo.writeInt(0);
                        this.dLo.writeBytes("WAVE");
                        this.dLo.writeBytes("fmt ");
                        this.dLo.writeInt(Integer.reverseBytes(16));
                        this.dLo.writeShort(Short.reverseBytes((short) 1));
                        this.dLo.writeShort(Short.reverseBytes(this.dLJ));
                        this.dLo.writeInt(Integer.reverseBytes(this.dLK));
                        this.dLo.writeInt(Integer.reverseBytes(((this.dLK * this.dLL) * this.dLJ) / 8));
                        this.dLo.writeShort(Short.reverseBytes((short) ((this.dLJ * this.dLL) / 8)));
                        this.dLo.writeShort(Short.reverseBytes(this.dLL));
                        this.dLo.writeBytes("data");
                        this.dLo.writeInt(0);
                        this.buffer = new byte[((this.dLO * this.dLL) / 8) * this.dLJ];
                        this.dLI = State.READY;
                    } else {
                        BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on uninitialized recorder");
                        this.dLI = State.ERROR;
                        return false;
                    }
                } else {
                    dLG.prepare();
                    this.dLI = State.READY;
                }
                return true;
            }
            BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on illegal state");
            release();
            this.dLI = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured in prepare()");
            }
            this.dLI = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.dLI == State.RECORDING) {
            stop();
        } else {
            if ((this.dLI == State.READY) & this.dLE) {
                try {
                    this.dLo.close();
                } catch (IOException e) {
                    BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.dLE) {
            if (dLF != null) {
                dLF.release();
            }
        } else if (dLG != null) {
            dLG.release();
        }
    }

    public void start() {
        if (this.dLI == State.READY) {
            if (this.dLE) {
                this.payloadSize = 0;
                dLF.startRecording();
                dLF.read(this.buffer, 0, this.buffer.length);
            } else {
                dLG.start();
            }
            this.dLI = State.RECORDING;
            return;
        }
        BdLog.e(MyAudioRecorder.class.getName() + "start() called on illegal state");
        this.dLI = State.ERROR;
    }

    public void stop() {
        BdLog.e(MyAudioRecorder.class.getName() + "audioRecorder.stop()");
        dLF.stop();
        try {
            this.dLo.seek(4L);
            this.dLo.writeInt(Integer.reverseBytes(this.payloadSize + 36));
            this.dLo.seek(40L);
            this.dLo.writeInt(Integer.reverseBytes(this.payloadSize));
            this.dLo.close();
            BdLog.e(MyAudioRecorder.class.getName() + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
            this.dLI = State.ERROR;
        }
        this.dLI = State.STOPPED;
    }

    private short b(byte b, byte b2) {
        return (short) ((b2 << 8) | b);
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean vs(String str) {
        if (vu(str)) {
            return prepare();
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean aRm() {
        synchronized (mLock) {
            if (this.writeThread == null || !this.writeThread.isAlive()) {
                this.writeThread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.MyAudioRecorder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MyAudioRecorder.this.aRl();
                    }
                });
                this.writeThread.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void aRn() {
        this.dLI = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean aRo() {
        return this.dLI == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRl() {
        if (dLF != null) {
            try {
                start();
                while (aRo()) {
                    dLF.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.dLo.write(this.buffer);
                        this.payloadSize += this.buffer.length;
                        if (this.dLL == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short b = b(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (b > this.dLH) {
                                    this.dLH = b;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.dLH) {
                                    this.dLH = this.buffer[i2];
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
