package android.support.v4.view;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
/* loaded from: classes2.dex */
class ViewCompatJB {
    ViewCompatJB() {
    }

    public static boolean hasTransientState(View view2) {
        return view2.hasTransientState();
    }

    public static void setHasTransientState(View view2, boolean z) {
        view2.setHasTransientState(z);
    }

    public static void postInvalidateOnAnimation(View view2) {
        view2.postInvalidateOnAnimation();
    }

    public static void postInvalidateOnAnimation(View view2, int i, int i2, int i3, int i4) {
        view2.postInvalidate(i, i2, i3, i4);
    }

    public static void postOnAnimation(View view2, Runnable runnable) {
        view2.postOnAnimation(runnable);
    }

    public static void postOnAnimationDelayed(View view2, Runnable runnable, long j) {
        view2.postOnAnimationDelayed(runnable, j);
    }

    public static int getImportantForAccessibility(View view2) {
        return view2.getImportantForAccessibility();
    }

    public static void setImportantForAccessibility(View view2, int i) {
        view2.setImportantForAccessibility(i);
    }

    public static boolean performAccessibilityAction(View view2, int i, Bundle bundle) {
        return view2.performAccessibilityAction(i, bundle);
    }

    public static Object getAccessibilityNodeProvider(View view2) {
        return view2.getAccessibilityNodeProvider();
    }

    public static ViewParent getParentForAccessibility(View view2) {
        return view2.getParentForAccessibility();
    }

    public static int getMinimumWidth(View view2) {
        return view2.getMinimumWidth();
    }

    public static int getMinimumHeight(View view2) {
        return view2.getMinimumHeight();
    }

    public static void requestApplyInsets(View view2) {
        view2.requestFitSystemWindows();
    }

    public static boolean getFitsSystemWindows(View view2) {
        return view2.getFitsSystemWindows();
    }

    public static boolean hasOverlappingRendering(View view2) {
        return view2.hasOverlappingRendering();
    }

    public static void setBackground(View view2, Drawable drawable) {
        view2.setBackground(drawable);
    }
}
