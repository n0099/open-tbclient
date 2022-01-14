package com.baidu.ar.arplay.core.engine.engine3d;

import java.util.HashMap;
/* loaded from: classes10.dex */
public interface IARPEngine3D {
    IARPScene getCurrentScene();

    void initWorldAxis();

    void sceneRotateToCamera();

    void sceneWorldPositionToOrigin();

    void updateNodeUniform(String str, HashMap<String, Object> hashMap);
}
