package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements d {
    public static int frE = 8000;
    public static int frF = 2;
    public static int frG = 2;
    public static int frH = 1;
    private int channelConfiguration;
    private int dataSize;
    private String filePath;
    private RandomAccessFile frI;
    private int frJ;
    private int frK;
    private short frL;
    private short frM;
    private int bufferSize = 0;
    private boolean adb = false;
    private AudioRecord mAudioRecord = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.frJ = i2;
        this.channelConfiguration = i3;
        this.frK = i4;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
        }
        this.mAudioRecord = new AudioRecord(i, this.frJ, this.channelConfiguration, this.frK, this.bufferSize);
        this.frL = (short) (this.channelConfiguration == 12 ? 2 : 1);
        this.frM = (short) (this.frK == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.frI != null) {
                try {
                    this.frI.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.frI = new RandomAccessFile(this.file, "rw");
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
    public boolean CI(String str) {
        return a(frH, frE, frF, frG, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzg() {
        if (this.mAudioRecord != null && this.file != null) {
            try {
                this.adb = true;
                byte[] bArr = new byte[this.bufferSize];
                this.mAudioRecord.startRecording();
                while (this.adb) {
                    this.mAudioRecord.read(bArr, 0, bArr.length);
                    this.frI.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.frI.seek(4L);
                this.frI.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.frI.seek(40L);
                this.frI.writeInt(Integer.reverseBytes(this.dataSize));
                this.frI.close();
                this.mAudioRecord.stop();
                this.mAudioRecord.release();
                this.adb = false;
            } catch (Throwable th) {
                if (this.file.exists()) {
                    this.file.delete();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean bzh() {
        Thread thread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.bzg();
            }
        });
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void bzi() {
        this.adb = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean bzj() {
        return this.adb;
    }

    private void writeHeader() {
        try {
            this.frI.setLength(0L);
            this.frI.writeBytes("RIFF");
            this.frI.writeInt(0);
            this.frI.writeBytes("WAVE");
            this.frI.writeBytes("fmt ");
            this.frI.writeInt(Integer.reverseBytes(16));
            this.frI.writeShort(Short.reverseBytes((short) 1));
            this.frI.writeShort(Short.reverseBytes(this.frL));
            this.frI.writeInt(Integer.reverseBytes(this.frJ));
            this.frI.writeInt(Integer.reverseBytes(((this.frJ * this.frL) * this.frM) / 8));
            this.frI.writeShort(Short.reverseBytes((short) ((this.frL * this.frM) / 8)));
            this.frI.writeShort(Short.reverseBytes(this.frM));
            this.frI.writeBytes("data");
            this.frI.writeInt(0);
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
