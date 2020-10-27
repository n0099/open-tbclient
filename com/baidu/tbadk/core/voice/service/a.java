package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import com.baidu.searchbox.ui.CoolPraiseGuideLottieView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements d {
    private int channelConfiguration;
    private int dataSize;
    private RandomAccessFile eVC;
    private int eVD;
    private int eVE;
    private short eVF;
    private short eVG;
    private String filePath;
    public static int eVy = CoolPraiseGuideLottieView.ANIM_DURATION;
    public static int eVz = 2;
    public static int eVA = 2;
    public static int eVB = 1;
    private int bufferSize = 0;
    private boolean abm = false;
    private AudioRecord mAudioRecord = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.eVD = i2;
        this.channelConfiguration = i3;
        this.eVE = i4;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
        }
        this.mAudioRecord = new AudioRecord(i, this.eVD, this.channelConfiguration, this.eVE, this.bufferSize);
        this.eVF = (short) (this.channelConfiguration == 12 ? 2 : 1);
        this.eVG = (short) (this.eVE == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.eVC != null) {
                try {
                    this.eVC.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.eVC = new RandomAccessFile(this.file, "rw");
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
    public boolean Cq(String str) {
        return a(eVB, eVy, eVz, eVA, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brw() {
        if (this.mAudioRecord != null && this.file != null) {
            try {
                this.abm = true;
                byte[] bArr = new byte[this.bufferSize];
                this.mAudioRecord.startRecording();
                while (this.abm) {
                    this.mAudioRecord.read(bArr, 0, bArr.length);
                    this.eVC.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.eVC.seek(4L);
                this.eVC.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.eVC.seek(40L);
                this.eVC.writeInt(Integer.reverseBytes(this.dataSize));
                this.eVC.close();
                this.mAudioRecord.stop();
                this.mAudioRecord.release();
                this.abm = false;
            } catch (Throwable th) {
                if (this.file.exists()) {
                    this.file.delete();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean brx() {
        Thread thread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.brw();
            }
        });
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void bry() {
        this.abm = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean brz() {
        return this.abm;
    }

    private void writeHeader() {
        try {
            this.eVC.setLength(0L);
            this.eVC.writeBytes("RIFF");
            this.eVC.writeInt(0);
            this.eVC.writeBytes("WAVE");
            this.eVC.writeBytes("fmt ");
            this.eVC.writeInt(Integer.reverseBytes(16));
            this.eVC.writeShort(Short.reverseBytes((short) 1));
            this.eVC.writeShort(Short.reverseBytes(this.eVF));
            this.eVC.writeInt(Integer.reverseBytes(this.eVD));
            this.eVC.writeInt(Integer.reverseBytes(((this.eVD * this.eVF) * this.eVG) / 8));
            this.eVC.writeShort(Short.reverseBytes((short) ((this.eVF * this.eVG) / 8)));
            this.eVC.writeShort(Short.reverseBytes(this.eVG));
            this.eVC.writeBytes("data");
            this.eVC.writeInt(0);
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
