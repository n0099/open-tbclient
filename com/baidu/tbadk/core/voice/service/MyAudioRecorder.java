package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import android.media.MediaRecorder;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class MyAudioRecorder implements d {
    private RandomAccessFile arA;
    private Thread arP;
    private boolean arQ;
    private int arT;
    private State arU;
    private short arV;
    private int arW;
    private short arX;
    private int arY;
    private int arZ;
    private int asa;
    private byte[] buffer;
    private int bufferSize;
    private String filePath;
    private int payloadSize;
    private static final int[] arO = {44100, 22050, 11025, 8000};
    private static Object mLock = new Object();
    private static AudioRecord arR = null;
    private static MediaRecorder arS = null;

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
            arR = null;
            arS = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, arO[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.xG() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, arO[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State xG() {
        return this.arU;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.arT = 0;
        this.filePath = null;
        try {
            this.arQ = z;
            if (this.arQ) {
                if (i4 == 2) {
                    this.arX = (short) 16;
                } else {
                    this.arX = (short) 8;
                }
                if (i3 == 2) {
                    this.arV = (short) 1;
                } else {
                    this.arV = (short) 2;
                }
                this.arY = i;
                this.arW = i2;
                this.arZ = i4;
                this.asa = (i2 * 120) / 1000;
                this.bufferSize = (((this.asa * 2) * this.arX) * this.arV) / 8;
                if (this.bufferSize < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.asa = this.bufferSize / (((this.arX * 2) * this.arV) / 8);
                    BdLog.w(MyAudioRecorder.class.getName() + "Increasing buffer size to " + Integer.toString(this.bufferSize));
                }
                arR = new AudioRecord(i, i2, i3, i4, this.bufferSize);
                if (arR.getRecordingState() == 3) {
                    arR.stop();
                }
                if (arR.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                arS = new MediaRecorder();
                arS.setAudioSource(1);
                arS.setOutputFormat(1);
                arS.setAudioEncoder(1);
            }
            this.arT = 0;
            this.filePath = null;
            this.arU = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while initializing recording");
            }
            this.arU = State.ERROR;
        }
    }

    public boolean eW(String str) {
        try {
            if (this.arU == State.INITIALIZING) {
                this.filePath = str;
                if (!this.arQ) {
                    arS.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while setting output path");
            }
            this.arU = State.ERROR;
            return false;
        }
    }

    public boolean prepare() {
        try {
            if (this.arU == State.INITIALIZING) {
                if (this.arQ) {
                    if ((this.filePath != null) & (arR.getState() == 1)) {
                        if (this.arA != null) {
                            this.arA.close();
                            this.arA = null;
                        }
                        this.arA = new RandomAccessFile(this.filePath, "rw");
                        this.arA.setLength(0L);
                        this.arA.writeBytes("RIFF");
                        this.arA.writeInt(0);
                        this.arA.writeBytes("WAVE");
                        this.arA.writeBytes("fmt ");
                        this.arA.writeInt(Integer.reverseBytes(16));
                        this.arA.writeShort(Short.reverseBytes((short) 1));
                        this.arA.writeShort(Short.reverseBytes(this.arV));
                        this.arA.writeInt(Integer.reverseBytes(this.arW));
                        this.arA.writeInt(Integer.reverseBytes(((this.arW * this.arX) * this.arV) / 8));
                        this.arA.writeShort(Short.reverseBytes((short) ((this.arV * this.arX) / 8)));
                        this.arA.writeShort(Short.reverseBytes(this.arX));
                        this.arA.writeBytes("data");
                        this.arA.writeInt(0);
                        this.buffer = new byte[((this.asa * this.arX) / 8) * this.arV];
                        this.arU = State.READY;
                    } else {
                        BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on uninitialized recorder");
                        this.arU = State.ERROR;
                        return false;
                    }
                } else {
                    arS.prepare();
                    this.arU = State.READY;
                }
                return true;
            }
            BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on illegal state");
            release();
            this.arU = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured in prepare()");
            }
            this.arU = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.arU == State.RECORDING) {
            stop();
        } else {
            if ((this.arU == State.READY) & this.arQ) {
                try {
                    this.arA.close();
                } catch (IOException e) {
                    BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.arQ) {
            if (arR != null) {
                arR.release();
            }
        } else if (arS != null) {
            arS.release();
        }
    }

    public void start() {
        if (this.arU == State.READY) {
            if (this.arQ) {
                this.payloadSize = 0;
                arR.startRecording();
                arR.read(this.buffer, 0, this.buffer.length);
            } else {
                arS.start();
            }
            this.arU = State.RECORDING;
            return;
        }
        BdLog.e(MyAudioRecorder.class.getName() + "start() called on illegal state");
        this.arU = State.ERROR;
    }

    public void stop() {
        BdLog.e(MyAudioRecorder.class.getName() + "audioRecorder.stop()");
        arR.stop();
        try {
            this.arA.seek(4L);
            this.arA.writeInt(Integer.reverseBytes(this.payloadSize + 36));
            this.arA.seek(40L);
            this.arA.writeInt(Integer.reverseBytes(this.payloadSize));
            this.arA.close();
            BdLog.e(MyAudioRecorder.class.getName() + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
            this.arU = State.ERROR;
        }
        this.arU = State.STOPPED;
    }

    private short b(byte b, byte b2) {
        return (short) ((b2 << 8) | b);
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean eU(String str) {
        if (eW(str)) {
            return prepare();
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean xD() {
        synchronized (mLock) {
            if (this.arP == null || !this.arP.isAlive()) {
                this.arP = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.MyAudioRecorder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MyAudioRecorder.this.xC();
                    }
                });
                this.arP.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void xE() {
        this.arU = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean isRecording() {
        return this.arU == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xC() {
        if (arR != null) {
            try {
                start();
                while (isRecording()) {
                    arR.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.arA.write(this.buffer);
                        this.payloadSize += this.buffer.length;
                        if (this.arX == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short b = b(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (b > this.arT) {
                                    this.arT = b;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.arT) {
                                    this.arT = this.buffer[i2];
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
