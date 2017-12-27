package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import android.media.MediaRecorder;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class MyAudioRecorder implements d {
    private int bdU;
    private RandomAccessFile bdV;
    private Thread bek;
    private boolean bel;
    private int beo;
    private State bep;
    private short beq;
    private int ber;
    private short bes;
    private int beu;
    private int bev;
    private int bew;
    private byte[] buffer;
    private String filePath;
    private int payloadSize;
    private static final int[] bej = {44100, 22050, 11025, 8000};
    private static Object mLock = new Object();
    private static AudioRecord bem = null;
    private static MediaRecorder ben = null;

    /* loaded from: classes.dex */
    public enum State {
        INITIALIZING,
        READY,
        RECORDING,
        ERROR,
        STOPPED
    }

    public static MyAudioRecorder b(Boolean bool) {
        MyAudioRecorder myAudioRecorder;
        synchronized (mLock) {
            bem = null;
            ben = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, bej[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.EG() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, bej[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State EG() {
        return this.bep;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.beo = 0;
        this.filePath = null;
        try {
            this.bel = z;
            if (this.bel) {
                if (i4 == 2) {
                    this.bes = (short) 16;
                } else {
                    this.bes = (short) 8;
                }
                if (i3 == 2) {
                    this.beq = (short) 1;
                } else {
                    this.beq = (short) 2;
                }
                this.beu = i;
                this.ber = i2;
                this.bev = i4;
                this.bew = (i2 * 120) / 1000;
                this.bdU = (((this.bew * 2) * this.bes) * this.beq) / 8;
                if (this.bdU < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.bdU = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.bew = this.bdU / (((this.bes * 2) * this.beq) / 8);
                    BdLog.w(MyAudioRecorder.class.getName() + "Increasing buffer size to " + Integer.toString(this.bdU));
                }
                bem = new AudioRecord(i, i2, i3, i4, this.bdU);
                if (bem.getRecordingState() == 3) {
                    bem.stop();
                }
                if (bem.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                ben = new MediaRecorder();
                ben.setAudioSource(1);
                ben.setOutputFormat(1);
                ben.setAudioEncoder(1);
            }
            this.beo = 0;
            this.filePath = null;
            this.bep = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while initializing recording");
            }
            this.bep = State.ERROR;
        }
    }

    public boolean eL(String str) {
        try {
            if (this.bep == State.INITIALIZING) {
                this.filePath = str;
                if (!this.bel) {
                    ben.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while setting output path");
            }
            this.bep = State.ERROR;
            return false;
        }
    }

    public boolean prepare() {
        try {
            if (this.bep == State.INITIALIZING) {
                if (this.bel) {
                    if ((this.filePath != null) & (bem.getState() == 1)) {
                        if (this.bdV != null) {
                            this.bdV.close();
                            this.bdV = null;
                        }
                        this.bdV = new RandomAccessFile(this.filePath, "rw");
                        this.bdV.setLength(0L);
                        this.bdV.writeBytes("RIFF");
                        this.bdV.writeInt(0);
                        this.bdV.writeBytes("WAVE");
                        this.bdV.writeBytes("fmt ");
                        this.bdV.writeInt(Integer.reverseBytes(16));
                        this.bdV.writeShort(Short.reverseBytes((short) 1));
                        this.bdV.writeShort(Short.reverseBytes(this.beq));
                        this.bdV.writeInt(Integer.reverseBytes(this.ber));
                        this.bdV.writeInt(Integer.reverseBytes(((this.ber * this.bes) * this.beq) / 8));
                        this.bdV.writeShort(Short.reverseBytes((short) ((this.beq * this.bes) / 8)));
                        this.bdV.writeShort(Short.reverseBytes(this.bes));
                        this.bdV.writeBytes("data");
                        this.bdV.writeInt(0);
                        this.buffer = new byte[((this.bew * this.bes) / 8) * this.beq];
                        this.bep = State.READY;
                    } else {
                        BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on uninitialized recorder");
                        this.bep = State.ERROR;
                        return false;
                    }
                } else {
                    ben.prepare();
                    this.bep = State.READY;
                }
                return true;
            }
            BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on illegal state");
            release();
            this.bep = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured in prepare()");
            }
            this.bep = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.bep == State.RECORDING) {
            stop();
        } else {
            if ((this.bep == State.READY) & this.bel) {
                try {
                    this.bdV.close();
                } catch (IOException e) {
                    BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.bel) {
            if (bem != null) {
                bem.release();
            }
        } else if (ben != null) {
            ben.release();
        }
    }

    public void start() {
        if (this.bep == State.READY) {
            if (this.bel) {
                this.payloadSize = 0;
                bem.startRecording();
                bem.read(this.buffer, 0, this.buffer.length);
            } else {
                ben.start();
            }
            this.bep = State.RECORDING;
            return;
        }
        BdLog.e(MyAudioRecorder.class.getName() + "start() called on illegal state");
        this.bep = State.ERROR;
    }

    public void stop() {
        BdLog.e(MyAudioRecorder.class.getName() + "audioRecorder.stop()");
        bem.stop();
        try {
            this.bdV.seek(4L);
            this.bdV.writeInt(Integer.reverseBytes(this.payloadSize + 36));
            this.bdV.seek(40L);
            this.bdV.writeInt(Integer.reverseBytes(this.payloadSize));
            this.bdV.close();
            BdLog.e(MyAudioRecorder.class.getName() + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
            this.bep = State.ERROR;
        }
        this.bep = State.STOPPED;
    }

    private short b(byte b, byte b2) {
        return (short) ((b2 << 8) | b);
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean eJ(String str) {
        if (eL(str)) {
            return prepare();
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean EC() {
        synchronized (mLock) {
            if (this.bek == null || !this.bek.isAlive()) {
                this.bek = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.MyAudioRecorder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MyAudioRecorder.this.EB();
                    }
                });
                this.bek.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void ED() {
        this.bep = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean isRecording() {
        return this.bep == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EB() {
        if (bem != null) {
            try {
                start();
                while (isRecording()) {
                    bem.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.bdV.write(this.buffer);
                        this.payloadSize += this.buffer.length;
                        if (this.bes == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short b = b(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (b > this.beo) {
                                    this.beo = b;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.beo) {
                                    this.beo = this.buffer[i2];
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
