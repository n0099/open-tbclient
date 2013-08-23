package android.support.v4.view;

import android.os.Bundle;
import android.view.View;
/* loaded from: classes.dex */
class k {
    public static Object a(m mVar) {
        return new l(mVar);
    }

    public static Object a(Object obj, View view) {
        return ((View.AccessibilityDelegate) obj).getAccessibilityNodeProvider(view);
    }

    public static boolean a(Object obj, View view, int i, Bundle bundle) {
        return ((View.AccessibilityDelegate) obj).performAccessibilityAction(view, i, bundle);
    }
}
