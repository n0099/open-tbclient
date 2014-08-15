package com.baidu.adp.newwidget.animation;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.adp.g;
import com.baidu.lightapp.plugin.videoplayer.coreplayer.Constants;
import java.lang.ref.SoftReference;
/* loaded from: classes.dex */
public class CircleRippleView extends FrameLayout {
    private SoftReference<Bitmap> a;
    private ImageView[] b;
    private AnimationSet[] c;
    private int d;
    private Drawable e;

    public CircleRippleView(Context context) {
        super(context);
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = Constants.MEDIA_INFO;
        this.e = null;
        a(context, (AttributeSet) null);
    }

    public CircleRippleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = Constants.MEDIA_INFO;
        this.e = null;
        a(context, attributeSet);
    }

    public CircleRippleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = Constants.MEDIA_INFO;
        this.e = null;
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.CircleRippleView);
            this.d = obtainStyledAttributes.getDimensionPixelSize(0, Constants.MEDIA_INFO);
            this.e = obtainStyledAttributes.getDrawable(1);
            obtainStyledAttributes.recycle();
        }
        this.b = new ImageView[3];
        this.b[0] = a(context);
        this.b[1] = a(context);
        this.b[2] = a(context);
        this.c = new AnimationSet[3];
        this.c[0] = a(0, this.b[0]);
        this.c[1] = a(1, this.b[1]);
        this.c[2] = a(2, this.b[2]);
    }

    private ImageView a(Context context) {
        ImageView imageView = new ImageView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.d, this.d);
        layoutParams.gravity = 17;
        addView(imageView, layoutParams);
        return imageView;
    }

    private AnimationSet a(int i, ImageView imageView) {
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

    public void a() {
        if (this.a == null) {
            c();
            if (this.a == null) {
                return;
            }
        }
        Bitmap bitmap = this.a.get();
        if (bitmap != null) {
            for (int i = 0; i < this.b.length; i++) {
                this.b[i].setImageBitmap(bitmap);
                this.b[i].setVisibility(0);
                this.b[i].setAnimation(this.c[i]);
                this.b[i].startAnimation(this.c[i]);
            }
        }
    }

    public void b() {
        for (int i = 0; i < this.b.length; i++) {
            this.b[i].setImageDrawable(null);
            this.b[i].setVisibility(8);
            this.b[i].clearAnimation();
            if (this.a != null) {
                this.a = null;
            }
        }
    }

    private void c() {
        if (this.e != null && (this.e instanceof BitmapDrawable)) {
            this.a = new SoftReference<>(((BitmapDrawable) this.e).getBitmap());
        }
    }
}
