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
import com.baidu.nadcore.widget.uiwidget.SimpleAdInfoView;
import com.baidu.tieba.R;
import com.baidu.tieba.az0;
import com.baidu.tieba.be0;
import com.baidu.tieba.df0;
import com.baidu.tieba.e71;
import com.baidu.tieba.gd0;
import com.baidu.tieba.gf0;
import com.baidu.tieba.ih0;
import com.baidu.tieba.in0;
import com.baidu.tieba.ky0;
import com.baidu.tieba.nn0;
import com.baidu.tieba.p11;
import com.baidu.tieba.si0;
import com.baidu.tieba.t11;
import com.baidu.tieba.tc0;
import com.baidu.tieba.ue0;
import com.baidu.tieba.vg0;
import com.baidu.tieba.w81;
import com.baidu.tieba.wi0;
import com.baidu.tieba.wm0;
import com.baidu.tieba.y81;
import com.baidu.tieba.zd0;
import com.baidu.tieba.zm0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class AdEnhanceButtonView extends FrameLayout implements y81<View> {
    public static final int r;
    public static final int s;
    public static final int t;
    public static final int u;
    public static final int v;
    public static final int w;
    public int a;
    public int b;
    public NadEnhanceButtonDownloadView c;
    public LinearLayout d;
    public TextView e;
    public AdImageView f;
    public ih0 g;
    public List<e71> h;
    public int i;
    public int j;
    public View k;
    public w81 l;
    public SimpleAdInfoView m;
    public boolean n;
    public int o;
    public int p;
    public int q;

    public int getLayoutId() {
        return R.layout.nad_enhance_button_view;
    }

    @Override // com.baidu.tieba.y81
    public void setBtnIconNightModeEnable(boolean z) {
    }

    /* loaded from: classes3.dex */
    public class a extends e71 {
        @Override // com.baidu.tieba.e71
        public void c() {
        }

        public a(long j, long j2) {
            super(j, j2);
        }

        @Override // com.baidu.tieba.e71
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
                this.a.topMargin = Math.round(AdEnhanceButtonView.u * animatedFraction);
                AdEnhanceButtonView.this.k.requestLayout();
                this.b.height = Math.round(AdEnhanceButtonView.this.b * animatedFraction);
                this.b.topMargin = Math.round(AdEnhanceButtonView.w * animatedFraction);
                this.b.bottomMargin = Math.round(AdEnhanceButtonView.v * animatedFraction);
                AdEnhanceButtonView.this.m.setY(this.c + Math.round(AdEnhanceButtonView.this.a * (1.0f - animatedFraction)) + Math.round(AdEnhanceButtonView.w * animatedFraction));
                AdEnhanceButtonView.this.m.setAlpha(animatedFraction);
                AdEnhanceButtonView.this.m.requestLayout();
                return;
            }
            this.a.height = Math.round(AdEnhanceButtonView.this.a * animatedFraction);
            this.a.topMargin = Math.round(AdEnhanceButtonView.t * animatedFraction);
            AdEnhanceButtonView.this.k.requestLayout();
        }
    }

    /* loaded from: classes3.dex */
    public class c extends e71 {
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

        @Override // com.baidu.tieba.e71
        public void c() {
            this.c.cancel();
            this.d.cancel();
            AdEnhanceButtonView.this.E();
        }

        @Override // com.baidu.tieba.e71
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
            View view2 = AdEnhanceButtonView.this.B() ? AdEnhanceButtonView.this.c : AdEnhanceButtonView.this.d;
            if (view2.getBackground() instanceof GradientDrawable) {
                GradientDrawable gradientDrawable = (GradientDrawable) view2.getBackground();
                gradientDrawable.setColor(be0.d(animatedFraction, AdEnhanceButtonView.this.p, AdEnhanceButtonView.this.getBtnFinalColor()));
                gradientDrawable.setCornerRadius(AdEnhanceButtonView.this.o);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e extends e71 {
        public final /* synthetic */ ValueAnimator c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(long j, long j2, ValueAnimator valueAnimator) {
            super(j, j2);
            this.c = valueAnimator;
        }

        @Override // com.baidu.tieba.e71
        public void c() {
            this.c.cancel();
        }

        @Override // com.baidu.tieba.e71
        public void d() {
            if (this.c.isRunning()) {
                return;
            }
            if (AdEnhanceButtonView.this.l != null) {
                AdEnhanceButtonView.this.l.c();
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
        public final /* synthetic */ wm0 a;

        public g(wm0 wm0Var) {
            this.a = wm0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            AdEnhanceButtonView.this.g.m();
            be0.b(this.a.h);
        }
    }

    /* loaded from: classes3.dex */
    public class h implements View.OnClickListener {
        public final /* synthetic */ wm0 a;

        public h(wm0 wm0Var) {
            this.a = wm0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (AdEnhanceButtonView.this.l != null) {
                in0 in0Var = new in0();
                in0Var.c = true;
                wm0 wm0Var = this.a;
                String str = wm0Var.t;
                in0Var.a = str;
                if (wm0Var.a == 0 && AdEnhanceButtonView.this.p(str).booleanValue()) {
                    in0Var.a = "";
                }
                AdEnhanceButtonView.this.l.b(in0Var);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i extends wi0<gd0> {
        public final /* synthetic */ wm0 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(Class cls, wm0 wm0Var) {
            super(cls);
            this.b = wm0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wi0
        public void onEvent(@NonNull gd0 gd0Var) {
            GradientDrawable gradientDrawable;
            if ("4".equals(gd0Var.a)) {
                if (gd0Var.h) {
                    AdEnhanceButtonView.this.x(this.b);
                    return;
                }
                if (gd0Var.f != null) {
                    AdEnhanceButtonView.this.f.r(gd0Var.f);
                }
                if (gd0Var.g != null) {
                    AdEnhanceButtonView.this.e.setText(gd0Var.g);
                }
                if (gd0Var.d != null && gd0Var.e != null && (gradientDrawable = (GradientDrawable) AdEnhanceButtonView.this.d.getBackground()) != null) {
                    gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
                    gradientDrawable.setColors(new int[]{p11.a(gd0Var.d, R.color.nad_reward_full_tail_btn_color), p11.a(gd0Var.e, R.color.nad_reward_full_tail_btn_color)});
                    AdEnhanceButtonView.this.d.setBackground(gradientDrawable);
                }
                az0.e(new ClogBuilder().y(ClogBuilder.LogType.REWARD_SHOW_TASK).u(ClogBuilder.Page.WELFARETAIL).p(gd0Var.i).k("4").l(gd0Var.c));
            }
        }
    }

    static {
        t11.c.a(gf0.b(), 8.0f);
        r = t11.c.a(gf0.b(), 12.0f);
        s = t11.c.a(gf0.b(), 33.0f);
        t = t11.c.a(gf0.b(), 9.0f);
        u = t11.c.a(gf0.b(), 28.0f);
        v = t11.c.a(gf0.b(), 11.0f);
        w = t11.c.a(gf0.b(), 7.0f);
    }

    public final void z() {
        ViewGroup.LayoutParams layoutParams = this.k.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = this.m.getLayoutParams();
        View view2 = this.k;
        if (view2 != null && (layoutParams instanceof ViewGroup.MarginLayoutParams) && (layoutParams2 instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
            if (this.n) {
                marginLayoutParams.height = this.a;
                marginLayoutParams.topMargin = u;
                view2.requestLayout();
                marginLayoutParams2.height = this.b;
                marginLayoutParams2.topMargin = w;
                marginLayoutParams2.bottomMargin = v;
                this.m.setAlpha(1.0f);
                this.m.requestLayout();
                return;
            }
            marginLayoutParams.height = this.a;
            marginLayoutParams.topMargin = t;
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
        this.o = t11.c.a(gf0.b(), 17.0f);
        this.p = getResources().getColor(R.color.nad_enhancement_btn_first_bg_color);
        this.q = getResources().getColor(R.color.nad_enhancement_btn_bg_color);
        q(context);
        C(attributeSet);
    }

    public AdEnhanceButtonView(@NonNull Context context, @NonNull ViewGroup viewGroup, @NonNull View view2) {
        this(context, null);
        setContainer(viewGroup);
        setBtnPlaceholder(view2);
    }

    public final void A(@NonNull zm0 zm0Var) {
        int i2 = zm0Var.a;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 == 2) {
                    w(zm0Var);
                    return;
                }
                return;
            }
            v(zm0Var);
            return;
        }
        ky0.b(this.h, new a(zm0Var.b, zm0Var.c));
    }

    public final void D(@NonNull wm0 wm0Var) {
        si0.a().c(this, new i(gd0.class, wm0Var));
    }

    public Boolean p(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return Boolean.FALSE;
        }
        if (!df0.o(str)) {
            return Boolean.FALSE;
        }
        return Boolean.valueOf("rewardWebPanel".equals(new ue0(str).a()));
    }

    public final void r(@NonNull wm0 wm0Var) {
        List<zm0> list = wm0Var.o;
        if (list != null && list.size() > 0) {
            this.h = new ArrayList();
            for (zm0 zm0Var : list) {
                if (zm0Var != null) {
                    A(zm0Var);
                }
            }
        }
    }

    public void setBtnCornerRadius(int i2) {
        this.o = i2;
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
    @Override // com.baidu.tieba.y81
    public void setBtnPlaceholder(View view2) {
        this.k = view2;
        E();
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

    public void setContainer(@NonNull ViewGroup viewGroup) {
        View view2 = (View) getParent();
        if (view2 instanceof ViewGroup) {
            ((ViewGroup) view2).removeView(this);
        }
        viewGroup.addView(this);
    }

    @Override // com.baidu.tieba.y81
    public void setData(@NonNull wm0 wm0Var) {
        if (!wm0Var.b()) {
            setVisibility(8);
            return;
        }
        setTag(wm0Var);
        setVisibility(0);
        s(wm0Var.s);
        if (!y(wm0Var)) {
            x(wm0Var);
        }
        z();
        t(false);
        r(wm0Var);
        D(wm0Var);
    }

    @Override // com.baidu.tieba.y81
    public void setEnhanceBtnListener(@NonNull w81 w81Var) {
        this.l = w81Var;
    }

    @Override // com.baidu.tieba.y81
    public void setVisible(int i2) {
        setVisibility(i2);
    }

    public boolean B() {
        wm0 wm0Var;
        if (!(getTag() instanceof wm0) || (wm0Var = (wm0) getTag()) == null) {
            return false;
        }
        if (!wm0Var.e && !wm0Var.u) {
            if (wm0Var.s == null || wm0Var.p == null || wm0Var.a != 2) {
                return false;
            }
            return true;
        } else if (wm0Var.p == null || wm0Var.a != 2) {
            return false;
        } else {
            return true;
        }
    }

    public final void C(AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, tc0.NadEnhanceButtonView);
        this.o = obtainStyledAttributes.getDimensionPixelSize(2, t11.c.a(gf0.b(), 8.0f));
        this.p = obtainStyledAttributes.getColor(1, getResources().getColor(R.color.nad_enhancement_btn_first_bg_color));
        this.q = obtainStyledAttributes.getColor(0, getResources().getColor(R.color.nad_enhancement_btn_bg_color));
        obtainStyledAttributes.recycle();
    }

    public final void q(Context context) {
        LayoutInflater.from(context).inflate(getLayoutId(), this);
        this.c = (NadEnhanceButtonDownloadView) findViewById(R.id.ad_video_download_btn);
        this.d = (LinearLayout) findViewById(R.id.common_btn);
        this.e = (TextView) findViewById(R.id.common_btn_text);
        this.f = (AdImageView) findViewById(R.id.common_btn_icon);
        this.m = (SimpleAdInfoView) findViewById(R.id.app_info_container);
        u();
    }

    public final void s(@Nullable nn0 nn0Var) {
        if (!be0.a(nn0Var)) {
            this.n = false;
            this.m.setVisibility(8);
            return;
        }
        this.n = true;
        this.m.setVisibility(0);
        this.m.setAdInfo(nn0Var);
        this.m.setAfterListener(new f());
        this.b = this.m.getHeight();
        this.m.measure(-2, -2);
        this.b = this.m.getMeasuredHeight();
    }

    public final void t(boolean z) {
        int btnFinalColor;
        View view2;
        if (z) {
            btnFinalColor = this.p;
        } else {
            btnFinalColor = getBtnFinalColor();
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(btnFinalColor);
        gradientDrawable.setCornerRadius(this.o);
        if (B()) {
            view2 = this.c;
        } else {
            view2 = this.d;
        }
        view2.setBackground(gradientDrawable);
        if (B()) {
            this.c.setProgressColor(getResources().getColor(R.color.nad_mini_video_ad_download_progress_color));
        }
    }

    @Override // com.baidu.tieba.y81
    public void update(int i2) {
        List<e71> list = this.h;
        if (list != null && this.i < ky0.l(list)) {
            e71 e71Var = (e71) ky0.d(this.h, this.i);
            if (e71Var != null && i2 * 1000 >= this.j) {
                e71Var.d();
                this.j = (int) (this.j + e71Var.b() + e71Var.a());
                this.i++;
                return;
            }
            return;
        }
        w81 w81Var = this.l;
        if (w81Var != null) {
            w81Var.d();
        }
    }

    public final void w(@NonNull zm0 zm0Var) {
        if (zm0Var.c <= 0) {
            return;
        }
        t(true);
        ValueAnimator duration = ValueAnimator.ofFloat(1.0f).setDuration(zm0Var.c);
        duration.addUpdateListener(new d());
        ky0.b(this.h, new e(zm0Var.b, zm0Var.c, duration));
    }

    public final void E() {
        View view2 = this.k;
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            layoutParams.height = this.a;
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = t;
            }
        }
    }

    @Override // com.baidu.tieba.y81
    public void a() {
        List<e71> list = this.h;
        if (list != null) {
            for (e71 e71Var : list) {
                e71Var.c();
            }
        }
        this.i = 0;
        this.j = 0;
    }

    public int getBtnFinalColor() {
        if ((getTag() instanceof wm0) && !TextUtils.isEmpty(((wm0) getTag()).r)) {
            return be0.f(((wm0) getTag()).r, R.color.nad_enhancement_btn_bg_color);
        }
        return this.q;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.y81
    public View getRealView() {
        if (!(getTag() instanceof wm0)) {
            return this.d;
        }
        if (((wm0) getTag()).a != 2) {
            return this.d;
        }
        return this.c;
    }

    public void u() {
        setBtnHeight(s);
    }

    public final void v(@NonNull zm0 zm0Var) {
        E();
        if (zm0Var.c <= 0) {
            return;
        }
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(zm0Var.c);
        ViewGroup.LayoutParams layoutParams = this.k.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = this.m.getLayoutParams();
        if (this.k != null && (layoutParams instanceof ViewGroup.MarginLayoutParams) && (layoutParams2 instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
            float y = this.m.getY();
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
            duration.addUpdateListener(new b(marginLayoutParams, marginLayoutParams2, y));
        }
        View realView = getRealView();
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.nad_max_pop_view_fade_in);
        loadAnimation.setDuration(zm0Var.c);
        realView.setVisibility(8);
        realView.setAnimation(loadAnimation);
        ky0.b(this.h, new c(zm0Var.b, zm0Var.c, duration, loadAnimation, realView));
    }

    public final void x(@NonNull wm0 wm0Var) {
        if (!TextUtils.isEmpty(wm0Var.c)) {
            this.f.r(wm0Var.c);
        } else {
            this.f.setImageDrawable(getContext().getResources().getDrawable(R.drawable.nad_ebtn_icon));
        }
        if (!TextUtils.isEmpty(wm0Var.b)) {
            this.e.setText(wm0Var.b);
        } else {
            this.e.setText(getResources().getText(R.string.nad_command_btn_text));
        }
        this.e.setTextColor(be0.f("", R.color.nad_white));
        this.d.setOnClickListener(new h(wm0Var));
        this.c.setVisibility(8);
        if (wm0Var.f) {
            this.f.setVisibility(8);
        } else {
            this.f.setVisibility(0);
        }
        if (wm0Var.g) {
            this.e.setText(R.string.nad_button_open);
            if (wm0Var.q != null) {
                az0.e(new ClogBuilder().j("openbtn").y(ClogBuilder.LogType.FREE_SHOW).u(ClogBuilder.Page.WELFAREMAXLP).p(wm0Var.q.d));
            }
        }
    }

    public final boolean y(@NonNull wm0 wm0Var) {
        if (B() && wm0Var.p != null && wm0Var.q != null) {
            this.c.setIconArrowSwitch(wm0Var.f);
            wm0Var.a = 2;
            if (wm0Var.d) {
                vg0 d2 = vg0.d(wm0Var.p, wm0Var.q.d, wm0Var.t);
                d2.q.a = ClogBuilder.Page.WELFAREMAXLP.type;
                zd0 zd0Var = new zd0(d2, this.c);
                this.g = zd0Var;
                zd0Var.z();
            } else {
                this.g = new ih0(vg0.d(wm0Var.p, wm0Var.q.d, wm0Var.t), this.c);
            }
            this.c.setCornerRadius(this.o);
            this.c.setTextSize(12.0f);
            NadEnhanceButtonDownloadView nadEnhanceButtonDownloadView = this.c;
            int i2 = r;
            nadEnhanceButtonDownloadView.setImageViewLayout(new FrameLayout.LayoutParams(i2, i2));
            this.d.setVisibility(8);
            this.c.setVisibility(0);
            this.c.setOnClickListener(new g(wm0Var));
            if (!TextUtils.isEmpty(wm0Var.c)) {
                this.c.setStateImageIcon(wm0Var.c);
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
