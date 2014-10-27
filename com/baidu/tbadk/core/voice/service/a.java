package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import android.util.Log;
import com.baidu.channelrtc.medialivesender.LiveSenderControl;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a implements h {
    public static int IK = LiveSenderControl.LiveSenderSampleRate.SAMPLINGRATE_8;
    public static int IL = 2;
    public static int IM = 2;
    public static int IN = 1;
    private RandomAccessFile IQ;
    private int IR;
    private int IS;
    private short IT;
    private short IU;
    private int dataSize;
    private String filePath;
    private int frequency;
    private int IO = 0;
    private boolean mIsRecording = false;
    private AudioRecord IP = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.IO = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.frequency = i2;
        this.IR = i3;
        this.IS = i4;
        if (this.IP != null) {
            this.IP.release();
        }
        this.IP = new AudioRecord(i, this.frequency, this.IR, this.IS, this.IO);
        this.IT = (short) (this.IR == 12 ? 2 : 1);
        this.IU = (short) (this.IS == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.IQ != null) {
                try {
                    this.IQ.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.IQ = new RandomAccessFile(this.file, "rw");
                nO();
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

    @Override // com.baidu.tbadk.core.voice.service.h
    public boolean ch(String str) {
        return a(IN, IK, IL, IM, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nK() {
        if (this.IP != null && this.file != null) {
            try {
                this.mIsRecording = true;
                byte[] bArr = new byte[this.IO];
                this.IP.startRecording();
                while (this.mIsRecording) {
                    this.IP.read(bArr, 0, bArr.length);
                    this.IQ.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.IQ.seek(4L);
                this.IQ.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.IQ.seek(40L);
                this.IQ.writeInt(Integer.reverseBytes(this.dataSize));
                this.IQ.close();
                this.IP.stop();
                this.IP.release();
                this.mIsRecording = false;
            } catch (Throwable th) {
                Log.e("AudioRecord", "Recording Failed");
                if (this.file.exists()) {
                    this.file.delete();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public boolean nL() {
        Thread thread = new Thread(new b(this));
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void nM() {
        this.mIsRecording = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public boolean nN() {
        return this.mIsRecording;
    }

    private void nO() {
        try {
            this.IQ.setLength(0L);
            this.IQ.writeBytes("RIFF");
            this.IQ.writeInt(0);
            this.IQ.writeBytes("WAVE");
            this.IQ.writeBytes("fmt ");
            this.IQ.writeInt(Integer.reverseBytes(16));
            this.IQ.writeShort(Short.reverseBytes((short) 1));
            this.IQ.writeShort(Short.reverseBytes(this.IT));
            this.IQ.writeInt(Integer.reverseBytes(this.frequency));
            this.IQ.writeInt(Integer.reverseBytes(((this.frequency * this.IT) * this.IU) / 8));
            this.IQ.writeShort(Short.reverseBytes((short) ((this.IT * this.IU) / 8)));
            this.IQ.writeShort(Short.reverseBytes(this.IU));
            this.IQ.writeBytes("data");
            this.IQ.writeInt(0);
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
