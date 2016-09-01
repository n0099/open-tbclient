package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements i {
    public static int aiF = 8000;
    public static int aiG = 2;
    public static int aiH = 2;
    public static int aiI = 1;
    private RandomAccessFile aiM;
    private int aiN;
    private int aiO;
    private short aiP;
    private short aiQ;
    private int dataSize;
    private String filePath;
    private int frequency;
    private int aiJ = 0;
    private boolean aiK = false;
    private AudioRecord aiL = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.aiJ = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.frequency = i2;
        this.aiN = i3;
        this.aiO = i4;
        if (this.aiL != null) {
            this.aiL.release();
        }
        this.aiL = new AudioRecord(i, this.frequency, this.aiN, this.aiO, this.aiJ);
        this.aiP = (short) (this.aiN == 12 ? 2 : 1);
        this.aiQ = (short) (this.aiO == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.aiM != null) {
                try {
                    this.aiM.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.aiM = new RandomAccessFile(this.file, "rw");
                xg();
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
        return a(aiI, aiF, aiG, aiH, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xc() {
        if (this.aiL != null && this.file != null) {
            try {
                this.aiK = true;
                byte[] bArr = new byte[this.aiJ];
                this.aiL.startRecording();
                while (this.aiK) {
                    this.aiL.read(bArr, 0, bArr.length);
                    this.aiM.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.aiM.seek(4L);
                this.aiM.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.aiM.seek(40L);
                this.aiM.writeInt(Integer.reverseBytes(this.dataSize));
                this.aiM.close();
                this.aiL.stop();
                this.aiL.release();
                this.aiK = false;
            } catch (Throwable th) {
                if (this.file.exists()) {
                    this.file.delete();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean xd() {
        Thread thread = new Thread(new b(this));
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public void xe() {
        this.aiK = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean xf() {
        return this.aiK;
    }

    private void xg() {
        try {
            this.aiM.setLength(0L);
            this.aiM.writeBytes("RIFF");
            this.aiM.writeInt(0);
            this.aiM.writeBytes("WAVE");
            this.aiM.writeBytes("fmt ");
            this.aiM.writeInt(Integer.reverseBytes(16));
            this.aiM.writeShort(Short.reverseBytes((short) 1));
            this.aiM.writeShort(Short.reverseBytes(this.aiP));
            this.aiM.writeInt(Integer.reverseBytes(this.frequency));
            this.aiM.writeInt(Integer.reverseBytes(((this.frequency * this.aiP) * this.aiQ) / 8));
            this.aiM.writeShort(Short.reverseBytes((short) ((this.aiP * this.aiQ) / 8)));
            this.aiM.writeShort(Short.reverseBytes(this.aiQ));
            this.aiM.writeBytes("data");
            this.aiM.writeInt(0);
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
