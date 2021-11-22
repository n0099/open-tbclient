package b.a.p0.a.h0.g;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.m1.c;
import b.a.p0.r.a.a.m;
import b.a.p0.r.a.a.o;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.support.v4.app.Fragment;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes.dex */
public final class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f5476e;

    /* renamed from: f  reason: collision with root package name */
    public static final Set<String> f5477f;

    /* renamed from: g  reason: collision with root package name */
    public static final int f5478g;

    /* renamed from: h  reason: collision with root package name */
    public static final int f5479h;

    /* renamed from: i  reason: collision with root package name */
    public static final int f5480i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public m f5481a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<d> f5482b;

    /* renamed from: c  reason: collision with root package name */
    public Queue<Runnable> f5483c;

    /* renamed from: d  reason: collision with root package name */
    public final List<a> f5484d;

    /* loaded from: classes.dex */
    public interface a {
        void a(@NonNull Fragment fragment);

        void b(@NonNull Fragment fragment);
    }

    /* loaded from: classes.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public o f5485a;

        /* renamed from: b  reason: collision with root package name */
        public String f5486b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ g f5487c;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f5488e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d f5489f;

            public a(b bVar, d dVar, d dVar2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, dVar, dVar2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f5488e = dVar;
                this.f5489f = dVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    d dVar = this.f5488e;
                    if (dVar != null && dVar.c0()) {
                        this.f5488e.j1(false);
                    }
                    d dVar2 = this.f5488e;
                    if (dVar2 instanceof f) {
                        ((f) dVar2).W3();
                    }
                    this.f5489f.j1(true);
                }
            }
        }

        /* renamed from: b.a.p0.a.h0.g.g$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0217b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f5490e;

            public RunnableC0217b(b bVar, d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f5490e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                d dVar;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (dVar = this.f5490e) == null) {
                    return;
                }
                dVar.j1(true);
            }
        }

        /* loaded from: classes.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f5491e;

            public c(b bVar, d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f5491e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                d dVar;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (dVar = this.f5491e) == null) {
                    return;
                }
                dVar.j1(false);
            }
        }

        public b(g gVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5487c = gVar;
            this.f5485a = gVar.f5481a.a();
            this.f5486b = str;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!TextUtils.isEmpty(this.f5486b)) {
                    f.R3(this.f5486b);
                }
                while (!this.f5487c.f5483c.isEmpty()) {
                    if (this.f5487c.f5483c.peek() != null) {
                        ((Runnable) this.f5487c.f5483c.poll()).run();
                    }
                }
                d();
                this.f5485a.f();
            }
        }

        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                a();
                return this.f5487c.f5481a.c();
            }
            return invokeV.booleanValue;
        }

        public void c(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
                o oVar = this.f5485a;
                oVar.g(dVar);
                oVar.f();
                this.f5487c.f5481a.c();
            }
        }

        public final void d() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f5487c.f5482b.isEmpty()) {
                return;
            }
            int size = this.f5487c.f5482b.size();
            boolean z = false;
            int i2 = size - 1;
            for (int i3 = i2; i3 >= 0; i3--) {
                if (i3 >= i2) {
                    if (g.f5476e) {
                        String str = "show fragment i " + i3 + " ,size: " + size;
                    }
                    this.f5485a.j((Fragment) this.f5487c.f5482b.get(i3));
                    z = ((d) this.f5487c.f5482b.get(i3)).G0;
                } else if (z) {
                    this.f5485a.j((Fragment) this.f5487c.f5482b.get(i3));
                    z = ((d) this.f5487c.f5482b.get(i3)).G0;
                } else {
                    this.f5485a.g((Fragment) this.f5487c.f5482b.get(i3));
                }
            }
        }

        public final boolean e(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? g.f5477f.contains(str) : invokeL.booleanValue;
        }

        public b f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                List<Fragment> d2 = this.f5487c.f5481a.d();
                if (d2 != null && d2.size() != this.f5487c.f5482b.size()) {
                    for (Fragment fragment : d2) {
                        if (fragment != null && !this.f5487c.f5482b.contains(fragment)) {
                            if (g.f5476e) {
                                String str = "popAllFragments remove: " + fragment;
                            }
                            for (a aVar : this.f5487c.f5484d) {
                                if (aVar != null) {
                                    aVar.b(fragment);
                                }
                            }
                            this.f5485a.h(fragment);
                        }
                    }
                }
                h(this.f5487c.f5482b.size());
                return this;
            }
            return (b) invokeV.objValue;
        }

        public b g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                h(1);
                return this;
            }
            return (b) invokeV.objValue;
        }

        public b h(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
                if (this.f5487c.f5482b.isEmpty()) {
                    return this;
                }
                ArrayList arrayList = (ArrayList) this.f5487c.f5482b.clone();
                int size = arrayList.size();
                int i3 = size - i2;
                d dVar = (i3 < 0 || i2 <= 0) ? null : (d) arrayList.get(i3);
                while (true) {
                    size--;
                    if (size <= i3 - 1 || size < 0) {
                        break;
                    }
                    for (a aVar : this.f5487c.f5484d) {
                        if (aVar != null) {
                            aVar.b((Fragment) arrayList.get(size));
                        }
                    }
                    this.f5485a.h((Fragment) arrayList.get(size));
                    this.f5487c.f5482b.remove(size);
                }
                this.f5487c.f5483c.offer(new c(this, dVar));
                r();
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                if (this.f5487c.f5482b.isEmpty()) {
                    return this;
                }
                ArrayList arrayList = (ArrayList) this.f5487c.f5482b.clone();
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (!((d) arrayList.get(size)).b2()) {
                        this.f5485a.h((Fragment) arrayList.get(size));
                        this.f5487c.f5482b.remove(size);
                    }
                }
                r();
                return this;
            }
            return (b) invokeV.objValue;
        }

        public b j(d dVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, dVar)) == null) {
                s(dVar);
                this.f5485a.b(b.a.p0.a.f.ai_apps_container, dVar, "SwanAppFragment");
                this.f5487c.f5482b.add(dVar);
                for (a aVar : this.f5487c.f5484d) {
                    if (aVar != null) {
                        aVar.a(dVar);
                    }
                }
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b k(String str, b.a.p0.a.m1.b bVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, bVar)) == null) ? l(str, bVar, false) : (b) invokeLL.objValue;
        }

        @Nullable
        public b l(String str, b.a.p0.a.m1.b bVar, boolean z) {
            InterceptResult invokeLLZ;
            d W2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048587, this, str, bVar, z)) == null) {
                if ("about".equals(str)) {
                    W2 = b.a.p0.a.h0.g.a.n3();
                } else if ("authority".equals(str)) {
                    W2 = b.a.p0.a.h0.g.c.c3();
                } else if ("pluginFunPage".equals(str)) {
                    W2 = h.V2(bVar.f7016g, bVar.f7015f);
                } else if (e(str)) {
                    W2 = l.Z2(bVar, str);
                } else if (TextUtils.equals("settings", str)) {
                    W2 = j.S2();
                } else if ("normal".equals(str)) {
                    c.a aVar = new c.a();
                    aVar.d(bVar.f7014e);
                    aVar.e(bVar.f7015f);
                    aVar.b(bVar.f7016g);
                    aVar.c(z);
                    aVar.g(bVar.f7018i);
                    aVar.f(bVar.j);
                    W2 = f.J3(aVar.a());
                } else {
                    W2 = "running_info".equals(str) ? i.W2() : null;
                }
                if (W2 == null) {
                    return null;
                }
                j(W2);
                return this;
            }
            return (b) invokeLLZ.objValue;
        }

        public b m(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
                int size = this.f5487c.f5482b.size();
                if (!this.f5487c.f5482b.isEmpty() && i2 >= 0 && i2 < size) {
                    this.f5485a.h((d) this.f5487c.f5482b.remove(i2));
                }
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b n(int i2, int i3) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(1048589, this, i2, i3)) == null) {
                b.a.p0.a.z2.g.d(this.f5485a, this.f5486b, i2, i3);
                return this;
            }
            return (b) invokeII.objValue;
        }

        public void o(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048590, this, dVar) == null) {
                o oVar = this.f5485a;
                oVar.j(dVar);
                oVar.f();
                this.f5487c.f5481a.c();
            }
        }

        public void p(List<d> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048591, this, list) == null) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    this.f5485a.j(list.get(i2));
                }
                this.f5485a.f();
                this.f5487c.f5481a.c();
            }
        }

        public b q(b.a.p0.a.m1.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, bVar)) == null) {
                f l = this.f5487c.l();
                if (l != null) {
                    l.S3(bVar);
                    return this;
                }
                return k("normal", bVar);
            }
            return (b) invokeL.objValue;
        }

        public final void r() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
                this.f5487c.f5483c.offer(new RunnableC0217b(this, this.f5487c.m()));
            }
        }

        public final void s(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048594, this, dVar) == null) {
                this.f5487c.f5483c.offer(new a(this, this.f5487c.m(), dVar));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1597403021, "Lb/a/p0/a/h0/g/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1597403021, "Lb/a/p0/a/h0/g/g;");
                return;
            }
        }
        f5476e = b.a.p0.a.k.f6863a;
        f5477f = new HashSet();
        f5478g = b.a.p0.a.a.aiapps_slide_in_from_right;
        f5479h = b.a.p0.a.a.aiapps_slide_out_to_right;
        f5480i = b.a.p0.a.a.aiapps_hold;
        f5477f.add("adLanding");
        f5477f.add("wxPay");
        f5477f.add("default_webview");
        f5477f.add("allianceLogin");
        f5477f.add("web_mode");
        f5477f.add("allianceChooseAddress");
        f5477f.add("qrCodePay");
    }

    public g(FragmentActivity fragmentActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fragmentActivity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f5483c = new LinkedList();
        this.f5481a = fragmentActivity.getSupportFragmentManager();
        this.f5482b = new ArrayList<>();
        this.f5484d = new CopyOnWriteArrayList();
    }

    public void g(@Nullable a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
            return;
        }
        this.f5484d.add(aVar);
    }

    public b h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new b(this, "") : (b) invokeV.objValue;
    }

    public b i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? new b(this, str) : (b) invokeL.objValue;
    }

    public d j(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            if (this.f5482b.isEmpty() || i2 < 0 || i2 >= this.f5482b.size()) {
                return null;
            }
            return this.f5482b.get(i2);
        }
        return (d) invokeI.objValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f5482b.size() : invokeV.intValue;
    }

    public f l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f5482b.isEmpty()) {
                return null;
            }
            int size = this.f5482b.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.f5482b.get(i2).b2()) {
                    return (f) this.f5482b.get(i2);
                }
            }
            return null;
        }
        return (f) invokeV.objValue;
    }

    @Nullable
    public d m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? j(this.f5482b.size() - 1) : (d) invokeV.objValue;
    }

    @Nullable
    public <T extends d> T n(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, cls)) == null) {
            if (cls != null) {
                for (int size = this.f5482b.size() - 1; size >= 0; size--) {
                    T t = (T) this.f5482b.get(size);
                    if (t.getClass() == cls) {
                        return t;
                    }
                }
                return null;
            }
            return null;
        }
        return (T) invokeL.objValue;
    }

    public f o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            for (int size = this.f5482b.size() - 1; size >= 0; size--) {
                d dVar = this.f5482b.get(size);
                if (dVar instanceof f) {
                    return (f) dVar;
                }
            }
            return null;
        }
        return (f) invokeV.objValue;
    }

    public void p(@Nullable a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) || aVar == null) {
            return;
        }
        this.f5484d.remove(aVar);
    }
}
