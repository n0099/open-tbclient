package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements i {
    public static int aih = 8000;
    public static int aii = 2;
    public static int aij = 2;
    public static int aik = 1;
    private RandomAccessFile aio;
    private int aip;
    private int aiq;
    private short air;
    private short ais;
    private int dataSize;
    private String filePath;
    private int frequency;
    private int ail = 0;
    private boolean aim = false;
    private AudioRecord ain = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.ail = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.frequency = i2;
        this.aip = i3;
        this.aiq = i4;
        if (this.ain != null) {
            this.ain.release();
        }
        this.ain = new AudioRecord(i, this.frequency, this.aip, this.aiq, this.ail);
        this.air = (short) (this.aip == 12 ? 2 : 1);
        this.ais = (short) (this.aiq == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.aio != null) {
                try {
                    this.aio.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.aio = new RandomAccessFile(this.file, "rw");
                xi();
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
    public boolean ed(String str) {
        return a(aik, aih, aii, aij, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xe() {
        if (this.ain != null && this.file != null) {
            try {
                this.aim = true;
                byte[] bArr = new byte[this.ail];
                this.ain.startRecording();
                while (this.aim) {
                    this.ain.read(bArr, 0, bArr.length);
                    this.aio.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.aio.seek(4L);
                this.aio.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.aio.seek(40L);
                this.aio.writeInt(Integer.reverseBytes(this.dataSize));
                this.aio.close();
                this.ain.stop();
                this.ain.release();
                this.aim = false;
            } catch (Throwable th) {
                if (this.file.exists()) {
                    this.file.delete();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean xf() {
        Thread thread = new Thread(new b(this));
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public void xg() {
        this.aim = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean xh() {
        return this.aim;
    }

    private void xi() {
        try {
            this.aio.setLength(0L);
            this.aio.writeBytes("RIFF");
            this.aio.writeInt(0);
            this.aio.writeBytes("WAVE");
            this.aio.writeBytes("fmt ");
            this.aio.writeInt(Integer.reverseBytes(16));
            this.aio.writeShort(Short.reverseBytes((short) 1));
            this.aio.writeShort(Short.reverseBytes(this.air));
            this.aio.writeInt(Integer.reverseBytes(this.frequency));
            this.aio.writeInt(Integer.reverseBytes(((this.frequency * this.air) * this.ais) / 8));
            this.aio.writeShort(Short.reverseBytes((short) ((this.air * this.ais) / 8)));
            this.aio.writeShort(Short.reverseBytes(this.ais));
            this.aio.writeBytes("data");
            this.aio.writeInt(0);
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
