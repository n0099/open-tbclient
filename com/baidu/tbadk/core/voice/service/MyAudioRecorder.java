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
    private RandomAccessFile frI;
    private boolean frY;
    private int fsb;
    private State fsc;
    private short fsd;
    private int fse;
    private short fsf;
    private int fsg;
    private int fsh;
    private int fsi;
    private int payloadSize;
    private Thread writeThread;
    private static final int[] frX = {44100, 22050, RequestResponseCode.REQUEST_LOGIN_PB_AT, 8000};
    private static Object mLock = new Object();
    private static AudioRecord frZ = null;
    private static MediaRecorder fsa = null;

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
            frZ = null;
            fsa = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, frX[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.bzk() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, frX[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State bzk() {
        return this.fsc;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.fsb = 0;
        this.filePath = null;
        try {
            this.frY = z;
            if (this.frY) {
                if (i4 == 2) {
                    this.fsf = (short) 16;
                } else {
                    this.fsf = (short) 8;
                }
                if (i3 == 2) {
                    this.fsd = (short) 1;
                } else {
                    this.fsd = (short) 2;
                }
                this.fsg = i;
                this.fse = i2;
                this.fsh = i4;
                this.fsi = (i2 * 120) / 1000;
                this.bufferSize = (((this.fsi * 2) * this.fsf) * this.fsd) / 8;
                if (this.bufferSize < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.fsi = this.bufferSize / (((this.fsf * 2) * this.fsd) / 8);
                    BdLog.w(MyAudioRecorder.class.getName() + "Increasing buffer size to " + Integer.toString(this.bufferSize));
                }
                frZ = new AudioRecord(i, i2, i3, i4, this.bufferSize);
                if (frZ.getRecordingState() == 3) {
                    frZ.stop();
                }
                if (frZ.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                fsa = new MediaRecorder();
                fsa.setAudioSource(1);
                fsa.setOutputFormat(1);
                fsa.setAudioEncoder(1);
            }
            this.fsb = 0;
            this.filePath = null;
            this.fsc = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while initializing recording");
            }
            this.fsc = State.ERROR;
        }
    }

    public boolean CL(String str) {
        try {
            if (this.fsc == State.INITIALIZING) {
                this.filePath = str;
                if (!this.frY) {
                    fsa.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while setting output path");
            }
            this.fsc = State.ERROR;
            return false;
        }
    }

    public boolean prepare() {
        try {
            if (this.fsc == State.INITIALIZING) {
                if (this.frY) {
                    if ((this.filePath != null) & (frZ.getState() == 1)) {
                        if (this.frI != null) {
                            this.frI.close();
                            this.frI = null;
                        }
                        this.frI = new RandomAccessFile(this.filePath, "rw");
                        this.frI.setLength(0L);
                        this.frI.writeBytes("RIFF");
                        this.frI.writeInt(0);
                        this.frI.writeBytes("WAVE");
                        this.frI.writeBytes("fmt ");
                        this.frI.writeInt(Integer.reverseBytes(16));
                        this.frI.writeShort(Short.reverseBytes((short) 1));
                        this.frI.writeShort(Short.reverseBytes(this.fsd));
                        this.frI.writeInt(Integer.reverseBytes(this.fse));
                        this.frI.writeInt(Integer.reverseBytes(((this.fse * this.fsf) * this.fsd) / 8));
                        this.frI.writeShort(Short.reverseBytes((short) ((this.fsd * this.fsf) / 8)));
                        this.frI.writeShort(Short.reverseBytes(this.fsf));
                        this.frI.writeBytes("data");
                        this.frI.writeInt(0);
                        this.buffer = new byte[((this.fsi * this.fsf) / 8) * this.fsd];
                        this.fsc = State.READY;
                    } else {
                        BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on uninitialized recorder");
                        this.fsc = State.ERROR;
                        return false;
                    }
                } else {
                    fsa.prepare();
                    this.fsc = State.READY;
                }
                return true;
            }
            BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on illegal state");
            release();
            this.fsc = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured in prepare()");
            }
            this.fsc = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.fsc == State.RECORDING) {
            stop();
        } else {
            if ((this.fsc == State.READY) & this.frY) {
                try {
                    this.frI.close();
                } catch (IOException e) {
                    BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.frY) {
            if (frZ != null) {
                frZ.release();
            }
        } else if (fsa != null) {
            fsa.release();
        }
    }

    public void start() {
        if (this.fsc == State.READY) {
            if (this.frY) {
                this.payloadSize = 0;
                frZ.startRecording();
                frZ.read(this.buffer, 0, this.buffer.length);
            } else {
                fsa.start();
            }
            this.fsc = State.RECORDING;
            return;
        }
        BdLog.e(MyAudioRecorder.class.getName() + "start() called on illegal state");
        this.fsc = State.ERROR;
    }

    public void stop() {
        BdLog.e(MyAudioRecorder.class.getName() + "audioRecorder.stop()");
        frZ.stop();
        try {
            this.frI.seek(4L);
            this.frI.writeInt(Integer.reverseBytes(this.payloadSize + 36));
            this.frI.seek(40L);
            this.frI.writeInt(Integer.reverseBytes(this.payloadSize));
            this.frI.close();
            BdLog.e(MyAudioRecorder.class.getName() + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
            this.fsc = State.ERROR;
        }
        this.fsc = State.STOPPED;
    }

    private short b(byte b2, byte b3) {
        return (short) ((b3 << 8) | b2);
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean CJ(String str) {
        if (CL(str)) {
            return prepare();
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean bzg() {
        synchronized (mLock) {
            if (this.writeThread == null || !this.writeThread.isAlive()) {
                this.writeThread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.MyAudioRecorder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MyAudioRecorder.this.bzf();
                    }
                });
                this.writeThread.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void bzh() {
        this.fsc = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean bzi() {
        return this.fsc == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzf() {
        if (frZ != null) {
            try {
                start();
                while (bzi()) {
                    frZ.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.frI.write(this.buffer);
                        this.payloadSize += this.buffer.length;
                        if (this.fsf == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short b2 = b(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (b2 > this.fsb) {
                                    this.fsb = b2;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.fsb) {
                                    this.fsb = this.buffer[i2];
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
