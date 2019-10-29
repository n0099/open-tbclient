package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements d {
    public static int ctB = 8000;
    public static int ctC = 2;
    public static int ctD = 2;
    public static int ctE = 1;
    private int channelConfiguration;
    private RandomAccessFile ctF;
    private int ctG;
    private int ctH;
    private short ctI;
    private short ctJ;
    private int dataSize;
    private String filePath;
    private int bufferSize = 0;
    private boolean Dn = false;
    private AudioRecord mAudioRecord = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.ctG = i2;
        this.channelConfiguration = i3;
        this.ctH = i4;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
        }
        this.mAudioRecord = new AudioRecord(i, this.ctG, this.channelConfiguration, this.ctH, this.bufferSize);
        this.ctI = (short) (this.channelConfiguration == 12 ? 2 : 1);
        this.ctJ = (short) (this.ctH == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.ctF != null) {
                try {
                    this.ctF.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.ctF = new RandomAccessFile(this.file, "rw");
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
        return a(ctE, ctB, ctC, ctD, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoz() {
        if (this.mAudioRecord != null && this.file != null) {
            try {
                this.Dn = true;
                byte[] bArr = new byte[this.bufferSize];
                this.mAudioRecord.startRecording();
                while (this.Dn) {
                    this.mAudioRecord.read(bArr, 0, bArr.length);
                    this.ctF.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.ctF.seek(4L);
                this.ctF.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.ctF.seek(40L);
                this.ctF.writeInt(Integer.reverseBytes(this.dataSize));
                this.ctF.close();
                this.mAudioRecord.stop();
                this.mAudioRecord.release();
                this.Dn = false;
            } catch (Throwable th) {
                if (this.file.exists()) {
                    this.file.delete();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean aoA() {
        Thread thread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.aoz();
            }
        });
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void aoB() {
        this.Dn = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean aoC() {
        return this.Dn;
    }

    private void writeHeader() {
        try {
            this.ctF.setLength(0L);
            this.ctF.writeBytes("RIFF");
            this.ctF.writeInt(0);
            this.ctF.writeBytes("WAVE");
            this.ctF.writeBytes("fmt ");
            this.ctF.writeInt(Integer.reverseBytes(16));
            this.ctF.writeShort(Short.reverseBytes((short) 1));
            this.ctF.writeShort(Short.reverseBytes(this.ctI));
            this.ctF.writeInt(Integer.reverseBytes(this.ctG));
            this.ctF.writeInt(Integer.reverseBytes(((this.ctG * this.ctI) * this.ctJ) / 8));
            this.ctF.writeShort(Short.reverseBytes((short) ((this.ctI * this.ctJ) / 8)));
            this.ctF.writeShort(Short.reverseBytes(this.ctJ));
            this.ctF.writeBytes("data");
            this.ctF.writeInt(0);
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
