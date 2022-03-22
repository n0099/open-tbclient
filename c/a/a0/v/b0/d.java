package c.a.a0.v.b0;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.ui.BdLayerSeekBar;
import com.baidu.nadcore.video.videoplayer.ui.full.BdThumbSeekBar;
import com.baidu.searchbox.player.event.ControlEvent;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public abstract class d extends e implements View.OnClickListener, c.a.a0.v.f0.l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f1655e;

    /* renamed from: f  reason: collision with root package name */
    public BdLayerSeekBar f1656f;

    /* renamed from: g  reason: collision with root package name */
    public int f1657g;

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void B(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (z) {
                this.f1656f.e();
            } else {
                this.f1656f.f();
            }
        }
    }

    public void C(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(Constants.METHOD_SEND_USER_MSG, this, i, i2, i3) == null) {
            this.f1656f.g(i, i2, i3);
        }
    }

    @Override // c.a.a0.v.f0.l
    public void a(BdThumbSeekBar bdThumbSeekBar, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{bdThumbSeekBar, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
        }
    }

    @Override // c.a.a0.v.f0.l
    public void b(BdThumbSeekBar bdThumbSeekBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bdThumbSeekBar) == null) {
            if (A()) {
                c.a.a0.v.v0.h.a("seek action has been intercepted");
                return;
            }
            c.a.a0.v.c0.p w = c.a.a0.v.c0.f.w(LayerEvent.ACTION_SEEK);
            w.n(1, Integer.valueOf(bdThumbSeekBar.getProgress()));
            o(w);
            q().y().F(this.f1657g, bdThumbSeekBar.getProgress());
            r().T(3000);
            this.f1657g = 0;
        }
    }

    @Override // c.a.a0.v.f0.l
    public void c(BdThumbSeekBar bdThumbSeekBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdThumbSeekBar) == null) {
            this.f1657g = q().C();
            r().S();
        }
    }

    @Override // c.a.a0.v.b0.h
    @NonNull
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f1655e : (View) invokeV.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // c.a.a0.v.b0.e, c.a.a0.v.b0.a
    public void k(@NonNull c.a.a0.v.c0.p pVar) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, pVar) == null) {
            super.k(pVar);
            String c3 = pVar.c();
            switch (c3.hashCode()) {
                case -1530009462:
                    if (c3.equals(ControlEvent.ACTION_SYNC_PROGRESS)) {
                        c2 = 7;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -882902390:
                    if (c3.equals(PlayerEvent.ACTION_SET_DATA_SOURCE)) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -552621273:
                    if (c3.equals(LayerEvent.ACTION_SWITCH_FULL)) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -552580917:
                    if (c3.equals(LayerEvent.ACTION_SWITCH_HALF)) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -525235558:
                    if (c3.equals(PlayerEvent.ACTION_ON_PREPARED)) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -461848373:
                    if (c3.equals(PlayerEvent.ACTION_ON_ERROR)) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 154871702:
                    if (c3.equals(PlayerEvent.ACTION_ON_COMPLETE)) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1610373035:
                    if (c3.equals(LayerEvent.ACTION_WAKE_UP_END)) {
                        c2 = '\b';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 2064424334:
                    if (c3.equals(LayerEvent.ACTION_POSITION_SLIDE)) {
                        c2 = 0;
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
                    s(false, false);
                    this.f1656f.setPosition(pVar.g(2) + pVar.g(3));
                    return;
                case 1:
                    B(false);
                    return;
                case 2:
                    B(true);
                    return;
                case 3:
                    z();
                    return;
                case 4:
                case 5:
                    s(false, false);
                    return;
                case 6:
                default:
                    return;
                case 7:
                    C(pVar.g(1), pVar.g(2), pVar.g(3));
                    return;
                case '\b':
                    this.f1656f.setVisibility(0);
                    return;
            }
        }
    }

    @Override // c.a.a0.v.b0.a
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.l();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view) == null) {
        }
    }

    @Override // c.a.a0.v.b0.g
    public void s(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
        }
    }

    @Override // c.a.a0.v.b0.g
    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.t();
            this.f1656f.setVisibility(0);
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f1656f.setDuration(q().r());
        }
    }
}
