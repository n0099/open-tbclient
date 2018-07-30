package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements d {
    public static int aAm = 8000;
    public static int aAn = 2;
    public static int aAo = 2;
    public static int aAp = 1;
    private RandomAccessFile aAr;
    private int aAs;
    private short aAt;
    private short aAu;
    private int channelConfiguration;
    private int dataSize;
    private String filePath;
    private int frequency;
    private int aAq = 0;
    private boolean Qi = false;
    private AudioRecord mAudioRecord = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.aAq = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.frequency = i2;
        this.channelConfiguration = i3;
        this.aAs = i4;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
        }
        this.mAudioRecord = new AudioRecord(i, this.frequency, this.channelConfiguration, this.aAs, this.aAq);
        this.aAt = (short) (this.channelConfiguration == 12 ? 2 : 1);
        this.aAu = (short) (this.aAs == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.aAr != null) {
                try {
                    this.aAr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.aAr = new RandomAccessFile(this.file, "rw");
                Bp();
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
    public boolean fu(String str) {
        return a(aAp, aAm, aAn, aAo, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bm() {
        if (this.mAudioRecord != null && this.file != null) {
            try {
                this.Qi = true;
                byte[] bArr = new byte[this.aAq];
                this.mAudioRecord.startRecording();
                while (this.Qi) {
                    this.mAudioRecord.read(bArr, 0, bArr.length);
                    this.aAr.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.aAr.seek(4L);
                this.aAr.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.aAr.seek(40L);
                this.aAr.writeInt(Integer.reverseBytes(this.dataSize));
                this.aAr.close();
                this.mAudioRecord.stop();
                this.mAudioRecord.release();
                this.Qi = false;
            } catch (Throwable th) {
                if (this.file.exists()) {
                    this.file.delete();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean Bn() {
        Thread thread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.Bm();
            }
        });
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void Bo() {
        this.Qi = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean isRecording() {
        return this.Qi;
    }

    private void Bp() {
        try {
            this.aAr.setLength(0L);
            this.aAr.writeBytes("RIFF");
            this.aAr.writeInt(0);
            this.aAr.writeBytes("WAVE");
            this.aAr.writeBytes("fmt ");
            this.aAr.writeInt(Integer.reverseBytes(16));
            this.aAr.writeShort(Short.reverseBytes((short) 1));
            this.aAr.writeShort(Short.reverseBytes(this.aAt));
            this.aAr.writeInt(Integer.reverseBytes(this.frequency));
            this.aAr.writeInt(Integer.reverseBytes(((this.frequency * this.aAt) * this.aAu) / 8));
            this.aAr.writeShort(Short.reverseBytes((short) ((this.aAt * this.aAu) / 8)));
            this.aAr.writeShort(Short.reverseBytes(this.aAu));
            this.aAr.writeBytes("data");
            this.aAr.writeInt(0);
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
