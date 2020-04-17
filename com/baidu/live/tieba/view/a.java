package com.baidu.live.tieba.view;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;
/* loaded from: classes3.dex */
public class a extends Animation {
    private float aVF;
    private float aVG;
    private final float aVH;
    private Camera mCamera;
    private final float mFromDegrees;
    private final boolean mReverse;
    private final float mToDegrees;

    public a(float f, float f2, float f3, boolean z) {
        this.mFromDegrees = f;
        this.mToDegrees = f2;
        this.aVH = f3;
        this.mReverse = z;
    }

    @Override // android.view.animation.Animation
    public void initialize(int i, int i2, int i3, int i4) {
        super.initialize(i, i2, i3, i4);
        this.aVF = i / 2;
        this.aVG = i / 2;
        this.mCamera = new Camera();
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        float f2 = this.mFromDegrees;
        float f3 = f2 + ((this.mToDegrees - f2) * f);
        float f4 = this.aVF;
        float f5 = this.aVG;
        Camera camera = this.mCamera;
        Matrix matrix = transformation.getMatrix();
        camera.save();
        if (this.mReverse) {
            camera.translate(0.0f, 0.0f, this.aVH * f);
        } else {
            camera.translate(0.0f, 0.0f, this.aVH * (1.0f - f));
        }
        camera.rotateY(f3);
        camera.getMatrix(matrix);
        camera.restore();
        matrix.preTranslate(-f4, -f5);
        matrix.postTranslate(f4, f5);
    }
}
