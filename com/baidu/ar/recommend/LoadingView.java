package com.baidu.ar.recommend;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
/* loaded from: classes3.dex */
public class LoadingView extends ImageView {
    private ValueAnimator a;

    public LoadingView(Context context) {
        super(context);
        a();
    }

    public LoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    private void a() {
        this.a = ValueAnimator.ofFloat(0.0f, 360.0f);
        this.a.setDuration(3000L);
        this.a.setInterpolator(new LinearInterpolator());
        this.a.setRepeatCount(-1);
        this.a.setRepeatMode(1);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.a == null) {
            super.draw(canvas);
            return;
        }
        canvas.save();
        canvas.rotate(((Float) this.a.getAnimatedValue()).floatValue(), getWidth() / 2, getHeight() / 2);
        super.draw(canvas);
        canvas.restore();
        if (isShown()) {
            postInvalidate();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.a != null) {
            this.a.cancel();
        }
    }

    public void setValueAnimator(ValueAnimator valueAnimator) {
        this.a = valueAnimator;
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i) {
        if (getVisibility() != i && this.a != null) {
            if (i == 0) {
                this.a.start();
            } else {
                this.a.cancel();
            }
        }
        super.setVisibility(i);
    }
}
