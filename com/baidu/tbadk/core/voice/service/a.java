package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements d {
    public static int bVq = 8000;
    public static int bVr = 2;
    public static int bVs = 2;
    public static int bVt = 1;
    private RandomAccessFile bVu;
    private int bVv;
    private short bVw;
    private short bVx;
    private int channelConfiguration;
    private int dataSize;
    private String filePath;
    private int frequency;
    private int bufferSize = 0;
    private boolean VP = false;
    private AudioRecord mAudioRecord = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.frequency = i2;
        this.channelConfiguration = i3;
        this.bVv = i4;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
        }
        this.mAudioRecord = new AudioRecord(i, this.frequency, this.channelConfiguration, this.bVv, this.bufferSize);
        this.bVw = (short) (this.channelConfiguration == 12 ? 2 : 1);
        this.bVx = (short) (this.bVv == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.bVu != null) {
                try {
                    this.bVu.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.bVu = new RandomAccessFile(this.file, "rw");
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
    public boolean ny(String str) {
        return a(bVt, bVq, bVr, bVs, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aft() {
        if (this.mAudioRecord != null && this.file != null) {
            try {
                this.VP = true;
                byte[] bArr = new byte[this.bufferSize];
                this.mAudioRecord.startRecording();
                while (this.VP) {
                    this.mAudioRecord.read(bArr, 0, bArr.length);
                    this.bVu.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.bVu.seek(4L);
                this.bVu.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.bVu.seek(40L);
                this.bVu.writeInt(Integer.reverseBytes(this.dataSize));
                this.bVu.close();
                this.mAudioRecord.stop();
                this.mAudioRecord.release();
                this.VP = false;
            } catch (Throwable th) {
                if (this.file.exists()) {
                    this.file.delete();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean afu() {
        Thread thread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.aft();
            }
        });
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void afv() {
        this.VP = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean afw() {
        return this.VP;
    }

    private void writeHeader() {
        try {
            this.bVu.setLength(0L);
            this.bVu.writeBytes("RIFF");
            this.bVu.writeInt(0);
            this.bVu.writeBytes("WAVE");
            this.bVu.writeBytes("fmt ");
            this.bVu.writeInt(Integer.reverseBytes(16));
            this.bVu.writeShort(Short.reverseBytes((short) 1));
            this.bVu.writeShort(Short.reverseBytes(this.bVw));
            this.bVu.writeInt(Integer.reverseBytes(this.frequency));
            this.bVu.writeInt(Integer.reverseBytes(((this.frequency * this.bVw) * this.bVx) / 8));
            this.bVu.writeShort(Short.reverseBytes((short) ((this.bVw * this.bVx) / 8)));
            this.bVu.writeShort(Short.reverseBytes(this.bVx));
            this.bVu.writeBytes("data");
            this.bVu.writeInt(0);
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
