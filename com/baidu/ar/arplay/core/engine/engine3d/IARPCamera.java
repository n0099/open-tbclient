package com.baidu.ar.arplay.core.engine.engine3d;
/* loaded from: classes10.dex */
public interface IARPCamera extends IARPNode {
    float getFieldOfView();

    float[] getViewMatrix();

    float getZFar();

    float getZNear();

    void setFieldOfView(float f2);

    void setViewMatrix(float[] fArr);

    void setZFar(float f2);

    void setZNear(float f2);
}
