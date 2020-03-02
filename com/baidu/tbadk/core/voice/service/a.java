package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements d {
    public static int dkQ = 8000;
    public static int dkR = 2;
    public static int dkS = 2;
    public static int dkT = 1;
    private int channelConfiguration;
    private int dataSize;
    private RandomAccessFile dkU;
    private int dkV;
    private int dkW;
    private short dkX;
    private short dkY;
    private String filePath;
    private int bufferSize = 0;
    private boolean FQ = false;
    private AudioRecord mAudioRecord = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.dkV = i2;
        this.channelConfiguration = i3;
        this.dkW = i4;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
        }
        this.mAudioRecord = new AudioRecord(i, this.dkV, this.channelConfiguration, this.dkW, this.bufferSize);
        this.dkX = (short) (this.channelConfiguration == 12 ? 2 : 1);
        this.dkY = (short) (this.dkW == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.dkU != null) {
                try {
                    this.dkU.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.dkU = new RandomAccessFile(this.file, "rw");
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
    public boolean ud(String str) {
        return a(dkT, dkQ, dkR, dkS, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIK() {
        if (this.mAudioRecord != null && this.file != null) {
            try {
                this.FQ = true;
                byte[] bArr = new byte[this.bufferSize];
                this.mAudioRecord.startRecording();
                while (this.FQ) {
                    this.mAudioRecord.read(bArr, 0, bArr.length);
                    this.dkU.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.dkU.seek(4L);
                this.dkU.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.dkU.seek(40L);
                this.dkU.writeInt(Integer.reverseBytes(this.dataSize));
                this.dkU.close();
                this.mAudioRecord.stop();
                this.mAudioRecord.release();
                this.FQ = false;
            } catch (Throwable th) {
                if (this.file.exists()) {
                    this.file.delete();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean aIL() {
        Thread thread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.aIK();
            }
        });
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void aIM() {
        this.FQ = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean isRecording() {
        return this.FQ;
    }

    private void writeHeader() {
        try {
            this.dkU.setLength(0L);
            this.dkU.writeBytes("RIFF");
            this.dkU.writeInt(0);
            this.dkU.writeBytes("WAVE");
            this.dkU.writeBytes("fmt ");
            this.dkU.writeInt(Integer.reverseBytes(16));
            this.dkU.writeShort(Short.reverseBytes((short) 1));
            this.dkU.writeShort(Short.reverseBytes(this.dkX));
            this.dkU.writeInt(Integer.reverseBytes(this.dkV));
            this.dkU.writeInt(Integer.reverseBytes(((this.dkV * this.dkX) * this.dkY) / 8));
            this.dkU.writeShort(Short.reverseBytes((short) ((this.dkX * this.dkY) / 8)));
            this.dkU.writeShort(Short.reverseBytes(this.dkY));
            this.dkU.writeBytes("data");
            this.dkU.writeInt(0);
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
