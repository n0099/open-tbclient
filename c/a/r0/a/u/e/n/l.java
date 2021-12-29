package c.a.r0.a.u.e.n;

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
public class l {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f9464g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile l f9465h;

    /* renamed from: i  reason: collision with root package name */
    public static c.a.r0.a.y0.k.g.a f9466i;

    /* renamed from: j  reason: collision with root package name */
    public static boolean f9467j;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, Boolean> a;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, c.a.r0.a.y0.k.g.a> f9468b;

    /* renamed from: c  reason: collision with root package name */
    public int f9469c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.r0.a.z2.g1.c<Integer> f9470d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.a.g1.h f9471e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.r0.a.t0.a f9472f;

    /* loaded from: classes.dex */
    public class a extends c.a.r0.a.t0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l a;

        public a(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lVar;
        }

        @Override // c.a.r0.a.t0.a, c.a.r0.a.t0.b
        public boolean onKeyDown(int i2, KeyEvent keyEvent) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i2, keyEvent)) == null) {
                if (i2 == 4 && this.a.f9470d != null && this.a.g()) {
                    this.a.f9470d.onCallback(1);
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(536665549, "Lc/a/r0/a/u/e/n/l;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(536665549, "Lc/a/r0/a/u/e/n/l;");
                return;
            }
        }
        f9464g = c.a.r0.a.k.a;
    }

    public l() {
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
        this.a = new HashMap<>();
        this.f9468b = new HashMap<>();
        this.f9469c = -1;
        this.f9470d = null;
        this.f9471e = null;
        this.f9472f = new a(this);
    }

    public static l e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f9465h == null) {
                synchronized (l.class) {
                    if (f9465h == null) {
                        f9465h = new l();
                    }
                }
            }
            return f9465h;
        }
        return (l) invokeV.objValue;
    }

    public void b(c.a.r0.a.y0.k.g.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null || TextUtils.isEmpty(aVar.c())) {
            return;
        }
        this.f9468b.put(aVar.c(), aVar);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.r0.a.e0.d.i("SwanInlinePlayerManager", "clearCacheVideo: ");
            f9466i = null;
            f9467j = false;
        }
    }

    public c.a.r0.a.y0.k.g.a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (f9464g && f9466i != null) {
                String str = "getCacheVideoPlayer: " + f9466i.c();
            }
            return f9466i;
        }
        return (c.a.r0.a.y0.k.g.a) invokeV.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            boolean z = true;
            z = (!(d() != null && d().f0() == null) || f9467j) ? false : false;
            c.a.r0.a.e0.d.i("SwanInlinePlayerManager", "hasCacheVideo: " + z);
            return z;
        }
        return invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int i2 = this.f9469c;
            return i2 == 90 || i2 == -90;
        }
        return invokeV.booleanValue;
    }

    public final boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f9469c == 0 : invokeV.booleanValue;
    }

    public void i() {
        c.a.r0.a.z2.g1.c<Integer> cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && g() && (cVar = this.f9470d) != null) {
            cVar.onCallback(0);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c.a.r0.a.h0.g.f H = c.a.r0.a.g1.f.U().H();
            if (g()) {
                boolean z = f9464g;
                if (H != null) {
                    H.L3(false);
                }
                c.a.r0.a.c2.b.a.g();
                c.a.r0.a.c2.b.a.m(true);
            } else if (h()) {
                boolean z2 = f9464g;
                if (H != null) {
                    H.L3(true);
                }
            } else {
                boolean z3 = f9464g;
                if (H != null) {
                    H.L3(false);
                }
            }
        }
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                boolean z = f9464g;
                return;
            }
            HashMap<String, c.a.r0.a.y0.k.g.a> hashMap = this.f9468b;
            if (hashMap == null || hashMap.size() <= 0) {
                return;
            }
            int i2 = 0;
            for (String str2 : this.f9468b.keySet()) {
                if (str2.equals(str)) {
                    if (f9464g) {
                        String str3 = "pauseOtherPlayers: skip itself." + str;
                    }
                } else {
                    c.a.r0.a.y0.k.g.a aVar = this.f9468b.get(str2);
                    if (aVar != null) {
                        if (i2 < 3) {
                            if (aVar.j0()) {
                                i2++;
                            } else {
                                aVar.pause();
                                aVar.Q().c(aVar.c());
                            }
                        } else {
                            aVar.pause();
                            aVar.Q().c(aVar.c());
                        }
                    }
                }
            }
        }
    }

    public void l(String str, boolean z) {
        HashMap<String, Boolean> hashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048585, this, str, z) == null) || (hashMap = this.a) == null) {
            return;
        }
        hashMap.put(str, Boolean.valueOf(z));
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            c.a.r0.a.g1.f.U().getActivity().registerCallback(this.f9472f);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            synchronized (this) {
                x();
                w();
                this.a = null;
                this.f9468b.clear();
                this.f9470d = null;
            }
            f9465h = null;
        }
    }

    public void o(c.a.r0.a.y0.k.g.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) || aVar == null) {
            return;
        }
        if (d() == null) {
            f9467j = false;
        } else if (TextUtils.equals(d().c(), aVar.c())) {
            c.a.r0.a.e0.d.i("SwanInlinePlayerManager", "releaseCacheVideo: clear cache video " + aVar.c());
            f9466i = null;
            f9467j = false;
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f9470d = null;
        }
    }

    public void q(String str) {
        HashMap<String, Boolean> hashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, str) == null) || (hashMap = this.a) == null) {
            return;
        }
        hashMap.remove(str);
        int size = this.a.keySet().size();
        if (f9464g) {
            String str2 = "removePlayerState: last player count " + size;
        }
    }

    public void r(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f9468b.remove(str);
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            c.a.r0.a.e0.d.i("SwanInlinePlayerManager", "setCacheInUsed: true");
            f9467j = true;
        }
    }

    public void t(c.a.r0.a.y0.k.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, aVar) == null) {
            if (f9464g) {
                String str = "setCacheVideo: " + aVar.toString();
            }
            f9466i = aVar;
        }
    }

    public void u(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.f9469c = i2;
        }
    }

    public void v(c.a.r0.a.z2.g1.c<Integer> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, cVar) == null) {
            this.f9470d = cVar;
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            SwanAppActivity activity = c.a.r0.a.g1.f.U().getActivity();
            c.a.r0.a.t0.a aVar = this.f9472f;
            if (aVar == null || activity == null) {
                return;
            }
            activity.unregisterCallback(aVar);
        }
    }

    public void x() {
        c.a.r0.a.g1.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (hVar = this.f9471e) == null) {
            return;
        }
        c.a.r0.a.g1.i.f(hVar);
        this.f9471e = null;
    }
}
