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
import com.baidu.tieba.bi0;
import com.baidu.tieba.c11;
import com.baidu.tieba.cc0;
import com.baidu.tieba.de0;
import com.baidu.tieba.eg0;
import com.baidu.tieba.f81;
import com.baidu.tieba.fi0;
import com.baidu.tieba.fm0;
import com.baidu.tieba.h81;
import com.baidu.tieba.id0;
import com.baidu.tieba.im0;
import com.baidu.tieba.jy0;
import com.baidu.tieba.kd0;
import com.baidu.tieba.me0;
import com.baidu.tieba.n61;
import com.baidu.tieba.pc0;
import com.baidu.tieba.pe0;
import com.baidu.tieba.rg0;
import com.baidu.tieba.rm0;
import com.baidu.tieba.tx0;
import com.baidu.tieba.wm0;
import com.baidu.tieba.y01;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class AdEnhanceButtonView extends FrameLayout implements h81<View> {
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
    public rg0 g;
    public List<n61> h;
    public int i;
    public int j;
    public View k;
    public f81 l;
    public SimpleAdInfoView m;
    public boolean n;
    public int o;
    public int p;
    public int q;

    public int getLayoutId() {
        return R.layout.nad_enhance_button_view;
    }

    @Override // com.baidu.tieba.h81
    public void setBtnIconNightModeEnable(boolean z) {
    }

    /* loaded from: classes3.dex */
    public class a extends n61 {
        @Override // com.baidu.tieba.n61
        public void c() {
        }

        public a(long j, long j2) {
            super(j, j2);
        }

        @Override // com.baidu.tieba.n61
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
    public class c extends n61 {
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

        @Override // com.baidu.tieba.n61
        public void c() {
            this.c.cancel();
            this.d.cancel();
            AdEnhanceButtonView.this.E();
        }

        @Override // com.baidu.tieba.n61
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
                gradientDrawable.setColor(kd0.d(animatedFraction, AdEnhanceButtonView.this.p, AdEnhanceButtonView.this.getBtnFinalColor()));
                gradientDrawable.setCornerRadius(AdEnhanceButtonView.this.o);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e extends n61 {
        public final /* synthetic */ ValueAnimator c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(long j, long j2, ValueAnimator valueAnimator) {
            super(j, j2);
            this.c = valueAnimator;
        }

        @Override // com.baidu.tieba.n61
        public void c() {
            this.c.cancel();
        }

        @Override // com.baidu.tieba.n61
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
        public final /* synthetic */ fm0 a;

        public g(fm0 fm0Var) {
            this.a = fm0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            AdEnhanceButtonView.this.g.l();
            kd0.b(this.a.h);
        }
    }

    /* loaded from: classes3.dex */
    public class h implements View.OnClickListener {
        public final /* synthetic */ fm0 a;

        public h(fm0 fm0Var) {
            this.a = fm0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (AdEnhanceButtonView.this.l != null) {
                rm0 rm0Var = new rm0();
                rm0Var.c = true;
                fm0 fm0Var = this.a;
                String str = fm0Var.t;
                rm0Var.a = str;
                if (fm0Var.a == 0 && AdEnhanceButtonView.this.p(str).booleanValue()) {
                    rm0Var.a = "";
                }
                AdEnhanceButtonView.this.l.b(rm0Var);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i extends fi0<pc0> {
        public final /* synthetic */ fm0 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(Class cls, fm0 fm0Var) {
            super(cls);
            this.b = fm0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fi0
        public void onEvent(@NonNull pc0 pc0Var) {
            GradientDrawable gradientDrawable;
            if ("4".equals(pc0Var.a)) {
                if (pc0Var.h) {
                    AdEnhanceButtonView.this.x(this.b);
                    return;
                }
                if (pc0Var.f != null) {
                    AdEnhanceButtonView.this.f.s(pc0Var.f);
                }
                if (pc0Var.g != null) {
                    AdEnhanceButtonView.this.e.setText(pc0Var.g);
                }
                if (pc0Var.d != null && pc0Var.e != null && (gradientDrawable = (GradientDrawable) AdEnhanceButtonView.this.d.getBackground()) != null) {
                    gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
                    gradientDrawable.setColors(new int[]{y01.a(pc0Var.d, R.color.nad_reward_full_tail_btn_color), y01.a(pc0Var.e, R.color.nad_reward_full_tail_btn_color)});
                    AdEnhanceButtonView.this.d.setBackground(gradientDrawable);
                }
                jy0.e(new ClogBuilder().y(ClogBuilder.LogType.REWARD_SHOW_TASK).u(ClogBuilder.Page.WELFARETAIL).p(pc0Var.i).k("4").l(pc0Var.c));
            }
        }
    }

    static {
        c11.c.a(pe0.b(), 8.0f);
        r = c11.c.a(pe0.b(), 12.0f);
        s = c11.c.a(pe0.b(), 33.0f);
        t = c11.c.a(pe0.b(), 9.0f);
        u = c11.c.a(pe0.b(), 28.0f);
        v = c11.c.a(pe0.b(), 11.0f);
        w = c11.c.a(pe0.b(), 7.0f);
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
        this.o = c11.c.a(pe0.b(), 17.0f);
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

    public final void A(@NonNull im0 im0Var) {
        int i2 = im0Var.a;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 == 2) {
                    w(im0Var);
                    return;
                }
                return;
            }
            v(im0Var);
            return;
        }
        tx0.b(this.h, new a(im0Var.b, im0Var.c));
    }

    public final void D(@NonNull fm0 fm0Var) {
        bi0.a().c(this, new i(pc0.class, fm0Var));
    }

    public Boolean p(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return Boolean.FALSE;
        }
        if (!me0.o(str)) {
            return Boolean.FALSE;
        }
        return Boolean.valueOf("rewardWebPanel".equals(new de0(str).a()));
    }

    public final void r(@NonNull fm0 fm0Var) {
        List<im0> list = fm0Var.o;
        if (list != null && list.size() > 0) {
            this.h = new ArrayList();
            for (im0 im0Var : list) {
                if (im0Var != null) {
                    A(im0Var);
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
    @Override // com.baidu.tieba.h81
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

    @Override // com.baidu.tieba.h81
    public void setData(@NonNull fm0 fm0Var) {
        if (!fm0Var.b()) {
            setVisibility(8);
            return;
        }
        setTag(fm0Var);
        setVisibility(0);
        s(fm0Var.s);
        if (!y(fm0Var)) {
            x(fm0Var);
        }
        z();
        t(false);
        r(fm0Var);
        D(fm0Var);
    }

    @Override // com.baidu.tieba.h81
    public void setEnhanceBtnListener(@NonNull f81 f81Var) {
        this.l = f81Var;
    }

    @Override // com.baidu.tieba.h81
    public void setVisible(int i2) {
        setVisibility(i2);
    }

    public boolean B() {
        fm0 fm0Var;
        if (!(getTag() instanceof fm0) || (fm0Var = (fm0) getTag()) == null) {
            return false;
        }
        if (!fm0Var.e && !fm0Var.u) {
            if (fm0Var.s == null || fm0Var.p == null || fm0Var.a != 2) {
                return false;
            }
            return true;
        } else if (fm0Var.p == null || fm0Var.a != 2) {
            return false;
        } else {
            return true;
        }
    }

    public final void C(AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, cc0.NadEnhanceButtonView);
        this.o = obtainStyledAttributes.getDimensionPixelSize(2, c11.c.a(pe0.b(), 8.0f));
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

    public final void s(@Nullable wm0 wm0Var) {
        if (!kd0.a(wm0Var)) {
            this.n = false;
            this.m.setVisibility(8);
            return;
        }
        this.n = true;
        this.m.setVisibility(0);
        this.m.setAdInfo(wm0Var);
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

    @Override // com.baidu.tieba.h81
    public void update(int i2) {
        List<n61> list = this.h;
        if (list != null && this.i < tx0.l(list)) {
            n61 n61Var = (n61) tx0.d(this.h, this.i);
            if (n61Var != null && i2 * 1000 >= this.j) {
                n61Var.d();
                this.j = (int) (this.j + n61Var.b() + n61Var.a());
                this.i++;
                return;
            }
            return;
        }
        f81 f81Var = this.l;
        if (f81Var != null) {
            f81Var.d();
        }
    }

    public final void w(@NonNull im0 im0Var) {
        if (im0Var.c <= 0) {
            return;
        }
        t(true);
        ValueAnimator duration = ValueAnimator.ofFloat(1.0f).setDuration(im0Var.c);
        duration.addUpdateListener(new d());
        tx0.b(this.h, new e(im0Var.b, im0Var.c, duration));
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

    @Override // com.baidu.tieba.h81
    public void a() {
        List<n61> list = this.h;
        if (list != null) {
            for (n61 n61Var : list) {
                n61Var.c();
            }
        }
        this.i = 0;
        this.j = 0;
    }

    public int getBtnFinalColor() {
        if ((getTag() instanceof fm0) && !TextUtils.isEmpty(((fm0) getTag()).r)) {
            return kd0.f(((fm0) getTag()).r, R.color.nad_enhancement_btn_bg_color);
        }
        return this.q;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.h81
    public View getRealView() {
        if (!(getTag() instanceof fm0)) {
            return this.d;
        }
        if (((fm0) getTag()).a != 2) {
            return this.d;
        }
        return this.c;
    }

    public void u() {
        setBtnHeight(s);
    }

    public final void v(@NonNull im0 im0Var) {
        E();
        if (im0Var.c <= 0) {
            return;
        }
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(im0Var.c);
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
        loadAnimation.setDuration(im0Var.c);
        realView.setVisibility(8);
        realView.setAnimation(loadAnimation);
        tx0.b(this.h, new c(im0Var.b, im0Var.c, duration, loadAnimation, realView));
    }

    public final void x(@NonNull fm0 fm0Var) {
        if (!TextUtils.isEmpty(fm0Var.c)) {
            this.f.s(fm0Var.c);
        } else {
            this.f.setImageDrawable(getContext().getResources().getDrawable(R.drawable.nad_ebtn_icon));
        }
        if (!TextUtils.isEmpty(fm0Var.b)) {
            this.e.setText(fm0Var.b);
        } else {
            this.e.setText(getResources().getText(R.string.nad_command_btn_text));
        }
        this.e.setTextColor(kd0.f("", R.color.nad_white));
        this.d.setOnClickListener(new h(fm0Var));
        this.c.setVisibility(8);
        if (fm0Var.f) {
            this.f.setVisibility(8);
        } else {
            this.f.setVisibility(0);
        }
        if (fm0Var.g) {
            this.e.setText(R.string.nad_button_open);
            if (fm0Var.q != null) {
                jy0.e(new ClogBuilder().j("openbtn").y(ClogBuilder.LogType.FREE_SHOW).u(ClogBuilder.Page.WELFAREMAXLP).p(fm0Var.q.d));
            }
        }
    }

    public final boolean y(@NonNull fm0 fm0Var) {
        if (B() && fm0Var.p != null && fm0Var.q != null) {
            this.c.setIconArrowSwitch(fm0Var.f);
            fm0Var.a = 2;
            if (fm0Var.d) {
                eg0 d2 = eg0.d(fm0Var.p, fm0Var.q.d, fm0Var.t);
                d2.q.a = ClogBuilder.Page.WELFAREMAXLP.type;
                id0 id0Var = new id0(d2, this.c);
                this.g = id0Var;
                id0Var.y();
            } else {
                this.g = new rg0(eg0.d(fm0Var.p, fm0Var.q.d, fm0Var.t), this.c);
            }
            this.c.setCornerRadius(this.o);
            this.c.setTextSize(12.0f);
            NadEnhanceButtonDownloadView nadEnhanceButtonDownloadView = this.c;
            int i2 = r;
            nadEnhanceButtonDownloadView.setImageViewLayout(new FrameLayout.LayoutParams(i2, i2));
            this.d.setVisibility(8);
            this.c.setVisibility(0);
            this.c.setOnClickListener(new g(fm0Var));
            if (!TextUtils.isEmpty(fm0Var.c)) {
                this.c.setStateImageIcon(fm0Var.c);
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
