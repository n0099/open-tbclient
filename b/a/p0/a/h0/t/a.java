package b.a.p0.a.h0.t;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.h0.u.g;
import b.a.p0.a.k;
import b.a.p0.a.z2.q0;
import com.baidu.mobads.container.util.AdIconUtil;
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

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f6100a;

    /* renamed from: b  reason: collision with root package name */
    public static LinkedList<e> f6101b;

    /* renamed from: c  reason: collision with root package name */
    public static Map<String, b.a.p0.a.p.e.b> f6102c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.a.p0.a.h0.t.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0258a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public RunnableC0258a() {
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
                boolean unused = a.f6100a;
                a.n(b.a.p0.a.g1.f.U().getActivity());
                boolean unused2 = a.f6100a;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b extends b.a.p0.a.h0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f6103a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f6104b;

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
            this.f6103a = eVar;
            this.f6104b = z;
        }

        @Override // b.a.p0.a.h0.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (a.f6100a) {
                    String str2 = "onPageFinished slaveId: " + this.f6103a.f6108a.c() + " url: " + str;
                }
                if (!b.a.p0.a.x1.a.a.D() || !g.U().q0()) {
                    a.l(this.f6103a, this.f6104b);
                } else {
                    a.m(this.f6103a, this.f6104b);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c implements ValueCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f6105a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f6106b;

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
            this.f6105a = eVar;
            this.f6106b = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (a.f6100a) {
                    String str2 = "slave onReceiveValue: " + str;
                }
                a.l(this.f6105a, this.f6106b);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class d extends b.a.p0.a.h0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.p.e.b f6107a;

        public d(b.a.p0.a.p.e.b bVar) {
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
            this.f6107a = bVar;
        }

        @Override // b.a.p0.a.h0.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f6107a.destroy();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public b.a.p0.a.p.e.b f6108a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f6109b;

        /* renamed from: c  reason: collision with root package name */
        public final ArrayList<f> f6110c;

        /* renamed from: d  reason: collision with root package name */
        public long f6111d;

        /* renamed from: e  reason: collision with root package name */
        public long f6112e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f6113f;

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
            this.f6110c = new ArrayList<>();
            this.f6113f = true;
        }
    }

    /* loaded from: classes.dex */
    public interface f {
        void onReady();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1597790118, "Lb/a/p0/a/h0/t/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1597790118, "Lb/a/p0/a/h0/t/a;");
                return;
            }
        }
        f6100a = k.f6863a;
        f6101b = new LinkedList<>();
        f6102c = new TreeMap();
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            f6101b.clear();
            f6102c.clear();
        }
    }

    public static e e(Context context, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{context, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (!b.a.p0.a.h0.t.f.a.d()) {
                i2 = 0;
            }
            e eVar = new e();
            eVar.f6111d = System.currentTimeMillis();
            eVar.f6109b = false;
            eVar.f6108a = g.U().K0(context, i2, new b(eVar, z));
            return eVar;
        }
        return (e) invokeCommon.objValue;
    }

    public static e f(@Nullable Activity activity, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(AdIconUtil.BAIDU_LOGO_ID, null, activity, i2)) == null) {
            if (f6100a) {
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
            boolean z2 = f6100a;
            if (!b.a.p0.a.h0.t.f.a.d()) {
                i2 = 0;
            }
            e eVar = null;
            Iterator<e> it = f6101b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                e next = it.next();
                if (next.f6108a.S() == i2) {
                    eVar = next;
                    break;
                }
            }
            if (eVar == null) {
                return e(k(activity), i2, false);
            }
            f6101b.remove(eVar);
            b.a.p0.a.p.e.b bVar = eVar.f6108a;
            if (bVar != null && activity != null) {
                bVar.f(activity);
            }
            boolean z3 = f6100a;
            if (!z) {
                int g2 = b.a.p0.a.u1.l.e.g();
                if (g2 <= 0) {
                    g2 = 600;
                }
                q0.b0(new RunnableC0258a(), g2);
            }
            return eVar;
        }
        return (e) invokeCommon.objValue;
    }

    public static b.a.p0.a.p.e.b h(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            b.a.p0.a.p.e.b bVar = f6102c.get(str != null ? str : "");
            if (bVar != null) {
                f6102c.remove(str);
            }
            return bVar;
        }
        return (b.a.p0.a.p.e.b) invokeL.objValue;
    }

    public static boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            b.a.p0.a.d2.e a0 = b.a.p0.a.d2.e.a0();
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
            for (int i3 = 0; i3 < f6101b.size(); i3++) {
                if (f6101b.get(i3).f6108a.S() == i2) {
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
                return b.a.p0.a.c1.a.c();
            }
            return ((context instanceof Activity) && ((Activity) context).isFinishing()) ? b.a.p0.a.c1.a.c() : context;
        }
        return (Context) invokeL.objValue;
    }

    public static void l(@NonNull e eVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65548, null, eVar, z) == null) {
            if (z && eVar.f6113f) {
                b.a.p0.a.h0.t.g.a.j(eVar.f6108a);
            }
            eVar.f6112e = System.currentTimeMillis();
            eVar.f6109b = true;
            if (eVar.f6110c.isEmpty()) {
                return;
            }
            Iterator<f> it = eVar.f6110c.iterator();
            while (it.hasNext()) {
                f next = it.next();
                if (next != null) {
                    next.onReady();
                }
            }
            eVar.f6110c.clear();
        }
    }

    public static void m(@NonNull e eVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65549, null, eVar, z) == null) {
            b.a.p0.a.e0.f.d.f.k().o(eVar.f6108a, new c(eVar, z));
        }
    }

    public static void n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, context) == null) {
            if (!j(0)) {
                f6101b.add(e(k(context), 0, true));
            }
            if (!j(1) && b.a.p0.a.h0.t.f.a.d() && i()) {
                f6101b.add(e(k(context), 1, true));
            }
        }
    }

    public static void o(@NonNull String str, b.a.p0.a.p.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65551, null, str, bVar) == null) {
            Map<String, b.a.p0.a.p.e.b> map = f6102c;
            if (str == null) {
                str = "";
            }
            map.put(str, bVar);
        }
    }

    public static void p(@NonNull b.a.p0.a.p.e.b<?> bVar) {
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
            eVar.f6111d = System.currentTimeMillis();
            eVar.f6109b = false;
            eVar.f6108a = bVar;
            f6101b.add(eVar);
            if (b.a.p0.a.x1.a.a.D() && g.U().q0()) {
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
        if (eVar.f6109b) {
            fVar.onReady();
            return;
        }
        eVar.f6110c.add(fVar);
        eVar.f6113f = false;
    }
}
