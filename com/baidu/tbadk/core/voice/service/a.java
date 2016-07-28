package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements i {
    public static int afK = 8000;
    public static int afL = 2;
    public static int afM = 2;
    public static int afN = 1;
    private RandomAccessFile afR;
    private int afS;
    private int afT;
    private short afU;
    private short afV;
    private int dataSize;
    private String filePath;
    private int frequency;
    private int afO = 0;
    private boolean afP = false;
    private AudioRecord afQ = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.afO = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.frequency = i2;
        this.afS = i3;
        this.afT = i4;
        if (this.afQ != null) {
            this.afQ.release();
        }
        this.afQ = new AudioRecord(i, this.frequency, this.afS, this.afT, this.afO);
        this.afU = (short) (this.afS == 12 ? 2 : 1);
        this.afV = (short) (this.afT == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.afR != null) {
                try {
                    this.afR.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.afR = new RandomAccessFile(this.file, "rw");
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
    public boolean dX(String str) {
        return a(afN, afK, afL, afM, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vY() {
        if (this.afQ != null && this.file != null) {
            try {
                this.afP = true;
                byte[] bArr = new byte[this.afO];
                this.afQ.startRecording();
                while (this.afP) {
                    this.afQ.read(bArr, 0, bArr.length);
                    this.afR.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.afR.seek(4L);
                this.afR.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.afR.seek(40L);
                this.afR.writeInt(Integer.reverseBytes(this.dataSize));
                this.afR.close();
                this.afQ.stop();
                this.afQ.release();
                this.afP = false;
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
        this.afP = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean wb() {
        return this.afP;
    }

    private void wc() {
        try {
            this.afR.setLength(0L);
            this.afR.writeBytes("RIFF");
            this.afR.writeInt(0);
            this.afR.writeBytes("WAVE");
            this.afR.writeBytes("fmt ");
            this.afR.writeInt(Integer.reverseBytes(16));
            this.afR.writeShort(Short.reverseBytes((short) 1));
            this.afR.writeShort(Short.reverseBytes(this.afU));
            this.afR.writeInt(Integer.reverseBytes(this.frequency));
            this.afR.writeInt(Integer.reverseBytes(((this.frequency * this.afU) * this.afV) / 8));
            this.afR.writeShort(Short.reverseBytes((short) ((this.afU * this.afV) / 8)));
            this.afR.writeShort(Short.reverseBytes(this.afV));
            this.afR.writeBytes("data");
            this.afR.writeInt(0);
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
