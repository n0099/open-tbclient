package c.a.n0.a.x.t;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.p2.q0;
import c.a.n0.a.x.u.g;
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
    public static LinkedList<e> f7444b;

    /* renamed from: c  reason: collision with root package name */
    public static Map<String, c.a.n0.a.f.e.b> f7445c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.n0.a.x.t.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0573a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public RunnableC0573a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (a.a) {
                    Log.d("SwanAppSlavePool", "getPreloadSlaveManager prepare next start.");
                }
                a.n(c.a.n0.a.w0.f.U().getActivity());
                if (a.a) {
                    Log.d("SwanAppSlavePool", "getPreloadSlaveManager prepare next end.");
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b extends c.a.n0.a.x.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f7446b;

        public b(e eVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
            this.f7446b = z;
        }

        @Override // c.a.n0.a.x.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (a.a) {
                    Log.d("SwanAppSlavePool", "onPageFinished slaveId: " + this.a.a.c() + " url: " + str);
                }
                if (!c.a.n0.a.n1.a.a.D() || !g.U().q0()) {
                    a.l(this.a, this.f7446b);
                } else {
                    a.m(this.a, this.f7446b);
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
        public final /* synthetic */ boolean f7447b;

        public c(e eVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
            this.f7447b = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (a.a) {
                    Log.d("SwanAppSlavePool", "slave onReceiveValue: " + str);
                }
                a.l(this.a, this.f7447b);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class d extends c.a.n0.a.x.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.a.f.e.b a;

        public d(c.a.n0.a.f.e.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // c.a.n0.a.x.b
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
        public c.a.n0.a.f.e.b a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f7448b;

        /* renamed from: c  reason: collision with root package name */
        public final ArrayList<f> f7449c;

        /* renamed from: d  reason: collision with root package name */
        public long f7450d;

        /* renamed from: e  reason: collision with root package name */
        public long f7451e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f7452f;

        public e() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7449c = new ArrayList<>();
            this.f7452f = true;
        }
    }

    /* loaded from: classes.dex */
    public interface f {
        void onReady();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-622500127, "Lc/a/n0/a/x/t/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-622500127, "Lc/a/n0/a/x/t/a;");
                return;
            }
        }
        a = c.a.n0.a.a.a;
        f7444b = new LinkedList<>();
        f7445c = new TreeMap();
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            f7444b.clear();
            f7445c.clear();
        }
    }

    public static e e(Context context, int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{context, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            if (!c.a.n0.a.x.t.f.a.d()) {
                i = 0;
            }
            e eVar = new e();
            eVar.f7450d = System.currentTimeMillis();
            eVar.f7448b = false;
            eVar.a = g.U().K0(context, i, new b(eVar, z));
            return eVar;
        }
        return (e) invokeCommon.objValue;
    }

    public static e f(@Nullable Activity activity, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, activity, i)) == null) {
            if (a) {
                Log.d("SwanAppSlavePool", "getPreloadSlaveManager: " + i);
                Log.d("SwanAppSlavePool", Log.getStackTraceString(new Exception()));
            }
            return g(activity, i, false);
        }
        return (e) invokeLI.objValue;
    }

    public static e g(@Nullable Activity activity, int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{activity, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            if (a) {
                Log.d("SwanAppSlavePool", "getPreloadSlaveManager");
            }
            if (!c.a.n0.a.x.t.f.a.d()) {
                i = 0;
            }
            e eVar = null;
            Iterator<e> it = f7444b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                e next = it.next();
                if (next.a.T() == i) {
                    eVar = next;
                    break;
                }
            }
            if (eVar == null) {
                return e(k(activity), i, false);
            }
            f7444b.remove(eVar);
            c.a.n0.a.f.e.b bVar = eVar.a;
            if (bVar != null && activity != null) {
                bVar.f(activity);
            }
            if (a) {
                Log.d("SwanAppSlavePool", "getPreloadSlaveManager prepare next.");
            }
            if (!z) {
                int g2 = c.a.n0.a.k1.l.e.g();
                if (g2 <= 0) {
                    g2 = 600;
                }
                q0.b0(new RunnableC0573a(), g2);
            }
            return eVar;
        }
        return (e) invokeCommon.objValue;
    }

    public static c.a.n0.a.f.e.b h(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            c.a.n0.a.f.e.b bVar = f7445c.get(str != null ? str : "");
            if (bVar != null) {
                f7445c.remove(str);
            }
            return bVar;
        }
        return (c.a.n0.a.f.e.b) invokeL.objValue;
    }

    public static boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            c.a.n0.a.t1.e a0 = c.a.n0.a.t1.e.a0();
            if (a0 == null || a0.P() == null) {
                return false;
            }
            return a0.P().u;
        }
        return invokeV.booleanValue;
    }

    public static boolean j(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65546, null, i)) == null) {
            for (int i2 = 0; i2 < f7444b.size(); i2++) {
                if (f7444b.get(i2).a.T() == i) {
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
                return c.a.n0.a.s0.a.c();
            }
            return ((context instanceof Activity) && ((Activity) context).isFinishing()) ? c.a.n0.a.s0.a.c() : context;
        }
        return (Context) invokeL.objValue;
    }

    public static void l(@NonNull e eVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65548, null, eVar, z) == null) {
            if (z && eVar.f7452f) {
                c.a.n0.a.x.t.g.a.j(eVar.a);
            }
            eVar.f7451e = System.currentTimeMillis();
            eVar.f7448b = true;
            if (eVar.f7449c.isEmpty()) {
                return;
            }
            Iterator<f> it = eVar.f7449c.iterator();
            while (it.hasNext()) {
                f next = it.next();
                if (next != null) {
                    next.onReady();
                }
            }
            eVar.f7449c.clear();
        }
    }

    public static void m(@NonNull e eVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65549, null, eVar, z) == null) {
            c.a.n0.a.u.f.d.f.k().o(eVar.a, new c(eVar, z));
        }
    }

    public static void n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, context) == null) {
            if (!j(0)) {
                f7444b.add(e(k(context), 0, true));
            }
            if (!j(1) && c.a.n0.a.x.t.f.a.d() && i()) {
                f7444b.add(e(k(context), 1, true));
            }
        }
    }

    public static void o(@NonNull String str, c.a.n0.a.f.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65551, null, str, bVar) == null) {
            Map<String, c.a.n0.a.f.e.b> map = f7445c;
            if (str == null) {
                str = "";
            }
            map.put(str, bVar);
        }
    }

    public static void p(@NonNull c.a.n0.a.f.e.b<?> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, bVar) == null) {
            if (bVar.T() == 1 && !i()) {
                if (g.U().l0()) {
                    bVar.destroy();
                    return;
                } else {
                    g.U().K(new d(bVar));
                    return;
                }
            }
            e eVar = new e();
            eVar.f7450d = System.currentTimeMillis();
            eVar.f7448b = false;
            eVar.a = bVar;
            f7444b.add(eVar);
            if (c.a.n0.a.n1.a.a.D() && g.U().q0()) {
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
        if (eVar.f7448b) {
            fVar.onReady();
            return;
        }
        eVar.f7449c.add(fVar);
        eVar.f7452f = false;
    }
}
