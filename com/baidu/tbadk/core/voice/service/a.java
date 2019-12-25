package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements d {
    private int channelConfiguration;
    private int dataSize;
    private RandomAccessFile dgB;
    private int dgC;
    private int dgD;
    private short dgE;
    private short dgF;
    private String filePath;
    public static int dgx = 8000;
    public static int dgy = 2;
    public static int dgz = 2;
    public static int dgA = 1;
    private int bufferSize = 0;
    private boolean Fs = false;
    private AudioRecord mAudioRecord = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.dgC = i2;
        this.channelConfiguration = i3;
        this.dgD = i4;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
        }
        this.mAudioRecord = new AudioRecord(i, this.dgC, this.channelConfiguration, this.dgD, this.bufferSize);
        this.dgE = (short) (this.channelConfiguration == 12 ? 2 : 1);
        this.dgF = (short) (this.dgD == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.dgB != null) {
                try {
                    this.dgB.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.dgB = new RandomAccessFile(this.file, "rw");
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
    public boolean tJ(String str) {
        return a(dgA, dgx, dgy, dgz, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGa() {
        if (this.mAudioRecord != null && this.file != null) {
            try {
                this.Fs = true;
                byte[] bArr = new byte[this.bufferSize];
                this.mAudioRecord.startRecording();
                while (this.Fs) {
                    this.mAudioRecord.read(bArr, 0, bArr.length);
                    this.dgB.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.dgB.seek(4L);
                this.dgB.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.dgB.seek(40L);
                this.dgB.writeInt(Integer.reverseBytes(this.dataSize));
                this.dgB.close();
                this.mAudioRecord.stop();
                this.mAudioRecord.release();
                this.Fs = false;
            } catch (Throwable th) {
                if (this.file.exists()) {
                    this.file.delete();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean aGb() {
        Thread thread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.aGa();
            }
        });
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void aGc() {
        this.Fs = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean isRecording() {
        return this.Fs;
    }

    private void writeHeader() {
        try {
            this.dgB.setLength(0L);
            this.dgB.writeBytes("RIFF");
            this.dgB.writeInt(0);
            this.dgB.writeBytes("WAVE");
            this.dgB.writeBytes("fmt ");
            this.dgB.writeInt(Integer.reverseBytes(16));
            this.dgB.writeShort(Short.reverseBytes((short) 1));
            this.dgB.writeShort(Short.reverseBytes(this.dgE));
            this.dgB.writeInt(Integer.reverseBytes(this.dgC));
            this.dgB.writeInt(Integer.reverseBytes(((this.dgC * this.dgE) * this.dgF) / 8));
            this.dgB.writeShort(Short.reverseBytes((short) ((this.dgE * this.dgF) / 8)));
            this.dgB.writeShort(Short.reverseBytes(this.dgF));
            this.dgB.writeBytes("data");
            this.dgB.writeInt(0);
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
