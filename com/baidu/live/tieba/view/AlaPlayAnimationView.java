package com.baidu.live.tieba.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes4.dex */
public class AlaPlayAnimationView extends ImageView {
    private ObjectAnimator bwZ;
    private boolean bxa;
    private boolean bxb;

    public AlaPlayAnimationView(Context context) {
        super(context);
        this.bxa = false;
        this.bxb = false;
        init();
    }

    public AlaPlayAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bxa = false;
        this.bxb = false;
        init();
    }

    private void init() {
        this.bwZ = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f, 1.0f);
        this.bwZ.setRepeatMode(1);
        this.bwZ.setRepeatCount(-1);
        this.bwZ.setDuration(700L);
        setVisibility(8);
        this.bxa = false;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.bxb) {
            startPlayAnimation();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        QP();
    }

    public void setAutoStartPlay(boolean z) {
        this.bxb = z;
    }

    public void startPlayAnimation() {
        if (!this.bxa) {
            this.bxa = true;
            if (this.bwZ != null) {
                setVisibility(0);
                this.bwZ.start();
            }
        }
    }

    public void QP() {
        if (this.bwZ != null) {
            this.bwZ.setRepeatCount(-1);
            this.bwZ.cancel();
            clearAnimation();
        }
        this.bxa = false;
        setVisibility(8);
    }
}
