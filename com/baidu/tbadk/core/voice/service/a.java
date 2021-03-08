package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import com.yy.mediaframework.stat.VideoDataStatistic;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements d {
    public static int fqL = 8000;
    public static int fqM = 2;
    public static int fqN = 2;
    public static int fqO = 1;
    private int channelConfiguration;
    private int dataSize;
    private String filePath;
    private RandomAccessFile fqP;
    private int fqQ;
    private int fqR;
    private short fqS;
    private short fqT;
    private int bufferSize = 0;
    private boolean aen = false;
    private AudioRecord mAudioRecord = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.fqQ = i2;
        this.channelConfiguration = i3;
        this.fqR = i4;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
        }
        this.mAudioRecord = new AudioRecord(i, this.fqQ, this.channelConfiguration, this.fqR, this.bufferSize);
        this.fqS = (short) (this.channelConfiguration == 12 ? 2 : 1);
        this.fqT = (short) (this.fqR == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.fqP != null) {
                try {
                    this.fqP.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.fqP = new RandomAccessFile(this.file, VideoDataStatistic.AnchorHiidoCoreStatisticKey.CaptureRealResolutionWidth);
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
    public boolean BV(String str) {
        return a(fqO, fqL, fqM, fqN, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvJ() {
        if (this.mAudioRecord != null && this.file != null) {
            try {
                this.aen = true;
                byte[] bArr = new byte[this.bufferSize];
                this.mAudioRecord.startRecording();
                while (this.aen) {
                    this.mAudioRecord.read(bArr, 0, bArr.length);
                    this.fqP.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.fqP.seek(4L);
                this.fqP.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.fqP.seek(40L);
                this.fqP.writeInt(Integer.reverseBytes(this.dataSize));
                this.fqP.close();
                this.mAudioRecord.stop();
                this.mAudioRecord.release();
                this.aen = false;
            } catch (Throwable th) {
                if (this.file.exists()) {
                    this.file.delete();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean bvK() {
        Thread thread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.bvJ();
            }
        });
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void bvL() {
        this.aen = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean isRecording() {
        return this.aen;
    }

    private void writeHeader() {
        try {
            this.fqP.setLength(0L);
            this.fqP.writeBytes("RIFF");
            this.fqP.writeInt(0);
            this.fqP.writeBytes("WAVE");
            this.fqP.writeBytes("fmt ");
            this.fqP.writeInt(Integer.reverseBytes(16));
            this.fqP.writeShort(Short.reverseBytes((short) 1));
            this.fqP.writeShort(Short.reverseBytes(this.fqS));
            this.fqP.writeInt(Integer.reverseBytes(this.fqQ));
            this.fqP.writeInt(Integer.reverseBytes(((this.fqQ * this.fqS) * this.fqT) / 8));
            this.fqP.writeShort(Short.reverseBytes((short) ((this.fqS * this.fqT) / 8)));
            this.fqP.writeShort(Short.reverseBytes(this.fqT));
            this.fqP.writeBytes("data");
            this.fqP.writeInt(0);
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
