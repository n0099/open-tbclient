package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import android.media.MediaRecorder;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class MyAudioRecorder implements d {
    private RandomAccessFile aMS;
    private boolean aNh;
    private int aNk;
    private State aNl;
    private short aNm;
    private int aNn;
    private short aNo;
    private int aNp;
    private int aNq;
    private int aNr;
    private byte[] buffer;
    private int bufferSize;
    private String filePath;
    private int payloadSize;
    private Thread writeThread;
    private static final int[] aNg = {44100, 22050, 11025, 8000};
    private static Object mLock = new Object();
    private static AudioRecord aNi = null;
    private static MediaRecorder aNj = null;

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
            aNi = null;
            aNj = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, aNg[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.Gh() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, aNg[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State Gh() {
        return this.aNl;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.aNk = 0;
        this.filePath = null;
        try {
            this.aNh = z;
            if (this.aNh) {
                if (i4 == 2) {
                    this.aNo = (short) 16;
                } else {
                    this.aNo = (short) 8;
                }
                if (i3 == 2) {
                    this.aNm = (short) 1;
                } else {
                    this.aNm = (short) 2;
                }
                this.aNp = i;
                this.aNn = i2;
                this.aNq = i4;
                this.aNr = (i2 * 120) / 1000;
                this.bufferSize = (((this.aNr * 2) * this.aNo) * this.aNm) / 8;
                if (this.bufferSize < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.aNr = this.bufferSize / (((this.aNo * 2) * this.aNm) / 8);
                    BdLog.w(MyAudioRecorder.class.getName() + "Increasing buffer size to " + Integer.toString(this.bufferSize));
                }
                aNi = new AudioRecord(i, i2, i3, i4, this.bufferSize);
                if (aNi.getRecordingState() == 3) {
                    aNi.stop();
                }
                if (aNi.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                aNj = new MediaRecorder();
                aNj.setAudioSource(1);
                aNj.setOutputFormat(1);
                aNj.setAudioEncoder(1);
            }
            this.aNk = 0;
            this.filePath = null;
            this.aNl = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while initializing recording");
            }
            this.aNl = State.ERROR;
        }
    }

    public boolean gN(String str) {
        try {
            if (this.aNl == State.INITIALIZING) {
                this.filePath = str;
                if (!this.aNh) {
                    aNj.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while setting output path");
            }
            this.aNl = State.ERROR;
            return false;
        }
    }

    public boolean prepare() {
        try {
            if (this.aNl == State.INITIALIZING) {
                if (this.aNh) {
                    if ((this.filePath != null) & (aNi.getState() == 1)) {
                        if (this.aMS != null) {
                            this.aMS.close();
                            this.aMS = null;
                        }
                        this.aMS = new RandomAccessFile(this.filePath, "rw");
                        this.aMS.setLength(0L);
                        this.aMS.writeBytes("RIFF");
                        this.aMS.writeInt(0);
                        this.aMS.writeBytes("WAVE");
                        this.aMS.writeBytes("fmt ");
                        this.aMS.writeInt(Integer.reverseBytes(16));
                        this.aMS.writeShort(Short.reverseBytes((short) 1));
                        this.aMS.writeShort(Short.reverseBytes(this.aNm));
                        this.aMS.writeInt(Integer.reverseBytes(this.aNn));
                        this.aMS.writeInt(Integer.reverseBytes(((this.aNn * this.aNo) * this.aNm) / 8));
                        this.aMS.writeShort(Short.reverseBytes((short) ((this.aNm * this.aNo) / 8)));
                        this.aMS.writeShort(Short.reverseBytes(this.aNo));
                        this.aMS.writeBytes("data");
                        this.aMS.writeInt(0);
                        this.buffer = new byte[((this.aNr * this.aNo) / 8) * this.aNm];
                        this.aNl = State.READY;
                    } else {
                        BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on uninitialized recorder");
                        this.aNl = State.ERROR;
                        return false;
                    }
                } else {
                    aNj.prepare();
                    this.aNl = State.READY;
                }
                return true;
            }
            BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on illegal state");
            release();
            this.aNl = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured in prepare()");
            }
            this.aNl = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.aNl == State.RECORDING) {
            stop();
        } else {
            if ((this.aNl == State.READY) & this.aNh) {
                try {
                    this.aMS.close();
                } catch (IOException e) {
                    BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.aNh) {
            if (aNi != null) {
                aNi.release();
            }
        } else if (aNj != null) {
            aNj.release();
        }
    }

    public void start() {
        if (this.aNl == State.READY) {
            if (this.aNh) {
                this.payloadSize = 0;
                aNi.startRecording();
                aNi.read(this.buffer, 0, this.buffer.length);
            } else {
                aNj.start();
            }
            this.aNl = State.RECORDING;
            return;
        }
        BdLog.e(MyAudioRecorder.class.getName() + "start() called on illegal state");
        this.aNl = State.ERROR;
    }

    public void stop() {
        BdLog.e(MyAudioRecorder.class.getName() + "audioRecorder.stop()");
        aNi.stop();
        try {
            this.aMS.seek(4L);
            this.aMS.writeInt(Integer.reverseBytes(this.payloadSize + 36));
            this.aMS.seek(40L);
            this.aMS.writeInt(Integer.reverseBytes(this.payloadSize));
            this.aMS.close();
            BdLog.e(MyAudioRecorder.class.getName() + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
            this.aNl = State.ERROR;
        }
        this.aNl = State.STOPPED;
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
        this.aNl = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean Gf() {
        return this.aNl == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gc() {
        if (aNi != null) {
            try {
                start();
                while (Gf()) {
                    aNi.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.aMS.write(this.buffer);
                        this.payloadSize += this.buffer.length;
                        if (this.aNo == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short b = b(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (b > this.aNk) {
                                    this.aNk = b;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.aNk) {
                                    this.aNk = this.buffer[i2];
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
