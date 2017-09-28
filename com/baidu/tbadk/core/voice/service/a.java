package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements d {
    public static int apl = 8000;
    public static int apm = 2;
    public static int apn = 2;
    public static int apo = 1;
    private RandomAccessFile apr;
    private int aps;
    private short apt;
    private short apu;
    private int channelConfiguration;
    private int dataSize;
    private String filePath;
    private int frequency;
    private int apq = 0;
    private boolean mIsRecording = false;
    private AudioRecord mAudioRecord = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.apq = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.frequency = i2;
        this.channelConfiguration = i3;
        this.aps = i4;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
        }
        this.mAudioRecord = new AudioRecord(i, this.frequency, this.channelConfiguration, this.aps, this.apq);
        this.apt = (short) (this.channelConfiguration == 12 ? 2 : 1);
        this.apu = (short) (this.aps == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.apr != null) {
                try {
                    this.apr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.apr = new RandomAccessFile(this.file, "rw");
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
    public boolean er(String str) {
        return a(apo, apl, apm, apn, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xc() {
        if (this.mAudioRecord != null && this.file != null) {
            try {
                this.mIsRecording = true;
                byte[] bArr = new byte[this.apq];
                this.mAudioRecord.startRecording();
                while (this.mIsRecording) {
                    this.mAudioRecord.read(bArr, 0, bArr.length);
                    this.apr.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.apr.seek(4L);
                this.apr.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.apr.seek(40L);
                this.apr.writeInt(Integer.reverseBytes(this.dataSize));
                this.apr.close();
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
            this.apr.setLength(0L);
            this.apr.writeBytes("RIFF");
            this.apr.writeInt(0);
            this.apr.writeBytes("WAVE");
            this.apr.writeBytes("fmt ");
            this.apr.writeInt(Integer.reverseBytes(16));
            this.apr.writeShort(Short.reverseBytes((short) 1));
            this.apr.writeShort(Short.reverseBytes(this.apt));
            this.apr.writeInt(Integer.reverseBytes(this.frequency));
            this.apr.writeInt(Integer.reverseBytes(((this.frequency * this.apt) * this.apu) / 8));
            this.apr.writeShort(Short.reverseBytes((short) ((this.apt * this.apu) / 8)));
            this.apr.writeShort(Short.reverseBytes(this.apu));
            this.apr.writeBytes("data");
            this.apr.writeInt(0);
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
