package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements d {
    public static int cdn = 8000;
    public static int cdo = 2;
    public static int cdp = 2;
    public static int cdq = 1;
    private RandomAccessFile cdr;
    private int cds;
    private short cdt;
    private short cdu;
    private int channelConfiguration;
    private int dataSize;
    private String filePath;
    private int frequency;
    private int bufferSize = 0;
    private boolean TC = false;
    private AudioRecord mAudioRecord = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.frequency = i2;
        this.channelConfiguration = i3;
        this.cds = i4;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
        }
        this.mAudioRecord = new AudioRecord(i, this.frequency, this.channelConfiguration, this.cds, this.bufferSize);
        this.cdt = (short) (this.channelConfiguration == 12 ? 2 : 1);
        this.cdu = (short) (this.cds == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.cdr != null) {
                try {
                    this.cdr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.cdr = new RandomAccessFile(this.file, "rw");
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
    public boolean oH(String str) {
        return a(cdq, cdn, cdo, cdp, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aks() {
        if (this.mAudioRecord != null && this.file != null) {
            try {
                this.TC = true;
                byte[] bArr = new byte[this.bufferSize];
                this.mAudioRecord.startRecording();
                while (this.TC) {
                    this.mAudioRecord.read(bArr, 0, bArr.length);
                    this.cdr.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.cdr.seek(4L);
                this.cdr.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.cdr.seek(40L);
                this.cdr.writeInt(Integer.reverseBytes(this.dataSize));
                this.cdr.close();
                this.mAudioRecord.stop();
                this.mAudioRecord.release();
                this.TC = false;
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
        this.TC = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean akv() {
        return this.TC;
    }

    private void writeHeader() {
        try {
            this.cdr.setLength(0L);
            this.cdr.writeBytes("RIFF");
            this.cdr.writeInt(0);
            this.cdr.writeBytes("WAVE");
            this.cdr.writeBytes("fmt ");
            this.cdr.writeInt(Integer.reverseBytes(16));
            this.cdr.writeShort(Short.reverseBytes((short) 1));
            this.cdr.writeShort(Short.reverseBytes(this.cdt));
            this.cdr.writeInt(Integer.reverseBytes(this.frequency));
            this.cdr.writeInt(Integer.reverseBytes(((this.frequency * this.cdt) * this.cdu) / 8));
            this.cdr.writeShort(Short.reverseBytes((short) ((this.cdt * this.cdu) / 8)));
            this.cdr.writeShort(Short.reverseBytes(this.cdu));
            this.cdr.writeBytes("data");
            this.cdr.writeInt(0);
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
