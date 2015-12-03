package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements i {
    public static int agF = 8000;
    public static int agG = 2;
    public static int agH = 2;
    public static int agI = 1;
    private RandomAccessFile agM;
    private int agN;
    private int agO;
    private short agP;
    private short agQ;
    private int dataSize;
    private String filePath;
    private int frequency;
    private int agJ = 0;
    private boolean agK = false;
    private AudioRecord agL = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.agJ = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.frequency = i2;
        this.agN = i3;
        this.agO = i4;
        if (this.agL != null) {
            this.agL.release();
        }
        this.agL = new AudioRecord(i, this.frequency, this.agN, this.agO, this.agJ);
        this.agP = (short) (this.agN == 12 ? 2 : 1);
        this.agQ = (short) (this.agO == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.agM != null) {
                try {
                    this.agM.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.agM = new RandomAccessFile(this.file, "rw");
                wG();
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
    public boolean dP(String str) {
        return a(agI, agF, agG, agH, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wC() {
        if (this.agL != null && this.file != null) {
            try {
                this.agK = true;
                byte[] bArr = new byte[this.agJ];
                this.agL.startRecording();
                while (this.agK) {
                    this.agL.read(bArr, 0, bArr.length);
                    this.agM.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.agM.seek(4L);
                this.agM.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.agM.seek(40L);
                this.agM.writeInt(Integer.reverseBytes(this.dataSize));
                this.agM.close();
                this.agL.stop();
                this.agL.release();
                this.agK = false;
            } catch (Throwable th) {
                if (this.file.exists()) {
                    this.file.delete();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean wD() {
        Thread thread = new Thread(new b(this));
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public void wE() {
        this.agK = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean wF() {
        return this.agK;
    }

    private void wG() {
        try {
            this.agM.setLength(0L);
            this.agM.writeBytes("RIFF");
            this.agM.writeInt(0);
            this.agM.writeBytes("WAVE");
            this.agM.writeBytes("fmt ");
            this.agM.writeInt(Integer.reverseBytes(16));
            this.agM.writeShort(Short.reverseBytes((short) 1));
            this.agM.writeShort(Short.reverseBytes(this.agP));
            this.agM.writeInt(Integer.reverseBytes(this.frequency));
            this.agM.writeInt(Integer.reverseBytes(((this.frequency * this.agP) * this.agQ) / 8));
            this.agM.writeShort(Short.reverseBytes((short) ((this.agP * this.agQ) / 8)));
            this.agM.writeShort(Short.reverseBytes(this.agQ));
            this.agM.writeBytes("data");
            this.agM.writeInt(0);
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
