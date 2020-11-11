package com.baidu.live.tieba.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes4.dex */
public class AlaPlayAnimationView extends ImageView {
    private ObjectAnimator bDk;
    private boolean bDl;
    private boolean bDm;

    public AlaPlayAnimationView(Context context) {
        super(context);
        this.bDl = false;
        this.bDm = false;
        init();
    }

    public AlaPlayAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bDl = false;
        this.bDm = false;
        init();
    }

    private void init() {
        this.bDk = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f, 1.0f);
        this.bDk.setRepeatMode(1);
        this.bDk.setRepeatCount(-1);
        this.bDk.setDuration(700L);
        setVisibility(8);
        this.bDl = false;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.bDm) {
            startPlayAnimation();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Tx();
    }

    public void setAutoStartPlay(boolean z) {
        this.bDm = z;
    }

    public void startPlayAnimation() {
        if (!this.bDl) {
            this.bDl = true;
            if (this.bDk != null) {
                setVisibility(0);
                this.bDk.start();
            }
        }
    }

    public void Tx() {
        if (this.bDk != null) {
            this.bDk.setRepeatCount(-1);
            this.bDk.cancel();
            clearAnimation();
        }
        this.bDl = false;
        setVisibility(8);
    }
}
