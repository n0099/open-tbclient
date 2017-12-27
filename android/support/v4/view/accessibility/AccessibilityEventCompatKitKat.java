package android.support.v4.view.accessibility;

import android.view.accessibility.AccessibilityEvent;
/* loaded from: classes2.dex */
class AccessibilityEventCompatKitKat {
    public static void setContentChangeTypes(AccessibilityEvent accessibilityEvent, int i) {
        accessibilityEvent.setContentChangeTypes(i);
    }

    public static int getContentChangeTypes(AccessibilityEvent accessibilityEvent) {
        return accessibilityEvent.getContentChangeTypes();
    }
}
