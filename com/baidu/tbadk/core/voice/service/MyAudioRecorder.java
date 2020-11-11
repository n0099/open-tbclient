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
    private boolean fbH;
    private int fbK;
    private State fbL;
    private short fbM;
    private int fbN;
    private short fbO;
    private int fbP;
    private int fbQ;
    private int fbR;
    private RandomAccessFile fbr;
    private String filePath;
    private int payloadSize;
    private Thread writeThread;
    private static final int[] fbG = {44100, 22050, RequestResponseCode.REQUEST_LOGIN_PB_AT, CoolPraiseGuideLottieView.ANIM_DURATION};
    private static Object mLock = new Object();
    private static AudioRecord fbI = null;
    private static MediaRecorder fbJ = null;

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
            fbI = null;
            fbJ = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, fbG[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.bub() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, fbG[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State bub() {
        return this.fbL;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.fbK = 0;
        this.filePath = null;
        try {
            this.fbH = z;
            if (this.fbH) {
                if (i4 == 2) {
                    this.fbO = (short) 16;
                } else {
                    this.fbO = (short) 8;
                }
                if (i3 == 2) {
                    this.fbM = (short) 1;
                } else {
                    this.fbM = (short) 2;
                }
                this.fbP = i;
                this.fbN = i2;
                this.fbQ = i4;
                this.fbR = (i2 * 120) / 1000;
                this.bufferSize = (((this.fbR * 2) * this.fbO) * this.fbM) / 8;
                if (this.bufferSize < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.fbR = this.bufferSize / (((this.fbO * 2) * this.fbM) / 8);
                    BdLog.w(MyAudioRecorder.class.getName() + "Increasing buffer size to " + Integer.toString(this.bufferSize));
                }
                fbI = new AudioRecord(i, i2, i3, i4, this.bufferSize);
                if (fbI.getRecordingState() == 3) {
                    fbI.stop();
                }
                if (fbI.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                fbJ = new MediaRecorder();
                fbJ.setAudioSource(1);
                fbJ.setOutputFormat(1);
                fbJ.setAudioEncoder(1);
            }
            this.fbK = 0;
            this.filePath = null;
            this.fbL = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while initializing recording");
            }
            this.fbL = State.ERROR;
        }
    }

    public boolean CG(String str) {
        try {
            if (this.fbL == State.INITIALIZING) {
                this.filePath = str;
                if (!this.fbH) {
                    fbJ.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while setting output path");
            }
            this.fbL = State.ERROR;
            return false;
        }
    }

    public boolean prepare() {
        try {
            if (this.fbL == State.INITIALIZING) {
                if (this.fbH) {
                    if ((this.filePath != null) & (fbI.getState() == 1)) {
                        if (this.fbr != null) {
                            this.fbr.close();
                            this.fbr = null;
                        }
                        this.fbr = new RandomAccessFile(this.filePath, "rw");
                        this.fbr.setLength(0L);
                        this.fbr.writeBytes("RIFF");
                        this.fbr.writeInt(0);
                        this.fbr.writeBytes("WAVE");
                        this.fbr.writeBytes("fmt ");
                        this.fbr.writeInt(Integer.reverseBytes(16));
                        this.fbr.writeShort(Short.reverseBytes((short) 1));
                        this.fbr.writeShort(Short.reverseBytes(this.fbM));
                        this.fbr.writeInt(Integer.reverseBytes(this.fbN));
                        this.fbr.writeInt(Integer.reverseBytes(((this.fbN * this.fbO) * this.fbM) / 8));
                        this.fbr.writeShort(Short.reverseBytes((short) ((this.fbM * this.fbO) / 8)));
                        this.fbr.writeShort(Short.reverseBytes(this.fbO));
                        this.fbr.writeBytes("data");
                        this.fbr.writeInt(0);
                        this.buffer = new byte[((this.fbR * this.fbO) / 8) * this.fbM];
                        this.fbL = State.READY;
                    } else {
                        BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on uninitialized recorder");
                        this.fbL = State.ERROR;
                        return false;
                    }
                } else {
                    fbJ.prepare();
                    this.fbL = State.READY;
                }
                return true;
            }
            BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on illegal state");
            release();
            this.fbL = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured in prepare()");
            }
            this.fbL = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.fbL == State.RECORDING) {
            stop();
        } else {
            if ((this.fbL == State.READY) & this.fbH) {
                try {
                    this.fbr.close();
                } catch (IOException e) {
                    BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.fbH) {
            if (fbI != null) {
                fbI.release();
            }
        } else if (fbJ != null) {
            fbJ.release();
        }
    }

    public void start() {
        if (this.fbL == State.READY) {
            if (this.fbH) {
                this.payloadSize = 0;
                fbI.startRecording();
                fbI.read(this.buffer, 0, this.buffer.length);
            } else {
                fbJ.start();
            }
            this.fbL = State.RECORDING;
            return;
        }
        BdLog.e(MyAudioRecorder.class.getName() + "start() called on illegal state");
        this.fbL = State.ERROR;
    }

    public void stop() {
        BdLog.e(MyAudioRecorder.class.getName() + "audioRecorder.stop()");
        fbI.stop();
        try {
            this.fbr.seek(4L);
            this.fbr.writeInt(Integer.reverseBytes(this.payloadSize + 36));
            this.fbr.seek(40L);
            this.fbr.writeInt(Integer.reverseBytes(this.payloadSize));
            this.fbr.close();
            BdLog.e(MyAudioRecorder.class.getName() + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
            this.fbL = State.ERROR;
        }
        this.fbL = State.STOPPED;
    }

    private short b(byte b, byte b2) {
        return (short) ((b2 << 8) | b);
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean CE(String str) {
        if (CG(str)) {
            return prepare();
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean btX() {
        synchronized (mLock) {
            if (this.writeThread == null || !this.writeThread.isAlive()) {
                this.writeThread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.MyAudioRecorder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MyAudioRecorder.this.btW();
                    }
                });
                this.writeThread.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void btY() {
        this.fbL = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean btZ() {
        return this.fbL == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btW() {
        if (fbI != null) {
            try {
                start();
                while (btZ()) {
                    fbI.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.fbr.write(this.buffer);
                        this.payloadSize += this.buffer.length;
                        if (this.fbO == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short b = b(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (b > this.fbK) {
                                    this.fbK = b;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.fbK) {
                                    this.fbK = this.buffer[i2];
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
