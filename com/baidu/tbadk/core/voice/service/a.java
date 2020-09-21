package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import com.baidu.searchbox.ui.CoolPraiseGuideLottieView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements d {
    public static int eAV = CoolPraiseGuideLottieView.ANIM_DURATION;
    public static int eAW = 2;
    public static int eAX = 2;
    public static int eAY = 1;
    private int channelConfiguration;
    private int dataSize;
    private RandomAccessFile eAZ;
    private int eBa;
    private int eBb;
    private short eBc;
    private short eBd;
    private String filePath;
    private int bufferSize = 0;
    private boolean aaU = false;
    private AudioRecord mAudioRecord = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.eBa = i2;
        this.channelConfiguration = i3;
        this.eBb = i4;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
        }
        this.mAudioRecord = new AudioRecord(i, this.eBa, this.channelConfiguration, this.eBb, this.bufferSize);
        this.eBc = (short) (this.channelConfiguration == 12 ? 2 : 1);
        this.eBd = (short) (this.eBb == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.eAZ != null) {
                try {
                    this.eAZ.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.eAZ = new RandomAccessFile(this.file, "rw");
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
    public boolean Bl(String str) {
        return a(eAY, eAV, eAW, eAX, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmT() {
        if (this.mAudioRecord != null && this.file != null) {
            try {
                this.aaU = true;
                byte[] bArr = new byte[this.bufferSize];
                this.mAudioRecord.startRecording();
                while (this.aaU) {
                    this.mAudioRecord.read(bArr, 0, bArr.length);
                    this.eAZ.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.eAZ.seek(4L);
                this.eAZ.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.eAZ.seek(40L);
                this.eAZ.writeInt(Integer.reverseBytes(this.dataSize));
                this.eAZ.close();
                this.mAudioRecord.stop();
                this.mAudioRecord.release();
                this.aaU = false;
            } catch (Throwable th) {
                if (this.file.exists()) {
                    this.file.delete();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean bmU() {
        Thread thread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.bmT();
            }
        });
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void bmV() {
        this.aaU = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean bmW() {
        return this.aaU;
    }

    private void writeHeader() {
        try {
            this.eAZ.setLength(0L);
            this.eAZ.writeBytes("RIFF");
            this.eAZ.writeInt(0);
            this.eAZ.writeBytes("WAVE");
            this.eAZ.writeBytes("fmt ");
            this.eAZ.writeInt(Integer.reverseBytes(16));
            this.eAZ.writeShort(Short.reverseBytes((short) 1));
            this.eAZ.writeShort(Short.reverseBytes(this.eBc));
            this.eAZ.writeInt(Integer.reverseBytes(this.eBa));
            this.eAZ.writeInt(Integer.reverseBytes(((this.eBa * this.eBc) * this.eBd) / 8));
            this.eAZ.writeShort(Short.reverseBytes((short) ((this.eBc * this.eBd) / 8)));
            this.eAZ.writeShort(Short.reverseBytes(this.eBd));
            this.eAZ.writeBytes("data");
            this.eAZ.writeInt(0);
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
