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
import com.baidu.swan.apps.as.ai;
import kotlin.g;
import kotlin.jvm.internal.p;
@SuppressLint({"SwanCommentErr"})
/* loaded from: classes9.dex */
public final class SwanLoadingTipsView extends RelativeLayout {
    private kotlin.jvm.a.a<g> clG;
    private TextView clH;
    private ObjectAnimator clI;
    private ObjectAnimator clJ;
    private Runnable clK;

    public final kotlin.jvm.a.a<g> getTipsAnimationFinishCallback() {
        return this.clG;
    }

    public final void setTipsAnimationFinishCallback(kotlin.jvm.a.a<g> aVar) {
        this.clG = aVar;
    }

    /* loaded from: classes9.dex */
    static final class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            SwanLoadingTipsView.this.amg();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanLoadingTipsView(Context context) {
        super(context);
        p.j(context, "context");
        this.clK = new c();
        init(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanLoadingTipsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.j(context, "context");
        p.j(attributeSet, "attrs");
        this.clK = new c();
        init(context);
    }

    private final void init(Context context) {
        View.inflate(context, a.g.aiapps_games_loading_tips_view, this);
        this.clH = (TextView) findViewById(a.f.aiapps_games_loading_tips_message);
    }

    public final void oX(String str) {
        String str2 = str;
        if (!(str2 == null || str2.length() == 0)) {
            TextView textView = this.clH;
            if (textView != null) {
                textView.setText(str);
            }
            setVisibility(8);
            if (this.clI != null) {
                ObjectAnimator objectAnimator = this.clI;
                if (objectAnimator != null) {
                    objectAnimator.removeAllListeners();
                }
                ObjectAnimator objectAnimator2 = this.clI;
                if (objectAnimator2 != null) {
                    objectAnimator2.cancel();
                }
            }
            this.clI = ObjectAnimator.ofFloat(this, "alpha", 0.0f, 1.0f);
            ObjectAnimator objectAnimator3 = this.clI;
            if (objectAnimator3 != null) {
                objectAnimator3.setDuration(500L);
            }
            ObjectAnimator objectAnimator4 = this.clI;
            if (objectAnimator4 != null) {
                objectAnimator4.setStartDelay(1000L);
            }
            ObjectAnimator objectAnimator5 = this.clI;
            if (objectAnimator5 != null) {
                objectAnimator5.addListener(new a());
            }
            ObjectAnimator objectAnimator6 = this.clI;
            if (objectAnimator6 != null) {
                objectAnimator6.start();
            }
        }
    }

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
            ai.b(SwanLoadingTipsView.this.clK, 2000L);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            SwanLoadingTipsView.this.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void amg() {
        if (this.clJ != null) {
            ObjectAnimator objectAnimator = this.clJ;
            if (objectAnimator != null) {
                objectAnimator.removeAllListeners();
            }
            ObjectAnimator objectAnimator2 = this.clJ;
            if (objectAnimator2 != null) {
                objectAnimator2.cancel();
            }
        }
        this.clJ = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimator3 = this.clJ;
        if (objectAnimator3 != null) {
            objectAnimator3.setDuration(500L);
        }
        ObjectAnimator objectAnimator4 = this.clJ;
        if (objectAnimator4 != null) {
            objectAnimator4.addListener(new b());
        }
        ObjectAnimator objectAnimator5 = this.clJ;
        if (objectAnimator5 != null) {
            objectAnimator5.start();
        }
    }

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
            kotlin.jvm.a.a<g> tipsAnimationFinishCallback = SwanLoadingTipsView.this.getTipsAnimationFinishCallback();
            if (tipsAnimationFinishCallback != null) {
                tipsAnimationFinishCallback.invoke();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public final void doDestroy() {
        this.clG = null;
        if (this.clK != null) {
            ai.k(this.clK);
        }
        if (this.clI != null) {
            ObjectAnimator objectAnimator = this.clI;
            if (objectAnimator != null) {
                objectAnimator.removeAllListeners();
            }
            ObjectAnimator objectAnimator2 = this.clI;
            if (objectAnimator2 != null) {
                objectAnimator2.cancel();
            }
            this.clI = null;
        }
        if (this.clJ != null) {
            ObjectAnimator objectAnimator3 = this.clJ;
            if (objectAnimator3 != null) {
                objectAnimator3.removeAllListeners();
            }
            ObjectAnimator objectAnimator4 = this.clJ;
            if (objectAnimator4 != null) {
                objectAnimator4.cancel();
            }
            this.clJ = null;
        }
    }
}
