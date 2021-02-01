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
import com.baidu.swan.apps.ao.ak;
import kotlin.e;
import kotlin.h;
import kotlin.jvm.internal.p;
@SuppressLint({"SwanCommentErr"})
@e
/* loaded from: classes9.dex */
public final class SwanLoadingTipsView extends RelativeLayout {
    private kotlin.jvm.a.a<h> eiK;
    private TextView eiL;
    private ObjectAnimator eiM;
    private ObjectAnimator eiN;
    private Runnable eiO;

    public final kotlin.jvm.a.a<h> getTipsAnimationFinishCallback() {
        return this.eiK;
    }

    public final void setTipsAnimationFinishCallback(kotlin.jvm.a.a<h> aVar) {
        this.eiK = aVar;
    }

    @e
    /* loaded from: classes9.dex */
    static final class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            SwanLoadingTipsView.this.aXx();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanLoadingTipsView(Context context) {
        super(context);
        p.o(context, "context");
        this.eiO = new c();
        init(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanLoadingTipsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.o(context, "context");
        p.o(attributeSet, "attrs");
        this.eiO = new c();
        init(context);
    }

    private final void init(Context context) {
        View.inflate(context, a.g.aiapps_games_loading_tips_view, this);
        this.eiL = (TextView) findViewById(a.f.aiapps_games_loading_tips_message);
    }

    public final void wX(String str) {
        String str2 = str;
        if (!(str2 == null || str2.length() == 0)) {
            TextView textView = this.eiL;
            if (textView != null) {
                textView.setText(str);
            }
            setVisibility(8);
            if (this.eiM != null) {
                ObjectAnimator objectAnimator = this.eiM;
                if (objectAnimator != null) {
                    objectAnimator.removeAllListeners();
                }
                ObjectAnimator objectAnimator2 = this.eiM;
                if (objectAnimator2 != null) {
                    objectAnimator2.cancel();
                }
            }
            this.eiM = ObjectAnimator.ofFloat(this, "alpha", 0.0f, 1.0f);
            ObjectAnimator objectAnimator3 = this.eiM;
            if (objectAnimator3 != null) {
                objectAnimator3.setDuration(500L);
            }
            ObjectAnimator objectAnimator4 = this.eiM;
            if (objectAnimator4 != null) {
                objectAnimator4.setStartDelay(1000L);
            }
            ObjectAnimator objectAnimator5 = this.eiM;
            if (objectAnimator5 != null) {
                objectAnimator5.addListener(new a());
            }
            ObjectAnimator objectAnimator6 = this.eiM;
            if (objectAnimator6 != null) {
                objectAnimator6.start();
            }
        }
    }

    @e
    /* loaded from: classes9.dex */
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
            ak.c(SwanLoadingTipsView.this.eiO, 2000L);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            SwanLoadingTipsView.this.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void aXx() {
        if (this.eiN != null) {
            ObjectAnimator objectAnimator = this.eiN;
            if (objectAnimator != null) {
                objectAnimator.removeAllListeners();
            }
            ObjectAnimator objectAnimator2 = this.eiN;
            if (objectAnimator2 != null) {
                objectAnimator2.cancel();
            }
        }
        this.eiN = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimator3 = this.eiN;
        if (objectAnimator3 != null) {
            objectAnimator3.setDuration(500L);
        }
        ObjectAnimator objectAnimator4 = this.eiN;
        if (objectAnimator4 != null) {
            objectAnimator4.addListener(new b());
        }
        ObjectAnimator objectAnimator5 = this.eiN;
        if (objectAnimator5 != null) {
            objectAnimator5.start();
        }
    }

    @e
    /* loaded from: classes9.dex */
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
            kotlin.jvm.a.a<h> tipsAnimationFinishCallback = SwanLoadingTipsView.this.getTipsAnimationFinishCallback();
            if (tipsAnimationFinishCallback != null) {
                tipsAnimationFinishCallback.invoke();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public final void doDestroy() {
        this.eiK = null;
        if (this.eiO != null) {
            ak.j(this.eiO);
        }
        if (this.eiM != null) {
            ObjectAnimator objectAnimator = this.eiM;
            if (objectAnimator != null) {
                objectAnimator.removeAllListeners();
            }
            ObjectAnimator objectAnimator2 = this.eiM;
            if (objectAnimator2 != null) {
                objectAnimator2.cancel();
            }
            this.eiM = null;
        }
        if (this.eiN != null) {
            ObjectAnimator objectAnimator3 = this.eiN;
            if (objectAnimator3 != null) {
                objectAnimator3.removeAllListeners();
            }
            ObjectAnimator objectAnimator4 = this.eiN;
            if (objectAnimator4 != null) {
                objectAnimator4.cancel();
            }
            this.eiN = null;
        }
    }
}
