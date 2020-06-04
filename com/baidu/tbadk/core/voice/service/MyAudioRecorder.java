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
    private RandomAccessFile dZJ;
    private boolean dZZ;
    private int eac;
    private State ead;
    private short eae;
    private int eaf;
    private short eag;
    private int eah;
    private int eai;
    private int eaj;
    private String filePath;
    private int payloadSize;
    private Thread writeThread;
    private static final int[] dZY = {44100, 22050, RequestResponseCode.REQUEST_LOGIN_PB_AT, CoolPraiseGuideLottieView.ANIM_DURATION};
    private static Object mLock = new Object();
    private static AudioRecord eaa = null;
    private static MediaRecorder eab = null;

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
            eaa = null;
            eab = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, dZY[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.aXv() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, dZY[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State aXv() {
        return this.ead;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.eac = 0;
        this.filePath = null;
        try {
            this.dZZ = z;
            if (this.dZZ) {
                if (i4 == 2) {
                    this.eag = (short) 16;
                } else {
                    this.eag = (short) 8;
                }
                if (i3 == 2) {
                    this.eae = (short) 1;
                } else {
                    this.eae = (short) 2;
                }
                this.eah = i;
                this.eaf = i2;
                this.eai = i4;
                this.eaj = (i2 * 120) / 1000;
                this.bufferSize = (((this.eaj * 2) * this.eag) * this.eae) / 8;
                if (this.bufferSize < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.eaj = this.bufferSize / (((this.eag * 2) * this.eae) / 8);
                    BdLog.w(MyAudioRecorder.class.getName() + "Increasing buffer size to " + Integer.toString(this.bufferSize));
                }
                eaa = new AudioRecord(i, i2, i3, i4, this.bufferSize);
                if (eaa.getRecordingState() == 3) {
                    eaa.stop();
                }
                if (eaa.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                eab = new MediaRecorder();
                eab.setAudioSource(1);
                eab.setOutputFormat(1);
                eab.setAudioEncoder(1);
            }
            this.eac = 0;
            this.filePath = null;
            this.ead = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while initializing recording");
            }
            this.ead = State.ERROR;
        }
    }

    public boolean xd(String str) {
        try {
            if (this.ead == State.INITIALIZING) {
                this.filePath = str;
                if (!this.dZZ) {
                    eab.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while setting output path");
            }
            this.ead = State.ERROR;
            return false;
        }
    }

    public boolean prepare() {
        try {
            if (this.ead == State.INITIALIZING) {
                if (this.dZZ) {
                    if ((this.filePath != null) & (eaa.getState() == 1)) {
                        if (this.dZJ != null) {
                            this.dZJ.close();
                            this.dZJ = null;
                        }
                        this.dZJ = new RandomAccessFile(this.filePath, "rw");
                        this.dZJ.setLength(0L);
                        this.dZJ.writeBytes("RIFF");
                        this.dZJ.writeInt(0);
                        this.dZJ.writeBytes("WAVE");
                        this.dZJ.writeBytes("fmt ");
                        this.dZJ.writeInt(Integer.reverseBytes(16));
                        this.dZJ.writeShort(Short.reverseBytes((short) 1));
                        this.dZJ.writeShort(Short.reverseBytes(this.eae));
                        this.dZJ.writeInt(Integer.reverseBytes(this.eaf));
                        this.dZJ.writeInt(Integer.reverseBytes(((this.eaf * this.eag) * this.eae) / 8));
                        this.dZJ.writeShort(Short.reverseBytes((short) ((this.eae * this.eag) / 8)));
                        this.dZJ.writeShort(Short.reverseBytes(this.eag));
                        this.dZJ.writeBytes("data");
                        this.dZJ.writeInt(0);
                        this.buffer = new byte[((this.eaj * this.eag) / 8) * this.eae];
                        this.ead = State.READY;
                    } else {
                        BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on uninitialized recorder");
                        this.ead = State.ERROR;
                        return false;
                    }
                } else {
                    eab.prepare();
                    this.ead = State.READY;
                }
                return true;
            }
            BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on illegal state");
            release();
            this.ead = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured in prepare()");
            }
            this.ead = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.ead == State.RECORDING) {
            stop();
        } else {
            if ((this.ead == State.READY) & this.dZZ) {
                try {
                    this.dZJ.close();
                } catch (IOException e) {
                    BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.dZZ) {
            if (eaa != null) {
                eaa.release();
            }
        } else if (eab != null) {
            eab.release();
        }
    }

    public void start() {
        if (this.ead == State.READY) {
            if (this.dZZ) {
                this.payloadSize = 0;
                eaa.startRecording();
                eaa.read(this.buffer, 0, this.buffer.length);
            } else {
                eab.start();
            }
            this.ead = State.RECORDING;
            return;
        }
        BdLog.e(MyAudioRecorder.class.getName() + "start() called on illegal state");
        this.ead = State.ERROR;
    }

    public void stop() {
        BdLog.e(MyAudioRecorder.class.getName() + "audioRecorder.stop()");
        eaa.stop();
        try {
            this.dZJ.seek(4L);
            this.dZJ.writeInt(Integer.reverseBytes(this.payloadSize + 36));
            this.dZJ.seek(40L);
            this.dZJ.writeInt(Integer.reverseBytes(this.payloadSize));
            this.dZJ.close();
            BdLog.e(MyAudioRecorder.class.getName() + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
            this.ead = State.ERROR;
        }
        this.ead = State.STOPPED;
    }

    private short b(byte b, byte b2) {
        return (short) ((b2 << 8) | b);
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean xb(String str) {
        if (xd(str)) {
            return prepare();
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean aXr() {
        synchronized (mLock) {
            if (this.writeThread == null || !this.writeThread.isAlive()) {
                this.writeThread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.MyAudioRecorder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MyAudioRecorder.this.aXq();
                    }
                });
                this.writeThread.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void aXs() {
        this.ead = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean aXt() {
        return this.ead == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXq() {
        if (eaa != null) {
            try {
                start();
                while (aXt()) {
                    eaa.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.dZJ.write(this.buffer);
                        this.payloadSize += this.buffer.length;
                        if (this.eag == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short b = b(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (b > this.eac) {
                                    this.eac = b;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.eac) {
                                    this.eac = this.buffer[i2];
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
