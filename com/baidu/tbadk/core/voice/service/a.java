package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements d {
    public static int aoZ = 8000;
    public static int apa = 2;
    public static int apb = 2;
    public static int apc = 1;
    private RandomAccessFile ape;
    private int apf;
    private short apg;
    private short aph;
    private int channelConfiguration;
    private int dataSize;
    private String filePath;
    private int frequency;
    private int apd = 0;
    private boolean mIsRecording = false;
    private AudioRecord mAudioRecord = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.apd = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.frequency = i2;
        this.channelConfiguration = i3;
        this.apf = i4;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
        }
        this.mAudioRecord = new AudioRecord(i, this.frequency, this.channelConfiguration, this.apf, this.apd);
        this.apg = (short) (this.channelConfiguration == 12 ? 2 : 1);
        this.aph = (short) (this.apf == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.ape != null) {
                try {
                    this.ape.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.ape = new RandomAccessFile(this.file, "rw");
                wY();
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
    public boolean eq(String str) {
        return a(apc, aoZ, apa, apb, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wV() {
        if (this.mAudioRecord != null && this.file != null) {
            try {
                this.mIsRecording = true;
                byte[] bArr = new byte[this.apd];
                this.mAudioRecord.startRecording();
                while (this.mIsRecording) {
                    this.mAudioRecord.read(bArr, 0, bArr.length);
                    this.ape.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.ape.seek(4L);
                this.ape.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.ape.seek(40L);
                this.ape.writeInt(Integer.reverseBytes(this.dataSize));
                this.ape.close();
                this.mAudioRecord.stop();
                this.mAudioRecord.release();
                this.mIsRecording = false;
            } catch (Throwable th) {
                if (this.file.exists()) {
                    this.file.delete();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean wW() {
        Thread thread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.wV();
            }
        });
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void wX() {
        this.mIsRecording = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean isRecording() {
        return this.mIsRecording;
    }

    private void wY() {
        try {
            this.ape.setLength(0L);
            this.ape.writeBytes("RIFF");
            this.ape.writeInt(0);
            this.ape.writeBytes("WAVE");
            this.ape.writeBytes("fmt ");
            this.ape.writeInt(Integer.reverseBytes(16));
            this.ape.writeShort(Short.reverseBytes((short) 1));
            this.ape.writeShort(Short.reverseBytes(this.apg));
            this.ape.writeInt(Integer.reverseBytes(this.frequency));
            this.ape.writeInt(Integer.reverseBytes(((this.frequency * this.apg) * this.aph) / 8));
            this.ape.writeShort(Short.reverseBytes((short) ((this.apg * this.aph) / 8)));
            this.ape.writeShort(Short.reverseBytes(this.aph));
            this.ape.writeBytes("data");
            this.ape.writeInt(0);
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
