package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements d {
    public static int dld = 8000;
    public static int dle = 2;
    public static int dlf = 2;
    public static int dlg = 1;
    private int channelConfiguration;
    private int dataSize;
    private RandomAccessFile dlh;
    private int dli;
    private int dlj;
    private short dlk;
    private short dll;
    private String filePath;
    private int bufferSize = 0;
    private boolean FQ = false;
    private AudioRecord mAudioRecord = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.dli = i2;
        this.channelConfiguration = i3;
        this.dlj = i4;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
        }
        this.mAudioRecord = new AudioRecord(i, this.dli, this.channelConfiguration, this.dlj, this.bufferSize);
        this.dlk = (short) (this.channelConfiguration == 12 ? 2 : 1);
        this.dll = (short) (this.dlj == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.dlh != null) {
                try {
                    this.dlh.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.dlh = new RandomAccessFile(this.file, "rw");
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
        return a(dlg, dld, dle, dlf, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIL() {
        if (this.mAudioRecord != null && this.file != null) {
            try {
                this.FQ = true;
                byte[] bArr = new byte[this.bufferSize];
                this.mAudioRecord.startRecording();
                while (this.FQ) {
                    this.mAudioRecord.read(bArr, 0, bArr.length);
                    this.dlh.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.dlh.seek(4L);
                this.dlh.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.dlh.seek(40L);
                this.dlh.writeInt(Integer.reverseBytes(this.dataSize));
                this.dlh.close();
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
    public boolean aIM() {
        Thread thread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.aIL();
            }
        });
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void aIN() {
        this.FQ = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean isRecording() {
        return this.FQ;
    }

    private void writeHeader() {
        try {
            this.dlh.setLength(0L);
            this.dlh.writeBytes("RIFF");
            this.dlh.writeInt(0);
            this.dlh.writeBytes("WAVE");
            this.dlh.writeBytes("fmt ");
            this.dlh.writeInt(Integer.reverseBytes(16));
            this.dlh.writeShort(Short.reverseBytes((short) 1));
            this.dlh.writeShort(Short.reverseBytes(this.dlk));
            this.dlh.writeInt(Integer.reverseBytes(this.dli));
            this.dlh.writeInt(Integer.reverseBytes(((this.dli * this.dlk) * this.dll) / 8));
            this.dlh.writeShort(Short.reverseBytes((short) ((this.dlk * this.dll) / 8)));
            this.dlh.writeShort(Short.reverseBytes(this.dll));
            this.dlh.writeBytes("data");
            this.dlh.writeInt(0);
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
