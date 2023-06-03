package com.baidu.searchbox.ui;

import android.annotation.SuppressLint;
import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.baidu.android.util.devices.DeviceUtil;
/* loaded from: classes4.dex */
public class Flip3dAnimation extends Animation {
    public Camera mCamera;
    public final float mCenterX;
    public final float mCenterY;
    public final float mDepthZ;
    public final float mFromDegrees;
    public final boolean mReverse;
    public final boolean mRotateByX;
    public final float mToDegrees;

    public Flip3dAnimation(float f, float f2, float f3, float f4, float f5, boolean z, boolean z2) {
        this.mFromDegrees = f;
        this.mToDegrees = f2;
        this.mCenterX = f3;
        this.mCenterY = f4;
        this.mDepthZ = f5;
        this.mReverse = z;
        this.mRotateByX = z2;
    }

    @Override // android.view.animation.Animation
    public void applyTransformation(float f, Transformation transformation) {
        float f2 = this.mFromDegrees;
        float f3 = f2 + ((this.mToDegrees - f2) * f);
        float f4 = this.mCenterX;
        float f5 = this.mCenterY;
        Camera camera = this.mCamera;
        Matrix matrix = transformation.getMatrix();
        camera.save();
        camera.translate(0.0f, 0.0f, (float) (this.mCenterX * Math.abs(Math.sin(Math.toRadians(f3)))));
        camera.rotateY(f3);
        camera.getMatrix(matrix);
        camera.restore();
        matrix.preTranslate(-f4, -f5);
        matrix.postTranslate(f4, f5);
    }

    @Override // android.view.animation.Animation
    @SuppressLint({"NewApi", "suppressNewApi"})
    public void initialize(int i, int i2, int i3, int i4) {
        super.initialize(i, i2, i3, i4);
        this.mCamera = new Camera();
        if (DeviceUtil.OSInfo.hasHoneycombMR1()) {
            this.mCamera.setLocation(0.0f, 0.0f, (-i) >> 2);
        }
    }
}
