package com.baidu.cloudbase.a;

import android.media.AudioTrack;
import android.media.MediaCodec;
import android.util.Log;
import com.baidu.tbadk.TbConfig;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
/* loaded from: classes10.dex */
public class a {
    public AudioTrack anB;
    public com.baidu.cloudbase.c.a anE;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f1686b = true;
    public volatile boolean c = true;
    public volatile boolean d = false;
    public Thread anC = null;
    public volatile BlockingQueue<b> anD = null;
    public volatile List<a.a.a.a.a> g = null;
    public volatile int h = 0;
    public volatile float i = 1.0f;
    public volatile float j = 1.0f;

    /* renamed from: com.baidu.cloudbase.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class RunnableC0095a implements Runnable {
        public RunnableC0095a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class b {
        public MediaCodec.BufferInfo anF;

        /* renamed from: b  reason: collision with root package name */
        public ByteBuffer f1687b;

        public b(a aVar, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
            this.anF = bufferInfo;
            this.f1687b = byteBuffer;
        }
    }

    public final void a() {
        byte[] bArr;
        int i;
        while (this.d) {
            try {
                try {
                    b take = this.anD.take();
                    if (take.f1687b == null) {
                        if (this.anE != null) {
                            this.anE.onFilteredFrameUpdate(null, take.anF);
                            return;
                        }
                        return;
                    }
                    MediaCodec.BufferInfo bufferInfo = take.anF;
                    int i2 = bufferInfo.size;
                    int i3 = Integer.MAX_VALUE;
                    int i4 = 0;
                    while (i4 < this.h) {
                        i4++;
                        i3 = Math.min(this.g.get(i4).f1031b, i3);
                    }
                    ByteBuffer byteBuffer = take.f1687b;
                    byte[] bArr2 = new byte[bufferInfo.size];
                    byteBuffer.get(bArr2);
                    int min = Math.min(i2, i3);
                    if (this.h > 0) {
                        byte[] bArr3 = new byte[min];
                        if (min > 0) {
                            byte[][] bArr4 = (byte[][]) Array.newInstance(Byte.TYPE, this.h, min);
                            for (int i5 = 0; i5 < this.h; i5++) {
                                this.g.get(i5).a(bArr4[i5], min);
                            }
                            for (int i6 = 0; i6 < min - 1; i6 += 2) {
                                for (int i7 = 0; i7 < this.h; i7++) {
                                    int i8 = i6 + 1;
                                    short s = (short) (((short) (((bArr4[i7][i6] & 255) | ((bArr4[i7][i8] & 255) << 8)) / this.h)) * this.j);
                                    bArr3[i6] = (byte) (bArr3[i6] + ((byte) (s & 255)));
                                    bArr3[i8] = (byte) (((byte) ((s >> 8) & 255)) + bArr3[i8]);
                                }
                            }
                        }
                        for (int i9 = 0; i9 < min - 1; i9 += 2) {
                            int i10 = i9 + 1;
                            short s2 = (short) ((bArr3[i9] & 255) | ((bArr3[i10] & 255) << 8));
                            int i11 = (int) (((short) ((bArr2[i9] & 255) | ((bArr2[i10] & 255) << 8))) * this.i);
                            if (s2 >= 0 || i11 >= 0) {
                                i = (i11 + s2) - ((i11 * s2) / 32768);
                            } else {
                                i = ((i11 * s2) / 32767) + i11 + s2;
                            }
                            short s3 = (short) i;
                            bArr2[i9] = (byte) (s3 & 255);
                            bArr2[i10] = (byte) ((s3 >> 8) & 255);
                        }
                        bArr = bArr3;
                    } else {
                        bArr = null;
                    }
                    if (this.f1686b) {
                        bArr = bArr2;
                    } else if (this.h <= 0) {
                        bArr = null;
                    }
                    if (bArr != null && bArr.length > 0 && this.c) {
                        this.anB.write(bArr, 0, min);
                    }
                    if (this.anE != null) {
                        bufferInfo.offset = 0;
                        this.anE.onFilteredFrameUpdate(bArr2, take.anF);
                    }
                } catch (InterruptedException e) {
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

    public void a(com.baidu.cloudbase.c.a aVar) {
        this.anE = aVar;
    }

    public void a(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (this.d) {
            try {
                if (this.anD != null) {
                    this.anD.put(new b(this, byteBuffer, bufferInfo));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void a(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo, int i) {
        int i2 = bufferInfo.size;
        if (this.h == 0 || !this.d || i2 == 0) {
            return;
        }
        byte[] bArr = new byte[bufferInfo.size];
        byteBuffer.get(bArr);
        this.g.get(i).d(bArr, i2);
    }

    public void a(boolean z, int i, int i2) {
        this.anD = new ArrayBlockingQueue(256);
        this.g = new ArrayList(3);
        int minBufferSize = AudioTrack.getMinBufferSize(44100, 12, 2);
        Log.i("AudioFilter", "AudioTrack getMinBufferSize=" + minBufferSize + ";audioSessionId=" + i2);
        if (i2 >= 0) {
            this.anB = new AudioTrack(i, 44100, 12, 2, minBufferSize, 1, i2);
        } else {
            this.anB = new AudioTrack(i, 44100, 12, 2, minBufferSize, 1);
        }
        this.anB.play();
        this.f1686b = z;
        this.d = true;
        this.anC = new Thread(new RunnableC0095a());
        this.anC.start();
    }

    public void aO(boolean z) {
        this.f1686b = z;
    }

    public void aP(boolean z) {
        this.c = z;
    }

    public void aQ(boolean z) {
        a(z, 3, -1);
    }

    public void release() {
        this.d = false;
        try {
            if (this.anC != null) {
                this.anC.interrupt();
                this.anC.join(1000L);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        AudioTrack audioTrack = this.anB;
        if (audioTrack != null) {
            audioTrack.release();
            this.anB = null;
        }
        tV();
        this.anD = null;
        this.g = null;
    }

    public int tS() {
        this.g.add(new a.a.a.a.a(TbConfig.THREAD_GIF_MIN_USE_MEMORY));
        int i = this.h;
        this.h = i + 1;
        return i;
    }

    public void tT() {
        if (this.anD != null) {
            this.anD.clear();
        }
        Log.d("AudioFilter", "clear master track over");
    }

    public void tU() {
        for (int i = 0; i < this.h; i++) {
            this.g.get(i).a();
        }
        if (this.g != null) {
            this.g.clear();
        }
        this.h = 0;
    }

    public void tV() {
        tT();
        tU();
    }
}
