package com.baidu.sapi2.g;

import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.utils.Log;
/* loaded from: classes2.dex */
public class d {
    public static int a(SapiConfiguration sapiConfiguration) {
        if (Build.VERSION.SDK_INT < 23) {
            return 101;
        }
        if (sapiConfiguration.isSupportTouchLogin()) {
            FingerprintManager fingerprintManager = null;
            try {
                fingerprintManager = (FingerprintManager) sapiConfiguration.context.getSystemService(FingerprintManager.class);
            } catch (Exception e2) {
                Log.e(e2);
            }
            return (fingerprintManager != null && fingerprintManager.isHardwareDetected() && fingerprintManager.hasEnrolledFingerprints()) ? 0 : 104;
        }
        return 102;
    }
}
