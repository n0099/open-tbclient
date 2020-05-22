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
import com.baidu.swan.apps.aq.aj;
import kotlin.h;
import kotlin.jvm.internal.q;
import kotlin.l;
@h
@SuppressLint({"SwanCommentErr"})
/* loaded from: classes11.dex */
public final class SwanLoadingTipsView extends RelativeLayout {
    private kotlin.jvm.a.a<l> dac;
    private TextView dad;
    private ObjectAnimator dae;
    private ObjectAnimator daf;
    private Runnable dag;

    public final kotlin.jvm.a.a<l> getTipsAnimationFinishCallback() {
        return this.dac;
    }

    public final void setTipsAnimationFinishCallback(kotlin.jvm.a.a<l> aVar) {
        this.dac = aVar;
    }

    @h
    /* loaded from: classes11.dex */
    static final class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            SwanLoadingTipsView.this.aAV();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanLoadingTipsView(Context context) {
        super(context);
        q.m(context, "context");
        this.dag = new c();
        init(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanLoadingTipsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        q.m(context, "context");
        q.m(attributeSet, "attrs");
        this.dag = new c();
        init(context);
    }

    private final void init(Context context) {
        View.inflate(context, a.g.aiapps_games_loading_tips_view, this);
        this.dad = (TextView) findViewById(a.f.aiapps_games_loading_tips_message);
    }

    public final void se(String str) {
        String str2 = str;
        if (!(str2 == null || str2.length() == 0)) {
            TextView textView = this.dad;
            if (textView != null) {
                textView.setText(str);
            }
            setVisibility(8);
            if (this.dae != null) {
                ObjectAnimator objectAnimator = this.dae;
                if (objectAnimator != null) {
                    objectAnimator.removeAllListeners();
                }
                ObjectAnimator objectAnimator2 = this.dae;
                if (objectAnimator2 != null) {
                    objectAnimator2.cancel();
                }
            }
            this.dae = ObjectAnimator.ofFloat(this, "alpha", 0.0f, 1.0f);
            ObjectAnimator objectAnimator3 = this.dae;
            if (objectAnimator3 != null) {
                objectAnimator3.setDuration(500L);
            }
            ObjectAnimator objectAnimator4 = this.dae;
            if (objectAnimator4 != null) {
                objectAnimator4.setStartDelay(1000L);
            }
            ObjectAnimator objectAnimator5 = this.dae;
            if (objectAnimator5 != null) {
                objectAnimator5.addListener(new a());
            }
            ObjectAnimator objectAnimator6 = this.dae;
            if (objectAnimator6 != null) {
                objectAnimator6.start();
            }
        }
    }

    @h
    /* loaded from: classes11.dex */
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
            aj.c(SwanLoadingTipsView.this.dag, 2000L);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            SwanLoadingTipsView.this.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void aAV() {
        if (this.daf != null) {
            ObjectAnimator objectAnimator = this.daf;
            if (objectAnimator != null) {
                objectAnimator.removeAllListeners();
            }
            ObjectAnimator objectAnimator2 = this.daf;
            if (objectAnimator2 != null) {
                objectAnimator2.cancel();
            }
        }
        this.daf = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimator3 = this.daf;
        if (objectAnimator3 != null) {
            objectAnimator3.setDuration(500L);
        }
        ObjectAnimator objectAnimator4 = this.daf;
        if (objectAnimator4 != null) {
            objectAnimator4.addListener(new b());
        }
        ObjectAnimator objectAnimator5 = this.daf;
        if (objectAnimator5 != null) {
            objectAnimator5.start();
        }
    }

    @h
    /* loaded from: classes11.dex */
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
        this.dac = null;
        if (this.dag != null) {
            aj.o(this.dag);
        }
        if (this.dae != null) {
            ObjectAnimator objectAnimator = this.dae;
            if (objectAnimator != null) {
                objectAnimator.removeAllListeners();
            }
            ObjectAnimator objectAnimator2 = this.dae;
            if (objectAnimator2 != null) {
                objectAnimator2.cancel();
            }
            this.dae = null;
        }
        if (this.daf != null) {
            ObjectAnimator objectAnimator3 = this.daf;
            if (objectAnimator3 != null) {
                objectAnimator3.removeAllListeners();
            }
            ObjectAnimator objectAnimator4 = this.daf;
            if (objectAnimator4 != null) {
                objectAnimator4.cancel();
            }
            this.daf = null;
        }
    }
}
