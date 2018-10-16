package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements d {
    public static int aHT = 8000;
    public static int aHU = 2;
    public static int aHV = 2;
    public static int aHW = 1;
    private RandomAccessFile aHX;
    private int aHY;
    private short aHZ;
    private short aIa;
    private int channelConfiguration;
    private int dataSize;
    private String filePath;
    private int frequency;
    private int bufferSize = 0;
    private boolean Ta = false;
    private AudioRecord mAudioRecord = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.frequency = i2;
        this.channelConfiguration = i3;
        this.aHY = i4;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
        }
        this.mAudioRecord = new AudioRecord(i, this.frequency, this.channelConfiguration, this.aHY, this.bufferSize);
        this.aHZ = (short) (this.channelConfiguration == 12 ? 2 : 1);
        this.aIa = (short) (this.aHY == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.aHX != null) {
                try {
                    this.aHX.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.aHX = new RandomAccessFile(this.file, "rw");
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
    public boolean gd(String str) {
        return a(aHW, aHT, aHU, aHV, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EA() {
        if (this.mAudioRecord != null && this.file != null) {
            try {
                this.Ta = true;
                byte[] bArr = new byte[this.bufferSize];
                this.mAudioRecord.startRecording();
                while (this.Ta) {
                    this.mAudioRecord.read(bArr, 0, bArr.length);
                    this.aHX.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.aHX.seek(4L);
                this.aHX.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.aHX.seek(40L);
                this.aHX.writeInt(Integer.reverseBytes(this.dataSize));
                this.aHX.close();
                this.mAudioRecord.stop();
                this.mAudioRecord.release();
                this.Ta = false;
            } catch (Throwable th) {
                if (this.file.exists()) {
                    this.file.delete();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean EB() {
        Thread thread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.EA();
            }
        });
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void EC() {
        this.Ta = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean isRecording() {
        return this.Ta;
    }

    private void writeHeader() {
        try {
            this.aHX.setLength(0L);
            this.aHX.writeBytes("RIFF");
            this.aHX.writeInt(0);
            this.aHX.writeBytes("WAVE");
            this.aHX.writeBytes("fmt ");
            this.aHX.writeInt(Integer.reverseBytes(16));
            this.aHX.writeShort(Short.reverseBytes((short) 1));
            this.aHX.writeShort(Short.reverseBytes(this.aHZ));
            this.aHX.writeInt(Integer.reverseBytes(this.frequency));
            this.aHX.writeInt(Integer.reverseBytes(((this.frequency * this.aHZ) * this.aIa) / 8));
            this.aHX.writeShort(Short.reverseBytes((short) ((this.aHZ * this.aIa) / 8)));
            this.aHX.writeShort(Short.reverseBytes(this.aIa));
            this.aHX.writeBytes("data");
            this.aHX.writeInt(0);
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
