package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import android.media.MediaRecorder;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class MyAudioRecorder implements d {
    private short aAa;
    private int aAb;
    private short aAc;
    private int aAd;
    private int aAe;
    private int aAf;
    private RandomAccessFile azF;
    private Thread azU;
    private boolean azV;
    private int azY;
    private State azZ;
    private byte[] buffer;
    private int bufferSize;
    private String filePath;
    private int payloadSize;
    private static final int[] azT = {44100, 22050, 11025, 8000};
    private static Object mLock = new Object();
    private static AudioRecord azW = null;
    private static MediaRecorder azX = null;

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
            azW = null;
            azX = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, azT[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.Bh() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, azT[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State Bh() {
        return this.azZ;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.azY = 0;
        this.filePath = null;
        try {
            this.azV = z;
            if (this.azV) {
                if (i4 == 2) {
                    this.aAc = (short) 16;
                } else {
                    this.aAc = (short) 8;
                }
                if (i3 == 2) {
                    this.aAa = (short) 1;
                } else {
                    this.aAa = (short) 2;
                }
                this.aAd = i;
                this.aAb = i2;
                this.aAe = i4;
                this.aAf = (i2 * 120) / 1000;
                this.bufferSize = (((this.aAf * 2) * this.aAc) * this.aAa) / 8;
                if (this.bufferSize < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.aAf = this.bufferSize / (((this.aAc * 2) * this.aAa) / 8);
                    BdLog.w(MyAudioRecorder.class.getName() + "Increasing buffer size to " + Integer.toString(this.bufferSize));
                }
                azW = new AudioRecord(i, i2, i3, i4, this.bufferSize);
                if (azW.getRecordingState() == 3) {
                    azW.stop();
                }
                if (azW.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                azX = new MediaRecorder();
                azX.setAudioSource(1);
                azX.setOutputFormat(1);
                azX.setAudioEncoder(1);
            }
            this.azY = 0;
            this.filePath = null;
            this.azZ = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while initializing recording");
            }
            this.azZ = State.ERROR;
        }
    }

    public boolean fu(String str) {
        try {
            if (this.azZ == State.INITIALIZING) {
                this.filePath = str;
                if (!this.azV) {
                    azX.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while setting output path");
            }
            this.azZ = State.ERROR;
            return false;
        }
    }

    public boolean prepare() {
        try {
            if (this.azZ == State.INITIALIZING) {
                if (this.azV) {
                    if ((this.filePath != null) & (azW.getState() == 1)) {
                        if (this.azF != null) {
                            this.azF.close();
                            this.azF = null;
                        }
                        this.azF = new RandomAccessFile(this.filePath, "rw");
                        this.azF.setLength(0L);
                        this.azF.writeBytes("RIFF");
                        this.azF.writeInt(0);
                        this.azF.writeBytes("WAVE");
                        this.azF.writeBytes("fmt ");
                        this.azF.writeInt(Integer.reverseBytes(16));
                        this.azF.writeShort(Short.reverseBytes((short) 1));
                        this.azF.writeShort(Short.reverseBytes(this.aAa));
                        this.azF.writeInt(Integer.reverseBytes(this.aAb));
                        this.azF.writeInt(Integer.reverseBytes(((this.aAb * this.aAc) * this.aAa) / 8));
                        this.azF.writeShort(Short.reverseBytes((short) ((this.aAa * this.aAc) / 8)));
                        this.azF.writeShort(Short.reverseBytes(this.aAc));
                        this.azF.writeBytes("data");
                        this.azF.writeInt(0);
                        this.buffer = new byte[((this.aAf * this.aAc) / 8) * this.aAa];
                        this.azZ = State.READY;
                    } else {
                        BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on uninitialized recorder");
                        this.azZ = State.ERROR;
                        return false;
                    }
                } else {
                    azX.prepare();
                    this.azZ = State.READY;
                }
                return true;
            }
            BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on illegal state");
            release();
            this.azZ = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured in prepare()");
            }
            this.azZ = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.azZ == State.RECORDING) {
            stop();
        } else {
            if ((this.azZ == State.READY) & this.azV) {
                try {
                    this.azF.close();
                } catch (IOException e) {
                    BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.azV) {
            if (azW != null) {
                azW.release();
            }
        } else if (azX != null) {
            azX.release();
        }
    }

    public void start() {
        if (this.azZ == State.READY) {
            if (this.azV) {
                this.payloadSize = 0;
                azW.startRecording();
                azW.read(this.buffer, 0, this.buffer.length);
            } else {
                azX.start();
            }
            this.azZ = State.RECORDING;
            return;
        }
        BdLog.e(MyAudioRecorder.class.getName() + "start() called on illegal state");
        this.azZ = State.ERROR;
    }

    public void stop() {
        BdLog.e(MyAudioRecorder.class.getName() + "audioRecorder.stop()");
        azW.stop();
        try {
            this.azF.seek(4L);
            this.azF.writeInt(Integer.reverseBytes(this.payloadSize + 36));
            this.azF.seek(40L);
            this.azF.writeInt(Integer.reverseBytes(this.payloadSize));
            this.azF.close();
            BdLog.e(MyAudioRecorder.class.getName() + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
            this.azZ = State.ERROR;
        }
        this.azZ = State.STOPPED;
    }

    private short b(byte b, byte b2) {
        return (short) ((b2 << 8) | b);
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean fs(String str) {
        if (fu(str)) {
            return prepare();
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean Be() {
        synchronized (mLock) {
            if (this.azU == null || !this.azU.isAlive()) {
                this.azU = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.MyAudioRecorder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MyAudioRecorder.this.Bd();
                    }
                });
                this.azU.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void Bf() {
        this.azZ = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean isRecording() {
        return this.azZ == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bd() {
        if (azW != null) {
            try {
                start();
                while (isRecording()) {
                    azW.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.azF.write(this.buffer);
                        this.payloadSize += this.buffer.length;
                        if (this.aAc == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short b = b(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (b > this.azY) {
                                    this.azY = b;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.azY) {
                                    this.azY = this.buffer[i2];
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
