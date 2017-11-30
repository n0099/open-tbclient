package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements d {
    public static int apM = 8000;
    public static int apN = 2;
    public static int apO = 2;
    public static int apP = 1;
    private RandomAccessFile apR;
    private int apS;
    private short apT;
    private short apU;
    private int channelConfiguration;
    private int dataSize;
    private String filePath;
    private int frequency;
    private int apQ = 0;
    private boolean mIsRecording = false;
    private AudioRecord mAudioRecord = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.apQ = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.frequency = i2;
        this.channelConfiguration = i3;
        this.apS = i4;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
        }
        this.mAudioRecord = new AudioRecord(i, this.frequency, this.channelConfiguration, this.apS, this.apQ);
        this.apT = (short) (this.channelConfiguration == 12 ? 2 : 1);
        this.apU = (short) (this.apS == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.apR != null) {
                try {
                    this.apR.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.apR = new RandomAccessFile(this.file, "rw");
                xg();
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
    public boolean eC(String str) {
        return a(apP, apM, apN, apO, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xd() {
        if (this.mAudioRecord != null && this.file != null) {
            try {
                this.mIsRecording = true;
                byte[] bArr = new byte[this.apQ];
                this.mAudioRecord.startRecording();
                while (this.mIsRecording) {
                    this.mAudioRecord.read(bArr, 0, bArr.length);
                    this.apR.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.apR.seek(4L);
                this.apR.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.apR.seek(40L);
                this.apR.writeInt(Integer.reverseBytes(this.dataSize));
                this.apR.close();
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
    public boolean xe() {
        Thread thread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.xd();
            }
        });
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void xf() {
        this.mIsRecording = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean isRecording() {
        return this.mIsRecording;
    }

    private void xg() {
        try {
            this.apR.setLength(0L);
            this.apR.writeBytes("RIFF");
            this.apR.writeInt(0);
            this.apR.writeBytes("WAVE");
            this.apR.writeBytes("fmt ");
            this.apR.writeInt(Integer.reverseBytes(16));
            this.apR.writeShort(Short.reverseBytes((short) 1));
            this.apR.writeShort(Short.reverseBytes(this.apT));
            this.apR.writeInt(Integer.reverseBytes(this.frequency));
            this.apR.writeInt(Integer.reverseBytes(((this.frequency * this.apT) * this.apU) / 8));
            this.apR.writeShort(Short.reverseBytes((short) ((this.apT * this.apU) / 8)));
            this.apR.writeShort(Short.reverseBytes(this.apU));
            this.apR.writeBytes("data");
            this.apR.writeInt(0);
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
