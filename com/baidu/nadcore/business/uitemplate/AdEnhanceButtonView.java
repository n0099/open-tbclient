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
import com.baidu.tieba.bs0;
import com.baidu.tieba.c61;
import com.baidu.tieba.fj0;
import com.baidu.tieba.hj0;
import com.baidu.tieba.hk0;
import com.baidu.tieba.kk0;
import com.baidu.tieba.mi0;
import com.baidu.tieba.mm0;
import com.baidu.tieba.mr0;
import com.baidu.tieba.n31;
import com.baidu.tieba.oe1;
import com.baidu.tieba.pn0;
import com.baidu.tieba.pr0;
import com.baidu.tieba.qe1;
import com.baidu.tieba.tc1;
import com.baidu.tieba.tn0;
import com.baidu.tieba.wr0;
import com.baidu.tieba.x21;
import com.baidu.tieba.y51;
import com.baidu.tieba.yj0;
import com.baidu.tieba.zh0;
import com.baidu.tieba.zl0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class AdEnhanceButtonView extends FrameLayout implements qe1<View> {
    public static final int q;
    public static final int r;
    public static final int s;
    public static final int t;
    public static final int u;
    public static final int v;
    public int a;
    public NadEnhanceButtonDownloadView b;
    public LinearLayout c;
    public TextView d;
    public AdImageView e;
    public mm0 f;
    public List<tc1> g;
    public int h;
    public int i;
    public View j;
    public oe1 k;
    public SimpleAdInfoView l;
    public boolean m;
    public int n;
    public int o;
    public int p;

    @Override // com.baidu.tieba.qe1
    public void setBtnIconNightModeEnable(boolean z) {
    }

    /* loaded from: classes3.dex */
    public class a extends tc1 {
        @Override // com.baidu.tieba.tc1
        public void c() {
        }

        public a(long j, long j2) {
            super(j, j2);
        }

        @Override // com.baidu.tieba.tc1
        public void d() {
            if (AdEnhanceButtonView.this.k != null) {
                AdEnhanceButtonView.this.k.e();
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
            if (AdEnhanceButtonView.this.m) {
                this.a.height = Math.round(AdEnhanceButtonView.r * animatedFraction);
                this.a.topMargin = Math.round(AdEnhanceButtonView.t * animatedFraction);
                AdEnhanceButtonView.this.j.requestLayout();
                this.b.height = Math.round(AdEnhanceButtonView.this.a * animatedFraction);
                this.b.topMargin = Math.round(AdEnhanceButtonView.v * animatedFraction);
                this.b.bottomMargin = Math.round(AdEnhanceButtonView.u * animatedFraction);
                AdEnhanceButtonView.this.l.setY(this.c + Math.round(AdEnhanceButtonView.r * (1.0f - animatedFraction)) + Math.round(AdEnhanceButtonView.v * animatedFraction));
                AdEnhanceButtonView.this.l.setAlpha(animatedFraction);
                AdEnhanceButtonView.this.l.requestLayout();
                return;
            }
            this.a.height = Math.round(AdEnhanceButtonView.r * animatedFraction);
            this.a.topMargin = Math.round(AdEnhanceButtonView.s * animatedFraction);
            AdEnhanceButtonView.this.j.requestLayout();
        }
    }

    /* loaded from: classes3.dex */
    public class c extends tc1 {
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

        @Override // com.baidu.tieba.tc1
        public void c() {
            this.c.cancel();
            this.d.cancel();
            AdEnhanceButtonView.this.E();
        }

        @Override // com.baidu.tieba.tc1
        public void d() {
            if (this.c.isRunning()) {
                return;
            }
            if (AdEnhanceButtonView.this.k != null) {
                AdEnhanceButtonView.this.k.f();
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
            View view2 = AdEnhanceButtonView.this.B() ? AdEnhanceButtonView.this.b : AdEnhanceButtonView.this.c;
            if (view2.getBackground() instanceof GradientDrawable) {
                GradientDrawable gradientDrawable = (GradientDrawable) view2.getBackground();
                gradientDrawable.setColor(hj0.d(animatedFraction, AdEnhanceButtonView.this.o, AdEnhanceButtonView.this.getBtnFinalColor()));
                gradientDrawable.setCornerRadius(AdEnhanceButtonView.this.n);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e extends tc1 {
        public final /* synthetic */ ValueAnimator c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(long j, long j2, ValueAnimator valueAnimator) {
            super(j, j2);
            this.c = valueAnimator;
        }

        @Override // com.baidu.tieba.tc1
        public void c() {
            this.c.cancel();
        }

        @Override // com.baidu.tieba.tc1
        public void d() {
            if (this.c.isRunning()) {
                return;
            }
            if (AdEnhanceButtonView.this.k != null) {
                AdEnhanceButtonView.this.k.c();
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
            if (AdEnhanceButtonView.this.k != null) {
                AdEnhanceButtonView.this.k.a(str);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements View.OnClickListener {
        public final /* synthetic */ mr0 a;

        public g(mr0 mr0Var) {
            this.a = mr0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            AdEnhanceButtonView.this.f.m();
            hj0.b(this.a.h);
        }
    }

    /* loaded from: classes3.dex */
    public class h implements View.OnClickListener {
        public final /* synthetic */ mr0 a;

        public h(mr0 mr0Var) {
            this.a = mr0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (AdEnhanceButtonView.this.k != null) {
                wr0 wr0Var = new wr0();
                wr0Var.c = true;
                mr0 mr0Var = this.a;
                String str = mr0Var.t;
                wr0Var.a = str;
                if (mr0Var.a == 0 && AdEnhanceButtonView.this.q(str).booleanValue()) {
                    wr0Var.a = "";
                }
                AdEnhanceButtonView.this.k.b(wr0Var);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i extends tn0<mi0> {
        public final /* synthetic */ mr0 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(Class cls, mr0 mr0Var) {
            super(cls);
            this.b = mr0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.tn0
        public void onEvent(@NonNull mi0 mi0Var) {
            GradientDrawable gradientDrawable;
            if ("4".equals(mi0Var.a)) {
                if (mi0Var.h) {
                    AdEnhanceButtonView.this.x(this.b);
                    return;
                }
                if (mi0Var.f != null) {
                    AdEnhanceButtonView.this.e.o(mi0Var.f);
                }
                if (mi0Var.g != null) {
                    AdEnhanceButtonView.this.d.setText(mi0Var.g);
                }
                if (mi0Var.d != null && mi0Var.e != null && (gradientDrawable = (GradientDrawable) AdEnhanceButtonView.this.c.getBackground()) != null) {
                    gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
                    gradientDrawable.setColors(new int[]{y51.a(mi0Var.d, R.color.nad_reward_full_tail_btn_color), y51.a(mi0Var.e, R.color.nad_reward_full_tail_btn_color)});
                    AdEnhanceButtonView.this.c.setBackground(gradientDrawable);
                }
                n31.b(new ClogBuilder().y(ClogBuilder.LogType.REWARD_SHOW_TASK).u(ClogBuilder.Page.WELFARETAIL).p(mi0Var.i).k("4").l(mi0Var.c));
            }
        }
    }

    static {
        c61.c.a(kk0.b(), 8.0f);
        q = c61.c.a(kk0.b(), 12.0f);
        r = c61.c.a(kk0.b(), 33.0f);
        s = c61.c.a(kk0.b(), 9.0f);
        t = c61.c.a(kk0.b(), 28.0f);
        u = c61.c.a(kk0.b(), 11.0f);
        v = c61.c.a(kk0.b(), 7.0f);
    }

    public final void z() {
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

    public AdEnhanceButtonView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdEnhanceButtonView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.h = 0;
        this.i = 0;
        this.k = null;
        this.m = false;
        this.n = c61.c.a(kk0.b(), 17.0f);
        this.o = getResources().getColor(R.color.nad_enhancement_btn_first_bg_color);
        this.p = getResources().getColor(R.color.nad_enhancement_btn_bg_color);
        r(context);
        C(attributeSet);
    }

    public AdEnhanceButtonView(@NonNull Context context, @NonNull ViewGroup viewGroup, @NonNull View view2) {
        this(context, null);
        setContainer(viewGroup);
        setBtnPlaceholder(view2);
    }

    public final void A(@NonNull pr0 pr0Var) {
        int i2 = pr0Var.a;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 == 2) {
                    w(pr0Var);
                    return;
                }
                return;
            }
            v(pr0Var);
            return;
        }
        x21.b(this.g, new a(pr0Var.b, pr0Var.c));
    }

    public final void D(@NonNull mr0 mr0Var) {
        pn0.a().b(this, new i(mi0.class, mr0Var));
    }

    public Boolean q(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return Boolean.FALSE;
        }
        if (!hk0.o(str)) {
            return Boolean.FALSE;
        }
        return Boolean.valueOf("rewardWebPanel".equals(new yj0(str).a()));
    }

    public final void s(@NonNull mr0 mr0Var) {
        List<pr0> list = mr0Var.o;
        if (list != null && list.size() > 0) {
            this.g = new ArrayList();
            for (pr0 pr0Var : list) {
                if (pr0Var != null) {
                    A(pr0Var);
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qe1
    public void setBtnPlaceholder(View view2) {
        this.j = view2;
        E();
    }

    public void setContainer(@NonNull ViewGroup viewGroup) {
        View view2 = (View) getParent();
        if (view2 instanceof ViewGroup) {
            ((ViewGroup) view2).removeView(this);
        }
        viewGroup.addView(this);
    }

    @Override // com.baidu.tieba.qe1
    public void setData(@NonNull mr0 mr0Var) {
        if (!mr0Var.b()) {
            setVisibility(8);
            return;
        }
        setTag(mr0Var);
        setVisibility(0);
        t(mr0Var.s);
        if (!y(mr0Var)) {
            x(mr0Var);
        }
        z();
        u(false);
        s(mr0Var);
        D(mr0Var);
    }

    @Override // com.baidu.tieba.qe1
    public void setEnhanceBtnListener(@NonNull oe1 oe1Var) {
        this.k = oe1Var;
    }

    @Override // com.baidu.tieba.qe1
    public void setVisible(int i2) {
        setVisibility(i2);
    }

    public final boolean B() {
        mr0 mr0Var;
        if (!(getTag() instanceof mr0) || (mr0Var = (mr0) getTag()) == null) {
            return false;
        }
        if (mr0Var.e) {
            if (mr0Var.p == null || mr0Var.a != 2) {
                return false;
            }
            return true;
        } else if (mr0Var.s == null || mr0Var.p == null || mr0Var.a != 2) {
            return false;
        } else {
            return true;
        }
    }

    public final void E() {
        View view2 = this.j;
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            layoutParams.height = r;
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = s;
            }
        }
    }

    @Override // com.baidu.tieba.qe1
    public void a() {
        List<tc1> list = this.g;
        if (list != null) {
            for (tc1 tc1Var : list) {
                tc1Var.c();
            }
        }
        this.h = 0;
        this.i = 0;
    }

    public int getBtnFinalColor() {
        if ((getTag() instanceof mr0) && !TextUtils.isEmpty(((mr0) getTag()).r)) {
            return hj0.f(((mr0) getTag()).r, R.color.nad_enhancement_btn_bg_color);
        }
        return this.p;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.qe1
    public View getRealView() {
        if (!(getTag() instanceof mr0)) {
            return this.c;
        }
        if (((mr0) getTag()).a != 2) {
            return this.c;
        }
        return this.b;
    }

    public final void C(AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, zh0.NadEnhanceButtonView);
        this.n = obtainStyledAttributes.getDimensionPixelSize(2, c61.c.a(kk0.b(), 8.0f));
        this.o = obtainStyledAttributes.getColor(1, getResources().getColor(R.color.nad_enhancement_btn_first_bg_color));
        this.p = obtainStyledAttributes.getColor(0, getResources().getColor(R.color.nad_enhancement_btn_bg_color));
        obtainStyledAttributes.recycle();
    }

    public final void r(Context context) {
        LayoutInflater.from(context).inflate(R.layout.nad_enhance_button_view, this);
        this.b = (NadEnhanceButtonDownloadView) findViewById(R.id.ad_video_download_btn);
        this.c = (LinearLayout) findViewById(R.id.common_btn);
        this.d = (TextView) findViewById(R.id.common_btn_text);
        this.e = (AdImageView) findViewById(R.id.common_btn_icon);
        this.l = (SimpleAdInfoView) findViewById(R.id.app_info_container);
    }

    public final void t(@Nullable bs0 bs0Var) {
        if (!hj0.a(bs0Var)) {
            this.m = false;
            this.l.setVisibility(8);
            return;
        }
        this.m = true;
        this.l.setVisibility(0);
        this.l.setAdInfo(bs0Var);
        this.l.setAfterListener(new f());
        this.a = this.l.getHeight();
        this.l.measure(-2, -2);
        this.a = this.l.getMeasuredHeight();
    }

    public final void u(boolean z) {
        int btnFinalColor;
        View view2;
        if (z) {
            btnFinalColor = this.o;
        } else {
            btnFinalColor = getBtnFinalColor();
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(btnFinalColor);
        gradientDrawable.setCornerRadius(this.n);
        if (B()) {
            view2 = this.b;
        } else {
            view2 = this.c;
        }
        view2.setBackground(gradientDrawable);
        if (B()) {
            this.b.setProgressColor(getResources().getColor(R.color.nad_mini_video_ad_download_progress_color));
        }
    }

    @Override // com.baidu.tieba.qe1
    public void update(int i2) {
        List<tc1> list = this.g;
        if (list != null && this.h < x21.l(list)) {
            tc1 tc1Var = (tc1) x21.d(this.g, this.h);
            if (tc1Var != null && i2 * 1000 >= this.i) {
                tc1Var.d();
                this.i = (int) (this.i + tc1Var.b() + tc1Var.a());
                this.h++;
                return;
            }
            return;
        }
        oe1 oe1Var = this.k;
        if (oe1Var != null) {
            oe1Var.d();
        }
    }

    public final void w(@NonNull pr0 pr0Var) {
        if (pr0Var.c <= 0) {
            return;
        }
        u(true);
        ValueAnimator duration = ValueAnimator.ofFloat(1.0f).setDuration(pr0Var.c);
        duration.addUpdateListener(new d());
        x21.b(this.g, new e(pr0Var.b, pr0Var.c, duration));
    }

    public final void v(@NonNull pr0 pr0Var) {
        E();
        if (pr0Var.c <= 0) {
            return;
        }
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(pr0Var.c);
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
            duration.addUpdateListener(new b(marginLayoutParams, marginLayoutParams2, y));
        }
        View realView = getRealView();
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.nad_max_pop_view_fade_in);
        loadAnimation.setDuration(pr0Var.c);
        realView.setVisibility(8);
        realView.setAnimation(loadAnimation);
        x21.b(this.g, new c(pr0Var.b, pr0Var.c, duration, loadAnimation, realView));
    }

    public final void x(@NonNull mr0 mr0Var) {
        if (!TextUtils.isEmpty(mr0Var.c)) {
            this.e.o(mr0Var.c);
        } else {
            this.e.setImageDrawable(getContext().getResources().getDrawable(R.drawable.nad_ebtn_icon));
        }
        if (!TextUtils.isEmpty(mr0Var.b)) {
            this.d.setText(mr0Var.b);
        } else {
            this.d.setText(getResources().getText(R.string.nad_command_btn_text));
        }
        this.d.setTextColor(hj0.f("", R.color.nad_white));
        this.c.setOnClickListener(new h(mr0Var));
        this.b.setVisibility(8);
        if (mr0Var.f) {
            this.e.setVisibility(8);
        } else {
            this.e.setVisibility(0);
        }
        if (mr0Var.g) {
            this.d.setText(R.string.nad_button_open);
            if (mr0Var.q != null) {
                n31.b(new ClogBuilder().j("openbtn").y(ClogBuilder.LogType.FREE_SHOW).u(ClogBuilder.Page.WELFAREMAXLP).p(mr0Var.q.d));
            }
        }
    }

    public final boolean y(@NonNull mr0 mr0Var) {
        if (B() && mr0Var.p != null && mr0Var.q != null) {
            this.b.setIconArrowSwitch(mr0Var.f);
            mr0Var.a = 2;
            if (mr0Var.d) {
                zl0 d2 = zl0.d(mr0Var.p, mr0Var.q.d, mr0Var.t);
                d2.q.a = ClogBuilder.Page.WELFAREMAXLP.type;
                fj0 fj0Var = new fj0(d2, this.b);
                this.f = fj0Var;
                fj0Var.A();
            } else {
                this.f = new mm0(zl0.d(mr0Var.p, mr0Var.q.d, mr0Var.t), this.b);
            }
            this.b.setCornerRadius(this.n);
            this.b.setTextSize(12.0f);
            NadEnhanceButtonDownloadView nadEnhanceButtonDownloadView = this.b;
            int i2 = q;
            nadEnhanceButtonDownloadView.setImageViewLayout(new FrameLayout.LayoutParams(i2, i2));
            this.c.setVisibility(8);
            this.b.setVisibility(0);
            this.b.setOnClickListener(new g(mr0Var));
            if (!TextUtils.isEmpty(mr0Var.c)) {
                this.b.setStateImageIcon(mr0Var.c);
                return true;
            }
            this.b.setStateImageRes(R.drawable.nad_ebtn_icon);
            return true;
        }
        if (this.f != null) {
            this.f = null;
        }
        this.b.setVisibility(8);
        return false;
    }
}
