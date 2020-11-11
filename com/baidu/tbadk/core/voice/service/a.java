package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import com.baidu.searchbox.ui.CoolPraiseGuideLottieView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements d {
    public static int fbn = CoolPraiseGuideLottieView.ANIM_DURATION;
    public static int fbo = 2;
    public static int fbp = 2;
    public static int fbq = 1;
    private int channelConfiguration;
    private int dataSize;
    private RandomAccessFile fbr;
    private int fbs;
    private int fbt;
    private short fbu;
    private short fbv;
    private String filePath;
    private int bufferSize = 0;
    private boolean abm = false;
    private AudioRecord mAudioRecord = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.bufferSize = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.fbs = i2;
        this.channelConfiguration = i3;
        this.fbt = i4;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
        }
        this.mAudioRecord = new AudioRecord(i, this.fbs, this.channelConfiguration, this.fbt, this.bufferSize);
        this.fbu = (short) (this.channelConfiguration == 12 ? 2 : 1);
        this.fbv = (short) (this.fbt == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.fbr != null) {
                try {
                    this.fbr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.fbr = new RandomAccessFile(this.file, "rw");
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
    public boolean CE(String str) {
        return a(fbq, fbn, fbo, fbp, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btW() {
        if (this.mAudioRecord != null && this.file != null) {
            try {
                this.abm = true;
                byte[] bArr = new byte[this.bufferSize];
                this.mAudioRecord.startRecording();
                while (this.abm) {
                    this.mAudioRecord.read(bArr, 0, bArr.length);
                    this.fbr.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.fbr.seek(4L);
                this.fbr.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.fbr.seek(40L);
                this.fbr.writeInt(Integer.reverseBytes(this.dataSize));
                this.fbr.close();
                this.mAudioRecord.stop();
                this.mAudioRecord.release();
                this.abm = false;
            } catch (Throwable th) {
                if (this.file.exists()) {
                    this.file.delete();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean btX() {
        Thread thread = new Thread(new Runnable() { // from class: com.baidu.tbadk.core.voice.service.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.btW();
            }
        });
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public void btY() {
        this.abm = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public boolean btZ() {
        return this.abm;
    }

    private void writeHeader() {
        try {
            this.fbr.setLength(0L);
            this.fbr.writeBytes("RIFF");
            this.fbr.writeInt(0);
            this.fbr.writeBytes("WAVE");
            this.fbr.writeBytes("fmt ");
            this.fbr.writeInt(Integer.reverseBytes(16));
            this.fbr.writeShort(Short.reverseBytes((short) 1));
            this.fbr.writeShort(Short.reverseBytes(this.fbu));
            this.fbr.writeInt(Integer.reverseBytes(this.fbs));
            this.fbr.writeInt(Integer.reverseBytes(((this.fbs * this.fbu) * this.fbv) / 8));
            this.fbr.writeShort(Short.reverseBytes((short) ((this.fbu * this.fbv) / 8)));
            this.fbr.writeShort(Short.reverseBytes(this.fbv));
            this.fbr.writeBytes("data");
            this.fbr.writeInt(0);
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
