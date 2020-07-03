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
    private boolean eiJ;
    private int eiM;
    private State eiN;
    private short eiO;
    private int eiP;
    private short eiQ;
    private int eiR;
    private int eiS;
    private int eiT;
    private RandomAccessFile eit;
    private String filePath;
    private int payloadSize;
    private Thread writeThread;
    private static final int[] eiI = {44100, 22050, RequestResponseCode.REQUEST_LOGIN_PB_AT, CoolPraiseGuideLottieView.ANIM_DURATION};
    private static Object mLock = new Object();
    private static AudioRecord eiK = null;
    private static MediaRecorder eiL = null;

    /* loaded from: classes.dex */
    public enum State {
        INITIALIZING,
        READY,
        RECORDING,
        ERROR,
        STOPPED
    }

    public static MyAudioRecorder g(Boolean bool) {
        MyAudioRecorder myAudioRecorder;
        synchronized (mLock) {
            eiK = null;
            eiL = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, eiI[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.aZB() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, eiI[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State aZB() {
        return this.eiN;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.eiM = 0;
        this.filePath = null;
        try {
            this.eiJ = z;
            if (this.eiJ) {
                if (i4 == 2) {
                    this.eiQ = (short) 16;
                } else {
                    this.eiQ = (short) 8;
                }
                if (i3 == 2) {
                    this.eiO = (short) 1;
                } else {
                    this.eiO = (short) 2;
                }
                this.eiR = i;
                this.eiP = i2;
                this.eiS = i4;
                this.eiT = (i2 * 120) / 1000;
                this.bufferSize = (((this.eiT * 2) * this.eiQ) * this.eiO) / 8;
                if (this.bufferSize < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.eiT = this.bufferSize / (((this.eiQ * 2) * this.eiO) / 8);
                    BdLog.w(MyAudioRecorder.class.getName() + "Increasing buffer size to " + Integer.toString(this.bufferSize));
                }
                eiK = new AudioRecord(i, i2, i3, i4, this.bufferSize);
                if (eiK.getRecordingState() == 3) {
                    eiK.stop();
                }
                if (eiK.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                eiL = new MediaRecorder();
                eiL.setAudioSource(1);
                eiL.setOutputFormat(1);
                eiL.setAudioEncoder(1);
            }
            this.eiM = 0;
            this.filePath = null;
            this.eiN = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while initializing recording");
            }
            this.eiN = State.ERROR;
        }
    }

    public boolean xw(String str) {
        try {
            if (this.eiN == State.INITIALIZING) {
                this.filePath = str;
                if (!this.eiJ) {
                    eiL.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while setting output path");
            }
            this.eiN = State.ERROR;
            return false;
        }
    }

    public boolean prepare() {
        try {
            if (this.eiN == State.INITIALIZING) {
                if (this.eiJ) {
                    if ((this.filePath != null) & (eiK.getState() == 1)) {
                        if (this.eit != null) {
                            this.eit.close();
                            this.eit = null;
                        }
                        this.eit = new RandomAccessFile(this.filePath, "rw");
                        this.eit.setLength(0L);
                        this.eit.writeBytes("RIFF");
                        this.eit.writeInt(0);
                        this.eit.writeBytes("WAVE");
                        this.eit.writeBytes("fmt ");
                        this.eit.writeInt(Integer.reverseBytes(16));
                        this.eit.writeShort(Short.reverseBytes((short) 1));
                        this.eit.writeShort(Short.reverseBytes(this.eiO));
                        this.eit.writeInt(Integer.reverseBytes(this.eiP));
                        this.eit.writeInt(Integer.reverseBytes(((this.eiP * this.eiQ) * this.eiO) / 8));
                        this.eit.writeShort(Short.reverseBytes((short) ((this.eiO * this.eiQ) / 8)));
                        this.eit.writeShort(Short.reverseBytes(this.eiQ));
                        this.eit.writeBytes("data");
                        this.eit.writeInt(0);
                        this.buffer = new byte[((this.eiT * this.eiQ) / 8) * this.eiO];
                        this.eiN = State.READY;
                    } else {
                        BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on uninitialized recorder");
                        this.eiN = State.ERROR;
                        return false;
                    }
                } else {
                    eiL.prepare();
                    this.eiN = State.READY;
                }
                return true;
            }
            BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on illegal state");
            release();
            this.eiN = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured in prepare()");
            }
            this.eiN = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.eiN == State.RECORDING) {
            stop();
        } else {
            if ((this.eiN == State.READY) & this.eiJ) {
                try {
                    this.eit.close();
                } catch (IOException e) {
                    BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.eiJ) {
            if (eiK != null) {
                eiK.release();
            }
        } else if (eiL != null) {
            eiL.release();
        }
    }

    public void start() {
        if (this.eiN == State.READY) {
            if (this.eiJ) {
                this.payloadSize = 0;
                eiK.startRecording();
                eiK.read(this.buffer, 0, this.buffer.length);
            } else {
                eiL.start();
            }
            this.eiN = State.RECORDING;
            return;
        }
        BdLog.e(MyAudioRecorder.class.getName() + "start() called on illegal state");
        this.eiN = State.ERROR;
    }

    public void stop() {
        BdLog.e(MyAudioRecorder.class.getName() + "audioRecorder.stop()");
        eiK.stop();
        try {
            this.eit.seek(4L);
            this.eit.writeInt(Integer.reverseBytes(this.payloadSize + 36));
            this.eit.seek(40L);
            this.eit.writeInt(Integer.reverseBytes(this.payloadSize));
            this.eit.close();
            BdLog.e(MyAudioRecorder.class.getName() + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
            this.eiN = State.ERROR;
        }
        this.eiN = State.STOPPED;
    }

    private short b(byte b, byte b2) {
        return (short) ((b2 << 8) | b);
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean xu(String str) {
        if (xw(str)) {
            return prepare();
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean aZx() {
        synchronized (mLock) {
            if (this.writeThread == null || !this.writeThread.isAlive()) {
                this.writeThread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.MyAudioRecorder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MyAudioRecorder.this.aZw();
                    }
                });
                this.writeThread.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void aZy() {
        this.eiN = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean aZz() {
        return this.eiN == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZw() {
        if (eiK != null) {
            try {
                start();
                while (aZz()) {
                    eiK.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.eit.write(this.buffer);
                        this.payloadSize += this.buffer.length;
                        if (this.eiQ == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short b = b(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (b > this.eiM) {
                                    this.eiM = b;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.eiM) {
                                    this.eiM = this.buffer[i2];
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
