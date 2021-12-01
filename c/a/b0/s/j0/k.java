package c.a.b0.s.j0;

import android.os.Message;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.searchbox.player.event.ControlEvent;
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
    public c.a.b0.s.b0.k m;
    public c.a.b0.s.b0.e n;
    public c.a.b0.s.b0.i o;
    @Nullable
    public c.a.b0.s.b0.m p;
    public c.a.b0.s.b0.o q;
    public c.a.b0.s.b0.l r;

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

    @Override // c.a.b0.s.j0.c, c.a.b0.s.j0.l, c.a.b0.s.j0.b
    public void A(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
            super.A(message);
            if (message.what == 0) {
                r0();
                d0(false);
            }
        }
    }

    @Override // c.a.b0.s.j0.l
    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.b0.s.b0.k kVar = new c.a.b0.s.b0.k();
            this.m = kVar;
            O(kVar);
            c.a.b0.s.b0.m mVar = new c.a.b0.s.b0.m();
            this.p = mVar;
            O(mVar);
            c.a.b0.s.b0.l lVar = new c.a.b0.s.b0.l();
            this.r = lVar;
            O(lVar);
            O(new c.a.b0.s.b0.n());
            c.a.b0.s.b0.o oVar = new c.a.b0.s.b0.o();
            this.q = oVar;
            O(oVar);
            f0();
            g0();
            O(new c.a.b0.s.b0.p());
            O(new c.a.b0.s.b0.j());
            h0();
        }
    }

    @Override // c.a.b0.s.j0.c, c.a.b0.s.j0.l, c.a.b0.s.j0.b, c.a.b0.s.f0.j
    public void e(@NonNull c.a.b0.s.c0.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pVar) == null) {
            super.e(pVar);
            if (PlayerEvent.ACTION_PLAYER_DETACH.equals(pVar.c())) {
                d0(false);
            } else if (PlayerEvent.ACTION_ON_ERROR.equals(pVar.c())) {
                d0(false);
            }
        }
    }

    public void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.b0.s.b0.f fVar = new c.a.b0.s.b0.f();
            this.n = fVar;
            O(fVar);
        }
    }

    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c.a.b0.s.b0.i iVar = new c.a.b0.s.b0.i();
            this.o = iVar;
            O(iVar);
        }
    }

    @Override // c.a.b0.s.j0.l, c.a.b0.s.f0.j
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? new int[]{4, 2, 3, 5, 1, 8} : (int[]) invokeV.objValue;
    }

    public void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    public void i0() {
        c.a.b0.s.b0.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (eVar = this.n) == null) {
            return;
        }
        eVar.s();
    }

    public void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    @Override // c.a.b0.s.j0.l, c.a.b0.s.j0.b, c.a.b0.s.f0.j
    public void k(@NonNull c.a.b0.s.c0.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, pVar) == null) {
            super.k(pVar);
            if ("interactive_switch_interactive_kernel".equals(pVar.c())) {
                if (pVar.d(9)) {
                    p0();
                } else {
                    q0();
                }
            }
        }
    }

    public boolean k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.b0.s.j0.c, c.a.b0.s.j0.l, c.a.b0.s.j0.b, c.a.b0.s.f0.j
    public void l(@NonNull c.a.b0.s.c0.p pVar) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, pVar) == null) {
            super.l(pVar);
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
                c.a.b0.s.v0.r.i(this);
                d0(false);
                c.a.b0.s.c0.p w = c.a.b0.s.c0.f.w(LayerEvent.ACTION_BARRAGE_EDIT_VIEW_VISIBLE_STATUS);
                w.n(16, Boolean.FALSE);
                G(w);
                if (this.l) {
                    s0();
                    this.f1970h.removeMessages(0);
                    this.f1970h.sendEmptyMessageDelayed(0, 2000L);
                }
                m0(false);
            } else if (c2 != 1) {
                if (c2 != 2) {
                    return;
                }
                this.f1970h.removeMessages(0);
                this.l = false;
            } else {
                v().f1();
                n0();
                d0(k0());
                i0();
                j0();
                m0(true);
            }
        }
    }

    public void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f1970h.removeMessages(0);
        }
    }

    public final void m0(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048589, this, z) == null) && c.a.b0.s.v0.r.f()) {
            int a = z ? c.a.b0.s.v0.d.a(this.f1977i, 20.0f) : 0;
            T t = this.f1977i;
            ((FrameLayout) t).setPadding(((FrameLayout) t).getPaddingLeft(), ((FrameLayout) this.f1977i).getPaddingTop(), ((FrameLayout) this.f1977i).getPaddingRight(), a);
        }
    }

    public void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            c.a.b0.s.v0.r.k(this);
        }
    }

    public void o0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            if (z) {
                if (v().V0()) {
                    return;
                }
                v().c1(1);
            } else if (v().V0()) {
                v().d1(1);
            }
        }
    }

    @Override // c.a.b0.s.j0.l, c.a.b0.s.j0.b, c.a.b0.s.j0.o
    public void onLayerRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onLayerRelease();
        }
    }

    public void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
        }
    }

    public void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
        }
    }

    @Override // c.a.b0.s.j0.c, c.a.b0.s.j0.l, c.a.b0.s.j0.b, c.a.b0.s.f0.j
    public void r(@NonNull c.a.b0.s.c0.p pVar) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, pVar) == null) {
            super.r(pVar);
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
                d0(false);
                BdVideoSeries o1 = v().o1();
                if (o1 == null || !o1.getSelectedVideo().getShowTitle()) {
                    return;
                }
                this.f1970h.removeMessages(0);
                if (!v().V0()) {
                    s0();
                }
                this.f1970h.sendEmptyMessageDelayed(0, 2000L);
                this.l = true;
            } else if (c2 != 1) {
                if (c2 != 2) {
                    return;
                }
                b0(3000);
            } else if (pVar.g(11) != 2 || v().p1()) {
            } else {
                l0();
                d0(true);
                a0();
            }
        }
    }

    public final void r0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.f1970h.removeMessages(0);
            Iterator it = this.f1978j.iterator();
            while (it.hasNext()) {
                ((c.a.b0.s.b0.g) it.next()).q();
            }
            this.l = false;
        }
    }

    public final void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            Iterator it = this.f1978j.iterator();
            while (it.hasNext()) {
                ((c.a.b0.s.b0.g) it.next()).r();
            }
        }
    }
}
