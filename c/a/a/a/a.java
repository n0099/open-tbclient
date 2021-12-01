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
    public volatile boolean f1043b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f1044c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f1045d;

    /* renamed from: e  reason: collision with root package name */
    public Thread f1046e;

    /* renamed from: f  reason: collision with root package name */
    public volatile BlockingQueue<b> f1047f;

    /* renamed from: g  reason: collision with root package name */
    public volatile List<b.a.a.a.a> f1048g;

    /* renamed from: h  reason: collision with root package name */
    public volatile int f1049h;

    /* renamed from: i  reason: collision with root package name */
    public volatile float f1050i;

    /* renamed from: j  reason: collision with root package name */
    public volatile float f1051j;

    /* renamed from: k  reason: collision with root package name */
    public c.a.a.d.a f1052k;

    /* renamed from: c.a.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0005a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f1053e;

        public RunnableC0005a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1053e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f1053e.a();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public MediaCodec.BufferInfo a;

        /* renamed from: b  reason: collision with root package name */
        public ByteBuffer f1054b;

        public b(a aVar, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, byteBuffer, bufferInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bufferInfo;
            this.f1054b = byteBuffer;
        }
    }

    public a() {
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
        this.f1043b = true;
        this.f1044c = true;
        this.f1045d = false;
        this.f1046e = null;
        this.f1047f = null;
        this.f1048g = null;
        this.f1049h = 0;
        this.f1050i = 1.0f;
        this.f1051j = 1.0f;
    }

    public final void a() {
        byte[] bArr;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            while (this.f1045d) {
                try {
                    try {
                        b take = this.f1047f.take();
                        byte[] bArr2 = null;
                        if (take.f1054b == null) {
                            if (this.f1052k != null) {
                                this.f1052k.onFilteredFrameUpdate(null, take.a);
                                return;
                            }
                            return;
                        }
                        MediaCodec.BufferInfo bufferInfo = take.a;
                        int i3 = bufferInfo.size;
                        int i4 = Integer.MAX_VALUE;
                        for (int i5 = 0; i5 < this.f1049h; i5++) {
                            i4 = Math.min(this.f1048g.get(i5).f1002b, i4);
                        }
                        ByteBuffer byteBuffer = take.f1054b;
                        byte[] bArr3 = new byte[bufferInfo.size];
                        byteBuffer.get(bArr3);
                        int min = Math.min(i3, i4);
                        if (this.f1049h > 0) {
                            bArr = new byte[min];
                            if (min > 0) {
                                byte[][] bArr4 = (byte[][]) Array.newInstance(byte.class, this.f1049h, min);
                                for (int i6 = 0; i6 < this.f1049h; i6++) {
                                    this.f1048g.get(i6).b(bArr4[i6], min);
                                }
                                for (int i7 = 0; i7 < min - 1; i7 += 2) {
                                    for (int i8 = 0; i8 < this.f1049h; i8++) {
                                        int i9 = i7 + 1;
                                        short s = (short) (((short) (((bArr4[i8][i7] & 255) | ((bArr4[i8][i9] & 255) << 8)) / this.f1049h)) * this.f1051j);
                                        bArr[i7] = (byte) (bArr[i7] + ((byte) (s & 255)));
                                        bArr[i9] = (byte) (bArr[i9] + ((byte) ((s >> 8) & 255)));
                                    }
                                }
                            }
                            for (int i10 = 0; i10 < min - 1; i10 += 2) {
                                int i11 = i10 + 1;
                                short s2 = (short) ((bArr[i10] & 255) | ((bArr[i11] & 255) << 8));
                                int i12 = (int) (((short) ((bArr3[i10] & 255) | ((bArr3[i11] & 255) << 8))) * this.f1050i);
                                if (s2 < 0 && i12 < 0) {
                                    i2 = i12 + s2 + ((i12 * s2) / 32767);
                                } else {
                                    i2 = (i12 + s2) - ((i12 * s2) / 32768);
                                }
                                short s3 = (short) i2;
                                bArr3[i10] = (byte) (s3 & 255);
                                bArr3[i11] = (byte) ((s3 >> 8) & 255);
                            }
                        } else {
                            bArr = null;
                        }
                        if (this.f1043b) {
                            bArr2 = bArr3;
                        } else if (this.f1049h > 0) {
                            bArr2 = bArr;
                        }
                        if (bArr2 != null && bArr2.length > 0 && this.f1044c) {
                            this.a.write(bArr2, 0, min);
                        }
                        if (this.f1052k != null) {
                            bufferInfo.offset = 0;
                            this.f1052k.onFilteredFrameUpdate(bArr3, take.a);
                        }
                    } catch (InterruptedException unused) {
                        return;
                    }
                } catch (Exception e2) {
                    Log.getStackTraceString(e2);
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
            this.f1048g.add(new b.a.a.a.a(TbConfig.THREAD_GIF_MIN_USE_MEMORY));
            int i2 = this.f1049h;
            this.f1049h = i2 + 1;
            return i2;
        }
        return invokeV.intValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f1047f == null) {
            return;
        }
        this.f1047f.clear();
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            for (int i2 = 0; i2 < this.f1049h; i2++) {
                this.f1048g.get(i2).a();
            }
            if (this.f1048g != null) {
                this.f1048g.clear();
            }
            this.f1049h = 0;
        }
    }

    public void e(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, byteBuffer, bufferInfo) == null) && this.f1045d) {
            try {
                if (this.f1047f != null) {
                    this.f1047f.put(new b(this, byteBuffer, bufferInfo));
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
            if (this.f1049h == 0 || !this.f1045d || i3 == 0) {
                return;
            }
            byte[] bArr = new byte[bufferInfo.size];
            byteBuffer.get(bArr);
            this.f1048g.get(i2).c(bArr, i3);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f1045d = false;
            try {
                if (this.f1046e != null) {
                    this.f1046e.interrupt();
                    this.f1046e.join(1000L);
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
            this.f1047f = null;
            this.f1048g = null;
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
            this.f1043b = z;
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f1044c = z;
        }
    }

    public void k(c.a.a.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
            this.f1052k = aVar;
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
            this.f1047f = new ArrayBlockingQueue(256);
            this.f1048g = new ArrayList(3);
            int minBufferSize = AudioTrack.getMinBufferSize(44100, 12, 2);
            String str = "AudioTrack getMinBufferSize=" + minBufferSize + ";audioSessionId=" + i3;
            if (i3 >= 0) {
                this.a = new AudioTrack(i2, 44100, 12, 2, minBufferSize, 1, i3);
            } else {
                this.a = new AudioTrack(i2, 44100, 12, 2, minBufferSize, 1);
            }
            this.a.play();
            this.f1043b = z;
            this.f1045d = true;
            Thread thread = new Thread(new RunnableC0005a(this));
            this.f1046e = thread;
            thread.start();
        }
    }
}
