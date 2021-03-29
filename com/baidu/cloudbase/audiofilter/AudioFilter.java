package com.baidu.cloudbase.audiofilter;

import a.a.a.a.ac;
import a.a.a.a.bv;
import android.media.AudioTrack;
import android.media.MediaCodec;
import android.util.Log;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import com.baidu.tbadk.TbConfig;
import d.b.k.c.b;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
/* loaded from: classes.dex */
public class AudioFilter {

    /* renamed from: a  reason: collision with root package name */
    public AudioTrack f4616a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f4617b = true;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f4618c = true;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f4619d = false;

    /* renamed from: e  reason: collision with root package name */
    public Thread f4620e = null;

    /* renamed from: f  reason: collision with root package name */
    public volatile BlockingQueue<a> f4621f = null;

    /* renamed from: g  reason: collision with root package name */
    public volatile List<ac> f4622g = null;

    /* renamed from: h  reason: collision with root package name */
    public volatile int f4623h = 0;
    public volatile float i = 1.0f;
    public volatile float j = 1.0f;
    public b k;

    /* loaded from: classes.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public MediaCodec.BufferInfo f4624a;

        /* renamed from: b  reason: collision with root package name */
        public ByteBuffer f4625b;

        public a(AudioFilter audioFilter, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
            this.f4624a = bufferInfo;
            this.f4625b = byteBuffer;
        }
    }

    public final void a() {
        byte[] bArr;
        while (this.f4619d) {
            try {
                try {
                    a take = this.f4621f.take();
                    byte[] bArr2 = null;
                    if (take.f4625b == null) {
                        if (this.k != null) {
                            this.k.onFilteredFrameUpdate(null, take.f4624a);
                            return;
                        }
                        return;
                    }
                    MediaCodec.BufferInfo bufferInfo = take.f4624a;
                    int i = bufferInfo.size;
                    int i2 = Integer.MAX_VALUE;
                    for (int i3 = 0; i3 < this.f4623h; i3++) {
                        i2 = Math.min(this.f4622g.get(i3).f1000b, i2);
                    }
                    ByteBuffer byteBuffer = take.f4625b;
                    byte[] bArr3 = new byte[bufferInfo.size];
                    byteBuffer.get(bArr3);
                    int min = Math.min(i, i2);
                    if (this.f4623h > 0) {
                        bArr = new byte[min];
                        if (min > 0) {
                            byte[][] bArr4 = (byte[][]) Array.newInstance(byte.class, this.f4623h, min);
                            for (int i4 = 0; i4 < this.f4623h; i4++) {
                                this.f4622g.get(i4).a(bArr4[i4], min);
                            }
                            for (int i5 = 0; i5 < min - 1; i5 += 2) {
                                for (int i6 = 0; i6 < this.f4623h; i6++) {
                                    int i7 = i5 + 1;
                                    short s = (short) (((short) (((bArr4[i6][i5] & 255) | ((bArr4[i6][i7] & 255) << 8)) / this.f4623h)) * this.j);
                                    bArr[i5] = (byte) (bArr[i5] + ((byte) (s & 255)));
                                    bArr[i7] = (byte) (bArr[i7] + ((byte) ((s >> 8) & 255)));
                                }
                            }
                        }
                        for (int i8 = 0; i8 < min - 1; i8 += 2) {
                            int i9 = i8 + 1;
                            short s2 = (short) ((bArr[i8] & 255) | ((bArr[i9] & 255) << 8));
                            int i10 = (int) (((short) ((bArr3[i8] & 255) | ((bArr3[i9] & 255) << 8))) * this.i);
                            short s3 = (short) ((s2 >= 0 || i10 >= 0) ? (i10 + s2) - ((i10 * s2) / 32768) : i10 + s2 + ((i10 * s2) / 32767));
                            bArr3[i8] = (byte) (s3 & 255);
                            bArr3[i9] = (byte) ((s3 >> 8) & 255);
                        }
                    } else {
                        bArr = null;
                    }
                    if (this.f4617b) {
                        bArr2 = bArr3;
                    } else if (this.f4623h > 0) {
                        bArr2 = bArr;
                    }
                    if (bArr2 != null && bArr2.length > 0 && this.f4618c) {
                        this.f4616a.write(bArr2, 0, min);
                    }
                    if (this.k != null) {
                        bufferInfo.offset = 0;
                        this.k.onFilteredFrameUpdate(bArr3, take.f4624a);
                    }
                } catch (InterruptedException unused) {
                    Log.d("AudioFilter", "break from mixingLoop, because queue.take is interrupt");
                    return;
                }
            } catch (Exception e2) {
                Log.d("AudioFilter", Log.getStackTraceString(e2));
                e2.printStackTrace();
                return;
            }
        }
    }

    public int b() {
        this.f4622g.add(new ac(TbConfig.THREAD_GIF_MIN_USE_MEMORY));
        int i = this.f4623h;
        this.f4623h = i + 1;
        return i;
    }

    public void c() {
        if (this.f4621f != null) {
            this.f4621f.clear();
        }
        Log.d("AudioFilter", "clear master track over");
    }

    public void d() {
        for (int i = 0; i < this.f4623h; i++) {
            this.f4622g.get(i).a();
        }
        if (this.f4622g != null) {
            this.f4622g.clear();
        }
        this.f4623h = 0;
    }

    public void e(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (this.f4619d) {
            try {
                if (this.f4621f != null) {
                    this.f4621f.put(new a(this, byteBuffer, bufferInfo));
                }
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void f(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo, int i) {
        int i2 = bufferInfo.size;
        if (this.f4623h == 0 || !this.f4619d || i2 == 0) {
            return;
        }
        byte[] bArr = new byte[bufferInfo.size];
        byteBuffer.get(bArr);
        this.f4622g.get(i).b(bArr, i2);
    }

    public void g() {
        this.f4619d = false;
        try {
            if (this.f4620e != null) {
                this.f4620e.interrupt();
                this.f4620e.join(1000L);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        AudioTrack audioTrack = this.f4616a;
        if (audioTrack != null) {
            audioTrack.release();
            this.f4616a = null;
        }
        h();
        this.f4621f = null;
        this.f4622g = null;
    }

    public void h() {
        c();
        d();
    }

    public void i(boolean z) {
        this.f4617b = z;
    }

    public void j(boolean z) {
        this.f4618c = z;
    }

    public void k(b bVar) {
        this.k = bVar;
    }

    public void l(boolean z) {
        m(z, 3, -1);
    }

    public void m(boolean z, int i, int i2) {
        this.f4621f = new ArrayBlockingQueue(256);
        this.f4622g = new ArrayList(3);
        int minBufferSize = AudioTrack.getMinBufferSize(SwanAudioPlayer.DEFAULT_SAMPLE_RATE, 12, 2);
        Log.i("AudioFilter", "AudioTrack getMinBufferSize=" + minBufferSize + ";audioSessionId=" + i2);
        if (i2 >= 0) {
            this.f4616a = new AudioTrack(i, SwanAudioPlayer.DEFAULT_SAMPLE_RATE, 12, 2, minBufferSize, 1, i2);
        } else {
            this.f4616a = new AudioTrack(i, SwanAudioPlayer.DEFAULT_SAMPLE_RATE, 12, 2, minBufferSize, 1);
        }
        this.f4616a.play();
        this.f4617b = z;
        this.f4619d = true;
        Thread thread = new Thread(new bv(this));
        this.f4620e = thread;
        thread.start();
    }
}
