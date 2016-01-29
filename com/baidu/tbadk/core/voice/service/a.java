package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements i {
    public static int ait = 8000;
    public static int aiu = 2;
    public static int aiv = 2;
    public static int aiw = 1;
    private RandomAccessFile aiA;
    private int aiB;
    private int aiC;
    private short aiD;
    private short aiE;
    private int dataSize;
    private String filePath;
    private int frequency;
    private int aix = 0;
    private boolean aiy = false;
    private AudioRecord aiz = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.aix = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.frequency = i2;
        this.aiB = i3;
        this.aiC = i4;
        if (this.aiz != null) {
            this.aiz.release();
        }
        this.aiz = new AudioRecord(i, this.frequency, this.aiB, this.aiC, this.aix);
        this.aiD = (short) (this.aiB == 12 ? 2 : 1);
        this.aiE = (short) (this.aiC == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.aiA != null) {
                try {
                    this.aiA.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.aiA = new RandomAccessFile(this.file, "rw");
                xD();
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
    public boolean dR(String str) {
        return a(aiw, ait, aiu, aiv, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xz() {
        if (this.aiz != null && this.file != null) {
            try {
                this.aiy = true;
                byte[] bArr = new byte[this.aix];
                this.aiz.startRecording();
                while (this.aiy) {
                    this.aiz.read(bArr, 0, bArr.length);
                    this.aiA.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.aiA.seek(4L);
                this.aiA.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.aiA.seek(40L);
                this.aiA.writeInt(Integer.reverseBytes(this.dataSize));
                this.aiA.close();
                this.aiz.stop();
                this.aiz.release();
                this.aiy = false;
            } catch (Throwable th) {
                if (this.file.exists()) {
                    this.file.delete();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean xA() {
        Thread thread = new Thread(new b(this));
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public void xB() {
        this.aiy = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean xC() {
        return this.aiy;
    }

    private void xD() {
        try {
            this.aiA.setLength(0L);
            this.aiA.writeBytes("RIFF");
            this.aiA.writeInt(0);
            this.aiA.writeBytes("WAVE");
            this.aiA.writeBytes("fmt ");
            this.aiA.writeInt(Integer.reverseBytes(16));
            this.aiA.writeShort(Short.reverseBytes((short) 1));
            this.aiA.writeShort(Short.reverseBytes(this.aiD));
            this.aiA.writeInt(Integer.reverseBytes(this.frequency));
            this.aiA.writeInt(Integer.reverseBytes(((this.frequency * this.aiD) * this.aiE) / 8));
            this.aiA.writeShort(Short.reverseBytes((short) ((this.aiD * this.aiE) / 8)));
            this.aiA.writeShort(Short.reverseBytes(this.aiE));
            this.aiA.writeBytes("data");
            this.aiA.writeInt(0);
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
