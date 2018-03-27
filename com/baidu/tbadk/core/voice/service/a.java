package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements d {
    public static int bfO = 8000;
    public static int bfP = 2;
    public static int bfQ = 2;
    public static int bfR = 1;
    private RandomAccessFile bfT;
    private int bfU;
    private short bfV;
    private short bfW;
    private int channelConfiguration;
    private int dataSize;
    private String filePath;
    private int frequency;
    private int bfS = 0;
    private boolean axJ = false;
    private AudioRecord mAudioRecord = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.bfS = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.frequency = i2;
        this.channelConfiguration = i3;
        this.bfU = i4;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
        }
        this.mAudioRecord = new AudioRecord(i, this.frequency, this.channelConfiguration, this.bfU, this.bfS);
        this.bfV = (short) (this.channelConfiguration == 12 ? 2 : 1);
        this.bfW = (short) (this.bfU == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.bfT != null) {
                try {
                    this.bfT.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.bfT = new RandomAccessFile(this.file, "rw");
                ES();
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
    public boolean fc(String str) {
        return a(bfR, bfO, bfP, bfQ, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EP() {
        if (this.mAudioRecord != null && this.file != null) {
            try {
                this.axJ = true;
                byte[] bArr = new byte[this.bfS];
                this.mAudioRecord.startRecording();
                while (this.axJ) {
                    this.mAudioRecord.read(bArr, 0, bArr.length);
                    this.bfT.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.bfT.seek(4L);
                this.bfT.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.bfT.seek(40L);
                this.bfT.writeInt(Integer.reverseBytes(this.dataSize));
                this.bfT.close();
                this.mAudioRecord.stop();
                this.mAudioRecord.release();
                this.axJ = false;
            } catch (Throwable th) {
                if (this.file.exists()) {
                    this.file.delete();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean EQ() {
        Thread thread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.EP();
            }
        });
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void ER() {
        this.axJ = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean isRecording() {
        return this.axJ;
    }

    private void ES() {
        try {
            this.bfT.setLength(0L);
            this.bfT.writeBytes("RIFF");
            this.bfT.writeInt(0);
            this.bfT.writeBytes("WAVE");
            this.bfT.writeBytes("fmt ");
            this.bfT.writeInt(Integer.reverseBytes(16));
            this.bfT.writeShort(Short.reverseBytes((short) 1));
            this.bfT.writeShort(Short.reverseBytes(this.bfV));
            this.bfT.writeInt(Integer.reverseBytes(this.frequency));
            this.bfT.writeInt(Integer.reverseBytes(((this.frequency * this.bfV) * this.bfW) / 8));
            this.bfT.writeShort(Short.reverseBytes((short) ((this.bfV * this.bfW) / 8)));
            this.bfT.writeShort(Short.reverseBytes(this.bfW));
            this.bfT.writeBytes("data");
            this.bfT.writeInt(0);
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
