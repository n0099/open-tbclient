package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements d {
    public static int csK = 8000;
    public static int csL = 2;
    public static int csM = 2;
    public static int csN = 1;
    private int channelConfiguration;
    private RandomAccessFile csO;
    private int csP;
    private int csQ;
    private short csR;
    private short csS;
    private int dataSize;
    private String filePath;
    private int bufferSize = 0;
    private boolean CL = false;
    private AudioRecord mAudioRecord = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.csP = i2;
        this.channelConfiguration = i3;
        this.csQ = i4;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
        }
        this.mAudioRecord = new AudioRecord(i, this.csP, this.channelConfiguration, this.csQ, this.bufferSize);
        this.csR = (short) (this.channelConfiguration == 12 ? 2 : 1);
        this.csS = (short) (this.csQ == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.csO != null) {
                try {
                    this.csO.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.csO = new RandomAccessFile(this.file, "rw");
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
    public boolean oF(String str) {
        return a(csN, csK, csL, csM, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aox() {
        if (this.mAudioRecord != null && this.file != null) {
            try {
                this.CL = true;
                byte[] bArr = new byte[this.bufferSize];
                this.mAudioRecord.startRecording();
                while (this.CL) {
                    this.mAudioRecord.read(bArr, 0, bArr.length);
                    this.csO.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.csO.seek(4L);
                this.csO.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.csO.seek(40L);
                this.csO.writeInt(Integer.reverseBytes(this.dataSize));
                this.csO.close();
                this.mAudioRecord.stop();
                this.mAudioRecord.release();
                this.CL = false;
            } catch (Throwable th) {
                if (this.file.exists()) {
                    this.file.delete();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean aoy() {
        Thread thread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.aox();
            }
        });
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void aoz() {
        this.CL = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean aoA() {
        return this.CL;
    }

    private void writeHeader() {
        try {
            this.csO.setLength(0L);
            this.csO.writeBytes("RIFF");
            this.csO.writeInt(0);
            this.csO.writeBytes("WAVE");
            this.csO.writeBytes("fmt ");
            this.csO.writeInt(Integer.reverseBytes(16));
            this.csO.writeShort(Short.reverseBytes((short) 1));
            this.csO.writeShort(Short.reverseBytes(this.csR));
            this.csO.writeInt(Integer.reverseBytes(this.csP));
            this.csO.writeInt(Integer.reverseBytes(((this.csP * this.csR) * this.csS) / 8));
            this.csO.writeShort(Short.reverseBytes((short) ((this.csR * this.csS) / 8)));
            this.csO.writeShort(Short.reverseBytes(this.csS));
            this.csO.writeBytes("data");
            this.csO.writeInt(0);
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
