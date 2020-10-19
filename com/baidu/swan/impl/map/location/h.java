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
    private static final int dQl = ah.J(58.0f);
    private View dQh;
    private View dQi;
    private boolean dQj;
    private a dQk;
    private View mListContainer;

    /* loaded from: classes25.dex */
    interface a {
        void hp(boolean z);

        void hq(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(View view, FrameLayout frameLayout, View view2) {
        this.mListContainer = view;
        this.dQh = frameLayout;
        this.dQi = view2;
    }

    public void hr(final boolean z) {
        if (this.dQk != null) {
            this.dQk.hq(z);
        }
        this.dQj = z;
        final int i = z ? -dQl : dQl;
        float[] fArr = z ? new float[]{0.0f, i} : new float[]{-i, 0.0f};
        float[] fArr2 = z ? new float[]{0.0f, i * 2} : new float[]{(-i) * 2, 0.0f};
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.dQh, "translationY", fArr), ObjectAnimator.ofFloat(this.mListContainer, "translationY", fArr2), ObjectAnimator.ofFloat(this.dQi, "translationY", fArr2));
        animatorSet.setDuration(200L);
        animatorSet.start();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.impl.map.location.h.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                animator.removeAllListeners();
                if (!z) {
                    h.this.mc(i);
                }
                if (h.this.dQk != null) {
                    h.this.dQk.hp(z);
                }
            }
        });
        if (z) {
            mc(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mc(int i) {
        ViewGroup.LayoutParams layoutParams = this.mListContainer.getLayoutParams();
        layoutParams.height = this.mListContainer.getHeight() - (i * 2);
        this.mListContainer.setLayoutParams(layoutParams);
    }

    public boolean isFlipped() {
        return this.dQj;
    }
}
