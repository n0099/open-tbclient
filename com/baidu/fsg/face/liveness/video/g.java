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
    public LinkedBlockingQueue<a> f40333a;

    /* renamed from: b  reason: collision with root package name */
    public f f40334b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f40335c;

    /* renamed from: d  reason: collision with root package name */
    public int f40336d;

    /* renamed from: e  reason: collision with root package name */
    public int f40337e;

    /* renamed from: f  reason: collision with root package name */
    public LinkedList<byte[]> f40338f;

    /* renamed from: g  reason: collision with root package name */
    public d f40339g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f40340h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f40341i;

    /* renamed from: j  reason: collision with root package name */
    public int f40342j;
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
        public long f40343a;

        /* renamed from: b  reason: collision with root package name */
        public byte[] f40344b;

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
        this.f40335c = false;
        this.f40338f = new LinkedList<>();
        this.p = -1L;
        this.n = 0;
        this.f40342j = i2;
        this.k = i3;
        setPriority(10);
        setName("VideoMediaEncoderThread");
        this.f40333a = new LinkedBlockingQueue<>();
        this.f40337e = i5;
        a(i2, i3, i4, i5, i6, str, mediaMuxer);
    }

    public void a(int i2, int i3, int i4, int i5, int i6, String str, MediaMuxer mediaMuxer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), str, mediaMuxer}) == null) {
            this.f40334b = new f(i2, i3, i4, i5, i6, mediaMuxer);
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f40340h : invokeV.booleanValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            a aVar = new a();
            aVar.f40344b = null;
            aVar.f40343a = 0L;
            this.f40333a.add(aVar);
            this.f40335c = true;
            this.l = null;
            this.m = 0L;
        }
    }

    @Deprecated
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            a aVar = new a();
            aVar.f40344b = null;
            aVar.f40343a = 0L;
            this.f40333a.clear();
            this.f40333a.add(aVar);
            this.f40335c = true;
        }
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f40336d + 1 : invokeV.intValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            LinkedBlockingQueue<a> linkedBlockingQueue = this.f40333a;
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
        if (!this.f40341i) {
            Thread.currentThread().setUncaughtExceptionHandler(this);
            this.f40341i = true;
            LogUtil.i("+initInThread");
            this.f40334b.a();
            LogUtil.i("-initInThread");
        }
        while (true) {
            try {
                LogUtil.i("+mQueue.take");
                take = this.f40333a.take();
                LogUtil.i("-mQueue.take");
            } catch (InterruptedException e2) {
                e2.printStackTrace();
                LogUtil.e(e2.toString());
            }
            if (take.f40344b == null) {
                this.f40338f.clear();
                this.f40333a.clear();
                this.f40334b.b();
                this.f40340h = true;
                return;
            }
            LogUtil.i("+encodeFrame");
            long currentTimeMillis = System.currentTimeMillis();
            this.f40334b.a(take.f40344b, take.f40343a);
            long currentTimeMillis2 = System.currentTimeMillis();
            LogUtil.i("-encodeFrame");
            synchronized (this.f40338f) {
                this.f40338f.add(take.f40344b);
            }
            this.f40336d++;
            LogUtil.i("mRecorder.encodeFrame:" + (currentTimeMillis2 - currentTimeMillis) + "ms");
            if (this.p < 0) {
                this.p = take.f40343a / 1000;
            }
            this.o = (take.f40343a / 1000) - this.p;
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
        if (!(interceptable == null || interceptable.invokeLJ(1048580, this, bArr, j2) == null) || this.f40335c || this.f40333a == null) {
            return;
        }
        if (this.f40338f.size() > 0) {
            synchronized (this.f40338f) {
                bArr2 = this.f40338f.pop();
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
        aVar.f40344b = bArr2;
        aVar.f40343a = j2;
        if (this.f40333a.size() < 50) {
            this.f40333a.add(aVar);
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
            this.f40339g = dVar;
        }
    }

    public void a(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, th) == null) {
            d dVar = this.f40339g;
            if (dVar != null) {
                dVar.a(th);
            }
            th.printStackTrace();
            LogUtil.e(th.toString());
            f fVar = this.f40334b;
            if (fVar != null) {
                fVar.b();
            }
        }
    }
}
