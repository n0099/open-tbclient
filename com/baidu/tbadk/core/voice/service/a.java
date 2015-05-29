package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import android.util.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements j {
    public static int aat = 8000;
    public static int aau = 2;
    public static int aav = 2;
    public static int aaw = 1;
    private RandomAccessFile aaA;
    private int aaB;
    private int aaC;
    private short aaD;
    private short aaE;
    private int dataSize;
    private String filePath;
    private int frequency;
    private int aax = 0;
    private boolean aay = false;
    private AudioRecord aaz = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.aax = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.frequency = i2;
        this.aaB = i3;
        this.aaC = i4;
        if (this.aaz != null) {
            this.aaz.release();
        }
        this.aaz = new AudioRecord(i, this.frequency, this.aaB, this.aaC, this.aax);
        this.aaD = (short) (this.aaB == 12 ? 2 : 1);
        this.aaE = (short) (this.aaC == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.aaA != null) {
                try {
                    this.aaA.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.aaA = new RandomAccessFile(this.file, "rw");
                uM();
                setFilePath(this.file.getParent());
                return true;
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
                return false;
            }
        } catch (IOException e3) {
            this.file = null;
            Log.e("create file error in audio record", e3.getMessage());
            return false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.j
    public boolean dv(String str) {
        return a(aaw, aat, aau, aav, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uI() {
        if (this.aaz != null && this.file != null) {
            try {
                this.aay = true;
                byte[] bArr = new byte[this.aax];
                this.aaz.startRecording();
                while (this.aay) {
                    this.aaz.read(bArr, 0, bArr.length);
                    this.aaA.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.aaA.seek(4L);
                this.aaA.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.aaA.seek(40L);
                this.aaA.writeInt(Integer.reverseBytes(this.dataSize));
                this.aaA.close();
                this.aaz.stop();
                this.aaz.release();
                this.aay = false;
            } catch (Throwable th) {
                Log.e("AudioRecord", "Recording Failed");
                if (this.file.exists()) {
                    this.file.delete();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.j
    public boolean uJ() {
        Thread thread = new Thread(new b(this));
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.j
    public void uK() {
        this.aay = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.j
    public boolean uL() {
        return this.aay;
    }

    private void uM() {
        try {
            this.aaA.setLength(0L);
            this.aaA.writeBytes("RIFF");
            this.aaA.writeInt(0);
            this.aaA.writeBytes("WAVE");
            this.aaA.writeBytes("fmt ");
            this.aaA.writeInt(Integer.reverseBytes(16));
            this.aaA.writeShort(Short.reverseBytes((short) 1));
            this.aaA.writeShort(Short.reverseBytes(this.aaD));
            this.aaA.writeInt(Integer.reverseBytes(this.frequency));
            this.aaA.writeInt(Integer.reverseBytes(((this.frequency * this.aaD) * this.aaE) / 8));
            this.aaA.writeShort(Short.reverseBytes((short) ((this.aaD * this.aaE) / 8)));
            this.aaA.writeShort(Short.reverseBytes(this.aaE));
            this.aaA.writeBytes("data");
            this.aaA.writeInt(0);
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
