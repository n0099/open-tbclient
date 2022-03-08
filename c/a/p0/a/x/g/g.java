package c.a.p0.a.x.g;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.c1.c;
import c.a.p0.r.a.a.m;
import c.a.p0.r.a.a.o;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.support.v4.app.Fragment;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.tieba.R;
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
    public static final boolean f8372e;

    /* renamed from: f  reason: collision with root package name */
    public static final Set<String> f8373f;

    /* renamed from: g  reason: collision with root package name */
    public static final int f8374g;

    /* renamed from: h  reason: collision with root package name */
    public static final int f8375h;

    /* renamed from: i  reason: collision with root package name */
    public static final int f8376i;
    public transient /* synthetic */ FieldHolder $fh;
    public m a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<d> f8377b;

    /* renamed from: c  reason: collision with root package name */
    public Queue<Runnable> f8378c;

    /* renamed from: d  reason: collision with root package name */
    public final List<a> f8379d;

    /* loaded from: classes.dex */
    public interface a {
        void a(@NonNull Fragment fragment);

        void b(@NonNull Fragment fragment);
    }

    /* loaded from: classes.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public o a;

        /* renamed from: b  reason: collision with root package name */
        public String f8380b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ g f8381c;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f8382e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d f8383f;

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
                this.f8382e = dVar;
                this.f8383f = dVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    d dVar = this.f8382e;
                    if (dVar != null && dVar.U()) {
                        this.f8382e.g1(false);
                    }
                    d dVar2 = this.f8382e;
                    if (dVar2 instanceof f) {
                        ((f) dVar2).T3();
                    }
                    this.f8383f.g1(true);
                }
            }
        }

        /* renamed from: c.a.p0.a.x.g.g$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0540b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f8384e;

            public RunnableC0540b(b bVar, d dVar) {
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
                this.f8384e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                d dVar;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (dVar = this.f8384e) == null) {
                    return;
                }
                dVar.g1(true);
            }
        }

        /* loaded from: classes.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f8385e;

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
                this.f8385e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                d dVar;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (dVar = this.f8385e) == null) {
                    return;
                }
                dVar.g1(false);
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
            this.f8381c = gVar;
            this.a = gVar.a.a();
            this.f8380b = str;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!TextUtils.isEmpty(this.f8380b)) {
                    f.O3(this.f8380b);
                }
                while (!this.f8381c.f8378c.isEmpty()) {
                    if (this.f8381c.f8378c.peek() != null) {
                        ((Runnable) this.f8381c.f8378c.poll()).run();
                    }
                }
                d();
                this.a.f();
            }
        }

        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                a();
                return this.f8381c.a.c();
            }
            return invokeV.booleanValue;
        }

        public void c(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
                o oVar = this.a;
                oVar.g(dVar);
                oVar.f();
                this.f8381c.a.c();
            }
        }

        public final void d() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f8381c.f8377b.isEmpty()) {
                return;
            }
            int size = this.f8381c.f8377b.size();
            boolean z = false;
            int i2 = size - 1;
            for (int i3 = i2; i3 >= 0; i3--) {
                if (i3 >= i2) {
                    if (g.f8372e) {
                        String str = "show fragment i " + i3 + " ,size: " + size;
                    }
                    this.a.j((Fragment) this.f8381c.f8377b.get(i3));
                    z = ((d) this.f8381c.f8377b.get(i3)).H0;
                } else if (z) {
                    this.a.j((Fragment) this.f8381c.f8377b.get(i3));
                    z = ((d) this.f8381c.f8377b.get(i3)).H0;
                } else {
                    this.a.g((Fragment) this.f8381c.f8377b.get(i3));
                }
            }
        }

        public final boolean e(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? g.f8373f.contains(str) : invokeL.booleanValue;
        }

        public b f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                List<Fragment> d2 = this.f8381c.a.d();
                if (d2 != null && d2.size() != this.f8381c.f8377b.size()) {
                    for (Fragment fragment : d2) {
                        if (fragment != null && !this.f8381c.f8377b.contains(fragment)) {
                            if (g.f8372e) {
                                String str = "popAllFragments remove: " + fragment;
                            }
                            for (a aVar : this.f8381c.f8379d) {
                                if (aVar != null) {
                                    aVar.b(fragment);
                                }
                            }
                            this.a.h(fragment);
                        }
                    }
                }
                h(this.f8381c.f8377b.size());
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
                if (this.f8381c.f8377b.isEmpty()) {
                    return this;
                }
                ArrayList arrayList = (ArrayList) this.f8381c.f8377b.clone();
                int size = arrayList.size();
                int i3 = size - i2;
                d dVar = (i3 < 0 || i2 <= 0) ? null : (d) arrayList.get(i3);
                while (true) {
                    size--;
                    if (size <= i3 - 1 || size < 0) {
                        break;
                    }
                    for (a aVar : this.f8381c.f8379d) {
                        if (aVar != null) {
                            aVar.b((Fragment) arrayList.get(size));
                        }
                    }
                    this.a.h((Fragment) arrayList.get(size));
                    this.f8381c.f8377b.remove(size);
                }
                this.f8381c.f8378c.offer(new c(this, dVar));
                r();
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                if (this.f8381c.f8377b.isEmpty()) {
                    return this;
                }
                ArrayList arrayList = (ArrayList) this.f8381c.f8377b.clone();
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (!((d) arrayList.get(size)).Y1()) {
                        this.a.h((Fragment) arrayList.get(size));
                        this.f8381c.f8377b.remove(size);
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
                this.a.b(R.id.ai_apps_container, dVar, "SwanAppFragment");
                this.f8381c.f8377b.add(dVar);
                for (a aVar : this.f8381c.f8379d) {
                    if (aVar != null) {
                        aVar.a(dVar);
                    }
                }
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b k(String str, c.a.p0.a.c1.b bVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, bVar)) == null) ? l(str, bVar, false) : (b) invokeLL.objValue;
        }

        @Nullable
        public b l(String str, c.a.p0.a.c1.b bVar, boolean z) {
            InterceptResult invokeLLZ;
            d T2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048587, this, str, bVar, z)) == null) {
                if ("about".equals(str)) {
                    T2 = c.a.p0.a.x.g.a.k3();
                } else if ("authority".equals(str)) {
                    T2 = c.a.p0.a.x.g.c.Z2();
                } else if ("pluginFunPage".equals(str)) {
                    T2 = h.S2(bVar.f4644g, bVar.f4643f);
                } else if (e(str)) {
                    T2 = l.W2(bVar, str);
                } else if (TextUtils.equals("settings", str)) {
                    T2 = j.P2();
                } else if ("normal".equals(str)) {
                    c.a aVar = new c.a();
                    aVar.d(bVar.f4642e);
                    aVar.e(bVar.f4643f);
                    aVar.b(bVar.f4644g);
                    aVar.c(z);
                    aVar.g(bVar.f4646i);
                    aVar.f(bVar.f4647j);
                    T2 = f.G3(aVar.a());
                } else {
                    T2 = "running_info".equals(str) ? i.T2() : null;
                }
                if (T2 == null) {
                    return null;
                }
                j(T2);
                return this;
            }
            return (b) invokeLLZ.objValue;
        }

        public b m(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
                int size = this.f8381c.f8377b.size();
                if (!this.f8381c.f8377b.isEmpty() && i2 >= 0 && i2 < size) {
                    this.a.h((d) this.f8381c.f8377b.remove(i2));
                }
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b n(int i2, int i3) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(1048589, this, i2, i3)) == null) {
                c.a.p0.a.p2.g.d(this.a, this.f8380b, i2, i3);
                return this;
            }
            return (b) invokeII.objValue;
        }

        public void o(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048590, this, dVar) == null) {
                o oVar = this.a;
                oVar.j(dVar);
                oVar.f();
                this.f8381c.a.c();
            }
        }

        public void p(List<d> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048591, this, list) == null) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    this.a.j(list.get(i2));
                }
                this.a.f();
                this.f8381c.a.c();
            }
        }

        public b q(c.a.p0.a.c1.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, bVar)) == null) {
                f l = this.f8381c.l();
                if (l != null) {
                    l.P3(bVar);
                    return this;
                }
                return k("normal", bVar);
            }
            return (b) invokeL.objValue;
        }

        public final void r() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
                this.f8381c.f8378c.offer(new RunnableC0540b(this, this.f8381c.m()));
            }
        }

        public final void s(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048594, this, dVar) == null) {
                this.f8381c.f8378c.offer(new a(this, this.f8381c.m(), dVar));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(78177354, "Lc/a/p0/a/x/g/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(78177354, "Lc/a/p0/a/x/g/g;");
                return;
            }
        }
        f8372e = c.a.p0.a.a.a;
        HashSet hashSet = new HashSet();
        f8373f = hashSet;
        f8374g = R.anim.aiapps_slide_in_from_right;
        f8375h = R.anim.aiapps_slide_out_to_right;
        f8376i = R.anim.aiapps_hold;
        hashSet.add("adLanding");
        f8373f.add("wxPay");
        f8373f.add("default_webview");
        f8373f.add("allianceLogin");
        f8373f.add("web_mode");
        f8373f.add("allianceChooseAddress");
        f8373f.add("qrCodePay");
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
        this.f8378c = new LinkedList();
        this.a = fragmentActivity.getSupportFragmentManager();
        this.f8377b = new ArrayList<>();
        this.f8379d = new CopyOnWriteArrayList();
    }

    public void g(@Nullable a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
            return;
        }
        this.f8379d.add(aVar);
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
            if (this.f8377b.isEmpty() || i2 < 0 || i2 >= this.f8377b.size()) {
                return null;
            }
            return this.f8377b.get(i2);
        }
        return (d) invokeI.objValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f8377b.size() : invokeV.intValue;
    }

    public f l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f8377b.isEmpty()) {
                return null;
            }
            int size = this.f8377b.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.f8377b.get(i2).Y1()) {
                    return (f) this.f8377b.get(i2);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? j(this.f8377b.size() - 1) : (d) invokeV.objValue;
    }

    @Nullable
    public <T extends d> T n(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, cls)) == null) {
            if (cls != null) {
                for (int size = this.f8377b.size() - 1; size >= 0; size--) {
                    T t = (T) this.f8377b.get(size);
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
            for (int size = this.f8377b.size() - 1; size >= 0; size--) {
                d dVar = this.f8377b.get(size);
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
        this.f8379d.remove(aVar);
    }
}
