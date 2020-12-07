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
import kotlin.e;
import kotlin.h;
import kotlin.jvm.internal.p;
@SuppressLint({"SwanCommentErr"})
@e
/* loaded from: classes25.dex */
public final class SwanLoadingTipsView extends RelativeLayout {
    private kotlin.jvm.a.a<h> ecs;
    private TextView ect;
    private ObjectAnimator ecu;
    private ObjectAnimator ecv;
    private Runnable ecw;

    public final kotlin.jvm.a.a<h> getTipsAnimationFinishCallback() {
        return this.ecs;
    }

    public final void setTipsAnimationFinishCallback(kotlin.jvm.a.a<h> aVar) {
        this.ecs = aVar;
    }

    @e
    /* loaded from: classes25.dex */
    static final class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            SwanLoadingTipsView.this.aYK();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanLoadingTipsView(Context context) {
        super(context);
        p.o(context, "context");
        this.ecw = new c();
        init(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanLoadingTipsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.o(context, "context");
        p.o(attributeSet, "attrs");
        this.ecw = new c();
        init(context);
    }

    private final void init(Context context) {
        View.inflate(context, a.g.aiapps_games_loading_tips_view, this);
        this.ect = (TextView) findViewById(a.f.aiapps_games_loading_tips_message);
    }

    public final void xQ(String str) {
        String str2 = str;
        if (!(str2 == null || str2.length() == 0)) {
            TextView textView = this.ect;
            if (textView != null) {
                textView.setText(str);
            }
            setVisibility(8);
            if (this.ecu != null) {
                ObjectAnimator objectAnimator = this.ecu;
                if (objectAnimator != null) {
                    objectAnimator.removeAllListeners();
                }
                ObjectAnimator objectAnimator2 = this.ecu;
                if (objectAnimator2 != null) {
                    objectAnimator2.cancel();
                }
            }
            this.ecu = ObjectAnimator.ofFloat(this, "alpha", 0.0f, 1.0f);
            ObjectAnimator objectAnimator3 = this.ecu;
            if (objectAnimator3 != null) {
                objectAnimator3.setDuration(500L);
            }
            ObjectAnimator objectAnimator4 = this.ecu;
            if (objectAnimator4 != null) {
                objectAnimator4.setStartDelay(1000L);
            }
            ObjectAnimator objectAnimator5 = this.ecu;
            if (objectAnimator5 != null) {
                objectAnimator5.addListener(new a());
            }
            ObjectAnimator objectAnimator6 = this.ecu;
            if (objectAnimator6 != null) {
                objectAnimator6.start();
            }
        }
    }

    @e
    /* loaded from: classes25.dex */
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
            ak.c(SwanLoadingTipsView.this.ecw, 2000L);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            SwanLoadingTipsView.this.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void aYK() {
        if (this.ecv != null) {
            ObjectAnimator objectAnimator = this.ecv;
            if (objectAnimator != null) {
                objectAnimator.removeAllListeners();
            }
            ObjectAnimator objectAnimator2 = this.ecv;
            if (objectAnimator2 != null) {
                objectAnimator2.cancel();
            }
        }
        this.ecv = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimator3 = this.ecv;
        if (objectAnimator3 != null) {
            objectAnimator3.setDuration(500L);
        }
        ObjectAnimator objectAnimator4 = this.ecv;
        if (objectAnimator4 != null) {
            objectAnimator4.addListener(new b());
        }
        ObjectAnimator objectAnimator5 = this.ecv;
        if (objectAnimator5 != null) {
            objectAnimator5.start();
        }
    }

    @e
    /* loaded from: classes25.dex */
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
        this.ecs = null;
        if (this.ecw != null) {
            ak.l(this.ecw);
        }
        if (this.ecu != null) {
            ObjectAnimator objectAnimator = this.ecu;
            if (objectAnimator != null) {
                objectAnimator.removeAllListeners();
            }
            ObjectAnimator objectAnimator2 = this.ecu;
            if (objectAnimator2 != null) {
                objectAnimator2.cancel();
            }
            this.ecu = null;
        }
        if (this.ecv != null) {
            ObjectAnimator objectAnimator3 = this.ecv;
            if (objectAnimator3 != null) {
                objectAnimator3.removeAllListeners();
            }
            ObjectAnimator objectAnimator4 = this.ecv;
            if (objectAnimator4 != null) {
                objectAnimator4.cancel();
            }
            this.ecv = null;
        }
    }
}
