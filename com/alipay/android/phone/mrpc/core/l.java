package com.alipay.android.phone.mrpc.core;

import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes9.dex */
public final class l implements ab {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static l f30686b;

    /* renamed from: i  reason: collision with root package name */
    public static final ThreadFactory f30687i;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: c  reason: collision with root package name */
    public ThreadPoolExecutor f30688c;

    /* renamed from: d  reason: collision with root package name */
    public b f30689d;

    /* renamed from: e  reason: collision with root package name */
    public long f30690e;

    /* renamed from: f  reason: collision with root package name */
    public long f30691f;

    /* renamed from: g  reason: collision with root package name */
    public long f30692g;

    /* renamed from: h  reason: collision with root package name */
    public int f30693h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-834063180, "Lcom/alipay/android/phone/mrpc/core/l;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-834063180, "Lcom/alipay/android/phone/mrpc/core/l;");
                return;
            }
        }
        f30687i = new n();
    }

    public l(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = context;
        this.f30689d = b.a("android");
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 11, 3L, TimeUnit.SECONDS, new ArrayBlockingQueue(20), f30687i, new ThreadPoolExecutor.CallerRunsPolicy());
        this.f30688c = threadPoolExecutor;
        try {
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        } catch (Exception unused) {
        }
        CookieSyncManager.createInstance(this.a);
        CookieManager.getInstance().setAcceptCookie(true);
    }

    public static final l a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            l lVar = f30686b;
            return lVar != null ? lVar : b(context);
        }
        return (l) invokeL.objValue;
    }

    public static final synchronized l b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            synchronized (l.class) {
                l lVar = f30686b;
                if (lVar != null) {
                    return lVar;
                }
                l lVar2 = new l(context);
                f30686b = lVar2;
                return lVar2;
            }
        }
        return (l) invokeL.objValue;
    }

    public final b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f30689d : (b) invokeV.objValue;
    }

    @Override // com.alipay.android.phone.mrpc.core.ab
    public final Future<u> a(t tVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tVar)) == null) {
            if (s.a(this.a)) {
                String str = "HttpManager" + hashCode() + ": Active Task = %d, Completed Task = %d, All Task = %d,Avarage Speed = %d KB/S, Connetct Time = %d ms, All data size = %d bytes, All enqueueConnect time = %d ms, All socket time = %d ms, All request times = %d times";
                Object[] objArr = new Object[9];
                objArr[0] = Integer.valueOf(this.f30688c.getActiveCount());
                objArr[1] = Long.valueOf(this.f30688c.getCompletedTaskCount());
                objArr[2] = Long.valueOf(this.f30688c.getTaskCount());
                long j2 = this.f30692g;
                objArr[3] = Long.valueOf(j2 == 0 ? 0L : ((this.f30690e * 1000) / j2) >> 10);
                int i2 = this.f30693h;
                objArr[4] = Long.valueOf(i2 != 0 ? this.f30691f / i2 : 0L);
                objArr[5] = Long.valueOf(this.f30690e);
                objArr[6] = Long.valueOf(this.f30691f);
                objArr[7] = Long.valueOf(this.f30692g);
                objArr[8] = Integer.valueOf(this.f30693h);
                String.format(str, objArr);
            }
            q qVar = new q(this, (o) tVar);
            m mVar = new m(this, qVar, qVar);
            this.f30688c.execute(mVar);
            return mVar;
        }
        return (Future) invokeL.objValue;
    }

    public final void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2) == null) {
            this.f30690e += j2;
        }
    }

    public final void b(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j2) == null) {
            this.f30691f += j2;
            this.f30693h++;
        }
    }

    public final void c(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j2) == null) {
            this.f30692g += j2;
        }
    }
}
