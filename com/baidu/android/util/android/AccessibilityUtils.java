package com.baidu.android.util.android;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.os.Build;
import android.view.accessibility.AccessibilityManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.util.Locale;
/* loaded from: classes.dex */
public class AccessibilityUtils {
    public static final String MODE_ACCESSIBILITY_TAG = "talkback";

    public static void addTalkBackChangeListener(AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) AppRuntime.getAppContext().getSystemService("accessibility");
        if (accessibilityManager == null || Build.VERSION.SDK_INT < 19) {
            return;
        }
        accessibilityManager.addTouchExplorationStateChangeListener(touchExplorationStateChangeListener);
    }

    public static boolean isEnabled() {
        try {
            for (AccessibilityServiceInfo accessibilityServiceInfo : ((AccessibilityManager) AppRuntime.getAppContext().getSystemService("accessibility")).getEnabledAccessibilityServiceList(-1)) {
                if (accessibilityServiceInfo.getId().toLowerCase(Locale.getDefault()).contains("talkback")) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isTalkBackOpened() {
        AccessibilityManager accessibilityManager = (AccessibilityManager) AppRuntime.getAppContext().getSystemService("accessibility");
        return accessibilityManager != null && accessibilityManager.isTouchExplorationEnabled();
    }

    public static void removeTalkBackChangeListener(AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) AppRuntime.getAppContext().getSystemService("accessibility");
        if (accessibilityManager == null || Build.VERSION.SDK_INT < 19) {
            return;
        }
        accessibilityManager.addTouchExplorationStateChangeListener(touchExplorationStateChangeListener);
    }
}
