package b.a.p0.a.u.e.n;

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
    public static final boolean f8882g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile l f8883h;

    /* renamed from: i  reason: collision with root package name */
    public static b.a.p0.a.y0.k.g.a f8884i;
    public static boolean j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, Boolean> f8885a;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, b.a.p0.a.y0.k.g.a> f8886b;

    /* renamed from: c  reason: collision with root package name */
    public int f8887c;

    /* renamed from: d  reason: collision with root package name */
    public b.a.p0.a.z2.g1.c<Integer> f8888d;

    /* renamed from: e  reason: collision with root package name */
    public b.a.p0.a.g1.h f8889e;

    /* renamed from: f  reason: collision with root package name */
    public b.a.p0.a.t0.a f8890f;

    /* loaded from: classes.dex */
    public class a extends b.a.p0.a.t0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f8891a;

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
            this.f8891a = lVar;
        }

        @Override // b.a.p0.a.t0.a, b.a.p0.a.t0.b
        public boolean onKeyDown(int i2, KeyEvent keyEvent) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i2, keyEvent)) == null) {
                if (i2 == 4 && this.f8891a.f8888d != null && this.f8891a.g()) {
                    this.f8891a.f8888d.onCallback(1);
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-229838134, "Lb/a/p0/a/u/e/n/l;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-229838134, "Lb/a/p0/a/u/e/n/l;");
                return;
            }
        }
        f8882g = b.a.p0.a.k.f6863a;
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
        this.f8885a = new HashMap<>();
        this.f8886b = new HashMap<>();
        this.f8887c = -1;
        this.f8888d = null;
        this.f8889e = null;
        this.f8890f = new a(this);
    }

    public static l e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f8883h == null) {
                synchronized (l.class) {
                    if (f8883h == null) {
                        f8883h = new l();
                    }
                }
            }
            return f8883h;
        }
        return (l) invokeV.objValue;
    }

    public void b(b.a.p0.a.y0.k.g.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null || TextUtils.isEmpty(aVar.c())) {
            return;
        }
        this.f8886b.put(aVar.c(), aVar);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            b.a.p0.a.e0.d.i("SwanInlinePlayerManager", "clearCacheVideo: ");
            f8884i = null;
            j = false;
        }
    }

    public b.a.p0.a.y0.k.g.a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (f8882g && f8884i != null) {
                String str = "getCacheVideoPlayer: " + f8884i.c();
            }
            return f8884i;
        }
        return (b.a.p0.a.y0.k.g.a) invokeV.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            boolean z = true;
            z = (!(d() != null && d().f0() == null) || j) ? false : false;
            b.a.p0.a.e0.d.i("SwanInlinePlayerManager", "hasCacheVideo: " + z);
            return z;
        }
        return invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int i2 = this.f8887c;
            return i2 == 90 || i2 == -90;
        }
        return invokeV.booleanValue;
    }

    public final boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f8887c == 0 : invokeV.booleanValue;
    }

    public void i() {
        b.a.p0.a.z2.g1.c<Integer> cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && g() && (cVar = this.f8888d) != null) {
            cVar.onCallback(0);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            b.a.p0.a.h0.g.f H = b.a.p0.a.g1.f.U().H();
            if (g()) {
                boolean z = f8882g;
                if (H != null) {
                    H.O3(false);
                }
                b.a.p0.a.c2.b.a.g();
                b.a.p0.a.c2.b.a.m(true);
            } else if (h()) {
                boolean z2 = f8882g;
                if (H != null) {
                    H.O3(true);
                }
            } else {
                boolean z3 = f8882g;
                if (H != null) {
                    H.O3(false);
                }
            }
        }
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                boolean z = f8882g;
                return;
            }
            HashMap<String, b.a.p0.a.y0.k.g.a> hashMap = this.f8886b;
            if (hashMap == null || hashMap.size() <= 0) {
                return;
            }
            int i2 = 0;
            for (String str2 : this.f8886b.keySet()) {
                if (str2.equals(str)) {
                    if (f8882g) {
                        String str3 = "pauseOtherPlayers: skip itself." + str;
                    }
                } else {
                    b.a.p0.a.y0.k.g.a aVar = this.f8886b.get(str2);
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
        if (!(interceptable == null || interceptable.invokeLZ(1048585, this, str, z) == null) || (hashMap = this.f8885a) == null) {
            return;
        }
        hashMap.put(str, Boolean.valueOf(z));
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            b.a.p0.a.g1.f.U().getActivity().registerCallback(this.f8890f);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            synchronized (this) {
                x();
                w();
                this.f8885a = null;
                this.f8886b.clear();
                this.f8888d = null;
            }
            f8883h = null;
        }
    }

    public void o(b.a.p0.a.y0.k.g.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) || aVar == null) {
            return;
        }
        if (d() == null) {
            j = false;
        } else if (TextUtils.equals(d().c(), aVar.c())) {
            b.a.p0.a.e0.d.i("SwanInlinePlayerManager", "releaseCacheVideo: clear cache video " + aVar.c());
            f8884i = null;
            j = false;
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f8888d = null;
        }
    }

    public void q(String str) {
        HashMap<String, Boolean> hashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, str) == null) || (hashMap = this.f8885a) == null) {
            return;
        }
        hashMap.remove(str);
        int size = this.f8885a.keySet().size();
        if (f8882g) {
            String str2 = "removePlayerState: last player count " + size;
        }
    }

    public void r(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f8886b.remove(str);
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            b.a.p0.a.e0.d.i("SwanInlinePlayerManager", "setCacheInUsed: true");
            j = true;
        }
    }

    public void t(b.a.p0.a.y0.k.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, aVar) == null) {
            if (f8882g) {
                String str = "setCacheVideo: " + aVar.toString();
            }
            f8884i = aVar;
        }
    }

    public void u(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.f8887c = i2;
        }
    }

    public void v(b.a.p0.a.z2.g1.c<Integer> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, cVar) == null) {
            this.f8888d = cVar;
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            SwanAppActivity activity = b.a.p0.a.g1.f.U().getActivity();
            b.a.p0.a.t0.a aVar = this.f8890f;
            if (aVar == null || activity == null) {
                return;
            }
            activity.unregisterCallback(aVar);
        }
    }

    public void x() {
        b.a.p0.a.g1.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (hVar = this.f8889e) == null) {
            return;
        }
        b.a.p0.a.g1.i.f(hVar);
        this.f8889e = null;
    }
}
