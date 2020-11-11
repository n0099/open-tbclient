package com.baidu.swan.impl.map.location;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.ap.ah;
/* loaded from: classes25.dex */
public class h {
    private static final int eez = ah.N(58.0f);
    private View eev;
    private View eew;
    private boolean eex;
    private a eey;
    private View mListContainer;

    /* loaded from: classes25.dex */
    interface a {
        void hL(boolean z);

        void hM(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(View view, FrameLayout frameLayout, View view2) {
        this.mListContainer = view;
        this.eev = frameLayout;
        this.eew = view2;
    }

    public void hN(final boolean z) {
        if (this.eey != null) {
            this.eey.hM(z);
        }
        this.eex = z;
        final int i = z ? -eez : eez;
        float[] fArr = z ? new float[]{0.0f, i} : new float[]{-i, 0.0f};
        float[] fArr2 = z ? new float[]{0.0f, i * 2} : new float[]{(-i) * 2, 0.0f};
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.eev, "translationY", fArr), ObjectAnimator.ofFloat(this.mListContainer, "translationY", fArr2), ObjectAnimator.ofFloat(this.eew, "translationY", fArr2));
        animatorSet.setDuration(200L);
        animatorSet.start();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.impl.map.location.h.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                animator.removeAllListeners();
                if (!z) {
                    h.this.mx(i);
                }
                if (h.this.eey != null) {
                    h.this.eey.hL(z);
                }
            }
        });
        if (z) {
            mx(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mx(int i) {
        ViewGroup.LayoutParams layoutParams = this.mListContainer.getLayoutParams();
        layoutParams.height = this.mListContainer.getHeight() - (i * 2);
        this.mListContainer.setLayoutParams(layoutParams);
    }

    public boolean isFlipped() {
        return this.eex;
    }
}
