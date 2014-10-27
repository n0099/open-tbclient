package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import android.media.MediaRecorder;
import android.util.Log;
import com.baidu.channelrtc.medialivesender.LiveSenderControl;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class MyAudioRecorder implements h {
    private int IO;
    private RandomAccessFile IQ;
    private Thread IY;
    private boolean IZ;
    private int Jc;
    private State Jd;
    private short Je;
    private int Jf;
    private short Jg;
    private int Jh;
    private int Ji;
    private int Jj;
    private int Jk;
    private byte[] buffer;
    private String filePath;
    private static final int[] IX = {LiveSenderControl.LiveSenderSampleRate.SAMPLINGRATE_44_1, LiveSenderControl.LiveSenderSampleRate.SAMPLINGRATE_22_05, LiveSenderControl.LiveSenderSampleRate.SAMPLINGRATE_11_025, LiveSenderControl.LiveSenderSampleRate.SAMPLINGRATE_8};
    private static Object mLock = new Object();
    private static AudioRecord Ja = null;
    private static MediaRecorder Jb = null;

    /* loaded from: classes.dex */
    public enum State {
        INITIALIZING,
        READY,
        RECORDING,
        ERROR,
        STOPPED;

        /* JADX DEBUG: Replace access to removed values field (Jm) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static State[] valuesCustom() {
            State[] valuesCustom = values();
            int length = valuesCustom.length;
            State[] stateArr = new State[length];
            System.arraycopy(valuesCustom, 0, stateArr, 0, length);
            return stateArr;
        }
    }

    public static MyAudioRecorder c(Boolean bool) {
        MyAudioRecorder myAudioRecorder;
        synchronized (mLock) {
            Ja = null;
            Jb = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, IX[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.nP() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, IX[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State nP() {
        return this.Jd;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.Jc = 0;
        this.filePath = null;
        try {
            this.IZ = z;
            if (this.IZ) {
                if (i4 == 2) {
                    this.Jg = (short) 16;
                } else {
                    this.Jg = (short) 8;
                }
                if (i3 == 2) {
                    this.Je = (short) 1;
                } else {
                    this.Je = (short) 2;
                }
                this.Jh = i;
                this.Jf = i2;
                this.Ji = i4;
                this.Jj = (i2 * 120) / 1000;
                this.IO = (((this.Jj * 2) * this.Jg) * this.Je) / 8;
                if (this.IO < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.IO = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.Jj = this.IO / (((this.Jg * 2) * this.Je) / 8);
                    Log.w(MyAudioRecorder.class.getName(), "Increasing buffer size to " + Integer.toString(this.IO));
                }
                Ja = new AudioRecord(i, i2, i3, i4, this.IO);
                if (Ja.getRecordingState() == 3) {
                    Ja.stop();
                }
                if (Ja.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                Jb = new MediaRecorder();
                Jb.setAudioSource(1);
                Jb.setOutputFormat(1);
                Jb.setAudioEncoder(1);
            }
            this.Jc = 0;
            this.filePath = null;
            this.Jd = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                Log.e(MyAudioRecorder.class.getName(), e.getMessage());
            } else {
                Log.e(MyAudioRecorder.class.getName(), "Unknown error occured while initializing recording");
            }
            this.Jd = State.ERROR;
        }
    }

    public boolean ci(String str) {
        try {
            if (this.Jd == State.INITIALIZING) {
                this.filePath = str;
                if (!this.IZ) {
                    Jb.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                Log.e(MyAudioRecorder.class.getName(), e.getMessage());
            } else {
                Log.e(MyAudioRecorder.class.getName(), "Unknown error occured while setting output path");
            }
            this.Jd = State.ERROR;
            return false;
        }
    }

    public boolean nQ() {
        try {
            if (this.Jd == State.INITIALIZING) {
                if (this.IZ) {
                    if ((this.filePath != null) & (Ja.getState() == 1)) {
                        if (this.IQ != null) {
                            this.IQ.close();
                            this.IQ = null;
                        }
                        this.IQ = new RandomAccessFile(this.filePath, "rw");
                        this.IQ.setLength(0L);
                        this.IQ.writeBytes("RIFF");
                        this.IQ.writeInt(0);
                        this.IQ.writeBytes("WAVE");
                        this.IQ.writeBytes("fmt ");
                        this.IQ.writeInt(Integer.reverseBytes(16));
                        this.IQ.writeShort(Short.reverseBytes((short) 1));
                        this.IQ.writeShort(Short.reverseBytes(this.Je));
                        this.IQ.writeInt(Integer.reverseBytes(this.Jf));
                        this.IQ.writeInt(Integer.reverseBytes(((this.Jf * this.Jg) * this.Je) / 8));
                        this.IQ.writeShort(Short.reverseBytes((short) ((this.Je * this.Jg) / 8)));
                        this.IQ.writeShort(Short.reverseBytes(this.Jg));
                        this.IQ.writeBytes("data");
                        this.IQ.writeInt(0);
                        this.buffer = new byte[((this.Jj * this.Jg) / 8) * this.Je];
                        this.Jd = State.READY;
                    } else {
                        Log.e(MyAudioRecorder.class.getName(), "prepare() method called on uninitialized recorder");
                        this.Jd = State.ERROR;
                        return false;
                    }
                } else {
                    Jb.prepare();
                    this.Jd = State.READY;
                }
                return true;
            }
            Log.e(MyAudioRecorder.class.getName(), "prepare() method called on illegal state");
            release();
            this.Jd = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                Log.e(MyAudioRecorder.class.getName(), e.getMessage());
            } else {
                Log.e(MyAudioRecorder.class.getName(), "Unknown error occured in prepare()");
            }
            this.Jd = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.Jd == State.RECORDING) {
            stop();
        } else {
            if ((this.Jd == State.READY) & this.IZ) {
                try {
                    this.IQ.close();
                } catch (IOException e) {
                    Log.e(MyAudioRecorder.class.getName(), "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.IZ) {
            if (Ja != null) {
                Ja.release();
            }
        } else if (Jb != null) {
            Jb.release();
        }
    }

    public void start() {
        if (this.Jd == State.READY) {
            if (this.IZ) {
                this.Jk = 0;
                Ja.startRecording();
                Ja.read(this.buffer, 0, this.buffer.length);
            } else {
                Jb.start();
            }
            this.Jd = State.RECORDING;
            return;
        }
        Log.e(MyAudioRecorder.class.getName(), "start() called on illegal state");
        this.Jd = State.ERROR;
    }

    public void stop() {
        Log.e(MyAudioRecorder.class.getName(), "audioRecorder.stop()");
        Ja.stop();
        try {
            this.IQ.seek(4L);
            this.IQ.writeInt(Integer.reverseBytes(this.Jk + 36));
            this.IQ.seek(40L);
            this.IQ.writeInt(Integer.reverseBytes(this.Jk));
            this.IQ.close();
            Log.e(MyAudioRecorder.class.getName(), "randomAccessWriter.close()");
        } catch (IOException e) {
            Log.e(MyAudioRecorder.class.getName(), "I/O exception occured while closing output file");
            this.Jd = State.ERROR;
        }
        this.Jd = State.STOPPED;
    }

    private short a(byte b, byte b2) {
        return (short) ((b2 << 8) | b);
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public boolean ch(String str) {
        if (ci(str)) {
            return nQ();
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public boolean nL() {
        synchronized (mLock) {
            if (this.IY == null || !this.IY.isAlive()) {
                this.IY = new Thread(new f(this));
                this.IY.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void nM() {
        this.Jd = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public boolean nN() {
        return this.Jd == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nK() {
        if (Ja != null) {
            try {
                start();
                while (nN()) {
                    Ja.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.IQ.write(this.buffer);
                        this.Jk += this.buffer.length;
                        if (this.Jg == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short a = a(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (a > this.Jc) {
                                    this.Jc = a;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.Jc) {
                                    this.Jc = this.buffer[i2];
                                }
                            }
                        }
                    } catch (IOException e) {
                    }
                }
                stop();
                release();
            } catch (Throwable th) {
                Log.e("AudioRecord", "Recording Failed");
            }
        }
    }
}
