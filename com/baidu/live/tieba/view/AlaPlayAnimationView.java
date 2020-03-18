package com.baidu.live.tieba.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes3.dex */
public class AlaPlayAnimationView extends ImageView {
    private ObjectAnimator aBK;
    private boolean aBL;
    private boolean aBM;

    public AlaPlayAnimationView(Context context) {
        super(context);
        this.aBL = false;
        this.aBM = false;
        init();
    }

    public AlaPlayAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aBL = false;
        this.aBM = false;
        init();
    }

    private void init() {
        this.aBK = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f, 1.0f);
        this.aBK.setRepeatMode(1);
        this.aBK.setRepeatCount(-1);
        this.aBK.setDuration(700L);
        setVisibility(8);
        this.aBL = false;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.aBM) {
            startPlayAnimation();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Am();
    }

    public void setAutoStartPlay(boolean z) {
        this.aBM = z;
    }

    public void startPlayAnimation() {
        if (!this.aBL) {
            this.aBL = true;
            if (this.aBK != null) {
                setVisibility(0);
                this.aBK.start();
            }
        }
    }

    public void Am() {
        if (this.aBK != null) {
            this.aBK.setRepeatCount(-1);
            this.aBK.cancel();
            clearAnimation();
        }
        this.aBL = false;
        setVisibility(8);
    }
}
