package com.baidu.android.util.android;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.view.accessibility.AccessibilityManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes8.dex */
public class AccessibilityUtil {
    private static final String MODE_ACCESSIBILITY_TAG = "talkback";

    public static boolean isEnabled() {
        try {
            for (AccessibilityServiceInfo accessibilityServiceInfo : ((AccessibilityManager) AppRuntime.getAppContext().getSystemService("accessibility")).getEnabledAccessibilityServiceList(-1)) {
                if (accessibilityServiceInfo.getId().toLowerCase().contains(MODE_ACCESSIBILITY_TAG)) {
                    return true;
                }
            }
        } catch (Exception e) {
        }
        return false;
    }

    public static boolean isTalkBackOpened() {
        AccessibilityManager accessibilityManager = (AccessibilityManager) AppRuntime.getAppContext().getSystemService("accessibility");
        return accessibilityManager != null && accessibilityManager.isTouchExplorationEnabled();
    }

    public static void addTalkBackChangeListener(AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) AppRuntime.getAppContext().getSystemService("accessibility");
        if (accessibilityManager != null) {
            accessibilityManager.addTouchExplorationStateChangeListener(touchExplorationStateChangeListener);
        }
    }

    public static void removeTalkBackChangeListener(AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) AppRuntime.getAppContext().getSystemService("accessibility");
        if (accessibilityManager != null) {
            accessibilityManager.removeTouchExplorationStateChangeListener(touchExplorationStateChangeListener);
        }
    }
}
