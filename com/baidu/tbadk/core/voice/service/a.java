package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements i {
    public static int aeW = 8000;
    public static int aeX = 2;
    public static int aeY = 2;
    public static int aeZ = 1;
    private RandomAccessFile afd;
    private int afe;
    private int aff;
    private short afg;
    private short afh;
    private int dataSize;
    private String filePath;
    private int frequency;
    private int afa = 0;
    private boolean afb = false;
    private AudioRecord afc = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.afa = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.frequency = i2;
        this.afe = i3;
        this.aff = i4;
        if (this.afc != null) {
            this.afc.release();
        }
        this.afc = new AudioRecord(i, this.frequency, this.afe, this.aff, this.afa);
        this.afg = (short) (this.afe == 12 ? 2 : 1);
        this.afh = (short) (this.aff == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.afd != null) {
                try {
                    this.afd.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.afd = new RandomAccessFile(this.file, "rw");
                wc();
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
    public boolean dY(String str) {
        return a(aeZ, aeW, aeX, aeY, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vY() {
        if (this.afc != null && this.file != null) {
            try {
                this.afb = true;
                byte[] bArr = new byte[this.afa];
                this.afc.startRecording();
                while (this.afb) {
                    this.afc.read(bArr, 0, bArr.length);
                    this.afd.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.afd.seek(4L);
                this.afd.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.afd.seek(40L);
                this.afd.writeInt(Integer.reverseBytes(this.dataSize));
                this.afd.close();
                this.afc.stop();
                this.afc.release();
                this.afb = false;
            } catch (Throwable th) {
                if (this.file.exists()) {
                    this.file.delete();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean vZ() {
        Thread thread = new Thread(new b(this));
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public void wa() {
        this.afb = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean wb() {
        return this.afb;
    }

    private void wc() {
        try {
            this.afd.setLength(0L);
            this.afd.writeBytes("RIFF");
            this.afd.writeInt(0);
            this.afd.writeBytes("WAVE");
            this.afd.writeBytes("fmt ");
            this.afd.writeInt(Integer.reverseBytes(16));
            this.afd.writeShort(Short.reverseBytes((short) 1));
            this.afd.writeShort(Short.reverseBytes(this.afg));
            this.afd.writeInt(Integer.reverseBytes(this.frequency));
            this.afd.writeInt(Integer.reverseBytes(((this.frequency * this.afg) * this.afh) / 8));
            this.afd.writeShort(Short.reverseBytes((short) ((this.afg * this.afh) / 8)));
            this.afd.writeShort(Short.reverseBytes(this.afh));
            this.afd.writeBytes("data");
            this.afd.writeInt(0);
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
