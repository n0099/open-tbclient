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
    private static final int bpm = z.ad(58.0f);
    private View bpi;
    private View bpj;
    private boolean bpk;
    private a bpl;
    private View mListContainer;

    /* loaded from: classes5.dex */
    interface a {
        void da(boolean z);

        void db(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(View view, FrameLayout frameLayout, View view2) {
        this.mListContainer = view;
        this.bpi = frameLayout;
        this.bpj = view2;
    }

    public void dd(final boolean z) {
        if (this.bpl != null) {
            this.bpl.db(z);
        }
        this.bpk = z;
        final int i = z ? -bpm : bpm;
        float[] fArr = z ? new float[]{0.0f, i} : new float[]{-i, 0.0f};
        float[] fArr2 = z ? new float[]{0.0f, i * 2} : new float[]{(-i) * 2, 0.0f};
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.bpi, "translationY", fArr), ObjectAnimator.ofFloat(this.mListContainer, "translationY", fArr2), ObjectAnimator.ofFloat(this.bpj, "translationY", fArr2));
        animatorSet.setDuration(200L);
        animatorSet.start();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.impl.map.location.h.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                animator.removeAllListeners();
                if (!z) {
                    h.this.fs(i);
                }
                if (h.this.bpl != null) {
                    h.this.bpl.da(z);
                }
            }
        });
        if (z) {
            fs(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fs(int i) {
        ViewGroup.LayoutParams layoutParams = this.mListContainer.getLayoutParams();
        layoutParams.height = this.mListContainer.getHeight() - (i * 2);
        this.mListContainer.setLayoutParams(layoutParams);
    }

    public boolean Vc() {
        return this.bpk;
    }
}
