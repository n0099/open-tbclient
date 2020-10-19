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
    private State eNA;
    private short eNB;
    private int eNC;
    private short eND;
    private int eNE;
    private int eNF;
    private int eNG;
    private RandomAccessFile eNg;
    private boolean eNw;
    private int eNz;
    private String filePath;
    private int payloadSize;
    private Thread writeThread;
    private static final int[] eNv = {44100, 22050, RequestResponseCode.REQUEST_LOGIN_PB_AT, CoolPraiseGuideLottieView.ANIM_DURATION};
    private static Object mLock = new Object();
    private static AudioRecord eNx = null;
    private static MediaRecorder eNy = null;

    /* loaded from: classes.dex */
    public enum State {
        INITIALIZING,
        READY,
        RECORDING,
        ERROR,
        STOPPED
    }

    public static MyAudioRecorder l(Boolean bool) {
        MyAudioRecorder myAudioRecorder;
        synchronized (mLock) {
            eNx = null;
            eNy = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, eNv[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.bpI() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, eNv[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State bpI() {
        return this.eNA;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.eNz = 0;
        this.filePath = null;
        try {
            this.eNw = z;
            if (this.eNw) {
                if (i4 == 2) {
                    this.eND = (short) 16;
                } else {
                    this.eND = (short) 8;
                }
                if (i3 == 2) {
                    this.eNB = (short) 1;
                } else {
                    this.eNB = (short) 2;
                }
                this.eNE = i;
                this.eNC = i2;
                this.eNF = i4;
                this.eNG = (i2 * 120) / 1000;
                this.bufferSize = (((this.eNG * 2) * this.eND) * this.eNB) / 8;
                if (this.bufferSize < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.eNG = this.bufferSize / (((this.eND * 2) * this.eNB) / 8);
                    BdLog.w(MyAudioRecorder.class.getName() + "Increasing buffer size to " + Integer.toString(this.bufferSize));
                }
                eNx = new AudioRecord(i, i2, i3, i4, this.bufferSize);
                if (eNx.getRecordingState() == 3) {
                    eNx.stop();
                }
                if (eNx.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                eNy = new MediaRecorder();
                eNy.setAudioSource(1);
                eNy.setOutputFormat(1);
                eNy.setAudioEncoder(1);
            }
            this.eNz = 0;
            this.filePath = null;
            this.eNA = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while initializing recording");
            }
            this.eNA = State.ERROR;
        }
    }

    public boolean BZ(String str) {
        try {
            if (this.eNA == State.INITIALIZING) {
                this.filePath = str;
                if (!this.eNw) {
                    eNy.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while setting output path");
            }
            this.eNA = State.ERROR;
            return false;
        }
    }

    public boolean prepare() {
        try {
            if (this.eNA == State.INITIALIZING) {
                if (this.eNw) {
                    if ((this.filePath != null) & (eNx.getState() == 1)) {
                        if (this.eNg != null) {
                            this.eNg.close();
                            this.eNg = null;
                        }
                        this.eNg = new RandomAccessFile(this.filePath, "rw");
                        this.eNg.setLength(0L);
                        this.eNg.writeBytes("RIFF");
                        this.eNg.writeInt(0);
                        this.eNg.writeBytes("WAVE");
                        this.eNg.writeBytes("fmt ");
                        this.eNg.writeInt(Integer.reverseBytes(16));
                        this.eNg.writeShort(Short.reverseBytes((short) 1));
                        this.eNg.writeShort(Short.reverseBytes(this.eNB));
                        this.eNg.writeInt(Integer.reverseBytes(this.eNC));
                        this.eNg.writeInt(Integer.reverseBytes(((this.eNC * this.eND) * this.eNB) / 8));
                        this.eNg.writeShort(Short.reverseBytes((short) ((this.eNB * this.eND) / 8)));
                        this.eNg.writeShort(Short.reverseBytes(this.eND));
                        this.eNg.writeBytes("data");
                        this.eNg.writeInt(0);
                        this.buffer = new byte[((this.eNG * this.eND) / 8) * this.eNB];
                        this.eNA = State.READY;
                    } else {
                        BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on uninitialized recorder");
                        this.eNA = State.ERROR;
                        return false;
                    }
                } else {
                    eNy.prepare();
                    this.eNA = State.READY;
                }
                return true;
            }
            BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on illegal state");
            release();
            this.eNA = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured in prepare()");
            }
            this.eNA = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.eNA == State.RECORDING) {
            stop();
        } else {
            if ((this.eNA == State.READY) & this.eNw) {
                try {
                    this.eNg.close();
                } catch (IOException e) {
                    BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.eNw) {
            if (eNx != null) {
                eNx.release();
            }
        } else if (eNy != null) {
            eNy.release();
        }
    }

    public void start() {
        if (this.eNA == State.READY) {
            if (this.eNw) {
                this.payloadSize = 0;
                eNx.startRecording();
                eNx.read(this.buffer, 0, this.buffer.length);
            } else {
                eNy.start();
            }
            this.eNA = State.RECORDING;
            return;
        }
        BdLog.e(MyAudioRecorder.class.getName() + "start() called on illegal state");
        this.eNA = State.ERROR;
    }

    public void stop() {
        BdLog.e(MyAudioRecorder.class.getName() + "audioRecorder.stop()");
        eNx.stop();
        try {
            this.eNg.seek(4L);
            this.eNg.writeInt(Integer.reverseBytes(this.payloadSize + 36));
            this.eNg.seek(40L);
            this.eNg.writeInt(Integer.reverseBytes(this.payloadSize));
            this.eNg.close();
            BdLog.e(MyAudioRecorder.class.getName() + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
            this.eNA = State.ERROR;
        }
        this.eNA = State.STOPPED;
    }

    private short b(byte b, byte b2) {
        return (short) ((b2 << 8) | b);
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean BX(String str) {
        if (BZ(str)) {
            return prepare();
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean bpE() {
        synchronized (mLock) {
            if (this.writeThread == null || !this.writeThread.isAlive()) {
                this.writeThread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.MyAudioRecorder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MyAudioRecorder.this.bpD();
                    }
                });
                this.writeThread.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void bpF() {
        this.eNA = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean bpG() {
        return this.eNA == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpD() {
        if (eNx != null) {
            try {
                start();
                while (bpG()) {
                    eNx.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.eNg.write(this.buffer);
                        this.payloadSize += this.buffer.length;
                        if (this.eND == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short b = b(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (b > this.eNz) {
                                    this.eNz = b;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.eNz) {
                                    this.eNz = this.buffer[i2];
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
