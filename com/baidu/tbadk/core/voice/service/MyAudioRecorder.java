package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import android.media.MediaRecorder;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class MyAudioRecorder implements d {
    private RandomAccessFile aMR;
    private boolean aNg;
    private int aNj;
    private State aNk;
    private short aNl;
    private int aNm;
    private short aNn;
    private int aNo;
    private int aNp;
    private int aNq;
    private byte[] buffer;
    private int bufferSize;
    private String filePath;
    private int payloadSize;
    private Thread writeThread;
    private static final int[] aNf = {44100, 22050, 11025, 8000};
    private static Object mLock = new Object();
    private static AudioRecord aNh = null;
    private static MediaRecorder aNi = null;

    /* loaded from: classes.dex */
    public enum State {
        INITIALIZING,
        READY,
        RECORDING,
        ERROR,
        STOPPED
    }

    public static MyAudioRecorder b(Boolean bool) {
        MyAudioRecorder myAudioRecorder;
        synchronized (mLock) {
            aNh = null;
            aNi = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, aNf[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.Gh() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, aNf[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State Gh() {
        return this.aNk;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.aNj = 0;
        this.filePath = null;
        try {
            this.aNg = z;
            if (this.aNg) {
                if (i4 == 2) {
                    this.aNn = (short) 16;
                } else {
                    this.aNn = (short) 8;
                }
                if (i3 == 2) {
                    this.aNl = (short) 1;
                } else {
                    this.aNl = (short) 2;
                }
                this.aNo = i;
                this.aNm = i2;
                this.aNp = i4;
                this.aNq = (i2 * 120) / 1000;
                this.bufferSize = (((this.aNq * 2) * this.aNn) * this.aNl) / 8;
                if (this.bufferSize < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.aNq = this.bufferSize / (((this.aNn * 2) * this.aNl) / 8);
                    BdLog.w(MyAudioRecorder.class.getName() + "Increasing buffer size to " + Integer.toString(this.bufferSize));
                }
                aNh = new AudioRecord(i, i2, i3, i4, this.bufferSize);
                if (aNh.getRecordingState() == 3) {
                    aNh.stop();
                }
                if (aNh.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                aNi = new MediaRecorder();
                aNi.setAudioSource(1);
                aNi.setOutputFormat(1);
                aNi.setAudioEncoder(1);
            }
            this.aNj = 0;
            this.filePath = null;
            this.aNk = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while initializing recording");
            }
            this.aNk = State.ERROR;
        }
    }

    public boolean gN(String str) {
        try {
            if (this.aNk == State.INITIALIZING) {
                this.filePath = str;
                if (!this.aNg) {
                    aNi.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while setting output path");
            }
            this.aNk = State.ERROR;
            return false;
        }
    }

    public boolean prepare() {
        try {
            if (this.aNk == State.INITIALIZING) {
                if (this.aNg) {
                    if ((this.filePath != null) & (aNh.getState() == 1)) {
                        if (this.aMR != null) {
                            this.aMR.close();
                            this.aMR = null;
                        }
                        this.aMR = new RandomAccessFile(this.filePath, "rw");
                        this.aMR.setLength(0L);
                        this.aMR.writeBytes("RIFF");
                        this.aMR.writeInt(0);
                        this.aMR.writeBytes("WAVE");
                        this.aMR.writeBytes("fmt ");
                        this.aMR.writeInt(Integer.reverseBytes(16));
                        this.aMR.writeShort(Short.reverseBytes((short) 1));
                        this.aMR.writeShort(Short.reverseBytes(this.aNl));
                        this.aMR.writeInt(Integer.reverseBytes(this.aNm));
                        this.aMR.writeInt(Integer.reverseBytes(((this.aNm * this.aNn) * this.aNl) / 8));
                        this.aMR.writeShort(Short.reverseBytes((short) ((this.aNl * this.aNn) / 8)));
                        this.aMR.writeShort(Short.reverseBytes(this.aNn));
                        this.aMR.writeBytes("data");
                        this.aMR.writeInt(0);
                        this.buffer = new byte[((this.aNq * this.aNn) / 8) * this.aNl];
                        this.aNk = State.READY;
                    } else {
                        BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on uninitialized recorder");
                        this.aNk = State.ERROR;
                        return false;
                    }
                } else {
                    aNi.prepare();
                    this.aNk = State.READY;
                }
                return true;
            }
            BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on illegal state");
            release();
            this.aNk = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured in prepare()");
            }
            this.aNk = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.aNk == State.RECORDING) {
            stop();
        } else {
            if ((this.aNk == State.READY) & this.aNg) {
                try {
                    this.aMR.close();
                } catch (IOException e) {
                    BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.aNg) {
            if (aNh != null) {
                aNh.release();
            }
        } else if (aNi != null) {
            aNi.release();
        }
    }

    public void start() {
        if (this.aNk == State.READY) {
            if (this.aNg) {
                this.payloadSize = 0;
                aNh.startRecording();
                aNh.read(this.buffer, 0, this.buffer.length);
            } else {
                aNi.start();
            }
            this.aNk = State.RECORDING;
            return;
        }
        BdLog.e(MyAudioRecorder.class.getName() + "start() called on illegal state");
        this.aNk = State.ERROR;
    }

    public void stop() {
        BdLog.e(MyAudioRecorder.class.getName() + "audioRecorder.stop()");
        aNh.stop();
        try {
            this.aMR.seek(4L);
            this.aMR.writeInt(Integer.reverseBytes(this.payloadSize + 36));
            this.aMR.seek(40L);
            this.aMR.writeInt(Integer.reverseBytes(this.payloadSize));
            this.aMR.close();
            BdLog.e(MyAudioRecorder.class.getName() + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
            this.aNk = State.ERROR;
        }
        this.aNk = State.STOPPED;
    }

    private short b(byte b, byte b2) {
        return (short) ((b2 << 8) | b);
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean gL(String str) {
        if (gN(str)) {
            return prepare();
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean Gd() {
        synchronized (mLock) {
            if (this.writeThread == null || !this.writeThread.isAlive()) {
                this.writeThread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.MyAudioRecorder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MyAudioRecorder.this.Gc();
                    }
                });
                this.writeThread.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void Ge() {
        this.aNk = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean Gf() {
        return this.aNk == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gc() {
        if (aNh != null) {
            try {
                start();
                while (Gf()) {
                    aNh.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.aMR.write(this.buffer);
                        this.payloadSize += this.buffer.length;
                        if (this.aNn == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short b = b(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (b > this.aNj) {
                                    this.aNj = b;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.aNj) {
                                    this.aNj = this.buffer[i2];
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
