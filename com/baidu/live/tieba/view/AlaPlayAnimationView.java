package com.baidu.live.tieba.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes3.dex */
public class AlaPlayAnimationView extends ImageView {
    private ObjectAnimator aVw;
    private boolean aVx;
    private boolean aVy;

    public AlaPlayAnimationView(Context context) {
        super(context);
        this.aVx = false;
        this.aVy = false;
        init();
    }

    public AlaPlayAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aVx = false;
        this.aVy = false;
        init();
    }

    private void init() {
        this.aVw = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f, 1.0f);
        this.aVw.setRepeatMode(1);
        this.aVw.setRepeatCount(-1);
        this.aVw.setDuration(700L);
        setVisibility(8);
        this.aVx = false;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.aVy) {
            startPlayAnimation();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Fj();
    }

    public void setAutoStartPlay(boolean z) {
        this.aVy = z;
    }

    public void startPlayAnimation() {
        if (!this.aVx) {
            this.aVx = true;
            if (this.aVw != null) {
                setVisibility(0);
                this.aVw.start();
            }
        }
    }

    public void Fj() {
        if (this.aVw != null) {
            this.aVw.setRepeatCount(-1);
            this.aVw.cancel();
            clearAnimation();
        }
        this.aVx = false;
        setVisibility(8);
    }
}
