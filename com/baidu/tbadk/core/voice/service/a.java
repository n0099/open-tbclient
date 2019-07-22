package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements d {
    public static int cep = 8000;
    public static int ceq = 2;
    public static int cer = 2;
    public static int ces = 1;
    private RandomAccessFile cet;
    private int ceu;
    private int cev;
    private short cew;
    private short cex;
    private int channelConfiguration;
    private int dataSize;
    private String filePath;
    private int bufferSize = 0;
    private boolean TW = false;
    private AudioRecord mAudioRecord = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.ceu = i2;
        this.channelConfiguration = i3;
        this.cev = i4;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
        }
        this.mAudioRecord = new AudioRecord(i, this.ceu, this.channelConfiguration, this.cev, this.bufferSize);
        this.cew = (short) (this.channelConfiguration == 12 ? 2 : 1);
        this.cex = (short) (this.cev == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.cet != null) {
                try {
                    this.cet.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.cet = new RandomAccessFile(this.file, "rw");
                writeHeader();
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
    public boolean oY(String str) {
        return a(ces, cep, ceq, cer, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alx() {
        if (this.mAudioRecord != null && this.file != null) {
            try {
                this.TW = true;
                byte[] bArr = new byte[this.bufferSize];
                this.mAudioRecord.startRecording();
                while (this.TW) {
                    this.mAudioRecord.read(bArr, 0, bArr.length);
                    this.cet.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.cet.seek(4L);
                this.cet.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.cet.seek(40L);
                this.cet.writeInt(Integer.reverseBytes(this.dataSize));
                this.cet.close();
                this.mAudioRecord.stop();
                this.mAudioRecord.release();
                this.TW = false;
            } catch (Throwable th) {
                if (this.file.exists()) {
                    this.file.delete();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean aly() {
        Thread thread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.alx();
            }
        });
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void alz() {
        this.TW = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean alA() {
        return this.TW;
    }

    private void writeHeader() {
        try {
            this.cet.setLength(0L);
            this.cet.writeBytes("RIFF");
            this.cet.writeInt(0);
            this.cet.writeBytes("WAVE");
            this.cet.writeBytes("fmt ");
            this.cet.writeInt(Integer.reverseBytes(16));
            this.cet.writeShort(Short.reverseBytes((short) 1));
            this.cet.writeShort(Short.reverseBytes(this.cew));
            this.cet.writeInt(Integer.reverseBytes(this.ceu));
            this.cet.writeInt(Integer.reverseBytes(((this.ceu * this.cew) * this.cex) / 8));
            this.cet.writeShort(Short.reverseBytes((short) ((this.cew * this.cex) / 8)));
            this.cet.writeShort(Short.reverseBytes(this.cex));
            this.cet.writeBytes("data");
            this.cet.writeInt(0);
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
