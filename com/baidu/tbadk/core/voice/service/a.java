package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements i {
    public static int aeT = 8000;
    public static int aeU = 2;
    public static int aeV = 2;
    public static int aeW = 1;
    private RandomAccessFile afa;
    private int afb;
    private int afc;
    private short afd;
    private short afe;
    private int dataSize;
    private String filePath;
    private int frequency;
    private int aeX = 0;
    private boolean aeY = false;
    private AudioRecord aeZ = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.aeX = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.frequency = i2;
        this.afb = i3;
        this.afc = i4;
        if (this.aeZ != null) {
            this.aeZ.release();
        }
        this.aeZ = new AudioRecord(i, this.frequency, this.afb, this.afc, this.aeX);
        this.afd = (short) (this.afb == 12 ? 2 : 1);
        this.afe = (short) (this.afc == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.afa != null) {
                try {
                    this.afa.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.afa = new RandomAccessFile(this.file, "rw");
                vO();
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
    public boolean dH(String str) {
        return a(aeW, aeT, aeU, aeV, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vK() {
        if (this.aeZ != null && this.file != null) {
            try {
                this.aeY = true;
                byte[] bArr = new byte[this.aeX];
                this.aeZ.startRecording();
                while (this.aeY) {
                    this.aeZ.read(bArr, 0, bArr.length);
                    this.afa.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.afa.seek(4L);
                this.afa.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.afa.seek(40L);
                this.afa.writeInt(Integer.reverseBytes(this.dataSize));
                this.afa.close();
                this.aeZ.stop();
                this.aeZ.release();
                this.aeY = false;
            } catch (Throwable th) {
                if (this.file.exists()) {
                    this.file.delete();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean vL() {
        Thread thread = new Thread(new b(this));
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public void vM() {
        this.aeY = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean vN() {
        return this.aeY;
    }

    private void vO() {
        try {
            this.afa.setLength(0L);
            this.afa.writeBytes("RIFF");
            this.afa.writeInt(0);
            this.afa.writeBytes("WAVE");
            this.afa.writeBytes("fmt ");
            this.afa.writeInt(Integer.reverseBytes(16));
            this.afa.writeShort(Short.reverseBytes((short) 1));
            this.afa.writeShort(Short.reverseBytes(this.afd));
            this.afa.writeInt(Integer.reverseBytes(this.frequency));
            this.afa.writeInt(Integer.reverseBytes(((this.frequency * this.afd) * this.afe) / 8));
            this.afa.writeShort(Short.reverseBytes((short) ((this.afd * this.afe) / 8)));
            this.afa.writeShort(Short.reverseBytes(this.afe));
            this.afa.writeBytes("data");
            this.afa.writeInt(0);
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
