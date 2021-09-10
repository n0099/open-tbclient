package c.a.p0.a.u.e.o;

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
    public static final boolean f9103g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile k f9104h;

    /* renamed from: i  reason: collision with root package name */
    public static c.a.p0.a.y0.k.g.a f9105i;

    /* renamed from: j  reason: collision with root package name */
    public static boolean f9106j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, Boolean> f9107a;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, c.a.p0.a.y0.k.g.a> f9108b;

    /* renamed from: c  reason: collision with root package name */
    public int f9109c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.a.v2.e1.b<Integer> f9110d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.a.g1.h f9111e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.p0.a.t0.a f9112f;

    /* loaded from: classes.dex */
    public class a extends c.a.p0.a.t0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k f9113a;

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
            this.f9113a = kVar;
        }

        @Override // c.a.p0.a.t0.a, c.a.p0.a.t0.b
        public boolean onKeyDown(int i2, KeyEvent keyEvent) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i2, keyEvent)) == null) {
                if (i2 == 4 && this.f9113a.f9110d != null && this.f9113a.g()) {
                    this.f9113a.f9110d.onCallback(1);
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1123501323, "Lc/a/p0/a/u/e/o/k;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1123501323, "Lc/a/p0/a/u/e/o/k;");
                return;
            }
        }
        f9103g = c.a.p0.a.k.f7077a;
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
        this.f9107a = new HashMap<>();
        this.f9108b = new HashMap<>();
        this.f9109c = -1;
        this.f9110d = null;
        this.f9111e = null;
        this.f9112f = new a(this);
    }

    public static k e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f9104h == null) {
                synchronized (k.class) {
                    if (f9104h == null) {
                        f9104h = new k();
                    }
                }
            }
            return f9104h;
        }
        return (k) invokeV.objValue;
    }

    public void b(c.a.p0.a.y0.k.g.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null || TextUtils.isEmpty(aVar.c())) {
            return;
        }
        this.f9108b.put(aVar.c(), aVar);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.p0.a.e0.d.g("SwanInlinePlayerManager", "clearCacheVideo: ");
            f9105i = null;
            f9106j = false;
        }
    }

    public c.a.p0.a.y0.k.g.a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (f9103g && f9105i != null) {
                String str = "getCacheVideoPlayer: " + f9105i.c();
            }
            return f9105i;
        }
        return (c.a.p0.a.y0.k.g.a) invokeV.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            boolean z = true;
            z = (!(d() != null && d().f0() == null) || f9106j) ? false : false;
            c.a.p0.a.e0.d.g("SwanInlinePlayerManager", "hasCacheVideo: " + z);
            return z;
        }
        return invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int i2 = this.f9109c;
            return i2 == 90 || i2 == -90;
        }
        return invokeV.booleanValue;
    }

    public void h() {
        c.a.p0.a.v2.e1.b<Integer> bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && g() && (bVar = this.f9110d) != null) {
            bVar.onCallback(0);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (g()) {
                boolean z = f9103g;
                c.a.p0.a.z1.b.a.f();
                c.a.p0.a.z1.b.a.k(true);
                return;
            }
            boolean z2 = f9103g;
        }
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                boolean z = f9103g;
                return;
            }
            HashMap<String, c.a.p0.a.y0.k.g.a> hashMap = this.f9108b;
            if (hashMap == null || hashMap.size() <= 0) {
                return;
            }
            for (String str2 : this.f9108b.keySet()) {
                if (str2.equals(str)) {
                    if (f9103g) {
                        String str3 = "pauseOtherPlayers: skip itself." + str;
                    }
                } else {
                    c.a.p0.a.y0.k.g.a aVar = this.f9108b.get(str2);
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
        if (!(interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, z) == null) || (hashMap = this.f9107a) == null) {
            return;
        }
        hashMap.put(str, Boolean.valueOf(z));
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            c.a.p0.a.g1.f.V().getActivity().registerCallback(this.f9112f);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            synchronized (this) {
                w();
                v();
                this.f9107a = null;
                this.f9108b.clear();
                this.f9110d = null;
            }
            f9104h = null;
        }
    }

    public void n(c.a.p0.a.y0.k.g.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) || aVar == null) {
            return;
        }
        if (d() == null) {
            f9106j = false;
        } else if (TextUtils.equals(d().c(), aVar.c())) {
            c.a.p0.a.e0.d.g("SwanInlinePlayerManager", "releaseCacheVideo: clear cache video " + aVar.c());
            f9105i = null;
            f9106j = false;
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f9110d = null;
        }
    }

    public void p(String str) {
        HashMap<String, Boolean> hashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, str) == null) || (hashMap = this.f9107a) == null) {
            return;
        }
        hashMap.remove(str);
        int size = this.f9107a.keySet().size();
        if (f9103g) {
            String str2 = "removePlayerState: last player count " + size;
        }
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f9108b.remove(str);
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            c.a.p0.a.e0.d.g("SwanInlinePlayerManager", "setCacheInUsed: true");
            f9106j = true;
        }
    }

    public void s(c.a.p0.a.y0.k.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, aVar) == null) {
            if (f9103g) {
                String str = "setCacheVideo: " + aVar.toString();
            }
            f9105i = aVar;
        }
    }

    public void t(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.f9109c = i2;
        }
    }

    public void u(c.a.p0.a.v2.e1.b<Integer> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bVar) == null) {
            this.f9110d = bVar;
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            SwanAppActivity activity = c.a.p0.a.g1.f.V().getActivity();
            c.a.p0.a.t0.a aVar = this.f9112f;
            if (aVar == null || activity == null) {
                return;
            }
            activity.unregisterCallback(aVar);
        }
    }

    public void w() {
        c.a.p0.a.g1.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (hVar = this.f9111e) == null) {
            return;
        }
        c.a.p0.a.g1.i.f(hVar);
        this.f9111e = null;
    }
}
