package c.a.a0.v.b0;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.constants.PlayerStatus;
import com.baidu.nadcore.player.ui.BdLayerTitleBarView;
import com.baidu.searchbox.player.event.InteractiveEvent;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class l extends g implements BdLayerTitleBarView.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public BdLayerTitleBarView f1673b;

    public l() {
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

    @Override // c.a.a0.v.b0.h
    @NonNull
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f1673b : (View) invokeV.objValue;
    }

    @Override // c.a.a0.v.b0.a
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f1673b = new BdLayerTitleBarView(getContext());
            this.f1673b.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
            this.f1673b.setVisibility(4);
            this.f1673b.setListener(this);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // c.a.a0.v.b0.a
    public void k(@NonNull c.a.a0.v.c0.p pVar) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pVar) == null) {
            String c3 = pVar.c();
            switch (c3.hashCode()) {
                case -882902390:
                    if (c3.equals(PlayerEvent.ACTION_SET_DATA_SOURCE)) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -745690976:
                    if (c3.equals(InteractiveEvent.ACTION_INTERACTIVE_START)) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -552621273:
                    if (c3.equals(LayerEvent.ACTION_SWITCH_FULL)) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -552580917:
                    if (c3.equals(LayerEvent.ACTION_SWITCH_HALF)) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -461848373:
                    if (c3.equals(PlayerEvent.ACTION_ON_ERROR)) {
                        c2 = 1;
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
                case 250537257:
                    if (c3.equals(LayerEvent.ACTION_NET_ERROR_SHOW)) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 == 0 || c2 == 1 || c2 == 2) {
                if (q().V0()) {
                    this.f1673b.e(false, true, q().r1());
                }
            } else if (c2 != 4 && c2 != 5) {
                if (c2 == 6 && !q().Y()) {
                    s(true, false);
                }
            } else {
                this.f1673b.a(false);
            }
        }
    }

    @Override // c.a.a0.v.b0.a
    public void n(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, playerStatus, playerStatus2) == null) {
            super.n(playerStatus, playerStatus2);
            if (playerStatus == PlayerStatus.PLAYING && q().V0()) {
                c.a.a0.v.j0.l lVar = this.a;
                if (!(lVar instanceof c.a.a0.v.j0.c) || ((c.a.a0.v.j0.c) lVar).U()) {
                    return;
                }
                this.f1673b.a(true);
            }
        }
    }

    @Override // com.baidu.nadcore.player.ui.BdLayerTitleBarView.a
    public void onBack() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            q().d1(2);
        }
    }

    @Override // c.a.a0.v.b0.g
    public void s(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            super.s(z, z2);
            if (z) {
                if (q().V0() && q().f1() == 0) {
                    this.f1673b.e(true, !q().Y(), q().r1());
                }
            } else if (q().V0() && q().f1() == 0 && this.f1673b.getVisibility() != 4 && q().Y()) {
                this.f1673b.a(true);
            }
        }
    }
}
