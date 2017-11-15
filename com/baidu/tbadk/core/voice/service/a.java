package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements d {
    public static int apu = 8000;
    public static int apv = 2;
    public static int apw = 2;
    public static int apx = 1;
    private int apA;
    private short apB;
    private short apC;
    private RandomAccessFile apz;
    private int channelConfiguration;
    private int dataSize;
    private String filePath;
    private int frequency;
    private int apy = 0;
    private boolean mIsRecording = false;
    private AudioRecord mAudioRecord = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.apy = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.frequency = i2;
        this.channelConfiguration = i3;
        this.apA = i4;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
        }
        this.mAudioRecord = new AudioRecord(i, this.frequency, this.channelConfiguration, this.apA, this.apy);
        this.apB = (short) (this.channelConfiguration == 12 ? 2 : 1);
        this.apC = (short) (this.apA == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.apz != null) {
                try {
                    this.apz.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.apz = new RandomAccessFile(this.file, "rw");
                xf();
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
    public boolean ex(String str) {
        return a(apx, apu, apv, apw, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xc() {
        if (this.mAudioRecord != null && this.file != null) {
            try {
                this.mIsRecording = true;
                byte[] bArr = new byte[this.apy];
                this.mAudioRecord.startRecording();
                while (this.mIsRecording) {
                    this.mAudioRecord.read(bArr, 0, bArr.length);
                    this.apz.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.apz.seek(4L);
                this.apz.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.apz.seek(40L);
                this.apz.writeInt(Integer.reverseBytes(this.dataSize));
                this.apz.close();
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
    public boolean xd() {
        Thread thread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.xc();
            }
        });
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void xe() {
        this.mIsRecording = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean isRecording() {
        return this.mIsRecording;
    }

    private void xf() {
        try {
            this.apz.setLength(0L);
            this.apz.writeBytes("RIFF");
            this.apz.writeInt(0);
            this.apz.writeBytes("WAVE");
            this.apz.writeBytes("fmt ");
            this.apz.writeInt(Integer.reverseBytes(16));
            this.apz.writeShort(Short.reverseBytes((short) 1));
            this.apz.writeShort(Short.reverseBytes(this.apB));
            this.apz.writeInt(Integer.reverseBytes(this.frequency));
            this.apz.writeInt(Integer.reverseBytes(((this.frequency * this.apB) * this.apC) / 8));
            this.apz.writeShort(Short.reverseBytes((short) ((this.apB * this.apC) / 8)));
            this.apz.writeShort(Short.reverseBytes(this.apC));
            this.apz.writeBytes("data");
            this.apz.writeInt(0);
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
