package android.support.v4.accessibilityservice;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.pm.PackageManager;
/* loaded from: classes2.dex */
class AccessibilityServiceInfoCompatJellyBean {
    public static String loadDescription(AccessibilityServiceInfo accessibilityServiceInfo, PackageManager packageManager) {
        return accessibilityServiceInfo.loadDescription(packageManager);
    }
}
