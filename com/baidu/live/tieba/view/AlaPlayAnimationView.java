package com.baidu.live.tieba.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes4.dex */
public class AlaPlayAnimationView extends ImageView {
    private ObjectAnimator buL;
    private boolean buM;
    private boolean buN;

    public AlaPlayAnimationView(Context context) {
        super(context);
        this.buM = false;
        this.buN = false;
        init();
    }

    public AlaPlayAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.buM = false;
        this.buN = false;
        init();
    }

    private void init() {
        this.buL = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f, 1.0f);
        this.buL.setRepeatMode(1);
        this.buL.setRepeatCount(-1);
        this.buL.setDuration(700L);
        setVisibility(8);
        this.buM = false;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.buN) {
            startPlayAnimation();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        PU();
    }

    public void setAutoStartPlay(boolean z) {
        this.buN = z;
    }

    public void startPlayAnimation() {
        if (!this.buM) {
            this.buM = true;
            if (this.buL != null) {
                setVisibility(0);
                this.buL.start();
            }
        }
    }

    public void PU() {
        if (this.buL != null) {
            this.buL.setRepeatCount(-1);
            this.buL.cancel();
            clearAnimation();
        }
        this.buM = false;
        setVisibility(8);
    }
}
