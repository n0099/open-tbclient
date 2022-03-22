package c.a.n0.a.x.l.g;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class m implements b<a> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f7208c;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile Boolean a;

    /* renamed from: b  reason: collision with root package name */
    public volatile b<a> f7209b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1451030459, "Lc/a/n0/a/x/l/g/m;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1451030459, "Lc/a/n0/a/x/l/g/m;");
                return;
            }
        }
        f7208c = c.a.n0.a.a.a;
    }

    public m() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
    }

    @Override // c.a.n0.a.x.l.g.b
    public void b(String str, PrefetchEvent.c cVar, PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, cVar, pMSAppInfo) == null) {
            l().b(str, cVar, pMSAppInfo);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: c.a.n0.a.x.l.g.d<c.a.n0.a.x.l.g.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // c.a.n0.a.x.l.g.c
    public void c(d<a> dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
            l().c(dVar);
        }
    }

    @Override // c.a.n0.a.x.l.g.b
    public void d(c.a.n0.a.e0.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            l().d(bVar);
        }
    }

    @Override // c.a.n0.a.x.l.g.c
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? l().f() : invokeV.booleanValue;
    }

    @Override // c.a.n0.a.x.l.g.c
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? l().g() : invokeV.booleanValue;
    }

    @Override // c.a.n0.a.x.l.g.c
    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? l().h() : invokeV.booleanValue;
    }

    @Override // c.a.n0.a.x.l.g.b
    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? l().i() : invokeV.booleanValue;
    }

    @Override // c.a.n0.a.x.l.g.b
    public void j(boolean z, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048585, this, z, jVar) == null) {
            l().j(z, jVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.n0.a.x.l.g.c
    /* renamed from: k */
    public a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (a) l().a() : (a) invokeV.objValue;
    }

    public final b<a> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.f7209b == null) {
                synchronized (this) {
                    if (this.f7209b == null) {
                        this.f7209b = m() ? new c.a.n0.a.x.l.g.o.c() : new l();
                        if (f7208c) {
                            Log.d("SwanAppMasterProviderWrapper", "provider - " + this.f7209b.getClass().getSimpleName());
                        }
                    }
                }
            }
            return this.f7209b;
        }
        return (b) invokeV.objValue;
    }

    public final boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.a == null) {
                this.a = Boolean.valueOf(c.a.n0.a.x.o.e.a.l() > 0 && c.a.n0.a.x.o.e.a.i());
            }
            if (f7208c) {
                Log.d("SwanAppMasterProviderWrapper", "loaded swan core version - " + c.a.n0.a.x.u.g.U().d0());
                Log.d("SwanAppMasterProviderWrapper", "use multi preload - " + this.a);
            }
            return this.a.booleanValue();
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.n0.a.x.l.g.c
    /* renamed from: n */
    public a e(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, pMSAppInfo)) == null) ? (a) l().e(pMSAppInfo) : (a) invokeL.objValue;
    }

    @Override // c.a.n0.a.x.l.g.c
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            l().reset();
            synchronized (this) {
                this.a = null;
                this.f7209b = null;
            }
        }
    }
}
