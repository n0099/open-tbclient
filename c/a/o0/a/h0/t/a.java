package c.a.o0.a.h0.t;

import android.app.Activity;
import android.content.Context;
import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.a.g1.f;
import c.a.o0.a.h0.u.g;
import c.a.o0.a.k;
import c.a.o0.a.v2.q0;
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
    public static final boolean f6402a;

    /* renamed from: b  reason: collision with root package name */
    public static LinkedList<d> f6403b;

    /* renamed from: c  reason: collision with root package name */
    public static Map<String, c.a.o0.a.p.e.b> f6404c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.o0.a.h0.t.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0249a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public RunnableC0249a() {
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
                boolean unused = a.f6402a;
                a.l(f.V().getActivity());
                boolean unused2 = a.f6402a;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b extends c.a.o0.a.h0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f6405a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f6406b;

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
            this.f6405a = dVar;
            this.f6406b = z;
        }

        @Override // c.a.o0.a.h0.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (a.f6402a) {
                    String str2 = "onPageFinished slaveId: " + this.f6405a.f6409a.c() + " url: " + str;
                }
                if (!c.a.o0.a.u1.a.a.C() || !g.N().g0()) {
                    a.j(this.f6405a, this.f6406b);
                } else {
                    a.k(this.f6405a, this.f6406b);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c implements ValueCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f6407a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f6408b;

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
            this.f6407a = dVar;
            this.f6408b = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (a.f6402a) {
                    String str2 = "slave onReceiveValue: " + str;
                }
                a.j(this.f6407a, this.f6408b);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public c.a.o0.a.p.e.b f6409a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f6410b;

        /* renamed from: c  reason: collision with root package name */
        public final ArrayList<e> f6411c;

        /* renamed from: d  reason: collision with root package name */
        public long f6412d;

        /* renamed from: e  reason: collision with root package name */
        public long f6413e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f6414f;

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
            this.f6411c = new ArrayList<>();
            this.f6414f = true;
        }
    }

    /* loaded from: classes.dex */
    public interface e {
        void onReady();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(958173222, "Lc/a/o0/a/h0/t/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(958173222, "Lc/a/o0/a/h0/t/a;");
                return;
            }
        }
        f6402a = k.f7049a;
        f6403b = new LinkedList<>();
        f6404c = new TreeMap();
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            f6403b.clear();
            f6404c.clear();
        }
    }

    public static d e(Context context, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(AdIconUtil.AD_TEXT_ID, null, context, z)) == null) {
            d dVar = new d();
            dVar.f6412d = System.currentTimeMillis();
            dVar.f6410b = false;
            dVar.f6409a = g.N().y0(context, new b(dVar, z));
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
            boolean z2 = f6402a;
            if (f6403b.isEmpty()) {
                return e(i(activity), false);
            }
            if (f6402a) {
                String str = "getPreloadSlaveManager : " + f6403b.getFirst();
            }
            d removeFirst = f6403b.removeFirst();
            c.a.o0.a.p.e.b bVar = removeFirst.f6409a;
            if (bVar != null && activity != null) {
                bVar.f(activity);
            }
            boolean z3 = f6402a;
            if (!z) {
                q0.Y(new RunnableC0249a(), 600L);
            }
            return removeFirst;
        }
        return (d) invokeLZ.objValue;
    }

    public static c.a.o0.a.p.e.b h(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            c.a.o0.a.p.e.b bVar = f6404c.get(str != null ? str : "");
            if (bVar != null) {
                f6404c.remove(str);
            }
            return bVar;
        }
        return (c.a.o0.a.p.e.b) invokeL.objValue;
    }

    public static Context i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            if (context == null) {
                return c.a.o0.a.c1.a.b();
            }
            return ((context instanceof Activity) && ((Activity) context).isFinishing()) ? c.a.o0.a.c1.a.b() : context;
        }
        return (Context) invokeL.objValue;
    }

    public static void j(@NonNull d dVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65546, null, dVar, z) == null) {
            if (z && dVar.f6414f) {
                c.a.o0.a.h0.t.c.a.h(dVar.f6409a);
            }
            dVar.f6413e = System.currentTimeMillis();
            dVar.f6410b = true;
            if (dVar.f6411c.isEmpty()) {
                return;
            }
            Iterator<e> it = dVar.f6411c.iterator();
            while (it.hasNext()) {
                e next = it.next();
                if (next != null) {
                    next.onReady();
                }
            }
            dVar.f6411c.clear();
        }
    }

    public static void k(@NonNull d dVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65547, null, dVar, z) == null) {
            c.a.o0.a.e0.f.d.f.k().o(dVar.f6409a, new c(dVar, z));
        }
    }

    public static void l(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, context) == null) {
            if (f6403b.size() < 2) {
                boolean z = f6402a;
                f6403b.add(e(i(context), true));
            } else {
                boolean z2 = f6402a;
            }
            if (f6402a) {
                String str = "preloadSlaveManager size: " + f6403b.size();
            }
        }
    }

    public static void m(@NonNull String str, c.a.o0.a.p.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, str, bVar) == null) {
            Map<String, c.a.o0.a.p.e.b> map = f6404c;
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
        if (dVar.f6410b) {
            eVar.onReady();
            return;
        }
        dVar.f6411c.add(eVar);
        dVar.f6414f = false;
    }
}
