package c.a.a.a;

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
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AudioTrack a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f1013b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f1014c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f1015d;

    /* renamed from: e  reason: collision with root package name */
    public Thread f1016e;

    /* renamed from: f  reason: collision with root package name */
    public volatile BlockingQueue<b> f1017f;

    /* renamed from: g  reason: collision with root package name */
    public volatile List<b.a.a.a.a> f1018g;

    /* renamed from: h  reason: collision with root package name */
    public volatile int f1019h;
    public volatile float i;
    public volatile float j;
    public c.a.a.d.a k;

    /* renamed from: c.a.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0005a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public RunnableC0005a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public MediaCodec.BufferInfo a;

        /* renamed from: b  reason: collision with root package name */
        public ByteBuffer f1020b;

        public b(a aVar, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, byteBuffer, bufferInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bufferInfo;
            this.f1020b = byteBuffer;
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1013b = true;
        this.f1014c = true;
        this.f1015d = false;
        this.f1016e = null;
        this.f1017f = null;
        this.f1018g = null;
        this.f1019h = 0;
        this.i = 1.0f;
        this.j = 1.0f;
    }

    public final void a() {
        byte[] bArr;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            while (this.f1015d) {
                try {
                    try {
                        b take = this.f1017f.take();
                        byte[] bArr2 = null;
                        if (take.f1020b == null) {
                            if (this.k != null) {
                                this.k.onFilteredFrameUpdate(null, take.a);
                                return;
                            }
                            return;
                        }
                        MediaCodec.BufferInfo bufferInfo = take.a;
                        int i2 = bufferInfo.size;
                        int i3 = Integer.MAX_VALUE;
                        for (int i4 = 0; i4 < this.f1019h; i4++) {
                            i3 = Math.min(this.f1018g.get(i4).f978b, i3);
                        }
                        ByteBuffer byteBuffer = take.f1020b;
                        byte[] bArr3 = new byte[bufferInfo.size];
                        byteBuffer.get(bArr3);
                        int min = Math.min(i2, i3);
                        if (this.f1019h > 0) {
                            bArr = new byte[min];
                            if (min > 0) {
                                byte[][] bArr4 = (byte[][]) Array.newInstance(byte.class, this.f1019h, min);
                                for (int i5 = 0; i5 < this.f1019h; i5++) {
                                    this.f1018g.get(i5).b(bArr4[i5], min);
                                }
                                for (int i6 = 0; i6 < min - 1; i6 += 2) {
                                    for (int i7 = 0; i7 < this.f1019h; i7++) {
                                        int i8 = i6 + 1;
                                        short s = (short) (((short) (((bArr4[i7][i6] & 255) | ((bArr4[i7][i8] & 255) << 8)) / this.f1019h)) * this.j);
                                        bArr[i6] = (byte) (bArr[i6] + ((byte) (s & 255)));
                                        bArr[i8] = (byte) (bArr[i8] + ((byte) ((s >> 8) & 255)));
                                    }
                                }
                            }
                            for (int i9 = 0; i9 < min - 1; i9 += 2) {
                                int i10 = i9 + 1;
                                short s2 = (short) ((bArr[i9] & 255) | ((bArr[i10] & 255) << 8));
                                int i11 = (int) (((short) ((bArr3[i9] & 255) | ((bArr3[i10] & 255) << 8))) * this.i);
                                if (s2 < 0 && i11 < 0) {
                                    i = i11 + s2 + ((i11 * s2) / 32767);
                                } else {
                                    i = (i11 + s2) - ((i11 * s2) / 32768);
                                }
                                short s3 = (short) i;
                                bArr3[i9] = (byte) (s3 & 255);
                                bArr3[i10] = (byte) ((s3 >> 8) & 255);
                            }
                        } else {
                            bArr = null;
                        }
                        if (this.f1013b) {
                            bArr2 = bArr3;
                        } else if (this.f1019h > 0) {
                            bArr2 = bArr;
                        }
                        if (bArr2 != null && bArr2.length > 0 && this.f1014c) {
                            this.a.write(bArr2, 0, min);
                        }
                        if (this.k != null) {
                            bufferInfo.offset = 0;
                            this.k.onFilteredFrameUpdate(bArr3, take.a);
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
            this.f1018g.add(new b.a.a.a.a(TbConfig.THREAD_GIF_MIN_USE_MEMORY));
            int i = this.f1019h;
            this.f1019h = i + 1;
            return i;
        }
        return invokeV.intValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.f1017f != null) {
                this.f1017f.clear();
            }
            Log.d("AudioFilter", "clear master track over");
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            for (int i = 0; i < this.f1019h; i++) {
                this.f1018g.get(i).a();
            }
            if (this.f1018g != null) {
                this.f1018g.clear();
            }
            this.f1019h = 0;
        }
    }

    public void e(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, byteBuffer, bufferInfo) == null) && this.f1015d) {
            try {
                if (this.f1017f != null) {
                    this.f1017f.put(new b(this, byteBuffer, bufferInfo));
                }
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void f(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048581, this, byteBuffer, bufferInfo, i) == null) {
            int i2 = bufferInfo.size;
            if (this.f1019h == 0 || !this.f1015d || i2 == 0) {
                return;
            }
            byte[] bArr = new byte[bufferInfo.size];
            byteBuffer.get(bArr);
            this.f1018g.get(i).c(bArr, i2);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f1015d = false;
            try {
                if (this.f1016e != null) {
                    this.f1016e.interrupt();
                    this.f1016e.join(1000L);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            AudioTrack audioTrack = this.a;
            if (audioTrack != null) {
                audioTrack.release();
                this.a = null;
            }
            h();
            this.f1017f = null;
            this.f1018g = null;
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
            this.f1013b = z;
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f1014c = z;
        }
    }

    public void k(c.a.a.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
            this.k = aVar;
        }
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            m(z, 3, -1);
        }
    }

    public void m(boolean z, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)}) == null) {
            this.f1017f = new ArrayBlockingQueue(256);
            this.f1018g = new ArrayList(3);
            int minBufferSize = AudioTrack.getMinBufferSize(44100, 12, 2);
            Log.i("AudioFilter", "AudioTrack getMinBufferSize=" + minBufferSize + ";audioSessionId=" + i2);
            if (i2 >= 0) {
                this.a = new AudioTrack(i, 44100, 12, 2, minBufferSize, 1, i2);
            } else {
                this.a = new AudioTrack(i, 44100, 12, 2, minBufferSize, 1);
            }
            this.a.play();
            this.f1013b = z;
            this.f1015d = true;
            Thread thread = new Thread(new RunnableC0005a(this));
            this.f1016e = thread;
            thread.start();
        }
    }
}
