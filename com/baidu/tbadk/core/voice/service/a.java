package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements i {
    public static int anm = 8000;
    public static int ann = 2;
    public static int ano = 2;
    public static int anp = 1;
    private RandomAccessFile ans;
    private int ant;
    private int anu;
    private short anv;
    private short anw;
    private int dataSize;
    private String filePath;
    private int frequency;
    private int anq = 0;
    private boolean anr = false;
    private AudioRecord mAudioRecord = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.anq = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.frequency = i2;
        this.ant = i3;
        this.anu = i4;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
        }
        this.mAudioRecord = new AudioRecord(i, this.frequency, this.ant, this.anu, this.anq);
        this.anv = (short) (this.ant == 12 ? 2 : 1);
        this.anw = (short) (this.anu == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.ans != null) {
                try {
                    this.ans.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.ans = new RandomAccessFile(this.file, "rw");
                wT();
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
        return a(anp, anm, ann, ano, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wQ() {
        if (this.mAudioRecord != null && this.file != null) {
            try {
                this.anr = true;
                byte[] bArr = new byte[this.anq];
                this.mAudioRecord.startRecording();
                while (this.anr) {
                    this.mAudioRecord.read(bArr, 0, bArr.length);
                    this.ans.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.ans.seek(4L);
                this.ans.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.ans.seek(40L);
                this.ans.writeInt(Integer.reverseBytes(this.dataSize));
                this.ans.close();
                this.mAudioRecord.stop();
                this.mAudioRecord.release();
                this.anr = false;
            } catch (Throwable th) {
                if (this.file.exists()) {
                    this.file.delete();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean wR() {
        Thread thread = new Thread(new b(this));
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public void wS() {
        this.anr = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean isRecording() {
        return this.anr;
    }

    private void wT() {
        try {
            this.ans.setLength(0L);
            this.ans.writeBytes("RIFF");
            this.ans.writeInt(0);
            this.ans.writeBytes("WAVE");
            this.ans.writeBytes("fmt ");
            this.ans.writeInt(Integer.reverseBytes(16));
            this.ans.writeShort(Short.reverseBytes((short) 1));
            this.ans.writeShort(Short.reverseBytes(this.anv));
            this.ans.writeInt(Integer.reverseBytes(this.frequency));
            this.ans.writeInt(Integer.reverseBytes(((this.frequency * this.anv) * this.anw) / 8));
            this.ans.writeShort(Short.reverseBytes((short) ((this.anv * this.anw) / 8)));
            this.ans.writeShort(Short.reverseBytes(this.anw));
            this.ans.writeBytes("data");
            this.ans.writeInt(0);
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
