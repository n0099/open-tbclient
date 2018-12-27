package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements d {
    public static int aMl = 8000;
    public static int aMm = 2;
    public static int aMn = 2;
    public static int aMo = 1;
    private RandomAccessFile aMp;
    private int aMq;
    private short aMr;
    private short aMs;
    private int channelConfiguration;
    private int dataSize;
    private String filePath;
    private int frequency;
    private int bufferSize = 0;
    private boolean Tc = false;
    private AudioRecord mAudioRecord = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.frequency = i2;
        this.channelConfiguration = i3;
        this.aMq = i4;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
        }
        this.mAudioRecord = new AudioRecord(i, this.frequency, this.channelConfiguration, this.aMq, this.bufferSize);
        this.aMr = (short) (this.channelConfiguration == 12 ? 2 : 1);
        this.aMs = (short) (this.aMq == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.aMp != null) {
                try {
                    this.aMp.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.aMp = new RandomAccessFile(this.file, "rw");
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
    public boolean gy(String str) {
        return a(aMo, aMl, aMm, aMn, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FP() {
        if (this.mAudioRecord != null && this.file != null) {
            try {
                this.Tc = true;
                byte[] bArr = new byte[this.bufferSize];
                this.mAudioRecord.startRecording();
                while (this.Tc) {
                    this.mAudioRecord.read(bArr, 0, bArr.length);
                    this.aMp.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.aMp.seek(4L);
                this.aMp.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.aMp.seek(40L);
                this.aMp.writeInt(Integer.reverseBytes(this.dataSize));
                this.aMp.close();
                this.mAudioRecord.stop();
                this.mAudioRecord.release();
                this.Tc = false;
            } catch (Throwable th) {
                if (this.file.exists()) {
                    this.file.delete();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean FQ() {
        Thread thread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.FP();
            }
        });
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void FR() {
        this.Tc = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean FS() {
        return this.Tc;
    }

    private void writeHeader() {
        try {
            this.aMp.setLength(0L);
            this.aMp.writeBytes("RIFF");
            this.aMp.writeInt(0);
            this.aMp.writeBytes("WAVE");
            this.aMp.writeBytes("fmt ");
            this.aMp.writeInt(Integer.reverseBytes(16));
            this.aMp.writeShort(Short.reverseBytes((short) 1));
            this.aMp.writeShort(Short.reverseBytes(this.aMr));
            this.aMp.writeInt(Integer.reverseBytes(this.frequency));
            this.aMp.writeInt(Integer.reverseBytes(((this.frequency * this.aMr) * this.aMs) / 8));
            this.aMp.writeShort(Short.reverseBytes((short) ((this.aMr * this.aMs) / 8)));
            this.aMp.writeShort(Short.reverseBytes(this.aMs));
            this.aMp.writeBytes("data");
            this.aMp.writeInt(0);
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
