package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements d {
    public static int bVo = 8000;
    public static int bVp = 2;
    public static int bVq = 2;
    public static int bVr = 1;
    private RandomAccessFile bVs;
    private int bVt;
    private short bVu;
    private short bVv;
    private int channelConfiguration;
    private int dataSize;
    private String filePath;
    private int frequency;
    private int bufferSize = 0;
    private boolean VP = false;
    private AudioRecord mAudioRecord = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.frequency = i2;
        this.channelConfiguration = i3;
        this.bVt = i4;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
        }
        this.mAudioRecord = new AudioRecord(i, this.frequency, this.channelConfiguration, this.bVt, this.bufferSize);
        this.bVu = (short) (this.channelConfiguration == 12 ? 2 : 1);
        this.bVv = (short) (this.bVt == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.bVs != null) {
                try {
                    this.bVs.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.bVs = new RandomAccessFile(this.file, "rw");
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
    public boolean nx(String str) {
        return a(bVr, bVo, bVp, bVq, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afw() {
        if (this.mAudioRecord != null && this.file != null) {
            try {
                this.VP = true;
                byte[] bArr = new byte[this.bufferSize];
                this.mAudioRecord.startRecording();
                while (this.VP) {
                    this.mAudioRecord.read(bArr, 0, bArr.length);
                    this.bVs.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.bVs.seek(4L);
                this.bVs.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.bVs.seek(40L);
                this.bVs.writeInt(Integer.reverseBytes(this.dataSize));
                this.bVs.close();
                this.mAudioRecord.stop();
                this.mAudioRecord.release();
                this.VP = false;
            } catch (Throwable th) {
                if (this.file.exists()) {
                    this.file.delete();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean afx() {
        Thread thread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.afw();
            }
        });
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void afy() {
        this.VP = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean afz() {
        return this.VP;
    }

    private void writeHeader() {
        try {
            this.bVs.setLength(0L);
            this.bVs.writeBytes("RIFF");
            this.bVs.writeInt(0);
            this.bVs.writeBytes("WAVE");
            this.bVs.writeBytes("fmt ");
            this.bVs.writeInt(Integer.reverseBytes(16));
            this.bVs.writeShort(Short.reverseBytes((short) 1));
            this.bVs.writeShort(Short.reverseBytes(this.bVu));
            this.bVs.writeInt(Integer.reverseBytes(this.frequency));
            this.bVs.writeInt(Integer.reverseBytes(((this.frequency * this.bVu) * this.bVv) / 8));
            this.bVs.writeShort(Short.reverseBytes((short) ((this.bVu * this.bVv) / 8)));
            this.bVs.writeShort(Short.reverseBytes(this.bVv));
            this.bVs.writeBytes("data");
            this.bVs.writeInt(0);
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
