package c.a.p0.a.x.q;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.x.o.j.d;
import c.a.p0.a.x.o.j.e.a;
import c.a.p0.a.x.q.d.c;
import c.a.p0.a.x.q.d.e;
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
    public static final c f8795b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.p0.a.x.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0578a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8796e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f8797f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f8798g;

        public RunnableC0578a(String str, boolean z, String str2) {
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
            this.f8796e = str;
            this.f8797f = z;
            this.f8798g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long currentTimeMillis = a.a ? System.currentTimeMillis() : 0L;
                Set<String> m = b.k().m(this.f8796e, true);
                if (m == null || m.size() <= 0) {
                    return;
                }
                if (a.a) {
                    String str = "start prelink, swan is already launched - " + this.f8797f;
                }
                for (String str2 : m) {
                    boolean b2 = a.b(this.f8798g, this.f8796e, str2);
                    d d2 = d.d();
                    String str3 = this.f8798g;
                    a.b a = c.a.p0.a.x.o.j.e.a.a();
                    a.h(RecordType.PREFETCH_PRELINK);
                    a.f(str2);
                    a.g(b2);
                    d2.f(str3, a.e());
                    if (b2) {
                        b.k().s(this.f8796e, str2);
                        a.d(this.f8796e, str2);
                    }
                }
                if (a.a) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    String str4 = " prelink - " + this.f8796e + ", cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms";
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(78475078, "Lc/a/p0/a/x/q/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(78475078, "Lc/a/p0/a/x/q/a;");
                return;
            }
        }
        a = c.a.p0.a.a.a;
        f8795b = e.a();
    }

    public static boolean b(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, str, str2, str3)) == null) {
            if (TextUtils.isEmpty(str3)) {
                return false;
            }
            return f8795b.c(str, str2, str3);
        }
        return invokeLLL.booleanValue;
    }

    public static void c(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, str, str2) == null) {
            if (!f8795b.b()) {
                boolean z = a;
            } else if (TextUtils.isEmpty(str2)) {
                boolean z2 = a;
            } else {
                c.a.p0.a.t1.e r = c.a.p0.a.t1.d.J().r();
                if (r == null) {
                    boolean z3 = a;
                } else if (TextUtils.equals(r.f7512f, str2)) {
                    e(str, str2, r.H());
                }
            }
        }
    }

    public static void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2) == null) || f8795b.a() == null) {
            return;
        }
        f8795b.a().b(str, str2, true);
    }

    public static void e(String str, @NonNull String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65541, null, str, str2, z) == null) {
            ExecutorUtilsExt.postOnSerial(new RunnableC0578a(str2, z, str), "SwanPreLinkWhenPreload");
        }
    }
}
