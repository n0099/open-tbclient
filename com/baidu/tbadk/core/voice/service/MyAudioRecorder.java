package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import android.media.MediaRecorder;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class MyAudioRecorder implements d {
    private int aqC;
    private RandomAccessFile aqE;
    private Thread aqU;
    private boolean aqV;
    private int aqY;
    private State aqZ;
    private short ara;
    private int arb;
    private short arc;
    private int ard;
    private int are;
    private int arf;
    private int arg;
    private byte[] buffer;
    private String filePath;
    private static final int[] aqT = {44100, 22050, 11025, 8000};
    private static Object mLock = new Object();
    private static AudioRecord aqW = null;
    private static MediaRecorder aqX = null;

    /* loaded from: classes.dex */
    public enum State {
        INITIALIZING,
        READY,
        RECORDING,
        ERROR,
        STOPPED
    }

    public static MyAudioRecorder c(Boolean bool) {
        MyAudioRecorder myAudioRecorder;
        synchronized (mLock) {
            aqW = null;
            aqX = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, aqT[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.xG() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, aqT[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State xG() {
        return this.aqZ;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.aqY = 0;
        this.filePath = null;
        try {
            this.aqV = z;
            if (this.aqV) {
                if (i4 == 2) {
                    this.arc = (short) 16;
                } else {
                    this.arc = (short) 8;
                }
                if (i3 == 2) {
                    this.ara = (short) 1;
                } else {
                    this.ara = (short) 2;
                }
                this.ard = i;
                this.arb = i2;
                this.are = i4;
                this.arf = (i2 * 120) / 1000;
                this.aqC = (((this.arf * 2) * this.arc) * this.ara) / 8;
                if (this.aqC < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.aqC = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.arf = this.aqC / (((this.arc * 2) * this.ara) / 8);
                    BdLog.w(MyAudioRecorder.class.getName() + "Increasing buffer size to " + Integer.toString(this.aqC));
                }
                aqW = new AudioRecord(i, i2, i3, i4, this.aqC);
                if (aqW.getRecordingState() == 3) {
                    aqW.stop();
                }
                if (aqW.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                aqX = new MediaRecorder();
                aqX.setAudioSource(1);
                aqX.setOutputFormat(1);
                aqX.setAudioEncoder(1);
            }
            this.aqY = 0;
            this.filePath = null;
            this.aqZ = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while initializing recording");
            }
            this.aqZ = State.ERROR;
        }
    }

    public boolean eC(String str) {
        try {
            if (this.aqZ == State.INITIALIZING) {
                this.filePath = str;
                if (!this.aqV) {
                    aqX.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while setting output path");
            }
            this.aqZ = State.ERROR;
            return false;
        }
    }

    public boolean prepare() {
        try {
            if (this.aqZ == State.INITIALIZING) {
                if (this.aqV) {
                    if ((this.filePath != null) & (aqW.getState() == 1)) {
                        if (this.aqE != null) {
                            this.aqE.close();
                            this.aqE = null;
                        }
                        this.aqE = new RandomAccessFile(this.filePath, "rw");
                        this.aqE.setLength(0L);
                        this.aqE.writeBytes("RIFF");
                        this.aqE.writeInt(0);
                        this.aqE.writeBytes("WAVE");
                        this.aqE.writeBytes("fmt ");
                        this.aqE.writeInt(Integer.reverseBytes(16));
                        this.aqE.writeShort(Short.reverseBytes((short) 1));
                        this.aqE.writeShort(Short.reverseBytes(this.ara));
                        this.aqE.writeInt(Integer.reverseBytes(this.arb));
                        this.aqE.writeInt(Integer.reverseBytes(((this.arb * this.arc) * this.ara) / 8));
                        this.aqE.writeShort(Short.reverseBytes((short) ((this.ara * this.arc) / 8)));
                        this.aqE.writeShort(Short.reverseBytes(this.arc));
                        this.aqE.writeBytes("data");
                        this.aqE.writeInt(0);
                        this.buffer = new byte[((this.arf * this.arc) / 8) * this.ara];
                        this.aqZ = State.READY;
                    } else {
                        BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on uninitialized recorder");
                        this.aqZ = State.ERROR;
                        return false;
                    }
                } else {
                    aqX.prepare();
                    this.aqZ = State.READY;
                }
                return true;
            }
            BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on illegal state");
            release();
            this.aqZ = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured in prepare()");
            }
            this.aqZ = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.aqZ == State.RECORDING) {
            stop();
        } else {
            if ((this.aqZ == State.READY) & this.aqV) {
                try {
                    this.aqE.close();
                } catch (IOException e) {
                    BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.aqV) {
            if (aqW != null) {
                aqW.release();
            }
        } else if (aqX != null) {
            aqX.release();
        }
    }

    public void start() {
        if (this.aqZ == State.READY) {
            if (this.aqV) {
                this.arg = 0;
                aqW.startRecording();
                aqW.read(this.buffer, 0, this.buffer.length);
            } else {
                aqX.start();
            }
            this.aqZ = State.RECORDING;
            return;
        }
        BdLog.e(MyAudioRecorder.class.getName() + "start() called on illegal state");
        this.aqZ = State.ERROR;
    }

    public void stop() {
        BdLog.e(MyAudioRecorder.class.getName() + "audioRecorder.stop()");
        aqW.stop();
        try {
            this.aqE.seek(4L);
            this.aqE.writeInt(Integer.reverseBytes(this.arg + 36));
            this.aqE.seek(40L);
            this.aqE.writeInt(Integer.reverseBytes(this.arg));
            this.aqE.close();
            BdLog.e(MyAudioRecorder.class.getName() + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
            this.aqZ = State.ERROR;
        }
        this.aqZ = State.STOPPED;
    }

    private short b(byte b, byte b2) {
        return (short) ((b2 << 8) | b);
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean eA(String str) {
        if (eC(str)) {
            return prepare();
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean xC() {
        synchronized (mLock) {
            if (this.aqU == null || !this.aqU.isAlive()) {
                this.aqU = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.MyAudioRecorder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MyAudioRecorder.this.xB();
                    }
                });
                this.aqU.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void xD() {
        this.aqZ = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean isRecording() {
        return this.aqZ == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xB() {
        if (aqW != null) {
            try {
                start();
                while (isRecording()) {
                    aqW.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.aqE.write(this.buffer);
                        this.arg += this.buffer.length;
                        if (this.arc == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short b = b(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (b > this.aqY) {
                                    this.aqY = b;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.aqY) {
                                    this.aqY = this.buffer[i2];
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
