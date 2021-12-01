package c.a.b0.s.j0;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.constants.PlayerStatus;
import com.baidu.searchbox.player.event.ControlEvent;
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
public class i extends c.a.b0.s.j0.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public c.a.b0.s.i0.a f1974i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f1975j;

    /* renamed from: k  reason: collision with root package name */
    public c.a.b0.s.f0.m f1976k;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public class b implements c.a.b0.s.f0.m {
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

        @Override // c.a.b0.s.f0.m
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 1;
            }
            return invokeV.intValue;
        }

        @Override // c.a.b0.s.f0.m
        public void b(c.a.b0.s.c0.p pVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pVar) == null) {
                this.a.b0().a(pVar);
            }
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
        this.f1975j = true;
        this.f1976k = new b(this, null);
        this.f1974i = c.a.b0.s.p0.e.a().b(str);
        C();
    }

    public void A0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f1974i.P();
        }
    }

    public void B0(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.f1974i.R(str);
        }
    }

    @Override // c.a.b0.s.j0.b
    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.C();
        }
    }

    public void O(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f1974i.b(str);
        }
    }

    public int Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f1974i.d() : invokeV.intValue;
    }

    public int S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f1974i.e() : invokeV.intValue;
    }

    public int T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f1974i.f() : invokeV.intValue;
    }

    @Nullable
    public c.a.b0.s.f0.g V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return null;
        }
        return (c.a.b0.s.f0.g) invokeV.objValue;
    }

    public int W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f1974i.g() : invokeV.intValue;
    }

    public int X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f1974i.h() : invokeV.intValue;
    }

    public PlayerStatus Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f1974i.i() : (PlayerStatus) invokeV.objValue;
    }

    public int Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f1974i.j() : invokeV.intValue;
    }

    public c.a.b0.s.i0.a a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f1974i : (c.a.b0.s.i0.a) invokeV.objValue;
    }

    public c.a.b0.s.q0.a b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f1974i.k() : (c.a.b0.s.q0.a) invokeV.objValue;
    }

    public String c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f1974i.l() : (String) invokeV.objValue;
    }

    public int d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f1974i.m() : invokeV.intValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // c.a.b0.s.j0.b, c.a.b0.s.f0.j
    public void e(@NonNull c.a.b0.s.c0.p pVar) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, pVar) == null) {
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
                this.f1974i.q();
            } else if (c2 == 1) {
                this.f1974i.t();
            } else if (c2 == 2) {
                this.f1974i.r();
            } else if (c2 != 3) {
                if (c2 == 4 && (pVar.f(3) instanceof c.a.b0.s.m0.h)) {
                    c.a.b0.s.m0.h hVar = (c.a.b0.s.m0.h) pVar.f(3);
                    c.a.b0.s.m0.i K = v().K();
                    String str = hVar.a;
                    K.f2040b = str;
                    x0(str, hVar.f2038c);
                }
            } else {
                this.f1974i.s(pVar.g(1), pVar.g(2), pVar.f(3));
            }
        }
    }

    public void e0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.f1974i.o(z);
        }
    }

    public void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.f1974i.u();
        }
    }

    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.f1974i.v();
        }
    }

    @Override // c.a.b0.s.j0.o
    @Nullable
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f1974i.c() : (View) invokeV.objValue;
    }

    @Override // c.a.b0.s.f0.j
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? new int[]{4, 3, 1, 2} : (int[]) invokeV.objValue;
    }

    public void h0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (this.f1974i instanceof c.a.b0.s.i0.b)) {
            return;
        }
        p0(null);
        c.a.b0.s.i0.a aVar = this.f1974i;
        this.f1974i = new c.a.b0.s.i0.b();
        c.a.b0.s.p0.e.a().c(aVar);
    }

    public final void i0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || v().X()) {
            return;
        }
        v().k0();
    }

    public void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.f1974i.y();
        }
    }

    @Override // c.a.b0.s.j0.b, c.a.b0.s.f0.j
    public void k(@NonNull c.a.b0.s.c0.p pVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048601, this, pVar) == null) && "interactive_event_error".equals(pVar.c())) {
            this.f1974i.r();
        }
    }

    public void k0(int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            int e2 = this.f1974i.e();
            if (e2 > 1 && i2 > (i3 = e2 - 1)) {
                i2 = i3;
            }
            this.f1974i.z(i2 * 1000);
        }
    }

    @Override // c.a.b0.s.j0.b, c.a.b0.s.f0.j
    public void l(@NonNull c.a.b0.s.c0.p pVar) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, pVar) == null) {
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
                v().l();
            } else if (c2 == 1) {
                k0(pVar.g(1));
                i0();
                this.f1974i.y();
            } else if (c2 != 2) {
            } else {
                int g2 = pVar.g(19);
                Object f2 = pVar.f(31);
                if (f2 instanceof c.a.b0.s.m0.h) {
                    String str = ((c.a.b0.s.m0.h) f2).a;
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    O(str);
                    k0(g2);
                }
            }
        }
    }

    public void l0(int i2, int i3) {
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048604, this, i2, i3) == null) {
            int f2 = this.f1974i.f();
            if (f2 > 1 && i2 > (i4 = f2 - 1)) {
                i2 = i4;
            }
            this.f1974i.A(i2, i3);
        }
    }

    public void m0(Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, bool) == null) {
            this.f1975j = bool.booleanValue();
        }
    }

    public void n0(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
            this.f1974i.B(str);
        }
    }

    @Override // c.a.b0.s.j0.b, c.a.b0.s.f0.j
    public void o(@NonNull c.a.b0.s.c0.p pVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048607, this, pVar) == null) && this.f1975j && SystemEvent.ACTION_VOLUME_CHANGED.equals(pVar.c())) {
            e0(pVar.g(5) <= 0);
        }
    }

    public void o0(@Nullable HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, hashMap) == null) {
            this.f1974i.D(hashMap);
        }
    }

    public void p0(@Nullable c.a.b0.s.i0.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, eVar) == null) {
            this.f1974i.E(eVar);
        }
    }

    public void q0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            this.f1974i.F(z);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // c.a.b0.s.j0.b, c.a.b0.s.f0.j
    public void r(@NonNull c.a.b0.s.c0.p pVar) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, pVar) == null) {
            String c3 = pVar.c();
            switch (c3.hashCode()) {
                case -1929694922:
                    if (c3.equals("internal_sync_control_event_resume")) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1106918114:
                    if (c3.equals("internal_sync_control_event_prepare")) {
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
                    if (c3.equals("internal_sync_control_event_stop")) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 745698331:
                    if (c3.equals("internal_sync_event_start")) {
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
                    if (c3.equals("internal_sync_control_event_pause")) {
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
                    l0(pVar.g(5) * 1000, pVar.h(12, 3));
                    return;
                case 1:
                    l0(pVar.g(5), pVar.h(12, 3));
                    return;
                case 2:
                    g0();
                    return;
                case 3:
                    if (getContentView() != null) {
                        getContentView().setVisibility(0);
                    }
                    y0();
                    return;
                case 4:
                    f0();
                    return;
                case 5:
                    j0();
                    return;
                case 6:
                    z0();
                    return;
                default:
                    return;
            }
        }
    }

    public void r0(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, str) == null) {
            this.f1974i.G(str);
        }
    }

    @Override // c.a.b0.s.j0.b
    public void s(@NonNull c.a.b0.s.k0.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, cVar) == null) {
            super.s(cVar);
            cVar.b(this.f1976k);
            this.f1974i.a(cVar);
        }
    }

    public void s0(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, str) == null) {
            this.f1974i.H(str);
        }
    }

    @Override // c.a.b0.s.j0.b
    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            if (z() != null) {
                z().f(this.f1976k);
            }
            super.t();
            this.f1974i.Q();
        }
    }

    public void t0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
        }
    }

    public void u0(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048617, this, f2) == null) {
            this.f1974i.I(f2);
        }
    }

    public void v0(String str, @NonNull HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048618, this, str, hashMap) == null) {
            this.f1974i.K(str, hashMap);
        }
    }

    public void w0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048619, this, i2) == null) {
            this.f1974i.L(i2);
        }
    }

    public void x0(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048620, this, str, z) == null) {
            this.f1974i.M(str, z);
        }
    }

    public void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            this.f1974i.N();
        }
    }

    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            this.f1974i.O();
        }
    }
}
