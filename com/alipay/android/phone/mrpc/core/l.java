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
/* loaded from: classes4.dex */
public final class l implements ab {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static l f35517b;

    /* renamed from: i  reason: collision with root package name */
    public static final ThreadFactory f35518i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f35519a;

    /* renamed from: c  reason: collision with root package name */
    public ThreadPoolExecutor f35520c;

    /* renamed from: d  reason: collision with root package name */
    public b f35521d;

    /* renamed from: e  reason: collision with root package name */
    public long f35522e;

    /* renamed from: f  reason: collision with root package name */
    public long f35523f;

    /* renamed from: g  reason: collision with root package name */
    public long f35524g;

    /* renamed from: h  reason: collision with root package name */
    public int f35525h;

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
        f35518i = new n();
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
        this.f35519a = context;
        this.f35521d = b.a("android");
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 11, 3L, TimeUnit.SECONDS, new ArrayBlockingQueue(20), f35518i, new ThreadPoolExecutor.CallerRunsPolicy());
        this.f35520c = threadPoolExecutor;
        try {
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        } catch (Exception unused) {
        }
        CookieSyncManager.createInstance(this.f35519a);
        CookieManager.getInstance().setAcceptCookie(true);
    }

    public static final l a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            l lVar = f35517b;
            return lVar != null ? lVar : b(context);
        }
        return (l) invokeL.objValue;
    }

    public static final synchronized l b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            synchronized (l.class) {
                if (f35517b != null) {
                    return f35517b;
                }
                l lVar = new l(context);
                f35517b = lVar;
                return lVar;
            }
        }
        return (l) invokeL.objValue;
    }

    public final b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f35521d : (b) invokeV.objValue;
    }

    @Override // com.alipay.android.phone.mrpc.core.ab
    public final Future<u> a(t tVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tVar)) == null) {
            if (s.a(this.f35519a)) {
                String str = "HttpManager" + hashCode() + ": Active Task = %d, Completed Task = %d, All Task = %d,Avarage Speed = %d KB/S, Connetct Time = %d ms, All data size = %d bytes, All enqueueConnect time = %d ms, All socket time = %d ms, All request times = %d times";
                Object[] objArr = new Object[9];
                objArr[0] = Integer.valueOf(this.f35520c.getActiveCount());
                objArr[1] = Long.valueOf(this.f35520c.getCompletedTaskCount());
                objArr[2] = Long.valueOf(this.f35520c.getTaskCount());
                long j2 = this.f35524g;
                objArr[3] = Long.valueOf(j2 == 0 ? 0L : ((this.f35522e * 1000) / j2) >> 10);
                int i2 = this.f35525h;
                objArr[4] = Long.valueOf(i2 != 0 ? this.f35523f / i2 : 0L);
                objArr[5] = Long.valueOf(this.f35522e);
                objArr[6] = Long.valueOf(this.f35523f);
                objArr[7] = Long.valueOf(this.f35524g);
                objArr[8] = Integer.valueOf(this.f35525h);
                String.format(str, objArr);
            }
            q qVar = new q(this, (o) tVar);
            m mVar = new m(this, qVar, qVar);
            this.f35520c.execute(mVar);
            return mVar;
        }
        return (Future) invokeL.objValue;
    }

    public final void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2) == null) {
            this.f35522e += j2;
        }
    }

    public final void b(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j2) == null) {
            this.f35523f += j2;
            this.f35525h++;
        }
    }

    public final void c(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j2) == null) {
            this.f35524g += j2;
        }
    }
}
