package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements i {
    public static int ahI = 8000;
    public static int ahJ = 2;
    public static int ahK = 2;
    public static int ahL = 1;
    private RandomAccessFile ahP;
    private int ahQ;
    private int ahR;
    private short ahS;
    private short ahT;
    private int dataSize;
    private String filePath;
    private int frequency;
    private int ahM = 0;
    private boolean ahN = false;
    private AudioRecord ahO = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.ahM = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.frequency = i2;
        this.ahQ = i3;
        this.ahR = i4;
        if (this.ahO != null) {
            this.ahO.release();
        }
        this.ahO = new AudioRecord(i, this.frequency, this.ahQ, this.ahR, this.ahM);
        this.ahS = (short) (this.ahQ == 12 ? 2 : 1);
        this.ahT = (short) (this.ahR == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.ahP != null) {
                try {
                    this.ahP.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.ahP = new RandomAccessFile(this.file, "rw");
                wp();
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
    public boolean dS(String str) {
        return a(ahL, ahI, ahJ, ahK, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wl() {
        if (this.ahO != null && this.file != null) {
            try {
                this.ahN = true;
                byte[] bArr = new byte[this.ahM];
                this.ahO.startRecording();
                while (this.ahN) {
                    this.ahO.read(bArr, 0, bArr.length);
                    this.ahP.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.ahP.seek(4L);
                this.ahP.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.ahP.seek(40L);
                this.ahP.writeInt(Integer.reverseBytes(this.dataSize));
                this.ahP.close();
                this.ahO.stop();
                this.ahO.release();
                this.ahN = false;
            } catch (Throwable th) {
                if (this.file.exists()) {
                    this.file.delete();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean wm() {
        Thread thread = new Thread(new b(this));
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public void wn() {
        this.ahN = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean wo() {
        return this.ahN;
    }

    private void wp() {
        try {
            this.ahP.setLength(0L);
            this.ahP.writeBytes("RIFF");
            this.ahP.writeInt(0);
            this.ahP.writeBytes("WAVE");
            this.ahP.writeBytes("fmt ");
            this.ahP.writeInt(Integer.reverseBytes(16));
            this.ahP.writeShort(Short.reverseBytes((short) 1));
            this.ahP.writeShort(Short.reverseBytes(this.ahS));
            this.ahP.writeInt(Integer.reverseBytes(this.frequency));
            this.ahP.writeInt(Integer.reverseBytes(((this.frequency * this.ahS) * this.ahT) / 8));
            this.ahP.writeShort(Short.reverseBytes((short) ((this.ahS * this.ahT) / 8)));
            this.ahP.writeShort(Short.reverseBytes(this.ahT));
            this.ahP.writeBytes("data");
            this.ahP.writeInt(0);
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
