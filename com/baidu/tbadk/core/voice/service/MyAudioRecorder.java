package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import android.media.MediaRecorder;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class MyAudioRecorder implements d {
    private int beA;
    private int beB;
    private int beC;
    private int bea;
    private RandomAccessFile beb;
    private Thread beq;
    private boolean ber;
    private int bev;
    private State bew;
    private short bex;
    private int bey;
    private short bez;
    private byte[] buffer;
    private String filePath;
    private int payloadSize;
    private static final int[] bep = {44100, 22050, 11025, 8000};
    private static Object mLock = new Object();
    private static AudioRecord bes = null;
    private static MediaRecorder beu = null;

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
            bes = null;
            beu = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, bep[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.Ex() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, bep[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State Ex() {
        return this.bew;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.bev = 0;
        this.filePath = null;
        try {
            this.ber = z;
            if (this.ber) {
                if (i4 == 2) {
                    this.bez = (short) 16;
                } else {
                    this.bez = (short) 8;
                }
                if (i3 == 2) {
                    this.bex = (short) 1;
                } else {
                    this.bex = (short) 2;
                }
                this.beA = i;
                this.bey = i2;
                this.beB = i4;
                this.beC = (i2 * 120) / 1000;
                this.bea = (((this.beC * 2) * this.bez) * this.bex) / 8;
                if (this.bea < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.bea = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.beC = this.bea / (((this.bez * 2) * this.bex) / 8);
                    BdLog.w(MyAudioRecorder.class.getName() + "Increasing buffer size to " + Integer.toString(this.bea));
                }
                bes = new AudioRecord(i, i2, i3, i4, this.bea);
                if (bes.getRecordingState() == 3) {
                    bes.stop();
                }
                if (bes.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                beu = new MediaRecorder();
                beu.setAudioSource(1);
                beu.setOutputFormat(1);
                beu.setAudioEncoder(1);
            }
            this.bev = 0;
            this.filePath = null;
            this.bew = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while initializing recording");
            }
            this.bew = State.ERROR;
        }
    }

    public boolean eL(String str) {
        try {
            if (this.bew == State.INITIALIZING) {
                this.filePath = str;
                if (!this.ber) {
                    beu.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while setting output path");
            }
            this.bew = State.ERROR;
            return false;
        }
    }

    public boolean prepare() {
        try {
            if (this.bew == State.INITIALIZING) {
                if (this.ber) {
                    if ((this.filePath != null) & (bes.getState() == 1)) {
                        if (this.beb != null) {
                            this.beb.close();
                            this.beb = null;
                        }
                        this.beb = new RandomAccessFile(this.filePath, "rw");
                        this.beb.setLength(0L);
                        this.beb.writeBytes("RIFF");
                        this.beb.writeInt(0);
                        this.beb.writeBytes("WAVE");
                        this.beb.writeBytes("fmt ");
                        this.beb.writeInt(Integer.reverseBytes(16));
                        this.beb.writeShort(Short.reverseBytes((short) 1));
                        this.beb.writeShort(Short.reverseBytes(this.bex));
                        this.beb.writeInt(Integer.reverseBytes(this.bey));
                        this.beb.writeInt(Integer.reverseBytes(((this.bey * this.bez) * this.bex) / 8));
                        this.beb.writeShort(Short.reverseBytes((short) ((this.bex * this.bez) / 8)));
                        this.beb.writeShort(Short.reverseBytes(this.bez));
                        this.beb.writeBytes("data");
                        this.beb.writeInt(0);
                        this.buffer = new byte[((this.beC * this.bez) / 8) * this.bex];
                        this.bew = State.READY;
                    } else {
                        BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on uninitialized recorder");
                        this.bew = State.ERROR;
                        return false;
                    }
                } else {
                    beu.prepare();
                    this.bew = State.READY;
                }
                return true;
            }
            BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on illegal state");
            release();
            this.bew = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured in prepare()");
            }
            this.bew = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.bew == State.RECORDING) {
            stop();
        } else {
            if ((this.bew == State.READY) & this.ber) {
                try {
                    this.beb.close();
                } catch (IOException e) {
                    BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.ber) {
            if (bes != null) {
                bes.release();
            }
        } else if (beu != null) {
            beu.release();
        }
    }

    public void start() {
        if (this.bew == State.READY) {
            if (this.ber) {
                this.payloadSize = 0;
                bes.startRecording();
                bes.read(this.buffer, 0, this.buffer.length);
            } else {
                beu.start();
            }
            this.bew = State.RECORDING;
            return;
        }
        BdLog.e(MyAudioRecorder.class.getName() + "start() called on illegal state");
        this.bew = State.ERROR;
    }

    public void stop() {
        BdLog.e(MyAudioRecorder.class.getName() + "audioRecorder.stop()");
        bes.stop();
        try {
            this.beb.seek(4L);
            this.beb.writeInt(Integer.reverseBytes(this.payloadSize + 36));
            this.beb.seek(40L);
            this.beb.writeInt(Integer.reverseBytes(this.payloadSize));
            this.beb.close();
            BdLog.e(MyAudioRecorder.class.getName() + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
            this.bew = State.ERROR;
        }
        this.bew = State.STOPPED;
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
    public boolean Et() {
        synchronized (mLock) {
            if (this.beq == null || !this.beq.isAlive()) {
                this.beq = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.MyAudioRecorder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MyAudioRecorder.this.Es();
                    }
                });
                this.beq.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void Eu() {
        this.bew = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean isRecording() {
        return this.bew == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Es() {
        if (bes != null) {
            try {
                start();
                while (isRecording()) {
                    bes.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.beb.write(this.buffer);
                        this.payloadSize += this.buffer.length;
                        if (this.bez == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short b = b(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (b > this.bev) {
                                    this.bev = b;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.bev) {
                                    this.bev = this.buffer[i2];
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
