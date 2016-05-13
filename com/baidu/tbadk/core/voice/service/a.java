package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements i {
    public static int aev = 8000;
    public static int aew = 2;
    public static int aex = 2;
    public static int aey = 1;
    private RandomAccessFile aeC;
    private int aeD;
    private int aeE;
    private short aeF;
    private short aeG;
    private int dataSize;
    private String filePath;
    private int frequency;
    private int aez = 0;
    private boolean aeA = false;
    private AudioRecord aeB = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.aez = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.frequency = i2;
        this.aeD = i3;
        this.aeE = i4;
        if (this.aeB != null) {
            this.aeB.release();
        }
        this.aeB = new AudioRecord(i, this.frequency, this.aeD, this.aeE, this.aez);
        this.aeF = (short) (this.aeD == 12 ? 2 : 1);
        this.aeG = (short) (this.aeE == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.aeC != null) {
                try {
                    this.aeC.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.aeC = new RandomAccessFile(this.file, "rw");
                vZ();
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
    public boolean dU(String str) {
        return a(aey, aev, aew, aex, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vV() {
        if (this.aeB != null && this.file != null) {
            try {
                this.aeA = true;
                byte[] bArr = new byte[this.aez];
                this.aeB.startRecording();
                while (this.aeA) {
                    this.aeB.read(bArr, 0, bArr.length);
                    this.aeC.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.aeC.seek(4L);
                this.aeC.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.aeC.seek(40L);
                this.aeC.writeInt(Integer.reverseBytes(this.dataSize));
                this.aeC.close();
                this.aeB.stop();
                this.aeB.release();
                this.aeA = false;
            } catch (Throwable th) {
                if (this.file.exists()) {
                    this.file.delete();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean vW() {
        Thread thread = new Thread(new b(this));
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public void vX() {
        this.aeA = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean vY() {
        return this.aeA;
    }

    private void vZ() {
        try {
            this.aeC.setLength(0L);
            this.aeC.writeBytes("RIFF");
            this.aeC.writeInt(0);
            this.aeC.writeBytes("WAVE");
            this.aeC.writeBytes("fmt ");
            this.aeC.writeInt(Integer.reverseBytes(16));
            this.aeC.writeShort(Short.reverseBytes((short) 1));
            this.aeC.writeShort(Short.reverseBytes(this.aeF));
            this.aeC.writeInt(Integer.reverseBytes(this.frequency));
            this.aeC.writeInt(Integer.reverseBytes(((this.frequency * this.aeF) * this.aeG) / 8));
            this.aeC.writeShort(Short.reverseBytes((short) ((this.aeF * this.aeG) / 8)));
            this.aeC.writeShort(Short.reverseBytes(this.aeG));
            this.aeC.writeBytes("data");
            this.aeC.writeInt(0);
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
