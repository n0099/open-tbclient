package com.baidu.nadcore.business.uitemplate;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.nadcore.widget.uiwidget.SimpleAdInfoView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.an0;
import com.repackage.bn0;
import com.repackage.eg0;
import com.repackage.ej0;
import com.repackage.en0;
import com.repackage.g51;
import com.repackage.hh0;
import com.repackage.i51;
import com.repackage.ln0;
import com.repackage.m31;
import com.repackage.q01;
import com.repackage.qn0;
import com.repackage.si0;
import com.repackage.xm0;
import com.repackage.xx0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class AdEnhanceButtonView extends FrameLayout implements i51<View> {
    public static /* synthetic */ Interceptable $ic;
    public static final int q;
    public static final int r;
    public static final int s;
    public static final int t;
    public static final int u;
    public static final int v;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public NadEnhanceButtonDownloadView b;
    public LinearLayout c;
    public TextView d;
    public AdImageView e;
    public ej0 f;
    public List<m31> g;
    public int h;
    public int i;
    public View j;
    public g51 k;
    public SimpleAdInfoView l;
    public boolean m;
    public int n;
    public int o;
    public int p;

    /* loaded from: classes2.dex */
    public class a extends m31 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdEnhanceButtonView c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AdEnhanceButtonView adEnhanceButtonView, long j, long j2) {
            super(j, j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adEnhanceButtonView, Long.valueOf(j), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = adEnhanceButtonView;
        }

        @Override // com.repackage.m31
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.repackage.m31
        public void d() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.c.k == null) {
                return;
            }
            this.c.k.e();
        }
    }

    /* loaded from: classes2.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup.MarginLayoutParams a;
        public final /* synthetic */ ViewGroup.MarginLayoutParams b;
        public final /* synthetic */ float c;
        public final /* synthetic */ AdEnhanceButtonView d;

        public b(AdEnhanceButtonView adEnhanceButtonView, ViewGroup.MarginLayoutParams marginLayoutParams, ViewGroup.MarginLayoutParams marginLayoutParams2, float f) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adEnhanceButtonView, marginLayoutParams, marginLayoutParams2, Float.valueOf(f)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = adEnhanceButtonView;
            this.a = marginLayoutParams;
            this.b = marginLayoutParams2;
            this.c = f;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (this.d.m) {
                    this.a.height = Math.round(AdEnhanceButtonView.r * animatedFraction);
                    this.a.topMargin = Math.round(AdEnhanceButtonView.t * animatedFraction);
                    this.d.j.requestLayout();
                    this.b.height = Math.round(this.d.a * animatedFraction);
                    this.b.topMargin = Math.round(AdEnhanceButtonView.v * animatedFraction);
                    this.b.bottomMargin = Math.round(AdEnhanceButtonView.u * animatedFraction);
                    this.d.l.setY(this.c + Math.round(AdEnhanceButtonView.r * (1.0f - animatedFraction)) + Math.round(AdEnhanceButtonView.v * animatedFraction));
                    this.d.l.setAlpha(animatedFraction);
                    this.d.l.requestLayout();
                    return;
                }
                this.a.height = Math.round(AdEnhanceButtonView.r * animatedFraction);
                this.a.topMargin = Math.round(AdEnhanceButtonView.s * animatedFraction);
                this.d.j.requestLayout();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c extends m31 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ValueAnimator c;
        public final /* synthetic */ Animation d;
        public final /* synthetic */ View e;
        public final /* synthetic */ AdEnhanceButtonView f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(AdEnhanceButtonView adEnhanceButtonView, long j, long j2, ValueAnimator valueAnimator, Animation animation, View view2) {
            super(j, j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {adEnhanceButtonView, Long.valueOf(j), Long.valueOf(j2), valueAnimator, animation, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = adEnhanceButtonView;
            this.c = valueAnimator;
            this.d = animation;
            this.e = view2;
        }

        @Override // com.repackage.m31
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.cancel();
                this.d.cancel();
                this.f.z();
            }
        }

        @Override // com.repackage.m31
        public void d() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.c.isRunning()) {
                return;
            }
            if (this.f.k != null) {
                this.f.k.f();
            }
            this.d.cancel();
            this.c.start();
            this.e.setVisibility(0);
            this.e.startAnimation(this.d);
        }
    }

    /* loaded from: classes2.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdEnhanceButtonView a;

        public d(AdEnhanceButtonView adEnhanceButtonView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adEnhanceButtonView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adEnhanceButtonView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                View view2 = this.a.x() ? this.a.b : this.a.c;
                if (view2.getBackground() instanceof GradientDrawable) {
                    GradientDrawable gradientDrawable = (GradientDrawable) view2.getBackground();
                    gradientDrawable.setColor(eg0.c(animatedFraction, this.a.o, this.a.getBtnFinalColor()));
                    gradientDrawable.setCornerRadius(this.a.n);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e extends m31 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ValueAnimator c;
        public final /* synthetic */ AdEnhanceButtonView d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(AdEnhanceButtonView adEnhanceButtonView, long j, long j2, ValueAnimator valueAnimator) {
            super(j, j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adEnhanceButtonView, Long.valueOf(j), Long.valueOf(j2), valueAnimator};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = adEnhanceButtonView;
            this.c = valueAnimator;
        }

        @Override // com.repackage.m31
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.cancel();
            }
        }

        @Override // com.repackage.m31
        public void d() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.c.isRunning()) {
                return;
            }
            if (this.d.k != null) {
                this.d.k.c();
            }
            this.c.start();
        }
    }

    /* loaded from: classes2.dex */
    public class f implements SimpleAdInfoView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdEnhanceButtonView a;

        public f(AdEnhanceButtonView adEnhanceButtonView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adEnhanceButtonView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adEnhanceButtonView;
        }

        @Override // com.baidu.nadcore.widget.uiwidget.SimpleAdInfoView.c
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || this.a.k == null) {
                return;
            }
            this.a.k.a(str);
        }
    }

    /* loaded from: classes2.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdEnhanceButtonView a;

        public g(AdEnhanceButtonView adEnhanceButtonView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adEnhanceButtonView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adEnhanceButtonView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.f.m();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bn0 a;
        public final /* synthetic */ AdEnhanceButtonView b;

        public h(AdEnhanceButtonView adEnhanceButtonView, bn0 bn0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adEnhanceButtonView, bn0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = adEnhanceButtonView;
            this.a = bn0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.b.k == null) {
                return;
            }
            ln0 ln0Var = new ln0();
            ln0Var.c = true;
            ln0Var.a = this.a.i;
            this.b.k.b(ln0Var);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(757863512, "Lcom/baidu/nadcore/business/uitemplate/AdEnhanceButtonView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(757863512, "Lcom/baidu/nadcore/business/uitemplate/AdEnhanceButtonView;");
                return;
            }
        }
        q01.c.a(hh0.b(), 8.0f);
        q = q01.c.a(hh0.b(), 12.0f);
        r = q01.c.a(hh0.b(), 33.0f);
        s = q01.c.a(hh0.b(), 9.0f);
        t = q01.c.a(hh0.b(), 28.0f);
        u = q01.c.a(hh0.b(), 11.0f);
        v = q01.c.a(hh0.b(), 7.0f);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdEnhanceButtonView(@NonNull Context context, @NonNull ViewGroup viewGroup, @NonNull View view2) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, viewGroup, view2};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        setContainer(viewGroup);
        setBtnPlaceholder(view2);
    }

    @Override // com.repackage.i51
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            List<m31> list = this.g;
            if (list != null) {
                for (m31 m31Var : list) {
                    m31Var.c();
                }
            }
            this.h = 0;
            this.i = 0;
        }
    }

    public int getBtnFinalColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if ((getTag() instanceof bn0) && !TextUtils.isEmpty(((bn0) getTag()).g)) {
                return eg0.e(((bn0) getTag()).g, R.color.obfuscated_res_0x7f060811);
            }
            return this.p;
        }
        return invokeV.intValue;
    }

    public final void n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d05b5, this);
            this.b = (NadEnhanceButtonDownloadView) findViewById(R.id.obfuscated_res_0x7f0900f6);
            this.c = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090667);
            this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f090669);
            this.e = (AdImageView) findViewById(R.id.obfuscated_res_0x7f090668);
            this.l = (SimpleAdInfoView) findViewById(R.id.obfuscated_res_0x7f090286);
        }
    }

    public final void o(@NonNull bn0 bn0Var) {
        List<en0> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, bn0Var) == null) || (list = bn0Var.d) == null || list.size() <= 0) {
            return;
        }
        this.g = new ArrayList();
        for (en0 en0Var : list) {
            if (en0Var != null) {
                w(en0Var);
            }
        }
    }

    public final void p(@Nullable qn0 qn0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, qn0Var) == null) {
            if (!eg0.a(qn0Var)) {
                this.m = false;
                this.l.setVisibility(8);
                return;
            }
            this.m = true;
            this.l.setVisibility(0);
            this.l.setAdInfo(qn0Var);
            this.l.setAfterListener(new f(this));
            this.a = this.l.getHeight();
            this.l.measure(-2, -2);
            this.a = this.l.getMeasuredHeight();
        }
    }

    public final void q(boolean z) {
        int btnFinalColor;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            if (z) {
                btnFinalColor = this.o;
            } else {
                btnFinalColor = getBtnFinalColor();
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(btnFinalColor);
            gradientDrawable.setCornerRadius(this.n);
            (x() ? this.b : this.c).setBackground(gradientDrawable);
            if (x()) {
                this.b.setProgressColor(getResources().getColor(R.color.obfuscated_res_0x7f06082a));
            }
        }
    }

    public final void r(@NonNull en0 en0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, en0Var) == null) {
            z();
            if (en0Var.c <= 0) {
                return;
            }
            ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(en0Var.c);
            ViewGroup.LayoutParams layoutParams = this.j.getLayoutParams();
            ViewGroup.LayoutParams layoutParams2 = this.l.getLayoutParams();
            if (this.j != null && (layoutParams instanceof ViewGroup.MarginLayoutParams) && (layoutParams2 instanceof ViewGroup.MarginLayoutParams)) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                float y = this.l.getY();
                marginLayoutParams.height = 0;
                marginLayoutParams.topMargin = 0;
                this.j.requestLayout();
                if (this.m) {
                    marginLayoutParams2.height = 0;
                    marginLayoutParams2.topMargin = 0;
                    marginLayoutParams2.bottomMargin = 0;
                    this.l.requestLayout();
                    this.l.setVisibility(0);
                } else {
                    this.l.setVisibility(8);
                }
                duration.addUpdateListener(new b(this, marginLayoutParams, marginLayoutParams2, y));
            }
            View realView = getRealView();
            Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.obfuscated_res_0x7f0100a3);
            loadAnimation.setDuration(en0Var.c);
            realView.setVisibility(8);
            realView.setAnimation(loadAnimation);
            xx0.b(this.g, new c(this, en0Var.b, en0Var.c, duration, loadAnimation, realView));
        }
    }

    public final void s(@NonNull en0 en0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, en0Var) == null) || en0Var.c <= 0) {
            return;
        }
        q(true);
        ValueAnimator duration = ValueAnimator.ofFloat(1.0f).setDuration(en0Var.c);
        duration.addUpdateListener(new d(this));
        xx0.b(this.g, new e(this, en0Var.b, en0Var.c, duration));
    }

    @Override // com.repackage.i51
    public void setBtnIconNightModeEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
        }
    }

    public void setContainer(@NonNull ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, viewGroup) == null) {
            View view2 = (View) getParent();
            if (view2 instanceof ViewGroup) {
                ((ViewGroup) view2).removeView(this);
            }
            viewGroup.addView(this);
        }
    }

    @Override // com.repackage.i51
    public void setData(@NonNull bn0 bn0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bn0Var) == null) {
            if (!bn0Var.b()) {
                setVisibility(8);
                return;
            }
            setTag(bn0Var);
            setVisibility(0);
            p(bn0Var.h);
            if (!u(bn0Var)) {
                t(bn0Var);
            }
            v();
            q(false);
            o(bn0Var);
        }
    }

    @Override // com.repackage.i51
    public void setEnhanceBtnListener(@NonNull g51 g51Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, g51Var) == null) {
            this.k = g51Var;
        }
    }

    @Override // com.repackage.i51
    public void setVisible(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            setVisibility(i);
        }
    }

    public final void t(@NonNull bn0 bn0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bn0Var) == null) {
            if (!TextUtils.isEmpty(bn0Var.c)) {
                this.e.g(bn0Var.c);
            } else {
                this.e.setImageDrawable(getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080d47));
            }
            if (!TextUtils.isEmpty(bn0Var.b)) {
                this.d.setText(bn0Var.b);
            } else {
                this.d.setText(getResources().getText(R.string.obfuscated_res_0x7f0f0b53));
            }
            this.d.setTextColor(eg0.e("", R.color.obfuscated_res_0x7f060868));
            this.c.setOnClickListener(new h(this, bn0Var));
            this.b.setVisibility(8);
            this.c.setVisibility(0);
        }
    }

    public final boolean u(@NonNull bn0 bn0Var) {
        InterceptResult invokeL;
        xm0 xm0Var;
        an0 an0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, bn0Var)) == null) {
            if (x() && (xm0Var = bn0Var.e) != null && (an0Var = bn0Var.f) != null) {
                bn0Var.a = 2;
                this.f = new ej0(si0.c(xm0Var, an0Var.d, bn0Var.i), this.b);
                this.b.setCornerRadius(this.n);
                this.b.setTextSize(12.0f);
                NadEnhanceButtonDownloadView nadEnhanceButtonDownloadView = this.b;
                int i = q;
                nadEnhanceButtonDownloadView.setImageViewLayout(new FrameLayout.LayoutParams(i, i));
                this.c.setVisibility(8);
                this.b.setVisibility(0);
                this.b.setOnClickListener(new g(this));
                return true;
            }
            if (this.f != null) {
                this.f = null;
            }
            this.b.setVisibility(8);
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.i51
    public void update(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            List<m31> list = this.g;
            if (list != null && this.h < xx0.k(list)) {
                m31 m31Var = (m31) xx0.d(this.g, this.h);
                if (m31Var != null && i * 1000 >= this.i) {
                    m31Var.d();
                    this.i = (int) (this.i + m31Var.b() + m31Var.a());
                    this.h++;
                    return;
                }
                return;
            }
            g51 g51Var = this.k;
            if (g51Var != null) {
                g51Var.d();
            }
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            ViewGroup.LayoutParams layoutParams = this.j.getLayoutParams();
            ViewGroup.LayoutParams layoutParams2 = this.l.getLayoutParams();
            View view2 = this.j;
            if (view2 != null && (layoutParams instanceof ViewGroup.MarginLayoutParams) && (layoutParams2 instanceof ViewGroup.MarginLayoutParams)) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                if (this.m) {
                    marginLayoutParams.height = r;
                    marginLayoutParams.topMargin = t;
                    view2.requestLayout();
                    marginLayoutParams2.height = this.a;
                    marginLayoutParams2.topMargin = v;
                    marginLayoutParams2.bottomMargin = u;
                    this.l.setAlpha(1.0f);
                    this.l.requestLayout();
                    return;
                }
                marginLayoutParams.height = r;
                marginLayoutParams.topMargin = s;
                view2.requestLayout();
                this.l.setVisibility(8);
            }
        }
    }

    public final void w(@NonNull en0 en0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, en0Var) == null) {
            int i = en0Var.a;
            if (i == 0) {
                xx0.b(this.g, new a(this, en0Var.b, en0Var.c));
            } else if (i == 1) {
                r(en0Var);
            } else if (i != 2) {
            } else {
                s(en0Var);
            }
        }
    }

    public final boolean x() {
        InterceptResult invokeV;
        bn0 bn0Var;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? (!(getTag() instanceof bn0) || (bn0Var = (bn0) getTag()) == null || bn0Var.h == null || bn0Var.e == null || bn0Var.a != 2) ? false : true : invokeV.booleanValue;
    }

    public final void y(AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, attributeSet) == null) || attributeSet == null) {
            return;
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f040101, R.attr.obfuscated_res_0x7f040102, R.attr.obfuscated_res_0x7f040104});
        this.n = obtainStyledAttributes.getDimensionPixelSize(2, q01.c.a(hh0.b(), 8.0f));
        this.o = obtainStyledAttributes.getColor(1, getResources().getColor(R.color.obfuscated_res_0x7f060812));
        this.p = obtainStyledAttributes.getColor(0, getResources().getColor(R.color.obfuscated_res_0x7f060811));
        obtainStyledAttributes.recycle();
    }

    public final void z() {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || (view2 = this.j) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        layoutParams.height = r;
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = s;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.repackage.i51
    public View getRealView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (!(getTag() instanceof bn0)) {
                return this.c;
            }
            if (((bn0) getTag()).a != 2) {
                return this.c;
            }
            return this.b;
        }
        return (View) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.i51
    public void setBtnPlaceholder(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, view2) == null) {
            this.j = view2;
            z();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdEnhanceButtonView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdEnhanceButtonView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.h = 0;
        this.i = 0;
        this.k = null;
        this.m = false;
        this.n = q01.c.a(hh0.b(), 8.0f);
        this.o = getResources().getColor(R.color.obfuscated_res_0x7f060812);
        this.p = getResources().getColor(R.color.obfuscated_res_0x7f060811);
        n(context);
        y(attributeSet);
    }
}
