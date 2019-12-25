package com.baidu.swan.impl.map.location;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.as.af;
/* loaded from: classes9.dex */
public class h {
    private static final int csV = af.T(58.0f);
    private View csR;
    private View csS;
    private boolean csT;
    private a csU;
    private View mListContainer;

    /* loaded from: classes9.dex */
    interface a {
        void eC(boolean z);

        void eD(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(View view, FrameLayout frameLayout, View view2) {
        this.mListContainer = view;
        this.csR = frameLayout;
        this.csS = view2;
    }

    public void eE(final boolean z) {
        if (this.csU != null) {
            this.csU.eD(z);
        }
        this.csT = z;
        final int i = z ? -csV : csV;
        float[] fArr = z ? new float[]{0.0f, i} : new float[]{-i, 0.0f};
        float[] fArr2 = z ? new float[]{0.0f, i * 2} : new float[]{(-i) * 2, 0.0f};
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.csR, "translationY", fArr), ObjectAnimator.ofFloat(this.mListContainer, "translationY", fArr2), ObjectAnimator.ofFloat(this.csS, "translationY", fArr2));
        animatorSet.setDuration(200L);
        animatorSet.start();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.impl.map.location.h.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                animator.removeAllListeners();
                if (!z) {
                    h.this.hS(i);
                }
                if (h.this.csU != null) {
                    h.this.csU.eC(z);
                }
            }
        });
        if (z) {
            hS(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hS(int i) {
        ViewGroup.LayoutParams layoutParams = this.mListContainer.getLayoutParams();
        layoutParams.height = this.mListContainer.getHeight() - (i * 2);
        this.mListContainer.setLayoutParams(layoutParams);
    }

    public boolean isFlipped() {
        return this.csT;
    }
}
