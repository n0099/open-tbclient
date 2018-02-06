package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements d {
    public static int bfX = 8000;
    public static int bfY = 2;
    public static int bfZ = 2;
    public static int bga = 1;
    private RandomAccessFile bgc;
    private int bgd;
    private short bge;
    private short bgf;
    private int channelConfiguration;
    private int dataSize;
    private String filePath;
    private int frequency;
    private int bgb = 0;
    private boolean axR = false;
    private AudioRecord mAudioRecord = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.bgb = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.frequency = i2;
        this.channelConfiguration = i3;
        this.bgd = i4;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
        }
        this.mAudioRecord = new AudioRecord(i, this.frequency, this.channelConfiguration, this.bgd, this.bgb);
        this.bge = (short) (this.channelConfiguration == 12 ? 2 : 1);
        this.bgf = (short) (this.bgd == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.bgc != null) {
                try {
                    this.bgc.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.bgc = new RandomAccessFile(this.file, "rw");
                ES();
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
    public boolean fc(String str) {
        return a(bga, bfX, bfY, bfZ, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EP() {
        if (this.mAudioRecord != null && this.file != null) {
            try {
                this.axR = true;
                byte[] bArr = new byte[this.bgb];
                this.mAudioRecord.startRecording();
                while (this.axR) {
                    this.mAudioRecord.read(bArr, 0, bArr.length);
                    this.bgc.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.bgc.seek(4L);
                this.bgc.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.bgc.seek(40L);
                this.bgc.writeInt(Integer.reverseBytes(this.dataSize));
                this.bgc.close();
                this.mAudioRecord.stop();
                this.mAudioRecord.release();
                this.axR = false;
            } catch (Throwable th) {
                if (this.file.exists()) {
                    this.file.delete();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean EQ() {
        Thread thread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.EP();
            }
        });
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void ER() {
        this.axR = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean isRecording() {
        return this.axR;
    }

    private void ES() {
        try {
            this.bgc.setLength(0L);
            this.bgc.writeBytes("RIFF");
            this.bgc.writeInt(0);
            this.bgc.writeBytes("WAVE");
            this.bgc.writeBytes("fmt ");
            this.bgc.writeInt(Integer.reverseBytes(16));
            this.bgc.writeShort(Short.reverseBytes((short) 1));
            this.bgc.writeShort(Short.reverseBytes(this.bge));
            this.bgc.writeInt(Integer.reverseBytes(this.frequency));
            this.bgc.writeInt(Integer.reverseBytes(((this.frequency * this.bge) * this.bgf) / 8));
            this.bgc.writeShort(Short.reverseBytes((short) ((this.bge * this.bgf) / 8)));
            this.bgc.writeShort(Short.reverseBytes(this.bgf));
            this.bgc.writeBytes("data");
            this.bgc.writeInt(0);
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
