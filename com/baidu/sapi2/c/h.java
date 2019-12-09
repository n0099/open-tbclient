package com.baidu.sapi2.c;

import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.utils.Log;
/* loaded from: classes2.dex */
public class h {
    public static int a(SapiConfiguration sapiConfiguration) {
        FingerprintManager fingerprintManager;
        if (Build.VERSION.SDK_INT < 23) {
            return 101;
        }
        if (sapiConfiguration.isSupportTouchLogin()) {
            try {
                fingerprintManager = (FingerprintManager) sapiConfiguration.context.getSystemService(FingerprintManager.class);
            } catch (Exception e) {
                Log.e(e);
                fingerprintManager = null;
            }
            return (fingerprintManager != null && fingerprintManager.isHardwareDetected() && fingerprintManager.hasEnrolledFingerprints()) ? 0 : 104;
        }
        return 102;
    }
}
