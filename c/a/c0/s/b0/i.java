package c.a.c0.s.b0;

import android.view.View;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import c.a.c0.h0.q;
import c.a.c0.s.v;
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
import com.google.android.material.badge.BadgeDrawable;
import org.apache.commons.lang3.CharUtils;
/* loaded from: classes.dex */
public class i extends g implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f2325f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f2326g;

    /* renamed from: h  reason: collision with root package name */
    public int f2327h;

    /* renamed from: i  reason: collision with root package name */
    public int f2328i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f2329j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f2330k;
    public boolean l;

    public i() {
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
        this.f2327h = -1;
        this.f2328i = -1;
        this.f2329j = false;
        this.f2330k = false;
        this.l = false;
    }

    public final void A(c.a.c0.s.c0.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, pVar) == null) {
            I(pVar.d(16));
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f2326g = n().f1() == 0;
            x();
        }
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            c.a.c0.s.f n = n();
            c.a.c0.s.j0.f a = c.a.c0.s.v0.l.a(n().v().getLayerList());
            return (n.Q() || n.R() || n.a0() || (a != null && a.getContentView().getVisibility() == 0)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            boolean z = z();
            if (z && c.a.c0.s.v0.k.c(getContext()) == 0) {
                c.a.c0.s.v0.k.d(getContext(), (int) (c.a.c0.s.v0.k.b(getContext()) * 0.35d));
            }
            G(z);
            boolean z2 = !z;
            H(z2);
            n().s0(z2);
            c.a.c0.s.q0.b.c().d(c.a.c0.s.c0.f.w(LayerEvent.ACTION_MUTE_SYNC_TO_ALL_PLAYER));
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            boolean z = n().X() || c.a.c0.s.v0.k.c(getContext()) <= 0;
            w(z);
            n().w0(z);
            H(z);
        }
    }

    public void G(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
        }
    }

    public void H(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            if (this.f2330k) {
                if (!z) {
                    if (!this.f2329j) {
                        this.f2325f.setImageDrawable(ContextCompat.getDrawable(getContext(), q.nad_videoplayer_new_player_mute_open_selector_full));
                    } else {
                        this.f2325f.setImageDrawable(ContextCompat.getDrawable(getContext(), q.nad_videoplayer_new_player_mute_open_full));
                    }
                } else if (!this.f2329j) {
                    this.f2325f.setImageDrawable(ContextCompat.getDrawable(getContext(), q.nad_videoplayer_new_player_mute_close_selector_full));
                } else {
                    this.f2325f.setImageDrawable(ContextCompat.getDrawable(getContext(), q.nad_videoplayer_new_player_mute_close_full));
                }
                u();
            } else if (!z && c.a.c0.s.v0.k.c(getContext()) != 0) {
                if (!this.f2329j) {
                    this.f2325f.setImageDrawable(ContextCompat.getDrawable(getContext(), q.nad_videoplayer_new_player_mute_close_selector));
                } else {
                    this.f2325f.setImageDrawable(ContextCompat.getDrawable(getContext(), q.nad_videoplayer_new_player_mute_close_half));
                }
                u();
            } else {
                if (!this.f2329j) {
                    this.f2325f.setImageDrawable(ContextCompat.getDrawable(getContext(), q.nad_videoplayer_new_player_mute_open_selector));
                } else {
                    this.f2325f.setImageDrawable(ContextCompat.getDrawable(getContext(), q.nad_videoplayer_new_player_mute_open_half));
                }
                D();
            }
        }
    }

    public void I(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            J(z, true);
        }
    }

    public void J(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f2325f.getLayoutParams();
            boolean z3 = true;
            if (!((n().V0() && n().f1() == 1) ? false : false) && !z) {
                layoutParams.bottomMargin = 0;
                layoutParams.leftMargin = (int) getContext().getResources().getDimension(c.a.c0.h0.p.nad_videoplayer_bd_video_mute_leftmargin);
            } else if (z2) {
                int i2 = this.f2328i;
                if (i2 == -1) {
                    i2 = (int) getContext().getResources().getDimension(c.a.c0.h0.p.nad_videoplayer_bd_video_mute_buttomargin);
                }
                layoutParams.bottomMargin = i2;
                layoutParams.leftMargin = this.f2327h;
            } else {
                layoutParams.bottomMargin = 0;
                layoutParams.leftMargin = (int) getContext().getResources().getDimension(c.a.c0.h0.p.nad_videoplayer_bd_video_mute_leftmargin);
            }
            this.f2325f.setLayoutParams(layoutParams);
        }
    }

    @Override // c.a.c0.s.b0.a
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            ImageView imageView = new ImageView(getContext());
            this.f2325f = imageView;
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            this.f2325f.setOnClickListener(this);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) getContext().getResources().getDimension(c.a.c0.h0.p.nad_videoplayer_bd_video_mute_width), (int) getContext().getResources().getDimension(c.a.c0.h0.p.nad_videoplayer_bd_video_mute_height));
            layoutParams.gravity = BadgeDrawable.BOTTOM_START;
            if (this.f2327h == -1) {
                this.f2327h = (int) getContext().getResources().getDimension(c.a.c0.h0.p.nad_videoplayer_bd_video_mute_leftmargin);
            }
            layoutParams.leftMargin = this.f2327h;
            this.f2325f.setLayoutParams(layoutParams);
            this.f2325f.setVisibility(8);
            if (this.f2318e.x() != null) {
                F();
            }
        }
    }

    @Override // c.a.c0.s.b0.h
    @NonNull
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f2325f : (View) invokeV.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // c.a.c0.s.b0.a
    public void h(@NonNull c.a.c0.s.c0.p pVar) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, pVar) == null) {
            String c3 = pVar.c();
            switch (c3.hashCode()) {
                case -1759675333:
                    if (c3.equals(PlayerEvent.ACTION_GO_BACK_OR_FOREGROUND)) {
                        c2 = CharUtils.CR;
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
                    this.f2325f.setVisibility(4);
                    return;
                case 4:
                    if (n().V0() && n().f1() == 1) {
                        ImageView imageView = this.f2325f;
                        if (C() && !y()) {
                            r6 = 0;
                        }
                        imageView.setVisibility(r6);
                        return;
                    }
                    x();
                    return;
                case 5:
                    if (z()) {
                        if (v.W0()) {
                            if (this.f2325f.getVisibility() == 0) {
                                this.f2325f.setVisibility(4);
                                return;
                            }
                            return;
                        } else if (this.f2325f.getVisibility() != 0) {
                            this.f2325f.setVisibility(0);
                            return;
                        } else {
                            return;
                        }
                    }
                    this.f2325f.setVisibility(4);
                    return;
                case 6:
                    this.f2325f.setVisibility(y() ? 4 : 0);
                    return;
                case 7:
                case '\b':
                    if (z()) {
                        this.f2325f.setVisibility(0);
                        return;
                    } else {
                        this.f2325f.setVisibility(4);
                        return;
                    }
                case '\t':
                    this.f2330k = true;
                    H(z());
                    B();
                    return;
                case '\n':
                    this.f2330k = false;
                    H(z());
                    this.f2326g = false;
                    I(false);
                    x();
                    return;
                case 11:
                    A(pVar);
                    return;
                case '\f':
                    if (n().a0() || n().Q()) {
                        return;
                    }
                    int g2 = pVar.g(5);
                    H(g2 <= 0);
                    x();
                    boolean z = z();
                    if ((!z || g2 <= 0) && (z || g2 != 0)) {
                        return;
                    }
                    E();
                    x();
                    return;
                case '\r':
                    if (pVar.d(4)) {
                        F();
                        x();
                        return;
                    }
                    return;
                case 14:
                    I(pVar.d(11));
                    return;
                case 15:
                case 16:
                    F();
                    return;
                case 17:
                    this.f2329j = true;
                    H(z());
                    if (this.f2325f.getVisibility() != 0) {
                        this.f2325f.setVisibility(0);
                        return;
                    }
                    return;
                case 18:
                    this.f2329j = false;
                    H(z());
                    if (this.f2325f.getVisibility() == 0) {
                        if ((!this.f2326g || y()) && !z()) {
                            this.f2325f.setVisibility(8);
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

    @Override // c.a.c0.s.b0.a
    public void k(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, playerStatus, playerStatus2) == null) {
            super.k(playerStatus, playerStatus2);
            if ((PlayerStatus.PREPARING == playerStatus || PlayerStatus.PLAYING == playerStatus) && this.f2326g && this.f2325f.getVisibility() != 0 && !y()) {
                this.f2325f.setVisibility(0);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, view) == null) && view.equals(this.f2325f) && !this.f2329j) {
            E();
            x();
        }
    }

    @Override // c.a.c0.s.b0.g
    public void p(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            boolean z3 = false;
            if (((v.W0() && n().V0()) ? false : true) && z) {
                z3 = true;
            }
            this.f2326g = z3;
            if (n().V0()) {
                s(this.f2326g);
            } else {
                t(this.f2326g);
            }
        }
    }

    public int s(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048592, this, z)) == null) {
            int i2 = 0;
            if (!n().V0() || n().f1() != 1) {
                if (z) {
                    v();
                    return 4;
                }
                if (z() && C()) {
                    this.f2325f.setVisibility(0);
                } else if (this.f2329j) {
                    this.f2325f.setVisibility(0);
                } else {
                    this.f2325f.setVisibility(4);
                }
                return 0;
            } else if (z) {
                this.f2325f.setVisibility((!C() || y()) ? 8 : 8);
                return 4;
            } else {
                if ((z() || c.a.c0.s.v0.k.c(getContext()) == 0) && C()) {
                    this.f2325f.setVisibility(0);
                } else if (this.f2329j) {
                    this.f2325f.setVisibility(0);
                } else {
                    this.f2325f.setVisibility(4);
                }
                return 0;
            }
        }
        return invokeZ.intValue;
    }

    public int t(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048593, this, z)) == null) {
            if (z) {
                this.f2325f.setVisibility(0);
                return 4;
            }
            x();
            return 0;
        }
        return invokeZ.intValue;
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            Animation a = c.a.c0.s.v0.f.a();
            if (this.f2325f.getVisibility() != 0) {
                this.f2325f.setVisibility(0);
                this.f2325f.startAnimation(a);
            }
        }
    }

    public boolean w(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048596, this, z)) == null) ? z : invokeZ.booleanValue;
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (!z() && c.a.c0.s.v0.k.c(getContext()) != 0) {
                if (this.f2326g && !y()) {
                    this.f2325f.setVisibility(0);
                } else if (this.f2329j) {
                    this.f2325f.setVisibility(0);
                } else {
                    this.f2325f.setVisibility(4);
                }
            } else if (C()) {
                this.f2325f.setVisibility(0);
            } else {
                this.f2325f.setVisibility(4);
            }
            ImageView imageView = this.f2325f;
            if (imageView == null || imageView.getVisibility() == 0) {
                return;
            }
            u();
        }
    }

    public boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.l && !z() : invokeV.booleanValue;
    }

    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? c.a.c0.s.e.T() : invokeV.booleanValue;
    }
}
