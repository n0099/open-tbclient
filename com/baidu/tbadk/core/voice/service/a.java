package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements i {
    public static int aiA = 8000;
    public static int aiB = 2;
    public static int aiC = 2;
    public static int aiD = 1;
    private RandomAccessFile aiH;
    private int aiI;
    private int aiJ;
    private short aiK;
    private short aiL;
    private int dataSize;
    private String filePath;
    private int frequency;
    private int aiE = 0;
    private boolean aiF = false;
    private AudioRecord aiG = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.aiE = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.frequency = i2;
        this.aiI = i3;
        this.aiJ = i4;
        if (this.aiG != null) {
            this.aiG.release();
        }
        this.aiG = new AudioRecord(i, this.frequency, this.aiI, this.aiJ, this.aiE);
        this.aiK = (short) (this.aiI == 12 ? 2 : 1);
        this.aiL = (short) (this.aiJ == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.aiH != null) {
                try {
                    this.aiH.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.aiH = new RandomAccessFile(this.file, "rw");
                xa();
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
    public boolean ec(String str) {
        return a(aiD, aiA, aiB, aiC, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wW() {
        if (this.aiG != null && this.file != null) {
            try {
                this.aiF = true;
                byte[] bArr = new byte[this.aiE];
                this.aiG.startRecording();
                while (this.aiF) {
                    this.aiG.read(bArr, 0, bArr.length);
                    this.aiH.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.aiH.seek(4L);
                this.aiH.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.aiH.seek(40L);
                this.aiH.writeInt(Integer.reverseBytes(this.dataSize));
                this.aiH.close();
                this.aiG.stop();
                this.aiG.release();
                this.aiF = false;
            } catch (Throwable th) {
                if (this.file.exists()) {
                    this.file.delete();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean wX() {
        Thread thread = new Thread(new b(this));
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public void wY() {
        this.aiF = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean wZ() {
        return this.aiF;
    }

    private void xa() {
        try {
            this.aiH.setLength(0L);
            this.aiH.writeBytes("RIFF");
            this.aiH.writeInt(0);
            this.aiH.writeBytes("WAVE");
            this.aiH.writeBytes("fmt ");
            this.aiH.writeInt(Integer.reverseBytes(16));
            this.aiH.writeShort(Short.reverseBytes((short) 1));
            this.aiH.writeShort(Short.reverseBytes(this.aiK));
            this.aiH.writeInt(Integer.reverseBytes(this.frequency));
            this.aiH.writeInt(Integer.reverseBytes(((this.frequency * this.aiK) * this.aiL) / 8));
            this.aiH.writeShort(Short.reverseBytes((short) ((this.aiK * this.aiL) / 8)));
            this.aiH.writeShort(Short.reverseBytes(this.aiL));
            this.aiH.writeBytes("data");
            this.aiH.writeInt(0);
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
