package com.baidu.swan.impl.map.location;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.aq.ag;
/* loaded from: classes12.dex */
public class h {
    private static final int dhx = ag.B(58.0f);
    private View dht;
    private View dhu;
    private boolean dhv;
    private a dhw;
    private View mListContainer;

    /* loaded from: classes12.dex */
    interface a {
        void fX(boolean z);

        void fY(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(View view, FrameLayout frameLayout, View view2) {
        this.mListContainer = view;
        this.dht = frameLayout;
        this.dhu = view2;
    }

    public void fZ(final boolean z) {
        if (this.dhw != null) {
            this.dhw.fY(z);
        }
        this.dhv = z;
        final int i = z ? -dhx : dhx;
        float[] fArr = z ? new float[]{0.0f, i} : new float[]{-i, 0.0f};
        float[] fArr2 = z ? new float[]{0.0f, i * 2} : new float[]{(-i) * 2, 0.0f};
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.dht, "translationY", fArr), ObjectAnimator.ofFloat(this.mListContainer, "translationY", fArr2), ObjectAnimator.ofFloat(this.dhu, "translationY", fArr2));
        animatorSet.setDuration(200L);
        animatorSet.start();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.impl.map.location.h.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                animator.removeAllListeners();
                if (!z) {
                    h.this.iH(i);
                }
                if (h.this.dhw != null) {
                    h.this.dhw.fX(z);
                }
            }
        });
        if (z) {
            iH(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iH(int i) {
        ViewGroup.LayoutParams layoutParams = this.mListContainer.getLayoutParams();
        layoutParams.height = this.mListContainer.getHeight() - (i * 2);
        this.mListContainer.setLayoutParams(layoutParams);
    }

    public boolean isFlipped() {
        return this.dhv;
    }
}
