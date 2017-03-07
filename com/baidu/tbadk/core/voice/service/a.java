package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements i {
    public static int anj = 8000;
    public static int ank = 2;
    public static int anl = 2;
    public static int anm = 1;
    private RandomAccessFile anp;
    private int anq;
    private int anr;
    private short ans;
    private short ant;
    private int dataSize;
    private String filePath;
    private int frequency;
    private int ann = 0;
    private boolean ano = false;
    private AudioRecord mAudioRecord = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.ann = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.frequency = i2;
        this.anq = i3;
        this.anr = i4;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
        }
        this.mAudioRecord = new AudioRecord(i, this.frequency, this.anq, this.anr, this.ann);
        this.ans = (short) (this.anq == 12 ? 2 : 1);
        this.ant = (short) (this.anr == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.anp != null) {
                try {
                    this.anp.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.anp = new RandomAccessFile(this.file, "rw");
                xq();
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
        return a(anm, anj, ank, anl, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xn() {
        if (this.mAudioRecord != null && this.file != null) {
            try {
                this.ano = true;
                byte[] bArr = new byte[this.ann];
                this.mAudioRecord.startRecording();
                while (this.ano) {
                    this.mAudioRecord.read(bArr, 0, bArr.length);
                    this.anp.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.anp.seek(4L);
                this.anp.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.anp.seek(40L);
                this.anp.writeInt(Integer.reverseBytes(this.dataSize));
                this.anp.close();
                this.mAudioRecord.stop();
                this.mAudioRecord.release();
                this.ano = false;
            } catch (Throwable th) {
                if (this.file.exists()) {
                    this.file.delete();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean xo() {
        Thread thread = new Thread(new b(this));
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public void xp() {
        this.ano = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean isRecording() {
        return this.ano;
    }

    private void xq() {
        try {
            this.anp.setLength(0L);
            this.anp.writeBytes("RIFF");
            this.anp.writeInt(0);
            this.anp.writeBytes("WAVE");
            this.anp.writeBytes("fmt ");
            this.anp.writeInt(Integer.reverseBytes(16));
            this.anp.writeShort(Short.reverseBytes((short) 1));
            this.anp.writeShort(Short.reverseBytes(this.ans));
            this.anp.writeInt(Integer.reverseBytes(this.frequency));
            this.anp.writeInt(Integer.reverseBytes(((this.frequency * this.ans) * this.ant) / 8));
            this.anp.writeShort(Short.reverseBytes((short) ((this.ans * this.ant) / 8)));
            this.anp.writeShort(Short.reverseBytes(this.ant));
            this.anp.writeBytes("data");
            this.anp.writeInt(0);
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
