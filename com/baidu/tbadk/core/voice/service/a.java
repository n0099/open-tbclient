package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import com.baidu.searchbox.ui.CoolPraiseGuideLottieView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements d {
    public static int eoB = CoolPraiseGuideLottieView.ANIM_DURATION;
    public static int eoC = 2;
    public static int eoD = 2;
    public static int eoE = 1;
    private int channelConfiguration;
    private int dataSize;
    private RandomAccessFile eoF;
    private int eoG;
    private int eoH;
    private short eoI;
    private short eoJ;
    private String filePath;
    private int bufferSize = 0;
    private boolean ZU = false;
    private AudioRecord mAudioRecord = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.eoG = i2;
        this.channelConfiguration = i3;
        this.eoH = i4;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
        }
        this.mAudioRecord = new AudioRecord(i, this.eoG, this.channelConfiguration, this.eoH, this.bufferSize);
        this.eoI = (short) (this.channelConfiguration == 12 ? 2 : 1);
        this.eoJ = (short) (this.eoH == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.eoF != null) {
                try {
                    this.eoF.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.eoF = new RandomAccessFile(this.file, "rw");
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
    public boolean yz(String str) {
        return a(eoE, eoB, eoC, eoD, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdt() {
        if (this.mAudioRecord != null && this.file != null) {
            try {
                this.ZU = true;
                byte[] bArr = new byte[this.bufferSize];
                this.mAudioRecord.startRecording();
                while (this.ZU) {
                    this.mAudioRecord.read(bArr, 0, bArr.length);
                    this.eoF.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.eoF.seek(4L);
                this.eoF.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.eoF.seek(40L);
                this.eoF.writeInt(Integer.reverseBytes(this.dataSize));
                this.eoF.close();
                this.mAudioRecord.stop();
                this.mAudioRecord.release();
                this.ZU = false;
            } catch (Throwable th) {
                if (this.file.exists()) {
                    this.file.delete();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean bdu() {
        Thread thread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.bdt();
            }
        });
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void bdv() {
        this.ZU = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean bdw() {
        return this.ZU;
    }

    private void writeHeader() {
        try {
            this.eoF.setLength(0L);
            this.eoF.writeBytes("RIFF");
            this.eoF.writeInt(0);
            this.eoF.writeBytes("WAVE");
            this.eoF.writeBytes("fmt ");
            this.eoF.writeInt(Integer.reverseBytes(16));
            this.eoF.writeShort(Short.reverseBytes((short) 1));
            this.eoF.writeShort(Short.reverseBytes(this.eoI));
            this.eoF.writeInt(Integer.reverseBytes(this.eoG));
            this.eoF.writeInt(Integer.reverseBytes(((this.eoG * this.eoI) * this.eoJ) / 8));
            this.eoF.writeShort(Short.reverseBytes((short) ((this.eoI * this.eoJ) / 8)));
            this.eoF.writeShort(Short.reverseBytes(this.eoJ));
            this.eoF.writeBytes("data");
            this.eoF.writeInt(0);
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
