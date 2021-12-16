package com.baidu.fsg.face.liveness.video;

import android.annotation.TargetApi;
import android.media.MediaMuxer;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.base.utils.LogUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes10.dex */
public class a extends h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f35323b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f35324c;
    public transient /* synthetic */ FieldHolder $fh;
    public g a;

    /* renamed from: d  reason: collision with root package name */
    public int f35325d;

    /* renamed from: e  reason: collision with root package name */
    public CountDownLatch f35326e;
    public String t;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1748391893, "Lcom/baidu/fsg/face/liveness/video/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1748391893, "Lcom/baidu/fsg/face/liveness/video/a;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(String str, b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.t = str;
    }

    @Override // com.baidu.fsg.face.liveness.video.h
    @TargetApi(18)
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int a = this.f35352j.a();
            int b2 = this.f35352j.b();
            LogUtil.i("previewSize:" + a + "," + b2);
            f35323b = false;
            f35324c = false;
            int c2 = this.f35352j.c();
            try {
                MediaMuxer mediaMuxer = new MediaMuxer(this.t, 0);
                mediaMuxer.setOrientationHint(c2);
                this.f35326e = new CountDownLatch(1);
                g gVar = new g(a, b2, this.s, this.q, this.r, null, mediaMuxer, this.f35326e);
                this.a = gVar;
                gVar.a(this);
                this.o.d(c2);
                this.o.a(this.t);
                this.o.a(a);
                this.o.b(b2);
                return true;
            } catch (IOException e2) {
                a(e2);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.fsg.face.liveness.video.h
    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.f35351i) {
            i();
            this.f35351i = false;
            this.a.c();
            this.f35325d += this.a.e();
        }
    }

    @Override // com.baidu.fsg.face.liveness.video.h
    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.f35351i) {
            i();
            this.f35351i = false;
            this.a.c();
            this.f35325d += this.a.e();
        }
    }

    @Override // com.baidu.fsg.face.liveness.video.h
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.l.submit(new Runnable(this) { // from class: com.baidu.fsg.face.liveness.video.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.a.e();
                        this.a.n = System.currentTimeMillis();
                        VideoInfo.a(this.a.o.a(), this.a.o);
                        this.a.f35325d = 0;
                    }
                }
            });
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048582, this) != null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        int i2 = -1;
        long j2 = 0;
        long j3 = 1000;
        while (true) {
            boolean z = false;
            try {
                z = !this.f35326e.await(j3, TimeUnit.MILLISECONDS);
            } catch (InterruptedException unused) {
            }
            j3 = 5000;
            if (!z) {
                if (this.p) {
                    return;
                }
                return;
            } else if (!this.a.isAlive()) {
                if (this.p || this.a.b()) {
                    return;
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                a(new RuntimeException("wait record stop" + (currentTimeMillis2 - currentTimeMillis) + "ms,timeout"));
                return;
            } else if (i2 != this.a.f()) {
                i2 = this.a.f();
                j2 = System.currentTimeMillis();
            } else if (System.currentTimeMillis() - j2 > 10000) {
                String str = (System.currentTimeMillis() - j2) + "ms cannot write finish, record fail";
                LogUtil.e(str);
                a(new RuntimeException(str));
                return;
            }
        }
    }

    @Override // com.baidu.fsg.face.liveness.video.c
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.p = false;
            h();
            if (a()) {
                this.a.start();
                this.m = System.currentTimeMillis();
                this.f35351i = true;
            }
        }
    }

    @Override // com.baidu.fsg.face.liveness.video.e
    public void a(byte[] bArr, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr, j2) == null) || !this.f35351i || bArr == null || this.f35353k) {
            return;
        }
        this.a.a(bArr, j2);
    }

    @Override // com.baidu.fsg.face.liveness.video.d
    public void a(Throwable th) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, th) == null) || this.p) {
            return;
        }
        LogUtil.i("onVideoRecordFail");
        synchronized (this) {
            if (this.p) {
                return;
            }
            this.p = true;
            if (th != null) {
                LogUtil.e(th.toString());
                th.printStackTrace();
            }
            if (this.f35351i) {
                LogUtil.i("stopRecordAndCancel");
                c();
            }
            File file = new File(this.o.a());
            if (file.exists()) {
                file.delete();
            }
        }
    }
}
