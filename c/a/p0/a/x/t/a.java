package c.a.p0.a.x.t;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.p2.q0;
import c.a.p0.a.x.u.g;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static LinkedList<e> f8855b;

    /* renamed from: c  reason: collision with root package name */
    public static Map<String, c.a.p0.a.f.e.b> f8856c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.p0.a.x.t.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0581a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public RunnableC0581a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean unused = a.a;
                a.n(c.a.p0.a.w0.f.U().getActivity());
                boolean unused2 = a.a;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b extends c.a.p0.a.x.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f8857b;

        public b(e eVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
            this.f8857b = z;
        }

        @Override // c.a.p0.a.x.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (a.a) {
                    String str2 = "onPageFinished slaveId: " + this.a.a.c() + " url: " + str;
                }
                if (!c.a.p0.a.n1.a.a.D() || !g.U().q0()) {
                    a.l(this.a, this.f8857b);
                } else {
                    a.m(this.a, this.f8857b);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c implements ValueCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f8858b;

        public c(e eVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
            this.f8858b = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (a.a) {
                    String str2 = "slave onReceiveValue: " + str;
                }
                a.l(this.a, this.f8858b);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class d extends c.a.p0.a.x.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.p0.a.f.e.b a;

        public d(c.a.p0.a.f.e.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // c.a.p0.a.x.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.a.destroy();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public c.a.p0.a.f.e.b a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f8859b;

        /* renamed from: c  reason: collision with root package name */
        public final ArrayList<f> f8860c;

        /* renamed from: d  reason: collision with root package name */
        public long f8861d;

        /* renamed from: e  reason: collision with root package name */
        public long f8862e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f8863f;

        public e() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8860c = new ArrayList<>();
            this.f8863f = true;
        }
    }

    /* loaded from: classes.dex */
    public interface f {
        void onReady();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(78564451, "Lc/a/p0/a/x/t/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(78564451, "Lc/a/p0/a/x/t/a;");
                return;
            }
        }
        a = c.a.p0.a.a.a;
        f8855b = new LinkedList<>();
        f8856c = new TreeMap();
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            f8855b.clear();
            f8856c.clear();
        }
    }

    public static e e(Context context, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{context, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (!c.a.p0.a.x.t.f.a.d()) {
                i2 = 0;
            }
            e eVar = new e();
            eVar.f8861d = System.currentTimeMillis();
            eVar.f8859b = false;
            eVar.a = g.U().K0(context, i2, new b(eVar, z));
            return eVar;
        }
        return (e) invokeCommon.objValue;
    }

    public static e f(@Nullable Activity activity, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, activity, i2)) == null) {
            if (a) {
                String str = "getPreloadSlaveManager: " + i2;
                Log.getStackTraceString(new Exception());
            }
            return g(activity, i2, false);
        }
        return (e) invokeLI.objValue;
    }

    public static e g(@Nullable Activity activity, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{activity, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            boolean z2 = a;
            if (!c.a.p0.a.x.t.f.a.d()) {
                i2 = 0;
            }
            e eVar = null;
            Iterator<e> it = f8855b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                e next = it.next();
                if (next.a.S() == i2) {
                    eVar = next;
                    break;
                }
            }
            if (eVar == null) {
                return e(k(activity), i2, false);
            }
            f8855b.remove(eVar);
            c.a.p0.a.f.e.b bVar = eVar.a;
            if (bVar != null && activity != null) {
                bVar.f(activity);
            }
            boolean z3 = a;
            if (!z) {
                int g2 = c.a.p0.a.k1.l.e.g();
                if (g2 <= 0) {
                    g2 = 600;
                }
                q0.b0(new RunnableC0581a(), g2);
            }
            return eVar;
        }
        return (e) invokeCommon.objValue;
    }

    public static c.a.p0.a.f.e.b h(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            c.a.p0.a.f.e.b bVar = f8856c.get(str != null ? str : "");
            if (bVar != null) {
                f8856c.remove(str);
            }
            return bVar;
        }
        return (c.a.p0.a.f.e.b) invokeL.objValue;
    }

    public static boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            c.a.p0.a.t1.e a0 = c.a.p0.a.t1.e.a0();
            if (a0 == null || a0.P() == null) {
                return false;
            }
            return a0.P().u;
        }
        return invokeV.booleanValue;
    }

    public static boolean j(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65546, null, i2)) == null) {
            for (int i3 = 0; i3 < f8855b.size(); i3++) {
                if (f8855b.get(i3).a.S() == i2) {
                    return true;
                }
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public static Context k(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            if (context == null) {
                return c.a.p0.a.s0.a.c();
            }
            return ((context instanceof Activity) && ((Activity) context).isFinishing()) ? c.a.p0.a.s0.a.c() : context;
        }
        return (Context) invokeL.objValue;
    }

    public static void l(@NonNull e eVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65548, null, eVar, z) == null) {
            if (z && eVar.f8863f) {
                c.a.p0.a.x.t.g.a.j(eVar.a);
            }
            eVar.f8862e = System.currentTimeMillis();
            eVar.f8859b = true;
            if (eVar.f8860c.isEmpty()) {
                return;
            }
            Iterator<f> it = eVar.f8860c.iterator();
            while (it.hasNext()) {
                f next = it.next();
                if (next != null) {
                    next.onReady();
                }
            }
            eVar.f8860c.clear();
        }
    }

    public static void m(@NonNull e eVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65549, null, eVar, z) == null) {
            c.a.p0.a.u.f.d.f.k().o(eVar.a, new c(eVar, z));
        }
    }

    public static void n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, context) == null) {
            if (!j(0)) {
                f8855b.add(e(k(context), 0, true));
            }
            if (!j(1) && c.a.p0.a.x.t.f.a.d() && i()) {
                f8855b.add(e(k(context), 1, true));
            }
        }
    }

    public static void o(@NonNull String str, c.a.p0.a.f.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65551, null, str, bVar) == null) {
            Map<String, c.a.p0.a.f.e.b> map = f8856c;
            if (str == null) {
                str = "";
            }
            map.put(str, bVar);
        }
    }

    public static void p(@NonNull c.a.p0.a.f.e.b<?> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, bVar) == null) {
            if (bVar.S() == 1 && !i()) {
                if (g.U().l0()) {
                    bVar.destroy();
                    return;
                } else {
                    g.U().K(new d(bVar));
                    return;
                }
            }
            e eVar = new e();
            eVar.f8861d = System.currentTimeMillis();
            eVar.f8859b = false;
            eVar.a = bVar;
            f8855b.add(eVar);
            if (c.a.p0.a.n1.a.a.D() && g.U().q0()) {
                m(eVar, true);
            } else {
                l(eVar, true);
            }
        }
    }

    public static void q(e eVar, f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65553, null, eVar, fVar) == null) || fVar == null) {
            return;
        }
        if (eVar.f8859b) {
            fVar.onReady();
            return;
        }
        eVar.f8860c.add(fVar);
        eVar.f8863f = false;
    }
}
