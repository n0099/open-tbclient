package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import com.yy.mediaframework.stat.VideoDataStatistic;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements d {
    public static int fpl = 8000;
    public static int fpm = 2;
    public static int fpn = 2;
    public static int fpo = 1;
    private int channelConfiguration;
    private int dataSize;
    private String filePath;
    private RandomAccessFile fpp;
    private int fpq;
    private int fpr;
    private short fpt;
    private short fpu;
    private int bufferSize = 0;
    private boolean acT = false;
    private AudioRecord mAudioRecord = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.fpq = i2;
        this.channelConfiguration = i3;
        this.fpr = i4;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
        }
        this.mAudioRecord = new AudioRecord(i, this.fpq, this.channelConfiguration, this.fpr, this.bufferSize);
        this.fpt = (short) (this.channelConfiguration == 12 ? 2 : 1);
        this.fpu = (short) (this.fpr == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.fpp != null) {
                try {
                    this.fpp.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.fpp = new RandomAccessFile(this.file, VideoDataStatistic.AnchorHiidoCoreStatisticKey.CaptureRealResolutionWidth);
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
    public boolean BO(String str) {
        return a(fpo, fpl, fpm, fpn, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvG() {
        if (this.mAudioRecord != null && this.file != null) {
            try {
                this.acT = true;
                byte[] bArr = new byte[this.bufferSize];
                this.mAudioRecord.startRecording();
                while (this.acT) {
                    this.mAudioRecord.read(bArr, 0, bArr.length);
                    this.fpp.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.fpp.seek(4L);
                this.fpp.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.fpp.seek(40L);
                this.fpp.writeInt(Integer.reverseBytes(this.dataSize));
                this.fpp.close();
                this.mAudioRecord.stop();
                this.mAudioRecord.release();
                this.acT = false;
            } catch (Throwable th) {
                if (this.file.exists()) {
                    this.file.delete();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean bvH() {
        Thread thread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.bvG();
            }
        });
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void bvI() {
        this.acT = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean isRecording() {
        return this.acT;
    }

    private void writeHeader() {
        try {
            this.fpp.setLength(0L);
            this.fpp.writeBytes("RIFF");
            this.fpp.writeInt(0);
            this.fpp.writeBytes("WAVE");
            this.fpp.writeBytes("fmt ");
            this.fpp.writeInt(Integer.reverseBytes(16));
            this.fpp.writeShort(Short.reverseBytes((short) 1));
            this.fpp.writeShort(Short.reverseBytes(this.fpt));
            this.fpp.writeInt(Integer.reverseBytes(this.fpq));
            this.fpp.writeInt(Integer.reverseBytes(((this.fpq * this.fpt) * this.fpu) / 8));
            this.fpp.writeShort(Short.reverseBytes((short) ((this.fpt * this.fpu) / 8)));
            this.fpp.writeShort(Short.reverseBytes(this.fpu));
            this.fpp.writeBytes("data");
            this.fpp.writeInt(0);
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
