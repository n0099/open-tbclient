package android.support.v4.view.accessibility;

import android.view.accessibility.AccessibilityNodeProvider;
/* loaded from: classes.dex */
class AccessibilityNodeProviderCompatJellyBean {

    /* loaded from: classes.dex */
    interface AccessibilityNodeInfoBridge {
    }

    public static Object newAccessibilityNodeProviderBridge(final AccessibilityNodeInfoBridge accessibilityNodeInfoBridge) {
        return new AccessibilityNodeProvider() { // from class: android.support.v4.view.accessibility.AccessibilityNodeProviderCompatJellyBean.1
        };
    }
}
