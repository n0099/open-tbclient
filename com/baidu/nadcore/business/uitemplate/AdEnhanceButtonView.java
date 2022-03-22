package com.baidu.nadcore.business.uitemplate;

import android.animation.ValueAnimator;
import android.content.Context;
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
import c.a.a0.h0.f;
import c.a.a0.s.o;
import c.a.a0.s.t;
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
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class AdEnhanceButtonView extends FrameLayout implements c.a.a0.l0.u.b<View> {
    public static /* synthetic */ Interceptable $ic;
    public static final int n;
    public static final int o;
    public static final int p;
    public static final int q;
    public static final int r;
    public static final int s;
    public static final int t;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public NadMiniVideoDownloadView f27451b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f27452c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f27453d;

    /* renamed from: e  reason: collision with root package name */
    public AdImageView f27454e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.a0.j.f.d f27455f;

    /* renamed from: g  reason: collision with root package name */
    public List<c.a.a0.l0.c> f27456g;

    /* renamed from: h  reason: collision with root package name */
    public int f27457h;
    public int i;
    public View j;
    public c.a.a0.l0.u.a k;
    public SimpleAdInfoView l;
    public boolean m;

    /* loaded from: classes4.dex */
    public class a extends c.a.a0.l0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ AdEnhanceButtonView f27458c;

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
            this.f27458c = adEnhanceButtonView;
        }

        @Override // c.a.a0.l0.c
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // c.a.a0.l0.c
        public void d() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f27458c.k == null) {
                return;
            }
            this.f27458c.k.e();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup.MarginLayoutParams a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ViewGroup.MarginLayoutParams f27459b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ float f27460c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ AdEnhanceButtonView f27461d;

        public b(AdEnhanceButtonView adEnhanceButtonView, ViewGroup.MarginLayoutParams marginLayoutParams, ViewGroup.MarginLayoutParams marginLayoutParams2, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adEnhanceButtonView, marginLayoutParams, marginLayoutParams2, Float.valueOf(f2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27461d = adEnhanceButtonView;
            this.a = marginLayoutParams;
            this.f27459b = marginLayoutParams2;
            this.f27460c = f2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (this.f27461d.m) {
                    this.a.height = Math.round(AdEnhanceButtonView.p * animatedFraction);
                    this.a.topMargin = Math.round(AdEnhanceButtonView.r * animatedFraction);
                    this.f27461d.j.requestLayout();
                    this.f27459b.height = Math.round(this.f27461d.a * animatedFraction);
                    this.f27459b.topMargin = Math.round(AdEnhanceButtonView.t * animatedFraction);
                    this.f27459b.bottomMargin = Math.round(AdEnhanceButtonView.s * animatedFraction);
                    this.f27461d.l.setY(this.f27460c + Math.round(AdEnhanceButtonView.p * (1.0f - animatedFraction)) + Math.round(AdEnhanceButtonView.t * animatedFraction));
                    this.f27461d.l.setAlpha(animatedFraction);
                    this.f27461d.l.requestLayout();
                    return;
                }
                this.a.height = Math.round(AdEnhanceButtonView.p * animatedFraction);
                this.a.topMargin = Math.round(AdEnhanceButtonView.q * animatedFraction);
                this.f27461d.j.requestLayout();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends c.a.a0.l0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ValueAnimator f27462c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Animation f27463d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f27464e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AdEnhanceButtonView f27465f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(AdEnhanceButtonView adEnhanceButtonView, long j, long j2, ValueAnimator valueAnimator, Animation animation, View view) {
            super(j, j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {adEnhanceButtonView, Long.valueOf(j), Long.valueOf(j2), valueAnimator, animation, view};
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
            this.f27465f = adEnhanceButtonView;
            this.f27462c = valueAnimator;
            this.f27463d = animation;
            this.f27464e = view;
        }

        @Override // c.a.a0.l0.c
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f27462c.cancel();
                this.f27463d.cancel();
                this.f27465f.w();
            }
        }

        @Override // c.a.a0.l0.c
        public void d() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f27462c.isRunning()) {
                return;
            }
            if (this.f27465f.k != null) {
                this.f27465f.k.f();
            }
            this.f27463d.cancel();
            this.f27462c.start();
            this.f27464e.setVisibility(0);
            this.f27464e.startAnimation(this.f27463d);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AdEnhanceButtonView f27466b;

        public d(AdEnhanceButtonView adEnhanceButtonView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adEnhanceButtonView, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27466b = adEnhanceButtonView;
            this.a = i;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                View view = this.f27466b.v() ? this.f27466b.f27451b : this.f27466b.f27452c;
                if (view.getBackground() instanceof GradientDrawable) {
                    GradientDrawable gradientDrawable = (GradientDrawable) view.getBackground();
                    gradientDrawable.setColor(c.a.a0.d.i.a.c(animatedFraction, this.f27466b.getContext().getResources().getColor(R.color.obfuscated_res_0x7f060808), this.a));
                    gradientDrawable.setCornerRadius(AdEnhanceButtonView.n);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends c.a.a0.l0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ValueAnimator f27467c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ AdEnhanceButtonView f27468d;

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
            this.f27468d = adEnhanceButtonView;
            this.f27467c = valueAnimator;
        }

        @Override // c.a.a0.l0.c
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f27467c.cancel();
            }
        }

        @Override // c.a.a0.l0.c
        public void d() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f27467c.isRunning()) {
                return;
            }
            if (this.f27468d.k != null) {
                this.f27468d.k.c();
            }
            this.f27467c.start();
        }
    }

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
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
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.f27455f.p();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.a0.s.g a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AdEnhanceButtonView f27469b;

        public h(AdEnhanceButtonView adEnhanceButtonView, c.a.a0.s.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adEnhanceButtonView, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27469b = adEnhanceButtonView;
            this.a = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f27469b.k == null) {
                return;
            }
            o oVar = new o();
            oVar.f1555b = true;
            oVar.a = this.a.f1543h;
            this.f27469b.k.b(oVar);
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
        n = f.c.a(c.a.a0.h.a.b(), 8.0f);
        o = f.c.a(c.a.a0.h.a.b(), 15.0f);
        p = f.c.a(c.a.a0.h.a.b(), 33.0f);
        q = f.c.a(c.a.a0.h.a.b(), 9.0f);
        r = f.c.a(c.a.a0.h.a.b(), 28.0f);
        s = f.c.a(c.a.a0.h.a.b(), 11.0f);
        t = f.c.a(c.a.a0.h.a.b(), 7.0f);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdEnhanceButtonView(@NonNull Context context, @NonNull ViewGroup viewGroup, @NonNull View view) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, viewGroup, view};
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
        setBtnPlaceholder(view);
    }

    private int getBtnFinalColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) ? getResources().getColor(R.color.obfuscated_res_0x7f060807) : invokeV.intValue;
    }

    @Override // c.a.a0.l0.u.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            List<c.a.a0.l0.c> list = this.f27456g;
            if (list != null) {
                for (c.a.a0.l0.c cVar : list) {
                    cVar.c();
                }
            }
            this.f27457h = 0;
            this.i = 0;
        }
    }

    public final void l(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d05ae, this);
            this.f27451b = (NadMiniVideoDownloadView) findViewById(R.id.obfuscated_res_0x7f0900f9);
            this.f27452c = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f09069d);
            this.f27453d = (TextView) findViewById(R.id.obfuscated_res_0x7f09069f);
            this.f27454e = (AdImageView) findViewById(R.id.obfuscated_res_0x7f09069e);
            this.l = (SimpleAdInfoView) findViewById(R.id.obfuscated_res_0x7f09028a);
        }
    }

    public final void m(@NonNull c.a.a0.s.g gVar) {
        List<c.a.a0.s.h> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, gVar) == null) || (list = gVar.f1539d) == null || list.size() <= 0) {
            return;
        }
        this.f27456g = new ArrayList();
        for (c.a.a0.s.h hVar : list) {
            if (hVar != null) {
                u(hVar);
            }
        }
    }

    public final void n(@Nullable t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, tVar) == null) {
            if (!c.a.a0.d.i.a.a(tVar)) {
                this.m = false;
                this.l.setVisibility(8);
                return;
            }
            this.m = true;
            this.l.setVisibility(0);
            this.l.setAdInfo(tVar);
            this.l.setAfterListener(new f(this));
            this.a = this.l.getHeight();
            this.l.measure(-2, -2);
            this.a = this.l.getMeasuredHeight();
        }
    }

    public final void o(boolean z) {
        int btnFinalColor;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            if (z) {
                btnFinalColor = getResources().getColor(R.color.obfuscated_res_0x7f060808);
            } else {
                btnFinalColor = getBtnFinalColor();
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(btnFinalColor);
            gradientDrawable.setCornerRadius(n);
            (v() ? this.f27451b : this.f27452c).setBackground(gradientDrawable);
            if (v()) {
                this.f27451b.setProgressColor(getResources().getColor(R.color.obfuscated_res_0x7f06081b));
            }
        }
    }

    public final void p(@NonNull c.a.a0.s.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, hVar) == null) {
            w();
            if (hVar.f1546c <= 0) {
                return;
            }
            ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(hVar.f1546c);
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
            Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.obfuscated_res_0x7f01009e);
            loadAnimation.setDuration(hVar.f1546c);
            realView.setVisibility(8);
            realView.setAnimation(loadAnimation);
            c.a.a0.x.a.b(this.f27456g, new c(this, hVar.f1545b, hVar.f1546c, duration, loadAnimation, realView));
        }
    }

    public final void q(@NonNull c.a.a0.s.h hVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, hVar) == null) || hVar.f1546c <= 0) {
            return;
        }
        o(true);
        ValueAnimator duration = ValueAnimator.ofFloat(1.0f).setDuration(hVar.f1546c);
        duration.addUpdateListener(new d(this, getBtnFinalColor()));
        c.a.a0.x.a.b(this.f27456g, new e(this, hVar.f1545b, hVar.f1546c, duration));
    }

    public final void r(@NonNull c.a.a0.s.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, gVar) == null) {
            if (!TextUtils.isEmpty(gVar.f1538c)) {
                this.f27454e.g(gVar.f1538c);
            } else {
                this.f27454e.setImageDrawable(getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080db8));
            }
            if (!TextUtils.isEmpty(gVar.f1537b)) {
                this.f27453d.setText(gVar.f1537b);
            } else {
                this.f27453d.setText(getResources().getText(R.string.obfuscated_res_0x7f0f0b57));
            }
            this.f27453d.setTextColor(c.a.a0.d.i.a.d("", R.color.obfuscated_res_0x7f060859));
            this.f27452c.setOnClickListener(new h(this, gVar));
            this.f27451b.setVisibility(8);
            this.f27452c.setVisibility(0);
        }
    }

    public final boolean s(@NonNull c.a.a0.s.g gVar) {
        InterceptResult invokeL;
        c.a.a0.s.c cVar;
        c.a.a0.s.f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, gVar)) == null) {
            if (v() && (cVar = gVar.f1540e) != null && (fVar = gVar.f1541f) != null) {
                gVar.a = 2;
                this.f27455f = new c.a.a0.j.f.d(c.a.a0.j.d.a.c(cVar, fVar.a, gVar.f1543h), this.f27451b);
                this.f27451b.setCornerRadius(n);
                this.f27451b.setTextSize(12.0f);
                NadMiniVideoDownloadView nadMiniVideoDownloadView = this.f27451b;
                int i = o;
                nadMiniVideoDownloadView.setImageViewLayout(new FrameLayout.LayoutParams(i, i));
                this.f27452c.setVisibility(8);
                this.f27451b.setVisibility(0);
                this.f27451b.setOnClickListener(new g(this));
                return true;
            }
            if (this.f27455f != null) {
                this.f27455f = null;
            }
            this.f27451b.setVisibility(8);
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.a0.l0.u.b
    public void setBtnIconNightModeEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
        }
    }

    public void setBtnPlaceholder(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, view) == null) {
            this.j = view;
            w();
        }
    }

    public void setContainer(@NonNull ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, viewGroup) == null) {
            View view = (View) getParent();
            if (view instanceof ViewGroup) {
                ((ViewGroup) view).removeView(this);
            }
            viewGroup.addView(this);
        }
    }

    @Override // c.a.a0.l0.u.b
    public void setData(@NonNull c.a.a0.s.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, gVar) == null) {
            if (!gVar.b()) {
                setVisibility(8);
                return;
            }
            setTag(gVar);
            setVisibility(0);
            n(gVar.f1542g);
            if (!s(gVar)) {
                r(gVar);
            }
            t();
            o(false);
            m(gVar);
        }
    }

    @Override // c.a.a0.l0.u.b
    public void setEnhanceBtnListener(@NonNull c.a.a0.l0.u.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, aVar) == null) {
            this.k = aVar;
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            ViewGroup.LayoutParams layoutParams = this.j.getLayoutParams();
            ViewGroup.LayoutParams layoutParams2 = this.l.getLayoutParams();
            View view = this.j;
            if (view != null && (layoutParams instanceof ViewGroup.MarginLayoutParams) && (layoutParams2 instanceof ViewGroup.MarginLayoutParams)) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                if (this.m) {
                    marginLayoutParams.height = p;
                    marginLayoutParams.topMargin = r;
                    view.requestLayout();
                    marginLayoutParams2.height = this.a;
                    marginLayoutParams2.topMargin = t;
                    marginLayoutParams2.bottomMargin = s;
                    this.l.setAlpha(1.0f);
                    this.l.requestLayout();
                    return;
                }
                marginLayoutParams.height = p;
                marginLayoutParams.topMargin = q;
                view.requestLayout();
                this.l.setVisibility(8);
            }
        }
    }

    public final void u(@NonNull c.a.a0.s.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, hVar) == null) {
            int i = hVar.a;
            if (i == 0) {
                c.a.a0.x.a.b(this.f27456g, new a(this, hVar.f1545b, hVar.f1546c));
            } else if (i == 1) {
                p(hVar);
            } else if (i != 2) {
            } else {
                q(hVar);
            }
        }
    }

    public void update(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            List<c.a.a0.l0.c> list = this.f27456g;
            if (list != null && this.f27457h < c.a.a0.x.a.k(list)) {
                c.a.a0.l0.c cVar = (c.a.a0.l0.c) c.a.a0.x.a.d(this.f27456g, this.f27457h);
                if (cVar != null && i * 1000 >= this.i) {
                    cVar.d();
                    this.i = (int) (this.i + cVar.b() + cVar.a());
                    this.f27457h++;
                    return;
                }
                return;
            }
            c.a.a0.l0.u.a aVar = this.k;
            if (aVar != null) {
                aVar.d();
            }
        }
    }

    public final boolean v() {
        InterceptResult invokeV;
        c.a.a0.s.g gVar;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? (!(getTag() instanceof c.a.a0.s.g) || (gVar = (c.a.a0.s.g) getTag()) == null || gVar.f1542g == null || gVar.f1540e == null || gVar.a != 2) ? false : true : invokeV.booleanValue;
    }

    public final void w() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (view = this.j) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = p;
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = q;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // c.a.a0.l0.u.b
    public View getRealView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (!(getTag() instanceof c.a.a0.s.g)) {
                return this.f27452c;
            }
            if (((c.a.a0.s.g) getTag()).a != 2) {
                return this.f27452c;
            }
            return this.f27451b;
        }
        return (View) invokeV.objValue;
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
        this.f27457h = 0;
        this.i = 0;
        this.k = null;
        this.m = false;
        l(context);
    }
}
