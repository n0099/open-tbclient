package com.baidu.live.tieba.view;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;
/* loaded from: classes6.dex */
public class a extends Animation {
    private final float aoL;
    private final float aoM;
    private float aoN;
    private float aoO;
    private final float aoP;
    private final boolean aoQ;
    private Camera aoR;

    public a(float f, float f2, float f3, boolean z) {
        this.aoL = f;
        this.aoM = f2;
        this.aoP = f3;
        this.aoQ = z;
    }

    @Override // android.view.animation.Animation
    public void initialize(int i, int i2, int i3, int i4) {
        super.initialize(i, i2, i3, i4);
        this.aoN = i / 2;
        this.aoO = i / 2;
        this.aoR = new Camera();
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        float f2 = this.aoL;
        float f3 = f2 + ((this.aoM - f2) * f);
        float f4 = this.aoN;
        float f5 = this.aoO;
        Camera camera = this.aoR;
        Matrix matrix = transformation.getMatrix();
        camera.save();
        if (this.aoQ) {
            camera.translate(0.0f, 0.0f, this.aoP * f);
        } else {
            camera.translate(0.0f, 0.0f, this.aoP * (1.0f - f));
        }
        camera.rotateY(f3);
        camera.getMatrix(matrix);
        camera.restore();
        matrix.preTranslate(-f4, -f5);
        matrix.postTranslate(f4, f5);
    }
}
