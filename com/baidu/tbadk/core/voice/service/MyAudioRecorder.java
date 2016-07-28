package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import android.media.MediaRecorder;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class MyAudioRecorder implements i {
    private int afO;
    private RandomAccessFile afR;
    private Thread agj;
    private boolean agk;
    private int agn;
    private State ago;
    private short agp;
    private int agq;
    private short agr;
    private int ags;
    private int agt;
    private int agu;
    private int agv;
    private byte[] buffer;
    private String filePath;
    private static final int[] agi = {44100, 22050, 11025, 8000};
    private static Object mLock = new Object();
    private static AudioRecord agl = null;
    private static MediaRecorder agm = null;

    /* loaded from: classes.dex */
    public enum State {
        INITIALIZING,
        READY,
        RECORDING,
        ERROR,
        STOPPED;

        /* JADX DEBUG: Replace access to removed values field (agx) with 'values()' method */
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
            agl = null;
            agm = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, agi[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.we() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, agi[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State we() {
        return this.ago;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.agn = 0;
        this.filePath = null;
        try {
            this.agk = z;
            if (this.agk) {
                if (i4 == 2) {
                    this.agr = (short) 16;
                } else {
                    this.agr = (short) 8;
                }
                if (i3 == 2) {
                    this.agp = (short) 1;
                } else {
                    this.agp = (short) 2;
                }
                this.ags = i;
                this.agq = i2;
                this.agt = i4;
                this.agu = (i2 * SocialAPIErrorCodes.ERROR_INVALID_AUTHORIZED_CODE) / 1000;
                this.afO = (((this.agu * 2) * this.agr) * this.agp) / 8;
                if (this.afO < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.afO = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.agu = this.afO / (((this.agr * 2) * this.agp) / 8);
                    BdLog.w(String.valueOf(MyAudioRecorder.class.getName()) + "Increasing buffer size to " + Integer.toString(this.afO));
                }
                agl = new AudioRecord(i, i2, i3, i4, this.afO);
                if (agl.getRecordingState() == 3) {
                    agl.stop();
                }
                if (agl.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                agm = new MediaRecorder();
                agm.setAudioSource(1);
                agm.setOutputFormat(1);
                agm.setAudioEncoder(1);
            }
            this.agn = 0;
            this.filePath = null;
            this.ago = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "Unknown error occured while initializing recording");
            }
            this.ago = State.ERROR;
        }
    }

    public boolean dZ(String str) {
        try {
            if (this.ago == State.INITIALIZING) {
                this.filePath = str;
                if (!this.agk) {
                    agm.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + e.getMessage());
            } else {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "Unknown error occured while setting output path");
            }
            this.ago = State.ERROR;
            return false;
        }
    }

    public boolean prepare() {
        try {
            if (this.ago == State.INITIALIZING) {
                if (this.agk) {
                    if ((this.filePath != null) & (agl.getState() == 1)) {
                        if (this.afR != null) {
                            this.afR.close();
                            this.afR = null;
                        }
                        this.afR = new RandomAccessFile(this.filePath, "rw");
                        this.afR.setLength(0L);
                        this.afR.writeBytes("RIFF");
                        this.afR.writeInt(0);
                        this.afR.writeBytes("WAVE");
                        this.afR.writeBytes("fmt ");
                        this.afR.writeInt(Integer.reverseBytes(16));
                        this.afR.writeShort(Short.reverseBytes((short) 1));
                        this.afR.writeShort(Short.reverseBytes(this.agp));
                        this.afR.writeInt(Integer.reverseBytes(this.agq));
                        this.afR.writeInt(Integer.reverseBytes(((this.agq * this.agr) * this.agp) / 8));
                        this.afR.writeShort(Short.reverseBytes((short) ((this.agp * this.agr) / 8)));
                        this.afR.writeShort(Short.reverseBytes(this.agr));
                        this.afR.writeBytes("data");
                        this.afR.writeInt(0);
                        this.buffer = new byte[((this.agu * this.agr) / 8) * this.agp];
                        this.ago = State.READY;
                    } else {
                        BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "prepare() method called on uninitialized recorder");
                        this.ago = State.ERROR;
                        return false;
                    }
                } else {
                    agm.prepare();
                    this.ago = State.READY;
                }
                return true;
            }
            BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "prepare() method called on illegal state");
            release();
            this.ago = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + e.getMessage());
            } else {
                BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "Unknown error occured in prepare()");
            }
            this.ago = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.ago == State.RECORDING) {
            stop();
        } else {
            if ((this.ago == State.READY) & this.agk) {
                try {
                    this.afR.close();
                } catch (IOException e) {
                    BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.agk) {
            if (agl != null) {
                agl.release();
            }
        } else if (agm != null) {
            agm.release();
        }
    }

    public void start() {
        if (this.ago == State.READY) {
            if (this.agk) {
                this.agv = 0;
                agl.startRecording();
                agl.read(this.buffer, 0, this.buffer.length);
            } else {
                agm.start();
            }
            this.ago = State.RECORDING;
            return;
        }
        BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "start() called on illegal state");
        this.ago = State.ERROR;
    }

    public void stop() {
        BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "audioRecorder.stop()");
        agl.stop();
        try {
            this.afR.seek(4L);
            this.afR.writeInt(Integer.reverseBytes(this.agv + 36));
            this.afR.seek(40L);
            this.afR.writeInt(Integer.reverseBytes(this.agv));
            this.afR.close();
            BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(String.valueOf(MyAudioRecorder.class.getName()) + "I/O exception occured while closing output file");
            this.ago = State.ERROR;
        }
        this.ago = State.STOPPED;
    }

    private short a(byte b, byte b2) {
        return (short) ((b2 << 8) | b);
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean dX(String str) {
        if (dZ(str)) {
            return prepare();
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean vZ() {
        synchronized (mLock) {
            if (this.agj == null || !this.agj.isAlive()) {
                this.agj = new Thread(new g(this));
                this.agj.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public void wa() {
        this.ago = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean wb() {
        return this.ago == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vY() {
        if (agl != null) {
            try {
                start();
                while (wb()) {
                    agl.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.afR.write(this.buffer);
                        this.agv += this.buffer.length;
                        if (this.agr == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short a = a(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (a > this.agn) {
                                    this.agn = a;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.agn) {
                                    this.agn = this.buffer[i2];
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
