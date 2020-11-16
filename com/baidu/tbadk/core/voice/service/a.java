package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import com.baidu.searchbox.ui.CoolPraiseGuideLottieView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements d {
    public static int fav = CoolPraiseGuideLottieView.ANIM_DURATION;
    public static int faw = 2;
    public static int fax = 2;
    public static int fay = 1;
    private int channelConfiguration;
    private int dataSize;
    private int faA;
    private int faB;
    private short faC;
    private short faD;
    private RandomAccessFile faz;
    private String filePath;
    private int bufferSize = 0;
    private boolean abr = false;
    private AudioRecord mAudioRecord = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.faA = i2;
        this.channelConfiguration = i3;
        this.faB = i4;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
        }
        this.mAudioRecord = new AudioRecord(i, this.faA, this.channelConfiguration, this.faB, this.bufferSize);
        this.faC = (short) (this.channelConfiguration == 12 ? 2 : 1);
        this.faD = (short) (this.faB == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.faz != null) {
                try {
                    this.faz.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.faz = new RandomAccessFile(this.file, "rw");
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
    public boolean Cd(String str) {
        return a(fay, fav, faw, fax, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btm() {
        if (this.mAudioRecord != null && this.file != null) {
            try {
                this.abr = true;
                byte[] bArr = new byte[this.bufferSize];
                this.mAudioRecord.startRecording();
                while (this.abr) {
                    this.mAudioRecord.read(bArr, 0, bArr.length);
                    this.faz.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.faz.seek(4L);
                this.faz.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.faz.seek(40L);
                this.faz.writeInt(Integer.reverseBytes(this.dataSize));
                this.faz.close();
                this.mAudioRecord.stop();
                this.mAudioRecord.release();
                this.abr = false;
            } catch (Throwable th) {
                if (this.file.exists()) {
                    this.file.delete();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean btn() {
        Thread thread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.btm();
            }
        });
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void bto() {
        this.abr = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean btp() {
        return this.abr;
    }

    private void writeHeader() {
        try {
            this.faz.setLength(0L);
            this.faz.writeBytes("RIFF");
            this.faz.writeInt(0);
            this.faz.writeBytes("WAVE");
            this.faz.writeBytes("fmt ");
            this.faz.writeInt(Integer.reverseBytes(16));
            this.faz.writeShort(Short.reverseBytes((short) 1));
            this.faz.writeShort(Short.reverseBytes(this.faC));
            this.faz.writeInt(Integer.reverseBytes(this.faA));
            this.faz.writeInt(Integer.reverseBytes(((this.faA * this.faC) * this.faD) / 8));
            this.faz.writeShort(Short.reverseBytes((short) ((this.faC * this.faD) / 8)));
            this.faz.writeShort(Short.reverseBytes(this.faD));
            this.faz.writeBytes("data");
            this.faz.writeInt(0);
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
