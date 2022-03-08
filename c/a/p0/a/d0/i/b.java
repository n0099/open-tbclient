package c.a.p0.a.d0.i;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.d2.n;
import c.a.p0.a.d2.s.f;
import c.a.p0.a.v0.e.c;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static long f4747b;

    /* renamed from: c  reason: collision with root package name */
    public static String f4748c;

    /* renamed from: d  reason: collision with root package name */
    public static String f4749d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Bundle f4750e;

        public a(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4750e = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a aVar = (c.a) new c.a().s(this.f4750e);
                f fVar = new f();
                fVar.a = n.n(0);
                fVar.f4947b = "launch";
                fVar.f4950e = "repeatlaunch";
                fVar.a("launchInterval", Long.valueOf(aVar.l("launch_interval", -1L)));
                fVar.j(aVar);
                fVar.d(aVar.s0().getString(UBCCloudControlProcessor.UBC_KEY));
                fVar.b(n.k(aVar.W()));
                n.onEvent(fVar);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1831880843, "Lc/a/p0/a/d0/i/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1831880843, "Lc/a/p0/a/d0/i/b;");
                return;
            }
        }
        a = c.a.p0.a.a.a;
    }

    public static long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? System.currentTimeMillis() - f4747b : invokeV.longValue;
    }

    public static boolean b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            long currentTimeMillis = System.currentTimeMillis() - f4747b;
            boolean z = currentTimeMillis < 800 && TextUtils.equals(f4748c, str) && TextUtils.equals(f4749d, str2);
            if (a && z) {
                String str3 = "CurrentLaunchInterval:" + currentTimeMillis + ",PreventSeriesLaunchInterval:800";
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            f4747b = System.currentTimeMillis();
        }
    }

    public static void d(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bundle) == null) {
            ExecutorUtilsExt.postOnElastic(new a(bundle), "SeriesLaunchChecker", 3);
        }
    }

    public static void e(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, str, str2) == null) {
            f4748c = str;
            f4749d = str2;
        }
    }
}
