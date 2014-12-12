package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import android.util.Log;
import com.baidu.channelrtc.medialivesender.LiveSenderControl;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements j {
    public static int NM = LiveSenderControl.LiveSenderSampleRate.SAMPLINGRATE_8;
    public static int NN = 2;
    public static int NO = 2;
    public static int NP = 1;
    private RandomAccessFile NS;
    private int NT;
    private int NU;
    private short NV;
    private short NW;
    private int dataSize;
    private String filePath;
    private int frequency;
    private int NQ = 0;
    private boolean mIsRecording = false;
    private AudioRecord NR = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.NQ = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.frequency = i2;
        this.NT = i3;
        this.NU = i4;
        if (this.NR != null) {
            this.NR.release();
        }
        this.NR = new AudioRecord(i, this.frequency, this.NT, this.NU, this.NQ);
        this.NV = (short) (this.NT == 12 ? 2 : 1);
        this.NW = (short) (this.NU == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.NS != null) {
                try {
                    this.NS.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.NS = new RandomAccessFile(this.file, "rw");
                qP();
                setFilePath(this.file.getParent());
                return true;
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
                return false;
            }
        } catch (IOException e3) {
            this.file = null;
            Log.e("create file error in audio record", e3.getMessage());
            return false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.j
    public boolean cZ(String str) {
        return a(NP, NM, NN, NO, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qL() {
        if (this.NR != null && this.file != null) {
            try {
                this.mIsRecording = true;
                byte[] bArr = new byte[this.NQ];
                this.NR.startRecording();
                while (this.mIsRecording) {
                    this.NR.read(bArr, 0, bArr.length);
                    this.NS.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.NS.seek(4L);
                this.NS.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.NS.seek(40L);
                this.NS.writeInt(Integer.reverseBytes(this.dataSize));
                this.NS.close();
                this.NR.stop();
                this.NR.release();
                this.mIsRecording = false;
            } catch (Throwable th) {
                Log.e("AudioRecord", "Recording Failed");
                if (this.file.exists()) {
                    this.file.delete();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.j
    public boolean qM() {
        Thread thread = new Thread(new b(this));
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.j
    public void qN() {
        this.mIsRecording = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.j
    public boolean qO() {
        return this.mIsRecording;
    }

    private void qP() {
        try {
            this.NS.setLength(0L);
            this.NS.writeBytes("RIFF");
            this.NS.writeInt(0);
            this.NS.writeBytes("WAVE");
            this.NS.writeBytes("fmt ");
            this.NS.writeInt(Integer.reverseBytes(16));
            this.NS.writeShort(Short.reverseBytes((short) 1));
            this.NS.writeShort(Short.reverseBytes(this.NV));
            this.NS.writeInt(Integer.reverseBytes(this.frequency));
            this.NS.writeInt(Integer.reverseBytes(((this.frequency * this.NV) * this.NW) / 8));
            this.NS.writeShort(Short.reverseBytes((short) ((this.NV * this.NW) / 8)));
            this.NS.writeShort(Short.reverseBytes(this.NW));
            this.NS.writeBytes("data");
            this.NS.writeInt(0);
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
