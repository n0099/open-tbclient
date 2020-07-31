package com.baidu.swan.impl.map.location;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.aq.ai;
/* loaded from: classes19.dex */
public class h {
    private static final int dse = ai.D(58.0f);
    private View dsa;
    private View dsb;
    private boolean dsc;
    private a dsd;
    private View mListContainer;

    /* loaded from: classes19.dex */
    interface a {
        void gy(boolean z);

        void gz(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(View view, FrameLayout frameLayout, View view2) {
        this.mListContainer = view;
        this.dsa = frameLayout;
        this.dsb = view2;
    }

    public void gA(final boolean z) {
        if (this.dsd != null) {
            this.dsd.gz(z);
        }
        this.dsc = z;
        final int i = z ? -dse : dse;
        float[] fArr = z ? new float[]{0.0f, i} : new float[]{-i, 0.0f};
        float[] fArr2 = z ? new float[]{0.0f, i * 2} : new float[]{(-i) * 2, 0.0f};
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.dsa, "translationY", fArr), ObjectAnimator.ofFloat(this.mListContainer, "translationY", fArr2), ObjectAnimator.ofFloat(this.dsb, "translationY", fArr2));
        animatorSet.setDuration(200L);
        animatorSet.start();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.impl.map.location.h.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                animator.removeAllListeners();
                if (!z) {
                    h.this.jl(i);
                }
                if (h.this.dsd != null) {
                    h.this.dsd.gy(z);
                }
            }
        });
        if (z) {
            jl(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jl(int i) {
        ViewGroup.LayoutParams layoutParams = this.mListContainer.getLayoutParams();
        layoutParams.height = this.mListContainer.getHeight() - (i * 2);
        this.mListContainer.setLayoutParams(layoutParams);
    }

    public boolean isFlipped() {
        return this.dsc;
    }
}
