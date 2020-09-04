package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import com.baidu.searchbox.ui.CoolPraiseGuideLottieView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements d {
    public static int eyR = CoolPraiseGuideLottieView.ANIM_DURATION;
    public static int eyS = 2;
    public static int eyT = 2;
    public static int eyU = 1;
    private int channelConfiguration;
    private int dataSize;
    private RandomAccessFile eyV;
    private int eyW;
    private int eyX;
    private short eyY;
    private short eyZ;
    private String filePath;
    private int bufferSize = 0;
    private boolean aaC = false;
    private AudioRecord mAudioRecord = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.eyW = i2;
        this.channelConfiguration = i3;
        this.eyX = i4;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
        }
        this.mAudioRecord = new AudioRecord(i, this.eyW, this.channelConfiguration, this.eyX, this.bufferSize);
        this.eyY = (short) (this.channelConfiguration == 12 ? 2 : 1);
        this.eyZ = (short) (this.eyX == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.eyV != null) {
                try {
                    this.eyV.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.eyV = new RandomAccessFile(this.file, "rw");
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
    public boolean AP(String str) {
        return a(eyU, eyR, eyS, eyT, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blZ() {
        if (this.mAudioRecord != null && this.file != null) {
            try {
                this.aaC = true;
                byte[] bArr = new byte[this.bufferSize];
                this.mAudioRecord.startRecording();
                while (this.aaC) {
                    this.mAudioRecord.read(bArr, 0, bArr.length);
                    this.eyV.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.eyV.seek(4L);
                this.eyV.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.eyV.seek(40L);
                this.eyV.writeInt(Integer.reverseBytes(this.dataSize));
                this.eyV.close();
                this.mAudioRecord.stop();
                this.mAudioRecord.release();
                this.aaC = false;
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
        this.aaC = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean bmc() {
        return this.aaC;
    }

    private void writeHeader() {
        try {
            this.eyV.setLength(0L);
            this.eyV.writeBytes("RIFF");
            this.eyV.writeInt(0);
            this.eyV.writeBytes("WAVE");
            this.eyV.writeBytes("fmt ");
            this.eyV.writeInt(Integer.reverseBytes(16));
            this.eyV.writeShort(Short.reverseBytes((short) 1));
            this.eyV.writeShort(Short.reverseBytes(this.eyY));
            this.eyV.writeInt(Integer.reverseBytes(this.eyW));
            this.eyV.writeInt(Integer.reverseBytes(((this.eyW * this.eyY) * this.eyZ) / 8));
            this.eyV.writeShort(Short.reverseBytes((short) ((this.eyY * this.eyZ) / 8)));
            this.eyV.writeShort(Short.reverseBytes(this.eyZ));
            this.eyV.writeBytes("data");
            this.eyV.writeInt(0);
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
