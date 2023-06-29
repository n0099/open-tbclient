package com.baidu.nadcore.lp.reward.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieListener;
import com.baidu.nadcore.utils.ExtensionsKt;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.cq0;
import com.baidu.tieba.ps0;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010@\u001a\u00020?\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010A\u0012\b\b\u0002\u0010C\u001a\u00020\u0004¢\u0006\u0004\bD\u0010EJ5\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0019\u0010\u0011J-\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\bH\u0017¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u001f\u0010\u0018R\u001d\u0010%\u001a\u00020 8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001d\u0010*\u001a\u00020&8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\"\u001a\u0004\b(\u0010)R\u001d\u0010-\u001a\u00020&8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\"\u001a\u0004\b,\u0010)R\u001d\u00100\u001a\u00020&8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\"\u001a\u0004\b/\u0010)R\u001d\u00105\u001a\u0002018B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u0010\"\u001a\u0004\b3\u00104R\u0016\u0010\u001a\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u00106R\u001d\u0010;\u001a\u0002078B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u0010\"\u001a\u0004\b9\u0010:R\u001d\u0010>\u001a\u0002078B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b<\u0010\"\u001a\u0004\b=\u0010:¨\u0006F"}, d2 = {"Lcom/baidu/nadcore/lp/reward/view/NadVideoRewardCountDownView;", "Lcom/baidu/nadcore/lp/reward/view/AbsRewardCountDownView;", "Landroid/view/ViewGroup;", "viewGroup", "", "index", "", "animation", "Lkotlin/Function0;", "Landroid/view/ViewGroup$MarginLayoutParams;", SapiUtils.KEY_QR_LOGIN_LP, "", "attachToViewGroup", "(Landroid/view/ViewGroup;IZLkotlin/Function0;)V", "Lcom/baidu/nadcore/model/RewardData;", "rewardData", "doTaskComplete", "(Lcom/baidu/nadcore/model/RewardData;)V", "", "getMillisUntilFinished", "()J", "", "url", "loadLottieAnimation", "(Ljava/lang/String;)V", "resetUI", "taskDuration", "onFinish", "setData", "(ILcom/baidu/nadcore/model/RewardData;Lkotlin/Function0;)V", "tips", "showRewardTips", "Lcom/baidu/nadcore/widget/AdImageView;", "ivIcon$delegate", "Lkotlin/Lazy;", "getIvIcon", "()Lcom/baidu/nadcore/widget/AdImageView;", "ivIcon", "Landroid/widget/LinearLayout;", "llContent$delegate", "getLlContent", "()Landroid/widget/LinearLayout;", "llContent", "llCountDown$delegate", "getLlCountDown", "llCountDown", "llLimit$delegate", "getLlLimit", "llLimit", "Lcom/airbnb/lottie/LottieAnimationView;", "lottieView$delegate", "getLottieView", "()Lcom/airbnb/lottie/LottieAnimationView;", "lottieView", "I", "Landroid/widget/TextView;", "tvCountDown$delegate", "getTvCountDown", "()Landroid/widget/TextView;", "tvCountDown", "tvDesc$delegate", "getTvDesc", "tvDesc", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class NadVideoRewardCountDownView extends AbsRewardCountDownView {
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;
    public final Lazy n;
    public int o;

    @JvmOverloads
    public NadVideoRewardCountDownView(Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public NadVideoRewardCountDownView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AdImageView getIvIcon() {
        return (AdImageView) this.k.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LinearLayout getLlContent() {
        return (LinearLayout) this.j.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LinearLayout getLlCountDown() {
        return (LinearLayout) this.h.getValue();
    }

    private final LinearLayout getLlLimit() {
        return (LinearLayout) this.i.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LottieAnimationView getLottieView() {
        return (LottieAnimationView) this.n.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView getTvCountDown() {
        return (TextView) this.l.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView getTvDesc() {
        return (TextView) this.m.getValue();
    }

    /* loaded from: classes3.dex */
    public static final class b<T> implements LottieListener<LottieComposition> {
        public b() {
        }

        /* loaded from: classes3.dex */
        public static final class a extends AnimatorListenerAdapter {

            /* renamed from: com.baidu.nadcore.lp.reward.view.NadVideoRewardCountDownView$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public static final class C0125a implements ValueAnimator.AnimatorUpdateListener {
                public C0125a() {
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator animator) {
                    LinearLayout llContent = NadVideoRewardCountDownView.this.getLlContent();
                    Intrinsics.checkNotNullExpressionValue(animator, "animator");
                    Object animatedValue = animator.getAnimatedValue();
                    if (animatedValue != null) {
                        llContent.setAlpha(((Float) animatedValue).floatValue());
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
                }
            }

            /* JADX DEBUG: Incorrect args count in method signature: ()V */
            public a() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.5f);
                ofFloat.addUpdateListener(new C0125a());
                ofFloat.setDuration(200L).start();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a */
        public final void onResult(LottieComposition lottieComposition) {
            NadVideoRewardCountDownView.this.getLottieView().addAnimatorListener(new a());
            NadVideoRewardCountDownView.this.getLottieView().setComposition(lottieComposition);
            NadVideoRewardCountDownView.this.getLottieView().playAnimation();
            NadVideoRewardCountDownView.this.getLottieView().setVisibility(0);
        }
    }

    /* loaded from: classes3.dex */
    public static final class a implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ ps0 b;

        public a(ps0 ps0Var) {
            this.b = ps0Var;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator it) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            Object animatedValue = it.getAnimatedValue();
            if (animatedValue != null) {
                float floatValue = ((Float) animatedValue).floatValue();
                if (floatValue <= 0.2f) {
                    NadVideoRewardCountDownView.this.getTvCountDown().setVisibility(8);
                    NadVideoRewardCountDownView.this.getTvDesc().setText(this.b.x());
                    NadVideoRewardCountDownView.this.getIvIcon().setVisibility(8);
                    NadVideoRewardCountDownView.this.r(this.b.w());
                }
                NadVideoRewardCountDownView.this.getLlCountDown().setAlpha(floatValue);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    /* loaded from: classes3.dex */
    public static final class c<T> implements LottieListener<Throwable> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a */
        public final void onResult(Throwable th) {
            NadVideoRewardCountDownView.this.getLottieView().setVisibility(8);
        }
    }

    /* loaded from: classes3.dex */
    public static final class d extends cq0 {
        public final /* synthetic */ ps0 k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(ps0 ps0Var, int i, long j, long j2) {
            super(j, j2);
            this.k = ps0Var;
        }

        @Override // com.baidu.tieba.cq0
        public void l() {
            Function0<Unit> countDownFinish = NadVideoRewardCountDownView.this.getCountDownFinish();
            if (countDownFinish != null) {
                countDownFinish.invoke();
            }
            NadVideoRewardCountDownView.this.q(this.k);
        }

        @Override // com.baidu.tieba.cq0
        public void m(long j) {
            Function0<Unit> bigCardShowCallback;
            Function0<Unit> suspendShowCallback;
            super.m(j);
            int i = (int) (j / 1000);
            if (i == NadVideoRewardCountDownView.this.getSuspendShowTime() && (suspendShowCallback = NadVideoRewardCountDownView.this.getSuspendShowCallback()) != null) {
                suspendShowCallback.invoke();
            }
            if (i == NadVideoRewardCountDownView.this.getBigCardShowTime() && (bigCardShowCallback = NadVideoRewardCountDownView.this.getBigCardShowCallback()) != null) {
                bigCardShowCallback.invoke();
            }
            NadVideoRewardCountDownView.this.getTvCountDown().setText(String.valueOf(j / 1000));
        }
    }

    /* loaded from: classes3.dex */
    public static final class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            cq0 countDownTime = NadVideoRewardCountDownView.this.getCountDownTime();
            if (countDownTime != null) {
                countDownTime.n();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NadVideoRewardCountDownView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.h = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: com.baidu.nadcore.lp.reward.view.NadVideoRewardCountDownView$llCountDown$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LinearLayout invoke() {
                View findViewById = NadVideoRewardCountDownView.this.findViewById(R.id.ll_countdown);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.ll_countdown)");
                return (LinearLayout) findViewById;
            }
        });
        this.i = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: com.baidu.nadcore.lp.reward.view.NadVideoRewardCountDownView$llLimit$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LinearLayout invoke() {
                View findViewById = NadVideoRewardCountDownView.this.findViewById(R.id.obfuscated_res_0x7f0915f4);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.ll_limit)");
                return (LinearLayout) findViewById;
            }
        });
        this.j = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: com.baidu.nadcore.lp.reward.view.NadVideoRewardCountDownView$llContent$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LinearLayout invoke() {
                View findViewById = NadVideoRewardCountDownView.this.findViewById(R.id.ll_content);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.ll_content)");
                return (LinearLayout) findViewById;
            }
        });
        this.k = LazyKt__LazyJVMKt.lazy(new Function0<AdImageView>() { // from class: com.baidu.nadcore.lp.reward.view.NadVideoRewardCountDownView$ivIcon$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AdImageView invoke() {
                View findViewById = NadVideoRewardCountDownView.this.findViewById(R.id.iv_icon);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.iv_icon)");
                return (AdImageView) findViewById;
            }
        });
        this.l = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.baidu.nadcore.lp.reward.view.NadVideoRewardCountDownView$tvCountDown$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                View findViewById = NadVideoRewardCountDownView.this.findViewById(R.id.tv_countdown);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.tv_countdown)");
                return (TextView) findViewById;
            }
        });
        this.m = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.baidu.nadcore.lp.reward.view.NadVideoRewardCountDownView$tvDesc$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                View findViewById = NadVideoRewardCountDownView.this.findViewById(R.id.tv_desc);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.tv_desc)");
                return (TextView) findViewById;
            }
        });
        this.n = LazyKt__LazyJVMKt.lazy(new Function0<LottieAnimationView>() { // from class: com.baidu.nadcore.lp.reward.view.NadVideoRewardCountDownView$lottieView$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LottieAnimationView invoke() {
                View findViewById = NadVideoRewardCountDownView.this.findViewById(R.id.lottie_view);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.lottie_view)");
                return (LottieAnimationView) findViewById;
            }
        });
        LayoutInflater.from(context).inflate(R.layout.nad_reward_video_lp_countdown, this);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(ExtensionsKt.d(14, context));
        gradientDrawable.setStroke(ExtensionsKt.d(1, context), ContextCompat.getColor(context, R.color.nad_welfare_countdown_stroke));
        int color = ContextCompat.getColor(context, R.color.nad_welfare_countdown_bg);
        gradientDrawable.setColors(new int[]{color, color});
        Unit unit = Unit.INSTANCE;
        setBackground(gradientDrawable);
    }

    public /* synthetic */ NadVideoRewardCountDownView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    @Override // com.baidu.nadcore.lp.reward.view.AbsRewardCountDownView
    public void f(String tips) {
        Intrinsics.checkNotNullParameter(tips, "tips");
        getTvCountDown().setVisibility(8);
        getTvDesc().setText(tips);
    }

    public final void q(ps0 ps0Var) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f, 1.0f);
        ofFloat.addUpdateListener(new a(ps0Var));
        ofFloat.setDuration(400L).start();
    }

    @Override // com.baidu.nadcore.lp.reward.view.AbsRewardCountDownView
    public void a(ViewGroup viewGroup, int i, boolean z, Function0<? extends ViewGroup.MarginLayoutParams> lp) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        Intrinsics.checkNotNullParameter(lp, "lp");
        super.a(viewGroup, i, z, new Function0<ViewGroup.MarginLayoutParams>() { // from class: com.baidu.nadcore.lp.reward.view.NadVideoRewardCountDownView$attachToViewGroup$1
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewGroup.MarginLayoutParams invoke() {
                ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
                Context context = NadVideoRewardCountDownView.this.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                marginLayoutParams.leftMargin = ExtensionsKt.d(14, context);
                Context context2 = NadVideoRewardCountDownView.this.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                marginLayoutParams.topMargin = ExtensionsKt.d(6, context2);
                return marginLayoutParams;
            }
        });
    }

    @Override // com.baidu.nadcore.lp.reward.view.AbsRewardCountDownView
    public long getMillisUntilFinished() {
        long j;
        long millis = TimeUnit.SECONDS.toMillis(this.o);
        cq0 countDownTime = getCountDownTime();
        if (countDownTime != null) {
            j = countDownTime.j();
        } else {
            j = 0;
        }
        return millis - j;
    }

    public final void r(String str) {
        boolean z;
        if (str.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            getLottieView().setVisibility(8);
        } else {
            LottieCompositionFactory.fromUrl(getContext(), str, String.valueOf(str.hashCode())).addListener(new b()).addFailureListener(new c());
        }
    }

    public final void s(ps0 ps0Var) {
        getTvCountDown().setVisibility(0);
        getIvIcon().setVisibility(0);
        getTvDesc().setText(ps0Var.z());
        getLlLimit().setVisibility(8);
        getLottieView().setVisibility(8);
        getLlCountDown().setAlpha(1.0f);
        getLlContent().setAlpha(1.0f);
    }

    @Override // com.baidu.nadcore.lp.reward.view.AbsRewardCountDownView
    @SuppressLint({"SetTextI18n"})
    public void setData(int i, ps0 rewardData, Function0<Unit> onFinish) {
        Intrinsics.checkNotNullParameter(rewardData, "rewardData");
        Intrinsics.checkNotNullParameter(onFinish, "onFinish");
        s(rewardData);
        setCountDownFinish(onFinish);
        this.o = i;
        getIvIcon().o(rewardData.y());
        getTvCountDown().setText(String.valueOf(i));
        setCountDownTime(new d(rewardData, i, TimeUnit.SECONDS.toMillis(i), 1000L));
        setDelayTimingTask(new e());
        postDelayed(getDelayTimingTask(), 1000L);
    }
}
