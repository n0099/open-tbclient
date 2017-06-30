package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements i {
    public static int aom = 8000;
    public static int aon = 2;
    public static int aoo = 2;
    public static int aop = 1;
    private RandomAccessFile aos;
    private int aot;
    private int aou;
    private short aov;
    private short aow;
    private int dataSize;
    private String filePath;
    private int frequency;
    private int aoq = 0;
    private boolean aor = false;
    private AudioRecord mAudioRecord = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.aoq = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.frequency = i2;
        this.aot = i3;
        this.aou = i4;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
        }
        this.mAudioRecord = new AudioRecord(i, this.frequency, this.aot, this.aou, this.aoq);
        this.aov = (short) (this.aot == 12 ? 2 : 1);
        this.aow = (short) (this.aou == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.aos != null) {
                try {
                    this.aos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.aos = new RandomAccessFile(this.file, "rw");
                xl();
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
    public boolean er(String str) {
        return a(aop, aom, aon, aoo, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xi() {
        if (this.mAudioRecord != null && this.file != null) {
            try {
                this.aor = true;
                byte[] bArr = new byte[this.aoq];
                this.mAudioRecord.startRecording();
                while (this.aor) {
                    this.mAudioRecord.read(bArr, 0, bArr.length);
                    this.aos.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.aos.seek(4L);
                this.aos.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.aos.seek(40L);
                this.aos.writeInt(Integer.reverseBytes(this.dataSize));
                this.aos.close();
                this.mAudioRecord.stop();
                this.mAudioRecord.release();
                this.aor = false;
            } catch (Throwable th) {
                if (this.file.exists()) {
                    this.file.delete();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean xj() {
        Thread thread = new Thread(new b(this));
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public void xk() {
        this.aor = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean isRecording() {
        return this.aor;
    }

    private void xl() {
        try {
            this.aos.setLength(0L);
            this.aos.writeBytes("RIFF");
            this.aos.writeInt(0);
            this.aos.writeBytes("WAVE");
            this.aos.writeBytes("fmt ");
            this.aos.writeInt(Integer.reverseBytes(16));
            this.aos.writeShort(Short.reverseBytes((short) 1));
            this.aos.writeShort(Short.reverseBytes(this.aov));
            this.aos.writeInt(Integer.reverseBytes(this.frequency));
            this.aos.writeInt(Integer.reverseBytes(((this.frequency * this.aov) * this.aow) / 8));
            this.aos.writeShort(Short.reverseBytes((short) ((this.aov * this.aow) / 8)));
            this.aos.writeShort(Short.reverseBytes(this.aow));
            this.aos.writeBytes("data");
            this.aos.writeInt(0);
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
