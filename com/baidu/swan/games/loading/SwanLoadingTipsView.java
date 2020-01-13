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
import kotlin.jvm.internal.q;
import kotlin.k;
@SuppressLint({"SwanCommentErr"})
/* loaded from: classes10.dex */
public final class SwanLoadingTipsView extends RelativeLayout {
    private kotlin.jvm.a.a<k> clT;
    private TextView clU;
    private ObjectAnimator clV;
    private ObjectAnimator clW;
    private Runnable clX;

    public final kotlin.jvm.a.a<k> getTipsAnimationFinishCallback() {
        return this.clT;
    }

    public final void setTipsAnimationFinishCallback(kotlin.jvm.a.a<k> aVar) {
        this.clT = aVar;
    }

    /* loaded from: classes10.dex */
    static final class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            SwanLoadingTipsView.this.amz();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanLoadingTipsView(Context context) {
        super(context);
        q.j(context, "context");
        this.clX = new c();
        init(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanLoadingTipsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        q.j(context, "context");
        q.j(attributeSet, "attrs");
        this.clX = new c();
        init(context);
    }

    private final void init(Context context) {
        View.inflate(context, a.g.aiapps_games_loading_tips_view, this);
        this.clU = (TextView) findViewById(a.f.aiapps_games_loading_tips_message);
    }

    public final void pa(String str) {
        String str2 = str;
        if (!(str2 == null || str2.length() == 0)) {
            TextView textView = this.clU;
            if (textView != null) {
                textView.setText(str);
            }
            setVisibility(8);
            if (this.clV != null) {
                ObjectAnimator objectAnimator = this.clV;
                if (objectAnimator != null) {
                    objectAnimator.removeAllListeners();
                }
                ObjectAnimator objectAnimator2 = this.clV;
                if (objectAnimator2 != null) {
                    objectAnimator2.cancel();
                }
            }
            this.clV = ObjectAnimator.ofFloat(this, "alpha", 0.0f, 1.0f);
            ObjectAnimator objectAnimator3 = this.clV;
            if (objectAnimator3 != null) {
                objectAnimator3.setDuration(500L);
            }
            ObjectAnimator objectAnimator4 = this.clV;
            if (objectAnimator4 != null) {
                objectAnimator4.setStartDelay(1000L);
            }
            ObjectAnimator objectAnimator5 = this.clV;
            if (objectAnimator5 != null) {
                objectAnimator5.addListener(new a());
            }
            ObjectAnimator objectAnimator6 = this.clV;
            if (objectAnimator6 != null) {
                objectAnimator6.start();
            }
        }
    }

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
            ai.b(SwanLoadingTipsView.this.clX, 2000L);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            SwanLoadingTipsView.this.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void amz() {
        if (this.clW != null) {
            ObjectAnimator objectAnimator = this.clW;
            if (objectAnimator != null) {
                objectAnimator.removeAllListeners();
            }
            ObjectAnimator objectAnimator2 = this.clW;
            if (objectAnimator2 != null) {
                objectAnimator2.cancel();
            }
        }
        this.clW = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimator3 = this.clW;
        if (objectAnimator3 != null) {
            objectAnimator3.setDuration(500L);
        }
        ObjectAnimator objectAnimator4 = this.clW;
        if (objectAnimator4 != null) {
            objectAnimator4.addListener(new b());
        }
        ObjectAnimator objectAnimator5 = this.clW;
        if (objectAnimator5 != null) {
            objectAnimator5.start();
        }
    }

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
            kotlin.jvm.a.a<k> tipsAnimationFinishCallback = SwanLoadingTipsView.this.getTipsAnimationFinishCallback();
            if (tipsAnimationFinishCallback != null) {
                tipsAnimationFinishCallback.invoke();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public final void doDestroy() {
        this.clT = null;
        if (this.clX != null) {
            ai.k(this.clX);
        }
        if (this.clV != null) {
            ObjectAnimator objectAnimator = this.clV;
            if (objectAnimator != null) {
                objectAnimator.removeAllListeners();
            }
            ObjectAnimator objectAnimator2 = this.clV;
            if (objectAnimator2 != null) {
                objectAnimator2.cancel();
            }
            this.clV = null;
        }
        if (this.clW != null) {
            ObjectAnimator objectAnimator3 = this.clW;
            if (objectAnimator3 != null) {
                objectAnimator3.removeAllListeners();
            }
            ObjectAnimator objectAnimator4 = this.clW;
            if (objectAnimator4 != null) {
                objectAnimator4.cancel();
            }
            this.clW = null;
        }
    }
}
