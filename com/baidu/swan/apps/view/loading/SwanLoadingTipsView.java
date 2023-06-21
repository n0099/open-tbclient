package com.baidu.swan.apps.view.loading;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.Key;
import com.baidu.tieba.R;
import com.baidu.tieba.tp3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u001f\u0010\bB\u0019\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\u001f\u0010\"J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\r\u0010\u0004R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R*\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006#"}, d2 = {"Lcom/baidu/swan/apps/view/loading/SwanLoadingTipsView;", "Landroid/widget/RelativeLayout;", "", "doDestroy", "()V", "Landroid/content/Context;", "context", "init", "(Landroid/content/Context;)V", "", "tips", "startTipsAppearAnimation", "(Ljava/lang/String;)V", "startTipsDisAppearAnimation", "Landroid/animation/ObjectAnimator;", "appearAnimator", "Landroid/animation/ObjectAnimator;", "disAppearAnimator", "Lkotlin/Function0;", "tipsAnimationFinishCallback", "Lkotlin/Function0;", "getTipsAnimationFinishCallback", "()Lkotlin/jvm/functions/Function0;", "setTipsAnimationFinishCallback", "(Lkotlin/jvm/functions/Function0;)V", "Ljava/lang/Runnable;", "tipsDismissRunnable", "Ljava/lang/Runnable;", "Landroid/widget/TextView;", "tipsView", "Landroid/widget/TextView;", "<init>", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "core_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@SuppressLint({"SwanCommentErr"})
/* loaded from: classes4.dex */
public final class SwanLoadingTipsView extends RelativeLayout {
    public Function0<Unit> a;
    public TextView b;
    public ObjectAnimator c;
    public ObjectAnimator d;
    public Runnable e;

    /* loaded from: classes4.dex */
    public static final class a implements Animator.AnimatorListener {
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            tp3.b0(SwanLoadingTipsView.this.e, 2000L);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            SwanLoadingTipsView.this.setVisibility(0);
        }
    }

    /* loaded from: classes4.dex */
    public static final class b implements Animator.AnimatorListener {
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SwanLoadingTipsView.this.setVisibility(8);
            Function0<Unit> tipsAnimationFinishCallback = SwanLoadingTipsView.this.getTipsAnimationFinishCallback();
            if (tipsAnimationFinishCallback != null) {
                tipsAnimationFinishCallback.invoke();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            SwanLoadingTipsView.this.f();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanLoadingTipsView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.e = new c();
        d(context);
    }

    public final void d(Context context) {
        View.inflate(context, R.layout.obfuscated_res_0x7f0d00b3, this);
        this.b = (TextView) findViewById(R.id.obfuscated_res_0x7f0901a5);
    }

    public final void setTipsAnimationFinishCallback(Function0<Unit> function0) {
        this.a = function0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanLoadingTipsView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.e = new c();
        d(context);
    }

    public final void c() {
        this.a = null;
        Runnable runnable = this.e;
        if (runnable != null) {
            tp3.d0(runnable);
        }
        ObjectAnimator objectAnimator = this.c;
        if (objectAnimator != null) {
            if (objectAnimator != null) {
                objectAnimator.removeAllListeners();
            }
            ObjectAnimator objectAnimator2 = this.c;
            if (objectAnimator2 != null) {
                objectAnimator2.cancel();
            }
            this.c = null;
        }
        ObjectAnimator objectAnimator3 = this.d;
        if (objectAnimator3 != null) {
            if (objectAnimator3 != null) {
                objectAnimator3.removeAllListeners();
            }
            ObjectAnimator objectAnimator4 = this.d;
            if (objectAnimator4 != null) {
                objectAnimator4.cancel();
            }
            this.d = null;
        }
    }

    public final Function0<Unit> getTipsAnimationFinishCallback() {
        return this.a;
    }

    public final void e(String str) {
        boolean z;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return;
        }
        TextView textView = this.b;
        if (textView != null) {
            textView.setText(str);
        }
        setVisibility(8);
        ObjectAnimator objectAnimator = this.c;
        if (objectAnimator != null) {
            if (objectAnimator != null) {
                objectAnimator.removeAllListeners();
            }
            ObjectAnimator objectAnimator2 = this.c;
            if (objectAnimator2 != null) {
                objectAnimator2.cancel();
            }
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, Key.ALPHA, 0.0f, 1.0f);
        this.c = ofFloat;
        if (ofFloat != null) {
            ofFloat.setDuration(500L);
        }
        ObjectAnimator objectAnimator3 = this.c;
        if (objectAnimator3 != null) {
            objectAnimator3.setStartDelay(1000L);
        }
        ObjectAnimator objectAnimator4 = this.c;
        if (objectAnimator4 != null) {
            objectAnimator4.addListener(new a());
        }
        ObjectAnimator objectAnimator5 = this.c;
        if (objectAnimator5 != null) {
            objectAnimator5.start();
        }
    }

    public final void f() {
        ObjectAnimator objectAnimator = this.d;
        if (objectAnimator != null) {
            if (objectAnimator != null) {
                objectAnimator.removeAllListeners();
            }
            ObjectAnimator objectAnimator2 = this.d;
            if (objectAnimator2 != null) {
                objectAnimator2.cancel();
            }
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, Key.ALPHA, 1.0f, 0.0f);
        this.d = ofFloat;
        if (ofFloat != null) {
            ofFloat.setDuration(500L);
        }
        ObjectAnimator objectAnimator3 = this.d;
        if (objectAnimator3 != null) {
            objectAnimator3.addListener(new b());
        }
        ObjectAnimator objectAnimator4 = this.d;
        if (objectAnimator4 != null) {
            objectAnimator4.start();
        }
    }
}
