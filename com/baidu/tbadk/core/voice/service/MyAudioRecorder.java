package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import android.media.MediaRecorder;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.yy.mediaframework.stat.VideoDataStatistic;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class MyAudioRecorder implements d {
    private byte[] buffer;
    private int bufferSize;
    private String filePath;
    private RandomAccessFile fqP;
    private boolean frg;
    private int frj;
    private State frk;
    private short frl;
    private int frm;
    private short frn;
    private int fro;
    private int frp;
    private int frq;
    private int payloadSize;
    private Thread writeThread;
    private static final int[] frf = {44100, 22050, RequestResponseCode.REQUEST_LOGIN_PB_AT, 8000};
    private static Object mLock = new Object();
    private static AudioRecord frh = null;
    private static MediaRecorder fri = null;

    /* loaded from: classes.dex */
    public enum State {
        INITIALIZING,
        READY,
        RECORDING,
        ERROR,
        STOPPED
    }

    public static MyAudioRecorder m(Boolean bool) {
        MyAudioRecorder myAudioRecorder;
        synchronized (mLock) {
            frh = null;
            fri = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, frf[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.bvN() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, frf[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State bvN() {
        return this.frk;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.frj = 0;
        this.filePath = null;
        try {
            this.frg = z;
            if (this.frg) {
                if (i4 == 2) {
                    this.frn = (short) 16;
                } else {
                    this.frn = (short) 8;
                }
                if (i3 == 2) {
                    this.frl = (short) 1;
                } else {
                    this.frl = (short) 2;
                }
                this.fro = i;
                this.frm = i2;
                this.frp = i4;
                this.frq = (i2 * 120) / 1000;
                this.bufferSize = (((this.frq * 2) * this.frn) * this.frl) / 8;
                if (this.bufferSize < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.frq = this.bufferSize / (((this.frn * 2) * this.frl) / 8);
                    BdLog.w(MyAudioRecorder.class.getName() + "Increasing buffer size to " + Integer.toString(this.bufferSize));
                }
                frh = new AudioRecord(i, i2, i3, i4, this.bufferSize);
                if (frh.getRecordingState() == 3) {
                    frh.stop();
                }
                if (frh.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                fri = new MediaRecorder();
                fri.setAudioSource(1);
                fri.setOutputFormat(1);
                fri.setAudioEncoder(1);
            }
            this.frj = 0;
            this.filePath = null;
            this.frk = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while initializing recording");
            }
            this.frk = State.ERROR;
        }
    }

    public boolean BX(String str) {
        try {
            if (this.frk == State.INITIALIZING) {
                this.filePath = str;
                if (!this.frg) {
                    fri.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while setting output path");
            }
            this.frk = State.ERROR;
            return false;
        }
    }

    public boolean prepare() {
        try {
            if (this.frk == State.INITIALIZING) {
                if (this.frg) {
                    if ((this.filePath != null) & (frh.getState() == 1)) {
                        if (this.fqP != null) {
                            this.fqP.close();
                            this.fqP = null;
                        }
                        this.fqP = new RandomAccessFile(this.filePath, VideoDataStatistic.AnchorHiidoCoreStatisticKey.CaptureRealResolutionWidth);
                        this.fqP.setLength(0L);
                        this.fqP.writeBytes("RIFF");
                        this.fqP.writeInt(0);
                        this.fqP.writeBytes("WAVE");
                        this.fqP.writeBytes("fmt ");
                        this.fqP.writeInt(Integer.reverseBytes(16));
                        this.fqP.writeShort(Short.reverseBytes((short) 1));
                        this.fqP.writeShort(Short.reverseBytes(this.frl));
                        this.fqP.writeInt(Integer.reverseBytes(this.frm));
                        this.fqP.writeInt(Integer.reverseBytes(((this.frm * this.frn) * this.frl) / 8));
                        this.fqP.writeShort(Short.reverseBytes((short) ((this.frl * this.frn) / 8)));
                        this.fqP.writeShort(Short.reverseBytes(this.frn));
                        this.fqP.writeBytes("data");
                        this.fqP.writeInt(0);
                        this.buffer = new byte[((this.frq * this.frn) / 8) * this.frl];
                        this.frk = State.READY;
                    } else {
                        BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on uninitialized recorder");
                        this.frk = State.ERROR;
                        return false;
                    }
                } else {
                    fri.prepare();
                    this.frk = State.READY;
                }
                return true;
            }
            BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on illegal state");
            release();
            this.frk = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured in prepare()");
            }
            this.frk = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.frk == State.RECORDING) {
            stop();
        } else {
            if ((this.frk == State.READY) & this.frg) {
                try {
                    this.fqP.close();
                } catch (IOException e) {
                    BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.frg) {
            if (frh != null) {
                frh.release();
            }
        } else if (fri != null) {
            fri.release();
        }
    }

    public void start() {
        if (this.frk == State.READY) {
            if (this.frg) {
                this.payloadSize = 0;
                frh.startRecording();
                frh.read(this.buffer, 0, this.buffer.length);
            } else {
                fri.start();
            }
            this.frk = State.RECORDING;
            return;
        }
        BdLog.e(MyAudioRecorder.class.getName() + "start() called on illegal state");
        this.frk = State.ERROR;
    }

    public void stop() {
        BdLog.e(MyAudioRecorder.class.getName() + "audioRecorder.stop()");
        frh.stop();
        try {
            this.fqP.seek(4L);
            this.fqP.writeInt(Integer.reverseBytes(this.payloadSize + 36));
            this.fqP.seek(40L);
            this.fqP.writeInt(Integer.reverseBytes(this.payloadSize));
            this.fqP.close();
            BdLog.e(MyAudioRecorder.class.getName() + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
            this.frk = State.ERROR;
        }
        this.frk = State.STOPPED;
    }

    private short b(byte b, byte b2) {
        return (short) ((b2 << 8) | b);
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean BV(String str) {
        if (BX(str)) {
            return prepare();
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean bvK() {
        synchronized (mLock) {
            if (this.writeThread == null || !this.writeThread.isAlive()) {
                this.writeThread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.MyAudioRecorder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MyAudioRecorder.this.bvJ();
                    }
                });
                this.writeThread.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void bvL() {
        this.frk = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean isRecording() {
        return this.frk == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvJ() {
        if (frh != null) {
            try {
                start();
                while (isRecording()) {
                    frh.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.fqP.write(this.buffer);
                        this.payloadSize += this.buffer.length;
                        if (this.frn == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short b = b(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (b > this.frj) {
                                    this.frj = b;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.frj) {
                                    this.frj = this.buffer[i2];
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
