package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements d {
    public static int azB = 8000;
    public static int azC = 2;
    public static int azD = 2;
    public static int azE = 1;
    private RandomAccessFile azF;
    private int azG;
    private short azH;
    private short azI;
    private int channelConfiguration;
    private int dataSize;
    private String filePath;
    private int frequency;
    private int bufferSize = 0;
    private boolean Qj = false;
    private AudioRecord mAudioRecord = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.frequency = i2;
        this.channelConfiguration = i3;
        this.azG = i4;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
        }
        this.mAudioRecord = new AudioRecord(i, this.frequency, this.channelConfiguration, this.azG, this.bufferSize);
        this.azH = (short) (this.channelConfiguration == 12 ? 2 : 1);
        this.azI = (short) (this.azG == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.azF != null) {
                try {
                    this.azF.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.azF = new RandomAccessFile(this.file, "rw");
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
    public boolean fs(String str) {
        return a(azE, azB, azC, azD, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bd() {
        if (this.mAudioRecord != null && this.file != null) {
            try {
                this.Qj = true;
                byte[] bArr = new byte[this.bufferSize];
                this.mAudioRecord.startRecording();
                while (this.Qj) {
                    this.mAudioRecord.read(bArr, 0, bArr.length);
                    this.azF.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.azF.seek(4L);
                this.azF.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.azF.seek(40L);
                this.azF.writeInt(Integer.reverseBytes(this.dataSize));
                this.azF.close();
                this.mAudioRecord.stop();
                this.mAudioRecord.release();
                this.Qj = false;
            } catch (Throwable th) {
                if (this.file.exists()) {
                    this.file.delete();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean Be() {
        Thread thread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.Bd();
            }
        });
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void Bf() {
        this.Qj = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean isRecording() {
        return this.Qj;
    }

    private void writeHeader() {
        try {
            this.azF.setLength(0L);
            this.azF.writeBytes("RIFF");
            this.azF.writeInt(0);
            this.azF.writeBytes("WAVE");
            this.azF.writeBytes("fmt ");
            this.azF.writeInt(Integer.reverseBytes(16));
            this.azF.writeShort(Short.reverseBytes((short) 1));
            this.azF.writeShort(Short.reverseBytes(this.azH));
            this.azF.writeInt(Integer.reverseBytes(this.frequency));
            this.azF.writeInt(Integer.reverseBytes(((this.frequency * this.azH) * this.azI) / 8));
            this.azF.writeShort(Short.reverseBytes((short) ((this.azH * this.azI) / 8)));
            this.azF.writeShort(Short.reverseBytes(this.azI));
            this.azF.writeBytes("data");
            this.azF.writeInt(0);
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
