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
    private RandomAccessFile ceA;
    private boolean ceQ;
    private int ceT;
    private State ceU;
    private short ceV;
    private int ceW;
    private short ceX;
    private int ceY;
    private int ceZ;
    private int cfa;
    private String filePath;
    private int payloadSize;
    private Thread writeThread;
    private static final int[] ceP = {44100, 22050, 11025, 8000};
    private static Object mLock = new Object();
    private static AudioRecord ceR = null;
    private static MediaRecorder ceS = null;

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
            ceR = null;
            ceS = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, ceP[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.alE() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, ceP[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State alE() {
        return this.ceU;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.ceT = 0;
        this.filePath = null;
        try {
            this.ceQ = z;
            if (this.ceQ) {
                if (i4 == 2) {
                    this.ceX = (short) 16;
                } else {
                    this.ceX = (short) 8;
                }
                if (i3 == 2) {
                    this.ceV = (short) 1;
                } else {
                    this.ceV = (short) 2;
                }
                this.ceY = i;
                this.ceW = i2;
                this.ceZ = i4;
                this.cfa = (i2 * 120) / 1000;
                this.bufferSize = (((this.cfa * 2) * this.ceX) * this.ceV) / 8;
                if (this.bufferSize < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.cfa = this.bufferSize / (((this.ceX * 2) * this.ceV) / 8);
                    BdLog.w(MyAudioRecorder.class.getName() + "Increasing buffer size to " + Integer.toString(this.bufferSize));
                }
                ceR = new AudioRecord(i, i2, i3, i4, this.bufferSize);
                if (ceR.getRecordingState() == 3) {
                    ceR.stop();
                }
                if (ceR.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                ceS = new MediaRecorder();
                ceS.setAudioSource(1);
                ceS.setOutputFormat(1);
                ceS.setAudioEncoder(1);
            }
            this.ceT = 0;
            this.filePath = null;
            this.ceU = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while initializing recording");
            }
            this.ceU = State.ERROR;
        }
    }

    public boolean pa(String str) {
        try {
            if (this.ceU == State.INITIALIZING) {
                this.filePath = str;
                if (!this.ceQ) {
                    ceS.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while setting output path");
            }
            this.ceU = State.ERROR;
            return false;
        }
    }

    public boolean prepare() {
        try {
            if (this.ceU == State.INITIALIZING) {
                if (this.ceQ) {
                    if ((this.filePath != null) & (ceR.getState() == 1)) {
                        if (this.ceA != null) {
                            this.ceA.close();
                            this.ceA = null;
                        }
                        this.ceA = new RandomAccessFile(this.filePath, "rw");
                        this.ceA.setLength(0L);
                        this.ceA.writeBytes("RIFF");
                        this.ceA.writeInt(0);
                        this.ceA.writeBytes("WAVE");
                        this.ceA.writeBytes("fmt ");
                        this.ceA.writeInt(Integer.reverseBytes(16));
                        this.ceA.writeShort(Short.reverseBytes((short) 1));
                        this.ceA.writeShort(Short.reverseBytes(this.ceV));
                        this.ceA.writeInt(Integer.reverseBytes(this.ceW));
                        this.ceA.writeInt(Integer.reverseBytes(((this.ceW * this.ceX) * this.ceV) / 8));
                        this.ceA.writeShort(Short.reverseBytes((short) ((this.ceV * this.ceX) / 8)));
                        this.ceA.writeShort(Short.reverseBytes(this.ceX));
                        this.ceA.writeBytes("data");
                        this.ceA.writeInt(0);
                        this.buffer = new byte[((this.cfa * this.ceX) / 8) * this.ceV];
                        this.ceU = State.READY;
                    } else {
                        BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on uninitialized recorder");
                        this.ceU = State.ERROR;
                        return false;
                    }
                } else {
                    ceS.prepare();
                    this.ceU = State.READY;
                }
                return true;
            }
            BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on illegal state");
            release();
            this.ceU = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured in prepare()");
            }
            this.ceU = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.ceU == State.RECORDING) {
            stop();
        } else {
            if ((this.ceU == State.READY) & this.ceQ) {
                try {
                    this.ceA.close();
                } catch (IOException e) {
                    BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.ceQ) {
            if (ceR != null) {
                ceR.release();
            }
        } else if (ceS != null) {
            ceS.release();
        }
    }

    public void start() {
        if (this.ceU == State.READY) {
            if (this.ceQ) {
                this.payloadSize = 0;
                ceR.startRecording();
                ceR.read(this.buffer, 0, this.buffer.length);
            } else {
                ceS.start();
            }
            this.ceU = State.RECORDING;
            return;
        }
        BdLog.e(MyAudioRecorder.class.getName() + "start() called on illegal state");
        this.ceU = State.ERROR;
    }

    public void stop() {
        BdLog.e(MyAudioRecorder.class.getName() + "audioRecorder.stop()");
        ceR.stop();
        try {
            this.ceA.seek(4L);
            this.ceA.writeInt(Integer.reverseBytes(this.payloadSize + 36));
            this.ceA.seek(40L);
            this.ceA.writeInt(Integer.reverseBytes(this.payloadSize));
            this.ceA.close();
            BdLog.e(MyAudioRecorder.class.getName() + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
            this.ceU = State.ERROR;
        }
        this.ceU = State.STOPPED;
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
    public boolean alA() {
        synchronized (mLock) {
            if (this.writeThread == null || !this.writeThread.isAlive()) {
                this.writeThread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.MyAudioRecorder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MyAudioRecorder.this.alz();
                    }
                });
                this.writeThread.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void alB() {
        this.ceU = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean alC() {
        return this.ceU == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alz() {
        if (ceR != null) {
            try {
                start();
                while (alC()) {
                    ceR.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.ceA.write(this.buffer);
                        this.payloadSize += this.buffer.length;
                        if (this.ceX == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short b = b(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (b > this.ceT) {
                                    this.ceT = b;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.ceT) {
                                    this.ceT = this.buffer[i2];
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
