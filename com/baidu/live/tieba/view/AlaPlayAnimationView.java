package com.baidu.live.tieba.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes11.dex */
public class AlaPlayAnimationView extends ImageView {
    private ObjectAnimator bLu;
    private boolean bLv;
    private boolean bLw;

    public AlaPlayAnimationView(Context context) {
        super(context);
        this.bLv = false;
        this.bLw = false;
        init();
    }

    public AlaPlayAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bLv = false;
        this.bLw = false;
        init();
    }

    private void init() {
        this.bLu = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f, 1.0f);
        this.bLu.setRepeatMode(1);
        this.bLu.setRepeatCount(-1);
        this.bLu.setDuration(700L);
        setVisibility(8);
        this.bLv = false;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.bLw) {
            startPlayAnimation();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Wr();
    }

    public void setAutoStartPlay(boolean z) {
        this.bLw = z;
    }

    public void startPlayAnimation() {
        if (!this.bLv) {
            this.bLv = true;
            if (this.bLu != null) {
                setVisibility(0);
                this.bLu.start();
            }
        }
    }

    public void Wr() {
        if (this.bLu != null) {
            this.bLu.setRepeatCount(-1);
            this.bLu.cancel();
            clearAnimation();
        }
        this.bLv = false;
        setVisibility(8);
    }
}
