package com.baidu.swan.games.loading;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ap.ak;
import kotlin.h;
import kotlin.jvm.internal.q;
import kotlin.l;
@h
@SuppressLint({"SwanCommentErr"})
/* loaded from: classes8.dex */
public final class SwanLoadingTipsView extends RelativeLayout {
    private kotlin.jvm.a.a<l> duH;
    private TextView duI;
    private ObjectAnimator duJ;
    private ObjectAnimator duK;
    private Runnable duL;

    public final kotlin.jvm.a.a<l> getTipsAnimationFinishCallback() {
        return this.duH;
    }

    public final void setTipsAnimationFinishCallback(kotlin.jvm.a.a<l> aVar) {
        this.duH = aVar;
    }

    @h
    /* loaded from: classes8.dex */
    static final class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            SwanLoadingTipsView.this.aOz();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanLoadingTipsView(Context context) {
        super(context);
        q.m(context, "context");
        this.duL = new c();
        init(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanLoadingTipsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        q.m(context, "context");
        q.m(attributeSet, "attrs");
        this.duL = new c();
        init(context);
    }

    private final void init(Context context) {
        View.inflate(context, a.g.aiapps_games_loading_tips_view, this);
        this.duI = (TextView) findViewById(a.f.aiapps_games_loading_tips_message);
    }

    public final void vB(String str) {
        String str2 = str;
        if (!(str2 == null || str2.length() == 0)) {
            TextView textView = this.duI;
            if (textView != null) {
                textView.setText(str);
            }
            setVisibility(8);
            if (this.duJ != null) {
                ObjectAnimator objectAnimator = this.duJ;
                if (objectAnimator != null) {
                    objectAnimator.removeAllListeners();
                }
                ObjectAnimator objectAnimator2 = this.duJ;
                if (objectAnimator2 != null) {
                    objectAnimator2.cancel();
                }
            }
            this.duJ = ObjectAnimator.ofFloat(this, "alpha", 0.0f, 1.0f);
            ObjectAnimator objectAnimator3 = this.duJ;
            if (objectAnimator3 != null) {
                objectAnimator3.setDuration(500L);
            }
            ObjectAnimator objectAnimator4 = this.duJ;
            if (objectAnimator4 != null) {
                objectAnimator4.setStartDelay(1000L);
            }
            ObjectAnimator objectAnimator5 = this.duJ;
            if (objectAnimator5 != null) {
                objectAnimator5.addListener(new a());
            }
            ObjectAnimator objectAnimator6 = this.duJ;
            if (objectAnimator6 != null) {
                objectAnimator6.start();
            }
        }
    }

    @h
    /* loaded from: classes8.dex */
    public static final class a implements Animator.AnimatorListener {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ak.c(SwanLoadingTipsView.this.duL, 2000L);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            SwanLoadingTipsView.this.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void aOz() {
        if (this.duK != null) {
            ObjectAnimator objectAnimator = this.duK;
            if (objectAnimator != null) {
                objectAnimator.removeAllListeners();
            }
            ObjectAnimator objectAnimator2 = this.duK;
            if (objectAnimator2 != null) {
                objectAnimator2.cancel();
            }
        }
        this.duK = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimator3 = this.duK;
        if (objectAnimator3 != null) {
            objectAnimator3.setDuration(500L);
        }
        ObjectAnimator objectAnimator4 = this.duK;
        if (objectAnimator4 != null) {
            objectAnimator4.addListener(new b());
        }
        ObjectAnimator objectAnimator5 = this.duK;
        if (objectAnimator5 != null) {
            objectAnimator5.start();
        }
    }

    @h
    /* loaded from: classes8.dex */
    public static final class b implements Animator.AnimatorListener {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SwanLoadingTipsView.this.setVisibility(8);
            kotlin.jvm.a.a<l> tipsAnimationFinishCallback = SwanLoadingTipsView.this.getTipsAnimationFinishCallback();
            if (tipsAnimationFinishCallback != null) {
                tipsAnimationFinishCallback.invoke();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public final void doDestroy() {
        this.duH = null;
        if (this.duL != null) {
            ak.l(this.duL);
        }
        if (this.duJ != null) {
            ObjectAnimator objectAnimator = this.duJ;
            if (objectAnimator != null) {
                objectAnimator.removeAllListeners();
            }
            ObjectAnimator objectAnimator2 = this.duJ;
            if (objectAnimator2 != null) {
                objectAnimator2.cancel();
            }
            this.duJ = null;
        }
        if (this.duK != null) {
            ObjectAnimator objectAnimator3 = this.duK;
            if (objectAnimator3 != null) {
                objectAnimator3.removeAllListeners();
            }
            ObjectAnimator objectAnimator4 = this.duK;
            if (objectAnimator4 != null) {
                objectAnimator4.cancel();
            }
            this.duK = null;
        }
    }
}
