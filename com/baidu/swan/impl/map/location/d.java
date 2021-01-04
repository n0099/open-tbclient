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
    private static final int esX = ah.O(58.0f);
    private View esT;
    private View esU;
    private boolean esV;
    private a esW;
    private View mListContainer;

    /* loaded from: classes9.dex */
    interface a {
        void iv(boolean z);

        void iw(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(View view, FrameLayout frameLayout, View view2) {
        this.mListContainer = view;
        this.esT = frameLayout;
        this.esU = view2;
    }

    public void iy(final boolean z) {
        if (this.esW != null) {
            this.esW.iw(z);
        }
        this.esV = z;
        final int i = z ? -esX : esX;
        float[] fArr = z ? new float[]{0.0f, i} : new float[]{-i, 0.0f};
        float[] fArr2 = z ? new float[]{0.0f, i * 2} : new float[]{(-i) * 2, 0.0f};
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.esT, "translationY", fArr), ObjectAnimator.ofFloat(this.mListContainer, "translationY", fArr2), ObjectAnimator.ofFloat(this.esU, "translationY", fArr2));
        animatorSet.setDuration(200L);
        animatorSet.start();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.impl.map.location.d.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                animator.removeAllListeners();
                if (!z) {
                    d.this.mZ(i);
                }
                if (d.this.esW != null) {
                    d.this.esW.iv(z);
                }
            }
        });
        if (z) {
            mZ(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mZ(int i) {
        ViewGroup.LayoutParams layoutParams = this.mListContainer.getLayoutParams();
        layoutParams.height = this.mListContainer.getHeight() - (i * 2);
        this.mListContainer.setLayoutParams(layoutParams);
    }

    public boolean beJ() {
        return this.esV;
    }
}
