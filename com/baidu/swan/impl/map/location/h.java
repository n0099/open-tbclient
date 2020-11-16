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
    private static final int ecS = ah.M(58.0f);
    private View ecO;
    private View ecP;
    private boolean ecQ;
    private a ecR;
    private View mListContainer;

    /* loaded from: classes24.dex */
    interface a {
        void hO(boolean z);

        void hP(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(View view, FrameLayout frameLayout, View view2) {
        this.mListContainer = view;
        this.ecO = frameLayout;
        this.ecP = view2;
    }

    public void hQ(final boolean z) {
        if (this.ecR != null) {
            this.ecR.hP(z);
        }
        this.ecQ = z;
        final int i = z ? -ecS : ecS;
        float[] fArr = z ? new float[]{0.0f, i} : new float[]{-i, 0.0f};
        float[] fArr2 = z ? new float[]{0.0f, i * 2} : new float[]{(-i) * 2, 0.0f};
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.ecO, "translationY", fArr), ObjectAnimator.ofFloat(this.mListContainer, "translationY", fArr2), ObjectAnimator.ofFloat(this.ecP, "translationY", fArr2));
        animatorSet.setDuration(200L);
        animatorSet.start();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.impl.map.location.h.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                animator.removeAllListeners();
                if (!z) {
                    h.this.mt(i);
                }
                if (h.this.ecR != null) {
                    h.this.ecR.hO(z);
                }
            }
        });
        if (z) {
            mt(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mt(int i) {
        ViewGroup.LayoutParams layoutParams = this.mListContainer.getLayoutParams();
        layoutParams.height = this.mListContainer.getHeight() - (i * 2);
        this.mListContainer.setLayoutParams(layoutParams);
    }

    public boolean isFlipped() {
        return this.ecQ;
    }
}
