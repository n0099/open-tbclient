package com.baidu.ar.arrender;

import android.graphics.PointF;
import com.baidu.ar.arplay.core.engine.ARPDataInteraction;
import com.baidu.ar.arplay.core.renderer.TakePictureCallback;
import com.baidu.ar.arplay.representation.Matrixf4x4;
/* loaded from: classes10.dex */
public interface l extends IRenderer {
    void a(long j, String str);

    void a(PointF pointF, boolean z);

    void a(ARPDataInteraction.b bVar);

    void a(TakePictureCallback takePictureCallback);

    void a(i iVar);

    void a(j jVar);

    void a(m mVar);

    void a(o oVar, boolean z);

    void a(com.baidu.ar.imu.b bVar);

    void a(String str, Object obj);

    void aJ();

    void b(int i, boolean z);

    void bv();

    void bw();

    String bx();

    void by();

    Matrixf4x4 getInitialTransform();

    void initWorldAxis();

    boolean isDriverdByARPVersion();

    void k(boolean z);

    boolean l(boolean z);

    void m(boolean z);

    void q(int i);

    void sceneRotateToCamera();

    void sceneWorldPositionToOrigin();

    void setFieldOfView(float f);

    void setOffScreenGuideWork(boolean z);

    String updateFilterCase(String str);
}
