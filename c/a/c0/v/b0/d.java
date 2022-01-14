package c.a.c0.v.b0;

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
public abstract class d extends e implements View.OnClickListener, c.a.c0.v.f0.l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public ViewGroup f2327i;

    /* renamed from: j  reason: collision with root package name */
    public BdLayerSeekBar f2328j;
    public int k;

    public d() {
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

    @Override // c.a.c0.v.b0.h
    @NonNull
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f2327i : (View) invokeV.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // c.a.c0.v.b0.e, c.a.c0.v.b0.a
    public void h(@NonNull c.a.c0.v.c0.p pVar) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pVar) == null) {
            super.h(pVar);
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
                    p(false, false);
                    this.f2328j.setPosition(pVar.g(2) + pVar.g(3));
                    return;
                case 1:
                    y(false);
                    return;
                case 2:
                    y(true);
                    return;
                case 3:
                    w();
                    return;
                case 4:
                case 5:
                    p(false, false);
                    return;
                case 6:
                default:
                    return;
                case 7:
                    z(pVar.g(1), pVar.g(2), pVar.g(3));
                    return;
                case '\b':
                    this.f2328j.setVisibility(0);
                    return;
            }
        }
    }

    @Override // c.a.c0.v.b0.a
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.i();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
        }
    }

    @Override // c.a.c0.v.f0.l
    public void onProgressChanged(BdThumbSeekBar bdThumbSeekBar, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{bdThumbSeekBar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
        }
    }

    @Override // c.a.c0.v.f0.l
    public void onStartTrackingTouch(BdThumbSeekBar bdThumbSeekBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdThumbSeekBar) == null) {
            this.k = n().C();
            o().S();
        }
    }

    @Override // c.a.c0.v.f0.l
    public void onStopTrackingTouch(BdThumbSeekBar bdThumbSeekBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bdThumbSeekBar) == null) {
            if (x()) {
                c.a.c0.v.v0.h.a("seek action has been intercepted");
                return;
            }
            c.a.c0.v.c0.p w = c.a.c0.v.c0.f.w(LayerEvent.ACTION_SEEK);
            w.n(1, Integer.valueOf(bdThumbSeekBar.getProgress()));
            l(w);
            n().y().F(this.k, bdThumbSeekBar.getProgress());
            o().T(3000);
            this.k = 0;
        }
    }

    @Override // c.a.c0.v.b0.g
    public void p(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
        }
    }

    @Override // c.a.c0.v.b0.g
    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.q();
            this.f2328j.setVisibility(0);
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f2328j.setDuration(n().r());
        }
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            if (z) {
                this.f2328j.switchToFull();
            } else {
                this.f2328j.switchToHalf();
            }
        }
    }

    public void z(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048588, this, i2, i3, i4) == null) {
            this.f2328j.syncPos(i2, i3, i4);
        }
    }
}
