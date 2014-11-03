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
    private int IP;
    private RandomAccessFile IR;
    private Thread IZ;
    private boolean Ja;
    private int Jd;
    private State Je;
    private short Jf;
    private int Jg;
    private short Jh;
    private int Ji;
    private int Jj;
    private int Jk;
    private int Jl;
    private byte[] buffer;
    private String filePath;
    private static final int[] IY = {LiveSenderControl.LiveSenderSampleRate.SAMPLINGRATE_44_1, LiveSenderControl.LiveSenderSampleRate.SAMPLINGRATE_22_05, LiveSenderControl.LiveSenderSampleRate.SAMPLINGRATE_11_025, LiveSenderControl.LiveSenderSampleRate.SAMPLINGRATE_8};
    private static Object mLock = new Object();
    private static AudioRecord Jb = null;
    private static MediaRecorder Jc = null;

    /* loaded from: classes.dex */
    public enum State {
        INITIALIZING,
        READY,
        RECORDING,
        ERROR,
        STOPPED;

        /* JADX DEBUG: Replace access to removed values field (Jn) with 'values()' method */
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
            Jb = null;
            Jc = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, IY[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.nP() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, IY[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State nP() {
        return this.Je;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.Jd = 0;
        this.filePath = null;
        try {
            this.Ja = z;
            if (this.Ja) {
                if (i4 == 2) {
                    this.Jh = (short) 16;
                } else {
                    this.Jh = (short) 8;
                }
                if (i3 == 2) {
                    this.Jf = (short) 1;
                } else {
                    this.Jf = (short) 2;
                }
                this.Ji = i;
                this.Jg = i2;
                this.Jj = i4;
                this.Jk = (i2 * 120) / 1000;
                this.IP = (((this.Jk * 2) * this.Jh) * this.Jf) / 8;
                if (this.IP < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.IP = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.Jk = this.IP / (((this.Jh * 2) * this.Jf) / 8);
                    Log.w(MyAudioRecorder.class.getName(), "Increasing buffer size to " + Integer.toString(this.IP));
                }
                Jb = new AudioRecord(i, i2, i3, i4, this.IP);
                if (Jb.getRecordingState() == 3) {
                    Jb.stop();
                }
                if (Jb.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                Jc = new MediaRecorder();
                Jc.setAudioSource(1);
                Jc.setOutputFormat(1);
                Jc.setAudioEncoder(1);
            }
            this.Jd = 0;
            this.filePath = null;
            this.Je = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                Log.e(MyAudioRecorder.class.getName(), e.getMessage());
            } else {
                Log.e(MyAudioRecorder.class.getName(), "Unknown error occured while initializing recording");
            }
            this.Je = State.ERROR;
        }
    }

    public boolean ci(String str) {
        try {
            if (this.Je == State.INITIALIZING) {
                this.filePath = str;
                if (!this.Ja) {
                    Jc.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                Log.e(MyAudioRecorder.class.getName(), e.getMessage());
            } else {
                Log.e(MyAudioRecorder.class.getName(), "Unknown error occured while setting output path");
            }
            this.Je = State.ERROR;
            return false;
        }
    }

    public boolean nQ() {
        try {
            if (this.Je == State.INITIALIZING) {
                if (this.Ja) {
                    if ((this.filePath != null) & (Jb.getState() == 1)) {
                        if (this.IR != null) {
                            this.IR.close();
                            this.IR = null;
                        }
                        this.IR = new RandomAccessFile(this.filePath, "rw");
                        this.IR.setLength(0L);
                        this.IR.writeBytes("RIFF");
                        this.IR.writeInt(0);
                        this.IR.writeBytes("WAVE");
                        this.IR.writeBytes("fmt ");
                        this.IR.writeInt(Integer.reverseBytes(16));
                        this.IR.writeShort(Short.reverseBytes((short) 1));
                        this.IR.writeShort(Short.reverseBytes(this.Jf));
                        this.IR.writeInt(Integer.reverseBytes(this.Jg));
                        this.IR.writeInt(Integer.reverseBytes(((this.Jg * this.Jh) * this.Jf) / 8));
                        this.IR.writeShort(Short.reverseBytes((short) ((this.Jf * this.Jh) / 8)));
                        this.IR.writeShort(Short.reverseBytes(this.Jh));
                        this.IR.writeBytes("data");
                        this.IR.writeInt(0);
                        this.buffer = new byte[((this.Jk * this.Jh) / 8) * this.Jf];
                        this.Je = State.READY;
                    } else {
                        Log.e(MyAudioRecorder.class.getName(), "prepare() method called on uninitialized recorder");
                        this.Je = State.ERROR;
                        return false;
                    }
                } else {
                    Jc.prepare();
                    this.Je = State.READY;
                }
                return true;
            }
            Log.e(MyAudioRecorder.class.getName(), "prepare() method called on illegal state");
            release();
            this.Je = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                Log.e(MyAudioRecorder.class.getName(), e.getMessage());
            } else {
                Log.e(MyAudioRecorder.class.getName(), "Unknown error occured in prepare()");
            }
            this.Je = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.Je == State.RECORDING) {
            stop();
        } else {
            if ((this.Je == State.READY) & this.Ja) {
                try {
                    this.IR.close();
                } catch (IOException e) {
                    Log.e(MyAudioRecorder.class.getName(), "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.Ja) {
            if (Jb != null) {
                Jb.release();
            }
        } else if (Jc != null) {
            Jc.release();
        }
    }

    public void start() {
        if (this.Je == State.READY) {
            if (this.Ja) {
                this.Jl = 0;
                Jb.startRecording();
                Jb.read(this.buffer, 0, this.buffer.length);
            } else {
                Jc.start();
            }
            this.Je = State.RECORDING;
            return;
        }
        Log.e(MyAudioRecorder.class.getName(), "start() called on illegal state");
        this.Je = State.ERROR;
    }

    public void stop() {
        Log.e(MyAudioRecorder.class.getName(), "audioRecorder.stop()");
        Jb.stop();
        try {
            this.IR.seek(4L);
            this.IR.writeInt(Integer.reverseBytes(this.Jl + 36));
            this.IR.seek(40L);
            this.IR.writeInt(Integer.reverseBytes(this.Jl));
            this.IR.close();
            Log.e(MyAudioRecorder.class.getName(), "randomAccessWriter.close()");
        } catch (IOException e) {
            Log.e(MyAudioRecorder.class.getName(), "I/O exception occured while closing output file");
            this.Je = State.ERROR;
        }
        this.Je = State.STOPPED;
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
            if (this.IZ == null || !this.IZ.isAlive()) {
                this.IZ = new Thread(new f(this));
                this.IZ.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void nM() {
        this.Je = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public boolean nN() {
        return this.Je == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nK() {
        if (Jb != null) {
            try {
                start();
                while (nN()) {
                    Jb.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.IR.write(this.buffer);
                        this.Jl += this.buffer.length;
                        if (this.Jh == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short a = a(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (a > this.Jd) {
                                    this.Jd = a;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.Jd) {
                                    this.Jd = this.buffer[i2];
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
