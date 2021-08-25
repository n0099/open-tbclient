package c.a.o0.a.h0.g;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.a.l1.c;
import c.a.o0.o.a.a.l;
import c.a.o0.o.a.a.n;
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
    public static final boolean f5898e;

    /* renamed from: f  reason: collision with root package name */
    public static final Set<String> f5899f;

    /* renamed from: g  reason: collision with root package name */
    public static final int f5900g;

    /* renamed from: h  reason: collision with root package name */
    public static final int f5901h;

    /* renamed from: i  reason: collision with root package name */
    public static final int f5902i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public l f5903a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<d> f5904b;

    /* renamed from: c  reason: collision with root package name */
    public Queue<Runnable> f5905c;

    /* renamed from: d  reason: collision with root package name */
    public final List<a> f5906d;

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
        public n f5907a;

        /* renamed from: b  reason: collision with root package name */
        public String f5908b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ g f5909c;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f5910e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d f5911f;

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
                this.f5910e = dVar;
                this.f5911f = dVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    d dVar = this.f5910e;
                    if (dVar != null && dVar.e0()) {
                        this.f5910e.k1(false);
                    }
                    d dVar2 = this.f5910e;
                    if (dVar2 instanceof f) {
                        ((f) dVar2).I3();
                    }
                    this.f5911f.k1(true);
                }
            }
        }

        /* renamed from: c.a.o0.a.h0.g.g$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0213b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f5912e;

            public RunnableC0213b(b bVar, d dVar) {
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
                this.f5912e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                d dVar;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (dVar = this.f5912e) == null) {
                    return;
                }
                dVar.k1(true);
            }
        }

        /* loaded from: classes.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f5913e;

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
                this.f5913e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                d dVar;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (dVar = this.f5913e) == null) {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5909c = gVar;
            this.f5907a = gVar.f5903a.a();
            this.f5908b = str;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!TextUtils.isEmpty(this.f5908b)) {
                    f.D3(this.f5908b);
                }
                while (!this.f5909c.f5905c.isEmpty()) {
                    if (this.f5909c.f5905c.peek() != null) {
                        ((Runnable) this.f5909c.f5905c.poll()).run();
                    }
                }
                d();
                this.f5907a.e();
            }
        }

        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                a();
                return this.f5909c.f5903a.c();
            }
            return invokeV.booleanValue;
        }

        public void c(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
                n nVar = this.f5907a;
                nVar.f(dVar);
                nVar.e();
                this.f5909c.f5903a.c();
            }
        }

        public final void d() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f5909c.f5904b.isEmpty()) {
                return;
            }
            int size = this.f5909c.f5904b.size();
            int i2 = size - 1;
            for (int i3 = i2; i3 >= 0; i3--) {
                if (i3 >= i2) {
                    if (g.f5898e) {
                        String str = "show fragment i " + i3 + " ,size: " + size;
                    }
                    this.f5907a.i((Fragment) this.f5909c.f5904b.get(i3));
                } else {
                    this.f5907a.f((Fragment) this.f5909c.f5904b.get(i3));
                }
            }
        }

        public final boolean e(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? g.f5899f.contains(str) : invokeL.booleanValue;
        }

        public b f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                List<Fragment> d2 = this.f5909c.f5903a.d();
                if (d2 != null && d2.size() != this.f5909c.f5904b.size()) {
                    for (Fragment fragment : d2) {
                        if (fragment != null && !this.f5909c.f5904b.contains(fragment)) {
                            if (g.f5898e) {
                                String str = "popAllFragments remove: " + fragment;
                            }
                            for (a aVar : this.f5909c.f5906d) {
                                if (aVar != null) {
                                    aVar.b(fragment);
                                }
                            }
                            this.f5907a.g(fragment);
                        }
                    }
                }
                h(this.f5909c.f5904b.size());
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
                if (this.f5909c.f5904b.isEmpty()) {
                    return this;
                }
                ArrayList arrayList = (ArrayList) this.f5909c.f5904b.clone();
                int size = arrayList.size();
                int i3 = size - i2;
                d dVar = (i3 < 0 || i2 <= 0) ? null : (d) arrayList.get(i3);
                while (true) {
                    size--;
                    if (size <= i3 - 1 || size < 0) {
                        break;
                    }
                    for (a aVar : this.f5909c.f5906d) {
                        if (aVar != null) {
                            aVar.b((Fragment) arrayList.get(size));
                        }
                    }
                    this.f5907a.g((Fragment) arrayList.get(size));
                    this.f5909c.f5904b.remove(size);
                }
                this.f5909c.f5905c.offer(new c(this, dVar));
                q();
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                if (this.f5909c.f5904b.isEmpty()) {
                    return this;
                }
                ArrayList arrayList = (ArrayList) this.f5909c.f5904b.clone();
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (!((d) arrayList.get(size)).X1()) {
                        this.f5907a.g((Fragment) arrayList.get(size));
                        this.f5909c.f5904b.remove(size);
                    }
                }
                q();
                return this;
            }
            return (b) invokeV.objValue;
        }

        public b j(d dVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, dVar)) == null) {
                r(dVar);
                this.f5907a.b(c.a.o0.a.f.ai_apps_container, dVar, "SwanAppFragment");
                this.f5909c.f5904b.add(dVar);
                for (a aVar : this.f5909c.f5906d) {
                    if (aVar != null) {
                        aVar.a(dVar);
                    }
                }
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b k(String str, c.a.o0.a.l1.b bVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, bVar)) == null) ? l(str, bVar, false) : (b) invokeLL.objValue;
        }

        @Nullable
        public b l(String str, c.a.o0.a.l1.b bVar, boolean z) {
            InterceptResult invokeLLZ;
            d K2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048587, this, str, bVar, z)) == null) {
                if ("about".equals(str)) {
                    K2 = c.a.o0.a.h0.g.a.b3();
                } else if ("authority".equals(str)) {
                    K2 = c.a.o0.a.h0.g.c.Q2();
                } else if ("pluginFunPage".equals(str)) {
                    K2 = h.J2(bVar.f7210g, bVar.f7209f);
                } else if (e(str)) {
                    K2 = k.N2(bVar, str);
                } else if (TextUtils.equals("settings", str)) {
                    K2 = j.G2();
                } else if ("normal".equals(str)) {
                    c.a aVar = new c.a();
                    aVar.d(bVar.f7208e);
                    aVar.e(bVar.f7209f);
                    aVar.b(bVar.f7210g);
                    aVar.c(z);
                    K2 = f.x3(aVar.a());
                } else {
                    K2 = "running_info".equals(str) ? i.K2() : null;
                }
                if (K2 == null) {
                    return null;
                }
                j(K2);
                return this;
            }
            return (b) invokeLLZ.objValue;
        }

        public b m(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
                int size = this.f5909c.f5904b.size();
                if (!this.f5909c.f5904b.isEmpty() && i2 >= 0 && i2 < size) {
                    this.f5907a.g((d) this.f5909c.f5904b.remove(i2));
                }
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b n(int i2, int i3) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(1048589, this, i2, i3)) == null) {
                this.f5907a.h(i2, i3);
                return this;
            }
            return (b) invokeII.objValue;
        }

        public void o(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048590, this, dVar) == null) {
                n nVar = this.f5907a;
                nVar.i(dVar);
                nVar.e();
                this.f5909c.f5903a.c();
            }
        }

        public b p(c.a.o0.a.l1.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, bVar)) == null) {
                f l = this.f5909c.l();
                if (l != null) {
                    l.E3(bVar);
                    return this;
                }
                return k("normal", bVar);
            }
            return (b) invokeL.objValue;
        }

        public final void q() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
                this.f5909c.f5905c.offer(new RunnableC0213b(this, this.f5909c.m()));
            }
        }

        public final void r(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048593, this, dVar) == null) {
                this.f5909c.f5905c.offer(new a(this, this.f5909c.m(), dVar));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(957786125, "Lc/a/o0/a/h0/g/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(957786125, "Lc/a/o0/a/h0/g/g;");
                return;
            }
        }
        f5898e = c.a.o0.a.k.f7049a;
        f5899f = new HashSet();
        f5900g = c.a.o0.a.a.aiapps_slide_in_from_right;
        f5901h = c.a.o0.a.a.aiapps_slide_out_to_right;
        f5902i = c.a.o0.a.a.aiapps_hold;
        f5899f.add("adLanding");
        f5899f.add("wxPay");
        f5899f.add("default_webview");
        f5899f.add("allianceLogin");
        f5899f.add("allianceChooseAddress");
        f5899f.add("qrCodePay");
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
        this.f5905c = new LinkedList();
        this.f5903a = fragmentActivity.getSupportFragmentManager();
        this.f5904b = new ArrayList<>();
        this.f5906d = new CopyOnWriteArrayList();
    }

    public void g(@Nullable a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
            return;
        }
        this.f5906d.add(aVar);
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
            if (this.f5904b.isEmpty() || i2 < 0 || i2 >= this.f5904b.size()) {
                return null;
            }
            return this.f5904b.get(i2);
        }
        return (d) invokeI.objValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f5904b.size() : invokeV.intValue;
    }

    public f l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f5904b.isEmpty()) {
                return null;
            }
            int size = this.f5904b.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.f5904b.get(i2).X1()) {
                    return (f) this.f5904b.get(i2);
                }
            }
            return null;
        }
        return (f) invokeV.objValue;
    }

    public d m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? j(this.f5904b.size() - 1) : (d) invokeV.objValue;
    }

    public <T extends d> T n(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, cls)) == null) {
            if (cls != null) {
                for (int size = this.f5904b.size() - 1; size >= 0; size--) {
                    T t = (T) this.f5904b.get(size);
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
            for (int size = this.f5904b.size() - 1; size >= 0; size--) {
                d dVar = this.f5904b.get(size);
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
        this.f5906d.remove(aVar);
    }
}
