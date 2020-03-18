package com.baidu.swan.impl.map.location;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.as.af;
/* loaded from: classes12.dex */
public class h {
    private static final int cxv = af.S(58.0f);
    private View cxr;
    private View cxs;
    private boolean cxt;
    private a cxu;
    private View mListContainer;

    /* loaded from: classes12.dex */
    interface a {
        void eP(boolean z);

        void eQ(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(View view, FrameLayout frameLayout, View view2) {
        this.mListContainer = view;
        this.cxr = frameLayout;
        this.cxs = view2;
    }

    public void eR(final boolean z) {
        if (this.cxu != null) {
            this.cxu.eQ(z);
        }
        this.cxt = z;
        final int i = z ? -cxv : cxv;
        float[] fArr = z ? new float[]{0.0f, i} : new float[]{-i, 0.0f};
        float[] fArr2 = z ? new float[]{0.0f, i * 2} : new float[]{(-i) * 2, 0.0f};
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.cxr, "translationY", fArr), ObjectAnimator.ofFloat(this.mListContainer, "translationY", fArr2), ObjectAnimator.ofFloat(this.cxs, "translationY", fArr2));
        animatorSet.setDuration(200L);
        animatorSet.start();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.impl.map.location.h.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                animator.removeAllListeners();
                if (!z) {
                    h.this.ij(i);
                }
                if (h.this.cxu != null) {
                    h.this.cxu.eP(z);
                }
            }
        });
        if (z) {
            ij(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ij(int i) {
        ViewGroup.LayoutParams layoutParams = this.mListContainer.getLayoutParams();
        layoutParams.height = this.mListContainer.getHeight() - (i * 2);
        this.mListContainer.setLayoutParams(layoutParams);
    }

    public boolean isFlipped() {
        return this.cxt;
    }
}
