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
    private static final int dCj = ah.H(58.0f);
    private View dCf;
    private View dCg;
    private boolean dCh;
    private a dCi;
    private View mListContainer;

    /* loaded from: classes19.dex */
    interface a {
        void gV(boolean z);

        void gW(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(View view, FrameLayout frameLayout, View view2) {
        this.mListContainer = view;
        this.dCf = frameLayout;
        this.dCg = view2;
    }

    public void gX(final boolean z) {
        if (this.dCi != null) {
            this.dCi.gW(z);
        }
        this.dCh = z;
        final int i = z ? -dCj : dCj;
        float[] fArr = z ? new float[]{0.0f, i} : new float[]{-i, 0.0f};
        float[] fArr2 = z ? new float[]{0.0f, i * 2} : new float[]{(-i) * 2, 0.0f};
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.dCf, "translationY", fArr), ObjectAnimator.ofFloat(this.mListContainer, "translationY", fArr2), ObjectAnimator.ofFloat(this.dCg, "translationY", fArr2));
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
                if (h.this.dCi != null) {
                    h.this.dCi.gV(z);
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
        return this.dCh;
    }
}
