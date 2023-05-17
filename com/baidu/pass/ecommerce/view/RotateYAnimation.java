package com.baidu.pass.ecommerce.view;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
/* loaded from: classes3.dex */
public class RotateYAnimation extends Animation {
    public Camera camera = new Camera();
    public int centerX;
    public int centerY;

    @Override // android.view.animation.Animation
    public void applyTransformation(float f, Transformation transformation) {
        Matrix matrix = transformation.getMatrix();
        this.camera.save();
        this.camera.rotateY(f * 360.0f);
        this.camera.getMatrix(matrix);
        matrix.preTranslate(-this.centerX, -this.centerY);
        matrix.postTranslate(this.centerX, this.centerY);
        this.camera.restore();
    }

    @Override // android.view.animation.Animation
    public void initialize(int i, int i2, int i3, int i4) {
        super.initialize(i, i2, i3, i4);
        int i5 = i / 2;
        this.centerX = i5;
        this.centerY = i5;
        setDuration(3000L);
        setInterpolator(new DecelerateInterpolator());
    }
}
