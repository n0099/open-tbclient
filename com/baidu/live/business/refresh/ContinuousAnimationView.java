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

    public final void animationCancel() {
    }

    public final void animationEnd() {
    }

    public final void animationRepeat() {
    }

    public final void animationStart() {
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
    public void onCompleteRefresh() {
    }

    @Override // com.baidu.live.business.refresh.BdSwipeRefreshLayout.h
    public void onFinish() {
    }

    @Override // com.baidu.live.business.refresh.BdSwipeRefreshLayout.h
    public void onPullPercentChange(float f, float f2) {
    }

    @Override // com.baidu.live.business.refresh.BdSwipeRefreshLayout.h
    public void onRefreshing() {
    }

    /* loaded from: classes3.dex */
    public class a implements Animator.AnimatorListener {
        public a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            ContinuousAnimationView.this.animationCancel();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ContinuousAnimationView.this.animationEnd();
            if (ContinuousAnimationView.this.b) {
                ContinuousAnimationView.this.b = false;
            }
            ContinuousAnimationView.this.a = false;
            ContinuousAnimationView.this.setFrame(0);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            ContinuousAnimationView.this.animationRepeat();
            if (ContinuousAnimationView.this.b) {
                ContinuousAnimationView.this.cancelAnimation();
                ContinuousAnimationView.this.b = false;
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            ContinuousAnimationView.this.animationStart();
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

    @Override // com.baidu.live.business.refresh.BdSwipeRefreshLayout.h
    public void onPullToRefresh() {
        if (isAnimating()) {
            cancelAnimation();
        }
    }

    @Override // com.baidu.live.business.refresh.BdSwipeRefreshLayout.h
    public void onReleaseToRefresh() {
        playAnimation();
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
