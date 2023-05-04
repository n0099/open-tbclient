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
import com.baidu.tieba.ag0;
import com.baidu.tieba.ak0;
import com.baidu.tieba.cq0;
import com.baidu.tieba.d41;
import com.baidu.tieba.gh0;
import com.baidu.tieba.ih0;
import com.baidu.tieba.ii0;
import com.baidu.tieba.li0;
import com.baidu.tieba.ng0;
import com.baidu.tieba.nk0;
import com.baidu.tieba.np0;
import com.baidu.tieba.o11;
import com.baidu.tieba.pc1;
import com.baidu.tieba.ql0;
import com.baidu.tieba.qp0;
import com.baidu.tieba.rc1;
import com.baidu.tieba.ua1;
import com.baidu.tieba.ul0;
import com.baidu.tieba.xp0;
import com.baidu.tieba.y01;
import com.baidu.tieba.z31;
import com.baidu.tieba.zh0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class AdEnhanceButtonView extends FrameLayout implements rc1<View> {
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
    public nk0 f;
    public List<ua1> g;
    public int h;
    public int i;
    public View j;
    public pc1 k;
    public SimpleAdInfoView l;
    public boolean m;
    public int n;
    public int o;
    public int p;

    @Override // com.baidu.tieba.rc1
    public void setBtnIconNightModeEnable(boolean z) {
    }

    /* loaded from: classes2.dex */
    public class a extends ua1 {
        @Override // com.baidu.tieba.ua1
        public void c() {
        }

        public a(long j, long j2) {
            super(j, j2);
        }

        @Override // com.baidu.tieba.ua1
        public void d() {
            if (AdEnhanceButtonView.this.k != null) {
                AdEnhanceButtonView.this.k.e();
            }
        }
    }

    /* loaded from: classes2.dex */
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

    /* loaded from: classes2.dex */
    public class c extends ua1 {
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

        @Override // com.baidu.tieba.ua1
        public void c() {
            this.c.cancel();
            this.d.cancel();
            AdEnhanceButtonView.this.E();
        }

        @Override // com.baidu.tieba.ua1
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

    /* loaded from: classes2.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        public d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float animatedFraction = valueAnimator.getAnimatedFraction();
            View view2 = AdEnhanceButtonView.this.B() ? AdEnhanceButtonView.this.b : AdEnhanceButtonView.this.c;
            if (view2.getBackground() instanceof GradientDrawable) {
                GradientDrawable gradientDrawable = (GradientDrawable) view2.getBackground();
                gradientDrawable.setColor(ih0.d(animatedFraction, AdEnhanceButtonView.this.o, AdEnhanceButtonView.this.getBtnFinalColor()));
                gradientDrawable.setCornerRadius(AdEnhanceButtonView.this.n);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e extends ua1 {
        public final /* synthetic */ ValueAnimator c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(long j, long j2, ValueAnimator valueAnimator) {
            super(j, j2);
            this.c = valueAnimator;
        }

        @Override // com.baidu.tieba.ua1
        public void c() {
            this.c.cancel();
        }

        @Override // com.baidu.tieba.ua1
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

    /* loaded from: classes2.dex */
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

    /* loaded from: classes2.dex */
    public class g implements View.OnClickListener {
        public final /* synthetic */ np0 a;

        public g(np0 np0Var) {
            this.a = np0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            AdEnhanceButtonView.this.f.m();
            ih0.b(this.a.h);
        }
    }

    /* loaded from: classes2.dex */
    public class h implements View.OnClickListener {
        public final /* synthetic */ np0 a;

        public h(np0 np0Var) {
            this.a = np0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (AdEnhanceButtonView.this.k != null) {
                xp0 xp0Var = new xp0();
                xp0Var.c = true;
                np0 np0Var = this.a;
                String str = np0Var.t;
                xp0Var.a = str;
                if (np0Var.a == 0 && AdEnhanceButtonView.this.q(str).booleanValue()) {
                    xp0Var.a = "";
                }
                AdEnhanceButtonView.this.k.b(xp0Var);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class i extends ul0<ng0> {
        public final /* synthetic */ np0 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(Class cls, np0 np0Var) {
            super(cls);
            this.b = np0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ul0
        public void onEvent(@NonNull ng0 ng0Var) {
            GradientDrawable gradientDrawable;
            if ("4".equals(ng0Var.a)) {
                if (ng0Var.h) {
                    AdEnhanceButtonView.this.x(this.b);
                    return;
                }
                if (ng0Var.f != null) {
                    AdEnhanceButtonView.this.e.o(ng0Var.f);
                }
                if (ng0Var.g != null) {
                    AdEnhanceButtonView.this.d.setText(ng0Var.g);
                }
                if (ng0Var.d != null && ng0Var.e != null && (gradientDrawable = (GradientDrawable) AdEnhanceButtonView.this.c.getBackground()) != null) {
                    gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
                    gradientDrawable.setColors(new int[]{z31.a(ng0Var.d, R.color.nad_reward_full_tail_btn_color), z31.a(ng0Var.e, R.color.nad_reward_full_tail_btn_color)});
                    AdEnhanceButtonView.this.c.setBackground(gradientDrawable);
                }
                o11.b(new ClogBuilder().y(ClogBuilder.LogType.REWARD_SHOW_TASK).u(ClogBuilder.Page.WELFARETAIL).p(ng0Var.i).k("4").l(ng0Var.c));
            }
        }
    }

    static {
        d41.c.a(li0.b(), 8.0f);
        q = d41.c.a(li0.b(), 12.0f);
        r = d41.c.a(li0.b(), 33.0f);
        s = d41.c.a(li0.b(), 9.0f);
        t = d41.c.a(li0.b(), 28.0f);
        u = d41.c.a(li0.b(), 11.0f);
        v = d41.c.a(li0.b(), 7.0f);
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
        this.n = d41.c.a(li0.b(), 17.0f);
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

    public final void A(@NonNull qp0 qp0Var) {
        int i2 = qp0Var.a;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 == 2) {
                    w(qp0Var);
                    return;
                }
                return;
            }
            v(qp0Var);
            return;
        }
        y01.b(this.g, new a(qp0Var.b, qp0Var.c));
    }

    public final void D(@NonNull np0 np0Var) {
        ql0.a().b(this, new i(ng0.class, np0Var));
    }

    public Boolean q(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return Boolean.FALSE;
        }
        if (!ii0.o(str)) {
            return Boolean.FALSE;
        }
        return Boolean.valueOf("rewardWebPanel".equals(new zh0(str).a()));
    }

    public final void s(@NonNull np0 np0Var) {
        List<qp0> list = np0Var.o;
        if (list != null && list.size() > 0) {
            this.g = new ArrayList();
            for (qp0 qp0Var : list) {
                if (qp0Var != null) {
                    A(qp0Var);
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.rc1
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

    @Override // com.baidu.tieba.rc1
    public void setData(@NonNull np0 np0Var) {
        if (!np0Var.b()) {
            setVisibility(8);
            return;
        }
        setTag(np0Var);
        setVisibility(0);
        t(np0Var.s);
        if (!y(np0Var)) {
            x(np0Var);
        }
        z();
        u(false);
        s(np0Var);
        D(np0Var);
    }

    @Override // com.baidu.tieba.rc1
    public void setEnhanceBtnListener(@NonNull pc1 pc1Var) {
        this.k = pc1Var;
    }

    @Override // com.baidu.tieba.rc1
    public void setVisible(int i2) {
        setVisibility(i2);
    }

    public final boolean B() {
        np0 np0Var;
        if (!(getTag() instanceof np0) || (np0Var = (np0) getTag()) == null) {
            return false;
        }
        if (np0Var.e) {
            if (np0Var.p == null || np0Var.a != 2) {
                return false;
            }
            return true;
        } else if (np0Var.s == null || np0Var.p == null || np0Var.a != 2) {
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

    @Override // com.baidu.tieba.rc1
    public void a() {
        List<ua1> list = this.g;
        if (list != null) {
            for (ua1 ua1Var : list) {
                ua1Var.c();
            }
        }
        this.h = 0;
        this.i = 0;
    }

    public int getBtnFinalColor() {
        if ((getTag() instanceof np0) && !TextUtils.isEmpty(((np0) getTag()).r)) {
            return ih0.f(((np0) getTag()).r, R.color.nad_enhancement_btn_bg_color);
        }
        return this.p;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.rc1
    public View getRealView() {
        if (!(getTag() instanceof np0)) {
            return this.c;
        }
        if (((np0) getTag()).a != 2) {
            return this.c;
        }
        return this.b;
    }

    public final void C(AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, ag0.NadEnhanceButtonView);
        this.n = obtainStyledAttributes.getDimensionPixelSize(2, d41.c.a(li0.b(), 8.0f));
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

    public final void t(@Nullable cq0 cq0Var) {
        if (!ih0.a(cq0Var)) {
            this.m = false;
            this.l.setVisibility(8);
            return;
        }
        this.m = true;
        this.l.setVisibility(0);
        this.l.setAdInfo(cq0Var);
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

    @Override // com.baidu.tieba.rc1
    public void update(int i2) {
        List<ua1> list = this.g;
        if (list != null && this.h < y01.l(list)) {
            ua1 ua1Var = (ua1) y01.d(this.g, this.h);
            if (ua1Var != null && i2 * 1000 >= this.i) {
                ua1Var.d();
                this.i = (int) (this.i + ua1Var.b() + ua1Var.a());
                this.h++;
                return;
            }
            return;
        }
        pc1 pc1Var = this.k;
        if (pc1Var != null) {
            pc1Var.d();
        }
    }

    public final void w(@NonNull qp0 qp0Var) {
        if (qp0Var.c <= 0) {
            return;
        }
        u(true);
        ValueAnimator duration = ValueAnimator.ofFloat(1.0f).setDuration(qp0Var.c);
        duration.addUpdateListener(new d());
        y01.b(this.g, new e(qp0Var.b, qp0Var.c, duration));
    }

    public final void v(@NonNull qp0 qp0Var) {
        E();
        if (qp0Var.c <= 0) {
            return;
        }
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(qp0Var.c);
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
        loadAnimation.setDuration(qp0Var.c);
        realView.setVisibility(8);
        realView.setAnimation(loadAnimation);
        y01.b(this.g, new c(qp0Var.b, qp0Var.c, duration, loadAnimation, realView));
    }

    public final void x(@NonNull np0 np0Var) {
        if (!TextUtils.isEmpty(np0Var.c)) {
            this.e.o(np0Var.c);
        } else {
            this.e.setImageDrawable(getContext().getResources().getDrawable(R.drawable.nad_ebtn_icon));
        }
        if (!TextUtils.isEmpty(np0Var.b)) {
            this.d.setText(np0Var.b);
        } else {
            this.d.setText(getResources().getText(R.string.nad_command_btn_text));
        }
        this.d.setTextColor(ih0.f("", R.color.nad_white));
        this.c.setOnClickListener(new h(np0Var));
        this.b.setVisibility(8);
        if (np0Var.f) {
            this.e.setVisibility(8);
        } else {
            this.e.setVisibility(0);
        }
        if (np0Var.g) {
            this.d.setText(R.string.nad_button_open);
            if (np0Var.q != null) {
                o11.b(new ClogBuilder().j("openbtn").y(ClogBuilder.LogType.FREE_SHOW).u(ClogBuilder.Page.WELFAREMAXLP).p(np0Var.q.d));
            }
        }
    }

    public final boolean y(@NonNull np0 np0Var) {
        if (B() && np0Var.p != null && np0Var.q != null) {
            this.b.setIconArrowSwitch(np0Var.f);
            np0Var.a = 2;
            if (np0Var.d) {
                ak0 d2 = ak0.d(np0Var.p, np0Var.q.d, np0Var.t);
                d2.q.a = ClogBuilder.Page.WELFAREMAXLP.type;
                gh0 gh0Var = new gh0(d2, this.b);
                this.f = gh0Var;
                gh0Var.A();
            } else {
                this.f = new nk0(ak0.d(np0Var.p, np0Var.q.d, np0Var.t), this.b);
            }
            this.b.setCornerRadius(this.n);
            this.b.setTextSize(12.0f);
            NadEnhanceButtonDownloadView nadEnhanceButtonDownloadView = this.b;
            int i2 = q;
            nadEnhanceButtonDownloadView.setImageViewLayout(new FrameLayout.LayoutParams(i2, i2));
            this.c.setVisibility(8);
            this.b.setVisibility(0);
            this.b.setOnClickListener(new g(np0Var));
            if (!TextUtils.isEmpty(np0Var.c)) {
                this.b.setStateImageIcon(np0Var.c);
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
