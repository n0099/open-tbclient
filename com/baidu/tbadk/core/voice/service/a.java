package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import com.baidu.searchbox.ui.CoolPraiseGuideLottieView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements d {
    public static int dLo = CoolPraiseGuideLottieView.ANIM_DURATION;
    public static int dLp = 2;
    public static int dLq = 2;
    public static int dLr = 1;
    private int channelConfiguration;
    private RandomAccessFile dLs;
    private int dLt;
    private int dLu;
    private short dLv;
    private short dLw;
    private int dataSize;
    private String filePath;
    private int bufferSize = 0;
    private boolean Zf = false;
    private AudioRecord mAudioRecord = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.dLt = i2;
        this.channelConfiguration = i3;
        this.dLu = i4;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
        }
        this.mAudioRecord = new AudioRecord(i, this.dLt, this.channelConfiguration, this.dLu, this.bufferSize);
        this.dLv = (short) (this.channelConfiguration == 12 ? 2 : 1);
        this.dLw = (short) (this.dLu == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.dLs != null) {
                try {
                    this.dLs.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.dLs = new RandomAccessFile(this.file, "rw");
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
    public boolean vv(String str) {
        return a(dLr, dLo, dLp, dLq, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRi() {
        if (this.mAudioRecord != null && this.file != null) {
            try {
                this.Zf = true;
                byte[] bArr = new byte[this.bufferSize];
                this.mAudioRecord.startRecording();
                while (this.Zf) {
                    this.mAudioRecord.read(bArr, 0, bArr.length);
                    this.dLs.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.dLs.seek(4L);
                this.dLs.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.dLs.seek(40L);
                this.dLs.writeInt(Integer.reverseBytes(this.dataSize));
                this.dLs.close();
                this.mAudioRecord.stop();
                this.mAudioRecord.release();
                this.Zf = false;
            } catch (Throwable th) {
                if (this.file.exists()) {
                    this.file.delete();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean aRj() {
        Thread thread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.aRi();
            }
        });
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void aRk() {
        this.Zf = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean aRl() {
        return this.Zf;
    }

    private void writeHeader() {
        try {
            this.dLs.setLength(0L);
            this.dLs.writeBytes("RIFF");
            this.dLs.writeInt(0);
            this.dLs.writeBytes("WAVE");
            this.dLs.writeBytes("fmt ");
            this.dLs.writeInt(Integer.reverseBytes(16));
            this.dLs.writeShort(Short.reverseBytes((short) 1));
            this.dLs.writeShort(Short.reverseBytes(this.dLv));
            this.dLs.writeInt(Integer.reverseBytes(this.dLt));
            this.dLs.writeInt(Integer.reverseBytes(((this.dLt * this.dLv) * this.dLw) / 8));
            this.dLs.writeShort(Short.reverseBytes((short) ((this.dLv * this.dLw) / 8)));
            this.dLs.writeShort(Short.reverseBytes(this.dLw));
            this.dLs.writeBytes("data");
            this.dLs.writeInt(0);
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
