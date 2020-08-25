package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import android.media.MediaRecorder;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.searchbox.ui.CoolPraiseGuideLottieView;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes2.dex */
public class MyAudioRecorder implements d {
    private byte[] buffer;
    private int bufferSize;
    private RandomAccessFile eyR;
    private boolean ezh;
    private int ezk;
    private State ezl;
    private short ezm;
    private int ezn;
    private short ezo;
    private int ezp;
    private int ezq;
    private int ezr;
    private String filePath;
    private int payloadSize;
    private Thread writeThread;
    private static final int[] ezg = {44100, 22050, RequestResponseCode.REQUEST_LOGIN_PB_AT, CoolPraiseGuideLottieView.ANIM_DURATION};
    private static Object mLock = new Object();
    private static AudioRecord ezi = null;
    private static MediaRecorder ezj = null;

    /* loaded from: classes2.dex */
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
            ezi = null;
            ezj = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, ezg[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.bme() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, ezg[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State bme() {
        return this.ezl;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.ezk = 0;
        this.filePath = null;
        try {
            this.ezh = z;
            if (this.ezh) {
                if (i4 == 2) {
                    this.ezo = (short) 16;
                } else {
                    this.ezo = (short) 8;
                }
                if (i3 == 2) {
                    this.ezm = (short) 1;
                } else {
                    this.ezm = (short) 2;
                }
                this.ezp = i;
                this.ezn = i2;
                this.ezq = i4;
                this.ezr = (i2 * 120) / 1000;
                this.bufferSize = (((this.ezr * 2) * this.ezo) * this.ezm) / 8;
                if (this.bufferSize < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.ezr = this.bufferSize / (((this.ezo * 2) * this.ezm) / 8);
                    BdLog.w(MyAudioRecorder.class.getName() + "Increasing buffer size to " + Integer.toString(this.bufferSize));
                }
                ezi = new AudioRecord(i, i2, i3, i4, this.bufferSize);
                if (ezi.getRecordingState() == 3) {
                    ezi.stop();
                }
                if (ezi.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                ezj = new MediaRecorder();
                ezj.setAudioSource(1);
                ezj.setOutputFormat(1);
                ezj.setAudioEncoder(1);
            }
            this.ezk = 0;
            this.filePath = null;
            this.ezl = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while initializing recording");
            }
            this.ezl = State.ERROR;
        }
    }

    public boolean AQ(String str) {
        try {
            if (this.ezl == State.INITIALIZING) {
                this.filePath = str;
                if (!this.ezh) {
                    ezj.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while setting output path");
            }
            this.ezl = State.ERROR;
            return false;
        }
    }

    public boolean prepare() {
        try {
            if (this.ezl == State.INITIALIZING) {
                if (this.ezh) {
                    if ((this.filePath != null) & (ezi.getState() == 1)) {
                        if (this.eyR != null) {
                            this.eyR.close();
                            this.eyR = null;
                        }
                        this.eyR = new RandomAccessFile(this.filePath, "rw");
                        this.eyR.setLength(0L);
                        this.eyR.writeBytes("RIFF");
                        this.eyR.writeInt(0);
                        this.eyR.writeBytes("WAVE");
                        this.eyR.writeBytes("fmt ");
                        this.eyR.writeInt(Integer.reverseBytes(16));
                        this.eyR.writeShort(Short.reverseBytes((short) 1));
                        this.eyR.writeShort(Short.reverseBytes(this.ezm));
                        this.eyR.writeInt(Integer.reverseBytes(this.ezn));
                        this.eyR.writeInt(Integer.reverseBytes(((this.ezn * this.ezo) * this.ezm) / 8));
                        this.eyR.writeShort(Short.reverseBytes((short) ((this.ezm * this.ezo) / 8)));
                        this.eyR.writeShort(Short.reverseBytes(this.ezo));
                        this.eyR.writeBytes("data");
                        this.eyR.writeInt(0);
                        this.buffer = new byte[((this.ezr * this.ezo) / 8) * this.ezm];
                        this.ezl = State.READY;
                    } else {
                        BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on uninitialized recorder");
                        this.ezl = State.ERROR;
                        return false;
                    }
                } else {
                    ezj.prepare();
                    this.ezl = State.READY;
                }
                return true;
            }
            BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on illegal state");
            release();
            this.ezl = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured in prepare()");
            }
            this.ezl = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.ezl == State.RECORDING) {
            stop();
        } else {
            if ((this.ezl == State.READY) & this.ezh) {
                try {
                    this.eyR.close();
                } catch (IOException e) {
                    BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.ezh) {
            if (ezi != null) {
                ezi.release();
            }
        } else if (ezj != null) {
            ezj.release();
        }
    }

    public void start() {
        if (this.ezl == State.READY) {
            if (this.ezh) {
                this.payloadSize = 0;
                ezi.startRecording();
                ezi.read(this.buffer, 0, this.buffer.length);
            } else {
                ezj.start();
            }
            this.ezl = State.RECORDING;
            return;
        }
        BdLog.e(MyAudioRecorder.class.getName() + "start() called on illegal state");
        this.ezl = State.ERROR;
    }

    public void stop() {
        BdLog.e(MyAudioRecorder.class.getName() + "audioRecorder.stop()");
        ezi.stop();
        try {
            this.eyR.seek(4L);
            this.eyR.writeInt(Integer.reverseBytes(this.payloadSize + 36));
            this.eyR.seek(40L);
            this.eyR.writeInt(Integer.reverseBytes(this.payloadSize));
            this.eyR.close();
            BdLog.e(MyAudioRecorder.class.getName() + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
            this.ezl = State.ERROR;
        }
        this.ezl = State.STOPPED;
    }

    private short b(byte b, byte b2) {
        return (short) ((b2 << 8) | b);
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean AO(String str) {
        if (AQ(str)) {
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
        this.ezl = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean bmc() {
        return this.ezl == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blZ() {
        if (ezi != null) {
            try {
                start();
                while (bmc()) {
                    ezi.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.eyR.write(this.buffer);
                        this.payloadSize += this.buffer.length;
                        if (this.ezo == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short b = b(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (b > this.ezk) {
                                    this.ezk = b;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.ezk) {
                                    this.ezk = this.buffer[i2];
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
