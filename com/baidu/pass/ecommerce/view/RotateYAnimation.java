package com.baidu.pass.ecommerce.view;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
/* loaded from: classes2.dex */
public class RotateYAnimation extends Animation {
    public Camera camera = new Camera();
    public int centerX;
    public int centerY;

    @Override // android.view.animation.Animation
    public void applyTransformation(float f2, Transformation transformation) {
        Matrix matrix = transformation.getMatrix();
        this.camera.save();
        this.camera.rotateY(f2 * 360.0f);
        this.camera.getMatrix(matrix);
        matrix.preTranslate(-this.centerX, -this.centerY);
        matrix.postTranslate(this.centerX, this.centerY);
        this.camera.restore();
    }

    @Override // android.view.animation.Animation
    public void initialize(int i2, int i3, int i4, int i5) {
        super.initialize(i2, i3, i4, i5);
        int i6 = i2 / 2;
        this.centerX = i6;
        this.centerY = i6;
        setDuration(3000L);
        setInterpolator(new DecelerateInterpolator());
    }
}
