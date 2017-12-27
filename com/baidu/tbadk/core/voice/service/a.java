package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements d {
    public static int bdQ = 8000;
    public static int bdR = 2;
    public static int bdS = 2;
    public static int bdT = 1;
    private RandomAccessFile bdV;
    private int bdW;
    private short bdX;
    private short bdY;
    private int channelConfiguration;
    private int dataSize;
    private String filePath;
    private int frequency;
    private int bdU = 0;
    private boolean axQ = false;
    private AudioRecord mAudioRecord = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.bdU = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.frequency = i2;
        this.channelConfiguration = i3;
        this.bdW = i4;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
        }
        this.mAudioRecord = new AudioRecord(i, this.frequency, this.channelConfiguration, this.bdW, this.bdU);
        this.bdX = (short) (this.channelConfiguration == 12 ? 2 : 1);
        this.bdY = (short) (this.bdW == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.bdV != null) {
                try {
                    this.bdV.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.bdV = new RandomAccessFile(this.file, "rw");
                EE();
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
        return a(bdT, bdQ, bdR, bdS, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EB() {
        if (this.mAudioRecord != null && this.file != null) {
            try {
                this.axQ = true;
                byte[] bArr = new byte[this.bdU];
                this.mAudioRecord.startRecording();
                while (this.axQ) {
                    this.mAudioRecord.read(bArr, 0, bArr.length);
                    this.bdV.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.bdV.seek(4L);
                this.bdV.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.bdV.seek(40L);
                this.bdV.writeInt(Integer.reverseBytes(this.dataSize));
                this.bdV.close();
                this.mAudioRecord.stop();
                this.mAudioRecord.release();
                this.axQ = false;
            } catch (Throwable th) {
                if (this.file.exists()) {
                    this.file.delete();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean EC() {
        Thread thread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.EB();
            }
        });
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void ED() {
        this.axQ = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean isRecording() {
        return this.axQ;
    }

    private void EE() {
        try {
            this.bdV.setLength(0L);
            this.bdV.writeBytes("RIFF");
            this.bdV.writeInt(0);
            this.bdV.writeBytes("WAVE");
            this.bdV.writeBytes("fmt ");
            this.bdV.writeInt(Integer.reverseBytes(16));
            this.bdV.writeShort(Short.reverseBytes((short) 1));
            this.bdV.writeShort(Short.reverseBytes(this.bdX));
            this.bdV.writeInt(Integer.reverseBytes(this.frequency));
            this.bdV.writeInt(Integer.reverseBytes(((this.frequency * this.bdX) * this.bdY) / 8));
            this.bdV.writeShort(Short.reverseBytes((short) ((this.bdX * this.bdY) / 8)));
            this.bdV.writeShort(Short.reverseBytes(this.bdY));
            this.bdV.writeBytes("data");
            this.bdV.writeInt(0);
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
