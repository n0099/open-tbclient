package com.baidu.live.tieba.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes4.dex */
public class AlaPlayAnimationView extends ImageView {
    private ObjectAnimator bqX;
    private boolean bqY;
    private boolean bqZ;

    public AlaPlayAnimationView(Context context) {
        super(context);
        this.bqY = false;
        this.bqZ = false;
        init();
    }

    public AlaPlayAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bqY = false;
        this.bqZ = false;
        init();
    }

    private void init() {
        this.bqX = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f, 1.0f);
        this.bqX.setRepeatMode(1);
        this.bqX.setRepeatCount(-1);
        this.bqX.setDuration(700L);
        setVisibility(8);
        this.bqY = false;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.bqZ) {
            startPlayAnimation();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        OP();
    }

    public void setAutoStartPlay(boolean z) {
        this.bqZ = z;
    }

    public void startPlayAnimation() {
        if (!this.bqY) {
            this.bqY = true;
            if (this.bqX != null) {
                setVisibility(0);
                this.bqX.start();
            }
        }
    }

    public void OP() {
        if (this.bqX != null) {
            this.bqX.setRepeatCount(-1);
            this.bqX.cancel();
            clearAnimation();
        }
        this.bqY = false;
        setVisibility(8);
    }
}
