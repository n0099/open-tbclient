package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import android.util.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements j {
    public static int On = 8000;
    public static int Oo = 2;
    public static int Op = 2;
    public static int Oq = 1;
    private RandomAccessFile Ot;
    private int Ou;
    private int Ov;
    private short Ow;
    private short Ox;
    private int dataSize;
    private String filePath;
    private int frequency;
    private int Or = 0;
    private boolean mIsRecording = false;
    private AudioRecord Os = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.Or = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.frequency = i2;
        this.Ou = i3;
        this.Ov = i4;
        if (this.Os != null) {
            this.Os.release();
        }
        this.Os = new AudioRecord(i, this.frequency, this.Ou, this.Ov, this.Or);
        this.Ow = (short) (this.Ou == 12 ? 2 : 1);
        this.Ox = (short) (this.Ov == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.Ot != null) {
                try {
                    this.Ot.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.Ot = new RandomAccessFile(this.file, "rw");
                ra();
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
    public boolean cY(String str) {
        return a(Oq, On, Oo, Op, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qW() {
        if (this.Os != null && this.file != null) {
            try {
                this.mIsRecording = true;
                byte[] bArr = new byte[this.Or];
                this.Os.startRecording();
                while (this.mIsRecording) {
                    this.Os.read(bArr, 0, bArr.length);
                    this.Ot.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.Ot.seek(4L);
                this.Ot.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.Ot.seek(40L);
                this.Ot.writeInt(Integer.reverseBytes(this.dataSize));
                this.Ot.close();
                this.Os.stop();
                this.Os.release();
                this.mIsRecording = false;
            } catch (Throwable th) {
                Log.e("AudioRecord", "Recording Failed");
                if (this.file.exists()) {
                    this.file.delete();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.j
    public boolean qX() {
        Thread thread = new Thread(new b(this));
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.j
    public void qY() {
        this.mIsRecording = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.j
    public boolean qZ() {
        return this.mIsRecording;
    }

    private void ra() {
        try {
            this.Ot.setLength(0L);
            this.Ot.writeBytes("RIFF");
            this.Ot.writeInt(0);
            this.Ot.writeBytes("WAVE");
            this.Ot.writeBytes("fmt ");
            this.Ot.writeInt(Integer.reverseBytes(16));
            this.Ot.writeShort(Short.reverseBytes((short) 1));
            this.Ot.writeShort(Short.reverseBytes(this.Ow));
            this.Ot.writeInt(Integer.reverseBytes(this.frequency));
            this.Ot.writeInt(Integer.reverseBytes(((this.frequency * this.Ow) * this.Ox) / 8));
            this.Ot.writeShort(Short.reverseBytes((short) ((this.Ow * this.Ox) / 8)));
            this.Ot.writeShort(Short.reverseBytes(this.Ox));
            this.Ot.writeBytes("data");
            this.Ot.writeInt(0);
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
