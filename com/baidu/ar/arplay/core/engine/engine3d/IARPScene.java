package com.baidu.ar.arplay.core.engine.engine3d;
/* loaded from: classes10.dex */
public interface IARPScene {
    IARPCamera getActiveCamera();

    String getName(long j2);

    IARPNode getNodeByName(String str);

    IARPNode getRootNode();

    void relocate();

    float[] sceneProject(float[] fArr);

    void setInternal(long j2);

    void setOffScreenGuideWork(boolean z);

    boolean setVisible(boolean z);
}
