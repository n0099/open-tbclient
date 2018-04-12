package android.support.v4.view;

import android.view.View;
import android.view.ViewParent;
/* loaded from: classes2.dex */
class ViewParentCompatKitKat {
    ViewParentCompatKitKat() {
    }

    public static void notifySubtreeAccessibilityStateChanged(ViewParent viewParent, View view2, View view3, int i) {
        viewParent.notifySubtreeAccessibilityStateChanged(view2, view3, i);
    }
}
