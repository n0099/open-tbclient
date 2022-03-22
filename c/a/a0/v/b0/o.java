package c.a.a0.v.b0;

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
import com.baidu.tieba.R;
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

    /* renamed from: b  reason: collision with root package name */
    public TextView f1678b;

    /* renamed from: c  reason: collision with root package name */
    public FrameLayout.LayoutParams f1679c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f1680d;

    /* renamed from: e  reason: collision with root package name */
    public Animator f1681e;

    /* renamed from: f  reason: collision with root package name */
    public Animator f1682f;

    /* renamed from: g  reason: collision with root package name */
    public String f1683g;

    /* renamed from: h  reason: collision with root package name */
    public int f1684h;
    public int i;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o a;

        public a(o oVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.w();
            }
        }
    }

    public o() {
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

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if (z) {
                this.f1684h = R.string.obfuscated_res_0x7f0f0bf3;
                this.i = R.string.obfuscated_res_0x7f0f0bef;
                return;
            }
            this.f1684h = R.string.obfuscated_res_0x7f0f0bf0;
            this.i = R.string.obfuscated_res_0x7f0f0be4;
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f1678b.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.height = -2;
            this.f1678b.setBackground(getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080ddd));
            this.f1678b.setText(getContext().getResources().getText(R.string.obfuscated_res_0x7f0f0bf3));
            this.f1678b.setPadding(38, 14, 38, 14);
            this.f1678b.setLayoutParams(layoutParams);
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f1678b.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = c.a.a0.i0.a.d.b.b(35.0f);
            this.f1678b.setPadding(0, 0, c.a.a0.i0.a.d.b.b(15.0f), 0);
            this.f1678b.setText(getContext().getResources().getString(R.string.obfuscated_res_0x7f0f0bf0));
            this.f1678b.setBackground(getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080ddb));
            this.f1678b.setLayoutParams(layoutParams);
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (q().V0()) {
                this.f1679c.bottomMargin = c.a.a0.i0.a.d.b.b(7.0f);
            } else {
                this.f1679c.bottomMargin = 2;
                this.f1678b.setBackground(getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080ddb));
            }
            this.f1678b.setLayoutParams(this.f1679c);
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (q().V0()) {
                this.f1679c.bottomMargin = c.a.a0.i0.a.d.b.b(81.0f);
            } else {
                this.f1679c.bottomMargin = c.a.a0.i0.a.d.b.b(32.0f);
                this.f1678b.setBackgroundColor(0);
                this.f1679c.height = c.a.a0.i0.a.d.b.b(32.0f);
            }
            this.f1678b.setLayoutParams(this.f1679c);
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f1678b.bringToFront();
            this.f1681e.start();
            v();
            z(true);
        }
    }

    @Override // c.a.a0.v.b0.h
    @NonNull
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f1678b : (View) invokeV.objValue;
    }

    @Override // c.a.a0.v.b0.a
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            TextView textView = new TextView(getContext());
            this.f1678b = textView;
            textView.setText(getContext().getResources().getString(R.string.obfuscated_res_0x7f0f0bf0));
            this.f1678b.setTextSize(0, getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07055e));
            this.f1678b.setShadowLayer(0.0f, 0.0f, 1.0f, Color.parseColor("#80000000"));
            this.f1678b.setTextColor(-1);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, c.a.a0.i0.a.d.b.b(35.0f));
            this.f1679c = layoutParams;
            layoutParams.gravity = BadgeDrawable.BOTTOM_END;
            this.f1678b.setLayoutParams(layoutParams);
            this.f1678b.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.obfuscated_res_0x7f080dff));
            this.f1678b.setGravity(8388629);
            this.f1678b.setAlpha(0.0f);
            this.f1678b.setPadding(0, 0, c.a.a0.i0.a.d.b.b(15.0f), 0);
            x();
            A(false);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // c.a.a0.v.b0.a
    public void k(@NonNull c.a.a0.v.c0.p pVar) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pVar) == null) {
            super.k(pVar);
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
                w();
            } else if (c2 != 3) {
                if (c2 == 4) {
                    B();
                    A(true);
                } else if (c2 != 5) {
                } else {
                    C();
                    A(false);
                }
            } else if (q().r1()) {
            } else {
                boolean e2 = pVar.e(8, false);
                boolean e3 = pVar.e(9, false);
                if (e2) {
                    this.f1678b.setText(getContext().getResources().getString(this.i));
                } else if (e3) {
                    if (!TextUtils.isEmpty(this.f1683g)) {
                        this.f1678b.setText(this.f1683g);
                        this.f1678b.setBackground(getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080ddb));
                    }
                } else {
                    this.f1678b.setText(getContext().getResources().getString(this.f1684h));
                }
                if (this.f1680d) {
                    E();
                } else {
                    D();
                }
                F();
            }
        }
    }

    @Override // c.a.a0.v.b0.g
    public void s(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            super.s(z, z2);
            this.f1680d = z;
            w();
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f1678b.postDelayed(new a(this), 3000L);
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.f1682f.isRunning() || this.f1678b.getAlpha() == 0.0f) {
            return;
        }
        this.f1682f.start();
        z(false);
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f1681e = ObjectAnimator.ofFloat(this.f1678b, AnimationProperty.OPACITY, 0.0f, 1.0f).setDuration(250L);
            this.f1682f = ObjectAnimator.ofFloat(this.f1678b, AnimationProperty.OPACITY, 1.0f, 0.0f).setDuration(250L);
        }
    }

    public boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f1681e.isRunning() || this.f1678b.getAlpha() == 1.0f : invokeV.booleanValue;
    }

    public final void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            c.a.a0.v.c0.p w = c.a.a0.v.c0.f.w(LayerEvent.ACTION_POPUP_SHOW);
            w.n(28, Boolean.valueOf(z));
            q().q0(w);
        }
    }
}
