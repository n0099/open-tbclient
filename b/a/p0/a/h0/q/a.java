package b.a.p0.a.h0.q;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.h0.o.j.d;
import b.a.p0.a.h0.o.j.e.a;
import b.a.p0.a.h0.q.d.c;
import b.a.p0.a.h0.q.d.e;
import b.a.p0.a.k;
import com.baidu.mobads.container.util.AdIconUtil;
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

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f6024a;

    /* renamed from: b  reason: collision with root package name */
    public static final c f6025b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.a.p0.a.h0.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0255a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f6026e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f6027f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f6028g;

        public RunnableC0255a(String str, boolean z, String str2) {
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
            this.f6026e = str;
            this.f6027f = z;
            this.f6028g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long currentTimeMillis = a.f6024a ? System.currentTimeMillis() : 0L;
                Set<String> m = b.k().m(this.f6026e, true);
                if (m == null || m.size() <= 0) {
                    return;
                }
                if (a.f6024a) {
                    String str = "start prelink, swan is already launched - " + this.f6027f;
                }
                for (String str2 : m) {
                    boolean b2 = a.b(this.f6028g, this.f6026e, str2);
                    d d2 = d.d();
                    String str3 = this.f6028g;
                    a.b a2 = b.a.p0.a.h0.o.j.e.a.a();
                    a2.h(RecordType.PREFETCH_PRELINK);
                    a2.f(str2);
                    a2.g(b2);
                    d2.f(str3, a2.e());
                    if (b2) {
                        b.k().s(this.f6026e, str2);
                        a.d(this.f6026e, str2);
                    }
                }
                if (a.f6024a) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    String str4 = " prelink - " + this.f6026e + ", cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms";
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1597700745, "Lb/a/p0/a/h0/q/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1597700745, "Lb/a/p0/a/h0/q/a;");
                return;
            }
        }
        f6024a = k.f6863a;
        f6025b = e.a();
    }

    public static boolean b(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, str, str2, str3)) == null) {
            if (TextUtils.isEmpty(str3)) {
                return false;
            }
            return f6025b.c(str, str2, str3);
        }
        return invokeLLL.booleanValue;
    }

    public static void c(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, str, str2) == null) {
            if (!f6025b.b()) {
                boolean z = f6024a;
            } else if (TextUtils.isEmpty(str2)) {
                boolean z2 = f6024a;
            } else {
                b.a.p0.a.d2.e r = b.a.p0.a.d2.d.J().r();
                if (r == null) {
                    boolean z3 = f6024a;
                } else if (TextUtils.equals(r.f4474f, str2)) {
                    e(str, str2, r.H());
                }
            }
        }
    }

    public static void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2) == null) || f6025b.a() == null) {
            return;
        }
        f6025b.a().b(str, str2, true);
    }

    public static void e(String str, @NonNull String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(AdIconUtil.AD_TEXT_ID, null, str, str2, z) == null) {
            ExecutorUtilsExt.postOnSerial(new RunnableC0255a(str2, z, str), "SwanPreLinkWhenPreload");
        }
    }
}
