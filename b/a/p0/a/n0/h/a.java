package b.a.p0.a.n0.h;

import android.app.Activity;
import b.a.p0.a.k;
import b.a.p0.a.z2.n0;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public abstract class a implements b.a.p0.a.g1.k.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f7123a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1667479880, "Lb/a/p0/a/n0/h/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1667479880, "Lb/a/p0/a/n0/h/a;");
                return;
            }
        }
        f7123a = k.f6863a;
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

    @Override // b.a.p0.a.g1.k.a
    public void a(boolean z, Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048576, this, z, activity) == null) && c.a() && !z) {
            long currentTimeMillis = f7123a ? System.currentTimeMillis() : 0L;
            boolean B = n0.B();
            if (f7123a) {
                long currentTimeMillis2 = System.currentTimeMillis();
                String str = "detect all process is on baground cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms";
            }
            if (B) {
                boolean n = e.n();
                b.a.p0.a.e0.d.k("DiskCleanerLifecycleObserver", "all app process in background，run clean task");
                b.a.p0.a.n0.f.c().d().u(null, n, 16);
                e.p(false);
            }
        }
    }
}
