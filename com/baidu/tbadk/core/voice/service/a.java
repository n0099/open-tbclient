package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements d {
    public static int aMj = 8000;
    public static int aMk = 2;
    public static int aMl = 2;
    public static int aMm = 1;
    private RandomAccessFile aMn;
    private int aMo;
    private short aMp;
    private short aMq;
    private int channelConfiguration;
    private int dataSize;
    private String filePath;
    private int frequency;
    private int bufferSize = 0;
    private boolean Tc = false;
    private AudioRecord mAudioRecord = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.frequency = i2;
        this.channelConfiguration = i3;
        this.aMo = i4;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
        }
        this.mAudioRecord = new AudioRecord(i, this.frequency, this.channelConfiguration, this.aMo, this.bufferSize);
        this.aMp = (short) (this.channelConfiguration == 12 ? 2 : 1);
        this.aMq = (short) (this.aMo == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.aMn != null) {
                try {
                    this.aMn.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.aMn = new RandomAccessFile(this.file, "rw");
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
    public boolean gx(String str) {
        return a(aMm, aMj, aMk, aMl, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FO() {
        if (this.mAudioRecord != null && this.file != null) {
            try {
                this.Tc = true;
                byte[] bArr = new byte[this.bufferSize];
                this.mAudioRecord.startRecording();
                while (this.Tc) {
                    this.mAudioRecord.read(bArr, 0, bArr.length);
                    this.aMn.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.aMn.seek(4L);
                this.aMn.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.aMn.seek(40L);
                this.aMn.writeInt(Integer.reverseBytes(this.dataSize));
                this.aMn.close();
                this.mAudioRecord.stop();
                this.mAudioRecord.release();
                this.Tc = false;
            } catch (Throwable th) {
                if (this.file.exists()) {
                    this.file.delete();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean FP() {
        Thread thread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.FO();
            }
        });
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void FQ() {
        this.Tc = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean FR() {
        return this.Tc;
    }

    private void writeHeader() {
        try {
            this.aMn.setLength(0L);
            this.aMn.writeBytes("RIFF");
            this.aMn.writeInt(0);
            this.aMn.writeBytes("WAVE");
            this.aMn.writeBytes("fmt ");
            this.aMn.writeInt(Integer.reverseBytes(16));
            this.aMn.writeShort(Short.reverseBytes((short) 1));
            this.aMn.writeShort(Short.reverseBytes(this.aMp));
            this.aMn.writeInt(Integer.reverseBytes(this.frequency));
            this.aMn.writeInt(Integer.reverseBytes(((this.frequency * this.aMp) * this.aMq) / 8));
            this.aMn.writeShort(Short.reverseBytes((short) ((this.aMp * this.aMq) / 8)));
            this.aMn.writeShort(Short.reverseBytes(this.aMq));
            this.aMn.writeBytes("data");
            this.aMn.writeInt(0);
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
