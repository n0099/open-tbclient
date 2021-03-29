package com.baidu.swan.games.loading;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.db.TableDefine;
import d.b.g0.a.f;
import d.b.g0.a.g;
import d.b.g0.a.i2.k0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u001f\u0010\bB\u0019\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\u001f\u0010\"J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\r\u0010\u0004R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R*\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006#"}, d2 = {"Lcom/baidu/swan/games/loading/SwanLoadingTipsView;", "Landroid/widget/RelativeLayout;", "", "doDestroy", "()V", "Landroid/content/Context;", "context", "init", "(Landroid/content/Context;)V", "", TableDefine.MessageColumns.COLUME_TIPS, "startTipsAppearAnimation", "(Ljava/lang/String;)V", "startTipsDisAppearAnimation", "Landroid/animation/ObjectAnimator;", "appearAnimator", "Landroid/animation/ObjectAnimator;", "disAppearAnimator", "Lkotlin/Function0;", "tipsAnimationFinishCallback", "Lkotlin/Function0;", "getTipsAnimationFinishCallback", "()Lkotlin/jvm/functions/Function0;", "setTipsAnimationFinishCallback", "(Lkotlin/jvm/functions/Function0;)V", "Ljava/lang/Runnable;", "tipsDismissRunnable", "Ljava/lang/Runnable;", "Landroid/widget/TextView;", "tipsView", "Landroid/widget/TextView;", "<init>", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "lib-swan-core_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@SuppressLint({"SwanCommentErr"})
/* loaded from: classes3.dex */
public final class SwanLoadingTipsView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public Function0<Unit> f12860e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f12861f;

    /* renamed from: g  reason: collision with root package name */
    public ObjectAnimator f12862g;

    /* renamed from: h  reason: collision with root package name */
    public ObjectAnimator f12863h;
    public Runnable i;

    /* loaded from: classes3.dex */
    public static final class a implements Animator.AnimatorListener {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            k0.U(SwanLoadingTipsView.this.i, 2000L);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            SwanLoadingTipsView.this.setVisibility(0);
        }
    }

    /* loaded from: classes3.dex */
    public static final class b implements Animator.AnimatorListener {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SwanLoadingTipsView.this.setVisibility(8);
            Function0<Unit> tipsAnimationFinishCallback = SwanLoadingTipsView.this.getTipsAnimationFinishCallback();
            if (tipsAnimationFinishCallback != null) {
                tipsAnimationFinishCallback.invoke();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: classes3.dex */
    public static final class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            SwanLoadingTipsView.this.f();
        }
    }

    public SwanLoadingTipsView(Context context) {
        super(context);
        this.i = new c();
        d(context);
    }

    public final void c() {
        this.f12860e = null;
        Runnable runnable = this.i;
        if (runnable != null) {
            k0.W(runnable);
        }
        ObjectAnimator objectAnimator = this.f12862g;
        if (objectAnimator != null) {
            if (objectAnimator != null) {
                objectAnimator.removeAllListeners();
            }
            ObjectAnimator objectAnimator2 = this.f12862g;
            if (objectAnimator2 != null) {
                objectAnimator2.cancel();
            }
            this.f12862g = null;
        }
        ObjectAnimator objectAnimator3 = this.f12863h;
        if (objectAnimator3 != null) {
            if (objectAnimator3 != null) {
                objectAnimator3.removeAllListeners();
            }
            ObjectAnimator objectAnimator4 = this.f12863h;
            if (objectAnimator4 != null) {
                objectAnimator4.cancel();
            }
            this.f12863h = null;
        }
    }

    public final void d(Context context) {
        View.inflate(context, g.aiapps_games_loading_tips_view, this);
        this.f12861f = (TextView) findViewById(f.aiapps_games_loading_tips_message);
    }

    public final void e(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        TextView textView = this.f12861f;
        if (textView != null) {
            textView.setText(str);
        }
        setVisibility(8);
        ObjectAnimator objectAnimator = this.f12862g;
        if (objectAnimator != null) {
            if (objectAnimator != null) {
                objectAnimator.removeAllListeners();
            }
            ObjectAnimator objectAnimator2 = this.f12862g;
            if (objectAnimator2 != null) {
                objectAnimator2.cancel();
            }
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "alpha", 0.0f, 1.0f);
        this.f12862g = ofFloat;
        if (ofFloat != null) {
            ofFloat.setDuration(500L);
        }
        ObjectAnimator objectAnimator3 = this.f12862g;
        if (objectAnimator3 != null) {
            objectAnimator3.setStartDelay(1000L);
        }
        ObjectAnimator objectAnimator4 = this.f12862g;
        if (objectAnimator4 != null) {
            objectAnimator4.addListener(new a());
        }
        ObjectAnimator objectAnimator5 = this.f12862g;
        if (objectAnimator5 != null) {
            objectAnimator5.start();
        }
    }

    public final void f() {
        ObjectAnimator objectAnimator = this.f12863h;
        if (objectAnimator != null) {
            if (objectAnimator != null) {
                objectAnimator.removeAllListeners();
            }
            ObjectAnimator objectAnimator2 = this.f12863h;
            if (objectAnimator2 != null) {
                objectAnimator2.cancel();
            }
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f);
        this.f12863h = ofFloat;
        if (ofFloat != null) {
            ofFloat.setDuration(500L);
        }
        ObjectAnimator objectAnimator3 = this.f12863h;
        if (objectAnimator3 != null) {
            objectAnimator3.addListener(new b());
        }
        ObjectAnimator objectAnimator4 = this.f12863h;
        if (objectAnimator4 != null) {
            objectAnimator4.start();
        }
    }

    public final Function0<Unit> getTipsAnimationFinishCallback() {
        return this.f12860e;
    }

    public final void setTipsAnimationFinishCallback(Function0<Unit> function0) {
        this.f12860e = function0;
    }

    public SwanLoadingTipsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.i = new c();
        d(context);
    }
}
