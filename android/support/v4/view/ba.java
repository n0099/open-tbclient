package android.support.v4.view;

import android.view.View;
/* loaded from: classes.dex */
class ba {
    public static boolean a(View view, int i) {
        return view.canScrollHorizontally(i);
    }

    public static void a(View view, Object obj) {
        view.setAccessibilityDelegate((View.AccessibilityDelegate) obj);
    }
}
