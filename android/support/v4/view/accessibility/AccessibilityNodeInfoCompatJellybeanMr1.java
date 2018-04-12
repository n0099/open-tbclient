package android.support.v4.view.accessibility;

import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
/* loaded from: classes2.dex */
class AccessibilityNodeInfoCompatJellybeanMr1 {
    AccessibilityNodeInfoCompatJellybeanMr1() {
    }

    public static void setLabelFor(Object obj, View view2) {
        ((AccessibilityNodeInfo) obj).setLabelFor(view2);
    }

    public static void setLabelFor(Object obj, View view2, int i) {
        ((AccessibilityNodeInfo) obj).setLabelFor(view2, i);
    }

    public static Object getLabelFor(Object obj) {
        return ((AccessibilityNodeInfo) obj).getLabelFor();
    }

    public static void setLabeledBy(Object obj, View view2) {
        ((AccessibilityNodeInfo) obj).setLabeledBy(view2);
    }

    public static void setLabeledBy(Object obj, View view2, int i) {
        ((AccessibilityNodeInfo) obj).setLabeledBy(view2, i);
    }

    public static Object getLabeledBy(Object obj) {
        return ((AccessibilityNodeInfo) obj).getLabeledBy();
    }
}
