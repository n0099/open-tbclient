package android.support.v4.view.accessibility;

import android.view.accessibility.AccessibilityWindowInfo;
/* loaded from: classes2.dex */
class AccessibilityWindowInfoCompatApi24 {
    public static CharSequence getTitle(Object obj) {
        return ((AccessibilityWindowInfo) obj).getTitle();
    }

    public static Object getAnchor(Object obj) {
        return ((AccessibilityWindowInfo) obj).getAnchor();
    }
}
