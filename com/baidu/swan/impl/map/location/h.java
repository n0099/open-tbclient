package com.baidu.swan.impl.map.location;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.ap.ah;
/* loaded from: classes19.dex */
public class h {
    private static final int dCf = ah.H(58.0f);
    private View dCb;
    private View dCc;
    private boolean dCd;
    private a dCe;
    private View mListContainer;

    /* loaded from: classes19.dex */
    interface a {
        void gU(boolean z);

        void gV(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(View view, FrameLayout frameLayout, View view2) {
        this.mListContainer = view;
        this.dCb = frameLayout;
        this.dCc = view2;
    }

    public void gW(final boolean z) {
        if (this.dCe != null) {
            this.dCe.gV(z);
        }
        this.dCd = z;
        final int i = z ? -dCf : dCf;
        float[] fArr = z ? new float[]{0.0f, i} : new float[]{-i, 0.0f};
        float[] fArr2 = z ? new float[]{0.0f, i * 2} : new float[]{(-i) * 2, 0.0f};
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.dCb, "translationY", fArr), ObjectAnimator.ofFloat(this.mListContainer, "translationY", fArr2), ObjectAnimator.ofFloat(this.dCc, "translationY", fArr2));
        animatorSet.setDuration(200L);
        animatorSet.start();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.impl.map.location.h.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                animator.removeAllListeners();
                if (!z) {
                    h.this.lu(i);
                }
                if (h.this.dCe != null) {
                    h.this.dCe.gU(z);
                }
            }
        });
        if (z) {
            lu(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lu(int i) {
        ViewGroup.LayoutParams layoutParams = this.mListContainer.getLayoutParams();
        layoutParams.height = this.mListContainer.getHeight() - (i * 2);
        this.mListContainer.setLayoutParams(layoutParams);
    }

    public boolean isFlipped() {
        return this.dCd;
    }
}
