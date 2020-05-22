package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import com.baidu.searchbox.ui.CoolPraiseGuideLottieView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements d {
    public static int dZF = CoolPraiseGuideLottieView.ANIM_DURATION;
    public static int dZG = 2;
    public static int dZH = 2;
    public static int dZI = 1;
    private int channelConfiguration;
    private RandomAccessFile dZJ;
    private int dZK;
    private int dZL;
    private short dZM;
    private short dZN;
    private int dataSize;
    private String filePath;
    private int bufferSize = 0;
    private boolean Zv = false;
    private AudioRecord mAudioRecord = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.dZK = i2;
        this.channelConfiguration = i3;
        this.dZL = i4;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
        }
        this.mAudioRecord = new AudioRecord(i, this.dZK, this.channelConfiguration, this.dZL, this.bufferSize);
        this.dZM = (short) (this.channelConfiguration == 12 ? 2 : 1);
        this.dZN = (short) (this.dZL == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.dZJ != null) {
                try {
                    this.dZJ.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.dZJ = new RandomAccessFile(this.file, "rw");
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
    public boolean xb(String str) {
        return a(dZI, dZF, dZG, dZH, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXp() {
        if (this.mAudioRecord != null && this.file != null) {
            try {
                this.Zv = true;
                byte[] bArr = new byte[this.bufferSize];
                this.mAudioRecord.startRecording();
                while (this.Zv) {
                    this.mAudioRecord.read(bArr, 0, bArr.length);
                    this.dZJ.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.dZJ.seek(4L);
                this.dZJ.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.dZJ.seek(40L);
                this.dZJ.writeInt(Integer.reverseBytes(this.dataSize));
                this.dZJ.close();
                this.mAudioRecord.stop();
                this.mAudioRecord.release();
                this.Zv = false;
            } catch (Throwable th) {
                if (this.file.exists()) {
                    this.file.delete();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean aXq() {
        Thread thread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.aXp();
            }
        });
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void aXr() {
        this.Zv = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean aXs() {
        return this.Zv;
    }

    private void writeHeader() {
        try {
            this.dZJ.setLength(0L);
            this.dZJ.writeBytes("RIFF");
            this.dZJ.writeInt(0);
            this.dZJ.writeBytes("WAVE");
            this.dZJ.writeBytes("fmt ");
            this.dZJ.writeInt(Integer.reverseBytes(16));
            this.dZJ.writeShort(Short.reverseBytes((short) 1));
            this.dZJ.writeShort(Short.reverseBytes(this.dZM));
            this.dZJ.writeInt(Integer.reverseBytes(this.dZK));
            this.dZJ.writeInt(Integer.reverseBytes(((this.dZK * this.dZM) * this.dZN) / 8));
            this.dZJ.writeShort(Short.reverseBytes((short) ((this.dZM * this.dZN) / 8)));
            this.dZJ.writeShort(Short.reverseBytes(this.dZN));
            this.dZJ.writeBytes("data");
            this.dZJ.writeInt(0);
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
