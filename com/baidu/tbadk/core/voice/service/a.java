package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements d {
    private RandomAccessFile aqE;
    private int aqF;
    private int aqG;
    private short aqH;
    private short aqI;
    private int dataSize;
    private String filePath;
    private int frequency;
    public static int aqy = 8000;
    public static int aqz = 2;
    public static int aqA = 2;
    public static int aqB = 1;
    private int aqC = 0;
    private boolean aqD = false;
    private AudioRecord mAudioRecord = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.aqC = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.frequency = i2;
        this.aqF = i3;
        this.aqG = i4;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
        }
        this.mAudioRecord = new AudioRecord(i, this.frequency, this.aqF, this.aqG, this.aqC);
        this.aqH = (short) (this.aqF == 12 ? 2 : 1);
        this.aqI = (short) (this.aqG == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.aqE != null) {
                try {
                    this.aqE.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.aqE = new RandomAccessFile(this.file, "rw");
                xE();
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

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean eE(String str) {
        return a(aqB, aqy, aqz, aqA, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xB() {
        if (this.mAudioRecord != null && this.file != null) {
            try {
                this.aqD = true;
                byte[] bArr = new byte[this.aqC];
                this.mAudioRecord.startRecording();
                while (this.aqD) {
                    this.mAudioRecord.read(bArr, 0, bArr.length);
                    this.aqE.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.aqE.seek(4L);
                this.aqE.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.aqE.seek(40L);
                this.aqE.writeInt(Integer.reverseBytes(this.dataSize));
                this.aqE.close();
                this.mAudioRecord.stop();
                this.mAudioRecord.release();
                this.aqD = false;
            } catch (Throwable th) {
                if (this.file.exists()) {
                    this.file.delete();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean xC() {
        Thread thread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.xB();
            }
        });
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void xD() {
        this.aqD = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean isRecording() {
        return this.aqD;
    }

    private void xE() {
        try {
            this.aqE.setLength(0L);
            this.aqE.writeBytes("RIFF");
            this.aqE.writeInt(0);
            this.aqE.writeBytes("WAVE");
            this.aqE.writeBytes("fmt ");
            this.aqE.writeInt(Integer.reverseBytes(16));
            this.aqE.writeShort(Short.reverseBytes((short) 1));
            this.aqE.writeShort(Short.reverseBytes(this.aqH));
            this.aqE.writeInt(Integer.reverseBytes(this.frequency));
            this.aqE.writeInt(Integer.reverseBytes(((this.frequency * this.aqH) * this.aqI) / 8));
            this.aqE.writeShort(Short.reverseBytes((short) ((this.aqH * this.aqI) / 8)));
            this.aqE.writeShort(Short.reverseBytes(this.aqI));
            this.aqE.writeBytes("data");
            this.aqE.writeInt(0);
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
