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
    private boolean faP;
    private int faS;
    private State faT;
    private short faU;
    private int faV;
    private short faW;
    private int faX;
    private int faY;
    private int faZ;
    private RandomAccessFile faz;
    private String filePath;
    private int payloadSize;
    private Thread writeThread;
    private static final int[] faO = {44100, 22050, RequestResponseCode.REQUEST_LOGIN_PB_AT, CoolPraiseGuideLottieView.ANIM_DURATION};
    private static Object mLock = new Object();
    private static AudioRecord faQ = null;
    private static MediaRecorder faR = null;

    /* loaded from: classes.dex */
    public enum State {
        INITIALIZING,
        READY,
        RECORDING,
        ERROR,
        STOPPED
    }

    public static MyAudioRecorder l(Boolean bool) {
        MyAudioRecorder myAudioRecorder;
        synchronized (mLock) {
            faQ = null;
            faR = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, faO[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.btr() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, faO[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State btr() {
        return this.faT;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.faS = 0;
        this.filePath = null;
        try {
            this.faP = z;
            if (this.faP) {
                if (i4 == 2) {
                    this.faW = (short) 16;
                } else {
                    this.faW = (short) 8;
                }
                if (i3 == 2) {
                    this.faU = (short) 1;
                } else {
                    this.faU = (short) 2;
                }
                this.faX = i;
                this.faV = i2;
                this.faY = i4;
                this.faZ = (i2 * 120) / 1000;
                this.bufferSize = (((this.faZ * 2) * this.faW) * this.faU) / 8;
                if (this.bufferSize < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.faZ = this.bufferSize / (((this.faW * 2) * this.faU) / 8);
                    BdLog.w(MyAudioRecorder.class.getName() + "Increasing buffer size to " + Integer.toString(this.bufferSize));
                }
                faQ = new AudioRecord(i, i2, i3, i4, this.bufferSize);
                if (faQ.getRecordingState() == 3) {
                    faQ.stop();
                }
                if (faQ.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                faR = new MediaRecorder();
                faR.setAudioSource(1);
                faR.setOutputFormat(1);
                faR.setAudioEncoder(1);
            }
            this.faS = 0;
            this.filePath = null;
            this.faT = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while initializing recording");
            }
            this.faT = State.ERROR;
        }
    }

    public boolean Cf(String str) {
        try {
            if (this.faT == State.INITIALIZING) {
                this.filePath = str;
                if (!this.faP) {
                    faR.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while setting output path");
            }
            this.faT = State.ERROR;
            return false;
        }
    }

    public boolean prepare() {
        try {
            if (this.faT == State.INITIALIZING) {
                if (this.faP) {
                    if ((this.filePath != null) & (faQ.getState() == 1)) {
                        if (this.faz != null) {
                            this.faz.close();
                            this.faz = null;
                        }
                        this.faz = new RandomAccessFile(this.filePath, "rw");
                        this.faz.setLength(0L);
                        this.faz.writeBytes("RIFF");
                        this.faz.writeInt(0);
                        this.faz.writeBytes("WAVE");
                        this.faz.writeBytes("fmt ");
                        this.faz.writeInt(Integer.reverseBytes(16));
                        this.faz.writeShort(Short.reverseBytes((short) 1));
                        this.faz.writeShort(Short.reverseBytes(this.faU));
                        this.faz.writeInt(Integer.reverseBytes(this.faV));
                        this.faz.writeInt(Integer.reverseBytes(((this.faV * this.faW) * this.faU) / 8));
                        this.faz.writeShort(Short.reverseBytes((short) ((this.faU * this.faW) / 8)));
                        this.faz.writeShort(Short.reverseBytes(this.faW));
                        this.faz.writeBytes("data");
                        this.faz.writeInt(0);
                        this.buffer = new byte[((this.faZ * this.faW) / 8) * this.faU];
                        this.faT = State.READY;
                    } else {
                        BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on uninitialized recorder");
                        this.faT = State.ERROR;
                        return false;
                    }
                } else {
                    faR.prepare();
                    this.faT = State.READY;
                }
                return true;
            }
            BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on illegal state");
            release();
            this.faT = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured in prepare()");
            }
            this.faT = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.faT == State.RECORDING) {
            stop();
        } else {
            if ((this.faT == State.READY) & this.faP) {
                try {
                    this.faz.close();
                } catch (IOException e) {
                    BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.faP) {
            if (faQ != null) {
                faQ.release();
            }
        } else if (faR != null) {
            faR.release();
        }
    }

    public void start() {
        if (this.faT == State.READY) {
            if (this.faP) {
                this.payloadSize = 0;
                faQ.startRecording();
                faQ.read(this.buffer, 0, this.buffer.length);
            } else {
                faR.start();
            }
            this.faT = State.RECORDING;
            return;
        }
        BdLog.e(MyAudioRecorder.class.getName() + "start() called on illegal state");
        this.faT = State.ERROR;
    }

    public void stop() {
        BdLog.e(MyAudioRecorder.class.getName() + "audioRecorder.stop()");
        faQ.stop();
        try {
            this.faz.seek(4L);
            this.faz.writeInt(Integer.reverseBytes(this.payloadSize + 36));
            this.faz.seek(40L);
            this.faz.writeInt(Integer.reverseBytes(this.payloadSize));
            this.faz.close();
            BdLog.e(MyAudioRecorder.class.getName() + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
            this.faT = State.ERROR;
        }
        this.faT = State.STOPPED;
    }

    private short b(byte b, byte b2) {
        return (short) ((b2 << 8) | b);
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean Cd(String str) {
        if (Cf(str)) {
            return prepare();
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean btn() {
        synchronized (mLock) {
            if (this.writeThread == null || !this.writeThread.isAlive()) {
                this.writeThread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.MyAudioRecorder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MyAudioRecorder.this.btm();
                    }
                });
                this.writeThread.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void bto() {
        this.faT = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean btp() {
        return this.faT == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btm() {
        if (faQ != null) {
            try {
                start();
                while (btp()) {
                    faQ.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.faz.write(this.buffer);
                        this.payloadSize += this.buffer.length;
                        if (this.faW == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short b = b(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (b > this.faS) {
                                    this.faS = b;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.faS) {
                                    this.faS = this.buffer[i2];
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
