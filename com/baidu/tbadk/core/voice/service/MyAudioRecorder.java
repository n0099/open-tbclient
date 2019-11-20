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
    private RandomAccessFile csO;
    private boolean cte;
    private int cth;
    private State cti;
    private short ctj;
    private int ctk;
    private short ctl;
    private int ctm;
    private int ctn;
    private int cto;
    private String filePath;
    private int payloadSize;
    private Thread writeThread;
    private static final int[] ctd = {StreamConfig.Audio.AUDIO_FREQUENCY, 22050, RequestResponseCode.REQUEST_LOGIN_PB_AT, 8000};
    private static Object mLock = new Object();
    private static AudioRecord ctf = null;
    private static MediaRecorder ctg = null;

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
            ctf = null;
            ctg = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, ctd[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.aoC() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, ctd[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State aoC() {
        return this.cti;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.cth = 0;
        this.filePath = null;
        try {
            this.cte = z;
            if (this.cte) {
                if (i4 == 2) {
                    this.ctl = (short) 16;
                } else {
                    this.ctl = (short) 8;
                }
                if (i3 == 2) {
                    this.ctj = (short) 1;
                } else {
                    this.ctj = (short) 2;
                }
                this.ctm = i;
                this.ctk = i2;
                this.ctn = i4;
                this.cto = (i2 * 120) / 1000;
                this.bufferSize = (((this.cto * 2) * this.ctl) * this.ctj) / 8;
                if (this.bufferSize < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.cto = this.bufferSize / (((this.ctl * 2) * this.ctj) / 8);
                    BdLog.w(MyAudioRecorder.class.getName() + "Increasing buffer size to " + Integer.toString(this.bufferSize));
                }
                ctf = new AudioRecord(i, i2, i3, i4, this.bufferSize);
                if (ctf.getRecordingState() == 3) {
                    ctf.stop();
                }
                if (ctf.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                ctg = new MediaRecorder();
                ctg.setAudioSource(1);
                ctg.setOutputFormat(1);
                ctg.setAudioEncoder(1);
            }
            this.cth = 0;
            this.filePath = null;
            this.cti = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while initializing recording");
            }
            this.cti = State.ERROR;
        }
    }

    public boolean oH(String str) {
        try {
            if (this.cti == State.INITIALIZING) {
                this.filePath = str;
                if (!this.cte) {
                    ctg.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while setting output path");
            }
            this.cti = State.ERROR;
            return false;
        }
    }

    public boolean prepare() {
        try {
            if (this.cti == State.INITIALIZING) {
                if (this.cte) {
                    if ((this.filePath != null) & (ctf.getState() == 1)) {
                        if (this.csO != null) {
                            this.csO.close();
                            this.csO = null;
                        }
                        this.csO = new RandomAccessFile(this.filePath, "rw");
                        this.csO.setLength(0L);
                        this.csO.writeBytes("RIFF");
                        this.csO.writeInt(0);
                        this.csO.writeBytes("WAVE");
                        this.csO.writeBytes("fmt ");
                        this.csO.writeInt(Integer.reverseBytes(16));
                        this.csO.writeShort(Short.reverseBytes((short) 1));
                        this.csO.writeShort(Short.reverseBytes(this.ctj));
                        this.csO.writeInt(Integer.reverseBytes(this.ctk));
                        this.csO.writeInt(Integer.reverseBytes(((this.ctk * this.ctl) * this.ctj) / 8));
                        this.csO.writeShort(Short.reverseBytes((short) ((this.ctj * this.ctl) / 8)));
                        this.csO.writeShort(Short.reverseBytes(this.ctl));
                        this.csO.writeBytes("data");
                        this.csO.writeInt(0);
                        this.buffer = new byte[((this.cto * this.ctl) / 8) * this.ctj];
                        this.cti = State.READY;
                    } else {
                        BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on uninitialized recorder");
                        this.cti = State.ERROR;
                        return false;
                    }
                } else {
                    ctg.prepare();
                    this.cti = State.READY;
                }
                return true;
            }
            BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on illegal state");
            release();
            this.cti = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured in prepare()");
            }
            this.cti = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.cti == State.RECORDING) {
            stop();
        } else {
            if ((this.cti == State.READY) & this.cte) {
                try {
                    this.csO.close();
                } catch (IOException e) {
                    BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.cte) {
            if (ctf != null) {
                ctf.release();
            }
        } else if (ctg != null) {
            ctg.release();
        }
    }

    public void start() {
        if (this.cti == State.READY) {
            if (this.cte) {
                this.payloadSize = 0;
                ctf.startRecording();
                ctf.read(this.buffer, 0, this.buffer.length);
            } else {
                ctg.start();
            }
            this.cti = State.RECORDING;
            return;
        }
        BdLog.e(MyAudioRecorder.class.getName() + "start() called on illegal state");
        this.cti = State.ERROR;
    }

    public void stop() {
        BdLog.e(MyAudioRecorder.class.getName() + "audioRecorder.stop()");
        ctf.stop();
        try {
            this.csO.seek(4L);
            this.csO.writeInt(Integer.reverseBytes(this.payloadSize + 36));
            this.csO.seek(40L);
            this.csO.writeInt(Integer.reverseBytes(this.payloadSize));
            this.csO.close();
            BdLog.e(MyAudioRecorder.class.getName() + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
            this.cti = State.ERROR;
        }
        this.cti = State.STOPPED;
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
    public boolean aoy() {
        synchronized (mLock) {
            if (this.writeThread == null || !this.writeThread.isAlive()) {
                this.writeThread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.MyAudioRecorder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MyAudioRecorder.this.aox();
                    }
                });
                this.writeThread.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void aoz() {
        this.cti = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean aoA() {
        return this.cti == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aox() {
        if (ctf != null) {
            try {
                start();
                while (aoA()) {
                    ctf.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.csO.write(this.buffer);
                        this.payloadSize += this.buffer.length;
                        if (this.ctl == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short b = b(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (b > this.cth) {
                                    this.cth = b;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.cth) {
                                    this.cth = this.buffer[i2];
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
