package c.a.o0.a.u.e.o;

import android.text.TextUtils;
import android.view.KeyEvent;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f9075g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile k f9076h;

    /* renamed from: i  reason: collision with root package name */
    public static c.a.o0.a.y0.k.g.a f9077i;

    /* renamed from: j  reason: collision with root package name */
    public static boolean f9078j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, Boolean> f9079a;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, c.a.o0.a.y0.k.g.a> f9080b;

    /* renamed from: c  reason: collision with root package name */
    public int f9081c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.o0.a.v2.e1.b<Integer> f9082d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.o0.a.g1.h f9083e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.o0.a.t0.a f9084f;

    /* loaded from: classes.dex */
    public class a extends c.a.o0.a.t0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k f9085a;

        public a(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9085a = kVar;
        }

        @Override // c.a.o0.a.t0.a, c.a.o0.a.t0.b
        public boolean onKeyDown(int i2, KeyEvent keyEvent) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i2, keyEvent)) == null) {
                if (i2 == 4 && this.f9085a.f9082d != null && this.f9085a.g()) {
                    this.f9085a.f9082d.onCallback(1);
                    return true;
                }
                return false;
            }
            return invokeIL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1416904330, "Lc/a/o0/a/u/e/o/k;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1416904330, "Lc/a/o0/a/u/e/o/k;");
                return;
            }
        }
        f9075g = c.a.o0.a.k.f7049a;
    }

    public k() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f9079a = new HashMap<>();
        this.f9080b = new HashMap<>();
        this.f9081c = -1;
        this.f9082d = null;
        this.f9083e = null;
        this.f9084f = new a(this);
    }

    public static k e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f9076h == null) {
                synchronized (k.class) {
                    if (f9076h == null) {
                        f9076h = new k();
                    }
                }
            }
            return f9076h;
        }
        return (k) invokeV.objValue;
    }

    public void b(c.a.o0.a.y0.k.g.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null || TextUtils.isEmpty(aVar.c())) {
            return;
        }
        this.f9080b.put(aVar.c(), aVar);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.o0.a.e0.d.g("SwanInlinePlayerManager", "clearCacheVideo: ");
            f9077i = null;
            f9078j = false;
        }
    }

    public c.a.o0.a.y0.k.g.a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (f9075g && f9077i != null) {
                String str = "getCacheVideoPlayer: " + f9077i.c();
            }
            return f9077i;
        }
        return (c.a.o0.a.y0.k.g.a) invokeV.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            boolean z = true;
            z = (!(d() != null && d().f0() == null) || f9078j) ? false : false;
            c.a.o0.a.e0.d.g("SwanInlinePlayerManager", "hasCacheVideo: " + z);
            return z;
        }
        return invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int i2 = this.f9081c;
            return i2 == 90 || i2 == -90;
        }
        return invokeV.booleanValue;
    }

    public void h() {
        c.a.o0.a.v2.e1.b<Integer> bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && g() && (bVar = this.f9082d) != null) {
            bVar.onCallback(0);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (g()) {
                boolean z = f9075g;
                c.a.o0.a.z1.b.a.f();
                c.a.o0.a.z1.b.a.k(true);
                return;
            }
            boolean z2 = f9075g;
        }
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                boolean z = f9075g;
                return;
            }
            HashMap<String, c.a.o0.a.y0.k.g.a> hashMap = this.f9080b;
            if (hashMap == null || hashMap.size() <= 0) {
                return;
            }
            for (String str2 : this.f9080b.keySet()) {
                if (str2.equals(str)) {
                    if (f9075g) {
                        String str3 = "pauseOtherPlayers: skip itself." + str;
                    }
                } else {
                    c.a.o0.a.y0.k.g.a aVar = this.f9080b.get(str2);
                    if (aVar != null) {
                        aVar.pause();
                        aVar.Q().c(aVar.c());
                    }
                }
            }
        }
    }

    public void k(String str, boolean z) {
        HashMap<String, Boolean> hashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, z) == null) || (hashMap = this.f9079a) == null) {
            return;
        }
        hashMap.put(str, Boolean.valueOf(z));
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            c.a.o0.a.g1.f.V().getActivity().registerCallback(this.f9084f);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            synchronized (this) {
                w();
                v();
                this.f9079a = null;
                this.f9080b.clear();
                this.f9082d = null;
            }
            f9076h = null;
        }
    }

    public void n(c.a.o0.a.y0.k.g.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) || aVar == null) {
            return;
        }
        if (d() == null) {
            f9078j = false;
        } else if (TextUtils.equals(d().c(), aVar.c())) {
            c.a.o0.a.e0.d.g("SwanInlinePlayerManager", "releaseCacheVideo: clear cache video " + aVar.c());
            f9077i = null;
            f9078j = false;
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f9082d = null;
        }
    }

    public void p(String str) {
        HashMap<String, Boolean> hashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, str) == null) || (hashMap = this.f9079a) == null) {
            return;
        }
        hashMap.remove(str);
        int size = this.f9079a.keySet().size();
        if (f9075g) {
            String str2 = "removePlayerState: last player count " + size;
        }
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f9080b.remove(str);
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            c.a.o0.a.e0.d.g("SwanInlinePlayerManager", "setCacheInUsed: true");
            f9078j = true;
        }
    }

    public void s(c.a.o0.a.y0.k.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, aVar) == null) {
            if (f9075g) {
                String str = "setCacheVideo: " + aVar.toString();
            }
            f9077i = aVar;
        }
    }

    public void t(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.f9081c = i2;
        }
    }

    public void u(c.a.o0.a.v2.e1.b<Integer> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bVar) == null) {
            this.f9082d = bVar;
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            SwanAppActivity activity = c.a.o0.a.g1.f.V().getActivity();
            c.a.o0.a.t0.a aVar = this.f9084f;
            if (aVar == null || activity == null) {
                return;
            }
            activity.unregisterCallback(aVar);
        }
    }

    public void w() {
        c.a.o0.a.g1.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (hVar = this.f9083e) == null) {
            return;
        }
        c.a.o0.a.g1.i.f(hVar);
        this.f9083e = null;
    }
}
