package c.a.a0.v.b0;

import android.view.View;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import c.a.a0.v.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.constants.PlayerStatus;
import com.baidu.searchbox.player.event.ControlEvent;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.searchbox.player.event.SystemEvent;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.badge.BadgeDrawable;
/* loaded from: classes.dex */
public class i extends g implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f1662b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f1663c;

    /* renamed from: d  reason: collision with root package name */
    public int f1664d;

    /* renamed from: e  reason: collision with root package name */
    public int f1665e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1666f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1667g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f1668h;

    public i() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1664d = -1;
        this.f1665e = -1;
        this.f1666f = false;
        this.f1667g = false;
        this.f1668h = false;
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (!C() && c.a.a0.v.v0.k.c(getContext()) != 0) {
                if (this.f1663c && !B()) {
                    this.f1662b.setVisibility(0);
                } else if (this.f1666f) {
                    this.f1662b.setVisibility(0);
                } else {
                    this.f1662b.setVisibility(4);
                }
            } else if (F()) {
                this.f1662b.setVisibility(0);
            } else {
                this.f1662b.setVisibility(4);
            }
            ImageView imageView = this.f1662b;
            if (imageView == null || imageView.getVisibility() == 0) {
                return;
            }
            x();
        }
    }

    public boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f1668h && !C() : invokeV.booleanValue;
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? c.a.a0.v.e.T() : invokeV.booleanValue;
    }

    public final void D(c.a.a0.v.c0.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, pVar) == null) {
            L(pVar.d(16));
        }
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f1663c = q().f1() == 0;
            A();
        }
    }

    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            c.a.a0.v.f q = q();
            c.a.a0.v.j0.f a = c.a.a0.v.v0.l.a(q().v().getLayerList());
            return (q.Q() || q.R() || q.a0() || (a != null && a.getContentView().getVisibility() == 0)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            boolean C = C();
            if (C && c.a.a0.v.v0.k.c(getContext()) == 0) {
                c.a.a0.v.v0.k.d(getContext(), (int) (c.a.a0.v.v0.k.b(getContext()) * 0.35d));
            }
            J(C);
            boolean z = !C;
            K(z);
            q().s0(z);
            c.a.a0.v.q0.b.c().d(c.a.a0.v.c0.f.w(LayerEvent.ACTION_MUTE_SYNC_TO_ALL_PLAYER));
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            boolean z = q().X() || c.a.a0.v.v0.k.c(getContext()) <= 0;
            z(z);
            q().w0(z);
            K(z);
        }
    }

    public void J(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
        }
    }

    public void K(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            if (this.f1667g) {
                if (!z) {
                    if (!this.f1666f) {
                        this.f1662b.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.obfuscated_res_0x7f080df6));
                    } else {
                        this.f1662b.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.obfuscated_res_0x7f080df3));
                    }
                } else if (!this.f1666f) {
                    this.f1662b.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.obfuscated_res_0x7f080df0));
                } else {
                    this.f1662b.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.obfuscated_res_0x7f080ded));
                }
                x();
            } else if (!z && c.a.a0.v.v0.k.c(getContext()) != 0) {
                if (!this.f1666f) {
                    this.f1662b.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.obfuscated_res_0x7f080def));
                } else {
                    this.f1662b.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.obfuscated_res_0x7f080dee));
                }
                x();
            } else {
                if (!this.f1666f) {
                    this.f1662b.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.obfuscated_res_0x7f080df5));
                } else {
                    this.f1662b.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.obfuscated_res_0x7f080df4));
                }
                G();
            }
        }
    }

    public void L(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            M(z, true);
        }
    }

    public void M(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f1662b.getLayoutParams();
            boolean z3 = true;
            if (!((q().V0() && q().f1() == 1) ? false : false) && !z) {
                layoutParams.bottomMargin = 0;
                layoutParams.leftMargin = (int) getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f07052e);
            } else if (z2) {
                int i = this.f1665e;
                if (i == -1) {
                    i = (int) getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f07052b);
                }
                layoutParams.bottomMargin = i;
                layoutParams.leftMargin = this.f1664d;
            } else {
                layoutParams.bottomMargin = 0;
                layoutParams.leftMargin = (int) getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f07052e);
            }
            this.f1662b.setLayoutParams(layoutParams);
        }
    }

    @Override // c.a.a0.v.b0.h
    @NonNull
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f1662b : (View) invokeV.objValue;
    }

    @Override // c.a.a0.v.b0.a
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            ImageView imageView = new ImageView(getContext());
            this.f1662b = imageView;
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            this.f1662b.setOnClickListener(this);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f07052f), (int) getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f07052c));
            layoutParams.gravity = BadgeDrawable.BOTTOM_START;
            if (this.f1664d == -1) {
                this.f1664d = (int) getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f07052e);
            }
            layoutParams.leftMargin = this.f1664d;
            this.f1662b.setLayoutParams(layoutParams);
            this.f1662b.setVisibility(8);
            if (this.a.x() != null) {
                I();
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // c.a.a0.v.b0.a
    public void k(@NonNull c.a.a0.v.c0.p pVar) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, pVar) == null) {
            String c3 = pVar.c();
            switch (c3.hashCode()) {
                case -1759675333:
                    if (c3.equals(PlayerEvent.ACTION_GO_BACK_OR_FOREGROUND)) {
                        c2 = '\r';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1009727513:
                    if (c3.equals(LayerEvent.ACTION_SHOW_VOLUME_BAR)) {
                        c2 = 17;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -849541738:
                    if (c3.equals(LayerEvent.ACTION_BARRAGE_CLICK)) {
                        c2 = 14;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -552621273:
                    if (c3.equals(LayerEvent.ACTION_SWITCH_FULL)) {
                        c2 = '\t';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -552580917:
                    if (c3.equals(LayerEvent.ACTION_SWITCH_HALF)) {
                        c2 = '\n';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -461848373:
                    if (c3.equals(PlayerEvent.ACTION_ON_ERROR)) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -333704320:
                    if (c3.equals(ControlEvent.ACTION_SHOW_TIP)) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -316059751:
                    if (c3.equals(LayerEvent.ACTION_ADJUST_LIGHT)) {
                        c2 = '\b';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -150198673:
                    if (c3.equals(LayerEvent.ACTION_CLICK_NET_TIP)) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -14542718:
                    if (c3.equals(LayerEvent.ACTION_HIDE_VOLUME_BAR)) {
                        c2 = 18;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 14382657:
                    if (c3.equals(ControlEvent.ACTION_STATUS_SYNC)) {
                        c2 = 16;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 154871702:
                    if (c3.equals(PlayerEvent.ACTION_ON_COMPLETE)) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 250537257:
                    if (c3.equals(LayerEvent.ACTION_NET_ERROR_SHOW)) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 723345051:
                    if (c3.equals(ControlEvent.ACTION_START)) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1231554669:
                    if (c3.equals(LayerEvent.ACTION_LOCK_SCREEN)) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1586388829:
                    if (c3.equals(LayerEvent.ACTION_BARRAGE_EDIT_VIEW_VISIBLE_STATUS)) {
                        c2 = 11;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1673877948:
                    if (c3.equals(LayerEvent.ACTION_MUTE_SYNC_TO_ALL_PLAYER)) {
                        c2 = 15;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1822725860:
                    if (c3.equals(SystemEvent.ACTION_VOLUME_CHANGED)) {
                        c2 = '\f';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 2064424334:
                    if (c3.equals(LayerEvent.ACTION_POSITION_SLIDE)) {
                        c2 = 7;
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
                case 1:
                case 2:
                case 3:
                    this.f1662b.setVisibility(4);
                    return;
                case 4:
                    if (q().V0() && q().f1() == 1) {
                        ImageView imageView = this.f1662b;
                        if (F() && !B()) {
                            r6 = 0;
                        }
                        imageView.setVisibility(r6);
                        return;
                    }
                    A();
                    return;
                case 5:
                    if (C()) {
                        if (v.W0()) {
                            if (this.f1662b.getVisibility() == 0) {
                                this.f1662b.setVisibility(4);
                                return;
                            }
                            return;
                        } else if (this.f1662b.getVisibility() != 0) {
                            this.f1662b.setVisibility(0);
                            return;
                        } else {
                            return;
                        }
                    }
                    this.f1662b.setVisibility(4);
                    return;
                case 6:
                    this.f1662b.setVisibility(B() ? 4 : 0);
                    return;
                case 7:
                case '\b':
                    if (C()) {
                        this.f1662b.setVisibility(0);
                        return;
                    } else {
                        this.f1662b.setVisibility(4);
                        return;
                    }
                case '\t':
                    this.f1667g = true;
                    K(C());
                    E();
                    return;
                case '\n':
                    this.f1667g = false;
                    K(C());
                    this.f1663c = false;
                    L(false);
                    A();
                    return;
                case 11:
                    D(pVar);
                    return;
                case '\f':
                    if (q().a0() || q().Q()) {
                        return;
                    }
                    int g2 = pVar.g(5);
                    K(g2 <= 0);
                    A();
                    boolean C = C();
                    if ((!C || g2 <= 0) && (C || g2 != 0)) {
                        return;
                    }
                    H();
                    A();
                    return;
                case '\r':
                    if (pVar.d(4)) {
                        I();
                        A();
                        return;
                    }
                    return;
                case 14:
                    L(pVar.d(11));
                    return;
                case 15:
                case 16:
                    I();
                    return;
                case 17:
                    this.f1666f = true;
                    K(C());
                    if (this.f1662b.getVisibility() != 0) {
                        this.f1662b.setVisibility(0);
                        return;
                    }
                    return;
                case 18:
                    this.f1666f = false;
                    K(C());
                    if (this.f1662b.getVisibility() == 0) {
                        if ((!this.f1663c || B()) && !C()) {
                            this.f1662b.setVisibility(8);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // c.a.a0.v.b0.a
    public void n(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, playerStatus, playerStatus2) == null) {
            super.n(playerStatus, playerStatus2);
            if ((PlayerStatus.PREPARING == playerStatus || PlayerStatus.PLAYING == playerStatus) && this.f1663c && this.f1662b.getVisibility() != 0 && !B()) {
                this.f1662b.setVisibility(0);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, view) == null) && view.equals(this.f1662b) && !this.f1666f) {
            H();
            A();
        }
    }

    @Override // c.a.a0.v.b0.g
    public void s(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            boolean z3 = false;
            if (((v.W0() && q().V0()) ? false : true) && z) {
                z3 = true;
            }
            this.f1663c = z3;
            if (q().V0()) {
                v(this.f1663c);
            } else {
                w(this.f1663c);
            }
        }
    }

    public int v(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048595, this, z)) == null) {
            int i = 0;
            if (!q().V0() || q().f1() != 1) {
                if (z) {
                    y();
                    return 4;
                }
                if (C() && F()) {
                    this.f1662b.setVisibility(0);
                } else if (this.f1666f) {
                    this.f1662b.setVisibility(0);
                } else {
                    this.f1662b.setVisibility(4);
                }
                return 0;
            } else if (z) {
                this.f1662b.setVisibility((!F() || B()) ? 8 : 8);
                return 4;
            } else {
                if ((C() || c.a.a0.v.v0.k.c(getContext()) == 0) && F()) {
                    this.f1662b.setVisibility(0);
                } else if (this.f1666f) {
                    this.f1662b.setVisibility(0);
                } else {
                    this.f1662b.setVisibility(4);
                }
                return 0;
            }
        }
        return invokeZ.intValue;
    }

    public int w(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048596, this, z)) == null) {
            if (z) {
                this.f1662b.setVisibility(0);
                return 4;
            }
            A();
            return 0;
        }
        return invokeZ.intValue;
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            Animation a = c.a.a0.v.v0.f.a();
            if (this.f1662b.getVisibility() != 0) {
                this.f1662b.setVisibility(0);
                this.f1662b.startAnimation(a);
            }
        }
    }

    public boolean z(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048599, this, z)) == null) ? z : invokeZ.booleanValue;
    }
}
