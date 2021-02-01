package com.baidu.swan.impl.map.location;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.ao.ah;
/* loaded from: classes9.dex */
public class d {
    private static final int eqq = ah.P(58.0f);
    private View eqm;
    private View eqn;
    private boolean eqo;
    private a eqp;
    private View mListContainer;

    /* loaded from: classes9.dex */
    interface a {
        void it(boolean z);

        void iu(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(View view, FrameLayout frameLayout, View view2) {
        this.mListContainer = view;
        this.eqm = frameLayout;
        this.eqn = view2;
    }

    public void iw(final boolean z) {
        if (this.eqp != null) {
            this.eqp.iu(z);
        }
        this.eqo = z;
        final int i = z ? -eqq : eqq;
        float[] fArr = z ? new float[]{0.0f, i} : new float[]{-i, 0.0f};
        float[] fArr2 = z ? new float[]{0.0f, i * 2} : new float[]{(-i) * 2, 0.0f};
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.eqm, "translationY", fArr), ObjectAnimator.ofFloat(this.mListContainer, "translationY", fArr2), ObjectAnimator.ofFloat(this.eqn, "translationY", fArr2));
        animatorSet.setDuration(200L);
        animatorSet.start();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.impl.map.location.d.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                animator.removeAllListeners();
                if (!z) {
                    d.this.lw(i);
                }
                if (d.this.eqp != null) {
                    d.this.eqp.it(z);
                }
            }
        });
        if (z) {
            lw(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lw(int i) {
        ViewGroup.LayoutParams layoutParams = this.mListContainer.getLayoutParams();
        layoutParams.height = this.mListContainer.getHeight() - (i * 2);
        this.mListContainer.setLayoutParams(layoutParams);
    }

    public boolean bbd() {
        return this.eqo;
    }
}
