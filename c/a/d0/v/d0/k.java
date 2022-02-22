package c.a.d0.v.d0;

import android.app.Activity;
import androidx.core.view.InputDeviceCompat;
import c.a.d0.v.j0.s;
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
public final class k implements c.a.d0.v.f0.i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.d0.v.j0.i a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.d0.v.j0.i f3275b;

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

    @Override // c.a.d0.v.f0.i
    public void a(c.a.d0.v.f player) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, player) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            i(player, player.u());
            c.a.d0.v.j0.i k = player.k();
            if (k != null) {
                if (!Intrinsics.areEqual(k, this.f3275b)) {
                    j(this.f3275b);
                    this.f3275b = null;
                } else if (!Intrinsics.areEqual(k, this.a)) {
                    j(this.a);
                    this.a = null;
                }
                j(k);
            }
        }
    }

    @Override // c.a.d0.v.f0.i
    public c.a.d0.v.j0.i b(c.a.d0.v.f player, c.a.d0.v.j0.i iVar) {
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
        return (c.a.d0.v.j0.i) invokeLL.objValue;
    }

    @Override // c.a.d0.v.f0.i
    public void c(c.a.d0.v.f player, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, player, z) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            c.a.d0.v.j0.i iVar = this.a;
            if (iVar != null) {
                e(player, iVar);
                return;
            }
            if (this.f3275b == null) {
                this.f3275b = f(player.o());
            }
            e(player, this.f3275b);
        }
    }

    @Override // c.a.d0.v.f0.i
    public boolean d(c.a.d0.v.f player, c.a.d0.v.j0.i iVar) {
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
            if (Intrinsics.areEqual(vid, sVar != null ? sVar.w0() : null)) {
                return PlayerStatus.isActiveStatus(iVar != null ? iVar.Q() : null);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void e(c.a.d0.v.f fVar, c.a.d0.v.j0.i iVar) {
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

    public boolean g(c.a.d0.v.e player, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, player, str)) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            if (str == null || str.length() == 0) {
                return false;
            }
            c.a.d0.v.j0.i k = player.k();
            c.a.d0.v.v0.h.a("ReuseHelper: detach,cache is " + k + ",cacheKey is " + str);
            if (k != null) {
                k.X();
                c.a.d0.v.x.a.a().c(str, k);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public c.a.d0.v.j0.i h(c.a.d0.v.e player, String str) {
        InterceptResult invokeLL;
        c.a.d0.v.i0.a S;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, player, str)) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            c.a.d0.v.j0.i b2 = c.a.d0.v.x.a.a().b(str);
            if (Intrinsics.areEqual((b2 == null || (S = b2.S()) == null) ? null : Boolean.valueOf(S.verify(player.o())), Boolean.TRUE)) {
                c.a.d0.v.x.a.a().d(str);
                player.A0(true);
                if (b2.u() != null) {
                    b2.u().k();
                    return b2;
                }
                return b2;
            }
            player.A0(false);
            return null;
        }
        return (c.a.d0.v.j0.i) invokeLL.objValue;
    }

    public void i(c.a.d0.v.f player, String str) {
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, player, str) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            if (player.u1() && player.b0() && !player.S() && (activity = player.getActivity()) != null && activity.isFinishing()) {
                c.a.d0.v.v0.h.a("performAutoDetachCache begin");
                c.a.d0.v.j0.i A = player.A();
                c.a.d0.v.j0.i iVar = this.a;
                if (Intrinsics.areEqual(iVar != null ? iVar.u() : null, player)) {
                    c.a.d0.v.v0.h.a("autoDetachCache,cacheKey:" + str + ", kernelLayer:" + A);
                    if (g(player, str)) {
                        this.a = null;
                    }
                } else if (this.a != null) {
                    c.a.d0.v.v0.h.a("detachCache,cacheKey:" + str + ", kernelLayer:" + A);
                    c.a.d0.v.j0.i iVar2 = this.a;
                    if (iVar2 != null) {
                        iVar2.X();
                    }
                    c.a.d0.v.x.a.a().c(str, this.a);
                    this.a = null;
                }
            }
        }
    }

    public final void j(c.a.d0.v.j0.i iVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, iVar) == null) || iVar == null) {
            return;
        }
        iVar.X();
        iVar.r0();
        iVar.Z();
    }
}
