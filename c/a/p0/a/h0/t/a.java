package c.a.p0.a.h0.t;

import android.app.Activity;
import android.content.Context;
import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.g1.f;
import c.a.p0.a.h0.u.g;
import c.a.p0.a.k;
import c.a.p0.a.v2.q0;
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
    public static final boolean f6430a;

    /* renamed from: b  reason: collision with root package name */
    public static LinkedList<d> f6431b;

    /* renamed from: c  reason: collision with root package name */
    public static Map<String, c.a.p0.a.p.e.b> f6432c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.p0.a.h0.t.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0251a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public RunnableC0251a() {
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
                boolean unused = a.f6430a;
                a.l(f.V().getActivity());
                boolean unused2 = a.f6430a;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b extends c.a.p0.a.h0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f6433a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f6434b;

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
            this.f6433a = dVar;
            this.f6434b = z;
        }

        @Override // c.a.p0.a.h0.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (a.f6430a) {
                    String str2 = "onPageFinished slaveId: " + this.f6433a.f6437a.c() + " url: " + str;
                }
                if (!c.a.p0.a.u1.a.a.C() || !g.N().g0()) {
                    a.j(this.f6433a, this.f6434b);
                } else {
                    a.k(this.f6433a, this.f6434b);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c implements ValueCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f6435a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f6436b;

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
            this.f6435a = dVar;
            this.f6436b = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (a.f6430a) {
                    String str2 = "slave onReceiveValue: " + str;
                }
                a.j(this.f6435a, this.f6436b);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public c.a.p0.a.p.e.b f6437a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f6438b;

        /* renamed from: c  reason: collision with root package name */
        public final ArrayList<e> f6439c;

        /* renamed from: d  reason: collision with root package name */
        public long f6440d;

        /* renamed from: e  reason: collision with root package name */
        public long f6441e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f6442f;

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
            this.f6439c = new ArrayList<>();
            this.f6442f = true;
        }
    }

    /* loaded from: classes.dex */
    public interface e {
        void onReady();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1087255941, "Lc/a/p0/a/h0/t/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1087255941, "Lc/a/p0/a/h0/t/a;");
                return;
            }
        }
        f6430a = k.f7077a;
        f6431b = new LinkedList<>();
        f6432c = new TreeMap();
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            f6431b.clear();
            f6432c.clear();
        }
    }

    public static d e(Context context, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(AdIconUtil.AD_TEXT_ID, null, context, z)) == null) {
            d dVar = new d();
            dVar.f6440d = System.currentTimeMillis();
            dVar.f6438b = false;
            dVar.f6437a = g.N().y0(context, new b(dVar, z));
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
            boolean z2 = f6430a;
            if (f6431b.isEmpty()) {
                return e(i(activity), false);
            }
            if (f6430a) {
                String str = "getPreloadSlaveManager : " + f6431b.getFirst();
            }
            d removeFirst = f6431b.removeFirst();
            c.a.p0.a.p.e.b bVar = removeFirst.f6437a;
            if (bVar != null && activity != null) {
                bVar.f(activity);
            }
            boolean z3 = f6430a;
            if (!z) {
                q0.Y(new RunnableC0251a(), 600L);
            }
            return removeFirst;
        }
        return (d) invokeLZ.objValue;
    }

    public static c.a.p0.a.p.e.b h(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            c.a.p0.a.p.e.b bVar = f6432c.get(str != null ? str : "");
            if (bVar != null) {
                f6432c.remove(str);
            }
            return bVar;
        }
        return (c.a.p0.a.p.e.b) invokeL.objValue;
    }

    public static Context i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            if (context == null) {
                return c.a.p0.a.c1.a.b();
            }
            return ((context instanceof Activity) && ((Activity) context).isFinishing()) ? c.a.p0.a.c1.a.b() : context;
        }
        return (Context) invokeL.objValue;
    }

    public static void j(@NonNull d dVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65546, null, dVar, z) == null) {
            if (z && dVar.f6442f) {
                c.a.p0.a.h0.t.c.a.h(dVar.f6437a);
            }
            dVar.f6441e = System.currentTimeMillis();
            dVar.f6438b = true;
            if (dVar.f6439c.isEmpty()) {
                return;
            }
            Iterator<e> it = dVar.f6439c.iterator();
            while (it.hasNext()) {
                e next = it.next();
                if (next != null) {
                    next.onReady();
                }
            }
            dVar.f6439c.clear();
        }
    }

    public static void k(@NonNull d dVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65547, null, dVar, z) == null) {
            c.a.p0.a.e0.f.d.f.k().o(dVar.f6437a, new c(dVar, z));
        }
    }

    public static void l(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, context) == null) {
            if (f6431b.size() < 2) {
                boolean z = f6430a;
                f6431b.add(e(i(context), true));
            } else {
                boolean z2 = f6430a;
            }
            if (f6430a) {
                String str = "preloadSlaveManager size: " + f6431b.size();
            }
        }
    }

    public static void m(@NonNull String str, c.a.p0.a.p.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, str, bVar) == null) {
            Map<String, c.a.p0.a.p.e.b> map = f6432c;
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
        if (dVar.f6438b) {
            eVar.onReady();
            return;
        }
        dVar.f6439c.add(eVar);
        dVar.f6442f = false;
    }
}
