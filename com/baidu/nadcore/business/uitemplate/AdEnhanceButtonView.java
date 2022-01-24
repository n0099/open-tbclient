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
import c.a.c0.g0.f;
import c.a.c0.s.k;
import c.a.c0.s.p;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.nadcore.widget.uiwidget.SimpleAdInfoView;
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
public class AdEnhanceButtonView extends FrameLayout implements c.a.c0.k0.a0.b<View> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int APP_INFO_MARGIN_BOTTOM;
    public static final int APP_INFO_MARGIN_TOP;
    public static final int OPERATE_BTN_APP_INFO_TOP_MARGIN;
    public static final int OPERATE_BTN_CORNOR_RADIUS;
    public static final int OPERATE_BTN_HEIGHT;
    public static final int OPERATE_BTN_ICON_SIZE;
    public static final int OPERATE_BTN_TEXT_SIZE = 12;
    public static final int OPERATE_BTN_TOP_MARGIN;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f36953e;

    /* renamed from: f  reason: collision with root package name */
    public NadMiniVideoDownloadView f36954f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f36955g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f36956h;

    /* renamed from: i  reason: collision with root package name */
    public AdImageView f36957i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.c0.j.f.d f36958j;
    public List<c.a.c0.k0.c> k;
    public int l;
    public int m;
    public View n;
    public c.a.c0.k0.a0.a o;
    public SimpleAdInfoView p;
    public boolean q;

    /* loaded from: classes10.dex */
    public class a extends c.a.c0.k0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AdEnhanceButtonView f36959g;

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
            this.f36959g = adEnhanceButtonView;
        }

        @Override // c.a.c0.k0.c
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // c.a.c0.k0.c
        public void d() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f36959g.o == null) {
                return;
            }
            this.f36959g.o.e();
        }
    }

    /* loaded from: classes10.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup.MarginLayoutParams f36960e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ViewGroup.MarginLayoutParams f36961f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ float f36962g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ AdEnhanceButtonView f36963h;

        public b(AdEnhanceButtonView adEnhanceButtonView, ViewGroup.MarginLayoutParams marginLayoutParams, ViewGroup.MarginLayoutParams marginLayoutParams2, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adEnhanceButtonView, marginLayoutParams, marginLayoutParams2, Float.valueOf(f2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36963h = adEnhanceButtonView;
            this.f36960e = marginLayoutParams;
            this.f36961f = marginLayoutParams2;
            this.f36962g = f2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (this.f36963h.q) {
                    this.f36960e.height = Math.round(AdEnhanceButtonView.OPERATE_BTN_HEIGHT * animatedFraction);
                    this.f36960e.topMargin = Math.round(AdEnhanceButtonView.OPERATE_BTN_APP_INFO_TOP_MARGIN * animatedFraction);
                    this.f36963h.n.requestLayout();
                    this.f36961f.height = Math.round(this.f36963h.f36953e * animatedFraction);
                    this.f36961f.topMargin = Math.round(AdEnhanceButtonView.APP_INFO_MARGIN_TOP * animatedFraction);
                    this.f36961f.bottomMargin = Math.round(AdEnhanceButtonView.APP_INFO_MARGIN_BOTTOM * animatedFraction);
                    this.f36963h.p.setY(this.f36962g + Math.round(AdEnhanceButtonView.OPERATE_BTN_HEIGHT * (1.0f - animatedFraction)) + Math.round(AdEnhanceButtonView.APP_INFO_MARGIN_TOP * animatedFraction));
                    this.f36963h.p.setAlpha(animatedFraction);
                    this.f36963h.p.requestLayout();
                    return;
                }
                this.f36960e.height = Math.round(AdEnhanceButtonView.OPERATE_BTN_HEIGHT * animatedFraction);
                this.f36960e.topMargin = Math.round(AdEnhanceButtonView.OPERATE_BTN_TOP_MARGIN * animatedFraction);
                this.f36963h.n.requestLayout();
            }
        }
    }

    /* loaded from: classes10.dex */
    public class c extends c.a.c0.k0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ValueAnimator f36964g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Animation f36965h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ View f36966i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ AdEnhanceButtonView f36967j;

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
            this.f36967j = adEnhanceButtonView;
            this.f36964g = valueAnimator;
            this.f36965h = animation;
            this.f36966i = view;
        }

        @Override // c.a.c0.k0.c
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f36964g.cancel();
                this.f36965h.cancel();
                this.f36967j.v();
            }
        }

        @Override // c.a.c0.k0.c
        public void d() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f36964g.isRunning()) {
                return;
            }
            if (this.f36967j.o != null) {
                this.f36967j.o.f();
            }
            this.f36965h.cancel();
            this.f36964g.start();
            this.f36966i.setVisibility(0);
            this.f36966i.startAnimation(this.f36965h);
        }
    }

    /* loaded from: classes10.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f36968e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AdEnhanceButtonView f36969f;

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
            this.f36969f = adEnhanceButtonView;
            this.f36968e = i2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                View view = this.f36969f.u() ? this.f36969f.f36954f : this.f36969f.f36955g;
                if (view.getBackground() instanceof GradientDrawable) {
                    GradientDrawable gradientDrawable = (GradientDrawable) view.getBackground();
                    gradientDrawable.setColor(c.a.c0.d.q.a.c(animatedFraction, this.f36969f.getContext().getResources().getColor(c.a.c0.d.b.nad_enhancement_btn_first_bg_color), this.f36968e));
                    gradientDrawable.setCornerRadius(AdEnhanceButtonView.OPERATE_BTN_CORNOR_RADIUS);
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class e extends c.a.c0.k0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ValueAnimator f36970g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ AdEnhanceButtonView f36971h;

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
            this.f36971h = adEnhanceButtonView;
            this.f36970g = valueAnimator;
        }

        @Override // c.a.c0.k0.c
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f36970g.cancel();
            }
        }

        @Override // c.a.c0.k0.c
        public void d() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f36970g.isRunning()) {
                return;
            }
            if (this.f36971h.o != null) {
                this.f36971h.o.c();
            }
            this.f36970g.start();
        }
    }

    /* loaded from: classes10.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || this.a.o == null) {
                return;
            }
            this.a.o.a(str);
        }
    }

    /* loaded from: classes10.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdEnhanceButtonView f36972e;

        public g(AdEnhanceButtonView adEnhanceButtonView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adEnhanceButtonView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36972e = adEnhanceButtonView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f36972e.f36958j.o();
            }
        }
    }

    /* loaded from: classes10.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.c0.s.g f36973e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AdEnhanceButtonView f36974f;

        public h(AdEnhanceButtonView adEnhanceButtonView, c.a.c0.s.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adEnhanceButtonView, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36974f = adEnhanceButtonView;
            this.f36973e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f36974f.o == null) {
                return;
            }
            k kVar = new k();
            kVar.f2240b = true;
            kVar.a = this.f36973e.f2230h;
            this.f36974f.o.b(kVar);
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
        OPERATE_BTN_CORNOR_RADIUS = f.c.a(c.a.c0.h.a.b(), 8.0f);
        OPERATE_BTN_ICON_SIZE = f.c.a(c.a.c0.h.a.b(), 15.0f);
        OPERATE_BTN_HEIGHT = f.c.a(c.a.c0.h.a.b(), 33.0f);
        OPERATE_BTN_TOP_MARGIN = f.c.a(c.a.c0.h.a.b(), 9.0f);
        OPERATE_BTN_APP_INFO_TOP_MARGIN = f.c.a(c.a.c0.h.a.b(), 28.0f);
        APP_INFO_MARGIN_BOTTOM = f.c.a(c.a.c0.h.a.b(), 11.0f);
        APP_INFO_MARGIN_TOP = f.c.a(c.a.c0.h.a.b(), 7.0f);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) ? getResources().getColor(c.a.c0.d.b.nad_enhancement_btn_bg_color) : invokeV.intValue;
    }

    public final void k(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            LayoutInflater.from(context).inflate(c.a.c0.d.g.nad_enhance_button_view, this);
            this.f36954f = (NadMiniVideoDownloadView) findViewById(c.a.c0.d.e.ad_video_download_btn);
            this.f36955g = (LinearLayout) findViewById(c.a.c0.d.e.common_btn);
            this.f36956h = (TextView) findViewById(c.a.c0.d.e.common_btn_text);
            this.f36957i = (AdImageView) findViewById(c.a.c0.d.e.common_btn_icon);
            this.p = (SimpleAdInfoView) findViewById(c.a.c0.d.e.app_info_container);
        }
    }

    public final void l(@NonNull c.a.c0.s.g gVar) {
        List<c.a.c0.s.h> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, gVar) == null) || (list = gVar.f2226d) == null || list.size() <= 0) {
            return;
        }
        this.k = new ArrayList();
        for (c.a.c0.s.h hVar : list) {
            if (hVar != null) {
                t(hVar);
            }
        }
    }

    public final void m(@Nullable p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, pVar) == null) {
            if (!c.a.c0.d.q.a.a(pVar)) {
                this.q = false;
                this.p.setVisibility(8);
                return;
            }
            this.q = true;
            this.p.setVisibility(0);
            this.p.setAdInfo(pVar);
            this.p.setAfterListener(new f(this));
            this.f36953e = this.p.getHeight();
            this.p.measure(-2, -2);
            this.f36953e = this.p.getMeasuredHeight();
        }
    }

    public final void n(boolean z) {
        int btnFinalColor;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            if (z) {
                btnFinalColor = getResources().getColor(c.a.c0.d.b.nad_enhancement_btn_first_bg_color);
            } else {
                btnFinalColor = getBtnFinalColor();
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(btnFinalColor);
            gradientDrawable.setCornerRadius(OPERATE_BTN_CORNOR_RADIUS);
            (u() ? this.f36954f : this.f36955g).setBackground(gradientDrawable);
            if (u()) {
                this.f36954f.setProgressColor(getResources().getColor(c.a.c0.d.b.nad_mini_video_ad_download_progress_color));
            }
        }
    }

    public final void o(@NonNull c.a.c0.s.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, hVar) == null) {
            v();
            if (hVar.f2232c <= 0) {
                return;
            }
            ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(hVar.f2232c);
            ViewGroup.LayoutParams layoutParams = this.n.getLayoutParams();
            ViewGroup.LayoutParams layoutParams2 = this.p.getLayoutParams();
            if (this.n != null && (layoutParams instanceof ViewGroup.MarginLayoutParams) && (layoutParams2 instanceof ViewGroup.MarginLayoutParams)) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                float y = this.p.getY();
                marginLayoutParams.height = 0;
                marginLayoutParams.topMargin = 0;
                this.n.requestLayout();
                if (this.q) {
                    marginLayoutParams2.height = 0;
                    marginLayoutParams2.topMargin = 0;
                    marginLayoutParams2.bottomMargin = 0;
                    this.p.requestLayout();
                    this.p.setVisibility(0);
                } else {
                    this.p.setVisibility(8);
                }
                duration.addUpdateListener(new b(this, marginLayoutParams, marginLayoutParams2, y));
            }
            View realView = getRealView();
            Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), c.a.c0.d.a.nad_max_pop_view_fade_in);
            loadAnimation.setDuration(hVar.f2232c);
            realView.setVisibility(8);
            realView.setAnimation(loadAnimation);
            c.a.c0.x.a.b(this.k, new c(this, hVar.f2231b, hVar.f2232c, duration, loadAnimation, realView));
        }
    }

    public final void p(@NonNull c.a.c0.s.h hVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, hVar) == null) || hVar.f2232c <= 0) {
            return;
        }
        n(true);
        ValueAnimator duration = ValueAnimator.ofFloat(1.0f).setDuration(hVar.f2232c);
        duration.addUpdateListener(new d(this, getBtnFinalColor()));
        c.a.c0.x.a.b(this.k, new e(this, hVar.f2231b, hVar.f2232c, duration));
    }

    public final void q(@NonNull c.a.c0.s.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, gVar) == null) {
            if (!TextUtils.isEmpty(gVar.f2225c)) {
                this.f36957i.displayImage(gVar.f2225c);
            } else {
                this.f36957i.setImageDrawable(getContext().getResources().getDrawable(c.a.c0.d.d.nad_mini_video_ad_pop_command));
            }
            if (!TextUtils.isEmpty(gVar.f2224b)) {
                this.f36956h.setText(gVar.f2224b);
            } else {
                this.f36956h.setText(getResources().getText(c.a.c0.d.h.nad_command_btn_text));
            }
            this.f36956h.setTextColor(c.a.c0.d.q.a.d("", c.a.c0.d.b.nad_white));
            this.f36955g.setOnClickListener(new h(this, gVar));
            this.f36954f.setVisibility(8);
            this.f36955g.setVisibility(0);
        }
    }

    public final boolean r(@NonNull c.a.c0.s.g gVar) {
        InterceptResult invokeL;
        c.a.c0.s.c cVar;
        c.a.c0.s.f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, gVar)) == null) {
            if (u() && (cVar = gVar.f2227e) != null && (fVar = gVar.f2228f) != null) {
                gVar.a = 2;
                this.f36958j = new c.a.c0.j.f.d(c.a.c0.j.d.a.c(cVar, fVar.a, gVar.f2230h), this.f36954f);
                this.f36954f.setCornerRadius(OPERATE_BTN_CORNOR_RADIUS);
                this.f36954f.setTextSize(12.0f);
                NadMiniVideoDownloadView nadMiniVideoDownloadView = this.f36954f;
                int i2 = OPERATE_BTN_ICON_SIZE;
                nadMiniVideoDownloadView.setImageViewLayout(new FrameLayout.LayoutParams(i2, i2));
                this.f36955g.setVisibility(8);
                this.f36954f.setVisibility(0);
                this.f36954f.setOnClickListener(new g(this));
                return true;
            }
            if (this.f36958j != null) {
                this.f36958j = null;
            }
            this.f36954f.setVisibility(8);
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.c0.k0.a0.b
    public void resetAnim() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            List<c.a.c0.k0.c> list = this.k;
            if (list != null) {
                for (c.a.c0.k0.c cVar : list) {
                    cVar.c();
                }
            }
            this.l = 0;
            this.m = 0;
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            ViewGroup.LayoutParams layoutParams = this.n.getLayoutParams();
            ViewGroup.LayoutParams layoutParams2 = this.p.getLayoutParams();
            View view = this.n;
            if (view != null && (layoutParams instanceof ViewGroup.MarginLayoutParams) && (layoutParams2 instanceof ViewGroup.MarginLayoutParams)) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                if (this.q) {
                    marginLayoutParams.height = OPERATE_BTN_HEIGHT;
                    marginLayoutParams.topMargin = OPERATE_BTN_APP_INFO_TOP_MARGIN;
                    view.requestLayout();
                    marginLayoutParams2.height = this.f36953e;
                    marginLayoutParams2.topMargin = APP_INFO_MARGIN_TOP;
                    marginLayoutParams2.bottomMargin = APP_INFO_MARGIN_BOTTOM;
                    this.p.setAlpha(1.0f);
                    this.p.requestLayout();
                    return;
                }
                marginLayoutParams.height = OPERATE_BTN_HEIGHT;
                marginLayoutParams.topMargin = OPERATE_BTN_TOP_MARGIN;
                view.requestLayout();
                this.p.setVisibility(8);
            }
        }
    }

    @Override // c.a.c0.k0.a0.b
    public void setBtnIconNightModeEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
        }
    }

    public void setBtnPlaceholder(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, view) == null) {
            this.n = view;
            v();
        }
    }

    public void setContainer(@NonNull ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, viewGroup) == null) {
            View view = (View) getParent();
            if (view instanceof ViewGroup) {
                ((ViewGroup) view).removeView(this);
            }
            viewGroup.addView(this);
        }
    }

    @Override // c.a.c0.k0.a0.b
    public void setData(@NonNull c.a.c0.s.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, gVar) == null) {
            if (!gVar.a()) {
                setVisibility(8);
                return;
            }
            setTag(gVar);
            setVisibility(0);
            m(gVar.f2229g);
            if (!r(gVar)) {
                q(gVar);
            }
            s();
            n(false);
            l(gVar);
        }
    }

    @Override // c.a.c0.k0.a0.b
    public void setEnhanceBtnListener(@NonNull c.a.c0.k0.a0.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, aVar) == null) {
            this.o = aVar;
        }
    }

    public final void t(@NonNull c.a.c0.s.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, hVar) == null) {
            int i2 = hVar.a;
            if (i2 == 0) {
                c.a.c0.x.a.b(this.k, new a(this, hVar.f2231b, hVar.f2232c));
            } else if (i2 == 1) {
                o(hVar);
            } else if (i2 != 2) {
            } else {
                p(hVar);
            }
        }
    }

    public final boolean u() {
        InterceptResult invokeV;
        c.a.c0.s.g gVar;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? (!(getTag() instanceof c.a.c0.s.g) || (gVar = (c.a.c0.s.g) getTag()) == null || gVar.f2229g == null || gVar.f2227e == null || gVar.a != 2) ? false : true : invokeV.booleanValue;
    }

    @Override // c.a.c0.k0.a0.b
    public void update(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            List<c.a.c0.k0.c> list = this.k;
            if (list != null && this.l < c.a.c0.x.a.k(list)) {
                c.a.c0.k0.c cVar = (c.a.c0.k0.c) c.a.c0.x.a.d(this.k, this.l);
                if (cVar != null && i2 * 1000 >= this.m) {
                    cVar.d();
                    this.m = (int) (this.m + cVar.b() + cVar.a());
                    this.l++;
                    return;
                }
                return;
            }
            c.a.c0.k0.a0.a aVar = this.o;
            if (aVar != null) {
                aVar.d();
            }
        }
    }

    @Override // c.a.c0.k0.a0.b
    public void updateUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
        }
    }

    public final void v() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (view = this.n) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = OPERATE_BTN_HEIGHT;
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = OPERATE_BTN_TOP_MARGIN;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // c.a.c0.k0.a0.b
    public View getRealView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!(getTag() instanceof c.a.c0.s.g)) {
                return this.f36955g;
            }
            if (((c.a.c0.s.g) getTag()).a != 2) {
                return this.f36955g;
            }
            return this.f36954f;
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
        this.l = 0;
        this.m = 0;
        this.o = null;
        this.q = false;
        k(context);
    }
}
