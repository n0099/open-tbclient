package c.a.b0.v.j0;

import android.annotation.SuppressLint;
import android.os.Message;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.b0.v.v;
import com.baidu.android.imsdk.internal.Constants;
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
public abstract class c extends h<FrameLayout, c.a.b0.v.b0.g> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean k;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f2137e;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2137e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f2137e.V(false);
            }
        }
    }

    public c() {
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

    @Override // c.a.b0.v.j0.l
    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f2140i = new FrameLayout(this.f2135g);
        }
    }

    public void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f2136h.removeMessages(1);
        }
    }

    public void T(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            S();
            this.f2136h.sendMessageDelayed(this.f2136h.obtainMessage(1), i2);
        }
    }

    public boolean U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.k : invokeV.booleanValue;
    }

    public void V(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            W(z, false);
        }
    }

    public void W(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.f2136h.removeMessages(2);
            boolean z3 = z && (!v.W0() || !u().V0());
            if (z3) {
                T(3000);
                this.k = true;
            } else {
                S();
                this.k = false;
            }
            Iterator it = this.f2141j.iterator();
            while (it.hasNext()) {
                ((c.a.b0.v.b0.g) it.next()).p(z3, z2);
            }
            c.a.b0.v.c0.p w = c.a.b0.v.c0.f.w(LayerEvent.ACTION_PANEL_VISIBLE_CHANGED);
            w.n(9, Boolean.valueOf(z3));
            F(w);
            if (u().V0() && c.a.b0.v.v0.j.i(getActivity())) {
                c.a.b0.v.v0.j.o(c.a.b0.v.v0.j.e(getActivity()), true);
            }
            u().y().y(z3);
        }
    }

    @Override // c.a.b0.v.j0.l, c.a.b0.v.j0.b, c.a.b0.v.f0.j
    public void d(@NonNull c.a.b0.v.c0.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, pVar) == null) {
            if (PlayerEvent.ACTION_ON_COMPLETE.equals(pVar.c())) {
                V(false);
            } else if (PlayerEvent.ACTION_ON_ERROR.equals(pVar.c())) {
                V(false);
            }
            M(pVar);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // c.a.b0.v.j0.l, c.a.b0.v.j0.b, c.a.b0.v.f0.j
    public void k(@NonNull c.a.b0.v.c0.p pVar) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, pVar) == null) {
            String c3 = pVar.c();
            switch (c3.hashCode()) {
                case -1814572281:
                    if (c3.equals(LayerEvent.ACTION_SPEED_CLICK)) {
                        c2 = '\b';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1225548796:
                    if (c3.equals(LayerEvent.ACTION_PRAISE_ANIM_START)) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -915923721:
                    if (c3.equals(LayerEvent.ACTION_ADJUST_VOLUME)) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -361192620:
                    if (c3.equals(LayerEvent.ACTION_CLARITY_CLICK)) {
                        c2 = '\t';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -316059751:
                    if (c3.equals(LayerEvent.ACTION_ADJUST_LIGHT)) {
                        c2 = 7;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -150198673:
                    if (c3.equals(LayerEvent.ACTION_CLICK_NET_TIP)) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -21461611:
                    if (c3.equals(LayerEvent.ACTION_TOUCH_DOWN)) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 555655894:
                    if (c3.equals(LayerEvent.ACTION_GOODS_CLICK)) {
                        c2 = '\n';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1231554669:
                    if (c3.equals(LayerEvent.ACTION_LOCK_SCREEN)) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1249368243:
                    if (c3.equals(LayerEvent.ACTION_LONG_PRESS)) {
                        c2 = 11;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1626817018:
                    if (c3.equals(LayerEvent.ACTION_SHOW_FACE_AI_HEAD_BOX)) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 2064424334:
                    if (c3.equals(LayerEvent.ACTION_POSITION_SLIDE)) {
                        c2 = 5;
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
                    S();
                    break;
                case 1:
                    V(!this.k);
                    break;
                case 2:
                    this.f2136h.postDelayed(new a(this), 100L);
                    break;
                case 3:
                    V(true);
                    v().h();
                    break;
                case 4:
                case 5:
                case 6:
                case 7:
                case '\b':
                case '\t':
                case '\n':
                case 11:
                    V(false);
                    break;
            }
            M(pVar);
        }
    }

    @Override // c.a.b0.v.j0.l, c.a.b0.v.j0.b, c.a.b0.v.j0.o
    public void onContainerDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onContainerDetach();
            V(false);
        }
    }

    @Override // c.a.b0.v.j0.l, c.a.b0.v.j0.b, c.a.b0.v.f0.j
    @SuppressLint({"WrongConstant"})
    public void q(@NonNull c.a.b0.v.c0.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, pVar) == null) {
            if (ControlEvent.ACTION_SHOW_TIP.equals(pVar.c())) {
                V(false);
            }
            M(pVar);
        }
    }

    @Override // c.a.b0.v.j0.l, c.a.b0.v.j0.b
    public void z(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, message) == null) {
            super.z(message);
            if (message.what == 1) {
                V(false);
            }
        }
    }
}
