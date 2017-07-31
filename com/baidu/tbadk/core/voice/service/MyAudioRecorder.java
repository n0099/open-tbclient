package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import android.media.MediaRecorder;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class MyAudioRecorder implements d {
    private int aqB;
    private RandomAccessFile aqD;
    private Thread aqT;
    private boolean aqU;
    private int aqX;
    private State aqY;
    private short aqZ;
    private int ara;
    private short arb;
    private int arc;
    private int ard;
    private int are;
    private int arf;
    private byte[] buffer;
    private String filePath;
    private static final int[] aqS = {44100, 22050, 11025, 8000};
    private static Object mLock = new Object();
    private static AudioRecord aqV = null;
    private static MediaRecorder aqW = null;

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
            aqV = null;
            aqW = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, aqS[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.xG() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, aqS[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State xG() {
        return this.aqY;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.aqX = 0;
        this.filePath = null;
        try {
            this.aqU = z;
            if (this.aqU) {
                if (i4 == 2) {
                    this.arb = (short) 16;
                } else {
                    this.arb = (short) 8;
                }
                if (i3 == 2) {
                    this.aqZ = (short) 1;
                } else {
                    this.aqZ = (short) 2;
                }
                this.arc = i;
                this.ara = i2;
                this.ard = i4;
                this.are = (i2 * 120) / 1000;
                this.aqB = (((this.are * 2) * this.arb) * this.aqZ) / 8;
                if (this.aqB < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.aqB = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.are = this.aqB / (((this.arb * 2) * this.aqZ) / 8);
                    BdLog.w(MyAudioRecorder.class.getName() + "Increasing buffer size to " + Integer.toString(this.aqB));
                }
                aqV = new AudioRecord(i, i2, i3, i4, this.aqB);
                if (aqV.getRecordingState() == 3) {
                    aqV.stop();
                }
                if (aqV.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                aqW = new MediaRecorder();
                aqW.setAudioSource(1);
                aqW.setOutputFormat(1);
                aqW.setAudioEncoder(1);
            }
            this.aqX = 0;
            this.filePath = null;
            this.aqY = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while initializing recording");
            }
            this.aqY = State.ERROR;
        }
    }

    public boolean eC(String str) {
        try {
            if (this.aqY == State.INITIALIZING) {
                this.filePath = str;
                if (!this.aqU) {
                    aqW.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while setting output path");
            }
            this.aqY = State.ERROR;
            return false;
        }
    }

    public boolean prepare() {
        try {
            if (this.aqY == State.INITIALIZING) {
                if (this.aqU) {
                    if ((this.filePath != null) & (aqV.getState() == 1)) {
                        if (this.aqD != null) {
                            this.aqD.close();
                            this.aqD = null;
                        }
                        this.aqD = new RandomAccessFile(this.filePath, "rw");
                        this.aqD.setLength(0L);
                        this.aqD.writeBytes("RIFF");
                        this.aqD.writeInt(0);
                        this.aqD.writeBytes("WAVE");
                        this.aqD.writeBytes("fmt ");
                        this.aqD.writeInt(Integer.reverseBytes(16));
                        this.aqD.writeShort(Short.reverseBytes((short) 1));
                        this.aqD.writeShort(Short.reverseBytes(this.aqZ));
                        this.aqD.writeInt(Integer.reverseBytes(this.ara));
                        this.aqD.writeInt(Integer.reverseBytes(((this.ara * this.arb) * this.aqZ) / 8));
                        this.aqD.writeShort(Short.reverseBytes((short) ((this.aqZ * this.arb) / 8)));
                        this.aqD.writeShort(Short.reverseBytes(this.arb));
                        this.aqD.writeBytes("data");
                        this.aqD.writeInt(0);
                        this.buffer = new byte[((this.are * this.arb) / 8) * this.aqZ];
                        this.aqY = State.READY;
                    } else {
                        BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on uninitialized recorder");
                        this.aqY = State.ERROR;
                        return false;
                    }
                } else {
                    aqW.prepare();
                    this.aqY = State.READY;
                }
                return true;
            }
            BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on illegal state");
            release();
            this.aqY = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured in prepare()");
            }
            this.aqY = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.aqY == State.RECORDING) {
            stop();
        } else {
            if ((this.aqY == State.READY) & this.aqU) {
                try {
                    this.aqD.close();
                } catch (IOException e) {
                    BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.aqU) {
            if (aqV != null) {
                aqV.release();
            }
        } else if (aqW != null) {
            aqW.release();
        }
    }

    public void start() {
        if (this.aqY == State.READY) {
            if (this.aqU) {
                this.arf = 0;
                aqV.startRecording();
                aqV.read(this.buffer, 0, this.buffer.length);
            } else {
                aqW.start();
            }
            this.aqY = State.RECORDING;
            return;
        }
        BdLog.e(MyAudioRecorder.class.getName() + "start() called on illegal state");
        this.aqY = State.ERROR;
    }

    public void stop() {
        BdLog.e(MyAudioRecorder.class.getName() + "audioRecorder.stop()");
        aqV.stop();
        try {
            this.aqD.seek(4L);
            this.aqD.writeInt(Integer.reverseBytes(this.arf + 36));
            this.aqD.seek(40L);
            this.aqD.writeInt(Integer.reverseBytes(this.arf));
            this.aqD.close();
            BdLog.e(MyAudioRecorder.class.getName() + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
            this.aqY = State.ERROR;
        }
        this.aqY = State.STOPPED;
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
            if (this.aqT == null || !this.aqT.isAlive()) {
                this.aqT = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.MyAudioRecorder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MyAudioRecorder.this.xB();
                    }
                });
                this.aqT.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void xD() {
        this.aqY = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean isRecording() {
        return this.aqY == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xB() {
        if (aqV != null) {
            try {
                start();
                while (isRecording()) {
                    aqV.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.aqD.write(this.buffer);
                        this.arf += this.buffer.length;
                        if (this.arb == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short b = b(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (b > this.aqX) {
                                    this.aqX = b;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.aqX) {
                                    this.aqX = this.buffer[i2];
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
