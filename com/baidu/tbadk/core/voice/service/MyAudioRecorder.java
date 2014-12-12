package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import android.media.MediaRecorder;
import android.util.Log;
import com.baidu.channelrtc.medialivesender.LiveSenderControl;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class MyAudioRecorder implements j {
    private int NQ;
    private RandomAccessFile NS;
    private Thread Oh;
    private boolean Oi;
    private int Ol;
    private State Om;
    private short On;
    private int Oo;
    private short Op;
    private int Oq;
    private int Or;
    private int Os;
    private int Ot;
    private byte[] buffer;
    private String filePath;
    private static final int[] Og = {LiveSenderControl.LiveSenderSampleRate.SAMPLINGRATE_44_1, LiveSenderControl.LiveSenderSampleRate.SAMPLINGRATE_22_05, LiveSenderControl.LiveSenderSampleRate.SAMPLINGRATE_11_025, LiveSenderControl.LiveSenderSampleRate.SAMPLINGRATE_8};
    private static Object mLock = new Object();
    private static AudioRecord Oj = null;
    private static MediaRecorder Ok = null;

    /* loaded from: classes.dex */
    public enum State {
        INITIALIZING,
        READY,
        RECORDING,
        ERROR,
        STOPPED;

        /* JADX DEBUG: Replace access to removed values field (Ov) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static State[] valuesCustom() {
            State[] valuesCustom = values();
            int length = valuesCustom.length;
            State[] stateArr = new State[length];
            System.arraycopy(valuesCustom, 0, stateArr, 0, length);
            return stateArr;
        }
    }

    public static MyAudioRecorder d(Boolean bool) {
        MyAudioRecorder myAudioRecorder;
        synchronized (mLock) {
            Oj = null;
            Ok = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, Og[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.qR() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, Og[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State qR() {
        return this.Om;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.Ol = 0;
        this.filePath = null;
        try {
            this.Oi = z;
            if (this.Oi) {
                if (i4 == 2) {
                    this.Op = (short) 16;
                } else {
                    this.Op = (short) 8;
                }
                if (i3 == 2) {
                    this.On = (short) 1;
                } else {
                    this.On = (short) 2;
                }
                this.Oq = i;
                this.Oo = i2;
                this.Or = i4;
                this.Os = (i2 * 120) / 1000;
                this.NQ = (((this.Os * 2) * this.Op) * this.On) / 8;
                if (this.NQ < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.NQ = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.Os = this.NQ / (((this.Op * 2) * this.On) / 8);
                    Log.w(MyAudioRecorder.class.getName(), "Increasing buffer size to " + Integer.toString(this.NQ));
                }
                Oj = new AudioRecord(i, i2, i3, i4, this.NQ);
                if (Oj.getRecordingState() == 3) {
                    Oj.stop();
                }
                if (Oj.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                Ok = new MediaRecorder();
                Ok.setAudioSource(1);
                Ok.setOutputFormat(1);
                Ok.setAudioEncoder(1);
            }
            this.Ol = 0;
            this.filePath = null;
            this.Om = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                Log.e(MyAudioRecorder.class.getName(), e.getMessage());
            } else {
                Log.e(MyAudioRecorder.class.getName(), "Unknown error occured while initializing recording");
            }
            this.Om = State.ERROR;
        }
    }

    public boolean db(String str) {
        try {
            if (this.Om == State.INITIALIZING) {
                this.filePath = str;
                if (!this.Oi) {
                    Ok.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                Log.e(MyAudioRecorder.class.getName(), e.getMessage());
            } else {
                Log.e(MyAudioRecorder.class.getName(), "Unknown error occured while setting output path");
            }
            this.Om = State.ERROR;
            return false;
        }
    }

    public boolean qS() {
        try {
            if (this.Om == State.INITIALIZING) {
                if (this.Oi) {
                    if ((this.filePath != null) & (Oj.getState() == 1)) {
                        if (this.NS != null) {
                            this.NS.close();
                            this.NS = null;
                        }
                        this.NS = new RandomAccessFile(this.filePath, "rw");
                        this.NS.setLength(0L);
                        this.NS.writeBytes("RIFF");
                        this.NS.writeInt(0);
                        this.NS.writeBytes("WAVE");
                        this.NS.writeBytes("fmt ");
                        this.NS.writeInt(Integer.reverseBytes(16));
                        this.NS.writeShort(Short.reverseBytes((short) 1));
                        this.NS.writeShort(Short.reverseBytes(this.On));
                        this.NS.writeInt(Integer.reverseBytes(this.Oo));
                        this.NS.writeInt(Integer.reverseBytes(((this.Oo * this.Op) * this.On) / 8));
                        this.NS.writeShort(Short.reverseBytes((short) ((this.On * this.Op) / 8)));
                        this.NS.writeShort(Short.reverseBytes(this.Op));
                        this.NS.writeBytes("data");
                        this.NS.writeInt(0);
                        this.buffer = new byte[((this.Os * this.Op) / 8) * this.On];
                        this.Om = State.READY;
                    } else {
                        Log.e(MyAudioRecorder.class.getName(), "prepare() method called on uninitialized recorder");
                        this.Om = State.ERROR;
                        return false;
                    }
                } else {
                    Ok.prepare();
                    this.Om = State.READY;
                }
                return true;
            }
            Log.e(MyAudioRecorder.class.getName(), "prepare() method called on illegal state");
            release();
            this.Om = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                Log.e(MyAudioRecorder.class.getName(), e.getMessage());
            } else {
                Log.e(MyAudioRecorder.class.getName(), "Unknown error occured in prepare()");
            }
            this.Om = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.Om == State.RECORDING) {
            stop();
        } else {
            if ((this.Om == State.READY) & this.Oi) {
                try {
                    this.NS.close();
                } catch (IOException e) {
                    Log.e(MyAudioRecorder.class.getName(), "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.Oi) {
            if (Oj != null) {
                Oj.release();
            }
        } else if (Ok != null) {
            Ok.release();
        }
    }

    public void start() {
        if (this.Om == State.READY) {
            if (this.Oi) {
                this.Ot = 0;
                Oj.startRecording();
                Oj.read(this.buffer, 0, this.buffer.length);
            } else {
                Ok.start();
            }
            this.Om = State.RECORDING;
            return;
        }
        Log.e(MyAudioRecorder.class.getName(), "start() called on illegal state");
        this.Om = State.ERROR;
    }

    public void stop() {
        Log.e(MyAudioRecorder.class.getName(), "audioRecorder.stop()");
        Oj.stop();
        try {
            this.NS.seek(4L);
            this.NS.writeInt(Integer.reverseBytes(this.Ot + 36));
            this.NS.seek(40L);
            this.NS.writeInt(Integer.reverseBytes(this.Ot));
            this.NS.close();
            Log.e(MyAudioRecorder.class.getName(), "randomAccessWriter.close()");
        } catch (IOException e) {
            Log.e(MyAudioRecorder.class.getName(), "I/O exception occured while closing output file");
            this.Om = State.ERROR;
        }
        this.Om = State.STOPPED;
    }

    private short a(byte b, byte b2) {
        return (short) ((b2 << 8) | b);
    }

    @Override // com.baidu.tbadk.core.voice.service.j
    public boolean cZ(String str) {
        if (db(str)) {
            return qS();
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.j
    public boolean qM() {
        synchronized (mLock) {
            if (this.Oh == null || !this.Oh.isAlive()) {
                this.Oh = new Thread(new h(this));
                this.Oh.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.j
    public void qN() {
        this.Om = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.j
    public boolean qO() {
        return this.Om == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qL() {
        if (Oj != null) {
            try {
                start();
                while (qO()) {
                    Oj.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.NS.write(this.buffer);
                        this.Ot += this.buffer.length;
                        if (this.Op == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short a = a(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (a > this.Ol) {
                                    this.Ol = a;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.Ol) {
                                    this.Ol = this.buffer[i2];
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
