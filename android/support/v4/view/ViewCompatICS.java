package android.support.v4.view;

import android.support.annotation.Nullable;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
/* loaded from: classes2.dex */
class ViewCompatICS {
    ViewCompatICS() {
    }

    public static boolean canScrollHorizontally(View view2, int i) {
        return view2.canScrollHorizontally(i);
    }

    public static boolean canScrollVertically(View view2, int i) {
        return view2.canScrollVertically(i);
    }

    public static void setAccessibilityDelegate(View view2, @Nullable Object obj) {
        view2.setAccessibilityDelegate((View.AccessibilityDelegate) obj);
    }

    public static void onPopulateAccessibilityEvent(View view2, AccessibilityEvent accessibilityEvent) {
        view2.onPopulateAccessibilityEvent(accessibilityEvent);
    }

    public static void onInitializeAccessibilityEvent(View view2, AccessibilityEvent accessibilityEvent) {
        view2.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    public static void onInitializeAccessibilityNodeInfo(View view2, Object obj) {
        view2.onInitializeAccessibilityNodeInfo((AccessibilityNodeInfo) obj);
    }

    public static void setFitsSystemWindows(View view2, boolean z) {
        view2.setFitsSystemWindows(z);
    }
}
