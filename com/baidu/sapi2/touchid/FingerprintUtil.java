package com.baidu.sapi2.touchid;

import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.utils.Log;
/* loaded from: classes3.dex */
public class FingerprintUtil {
    public static int getFingerPrintState(SapiConfiguration sapiConfiguration) {
        if (Build.VERSION.SDK_INT < 23) {
            return 101;
        }
        if (!sapiConfiguration.isSupportTouchLogin()) {
            return 102;
        }
        FingerprintManager fingerprintManager = null;
        try {
            fingerprintManager = (FingerprintManager) sapiConfiguration.context.getSystemService(FingerprintManager.class);
        } catch (Exception e) {
            Log.e(e);
        }
        if (fingerprintManager != null && fingerprintManager.isHardwareDetected() && fingerprintManager.hasEnrolledFingerprints()) {
            return 0;
        }
        return 104;
    }
}
