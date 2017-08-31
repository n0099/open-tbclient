package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements d {
    public static int aqe = 8000;
    public static int aqf = 2;
    public static int aqg = 2;
    public static int aqh = 1;
    private RandomAccessFile aqk;
    private int aql;
    private int aqm;
    private short aqn;
    private short aqo;
    private int dataSize;
    private String filePath;
    private int frequency;
    private int aqi = 0;
    private boolean aqj = false;
    private AudioRecord mAudioRecord = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.aqi = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.frequency = i2;
        this.aql = i3;
        this.aqm = i4;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
        }
        this.mAudioRecord = new AudioRecord(i, this.frequency, this.aql, this.aqm, this.aqi);
        this.aqn = (short) (this.aql == 12 ? 2 : 1);
        this.aqo = (short) (this.aqm == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.aqk != null) {
                try {
                    this.aqk.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.aqk = new RandomAccessFile(this.file, "rw");
                xG();
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
    public boolean ex(String str) {
        return a(aqh, aqe, aqf, aqg, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xD() {
        if (this.mAudioRecord != null && this.file != null) {
            try {
                this.aqj = true;
                byte[] bArr = new byte[this.aqi];
                this.mAudioRecord.startRecording();
                while (this.aqj) {
                    this.mAudioRecord.read(bArr, 0, bArr.length);
                    this.aqk.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.aqk.seek(4L);
                this.aqk.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.aqk.seek(40L);
                this.aqk.writeInt(Integer.reverseBytes(this.dataSize));
                this.aqk.close();
                this.mAudioRecord.stop();
                this.mAudioRecord.release();
                this.aqj = false;
            } catch (Throwable th) {
                if (this.file.exists()) {
                    this.file.delete();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean xE() {
        Thread thread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.xD();
            }
        });
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void xF() {
        this.aqj = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean isRecording() {
        return this.aqj;
    }

    private void xG() {
        try {
            this.aqk.setLength(0L);
            this.aqk.writeBytes("RIFF");
            this.aqk.writeInt(0);
            this.aqk.writeBytes("WAVE");
            this.aqk.writeBytes("fmt ");
            this.aqk.writeInt(Integer.reverseBytes(16));
            this.aqk.writeShort(Short.reverseBytes((short) 1));
            this.aqk.writeShort(Short.reverseBytes(this.aqn));
            this.aqk.writeInt(Integer.reverseBytes(this.frequency));
            this.aqk.writeInt(Integer.reverseBytes(((this.frequency * this.aqn) * this.aqo) / 8));
            this.aqk.writeShort(Short.reverseBytes((short) ((this.aqn * this.aqo) / 8)));
            this.aqk.writeShort(Short.reverseBytes(this.aqo));
            this.aqk.writeBytes("data");
            this.aqk.writeInt(0);
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
