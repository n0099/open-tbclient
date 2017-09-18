package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements d {
    public static int aqc = 8000;
    public static int aqd = 2;
    public static int aqe = 2;
    public static int aqf = 1;
    private RandomAccessFile aqh;
    private int aqi;
    private int aqj;
    private short aqk;
    private short aql;
    private int dataSize;
    private String filePath;
    private int frequency;
    private int aqg = 0;
    private boolean mIsRecording = false;
    private AudioRecord mAudioRecord = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.aqg = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.frequency = i2;
        this.aqi = i3;
        this.aqj = i4;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
        }
        this.mAudioRecord = new AudioRecord(i, this.frequency, this.aqi, this.aqj, this.aqg);
        this.aqk = (short) (this.aqi == 12 ? 2 : 1);
        this.aql = (short) (this.aqj == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.aqh != null) {
                try {
                    this.aqh.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.aqh = new RandomAccessFile(this.file, "rw");
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
        return a(aqf, aqc, aqd, aqe, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xD() {
        if (this.mAudioRecord != null && this.file != null) {
            try {
                this.mIsRecording = true;
                byte[] bArr = new byte[this.aqg];
                this.mAudioRecord.startRecording();
                while (this.mIsRecording) {
                    this.mAudioRecord.read(bArr, 0, bArr.length);
                    this.aqh.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.aqh.seek(4L);
                this.aqh.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.aqh.seek(40L);
                this.aqh.writeInt(Integer.reverseBytes(this.dataSize));
                this.aqh.close();
                this.mAudioRecord.stop();
                this.mAudioRecord.release();
                this.mIsRecording = false;
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
        this.mIsRecording = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean isRecording() {
        return this.mIsRecording;
    }

    private void xG() {
        try {
            this.aqh.setLength(0L);
            this.aqh.writeBytes("RIFF");
            this.aqh.writeInt(0);
            this.aqh.writeBytes("WAVE");
            this.aqh.writeBytes("fmt ");
            this.aqh.writeInt(Integer.reverseBytes(16));
            this.aqh.writeShort(Short.reverseBytes((short) 1));
            this.aqh.writeShort(Short.reverseBytes(this.aqk));
            this.aqh.writeInt(Integer.reverseBytes(this.frequency));
            this.aqh.writeInt(Integer.reverseBytes(((this.frequency * this.aqk) * this.aql) / 8));
            this.aqh.writeShort(Short.reverseBytes((short) ((this.aqk * this.aql) / 8)));
            this.aqh.writeShort(Short.reverseBytes(this.aql));
            this.aqh.writeBytes("data");
            this.aqh.writeInt(0);
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
