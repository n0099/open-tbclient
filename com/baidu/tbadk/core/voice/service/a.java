package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import android.util.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements j {
    public static int Zs = 8000;
    public static int Zt = 2;
    public static int Zu = 2;
    public static int Zv = 1;
    private int ZA;
    private int ZB;
    private short ZC;
    private short ZD;
    private RandomAccessFile Zz;
    private int dataSize;
    private String filePath;
    private int frequency;
    private int Zw = 0;
    private boolean Zx = false;
    private AudioRecord Zy = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.Zw = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.frequency = i2;
        this.ZA = i3;
        this.ZB = i4;
        if (this.Zy != null) {
            this.Zy.release();
        }
        this.Zy = new AudioRecord(i, this.frequency, this.ZA, this.ZB, this.Zw);
        this.ZC = (short) (this.ZA == 12 ? 2 : 1);
        this.ZD = (short) (this.ZB == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.Zz != null) {
                try {
                    this.Zz.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.Zz = new RandomAccessFile(this.file, "rw");
                ud();
                setFilePath(this.file.getParent());
                return true;
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
                return false;
            }
        } catch (IOException e3) {
            this.file = null;
            Log.e("create file error in audio record", e3.getMessage());
            return false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.j
    public boolean de(String str) {
        return a(Zv, Zs, Zt, Zu, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tZ() {
        if (this.Zy != null && this.file != null) {
            try {
                this.Zx = true;
                byte[] bArr = new byte[this.Zw];
                this.Zy.startRecording();
                while (this.Zx) {
                    this.Zy.read(bArr, 0, bArr.length);
                    this.Zz.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.Zz.seek(4L);
                this.Zz.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.Zz.seek(40L);
                this.Zz.writeInt(Integer.reverseBytes(this.dataSize));
                this.Zz.close();
                this.Zy.stop();
                this.Zy.release();
                this.Zx = false;
            } catch (Throwable th) {
                Log.e("AudioRecord", "Recording Failed");
                if (this.file.exists()) {
                    this.file.delete();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.j
    public boolean ua() {
        Thread thread = new Thread(new b(this));
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.j
    public void ub() {
        this.Zx = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.j
    public boolean uc() {
        return this.Zx;
    }

    private void ud() {
        try {
            this.Zz.setLength(0L);
            this.Zz.writeBytes("RIFF");
            this.Zz.writeInt(0);
            this.Zz.writeBytes("WAVE");
            this.Zz.writeBytes("fmt ");
            this.Zz.writeInt(Integer.reverseBytes(16));
            this.Zz.writeShort(Short.reverseBytes((short) 1));
            this.Zz.writeShort(Short.reverseBytes(this.ZC));
            this.Zz.writeInt(Integer.reverseBytes(this.frequency));
            this.Zz.writeInt(Integer.reverseBytes(((this.frequency * this.ZC) * this.ZD) / 8));
            this.Zz.writeShort(Short.reverseBytes((short) ((this.ZC * this.ZD) / 8)));
            this.Zz.writeShort(Short.reverseBytes(this.ZD));
            this.Zz.writeBytes("data");
            this.Zz.writeInt(0);
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
