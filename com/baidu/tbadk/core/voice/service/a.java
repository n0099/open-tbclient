package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements d {
    public static int arw = 8000;
    public static int arx = 2;
    public static int ary = 2;
    public static int arz = 1;
    private RandomAccessFile arA;
    private int arB;
    private short arC;
    private short arD;
    private int channelConfiguration;
    private int dataSize;
    private String filePath;
    private int frequency;
    private int bufferSize = 0;
    private boolean JU = false;
    private AudioRecord mAudioRecord = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.frequency = i2;
        this.channelConfiguration = i3;
        this.arB = i4;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
        }
        this.mAudioRecord = new AudioRecord(i, this.frequency, this.channelConfiguration, this.arB, this.bufferSize);
        this.arC = (short) (this.channelConfiguration == 12 ? 2 : 1);
        this.arD = (short) (this.arB == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.arA != null) {
                try {
                    this.arA.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.arA = new RandomAccessFile(this.file, "rw");
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
    public boolean eU(String str) {
        return a(arz, arw, arx, ary, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xD() {
        if (this.mAudioRecord != null && this.file != null) {
            try {
                this.JU = true;
                byte[] bArr = new byte[this.bufferSize];
                this.mAudioRecord.startRecording();
                while (this.JU) {
                    this.mAudioRecord.read(bArr, 0, bArr.length);
                    this.arA.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.arA.seek(4L);
                this.arA.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.arA.seek(40L);
                this.arA.writeInt(Integer.reverseBytes(this.dataSize));
                this.arA.close();
                this.mAudioRecord.stop();
                this.mAudioRecord.release();
                this.JU = false;
            } catch (Throwable th) {
                if (this.file.exists()) {
                    this.file.delete();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean xE() {
        Thread thread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.xD();
            }
        });
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void xF() {
        this.JU = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean isRecording() {
        return this.JU;
    }

    private void writeHeader() {
        try {
            this.arA.setLength(0L);
            this.arA.writeBytes("RIFF");
            this.arA.writeInt(0);
            this.arA.writeBytes("WAVE");
            this.arA.writeBytes("fmt ");
            this.arA.writeInt(Integer.reverseBytes(16));
            this.arA.writeShort(Short.reverseBytes((short) 1));
            this.arA.writeShort(Short.reverseBytes(this.arC));
            this.arA.writeInt(Integer.reverseBytes(this.frequency));
            this.arA.writeInt(Integer.reverseBytes(((this.frequency * this.arC) * this.arD) / 8));
            this.arA.writeShort(Short.reverseBytes((short) ((this.arC * this.arD) / 8)));
            this.arA.writeShort(Short.reverseBytes(this.arD));
            this.arA.writeBytes("data");
            this.arA.writeInt(0);
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
