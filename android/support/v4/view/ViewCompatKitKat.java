package android.support.v4.view;

import android.view.View;
/* loaded from: classes2.dex */
class ViewCompatKitKat {
    ViewCompatKitKat() {
    }

    public static int getAccessibilityLiveRegion(View view2) {
        return view2.getAccessibilityLiveRegion();
    }

    public static void setAccessibilityLiveRegion(View view2, int i) {
        view2.setAccessibilityLiveRegion(i);
    }

    public static boolean isLaidOut(View view2) {
        return view2.isLaidOut();
    }

    public static boolean isAttachedToWindow(View view2) {
        return view2.isAttachedToWindow();
    }

    public static boolean isLayoutDirectionResolved(View view2) {
        return view2.isLayoutDirectionResolved();
    }
}
