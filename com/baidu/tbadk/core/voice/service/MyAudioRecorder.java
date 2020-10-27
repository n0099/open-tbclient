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
    private RandomAccessFile eVC;
    private boolean eVS;
    private int eVV;
    private State eVW;
    private short eVX;
    private int eVY;
    private short eVZ;
    private int eWa;
    private int eWb;
    private int eWc;
    private String filePath;
    private int payloadSize;
    private Thread writeThread;
    private static final int[] eVR = {44100, 22050, RequestResponseCode.REQUEST_LOGIN_PB_AT, CoolPraiseGuideLottieView.ANIM_DURATION};
    private static Object mLock = new Object();
    private static AudioRecord eVT = null;
    private static MediaRecorder eVU = null;

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
            eVT = null;
            eVU = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, eVR[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.brB() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, eVR[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State brB() {
        return this.eVW;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.eVV = 0;
        this.filePath = null;
        try {
            this.eVS = z;
            if (this.eVS) {
                if (i4 == 2) {
                    this.eVZ = (short) 16;
                } else {
                    this.eVZ = (short) 8;
                }
                if (i3 == 2) {
                    this.eVX = (short) 1;
                } else {
                    this.eVX = (short) 2;
                }
                this.eWa = i;
                this.eVY = i2;
                this.eWb = i4;
                this.eWc = (i2 * 120) / 1000;
                this.bufferSize = (((this.eWc * 2) * this.eVZ) * this.eVX) / 8;
                if (this.bufferSize < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.eWc = this.bufferSize / (((this.eVZ * 2) * this.eVX) / 8);
                    BdLog.w(MyAudioRecorder.class.getName() + "Increasing buffer size to " + Integer.toString(this.bufferSize));
                }
                eVT = new AudioRecord(i, i2, i3, i4, this.bufferSize);
                if (eVT.getRecordingState() == 3) {
                    eVT.stop();
                }
                if (eVT.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                eVU = new MediaRecorder();
                eVU.setAudioSource(1);
                eVU.setOutputFormat(1);
                eVU.setAudioEncoder(1);
            }
            this.eVV = 0;
            this.filePath = null;
            this.eVW = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while initializing recording");
            }
            this.eVW = State.ERROR;
        }
    }

    public boolean Cs(String str) {
        try {
            if (this.eVW == State.INITIALIZING) {
                this.filePath = str;
                if (!this.eVS) {
                    eVU.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while setting output path");
            }
            this.eVW = State.ERROR;
            return false;
        }
    }

    public boolean prepare() {
        try {
            if (this.eVW == State.INITIALIZING) {
                if (this.eVS) {
                    if ((this.filePath != null) & (eVT.getState() == 1)) {
                        if (this.eVC != null) {
                            this.eVC.close();
                            this.eVC = null;
                        }
                        this.eVC = new RandomAccessFile(this.filePath, "rw");
                        this.eVC.setLength(0L);
                        this.eVC.writeBytes("RIFF");
                        this.eVC.writeInt(0);
                        this.eVC.writeBytes("WAVE");
                        this.eVC.writeBytes("fmt ");
                        this.eVC.writeInt(Integer.reverseBytes(16));
                        this.eVC.writeShort(Short.reverseBytes((short) 1));
                        this.eVC.writeShort(Short.reverseBytes(this.eVX));
                        this.eVC.writeInt(Integer.reverseBytes(this.eVY));
                        this.eVC.writeInt(Integer.reverseBytes(((this.eVY * this.eVZ) * this.eVX) / 8));
                        this.eVC.writeShort(Short.reverseBytes((short) ((this.eVX * this.eVZ) / 8)));
                        this.eVC.writeShort(Short.reverseBytes(this.eVZ));
                        this.eVC.writeBytes("data");
                        this.eVC.writeInt(0);
                        this.buffer = new byte[((this.eWc * this.eVZ) / 8) * this.eVX];
                        this.eVW = State.READY;
                    } else {
                        BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on uninitialized recorder");
                        this.eVW = State.ERROR;
                        return false;
                    }
                } else {
                    eVU.prepare();
                    this.eVW = State.READY;
                }
                return true;
            }
            BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on illegal state");
            release();
            this.eVW = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured in prepare()");
            }
            this.eVW = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.eVW == State.RECORDING) {
            stop();
        } else {
            if ((this.eVW == State.READY) & this.eVS) {
                try {
                    this.eVC.close();
                } catch (IOException e) {
                    BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.eVS) {
            if (eVT != null) {
                eVT.release();
            }
        } else if (eVU != null) {
            eVU.release();
        }
    }

    public void start() {
        if (this.eVW == State.READY) {
            if (this.eVS) {
                this.payloadSize = 0;
                eVT.startRecording();
                eVT.read(this.buffer, 0, this.buffer.length);
            } else {
                eVU.start();
            }
            this.eVW = State.RECORDING;
            return;
        }
        BdLog.e(MyAudioRecorder.class.getName() + "start() called on illegal state");
        this.eVW = State.ERROR;
    }

    public void stop() {
        BdLog.e(MyAudioRecorder.class.getName() + "audioRecorder.stop()");
        eVT.stop();
        try {
            this.eVC.seek(4L);
            this.eVC.writeInt(Integer.reverseBytes(this.payloadSize + 36));
            this.eVC.seek(40L);
            this.eVC.writeInt(Integer.reverseBytes(this.payloadSize));
            this.eVC.close();
            BdLog.e(MyAudioRecorder.class.getName() + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
            this.eVW = State.ERROR;
        }
        this.eVW = State.STOPPED;
    }

    private short b(byte b, byte b2) {
        return (short) ((b2 << 8) | b);
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean Cq(String str) {
        if (Cs(str)) {
            return prepare();
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean brx() {
        synchronized (mLock) {
            if (this.writeThread == null || !this.writeThread.isAlive()) {
                this.writeThread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.MyAudioRecorder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MyAudioRecorder.this.brw();
                    }
                });
                this.writeThread.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void bry() {
        this.eVW = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean brz() {
        return this.eVW == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brw() {
        if (eVT != null) {
            try {
                start();
                while (brz()) {
                    eVT.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.eVC.write(this.buffer);
                        this.payloadSize += this.buffer.length;
                        if (this.eVZ == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short b = b(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (b > this.eVV) {
                                    this.eVV = b;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.eVV) {
                                    this.eVV = this.buffer[i2];
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
