package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements d {
    public static int aIJ = 8000;
    public static int aIK = 2;
    public static int aIL = 2;
    public static int aIM = 1;
    private RandomAccessFile aIN;
    private int aIO;
    private short aIP;
    private short aIQ;
    private int channelConfiguration;
    private int dataSize;
    private String filePath;
    private int frequency;
    private int bufferSize = 0;
    private boolean Tc = false;
    private AudioRecord mAudioRecord = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.frequency = i2;
        this.channelConfiguration = i3;
        this.aIO = i4;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
        }
        this.mAudioRecord = new AudioRecord(i, this.frequency, this.channelConfiguration, this.aIO, this.bufferSize);
        this.aIP = (short) (this.channelConfiguration == 12 ? 2 : 1);
        this.aIQ = (short) (this.aIO == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.aIN != null) {
                try {
                    this.aIN.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.aIN = new RandomAccessFile(this.file, "rw");
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
    public boolean ge(String str) {
        return a(aIM, aIJ, aIK, aIL, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EK() {
        if (this.mAudioRecord != null && this.file != null) {
            try {
                this.Tc = true;
                byte[] bArr = new byte[this.bufferSize];
                this.mAudioRecord.startRecording();
                while (this.Tc) {
                    this.mAudioRecord.read(bArr, 0, bArr.length);
                    this.aIN.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.aIN.seek(4L);
                this.aIN.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.aIN.seek(40L);
                this.aIN.writeInt(Integer.reverseBytes(this.dataSize));
                this.aIN.close();
                this.mAudioRecord.stop();
                this.mAudioRecord.release();
                this.Tc = false;
            } catch (Throwable th) {
                if (this.file.exists()) {
                    this.file.delete();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean EL() {
        Thread thread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.EK();
            }
        });
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void EM() {
        this.Tc = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean EN() {
        return this.Tc;
    }

    private void writeHeader() {
        try {
            this.aIN.setLength(0L);
            this.aIN.writeBytes("RIFF");
            this.aIN.writeInt(0);
            this.aIN.writeBytes("WAVE");
            this.aIN.writeBytes("fmt ");
            this.aIN.writeInt(Integer.reverseBytes(16));
            this.aIN.writeShort(Short.reverseBytes((short) 1));
            this.aIN.writeShort(Short.reverseBytes(this.aIP));
            this.aIN.writeInt(Integer.reverseBytes(this.frequency));
            this.aIN.writeInt(Integer.reverseBytes(((this.frequency * this.aIP) * this.aIQ) / 8));
            this.aIN.writeShort(Short.reverseBytes((short) ((this.aIP * this.aIQ) / 8)));
            this.aIN.writeShort(Short.reverseBytes(this.aIQ));
            this.aIN.writeBytes("data");
            this.aIN.writeInt(0);
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
