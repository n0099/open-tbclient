package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements d {
    public static int bfL = 8000;
    public static int bfM = 2;
    public static int bfN = 2;
    public static int bfO = 1;
    private RandomAccessFile bfQ;
    private int bfR;
    private short bfS;
    private short bfT;
    private int channelConfiguration;
    private int dataSize;
    private String filePath;
    private int frequency;
    private int bfP = 0;
    private boolean axI = false;
    private AudioRecord mAudioRecord = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.bfP = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.frequency = i2;
        this.channelConfiguration = i3;
        this.bfR = i4;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
        }
        this.mAudioRecord = new AudioRecord(i, this.frequency, this.channelConfiguration, this.bfR, this.bfP);
        this.bfS = (short) (this.channelConfiguration == 12 ? 2 : 1);
        this.bfT = (short) (this.bfR == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.bfQ != null) {
                try {
                    this.bfQ.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.bfQ = new RandomAccessFile(this.file, "rw");
                ER();
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
        return a(bfO, bfL, bfM, bfN, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EO() {
        if (this.mAudioRecord != null && this.file != null) {
            try {
                this.axI = true;
                byte[] bArr = new byte[this.bfP];
                this.mAudioRecord.startRecording();
                while (this.axI) {
                    this.mAudioRecord.read(bArr, 0, bArr.length);
                    this.bfQ.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.bfQ.seek(4L);
                this.bfQ.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.bfQ.seek(40L);
                this.bfQ.writeInt(Integer.reverseBytes(this.dataSize));
                this.bfQ.close();
                this.mAudioRecord.stop();
                this.mAudioRecord.release();
                this.axI = false;
            } catch (Throwable th) {
                if (this.file.exists()) {
                    this.file.delete();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean EP() {
        Thread thread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.EO();
            }
        });
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void EQ() {
        this.axI = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean isRecording() {
        return this.axI;
    }

    private void ER() {
        try {
            this.bfQ.setLength(0L);
            this.bfQ.writeBytes("RIFF");
            this.bfQ.writeInt(0);
            this.bfQ.writeBytes("WAVE");
            this.bfQ.writeBytes("fmt ");
            this.bfQ.writeInt(Integer.reverseBytes(16));
            this.bfQ.writeShort(Short.reverseBytes((short) 1));
            this.bfQ.writeShort(Short.reverseBytes(this.bfS));
            this.bfQ.writeInt(Integer.reverseBytes(this.frequency));
            this.bfQ.writeInt(Integer.reverseBytes(((this.frequency * this.bfS) * this.bfT) / 8));
            this.bfQ.writeShort(Short.reverseBytes((short) ((this.bfS * this.bfT) / 8)));
            this.bfQ.writeShort(Short.reverseBytes(this.bfT));
            this.bfQ.writeBytes("data");
            this.bfQ.writeInt(0);
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
