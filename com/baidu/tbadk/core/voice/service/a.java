package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import com.baidu.searchbox.ui.CoolPraiseGuideLottieView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes2.dex */
public class a implements d {
    public static int eyN = CoolPraiseGuideLottieView.ANIM_DURATION;
    public static int eyO = 2;
    public static int eyP = 2;
    public static int eyQ = 1;
    private int channelConfiguration;
    private int dataSize;
    private RandomAccessFile eyR;
    private int eyS;
    private int eyT;
    private short eyU;
    private short eyV;
    private String filePath;
    private int bufferSize = 0;
    private boolean aaA = false;
    private AudioRecord mAudioRecord = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.eyS = i2;
        this.channelConfiguration = i3;
        this.eyT = i4;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
        }
        this.mAudioRecord = new AudioRecord(i, this.eyS, this.channelConfiguration, this.eyT, this.bufferSize);
        this.eyU = (short) (this.channelConfiguration == 12 ? 2 : 1);
        this.eyV = (short) (this.eyT == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.eyR != null) {
                try {
                    this.eyR.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.eyR = new RandomAccessFile(this.file, "rw");
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
    public boolean AO(String str) {
        return a(eyQ, eyN, eyO, eyP, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blZ() {
        if (this.mAudioRecord != null && this.file != null) {
            try {
                this.aaA = true;
                byte[] bArr = new byte[this.bufferSize];
                this.mAudioRecord.startRecording();
                while (this.aaA) {
                    this.mAudioRecord.read(bArr, 0, bArr.length);
                    this.eyR.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.eyR.seek(4L);
                this.eyR.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.eyR.seek(40L);
                this.eyR.writeInt(Integer.reverseBytes(this.dataSize));
                this.eyR.close();
                this.mAudioRecord.stop();
                this.mAudioRecord.release();
                this.aaA = false;
            } catch (Throwable th) {
                if (this.file.exists()) {
                    this.file.delete();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean bma() {
        Thread thread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.blZ();
            }
        });
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void bmb() {
        this.aaA = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean bmc() {
        return this.aaA;
    }

    private void writeHeader() {
        try {
            this.eyR.setLength(0L);
            this.eyR.writeBytes("RIFF");
            this.eyR.writeInt(0);
            this.eyR.writeBytes("WAVE");
            this.eyR.writeBytes("fmt ");
            this.eyR.writeInt(Integer.reverseBytes(16));
            this.eyR.writeShort(Short.reverseBytes((short) 1));
            this.eyR.writeShort(Short.reverseBytes(this.eyU));
            this.eyR.writeInt(Integer.reverseBytes(this.eyS));
            this.eyR.writeInt(Integer.reverseBytes(((this.eyS * this.eyU) * this.eyV) / 8));
            this.eyR.writeShort(Short.reverseBytes((short) ((this.eyU * this.eyV) / 8)));
            this.eyR.writeShort(Short.reverseBytes(this.eyV));
            this.eyR.writeBytes("data");
            this.eyR.writeInt(0);
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
