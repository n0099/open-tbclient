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
    private static final int cxj = af.S(58.0f);
    private View cxf;
    private View cxg;
    private boolean cxh;
    private a cxi;
    private View mListContainer;

    /* loaded from: classes12.dex */
    interface a {
        void eO(boolean z);

        void eP(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(View view, FrameLayout frameLayout, View view2) {
        this.mListContainer = view;
        this.cxf = frameLayout;
        this.cxg = view2;
    }

    public void eQ(final boolean z) {
        if (this.cxi != null) {
            this.cxi.eP(z);
        }
        this.cxh = z;
        final int i = z ? -cxj : cxj;
        float[] fArr = z ? new float[]{0.0f, i} : new float[]{-i, 0.0f};
        float[] fArr2 = z ? new float[]{0.0f, i * 2} : new float[]{(-i) * 2, 0.0f};
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.cxf, "translationY", fArr), ObjectAnimator.ofFloat(this.mListContainer, "translationY", fArr2), ObjectAnimator.ofFloat(this.cxg, "translationY", fArr2));
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
                if (h.this.cxi != null) {
                    h.this.cxi.eO(z);
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
        return this.cxh;
    }
}
