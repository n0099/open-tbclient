package com.baidu.swan.impl.map.location;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.an.x;
/* loaded from: classes5.dex */
public class h {
    private static final int bis = x.ad(58.0f);
    private View bio;
    private View bip;
    private boolean biq;
    private a bir;
    private View mListContainer;

    /* loaded from: classes5.dex */
    interface a {
        void cG(boolean z);

        void cH(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(View view, FrameLayout frameLayout, View view2) {
        this.mListContainer = view;
        this.bio = frameLayout;
        this.bip = view2;
    }

    public void cJ(final boolean z) {
        if (this.bir != null) {
            this.bir.cH(z);
        }
        this.biq = z;
        final int i = z ? -bis : bis;
        float[] fArr = z ? new float[]{0.0f, i} : new float[]{-i, 0.0f};
        float[] fArr2 = z ? new float[]{0.0f, i * 2} : new float[]{(-i) * 2, 0.0f};
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.bio, "translationY", fArr), ObjectAnimator.ofFloat(this.mListContainer, "translationY", fArr2), ObjectAnimator.ofFloat(this.bip, "translationY", fArr2));
        animatorSet.setDuration(200L);
        animatorSet.start();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.impl.map.location.h.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                animator.removeAllListeners();
                if (!z) {
                    h.this.eQ(i);
                }
                if (h.this.bir != null) {
                    h.this.bir.cG(z);
                }
            }
        });
        if (z) {
            eQ(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eQ(int i) {
        ViewGroup.LayoutParams layoutParams = this.mListContainer.getLayoutParams();
        layoutParams.height = this.mListContainer.getHeight() - (i * 2);
        this.mListContainer.setLayoutParams(layoutParams);
    }

    public boolean QA() {
        return this.biq;
    }
}
