package com.baidu.swan.impl.map.location;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.ap.ah;
/* loaded from: classes25.dex */
public class h {
    private static final int ejT = ah.M(58.0f);
    private View ejP;
    private View ejQ;
    private boolean ejR;
    private a ejS;
    private View mListContainer;

    /* loaded from: classes25.dex */
    interface a {
        void id(boolean z);

        void ie(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(View view, FrameLayout frameLayout, View view2) {
        this.mListContainer = view;
        this.ejP = frameLayout;
        this.ejQ = view2;
    }

    /* renamed from: if  reason: not valid java name */
    public void m34if(final boolean z) {
        if (this.ejS != null) {
            this.ejS.ie(z);
        }
        this.ejR = z;
        final int i = z ? -ejT : ejT;
        float[] fArr = z ? new float[]{0.0f, i} : new float[]{-i, 0.0f};
        float[] fArr2 = z ? new float[]{0.0f, i * 2} : new float[]{(-i) * 2, 0.0f};
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.ejP, "translationY", fArr), ObjectAnimator.ofFloat(this.mListContainer, "translationY", fArr2), ObjectAnimator.ofFloat(this.ejQ, "translationY", fArr2));
        animatorSet.setDuration(200L);
        animatorSet.start();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.impl.map.location.h.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                animator.removeAllListeners();
                if (!z) {
                    h.this.mR(i);
                }
                if (h.this.ejS != null) {
                    h.this.ejS.id(z);
                }
            }
        });
        if (z) {
            mR(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mR(int i) {
        ViewGroup.LayoutParams layoutParams = this.mListContainer.getLayoutParams();
        layoutParams.height = this.mListContainer.getHeight() - (i * 2);
        this.mListContainer.setLayoutParams(layoutParams);
    }

    public boolean isFlipped() {
        return this.ejR;
    }
}
