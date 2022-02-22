package c.a.d0.v.j0;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.constants.PlayerStatus;
import com.baidu.searchbox.player.event.ControlEvent;
import com.baidu.searchbox.player.event.InteractiveEvent;
import com.baidu.searchbox.player.event.InternalSyncControlEvent;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.searchbox.player.event.SystemEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes.dex */
public class i extends c.a.d0.v.j0.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public c.a.d0.v.i0.a f3308i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f3309j;
    public c.a.d0.v.f0.m k;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public class b implements c.a.d0.v.f0.m {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i a;

        public b(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iVar;
        }

        @Override // c.a.d0.v.f0.m
        public void a(c.a.d0.v.c0.p pVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pVar) == null) {
                this.a.T().a(pVar);
            }
        }

        @Override // c.a.d0.v.f0.m
        public int getExpectOrder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 1;
            }
            return invokeV.intValue;
        }

        public /* synthetic */ b(i iVar, a aVar) {
            this(iVar);
        }
    }

    public i(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f3309j = true;
        this.k = new b(this, null);
        this.f3308i = c.a.d0.v.p0.e.a().b(str);
        B();
    }

    @Override // c.a.d0.v.j0.b
    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.B();
        }
    }

    public void J(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.f3308i.b(str);
        }
    }

    public int K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f3308i.d() : invokeV.intValue;
    }

    public int L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f3308i.e() : invokeV.intValue;
    }

    public int M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f3308i.f() : invokeV.intValue;
    }

    @Nullable
    public c.a.d0.v.f0.g N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return null;
        }
        return (c.a.d0.v.f0.g) invokeV.objValue;
    }

    public int O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f3308i.g() : invokeV.intValue;
    }

    public int P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f3308i.h() : invokeV.intValue;
    }

    public PlayerStatus Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f3308i.i() : (PlayerStatus) invokeV.objValue;
    }

    public int R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f3308i.j() : invokeV.intValue;
    }

    public c.a.d0.v.i0.a S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f3308i : (c.a.d0.v.i0.a) invokeV.objValue;
    }

    public c.a.d0.v.q0.a T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f3308i.k() : (c.a.d0.v.q0.a) invokeV.objValue;
    }

    public String U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f3308i.l() : (String) invokeV.objValue;
    }

    public int V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f3308i.m() : invokeV.intValue;
    }

    public void W(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.f3308i.o(z);
        }
    }

    public void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f3308i.u();
        }
    }

    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.f3308i.v();
        }
    }

    public void Z() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (this.f3308i instanceof c.a.d0.v.i0.b)) {
            return;
        }
        h0(null);
        c.a.d0.v.i0.a aVar = this.f3308i;
        this.f3308i = new c.a.d0.v.i0.b();
        c.a.d0.v.p0.e.a().c(aVar);
    }

    public final void a0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || u().X()) {
            return;
        }
        u().k0();
    }

    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.f3308i.y();
        }
    }

    public void c0(int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            int e2 = this.f3308i.e();
            if (e2 > 1 && i2 > (i3 = e2 - 1)) {
                i2 = i3;
            }
            this.f3308i.z(i2 * 1000);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // c.a.d0.v.j0.b, c.a.d0.v.f0.j
    public void d(@NonNull c.a.d0.v.c0.p pVar) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, pVar) == null) {
            String c3 = pVar.c();
            switch (c3.hashCode()) {
                case -882902390:
                    if (c3.equals(PlayerEvent.ACTION_SET_DATA_SOURCE)) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -525235558:
                    if (c3.equals(PlayerEvent.ACTION_ON_PREPARED)) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -461848373:
                    if (c3.equals(PlayerEvent.ACTION_ON_ERROR)) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 154871702:
                    if (c3.equals(PlayerEvent.ACTION_ON_COMPLETE)) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1370689931:
                    if (c3.equals(PlayerEvent.ACTION_ON_INFO)) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 == 0) {
                this.f3308i.q();
            } else if (c2 == 1) {
                this.f3308i.t();
            } else if (c2 == 2) {
                this.f3308i.r();
            } else if (c2 != 3) {
                if (c2 == 4 && (pVar.f(3) instanceof c.a.d0.v.m0.h)) {
                    c.a.d0.v.m0.h hVar = (c.a.d0.v.m0.h) pVar.f(3);
                    c.a.d0.v.m0.i K = u().K();
                    String str = hVar.a;
                    K.f3367b = str;
                    p0(str, hVar.f3365c);
                }
            } else {
                this.f3308i.s(pVar.g(1), pVar.g(2), pVar.f(3));
            }
        }
    }

    public void d0(int i2, int i3) {
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048598, this, i2, i3) == null) {
            int f2 = this.f3308i.f();
            if (f2 > 1 && i2 > (i4 = f2 - 1)) {
                i2 = i4;
            }
            this.f3308i.A(i2, i3);
        }
    }

    public void e0(Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, bool) == null) {
            this.f3309j = bool.booleanValue();
        }
    }

    public void f0(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            this.f3308i.B(str);
        }
    }

    public void g0(@Nullable HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, hashMap) == null) {
            this.f3308i.D(hashMap);
        }
    }

    @Override // c.a.d0.v.j0.o
    @Nullable
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f3308i.c() : (View) invokeV.objValue;
    }

    @Override // c.a.d0.v.f0.j
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? new int[]{4, 3, 1, 2} : (int[]) invokeV.objValue;
    }

    public void h0(@Nullable c.a.d0.v.i0.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, eVar) == null) {
            this.f3308i.E(eVar);
        }
    }

    public void i0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            this.f3308i.F(z);
        }
    }

    @Override // c.a.d0.v.j0.b, c.a.d0.v.f0.j
    public void j(@NonNull c.a.d0.v.c0.p pVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048606, this, pVar) == null) && InteractiveEvent.ACTION_INTERACTIVE_ERROR.equals(pVar.c())) {
            this.f3308i.r();
        }
    }

    public void j0(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, str) == null) {
            this.f3308i.G(str);
        }
    }

    @Override // c.a.d0.v.j0.b, c.a.d0.v.f0.j
    public void k(@NonNull c.a.d0.v.c0.p pVar) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, pVar) == null) {
            String c3 = pVar.c();
            int hashCode = c3.hashCode();
            if (hashCode == -150198673) {
                if (c3.equals(LayerEvent.ACTION_CLICK_NET_TIP)) {
                    c2 = 0;
                }
                c2 = 65535;
            } else if (hashCode != -103262037) {
                if (hashCode == 1939755256 && c3.equals(LayerEvent.ACTION_CHANGE_CLARITY)) {
                    c2 = 2;
                }
                c2 = 65535;
            } else {
                if (c3.equals(LayerEvent.ACTION_SEEK)) {
                    c2 = 1;
                }
                c2 = 65535;
            }
            if (c2 == 0) {
                u().l();
            } else if (c2 == 1) {
                c0(pVar.g(1));
                a0();
                this.f3308i.y();
            } else if (c2 != 2) {
            } else {
                int g2 = pVar.g(19);
                Object f2 = pVar.f(31);
                if (f2 instanceof c.a.d0.v.m0.h) {
                    String str = ((c.a.d0.v.m0.h) f2).a;
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    J(str);
                    c0(g2);
                }
            }
        }
    }

    public void k0(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, str) == null) {
            this.f3308i.H(str);
        }
    }

    public void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
        }
    }

    public void m0(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048611, this, f2) == null) {
            this.f3308i.I(f2);
        }
    }

    @Override // c.a.d0.v.j0.b, c.a.d0.v.f0.j
    public void n(@NonNull c.a.d0.v.c0.p pVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048612, this, pVar) == null) && this.f3309j && SystemEvent.ACTION_VOLUME_CHANGED.equals(pVar.c())) {
            W(pVar.g(5) <= 0);
        }
    }

    public void n0(String str, @NonNull HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048613, this, str, hashMap) == null) {
            this.f3308i.K(str, hashMap);
        }
    }

    public void o0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i2) == null) {
            this.f3308i.L(i2);
        }
    }

    public void p0(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048615, this, str, z) == null) {
            this.f3308i.M(str, z);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // c.a.d0.v.j0.b, c.a.d0.v.f0.j
    public void q(@NonNull c.a.d0.v.c0.p pVar) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, pVar) == null) {
            String c3 = pVar.c();
            switch (c3.hashCode()) {
                case -1929694922:
                    if (c3.equals(InternalSyncControlEvent.INTERNAL_ACTION_RESUME)) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1106918114:
                    if (c3.equals(InternalSyncControlEvent.INTERNAL_ACTION_PREPARE)) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1076076346:
                    if (c3.equals(ControlEvent.ACTION_SEEK_MS)) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -502522037:
                    if (c3.equals(InternalSyncControlEvent.INTERNAL_ACTION_STOP)) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 745698331:
                    if (c3.equals(InternalSyncControlEvent.INTERNAL_ACTION_START)) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1547340063:
                    if (c3.equals(ControlEvent.ACTION_SEEK)) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1598355405:
                    if (c3.equals(InternalSyncControlEvent.INTERNAL_ACTION_PAUSE)) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            switch (c2) {
                case 0:
                    d0(pVar.g(5) * 1000, pVar.h(12, 3));
                    return;
                case 1:
                    d0(pVar.g(5), pVar.h(12, 3));
                    return;
                case 2:
                    Y();
                    return;
                case 3:
                    if (getContentView() != null) {
                        getContentView().setVisibility(0);
                    }
                    q0();
                    return;
                case 4:
                    X();
                    return;
                case 5:
                    b0();
                    return;
                case 6:
                    r0();
                    return;
                default:
                    return;
            }
        }
    }

    public void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            this.f3308i.N();
        }
    }

    @Override // c.a.d0.v.j0.b
    public void r(@NonNull c.a.d0.v.k0.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, cVar) == null) {
            super.r(cVar);
            cVar.b(this.k);
            this.f3308i.a(cVar);
        }
    }

    public void r0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            this.f3308i.O();
        }
    }

    @Override // c.a.d0.v.j0.b
    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            if (y() != null) {
                y().f(this.k);
            }
            super.s();
            this.f3308i.Q();
        }
    }

    public void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            this.f3308i.P();
        }
    }

    public void t0(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, str) == null) {
            this.f3308i.R(str);
        }
    }
}
