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
/* loaded from: classes10.dex */
public final class SwanLoadingTipsView extends RelativeLayout {
    private kotlin.jvm.a.a<l> dXc;
    private TextView dXd;
    private ObjectAnimator dXe;
    private ObjectAnimator dXf;
    private Runnable dXg;

    public final kotlin.jvm.a.a<l> getTipsAnimationFinishCallback() {
        return this.dXc;
    }

    public final void setTipsAnimationFinishCallback(kotlin.jvm.a.a<l> aVar) {
        this.dXc = aVar;
    }

    @h
    /* loaded from: classes10.dex */
    static final class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            SwanLoadingTipsView.this.aWn();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanLoadingTipsView(Context context) {
        super(context);
        q.n(context, "context");
        this.dXg = new c();
        init(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanLoadingTipsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        q.n(context, "context");
        q.n(attributeSet, "attrs");
        this.dXg = new c();
        init(context);
    }

    private final void init(Context context) {
        View.inflate(context, a.g.aiapps_games_loading_tips_view, this);
        this.dXd = (TextView) findViewById(a.f.aiapps_games_loading_tips_message);
    }

    public final void xo(String str) {
        String str2 = str;
        if (!(str2 == null || str2.length() == 0)) {
            TextView textView = this.dXd;
            if (textView != null) {
                textView.setText(str);
            }
            setVisibility(8);
            if (this.dXe != null) {
                ObjectAnimator objectAnimator = this.dXe;
                if (objectAnimator != null) {
                    objectAnimator.removeAllListeners();
                }
                ObjectAnimator objectAnimator2 = this.dXe;
                if (objectAnimator2 != null) {
                    objectAnimator2.cancel();
                }
            }
            this.dXe = ObjectAnimator.ofFloat(this, "alpha", 0.0f, 1.0f);
            ObjectAnimator objectAnimator3 = this.dXe;
            if (objectAnimator3 != null) {
                objectAnimator3.setDuration(500L);
            }
            ObjectAnimator objectAnimator4 = this.dXe;
            if (objectAnimator4 != null) {
                objectAnimator4.setStartDelay(1000L);
            }
            ObjectAnimator objectAnimator5 = this.dXe;
            if (objectAnimator5 != null) {
                objectAnimator5.addListener(new a());
            }
            ObjectAnimator objectAnimator6 = this.dXe;
            if (objectAnimator6 != null) {
                objectAnimator6.start();
            }
        }
    }

    @h
    /* loaded from: classes10.dex */
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
            ak.c(SwanLoadingTipsView.this.dXg, 2000L);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            SwanLoadingTipsView.this.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void aWn() {
        if (this.dXf != null) {
            ObjectAnimator objectAnimator = this.dXf;
            if (objectAnimator != null) {
                objectAnimator.removeAllListeners();
            }
            ObjectAnimator objectAnimator2 = this.dXf;
            if (objectAnimator2 != null) {
                objectAnimator2.cancel();
            }
        }
        this.dXf = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimator3 = this.dXf;
        if (objectAnimator3 != null) {
            objectAnimator3.setDuration(500L);
        }
        ObjectAnimator objectAnimator4 = this.dXf;
        if (objectAnimator4 != null) {
            objectAnimator4.addListener(new b());
        }
        ObjectAnimator objectAnimator5 = this.dXf;
        if (objectAnimator5 != null) {
            objectAnimator5.start();
        }
    }

    @h
    /* loaded from: classes10.dex */
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
        this.dXc = null;
        if (this.dXg != null) {
            ak.l(this.dXg);
        }
        if (this.dXe != null) {
            ObjectAnimator objectAnimator = this.dXe;
            if (objectAnimator != null) {
                objectAnimator.removeAllListeners();
            }
            ObjectAnimator objectAnimator2 = this.dXe;
            if (objectAnimator2 != null) {
                objectAnimator2.cancel();
            }
            this.dXe = null;
        }
        if (this.dXf != null) {
            ObjectAnimator objectAnimator3 = this.dXf;
            if (objectAnimator3 != null) {
                objectAnimator3.removeAllListeners();
            }
            ObjectAnimator objectAnimator4 = this.dXf;
            if (objectAnimator4 != null) {
                objectAnimator4.cancel();
            }
            this.dXf = null;
        }
    }
}
