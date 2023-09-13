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
import com.baidu.tieba.as0;
import com.baidu.tieba.bc1;
import com.baidu.tieba.fn0;
import com.baidu.tieba.gh0;
import com.baidu.tieba.h31;
import com.baidu.tieba.hj0;
import com.baidu.tieba.il0;
import com.baidu.tieba.jn0;
import com.baidu.tieba.jr0;
import com.baidu.tieba.m61;
import com.baidu.tieba.mi0;
import com.baidu.tieba.mr0;
import com.baidu.tieba.oi0;
import com.baidu.tieba.q61;
import com.baidu.tieba.qj0;
import com.baidu.tieba.th0;
import com.baidu.tieba.tj0;
import com.baidu.tieba.vl0;
import com.baidu.tieba.vr0;
import com.baidu.tieba.wd1;
import com.baidu.tieba.x31;
import com.baidu.tieba.yd1;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class AdEnhanceButtonView extends FrameLayout implements yd1<View> {
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
    public vl0 g;
    public List<bc1> h;
    public int i;
    public int j;
    public View k;
    public wd1 l;
    public SimpleAdInfoView m;
    public boolean n;
    public int o;
    public int p;
    public int q;

    public int getLayoutId() {
        return R.layout.nad_enhance_button_view;
    }

    @Override // com.baidu.tieba.yd1
    public void setBtnIconNightModeEnable(boolean z) {
    }

    /* loaded from: classes3.dex */
    public class a extends bc1 {
        @Override // com.baidu.tieba.bc1
        public void c() {
        }

        public a(long j, long j2) {
            super(j, j2);
        }

        @Override // com.baidu.tieba.bc1
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
    public class c extends bc1 {
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

        @Override // com.baidu.tieba.bc1
        public void c() {
            this.c.cancel();
            this.d.cancel();
            AdEnhanceButtonView.this.E();
        }

        @Override // com.baidu.tieba.bc1
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
                gradientDrawable.setColor(oi0.d(animatedFraction, AdEnhanceButtonView.this.p, AdEnhanceButtonView.this.getBtnFinalColor()));
                gradientDrawable.setCornerRadius(AdEnhanceButtonView.this.o);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e extends bc1 {
        public final /* synthetic */ ValueAnimator c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(long j, long j2, ValueAnimator valueAnimator) {
            super(j, j2);
            this.c = valueAnimator;
        }

        @Override // com.baidu.tieba.bc1
        public void c() {
            this.c.cancel();
        }

        @Override // com.baidu.tieba.bc1
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
        public final /* synthetic */ jr0 a;

        public g(jr0 jr0Var) {
            this.a = jr0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            AdEnhanceButtonView.this.g.l();
            oi0.b(this.a.h);
        }
    }

    /* loaded from: classes3.dex */
    public class h implements View.OnClickListener {
        public final /* synthetic */ jr0 a;

        public h(jr0 jr0Var) {
            this.a = jr0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (AdEnhanceButtonView.this.l != null) {
                vr0 vr0Var = new vr0();
                vr0Var.c = true;
                jr0 jr0Var = this.a;
                String str = jr0Var.t;
                vr0Var.a = str;
                if (jr0Var.a == 0 && AdEnhanceButtonView.this.p(str).booleanValue()) {
                    vr0Var.a = "";
                }
                AdEnhanceButtonView.this.l.b(vr0Var);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i extends jn0<th0> {
        public final /* synthetic */ jr0 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(Class cls, jr0 jr0Var) {
            super(cls);
            this.b = jr0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jn0
        public void onEvent(@NonNull th0 th0Var) {
            GradientDrawable gradientDrawable;
            if ("4".equals(th0Var.a)) {
                if (th0Var.h) {
                    AdEnhanceButtonView.this.x(this.b);
                    return;
                }
                if (th0Var.f != null) {
                    AdEnhanceButtonView.this.f.r(th0Var.f);
                }
                if (th0Var.g != null) {
                    AdEnhanceButtonView.this.e.setText(th0Var.g);
                }
                if (th0Var.d != null && th0Var.e != null && (gradientDrawable = (GradientDrawable) AdEnhanceButtonView.this.d.getBackground()) != null) {
                    gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
                    gradientDrawable.setColors(new int[]{m61.a(th0Var.d, R.color.nad_reward_full_tail_btn_color), m61.a(th0Var.e, R.color.nad_reward_full_tail_btn_color)});
                    AdEnhanceButtonView.this.d.setBackground(gradientDrawable);
                }
                x31.e(new ClogBuilder().y(ClogBuilder.LogType.REWARD_SHOW_TASK).u(ClogBuilder.Page.WELFARETAIL).p(th0Var.i).k("4").l(th0Var.c));
            }
        }
    }

    static {
        q61.c.a(tj0.b(), 8.0f);
        r = q61.c.a(tj0.b(), 12.0f);
        s = q61.c.a(tj0.b(), 33.0f);
        t = q61.c.a(tj0.b(), 9.0f);
        u = q61.c.a(tj0.b(), 28.0f);
        v = q61.c.a(tj0.b(), 11.0f);
        w = q61.c.a(tj0.b(), 7.0f);
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
        this.o = q61.c.a(tj0.b(), 17.0f);
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

    public final void A(@NonNull mr0 mr0Var) {
        int i2 = mr0Var.a;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 == 2) {
                    w(mr0Var);
                    return;
                }
                return;
            }
            v(mr0Var);
            return;
        }
        h31.b(this.h, new a(mr0Var.b, mr0Var.c));
    }

    public final void D(@NonNull jr0 jr0Var) {
        fn0.a().b(this, new i(th0.class, jr0Var));
    }

    public Boolean p(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return Boolean.FALSE;
        }
        if (!qj0.o(str)) {
            return Boolean.FALSE;
        }
        return Boolean.valueOf("rewardWebPanel".equals(new hj0(str).a()));
    }

    public final void r(@NonNull jr0 jr0Var) {
        List<mr0> list = jr0Var.o;
        if (list != null && list.size() > 0) {
            this.h = new ArrayList();
            for (mr0 mr0Var : list) {
                if (mr0Var != null) {
                    A(mr0Var);
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
    @Override // com.baidu.tieba.yd1
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

    @Override // com.baidu.tieba.yd1
    public void setData(@NonNull jr0 jr0Var) {
        if (!jr0Var.b()) {
            setVisibility(8);
            return;
        }
        setTag(jr0Var);
        setVisibility(0);
        s(jr0Var.s);
        if (!y(jr0Var)) {
            x(jr0Var);
        }
        z();
        t(false);
        r(jr0Var);
        D(jr0Var);
    }

    @Override // com.baidu.tieba.yd1
    public void setEnhanceBtnListener(@NonNull wd1 wd1Var) {
        this.l = wd1Var;
    }

    @Override // com.baidu.tieba.yd1
    public void setVisible(int i2) {
        setVisibility(i2);
    }

    public boolean B() {
        jr0 jr0Var;
        if (!(getTag() instanceof jr0) || (jr0Var = (jr0) getTag()) == null) {
            return false;
        }
        if (!jr0Var.e && !jr0Var.u) {
            if (jr0Var.s == null || jr0Var.p == null || jr0Var.a != 2) {
                return false;
            }
            return true;
        } else if (jr0Var.p == null || jr0Var.a != 2) {
            return false;
        } else {
            return true;
        }
    }

    public final void C(AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, gh0.NadEnhanceButtonView);
        this.o = obtainStyledAttributes.getDimensionPixelSize(2, q61.c.a(tj0.b(), 8.0f));
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

    public final void s(@Nullable as0 as0Var) {
        if (!oi0.a(as0Var)) {
            this.n = false;
            this.m.setVisibility(8);
            return;
        }
        this.n = true;
        this.m.setVisibility(0);
        this.m.setAdInfo(as0Var);
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

    @Override // com.baidu.tieba.yd1
    public void update(int i2) {
        List<bc1> list = this.h;
        if (list != null && this.i < h31.l(list)) {
            bc1 bc1Var = (bc1) h31.d(this.h, this.i);
            if (bc1Var != null && i2 * 1000 >= this.j) {
                bc1Var.d();
                this.j = (int) (this.j + bc1Var.b() + bc1Var.a());
                this.i++;
                return;
            }
            return;
        }
        wd1 wd1Var = this.l;
        if (wd1Var != null) {
            wd1Var.d();
        }
    }

    public final void w(@NonNull mr0 mr0Var) {
        if (mr0Var.c <= 0) {
            return;
        }
        t(true);
        ValueAnimator duration = ValueAnimator.ofFloat(1.0f).setDuration(mr0Var.c);
        duration.addUpdateListener(new d());
        h31.b(this.h, new e(mr0Var.b, mr0Var.c, duration));
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

    @Override // com.baidu.tieba.yd1
    public void a() {
        List<bc1> list = this.h;
        if (list != null) {
            for (bc1 bc1Var : list) {
                bc1Var.c();
            }
        }
        this.i = 0;
        this.j = 0;
    }

    public int getBtnFinalColor() {
        if ((getTag() instanceof jr0) && !TextUtils.isEmpty(((jr0) getTag()).r)) {
            return oi0.f(((jr0) getTag()).r, R.color.nad_enhancement_btn_bg_color);
        }
        return this.q;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.yd1
    public View getRealView() {
        if (!(getTag() instanceof jr0)) {
            return this.d;
        }
        if (((jr0) getTag()).a != 2) {
            return this.d;
        }
        return this.c;
    }

    public void u() {
        setBtnHeight(s);
    }

    public final void v(@NonNull mr0 mr0Var) {
        E();
        if (mr0Var.c <= 0) {
            return;
        }
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(mr0Var.c);
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
        loadAnimation.setDuration(mr0Var.c);
        realView.setVisibility(8);
        realView.setAnimation(loadAnimation);
        h31.b(this.h, new c(mr0Var.b, mr0Var.c, duration, loadAnimation, realView));
    }

    public final void x(@NonNull jr0 jr0Var) {
        if (!TextUtils.isEmpty(jr0Var.c)) {
            this.f.r(jr0Var.c);
        } else {
            this.f.setImageDrawable(getContext().getResources().getDrawable(R.drawable.nad_ebtn_icon));
        }
        if (!TextUtils.isEmpty(jr0Var.b)) {
            this.e.setText(jr0Var.b);
        } else {
            this.e.setText(getResources().getText(R.string.nad_command_btn_text));
        }
        this.e.setTextColor(oi0.f("", R.color.nad_white));
        this.d.setOnClickListener(new h(jr0Var));
        this.c.setVisibility(8);
        if (jr0Var.f) {
            this.f.setVisibility(8);
        } else {
            this.f.setVisibility(0);
        }
        if (jr0Var.g) {
            this.e.setText(R.string.nad_button_open);
            if (jr0Var.q != null) {
                x31.e(new ClogBuilder().j("openbtn").y(ClogBuilder.LogType.FREE_SHOW).u(ClogBuilder.Page.WELFAREMAXLP).p(jr0Var.q.d));
            }
        }
    }

    public final boolean y(@NonNull jr0 jr0Var) {
        if (B() && jr0Var.p != null && jr0Var.q != null) {
            this.c.setIconArrowSwitch(jr0Var.f);
            jr0Var.a = 2;
            if (jr0Var.d) {
                il0 d2 = il0.d(jr0Var.p, jr0Var.q.d, jr0Var.t);
                d2.q.a = ClogBuilder.Page.WELFAREMAXLP.type;
                mi0 mi0Var = new mi0(d2, this.c);
                this.g = mi0Var;
                mi0Var.z();
            } else {
                this.g = new vl0(il0.d(jr0Var.p, jr0Var.q.d, jr0Var.t), this.c);
            }
            this.c.setCornerRadius(this.o);
            this.c.setTextSize(12.0f);
            NadEnhanceButtonDownloadView nadEnhanceButtonDownloadView = this.c;
            int i2 = r;
            nadEnhanceButtonDownloadView.setImageViewLayout(new FrameLayout.LayoutParams(i2, i2));
            this.d.setVisibility(8);
            this.c.setVisibility(0);
            this.c.setOnClickListener(new g(jr0Var));
            if (!TextUtils.isEmpty(jr0Var.c)) {
                this.c.setStateImageIcon(jr0Var.c);
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
