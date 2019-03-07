package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements d {
    public static int bVn = 8000;
    public static int bVo = 2;
    public static int bVp = 2;
    public static int bVq = 1;
    private RandomAccessFile bVr;
    private int bVs;
    private short bVt;
    private short bVu;
    private int channelConfiguration;
    private int dataSize;
    private String filePath;
    private int frequency;
    private int bufferSize = 0;
    private boolean VO = false;
    private AudioRecord mAudioRecord = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.frequency = i2;
        this.channelConfiguration = i3;
        this.bVs = i4;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
        }
        this.mAudioRecord = new AudioRecord(i, this.frequency, this.channelConfiguration, this.bVs, this.bufferSize);
        this.bVt = (short) (this.channelConfiguration == 12 ? 2 : 1);
        this.bVu = (short) (this.bVs == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.bVr != null) {
                try {
                    this.bVr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.bVr = new RandomAccessFile(this.file, "rw");
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
        return a(bVq, bVn, bVo, bVp, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afw() {
        if (this.mAudioRecord != null && this.file != null) {
            try {
                this.VO = true;
                byte[] bArr = new byte[this.bufferSize];
                this.mAudioRecord.startRecording();
                while (this.VO) {
                    this.mAudioRecord.read(bArr, 0, bArr.length);
                    this.bVr.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.bVr.seek(4L);
                this.bVr.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.bVr.seek(40L);
                this.bVr.writeInt(Integer.reverseBytes(this.dataSize));
                this.bVr.close();
                this.mAudioRecord.stop();
                this.mAudioRecord.release();
                this.VO = false;
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
        this.VO = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean afz() {
        return this.VO;
    }

    private void writeHeader() {
        try {
            this.bVr.setLength(0L);
            this.bVr.writeBytes("RIFF");
            this.bVr.writeInt(0);
            this.bVr.writeBytes("WAVE");
            this.bVr.writeBytes("fmt ");
            this.bVr.writeInt(Integer.reverseBytes(16));
            this.bVr.writeShort(Short.reverseBytes((short) 1));
            this.bVr.writeShort(Short.reverseBytes(this.bVt));
            this.bVr.writeInt(Integer.reverseBytes(this.frequency));
            this.bVr.writeInt(Integer.reverseBytes(((this.frequency * this.bVt) * this.bVu) / 8));
            this.bVr.writeShort(Short.reverseBytes((short) ((this.bVt * this.bVu) / 8)));
            this.bVr.writeShort(Short.reverseBytes(this.bVu));
            this.bVr.writeBytes("data");
            this.bVr.writeInt(0);
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
