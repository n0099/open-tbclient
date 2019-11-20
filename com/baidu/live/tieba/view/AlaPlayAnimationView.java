package com.baidu.live.tieba.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes6.dex */
public class AlaPlayAnimationView extends ImageView {
    private ObjectAnimator aov;
    private boolean aow;
    private boolean aox;

    public AlaPlayAnimationView(Context context) {
        super(context);
        this.aow = false;
        this.aox = false;
        init();
    }

    public AlaPlayAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aow = false;
        this.aox = false;
        init();
    }

    private void init() {
        this.aov = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f, 1.0f);
        this.aov.setRepeatMode(1);
        this.aov.setRepeatCount(-1);
        this.aov.setDuration(700L);
        setVisibility(8);
        this.aow = false;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.aox) {
            startPlayAnimation();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        vy();
    }

    public void setAutoStartPlay(boolean z) {
        this.aox = z;
    }

    public void startPlayAnimation() {
        if (!this.aow) {
            this.aow = true;
            if (this.aov != null) {
                setVisibility(0);
                this.aov.start();
            }
        }
    }

    public void vy() {
        if (this.aov != null) {
            this.aov.setRepeatCount(-1);
            this.aov.cancel();
            clearAnimation();
        }
        this.aow = false;
        setVisibility(8);
    }
}
