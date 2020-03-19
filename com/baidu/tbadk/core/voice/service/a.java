package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements d {
    public static int dlq = 8000;
    public static int dlr = 2;
    public static int dls = 2;
    public static int dlt = 1;
    private int channelConfiguration;
    private int dataSize;
    private RandomAccessFile dlu;
    private int dlv;
    private int dlw;
    private short dlx;
    private short dly;
    private String filePath;
    private int bufferSize = 0;
    private boolean FQ = false;
    private AudioRecord mAudioRecord = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.dlv = i2;
        this.channelConfiguration = i3;
        this.dlw = i4;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
        }
        this.mAudioRecord = new AudioRecord(i, this.dlv, this.channelConfiguration, this.dlw, this.bufferSize);
        this.dlx = (short) (this.channelConfiguration == 12 ? 2 : 1);
        this.dly = (short) (this.dlw == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.dlu != null) {
                try {
                    this.dlu.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.dlu = new RandomAccessFile(this.file, "rw");
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
    public boolean ue(String str) {
        return a(dlt, dlq, dlr, dls, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIP() {
        if (this.mAudioRecord != null && this.file != null) {
            try {
                this.FQ = true;
                byte[] bArr = new byte[this.bufferSize];
                this.mAudioRecord.startRecording();
                while (this.FQ) {
                    this.mAudioRecord.read(bArr, 0, bArr.length);
                    this.dlu.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.dlu.seek(4L);
                this.dlu.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.dlu.seek(40L);
                this.dlu.writeInt(Integer.reverseBytes(this.dataSize));
                this.dlu.close();
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
    public boolean aIQ() {
        Thread thread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.aIP();
            }
        });
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void aIR() {
        this.FQ = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean isRecording() {
        return this.FQ;
    }

    private void writeHeader() {
        try {
            this.dlu.setLength(0L);
            this.dlu.writeBytes("RIFF");
            this.dlu.writeInt(0);
            this.dlu.writeBytes("WAVE");
            this.dlu.writeBytes("fmt ");
            this.dlu.writeInt(Integer.reverseBytes(16));
            this.dlu.writeShort(Short.reverseBytes((short) 1));
            this.dlu.writeShort(Short.reverseBytes(this.dlx));
            this.dlu.writeInt(Integer.reverseBytes(this.dlv));
            this.dlu.writeInt(Integer.reverseBytes(((this.dlv * this.dlx) * this.dly) / 8));
            this.dlu.writeShort(Short.reverseBytes((short) ((this.dlx * this.dly) / 8)));
            this.dlu.writeShort(Short.reverseBytes(this.dly));
            this.dlu.writeBytes("data");
            this.dlu.writeInt(0);
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
