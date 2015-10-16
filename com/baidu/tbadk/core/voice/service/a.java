package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements i {
    public static int aeU = 8000;
    public static int aeV = 2;
    public static int aeW = 2;
    public static int aeX = 1;
    private RandomAccessFile afb;
    private int afc;
    private int afd;
    private short afe;
    private short aff;
    private int dataSize;
    private String filePath;
    private int frequency;
    private int aeY = 0;
    private boolean aeZ = false;
    private AudioRecord afa = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.aeY = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.frequency = i2;
        this.afc = i3;
        this.afd = i4;
        if (this.afa != null) {
            this.afa.release();
        }
        this.afa = new AudioRecord(i, this.frequency, this.afc, this.afd, this.aeY);
        this.afe = (short) (this.afc == 12 ? 2 : 1);
        this.aff = (short) (this.afd == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.afb != null) {
                try {
                    this.afb.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.afb = new RandomAccessFile(this.file, "rw");
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
        return a(aeX, aeU, aeV, aeW, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vK() {
        if (this.afa != null && this.file != null) {
            try {
                this.aeZ = true;
                byte[] bArr = new byte[this.aeY];
                this.afa.startRecording();
                while (this.aeZ) {
                    this.afa.read(bArr, 0, bArr.length);
                    this.afb.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.afb.seek(4L);
                this.afb.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.afb.seek(40L);
                this.afb.writeInt(Integer.reverseBytes(this.dataSize));
                this.afb.close();
                this.afa.stop();
                this.afa.release();
                this.aeZ = false;
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
        this.aeZ = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean vN() {
        return this.aeZ;
    }

    private void vO() {
        try {
            this.afb.setLength(0L);
            this.afb.writeBytes("RIFF");
            this.afb.writeInt(0);
            this.afb.writeBytes("WAVE");
            this.afb.writeBytes("fmt ");
            this.afb.writeInt(Integer.reverseBytes(16));
            this.afb.writeShort(Short.reverseBytes((short) 1));
            this.afb.writeShort(Short.reverseBytes(this.afe));
            this.afb.writeInt(Integer.reverseBytes(this.frequency));
            this.afb.writeInt(Integer.reverseBytes(((this.frequency * this.afe) * this.aff) / 8));
            this.afb.writeShort(Short.reverseBytes((short) ((this.afe * this.aff) / 8)));
            this.afb.writeShort(Short.reverseBytes(this.aff));
            this.afb.writeBytes("data");
            this.afb.writeInt(0);
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
