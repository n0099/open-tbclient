package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import android.media.MediaRecorder;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.ala.livePlayer.StreamConfig;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class MyAudioRecorder implements d {
    private byte[] buffer;
    private int bufferSize;
    private RandomAccessFile ctF;
    private boolean ctV;
    private int ctY;
    private State ctZ;
    private short cua;
    private int cub;
    private short cuc;
    private int cud;
    private int cue;
    private int cuf;
    private String filePath;
    private int payloadSize;
    private Thread writeThread;
    private static final int[] ctU = {StreamConfig.Audio.AUDIO_FREQUENCY, 22050, RequestResponseCode.REQUEST_LOGIN_PB_AT, 8000};
    private static Object mLock = new Object();
    private static AudioRecord ctW = null;
    private static MediaRecorder ctX = null;

    /* loaded from: classes.dex */
    public enum State {
        INITIALIZING,
        READY,
        RECORDING,
        ERROR,
        STOPPED
    }

    public static MyAudioRecorder d(Boolean bool) {
        MyAudioRecorder myAudioRecorder;
        synchronized (mLock) {
            ctW = null;
            ctX = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, ctU[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.aoE() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, ctU[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State aoE() {
        return this.ctZ;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.ctY = 0;
        this.filePath = null;
        try {
            this.ctV = z;
            if (this.ctV) {
                if (i4 == 2) {
                    this.cuc = (short) 16;
                } else {
                    this.cuc = (short) 8;
                }
                if (i3 == 2) {
                    this.cua = (short) 1;
                } else {
                    this.cua = (short) 2;
                }
                this.cud = i;
                this.cub = i2;
                this.cue = i4;
                this.cuf = (i2 * 120) / 1000;
                this.bufferSize = (((this.cuf * 2) * this.cuc) * this.cua) / 8;
                if (this.bufferSize < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.cuf = this.bufferSize / (((this.cuc * 2) * this.cua) / 8);
                    BdLog.w(MyAudioRecorder.class.getName() + "Increasing buffer size to " + Integer.toString(this.bufferSize));
                }
                ctW = new AudioRecord(i, i2, i3, i4, this.bufferSize);
                if (ctW.getRecordingState() == 3) {
                    ctW.stop();
                }
                if (ctW.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                ctX = new MediaRecorder();
                ctX.setAudioSource(1);
                ctX.setOutputFormat(1);
                ctX.setAudioEncoder(1);
            }
            this.ctY = 0;
            this.filePath = null;
            this.ctZ = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while initializing recording");
            }
            this.ctZ = State.ERROR;
        }
    }

    public boolean oH(String str) {
        try {
            if (this.ctZ == State.INITIALIZING) {
                this.filePath = str;
                if (!this.ctV) {
                    ctX.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while setting output path");
            }
            this.ctZ = State.ERROR;
            return false;
        }
    }

    public boolean prepare() {
        try {
            if (this.ctZ == State.INITIALIZING) {
                if (this.ctV) {
                    if ((this.filePath != null) & (ctW.getState() == 1)) {
                        if (this.ctF != null) {
                            this.ctF.close();
                            this.ctF = null;
                        }
                        this.ctF = new RandomAccessFile(this.filePath, "rw");
                        this.ctF.setLength(0L);
                        this.ctF.writeBytes("RIFF");
                        this.ctF.writeInt(0);
                        this.ctF.writeBytes("WAVE");
                        this.ctF.writeBytes("fmt ");
                        this.ctF.writeInt(Integer.reverseBytes(16));
                        this.ctF.writeShort(Short.reverseBytes((short) 1));
                        this.ctF.writeShort(Short.reverseBytes(this.cua));
                        this.ctF.writeInt(Integer.reverseBytes(this.cub));
                        this.ctF.writeInt(Integer.reverseBytes(((this.cub * this.cuc) * this.cua) / 8));
                        this.ctF.writeShort(Short.reverseBytes((short) ((this.cua * this.cuc) / 8)));
                        this.ctF.writeShort(Short.reverseBytes(this.cuc));
                        this.ctF.writeBytes("data");
                        this.ctF.writeInt(0);
                        this.buffer = new byte[((this.cuf * this.cuc) / 8) * this.cua];
                        this.ctZ = State.READY;
                    } else {
                        BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on uninitialized recorder");
                        this.ctZ = State.ERROR;
                        return false;
                    }
                } else {
                    ctX.prepare();
                    this.ctZ = State.READY;
                }
                return true;
            }
            BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on illegal state");
            release();
            this.ctZ = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured in prepare()");
            }
            this.ctZ = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.ctZ == State.RECORDING) {
            stop();
        } else {
            if ((this.ctZ == State.READY) & this.ctV) {
                try {
                    this.ctF.close();
                } catch (IOException e) {
                    BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.ctV) {
            if (ctW != null) {
                ctW.release();
            }
        } else if (ctX != null) {
            ctX.release();
        }
    }

    public void start() {
        if (this.ctZ == State.READY) {
            if (this.ctV) {
                this.payloadSize = 0;
                ctW.startRecording();
                ctW.read(this.buffer, 0, this.buffer.length);
            } else {
                ctX.start();
            }
            this.ctZ = State.RECORDING;
            return;
        }
        BdLog.e(MyAudioRecorder.class.getName() + "start() called on illegal state");
        this.ctZ = State.ERROR;
    }

    public void stop() {
        BdLog.e(MyAudioRecorder.class.getName() + "audioRecorder.stop()");
        ctW.stop();
        try {
            this.ctF.seek(4L);
            this.ctF.writeInt(Integer.reverseBytes(this.payloadSize + 36));
            this.ctF.seek(40L);
            this.ctF.writeInt(Integer.reverseBytes(this.payloadSize));
            this.ctF.close();
            BdLog.e(MyAudioRecorder.class.getName() + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
            this.ctZ = State.ERROR;
        }
        this.ctZ = State.STOPPED;
    }

    private short b(byte b, byte b2) {
        return (short) ((b2 << 8) | b);
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean oF(String str) {
        if (oH(str)) {
            return prepare();
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean aoA() {
        synchronized (mLock) {
            if (this.writeThread == null || !this.writeThread.isAlive()) {
                this.writeThread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.MyAudioRecorder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MyAudioRecorder.this.aoz();
                    }
                });
                this.writeThread.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void aoB() {
        this.ctZ = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean aoC() {
        return this.ctZ == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoz() {
        if (ctW != null) {
            try {
                start();
                while (aoC()) {
                    ctW.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.ctF.write(this.buffer);
                        this.payloadSize += this.buffer.length;
                        if (this.cuc == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short b = b(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (b > this.ctY) {
                                    this.ctY = b;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.ctY) {
                                    this.ctY = this.buffer[i2];
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
