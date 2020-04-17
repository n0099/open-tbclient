package com.baidu.ar.arrender;

import android.graphics.PointF;
import com.baidu.ar.arplay.core.engine.ARPEngine;
import com.baidu.ar.arplay.core.filter.TakePictureCallback;
import com.baidu.ar.arplay.representation.Matrixf4x4;
/* loaded from: classes3.dex */
public interface j extends IRenderer {
    void a(float f);

    void a(long j, String str);

    void a(PointF pointF, boolean z);

    void a(ARPEngine.g gVar);

    void a(TakePictureCallback takePictureCallback);

    void a(h hVar);

    void a(i iVar);

    void a(k kVar);

    void a(l lVar, boolean z);

    void a(m mVar, boolean z);

    void a(com.baidu.ar.imu.b bVar);

    Matrixf4x4 aI();

    void aw();

    void b(String str, Object obj);

    void bc();

    void bd();

    String be();

    void bf();

    void i(boolean z);

    boolean isDriverdByARPVersion();

    void m(boolean z);

    boolean n(boolean z);

    void o(boolean z);

    void sceneRotateToCamera();

    void sceneWorldPositionToOrigin();

    void setFaceCallBack(ARPEngine.f fVar);

    String updateFilterCase(String str);
}
