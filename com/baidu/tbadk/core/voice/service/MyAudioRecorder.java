package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import android.media.MediaRecorder;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.searchbox.ui.CoolPraiseGuideLottieView;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class MyAudioRecorder implements d {
    private byte[] buffer;
    private int bufferSize;
    private RandomAccessFile eoF;
    private boolean eoV;
    private int eoY;
    private State eoZ;
    private short epa;
    private int epb;
    private short epc;
    private int epd;
    private int epe;
    private int epf;
    private String filePath;
    private int payloadSize;
    private Thread writeThread;
    private static final int[] eoU = {44100, 22050, RequestResponseCode.REQUEST_LOGIN_PB_AT, CoolPraiseGuideLottieView.ANIM_DURATION};
    private static Object mLock = new Object();
    private static AudioRecord eoW = null;
    private static MediaRecorder eoX = null;

    /* loaded from: classes.dex */
    public enum State {
        INITIALIZING,
        READY,
        RECORDING,
        ERROR,
        STOPPED
    }

    public static MyAudioRecorder i(Boolean bool) {
        MyAudioRecorder myAudioRecorder;
        synchronized (mLock) {
            eoW = null;
            eoX = null;
            if (!bool.booleanValue()) {
                int i = 3;
                while (true) {
                    myAudioRecorder = new MyAudioRecorder(true, 1, eoU[i], 2, 2);
                    int i2 = i - 1;
                    if (!(myAudioRecorder.bdy() != State.INITIALIZING) || !(i2 >= 0)) {
                        break;
                    }
                    i = i2;
                }
            } else {
                myAudioRecorder = new MyAudioRecorder(false, 1, eoU[3], 2, 2);
            }
        }
        return myAudioRecorder;
    }

    public State bdy() {
        return this.eoZ;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        this.eoY = 0;
        this.filePath = null;
        try {
            this.eoV = z;
            if (this.eoV) {
                if (i4 == 2) {
                    this.epc = (short) 16;
                } else {
                    this.epc = (short) 8;
                }
                if (i3 == 2) {
                    this.epa = (short) 1;
                } else {
                    this.epa = (short) 2;
                }
                this.epd = i;
                this.epb = i2;
                this.epe = i4;
                this.epf = (i2 * 120) / 1000;
                this.bufferSize = (((this.epf * 2) * this.epc) * this.epa) / 8;
                if (this.bufferSize < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.epf = this.bufferSize / (((this.epc * 2) * this.epa) / 8);
                    BdLog.w(MyAudioRecorder.class.getName() + "Increasing buffer size to " + Integer.toString(this.bufferSize));
                }
                eoW = new AudioRecord(i, i2, i3, i4, this.bufferSize);
                if (eoW.getRecordingState() == 3) {
                    eoW.stop();
                }
                if (eoW.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                eoX = new MediaRecorder();
                eoX.setAudioSource(1);
                eoX.setOutputFormat(1);
                eoX.setAudioEncoder(1);
            }
            this.eoY = 0;
            this.filePath = null;
            this.eoZ = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while initializing recording");
            }
            this.eoZ = State.ERROR;
        }
    }

    public boolean yB(String str) {
        try {
            if (this.eoZ == State.INITIALIZING) {
                this.filePath = str;
                if (!this.eoV) {
                    eoX.setOutputFile(this.filePath);
                }
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while setting output path");
            }
            this.eoZ = State.ERROR;
            return false;
        }
    }

    public boolean prepare() {
        try {
            if (this.eoZ == State.INITIALIZING) {
                if (this.eoV) {
                    if ((this.filePath != null) & (eoW.getState() == 1)) {
                        if (this.eoF != null) {
                            this.eoF.close();
                            this.eoF = null;
                        }
                        this.eoF = new RandomAccessFile(this.filePath, "rw");
                        this.eoF.setLength(0L);
                        this.eoF.writeBytes("RIFF");
                        this.eoF.writeInt(0);
                        this.eoF.writeBytes("WAVE");
                        this.eoF.writeBytes("fmt ");
                        this.eoF.writeInt(Integer.reverseBytes(16));
                        this.eoF.writeShort(Short.reverseBytes((short) 1));
                        this.eoF.writeShort(Short.reverseBytes(this.epa));
                        this.eoF.writeInt(Integer.reverseBytes(this.epb));
                        this.eoF.writeInt(Integer.reverseBytes(((this.epb * this.epc) * this.epa) / 8));
                        this.eoF.writeShort(Short.reverseBytes((short) ((this.epa * this.epc) / 8)));
                        this.eoF.writeShort(Short.reverseBytes(this.epc));
                        this.eoF.writeBytes("data");
                        this.eoF.writeInt(0);
                        this.buffer = new byte[((this.epf * this.epc) / 8) * this.epa];
                        this.eoZ = State.READY;
                    } else {
                        BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on uninitialized recorder");
                        this.eoZ = State.ERROR;
                        return false;
                    }
                } else {
                    eoX.prepare();
                    this.eoZ = State.READY;
                }
                return true;
            }
            BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on illegal state");
            release();
            this.eoZ = State.ERROR;
            return false;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured in prepare()");
            }
            this.eoZ = State.ERROR;
            return false;
        }
    }

    public void release() {
        if (this.eoZ == State.RECORDING) {
            stop();
        } else {
            if ((this.eoZ == State.READY) & this.eoV) {
                try {
                    this.eoF.close();
                } catch (IOException e) {
                    BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
                }
                new File(this.filePath).delete();
            }
        }
        if (this.eoV) {
            if (eoW != null) {
                eoW.release();
            }
        } else if (eoX != null) {
            eoX.release();
        }
    }

    public void start() {
        if (this.eoZ == State.READY) {
            if (this.eoV) {
                this.payloadSize = 0;
                eoW.startRecording();
                eoW.read(this.buffer, 0, this.buffer.length);
            } else {
                eoX.start();
            }
            this.eoZ = State.RECORDING;
            return;
        }
        BdLog.e(MyAudioRecorder.class.getName() + "start() called on illegal state");
        this.eoZ = State.ERROR;
    }

    public void stop() {
        BdLog.e(MyAudioRecorder.class.getName() + "audioRecorder.stop()");
        eoW.stop();
        try {
            this.eoF.seek(4L);
            this.eoF.writeInt(Integer.reverseBytes(this.payloadSize + 36));
            this.eoF.seek(40L);
            this.eoF.writeInt(Integer.reverseBytes(this.payloadSize));
            this.eoF.close();
            BdLog.e(MyAudioRecorder.class.getName() + "randomAccessWriter.close()");
        } catch (IOException e) {
            BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
            this.eoZ = State.ERROR;
        }
        this.eoZ = State.STOPPED;
    }

    private short b(byte b, byte b2) {
        return (short) ((b2 << 8) | b);
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean yz(String str) {
        if (yB(str)) {
            return prepare();
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean bdu() {
        synchronized (mLock) {
            if (this.writeThread == null || !this.writeThread.isAlive()) {
                this.writeThread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.MyAudioRecorder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MyAudioRecorder.this.bdt();
                    }
                });
                this.writeThread.start();
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void bdv() {
        this.eoZ = State.STOPPED;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean bdw() {
        return this.eoZ == State.RECORDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdt() {
        if (eoW != null) {
            try {
                start();
                while (bdw()) {
                    eoW.read(this.buffer, 0, this.buffer.length);
                    try {
                        System.out.println(this.buffer);
                        this.eoF.write(this.buffer);
                        this.payloadSize += this.buffer.length;
                        if (this.epc == 16) {
                            for (int i = 0; i < this.buffer.length / 2; i++) {
                                short b = b(this.buffer[i * 2], this.buffer[(i * 2) + 1]);
                                if (b > this.eoY) {
                                    this.eoY = b;
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.buffer.length; i2++) {
                                if (this.buffer[i2] > this.eoY) {
                                    this.eoY = this.buffer[i2];
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
