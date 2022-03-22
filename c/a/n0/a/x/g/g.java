package c.a.n0.a.x.g;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.c1.c;
import c.a.n0.r.a.a.m;
import c.a.n0.r.a.a.o;
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
    public static final boolean f7046e;

    /* renamed from: f  reason: collision with root package name */
    public static final Set<String> f7047f;

    /* renamed from: g  reason: collision with root package name */
    public static final int f7048g;

    /* renamed from: h  reason: collision with root package name */
    public static final int f7049h;
    public static final int i;
    public transient /* synthetic */ FieldHolder $fh;
    public m a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<d> f7050b;

    /* renamed from: c  reason: collision with root package name */
    public Queue<Runnable> f7051c;

    /* renamed from: d  reason: collision with root package name */
    public final List<a> f7052d;

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
        public String f7053b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ g f7054c;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ d f7055b;

            public a(b bVar, d dVar, d dVar2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, dVar, dVar2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dVar;
                this.f7055b = dVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    d dVar = this.a;
                    if (dVar != null && dVar.O()) {
                        this.a.k1(false);
                    }
                    d dVar2 = this.a;
                    if (dVar2 instanceof f) {
                        ((f) dVar2).X3();
                    }
                    this.f7055b.k1(true);
                }
            }
        }

        /* renamed from: c.a.n0.a.x.g.g$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0532b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            public RunnableC0532b(b bVar, d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                d dVar;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (dVar = this.a) == null) {
                    return;
                }
                dVar.k1(true);
            }
        }

        /* loaded from: classes.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            public c(b bVar, d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                d dVar;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (dVar = this.a) == null) {
                    return;
                }
                dVar.k1(false);
            }
        }

        public b(g gVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7054c = gVar;
            this.a = gVar.a.a();
            this.f7053b = str;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!TextUtils.isEmpty(this.f7053b)) {
                    f.S3(this.f7053b);
                }
                while (!this.f7054c.f7051c.isEmpty()) {
                    if (this.f7054c.f7051c.peek() != null) {
                        ((Runnable) this.f7054c.f7051c.poll()).run();
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
                return this.f7054c.a.c();
            }
            return invokeV.booleanValue;
        }

        public void c(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
                o oVar = this.a;
                oVar.g(dVar);
                oVar.f();
                this.f7054c.a.c();
            }
        }

        public final void d() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f7054c.f7050b.isEmpty()) {
                return;
            }
            int size = this.f7054c.f7050b.size();
            boolean z = false;
            int i = size - 1;
            for (int i2 = i; i2 >= 0; i2--) {
                if (i2 >= i) {
                    if (g.f7046e) {
                        Log.d("SwanAppFragmentManager", "show fragment i " + i2 + " ,size: " + size);
                    }
                    this.a.j((Fragment) this.f7054c.f7050b.get(i2));
                    z = ((d) this.f7054c.f7050b.get(i2)).D0;
                } else if (z) {
                    this.a.j((Fragment) this.f7054c.f7050b.get(i2));
                    z = ((d) this.f7054c.f7050b.get(i2)).D0;
                } else {
                    this.a.g((Fragment) this.f7054c.f7050b.get(i2));
                }
            }
        }

        public final boolean e(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? g.f7047f.contains(str) : invokeL.booleanValue;
        }

        public b f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                List<Fragment> d2 = this.f7054c.a.d();
                if (d2 != null && d2.size() != this.f7054c.f7050b.size()) {
                    for (Fragment fragment : d2) {
                        if (fragment != null && !this.f7054c.f7050b.contains(fragment)) {
                            if (g.f7046e) {
                                Log.d("SwanAppFragmentManager", "popAllFragments remove: " + fragment);
                            }
                            for (a aVar : this.f7054c.f7052d) {
                                if (aVar != null) {
                                    aVar.b(fragment);
                                }
                            }
                            this.a.h(fragment);
                        }
                    }
                }
                h(this.f7054c.f7050b.size());
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

        public b h(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
                if (this.f7054c.f7050b.isEmpty()) {
                    return this;
                }
                ArrayList arrayList = (ArrayList) this.f7054c.f7050b.clone();
                int size = arrayList.size();
                int i2 = size - i;
                d dVar = (i2 < 0 || i <= 0) ? null : (d) arrayList.get(i2);
                while (true) {
                    size--;
                    if (size <= i2 - 1 || size < 0) {
                        break;
                    }
                    for (a aVar : this.f7054c.f7052d) {
                        if (aVar != null) {
                            aVar.b((Fragment) arrayList.get(size));
                        }
                    }
                    this.a.h((Fragment) arrayList.get(size));
                    this.f7054c.f7050b.remove(size);
                }
                this.f7054c.f7051c.offer(new c(this, dVar));
                r();
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                if (this.f7054c.f7050b.isEmpty()) {
                    return this;
                }
                ArrayList arrayList = (ArrayList) this.f7054c.f7050b.clone();
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (!((d) arrayList.get(size)).c2()) {
                        this.a.h((Fragment) arrayList.get(size));
                        this.f7054c.f7050b.remove(size);
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
                this.a.b(R.id.obfuscated_res_0x7f090171, dVar, "SwanAppFragment");
                this.f7054c.f7050b.add(dVar);
                for (a aVar : this.f7054c.f7052d) {
                    if (aVar != null) {
                        aVar.a(dVar);
                    }
                }
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b k(String str, c.a.n0.a.c1.b bVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, bVar)) == null) ? l(str, bVar, false) : (b) invokeLL.objValue;
        }

        @Nullable
        public b l(String str, c.a.n0.a.c1.b bVar, boolean z) {
            InterceptResult invokeLLZ;
            d X2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048587, this, str, bVar, z)) == null) {
                if ("about".equals(str)) {
                    X2 = c.a.n0.a.x.g.a.o3();
                } else if ("authority".equals(str)) {
                    X2 = c.a.n0.a.x.g.c.d3();
                } else if ("pluginFunPage".equals(str)) {
                    X2 = h.W2(bVar.f3948c, bVar.f3947b);
                } else if (e(str)) {
                    X2 = l.a3(bVar, str);
                } else if (TextUtils.equals("settings", str)) {
                    X2 = j.T2();
                } else if ("normal".equals(str)) {
                    c.a aVar = new c.a();
                    aVar.d(bVar.a);
                    aVar.e(bVar.f3947b);
                    aVar.b(bVar.f3948c);
                    aVar.c(z);
                    aVar.g(bVar.f3950e);
                    aVar.f(bVar.f3951f);
                    X2 = f.K3(aVar.a());
                } else {
                    X2 = "running_info".equals(str) ? i.X2() : null;
                }
                if (X2 == null) {
                    return null;
                }
                j(X2);
                return this;
            }
            return (b) invokeLLZ.objValue;
        }

        public b m(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
                int size = this.f7054c.f7050b.size();
                if (!this.f7054c.f7050b.isEmpty() && i >= 0 && i < size) {
                    this.a.h((d) this.f7054c.f7050b.remove(i));
                }
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b n(int i, int i2) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(1048589, this, i, i2)) == null) {
                c.a.n0.a.p2.g.d(this.a, this.f7053b, i, i2);
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
                this.f7054c.a.c();
            }
        }

        public void p(List<d> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048591, this, list) == null) {
                for (int i = 0; i < list.size(); i++) {
                    this.a.j(list.get(i));
                }
                this.a.f();
                this.f7054c.a.c();
            }
        }

        public b q(c.a.n0.a.c1.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, bVar)) == null) {
                f l = this.f7054c.l();
                if (l != null) {
                    l.T3(bVar);
                    return this;
                }
                return k("normal", bVar);
            }
            return (b) invokeL.objValue;
        }

        public final void r() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
                this.f7054c.f7051c.offer(new RunnableC0532b(this, this.f7054c.m()));
            }
        }

        public final void s(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048594, this, dVar) == null) {
                this.f7054c.f7051c.offer(new a(this, this.f7054c.m(), dVar));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-622887224, "Lc/a/n0/a/x/g/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-622887224, "Lc/a/n0/a/x/g/g;");
                return;
            }
        }
        f7046e = c.a.n0.a.a.a;
        HashSet hashSet = new HashSet();
        f7047f = hashSet;
        f7048g = R.anim.obfuscated_res_0x7f010022;
        f7049h = R.anim.obfuscated_res_0x7f010025;
        i = R.anim.obfuscated_res_0x7f01001c;
        hashSet.add("adLanding");
        f7047f.add("wxPay");
        f7047f.add("default_webview");
        f7047f.add("allianceLogin");
        f7047f.add("web_mode");
        f7047f.add("allianceChooseAddress");
        f7047f.add("qrCodePay");
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
        this.f7051c = new LinkedList();
        this.a = fragmentActivity.getSupportFragmentManager();
        this.f7050b = new ArrayList<>();
        this.f7052d = new CopyOnWriteArrayList();
    }

    public void g(@Nullable a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
            return;
        }
        this.f7052d.add(aVar);
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
            if (this.f7050b.isEmpty() || i2 < 0 || i2 >= this.f7050b.size()) {
                return null;
            }
            return this.f7050b.get(i2);
        }
        return (d) invokeI.objValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f7050b.size() : invokeV.intValue;
    }

    public f l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f7050b.isEmpty()) {
                return null;
            }
            int size = this.f7050b.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.f7050b.get(i2).c2()) {
                    return (f) this.f7050b.get(i2);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? j(this.f7050b.size() - 1) : (d) invokeV.objValue;
    }

    @Nullable
    public <T extends d> T n(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, cls)) == null) {
            if (cls != null) {
                for (int size = this.f7050b.size() - 1; size >= 0; size--) {
                    T t = (T) this.f7050b.get(size);
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
            for (int size = this.f7050b.size() - 1; size >= 0; size--) {
                d dVar = this.f7050b.get(size);
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
        this.f7052d.remove(aVar);
    }
}
