package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import android.media.MediaRecorder;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class MyAudioRecorder implements d {
    private Thread apO;
    private boolean apP;
    private int apS;
    private State apT;
    private short apU;
    private int apV;
    private short apW;
    private int apX;
    private int apY;
    private int apZ;
    private int apy;
    private RandomAccessFile apz;
    private byte[] buffer;
    private String filePath;
    private int payloadSize;
    private static final int[] apN = {44100, 22050, 11025, 8000};
    private static Object mLock = new Object();
    private static AudioRecord apQ = null;
    private static MediaRecorder apR = null;

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
            apQ = null;
            apR = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, apN[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.xh() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, apN[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State xh() {
        return this.apT;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.apS = 0;
        this.filePath = null;
        try {
            this.apP = z;
            if (this.apP) {
                if (i4 == 2) {
                    this.apW = (short) 16;
                } else {
                    this.apW = (short) 8;
                }
                if (i3 == 2) {
                    this.apU = (short) 1;
                } else {
                    this.apU = (short) 2;
                }
                this.apX = i;
                this.apV = i2;
                this.apY = i4;
                this.apZ = (i2 * 120) / 1000;
                this.apy = (((this.apZ * 2) * this.apW) * this.apU) / 8;
                if (this.apy < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.apy = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.apZ = this.apy / (((this.apW * 2) * this.apU) / 8);
                    BdLog.w(MyAudioRecorder.class.getName() + "Increasing buffer size to " + Integer.toString(this.apy));
                }
                apQ = new AudioRecord(i, i2, i3, i4, this.apy);
                if (apQ.getRecordingState() == 3) {
                    apQ.stop();
                }
                if (apQ.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                apR = new MediaRecorder();
                apR.setAudioSource(1);
                apR.setOutputFormat(1);
                apR.setAudioEncoder(1);
            }
            this.apS = 0;
            this.filePath = null;
            this.apT = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while initializing recording");
            }
            this.apT = State.ERROR;
        }
    }

    public boolean ez(String str) {
        try {
            if (this.apT == State.INITIALIZING) {
                this.filePath = str;
                if (!this.apP) {
                    apR.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while setting output path");
            }
            this.apT = State.ERROR;
            return false;
        }
    }

    public boolean prepare() {
        try {
            if (this.apT == State.INITIALIZING) {
                if (this.apP) {
                    if ((this.filePath != null) & (apQ.getState() == 1)) {
                        if (this.apz != null) {
                            this.apz.close();
                            this.apz = null;
                        }
                        this.apz = new RandomAccessFile(this.filePath, "rw");
                        this.apz.setLength(0L);
                        this.apz.writeBytes("RIFF");
                        this.apz.writeInt(0);
                        this.apz.writeBytes("WAVE");
                        this.apz.writeBytes("fmt ");
                        this.apz.writeInt(Integer.reverseBytes(16));
                        this.apz.writeShort(Short.reverseBytes((short) 1));
                        this.apz.writeShort(Short.reverseBytes(this.apU));
                        this.apz.writeInt(Integer.reverseBytes(this.apV));
                        this.apz.writeInt(Integer.reverseBytes(((this.apV * this.apW) * this.apU) / 8));
                        this.apz.writeShort(Short.reverseBytes((short) ((this.apU * this.apW) / 8)));
                        this.apz.writeShort(Short.reverseBytes(this.apW));
                        this.apz.writeBytes("data");
                        this.apz.writeInt(0);
                        this.buffer = new byte[((this.apZ * this.apW) / 8) * this.apU];
                        this.apT = State.READY;
                    } else {
                        BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on uninitialized recorder");
                        this.apT = State.ERROR;
                        return false;
                    }
                } else {
                    apR.prepare();
                    this.apT = State.READY;
                }
                return true;
            }
            BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on illegal state");
            release();
            this.apT = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured in prepare()");
            }
            this.apT = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.apT == State.RECORDING) {
            stop();
        } else {
            if ((this.apT == State.READY) & this.apP) {
                try {
                    this.apz.close();
                } catch (IOException e) {
                    BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.apP) {
            if (apQ != null) {
                apQ.release();
            }
        } else if (apR != null) {
            apR.release();
        }
    }

    public void start() {
        if (this.apT == State.READY) {
            if (this.apP) {
                this.payloadSize = 0;
                apQ.startRecording();
                apQ.read(this.buffer, 0, this.buffer.length);
            } else {
                apR.start();
            }
            this.apT = State.RECORDING;
            return;
        }
        BdLog.e(MyAudioRecorder.class.getName() + "start() called on illegal state");
        this.apT = State.ERROR;
    }

    public void stop() {
        BdLog.e(MyAudioRecorder.class.getName() + "audioRecorder.stop()");
        apQ.stop();
        try {
            this.apz.seek(4L);
            this.apz.writeInt(Integer.reverseBytes(this.payloadSize + 36));
            this.apz.seek(40L);
            this.apz.writeInt(Integer.reverseBytes(this.payloadSize));
            this.apz.close();
            BdLog.e(MyAudioRecorder.class.getName() + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
            this.apT = State.ERROR;
        }
        this.apT = State.STOPPED;
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
            if (this.apO == null || !this.apO.isAlive()) {
                this.apO = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.MyAudioRecorder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MyAudioRecorder.this.xc();
                    }
                });
                this.apO.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void xe() {
        this.apT = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean isRecording() {
        return this.apT == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xc() {
        if (apQ != null) {
            try {
                start();
                while (isRecording()) {
                    apQ.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.apz.write(this.buffer);
                        this.payloadSize += this.buffer.length;
                        if (this.apW == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short b = b(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (b > this.apS) {
                                    this.apS = b;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.apS) {
                                    this.apS = this.buffer[i2];
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
