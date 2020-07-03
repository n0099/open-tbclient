package com.baidu.ar.audio;

import android.media.AudioRecord;
import java.nio.ByteBuffer;
import java.util.ArrayList;
/* loaded from: classes3.dex */
class c {
    private static final String TAG = c.class.getSimpleName();
    private static volatile boolean iR = false;
    private AudioRecord iJ;
    private AudioParams iK;
    private a iO;
    private VolumeListener iP;
    private byte[] iL = null;
    private ArrayList<ByteBuffer> iM = null;
    private int iN = 0;
    private boolean iQ = false;

    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void ca() {
        boolean z = true;
        if (this.iJ.getState() == 1) {
            try {
                this.iJ.startRecording();
                int recordingState = this.iJ.getRecordingState();
                if (recordingState != 3) {
                    com.baidu.ar.f.b.b(TAG, "startAudioRecord state = " + recordingState);
                }
            } catch (IllegalStateException e) {
                com.baidu.ar.f.b.b(TAG, "startAudioRecord error!!!");
                e.printStackTrace();
            }
            iR = z;
            if (z) {
                com.baidu.ar.f.b.b(TAG, "startAudioRecord error!!! mAudioRecord.getState() = " + this.iJ.getState());
                s(false);
                return;
            }
            return;
        }
        z = false;
        iR = z;
        if (z) {
        }
    }

    private void cb() {
        int i;
        if (this.iK.getFrameSize() <= 0) {
            return;
        }
        if (this.iM == null) {
            this.iM = new ArrayList<>();
            for (int i2 = 0; i2 < this.iK.getFrameBufferCount(); i2++) {
                this.iM.add(ByteBuffer.allocate(this.iK.getFrameSize()));
            }
        }
        this.iN = 0;
        if (this.iL == null) {
            this.iL = new byte[this.iK.getFrameSize()];
        }
        int i3 = 0;
        while (iR) {
            long nanoTime = System.nanoTime();
            int read = this.iJ.read(this.iL, 0, this.iL.length);
            if (!this.iQ || this.iK == null) {
                j(i3);
                i = i3 + 1;
            } else {
                ByteBuffer byteBuffer = this.iM.get(this.iN);
                if (read == -3) {
                    com.baidu.ar.f.b.b(TAG, "Audio read error");
                } else if (this.iO != null && byteBuffer != null && byteBuffer.capacity() >= read) {
                    if (this.iK.getAmplifyVolume() != 1.0f) {
                        d.a(this.iL, this.iK.getAmplifyVolume());
                    }
                    byteBuffer.clear();
                    byteBuffer.position(0);
                    byteBuffer.put(this.iL, 0, read);
                    byteBuffer.flip();
                    this.iO.onAudioFrameAvailable(byteBuffer, read, nanoTime);
                }
                this.iN++;
                this.iN %= this.iK.getFrameBufferCount();
                if (this.iP != null) {
                    this.iP.onRealtimeVolume((int) d.c(this.iL));
                }
                i = i3;
            }
            i3 = i;
        }
        this.iM = null;
        this.iL = null;
        try {
            this.iJ.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.iO != null) {
            this.iO.onAudioStop(true);
        }
    }

    private void j(long j) {
        if (j >= 20) {
            s(false);
            this.iQ = true;
        } else if (d.b(this.iL) != 0.0d) {
            s(true);
            this.iQ = true;
        }
    }

    private void s(boolean z) {
        if (this.iO != null) {
            this.iO.onAudioStart(z);
        }
    }

    public void a(a aVar) {
        this.iO = aVar;
    }

    public void b(AudioParams audioParams) {
        int minBufferSize = AudioRecord.getMinBufferSize(audioParams.getSampleRate(), audioParams.getChannelConfig(), audioParams.getAudioFormat());
        if (audioParams.getFrameSize() < minBufferSize) {
            audioParams.setAudioBufferSize(((minBufferSize / 1024) + 1) * 1024 * 2);
        }
        this.iJ = new AudioRecord(audioParams.getAudioSource(), audioParams.getSampleRate(), audioParams.getChannelConfig(), audioParams.getAudioFormat(), audioParams.getAudioBufferSize());
        this.iK = audioParams;
        this.iQ = false;
        if (this.iO != null) {
            this.iO.onAudioSetup(true);
        }
    }

    public AudioParams bS() {
        return this.iK;
    }

    public void bX() {
        ca();
        cb();
    }

    public void bY() {
        iR = false;
    }

    public void bZ() {
        if (iR) {
            return;
        }
        this.iJ.release();
        this.iJ = null;
        if (this.iO != null) {
            this.iO.onAudioRelease();
        }
        this.iO = null;
        this.iP = null;
    }

    public void setVolumeListener(VolumeListener volumeListener) {
        this.iP = volumeListener;
    }
}
