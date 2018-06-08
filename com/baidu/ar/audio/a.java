package com.baidu.ar.audio;

import android.media.AudioRecord;
import android.util.Log;
import java.nio.ByteBuffer;
import java.util.ArrayList;
/* loaded from: classes3.dex */
class a {
    private static final String a = a.class.getSimpleName();
    private static volatile boolean j = false;
    private AudioRecord b;
    private AudioParams c;
    private AudioCallback g;
    private VolumeListener h;
    private byte[] d = null;
    private ArrayList<ByteBuffer> e = null;
    private int f = 0;
    private boolean i = false;

    private void a(long j2) {
        if (j2 >= 20) {
            a(false);
            this.i = true;
        } else if (b.a(this.d) != 0.0d) {
            a(true);
            this.i = true;
        }
    }

    private void a(boolean z) {
        if (this.g != null) {
            this.g.onAudioStart(z);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void e() {
        boolean z = true;
        if (this.b.getState() == 1) {
            try {
                this.b.startRecording();
                int recordingState = this.b.getRecordingState();
                if (recordingState != 3) {
                    Log.e(a, "startAudioRecord state = " + recordingState);
                }
            } catch (IllegalStateException e) {
                Log.e(a, "startAudioRecord error!!!");
                e.printStackTrace();
            }
            j = z;
            if (z) {
                a(false);
                return;
            }
            return;
        }
        z = false;
        j = z;
        if (z) {
        }
    }

    private void f() {
        int i;
        if (this.c.getFrameSize() <= 0) {
            return;
        }
        if (this.e == null) {
            this.e = new ArrayList<>();
            for (int i2 = 0; i2 < this.c.getFrameBufferCount(); i2++) {
                this.e.add(ByteBuffer.allocate(this.c.getFrameSize()));
            }
        }
        this.f = 0;
        if (this.d == null) {
            this.d = new byte[this.c.getFrameSize()];
        }
        int i3 = 0;
        while (j) {
            long nanoTime = System.nanoTime();
            int read = this.b.read(this.d, 0, this.d.length);
            if (this.i) {
                ByteBuffer byteBuffer = this.e.get(this.f);
                if (read == -3) {
                    Log.e(a, "Audio read error");
                } else if (this.g != null && byteBuffer != null && byteBuffer.capacity() >= read) {
                    byteBuffer.clear();
                    byteBuffer.position(0);
                    byteBuffer.put(this.d, 0, read);
                    byteBuffer.flip();
                    this.g.onAudioFrameAvailable(byteBuffer, read, nanoTime);
                }
                this.f++;
                this.f %= this.c.getFrameBufferCount();
                if (this.h != null) {
                    this.h.onRealtimeVolume((int) b.b(this.d));
                }
                i = i3;
            } else {
                a(i3);
                i = i3 + 1;
            }
            i3 = i;
        }
        this.e = null;
        this.d = null;
        try {
            this.b.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.g != null) {
            this.g.onAudioStop(true);
        }
    }

    public void a() {
        e();
        f();
    }

    public void a(AudioCallback audioCallback) {
        this.g = audioCallback;
    }

    public void a(AudioParams audioParams) {
        int minBufferSize = AudioRecord.getMinBufferSize(audioParams.getSampleRate(), audioParams.getChannelConfig(), audioParams.getAudioFormat());
        if (audioParams.getFrameSize() < minBufferSize) {
            audioParams.setAudioBufferSize(((minBufferSize / 1024) + 1) * 1024 * 2);
        }
        this.b = new AudioRecord(audioParams.getAudioSource(), audioParams.getSampleRate(), audioParams.getChannelConfig(), audioParams.getAudioFormat(), audioParams.getAudioBufferSize());
        this.c = audioParams;
        this.i = false;
        if (this.g != null) {
            this.g.onAudioSetup(true);
        }
    }

    public void a(VolumeListener volumeListener) {
        this.h = volumeListener;
    }

    public void b() {
        j = false;
    }

    public void c() {
        if (j) {
            return;
        }
        this.b.release();
        this.b = null;
        if (this.g != null) {
            this.g.onAudioRelease();
        }
        this.g = null;
        this.h = null;
    }

    public AudioParams d() {
        return this.c;
    }
}
