package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements d {
    public static int apP = 8000;
    public static int apQ = 2;
    public static int apR = 2;
    public static int apS = 1;
    private RandomAccessFile apU;
    private int apV;
    private short apW;
    private short apX;
    private int channelConfiguration;
    private int dataSize;
    private String filePath;
    private int frequency;
    private int apT = 0;
    private boolean IT = false;
    private AudioRecord mAudioRecord = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.apT = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.frequency = i2;
        this.channelConfiguration = i3;
        this.apV = i4;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
        }
        this.mAudioRecord = new AudioRecord(i, this.frequency, this.channelConfiguration, this.apV, this.apT);
        this.apW = (short) (this.channelConfiguration == 12 ? 2 : 1);
        this.apX = (short) (this.apV == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.apU != null) {
                try {
                    this.apU.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.apU = new RandomAccessFile(this.file, "rw");
                xf();
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
    public boolean eC(String str) {
        return a(apS, apP, apQ, apR, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xc() {
        if (this.mAudioRecord != null && this.file != null) {
            try {
                this.IT = true;
                byte[] bArr = new byte[this.apT];
                this.mAudioRecord.startRecording();
                while (this.IT) {
                    this.mAudioRecord.read(bArr, 0, bArr.length);
                    this.apU.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.apU.seek(4L);
                this.apU.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.apU.seek(40L);
                this.apU.writeInt(Integer.reverseBytes(this.dataSize));
                this.apU.close();
                this.mAudioRecord.stop();
                this.mAudioRecord.release();
                this.IT = false;
            } catch (Throwable th) {
                if (this.file.exists()) {
                    this.file.delete();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean xd() {
        Thread thread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.xc();
            }
        });
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void xe() {
        this.IT = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean isRecording() {
        return this.IT;
    }

    private void xf() {
        try {
            this.apU.setLength(0L);
            this.apU.writeBytes("RIFF");
            this.apU.writeInt(0);
            this.apU.writeBytes("WAVE");
            this.apU.writeBytes("fmt ");
            this.apU.writeInt(Integer.reverseBytes(16));
            this.apU.writeShort(Short.reverseBytes((short) 1));
            this.apU.writeShort(Short.reverseBytes(this.apW));
            this.apU.writeInt(Integer.reverseBytes(this.frequency));
            this.apU.writeInt(Integer.reverseBytes(((this.frequency * this.apW) * this.apX) / 8));
            this.apU.writeShort(Short.reverseBytes((short) ((this.apW * this.apX) / 8)));
            this.apU.writeShort(Short.reverseBytes(this.apX));
            this.apU.writeBytes("data");
            this.apU.writeInt(0);
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
