package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import com.baidu.searchbox.ui.CoolPraiseGuideLottieView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements d {
    public static int dLk = CoolPraiseGuideLottieView.ANIM_DURATION;
    public static int dLl = 2;
    public static int dLm = 2;
    public static int dLn = 1;
    private int channelConfiguration;
    private RandomAccessFile dLo;
    private int dLp;
    private int dLq;
    private short dLr;
    private short dLs;
    private int dataSize;
    private String filePath;
    private int bufferSize = 0;
    private boolean Zc = false;
    private AudioRecord mAudioRecord = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.dLp = i2;
        this.channelConfiguration = i3;
        this.dLq = i4;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
        }
        this.mAudioRecord = new AudioRecord(i, this.dLp, this.channelConfiguration, this.dLq, this.bufferSize);
        this.dLr = (short) (this.channelConfiguration == 12 ? 2 : 1);
        this.dLs = (short) (this.dLq == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.dLo != null) {
                try {
                    this.dLo.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.dLo = new RandomAccessFile(this.file, "rw");
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
    public boolean vs(String str) {
        return a(dLn, dLk, dLl, dLm, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRl() {
        if (this.mAudioRecord != null && this.file != null) {
            try {
                this.Zc = true;
                byte[] bArr = new byte[this.bufferSize];
                this.mAudioRecord.startRecording();
                while (this.Zc) {
                    this.mAudioRecord.read(bArr, 0, bArr.length);
                    this.dLo.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.dLo.seek(4L);
                this.dLo.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.dLo.seek(40L);
                this.dLo.writeInt(Integer.reverseBytes(this.dataSize));
                this.dLo.close();
                this.mAudioRecord.stop();
                this.mAudioRecord.release();
                this.Zc = false;
            } catch (Throwable th) {
                if (this.file.exists()) {
                    this.file.delete();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean aRm() {
        Thread thread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.aRl();
            }
        });
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void aRn() {
        this.Zc = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean aRo() {
        return this.Zc;
    }

    private void writeHeader() {
        try {
            this.dLo.setLength(0L);
            this.dLo.writeBytes("RIFF");
            this.dLo.writeInt(0);
            this.dLo.writeBytes("WAVE");
            this.dLo.writeBytes("fmt ");
            this.dLo.writeInt(Integer.reverseBytes(16));
            this.dLo.writeShort(Short.reverseBytes((short) 1));
            this.dLo.writeShort(Short.reverseBytes(this.dLr));
            this.dLo.writeInt(Integer.reverseBytes(this.dLp));
            this.dLo.writeInt(Integer.reverseBytes(((this.dLp * this.dLr) * this.dLs) / 8));
            this.dLo.writeShort(Short.reverseBytes((short) ((this.dLr * this.dLs) / 8)));
            this.dLo.writeShort(Short.reverseBytes(this.dLs));
            this.dLo.writeBytes("data");
            this.dLo.writeInt(0);
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
