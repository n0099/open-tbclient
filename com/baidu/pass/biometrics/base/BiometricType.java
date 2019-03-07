package com.baidu.pass.biometrics.base;
/* loaded from: classes2.dex */
public final class BiometricType {
    public static final int IDCARD_RECOG = 1;
    public static final int LIVENESS_RECOG = 4;
    public static final int SIGNATURE_VERIFY = 3;
    public static final int VOICE_VERIFY = 2;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getClass(int i) {
        switch (i) {
            case 1:
                return "com.baidu.pass.biometrics.idcard.SapiIDCardRecogManager";
            case 2:
                return "com.baidu.pass.biometrics.voice.SapiVoiceManager";
            case 3:
                return "com.baidu.pass.biometrics.signature.SapiSignatureManager";
            case 4:
                return "com.baidu.pass.biometrics.face.liveness.PassFaceRecogManager";
            default:
                return "";
        }
    }
}
