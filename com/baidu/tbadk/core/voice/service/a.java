package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import android.util.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements j {
    public static int Zq = 8000;
    public static int Zr = 2;
    public static int Zs = 2;
    public static int Zt = 1;
    private short ZA;
    private short ZB;
    private RandomAccessFile Zx;
    private int Zy;
    private int Zz;
    private int dataSize;
    private String filePath;
    private int frequency;
    private int Zu = 0;
    private boolean Zv = false;
    private AudioRecord Zw = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.Zu = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.frequency = i2;
        this.Zy = i3;
        this.Zz = i4;
        if (this.Zw != null) {
            this.Zw.release();
        }
        this.Zw = new AudioRecord(i, this.frequency, this.Zy, this.Zz, this.Zu);
        this.ZA = (short) (this.Zy == 12 ? 2 : 1);
        this.ZB = (short) (this.Zz == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.Zx != null) {
                try {
                    this.Zx.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.Zx = new RandomAccessFile(this.file, "rw");
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
        return a(Zt, Zq, Zr, Zs, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tZ() {
        if (this.Zw != null && this.file != null) {
            try {
                this.Zv = true;
                byte[] bArr = new byte[this.Zu];
                this.Zw.startRecording();
                while (this.Zv) {
                    this.Zw.read(bArr, 0, bArr.length);
                    this.Zx.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.Zx.seek(4L);
                this.Zx.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.Zx.seek(40L);
                this.Zx.writeInt(Integer.reverseBytes(this.dataSize));
                this.Zx.close();
                this.Zw.stop();
                this.Zw.release();
                this.Zv = false;
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
        this.Zv = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.j
    public boolean uc() {
        return this.Zv;
    }

    private void ud() {
        try {
            this.Zx.setLength(0L);
            this.Zx.writeBytes("RIFF");
            this.Zx.writeInt(0);
            this.Zx.writeBytes("WAVE");
            this.Zx.writeBytes("fmt ");
            this.Zx.writeInt(Integer.reverseBytes(16));
            this.Zx.writeShort(Short.reverseBytes((short) 1));
            this.Zx.writeShort(Short.reverseBytes(this.ZA));
            this.Zx.writeInt(Integer.reverseBytes(this.frequency));
            this.Zx.writeInt(Integer.reverseBytes(((this.frequency * this.ZA) * this.ZB) / 8));
            this.Zx.writeShort(Short.reverseBytes((short) ((this.ZA * this.ZB) / 8)));
            this.Zx.writeShort(Short.reverseBytes(this.ZB));
            this.Zx.writeBytes("data");
            this.Zx.writeInt(0);
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
