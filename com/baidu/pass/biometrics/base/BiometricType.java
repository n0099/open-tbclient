package com.baidu.pass.biometrics.base;
/* loaded from: classes2.dex */
public final class BiometricType {
    public static final int LIVENESS_RECOG = 4;

    public static String a(int i2) {
        return i2 != 4 ? "" : "com.baidu.pass.biometrics.face.liveness.PassFaceRecogManager";
    }
}
