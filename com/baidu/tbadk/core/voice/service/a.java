package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements d {
    public static int bee = 8000;
    public static int bef = 2;
    public static int beg = 2;
    public static int beh = 1;
    private RandomAccessFile bej;
    private int bek;
    private short bel;
    private short bem;
    private int channelConfiguration;
    private int dataSize;
    private String filePath;
    private int frequency;
    private int bei = 0;
    private boolean axS = false;
    private AudioRecord mAudioRecord = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.bei = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.frequency = i2;
        this.channelConfiguration = i3;
        this.bek = i4;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
        }
        this.mAudioRecord = new AudioRecord(i, this.frequency, this.channelConfiguration, this.bek, this.bei);
        this.bel = (short) (this.channelConfiguration == 12 ? 2 : 1);
        this.bem = (short) (this.bek == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.bej != null) {
                try {
                    this.bej.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.bej = new RandomAccessFile(this.file, "rw");
                Ex();
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
    public boolean eQ(String str) {
        return a(beh, bee, bef, beg, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Eu() {
        if (this.mAudioRecord != null && this.file != null) {
            try {
                this.axS = true;
                byte[] bArr = new byte[this.bei];
                this.mAudioRecord.startRecording();
                while (this.axS) {
                    this.mAudioRecord.read(bArr, 0, bArr.length);
                    this.bej.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.bej.seek(4L);
                this.bej.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.bej.seek(40L);
                this.bej.writeInt(Integer.reverseBytes(this.dataSize));
                this.bej.close();
                this.mAudioRecord.stop();
                this.mAudioRecord.release();
                this.axS = false;
            } catch (Throwable th) {
                if (this.file.exists()) {
                    this.file.delete();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean Ev() {
        Thread thread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.Eu();
            }
        });
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void Ew() {
        this.axS = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean isRecording() {
        return this.axS;
    }

    private void Ex() {
        try {
            this.bej.setLength(0L);
            this.bej.writeBytes("RIFF");
            this.bej.writeInt(0);
            this.bej.writeBytes("WAVE");
            this.bej.writeBytes("fmt ");
            this.bej.writeInt(Integer.reverseBytes(16));
            this.bej.writeShort(Short.reverseBytes((short) 1));
            this.bej.writeShort(Short.reverseBytes(this.bel));
            this.bej.writeInt(Integer.reverseBytes(this.frequency));
            this.bej.writeInt(Integer.reverseBytes(((this.frequency * this.bel) * this.bem) / 8));
            this.bej.writeShort(Short.reverseBytes((short) ((this.bel * this.bem) / 8)));
            this.bej.writeShort(Short.reverseBytes(this.bem));
            this.bej.writeBytes("data");
            this.bej.writeInt(0);
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
