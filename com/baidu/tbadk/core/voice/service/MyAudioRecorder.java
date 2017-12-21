package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import android.media.MediaRecorder;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class MyAudioRecorder implements d {
    private int apW;
    private RandomAccessFile apX;
    private Thread aqm;
    private boolean aqn;
    private int aqq;
    private State aqr;
    private short aqs;
    private int aqt;
    private short aqu;
    private int aqv;
    private int aqw;
    private int aqx;
    private byte[] buffer;
    private String filePath;
    private int payloadSize;
    private static final int[] aql = {44100, 22050, 11025, 8000};
    private static Object mLock = new Object();
    private static AudioRecord aqo = null;
    private static MediaRecorder aqp = null;

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
            aqo = null;
            aqp = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, aql[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.xh() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, aql[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State xh() {
        return this.aqr;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.aqq = 0;
        this.filePath = null;
        try {
            this.aqn = z;
            if (this.aqn) {
                if (i4 == 2) {
                    this.aqu = (short) 16;
                } else {
                    this.aqu = (short) 8;
                }
                if (i3 == 2) {
                    this.aqs = (short) 1;
                } else {
                    this.aqs = (short) 2;
                }
                this.aqv = i;
                this.aqt = i2;
                this.aqw = i4;
                this.aqx = (i2 * 120) / 1000;
                this.apW = (((this.aqx * 2) * this.aqu) * this.aqs) / 8;
                if (this.apW < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.apW = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.aqx = this.apW / (((this.aqu * 2) * this.aqs) / 8);
                    BdLog.w(MyAudioRecorder.class.getName() + "Increasing buffer size to " + Integer.toString(this.apW));
                }
                aqo = new AudioRecord(i, i2, i3, i4, this.apW);
                if (aqo.getRecordingState() == 3) {
                    aqo.stop();
                }
                if (aqo.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                aqp = new MediaRecorder();
                aqp.setAudioSource(1);
                aqp.setOutputFormat(1);
                aqp.setAudioEncoder(1);
            }
            this.aqq = 0;
            this.filePath = null;
            this.aqr = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while initializing recording");
            }
            this.aqr = State.ERROR;
        }
    }

    public boolean eE(String str) {
        try {
            if (this.aqr == State.INITIALIZING) {
                this.filePath = str;
                if (!this.aqn) {
                    aqp.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while setting output path");
            }
            this.aqr = State.ERROR;
            return false;
        }
    }

    public boolean prepare() {
        try {
            if (this.aqr == State.INITIALIZING) {
                if (this.aqn) {
                    if ((this.filePath != null) & (aqo.getState() == 1)) {
                        if (this.apX != null) {
                            this.apX.close();
                            this.apX = null;
                        }
                        this.apX = new RandomAccessFile(this.filePath, "rw");
                        this.apX.setLength(0L);
                        this.apX.writeBytes("RIFF");
                        this.apX.writeInt(0);
                        this.apX.writeBytes("WAVE");
                        this.apX.writeBytes("fmt ");
                        this.apX.writeInt(Integer.reverseBytes(16));
                        this.apX.writeShort(Short.reverseBytes((short) 1));
                        this.apX.writeShort(Short.reverseBytes(this.aqs));
                        this.apX.writeInt(Integer.reverseBytes(this.aqt));
                        this.apX.writeInt(Integer.reverseBytes(((this.aqt * this.aqu) * this.aqs) / 8));
                        this.apX.writeShort(Short.reverseBytes((short) ((this.aqs * this.aqu) / 8)));
                        this.apX.writeShort(Short.reverseBytes(this.aqu));
                        this.apX.writeBytes("data");
                        this.apX.writeInt(0);
                        this.buffer = new byte[((this.aqx * this.aqu) / 8) * this.aqs];
                        this.aqr = State.READY;
                    } else {
                        BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on uninitialized recorder");
                        this.aqr = State.ERROR;
                        return false;
                    }
                } else {
                    aqp.prepare();
                    this.aqr = State.READY;
                }
                return true;
            }
            BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on illegal state");
            release();
            this.aqr = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured in prepare()");
            }
            this.aqr = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.aqr == State.RECORDING) {
            stop();
        } else {
            if ((this.aqr == State.READY) & this.aqn) {
                try {
                    this.apX.close();
                } catch (IOException e) {
                    BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.aqn) {
            if (aqo != null) {
                aqo.release();
            }
        } else if (aqp != null) {
            aqp.release();
        }
    }

    public void start() {
        if (this.aqr == State.READY) {
            if (this.aqn) {
                this.payloadSize = 0;
                aqo.startRecording();
                aqo.read(this.buffer, 0, this.buffer.length);
            } else {
                aqp.start();
            }
            this.aqr = State.RECORDING;
            return;
        }
        BdLog.e(MyAudioRecorder.class.getName() + "start() called on illegal state");
        this.aqr = State.ERROR;
    }

    public void stop() {
        BdLog.e(MyAudioRecorder.class.getName() + "audioRecorder.stop()");
        aqo.stop();
        try {
            this.apX.seek(4L);
            this.apX.writeInt(Integer.reverseBytes(this.payloadSize + 36));
            this.apX.seek(40L);
            this.apX.writeInt(Integer.reverseBytes(this.payloadSize));
            this.apX.close();
            BdLog.e(MyAudioRecorder.class.getName() + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
            this.aqr = State.ERROR;
        }
        this.aqr = State.STOPPED;
    }

    private short b(byte b, byte b2) {
        return (short) ((b2 << 8) | b);
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean eC(String str) {
        if (eE(str)) {
            return prepare();
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean xd() {
        synchronized (mLock) {
            if (this.aqm == null || !this.aqm.isAlive()) {
                this.aqm = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.MyAudioRecorder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MyAudioRecorder.this.xc();
                    }
                });
                this.aqm.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void xe() {
        this.aqr = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean isRecording() {
        return this.aqr == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xc() {
        if (aqo != null) {
            try {
                start();
                while (isRecording()) {
                    aqo.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.apX.write(this.buffer);
                        this.payloadSize += this.buffer.length;
                        if (this.aqu == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short b = b(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (b > this.aqq) {
                                    this.aqq = b;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.aqq) {
                                    this.aqq = this.buffer[i2];
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
