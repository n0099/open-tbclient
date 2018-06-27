package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements d {
    public static int aAt = 8000;
    public static int aAu = 2;
    public static int aAv = 2;
    public static int aAw = 1;
    private short aAA;
    private RandomAccessFile aAx;
    private int aAy;
    private short aAz;
    private int channelConfiguration;
    private int dataSize;
    private String filePath;
    private int frequency;
    private int bufferSize = 0;
    private boolean Ql = false;
    private AudioRecord mAudioRecord = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.frequency = i2;
        this.channelConfiguration = i3;
        this.aAy = i4;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
        }
        this.mAudioRecord = new AudioRecord(i, this.frequency, this.channelConfiguration, this.aAy, this.bufferSize);
        this.aAz = (short) (this.channelConfiguration == 12 ? 2 : 1);
        this.aAA = (short) (this.aAy == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.aAx != null) {
                try {
                    this.aAx.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.aAx = new RandomAccessFile(this.file, "rw");
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
    public boolean fw(String str) {
        return a(aAw, aAt, aAu, aAv, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bv() {
        if (this.mAudioRecord != null && this.file != null) {
            try {
                this.Ql = true;
                byte[] bArr = new byte[this.bufferSize];
                this.mAudioRecord.startRecording();
                while (this.Ql) {
                    this.mAudioRecord.read(bArr, 0, bArr.length);
                    this.aAx.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.aAx.seek(4L);
                this.aAx.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.aAx.seek(40L);
                this.aAx.writeInt(Integer.reverseBytes(this.dataSize));
                this.aAx.close();
                this.mAudioRecord.stop();
                this.mAudioRecord.release();
                this.Ql = false;
            } catch (Throwable th) {
                if (this.file.exists()) {
                    this.file.delete();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean Bw() {
        Thread thread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.Bv();
            }
        });
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void Bx() {
        this.Ql = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean isRecording() {
        return this.Ql;
    }

    private void writeHeader() {
        try {
            this.aAx.setLength(0L);
            this.aAx.writeBytes("RIFF");
            this.aAx.writeInt(0);
            this.aAx.writeBytes("WAVE");
            this.aAx.writeBytes("fmt ");
            this.aAx.writeInt(Integer.reverseBytes(16));
            this.aAx.writeShort(Short.reverseBytes((short) 1));
            this.aAx.writeShort(Short.reverseBytes(this.aAz));
            this.aAx.writeInt(Integer.reverseBytes(this.frequency));
            this.aAx.writeInt(Integer.reverseBytes(((this.frequency * this.aAz) * this.aAA) / 8));
            this.aAx.writeShort(Short.reverseBytes((short) ((this.aAz * this.aAA) / 8)));
            this.aAx.writeShort(Short.reverseBytes(this.aAA));
            this.aAx.writeBytes("data");
            this.aAx.writeInt(0);
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
