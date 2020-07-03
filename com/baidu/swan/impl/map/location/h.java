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
    private static final int dmj = ag.D(58.0f);
    private View dmf;
    private View dmg;
    private boolean dmh;
    private a dmi;
    private View mListContainer;

    /* loaded from: classes12.dex */
    interface a {
        void gc(boolean z);

        void gd(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(View view, FrameLayout frameLayout, View view2) {
        this.mListContainer = view;
        this.dmf = frameLayout;
        this.dmg = view2;
    }

    public void ge(final boolean z) {
        if (this.dmi != null) {
            this.dmi.gd(z);
        }
        this.dmh = z;
        final int i = z ? -dmj : dmj;
        float[] fArr = z ? new float[]{0.0f, i} : new float[]{-i, 0.0f};
        float[] fArr2 = z ? new float[]{0.0f, i * 2} : new float[]{(-i) * 2, 0.0f};
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.dmf, "translationY", fArr), ObjectAnimator.ofFloat(this.mListContainer, "translationY", fArr2), ObjectAnimator.ofFloat(this.dmg, "translationY", fArr2));
        animatorSet.setDuration(200L);
        animatorSet.start();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.impl.map.location.h.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                animator.removeAllListeners();
                if (!z) {
                    h.this.iU(i);
                }
                if (h.this.dmi != null) {
                    h.this.dmi.gc(z);
                }
            }
        });
        if (z) {
            iU(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iU(int i) {
        ViewGroup.LayoutParams layoutParams = this.mListContainer.getLayoutParams();
        layoutParams.height = this.mListContainer.getHeight() - (i * 2);
        this.mListContainer.setLayoutParams(layoutParams);
    }

    public boolean isFlipped() {
        return this.dmh;
    }
}
