package com.baidu.swan.impl.map.location;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.as.af;
/* loaded from: classes10.dex */
public class h {
    private static final int ctg = af.S(58.0f);
    private View ctc;
    private View ctd;
    private boolean cte;
    private a ctf;
    private View mListContainer;

    /* loaded from: classes10.dex */
    interface a {
        void eH(boolean z);

        void eI(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(View view, FrameLayout frameLayout, View view2) {
        this.mListContainer = view;
        this.ctc = frameLayout;
        this.ctd = view2;
    }

    public void eJ(final boolean z) {
        if (this.ctf != null) {
            this.ctf.eI(z);
        }
        this.cte = z;
        final int i = z ? -ctg : ctg;
        float[] fArr = z ? new float[]{0.0f, i} : new float[]{-i, 0.0f};
        float[] fArr2 = z ? new float[]{0.0f, i * 2} : new float[]{(-i) * 2, 0.0f};
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.ctc, "translationY", fArr), ObjectAnimator.ofFloat(this.mListContainer, "translationY", fArr2), ObjectAnimator.ofFloat(this.ctd, "translationY", fArr2));
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
                if (h.this.ctf != null) {
                    h.this.ctf.eH(z);
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
        return this.cte;
    }
}
