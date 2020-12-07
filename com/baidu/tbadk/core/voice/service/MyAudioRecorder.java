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
    private RandomAccessFile fhW;
    private String filePath;
    private boolean fin;
    private int fir;
    private State fis;
    private short fit;
    private int fiu;
    private short fiv;
    private int fiw;
    private int fiy;
    private int fiz;
    private int payloadSize;
    private Thread writeThread;
    private static final int[] fim = {44100, 22050, RequestResponseCode.REQUEST_LOGIN_PB_AT, CoolPraiseGuideLottieView.ANIM_DURATION};
    private static Object mLock = new Object();
    private static AudioRecord fio = null;
    private static MediaRecorder fiq = null;

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
            fio = null;
            fiq = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, fim[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.bwR() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, fim[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State bwR() {
        return this.fis;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.fir = 0;
        this.filePath = null;
        try {
            this.fin = z;
            if (this.fin) {
                if (i4 == 2) {
                    this.fiv = (short) 16;
                } else {
                    this.fiv = (short) 8;
                }
                if (i3 == 2) {
                    this.fit = (short) 1;
                } else {
                    this.fit = (short) 2;
                }
                this.fiw = i;
                this.fiu = i2;
                this.fiy = i4;
                this.fiz = (i2 * 120) / 1000;
                this.bufferSize = (((this.fiz * 2) * this.fiv) * this.fit) / 8;
                if (this.bufferSize < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.fiz = this.bufferSize / (((this.fiv * 2) * this.fit) / 8);
                    BdLog.w(MyAudioRecorder.class.getName() + "Increasing buffer size to " + Integer.toString(this.bufferSize));
                }
                fio = new AudioRecord(i, i2, i3, i4, this.bufferSize);
                if (fio.getRecordingState() == 3) {
                    fio.stop();
                }
                if (fio.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                fiq = new MediaRecorder();
                fiq.setAudioSource(1);
                fiq.setOutputFormat(1);
                fiq.setAudioEncoder(1);
            }
            this.fir = 0;
            this.filePath = null;
            this.fis = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while initializing recording");
            }
            this.fis = State.ERROR;
        }
    }

    public boolean CN(String str) {
        try {
            if (this.fis == State.INITIALIZING) {
                this.filePath = str;
                if (!this.fin) {
                    fiq.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while setting output path");
            }
            this.fis = State.ERROR;
            return false;
        }
    }

    public boolean prepare() {
        try {
            if (this.fis == State.INITIALIZING) {
                if (this.fin) {
                    if ((this.filePath != null) & (fio.getState() == 1)) {
                        if (this.fhW != null) {
                            this.fhW.close();
                            this.fhW = null;
                        }
                        this.fhW = new RandomAccessFile(this.filePath, "rw");
                        this.fhW.setLength(0L);
                        this.fhW.writeBytes("RIFF");
                        this.fhW.writeInt(0);
                        this.fhW.writeBytes("WAVE");
                        this.fhW.writeBytes("fmt ");
                        this.fhW.writeInt(Integer.reverseBytes(16));
                        this.fhW.writeShort(Short.reverseBytes((short) 1));
                        this.fhW.writeShort(Short.reverseBytes(this.fit));
                        this.fhW.writeInt(Integer.reverseBytes(this.fiu));
                        this.fhW.writeInt(Integer.reverseBytes(((this.fiu * this.fiv) * this.fit) / 8));
                        this.fhW.writeShort(Short.reverseBytes((short) ((this.fit * this.fiv) / 8)));
                        this.fhW.writeShort(Short.reverseBytes(this.fiv));
                        this.fhW.writeBytes("data");
                        this.fhW.writeInt(0);
                        this.buffer = new byte[((this.fiz * this.fiv) / 8) * this.fit];
                        this.fis = State.READY;
                    } else {
                        BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on uninitialized recorder");
                        this.fis = State.ERROR;
                        return false;
                    }
                } else {
                    fiq.prepare();
                    this.fis = State.READY;
                }
                return true;
            }
            BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on illegal state");
            release();
            this.fis = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured in prepare()");
            }
            this.fis = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.fis == State.RECORDING) {
            stop();
        } else {
            if ((this.fis == State.READY) & this.fin) {
                try {
                    this.fhW.close();
                } catch (IOException e) {
                    BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.fin) {
            if (fio != null) {
                fio.release();
            }
        } else if (fiq != null) {
            fiq.release();
        }
    }

    public void start() {
        if (this.fis == State.READY) {
            if (this.fin) {
                this.payloadSize = 0;
                fio.startRecording();
                fio.read(this.buffer, 0, this.buffer.length);
            } else {
                fiq.start();
            }
            this.fis = State.RECORDING;
            return;
        }
        BdLog.e(MyAudioRecorder.class.getName() + "start() called on illegal state");
        this.fis = State.ERROR;
    }

    public void stop() {
        BdLog.e(MyAudioRecorder.class.getName() + "audioRecorder.stop()");
        fio.stop();
        try {
            this.fhW.seek(4L);
            this.fhW.writeInt(Integer.reverseBytes(this.payloadSize + 36));
            this.fhW.seek(40L);
            this.fhW.writeInt(Integer.reverseBytes(this.payloadSize));
            this.fhW.close();
            BdLog.e(MyAudioRecorder.class.getName() + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
            this.fis = State.ERROR;
        }
        this.fis = State.STOPPED;
    }

    private short b(byte b, byte b2) {
        return (short) ((b2 << 8) | b);
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean CL(String str) {
        if (CN(str)) {
            return prepare();
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean bwN() {
        synchronized (mLock) {
            if (this.writeThread == null || !this.writeThread.isAlive()) {
                this.writeThread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.MyAudioRecorder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MyAudioRecorder.this.bwM();
                    }
                });
                this.writeThread.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void bwO() {
        this.fis = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean bwP() {
        return this.fis == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwM() {
        if (fio != null) {
            try {
                start();
                while (bwP()) {
                    fio.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.fhW.write(this.buffer);
                        this.payloadSize += this.buffer.length;
                        if (this.fiv == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short b = b(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (b > this.fir) {
                                    this.fir = b;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.fir) {
                                    this.fir = this.buffer[i2];
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
