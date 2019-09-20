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
    private static final int bpK = z.ad(58.0f);
    private View bpG;
    private View bpH;
    private boolean bpI;
    private a bpJ;
    private View mListContainer;

    /* loaded from: classes5.dex */
    interface a {
        void da(boolean z);

        void db(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(View view, FrameLayout frameLayout, View view2) {
        this.mListContainer = view;
        this.bpG = frameLayout;
        this.bpH = view2;
    }

    public void dd(final boolean z) {
        if (this.bpJ != null) {
            this.bpJ.db(z);
        }
        this.bpI = z;
        final int i = z ? -bpK : bpK;
        float[] fArr = z ? new float[]{0.0f, i} : new float[]{-i, 0.0f};
        float[] fArr2 = z ? new float[]{0.0f, i * 2} : new float[]{(-i) * 2, 0.0f};
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.bpG, "translationY", fArr), ObjectAnimator.ofFloat(this.mListContainer, "translationY", fArr2), ObjectAnimator.ofFloat(this.bpH, "translationY", fArr2));
        animatorSet.setDuration(200L);
        animatorSet.start();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.impl.map.location.h.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                animator.removeAllListeners();
                if (!z) {
                    h.this.ft(i);
                }
                if (h.this.bpJ != null) {
                    h.this.bpJ.da(z);
                }
            }
        });
        if (z) {
            ft(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ft(int i) {
        ViewGroup.LayoutParams layoutParams = this.mListContainer.getLayoutParams();
        layoutParams.height = this.mListContainer.getHeight() - (i * 2);
        this.mListContainer.setLayoutParams(layoutParams);
    }

    public boolean Vg() {
        return this.bpI;
    }
}
