package com.baidu.live.tieba.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes4.dex */
public class AlaPlayAnimationView extends ImageView {
    private boolean bBA;
    private boolean bBB;
    private ObjectAnimator bBz;

    public AlaPlayAnimationView(Context context) {
        super(context);
        this.bBA = false;
        this.bBB = false;
        init();
    }

    public AlaPlayAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bBA = false;
        this.bBB = false;
        init();
    }

    private void init() {
        this.bBz = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f, 1.0f);
        this.bBz.setRepeatMode(1);
        this.bBz.setRepeatCount(-1);
        this.bBz.setDuration(700L);
        setVisibility(8);
        this.bBA = false;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.bBB) {
            startPlayAnimation();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SO();
    }

    public void setAutoStartPlay(boolean z) {
        this.bBB = z;
    }

    public void startPlayAnimation() {
        if (!this.bBA) {
            this.bBA = true;
            if (this.bBz != null) {
                setVisibility(0);
                this.bBz.start();
            }
        }
    }

    public void SO() {
        if (this.bBz != null) {
            this.bBz.setRepeatCount(-1);
            this.bBz.cancel();
            clearAnimation();
        }
        this.bBA = false;
        setVisibility(8);
    }
}
