package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements i {
    public static int aiZ = 8000;
    public static int aja = 2;
    public static int ajb = 2;
    public static int ajc = 1;
    private RandomAccessFile ajg;
    private int ajh;
    private int aji;
    private short ajj;
    private short ajk;
    private int dataSize;
    private String filePath;
    private int frequency;
    private int ajd = 0;
    private boolean aje = false;
    private AudioRecord ajf = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.ajd = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.frequency = i2;
        this.ajh = i3;
        this.aji = i4;
        if (this.ajf != null) {
            this.ajf.release();
        }
        this.ajf = new AudioRecord(i, this.frequency, this.ajh, this.aji, this.ajd);
        this.ajj = (short) (this.ajh == 12 ? 2 : 1);
        this.ajk = (short) (this.aji == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.ajg != null) {
                try {
                    this.ajg.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.ajg = new RandomAccessFile(this.file, "rw");
                xn();
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
    public boolean ef(String str) {
        return a(ajc, aiZ, aja, ajb, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj() {
        if (this.ajf != null && this.file != null) {
            try {
                this.aje = true;
                byte[] bArr = new byte[this.ajd];
                this.ajf.startRecording();
                while (this.aje) {
                    this.ajf.read(bArr, 0, bArr.length);
                    this.ajg.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.ajg.seek(4L);
                this.ajg.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.ajg.seek(40L);
                this.ajg.writeInt(Integer.reverseBytes(this.dataSize));
                this.ajg.close();
                this.ajf.stop();
                this.ajf.release();
                this.aje = false;
            } catch (Throwable th) {
                if (this.file.exists()) {
                    this.file.delete();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean xk() {
        Thread thread = new Thread(new b(this));
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public void xl() {
        this.aje = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean xm() {
        return this.aje;
    }

    private void xn() {
        try {
            this.ajg.setLength(0L);
            this.ajg.writeBytes("RIFF");
            this.ajg.writeInt(0);
            this.ajg.writeBytes("WAVE");
            this.ajg.writeBytes("fmt ");
            this.ajg.writeInt(Integer.reverseBytes(16));
            this.ajg.writeShort(Short.reverseBytes((short) 1));
            this.ajg.writeShort(Short.reverseBytes(this.ajj));
            this.ajg.writeInt(Integer.reverseBytes(this.frequency));
            this.ajg.writeInt(Integer.reverseBytes(((this.frequency * this.ajj) * this.ajk) / 8));
            this.ajg.writeShort(Short.reverseBytes((short) ((this.ajj * this.ajk) / 8)));
            this.ajg.writeShort(Short.reverseBytes(this.ajk));
            this.ajg.writeBytes("data");
            this.ajg.writeInt(0);
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
