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
    private RandomAccessFile eAZ;
    private boolean eBp;
    private int eBs;
    private State eBt;
    private short eBu;
    private int eBv;
    private short eBw;
    private int eBx;
    private int eBy;
    private int eBz;
    private String filePath;
    private int payloadSize;
    private Thread writeThread;
    private static final int[] eBo = {44100, 22050, RequestResponseCode.REQUEST_LOGIN_PB_AT, CoolPraiseGuideLottieView.ANIM_DURATION};
    private static Object mLock = new Object();
    private static AudioRecord eBq = null;
    private static MediaRecorder eBr = null;

    /* loaded from: classes.dex */
    public enum State {
        INITIALIZING,
        READY,
        RECORDING,
        ERROR,
        STOPPED
    }

    public static MyAudioRecorder k(Boolean bool) {
        MyAudioRecorder myAudioRecorder;
        synchronized (mLock) {
            eBq = null;
            eBr = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, eBo[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.bmY() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, eBo[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State bmY() {
        return this.eBt;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.eBs = 0;
        this.filePath = null;
        try {
            this.eBp = z;
            if (this.eBp) {
                if (i4 == 2) {
                    this.eBw = (short) 16;
                } else {
                    this.eBw = (short) 8;
                }
                if (i3 == 2) {
                    this.eBu = (short) 1;
                } else {
                    this.eBu = (short) 2;
                }
                this.eBx = i;
                this.eBv = i2;
                this.eBy = i4;
                this.eBz = (i2 * 120) / 1000;
                this.bufferSize = (((this.eBz * 2) * this.eBw) * this.eBu) / 8;
                if (this.bufferSize < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.eBz = this.bufferSize / (((this.eBw * 2) * this.eBu) / 8);
                    BdLog.w(MyAudioRecorder.class.getName() + "Increasing buffer size to " + Integer.toString(this.bufferSize));
                }
                eBq = new AudioRecord(i, i2, i3, i4, this.bufferSize);
                if (eBq.getRecordingState() == 3) {
                    eBq.stop();
                }
                if (eBq.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                eBr = new MediaRecorder();
                eBr.setAudioSource(1);
                eBr.setOutputFormat(1);
                eBr.setAudioEncoder(1);
            }
            this.eBs = 0;
            this.filePath = null;
            this.eBt = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while initializing recording");
            }
            this.eBt = State.ERROR;
        }
    }

    public boolean Bn(String str) {
        try {
            if (this.eBt == State.INITIALIZING) {
                this.filePath = str;
                if (!this.eBp) {
                    eBr.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while setting output path");
            }
            this.eBt = State.ERROR;
            return false;
        }
    }

    public boolean prepare() {
        try {
            if (this.eBt == State.INITIALIZING) {
                if (this.eBp) {
                    if ((this.filePath != null) & (eBq.getState() == 1)) {
                        if (this.eAZ != null) {
                            this.eAZ.close();
                            this.eAZ = null;
                        }
                        this.eAZ = new RandomAccessFile(this.filePath, "rw");
                        this.eAZ.setLength(0L);
                        this.eAZ.writeBytes("RIFF");
                        this.eAZ.writeInt(0);
                        this.eAZ.writeBytes("WAVE");
                        this.eAZ.writeBytes("fmt ");
                        this.eAZ.writeInt(Integer.reverseBytes(16));
                        this.eAZ.writeShort(Short.reverseBytes((short) 1));
                        this.eAZ.writeShort(Short.reverseBytes(this.eBu));
                        this.eAZ.writeInt(Integer.reverseBytes(this.eBv));
                        this.eAZ.writeInt(Integer.reverseBytes(((this.eBv * this.eBw) * this.eBu) / 8));
                        this.eAZ.writeShort(Short.reverseBytes((short) ((this.eBu * this.eBw) / 8)));
                        this.eAZ.writeShort(Short.reverseBytes(this.eBw));
                        this.eAZ.writeBytes("data");
                        this.eAZ.writeInt(0);
                        this.buffer = new byte[((this.eBz * this.eBw) / 8) * this.eBu];
                        this.eBt = State.READY;
                    } else {
                        BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on uninitialized recorder");
                        this.eBt = State.ERROR;
                        return false;
                    }
                } else {
                    eBr.prepare();
                    this.eBt = State.READY;
                }
                return true;
            }
            BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on illegal state");
            release();
            this.eBt = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured in prepare()");
            }
            this.eBt = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.eBt == State.RECORDING) {
            stop();
        } else {
            if ((this.eBt == State.READY) & this.eBp) {
                try {
                    this.eAZ.close();
                } catch (IOException e) {
                    BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.eBp) {
            if (eBq != null) {
                eBq.release();
            }
        } else if (eBr != null) {
            eBr.release();
        }
    }

    public void start() {
        if (this.eBt == State.READY) {
            if (this.eBp) {
                this.payloadSize = 0;
                eBq.startRecording();
                eBq.read(this.buffer, 0, this.buffer.length);
            } else {
                eBr.start();
            }
            this.eBt = State.RECORDING;
            return;
        }
        BdLog.e(MyAudioRecorder.class.getName() + "start() called on illegal state");
        this.eBt = State.ERROR;
    }

    public void stop() {
        BdLog.e(MyAudioRecorder.class.getName() + "audioRecorder.stop()");
        eBq.stop();
        try {
            this.eAZ.seek(4L);
            this.eAZ.writeInt(Integer.reverseBytes(this.payloadSize + 36));
            this.eAZ.seek(40L);
            this.eAZ.writeInt(Integer.reverseBytes(this.payloadSize));
            this.eAZ.close();
            BdLog.e(MyAudioRecorder.class.getName() + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
            this.eBt = State.ERROR;
        }
        this.eBt = State.STOPPED;
    }

    private short b(byte b, byte b2) {
        return (short) ((b2 << 8) | b);
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean Bl(String str) {
        if (Bn(str)) {
            return prepare();
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean bmU() {
        synchronized (mLock) {
            if (this.writeThread == null || !this.writeThread.isAlive()) {
                this.writeThread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.MyAudioRecorder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MyAudioRecorder.this.bmT();
                    }
                });
                this.writeThread.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void bmV() {
        this.eBt = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean bmW() {
        return this.eBt == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmT() {
        if (eBq != null) {
            try {
                start();
                while (bmW()) {
                    eBq.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.eAZ.write(this.buffer);
                        this.payloadSize += this.buffer.length;
                        if (this.eBw == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short b = b(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (b > this.eBs) {
                                    this.eBs = b;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.eBs) {
                                    this.eBs = this.buffer[i2];
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
