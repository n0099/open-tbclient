package c.a.p0.a.n0.h;

import android.app.Activity;
import c.a.p0.a.k;
import c.a.p0.a.v2.n0;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public abstract class a implements c.a.p0.a.g1.k.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f7488a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2116953239, "Lc/a/p0/a/n0/h/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2116953239, "Lc/a/p0/a/n0/h/a;");
                return;
            }
        }
        f7488a = k.f7085a;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // c.a.p0.a.g1.k.a
    public void a(boolean z, Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048576, this, z, activity) == null) && c.a() && !z) {
            long currentTimeMillis = f7488a ? System.currentTimeMillis() : 0L;
            boolean C = n0.C();
            if (f7488a) {
                long currentTimeMillis2 = System.currentTimeMillis();
                String str = "detect all process is on baground cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms";
            }
            if (C) {
                boolean n = e.n();
                c.a.p0.a.e0.d.h("DiskCleanerLifecycleObserver", "all app process in background，run clean task");
                c.a.p0.a.n0.f.c().d().u(null, n, 16);
                e.p(false);
            }
        }
    }
}
