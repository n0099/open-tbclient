package com.baidu.fsg.face.liveness.video;

import android.media.MediaMuxer;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.base.utils.LogUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.Thread;
import java.util.LinkedList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes5.dex */
public class g extends Thread implements Thread.UncaughtExceptionHandler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public LinkedBlockingQueue<a> f40337a;

    /* renamed from: b  reason: collision with root package name */
    public f f40338b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f40339c;

    /* renamed from: d  reason: collision with root package name */
    public int f40340d;

    /* renamed from: e  reason: collision with root package name */
    public int f40341e;

    /* renamed from: f  reason: collision with root package name */
    public LinkedList<byte[]> f40342f;

    /* renamed from: g  reason: collision with root package name */
    public d f40343g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f40344h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f40345i;

    /* renamed from: j  reason: collision with root package name */
    public int f40346j;
    public int k;
    public byte[] l;
    public long m;
    public int n;
    public long o;
    public long p;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f40347a;

        /* renamed from: b  reason: collision with root package name */
        public byte[] f40348b;

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
                }
            }
        }
    }

    public g(int i2, int i3, int i4, int i5, int i6, String str, MediaMuxer mediaMuxer, CountDownLatch countDownLatch) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), str, mediaMuxer, countDownLatch};
            interceptable.invokeUnInit(65536, newInitContext);
            int i7 = newInitContext.flag;
            if ((i7 & 1) != 0) {
                int i8 = i7 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f40339c = false;
        this.f40342f = new LinkedList<>();
        this.p = -1L;
        this.n = 0;
        this.f40346j = i2;
        this.k = i3;
        setPriority(10);
        setName("VideoMediaEncoderThread");
        this.f40337a = new LinkedBlockingQueue<>();
        this.f40341e = i5;
        a(i2, i3, i4, i5, i6, str, mediaMuxer);
    }

    public void a(int i2, int i3, int i4, int i5, int i6, String str, MediaMuxer mediaMuxer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), str, mediaMuxer}) == null) {
            this.f40338b = new f(i2, i3, i4, i5, i6, mediaMuxer);
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f40344h : invokeV.booleanValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            a aVar = new a();
            aVar.f40348b = null;
            aVar.f40347a = 0L;
            this.f40337a.add(aVar);
            this.f40339c = true;
            this.l = null;
            this.m = 0L;
        }
    }

    @Deprecated
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            a aVar = new a();
            aVar.f40348b = null;
            aVar.f40347a = 0L;
            this.f40337a.clear();
            this.f40337a.add(aVar);
            this.f40339c = true;
        }
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f40340d + 1 : invokeV.intValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            LinkedBlockingQueue<a> linkedBlockingQueue = this.f40337a;
            if (linkedBlockingQueue == null) {
                return 0;
            }
            return linkedBlockingQueue.size();
        }
        return invokeV.intValue;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        a take;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048586, this) != null) {
            return;
        }
        if (!this.f40345i) {
            Thread.currentThread().setUncaughtExceptionHandler(this);
            this.f40345i = true;
            LogUtil.i("+initInThread");
            this.f40338b.a();
            LogUtil.i("-initInThread");
        }
        while (true) {
            try {
                LogUtil.i("+mQueue.take");
                take = this.f40337a.take();
                LogUtil.i("-mQueue.take");
            } catch (InterruptedException e2) {
                e2.printStackTrace();
                LogUtil.e(e2.toString());
            }
            if (take.f40348b == null) {
                this.f40342f.clear();
                this.f40337a.clear();
                this.f40338b.b();
                this.f40344h = true;
                return;
            }
            LogUtil.i("+encodeFrame");
            long currentTimeMillis = System.currentTimeMillis();
            this.f40338b.a(take.f40348b, take.f40347a);
            long currentTimeMillis2 = System.currentTimeMillis();
            LogUtil.i("-encodeFrame");
            synchronized (this.f40342f) {
                this.f40342f.add(take.f40348b);
            }
            this.f40340d++;
            LogUtil.i("mRecorder.encodeFrame:" + (currentTimeMillis2 - currentTimeMillis) + "ms");
            if (this.p < 0) {
                this.p = take.f40347a / 1000;
            }
            this.o = (take.f40347a / 1000) - this.p;
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, thread, th) == null) {
            a(th);
        }
    }

    public void a(byte[] bArr, long j2) {
        byte[] bArr2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(1048580, this, bArr, j2) == null) || this.f40339c || this.f40337a == null) {
            return;
        }
        if (this.f40342f.size() > 0) {
            synchronized (this.f40342f) {
                bArr2 = this.f40342f.pop();
            }
            if (bArr.length != bArr2.length) {
                try {
                    bArr2 = new byte[bArr.length];
                } catch (OutOfMemoryError e2) {
                    LogUtil.e(e2.toString());
                    e2.printStackTrace();
                    return;
                }
            }
        } else {
            try {
                bArr2 = new byte[bArr.length];
            } catch (OutOfMemoryError e3) {
                LogUtil.e(e3.toString());
                e3.printStackTrace();
                return;
            }
        }
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        a aVar = new a();
        this.l = bArr2;
        this.m = j2;
        aVar.f40348b = bArr2;
        aVar.f40347a = j2;
        if (this.f40337a.size() < 50) {
            this.f40337a.add(aVar);
        }
    }

    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.o : invokeV.longValue;
    }

    public void a(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
            this.f40343g = dVar;
        }
    }

    public void a(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, th) == null) {
            d dVar = this.f40343g;
            if (dVar != null) {
                dVar.a(th);
            }
            th.printStackTrace();
            LogUtil.e(th.toString());
            f fVar = this.f40338b;
            if (fVar != null) {
                fVar.b();
            }
        }
    }
}
