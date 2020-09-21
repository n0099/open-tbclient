package com.baidu.ar.arrender;

import android.graphics.PointF;
import com.baidu.ar.arplay.core.engine.ARPEngine;
import com.baidu.ar.arplay.core.filter.TakePictureCallback;
import com.baidu.ar.arplay.representation.Matrixf4x4;
/* loaded from: classes10.dex */
public interface k extends IRenderer {
    void a(float f);

    void a(long j, String str);

    void a(PointF pointF, boolean z);

    void a(ARPEngine.d dVar);

    void a(TakePictureCallback takePictureCallback);

    void a(h hVar);

    void a(i iVar);

    void a(l lVar);

    void a(n nVar, boolean z);

    void a(com.baidu.ar.imu.b bVar);

    void aI();

    Matrixf4x4 aT();

    void b(int i, boolean z);

    void b(String str, Object obj);

    String bA();

    void bB();

    void by();

    void bz();

    void i(boolean z);

    boolean isDriverdByARPVersion();

    void m(boolean z);

    boolean n(boolean z);

    void o(int i);

    void o(boolean z);

    void sceneRotateToCamera();

    void sceneWorldPositionToOrigin();

    String updateFilterCase(String str);
}
