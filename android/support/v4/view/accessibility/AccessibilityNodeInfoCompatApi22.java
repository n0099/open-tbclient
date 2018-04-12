package android.support.v4.view.accessibility;

import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
/* loaded from: classes2.dex */
class AccessibilityNodeInfoCompatApi22 {
    AccessibilityNodeInfoCompatApi22() {
    }

    public static Object getTraversalBefore(Object obj) {
        return ((AccessibilityNodeInfo) obj).getTraversalBefore();
    }

    public static void setTraversalBefore(Object obj, View view2) {
        ((AccessibilityNodeInfo) obj).setTraversalBefore(view2);
    }

    public static void setTraversalBefore(Object obj, View view2, int i) {
        ((AccessibilityNodeInfo) obj).setTraversalBefore(view2, i);
    }

    public static Object getTraversalAfter(Object obj) {
        return ((AccessibilityNodeInfo) obj).getTraversalAfter();
    }

    public static void setTraversalAfter(Object obj, View view2) {
        ((AccessibilityNodeInfo) obj).setTraversalAfter(view2);
    }

    public static void setTraversalAfter(Object obj, View view2, int i) {
        ((AccessibilityNodeInfo) obj).setTraversalAfter(view2, i);
    }
}
