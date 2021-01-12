package com.baidu.swan.impl.map.location;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.ao.ah;
/* loaded from: classes8.dex */
public class d {
    private static final int eok = ah.O(58.0f);
    private View eog;
    private View eoh;
    private boolean eoi;
    private a eoj;
    private View mListContainer;

    /* loaded from: classes8.dex */
    interface a {
        void ir(boolean z);

        void is(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(View view, FrameLayout frameLayout, View view2) {
        this.mListContainer = view;
        this.eog = frameLayout;
        this.eoh = view2;
    }

    public void iu(final boolean z) {
        if (this.eoj != null) {
            this.eoj.is(z);
        }
        this.eoi = z;
        final int i = z ? -eok : eok;
        float[] fArr = z ? new float[]{0.0f, i} : new float[]{-i, 0.0f};
        float[] fArr2 = z ? new float[]{0.0f, i * 2} : new float[]{(-i) * 2, 0.0f};
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.eog, "translationY", fArr), ObjectAnimator.ofFloat(this.mListContainer, "translationY", fArr2), ObjectAnimator.ofFloat(this.eoh, "translationY", fArr2));
        animatorSet.setDuration(200L);
        animatorSet.start();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.impl.map.location.d.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                animator.removeAllListeners();
                if (!z) {
                    d.this.lt(i);
                }
                if (d.this.eoj != null) {
                    d.this.eoj.ir(z);
                }
            }
        });
        if (z) {
            lt(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lt(int i) {
        ViewGroup.LayoutParams layoutParams = this.mListContainer.getLayoutParams();
        layoutParams.height = this.mListContainer.getHeight() - (i * 2);
        this.mListContainer.setLayoutParams(layoutParams);
    }

    public boolean baQ() {
        return this.eoi;
    }
}
