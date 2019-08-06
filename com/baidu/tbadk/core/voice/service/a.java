package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements d {
    public static int cew = 8000;
    public static int cex = 2;
    public static int cey = 2;
    public static int cez = 1;
    private RandomAccessFile ceA;
    private int ceB;
    private int ceC;
    private short ceD;
    private short ceE;
    private int channelConfiguration;
    private int dataSize;
    private String filePath;
    private int bufferSize = 0;
    private boolean TW = false;
    private AudioRecord mAudioRecord = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.ceB = i2;
        this.channelConfiguration = i3;
        this.ceC = i4;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
        }
        this.mAudioRecord = new AudioRecord(i, this.ceB, this.channelConfiguration, this.ceC, this.bufferSize);
        this.ceD = (short) (this.channelConfiguration == 12 ? 2 : 1);
        this.ceE = (short) (this.ceC == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.ceA != null) {
                try {
                    this.ceA.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.ceA = new RandomAccessFile(this.file, "rw");
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
        return a(cez, cew, cex, cey, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alz() {
        if (this.mAudioRecord != null && this.file != null) {
            try {
                this.TW = true;
                byte[] bArr = new byte[this.bufferSize];
                this.mAudioRecord.startRecording();
                while (this.TW) {
                    this.mAudioRecord.read(bArr, 0, bArr.length);
                    this.ceA.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.ceA.seek(4L);
                this.ceA.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.ceA.seek(40L);
                this.ceA.writeInt(Integer.reverseBytes(this.dataSize));
                this.ceA.close();
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
    public boolean alA() {
        Thread thread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.alz();
            }
        });
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void alB() {
        this.TW = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean alC() {
        return this.TW;
    }

    private void writeHeader() {
        try {
            this.ceA.setLength(0L);
            this.ceA.writeBytes("RIFF");
            this.ceA.writeInt(0);
            this.ceA.writeBytes("WAVE");
            this.ceA.writeBytes("fmt ");
            this.ceA.writeInt(Integer.reverseBytes(16));
            this.ceA.writeShort(Short.reverseBytes((short) 1));
            this.ceA.writeShort(Short.reverseBytes(this.ceD));
            this.ceA.writeInt(Integer.reverseBytes(this.ceB));
            this.ceA.writeInt(Integer.reverseBytes(((this.ceB * this.ceD) * this.ceE) / 8));
            this.ceA.writeShort(Short.reverseBytes((short) ((this.ceD * this.ceE) / 8)));
            this.ceA.writeShort(Short.reverseBytes(this.ceE));
            this.ceA.writeBytes("data");
            this.ceA.writeInt(0);
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
