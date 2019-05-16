package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements d {
    public static int cdm = 8000;
    public static int cdn = 2;
    public static int cdo = 2;
    public static int cdp = 1;
    private RandomAccessFile cdq;
    private int cdr;
    private short cds;
    private short cdt;
    private int channelConfiguration;
    private int dataSize;
    private String filePath;
    private int frequency;
    private int bufferSize = 0;
    private boolean TD = false;
    private AudioRecord mAudioRecord = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.frequency = i2;
        this.channelConfiguration = i3;
        this.cdr = i4;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
        }
        this.mAudioRecord = new AudioRecord(i, this.frequency, this.channelConfiguration, this.cdr, this.bufferSize);
        this.cds = (short) (this.channelConfiguration == 12 ? 2 : 1);
        this.cdt = (short) (this.cdr == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.cdq != null) {
                try {
                    this.cdq.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.cdq = new RandomAccessFile(this.file, "rw");
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
    public boolean oI(String str) {
        return a(cdp, cdm, cdn, cdo, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aks() {
        if (this.mAudioRecord != null && this.file != null) {
            try {
                this.TD = true;
                byte[] bArr = new byte[this.bufferSize];
                this.mAudioRecord.startRecording();
                while (this.TD) {
                    this.mAudioRecord.read(bArr, 0, bArr.length);
                    this.cdq.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.cdq.seek(4L);
                this.cdq.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.cdq.seek(40L);
                this.cdq.writeInt(Integer.reverseBytes(this.dataSize));
                this.cdq.close();
                this.mAudioRecord.stop();
                this.mAudioRecord.release();
                this.TD = false;
            } catch (Throwable th) {
                if (this.file.exists()) {
                    this.file.delete();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean akt() {
        Thread thread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.aks();
            }
        });
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void aku() {
        this.TD = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean akv() {
        return this.TD;
    }

    private void writeHeader() {
        try {
            this.cdq.setLength(0L);
            this.cdq.writeBytes("RIFF");
            this.cdq.writeInt(0);
            this.cdq.writeBytes("WAVE");
            this.cdq.writeBytes("fmt ");
            this.cdq.writeInt(Integer.reverseBytes(16));
            this.cdq.writeShort(Short.reverseBytes((short) 1));
            this.cdq.writeShort(Short.reverseBytes(this.cds));
            this.cdq.writeInt(Integer.reverseBytes(this.frequency));
            this.cdq.writeInt(Integer.reverseBytes(((this.frequency * this.cds) * this.cdt) / 8));
            this.cdq.writeShort(Short.reverseBytes((short) ((this.cds * this.cdt) / 8)));
            this.cdq.writeShort(Short.reverseBytes(this.cdt));
            this.cdq.writeBytes("data");
            this.cdq.writeInt(0);
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
