package com.baidu.platform.comapi.map;

import android.view.SurfaceView;
/* loaded from: classes7.dex */
public class ae {

    /* loaded from: classes7.dex */
    public enum a {
        OPENGL_ES,
        VULKAN,
        AUTO
    }

    public static ad a(SurfaceView surfaceView, a aVar) {
        f fVar = new f(surfaceView);
        fVar.b(2);
        try {
            if (com.baidu.platform.comapi.util.g.a(8, 8, 8, 8, 24, 8)) {
                fVar.a(8, 8, 8, 8, 24, 8);
            } else {
                fVar.b(true);
            }
        } catch (IllegalArgumentException e) {
            fVar.b(true);
        }
        fVar.a(true);
        return fVar;
    }
}
