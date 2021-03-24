package com.baidu.adp.widget.refresh;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.view.animation.Animation;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import androidx.swiperefreshlayout.widget.CircleImageView;
/* loaded from: classes.dex */
public class BdCircleImageView extends ImageView {

    /* renamed from: e  reason: collision with root package name */
    public Animation.AnimationListener f2438e;

    /* renamed from: f  reason: collision with root package name */
    public int f2439f;

    /* loaded from: classes.dex */
    public class a extends OvalShape {

        /* renamed from: e  reason: collision with root package name */
        public RadialGradient f2440e;

        /* renamed from: f  reason: collision with root package name */
        public Paint f2441f = new Paint();

        public a(int i) {
            BdCircleImageView.this.f2439f = i;
            a((int) rect().width());
        }

        public final void a(int i) {
            float f2 = i / 2;
            RadialGradient radialGradient = new RadialGradient(f2, f2, BdCircleImageView.this.f2439f, new int[]{CircleImageView.FILL_SHADOW_COLOR, 0}, (float[]) null, Shader.TileMode.CLAMP);
            this.f2440e = radialGradient;
            this.f2441f.setShader(radialGradient);
        }

        @Override // android.graphics.drawable.shapes.OvalShape, android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        public void draw(Canvas canvas, Paint paint) {
            int width;
            float width2 = BdCircleImageView.this.getWidth() / 2;
            float height = BdCircleImageView.this.getHeight() / 2;
            canvas.drawCircle(width2, height, width2, this.f2441f);
            canvas.drawCircle(width2, height, width - BdCircleImageView.this.f2439f, paint);
        }

        @Override // android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        public void onResize(float f2, float f3) {
            super.onResize(f2, f3);
            a((int) f2);
        }
    }

    public BdCircleImageView(Context context, int i) {
        super(context);
        ShapeDrawable shapeDrawable;
        float f2 = getContext().getResources().getDisplayMetrics().density;
        int i2 = (int) (1.75f * f2);
        int i3 = (int) (0.0f * f2);
        this.f2439f = (int) (3.5f * f2);
        if (a()) {
            shapeDrawable = new ShapeDrawable(new OvalShape());
            ViewCompat.setElevation(this, f2 * 4.0f);
        } else {
            ShapeDrawable shapeDrawable2 = new ShapeDrawable(new a(this.f2439f));
            ViewCompat.setLayerType(this, 1, shapeDrawable2.getPaint());
            shapeDrawable2.getPaint().setShadowLayer(this.f2439f, i3, i2, CircleImageView.KEY_SHADOW_COLOR);
            int i4 = this.f2439f;
            setPadding(i4, i4, i4, i4);
            shapeDrawable = shapeDrawable2;
        }
        shapeDrawable.getPaint().setColor(i);
        setBackgroundDrawable(shapeDrawable);
    }

    public final boolean a() {
        return Build.VERSION.SDK_INT >= 21;
    }

    @Override // android.view.View
    public void onAnimationEnd() {
        super.onAnimationEnd();
        Animation.AnimationListener animationListener = this.f2438e;
        if (animationListener != null) {
            animationListener.onAnimationEnd(getAnimation());
        }
    }

    @Override // android.view.View
    public void onAnimationStart() {
        super.onAnimationStart();
        Animation.AnimationListener animationListener = this.f2438e;
        if (animationListener != null) {
            animationListener.onAnimationStart(getAnimation());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (a()) {
            return;
        }
        setMeasuredDimension(getMeasuredWidth() + (this.f2439f * 2), getMeasuredHeight() + (this.f2439f * 2));
    }

    public void setAnimationListener(Animation.AnimationListener animationListener) {
        this.f2438e = animationListener;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i);
        }
    }

    public void setBackgroundColorRes(int i) {
        setBackgroundColor(getContext().getResources().getColor(i));
    }
}
