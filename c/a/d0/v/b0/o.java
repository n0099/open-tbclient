package c.a.d0.v.b0;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.event.ControlEvent;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.badge.BadgeDrawable;
import com.tachikoma.core.component.anim.AnimationProperty;
/* loaded from: classes.dex */
public class o extends g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public TextView f3236f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout.LayoutParams f3237g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f3238h;

    /* renamed from: i  reason: collision with root package name */
    public Animator f3239i;

    /* renamed from: j  reason: collision with root package name */
    public Animator f3240j;
    public String k;
    public int l;
    public int m;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ o f3241e;

        public a(o oVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3241e = oVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f3241e.t();
            }
        }
    }

    public o() {
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

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (n().V0()) {
                this.f3237g.bottomMargin = c.a.d0.i0.a.d.b.b(7.0f);
            } else {
                this.f3237g.bottomMargin = 2;
                this.f3236f.setBackground(getContext().getResources().getDrawable(c.a.d0.l0.l.nad_videoplayer_control_panel_background));
            }
            this.f3236f.setLayoutParams(this.f3237g);
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (n().V0()) {
                this.f3237g.bottomMargin = c.a.d0.i0.a.d.b.b(81.0f);
            } else {
                this.f3237g.bottomMargin = c.a.d0.i0.a.d.b.b(32.0f);
                this.f3236f.setBackgroundColor(0);
                this.f3237g.height = c.a.d0.i0.a.d.b.b(32.0f);
            }
            this.f3236f.setLayoutParams(this.f3237g);
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f3236f.bringToFront();
            this.f3239i.start();
            s();
            w(true);
        }
    }

    @Override // c.a.d0.v.b0.a
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            TextView textView = new TextView(getContext());
            this.f3236f = textView;
            textView.setText(getContext().getResources().getString(c.a.d0.l0.o.nad_videoplayer_half_video_next_tip));
            this.f3236f.setTextSize(0, getContext().getResources().getDimensionPixelSize(c.a.d0.l0.k.nad_videoplayer_immersive_video_next_text_size));
            this.f3236f.setShadowLayer(0.0f, 0.0f, 1.0f, Color.parseColor("#80000000"));
            this.f3236f.setTextColor(-1);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, c.a.d0.i0.a.d.b.b(35.0f));
            this.f3237g = layoutParams;
            layoutParams.gravity = BadgeDrawable.BOTTOM_END;
            this.f3236f.setLayoutParams(layoutParams);
            this.f3236f.setBackground(ContextCompat.getDrawable(getContext(), c.a.d0.l0.l.nad_videoplayer_next_play_tips_background));
            this.f3236f.setGravity(8388629);
            this.f3236f.setAlpha(0.0f);
            this.f3236f.setPadding(0, 0, c.a.d0.i0.a.d.b.b(15.0f), 0);
            u();
            x(false);
        }
    }

    @Override // c.a.d0.v.b0.h
    @NonNull
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f3236f : (View) invokeV.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // c.a.d0.v.b0.a
    public void h(@NonNull c.a.d0.v.c0.p pVar) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, pVar) == null) {
            super.h(pVar);
            String c3 = pVar.c();
            switch (c3.hashCode()) {
                case -1244137507:
                    if (c3.equals(PlayerEvent.ACTION_SEEK_COMPLETE)) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -882902390:
                    if (c3.equals(PlayerEvent.ACTION_SET_DATA_SOURCE)) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -552621273:
                    if (c3.equals(LayerEvent.ACTION_SWITCH_FULL)) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -552580917:
                    if (c3.equals(LayerEvent.ACTION_SWITCH_HALF)) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 723345051:
                    if (c3.equals(ControlEvent.ACTION_START)) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1933234291:
                    if (c3.equals(ControlEvent.ACTION_CONTINUE_TIPS_SHOW)) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 == 0 || c2 == 1 || c2 == 2) {
                t();
            } else if (c2 != 3) {
                if (c2 == 4) {
                    y();
                    x(true);
                } else if (c2 != 5) {
                } else {
                    z();
                    x(false);
                }
            } else if (n().r1()) {
            } else {
                boolean e2 = pVar.e(8, false);
                boolean e3 = pVar.e(9, false);
                if (e2) {
                    this.f3236f.setText(getContext().getResources().getString(this.m));
                } else if (e3) {
                    if (!TextUtils.isEmpty(this.k)) {
                        this.f3236f.setText(this.k);
                        this.f3236f.setBackground(getContext().getResources().getDrawable(c.a.d0.l0.l.nad_videoplayer_control_panel_background));
                    }
                } else {
                    this.f3236f.setText(getContext().getResources().getString(this.l));
                }
                if (this.f3238h) {
                    B();
                } else {
                    A();
                }
                C();
            }
        }
    }

    @Override // c.a.d0.v.b0.g
    public void p(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            super.p(z, z2);
            this.f3238h = z;
            t();
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f3236f.postDelayed(new a(this), 3000L);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.f3240j.isRunning() || this.f3236f.getAlpha() == 0.0f) {
            return;
        }
        this.f3240j.start();
        w(false);
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f3239i = ObjectAnimator.ofFloat(this.f3236f, AnimationProperty.OPACITY, 0.0f, 1.0f).setDuration(250L);
            this.f3240j = ObjectAnimator.ofFloat(this.f3236f, AnimationProperty.OPACITY, 1.0f, 0.0f).setDuration(250L);
        }
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f3239i.isRunning() || this.f3236f.getAlpha() == 1.0f : invokeV.booleanValue;
    }

    public final void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            c.a.d0.v.c0.p w = c.a.d0.v.c0.f.w(LayerEvent.ACTION_POPUP_SHOW);
            w.n(28, Boolean.valueOf(z));
            n().q0(w);
        }
    }

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            if (z) {
                this.l = c.a.d0.l0.o.nad_videoplayer_video_next_tip;
                this.m = c.a.d0.l0.o.nad_videoplayer_full_after_ad_play_next_tip;
                return;
            }
            this.l = c.a.d0.l0.o.nad_videoplayer_half_video_next_tip;
            this.m = c.a.d0.l0.o.nad_videoplayer_after_ad_play_next_tip;
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f3236f.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.height = -2;
            this.f3236f.setBackground(getContext().getResources().getDrawable(c.a.d0.l0.l.nad_videoplayer_immersive_video_next_bg));
            this.f3236f.setText(getContext().getResources().getText(c.a.d0.l0.o.nad_videoplayer_video_next_tip));
            this.f3236f.setPadding(38, 14, 38, 14);
            this.f3236f.setLayoutParams(layoutParams);
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f3236f.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = c.a.d0.i0.a.d.b.b(35.0f);
            this.f3236f.setPadding(0, 0, c.a.d0.i0.a.d.b.b(15.0f), 0);
            this.f3236f.setText(getContext().getResources().getString(c.a.d0.l0.o.nad_videoplayer_half_video_next_tip));
            this.f3236f.setBackground(getContext().getResources().getDrawable(c.a.d0.l0.l.nad_videoplayer_control_panel_background));
            this.f3236f.setLayoutParams(layoutParams);
        }
    }
}
