package c.a.c0.v.i0;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.c0.v.d0.m;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.constants.PlayerStatus;
import com.baidu.searchbox.player.kernel.AbsVideoKernel;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public abstract class a implements c.a.c0.v.p0.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public String f2406b;

    /* renamed from: c  reason: collision with root package name */
    public String f2407c;

    /* renamed from: d  reason: collision with root package name */
    public final HashMap<String, String> f2408d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final c.a.c0.v.q0.a f2409e;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f2408d = new HashMap<>();
        this.f2409e = c.a.c0.v.q0.b.c().b();
        w("VideoKernel: " + getClass().getSimpleName() + " Created, HashCode = " + System.identityHashCode(this));
    }

    public abstract void A(int i2, int i3);

    public void B(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
        }
    }

    public abstract void C();

    public void D(@Nullable HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, hashMap) == null) || hashMap == null) {
            return;
        }
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            this.f2408d.put(entry.getKey(), entry.getValue());
        }
    }

    public void E(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, eVar) == null) {
        }
    }

    public abstract void F(boolean z);

    public void G(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
        }
    }

    public abstract void H(@Nullable String str);

    public abstract void I(float f2);

    public void J(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        w("setUserAgent = " + str);
        this.f2408d.put("User-Agent", str);
    }

    public abstract void K(String str, @NonNull HashMap<String, String> hashMap);

    public abstract void L(int i2);

    public void M(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048588, this, str, z) == null) {
            this.f2406b = str;
            if (TextUtils.isEmpty(str) || !z) {
                return;
            }
            this.f2407c = this.f2406b;
            w("setDataSourceAndPrepare " + this.f2406b);
            p(PlayerStatus.PREPARING);
            C();
        }
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            w("start()" + this.f2406b);
            if (TextUtils.isEmpty(this.f2406b)) {
                this.f2406b = "";
            } else {
                x();
            }
        }
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            w(IntentConfig.STOP);
            this.f2407c = null;
            p(PlayerStatus.STOP);
        }
    }

    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            w("stopPlayback");
            this.f2407c = null;
        }
    }

    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.f2409e.h();
        }
    }

    public abstract void R(@Nullable String str);

    public void a(@NonNull c.a.c0.v.k0.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, cVar) == null) {
            this.f2409e.b(cVar);
        }
    }

    public void b(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f2406b = str;
        p(PlayerStatus.PREPARING);
        C();
        N();
    }

    @Nullable
    public abstract View c();

    public abstract int d();

    public abstract int e();

    public abstract int f();

    public abstract int g();

    public abstract int h();

    public PlayerStatus i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f2409e.c() : (PlayerStatus) invokeV.objValue;
    }

    public abstract int j();

    @NonNull
    public c.a.c0.v.q0.a k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.f2409e : (c.a.c0.v.q0.a) invokeV.objValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f2406b : (String) invokeV.objValue;
    }

    public abstract int m();

    public boolean n(@NonNull PlayerStatus... playerStatusArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, playerStatusArr)) == null) ? this.f2409e.e(playerStatusArr) : invokeL.booleanValue;
    }

    public abstract void o(boolean z);

    @Override // c.a.c0.v.p0.c
    public void onInit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            w("onInit");
            View c2 = c();
            if (c2 != null) {
                c2.setBackground(null);
            }
        }
    }

    @Override // c.a.c0.v.p0.c
    public void onRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            w("onRelease");
            m.a(c());
            this.f2409e.f();
            this.f2407c = null;
            this.f2406b = "";
        }
    }

    public void p(PlayerStatus playerStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, playerStatus) == null) {
            this.f2409e.g(playerStatus);
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            this.f2407c = null;
        }
    }

    public void s(int i2, int i3, Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048614, this, i2, i3, obj) == null) || 701 == i2 || 702 == i2) {
            return;
        }
        if (946 == i2) {
            this.a = i3;
        } else if (924 != i2 && 5000 == i2 && (obj instanceof String)) {
            String str = (String) obj;
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            w("pause");
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            w("prepare");
            if (PlayerStatus.isActiveStatus(i()) || TextUtils.isEmpty(this.f2406b)) {
                return;
            }
            p(PlayerStatus.PREPARING);
            C();
        }
    }

    @Override // c.a.c0.v.p0.c
    public boolean verify(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048618, this, str)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    public void w(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, str) == null) {
            c.a.c0.v.v0.h.b(AbsVideoKernel.TAG, String.format("video kernel [%s]: %s ", "AbsVideoKernel@" + System.identityHashCode(this), str));
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048620, this) == null) || TextUtils.equals(this.f2407c, this.f2406b) || TextUtils.isEmpty(this.f2406b)) {
            return;
        }
        p(PlayerStatus.PREPARING);
        C();
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            w("resume");
        }
    }

    public void z(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048622, this, i2) == null) {
            A(i2, 3);
        }
    }
}
