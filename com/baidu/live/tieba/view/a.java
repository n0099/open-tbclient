package com.baidu.live.tieba.view;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;
/* loaded from: classes6.dex */
public class a extends Animation {
    private final float apd;
    private final float ape;
    private float apf;
    private float apg;
    private final float aph;
    private final boolean api;
    private Camera apj;

    public a(float f, float f2, float f3, boolean z) {
        this.apd = f;
        this.ape = f2;
        this.aph = f3;
        this.api = z;
    }

    @Override // android.view.animation.Animation
    public void initialize(int i, int i2, int i3, int i4) {
        super.initialize(i, i2, i3, i4);
        this.apf = i / 2;
        this.apg = i / 2;
        this.apj = new Camera();
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        float f2 = this.apd;
        float f3 = f2 + ((this.ape - f2) * f);
        float f4 = this.apf;
        float f5 = this.apg;
        Camera camera = this.apj;
        Matrix matrix = transformation.getMatrix();
        camera.save();
        if (this.api) {
            camera.translate(0.0f, 0.0f, this.aph * f);
        } else {
            camera.translate(0.0f, 0.0f, this.aph * (1.0f - f));
        }
        camera.rotateY(f3);
        camera.getMatrix(matrix);
        camera.restore();
        matrix.preTranslate(-f4, -f5);
        matrix.postTranslate(f4, f5);
    }
}
