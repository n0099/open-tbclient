package com.baidu.ar.arrender;

import android.graphics.PointF;
import com.baidu.ar.arplay.core.engine.ARPEngine;
import com.baidu.ar.arplay.core.filter.TakePictureCallback;
import com.baidu.ar.arplay.representation.Matrixf4x4;
/* loaded from: classes11.dex */
public interface j extends IRenderer {
    void a(float f);

    void a(int i, boolean z);

    void a(long j, String str);

    void a(PointF pointF, boolean z);

    void a(ARPEngine.e eVar);

    void a(TakePictureCallback takePictureCallback);

    void a(h hVar);

    void a(i iVar);

    void a(k kVar);

    void a(m mVar, boolean z);

    void a(com.baidu.ar.imu.b bVar);

    void aK();

    Matrixf4x4 aW();

    void b(String str, Object obj);

    void bq();

    void br();

    String bs();

    void bt();

    void h(boolean z);

    boolean isDriverdByARPVersion();

    void l(boolean z);

    boolean m(boolean z);

    void n(boolean z);

    void r(int i);

    void sceneRotateToCamera();

    void sceneWorldPositionToOrigin();

    String updateFilterCase(String str);
}
