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
/* loaded from: classes.dex */
public final class l implements ab {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static l f1649b;

    /* renamed from: i  reason: collision with root package name */
    public static final ThreadFactory f1650i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f1651a;

    /* renamed from: c  reason: collision with root package name */
    public ThreadPoolExecutor f1652c;

    /* renamed from: d  reason: collision with root package name */
    public b f1653d;

    /* renamed from: e  reason: collision with root package name */
    public long f1654e;

    /* renamed from: f  reason: collision with root package name */
    public long f1655f;

    /* renamed from: g  reason: collision with root package name */
    public long f1656g;

    /* renamed from: h  reason: collision with root package name */
    public int f1657h;

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
        f1650i = new n();
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
        this.f1651a = context;
        this.f1653d = b.a("android");
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 11, 3L, TimeUnit.SECONDS, new ArrayBlockingQueue(20), f1650i, new ThreadPoolExecutor.CallerRunsPolicy());
        this.f1652c = threadPoolExecutor;
        try {
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        } catch (Exception unused) {
        }
        CookieSyncManager.createInstance(this.f1651a);
        CookieManager.getInstance().setAcceptCookie(true);
    }

    public static final l a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            l lVar = f1649b;
            return lVar != null ? lVar : b(context);
        }
        return (l) invokeL.objValue;
    }

    public static final synchronized l b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            synchronized (l.class) {
                if (f1649b != null) {
                    return f1649b;
                }
                l lVar = new l(context);
                f1649b = lVar;
                return lVar;
            }
        }
        return (l) invokeL.objValue;
    }

    public final b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f1653d : (b) invokeV.objValue;
    }

    @Override // com.alipay.android.phone.mrpc.core.ab
    public final Future<u> a(t tVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tVar)) == null) {
            if (s.a(this.f1651a)) {
                String str = "HttpManager" + hashCode() + ": Active Task = %d, Completed Task = %d, All Task = %d,Avarage Speed = %d KB/S, Connetct Time = %d ms, All data size = %d bytes, All enqueueConnect time = %d ms, All socket time = %d ms, All request times = %d times";
                Object[] objArr = new Object[9];
                objArr[0] = Integer.valueOf(this.f1652c.getActiveCount());
                objArr[1] = Long.valueOf(this.f1652c.getCompletedTaskCount());
                objArr[2] = Long.valueOf(this.f1652c.getTaskCount());
                long j = this.f1656g;
                objArr[3] = Long.valueOf(j == 0 ? 0L : ((this.f1654e * 1000) / j) >> 10);
                int i2 = this.f1657h;
                objArr[4] = Long.valueOf(i2 != 0 ? this.f1655f / i2 : 0L);
                objArr[5] = Long.valueOf(this.f1654e);
                objArr[6] = Long.valueOf(this.f1655f);
                objArr[7] = Long.valueOf(this.f1656g);
                objArr[8] = Integer.valueOf(this.f1657h);
                String.format(str, objArr);
            }
            q qVar = new q(this, (o) tVar);
            m mVar = new m(this, qVar, qVar);
            this.f1652c.execute(mVar);
            return mVar;
        }
        return (Future) invokeL.objValue;
    }

    public final void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            this.f1654e += j;
        }
    }

    public final void b(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            this.f1655f += j;
            this.f1657h++;
        }
    }

    public final void c(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            this.f1656g += j;
        }
    }
}
