package com.baidu.ar.audio;

import android.media.AudioRecord;
import java.nio.ByteBuffer;
import java.util.ArrayList;
/* loaded from: classes6.dex */
class c {
    private static final String TAG = c.class.getSimpleName();
    private static volatile boolean iP = false;
    private AudioRecord iH;
    private AudioParams iI;
    private a iM;
    private VolumeListener iN;
    private byte[] iJ = null;
    private ArrayList<ByteBuffer> iK = null;
    private int iL = 0;
    private boolean iO = false;

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
        this.iL++;
        this.iL %= this.iI.getFrameBufferCount();
        if (this.iN != null) {
            this.iN.onRealtimeVolume((int) d.c(this.iJ));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void cr() {
        boolean z = true;
        if (this.iH.getState() == 1) {
            try {
                this.iH.startRecording();
                int recordingState = this.iH.getRecordingState();
                if (recordingState != 3) {
                    com.baidu.ar.h.b.b(TAG, "startAudioRecord state = " + recordingState);
                }
            } catch (IllegalStateException e) {
                com.baidu.ar.h.b.b(TAG, "startAudioRecord error!!!");
                e.printStackTrace();
            }
            iP = z;
            if (z) {
                com.baidu.ar.h.b.b(TAG, "startAudioRecord error!!! mAudioRecord.getState() = " + this.iH.getState());
                r(false);
                return;
            }
            return;
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
            int read = this.iH.read(this.iJ, 0, this.iJ.length);
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
        if (this.iM != null) {
            this.iM.onAudioStop(true);
        }
    }

    private void h(long j) {
        if (j >= 20) {
            r(false);
            this.iO = true;
        } else if (d.b(this.iJ) != 0.0d) {
            r(true);
            this.iO = true;
        }
    }

    private void r(boolean z) {
        if (this.iM != null) {
            this.iM.onAudioStart(z);
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
        if (this.iM != null) {
            this.iM.onAudioSetup(true);
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
        if (this.iM != null) {
            this.iM.onAudioRelease();
        }
        this.iM = null;
        this.iN = null;
    }

    public void setVolumeListener(VolumeListener volumeListener) {
        this.iN = volumeListener;
    }
}
