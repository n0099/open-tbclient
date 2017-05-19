package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements i {
    public static int anC = 8000;
    public static int anD = 2;
    public static int anE = 2;
    public static int anF = 1;
    private RandomAccessFile anI;
    private int anJ;
    private int anK;
    private short anL;
    private short anM;
    private int dataSize;
    private String filePath;
    private int frequency;
    private int anG = 0;
    private boolean anH = false;
    private AudioRecord mAudioRecord = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.anG = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.frequency = i2;
        this.anJ = i3;
        this.anK = i4;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
        }
        this.mAudioRecord = new AudioRecord(i, this.frequency, this.anJ, this.anK, this.anG);
        this.anL = (short) (this.anJ == 12 ? 2 : 1);
        this.anM = (short) (this.anK == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.anI != null) {
                try {
                    this.anI.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.anI = new RandomAccessFile(this.file, "rw");
                xa();
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

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean dZ(String str) {
        return a(anF, anC, anD, anE, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wX() {
        if (this.mAudioRecord != null && this.file != null) {
            try {
                this.anH = true;
                byte[] bArr = new byte[this.anG];
                this.mAudioRecord.startRecording();
                while (this.anH) {
                    this.mAudioRecord.read(bArr, 0, bArr.length);
                    this.anI.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.anI.seek(4L);
                this.anI.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.anI.seek(40L);
                this.anI.writeInt(Integer.reverseBytes(this.dataSize));
                this.anI.close();
                this.mAudioRecord.stop();
                this.mAudioRecord.release();
                this.anH = false;
            } catch (Throwable th) {
                if (this.file.exists()) {
                    this.file.delete();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean wY() {
        Thread thread = new Thread(new b(this));
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public void wZ() {
        this.anH = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean isRecording() {
        return this.anH;
    }

    private void xa() {
        try {
            this.anI.setLength(0L);
            this.anI.writeBytes("RIFF");
            this.anI.writeInt(0);
            this.anI.writeBytes("WAVE");
            this.anI.writeBytes("fmt ");
            this.anI.writeInt(Integer.reverseBytes(16));
            this.anI.writeShort(Short.reverseBytes((short) 1));
            this.anI.writeShort(Short.reverseBytes(this.anL));
            this.anI.writeInt(Integer.reverseBytes(this.frequency));
            this.anI.writeInt(Integer.reverseBytes(((this.frequency * this.anL) * this.anM) / 8));
            this.anI.writeShort(Short.reverseBytes((short) ((this.anL * this.anM) / 8)));
            this.anI.writeShort(Short.reverseBytes(this.anM));
            this.anI.writeBytes("data");
            this.anI.writeInt(0);
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
