package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements d {
    public static int aMN = 8000;
    public static int aMO = 2;
    public static int aMP = 2;
    public static int aMQ = 1;
    private RandomAccessFile aMR;
    private int aMS;
    private short aMT;
    private short aMU;
    private int channelConfiguration;
    private int dataSize;
    private String filePath;
    private int frequency;
    private int bufferSize = 0;
    private boolean Tl = false;
    private AudioRecord mAudioRecord = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.frequency = i2;
        this.channelConfiguration = i3;
        this.aMS = i4;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
        }
        this.mAudioRecord = new AudioRecord(i, this.frequency, this.channelConfiguration, this.aMS, this.bufferSize);
        this.aMT = (short) (this.channelConfiguration == 12 ? 2 : 1);
        this.aMU = (short) (this.aMS == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.aMR != null) {
                try {
                    this.aMR.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.aMR = new RandomAccessFile(this.file, "rw");
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
    public boolean gL(String str) {
        return a(aMQ, aMN, aMO, aMP, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gc() {
        if (this.mAudioRecord != null && this.file != null) {
            try {
                this.Tl = true;
                byte[] bArr = new byte[this.bufferSize];
                this.mAudioRecord.startRecording();
                while (this.Tl) {
                    this.mAudioRecord.read(bArr, 0, bArr.length);
                    this.aMR.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.aMR.seek(4L);
                this.aMR.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.aMR.seek(40L);
                this.aMR.writeInt(Integer.reverseBytes(this.dataSize));
                this.aMR.close();
                this.mAudioRecord.stop();
                this.mAudioRecord.release();
                this.Tl = false;
            } catch (Throwable th) {
                if (this.file.exists()) {
                    this.file.delete();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean Gd() {
        Thread thread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.Gc();
            }
        });
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void Ge() {
        this.Tl = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean Gf() {
        return this.Tl;
    }

    private void writeHeader() {
        try {
            this.aMR.setLength(0L);
            this.aMR.writeBytes("RIFF");
            this.aMR.writeInt(0);
            this.aMR.writeBytes("WAVE");
            this.aMR.writeBytes("fmt ");
            this.aMR.writeInt(Integer.reverseBytes(16));
            this.aMR.writeShort(Short.reverseBytes((short) 1));
            this.aMR.writeShort(Short.reverseBytes(this.aMT));
            this.aMR.writeInt(Integer.reverseBytes(this.frequency));
            this.aMR.writeInt(Integer.reverseBytes(((this.frequency * this.aMT) * this.aMU) / 8));
            this.aMR.writeShort(Short.reverseBytes((short) ((this.aMT * this.aMU) / 8)));
            this.aMR.writeShort(Short.reverseBytes(this.aMU));
            this.aMR.writeBytes("data");
            this.aMR.writeInt(0);
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
