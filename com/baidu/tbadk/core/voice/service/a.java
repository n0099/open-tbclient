package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements d {
    public static int bVr = 8000;
    public static int bVs = 2;
    public static int bVt = 2;
    public static int bVu = 1;
    private RandomAccessFile bVv;
    private int bVw;
    private short bVx;
    private short bVy;
    private int channelConfiguration;
    private int dataSize;
    private String filePath;
    private int frequency;
    private int bufferSize = 0;
    private boolean VQ = false;
    private AudioRecord mAudioRecord = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.frequency = i2;
        this.channelConfiguration = i3;
        this.bVw = i4;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
        }
        this.mAudioRecord = new AudioRecord(i, this.frequency, this.channelConfiguration, this.bVw, this.bufferSize);
        this.bVx = (short) (this.channelConfiguration == 12 ? 2 : 1);
        this.bVy = (short) (this.bVw == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.bVv != null) {
                try {
                    this.bVv.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.bVv = new RandomAccessFile(this.file, "rw");
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
    public boolean ny(String str) {
        return a(bVu, bVr, bVs, bVt, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aft() {
        if (this.mAudioRecord != null && this.file != null) {
            try {
                this.VQ = true;
                byte[] bArr = new byte[this.bufferSize];
                this.mAudioRecord.startRecording();
                while (this.VQ) {
                    this.mAudioRecord.read(bArr, 0, bArr.length);
                    this.bVv.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.bVv.seek(4L);
                this.bVv.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.bVv.seek(40L);
                this.bVv.writeInt(Integer.reverseBytes(this.dataSize));
                this.bVv.close();
                this.mAudioRecord.stop();
                this.mAudioRecord.release();
                this.VQ = false;
            } catch (Throwable th) {
                if (this.file.exists()) {
                    this.file.delete();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean afu() {
        Thread thread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.aft();
            }
        });
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void afv() {
        this.VQ = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean afw() {
        return this.VQ;
    }

    private void writeHeader() {
        try {
            this.bVv.setLength(0L);
            this.bVv.writeBytes("RIFF");
            this.bVv.writeInt(0);
            this.bVv.writeBytes("WAVE");
            this.bVv.writeBytes("fmt ");
            this.bVv.writeInt(Integer.reverseBytes(16));
            this.bVv.writeShort(Short.reverseBytes((short) 1));
            this.bVv.writeShort(Short.reverseBytes(this.bVx));
            this.bVv.writeInt(Integer.reverseBytes(this.frequency));
            this.bVv.writeInt(Integer.reverseBytes(((this.frequency * this.bVx) * this.bVy) / 8));
            this.bVv.writeShort(Short.reverseBytes((short) ((this.bVx * this.bVy) / 8)));
            this.bVv.writeShort(Short.reverseBytes(this.bVy));
            this.bVv.writeBytes("data");
            this.bVv.writeInt(0);
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
