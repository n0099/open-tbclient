package android.support.v4.view;

import android.view.View;
import android.view.ViewParent;
/* loaded from: classes2.dex */
class ViewParentCompatKitKat {
    public static void notifySubtreeAccessibilityStateChanged(ViewParent viewParent, View view, View view2, int i) {
        viewParent.notifySubtreeAccessibilityStateChanged(view, view2, i);
    }
}
