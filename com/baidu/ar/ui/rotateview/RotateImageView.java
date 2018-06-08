package com.baidu.ar.ui.rotateview;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.baidu.ar.rotate.Orientation;
/* loaded from: classes3.dex */
public class RotateImageView extends ImageView implements IRotateView {
    private int a;
    private Animation b;

    public RotateImageView(Context context) {
        this(context, null, 0);
    }

    public RotateImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RotateImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 0;
    }

    @Override // android.view.View, com.baidu.ar.ui.rotateview.IRotateView
    public void clearAnimation() {
        if (this.b != null) {
            this.b.cancel();
            this.b.setAnimationListener(null);
            this.b = null;
        }
        super.clearAnimation();
    }

    @Override // com.baidu.ar.ui.rotateview.IRotateView
    public int getAngle() {
        return this.a;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.a == 0 || this.a == 360) {
            super.onDraw(canvas);
            return;
        }
        canvas.save();
        canvas.rotate(this.a, getWidth() * 0.5f, getHeight() * 0.5f);
        super.onDraw(canvas);
        canvas.restore();
    }

    @Override // com.baidu.ar.ui.rotateview.IRotateView
    public void requestOrientation(Orientation orientation) {
        RotateViewUtils.updateOrientation(this, orientation);
    }

    @Override // com.baidu.ar.ui.rotateview.IRotateView
    public void requestOrientation(Orientation orientation, boolean z) {
        RotateViewUtils.a(this, orientation, z);
    }

    @Override // com.baidu.ar.ui.rotateview.IRotateView
    public void setAngle(int i) {
        this.a = RotateViewUtils.a(i);
        invalidate();
    }

    @Override // android.view.View, com.baidu.ar.ui.rotateview.IRotateView
    public void startAnimation(Animation animation) {
        this.b = animation;
        super.startAnimation(animation);
    }
}
