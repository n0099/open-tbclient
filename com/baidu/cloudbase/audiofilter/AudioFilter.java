package com.baidu.cloudbase.audiofilter;

import a.a.a.a.ac;
import a.a.a.a.bv;
import android.media.AudioTrack;
import android.media.MediaCodec;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.m.c.b;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
/* loaded from: classes2.dex */
public class AudioFilter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public AudioTrack f4708a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f4709b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f4710c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f4711d;

    /* renamed from: e  reason: collision with root package name */
    public Thread f4712e;

    /* renamed from: f  reason: collision with root package name */
    public volatile BlockingQueue<a> f4713f;

    /* renamed from: g  reason: collision with root package name */
    public volatile List<ac> f4714g;

    /* renamed from: h  reason: collision with root package name */
    public volatile int f4715h;

    /* renamed from: i  reason: collision with root package name */
    public volatile float f4716i;
    public volatile float j;
    public b k;

    /* loaded from: classes2.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public MediaCodec.BufferInfo f4717a;

        /* renamed from: b  reason: collision with root package name */
        public ByteBuffer f4718b;

        public a(AudioFilter audioFilter, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {audioFilter, byteBuffer, bufferInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4717a = bufferInfo;
            this.f4718b = byteBuffer;
        }
    }

    public AudioFilter() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f4709b = true;
        this.f4710c = true;
        this.f4711d = false;
        this.f4712e = null;
        this.f4713f = null;
        this.f4714g = null;
        this.f4715h = 0;
        this.f4716i = 1.0f;
        this.j = 1.0f;
    }

    public final void a() {
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            while (this.f4711d) {
                try {
                    try {
                        a take = this.f4713f.take();
                        byte[] bArr2 = null;
                        if (take.f4718b == null) {
                            if (this.k != null) {
                                this.k.onFilteredFrameUpdate(null, take.f4717a);
                                return;
                            }
                            return;
                        }
                        MediaCodec.BufferInfo bufferInfo = take.f4717a;
                        int i2 = bufferInfo.size;
                        int i3 = Integer.MAX_VALUE;
                        for (int i4 = 0; i4 < this.f4715h; i4++) {
                            i3 = Math.min(this.f4714g.get(i4).f1004b, i3);
                        }
                        ByteBuffer byteBuffer = take.f4718b;
                        byte[] bArr3 = new byte[bufferInfo.size];
                        byteBuffer.get(bArr3);
                        int min = Math.min(i2, i3);
                        if (this.f4715h > 0) {
                            bArr = new byte[min];
                            if (min > 0) {
                                byte[][] bArr4 = (byte[][]) Array.newInstance(byte.class, this.f4715h, min);
                                for (int i5 = 0; i5 < this.f4715h; i5++) {
                                    this.f4714g.get(i5).a(bArr4[i5], min);
                                }
                                for (int i6 = 0; i6 < min - 1; i6 += 2) {
                                    for (int i7 = 0; i7 < this.f4715h; i7++) {
                                        int i8 = i6 + 1;
                                        short s = (short) (((short) (((bArr4[i7][i6] & 255) | ((bArr4[i7][i8] & 255) << 8)) / this.f4715h)) * this.j);
                                        bArr[i6] = (byte) (bArr[i6] + ((byte) (s & 255)));
                                        bArr[i8] = (byte) (bArr[i8] + ((byte) ((s >> 8) & 255)));
                                    }
                                }
                            }
                            for (int i9 = 0; i9 < min - 1; i9 += 2) {
                                int i10 = i9 + 1;
                                short s2 = (short) ((bArr[i9] & 255) | ((bArr[i10] & 255) << 8));
                                int i11 = (int) (((short) ((bArr3[i9] & 255) | ((bArr3[i10] & 255) << 8))) * this.f4716i);
                                short s3 = (short) ((s2 >= 0 || i11 >= 0) ? (i11 + s2) - ((i11 * s2) / 32768) : i11 + s2 + ((i11 * s2) / 32767));
                                bArr3[i9] = (byte) (s3 & 255);
                                bArr3[i10] = (byte) ((s3 >> 8) & 255);
                            }
                        } else {
                            bArr = null;
                        }
                        if (this.f4709b) {
                            bArr2 = bArr3;
                        } else if (this.f4715h > 0) {
                            bArr2 = bArr;
                        }
                        if (bArr2 != null && bArr2.length > 0 && this.f4710c) {
                            this.f4708a.write(bArr2, 0, min);
                        }
                        if (this.k != null) {
                            bufferInfo.offset = 0;
                            this.k.onFilteredFrameUpdate(bArr3, take.f4717a);
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
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            this.f4714g.add(new ac(TbConfig.THREAD_GIF_MIN_USE_MEMORY));
            int i2 = this.f4715h;
            this.f4715h = i2 + 1;
            return i2;
        }
        return invokeV.intValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.f4713f != null) {
                this.f4713f.clear();
            }
            Log.d("AudioFilter", "clear master track over");
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            for (int i2 = 0; i2 < this.f4715h; i2++) {
                this.f4714g.get(i2).a();
            }
            if (this.f4714g != null) {
                this.f4714g.clear();
            }
            this.f4715h = 0;
        }
    }

    public void e(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, byteBuffer, bufferInfo) == null) && this.f4711d) {
            try {
                if (this.f4713f != null) {
                    this.f4713f.put(new a(this, byteBuffer, bufferInfo));
                }
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void f(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048581, this, byteBuffer, bufferInfo, i2) == null) {
            int i3 = bufferInfo.size;
            if (this.f4715h == 0 || !this.f4711d || i3 == 0) {
                return;
            }
            byte[] bArr = new byte[bufferInfo.size];
            byteBuffer.get(bArr);
            this.f4714g.get(i2).b(bArr, i3);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f4711d = false;
            try {
                if (this.f4712e != null) {
                    this.f4712e.interrupt();
                    this.f4712e.join(1000L);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            AudioTrack audioTrack = this.f4708a;
            if (audioTrack != null) {
                audioTrack.release();
                this.f4708a = null;
            }
            h();
            this.f4713f = null;
            this.f4714g = null;
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c();
            d();
        }
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f4709b = z;
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f4710c = z;
        }
    }

    public void k(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
            this.k = bVar;
        }
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            m(z, 3, -1);
        }
    }

    public void m(boolean z, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            this.f4713f = new ArrayBlockingQueue(256);
            this.f4714g = new ArrayList(3);
            int minBufferSize = AudioTrack.getMinBufferSize(44100, 12, 2);
            Log.i("AudioFilter", "AudioTrack getMinBufferSize=" + minBufferSize + ";audioSessionId=" + i3);
            if (i3 >= 0) {
                this.f4708a = new AudioTrack(i2, 44100, 12, 2, minBufferSize, 1, i3);
            } else {
                this.f4708a = new AudioTrack(i2, 44100, 12, 2, minBufferSize, 1);
            }
            this.f4708a.play();
            this.f4709b = z;
            this.f4711d = true;
            Thread thread = new Thread(new bv(this));
            this.f4712e = thread;
            thread.start();
        }
    }
}
