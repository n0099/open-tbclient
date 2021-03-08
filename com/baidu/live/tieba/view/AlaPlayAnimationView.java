package com.baidu.live.tieba.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes10.dex */
public class AlaPlayAnimationView extends ImageView {
    private ObjectAnimator bLS;
    private boolean bLT;
    private boolean bLU;

    public AlaPlayAnimationView(Context context) {
        super(context);
        this.bLT = false;
        this.bLU = false;
        init();
    }

    public AlaPlayAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bLT = false;
        this.bLU = false;
        init();
    }

    private void init() {
        this.bLS = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f, 1.0f);
        this.bLS.setRepeatMode(1);
        this.bLS.setRepeatCount(-1);
        this.bLS.setDuration(700L);
        setVisibility(8);
        this.bLT = false;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.bLU) {
            startPlayAnimation();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Ui();
    }

    public void setAutoStartPlay(boolean z) {
        this.bLU = z;
    }

    public void startPlayAnimation() {
        if (!this.bLT) {
            this.bLT = true;
            if (this.bLS != null) {
                setVisibility(0);
                this.bLS.start();
            }
        }
    }

    public void Ui() {
        if (this.bLS != null) {
            this.bLS.setRepeatCount(-1);
            this.bLS.cancel();
            clearAnimation();
        }
        this.bLT = false;
        setVisibility(8);
    }
}
