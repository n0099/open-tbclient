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
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.nadcore.widget.NadButtonLottieView;
import com.baidu.nadcore.widget.uiwidget.SimpleAdInfoView;
import com.baidu.tieba.R;
import com.baidu.tieba.ae0;
import com.baidu.tieba.b91;
import com.baidu.tieba.bn0;
import com.baidu.tieba.ce0;
import com.baidu.tieba.d91;
import com.baidu.tieba.dz0;
import com.baidu.tieba.ef0;
import com.baidu.tieba.h71;
import com.baidu.tieba.hd0;
import com.baidu.tieba.hf0;
import com.baidu.tieba.jh0;
import com.baidu.tieba.kn0;
import com.baidu.tieba.ny0;
import com.baidu.tieba.pn0;
import com.baidu.tieba.s11;
import com.baidu.tieba.ti0;
import com.baidu.tieba.uc0;
import com.baidu.tieba.ve0;
import com.baidu.tieba.w11;
import com.baidu.tieba.wg0;
import com.baidu.tieba.xi0;
import com.baidu.tieba.xm0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class AdEnhanceButtonView extends FrameLayout implements d91<View> {
    public static final int s = w11.c.a(hf0.b(), 8.0f);
    public static final int t = w11.c.a(hf0.b(), 12.0f);
    public static final int u = w11.c.a(hf0.b(), 33.0f);
    public static final int v = w11.c.a(hf0.b(), 9.0f);
    public static final int w = w11.c.a(hf0.b(), 28.0f);
    public static final int x = w11.c.a(hf0.b(), 11.0f);
    public static final int y = w11.c.a(hf0.b(), 7.0f);
    public int a;
    public int b;
    public NadEnhanceButtonDownloadView c;
    public LinearLayout d;
    public TextView e;
    public AdImageView f;
    public jh0 g;
    public List<h71> h;
    public int i;
    public int j;
    public View k;
    public b91 l;
    public SimpleAdInfoView m;
    public boolean n;
    public NadButtonLottieView o;
    public int p;
    public int q;
    public int r;

    public int getLayoutId() {
        return R.layout.nad_enhance_button_view;
    }

    @Override // com.baidu.tieba.d91
    public void setBtnIconNightModeEnable(boolean z) {
    }

    /* loaded from: classes3.dex */
    public class a extends h71 {
        @Override // com.baidu.tieba.h71
        public void c() {
        }

        public a(long j, long j2) {
            super(j, j2);
        }

        @Override // com.baidu.tieba.h71
        public void d() {
            if (AdEnhanceButtonView.this.l != null) {
                AdEnhanceButtonView.this.l.e();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ ViewGroup.MarginLayoutParams a;
        public final /* synthetic */ ViewGroup.MarginLayoutParams b;
        public final /* synthetic */ float c;

        public b(ViewGroup.MarginLayoutParams marginLayoutParams, ViewGroup.MarginLayoutParams marginLayoutParams2, float f) {
            this.a = marginLayoutParams;
            this.b = marginLayoutParams2;
            this.c = f;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float animatedFraction = valueAnimator.getAnimatedFraction();
            if (AdEnhanceButtonView.this.n) {
                this.a.height = Math.round(AdEnhanceButtonView.this.a * animatedFraction);
                this.a.topMargin = Math.round(AdEnhanceButtonView.w * animatedFraction);
                AdEnhanceButtonView.this.k.requestLayout();
                this.b.height = Math.round(AdEnhanceButtonView.this.b * animatedFraction);
                this.b.topMargin = Math.round(AdEnhanceButtonView.y * animatedFraction);
                this.b.bottomMargin = Math.round(AdEnhanceButtonView.x * animatedFraction);
                AdEnhanceButtonView.this.m.setY(this.c + Math.round(AdEnhanceButtonView.this.a * (1.0f - animatedFraction)) + Math.round(AdEnhanceButtonView.y * animatedFraction));
                AdEnhanceButtonView.this.m.setAlpha(animatedFraction);
                AdEnhanceButtonView.this.m.requestLayout();
                return;
            }
            this.a.height = Math.round(AdEnhanceButtonView.this.a * animatedFraction);
            this.a.topMargin = Math.round(AdEnhanceButtonView.v * animatedFraction);
            AdEnhanceButtonView.this.k.requestLayout();
        }
    }

    /* loaded from: classes3.dex */
    public class c extends h71 {
        public final /* synthetic */ ValueAnimator c;
        public final /* synthetic */ Animation d;
        public final /* synthetic */ View e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(long j, long j2, ValueAnimator valueAnimator, Animation animation, View view2) {
            super(j, j2);
            this.c = valueAnimator;
            this.d = animation;
            this.e = view2;
        }

        @Override // com.baidu.tieba.h71
        public void c() {
            this.c.cancel();
            this.d.cancel();
            AdEnhanceButtonView.this.F();
        }

        @Override // com.baidu.tieba.h71
        public void d() {
            if (this.c.isRunning()) {
                return;
            }
            if (AdEnhanceButtonView.this.l != null) {
                AdEnhanceButtonView.this.l.f();
            }
            this.d.cancel();
            this.c.start();
            this.e.setVisibility(0);
            if (AdEnhanceButtonView.this.o != null) {
                AdEnhanceButtonView.this.o.setVisibility(0);
            }
            this.e.startAnimation(this.d);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        public d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float animatedFraction = valueAnimator.getAnimatedFraction();
            View view2 = AdEnhanceButtonView.this.C() ? AdEnhanceButtonView.this.c : AdEnhanceButtonView.this.d;
            if (view2.getBackground() instanceof GradientDrawable) {
                GradientDrawable gradientDrawable = (GradientDrawable) view2.getBackground();
                gradientDrawable.setColor(ce0.d(animatedFraction, AdEnhanceButtonView.this.q, AdEnhanceButtonView.this.getBtnFinalColor()));
                gradientDrawable.setCornerRadius(AdEnhanceButtonView.this.p);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e extends h71 {
        public final /* synthetic */ ValueAnimator c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(long j, long j2, ValueAnimator valueAnimator) {
            super(j, j2);
            this.c = valueAnimator;
        }

        @Override // com.baidu.tieba.h71
        public void c() {
            this.c.cancel();
        }

        @Override // com.baidu.tieba.h71
        public void d() {
            if (this.c.isRunning()) {
                return;
            }
            if (AdEnhanceButtonView.this.l != null) {
                AdEnhanceButtonView.this.l.c();
            }
            if (AdEnhanceButtonView.this.o != null) {
                AdEnhanceButtonView.this.o.playAnimation();
            }
            this.c.start();
        }
    }

    /* loaded from: classes3.dex */
    public class f implements SimpleAdInfoView.c {
        public f() {
        }

        @Override // com.baidu.nadcore.widget.uiwidget.SimpleAdInfoView.c
        public void a(String str) {
            if (AdEnhanceButtonView.this.l != null) {
                AdEnhanceButtonView.this.l.a(str);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements View.OnClickListener {
        public final /* synthetic */ xm0 a;

        public g(xm0 xm0Var) {
            this.a = xm0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            AdEnhanceButtonView.this.g.l();
            ce0.b(this.a.h);
        }
    }

    /* loaded from: classes3.dex */
    public class h implements View.OnClickListener {
        public final /* synthetic */ xm0 a;

        public h(xm0 xm0Var) {
            this.a = xm0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (AdEnhanceButtonView.this.l != null) {
                kn0 kn0Var = new kn0();
                kn0Var.c = true;
                xm0 xm0Var = this.a;
                String str = xm0Var.t;
                kn0Var.a = str;
                if (xm0Var.a == 0 && AdEnhanceButtonView.this.q(str).booleanValue()) {
                    kn0Var.a = "";
                }
                AdEnhanceButtonView.this.l.b(kn0Var);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i extends xi0<hd0> {
        public final /* synthetic */ xm0 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(Class cls, xm0 xm0Var) {
            super(cls);
            this.b = xm0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xi0
        public void onEvent(@NonNull hd0 hd0Var) {
            GradientDrawable gradientDrawable;
            if ("4".equals(hd0Var.a)) {
                if (hd0Var.h) {
                    AdEnhanceButtonView.this.y(this.b);
                    return;
                }
                if (hd0Var.f != null) {
                    AdEnhanceButtonView.this.f.u(hd0Var.f);
                }
                if (hd0Var.g != null) {
                    AdEnhanceButtonView.this.e.setText(hd0Var.g);
                }
                if (hd0Var.d != null && hd0Var.e != null && (gradientDrawable = (GradientDrawable) AdEnhanceButtonView.this.d.getBackground()) != null) {
                    gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
                    gradientDrawable.setColors(new int[]{s11.a(hd0Var.d, R.color.nad_reward_full_tail_btn_color), s11.a(hd0Var.e, R.color.nad_reward_full_tail_btn_color)});
                    AdEnhanceButtonView.this.d.setBackground(gradientDrawable);
                }
                dz0.e(new ClogBuilder().y(ClogBuilder.LogType.REWARD_SHOW_TASK).u(ClogBuilder.Page.WELFARETAIL).p(hd0Var.i).k("4").l(hd0Var.c));
            }
        }
    }

    public final void A() {
        ViewGroup.LayoutParams layoutParams = this.k.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = this.m.getLayoutParams();
        View view2 = this.k;
        if (view2 != null && (layoutParams instanceof ViewGroup.MarginLayoutParams) && (layoutParams2 instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
            if (this.n) {
                marginLayoutParams.height = this.a;
                marginLayoutParams.topMargin = w;
                view2.requestLayout();
                marginLayoutParams2.height = this.b;
                marginLayoutParams2.topMargin = y;
                marginLayoutParams2.bottomMargin = x;
                this.m.setAlpha(1.0f);
                this.m.requestLayout();
                return;
            }
            marginLayoutParams.height = this.a;
            marginLayoutParams.topMargin = v;
            view2.requestLayout();
            this.m.setVisibility(8);
        }
    }

    public AdEnhanceButtonView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdEnhanceButtonView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.i = 0;
        this.j = 0;
        this.l = null;
        this.n = false;
        this.o = null;
        this.p = w11.c.a(hf0.b(), 17.0f);
        this.q = getResources().getColor(R.color.nad_enhancement_btn_first_bg_color);
        this.r = getResources().getColor(R.color.nad_enhancement_btn_bg_color);
        r(context);
        D(attributeSet);
    }

    public AdEnhanceButtonView(@NonNull Context context, @NonNull ViewGroup viewGroup, @NonNull View view2) {
        this(context, null);
        setContainer(viewGroup);
        setBtnPlaceholder(view2);
    }

    public final void B(@NonNull bn0 bn0Var) {
        int i2 = bn0Var.a;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 == 2) {
                    x(bn0Var);
                    return;
                }
                return;
            }
            w(bn0Var);
            return;
        }
        ny0.b(this.h, new a(bn0Var.b, bn0Var.c));
    }

    public final void E(@NonNull xm0 xm0Var) {
        ti0.a().c(this, new i(hd0.class, xm0Var));
    }

    public Boolean q(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return Boolean.FALSE;
        }
        if (!ef0.o(str)) {
            return Boolean.FALSE;
        }
        return Boolean.valueOf("rewardWebPanel".equals(new ve0(str).a()));
    }

    public final void s(@NonNull xm0 xm0Var) {
        List<bn0> list = xm0Var.o;
        if (list != null && list.size() > 0) {
            this.h = new ArrayList();
            for (bn0 bn0Var : list) {
                if (bn0Var != null) {
                    B(bn0Var);
                }
            }
        }
    }

    public void setBtnCornerRadius(int i2) {
        this.p = i2;
    }

    public void setBtnHeight(int i2) {
        this.a = i2;
        LinearLayout linearLayout = this.d;
        if (linearLayout != null) {
            ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
            layoutParams.height = this.a;
            this.d.setLayoutParams(layoutParams);
        }
        NadEnhanceButtonDownloadView nadEnhanceButtonDownloadView = this.c;
        if (nadEnhanceButtonDownloadView != null) {
            ViewGroup.LayoutParams layoutParams2 = nadEnhanceButtonDownloadView.getLayoutParams();
            layoutParams2.height = this.a;
            this.c.setLayoutParams(layoutParams2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.d91
    public void setBtnPlaceholder(View view2) {
        this.k = view2;
        F();
    }

    public void setBtnTextSize(float f2) {
        NadEnhanceButtonDownloadView nadEnhanceButtonDownloadView = this.c;
        if (nadEnhanceButtonDownloadView != null) {
            nadEnhanceButtonDownloadView.setTextSize(f2);
        }
        TextView textView = this.e;
        if (textView != null) {
            textView.setTextSize(1, f2);
        }
    }

    public void setButtonLottieViewHeight(int i2) {
        ViewGroup.LayoutParams layoutParams = this.o.getLayoutParams();
        layoutParams.height = i2;
        this.o.setLayoutParams(layoutParams);
    }

    public void setContainer(@NonNull ViewGroup viewGroup) {
        View view2 = (View) getParent();
        if (view2 instanceof ViewGroup) {
            ((ViewGroup) view2).removeView(this);
        }
        viewGroup.addView(this);
    }

    @Override // com.baidu.tieba.d91
    public void setEnhanceBtnListener(@NonNull b91 b91Var) {
        this.l = b91Var;
    }

    @Override // com.baidu.tieba.d91
    public void setVisible(int i2) {
        setVisibility(i2);
    }

    public boolean C() {
        xm0 xm0Var;
        if (!(getTag() instanceof xm0) || (xm0Var = (xm0) getTag()) == null) {
            return false;
        }
        if (!xm0Var.e && !xm0Var.u) {
            if (xm0Var.s == null || xm0Var.p == null || xm0Var.a != 2) {
                return false;
            }
            return true;
        } else if (xm0Var.p == null || xm0Var.a != 2) {
            return false;
        } else {
            return true;
        }
    }

    public final void D(AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, uc0.NadEnhanceButtonView);
        this.p = obtainStyledAttributes.getDimensionPixelSize(2, w11.c.a(hf0.b(), 8.0f));
        this.q = obtainStyledAttributes.getColor(1, getResources().getColor(R.color.nad_enhancement_btn_first_bg_color));
        this.r = obtainStyledAttributes.getColor(0, getResources().getColor(R.color.nad_enhancement_btn_bg_color));
        obtainStyledAttributes.recycle();
    }

    public final void r(Context context) {
        LayoutInflater.from(context).inflate(getLayoutId(), this);
        this.c = (NadEnhanceButtonDownloadView) findViewById(R.id.ad_video_download_btn);
        this.d = (LinearLayout) findViewById(R.id.common_btn);
        this.e = (TextView) findViewById(R.id.common_btn_text);
        this.f = (AdImageView) findViewById(R.id.common_btn_icon);
        this.m = (SimpleAdInfoView) findViewById(R.id.app_info_container);
        v();
    }

    public final void t(@Nullable pn0 pn0Var) {
        if (!ce0.a(pn0Var)) {
            this.n = false;
            this.m.setVisibility(8);
            return;
        }
        this.n = true;
        this.m.setVisibility(0);
        this.m.setAdInfo(pn0Var);
        this.m.setAfterListener(new f());
        this.b = this.m.getHeight();
        this.m.measure(-2, -2);
        this.b = this.m.getMeasuredHeight();
    }

    public final void u(boolean z) {
        int btnFinalColor;
        View view2;
        if (z) {
            btnFinalColor = this.q;
        } else {
            btnFinalColor = getBtnFinalColor();
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(btnFinalColor);
        gradientDrawable.setCornerRadius(this.p);
        if (C()) {
            view2 = this.c;
        } else {
            view2 = this.d;
        }
        view2.setBackground(gradientDrawable);
        if (C()) {
            this.c.setProgressColor(getResources().getColor(R.color.nad_mini_video_ad_download_progress_color));
        }
    }

    @Override // com.baidu.tieba.d91
    public void update(int i2) {
        List<h71> list = this.h;
        if (list != null && this.i < ny0.l(list)) {
            h71 h71Var = (h71) ny0.d(this.h, this.i);
            if (h71Var != null && i2 * 1000 >= this.j) {
                h71Var.d();
                this.j = (int) (this.j + h71Var.b() + h71Var.a());
                this.i++;
                return;
            }
            return;
        }
        b91 b91Var = this.l;
        if (b91Var != null) {
            b91Var.d();
        }
    }

    public final void x(@NonNull bn0 bn0Var) {
        if (bn0Var.c <= 0) {
            return;
        }
        u(true);
        NadButtonLottieView nadButtonLottieView = this.o;
        if (nadButtonLottieView != null) {
            nadButtonLottieView.cancelAnimation();
        }
        ValueAnimator duration = ValueAnimator.ofFloat(1.0f).setDuration(bn0Var.c);
        duration.addUpdateListener(new d());
        ny0.b(this.h, new e(bn0Var.b, bn0Var.c, duration));
    }

    public final void F() {
        View view2 = this.k;
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            layoutParams.height = this.a;
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = v;
            }
        }
    }

    @Override // com.baidu.tieba.d91
    public void a() {
        List<h71> list = this.h;
        if (list != null) {
            for (h71 h71Var : list) {
                h71Var.c();
            }
        }
        this.i = 0;
        this.j = 0;
    }

    public int getBtnFinalColor() {
        if ((getTag() instanceof xm0) && !TextUtils.isEmpty(((xm0) getTag()).r)) {
            return ce0.f(((xm0) getTag()).r, R.color.nad_enhancement_btn_bg_color);
        }
        return this.r;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.d91
    public View getRealView() {
        if (!(getTag() instanceof xm0)) {
            return this.d;
        }
        if (((xm0) getTag()).a != 2) {
            return this.d;
        }
        return this.c;
    }

    public void v() {
        setBtnHeight(u);
    }

    @Override // com.baidu.tieba.d91
    public void setData(@NonNull xm0 xm0Var) {
        if (!xm0Var.b()) {
            setVisibility(8);
            return;
        }
        setTag(xm0Var);
        setVisibility(0);
        t(xm0Var.s);
        NadButtonLottieView nadButtonLottieView = new NadButtonLottieView(getContext(), xm0Var.v);
        this.o = nadButtonLottieView;
        nadButtonLottieView.setXRradius(s);
        this.o.setYRradius(s);
        this.o.setLayoutParams(this.c.getLayoutParams());
        if (this.n) {
            this.o.setY(w);
        } else {
            this.o.setY(0.0f);
        }
        addView(this.o);
        if (!z(xm0Var)) {
            y(xm0Var);
        }
        A();
        u(false);
        s(xm0Var);
        E(xm0Var);
    }

    public final void w(@NonNull bn0 bn0Var) {
        F();
        if (bn0Var.c <= 0) {
            return;
        }
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(bn0Var.c);
        ViewGroup.LayoutParams layoutParams = this.k.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = this.m.getLayoutParams();
        if (this.k != null && (layoutParams instanceof ViewGroup.MarginLayoutParams) && (layoutParams2 instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
            float y2 = this.m.getY();
            marginLayoutParams.height = 0;
            marginLayoutParams.topMargin = 0;
            this.k.requestLayout();
            if (this.n) {
                marginLayoutParams2.height = 0;
                marginLayoutParams2.topMargin = 0;
                marginLayoutParams2.bottomMargin = 0;
                this.m.requestLayout();
                this.m.setVisibility(0);
            } else {
                this.m.setVisibility(8);
            }
            duration.addUpdateListener(new b(marginLayoutParams, marginLayoutParams2, y2));
        }
        View realView = getRealView();
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.nad_max_pop_view_fade_in);
        loadAnimation.setDuration(bn0Var.c);
        realView.setVisibility(8);
        NadButtonLottieView nadButtonLottieView = this.o;
        if (nadButtonLottieView != null) {
            nadButtonLottieView.setVisibility(8);
        }
        realView.setAnimation(loadAnimation);
        ny0.b(this.h, new c(bn0Var.b, bn0Var.c, duration, loadAnimation, realView));
    }

    public final void y(@NonNull xm0 xm0Var) {
        if (!TextUtils.isEmpty(xm0Var.c)) {
            this.f.u(xm0Var.c);
        } else {
            this.f.setImageDrawable(getContext().getResources().getDrawable(R.drawable.nad_ebtn_icon));
        }
        if (!TextUtils.isEmpty(xm0Var.b)) {
            this.e.setText(xm0Var.b);
        } else {
            this.e.setText(getResources().getText(R.string.nad_command_btn_text));
        }
        this.e.setTextColor(ce0.f("", R.color.nad_white));
        this.d.setOnClickListener(new h(xm0Var));
        this.c.setVisibility(8);
        if (xm0Var.f) {
            this.f.setVisibility(8);
        } else {
            this.f.setVisibility(0);
        }
        if (xm0Var.g) {
            this.e.setText(R.string.nad_button_open);
            if (xm0Var.q != null) {
                dz0.e(new ClogBuilder().j("openbtn").y(ClogBuilder.LogType.FREE_SHOW).u(ClogBuilder.Page.WELFAREMAXLP).p(xm0Var.q.d));
            }
        }
    }

    public final boolean z(@NonNull xm0 xm0Var) {
        if (C() && xm0Var.p != null && xm0Var.q != null) {
            this.c.setIconArrowSwitch(xm0Var.f);
            xm0Var.a = 2;
            if (xm0Var.d) {
                wg0 d2 = wg0.d(xm0Var.p, xm0Var.q.d, xm0Var.t);
                d2.q.a = ClogBuilder.Page.WELFAREMAXLP.type;
                ae0 ae0Var = new ae0(d2, this.c);
                this.g = ae0Var;
                ae0Var.z();
            } else {
                this.g = new jh0(wg0.d(xm0Var.p, xm0Var.q.d, xm0Var.t), this.c);
            }
            this.c.setCornerRadius(this.p);
            this.c.setTextSize(12.0f);
            NadEnhanceButtonDownloadView nadEnhanceButtonDownloadView = this.c;
            int i2 = t;
            nadEnhanceButtonDownloadView.setImageViewLayout(new FrameLayout.LayoutParams(i2, i2));
            this.d.setVisibility(8);
            this.c.setVisibility(0);
            this.c.setOnClickListener(new g(xm0Var));
            if (!TextUtils.isEmpty(xm0Var.c)) {
                this.c.setStateImageIcon(xm0Var.c);
                return true;
            }
            this.c.setStateImageRes(R.drawable.nad_ebtn_icon);
            return true;
        }
        if (this.g != null) {
            this.g = null;
        }
        this.c.setVisibility(8);
        return false;
    }
}
