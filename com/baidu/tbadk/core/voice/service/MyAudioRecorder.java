package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import android.media.MediaRecorder;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class MyAudioRecorder implements d {
    private RandomAccessFile apA;
    private Thread apP;
    private boolean apQ;
    private int apT;
    private State apU;
    private short apV;
    private int apW;
    private short apX;
    private int apY;
    private int apZ;
    private int apz;
    private int aqa;
    private byte[] buffer;
    private String filePath;
    private int payloadSize;
    private static final int[] apO = {44100, 22050, 11025, 8000};
    private static Object mLock = new Object();
    private static AudioRecord apR = null;
    private static MediaRecorder apS = null;

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
            apR = null;
            apS = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, apO[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.xh() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, apO[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State xh() {
        return this.apU;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.apT = 0;
        this.filePath = null;
        try {
            this.apQ = z;
            if (this.apQ) {
                if (i4 == 2) {
                    this.apX = (short) 16;
                } else {
                    this.apX = (short) 8;
                }
                if (i3 == 2) {
                    this.apV = (short) 1;
                } else {
                    this.apV = (short) 2;
                }
                this.apY = i;
                this.apW = i2;
                this.apZ = i4;
                this.aqa = (i2 * 120) / 1000;
                this.apz = (((this.aqa * 2) * this.apX) * this.apV) / 8;
                if (this.apz < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.apz = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.aqa = this.apz / (((this.apX * 2) * this.apV) / 8);
                    BdLog.w(MyAudioRecorder.class.getName() + "Increasing buffer size to " + Integer.toString(this.apz));
                }
                apR = new AudioRecord(i, i2, i3, i4, this.apz);
                if (apR.getRecordingState() == 3) {
                    apR.stop();
                }
                if (apR.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                apS = new MediaRecorder();
                apS.setAudioSource(1);
                apS.setOutputFormat(1);
                apS.setAudioEncoder(1);
            }
            this.apT = 0;
            this.filePath = null;
            this.apU = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while initializing recording");
            }
            this.apU = State.ERROR;
        }
    }

    public boolean ez(String str) {
        try {
            if (this.apU == State.INITIALIZING) {
                this.filePath = str;
                if (!this.apQ) {
                    apS.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while setting output path");
            }
            this.apU = State.ERROR;
            return false;
        }
    }

    public boolean prepare() {
        try {
            if (this.apU == State.INITIALIZING) {
                if (this.apQ) {
                    if ((this.filePath != null) & (apR.getState() == 1)) {
                        if (this.apA != null) {
                            this.apA.close();
                            this.apA = null;
                        }
                        this.apA = new RandomAccessFile(this.filePath, "rw");
                        this.apA.setLength(0L);
                        this.apA.writeBytes("RIFF");
                        this.apA.writeInt(0);
                        this.apA.writeBytes("WAVE");
                        this.apA.writeBytes("fmt ");
                        this.apA.writeInt(Integer.reverseBytes(16));
                        this.apA.writeShort(Short.reverseBytes((short) 1));
                        this.apA.writeShort(Short.reverseBytes(this.apV));
                        this.apA.writeInt(Integer.reverseBytes(this.apW));
                        this.apA.writeInt(Integer.reverseBytes(((this.apW * this.apX) * this.apV) / 8));
                        this.apA.writeShort(Short.reverseBytes((short) ((this.apV * this.apX) / 8)));
                        this.apA.writeShort(Short.reverseBytes(this.apX));
                        this.apA.writeBytes("data");
                        this.apA.writeInt(0);
                        this.buffer = new byte[((this.aqa * this.apX) / 8) * this.apV];
                        this.apU = State.READY;
                    } else {
                        BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on uninitialized recorder");
                        this.apU = State.ERROR;
                        return false;
                    }
                } else {
                    apS.prepare();
                    this.apU = State.READY;
                }
                return true;
            }
            BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on illegal state");
            release();
            this.apU = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured in prepare()");
            }
            this.apU = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.apU == State.RECORDING) {
            stop();
        } else {
            if ((this.apU == State.READY) & this.apQ) {
                try {
                    this.apA.close();
                } catch (IOException e) {
                    BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.apQ) {
            if (apR != null) {
                apR.release();
            }
        } else if (apS != null) {
            apS.release();
        }
    }

    public void start() {
        if (this.apU == State.READY) {
            if (this.apQ) {
                this.payloadSize = 0;
                apR.startRecording();
                apR.read(this.buffer, 0, this.buffer.length);
            } else {
                apS.start();
            }
            this.apU = State.RECORDING;
            return;
        }
        BdLog.e(MyAudioRecorder.class.getName() + "start() called on illegal state");
        this.apU = State.ERROR;
    }

    public void stop() {
        BdLog.e(MyAudioRecorder.class.getName() + "audioRecorder.stop()");
        apR.stop();
        try {
            this.apA.seek(4L);
            this.apA.writeInt(Integer.reverseBytes(this.payloadSize + 36));
            this.apA.seek(40L);
            this.apA.writeInt(Integer.reverseBytes(this.payloadSize));
            this.apA.close();
            BdLog.e(MyAudioRecorder.class.getName() + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
            this.apU = State.ERROR;
        }
        this.apU = State.STOPPED;
    }

    private short b(byte b, byte b2) {
        return (short) ((b2 << 8) | b);
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean ex(String str) {
        if (ez(str)) {
            return prepare();
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean xd() {
        synchronized (mLock) {
            if (this.apP == null || !this.apP.isAlive()) {
                this.apP = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.MyAudioRecorder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MyAudioRecorder.this.xc();
                    }
                });
                this.apP.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void xe() {
        this.apU = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean isRecording() {
        return this.apU == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xc() {
        if (apR != null) {
            try {
                start();
                while (isRecording()) {
                    apR.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.apA.write(this.buffer);
                        this.payloadSize += this.buffer.length;
                        if (this.apX == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short b = b(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (b > this.apT) {
                                    this.apT = b;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.apT) {
                                    this.apT = this.buffer[i2];
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
