package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements d {
    public static int aAj = 8000;
    public static int aAk = 2;
    public static int aAl = 2;
    public static int aAm = 1;
    private RandomAccessFile aAo;
    private int aAp;
    private short aAq;
    private short aAr;
    private int channelConfiguration;
    private int dataSize;
    private String filePath;
    private int frequency;
    private int aAn = 0;
    private boolean Qi = false;
    private AudioRecord mAudioRecord = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.aAn = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.frequency = i2;
        this.channelConfiguration = i3;
        this.aAp = i4;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
        }
        this.mAudioRecord = new AudioRecord(i, this.frequency, this.channelConfiguration, this.aAp, this.aAn);
        this.aAq = (short) (this.channelConfiguration == 12 ? 2 : 1);
        this.aAr = (short) (this.aAp == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.aAo != null) {
                try {
                    this.aAo.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.aAo = new RandomAccessFile(this.file, "rw");
                Bm();
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
        return a(aAm, aAj, aAk, aAl, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bj() {
        if (this.mAudioRecord != null && this.file != null) {
            try {
                this.Qi = true;
                byte[] bArr = new byte[this.aAn];
                this.mAudioRecord.startRecording();
                while (this.Qi) {
                    this.mAudioRecord.read(bArr, 0, bArr.length);
                    this.aAo.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.aAo.seek(4L);
                this.aAo.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.aAo.seek(40L);
                this.aAo.writeInt(Integer.reverseBytes(this.dataSize));
                this.aAo.close();
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
    public boolean Bk() {
        Thread thread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.Bj();
            }
        });
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void Bl() {
        this.Qi = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean isRecording() {
        return this.Qi;
    }

    private void Bm() {
        try {
            this.aAo.setLength(0L);
            this.aAo.writeBytes("RIFF");
            this.aAo.writeInt(0);
            this.aAo.writeBytes("WAVE");
            this.aAo.writeBytes("fmt ");
            this.aAo.writeInt(Integer.reverseBytes(16));
            this.aAo.writeShort(Short.reverseBytes((short) 1));
            this.aAo.writeShort(Short.reverseBytes(this.aAq));
            this.aAo.writeInt(Integer.reverseBytes(this.frequency));
            this.aAo.writeInt(Integer.reverseBytes(((this.frequency * this.aAq) * this.aAr) / 8));
            this.aAo.writeShort(Short.reverseBytes((short) ((this.aAq * this.aAr) / 8)));
            this.aAo.writeShort(Short.reverseBytes(this.aAr));
            this.aAo.writeBytes("data");
            this.aAo.writeInt(0);
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
