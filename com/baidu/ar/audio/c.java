package com.baidu.ar.audio;

import android.media.AudioRecord;
import java.nio.ByteBuffer;
import java.util.ArrayList;
/* loaded from: classes3.dex */
class c {
    private static final String TAG = c.class.getSimpleName();
    private static volatile boolean iC = false;
    private VolumeListener iA;
    private AudioRecord iu;
    private AudioParams iv;
    private a iz;
    private byte[] iw = null;
    private ArrayList<ByteBuffer> ix = null;
    private int iy = 0;
    private boolean iB = false;

    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void bM() {
        boolean z = true;
        if (this.iu.getState() == 1) {
            try {
                this.iu.startRecording();
                int recordingState = this.iu.getRecordingState();
                if (recordingState != 3) {
                    com.baidu.ar.f.b.b(TAG, "startAudioRecord state = " + recordingState);
                }
            } catch (IllegalStateException e) {
                com.baidu.ar.f.b.b(TAG, "startAudioRecord error!!!");
                e.printStackTrace();
            }
            iC = z;
            if (z) {
                com.baidu.ar.f.b.b(TAG, "startAudioRecord error!!! mAudioRecord.getState() = " + this.iu.getState());
                t(false);
                return;
            }
            return;
        }
        z = false;
        iC = z;
        if (z) {
        }
    }

    private void bN() {
        int i;
        if (this.iv.getFrameSize() <= 0) {
            return;
        }
        if (this.ix == null) {
            this.ix = new ArrayList<>();
            for (int i2 = 0; i2 < this.iv.getFrameBufferCount(); i2++) {
                this.ix.add(ByteBuffer.allocate(this.iv.getFrameSize()));
            }
        }
        this.iy = 0;
        if (this.iw == null) {
            this.iw = new byte[this.iv.getFrameSize()];
        }
        int i3 = 0;
        while (iC) {
            long nanoTime = System.nanoTime();
            int read = this.iu.read(this.iw, 0, this.iw.length);
            if (!this.iB || this.iv == null) {
                j(i3);
                i = i3 + 1;
            } else {
                ByteBuffer byteBuffer = this.ix.get(this.iy);
                if (read == -3) {
                    com.baidu.ar.f.b.b(TAG, "Audio read error");
                } else if (this.iz != null && byteBuffer != null && byteBuffer.capacity() >= read) {
                    if (this.iv.getAmplifyVolume() != 1.0f) {
                        d.a(this.iw, this.iv.getAmplifyVolume());
                    }
                    byteBuffer.clear();
                    byteBuffer.position(0);
                    byteBuffer.put(this.iw, 0, read);
                    byteBuffer.flip();
                    this.iz.onAudioFrameAvailable(byteBuffer, read, nanoTime);
                }
                this.iy++;
                this.iy %= this.iv.getFrameBufferCount();
                if (this.iA != null) {
                    this.iA.onRealtimeVolume((int) d.c(this.iw));
                }
                i = i3;
            }
            i3 = i;
        }
        this.ix = null;
        this.iw = null;
        try {
            this.iu.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.iz != null) {
            this.iz.onAudioStop(true);
        }
    }

    private void j(long j) {
        if (j >= 20) {
            t(false);
            this.iB = true;
        } else if (d.b(this.iw) != 0.0d) {
            t(true);
            this.iB = true;
        }
    }

    private void t(boolean z) {
        if (this.iz != null) {
            this.iz.onAudioStart(z);
        }
    }

    public void a(a aVar) {
        this.iz = aVar;
    }

    public void b(AudioParams audioParams) {
        int minBufferSize = AudioRecord.getMinBufferSize(audioParams.getSampleRate(), audioParams.getChannelConfig(), audioParams.getAudioFormat());
        if (audioParams.getFrameSize() < minBufferSize) {
            audioParams.setAudioBufferSize(((minBufferSize / 1024) + 1) * 1024 * 2);
        }
        this.iu = new AudioRecord(audioParams.getAudioSource(), audioParams.getSampleRate(), audioParams.getChannelConfig(), audioParams.getAudioFormat(), audioParams.getAudioBufferSize());
        this.iv = audioParams;
        this.iB = false;
        if (this.iz != null) {
            this.iz.onAudioSetup(true);
        }
    }

    public AudioParams bE() {
        return this.iv;
    }

    public void bJ() {
        bM();
        bN();
    }

    public void bK() {
        iC = false;
    }

    public void bL() {
        if (iC) {
            return;
        }
        this.iu.release();
        this.iu = null;
        if (this.iz != null) {
            this.iz.onAudioRelease();
        }
        this.iz = null;
        this.iA = null;
    }

    public void setVolumeListener(VolumeListener volumeListener) {
        this.iA = volumeListener;
    }
}
