package com.baidu.ar.audio;

import android.media.AudioRecord;
import java.nio.ByteBuffer;
import java.util.ArrayList;
/* loaded from: classes11.dex */
class c {
    private static final String TAG = c.class.getSimpleName();
    private static volatile boolean iA = false;
    private AudioRecord is;
    private AudioParams it;
    private a ix;
    private VolumeListener iy;
    private byte[] iu = null;
    private ArrayList<ByteBuffer> iv = null;
    private int iw = 0;
    private boolean iz = false;

    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void cs() {
        boolean z = true;
        if (this.is.getState() == 1) {
            try {
                this.is.startRecording();
                int recordingState = this.is.getRecordingState();
                if (recordingState != 3) {
                    com.baidu.ar.g.b.b(TAG, "startAudioRecord state = " + recordingState);
                }
            } catch (IllegalStateException e) {
                com.baidu.ar.g.b.b(TAG, "startAudioRecord error!!!");
                e.printStackTrace();
            }
            iA = z;
            if (z) {
                com.baidu.ar.g.b.b(TAG, "startAudioRecord error!!! mAudioRecord.getState() = " + this.is.getState());
                t(false);
                return;
            }
            return;
        }
        z = false;
        iA = z;
        if (z) {
        }
    }

    private void ct() {
        int i;
        if (this.it.getFrameSize() <= 0) {
            return;
        }
        if (this.iv == null) {
            this.iv = new ArrayList<>();
            for (int i2 = 0; i2 < this.it.getFrameBufferCount(); i2++) {
                this.iv.add(ByteBuffer.allocate(this.it.getFrameSize()));
            }
        }
        this.iw = 0;
        if (this.iu == null) {
            this.iu = new byte[this.it.getFrameSize()];
        }
        int i3 = 0;
        while (iA) {
            long nanoTime = System.nanoTime();
            int read = this.is.read(this.iu, 0, this.iu.length);
            if (!this.iz || this.it == null) {
                j(i3);
                i = i3 + 1;
            } else {
                ByteBuffer byteBuffer = this.iv.get(this.iw);
                if (read == -3) {
                    com.baidu.ar.g.b.b(TAG, "Audio read error");
                } else if (this.ix != null && byteBuffer != null && byteBuffer.capacity() >= read) {
                    if (this.it.getAmplifyVolume() != 1.0f) {
                        d.a(this.iu, this.it.getAmplifyVolume());
                    }
                    byteBuffer.clear();
                    byteBuffer.position(0);
                    byteBuffer.put(this.iu, 0, read);
                    byteBuffer.flip();
                    this.ix.onAudioFrameAvailable(byteBuffer, read, nanoTime);
                }
                this.iw++;
                this.iw %= this.it.getFrameBufferCount();
                if (this.iy != null) {
                    this.iy.onRealtimeVolume((int) d.c(this.iu));
                }
                i = i3;
            }
            i3 = i;
        }
        this.iv = null;
        this.iu = null;
        try {
            this.is.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.ix != null) {
            this.ix.onAudioStop(true);
        }
    }

    private void j(long j) {
        if (j >= 20) {
            t(false);
            this.iz = true;
        } else if (d.b(this.iu) != 0.0d) {
            t(true);
            this.iz = true;
        }
    }

    private void t(boolean z) {
        if (this.ix != null) {
            this.ix.onAudioStart(z);
        }
    }

    public void a(a aVar) {
        this.ix = aVar;
    }

    public void b(AudioParams audioParams) {
        int minBufferSize = AudioRecord.getMinBufferSize(audioParams.getSampleRate(), audioParams.getChannelConfig(), audioParams.getAudioFormat());
        if (audioParams.getFrameSize() < minBufferSize) {
            audioParams.setAudioBufferSize(((minBufferSize / 1024) + 1) * 1024 * 2);
        }
        this.is = new AudioRecord(audioParams.getAudioSource(), audioParams.getSampleRate(), audioParams.getChannelConfig(), audioParams.getAudioFormat(), audioParams.getAudioBufferSize());
        this.it = audioParams;
        this.iz = false;
        if (this.ix != null) {
            this.ix.onAudioSetup(true);
        }
    }

    public AudioParams ck() {
        return this.it;
    }

    public void cp() {
        cs();
        ct();
    }

    public void cq() {
        iA = false;
    }

    public void cr() {
        if (iA) {
            return;
        }
        this.is.release();
        this.is = null;
        if (this.ix != null) {
            this.ix.onAudioRelease();
        }
        this.ix = null;
        this.iy = null;
    }

    public void setVolumeListener(VolumeListener volumeListener) {
        this.iy = volumeListener;
    }
}
