package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements i {
    public static int ahN = 8000;
    public static int ahO = 2;
    public static int ahP = 2;
    public static int ahQ = 1;
    private RandomAccessFile ahT;
    private int ahU;
    private int ahV;
    private short ahW;
    private short ahX;
    private int dataSize;
    private String filePath;
    private int frequency;
    private int ahR = 0;
    private boolean ahS = false;
    private AudioRecord mAudioRecord = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.ahR = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.frequency = i2;
        this.ahU = i3;
        this.ahV = i4;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
        }
        this.mAudioRecord = new AudioRecord(i, this.frequency, this.ahU, this.ahV, this.ahR);
        this.ahW = (short) (this.ahU == 12 ? 2 : 1);
        this.ahX = (short) (this.ahV == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.ahT != null) {
                try {
                    this.ahT.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.ahT = new RandomAccessFile(this.file, "rw");
                wU();
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
    public boolean ea(String str) {
        return a(ahQ, ahN, ahO, ahP, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wQ() {
        if (this.mAudioRecord != null && this.file != null) {
            try {
                this.ahS = true;
                byte[] bArr = new byte[this.ahR];
                this.mAudioRecord.startRecording();
                while (this.ahS) {
                    this.mAudioRecord.read(bArr, 0, bArr.length);
                    this.ahT.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.ahT.seek(4L);
                this.ahT.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.ahT.seek(40L);
                this.ahT.writeInt(Integer.reverseBytes(this.dataSize));
                this.ahT.close();
                this.mAudioRecord.stop();
                this.mAudioRecord.release();
                this.ahS = false;
            } catch (Throwable th) {
                if (this.file.exists()) {
                    this.file.delete();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean wR() {
        Thread thread = new Thread(new b(this));
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public void wS() {
        this.ahS = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean wT() {
        return this.ahS;
    }

    private void wU() {
        try {
            this.ahT.setLength(0L);
            this.ahT.writeBytes("RIFF");
            this.ahT.writeInt(0);
            this.ahT.writeBytes("WAVE");
            this.ahT.writeBytes("fmt ");
            this.ahT.writeInt(Integer.reverseBytes(16));
            this.ahT.writeShort(Short.reverseBytes((short) 1));
            this.ahT.writeShort(Short.reverseBytes(this.ahW));
            this.ahT.writeInt(Integer.reverseBytes(this.frequency));
            this.ahT.writeInt(Integer.reverseBytes(((this.frequency * this.ahW) * this.ahX) / 8));
            this.ahT.writeShort(Short.reverseBytes((short) ((this.ahW * this.ahX) / 8)));
            this.ahT.writeShort(Short.reverseBytes(this.ahX));
            this.ahT.writeBytes("data");
            this.ahT.writeInt(0);
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
