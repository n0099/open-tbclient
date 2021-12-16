package c.a.q0.a.h0.q;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.a.h0.o.j.d;
import c.a.q0.a.h0.o.j.e.a;
import c.a.q0.a.h0.q.d.c;
import c.a.q0.a.h0.q.d.e;
import c.a.q0.a.k;
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
    public static final c f6235b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.q0.a.h0.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0345a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f6236e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f6237f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f6238g;

        public RunnableC0345a(String str, boolean z, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Boolean.valueOf(z), str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6236e = str;
            this.f6237f = z;
            this.f6238g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long currentTimeMillis = a.a ? System.currentTimeMillis() : 0L;
                Set<String> m = b.k().m(this.f6236e, true);
                if (m == null || m.size() <= 0) {
                    return;
                }
                if (a.a) {
                    String str = "start prelink, swan is already launched - " + this.f6237f;
                }
                for (String str2 : m) {
                    boolean b2 = a.b(this.f6238g, this.f6236e, str2);
                    d d2 = d.d();
                    String str3 = this.f6238g;
                    a.b a = c.a.q0.a.h0.o.j.e.a.a();
                    a.h(RecordType.PREFETCH_PRELINK);
                    a.f(str2);
                    a.g(b2);
                    d2.f(str3, a.e());
                    if (b2) {
                        b.k().s(this.f6236e, str2);
                        a.d(this.f6236e, str2);
                    }
                }
                if (a.a) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    String str4 = " prelink - " + this.f6236e + ", cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms";
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1216249287, "Lc/a/q0/a/h0/q/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1216249287, "Lc/a/q0/a/h0/q/a;");
                return;
            }
        }
        a = k.a;
        f6235b = e.a();
    }

    public static boolean b(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, str, str2, str3)) == null) {
            if (TextUtils.isEmpty(str3)) {
                return false;
            }
            return f6235b.c(str, str2, str3);
        }
        return invokeLLL.booleanValue;
    }

    public static void c(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, str, str2) == null) {
            if (!f6235b.b()) {
                boolean z = a;
            } else if (TextUtils.isEmpty(str2)) {
                boolean z2 = a;
            } else {
                c.a.q0.a.d2.e r = c.a.q0.a.d2.d.J().r();
                if (r == null) {
                    boolean z3 = a;
                } else if (TextUtils.equals(r.f4925f, str2)) {
                    e(str, str2, r.H());
                }
            }
        }
    }

    public static void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2) == null) || f6235b.a() == null) {
            return;
        }
        f6235b.a().b(str, str2, true);
    }

    public static void e(String str, @NonNull String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65541, null, str, str2, z) == null) {
            ExecutorUtilsExt.postOnSerial(new RunnableC0345a(str2, z, str), "SwanPreLinkWhenPreload");
        }
    }
}
