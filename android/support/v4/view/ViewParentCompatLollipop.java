package android.support.v4.view;

import android.util.Log;
import android.view.View;
import android.view.ViewParent;
/* loaded from: classes2.dex */
class ViewParentCompatLollipop {
    private static final String TAG = "ViewParentCompat";

    ViewParentCompatLollipop() {
    }

    public static boolean onStartNestedScroll(ViewParent viewParent, View view2, View view3, int i) {
        try {
            return viewParent.onStartNestedScroll(view2, view3, i);
        } catch (AbstractMethodError e) {
            Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onStartNestedScroll", e);
            return false;
        }
    }

    public static void onNestedScrollAccepted(ViewParent viewParent, View view2, View view3, int i) {
        try {
            viewParent.onNestedScrollAccepted(view2, view3, i);
        } catch (AbstractMethodError e) {
            Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onNestedScrollAccepted", e);
        }
    }

    public static void onStopNestedScroll(ViewParent viewParent, View view2) {
        try {
            viewParent.onStopNestedScroll(view2);
        } catch (AbstractMethodError e) {
            Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onStopNestedScroll", e);
        }
    }

    public static void onNestedScroll(ViewParent viewParent, View view2, int i, int i2, int i3, int i4) {
        try {
            viewParent.onNestedScroll(view2, i, i2, i3, i4);
        } catch (AbstractMethodError e) {
            Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onNestedScroll", e);
        }
    }

    public static void onNestedPreScroll(ViewParent viewParent, View view2, int i, int i2, int[] iArr) {
        try {
            viewParent.onNestedPreScroll(view2, i, i2, iArr);
        } catch (AbstractMethodError e) {
            Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onNestedPreScroll", e);
        }
    }

    public static boolean onNestedFling(ViewParent viewParent, View view2, float f, float f2, boolean z) {
        try {
            return viewParent.onNestedFling(view2, f, f2, z);
        } catch (AbstractMethodError e) {
            Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onNestedFling", e);
            return false;
        }
    }

    public static boolean onNestedPreFling(ViewParent viewParent, View view2, float f, float f2) {
        try {
            return viewParent.onNestedPreFling(view2, f, f2);
        } catch (AbstractMethodError e) {
            Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onNestedPreFling", e);
            return false;
        }
    }
}
