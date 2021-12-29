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
    public NadMiniVideoDownloadView f38618e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f38619f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f38620g;

    /* renamed from: h  reason: collision with root package name */
    public AdImageView f38621h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.c0.g.f.d f38622i;

    /* renamed from: j  reason: collision with root package name */
    public List<c.a.c0.h0.e> f38623j;

    /* renamed from: k  reason: collision with root package name */
    public int f38624k;
    public int l;
    public View m;
    public i n;

    /* loaded from: classes10.dex */
    public class a extends c.a.c0.h0.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AdEnhanceButtonView f38625g;

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
            this.f38625g = adEnhanceButtonView;
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
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f38625g.n == null) {
                return;
            }
            this.f38625g.n.d();
        }
    }

    /* loaded from: classes10.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup.MarginLayoutParams f38626e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AdEnhanceButtonView f38627f;

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
            this.f38627f = adEnhanceButtonView;
            this.f38626e = marginLayoutParams;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                this.f38626e.height = Math.round(AdEnhanceButtonView.OPERATE_BTN_HEIGHT * animatedFraction);
                this.f38626e.topMargin = Math.round(AdEnhanceButtonView.OPERATE_BTN_TOP_MARGIN * animatedFraction);
                this.f38627f.m.requestLayout();
            }
        }
    }

    /* loaded from: classes10.dex */
    public class c extends c.a.c0.h0.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ValueAnimator f38628g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Animation f38629h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ View f38630i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ AdEnhanceButtonView f38631j;

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
            this.f38631j = adEnhanceButtonView;
            this.f38628g = valueAnimator;
            this.f38629h = animation;
            this.f38630i = view;
        }

        @Override // c.a.c0.h0.e
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f38628g.cancel();
                this.f38629h.cancel();
                this.f38631j.s();
            }
        }

        @Override // c.a.c0.h0.e
        public void d() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f38628g.isRunning()) {
                return;
            }
            if (this.f38631j.n != null) {
                this.f38631j.n.e();
            }
            this.f38629h.cancel();
            this.f38628g.start();
            this.f38630i.setVisibility(0);
            this.f38630i.startAnimation(this.f38629h);
        }
    }

    /* loaded from: classes10.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f38632e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AdEnhanceButtonView f38633f;

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
            this.f38633f = adEnhanceButtonView;
            this.f38632e = i2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                View view = this.f38633f.p() ? this.f38633f.f38618e : this.f38633f.f38619f;
                if (view.getBackground() instanceof GradientDrawable) {
                    GradientDrawable gradientDrawable = (GradientDrawable) view.getBackground();
                    gradientDrawable.setColor(k.a.b(animatedFraction, this.f38633f.getContext().getResources().getColor(c.a.c0.b.b.nad_enhancement_btn_first_bg_color), this.f38632e));
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
        public final /* synthetic */ ValueAnimator f38634g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ AdEnhanceButtonView f38635h;

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
            this.f38635h = adEnhanceButtonView;
            this.f38634g = valueAnimator;
        }

        @Override // c.a.c0.h0.e
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f38634g.cancel();
            }
        }

        @Override // c.a.c0.h0.e
        public void d() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f38634g.isRunning()) {
                return;
            }
            if (this.f38635h.n != null) {
                this.f38635h.n.b();
            }
            this.f38634g.start();
        }
    }

    /* loaded from: classes10.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdBaseModel f38636e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AdEnhanceButtonView f38637f;

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
            this.f38637f = adEnhanceButtonView;
            this.f38636e = adBaseModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f38637f.f38622i.o();
                if (this.f38637f.n != null) {
                    this.f38637f.n.a(this.f38636e.f38221f);
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdBaseModel f38638e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AdEnhanceButtonView f38639f;

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
            this.f38639f = adEnhanceButtonView;
            this.f38638e = adBaseModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f38639f.n == null) {
                return;
            }
            this.f38639f.n.a(this.f38638e.f38221f);
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
            this.f38618e = (NadMiniVideoDownloadView) findViewById(c.a.c0.b.e.ad_video_download_btn);
            this.f38619f = (LinearLayout) findViewById(c.a.c0.b.e.common_btn);
            this.f38620g = (TextView) findViewById(c.a.c0.b.e.common_btn_text);
            this.f38621h = (AdImageView) findViewById(c.a.c0.b.e.common_btn_icon);
        }
    }

    public final void i(@NonNull AdBaseModel adBaseModel) {
        h hVar;
        List<c.a.c0.p.i> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, adBaseModel) == null) || (hVar = adBaseModel.f38225j) == null || (list = hVar.a) == null || list.size() <= 0) {
            return;
        }
        this.f38623j = new ArrayList();
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
            (p() ? this.f38618e : this.f38619f).setBackground(gradientDrawable);
            getTag();
        }
    }

    public final void k(@NonNull c.a.c0.p.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, iVar) == null) {
            s();
            if (iVar.f2226c > 0 && !q()) {
                ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(iVar.f2226c);
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
                loadAnimation.setDuration(iVar.f2226c);
                realView.setVisibility(8);
                realView.setAnimation(loadAnimation);
                c.a.c0.u.a.b(this.f38623j, new c(this, iVar.f2225b, iVar.f2226c, duration, loadAnimation, realView));
            }
        }
    }

    public final void l(@NonNull c.a.c0.p.i iVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, iVar) == null) || iVar.f2226c <= 0 || q()) {
            return;
        }
        j(true);
        ValueAnimator duration = ValueAnimator.ofFloat(1.0f).setDuration(iVar.f2226c);
        duration.addUpdateListener(new d(this, getBtnFinalColor()));
        c.a.c0.u.a.b(this.f38623j, new e(this, iVar.f2225b, iVar.f2226c, duration));
    }

    public final void m(@NonNull AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, adBaseModel) == null) {
            if (!r()) {
                this.f38619f.setVisibility(8);
                return;
            }
            this.f38621h.setImageDrawable(getContext().getResources().getDrawable(c.a.c0.b.d.nad_mini_video_ad_pop_command));
            if (!TextUtils.isEmpty(adBaseModel.f38221f.f38228c)) {
                this.f38620g.setText(adBaseModel.f38221f.f38228c);
            } else {
                this.f38620g.setText(getResources().getText(c.a.c0.b.h.nad_command_btn_text));
            }
            this.f38620g.setTextColor(k.a.c("", c.a.c0.b.b.nad_white));
            this.f38619f.setOnClickListener(new g(this, adBaseModel));
            this.f38618e.setVisibility(8);
            this.f38619f.setVisibility(0);
        }
    }

    public final boolean n(@NonNull AdBaseModel adBaseModel) {
        InterceptResult invokeL;
        c.a.c0.p.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, adBaseModel)) == null) {
            if (p() && (cVar = adBaseModel.f38224i) != null && cVar.f2215d) {
                this.f38622i = new c.a.c0.g.f.d(c.a.c0.g.d.a.b(adBaseModel), this.f38618e);
                this.f38618e.setCornerRadius(OPERATE_BTN_CORNOR_RADIUS);
                this.f38618e.setTextSize(12.0f);
                NadMiniVideoDownloadView nadMiniVideoDownloadView = this.f38618e;
                int i2 = OPERATE_BTN_ICON_SIZE;
                nadMiniVideoDownloadView.setImageViewLayout(new FrameLayout.LayoutParams(i2, i2));
                this.f38619f.setVisibility(8);
                this.f38618e.setVisibility(0);
                this.f38618e.setOnClickListener(new f(this, adBaseModel));
                return true;
            }
            if (this.f38622i != null) {
                this.f38622i = null;
            }
            this.f38618e.setVisibility(8);
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void o(@NonNull c.a.c0.p.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, iVar) == null) {
            int i2 = iVar.a;
            if (i2 == 0) {
                c.a.c0.u.a.b(this.f38623j, new a(this, iVar.f2225b, iVar.f2226c));
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (!(getTag() instanceof AdBaseModel) || (adBaseModel = (AdBaseModel) getTag()) == null || adBaseModel.f38222g == null || (adOperator = adBaseModel.f38221f) == null || adOperator.a != AdOperator.TYPE.DOWNLOAD) ? false : true : invokeV.booleanValue;
    }

    public final boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (getTag() instanceof AdBaseModel) {
                AdBaseModel adBaseModel = (AdBaseModel) getTag();
                if (!p() || adBaseModel.f38224i == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? (!(getTag() instanceof AdBaseModel) || (adBaseModel = (AdBaseModel) getTag()) == null || adBaseModel.f38221f == null) ? false : true : invokeV.booleanValue;
    }

    @Override // c.a.c0.h0.g0.b
    public void resetAnim() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            List<c.a.c0.h0.e> list = this.f38623j;
            if (list != null) {
                for (c.a.c0.h0.e eVar : list) {
                    eVar.c();
                }
            }
            this.f38624k = 0;
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
            List<c.a.c0.h0.e> list = this.f38623j;
            if (list != null && this.f38624k < c.a.c0.u.a.k(list)) {
                c.a.c0.h0.e eVar = (c.a.c0.h0.e) c.a.c0.u.a.d(this.f38623j, this.f38624k);
                if (eVar != null && i2 * 1000 >= this.l) {
                    eVar.d();
                    this.l = (int) (this.l + eVar.b() + eVar.a());
                    this.f38624k++;
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
                return this.f38619f;
            }
            if (!r()) {
                return this.f38619f;
            }
            String str = ((AdBaseModel) getTag()).f38221f.a.toString();
            char c2 = 65535;
            if (str.hashCode() == 1427818632 && str.equals("download")) {
                c2 = 0;
            }
            if (c2 != 0) {
                return this.f38619f;
            }
            return this.f38618e;
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
        this.f38624k = 0;
        this.l = 0;
        this.n = null;
        h(context);
    }
}
