package com.baidu.ar.audio;

import android.media.AudioRecord;
import android.util.Log;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
class c {
    private static final String a = c.class.getSimpleName();
    private AudioRecord b;
    private a e;
    private byte[] c = null;
    private ByteBuffer d = null;
    private volatile boolean f = false;

    private void d() {
        boolean z = this.b.getState() == 1;
        if (z) {
            this.b.startRecording();
            this.f = true;
        }
        if (this.e != null) {
            this.e.a(z);
        }
    }

    private void e() {
        do {
            this.d.clear();
            long nanoTime = System.nanoTime();
            int read = this.b.read(this.c, 0, this.c.length);
            if (read == -3) {
                Log.e(a, "Audio read error");
            } else if (this.e != null && this.d.capacity() >= read) {
                long sampleRate = nanoTime - ((read / this.b.getSampleRate()) / 1000000000);
                this.d.position(0);
                this.d.put(this.c, 0, read);
                this.d.flip();
                this.e.a(this.d, read, sampleRate);
            }
        } while (this.f);
        try {
            this.b.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.e != null) {
            this.e.b(true);
        }
    }

    public void a() {
        d();
        e();
    }

    public void a(AudioParams audioParams) {
        int minBufferSize = AudioRecord.getMinBufferSize(audioParams.b(), audioParams.c(), audioParams.d());
        if (audioParams.e() < minBufferSize) {
            audioParams.a(((minBufferSize / 1024) + 1) * 1024 * 2);
        }
        this.b = new AudioRecord(audioParams.a(), audioParams.b(), audioParams.c(), audioParams.d(), audioParams.e());
        if (this.d == null) {
            this.d = ByteBuffer.allocate(audioParams.e());
        }
        if (this.c == null) {
            this.c = new byte[audioParams.e()];
        }
    }

    public void a(a aVar) {
        this.e = aVar;
    }

    public void b() {
        this.f = false;
    }

    public void c() {
        if (this.f) {
            return;
        }
        this.b.release();
        this.b = null;
        this.d.clear();
        this.d = null;
        this.c = null;
        this.e = null;
    }
}
