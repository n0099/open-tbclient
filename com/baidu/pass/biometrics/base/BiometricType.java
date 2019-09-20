package com.baidu.pass.biometrics.base;
/* loaded from: classes2.dex */
public final class BiometricType {
    public static final int LIVENESS_RECOG = 4;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getClass(int i) {
        switch (i) {
            case 4:
                return "com.baidu.pass.biometrics.face.liveness.PassFaceRecogManager";
            default:
                return "";
        }
    }
}
