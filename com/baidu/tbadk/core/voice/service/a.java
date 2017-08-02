package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements d {
    public static int apd = 8000;
    public static int ape = 2;
    public static int apf = 2;
    public static int apg = 1;
    private RandomAccessFile apj;
    private int apk;
    private int apl;
    private short apm;
    private short apn;
    private int dataSize;
    private String filePath;
    private int frequency;
    private int aph = 0;
    private boolean api = false;
    private AudioRecord mAudioRecord = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.aph = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.frequency = i2;
        this.apk = i3;
        this.apl = i4;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
        }
        this.mAudioRecord = new AudioRecord(i, this.frequency, this.apk, this.apl, this.aph);
        this.apm = (short) (this.apk == 12 ? 2 : 1);
        this.apn = (short) (this.apl == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.apj != null) {
                try {
                    this.apj.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.apj = new RandomAccessFile(this.file, "rw");
                xw();
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
    public boolean eu(String str) {
        return a(apg, apd, ape, apf, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xt() {
        if (this.mAudioRecord != null && this.file != null) {
            try {
                this.api = true;
                byte[] bArr = new byte[this.aph];
                this.mAudioRecord.startRecording();
                while (this.api) {
                    this.mAudioRecord.read(bArr, 0, bArr.length);
                    this.apj.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.apj.seek(4L);
                this.apj.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.apj.seek(40L);
                this.apj.writeInt(Integer.reverseBytes(this.dataSize));
                this.apj.close();
                this.mAudioRecord.stop();
                this.mAudioRecord.release();
                this.api = false;
            } catch (Throwable th) {
                if (this.file.exists()) {
                    this.file.delete();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean xu() {
        Thread thread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.xt();
            }
        });
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void xv() {
        this.api = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean isRecording() {
        return this.api;
    }

    private void xw() {
        try {
            this.apj.setLength(0L);
            this.apj.writeBytes("RIFF");
            this.apj.writeInt(0);
            this.apj.writeBytes("WAVE");
            this.apj.writeBytes("fmt ");
            this.apj.writeInt(Integer.reverseBytes(16));
            this.apj.writeShort(Short.reverseBytes((short) 1));
            this.apj.writeShort(Short.reverseBytes(this.apm));
            this.apj.writeInt(Integer.reverseBytes(this.frequency));
            this.apj.writeInt(Integer.reverseBytes(((this.frequency * this.apm) * this.apn) / 8));
            this.apj.writeShort(Short.reverseBytes((short) ((this.apm * this.apn) / 8)));
            this.apj.writeShort(Short.reverseBytes(this.apn));
            this.apj.writeBytes("data");
            this.apj.writeInt(0);
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
