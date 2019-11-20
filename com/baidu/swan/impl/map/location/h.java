package com.baidu.swan.impl.map.location;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.an.z;
/* loaded from: classes5.dex */
public class h {
    private static final int bHF = z.S(58.0f);
    private View bHB;
    private View bHC;
    private boolean bHD;
    private a bHE;
    private View mListContainer;

    /* loaded from: classes5.dex */
    interface a {
        void dr(boolean z);

        void ds(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(View view, FrameLayout frameLayout, View view2) {
        this.mListContainer = view;
        this.bHB = frameLayout;
        this.bHC = view2;
    }

    public void du(final boolean z) {
        if (this.bHE != null) {
            this.bHE.ds(z);
        }
        this.bHD = z;
        final int i = z ? -bHF : bHF;
        float[] fArr = z ? new float[]{0.0f, i} : new float[]{-i, 0.0f};
        float[] fArr2 = z ? new float[]{0.0f, i * 2} : new float[]{(-i) * 2, 0.0f};
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.bHB, "translationY", fArr), ObjectAnimator.ofFloat(this.mListContainer, "translationY", fArr2), ObjectAnimator.ofFloat(this.bHC, "translationY", fArr2));
        animatorSet.setDuration(200L);
        animatorSet.start();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.impl.map.location.h.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                animator.removeAllListeners();
                if (!z) {
                    h.this.gn(i);
                }
                if (h.this.bHE != null) {
                    h.this.bHE.dr(z);
                }
            }
        });
        if (z) {
            gn(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gn(int i) {
        ViewGroup.LayoutParams layoutParams = this.mListContainer.getLayoutParams();
        layoutParams.height = this.mListContainer.getHeight() - (i * 2);
        this.mListContainer.setLayoutParams(layoutParams);
    }

    public boolean ZT() {
        return this.bHD;
    }
}
