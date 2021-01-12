package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements d {
    public static int fmT = 8000;
    public static int fmU = 2;
    public static int fmV = 2;
    public static int fmW = 1;
    private int channelConfiguration;
    private int dataSize;
    private String filePath;
    private RandomAccessFile fmX;
    private int fmY;
    private int fmZ;
    private short fna;
    private short fnb;
    private int bufferSize = 0;
    private boolean acZ = false;
    private AudioRecord mAudioRecord = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.fmY = i2;
        this.channelConfiguration = i3;
        this.fmZ = i4;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
        }
        this.mAudioRecord = new AudioRecord(i, this.fmY, this.channelConfiguration, this.fmZ, this.bufferSize);
        this.fna = (short) (this.channelConfiguration == 12 ? 2 : 1);
        this.fnb = (short) (this.fmZ == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.fmX != null) {
                try {
                    this.fmX.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.fmX = new RandomAccessFile(this.file, "rw");
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
    public boolean Bx(String str) {
        return a(fmW, fmT, fmU, fmV, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvm() {
        if (this.mAudioRecord != null && this.file != null) {
            try {
                this.acZ = true;
                byte[] bArr = new byte[this.bufferSize];
                this.mAudioRecord.startRecording();
                while (this.acZ) {
                    this.mAudioRecord.read(bArr, 0, bArr.length);
                    this.fmX.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.fmX.seek(4L);
                this.fmX.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.fmX.seek(40L);
                this.fmX.writeInt(Integer.reverseBytes(this.dataSize));
                this.fmX.close();
                this.mAudioRecord.stop();
                this.mAudioRecord.release();
                this.acZ = false;
            } catch (Throwable th) {
                if (this.file.exists()) {
                    this.file.delete();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean bvn() {
        Thread thread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.bvm();
            }
        });
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void bvo() {
        this.acZ = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean bvp() {
        return this.acZ;
    }

    private void writeHeader() {
        try {
            this.fmX.setLength(0L);
            this.fmX.writeBytes("RIFF");
            this.fmX.writeInt(0);
            this.fmX.writeBytes("WAVE");
            this.fmX.writeBytes("fmt ");
            this.fmX.writeInt(Integer.reverseBytes(16));
            this.fmX.writeShort(Short.reverseBytes((short) 1));
            this.fmX.writeShort(Short.reverseBytes(this.fna));
            this.fmX.writeInt(Integer.reverseBytes(this.fmY));
            this.fmX.writeInt(Integer.reverseBytes(((this.fmY * this.fna) * this.fnb) / 8));
            this.fmX.writeShort(Short.reverseBytes((short) ((this.fna * this.fnb) / 8)));
            this.fmX.writeShort(Short.reverseBytes(this.fnb));
            this.fmX.writeBytes("data");
            this.fmX.writeInt(0);
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
