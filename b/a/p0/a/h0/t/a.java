package b.a.p0.a.h0.t;

import android.app.Activity;
import android.content.Context;
import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.g1.f;
import b.a.p0.a.h0.u.g;
import b.a.p0.a.k;
import b.a.p0.a.v2.q0;
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
    public static final boolean f5771a;

    /* renamed from: b  reason: collision with root package name */
    public static LinkedList<d> f5772b;

    /* renamed from: c  reason: collision with root package name */
    public static Map<String, b.a.p0.a.p.e.b> f5773c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.a.p0.a.h0.t.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0246a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public RunnableC0246a() {
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
                boolean unused = a.f5771a;
                a.l(f.T().getActivity());
                boolean unused2 = a.f5771a;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b extends b.a.p0.a.h0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f5774a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f5775b;

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
            this.f5774a = dVar;
            this.f5775b = z;
        }

        @Override // b.a.p0.a.h0.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (a.f5771a) {
                    String str2 = "onPageFinished slaveId: " + this.f5774a.f5778a.b() + " url: " + str;
                }
                if (!b.a.p0.a.u1.a.a.C() || !g.M().f0()) {
                    a.j(this.f5774a, this.f5775b);
                } else {
                    a.k(this.f5774a, this.f5775b);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c implements ValueCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f5776a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f5777b;

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
            this.f5776a = dVar;
            this.f5777b = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (a.f5771a) {
                    String str2 = "slave onReceiveValue: " + str;
                }
                a.j(this.f5776a, this.f5777b);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public b.a.p0.a.p.e.b f5778a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f5779b;

        /* renamed from: c  reason: collision with root package name */
        public final ArrayList<e> f5780c;

        /* renamed from: d  reason: collision with root package name */
        public long f5781d;

        /* renamed from: e  reason: collision with root package name */
        public long f5782e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f5783f;

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
            this.f5780c = new ArrayList<>();
            this.f5783f = true;
        }
    }

    /* loaded from: classes.dex */
    public interface e {
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
        f5771a = k.f6397a;
        f5772b = new LinkedList<>();
        f5773c = new TreeMap();
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            f5772b.clear();
            f5773c.clear();
        }
    }

    public static d e(Context context, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(AdIconUtil.AD_TEXT_ID, null, context, z)) == null) {
            d dVar = new d();
            dVar.f5781d = System.currentTimeMillis();
            dVar.f5779b = false;
            dVar.f5778a = g.M().x0(context, new b(dVar, z));
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
            boolean z2 = f5771a;
            if (f5772b.isEmpty()) {
                return e(i(activity), false);
            }
            if (f5771a) {
                String str = "getPreloadSlaveManager : " + f5772b.getFirst();
            }
            d removeFirst = f5772b.removeFirst();
            b.a.p0.a.p.e.b bVar = removeFirst.f5778a;
            if (bVar != null && activity != null) {
                bVar.e(activity);
            }
            boolean z3 = f5771a;
            if (!z) {
                q0.Y(new RunnableC0246a(), 600L);
            }
            return removeFirst;
        }
        return (d) invokeLZ.objValue;
    }

    public static b.a.p0.a.p.e.b h(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            b.a.p0.a.p.e.b bVar = f5773c.get(str != null ? str : "");
            if (bVar != null) {
                f5773c.remove(str);
            }
            return bVar;
        }
        return (b.a.p0.a.p.e.b) invokeL.objValue;
    }

    public static Context i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            if (context == null) {
                return b.a.p0.a.c1.a.b();
            }
            return ((context instanceof Activity) && ((Activity) context).isFinishing()) ? b.a.p0.a.c1.a.b() : context;
        }
        return (Context) invokeL.objValue;
    }

    public static void j(@NonNull d dVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65546, null, dVar, z) == null) {
            if (z && dVar.f5783f) {
                b.a.p0.a.h0.t.c.a.h(dVar.f5778a);
            }
            dVar.f5782e = System.currentTimeMillis();
            dVar.f5779b = true;
            if (dVar.f5780c.isEmpty()) {
                return;
            }
            Iterator<e> it = dVar.f5780c.iterator();
            while (it.hasNext()) {
                e next = it.next();
                if (next != null) {
                    next.onReady();
                }
            }
            dVar.f5780c.clear();
        }
    }

    public static void k(@NonNull d dVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65547, null, dVar, z) == null) {
            b.a.p0.a.e0.f.d.f.k().o(dVar.f5778a, new c(dVar, z));
        }
    }

    public static void l(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, context) == null) {
            if (f5772b.size() < 2) {
                boolean z = f5771a;
                f5772b.add(e(i(context), true));
            } else {
                boolean z2 = f5771a;
            }
            if (f5771a) {
                String str = "preloadSlaveManager size: " + f5772b.size();
            }
        }
    }

    public static void m(@NonNull String str, b.a.p0.a.p.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, str, bVar) == null) {
            Map<String, b.a.p0.a.p.e.b> map = f5773c;
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
        if (dVar.f5779b) {
            eVar.onReady();
            return;
        }
        dVar.f5780c.add(eVar);
        dVar.f5783f = false;
    }
}
