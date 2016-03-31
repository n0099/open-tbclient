package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements i {
    public static int aiJ = 8000;
    public static int aiK = 2;
    public static int aiL = 2;
    public static int aiM = 1;
    private RandomAccessFile aiQ;
    private int aiR;
    private int aiS;
    private short aiT;
    private short aiU;
    private int dataSize;
    private String filePath;
    private int frequency;
    private int aiN = 0;
    private boolean aiO = false;
    private AudioRecord aiP = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.aiN = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.frequency = i2;
        this.aiR = i3;
        this.aiS = i4;
        if (this.aiP != null) {
            this.aiP.release();
        }
        this.aiP = new AudioRecord(i, this.frequency, this.aiR, this.aiS, this.aiN);
        this.aiT = (short) (this.aiR == 12 ? 2 : 1);
        this.aiU = (short) (this.aiS == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.aiQ != null) {
                try {
                    this.aiQ.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.aiQ = new RandomAccessFile(this.file, "rw");
                ye();
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
        return a(aiM, aiJ, aiK, aiL, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ya() {
        if (this.aiP != null && this.file != null) {
            try {
                this.aiO = true;
                byte[] bArr = new byte[this.aiN];
                this.aiP.startRecording();
                while (this.aiO) {
                    this.aiP.read(bArr, 0, bArr.length);
                    this.aiQ.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.aiQ.seek(4L);
                this.aiQ.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.aiQ.seek(40L);
                this.aiQ.writeInt(Integer.reverseBytes(this.dataSize));
                this.aiQ.close();
                this.aiP.stop();
                this.aiP.release();
                this.aiO = false;
            } catch (Throwable th) {
                if (this.file.exists()) {
                    this.file.delete();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean yb() {
        Thread thread = new Thread(new b(this));
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public void yc() {
        this.aiO = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean yd() {
        return this.aiO;
    }

    private void ye() {
        try {
            this.aiQ.setLength(0L);
            this.aiQ.writeBytes("RIFF");
            this.aiQ.writeInt(0);
            this.aiQ.writeBytes("WAVE");
            this.aiQ.writeBytes("fmt ");
            this.aiQ.writeInt(Integer.reverseBytes(16));
            this.aiQ.writeShort(Short.reverseBytes((short) 1));
            this.aiQ.writeShort(Short.reverseBytes(this.aiT));
            this.aiQ.writeInt(Integer.reverseBytes(this.frequency));
            this.aiQ.writeInt(Integer.reverseBytes(((this.frequency * this.aiT) * this.aiU) / 8));
            this.aiQ.writeShort(Short.reverseBytes((short) ((this.aiT * this.aiU) / 8)));
            this.aiQ.writeShort(Short.reverseBytes(this.aiU));
            this.aiQ.writeBytes("data");
            this.aiQ.writeInt(0);
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
