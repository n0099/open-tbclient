package com.baidu.live.tieba.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes3.dex */
public class AlaPlayAnimationView extends ImageView {
    private ObjectAnimator aBv;
    private boolean aBw;
    private boolean aBx;

    public AlaPlayAnimationView(Context context) {
        super(context);
        this.aBw = false;
        this.aBx = false;
        init();
    }

    public AlaPlayAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aBw = false;
        this.aBx = false;
        init();
    }

    private void init() {
        this.aBv = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f, 1.0f);
        this.aBv.setRepeatMode(1);
        this.aBv.setRepeatCount(-1);
        this.aBv.setDuration(700L);
        setVisibility(8);
        this.aBw = false;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.aBx) {
            startPlayAnimation();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Af();
    }

    public void setAutoStartPlay(boolean z) {
        this.aBx = z;
    }

    public void startPlayAnimation() {
        if (!this.aBw) {
            this.aBw = true;
            if (this.aBv != null) {
                setVisibility(0);
                this.aBv.start();
            }
        }
    }

    public void Af() {
        if (this.aBv != null) {
            this.aBv.setRepeatCount(-1);
            this.aBv.cancel();
            clearAnimation();
        }
        this.aBw = false;
        setVisibility(8);
    }
}
