package com.baidu.adp.newwidget.animation;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.adp.R;
import java.lang.ref.SoftReference;
/* loaded from: classes.dex */
public class CircleRippleView extends FrameLayout {
    private AnimationSet[] mAnimationSetList;
    private Drawable mCircleImage;
    private int mCircleSize;
    private ImageView[] mImageViewList;
    private SoftReference<Bitmap> mRippleBitmapSoftRef;

    public CircleRippleView(Context context) {
        super(context);
        this.mRippleBitmapSoftRef = null;
        this.mImageViewList = null;
        this.mAnimationSetList = null;
        this.mCircleSize = 200;
        this.mCircleImage = null;
        init(context, null);
    }

    public CircleRippleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRippleBitmapSoftRef = null;
        this.mImageViewList = null;
        this.mAnimationSetList = null;
        this.mCircleSize = 200;
        this.mCircleImage = null;
        init(context, attributeSet);
    }

    public CircleRippleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRippleBitmapSoftRef = null;
        this.mImageViewList = null;
        this.mAnimationSetList = null;
        this.mCircleSize = 200;
        this.mCircleImage = null;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CircleRippleView);
            this.mCircleSize = obtainStyledAttributes.getDimensionPixelSize(0, 200);
            this.mCircleImage = obtainStyledAttributes.getDrawable(1);
            obtainStyledAttributes.recycle();
        }
        this.mImageViewList = new ImageView[3];
        this.mImageViewList[0] = newImageView(context);
        this.mImageViewList[1] = newImageView(context);
        this.mImageViewList[2] = newImageView(context);
        this.mAnimationSetList = new AnimationSet[3];
        this.mAnimationSetList[0] = newAnimationSet(0, this.mImageViewList[0]);
        this.mAnimationSetList[1] = newAnimationSet(1, this.mImageViewList[1]);
        this.mAnimationSetList[2] = newAnimationSet(2, this.mImageViewList[2]);
    }

    private ImageView newImageView(Context context) {
        ImageView imageView = new ImageView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mCircleSize, this.mCircleSize);
        layoutParams.gravity = 17;
        addView(imageView, layoutParams);
        return imageView;
    }

    private AnimationSet newAnimationSet(int i, ImageView imageView) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.6f, 1.0f, 1.6f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setRepeatCount(-1);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f, 0.0f);
        alphaAnimation.setRepeatCount(-1);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setRepeatCount(-1);
        animationSet.setDuration(1950L);
        animationSet.setFillEnabled(true);
        animationSet.setFillBefore(true);
        animationSet.setStartOffset(650 * i);
        animationSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animationSet.setAnimationListener(new a(this, imageView));
        return animationSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements Animation.AnimationListener {
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
}
