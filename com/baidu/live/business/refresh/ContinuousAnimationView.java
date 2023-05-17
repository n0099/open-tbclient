package com.baidu.live.business.refresh;

import android.animation.Animator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.live.business.refresh.BdSwipeRefreshLayout;
/* loaded from: classes3.dex */
public class ContinuousAnimationView extends LottieAnimationView implements BdSwipeRefreshLayout.h {
    public boolean a;
    public boolean b;

    @Override // com.baidu.live.business.refresh.BdSwipeRefreshLayout.h
    public void c(float f, float f2) {
    }

    @Override // com.baidu.live.business.refresh.BdSwipeRefreshLayout.h
    public void d() {
    }

    @Override // com.baidu.live.business.refresh.BdSwipeRefreshLayout.h
    public void e() {
    }

    @Override // com.baidu.live.business.refresh.BdSwipeRefreshLayout.h
    public long getCompleteAnimTime() {
        return 0L;
    }

    @Override // com.baidu.live.business.refresh.BdSwipeRefreshLayout.h
    public View getView() {
        return null;
    }

    @Override // com.baidu.live.business.refresh.BdSwipeRefreshLayout.h
    public void onFinish() {
    }

    public final void u() {
    }

    public final void x() {
    }

    public final void y() {
    }

    public final void z() {
    }

    /* loaded from: classes3.dex */
    public class a implements Animator.AnimatorListener {
        public a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            ContinuousAnimationView.this.u();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ContinuousAnimationView.this.x();
            if (ContinuousAnimationView.this.b) {
                ContinuousAnimationView.this.b = false;
            }
            ContinuousAnimationView.this.a = false;
            ContinuousAnimationView.this.setFrame(0);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            ContinuousAnimationView.this.y();
            if (ContinuousAnimationView.this.b) {
                ContinuousAnimationView.this.cancelAnimation();
                ContinuousAnimationView.this.b = false;
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            ContinuousAnimationView.this.z();
            ContinuousAnimationView.this.a = true;
        }
    }

    public ContinuousAnimationView(Context context) {
        this(context, null);
    }

    public ContinuousAnimationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ContinuousAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = false;
        this.b = false;
        init();
    }

    @Override // com.baidu.live.business.refresh.BdSwipeRefreshLayout.h
    public void a() {
        if (isAnimating()) {
            cancelAnimation();
        }
    }

    @Override // com.baidu.live.business.refresh.BdSwipeRefreshLayout.h
    public void b() {
        playAnimation();
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void cancelAnimation() {
        super.cancelAnimation();
    }

    @Override // android.view.View
    public void clearAnimation() {
        super.clearAnimation();
    }

    public final void init() {
        addAnimatorListener(new a());
        loop(true);
        setFrame(0);
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void pauseAnimation() {
        if (this.a) {
            this.b = true;
        }
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void playAnimation() {
        if (isAnimating()) {
            cancelAnimation();
        }
        setAlpha(1.0f);
        super.playAnimation();
    }
}
