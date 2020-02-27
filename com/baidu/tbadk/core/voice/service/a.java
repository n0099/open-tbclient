package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements d {
    public static int dkP = 8000;
    public static int dkQ = 2;
    public static int dkR = 2;
    public static int dkS = 1;
    private int channelConfiguration;
    private int dataSize;
    private RandomAccessFile dkT;
    private int dkU;
    private int dkV;
    private short dkW;
    private short dkX;
    private String filePath;
    private int bufferSize = 0;
    private boolean FQ = false;
    private AudioRecord mAudioRecord = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.dkU = i2;
        this.channelConfiguration = i3;
        this.dkV = i4;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
        }
        this.mAudioRecord = new AudioRecord(i, this.dkU, this.channelConfiguration, this.dkV, this.bufferSize);
        this.dkW = (short) (this.channelConfiguration == 12 ? 2 : 1);
        this.dkX = (short) (this.dkV == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.dkT != null) {
                try {
                    this.dkT.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.dkT = new RandomAccessFile(this.file, "rw");
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
    public boolean ud(String str) {
        return a(dkS, dkP, dkQ, dkR, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aII() {
        if (this.mAudioRecord != null && this.file != null) {
            try {
                this.FQ = true;
                byte[] bArr = new byte[this.bufferSize];
                this.mAudioRecord.startRecording();
                while (this.FQ) {
                    this.mAudioRecord.read(bArr, 0, bArr.length);
                    this.dkT.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.dkT.seek(4L);
                this.dkT.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.dkT.seek(40L);
                this.dkT.writeInt(Integer.reverseBytes(this.dataSize));
                this.dkT.close();
                this.mAudioRecord.stop();
                this.mAudioRecord.release();
                this.FQ = false;
            } catch (Throwable th) {
                if (this.file.exists()) {
                    this.file.delete();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean aIJ() {
        Thread thread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.aII();
            }
        });
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void aIK() {
        this.FQ = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean isRecording() {
        return this.FQ;
    }

    private void writeHeader() {
        try {
            this.dkT.setLength(0L);
            this.dkT.writeBytes("RIFF");
            this.dkT.writeInt(0);
            this.dkT.writeBytes("WAVE");
            this.dkT.writeBytes("fmt ");
            this.dkT.writeInt(Integer.reverseBytes(16));
            this.dkT.writeShort(Short.reverseBytes((short) 1));
            this.dkT.writeShort(Short.reverseBytes(this.dkW));
            this.dkT.writeInt(Integer.reverseBytes(this.dkU));
            this.dkT.writeInt(Integer.reverseBytes(((this.dkU * this.dkW) * this.dkX) / 8));
            this.dkT.writeShort(Short.reverseBytes((short) ((this.dkW * this.dkX) / 8)));
            this.dkT.writeShort(Short.reverseBytes(this.dkX));
            this.dkT.writeBytes("data");
            this.dkT.writeInt(0);
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
