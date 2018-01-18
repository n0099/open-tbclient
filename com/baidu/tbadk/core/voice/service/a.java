package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements d {
    public static int bdW = 8000;
    public static int bdX = 2;
    public static int bdY = 2;
    public static int bdZ = 1;
    private RandomAccessFile beb;
    private int bec;
    private short bed;
    private short bee;
    private int channelConfiguration;
    private int dataSize;
    private String filePath;
    private int frequency;
    private int bea = 0;
    private boolean axP = false;
    private AudioRecord mAudioRecord = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.bea = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.frequency = i2;
        this.channelConfiguration = i3;
        this.bec = i4;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
        }
        this.mAudioRecord = new AudioRecord(i, this.frequency, this.channelConfiguration, this.bec, this.bea);
        this.bed = (short) (this.channelConfiguration == 12 ? 2 : 1);
        this.bee = (short) (this.bec == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.beb != null) {
                try {
                    this.beb.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.beb = new RandomAccessFile(this.file, "rw");
                Ev();
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
    public boolean eJ(String str) {
        return a(bdZ, bdW, bdX, bdY, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Es() {
        if (this.mAudioRecord != null && this.file != null) {
            try {
                this.axP = true;
                byte[] bArr = new byte[this.bea];
                this.mAudioRecord.startRecording();
                while (this.axP) {
                    this.mAudioRecord.read(bArr, 0, bArr.length);
                    this.beb.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.beb.seek(4L);
                this.beb.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.beb.seek(40L);
                this.beb.writeInt(Integer.reverseBytes(this.dataSize));
                this.beb.close();
                this.mAudioRecord.stop();
                this.mAudioRecord.release();
                this.axP = false;
            } catch (Throwable th) {
                if (this.file.exists()) {
                    this.file.delete();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean Et() {
        Thread thread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.Es();
            }
        });
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void Eu() {
        this.axP = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean isRecording() {
        return this.axP;
    }

    private void Ev() {
        try {
            this.beb.setLength(0L);
            this.beb.writeBytes("RIFF");
            this.beb.writeInt(0);
            this.beb.writeBytes("WAVE");
            this.beb.writeBytes("fmt ");
            this.beb.writeInt(Integer.reverseBytes(16));
            this.beb.writeShort(Short.reverseBytes((short) 1));
            this.beb.writeShort(Short.reverseBytes(this.bed));
            this.beb.writeInt(Integer.reverseBytes(this.frequency));
            this.beb.writeInt(Integer.reverseBytes(((this.frequency * this.bed) * this.bee) / 8));
            this.beb.writeShort(Short.reverseBytes((short) ((this.bed * this.bee) / 8)));
            this.beb.writeShort(Short.reverseBytes(this.bee));
            this.beb.writeBytes("data");
            this.beb.writeInt(0);
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
