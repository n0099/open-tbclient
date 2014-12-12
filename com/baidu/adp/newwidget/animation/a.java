package com.baidu.adp.newwidget.animation;

import android.view.animation.Animation;
import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements Animation.AnimationListener {
    private ImageView mImageView;

    public a(CircleRippleView circleRippleView, ImageView imageView) {
        this.mImageView = imageView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.mImageView.setVisibility(8);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
        animation.setStartOffset(0L);
    }
}
