package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements d {
    public static int dgJ = 8000;
    public static int dgK = 2;
    public static int dgL = 2;
    public static int dgM = 1;
    private int channelConfiguration;
    private int dataSize;
    private RandomAccessFile dgN;
    private int dgO;
    private int dgP;
    private short dgQ;
    private short dgR;
    private String filePath;
    private int bufferSize = 0;
    private boolean Fx = false;
    private AudioRecord mAudioRecord = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.dgO = i2;
        this.channelConfiguration = i3;
        this.dgP = i4;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
        }
        this.mAudioRecord = new AudioRecord(i, this.dgO, this.channelConfiguration, this.dgP, this.bufferSize);
        this.dgQ = (short) (this.channelConfiguration == 12 ? 2 : 1);
        this.dgR = (short) (this.dgP == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.dgN != null) {
                try {
                    this.dgN.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.dgN = new RandomAccessFile(this.file, "rw");
                writeHeader();
                setFilePath(this.file.getParent());
                return true;
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
                return false;
            }
        } catch (IOException e3) {
            this.file = null;
            return false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean tN(String str) {
        return a(dgM, dgJ, dgK, dgL, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGt() {
        if (this.mAudioRecord != null && this.file != null) {
            try {
                this.Fx = true;
                byte[] bArr = new byte[this.bufferSize];
                this.mAudioRecord.startRecording();
                while (this.Fx) {
                    this.mAudioRecord.read(bArr, 0, bArr.length);
                    this.dgN.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.dgN.seek(4L);
                this.dgN.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.dgN.seek(40L);
                this.dgN.writeInt(Integer.reverseBytes(this.dataSize));
                this.dgN.close();
                this.mAudioRecord.stop();
                this.mAudioRecord.release();
                this.Fx = false;
            } catch (Throwable th) {
                if (this.file.exists()) {
                    this.file.delete();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean aGu() {
        Thread thread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.aGt();
            }
        });
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void aGv() {
        this.Fx = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean isRecording() {
        return this.Fx;
    }

    private void writeHeader() {
        try {
            this.dgN.setLength(0L);
            this.dgN.writeBytes("RIFF");
            this.dgN.writeInt(0);
            this.dgN.writeBytes("WAVE");
            this.dgN.writeBytes("fmt ");
            this.dgN.writeInt(Integer.reverseBytes(16));
            this.dgN.writeShort(Short.reverseBytes((short) 1));
            this.dgN.writeShort(Short.reverseBytes(this.dgQ));
            this.dgN.writeInt(Integer.reverseBytes(this.dgO));
            this.dgN.writeInt(Integer.reverseBytes(((this.dgO * this.dgQ) * this.dgR) / 8));
            this.dgN.writeShort(Short.reverseBytes((short) ((this.dgQ * this.dgR) / 8)));
            this.dgN.writeShort(Short.reverseBytes(this.dgR));
            this.dgN.writeBytes("data");
            this.dgN.writeInt(0);
        } catch (IOException e) {
            if (this.file.exists()) {
                this.file.delete();
            }
            e.printStackTrace();
        }
    }

    public void setFilePath(String str) {
        this.filePath = str;
    }
}
