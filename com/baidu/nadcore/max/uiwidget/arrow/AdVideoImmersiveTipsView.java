package com.baidu.nadcore.max.uiwidget.arrow;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.Key;
import com.baidu.nadcore.widget.uiwidget.ExpandIconView;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.tieba.R;
import com.baidu.tieba.p21;
import com.baidu.tieba.u11;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 =2\u00020\u0001:\u0001=B'\b\u0007\u0012\u0006\u00107\u001a\u000206\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u000108\u0012\b\b\u0002\u0010:\u001a\u00020\u0002¢\u0006\u0004\b;\u0010<J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000b\u0010\u0006J\u000f\u0010\f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\rJ\u001d\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0012\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0012\u0010\nJ\r\u0010\u0013\u001a\u00020\u0004¢\u0006\u0004\b\u0013\u0010\rJ\u000f\u0010\u0014\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\rJ\u001d\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u0006J\u0015\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0015¢\u0006\u0004\b\u001b\u0010\u001cR$\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0016\u0010$\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R$\u0010&\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010\u001f\u001a\u0004\b'\u0010!\"\u0004\b(\u0010#R\u001c\u0010)\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\f\n\u0004\b)\u0010%\u0012\u0004\b*\u0010\rR\u0018\u0010,\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010.\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010%R$\u00100\u001a\u0004\u0018\u00010/8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105¨\u0006>"}, d2 = {"Lcom/baidu/nadcore/max/uiwidget/arrow/AdVideoImmersiveTipsView;", "Landroid/widget/FrameLayout;", "", "type", "", "cancelArrowAnim", "(I)V", "", "fraction", "changeBottomMargin", "(F)V", "doArrowAnim", "doDefaultAnim", "()V", "doLightPieAnim", "time", "initGuideArrowAnim", "(II)V", "onScroll", "release", "resetAnim", "", MapBundleKey.MapObjKey.OBJ_SL_VISI, "withAnim", "setTipsVisible", "(ZZ)V", "startCountDown", "stopCountDown", "(Z)V", "Lcom/baidu/nadcore/utils/UniversalCountDownTimer;", "animTimer", "Lcom/baidu/nadcore/utils/UniversalCountDownTimer;", "getAnimTimer", "()Lcom/baidu/nadcore/utils/UniversalCountDownTimer;", "setAnimTimer", "(Lcom/baidu/nadcore/utils/UniversalCountDownTimer;)V", "arrowVideoMargin", "I", "countDownTimer", "getCountDownTimer", "setCountDownTimer", "guideAnimType", "getGuideAnimType$annotations", "Landroid/animation/ObjectAnimator;", "guideTipAnimator", "Landroid/animation/ObjectAnimator;", "guideTipTime", "Landroid/view/View$OnClickListener;", "outClickListener", "Landroid/view/View$OnClickListener;", "getOutClickListener", "()Landroid/view/View$OnClickListener;", "setOutClickListener", "(Landroid/view/View$OnClickListener;)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class AdVideoImmersiveTipsView extends FrameLayout {
    public p21 a;
    public p21 b;
    public ObjectAnimator c;
    public int d;
    public View.OnClickListener e;
    public int f;
    public HashMap g;

    @JvmOverloads
    public AdVideoImmersiveTipsView(Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public AdVideoImmersiveTipsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public static /* synthetic */ void getGuideAnimType$annotations() {
    }

    public View a(int i) {
        if (this.g == null) {
            this.g = new HashMap();
        }
        View view2 = (View) this.g.get(Integer.valueOf(i));
        if (view2 == null) {
            View findViewById = findViewById(i);
            this.g.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view2;
    }

    /* loaded from: classes3.dex */
    public static final class c implements Animation.AnimationListener {
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        /* loaded from: classes3.dex */
        public static final class a implements Runnable {
            public a() {
            }

            /* renamed from: com.baidu.nadcore.max.uiwidget.arrow.AdVideoImmersiveTipsView$c$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public static final class C0118a extends AnimatorListenerAdapter {
                /* JADX DEBUG: Incorrect args count in method signature: ()V */
                public C0118a() {
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    ImageView arrowPieImage = (ImageView) AdVideoImmersiveTipsView.this.a(R.id.obfuscated_res_0x7f0902f9);
                    Intrinsics.checkNotNullExpressionValue(arrowPieImage, "arrowPieImage");
                    arrowPieImage.setVisibility(8);
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                ImageView arrowPieImage = (ImageView) AdVideoImmersiveTipsView.this.a(R.id.obfuscated_res_0x7f0902f9);
                Intrinsics.checkNotNullExpressionValue(arrowPieImage, "arrowPieImage");
                if (arrowPieImage.getVisibility() == 0) {
                    ObjectAnimator duration = ObjectAnimator.ofFloat((ImageView) AdVideoImmersiveTipsView.this.a(R.id.obfuscated_res_0x7f0902f9), Key.ALPHA, 1.0f).setDuration(500L);
                    Intrinsics.checkNotNullExpressionValue(duration, "ObjectAnimator.ofFloat(a…on(DEFUALT_ANIM_DURATION)");
                    duration.setFloatValues(1.0f, 0.0f);
                    duration.addListener(new C0118a());
                    duration.start();
                }
                ExpandIconView arrowImage = (ExpandIconView) AdVideoImmersiveTipsView.this.a(R.id.obfuscated_res_0x7f0902f8);
                Intrinsics.checkNotNullExpressionValue(arrowImage, "arrowImage");
                arrowImage.setVisibility(0);
            }
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public c() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            AdVideoImmersiveTipsView.this.postDelayed(new a(), 2000L);
        }
    }

    /* loaded from: classes3.dex */
    public static final class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            View.OnClickListener outClickListener = AdVideoImmersiveTipsView.this.getOutClickListener();
            if (outClickListener != null) {
                outClickListener.onClick((ExpandIconView) AdVideoImmersiveTipsView.this.a(R.id.obfuscated_res_0x7f0902f8));
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class b implements View.OnClickListener {
        public final /* synthetic */ ImageView a;
        public final /* synthetic */ AdVideoImmersiveTipsView b;

        public b(ImageView imageView, AdVideoImmersiveTipsView adVideoImmersiveTipsView) {
            this.a = imageView;
            this.b = adVideoImmersiveTipsView;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            View.OnClickListener outClickListener = this.b.getOutClickListener();
            if (outClickListener != null) {
                outClickListener.onClick(this.a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class d extends p21.b {
        public final /* synthetic */ int b;

        public d(int i) {
            this.b = i;
        }

        @Override // com.baidu.tieba.p21.b
        public void b() {
            AdVideoImmersiveTipsView.this.e(this.b);
            p21 animTimer = AdVideoImmersiveTipsView.this.getAnimTimer();
            if (animTimer != null) {
                animTimer.a();
            }
            AdVideoImmersiveTipsView.this.setAnimTimer(null);
        }
    }

    /* loaded from: classes3.dex */
    public static final class e extends AnimatorListenerAdapter {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public e() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            TextView guideText = (TextView) AdVideoImmersiveTipsView.this.a(R.id.obfuscated_res_0x7f090f3e);
            Intrinsics.checkNotNullExpressionValue(guideText, "guideText");
            guideText.setVisibility(8);
        }
    }

    /* loaded from: classes3.dex */
    public static final class f extends p21.b {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public f() {
        }

        @Override // com.baidu.tieba.p21.b
        public void b() {
            AdVideoImmersiveTipsView.this.setTipsVisible(false, true);
        }

        @Override // com.baidu.tieba.p21.b
        public void e() {
            AdVideoImmersiveTipsView.this.setTipsVisible(true, true);
        }

        @Override // com.baidu.tieba.p21.b
        public void f(long j) {
            TextView guideText = (TextView) AdVideoImmersiveTipsView.this.a(R.id.obfuscated_res_0x7f090f3e);
            Intrinsics.checkNotNullExpressionValue(guideText, "guideText");
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            Context context = AdVideoImmersiveTipsView.this.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            String string = context.getResources().getString(R.string.nad_max_countdown_tips_text);
            Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr…_max_countdown_tips_text)");
            String format = String.format(string, Arrays.copyOf(new Object[]{Long.valueOf(j / 1000)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
            guideText.setText(format);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AdVideoImmersiveTipsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.nad_max_tip_view, this);
        ((ExpandIconView) a(R.id.obfuscated_res_0x7f0902f8)).setOnClickListener(new a());
        ((ExpandIconView) a(R.id.obfuscated_res_0x7f0902f8)).setState(1, true);
    }

    public /* synthetic */ AdVideoImmersiveTipsView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final void c(int i) {
        if (i != 0) {
            if (i == 1) {
                ((ExpandIconView) a(R.id.obfuscated_res_0x7f0902f8)).clearAnimation();
                ((ImageView) a(R.id.obfuscated_res_0x7f0902f9)).clearAnimation();
                return;
            }
            return;
        }
        ((ExpandIconView) a(R.id.obfuscated_res_0x7f0902f8)).clearAnimation();
    }

    public final void e(int i) {
        if (i != 0) {
            if (i == 1) {
                ImageView imageView = (ImageView) a(R.id.obfuscated_res_0x7f0902f9);
                imageView.setOnClickListener(new b(imageView, this));
                g();
                return;
            }
            return;
        }
        f();
    }

    public final void i(float f2) {
        float max = Math.max(Math.min(f2, 1.0f), -1.0f);
        ((ExpandIconView) a(R.id.obfuscated_res_0x7f0902f8)).setFraction(max, false);
        d(max);
    }

    public final void l(int i) {
        if (this.a != null) {
            return;
        }
        p21 p21Var = new p21(i * 1000, 1000L);
        p21Var.d(new f());
        this.a = p21Var;
        if (p21Var != null) {
            p21Var.e();
        }
    }

    public final void m(boolean z) {
        p21 p21Var = this.a;
        if (p21Var != null) {
            p21Var.a();
        }
        TextView guideText = (TextView) a(R.id.obfuscated_res_0x7f090f3e);
        Intrinsics.checkNotNullExpressionValue(guideText, "guideText");
        if (guideText.getVisibility() == 0) {
            setTipsVisible(false, z);
        }
    }

    public final void setAnimTimer(p21 p21Var) {
        this.b = p21Var;
    }

    public final void setCountDownTimer(p21 p21Var) {
        this.a = p21Var;
    }

    public final void setOutClickListener(View.OnClickListener onClickListener) {
        this.e = onClickListener;
    }

    public final void d(float f2) {
        if (Math.abs(f2) < 0.6f) {
            return;
        }
        float abs = (Math.abs(f2) - 0.6f) / 0.39999998f;
        int a2 = u11.c.a(getContext(), -4.0f);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (!(layoutParams instanceof FrameLayout.LayoutParams)) {
            layoutParams = null;
        }
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        if (layoutParams2 != null) {
            layoutParams2.bottomMargin = a2 + ((int) (abs * (this.f - a2)));
        }
        setLayoutParams(layoutParams2);
    }

    public final void f() {
        ImageView arrowPieImage = (ImageView) a(R.id.obfuscated_res_0x7f0902f9);
        Intrinsics.checkNotNullExpressionValue(arrowPieImage, "arrowPieImage");
        if (arrowPieImage.getVisibility() == 0) {
            ImageView arrowPieImage2 = (ImageView) a(R.id.obfuscated_res_0x7f0902f9);
            Intrinsics.checkNotNullExpressionValue(arrowPieImage2, "arrowPieImage");
            arrowPieImage2.setVisibility(8);
        }
        ExpandIconView arrowImage = (ExpandIconView) a(R.id.obfuscated_res_0x7f0902f8);
        Intrinsics.checkNotNullExpressionValue(arrowImage, "arrowImage");
        if (arrowImage.getVisibility() != 0) {
            ExpandIconView arrowImage2 = (ExpandIconView) a(R.id.obfuscated_res_0x7f0902f8);
            Intrinsics.checkNotNullExpressionValue(arrowImage2, "arrowImage");
            arrowImage2.setVisibility(0);
        }
        ((ExpandIconView) a(R.id.obfuscated_res_0x7f0902f8)).startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.nad_max_guide_arrow_anim));
    }

    public final void g() {
        ExpandIconView arrowImage = (ExpandIconView) a(R.id.obfuscated_res_0x7f0902f8);
        Intrinsics.checkNotNullExpressionValue(arrowImage, "arrowImage");
        if (arrowImage.getVisibility() == 0) {
            ExpandIconView arrowImage2 = (ExpandIconView) a(R.id.obfuscated_res_0x7f0902f8);
            Intrinsics.checkNotNullExpressionValue(arrowImage2, "arrowImage");
            arrowImage2.setVisibility(8);
        }
        ImageView arrowPieImage = (ImageView) a(R.id.obfuscated_res_0x7f0902f9);
        Intrinsics.checkNotNullExpressionValue(arrowPieImage, "arrowPieImage");
        if (arrowPieImage.getVisibility() != 0) {
            ImageView arrowPieImage2 = (ImageView) a(R.id.obfuscated_res_0x7f0902f9);
            Intrinsics.checkNotNullExpressionValue(arrowPieImage2, "arrowPieImage");
            arrowPieImage2.setVisibility(0);
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.nad_max_guide_pie_arrow_anim);
        if (loadAnimation != null) {
            loadAnimation.setAnimationListener(new c());
        }
        ((ImageView) a(R.id.obfuscated_res_0x7f0902f9)).startAnimation(loadAnimation);
    }

    public final p21 getAnimTimer() {
        return this.b;
    }

    public final p21 getCountDownTimer() {
        return this.a;
    }

    public final View.OnClickListener getOutClickListener() {
        return this.e;
    }

    public final void j() {
        k();
        p21 p21Var = this.b;
        if (p21Var != null) {
            p21Var.a();
        }
        this.b = null;
        p21 p21Var2 = this.a;
        if (p21Var2 != null) {
            p21Var2.a();
        }
        this.a = null;
    }

    public final void k() {
        if (this.c != null) {
            this.c = null;
        }
        c(this.d);
    }

    public final void h(int i, int i2) {
        int i3;
        this.d = i2;
        if (i < 0) {
            return;
        }
        if (i == 0) {
            e(i2);
        } else {
            if (i == 1 && i2 == 1) {
                ExpandIconView arrowImage = (ExpandIconView) a(R.id.obfuscated_res_0x7f0902f8);
                Intrinsics.checkNotNullExpressionValue(arrowImage, "arrowImage");
                arrowImage.setVisibility(8);
            }
            if (this.b != null) {
                return;
            }
            p21 p21Var = new p21(i * 1000, 1000L);
            p21Var.d(new d(i2));
            this.b = p21Var;
            if (p21Var != null) {
                p21Var.e();
            }
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (!(layoutParams instanceof FrameLayout.LayoutParams)) {
            layoutParams = null;
        }
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        if (layoutParams2 != null) {
            i3 = layoutParams2.bottomMargin;
        } else {
            i3 = 0;
        }
        this.f = i3;
    }

    public final void setTipsVisible(boolean z, boolean z2) {
        int i;
        boolean z3;
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        TextView guideText = (TextView) a(R.id.obfuscated_res_0x7f090f3e);
        Intrinsics.checkNotNullExpressionValue(guideText, "guideText");
        if (guideText.getVisibility() == i) {
            return;
        }
        if (!z2) {
            TextView guideText2 = (TextView) a(R.id.obfuscated_res_0x7f090f3e);
            Intrinsics.checkNotNullExpressionValue(guideText2, "guideText");
            guideText2.setVisibility(i);
            return;
        }
        ObjectAnimator objectAnimator = this.c;
        if (objectAnimator != null) {
            z3 = objectAnimator.isRunning();
        } else {
            z3 = false;
        }
        if (z3) {
            ObjectAnimator objectAnimator2 = this.c;
            if (objectAnimator2 != null) {
                objectAnimator2.cancel();
            }
            this.c = null;
        }
        ObjectAnimator duration = ObjectAnimator.ofFloat((TextView) a(R.id.obfuscated_res_0x7f090f3e), Key.ALPHA, 1.0f).setDuration(500L);
        this.c = duration;
        if (z) {
            if (duration != null) {
                duration.setFloatValues(0.0f, 1.0f);
            }
            TextView guideText3 = (TextView) a(R.id.obfuscated_res_0x7f090f3e);
            Intrinsics.checkNotNullExpressionValue(guideText3, "guideText");
            guideText3.setVisibility(0);
        } else {
            if (duration != null) {
                duration.setFloatValues(1.0f, 0.0f);
            }
            ObjectAnimator objectAnimator3 = this.c;
            if (objectAnimator3 != null) {
                objectAnimator3.addListener(new e());
            }
        }
        ObjectAnimator objectAnimator4 = this.c;
        if (objectAnimator4 != null) {
            objectAnimator4.start();
        }
    }
}
