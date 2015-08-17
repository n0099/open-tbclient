package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements i {
    public static int afw = 8000;
    public static int afx = 2;
    public static int afy = 2;
    public static int afz = 1;
    private RandomAccessFile afD;
    private int afE;
    private int afF;
    private short afG;
    private short afH;
    private int dataSize;
    private String filePath;
    private int frequency;
    private int afA = 0;
    private boolean afB = false;
    private AudioRecord afC = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.afA = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.frequency = i2;
        this.afE = i3;
        this.afF = i4;
        if (this.afC != null) {
            this.afC.release();
        }
        this.afC = new AudioRecord(i, this.frequency, this.afE, this.afF, this.afA);
        this.afG = (short) (this.afE == 12 ? 2 : 1);
        this.afH = (short) (this.afF == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.afD != null) {
                try {
                    this.afD.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.afD = new RandomAccessFile(this.file, "rw");
                vQ();
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
    public boolean dw(String str) {
        return a(afz, afw, afx, afy, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vM() {
        if (this.afC != null && this.file != null) {
            try {
                this.afB = true;
                byte[] bArr = new byte[this.afA];
                this.afC.startRecording();
                while (this.afB) {
                    this.afC.read(bArr, 0, bArr.length);
                    this.afD.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.afD.seek(4L);
                this.afD.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.afD.seek(40L);
                this.afD.writeInt(Integer.reverseBytes(this.dataSize));
                this.afD.close();
                this.afC.stop();
                this.afC.release();
                this.afB = false;
            } catch (Throwable th) {
                if (this.file.exists()) {
                    this.file.delete();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean vN() {
        Thread thread = new Thread(new b(this));
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public void vO() {
        this.afB = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean vP() {
        return this.afB;
    }

    private void vQ() {
        try {
            this.afD.setLength(0L);
            this.afD.writeBytes("RIFF");
            this.afD.writeInt(0);
            this.afD.writeBytes("WAVE");
            this.afD.writeBytes("fmt ");
            this.afD.writeInt(Integer.reverseBytes(16));
            this.afD.writeShort(Short.reverseBytes((short) 1));
            this.afD.writeShort(Short.reverseBytes(this.afG));
            this.afD.writeInt(Integer.reverseBytes(this.frequency));
            this.afD.writeInt(Integer.reverseBytes(((this.frequency * this.afG) * this.afH) / 8));
            this.afD.writeShort(Short.reverseBytes((short) ((this.afG * this.afH) / 8)));
            this.afD.writeShort(Short.reverseBytes(this.afH));
            this.afD.writeBytes("data");
            this.afD.writeInt(0);
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
