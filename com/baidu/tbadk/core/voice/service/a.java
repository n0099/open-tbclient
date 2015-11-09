package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements i {
    public static int aeZ = 8000;
    public static int afa = 2;
    public static int afb = 2;
    public static int afc = 1;
    private RandomAccessFile afg;
    private int afh;
    private int afi;
    private short afj;
    private short afk;
    private int dataSize;
    private String filePath;
    private int frequency;
    private int afd = 0;
    private boolean afe = false;
    private AudioRecord aff = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.afd = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.frequency = i2;
        this.afh = i3;
        this.afi = i4;
        if (this.aff != null) {
            this.aff.release();
        }
        this.aff = new AudioRecord(i, this.frequency, this.afh, this.afi, this.afd);
        this.afj = (short) (this.afh == 12 ? 2 : 1);
        this.afk = (short) (this.afi == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.afg != null) {
                try {
                    this.afg.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.afg = new RandomAccessFile(this.file, "rw");
                vP();
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
        return a(afc, aeZ, afa, afb, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vL() {
        if (this.aff != null && this.file != null) {
            try {
                this.afe = true;
                byte[] bArr = new byte[this.afd];
                this.aff.startRecording();
                while (this.afe) {
                    this.aff.read(bArr, 0, bArr.length);
                    this.afg.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.afg.seek(4L);
                this.afg.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.afg.seek(40L);
                this.afg.writeInt(Integer.reverseBytes(this.dataSize));
                this.afg.close();
                this.aff.stop();
                this.aff.release();
                this.afe = false;
            } catch (Throwable th) {
                if (this.file.exists()) {
                    this.file.delete();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean vM() {
        Thread thread = new Thread(new b(this));
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public void vN() {
        this.afe = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean vO() {
        return this.afe;
    }

    private void vP() {
        try {
            this.afg.setLength(0L);
            this.afg.writeBytes("RIFF");
            this.afg.writeInt(0);
            this.afg.writeBytes("WAVE");
            this.afg.writeBytes("fmt ");
            this.afg.writeInt(Integer.reverseBytes(16));
            this.afg.writeShort(Short.reverseBytes((short) 1));
            this.afg.writeShort(Short.reverseBytes(this.afj));
            this.afg.writeInt(Integer.reverseBytes(this.frequency));
            this.afg.writeInt(Integer.reverseBytes(((this.frequency * this.afj) * this.afk) / 8));
            this.afg.writeShort(Short.reverseBytes((short) ((this.afj * this.afk) / 8)));
            this.afg.writeShort(Short.reverseBytes(this.afk));
            this.afg.writeBytes("data");
            this.afg.writeInt(0);
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
