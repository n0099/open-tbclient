package com.baidu.swan.impl.map.location;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.ao.ah;
/* loaded from: classes8.dex */
public class d {
    private static final int erS = ah.T(58.0f);
    private View erO;
    private View erP;
    private boolean erQ;
    private a erR;
    private View mListContainer;

    /* loaded from: classes8.dex */
    interface a {
        void it(boolean z);

        void iu(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(View view, FrameLayout frameLayout, View view2) {
        this.mListContainer = view;
        this.erO = frameLayout;
        this.erP = view2;
    }

    public void iw(final boolean z) {
        if (this.erR != null) {
            this.erR.iu(z);
        }
        this.erQ = z;
        final int i = z ? -erS : erS;
        float[] fArr = z ? new float[]{0.0f, i} : new float[]{-i, 0.0f};
        float[] fArr2 = z ? new float[]{0.0f, i * 2} : new float[]{(-i) * 2, 0.0f};
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.erO, "translationY", fArr), ObjectAnimator.ofFloat(this.mListContainer, "translationY", fArr2), ObjectAnimator.ofFloat(this.erP, "translationY", fArr2));
        animatorSet.setDuration(200L);
        animatorSet.start();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.impl.map.location.d.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                animator.removeAllListeners();
                if (!z) {
                    d.this.lx(i);
                }
                if (d.this.erR != null) {
                    d.this.erR.it(z);
                }
            }
        });
        if (z) {
            lx(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lx(int i) {
        ViewGroup.LayoutParams layoutParams = this.mListContainer.getLayoutParams();
        layoutParams.height = this.mListContainer.getHeight() - (i * 2);
        this.mListContainer.setLayoutParams(layoutParams);
    }

    public boolean isFlipped() {
        return this.erQ;
    }
}
