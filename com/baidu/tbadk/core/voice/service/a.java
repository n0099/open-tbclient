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
    public static int IL = LiveSenderControl.LiveSenderSampleRate.SAMPLINGRATE_8;
    public static int IM = 2;
    public static int IN = 2;
    public static int IO = 1;
    private RandomAccessFile IR;
    private int IS;
    private int IT;
    private short IU;
    private short IV;
    private int dataSize;
    private String filePath;
    private int frequency;
    private int IP = 0;
    private boolean mIsRecording = false;
    private AudioRecord IQ = null;
    private File file = null;

    public boolean a(int i, int i2, int i3, int i4, String str) {
        this.IP = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.frequency = i2;
        this.IS = i3;
        this.IT = i4;
        if (this.IQ != null) {
            this.IQ.release();
        }
        this.IQ = new AudioRecord(i, this.frequency, this.IS, this.IT, this.IP);
        this.IU = (short) (this.IS == 12 ? 2 : 1);
        this.IV = (short) (this.IT == 2 ? 16 : 8);
        this.file = new File(str);
        if (this.file.exists()) {
            this.file.delete();
        }
        try {
            this.file.createNewFile();
            if (this.IR != null) {
                try {
                    this.IR.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                this.IR = new RandomAccessFile(this.file, "rw");
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
        return a(IO, IL, IM, IN, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nK() {
        if (this.IQ != null && this.file != null) {
            try {
                this.mIsRecording = true;
                byte[] bArr = new byte[this.IP];
                this.IQ.startRecording();
                while (this.mIsRecording) {
                    this.IQ.read(bArr, 0, bArr.length);
                    this.IR.write(bArr);
                    this.dataSize += bArr.length;
                }
                this.IR.seek(4L);
                this.IR.writeInt(Integer.reverseBytes(this.dataSize + 36));
                this.IR.seek(40L);
                this.IR.writeInt(Integer.reverseBytes(this.dataSize));
                this.IR.close();
                this.IQ.stop();
                this.IQ.release();
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
            this.IR.setLength(0L);
            this.IR.writeBytes("RIFF");
            this.IR.writeInt(0);
            this.IR.writeBytes("WAVE");
            this.IR.writeBytes("fmt ");
            this.IR.writeInt(Integer.reverseBytes(16));
            this.IR.writeShort(Short.reverseBytes((short) 1));
            this.IR.writeShort(Short.reverseBytes(this.IU));
            this.IR.writeInt(Integer.reverseBytes(this.frequency));
            this.IR.writeInt(Integer.reverseBytes(((this.frequency * this.IU) * this.IV) / 8));
            this.IR.writeShort(Short.reverseBytes((short) ((this.IU * this.IV) / 8)));
            this.IR.writeShort(Short.reverseBytes(this.IV));
            this.IR.writeBytes("data");
            this.IR.writeInt(0);
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
