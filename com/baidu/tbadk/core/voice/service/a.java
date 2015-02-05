package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import android.util.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements j {
    public static int Ok = 8000;
    public static int Ol = 2;
    public static int Om = 2;
    public static int On = 1;
    private RandomAccessFile Oq;
    private int Or;
    private int Os;
    private short Ot;
    private short Ou;
    private int dataSize;
    private String filePath;
    private int frequency;
    private int Oo = 0;
    private boolean mIsRecording = false;
    private AudioRecord Op = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.Oo = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.frequency = i2;
        this.Or = i3;
        this.Os = i4;
        if (this.Op != null) {
            this.Op.release();
        }
        this.Op = new AudioRecord(i, this.frequency, this.Or, this.Os, this.Oo);
        this.Ot = (short) (this.Or == 12 ? 2 : 1);
        this.Ou = (short) (this.Os == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.Oq != null) {
                try {
                    this.Oq.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.Oq = new RandomAccessFile(this.file, "rw");
                qU();
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
    public boolean cV(String str) {
        return a(On, Ok, Ol, Om, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qQ() {
        if (this.Op != null && this.file != null) {
            try {
                this.mIsRecording = true;
                byte[] bArr = new byte[this.Oo];
                this.Op.startRecording();
                while (this.mIsRecording) {
                    this.Op.read(bArr, 0, bArr.length);
                    this.Oq.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.Oq.seek(4L);
                this.Oq.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.Oq.seek(40L);
                this.Oq.writeInt(Integer.reverseBytes(this.dataSize));
                this.Oq.close();
                this.Op.stop();
                this.Op.release();
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
    public boolean qR() {
        Thread thread = new Thread(new b(this));
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.j
    public void qS() {
        this.mIsRecording = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.j
    public boolean qT() {
        return this.mIsRecording;
    }

    private void qU() {
        try {
            this.Oq.setLength(0L);
            this.Oq.writeBytes("RIFF");
            this.Oq.writeInt(0);
            this.Oq.writeBytes("WAVE");
            this.Oq.writeBytes("fmt ");
            this.Oq.writeInt(Integer.reverseBytes(16));
            this.Oq.writeShort(Short.reverseBytes((short) 1));
            this.Oq.writeShort(Short.reverseBytes(this.Ot));
            this.Oq.writeInt(Integer.reverseBytes(this.frequency));
            this.Oq.writeInt(Integer.reverseBytes(((this.frequency * this.Ot) * this.Ou) / 8));
            this.Oq.writeShort(Short.reverseBytes((short) ((this.Ot * this.Ou) / 8)));
            this.Oq.writeShort(Short.reverseBytes(this.Ou));
            this.Oq.writeBytes("data");
            this.Oq.writeInt(0);
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
