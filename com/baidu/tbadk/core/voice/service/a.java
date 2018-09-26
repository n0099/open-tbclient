package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements d {
    public static int aDn = 8000;
    public static int aDo = 2;
    public static int aDp = 2;
    public static int aDq = 1;
    private RandomAccessFile aDs;
    private int aDt;
    private short aDu;
    private short aDv;
    private int channelConfiguration;
    private int dataSize;
    private String filePath;
    private int frequency;
    private int aDr = 0;
    private boolean SJ = false;
    private AudioRecord mAudioRecord = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.aDr = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.frequency = i2;
        this.channelConfiguration = i3;
        this.aDt = i4;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
        }
        this.mAudioRecord = new AudioRecord(i, this.frequency, this.channelConfiguration, this.aDt, this.aDr);
        this.aDu = (short) (this.channelConfiguration == 12 ? 2 : 1);
        this.aDv = (short) (this.aDt == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.aDs != null) {
                try {
                    this.aDs.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.aDs = new RandomAccessFile(this.file, "rw");
                Cy();
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
    public boolean fP(String str) {
        return a(aDq, aDn, aDo, aDp, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cv() {
        if (this.mAudioRecord != null && this.file != null) {
            try {
                this.SJ = true;
                byte[] bArr = new byte[this.aDr];
                this.mAudioRecord.startRecording();
                while (this.SJ) {
                    this.mAudioRecord.read(bArr, 0, bArr.length);
                    this.aDs.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.aDs.seek(4L);
                this.aDs.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.aDs.seek(40L);
                this.aDs.writeInt(Integer.reverseBytes(this.dataSize));
                this.aDs.close();
                this.mAudioRecord.stop();
                this.mAudioRecord.release();
                this.SJ = false;
            } catch (Throwable th) {
                if (this.file.exists()) {
                    this.file.delete();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean Cw() {
        Thread thread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.Cv();
            }
        });
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void Cx() {
        this.SJ = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean isRecording() {
        return this.SJ;
    }

    private void Cy() {
        try {
            this.aDs.setLength(0L);
            this.aDs.writeBytes("RIFF");
            this.aDs.writeInt(0);
            this.aDs.writeBytes("WAVE");
            this.aDs.writeBytes("fmt ");
            this.aDs.writeInt(Integer.reverseBytes(16));
            this.aDs.writeShort(Short.reverseBytes((short) 1));
            this.aDs.writeShort(Short.reverseBytes(this.aDu));
            this.aDs.writeInt(Integer.reverseBytes(this.frequency));
            this.aDs.writeInt(Integer.reverseBytes(((this.frequency * this.aDu) * this.aDv) / 8));
            this.aDs.writeShort(Short.reverseBytes((short) ((this.aDu * this.aDv) / 8)));
            this.aDs.writeShort(Short.reverseBytes(this.aDv));
            this.aDs.writeBytes("data");
            this.aDs.writeInt(0);
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
