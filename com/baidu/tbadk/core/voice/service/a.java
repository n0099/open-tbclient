package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements i {
    public static int afG = 8000;
    public static int afH = 2;
    public static int afI = 2;
    public static int afJ = 1;
    private RandomAccessFile afN;
    private int afO;
    private int afP;
    private short afQ;
    private short afR;
    private int dataSize;
    private String filePath;
    private int frequency;
    private int afK = 0;
    private boolean afL = false;
    private AudioRecord afM = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.afK = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.frequency = i2;
        this.afO = i3;
        this.afP = i4;
        if (this.afM != null) {
            this.afM.release();
        }
        this.afM = new AudioRecord(i, this.frequency, this.afO, this.afP, this.afK);
        this.afQ = (short) (this.afO == 12 ? 2 : 1);
        this.afR = (short) (this.afP == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.afN != null) {
                try {
                    this.afN.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.afN = new RandomAccessFile(this.file, "rw");
                vV();
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
    public boolean dD(String str) {
        return a(afJ, afG, afH, afI, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vR() {
        if (this.afM != null && this.file != null) {
            try {
                this.afL = true;
                byte[] bArr = new byte[this.afK];
                this.afM.startRecording();
                while (this.afL) {
                    this.afM.read(bArr, 0, bArr.length);
                    this.afN.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.afN.seek(4L);
                this.afN.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.afN.seek(40L);
                this.afN.writeInt(Integer.reverseBytes(this.dataSize));
                this.afN.close();
                this.afM.stop();
                this.afM.release();
                this.afL = false;
            } catch (Throwable th) {
                if (this.file.exists()) {
                    this.file.delete();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean vS() {
        Thread thread = new Thread(new b(this));
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public void vT() {
        this.afL = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean vU() {
        return this.afL;
    }

    private void vV() {
        try {
            this.afN.setLength(0L);
            this.afN.writeBytes("RIFF");
            this.afN.writeInt(0);
            this.afN.writeBytes("WAVE");
            this.afN.writeBytes("fmt ");
            this.afN.writeInt(Integer.reverseBytes(16));
            this.afN.writeShort(Short.reverseBytes((short) 1));
            this.afN.writeShort(Short.reverseBytes(this.afQ));
            this.afN.writeInt(Integer.reverseBytes(this.frequency));
            this.afN.writeInt(Integer.reverseBytes(((this.frequency * this.afQ) * this.afR) / 8));
            this.afN.writeShort(Short.reverseBytes((short) ((this.afQ * this.afR) / 8)));
            this.afN.writeShort(Short.reverseBytes(this.afR));
            this.afN.writeBytes("data");
            this.afN.writeInt(0);
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
