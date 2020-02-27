package com.baidu.live.tieba.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes3.dex */
public class AlaPlayAnimationView extends ImageView {
    private ObjectAnimator aBu;
    private boolean aBv;
    private boolean aBw;

    public AlaPlayAnimationView(Context context) {
        super(context);
        this.aBv = false;
        this.aBw = false;
        init();
    }

    public AlaPlayAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aBv = false;
        this.aBw = false;
        init();
    }

    private void init() {
        this.aBu = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f, 1.0f);
        this.aBu.setRepeatMode(1);
        this.aBu.setRepeatCount(-1);
        this.aBu.setDuration(700L);
        setVisibility(8);
        this.aBv = false;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.aBw) {
            startPlayAnimation();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Ad();
    }

    public void setAutoStartPlay(boolean z) {
        this.aBw = z;
    }

    public void startPlayAnimation() {
        if (!this.aBv) {
            this.aBv = true;
            if (this.aBu != null) {
                setVisibility(0);
                this.aBu.start();
            }
        }
    }

    public void Ad() {
        if (this.aBu != null) {
            this.aBu.setRepeatCount(-1);
            this.aBu.cancel();
            clearAnimation();
        }
        this.aBv = false;
        setVisibility(8);
    }
}
