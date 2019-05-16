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
    private static final int boz = z.ad(58.0f);
    private View bov;
    private View bow;
    private boolean box;
    private a boy;
    private View mListContainer;

    /* loaded from: classes5.dex */
    interface a {
        void cX(boolean z);

        void cY(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(View view, FrameLayout frameLayout, View view2) {
        this.mListContainer = view;
        this.bov = frameLayout;
        this.bow = view2;
    }

    public void da(final boolean z) {
        if (this.boy != null) {
            this.boy.cY(z);
        }
        this.box = z;
        final int i = z ? -boz : boz;
        float[] fArr = z ? new float[]{0.0f, i} : new float[]{-i, 0.0f};
        float[] fArr2 = z ? new float[]{0.0f, i * 2} : new float[]{(-i) * 2, 0.0f};
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.bov, "translationY", fArr), ObjectAnimator.ofFloat(this.mListContainer, "translationY", fArr2), ObjectAnimator.ofFloat(this.bow, "translationY", fArr2));
        animatorSet.setDuration(200L);
        animatorSet.start();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.impl.map.location.h.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                animator.removeAllListeners();
                if (!z) {
                    h.this.fo(i);
                }
                if (h.this.boy != null) {
                    h.this.boy.cX(z);
                }
            }
        });
        if (z) {
            fo(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fo(int i) {
        ViewGroup.LayoutParams layoutParams = this.mListContainer.getLayoutParams();
        layoutParams.height = this.mListContainer.getHeight() - (i * 2);
        this.mListContainer.setLayoutParams(layoutParams);
    }

    public boolean Uk() {
        return this.box;
    }
}
