package com.baidu.nadcore.widget.view;

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
import androidx.core.view.InputDeviceCompat;
import c.a.c0.d0.f;
import c.a.c0.h0.i;
import c.a.c0.p.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.model.AdOperator;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class AdEnhanceButtonView extends FrameLayout implements c.a.c0.h0.g0.b<View> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int OPERATE_BTN_CORNOR_RADIUS;
    public static final int OPERATE_BTN_HEIGHT;
    public static final int OPERATE_BTN_ICON_SIZE;
    public static final int OPERATE_BTN_TEXT_SIZE = 12;
    public static final int OPERATE_BTN_TOP_MARGIN;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public NadMiniVideoDownloadView f38462e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f38463f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f38464g;

    /* renamed from: h  reason: collision with root package name */
    public AdImageView f38465h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.c0.g.f.d f38466i;

    /* renamed from: j  reason: collision with root package name */
    public List<c.a.c0.h0.e> f38467j;

    /* renamed from: k  reason: collision with root package name */
    public int f38468k;
    public int l;
    public View m;
    public i n;

    /* loaded from: classes10.dex */
    public class a extends c.a.c0.h0.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AdEnhanceButtonView f38469g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AdEnhanceButtonView adEnhanceButtonView, long j2, long j3) {
            super(j2, j3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adEnhanceButtonView, Long.valueOf(j2), Long.valueOf(j3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38469g = adEnhanceButtonView;
        }

        @Override // c.a.c0.h0.e
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // c.a.c0.h0.e
        public void d() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f38469g.n == null) {
                return;
            }
            this.f38469g.n.d();
        }
    }

    /* loaded from: classes10.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup.MarginLayoutParams f38470e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AdEnhanceButtonView f38471f;

        public b(AdEnhanceButtonView adEnhanceButtonView, ViewGroup.MarginLayoutParams marginLayoutParams) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adEnhanceButtonView, marginLayoutParams};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38471f = adEnhanceButtonView;
            this.f38470e = marginLayoutParams;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                this.f38470e.height = Math.round(AdEnhanceButtonView.OPERATE_BTN_HEIGHT * animatedFraction);
                this.f38470e.topMargin = Math.round(AdEnhanceButtonView.OPERATE_BTN_TOP_MARGIN * animatedFraction);
                this.f38471f.m.requestLayout();
            }
        }
    }

    /* loaded from: classes10.dex */
    public class c extends c.a.c0.h0.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ValueAnimator f38472g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Animation f38473h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ View f38474i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ AdEnhanceButtonView f38475j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(AdEnhanceButtonView adEnhanceButtonView, long j2, long j3, ValueAnimator valueAnimator, Animation animation, View view) {
            super(j2, j3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {adEnhanceButtonView, Long.valueOf(j2), Long.valueOf(j3), valueAnimator, animation, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38475j = adEnhanceButtonView;
            this.f38472g = valueAnimator;
            this.f38473h = animation;
            this.f38474i = view;
        }

        @Override // c.a.c0.h0.e
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f38472g.cancel();
                this.f38473h.cancel();
                this.f38475j.s();
            }
        }

        @Override // c.a.c0.h0.e
        public void d() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f38472g.isRunning()) {
                return;
            }
            if (this.f38475j.n != null) {
                this.f38475j.n.e();
            }
            this.f38473h.cancel();
            this.f38472g.start();
            this.f38474i.setVisibility(0);
            this.f38474i.startAnimation(this.f38473h);
        }
    }

    /* loaded from: classes10.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f38476e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AdEnhanceButtonView f38477f;

        public d(AdEnhanceButtonView adEnhanceButtonView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adEnhanceButtonView, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38477f = adEnhanceButtonView;
            this.f38476e = i2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                View view = this.f38477f.p() ? this.f38477f.f38462e : this.f38477f.f38463f;
                if (view.getBackground() instanceof GradientDrawable) {
                    GradientDrawable gradientDrawable = (GradientDrawable) view.getBackground();
                    gradientDrawable.setColor(k.a.b(animatedFraction, this.f38477f.getContext().getResources().getColor(c.a.c0.b.b.nad_enhancement_btn_first_bg_color), this.f38476e));
                    gradientDrawable.setCornerRadius(AdEnhanceButtonView.OPERATE_BTN_CORNOR_RADIUS);
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class e extends c.a.c0.h0.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ValueAnimator f38478g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ AdEnhanceButtonView f38479h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(AdEnhanceButtonView adEnhanceButtonView, long j2, long j3, ValueAnimator valueAnimator) {
            super(j2, j3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adEnhanceButtonView, Long.valueOf(j2), Long.valueOf(j3), valueAnimator};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38479h = adEnhanceButtonView;
            this.f38478g = valueAnimator;
        }

        @Override // c.a.c0.h0.e
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f38478g.cancel();
            }
        }

        @Override // c.a.c0.h0.e
        public void d() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f38478g.isRunning()) {
                return;
            }
            if (this.f38479h.n != null) {
                this.f38479h.n.b();
            }
            this.f38478g.start();
        }
    }

    /* loaded from: classes10.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdBaseModel f38480e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AdEnhanceButtonView f38481f;

        public f(AdEnhanceButtonView adEnhanceButtonView, AdBaseModel adBaseModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adEnhanceButtonView, adBaseModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38481f = adEnhanceButtonView;
            this.f38480e = adBaseModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f38481f.f38466i.o();
                if (this.f38481f.n != null) {
                    this.f38481f.n.a(this.f38480e.f38065f);
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdBaseModel f38482e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AdEnhanceButtonView f38483f;

        public g(AdEnhanceButtonView adEnhanceButtonView, AdBaseModel adBaseModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adEnhanceButtonView, adBaseModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38483f = adEnhanceButtonView;
            this.f38482e = adBaseModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f38483f.n == null) {
                return;
            }
            this.f38483f.n.a(this.f38482e.f38065f);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1369552795, "Lcom/baidu/nadcore/widget/view/AdEnhanceButtonView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1369552795, "Lcom/baidu/nadcore/widget/view/AdEnhanceButtonView;");
                return;
            }
        }
        OPERATE_BTN_CORNOR_RADIUS = f.c.a(c.a.c0.e.a.b(), 8.0f);
        OPERATE_BTN_ICON_SIZE = f.c.a(c.a.c0.e.a.b(), 15.0f);
        OPERATE_BTN_HEIGHT = f.c.a(c.a.c0.e.a.b(), 33.0f);
        OPERATE_BTN_TOP_MARGIN = f.c.a(c.a.c0.e.a.b(), 9.0f);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            if (getTag() instanceof PortraitVideoView) {
                PortraitVideoView portraitVideoView = (PortraitVideoView) getTag();
                return k.a.c("TODO", c.a.c0.b.b.nad_enhancement_btn_bg_color);
            }
            return getResources().getColor(c.a.c0.b.b.nad_enhancement_btn_bg_color);
        }
        return invokeV.intValue;
    }

    public final void h(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            LayoutInflater.from(context).inflate(c.a.c0.b.g.nad_enhance_button_view, this);
            this.f38462e = (NadMiniVideoDownloadView) findViewById(c.a.c0.b.e.ad_video_download_btn);
            this.f38463f = (LinearLayout) findViewById(c.a.c0.b.e.common_btn);
            this.f38464g = (TextView) findViewById(c.a.c0.b.e.common_btn_text);
            this.f38465h = (AdImageView) findViewById(c.a.c0.b.e.common_btn_icon);
        }
    }

    public final void i(@NonNull AdBaseModel adBaseModel) {
        h hVar;
        List<c.a.c0.p.i> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, adBaseModel) == null) || (hVar = adBaseModel.f38069j) == null || (list = hVar.a) == null || list.size() <= 0) {
            return;
        }
        this.f38467j = new ArrayList();
        for (c.a.c0.p.i iVar : list) {
            if (iVar != null) {
                o(iVar);
            }
        }
    }

    public final void j(boolean z) {
        int btnFinalColor;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            if (z) {
                btnFinalColor = getResources().getColor(c.a.c0.b.b.nad_enhancement_btn_first_bg_color);
            } else {
                btnFinalColor = getBtnFinalColor();
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(btnFinalColor);
            gradientDrawable.setCornerRadius(OPERATE_BTN_CORNOR_RADIUS);
            (p() ? this.f38462e : this.f38463f).setBackground(gradientDrawable);
            getTag();
        }
    }

    public final void k(@NonNull c.a.c0.p.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, iVar) == null) {
            s();
            if (iVar.f1799c > 0 && !q()) {
                ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(iVar.f1799c);
                ViewGroup.LayoutParams layoutParams = this.m.getLayoutParams();
                View view = this.m;
                if (view != null && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    marginLayoutParams.height = 0;
                    marginLayoutParams.topMargin = 0;
                    view.requestLayout();
                    duration.addUpdateListener(new b(this, marginLayoutParams));
                }
                View realView = getRealView();
                Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), c.a.c0.b.a.ad_video_pop_view_fade_in);
                loadAnimation.setDuration(iVar.f1799c);
                realView.setVisibility(8);
                realView.setAnimation(loadAnimation);
                c.a.c0.u.a.b(this.f38467j, new c(this, iVar.f1798b, iVar.f1799c, duration, loadAnimation, realView));
            }
        }
    }

    public final void l(@NonNull c.a.c0.p.i iVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, iVar) == null) || iVar.f1799c <= 0 || q()) {
            return;
        }
        j(true);
        ValueAnimator duration = ValueAnimator.ofFloat(1.0f).setDuration(iVar.f1799c);
        duration.addUpdateListener(new d(this, getBtnFinalColor()));
        c.a.c0.u.a.b(this.f38467j, new e(this, iVar.f1798b, iVar.f1799c, duration));
    }

    public final void m(@NonNull AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, adBaseModel) == null) {
            if (!r()) {
                this.f38463f.setVisibility(8);
                return;
            }
            this.f38465h.setImageDrawable(getContext().getResources().getDrawable(c.a.c0.b.d.nad_mini_video_ad_pop_command));
            if (!TextUtils.isEmpty(adBaseModel.f38065f.f38072c)) {
                this.f38464g.setText(adBaseModel.f38065f.f38072c);
            } else {
                this.f38464g.setText(getResources().getText(c.a.c0.b.h.nad_command_btn_text));
            }
            this.f38464g.setTextColor(k.a.c("", c.a.c0.b.b.nad_white));
            this.f38463f.setOnClickListener(new g(this, adBaseModel));
            this.f38462e.setVisibility(8);
            this.f38463f.setVisibility(0);
        }
    }

    public final boolean n(@NonNull AdBaseModel adBaseModel) {
        InterceptResult invokeL;
        c.a.c0.p.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, adBaseModel)) == null) {
            if (p() && (cVar = adBaseModel.f38068i) != null && cVar.f1788d) {
                this.f38466i = new c.a.c0.g.f.d(c.a.c0.g.d.a.b(adBaseModel), this.f38462e);
                this.f38462e.setCornerRadius(OPERATE_BTN_CORNOR_RADIUS);
                this.f38462e.setTextSize(12.0f);
                NadMiniVideoDownloadView nadMiniVideoDownloadView = this.f38462e;
                int i2 = OPERATE_BTN_ICON_SIZE;
                nadMiniVideoDownloadView.setImageViewLayout(new FrameLayout.LayoutParams(i2, i2));
                this.f38463f.setVisibility(8);
                this.f38462e.setVisibility(0);
                this.f38462e.setOnClickListener(new f(this, adBaseModel));
                return true;
            }
            if (this.f38466i != null) {
                this.f38466i = null;
            }
            this.f38462e.setVisibility(8);
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void o(@NonNull c.a.c0.p.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, iVar) == null) {
            int i2 = iVar.a;
            if (i2 == 0) {
                c.a.c0.u.a.b(this.f38467j, new a(this, iVar.f1798b, iVar.f1799c));
            } else if (i2 == 1) {
                k(iVar);
            } else if (i2 != 2) {
            } else {
                l(iVar);
            }
        }
    }

    public final boolean p() {
        InterceptResult invokeV;
        AdBaseModel adBaseModel;
        AdOperator adOperator;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (!(getTag() instanceof AdBaseModel) || (adBaseModel = (AdBaseModel) getTag()) == null || adBaseModel.f38066g == null || (adOperator = adBaseModel.f38065f) == null || adOperator.a != AdOperator.TYPE.DOWNLOAD) ? false : true : invokeV.booleanValue;
    }

    public final boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (getTag() instanceof AdBaseModel) {
                AdBaseModel adBaseModel = (AdBaseModel) getTag();
                if (!p() || adBaseModel.f38068i == null) {
                }
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean r() {
        InterceptResult invokeV;
        AdBaseModel adBaseModel;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? (!(getTag() instanceof AdBaseModel) || (adBaseModel = (AdBaseModel) getTag()) == null || adBaseModel.f38065f == null) ? false : true : invokeV.booleanValue;
    }

    @Override // c.a.c0.h0.g0.b
    public void resetAnim() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            List<c.a.c0.h0.e> list = this.f38467j;
            if (list != null) {
                for (c.a.c0.h0.e eVar : list) {
                    eVar.c();
                }
            }
            this.f38468k = 0;
            this.l = 0;
        }
    }

    public final void s() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (view = this.m) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = OPERATE_BTN_HEIGHT;
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = OPERATE_BTN_TOP_MARGIN;
        }
    }

    @Override // c.a.c0.h0.g0.b
    public void setBtnIconNightModeEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
        }
    }

    public void setBtnPlaceholder(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, view) == null) {
            this.m = view;
            s();
        }
    }

    public void setContainer(@NonNull ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, viewGroup) == null) {
            View view = (View) getParent();
            if (view instanceof ViewGroup) {
                ((ViewGroup) view).removeView(this);
            }
            viewGroup.addView(this);
        }
    }

    @Override // c.a.c0.h0.g0.b
    public void setData(@NonNull AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, adBaseModel) == null) {
            if (adBaseModel == null) {
                setVisibility(8);
                return;
            }
            setTag(adBaseModel);
            setVisibility(0);
            if (!n(adBaseModel)) {
                m(adBaseModel);
            }
            j(false);
            i(adBaseModel);
        }
    }

    @Override // c.a.c0.h0.g0.b
    public void setEnhanceBtnListener(@NonNull i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, iVar) == null) {
            this.n = iVar;
        }
    }

    @Override // c.a.c0.h0.g0.b
    public void update(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            List<c.a.c0.h0.e> list = this.f38467j;
            if (list != null && this.f38468k < c.a.c0.u.a.k(list)) {
                c.a.c0.h0.e eVar = (c.a.c0.h0.e) c.a.c0.u.a.d(this.f38467j, this.f38468k);
                if (eVar != null && i2 * 1000 >= this.l) {
                    eVar.d();
                    this.l = (int) (this.l + eVar.b() + eVar.a());
                    this.f38468k++;
                    return;
                }
                return;
            }
            i iVar = this.n;
            if (iVar != null) {
                iVar.c();
            }
        }
    }

    @Override // c.a.c0.h0.g0.b
    public void updateUI() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048597, this) != null) || !(getTag() instanceof AdBaseModel)) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // c.a.c0.h0.g0.b
    public View getRealView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!(getTag() instanceof AdBaseModel)) {
                return this.f38463f;
            }
            if (!r()) {
                return this.f38463f;
            }
            String str = ((AdBaseModel) getTag()).f38065f.a.toString();
            char c2 = 65535;
            if (str.hashCode() == 1427818632 && str.equals("download")) {
                c2 = 0;
            }
            if (c2 != 0) {
                return this.f38463f;
            }
            return this.f38462e;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdEnhanceButtonView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f38468k = 0;
        this.l = 0;
        this.n = null;
        h(context);
    }
}
