package com.baidu.searchbox.ng.ai.apps.impl.map.location;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUIUtils;
/* loaded from: classes4.dex */
public class LocationViewFlipper {
    private static final int ANIMATION_DURATION = 200;
    private static final int SCROLL_DISTANCE = AiAppsUIUtils.dp2px(58.0f);
    private boolean mIsFlipped;
    private View mListContainer;
    private View mMapContainer;
    private View mMyLocationBtn;
    private OnFlipListener mOnFlipListener;

    /* loaded from: classes4.dex */
    interface OnFlipListener {
        void onFlipOver(boolean z);

        void onFlipStart(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocationViewFlipper(View view, FrameLayout frameLayout, View view2) {
        this.mListContainer = view;
        this.mMapContainer = frameLayout;
        this.mMyLocationBtn = view2;
    }

    public void scrollView(final boolean z) {
        if (this.mOnFlipListener != null) {
            this.mOnFlipListener.onFlipStart(z);
        }
        this.mIsFlipped = z;
        final int i = z ? -SCROLL_DISTANCE : SCROLL_DISTANCE;
        float[] fArr = z ? new float[]{0.0f, i} : new float[]{-i, 0.0f};
        float[] fArr2 = z ? new float[]{0.0f, i * 2} : new float[]{(-i) * 2, 0.0f};
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.mMapContainer, "translationY", fArr), ObjectAnimator.ofFloat(this.mListContainer, "translationY", fArr2), ObjectAnimator.ofFloat(this.mMyLocationBtn, "translationY", fArr2));
        animatorSet.setDuration(200L);
        animatorSet.start();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.searchbox.ng.ai.apps.impl.map.location.LocationViewFlipper.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                animator.removeAllListeners();
                if (!z) {
                    LocationViewFlipper.this.adjustListContainerHeight(i);
                }
                if (LocationViewFlipper.this.mOnFlipListener != null) {
                    LocationViewFlipper.this.mOnFlipListener.onFlipOver(z);
                }
            }
        });
        if (z) {
            adjustListContainerHeight(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adjustListContainerHeight(int i) {
        ViewGroup.LayoutParams layoutParams = this.mListContainer.getLayoutParams();
        layoutParams.height = this.mListContainer.getHeight() - (i * 2);
        this.mListContainer.setLayoutParams(layoutParams);
    }

    public boolean isFlipped() {
        return this.mIsFlipped;
    }

    public void setOnFlipListener(OnFlipListener onFlipListener) {
        this.mOnFlipListener = onFlipListener;
    }
}
