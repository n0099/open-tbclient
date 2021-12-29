package c.a.c0.s.j0;

import android.os.Message;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.searchbox.player.event.ControlEvent;
import com.baidu.searchbox.player.event.InteractiveEvent;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
/* loaded from: classes.dex */
public class k extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean l;
    public c.a.c0.s.b0.k m;
    public c.a.c0.s.b0.e n;
    public c.a.c0.s.b0.i o;
    @Nullable
    public c.a.c0.s.b0.m p;
    public c.a.c0.s.b0.o q;
    public c.a.c0.s.b0.l r;

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
                return;
            }
        }
        this.l = false;
    }

    @Override // c.a.c0.s.j0.l
    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.a.c0.s.b0.k kVar = new c.a.c0.s.b0.k();
            this.m = kVar;
            J(kVar);
            c.a.c0.s.b0.m mVar = new c.a.c0.s.b0.m();
            this.p = mVar;
            J(mVar);
            c.a.c0.s.b0.l lVar = new c.a.c0.s.b0.l();
            this.r = lVar;
            J(lVar);
            J(new c.a.c0.s.b0.n());
            c.a.c0.s.b0.o oVar = new c.a.c0.s.b0.o();
            this.q = oVar;
            J(oVar);
            X();
            Y();
            J(new c.a.c0.s.b0.p());
            J(new c.a.c0.s.b0.j());
            Z();
        }
    }

    public void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.c0.s.b0.f fVar = new c.a.c0.s.b0.f();
            this.n = fVar;
            J(fVar);
        }
    }

    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.c0.s.b0.i iVar = new c.a.c0.s.b0.i();
            this.o = iVar;
            J(iVar);
        }
    }

    public void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public void a0() {
        c.a.c0.s.b0.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (eVar = this.n) == null) {
            return;
        }
        eVar.s();
    }

    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    public boolean c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.c0.s.j0.c, c.a.c0.s.j0.l, c.a.c0.s.j0.b, c.a.c0.s.f0.j
    public void d(@NonNull c.a.c0.s.c0.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, pVar) == null) {
            super.d(pVar);
            if (PlayerEvent.ACTION_PLAYER_DETACH.equals(pVar.c())) {
                V(false);
            } else if (PlayerEvent.ACTION_ON_ERROR.equals(pVar.c())) {
                V(false);
            }
        }
    }

    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f2415h.removeMessages(0);
        }
    }

    public final void e0(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048585, this, z) == null) && c.a.c0.s.v0.r.f()) {
            int a = z ? c.a.c0.s.v0.d.a(this.f2422i, 20.0f) : 0;
            T t = this.f2422i;
            ((FrameLayout) t).setPadding(((FrameLayout) t).getPaddingLeft(), ((FrameLayout) this.f2422i).getPaddingTop(), ((FrameLayout) this.f2422i).getPaddingRight(), a);
        }
    }

    public void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            c.a.c0.s.v0.r.k(this);
        }
    }

    public void g0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            if (z) {
                if (u().V0()) {
                    return;
                }
                u().c1(1);
            } else if (u().V0()) {
                u().d1(1);
            }
        }
    }

    @Override // c.a.c0.s.j0.l, c.a.c0.s.f0.j
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? new int[]{4, 2, 3, 5, 1, 8} : (int[]) invokeV.objValue;
    }

    public void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
        }
    }

    public void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
        }
    }

    @Override // c.a.c0.s.j0.l, c.a.c0.s.j0.b, c.a.c0.s.f0.j
    public void j(@NonNull c.a.c0.s.c0.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, pVar) == null) {
            super.j(pVar);
            if (InteractiveEvent.ACTION_SWITCH_INTERACTIVE_KERNEL.equals(pVar.c())) {
                if (pVar.d(9)) {
                    h0();
                } else {
                    i0();
                }
            }
        }
    }

    public final void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.f2415h.removeMessages(0);
            Iterator it = this.f2423j.iterator();
            while (it.hasNext()) {
                ((c.a.c0.s.b0.g) it.next()).q();
            }
            this.l = false;
        }
    }

    @Override // c.a.c0.s.j0.c, c.a.c0.s.j0.l, c.a.c0.s.j0.b, c.a.c0.s.f0.j
    public void k(@NonNull c.a.c0.s.c0.p pVar) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, pVar) == null) {
            super.k(pVar);
            String c3 = pVar.c();
            int hashCode = c3.hashCode();
            if (hashCode == -552621273) {
                if (c3.equals(LayerEvent.ACTION_SWITCH_FULL)) {
                    c2 = 1;
                }
                c2 = 65535;
            } else if (hashCode != -552580917) {
                if (hashCode == -21461611 && c3.equals(LayerEvent.ACTION_TOUCH_DOWN)) {
                    c2 = 2;
                }
                c2 = 65535;
            } else {
                if (c3.equals(LayerEvent.ACTION_SWITCH_HALF)) {
                    c2 = 0;
                }
                c2 = 65535;
            }
            if (c2 == 0) {
                c.a.c0.s.v0.r.i(this);
                V(false);
                c.a.c0.s.c0.p w = c.a.c0.s.c0.f.w(LayerEvent.ACTION_BARRAGE_EDIT_VIEW_VISIBLE_STATUS);
                w.n(16, Boolean.FALSE);
                F(w);
                if (this.l) {
                    k0();
                    this.f2415h.removeMessages(0);
                    this.f2415h.sendEmptyMessageDelayed(0, 2000L);
                }
                e0(false);
            } else if (c2 != 1) {
                if (c2 != 2) {
                    return;
                }
                this.f2415h.removeMessages(0);
                this.l = false;
            } else {
                u().f1();
                f0();
                V(c0());
                a0();
                b0();
                e0(true);
            }
        }
    }

    public final void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            Iterator it = this.f2423j.iterator();
            while (it.hasNext()) {
                ((c.a.c0.s.b0.g) it.next()).r();
            }
        }
    }

    @Override // c.a.c0.s.j0.l, c.a.c0.s.j0.b, c.a.c0.s.j0.o
    public void onLayerRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onLayerRelease();
        }
    }

    @Override // c.a.c0.s.j0.c, c.a.c0.s.j0.l, c.a.c0.s.j0.b, c.a.c0.s.f0.j
    public void q(@NonNull c.a.c0.s.c0.p pVar) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, pVar) == null) {
            super.q(pVar);
            String c3 = pVar.c();
            int hashCode = c3.hashCode();
            if (hashCode == 720027695) {
                if (c3.equals(ControlEvent.ACTION_PAUSE)) {
                    c2 = 1;
                }
                c2 = 65535;
            } else if (hashCode != 723345051) {
                if (hashCode == 906917140 && c3.equals(ControlEvent.ACTION_RESUME)) {
                    c2 = 2;
                }
                c2 = 65535;
            } else {
                if (c3.equals(ControlEvent.ACTION_START)) {
                    c2 = 0;
                }
                c2 = 65535;
            }
            if (c2 == 0) {
                V(false);
                BdVideoSeries o1 = u().o1();
                if (o1 == null || !o1.getSelectedVideo().getShowTitle()) {
                    return;
                }
                this.f2415h.removeMessages(0);
                if (!u().V0()) {
                    k0();
                }
                this.f2415h.sendEmptyMessageDelayed(0, 2000L);
                this.l = true;
            } else if (c2 != 1) {
                if (c2 != 2) {
                    return;
                }
                T(3000);
            } else if (pVar.g(11) != 2 || u().p1()) {
            } else {
                d0();
                V(true);
                S();
            }
        }
    }

    @Override // c.a.c0.s.j0.c, c.a.c0.s.j0.l, c.a.c0.s.j0.b
    public void z(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, message) == null) {
            super.z(message);
            if (message.what == 0) {
                j0();
                V(false);
            }
        }
    }
}
