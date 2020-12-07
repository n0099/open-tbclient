package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import com.baidu.searchbox.ui.CoolPraiseGuideLottieView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements d {
    public static int fhS = CoolPraiseGuideLottieView.ANIM_DURATION;
    public static int fhT = 2;
    public static int fhU = 2;
    public static int fhV = 1;
    private int channelConfiguration;
    private int dataSize;
    private RandomAccessFile fhW;
    private int fhX;
    private int fhY;
    private short fhZ;
    private short fia;
    private String filePath;
    private int bufferSize = 0;
    private boolean acp = false;
    private AudioRecord mAudioRecord = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.fhX = i2;
        this.channelConfiguration = i3;
        this.fhY = i4;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
        }
        this.mAudioRecord = new AudioRecord(i, this.fhX, this.channelConfiguration, this.fhY, this.bufferSize);
        this.fhZ = (short) (this.channelConfiguration == 12 ? 2 : 1);
        this.fia = (short) (this.fhY == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.fhW != null) {
                try {
                    this.fhW.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.fhW = new RandomAccessFile(this.file, "rw");
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
    public boolean CL(String str) {
        return a(fhV, fhS, fhT, fhU, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwM() {
        if (this.mAudioRecord != null && this.file != null) {
            try {
                this.acp = true;
                byte[] bArr = new byte[this.bufferSize];
                this.mAudioRecord.startRecording();
                while (this.acp) {
                    this.mAudioRecord.read(bArr, 0, bArr.length);
                    this.fhW.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.fhW.seek(4L);
                this.fhW.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.fhW.seek(40L);
                this.fhW.writeInt(Integer.reverseBytes(this.dataSize));
                this.fhW.close();
                this.mAudioRecord.stop();
                this.mAudioRecord.release();
                this.acp = false;
            } catch (Throwable th) {
                if (this.file.exists()) {
                    this.file.delete();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean bwN() {
        Thread thread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.bwM();
            }
        });
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void bwO() {
        this.acp = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean bwP() {
        return this.acp;
    }

    private void writeHeader() {
        try {
            this.fhW.setLength(0L);
            this.fhW.writeBytes("RIFF");
            this.fhW.writeInt(0);
            this.fhW.writeBytes("WAVE");
            this.fhW.writeBytes("fmt ");
            this.fhW.writeInt(Integer.reverseBytes(16));
            this.fhW.writeShort(Short.reverseBytes((short) 1));
            this.fhW.writeShort(Short.reverseBytes(this.fhZ));
            this.fhW.writeInt(Integer.reverseBytes(this.fhX));
            this.fhW.writeInt(Integer.reverseBytes(((this.fhX * this.fhZ) * this.fia) / 8));
            this.fhW.writeShort(Short.reverseBytes((short) ((this.fhZ * this.fia) / 8)));
            this.fhW.writeShort(Short.reverseBytes(this.fia));
            this.fhW.writeBytes("data");
            this.fhW.writeInt(0);
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
