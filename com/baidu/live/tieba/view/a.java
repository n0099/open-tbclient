package com.baidu.live.tieba.view;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;
/* loaded from: classes2.dex */
public class a extends Animation {
    private final float awG;
    private final float awH;
    private float awI;
    private float awJ;
    private final float awK;
    private Camera awL;
    private final boolean mReverse;

    public a(float f, float f2, float f3, boolean z) {
        this.awG = f;
        this.awH = f2;
        this.awK = f3;
        this.mReverse = z;
    }

    @Override // android.view.animation.Animation
    public void initialize(int i, int i2, int i3, int i4) {
        super.initialize(i, i2, i3, i4);
        this.awI = i / 2;
        this.awJ = i / 2;
        this.awL = new Camera();
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        float f2 = this.awG;
        float f3 = f2 + ((this.awH - f2) * f);
        float f4 = this.awI;
        float f5 = this.awJ;
        Camera camera = this.awL;
        Matrix matrix = transformation.getMatrix();
        camera.save();
        if (this.mReverse) {
            camera.translate(0.0f, 0.0f, this.awK * f);
        } else {
            camera.translate(0.0f, 0.0f, this.awK * (1.0f - f));
        }
        camera.rotateY(f3);
        camera.getMatrix(matrix);
        camera.restore();
        matrix.preTranslate(-f4, -f5);
        matrix.postTranslate(f4, f5);
    }
}
