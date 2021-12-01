package c.a.b0.s.d0;

import android.app.Activity;
import androidx.core.view.InputDeviceCompat;
import c.a.b0.s.j0.s;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.constants.PlayerStatus;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class k implements c.a.b0.s.f0.i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.b0.s.j0.i a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.b0.s.j0.i f1938b;

    public k() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // c.a.b0.s.f0.i
    public void a(c.a.b0.s.f player) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, player) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            i(player, player.u());
            c.a.b0.s.j0.i k2 = player.k();
            if (k2 != null) {
                if (!Intrinsics.areEqual(k2, this.f1938b)) {
                    j(this.f1938b);
                    this.f1938b = null;
                } else if (!Intrinsics.areEqual(k2, this.a)) {
                    j(this.a);
                    this.a = null;
                }
                j(k2);
            }
        }
    }

    @Override // c.a.b0.s.f0.i
    public c.a.b0.s.j0.i b(c.a.b0.s.f player, c.a.b0.s.j0.i iVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, player, iVar)) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            if (player.u1()) {
                iVar = h(player, player.u());
            }
            if (iVar == null) {
                iVar = f(player.o());
            }
            this.a = iVar;
            return iVar;
        }
        return (c.a.b0.s.j0.i) invokeLL.objValue;
    }

    @Override // c.a.b0.s.f0.i
    public void c(c.a.b0.s.f player, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, player, z) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            c.a.b0.s.j0.i iVar = this.a;
            if (iVar != null) {
                e(player, iVar);
                return;
            }
            if (this.f1938b == null) {
                this.f1938b = f(player.o());
            }
            e(player, this.f1938b);
        }
    }

    @Override // c.a.b0.s.f0.i
    public boolean d(c.a.b0.s.f player, c.a.b0.s.j0.i iVar) {
        InterceptResult invokeLL;
        String vid;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, player, iVar)) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            BdVideoSeries o1 = player.o1();
            if (o1 == null || (vid = o1.getVid()) == null) {
                return false;
            }
            Intrinsics.checkNotNullExpressionValue(vid, "player.videoSeries?.vid ?: return false");
            s sVar = (s) (!(iVar instanceof s) ? null : iVar);
            if (Intrinsics.areEqual(vid, sVar != null ? sVar.E0() : null)) {
                return PlayerStatus.isActiveStatus(iVar != null ? iVar.Y() : null);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void e(c.a.b0.s.f fVar, c.a.b0.s.j0.i iVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, fVar, iVar) == null) || iVar == null) {
            return;
        }
        fVar.e(iVar);
    }

    public final s f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (str == null) {
                str = "SysBuiltinKernel";
            }
            return new s(str);
        }
        return (s) invokeL.objValue;
    }

    public boolean g(c.a.b0.s.e player, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, player, str)) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            if (str == null || str.length() == 0) {
                return false;
            }
            c.a.b0.s.j0.i k2 = player.k();
            c.a.b0.s.v0.h.a("ReuseHelper: detach,cache is " + k2 + ",cacheKey is " + str);
            if (k2 != null) {
                k2.f0();
                c.a.b0.s.x.a.a().c(str, k2);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public c.a.b0.s.j0.i h(c.a.b0.s.e player, String str) {
        InterceptResult invokeLL;
        c.a.b0.s.i0.a a0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, player, str)) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            c.a.b0.s.j0.i b2 = c.a.b0.s.x.a.a().b(str);
            if (Intrinsics.areEqual((b2 == null || (a0 = b2.a0()) == null) ? null : Boolean.valueOf(a0.verify(player.o())), Boolean.TRUE)) {
                c.a.b0.s.x.a.a().d(str);
                player.A0(true);
                if (b2.v() != null) {
                    b2.v().k();
                    return b2;
                }
                return b2;
            }
            player.A0(false);
            return null;
        }
        return (c.a.b0.s.j0.i) invokeLL.objValue;
    }

    public void i(c.a.b0.s.f player, String str) {
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, player, str) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            if (player.u1() && player.b0() && !player.S() && (activity = player.getActivity()) != null && activity.isFinishing()) {
                c.a.b0.s.v0.h.a("performAutoDetachCache begin");
                c.a.b0.s.j0.i A = player.A();
                c.a.b0.s.j0.i iVar = this.a;
                if (Intrinsics.areEqual(iVar != null ? iVar.v() : null, player)) {
                    c.a.b0.s.v0.h.a("autoDetachCache,cacheKey:" + str + ", kernelLayer:" + A);
                    if (g(player, str)) {
                        this.a = null;
                    }
                } else if (this.a != null) {
                    c.a.b0.s.v0.h.a("detachCache,cacheKey:" + str + ", kernelLayer:" + A);
                    c.a.b0.s.j0.i iVar2 = this.a;
                    if (iVar2 != null) {
                        iVar2.f0();
                    }
                    c.a.b0.s.x.a.a().c(str, this.a);
                    this.a = null;
                }
            }
        }
    }

    public final void j(c.a.b0.s.j0.i iVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, iVar) == null) || iVar == null) {
            return;
        }
        iVar.f0();
        iVar.z0();
        iVar.h0();
    }
}
