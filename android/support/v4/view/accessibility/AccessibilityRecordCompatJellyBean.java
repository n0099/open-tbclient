package android.support.v4.view.accessibility;

import android.view.View;
import android.view.accessibility.AccessibilityRecord;
/* loaded from: classes2.dex */
class AccessibilityRecordCompatJellyBean {
    AccessibilityRecordCompatJellyBean() {
    }

    public static void setSource(Object obj, View view2, int i) {
        ((AccessibilityRecord) obj).setSource(view2, i);
    }
}
