package com.baidu.nadcore.lp.reward.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tieba.jq0;
import com.baidu.tieba.wn0;
import com.baidu.webkit.sdk.WebChromeClient;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b \u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010K\u001a\u00020J\u0012\n\b\u0002\u0010M\u001a\u0004\u0018\u00010L\u0012\b\b\u0002\u0010N\u001a\u00020\u0004¢\u0006\u0004\bO\u0010PJ;\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\b¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\u000b¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\u000b¢\u0006\u0004\b\u0017\u0010\u0013J\u0017\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ-\u0010 \u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001d2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000b0\bH&¢\u0006\u0004\b \u0010!J\u0017\u0010$\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\"H&¢\u0006\u0004\b$\u0010%J\r\u0010&\u001a\u00020\u000b¢\u0006\u0004\b&\u0010\u0013J\r\u0010'\u001a\u00020\u000b¢\u0006\u0004\b'\u0010\u0013J#\u0010)\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\b¢\u0006\u0004\b)\u0010\u0011R*\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u0010/\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R*\u00105\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u0010*\u001a\u0004\b6\u0010,\"\u0004\b7\u0010.R$\u00109\u001a\u0004\u0018\u0001088\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R$\u0010@\u001a\u0004\u0018\u00010?8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER*\u0010)\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\bF\u0010,\"\u0004\bG\u0010.R\"\u0010(\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u00100\u001a\u0004\bH\u00102\"\u0004\bI\u00104¨\u0006Q"}, d2 = {"Lcom/baidu/nadcore/lp/reward/view/AbsRewardCountDownView;", "Landroidx/appcompat/widget/LinearLayoutCompat;", "Landroid/view/ViewGroup;", "viewGroup", "", "index", "", "animation", "Lkotlin/Function0;", "Landroid/view/ViewGroup$MarginLayoutParams;", SapiUtils.KEY_QR_LOGIN_LP, "", "attachToViewGroup", "(Landroid/view/ViewGroup;IZLkotlin/Function0;)V", "showTime", WebChromeClient.KEY_ARG_CALLBACK, "bigCardShowCallback", "(ILkotlin/Function0;)V", "continueCountDown", "()V", "", "getMillisUntilFinished", "()J", "removeCountDownCallback", "Landroid/view/View$OnClickListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setCountDownClickListener", "(Landroid/view/View$OnClickListener;)V", "taskDuration", "Lcom/baidu/nadcore/model/RewardData;", "rewardData", "onFinish", "setData", "(ILcom/baidu/nadcore/model/RewardData;Lkotlin/Function0;)V", "", "tips", "showRewardTips", "(Ljava/lang/String;)V", "startCountDown", "stopCountDown", "suspendShowTime", "suspendShowCallback", "Lkotlin/Function0;", "getBigCardShowCallback", "()Lkotlin/jvm/functions/Function0;", "setBigCardShowCallback", "(Lkotlin/jvm/functions/Function0;)V", "bigCardShowTime", "I", "getBigCardShowTime", "()I", "setBigCardShowTime", "(I)V", "countDownFinish", "getCountDownFinish", "setCountDownFinish", "Lcom/baidu/nadcore/lp/reward/util/MultipleStartCountDownTime;", "countDownTime", "Lcom/baidu/nadcore/lp/reward/util/MultipleStartCountDownTime;", "getCountDownTime", "()Lcom/baidu/nadcore/lp/reward/util/MultipleStartCountDownTime;", "setCountDownTime", "(Lcom/baidu/nadcore/lp/reward/util/MultipleStartCountDownTime;)V", "Ljava/lang/Runnable;", "delayTimingTask", "Ljava/lang/Runnable;", "getDelayTimingTask", "()Ljava/lang/Runnable;", "setDelayTimingTask", "(Ljava/lang/Runnable;)V", "getSuspendShowCallback", "setSuspendShowCallback", "getSuspendShowTime", "setSuspendShowTime", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public abstract class AbsRewardCountDownView extends LinearLayoutCompat {
    public wn0 a;
    public Function0<Unit> b;
    public Runnable c;
    public int d;
    public Function0<Unit> e;
    public int f;
    public Function0<Unit> g;

    @JvmOverloads
    public AbsRewardCountDownView(Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public AbsRewardCountDownView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public abstract void f(String str);

    public abstract void setData(int i, jq0 jq0Var, Function0<Unit> function0);

    /* loaded from: classes2.dex */
    public static final class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator it) {
            AbsRewardCountDownView absRewardCountDownView = AbsRewardCountDownView.this;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            Object animatedValue = it.getAnimatedValue();
            if (animatedValue != null) {
                absRewardCountDownView.setAlpha(((Float) animatedValue).floatValue());
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    /* loaded from: classes2.dex */
    public static final class b implements View.OnClickListener {
        public final /* synthetic */ View.OnClickListener a;

        public b(View.OnClickListener onClickListener) {
            this.a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            this.a.onClick(view2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AbsRewardCountDownView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.d = -1;
        this.f = -1;
    }

    public /* synthetic */ AbsRewardCountDownView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.nadcore.lp.reward.view.AbsRewardCountDownView */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void b(AbsRewardCountDownView absRewardCountDownView, ViewGroup viewGroup, int i, boolean z, Function0 function0, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                i = -1;
            }
            if ((i2 & 4) != 0) {
                z = false;
            }
            if ((i2 & 8) != 0) {
                function0 = new Function0<ViewGroup.MarginLayoutParams>() { // from class: com.baidu.nadcore.lp.reward.view.AbsRewardCountDownView$attachToViewGroup$1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final ViewGroup.MarginLayoutParams invoke() {
                        return new ViewGroup.MarginLayoutParams(-2, -2);
                    }
                };
            }
            absRewardCountDownView.a(viewGroup, i, z, function0);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: attachToViewGroup");
    }

    public void a(ViewGroup viewGroup, int i, boolean z, Function0<? extends ViewGroup.MarginLayoutParams> lp) {
        float f;
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        Intrinsics.checkNotNullParameter(lp, "lp");
        if (z) {
            f = 0.0f;
        } else {
            f = 1.0f;
        }
        setAlpha(f);
        ViewParent parent = getParent();
        if (!(parent instanceof ViewGroup)) {
            parent = null;
        }
        ViewGroup viewGroup2 = (ViewGroup) parent;
        if (viewGroup2 != null) {
            viewGroup2.removeView(this);
        }
        viewGroup.addView(this, lp.invoke());
        if (z) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.addUpdateListener(new a());
            ofFloat.setDuration(200L).start();
        }
    }

    public final void c(int i, Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (i < 0) {
            i = 0;
        }
        this.f = i;
        this.g = callback;
    }

    public final void h(int i, Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.d = i;
        this.e = callback;
    }

    public final void d() {
        wn0 wn0Var = this.a;
        if (wn0Var != null) {
            wn0Var.i();
        }
    }

    public final void e() {
        this.b = null;
        removeCallbacks(this.c);
        wn0 wn0Var = this.a;
        if (wn0Var != null) {
            wn0Var.h();
        }
    }

    public final void g() {
        wn0 wn0Var = this.a;
        if (wn0Var != null) {
            wn0Var.h();
        }
    }

    public final Function0<Unit> getBigCardShowCallback() {
        return this.g;
    }

    public final int getBigCardShowTime() {
        return this.f;
    }

    public final Function0<Unit> getCountDownFinish() {
        return this.b;
    }

    public final wn0 getCountDownTime() {
        return this.a;
    }

    public final Runnable getDelayTimingTask() {
        return this.c;
    }

    public long getMillisUntilFinished() {
        wn0 wn0Var = this.a;
        if (wn0Var != null) {
            return wn0Var.k();
        }
        return 0L;
    }

    public final Function0<Unit> getSuspendShowCallback() {
        return this.e;
    }

    public final int getSuspendShowTime() {
        return this.d;
    }

    public final void setBigCardShowCallback(Function0<Unit> function0) {
        this.g = function0;
    }

    public final void setBigCardShowTime(int i) {
        this.f = i;
    }

    public void setCountDownClickListener(View.OnClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        setOnClickListener(new b(listener));
    }

    public final void setCountDownFinish(Function0<Unit> function0) {
        this.b = function0;
    }

    public final void setCountDownTime(wn0 wn0Var) {
        this.a = wn0Var;
    }

    public final void setDelayTimingTask(Runnable runnable) {
        this.c = runnable;
    }

    public final void setSuspendShowCallback(Function0<Unit> function0) {
        this.e = function0;
    }

    public final void setSuspendShowTime(int i) {
        this.d = i;
    }
}
