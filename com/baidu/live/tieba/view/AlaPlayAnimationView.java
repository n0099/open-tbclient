package com.baidu.live.tieba.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes6.dex */
public class AlaPlayAnimationView extends ImageView {
    private ObjectAnimator aoN;
    private boolean aoO;
    private boolean aoP;

    public AlaPlayAnimationView(Context context) {
        super(context);
        this.aoO = false;
        this.aoP = false;
        init();
    }

    public AlaPlayAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aoO = false;
        this.aoP = false;
        init();
    }

    private void init() {
        this.aoN = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f, 1.0f);
        this.aoN.setRepeatMode(1);
        this.aoN.setRepeatCount(-1);
        this.aoN.setDuration(700L);
        setVisibility(8);
        this.aoO = false;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.aoP) {
            startPlayAnimation();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        vx();
    }

    public void setAutoStartPlay(boolean z) {
        this.aoP = z;
    }

    public void startPlayAnimation() {
        if (!this.aoO) {
            this.aoO = true;
            if (this.aoN != null) {
                setVisibility(0);
                this.aoN.start();
            }
        }
    }

    public void vx() {
        if (this.aoN != null) {
            this.aoN.setRepeatCount(-1);
            this.aoN.cancel();
            clearAnimation();
        }
        this.aoO = false;
        setVisibility(8);
    }
}
