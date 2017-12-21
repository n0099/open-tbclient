package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements d {
    public static int apS = 8000;
    public static int apT = 2;
    public static int apU = 2;
    public static int apV = 1;
    private RandomAccessFile apX;
    private int apY;
    private short apZ;
    private short aqa;
    private int channelConfiguration;
    private int dataSize;
    private String filePath;
    private int frequency;
    private int apW = 0;
    private boolean IU = false;
    private AudioRecord mAudioRecord = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.apW = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.frequency = i2;
        this.channelConfiguration = i3;
        this.apY = i4;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
        }
        this.mAudioRecord = new AudioRecord(i, this.frequency, this.channelConfiguration, this.apY, this.apW);
        this.apZ = (short) (this.channelConfiguration == 12 ? 2 : 1);
        this.aqa = (short) (this.apY == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.apX != null) {
                try {
                    this.apX.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.apX = new RandomAccessFile(this.file, "rw");
                xf();
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
    public boolean eC(String str) {
        return a(apV, apS, apT, apU, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xc() {
        if (this.mAudioRecord != null && this.file != null) {
            try {
                this.IU = true;
                byte[] bArr = new byte[this.apW];
                this.mAudioRecord.startRecording();
                while (this.IU) {
                    this.mAudioRecord.read(bArr, 0, bArr.length);
                    this.apX.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.apX.seek(4L);
                this.apX.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.apX.seek(40L);
                this.apX.writeInt(Integer.reverseBytes(this.dataSize));
                this.apX.close();
                this.mAudioRecord.stop();
                this.mAudioRecord.release();
                this.IU = false;
            } catch (Throwable th) {
                if (this.file.exists()) {
                    this.file.delete();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean xd() {
        Thread thread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.xc();
            }
        });
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void xe() {
        this.IU = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean isRecording() {
        return this.IU;
    }

    private void xf() {
        try {
            this.apX.setLength(0L);
            this.apX.writeBytes("RIFF");
            this.apX.writeInt(0);
            this.apX.writeBytes("WAVE");
            this.apX.writeBytes("fmt ");
            this.apX.writeInt(Integer.reverseBytes(16));
            this.apX.writeShort(Short.reverseBytes((short) 1));
            this.apX.writeShort(Short.reverseBytes(this.apZ));
            this.apX.writeInt(Integer.reverseBytes(this.frequency));
            this.apX.writeInt(Integer.reverseBytes(((this.frequency * this.apZ) * this.aqa) / 8));
            this.apX.writeShort(Short.reverseBytes((short) ((this.apZ * this.aqa) / 8)));
            this.apX.writeShort(Short.reverseBytes(this.aqa));
            this.apX.writeBytes("data");
            this.apX.writeInt(0);
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
