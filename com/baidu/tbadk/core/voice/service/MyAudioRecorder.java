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
    private RandomAccessFile eyV;
    private boolean ezl;
    private int ezo;
    private State ezp;
    private short ezq;
    private int ezr;
    private short ezs;
    private int ezt;
    private int ezu;
    private int ezv;
    private String filePath;
    private int payloadSize;
    private Thread writeThread;
    private static final int[] ezk = {44100, 22050, RequestResponseCode.REQUEST_LOGIN_PB_AT, CoolPraiseGuideLottieView.ANIM_DURATION};
    private static Object mLock = new Object();
    private static AudioRecord ezm = null;
    private static MediaRecorder ezn = null;

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
            ezm = null;
            ezn = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, ezk[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.bme() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, ezk[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State bme() {
        return this.ezp;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.ezo = 0;
        this.filePath = null;
        try {
            this.ezl = z;
            if (this.ezl) {
                if (i4 == 2) {
                    this.ezs = (short) 16;
                } else {
                    this.ezs = (short) 8;
                }
                if (i3 == 2) {
                    this.ezq = (short) 1;
                } else {
                    this.ezq = (short) 2;
                }
                this.ezt = i;
                this.ezr = i2;
                this.ezu = i4;
                this.ezv = (i2 * 120) / 1000;
                this.bufferSize = (((this.ezv * 2) * this.ezs) * this.ezq) / 8;
                if (this.bufferSize < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.ezv = this.bufferSize / (((this.ezs * 2) * this.ezq) / 8);
                    BdLog.w(MyAudioRecorder.class.getName() + "Increasing buffer size to " + Integer.toString(this.bufferSize));
                }
                ezm = new AudioRecord(i, i2, i3, i4, this.bufferSize);
                if (ezm.getRecordingState() == 3) {
                    ezm.stop();
                }
                if (ezm.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                ezn = new MediaRecorder();
                ezn.setAudioSource(1);
                ezn.setOutputFormat(1);
                ezn.setAudioEncoder(1);
            }
            this.ezo = 0;
            this.filePath = null;
            this.ezp = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while initializing recording");
            }
            this.ezp = State.ERROR;
        }
    }

    public boolean AR(String str) {
        try {
            if (this.ezp == State.INITIALIZING) {
                this.filePath = str;
                if (!this.ezl) {
                    ezn.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while setting output path");
            }
            this.ezp = State.ERROR;
            return false;
        }
    }

    public boolean prepare() {
        try {
            if (this.ezp == State.INITIALIZING) {
                if (this.ezl) {
                    if ((this.filePath != null) & (ezm.getState() == 1)) {
                        if (this.eyV != null) {
                            this.eyV.close();
                            this.eyV = null;
                        }
                        this.eyV = new RandomAccessFile(this.filePath, "rw");
                        this.eyV.setLength(0L);
                        this.eyV.writeBytes("RIFF");
                        this.eyV.writeInt(0);
                        this.eyV.writeBytes("WAVE");
                        this.eyV.writeBytes("fmt ");
                        this.eyV.writeInt(Integer.reverseBytes(16));
                        this.eyV.writeShort(Short.reverseBytes((short) 1));
                        this.eyV.writeShort(Short.reverseBytes(this.ezq));
                        this.eyV.writeInt(Integer.reverseBytes(this.ezr));
                        this.eyV.writeInt(Integer.reverseBytes(((this.ezr * this.ezs) * this.ezq) / 8));
                        this.eyV.writeShort(Short.reverseBytes((short) ((this.ezq * this.ezs) / 8)));
                        this.eyV.writeShort(Short.reverseBytes(this.ezs));
                        this.eyV.writeBytes("data");
                        this.eyV.writeInt(0);
                        this.buffer = new byte[((this.ezv * this.ezs) / 8) * this.ezq];
                        this.ezp = State.READY;
                    } else {
                        BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on uninitialized recorder");
                        this.ezp = State.ERROR;
                        return false;
                    }
                } else {
                    ezn.prepare();
                    this.ezp = State.READY;
                }
                return true;
            }
            BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on illegal state");
            release();
            this.ezp = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured in prepare()");
            }
            this.ezp = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.ezp == State.RECORDING) {
            stop();
        } else {
            if ((this.ezp == State.READY) & this.ezl) {
                try {
                    this.eyV.close();
                } catch (IOException e) {
                    BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.ezl) {
            if (ezm != null) {
                ezm.release();
            }
        } else if (ezn != null) {
            ezn.release();
        }
    }

    public void start() {
        if (this.ezp == State.READY) {
            if (this.ezl) {
                this.payloadSize = 0;
                ezm.startRecording();
                ezm.read(this.buffer, 0, this.buffer.length);
            } else {
                ezn.start();
            }
            this.ezp = State.RECORDING;
            return;
        }
        BdLog.e(MyAudioRecorder.class.getName() + "start() called on illegal state");
        this.ezp = State.ERROR;
    }

    public void stop() {
        BdLog.e(MyAudioRecorder.class.getName() + "audioRecorder.stop()");
        ezm.stop();
        try {
            this.eyV.seek(4L);
            this.eyV.writeInt(Integer.reverseBytes(this.payloadSize + 36));
            this.eyV.seek(40L);
            this.eyV.writeInt(Integer.reverseBytes(this.payloadSize));
            this.eyV.close();
            BdLog.e(MyAudioRecorder.class.getName() + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
            this.ezp = State.ERROR;
        }
        this.ezp = State.STOPPED;
    }

    private short b(byte b, byte b2) {
        return (short) ((b2 << 8) | b);
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean AP(String str) {
        if (AR(str)) {
            return prepare();
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean bma() {
        synchronized (mLock) {
            if (this.writeThread == null || !this.writeThread.isAlive()) {
                this.writeThread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.MyAudioRecorder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MyAudioRecorder.this.blZ();
                    }
                });
                this.writeThread.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void bmb() {
        this.ezp = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean bmc() {
        return this.ezp == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blZ() {
        if (ezm != null) {
            try {
                start();
                while (bmc()) {
                    ezm.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.eyV.write(this.buffer);
                        this.payloadSize += this.buffer.length;
                        if (this.ezs == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short b = b(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (b > this.ezo) {
                                    this.ezo = b;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.ezo) {
                                    this.ezo = this.buffer[i2];
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
