package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import com.baidu.searchbox.ui.CoolPraiseGuideLottieView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements d {
    public static int eNc = CoolPraiseGuideLottieView.ANIM_DURATION;
    public static int eNd = 2;
    public static int eNe = 2;
    public static int eNf = 1;
    private int channelConfiguration;
    private int dataSize;
    private RandomAccessFile eNg;
    private int eNh;
    private int eNi;
    private short eNj;
    private short eNk;
    private String filePath;
    private int bufferSize = 0;
    private boolean abl = false;
    private AudioRecord mAudioRecord = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.eNh = i2;
        this.channelConfiguration = i3;
        this.eNi = i4;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
        }
        this.mAudioRecord = new AudioRecord(i, this.eNh, this.channelConfiguration, this.eNi, this.bufferSize);
        this.eNj = (short) (this.channelConfiguration == 12 ? 2 : 1);
        this.eNk = (short) (this.eNi == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.eNg != null) {
                try {
                    this.eNg.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.eNg = new RandomAccessFile(this.file, "rw");
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
    public boolean BX(String str) {
        return a(eNf, eNc, eNd, eNe, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpD() {
        if (this.mAudioRecord != null && this.file != null) {
            try {
                this.abl = true;
                byte[] bArr = new byte[this.bufferSize];
                this.mAudioRecord.startRecording();
                while (this.abl) {
                    this.mAudioRecord.read(bArr, 0, bArr.length);
                    this.eNg.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.eNg.seek(4L);
                this.eNg.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.eNg.seek(40L);
                this.eNg.writeInt(Integer.reverseBytes(this.dataSize));
                this.eNg.close();
                this.mAudioRecord.stop();
                this.mAudioRecord.release();
                this.abl = false;
            } catch (Throwable th) {
                if (this.file.exists()) {
                    this.file.delete();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean bpE() {
        Thread thread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.bpD();
            }
        });
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void bpF() {
        this.abl = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean bpG() {
        return this.abl;
    }

    private void writeHeader() {
        try {
            this.eNg.setLength(0L);
            this.eNg.writeBytes("RIFF");
            this.eNg.writeInt(0);
            this.eNg.writeBytes("WAVE");
            this.eNg.writeBytes("fmt ");
            this.eNg.writeInt(Integer.reverseBytes(16));
            this.eNg.writeShort(Short.reverseBytes((short) 1));
            this.eNg.writeShort(Short.reverseBytes(this.eNj));
            this.eNg.writeInt(Integer.reverseBytes(this.eNh));
            this.eNg.writeInt(Integer.reverseBytes(((this.eNh * this.eNj) * this.eNk) / 8));
            this.eNg.writeShort(Short.reverseBytes((short) ((this.eNj * this.eNk) / 8)));
            this.eNg.writeShort(Short.reverseBytes(this.eNk));
            this.eNg.writeBytes("data");
            this.eNg.writeInt(0);
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
