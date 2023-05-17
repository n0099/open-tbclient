package com.baidu.ar.audio;

import android.media.AudioRecord;
import java.nio.ByteBuffer;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class c {
    public static final String TAG = "c";
    public static volatile boolean iP;
    public AudioRecord iH;
    public AudioParams iI;
    public a iM;
    public VolumeListener iN;
    public byte[] iJ = null;
    public ArrayList<ByteBuffer> iK = null;
    public int iL = 0;
    public boolean iO = false;

    private void a(long j, int i) {
        ByteBuffer byteBuffer = this.iK.get(this.iL);
        if (i == -3) {
            com.baidu.ar.h.b.b(TAG, "Audio read error");
        } else if (this.iM != null && byteBuffer != null && byteBuffer.capacity() >= i) {
            if (this.iI.getAmplifyVolume() != 1.0f) {
                d.a(this.iJ, this.iI.getAmplifyVolume());
            }
            try {
                byteBuffer.clear();
                byteBuffer.position(0);
                byteBuffer.put(this.iJ, 0, i);
                byteBuffer.flip();
                this.iM.onAudioFrameAvailable(byteBuffer, i, j);
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        int i2 = this.iL + 1;
        this.iL = i2;
        this.iL = i2 % this.iI.getFrameBufferCount();
        if (this.iN != null) {
            this.iN.onRealtimeVolume((int) d.c(this.iJ));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void cr() {
        int recordingState;
        boolean z = true;
        if (this.iH.getState() == 1) {
            try {
                this.iH.startRecording();
                recordingState = this.iH.getRecordingState();
            } catch (IllegalStateException e) {
                com.baidu.ar.h.b.b(TAG, "startAudioRecord error!!!");
                e.printStackTrace();
            }
            if (recordingState == 3) {
                iP = z;
                if (z) {
                    String str = TAG;
                    com.baidu.ar.h.b.b(str, "startAudioRecord error!!! mAudioRecord.getState() = " + this.iH.getState());
                    r(false);
                    return;
                }
                return;
            }
            String str2 = TAG;
            com.baidu.ar.h.b.b(str2, "startAudioRecord state = " + recordingState);
        }
        z = false;
        iP = z;
        if (z) {
        }
    }

    private void cs() {
        if (this.iI.getFrameSize() <= 0) {
            return;
        }
        if (this.iK == null) {
            this.iK = new ArrayList<>();
            for (int i = 0; i < this.iI.getFrameBufferCount(); i++) {
                this.iK.add(ByteBuffer.allocate(this.iI.getFrameSize()));
            }
        }
        this.iL = 0;
        if (this.iJ == null) {
            this.iJ = new byte[this.iI.getFrameSize()];
        }
        int i2 = 0;
        while (iP) {
            long nanoTime = System.nanoTime();
            AudioRecord audioRecord = this.iH;
            byte[] bArr = this.iJ;
            int read = audioRecord.read(bArr, 0, bArr.length);
            if (!this.iO || this.iI == null) {
                h(i2);
                i2++;
            } else {
                a(nanoTime, read);
            }
        }
        this.iK = null;
        this.iJ = null;
        try {
            this.iH.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
        a aVar = this.iM;
        if (aVar != null) {
            aVar.onAudioStop(true);
        }
    }

    private void h(long j) {
        if (j >= 20) {
            r(false);
        } else if (d.b(this.iJ) == 0.0d) {
            return;
        } else {
            r(true);
        }
        this.iO = true;
    }

    private void r(boolean z) {
        a aVar = this.iM;
        if (aVar != null) {
            aVar.onAudioStart(z);
        }
    }

    public void a(a aVar) {
        this.iM = aVar;
    }

    public void b(AudioParams audioParams) {
        int minBufferSize = AudioRecord.getMinBufferSize(audioParams.getSampleRate(), audioParams.getChannelConfig(), audioParams.getAudioFormat());
        if (audioParams.getFrameSize() < minBufferSize) {
            audioParams.setAudioBufferSize(((minBufferSize / 1024) + 1) * 1024 * 2);
        }
        this.iH = new AudioRecord(audioParams.getAudioSource(), audioParams.getSampleRate(), audioParams.getChannelConfig(), audioParams.getAudioFormat(), audioParams.getAudioBufferSize());
        this.iI = audioParams;
        this.iO = false;
        a aVar = this.iM;
        if (aVar != null) {
            aVar.onAudioSetup(true);
        }
    }

    public AudioParams cj() {
        return this.iI;
    }

    public void co() {
        cr();
        cs();
    }

    public void cp() {
        iP = false;
    }

    public void cq() {
        if (iP) {
            return;
        }
        this.iH.release();
        this.iH = null;
        a aVar = this.iM;
        if (aVar != null) {
            aVar.onAudioRelease();
        }
        this.iM = null;
        this.iN = null;
    }

    public void setVolumeListener(VolumeListener volumeListener) {
        this.iN = volumeListener;
    }
}
