package b.a.a.a;

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

    /* renamed from: a  reason: collision with root package name */
    public AudioTrack f1056a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f1057b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f1058c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f1059d;

    /* renamed from: e  reason: collision with root package name */
    public Thread f1060e;

    /* renamed from: f  reason: collision with root package name */
    public volatile BlockingQueue<b> f1061f;

    /* renamed from: g  reason: collision with root package name */
    public volatile List<a.a.a.a.a> f1062g;

    /* renamed from: h  reason: collision with root package name */
    public volatile int f1063h;

    /* renamed from: i  reason: collision with root package name */
    public volatile float f1064i;
    public volatile float j;
    public b.a.a.d.a k;

    /* renamed from: b.a.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0005a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f1065e;

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
            this.f1065e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f1065e.a();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public MediaCodec.BufferInfo f1066a;

        /* renamed from: b  reason: collision with root package name */
        public ByteBuffer f1067b;

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
            this.f1066a = bufferInfo;
            this.f1067b = byteBuffer;
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
        this.f1057b = true;
        this.f1058c = true;
        this.f1059d = false;
        this.f1060e = null;
        this.f1061f = null;
        this.f1062g = null;
        this.f1063h = 0;
        this.f1064i = 1.0f;
        this.j = 1.0f;
    }

    public final void a() {
        byte[] bArr;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            while (this.f1059d) {
                try {
                    try {
                        b take = this.f1061f.take();
                        byte[] bArr2 = null;
                        if (take.f1067b == null) {
                            if (this.k != null) {
                                this.k.onFilteredFrameUpdate(null, take.f1066a);
                                return;
                            }
                            return;
                        }
                        MediaCodec.BufferInfo bufferInfo = take.f1066a;
                        int i3 = bufferInfo.size;
                        int i4 = Integer.MAX_VALUE;
                        for (int i5 = 0; i5 < this.f1063h; i5++) {
                            i4 = Math.min(this.f1062g.get(i5).f1007b, i4);
                        }
                        ByteBuffer byteBuffer = take.f1067b;
                        byte[] bArr3 = new byte[bufferInfo.size];
                        byteBuffer.get(bArr3);
                        int min = Math.min(i3, i4);
                        if (this.f1063h > 0) {
                            bArr = new byte[min];
                            if (min > 0) {
                                byte[][] bArr4 = (byte[][]) Array.newInstance(byte.class, this.f1063h, min);
                                for (int i6 = 0; i6 < this.f1063h; i6++) {
                                    this.f1062g.get(i6).b(bArr4[i6], min);
                                }
                                for (int i7 = 0; i7 < min - 1; i7 += 2) {
                                    for (int i8 = 0; i8 < this.f1063h; i8++) {
                                        int i9 = i7 + 1;
                                        short s = (short) (((short) (((bArr4[i8][i7] & 255) | ((bArr4[i8][i9] & 255) << 8)) / this.f1063h)) * this.j);
                                        bArr[i7] = (byte) (bArr[i7] + ((byte) (s & 255)));
                                        bArr[i9] = (byte) (bArr[i9] + ((byte) ((s >> 8) & 255)));
                                    }
                                }
                            }
                            for (int i10 = 0; i10 < min - 1; i10 += 2) {
                                int i11 = i10 + 1;
                                short s2 = (short) ((bArr[i10] & 255) | ((bArr[i11] & 255) << 8));
                                int i12 = (int) (((short) ((bArr3[i10] & 255) | ((bArr3[i11] & 255) << 8))) * this.f1064i);
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
                        if (this.f1057b) {
                            bArr2 = bArr3;
                        } else if (this.f1063h > 0) {
                            bArr2 = bArr;
                        }
                        if (bArr2 != null && bArr2.length > 0 && this.f1058c) {
                            this.f1056a.write(bArr2, 0, min);
                        }
                        if (this.k != null) {
                            bufferInfo.offset = 0;
                            this.k.onFilteredFrameUpdate(bArr3, take.f1066a);
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
            this.f1062g.add(new a.a.a.a.a(TbConfig.THREAD_GIF_MIN_USE_MEMORY));
            int i2 = this.f1063h;
            this.f1063h = i2 + 1;
            return i2;
        }
        return invokeV.intValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f1061f == null) {
            return;
        }
        this.f1061f.clear();
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            for (int i2 = 0; i2 < this.f1063h; i2++) {
                this.f1062g.get(i2).a();
            }
            if (this.f1062g != null) {
                this.f1062g.clear();
            }
            this.f1063h = 0;
        }
    }

    public void e(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, byteBuffer, bufferInfo) == null) && this.f1059d) {
            try {
                if (this.f1061f != null) {
                    this.f1061f.put(new b(this, byteBuffer, bufferInfo));
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
            if (this.f1063h == 0 || !this.f1059d || i3 == 0) {
                return;
            }
            byte[] bArr = new byte[bufferInfo.size];
            byteBuffer.get(bArr);
            this.f1062g.get(i2).c(bArr, i3);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f1059d = false;
            try {
                if (this.f1060e != null) {
                    this.f1060e.interrupt();
                    this.f1060e.join(1000L);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            AudioTrack audioTrack = this.f1056a;
            if (audioTrack != null) {
                audioTrack.release();
                this.f1056a = null;
            }
            h();
            this.f1061f = null;
            this.f1062g = null;
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
            this.f1057b = z;
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f1058c = z;
        }
    }

    public void k(b.a.a.d.a aVar) {
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

    public void m(boolean z, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            this.f1061f = new ArrayBlockingQueue(256);
            this.f1062g = new ArrayList(3);
            int minBufferSize = AudioTrack.getMinBufferSize(44100, 12, 2);
            String str = "AudioTrack getMinBufferSize=" + minBufferSize + ";audioSessionId=" + i3;
            if (i3 >= 0) {
                this.f1056a = new AudioTrack(i2, 44100, 12, 2, minBufferSize, 1, i3);
            } else {
                this.f1056a = new AudioTrack(i2, 44100, 12, 2, minBufferSize, 1);
            }
            this.f1056a.play();
            this.f1057b = z;
            this.f1059d = true;
            Thread thread = new Thread(new RunnableC0005a(this));
            this.f1060e = thread;
            thread.start();
        }
    }
}
