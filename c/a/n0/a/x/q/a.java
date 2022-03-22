package c.a.n0.a.x.q;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.x.o.j.d;
import c.a.n0.a.x.o.j.e.a;
import c.a.n0.a.x.q.d.c;
import c.a.n0.a.x.q.d.e;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.core.prefetch.statistics.item.RecordType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Set;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static final c f7393b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.n0.a.x.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0570a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f7394b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f7395c;

        public RunnableC0570a(String str, boolean z, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Boolean.valueOf(z), str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.f7394b = z;
            this.f7395c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long currentTimeMillis = a.a ? System.currentTimeMillis() : 0L;
                Set<String> m = b.k().m(this.a, true);
                if (m == null || m.size() <= 0) {
                    return;
                }
                if (a.a) {
                    Log.d("SwanPreLinkWhenPreload", "start prelink, swan is already launched - " + this.f7394b);
                }
                for (String str : m) {
                    boolean b2 = a.b(this.f7395c, this.a, str);
                    d d2 = d.d();
                    String str2 = this.f7395c;
                    a.b a = c.a.n0.a.x.o.j.e.a.a();
                    a.h(RecordType.PREFETCH_PRELINK);
                    a.f(str);
                    a.g(b2);
                    d2.f(str2, a.e());
                    if (b2) {
                        b.k().s(this.a, str);
                        a.d(this.a, str);
                    }
                }
                if (a.a) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    Log.d("SwanPreLinkWhenPreload", " prelink - " + this.a + ", cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-622589500, "Lc/a/n0/a/x/q/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-622589500, "Lc/a/n0/a/x/q/a;");
                return;
            }
        }
        a = c.a.n0.a.a.a;
        f7393b = e.a();
    }

    public static boolean b(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, str, str2, str3)) == null) {
            if (TextUtils.isEmpty(str3)) {
                return false;
            }
            return f7393b.c(str, str2, str3);
        }
        return invokeLLL.booleanValue;
    }

    public static void c(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, str, str2) == null) {
            if (!f7393b.b()) {
                if (a) {
                    Log.d("SwanPreLinkWhenPreload", "prelink by preload ab is off");
                }
            } else if (TextUtils.isEmpty(str2)) {
                if (a) {
                    Log.d("SwanPreLinkWhenPreload", "prelink by preload appId is empty");
                }
            } else {
                c.a.n0.a.t1.e r = c.a.n0.a.t1.d.J().r();
                if (r == null) {
                    if (a) {
                        Log.d("SwanPreLinkWhenPreload", "prelink by preload swanApp is null");
                    }
                } else if (TextUtils.equals(r.f6344b, str2)) {
                    e(str, str2, r.H());
                }
            }
        }
    }

    public static void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2) == null) || f7393b.a() == null) {
            return;
        }
        f7393b.a().b(str, str2, true);
    }

    public static void e(String str, @NonNull String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65541, null, str, str2, z) == null) {
            ExecutorUtilsExt.postOnSerial(new RunnableC0570a(str2, z, str), "SwanPreLinkWhenPreload");
        }
    }
}
