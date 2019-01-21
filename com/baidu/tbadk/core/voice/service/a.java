package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements d {
    public static int aMO = 8000;
    public static int aMP = 2;
    public static int aMQ = 2;
    public static int aMR = 1;
    private RandomAccessFile aMS;
    private int aMT;
    private short aMU;
    private short aMV;
    private int channelConfiguration;
    private int dataSize;
    private String filePath;
    private int frequency;
    private int bufferSize = 0;
    private boolean Tl = false;
    private AudioRecord mAudioRecord = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.frequency = i2;
        this.channelConfiguration = i3;
        this.aMT = i4;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
        }
        this.mAudioRecord = new AudioRecord(i, this.frequency, this.channelConfiguration, this.aMT, this.bufferSize);
        this.aMU = (short) (this.channelConfiguration == 12 ? 2 : 1);
        this.aMV = (short) (this.aMT == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.aMS != null) {
                try {
                    this.aMS.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.aMS = new RandomAccessFile(this.file, "rw");
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
    public boolean gL(String str) {
        return a(aMR, aMO, aMP, aMQ, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gc() {
        if (this.mAudioRecord != null && this.file != null) {
            try {
                this.Tl = true;
                byte[] bArr = new byte[this.bufferSize];
                this.mAudioRecord.startRecording();
                while (this.Tl) {
                    this.mAudioRecord.read(bArr, 0, bArr.length);
                    this.aMS.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.aMS.seek(4L);
                this.aMS.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.aMS.seek(40L);
                this.aMS.writeInt(Integer.reverseBytes(this.dataSize));
                this.aMS.close();
                this.mAudioRecord.stop();
                this.mAudioRecord.release();
                this.Tl = false;
            } catch (Throwable th) {
                if (this.file.exists()) {
                    this.file.delete();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean Gd() {
        Thread thread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.Gc();
            }
        });
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void Ge() {
        this.Tl = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean Gf() {
        return this.Tl;
    }

    private void writeHeader() {
        try {
            this.aMS.setLength(0L);
            this.aMS.writeBytes("RIFF");
            this.aMS.writeInt(0);
            this.aMS.writeBytes("WAVE");
            this.aMS.writeBytes("fmt ");
            this.aMS.writeInt(Integer.reverseBytes(16));
            this.aMS.writeShort(Short.reverseBytes((short) 1));
            this.aMS.writeShort(Short.reverseBytes(this.aMU));
            this.aMS.writeInt(Integer.reverseBytes(this.frequency));
            this.aMS.writeInt(Integer.reverseBytes(((this.frequency * this.aMU) * this.aMV) / 8));
            this.aMS.writeShort(Short.reverseBytes((short) ((this.aMU * this.aMV) / 8)));
            this.aMS.writeShort(Short.reverseBytes(this.aMV));
            this.aMS.writeBytes("data");
            this.aMS.writeInt(0);
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
