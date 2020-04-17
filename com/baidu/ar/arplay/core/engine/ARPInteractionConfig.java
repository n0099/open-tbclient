package com.baidu.ar.arplay.core.engine;

import com.baidu.ar.arplay.representation.Vector3f;
/* loaded from: classes3.dex */
public class ARPInteractionConfig {
    public static void a(Vector3f vector3f, float f) {
        nativeSetMovePlane(vector3f.getX(), vector3f.getY(), vector3f.getZ(), f);
    }

    private static native void nativeSetMovePlane(float f, float f2, float f3, float f4);
}
