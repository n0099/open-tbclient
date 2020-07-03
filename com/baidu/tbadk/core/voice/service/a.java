package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import com.baidu.searchbox.ui.CoolPraiseGuideLottieView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements d {
    public static int eip = CoolPraiseGuideLottieView.ANIM_DURATION;
    public static int eiq = 2;
    public static int eir = 2;
    public static int eis = 1;
    private int channelConfiguration;
    private int dataSize;
    private RandomAccessFile eit;
    private int eiu;
    private int eiv;
    private short eiw;
    private short eix;
    private String filePath;
    private int bufferSize = 0;
    private boolean ZZ = false;
    private AudioRecord mAudioRecord = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.eiu = i2;
        this.channelConfiguration = i3;
        this.eiv = i4;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
        }
        this.mAudioRecord = new AudioRecord(i, this.eiu, this.channelConfiguration, this.eiv, this.bufferSize);
        this.eiw = (short) (this.channelConfiguration == 12 ? 2 : 1);
        this.eix = (short) (this.eiv == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.eit != null) {
                try {
                    this.eit.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.eit = new RandomAccessFile(this.file, "rw");
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
    public boolean xu(String str) {
        return a(eis, eip, eiq, eir, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZw() {
        if (this.mAudioRecord != null && this.file != null) {
            try {
                this.ZZ = true;
                byte[] bArr = new byte[this.bufferSize];
                this.mAudioRecord.startRecording();
                while (this.ZZ) {
                    this.mAudioRecord.read(bArr, 0, bArr.length);
                    this.eit.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.eit.seek(4L);
                this.eit.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.eit.seek(40L);
                this.eit.writeInt(Integer.reverseBytes(this.dataSize));
                this.eit.close();
                this.mAudioRecord.stop();
                this.mAudioRecord.release();
                this.ZZ = false;
            } catch (Throwable th) {
                if (this.file.exists()) {
                    this.file.delete();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean aZx() {
        Thread thread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.aZw();
            }
        });
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void aZy() {
        this.ZZ = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean aZz() {
        return this.ZZ;
    }

    private void writeHeader() {
        try {
            this.eit.setLength(0L);
            this.eit.writeBytes("RIFF");
            this.eit.writeInt(0);
            this.eit.writeBytes("WAVE");
            this.eit.writeBytes("fmt ");
            this.eit.writeInt(Integer.reverseBytes(16));
            this.eit.writeShort(Short.reverseBytes((short) 1));
            this.eit.writeShort(Short.reverseBytes(this.eiw));
            this.eit.writeInt(Integer.reverseBytes(this.eiu));
            this.eit.writeInt(Integer.reverseBytes(((this.eiu * this.eiw) * this.eix) / 8));
            this.eit.writeShort(Short.reverseBytes((short) ((this.eiw * this.eix) / 8)));
            this.eit.writeShort(Short.reverseBytes(this.eix));
            this.eit.writeBytes("data");
            this.eit.writeInt(0);
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
