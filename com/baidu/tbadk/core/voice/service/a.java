package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements i {
    private RandomAccessFile anD;
    private int anE;
    private int anF;
    private short anG;
    private short anH;
    private int dataSize;
    private String filePath;
    private int frequency;
    public static int anx = 8000;
    public static int any = 2;
    public static int anz = 2;
    public static int anA = 1;
    private int anB = 0;
    private boolean anC = false;
    private AudioRecord mAudioRecord = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.anB = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.frequency = i2;
        this.anE = i3;
        this.anF = i4;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
        }
        this.mAudioRecord = new AudioRecord(i, this.frequency, this.anE, this.anF, this.anB);
        this.anG = (short) (this.anE == 12 ? 2 : 1);
        this.anH = (short) (this.anF == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.anD != null) {
                try {
                    this.anD.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.anD = new RandomAccessFile(this.file, "rw");
                xM();
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
    public boolean ea(String str) {
        return a(anA, anx, any, anz, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xJ() {
        if (this.mAudioRecord != null && this.file != null) {
            try {
                this.anC = true;
                byte[] bArr = new byte[this.anB];
                this.mAudioRecord.startRecording();
                while (this.anC) {
                    this.mAudioRecord.read(bArr, 0, bArr.length);
                    this.anD.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.anD.seek(4L);
                this.anD.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.anD.seek(40L);
                this.anD.writeInt(Integer.reverseBytes(this.dataSize));
                this.anD.close();
                this.mAudioRecord.stop();
                this.mAudioRecord.release();
                this.anC = false;
            } catch (Throwable th) {
                if (this.file.exists()) {
                    this.file.delete();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean xK() {
        Thread thread = new Thread(new b(this));
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public void xL() {
        this.anC = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean isRecording() {
        return this.anC;
    }

    private void xM() {
        try {
            this.anD.setLength(0L);
            this.anD.writeBytes("RIFF");
            this.anD.writeInt(0);
            this.anD.writeBytes("WAVE");
            this.anD.writeBytes("fmt ");
            this.anD.writeInt(Integer.reverseBytes(16));
            this.anD.writeShort(Short.reverseBytes((short) 1));
            this.anD.writeShort(Short.reverseBytes(this.anG));
            this.anD.writeInt(Integer.reverseBytes(this.frequency));
            this.anD.writeInt(Integer.reverseBytes(((this.frequency * this.anG) * this.anH) / 8));
            this.anD.writeShort(Short.reverseBytes((short) ((this.anG * this.anH) / 8)));
            this.anD.writeShort(Short.reverseBytes(this.anH));
            this.anD.writeBytes("data");
            this.anD.writeInt(0);
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
