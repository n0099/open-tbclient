package c.a.n0.a.h0.t;

import android.app.Activity;
import android.content.Context;
import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.g1.f;
import c.a.n0.a.h0.u.g;
import c.a.n0.a.k;
import c.a.n0.a.v2.q0;
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
    public static final boolean f6156a;

    /* renamed from: b  reason: collision with root package name */
    public static LinkedList<d> f6157b;

    /* renamed from: c  reason: collision with root package name */
    public static Map<String, c.a.n0.a.p.e.b> f6158c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.n0.a.h0.t.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0241a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public RunnableC0241a() {
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
                boolean unused = a.f6156a;
                a.l(f.V().getActivity());
                boolean unused2 = a.f6156a;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b extends c.a.n0.a.h0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f6159a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f6160b;

        public b(d dVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6159a = dVar;
            this.f6160b = z;
        }

        @Override // c.a.n0.a.h0.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (a.f6156a) {
                    String str2 = "onPageFinished slaveId: " + this.f6159a.f6163a.c() + " url: " + str;
                }
                if (!c.a.n0.a.u1.a.a.C() || !g.N().g0()) {
                    a.j(this.f6159a, this.f6160b);
                } else {
                    a.k(this.f6159a, this.f6160b);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c implements ValueCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f6161a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f6162b;

        public c(d dVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6161a = dVar;
            this.f6162b = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (a.f6156a) {
                    String str2 = "slave onReceiveValue: " + str;
                }
                a.j(this.f6161a, this.f6162b);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public c.a.n0.a.p.e.b f6163a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f6164b;

        /* renamed from: c  reason: collision with root package name */
        public final ArrayList<e> f6165c;

        /* renamed from: d  reason: collision with root package name */
        public long f6166d;

        /* renamed from: e  reason: collision with root package name */
        public long f6167e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f6168f;

        public d() {
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
            this.f6165c = new ArrayList<>();
            this.f6168f = true;
        }
    }

    /* loaded from: classes.dex */
    public interface e {
        void onReady();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(829090503, "Lc/a/n0/a/h0/t/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(829090503, "Lc/a/n0/a/h0/t/a;");
                return;
            }
        }
        f6156a = k.f6803a;
        f6157b = new LinkedList<>();
        f6158c = new TreeMap();
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            f6157b.clear();
            f6158c.clear();
        }
    }

    public static d e(Context context, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(AdIconUtil.AD_TEXT_ID, null, context, z)) == null) {
            d dVar = new d();
            dVar.f6166d = System.currentTimeMillis();
            dVar.f6164b = false;
            dVar.f6163a = g.N().y0(context, new b(dVar, z));
            return dVar;
        }
        return (d) invokeLZ.objValue;
    }

    public static d f(@Nullable Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, activity)) == null) ? g(activity, false) : (d) invokeL.objValue;
    }

    public static d g(@Nullable Activity activity, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65543, null, activity, z)) == null) {
            boolean z2 = f6156a;
            if (f6157b.isEmpty()) {
                return e(i(activity), false);
            }
            if (f6156a) {
                String str = "getPreloadSlaveManager : " + f6157b.getFirst();
            }
            d removeFirst = f6157b.removeFirst();
            c.a.n0.a.p.e.b bVar = removeFirst.f6163a;
            if (bVar != null && activity != null) {
                bVar.f(activity);
            }
            boolean z3 = f6156a;
            if (!z) {
                q0.Y(new RunnableC0241a(), 600L);
            }
            return removeFirst;
        }
        return (d) invokeLZ.objValue;
    }

    public static c.a.n0.a.p.e.b h(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            c.a.n0.a.p.e.b bVar = f6158c.get(str != null ? str : "");
            if (bVar != null) {
                f6158c.remove(str);
            }
            return bVar;
        }
        return (c.a.n0.a.p.e.b) invokeL.objValue;
    }

    public static Context i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            if (context == null) {
                return c.a.n0.a.c1.a.b();
            }
            return ((context instanceof Activity) && ((Activity) context).isFinishing()) ? c.a.n0.a.c1.a.b() : context;
        }
        return (Context) invokeL.objValue;
    }

    public static void j(@NonNull d dVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65546, null, dVar, z) == null) {
            if (z && dVar.f6168f) {
                c.a.n0.a.h0.t.c.a.h(dVar.f6163a);
            }
            dVar.f6167e = System.currentTimeMillis();
            dVar.f6164b = true;
            if (dVar.f6165c.isEmpty()) {
                return;
            }
            Iterator<e> it = dVar.f6165c.iterator();
            while (it.hasNext()) {
                e next = it.next();
                if (next != null) {
                    next.onReady();
                }
            }
            dVar.f6165c.clear();
        }
    }

    public static void k(@NonNull d dVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65547, null, dVar, z) == null) {
            c.a.n0.a.e0.f.d.f.k().o(dVar.f6163a, new c(dVar, z));
        }
    }

    public static void l(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, context) == null) {
            if (f6157b.size() < 2) {
                boolean z = f6156a;
                f6157b.add(e(i(context), true));
            } else {
                boolean z2 = f6156a;
            }
            if (f6156a) {
                String str = "preloadSlaveManager size: " + f6157b.size();
            }
        }
    }

    public static void m(@NonNull String str, c.a.n0.a.p.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, str, bVar) == null) {
            Map<String, c.a.n0.a.p.e.b> map = f6158c;
            if (str == null) {
                str = "";
            }
            map.put(str, bVar);
        }
    }

    public static void n(d dVar, e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65550, null, dVar, eVar) == null) || eVar == null) {
            return;
        }
        if (dVar.f6164b) {
            eVar.onReady();
            return;
        }
        dVar.f6165c.add(eVar);
        dVar.f6168f = false;
    }
}
