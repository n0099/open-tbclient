package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements d {
    public static int cfp = 8000;
    public static int cfq = 2;
    public static int cfr = 2;
    public static int cfs = 1;
    private RandomAccessFile cft;
    private int cfu;
    private int cfv;
    private short cfw;
    private short cfx;
    private int channelConfiguration;
    private int dataSize;
    private String filePath;
    private int bufferSize = 0;
    private boolean TV = false;
    private AudioRecord mAudioRecord = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.cfu = i2;
        this.channelConfiguration = i3;
        this.cfv = i4;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
        }
        this.mAudioRecord = new AudioRecord(i, this.cfu, this.channelConfiguration, this.cfv, this.bufferSize);
        this.cfw = (short) (this.channelConfiguration == 12 ? 2 : 1);
        this.cfx = (short) (this.cfv == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.cft != null) {
                try {
                    this.cft.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.cft = new RandomAccessFile(this.file, "rw");
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
    public boolean pg(String str) {
        return a(cfs, cfp, cfq, cfr, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alL() {
        if (this.mAudioRecord != null && this.file != null) {
            try {
                this.TV = true;
                byte[] bArr = new byte[this.bufferSize];
                this.mAudioRecord.startRecording();
                while (this.TV) {
                    this.mAudioRecord.read(bArr, 0, bArr.length);
                    this.cft.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.cft.seek(4L);
                this.cft.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.cft.seek(40L);
                this.cft.writeInt(Integer.reverseBytes(this.dataSize));
                this.cft.close();
                this.mAudioRecord.stop();
                this.mAudioRecord.release();
                this.TV = false;
            } catch (Throwable th) {
                if (this.file.exists()) {
                    this.file.delete();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean alM() {
        Thread thread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.alL();
            }
        });
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void alN() {
        this.TV = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean alO() {
        return this.TV;
    }

    private void writeHeader() {
        try {
            this.cft.setLength(0L);
            this.cft.writeBytes("RIFF");
            this.cft.writeInt(0);
            this.cft.writeBytes("WAVE");
            this.cft.writeBytes("fmt ");
            this.cft.writeInt(Integer.reverseBytes(16));
            this.cft.writeShort(Short.reverseBytes((short) 1));
            this.cft.writeShort(Short.reverseBytes(this.cfw));
            this.cft.writeInt(Integer.reverseBytes(this.cfu));
            this.cft.writeInt(Integer.reverseBytes(((this.cfu * this.cfw) * this.cfx) / 8));
            this.cft.writeShort(Short.reverseBytes((short) ((this.cfw * this.cfx) / 8)));
            this.cft.writeShort(Short.reverseBytes(this.cfx));
            this.cft.writeBytes("data");
            this.cft.writeInt(0);
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
