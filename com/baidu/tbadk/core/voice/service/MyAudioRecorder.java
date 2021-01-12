package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import android.media.MediaRecorder;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class MyAudioRecorder implements d {
    private byte[] buffer;
    private int bufferSize;
    private String filePath;
    private RandomAccessFile fmX;
    private boolean fnn;
    private int fnq;
    private State fnr;
    private short fns;
    private int fnt;
    private short fnu;
    private int fnv;
    private int fnw;
    private int fnx;
    private int payloadSize;
    private Thread writeThread;
    private static final int[] fnm = {44100, 22050, RequestResponseCode.REQUEST_LOGIN_PB_AT, 8000};
    private static Object mLock = new Object();
    private static AudioRecord fno = null;
    private static MediaRecorder fnp = null;

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
            fno = null;
            fnp = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, fnm[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.bvr() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, fnm[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State bvr() {
        return this.fnr;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.fnq = 0;
        this.filePath = null;
        try {
            this.fnn = z;
            if (this.fnn) {
                if (i4 == 2) {
                    this.fnu = (short) 16;
                } else {
                    this.fnu = (short) 8;
                }
                if (i3 == 2) {
                    this.fns = (short) 1;
                } else {
                    this.fns = (short) 2;
                }
                this.fnv = i;
                this.fnt = i2;
                this.fnw = i4;
                this.fnx = (i2 * 120) / 1000;
                this.bufferSize = (((this.fnx * 2) * this.fnu) * this.fns) / 8;
                if (this.bufferSize < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.fnx = this.bufferSize / (((this.fnu * 2) * this.fns) / 8);
                    BdLog.w(MyAudioRecorder.class.getName() + "Increasing buffer size to " + Integer.toString(this.bufferSize));
                }
                fno = new AudioRecord(i, i2, i3, i4, this.bufferSize);
                if (fno.getRecordingState() == 3) {
                    fno.stop();
                }
                if (fno.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                fnp = new MediaRecorder();
                fnp.setAudioSource(1);
                fnp.setOutputFormat(1);
                fnp.setAudioEncoder(1);
            }
            this.fnq = 0;
            this.filePath = null;
            this.fnr = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while initializing recording");
            }
            this.fnr = State.ERROR;
        }
    }

    public boolean Bz(String str) {
        try {
            if (this.fnr == State.INITIALIZING) {
                this.filePath = str;
                if (!this.fnn) {
                    fnp.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while setting output path");
            }
            this.fnr = State.ERROR;
            return false;
        }
    }

    public boolean prepare() {
        try {
            if (this.fnr == State.INITIALIZING) {
                if (this.fnn) {
                    if ((this.filePath != null) & (fno.getState() == 1)) {
                        if (this.fmX != null) {
                            this.fmX.close();
                            this.fmX = null;
                        }
                        this.fmX = new RandomAccessFile(this.filePath, "rw");
                        this.fmX.setLength(0L);
                        this.fmX.writeBytes("RIFF");
                        this.fmX.writeInt(0);
                        this.fmX.writeBytes("WAVE");
                        this.fmX.writeBytes("fmt ");
                        this.fmX.writeInt(Integer.reverseBytes(16));
                        this.fmX.writeShort(Short.reverseBytes((short) 1));
                        this.fmX.writeShort(Short.reverseBytes(this.fns));
                        this.fmX.writeInt(Integer.reverseBytes(this.fnt));
                        this.fmX.writeInt(Integer.reverseBytes(((this.fnt * this.fnu) * this.fns) / 8));
                        this.fmX.writeShort(Short.reverseBytes((short) ((this.fns * this.fnu) / 8)));
                        this.fmX.writeShort(Short.reverseBytes(this.fnu));
                        this.fmX.writeBytes("data");
                        this.fmX.writeInt(0);
                        this.buffer = new byte[((this.fnx * this.fnu) / 8) * this.fns];
                        this.fnr = State.READY;
                    } else {
                        BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on uninitialized recorder");
                        this.fnr = State.ERROR;
                        return false;
                    }
                } else {
                    fnp.prepare();
                    this.fnr = State.READY;
                }
                return true;
            }
            BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on illegal state");
            release();
            this.fnr = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured in prepare()");
            }
            this.fnr = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.fnr == State.RECORDING) {
            stop();
        } else {
            if ((this.fnr == State.READY) & this.fnn) {
                try {
                    this.fmX.close();
                } catch (IOException e) {
                    BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.fnn) {
            if (fno != null) {
                fno.release();
            }
        } else if (fnp != null) {
            fnp.release();
        }
    }

    public void start() {
        if (this.fnr == State.READY) {
            if (this.fnn) {
                this.payloadSize = 0;
                fno.startRecording();
                fno.read(this.buffer, 0, this.buffer.length);
            } else {
                fnp.start();
            }
            this.fnr = State.RECORDING;
            return;
        }
        BdLog.e(MyAudioRecorder.class.getName() + "start() called on illegal state");
        this.fnr = State.ERROR;
    }

    public void stop() {
        BdLog.e(MyAudioRecorder.class.getName() + "audioRecorder.stop()");
        fno.stop();
        try {
            this.fmX.seek(4L);
            this.fmX.writeInt(Integer.reverseBytes(this.payloadSize + 36));
            this.fmX.seek(40L);
            this.fmX.writeInt(Integer.reverseBytes(this.payloadSize));
            this.fmX.close();
            BdLog.e(MyAudioRecorder.class.getName() + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
            this.fnr = State.ERROR;
        }
        this.fnr = State.STOPPED;
    }

    private short b(byte b2, byte b3) {
        return (short) ((b3 << 8) | b2);
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean Bx(String str) {
        if (Bz(str)) {
            return prepare();
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean bvn() {
        synchronized (mLock) {
            if (this.writeThread == null || !this.writeThread.isAlive()) {
                this.writeThread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.MyAudioRecorder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MyAudioRecorder.this.bvm();
                    }
                });
                this.writeThread.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void bvo() {
        this.fnr = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean bvp() {
        return this.fnr == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvm() {
        if (fno != null) {
            try {
                start();
                while (bvp()) {
                    fno.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.fmX.write(this.buffer);
                        this.payloadSize += this.buffer.length;
                        if (this.fnu == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short b2 = b(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (b2 > this.fnq) {
                                    this.fnq = b2;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.fnq) {
                                    this.fnq = this.buffer[i2];
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
