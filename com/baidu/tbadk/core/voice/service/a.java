package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements d {
    private RandomAccessFile aqD;
    private int aqE;
    private int aqF;
    private short aqG;
    private short aqH;
    private int dataSize;
    private String filePath;
    private int frequency;
    public static int aqx = 8000;
    public static int aqy = 2;
    public static int aqz = 2;
    public static int aqA = 1;
    private int aqB = 0;
    private boolean aqC = false;
    private AudioRecord mAudioRecord = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.aqB = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.frequency = i2;
        this.aqE = i3;
        this.aqF = i4;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
        }
        this.mAudioRecord = new AudioRecord(i, this.frequency, this.aqE, this.aqF, this.aqB);
        this.aqG = (short) (this.aqE == 12 ? 2 : 1);
        this.aqH = (short) (this.aqF == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.aqD != null) {
                try {
                    this.aqD.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.aqD = new RandomAccessFile(this.file, "rw");
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
    public boolean eA(String str) {
        return a(aqA, aqx, aqy, aqz, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xB() {
        if (this.mAudioRecord != null && this.file != null) {
            try {
                this.aqC = true;
                byte[] bArr = new byte[this.aqB];
                this.mAudioRecord.startRecording();
                while (this.aqC) {
                    this.mAudioRecord.read(bArr, 0, bArr.length);
                    this.aqD.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.aqD.seek(4L);
                this.aqD.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.aqD.seek(40L);
                this.aqD.writeInt(Integer.reverseBytes(this.dataSize));
                this.aqD.close();
                this.mAudioRecord.stop();
                this.mAudioRecord.release();
                this.aqC = false;
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
        this.aqC = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean isRecording() {
        return this.aqC;
    }

    private void xE() {
        try {
            this.aqD.setLength(0L);
            this.aqD.writeBytes("RIFF");
            this.aqD.writeInt(0);
            this.aqD.writeBytes("WAVE");
            this.aqD.writeBytes("fmt ");
            this.aqD.writeInt(Integer.reverseBytes(16));
            this.aqD.writeShort(Short.reverseBytes((short) 1));
            this.aqD.writeShort(Short.reverseBytes(this.aqG));
            this.aqD.writeInt(Integer.reverseBytes(this.frequency));
            this.aqD.writeInt(Integer.reverseBytes(((this.frequency * this.aqG) * this.aqH) / 8));
            this.aqD.writeShort(Short.reverseBytes((short) ((this.aqG * this.aqH) / 8)));
            this.aqD.writeShort(Short.reverseBytes(this.aqH));
            this.aqD.writeBytes("data");
            this.aqD.writeInt(0);
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
