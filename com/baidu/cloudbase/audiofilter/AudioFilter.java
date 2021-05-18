package com.baidu.cloudbase.audiofilter;

import a.a.a.a.ac;
import a.a.a.a.bv;
import android.media.AudioTrack;
import android.media.MediaCodec;
import android.util.Log;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import com.baidu.tbadk.TbConfig;
import d.a.k.c.b;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
/* loaded from: classes.dex */
public class AudioFilter {

    /* renamed from: a  reason: collision with root package name */
    public AudioTrack f4613a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f4614b = true;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f4615c = true;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f4616d = false;

    /* renamed from: e  reason: collision with root package name */
    public Thread f4617e = null;

    /* renamed from: f  reason: collision with root package name */
    public volatile BlockingQueue<a> f4618f = null;

    /* renamed from: g  reason: collision with root package name */
    public volatile List<ac> f4619g = null;

    /* renamed from: h  reason: collision with root package name */
    public volatile int f4620h = 0;

    /* renamed from: i  reason: collision with root package name */
    public volatile float f4621i = 1.0f;
    public volatile float j = 1.0f;
    public b k;

    /* loaded from: classes.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public MediaCodec.BufferInfo f4622a;

        /* renamed from: b  reason: collision with root package name */
        public ByteBuffer f4623b;

        public a(AudioFilter audioFilter, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
            this.f4622a = bufferInfo;
            this.f4623b = byteBuffer;
        }
    }

    public final void a() {
        byte[] bArr;
        while (this.f4616d) {
            try {
                try {
                    a take = this.f4618f.take();
                    byte[] bArr2 = null;
                    if (take.f4623b == null) {
                        if (this.k != null) {
                            this.k.onFilteredFrameUpdate(null, take.f4622a);
                            return;
                        }
                        return;
                    }
                    MediaCodec.BufferInfo bufferInfo = take.f4622a;
                    int i2 = bufferInfo.size;
                    int i3 = Integer.MAX_VALUE;
                    for (int i4 = 0; i4 < this.f4620h; i4++) {
                        i3 = Math.min(this.f4619g.get(i4).f1000b, i3);
                    }
                    ByteBuffer byteBuffer = take.f4623b;
                    byte[] bArr3 = new byte[bufferInfo.size];
                    byteBuffer.get(bArr3);
                    int min = Math.min(i2, i3);
                    if (this.f4620h > 0) {
                        bArr = new byte[min];
                        if (min > 0) {
                            byte[][] bArr4 = (byte[][]) Array.newInstance(byte.class, this.f4620h, min);
                            for (int i5 = 0; i5 < this.f4620h; i5++) {
                                this.f4619g.get(i5).a(bArr4[i5], min);
                            }
                            for (int i6 = 0; i6 < min - 1; i6 += 2) {
                                for (int i7 = 0; i7 < this.f4620h; i7++) {
                                    int i8 = i6 + 1;
                                    short s = (short) (((short) (((bArr4[i7][i6] & 255) | ((bArr4[i7][i8] & 255) << 8)) / this.f4620h)) * this.j);
                                    bArr[i6] = (byte) (bArr[i6] + ((byte) (s & 255)));
                                    bArr[i8] = (byte) (bArr[i8] + ((byte) ((s >> 8) & 255)));
                                }
                            }
                        }
                        for (int i9 = 0; i9 < min - 1; i9 += 2) {
                            int i10 = i9 + 1;
                            short s2 = (short) ((bArr[i9] & 255) | ((bArr[i10] & 255) << 8));
                            int i11 = (int) (((short) ((bArr3[i9] & 255) | ((bArr3[i10] & 255) << 8))) * this.f4621i);
                            short s3 = (short) ((s2 >= 0 || i11 >= 0) ? (i11 + s2) - ((i11 * s2) / 32768) : i11 + s2 + ((i11 * s2) / 32767));
                            bArr3[i9] = (byte) (s3 & 255);
                            bArr3[i10] = (byte) ((s3 >> 8) & 255);
                        }
                    } else {
                        bArr = null;
                    }
                    if (this.f4614b) {
                        bArr2 = bArr3;
                    } else if (this.f4620h > 0) {
                        bArr2 = bArr;
                    }
                    if (bArr2 != null && bArr2.length > 0 && this.f4615c) {
                        this.f4613a.write(bArr2, 0, min);
                    }
                    if (this.k != null) {
                        bufferInfo.offset = 0;
                        this.k.onFilteredFrameUpdate(bArr3, take.f4622a);
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
        this.f4619g.add(new ac(TbConfig.THREAD_GIF_MIN_USE_MEMORY));
        int i2 = this.f4620h;
        this.f4620h = i2 + 1;
        return i2;
    }

    public void c() {
        if (this.f4618f != null) {
            this.f4618f.clear();
        }
        Log.d("AudioFilter", "clear master track over");
    }

    public void d() {
        for (int i2 = 0; i2 < this.f4620h; i2++) {
            this.f4619g.get(i2).a();
        }
        if (this.f4619g != null) {
            this.f4619g.clear();
        }
        this.f4620h = 0;
    }

    public void e(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (this.f4616d) {
            try {
                if (this.f4618f != null) {
                    this.f4618f.put(new a(this, byteBuffer, bufferInfo));
                }
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void f(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo, int i2) {
        int i3 = bufferInfo.size;
        if (this.f4620h == 0 || !this.f4616d || i3 == 0) {
            return;
        }
        byte[] bArr = new byte[bufferInfo.size];
        byteBuffer.get(bArr);
        this.f4619g.get(i2).b(bArr, i3);
    }

    public void g() {
        this.f4616d = false;
        try {
            if (this.f4617e != null) {
                this.f4617e.interrupt();
                this.f4617e.join(1000L);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        AudioTrack audioTrack = this.f4613a;
        if (audioTrack != null) {
            audioTrack.release();
            this.f4613a = null;
        }
        h();
        this.f4618f = null;
        this.f4619g = null;
    }

    public void h() {
        c();
        d();
    }

    public void i(boolean z) {
        this.f4614b = z;
    }

    public void j(boolean z) {
        this.f4615c = z;
    }

    public void k(b bVar) {
        this.k = bVar;
    }

    public void l(boolean z) {
        m(z, 3, -1);
    }

    public void m(boolean z, int i2, int i3) {
        this.f4618f = new ArrayBlockingQueue(256);
        this.f4619g = new ArrayList(3);
        int minBufferSize = AudioTrack.getMinBufferSize(SwanAudioPlayer.DEFAULT_SAMPLE_RATE, 12, 2);
        Log.i("AudioFilter", "AudioTrack getMinBufferSize=" + minBufferSize + ";audioSessionId=" + i3);
        if (i3 >= 0) {
            this.f4613a = new AudioTrack(i2, SwanAudioPlayer.DEFAULT_SAMPLE_RATE, 12, 2, minBufferSize, 1, i3);
        } else {
            this.f4613a = new AudioTrack(i2, SwanAudioPlayer.DEFAULT_SAMPLE_RATE, 12, 2, minBufferSize, 1);
        }
        this.f4613a.play();
        this.f4614b = z;
        this.f4616d = true;
        Thread thread = new Thread(new bv(this));
        this.f4617e = thread;
        thread.start();
    }
}
