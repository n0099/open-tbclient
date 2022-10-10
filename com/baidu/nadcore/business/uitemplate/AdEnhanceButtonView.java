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
import com.baidu.tieba.bp0;
import com.baidu.tieba.c81;
import com.baidu.tieba.e81;
import com.baidu.tieba.h61;
import com.baidu.tieba.ip0;
import com.baidu.tieba.lk0;
import com.baidu.tieba.np0;
import com.baidu.tieba.rg0;
import com.baidu.tieba.t21;
import com.baidu.tieba.uo0;
import com.baidu.tieba.wh0;
import com.baidu.tieba.wz0;
import com.baidu.tieba.xo0;
import com.baidu.tieba.yk0;
import com.baidu.tieba.yo0;
import com.baidu.tieba.zi0;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class AdEnhanceButtonView extends FrameLayout implements e81<View> {
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
    public yk0 f;
    public List<h61> g;
    public int h;
    public int i;
    public View j;
    public c81 k;
    public SimpleAdInfoView l;
    public boolean m;
    public int n;
    public int o;
    public int p;

    /* loaded from: classes2.dex */
    public class a extends h61 {
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

        @Override // com.baidu.tieba.h61
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.baidu.tieba.h61
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
    public class c extends h61 {
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

        @Override // com.baidu.tieba.h61
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.cancel();
                this.d.cancel();
                this.f.z();
            }
        }

        @Override // com.baidu.tieba.h61
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
                    gradientDrawable.setColor(wh0.b(animatedFraction, this.a.o, this.a.getBtnFinalColor()));
                    gradientDrawable.setCornerRadius(this.a.n);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e extends h61 {
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

        @Override // com.baidu.tieba.h61
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.cancel();
            }
        }

        @Override // com.baidu.tieba.h61
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
        public final /* synthetic */ yo0 a;
        public final /* synthetic */ AdEnhanceButtonView b;

        public h(AdEnhanceButtonView adEnhanceButtonView, yo0 yo0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adEnhanceButtonView, yo0Var};
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
            this.a = yo0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.b.k == null) {
                return;
            }
            ip0 ip0Var = new ip0();
            ip0Var.c = true;
            ip0Var.a = this.a.i;
            this.b.k.b(ip0Var);
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
        t21.c.a(zi0.b(), 8.0f);
        q = t21.c.a(zi0.b(), 12.0f);
        r = t21.c.a(zi0.b(), 33.0f);
        s = t21.c.a(zi0.b(), 9.0f);
        t = t21.c.a(zi0.b(), 28.0f);
        u = t21.c.a(zi0.b(), 11.0f);
        v = t21.c.a(zi0.b(), 7.0f);
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

    @Override // com.baidu.tieba.e81
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            List<h61> list = this.g;
            if (list != null) {
                for (h61 h61Var : list) {
                    h61Var.c();
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
            if ((getTag() instanceof yo0) && !TextUtils.isEmpty(((yo0) getTag()).g)) {
                return wh0.d(((yo0) getTag()).g, R.color.obfuscated_res_0x7f06083f);
            }
            return this.p;
        }
        return invokeV.intValue;
    }

    public final void n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d05ec, this);
            this.b = (NadEnhanceButtonDownloadView) findViewById(R.id.obfuscated_res_0x7f0900ff);
            this.c = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090697);
            this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f090699);
            this.e = (AdImageView) findViewById(R.id.obfuscated_res_0x7f090698);
            this.l = (SimpleAdInfoView) findViewById(R.id.obfuscated_res_0x7f09029e);
        }
    }

    public final void o(@NonNull yo0 yo0Var) {
        List<bp0> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, yo0Var) == null) || (list = yo0Var.d) == null || list.size() <= 0) {
            return;
        }
        this.g = new ArrayList();
        for (bp0 bp0Var : list) {
            if (bp0Var != null) {
                w(bp0Var);
            }
        }
    }

    public final void p(@Nullable np0 np0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, np0Var) == null) {
            if (!wh0.a(np0Var)) {
                this.m = false;
                this.l.setVisibility(8);
                return;
            }
            this.m = true;
            this.l.setVisibility(0);
            this.l.setAdInfo(np0Var);
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
                this.b.setProgressColor(getResources().getColor(R.color.obfuscated_res_0x7f060859));
            }
        }
    }

    public final void r(@NonNull bp0 bp0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bp0Var) == null) {
            z();
            if (bp0Var.c <= 0) {
                return;
            }
            ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(bp0Var.c);
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
            Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.obfuscated_res_0x7f0100a9);
            loadAnimation.setDuration(bp0Var.c);
            realView.setVisibility(8);
            realView.setAnimation(loadAnimation);
            wz0.b(this.g, new c(this, bp0Var.b, bp0Var.c, duration, loadAnimation, realView));
        }
    }

    public final void s(@NonNull bp0 bp0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, bp0Var) == null) || bp0Var.c <= 0) {
            return;
        }
        q(true);
        ValueAnimator duration = ValueAnimator.ofFloat(1.0f).setDuration(bp0Var.c);
        duration.addUpdateListener(new d(this));
        wz0.b(this.g, new e(this, bp0Var.b, bp0Var.c, duration));
    }

    @Override // com.baidu.tieba.e81
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

    @Override // com.baidu.tieba.e81
    public void setData(@NonNull yo0 yo0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, yo0Var) == null) {
            if (!yo0Var.b()) {
                setVisibility(8);
                return;
            }
            setTag(yo0Var);
            setVisibility(0);
            p(yo0Var.h);
            if (!u(yo0Var)) {
                t(yo0Var);
            }
            v();
            q(false);
            o(yo0Var);
        }
    }

    @Override // com.baidu.tieba.e81
    public void setEnhanceBtnListener(@NonNull c81 c81Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, c81Var) == null) {
            this.k = c81Var;
        }
    }

    @Override // com.baidu.tieba.e81
    public void setVisible(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            setVisibility(i);
        }
    }

    public final void t(@NonNull yo0 yo0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, yo0Var) == null) {
            if (!TextUtils.isEmpty(yo0Var.c)) {
                this.e.g(yo0Var.c);
            } else {
                this.e.setImageDrawable(getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080dc8));
            }
            if (!TextUtils.isEmpty(yo0Var.b)) {
                this.d.setText(yo0Var.b);
            } else {
                this.d.setText(getResources().getText(R.string.obfuscated_res_0x7f0f0b95));
            }
            this.d.setTextColor(wh0.d("", R.color.obfuscated_res_0x7f060898));
            this.c.setOnClickListener(new h(this, yo0Var));
            this.b.setVisibility(8);
            this.c.setVisibility(0);
        }
    }

    public final boolean u(@NonNull yo0 yo0Var) {
        InterceptResult invokeL;
        uo0 uo0Var;
        xo0 xo0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, yo0Var)) == null) {
            if (x() && (uo0Var = yo0Var.e) != null && (xo0Var = yo0Var.f) != null) {
                yo0Var.a = 2;
                this.f = new yk0(lk0.d(uo0Var, xo0Var.d, yo0Var.i), this.b);
                this.b.setCornerRadius(this.n);
                this.b.setTextSize(12.0f);
                NadEnhanceButtonDownloadView nadEnhanceButtonDownloadView = this.b;
                int i = q;
                nadEnhanceButtonDownloadView.setImageViewLayout(new FrameLayout.LayoutParams(i, i));
                this.c.setVisibility(8);
                this.b.setVisibility(0);
                this.b.setOnClickListener(new g(this));
                if (!TextUtils.isEmpty(yo0Var.c)) {
                    this.b.setStateImageIcon(yo0Var.c);
                    return true;
                }
                this.b.setStateImageRes(R.drawable.obfuscated_res_0x7f080dc8);
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

    @Override // com.baidu.tieba.e81
    public void update(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            List<h61> list = this.g;
            if (list != null && this.h < wz0.l(list)) {
                h61 h61Var = (h61) wz0.d(this.g, this.h);
                if (h61Var != null && i * 1000 >= this.i) {
                    h61Var.d();
                    this.i = (int) (this.i + h61Var.b() + h61Var.a());
                    this.h++;
                    return;
                }
                return;
            }
            c81 c81Var = this.k;
            if (c81Var != null) {
                c81Var.d();
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

    public final void w(@NonNull bp0 bp0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bp0Var) == null) {
            int i = bp0Var.a;
            if (i == 0) {
                wz0.b(this.g, new a(this, bp0Var.b, bp0Var.c));
            } else if (i == 1) {
                r(bp0Var);
            } else if (i != 2) {
            } else {
                s(bp0Var);
            }
        }
    }

    public final boolean x() {
        InterceptResult invokeV;
        yo0 yo0Var;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? (!(getTag() instanceof yo0) || (yo0Var = (yo0) getTag()) == null || yo0Var.h == null || yo0Var.e == null || yo0Var.a != 2) ? false : true : invokeV.booleanValue;
    }

    public final void y(AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, attributeSet) == null) || attributeSet == null) {
            return;
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, rg0.NadEnhanceButtonView);
        this.n = obtainStyledAttributes.getDimensionPixelSize(2, t21.c.a(zi0.b(), 8.0f));
        this.o = obtainStyledAttributes.getColor(1, getResources().getColor(R.color.obfuscated_res_0x7f060840));
        this.p = obtainStyledAttributes.getColor(0, getResources().getColor(R.color.obfuscated_res_0x7f06083f));
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
    @Override // com.baidu.tieba.e81
    public View getRealView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (!(getTag() instanceof yo0)) {
                return this.c;
            }
            if (((yo0) getTag()).a != 2) {
                return this.c;
            }
            return this.b;
        }
        return (View) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.e81
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
        this.n = t21.c.a(zi0.b(), 17.0f);
        this.o = getResources().getColor(R.color.obfuscated_res_0x7f060840);
        this.p = getResources().getColor(R.color.obfuscated_res_0x7f06083f);
        n(context);
        y(attributeSet);
    }
}
