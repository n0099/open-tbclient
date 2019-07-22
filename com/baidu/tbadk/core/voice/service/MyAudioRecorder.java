package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import android.media.MediaRecorder;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class MyAudioRecorder implements d {
    private byte[] buffer;
    private int bufferSize;
    private boolean ceJ;
    private int ceM;
    private State ceN;
    private short ceO;
    private int ceP;
    private short ceQ;
    private int ceR;
    private int ceS;
    private int ceT;
    private RandomAccessFile cet;
    private String filePath;
    private int payloadSize;
    private Thread writeThread;
    private static final int[] ceI = {44100, 22050, 11025, 8000};
    private static Object mLock = new Object();
    private static AudioRecord ceK = null;
    private static MediaRecorder ceL = null;

    /* loaded from: classes.dex */
    public enum State {
        INITIALIZING,
        READY,
        RECORDING,
        ERROR,
        STOPPED
    }

    public static MyAudioRecorder d(Boolean bool) {
        MyAudioRecorder myAudioRecorder;
        synchronized (mLock) {
            ceK = null;
            ceL = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, ceI[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.alC() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, ceI[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State alC() {
        return this.ceN;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.ceM = 0;
        this.filePath = null;
        try {
            this.ceJ = z;
            if (this.ceJ) {
                if (i4 == 2) {
                    this.ceQ = (short) 16;
                } else {
                    this.ceQ = (short) 8;
                }
                if (i3 == 2) {
                    this.ceO = (short) 1;
                } else {
                    this.ceO = (short) 2;
                }
                this.ceR = i;
                this.ceP = i2;
                this.ceS = i4;
                this.ceT = (i2 * 120) / 1000;
                this.bufferSize = (((this.ceT * 2) * this.ceQ) * this.ceO) / 8;
                if (this.bufferSize < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.ceT = this.bufferSize / (((this.ceQ * 2) * this.ceO) / 8);
                    BdLog.w(MyAudioRecorder.class.getName() + "Increasing buffer size to " + Integer.toString(this.bufferSize));
                }
                ceK = new AudioRecord(i, i2, i3, i4, this.bufferSize);
                if (ceK.getRecordingState() == 3) {
                    ceK.stop();
                }
                if (ceK.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                ceL = new MediaRecorder();
                ceL.setAudioSource(1);
                ceL.setOutputFormat(1);
                ceL.setAudioEncoder(1);
            }
            this.ceM = 0;
            this.filePath = null;
            this.ceN = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while initializing recording");
            }
            this.ceN = State.ERROR;
        }
    }

    public boolean pa(String str) {
        try {
            if (this.ceN == State.INITIALIZING) {
                this.filePath = str;
                if (!this.ceJ) {
                    ceL.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while setting output path");
            }
            this.ceN = State.ERROR;
            return false;
        }
    }

    public boolean prepare() {
        try {
            if (this.ceN == State.INITIALIZING) {
                if (this.ceJ) {
                    if ((this.filePath != null) & (ceK.getState() == 1)) {
                        if (this.cet != null) {
                            this.cet.close();
                            this.cet = null;
                        }
                        this.cet = new RandomAccessFile(this.filePath, "rw");
                        this.cet.setLength(0L);
                        this.cet.writeBytes("RIFF");
                        this.cet.writeInt(0);
                        this.cet.writeBytes("WAVE");
                        this.cet.writeBytes("fmt ");
                        this.cet.writeInt(Integer.reverseBytes(16));
                        this.cet.writeShort(Short.reverseBytes((short) 1));
                        this.cet.writeShort(Short.reverseBytes(this.ceO));
                        this.cet.writeInt(Integer.reverseBytes(this.ceP));
                        this.cet.writeInt(Integer.reverseBytes(((this.ceP * this.ceQ) * this.ceO) / 8));
                        this.cet.writeShort(Short.reverseBytes((short) ((this.ceO * this.ceQ) / 8)));
                        this.cet.writeShort(Short.reverseBytes(this.ceQ));
                        this.cet.writeBytes("data");
                        this.cet.writeInt(0);
                        this.buffer = new byte[((this.ceT * this.ceQ) / 8) * this.ceO];
                        this.ceN = State.READY;
                    } else {
                        BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on uninitialized recorder");
                        this.ceN = State.ERROR;
                        return false;
                    }
                } else {
                    ceL.prepare();
                    this.ceN = State.READY;
                }
                return true;
            }
            BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on illegal state");
            release();
            this.ceN = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured in prepare()");
            }
            this.ceN = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.ceN == State.RECORDING) {
            stop();
        } else {
            if ((this.ceN == State.READY) & this.ceJ) {
                try {
                    this.cet.close();
                } catch (IOException e) {
                    BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.ceJ) {
            if (ceK != null) {
                ceK.release();
            }
        } else if (ceL != null) {
            ceL.release();
        }
    }

    public void start() {
        if (this.ceN == State.READY) {
            if (this.ceJ) {
                this.payloadSize = 0;
                ceK.startRecording();
                ceK.read(this.buffer, 0, this.buffer.length);
            } else {
                ceL.start();
            }
            this.ceN = State.RECORDING;
            return;
        }
        BdLog.e(MyAudioRecorder.class.getName() + "start() called on illegal state");
        this.ceN = State.ERROR;
    }

    public void stop() {
        BdLog.e(MyAudioRecorder.class.getName() + "audioRecorder.stop()");
        ceK.stop();
        try {
            this.cet.seek(4L);
            this.cet.writeInt(Integer.reverseBytes(this.payloadSize + 36));
            this.cet.seek(40L);
            this.cet.writeInt(Integer.reverseBytes(this.payloadSize));
            this.cet.close();
            BdLog.e(MyAudioRecorder.class.getName() + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
            this.ceN = State.ERROR;
        }
        this.ceN = State.STOPPED;
    }

    private short b(byte b, byte b2) {
        return (short) ((b2 << 8) | b);
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean oY(String str) {
        if (pa(str)) {
            return prepare();
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean aly() {
        synchronized (mLock) {
            if (this.writeThread == null || !this.writeThread.isAlive()) {
                this.writeThread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.MyAudioRecorder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MyAudioRecorder.this.alx();
                    }
                });
                this.writeThread.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void alz() {
        this.ceN = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean alA() {
        return this.ceN == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alx() {
        if (ceK != null) {
            try {
                start();
                while (alA()) {
                    ceK.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.cet.write(this.buffer);
                        this.payloadSize += this.buffer.length;
                        if (this.ceQ == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short b = b(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (b > this.ceM) {
                                    this.ceM = b;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.ceM) {
                                    this.ceM = this.buffer[i2];
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
