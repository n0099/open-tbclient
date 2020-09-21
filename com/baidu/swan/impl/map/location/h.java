package com.baidu.swan.impl.map.location;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.ap.ah;
/* loaded from: classes24.dex */
public class h {
    private static final int dEk = ah.H(58.0f);
    private View dEg;
    private View dEh;
    private boolean dEi;
    private a dEj;
    private View mListContainer;

    /* loaded from: classes24.dex */
    interface a {
        void gT(boolean z);

        void gU(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(View view, FrameLayout frameLayout, View view2) {
        this.mListContainer = view;
        this.dEg = frameLayout;
        this.dEh = view2;
    }

    public void gV(final boolean z) {
        if (this.dEj != null) {
            this.dEj.gU(z);
        }
        this.dEi = z;
        final int i = z ? -dEk : dEk;
        float[] fArr = z ? new float[]{0.0f, i} : new float[]{-i, 0.0f};
        float[] fArr2 = z ? new float[]{0.0f, i * 2} : new float[]{(-i) * 2, 0.0f};
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.dEg, "translationY", fArr), ObjectAnimator.ofFloat(this.mListContainer, "translationY", fArr2), ObjectAnimator.ofFloat(this.dEh, "translationY", fArr2));
        animatorSet.setDuration(200L);
        animatorSet.start();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.impl.map.location.h.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                animator.removeAllListeners();
                if (!z) {
                    h.this.lF(i);
                }
                if (h.this.dEj != null) {
                    h.this.dEj.gT(z);
                }
            }
        });
        if (z) {
            lF(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lF(int i) {
        ViewGroup.LayoutParams layoutParams = this.mListContainer.getLayoutParams();
        layoutParams.height = this.mListContainer.getHeight() - (i * 2);
        this.mListContainer.setLayoutParams(layoutParams);
    }

    public boolean isFlipped() {
        return this.dEi;
    }
}
