package b.a.p0.a.g1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import android.widget.AbsoluteLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.g1.e;
import b.a.p0.a.k;
import b.a.p0.a.p.b.a.n;
import b.a.p0.a.v2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.console.property.SwanAppPropertyWindow;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes.dex */
public final class f implements e.b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f5132b;

    /* renamed from: c  reason: collision with root package name */
    public static AtomicLong f5133c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile f f5134d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d f5135a;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public class b extends b.a.p0.a.g1.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // b.a.p0.a.g1.b
        public void P() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.P();
            }
        }

        @Override // b.a.p0.a.g1.d
        public boolean j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f5106h : invokeV.booleanValue;
        }

        public /* synthetic */ b(f fVar, a aVar) {
            this(fVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1323672036, "Lb/a/p0/a/g1/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1323672036, "Lb/a/p0/a/g1/f;");
                return;
            }
        }
        f5132b = k.f6397a;
        f5133c = new AtomicLong(0L);
    }

    public f() {
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
        this.f5135a = new b(this, null);
    }

    public static f T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f5134d == null) {
                synchronized (f.class) {
                    if (f5134d == null) {
                        f5134d = new f();
                    }
                }
            }
            return f5134d;
        }
        return (f) invokeV.objValue;
    }

    public static synchronized void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            synchronized (f.class) {
                if (f5134d == null) {
                    return;
                }
                if (f5134d.f5135a != null) {
                    f5134d.f5135a.N();
                }
                f5134d = null;
            }
        }
    }

    public b.a.p0.a.p.e.d A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? this.f5135a.A(str) : (b.a.p0.a.p.e.d) invokeL.objValue;
    }

    public AbsoluteLayout B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? this.f5135a.B(str) : (AbsoluteLayout) invokeL.objValue;
    }

    public String C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f5135a.C() : (String) invokeV.objValue;
    }

    @Nullable
    public b.a.p0.a.a2.e D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f5135a.D() : (b.a.p0.a.a2.e) invokeV.objValue;
    }

    public void E(b.a.p0.a.f1.e.b bVar, b.a.p0.a.a1.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, bVar, bVar2) == null) {
            this.f5135a.E(bVar, bVar2);
        }
    }

    public b.a.p0.a.p.b.a.k F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f5135a.F() : (b.a.p0.a.p.b.a.k) invokeV.objValue;
    }

    public b.a.p0.a.k2.f.d G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f5135a.G() : (b.a.p0.a.k2.f.d) invokeV.objValue;
    }

    public b.a.p0.a.h0.g.f H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f5135a.H() : (b.a.p0.a.h0.g.f) invokeV.objValue;
    }

    public SwanAppPropertyWindow J(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity)) == null) ? this.f5135a.J(activity) : (SwanAppPropertyWindow) invokeL.objValue;
    }

    public SwanCoreVersion L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f5135a.L() : (SwanCoreVersion) invokeV.objValue;
    }

    public boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f5135a.M() : invokeV.booleanValue;
    }

    public void P(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i2) == null) || Y()) {
            return;
        }
        if (i2 == 0) {
            this.f5135a = new c();
        } else if (i2 != 1) {
        } else {
            this.f5135a = b.a.p0.a.c1.b.a();
        }
    }

    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            long decrementAndGet = f5133c.decrementAndGet();
            SwanAppActivity x = b.a.p0.a.a2.d.g().x();
            if (decrementAndGet <= 0 && x != null && x.isBackground()) {
                this.f5135a.I();
            }
            if (f5132b) {
                StringBuilder sb = new StringBuilder();
                sb.append("decrementBgThreadAliveCount: count = ");
                sb.append(decrementAndGet);
                sb.append("isBackground = ");
                sb.append(x != null && x.isBackground());
                sb.toString();
            }
        }
    }

    public long R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? f5133c.get() : invokeV.longValue;
    }

    public String S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? q0.n().f() : (String) invokeV.objValue;
    }

    @Nullable
    public b.a.p0.a.h0.g.g U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            SwanAppActivity activity = T().getActivity();
            if (activity == null) {
                return null;
            }
            return activity.getSwanAppFragmentManager();
        }
        return (b.a.p0.a.h0.g.g) invokeV.objValue;
    }

    public n V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f5135a.O() : (n) invokeV.objValue;
    }

    public n W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f5135a.K() : (n) invokeV.objValue;
    }

    public boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? Y() && this.f5135a.getActivity() != null : invokeV.booleanValue;
    }

    public boolean Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            d dVar = this.f5135a;
            return (dVar == null || (dVar instanceof b)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            long incrementAndGet = f5133c.incrementAndGet();
            if (f5132b) {
                String str = "incrementBgThreadAliveCount: " + incrementAndGet;
            }
        }
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f5135a.a() : (String) invokeV.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.f5135a.b();
        }
    }

    public void c(b.a.p0.a.f1.e.b bVar, b.a.p0.a.a1.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, bVar, bVar2) == null) {
            this.f5135a.c(bVar, bVar2);
        }
    }

    @NonNull
    public b.a.p0.a.a2.n.g d(String str, SwanAppConfigData swanAppConfigData, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048600, this, str, swanAppConfigData, str2)) == null) ? this.f5135a.d(str, swanAppConfigData, str2) : (b.a.p0.a.a2.n.g) invokeLLL.objValue;
    }

    @NonNull
    public b.a.p0.a.a2.n.g e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) ? this.f5135a.e(str) : (b.a.p0.a.a2.n.g) invokeL.objValue;
    }

    public void exit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.f5135a.exit();
        }
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f5135a.f() : (String) invokeV.objValue;
    }

    @Override // b.a.p0.a.g1.e.b
    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            this.f5135a.g(i2);
        }
    }

    public SwanAppActivity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f5135a.getActivity() : (SwanAppActivity) invokeV.objValue;
    }

    public b.a.p0.a.p.e.c h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.f5135a.h() : (b.a.p0.a.p.e.c) invokeV.objValue;
    }

    public b.a.p0.a.a2.n.g i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, str)) == null) ? this.f5135a.i(str) : (b.a.p0.a.a2.n.g) invokeL.objValue;
    }

    public void k(SwanAppActivity swanAppActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, swanAppActivity) == null) {
            if (swanAppActivity != null && !Y()) {
                P(swanAppActivity.getFrameType());
            }
            if (Y()) {
                this.f5135a.k(swanAppActivity);
            }
        }
    }

    public void l(String str, b.a.p0.a.o0.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048609, this, str, aVar) == null) {
            this.f5135a.l(str, aVar);
        }
    }

    public FullScreenFloatView m(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, activity)) == null) ? this.f5135a.m(activity) : (FullScreenFloatView) invokeL.objValue;
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            this.f5135a.n();
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            this.f5135a.o();
        }
    }

    @DebugTrace
    public b.a.p0.a.p.e.a p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.f5135a.p() : (b.a.p0.a.p.e.a) invokeV.objValue;
    }

    @NonNull
    public Pair<Integer, Integer> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.f5135a.q() : (Pair) invokeV.objValue;
    }

    public SwanAppConfigData r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.f5135a.r() : (SwanAppConfigData) invokeV.objValue;
    }

    public void registerReceiver(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, context) == null) {
            this.f5135a.registerReceiver(context);
        }
    }

    public void s(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, intent) == null) {
            this.f5135a.s(intent);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            this.f5135a.t();
        }
    }

    public void u(b.a.p0.a.o0.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, aVar) == null) {
            this.f5135a.u(aVar);
        }
    }

    public void unregisterReceiver(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, context) == null) {
            this.f5135a.unregisterReceiver(context);
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            this.f5135a.v();
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            this.f5135a.w();
        }
    }

    @NonNull
    public Pair<Integer, Integer> x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.f5135a.x() : (Pair) invokeV.objValue;
    }

    public void y(b.a.p0.a.o0.d.d dVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048624, this, dVar, z) == null) {
            this.f5135a.y(dVar, z);
        }
    }

    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.f5135a.z() : (String) invokeV.objValue;
    }
}
