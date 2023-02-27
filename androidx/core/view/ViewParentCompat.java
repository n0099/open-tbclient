package androidx.core.view;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public final class ViewParentCompat {
    public static final String TAG = "ViewParentCompat";
    public static int[] sTempNestedScrollConsumed;

    public static int[] getTempNestedScrollConsumed() {
        int[] iArr = sTempNestedScrollConsumed;
        if (iArr == null) {
            sTempNestedScrollConsumed = new int[2];
        } else {
            iArr[0] = 0;
            iArr[1] = 0;
        }
        return sTempNestedScrollConsumed;
    }

    public static void notifySubtreeAccessibilityStateChanged(ViewParent viewParent, View view2, View view3, int i) {
        if (Build.VERSION.SDK_INT >= 19) {
            viewParent.notifySubtreeAccessibilityStateChanged(view2, view3, i);
        }
    }

    public static void onNestedScrollAccepted(ViewParent viewParent, View view2, View view3, int i) {
        onNestedScrollAccepted(viewParent, view2, view3, i, 0);
    }

    public static boolean onStartNestedScroll(ViewParent viewParent, View view2, View view3, int i) {
        return onStartNestedScroll(viewParent, view2, view3, i, 0);
    }

    public static boolean onNestedFling(ViewParent viewParent, View view2, float f, float f2, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                return viewParent.onNestedFling(view2, f, f2, z);
            } catch (AbstractMethodError e) {
                Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onNestedFling", e);
                return false;
            }
        } else if (viewParent instanceof NestedScrollingParent) {
            return ((NestedScrollingParent) viewParent).onNestedFling(view2, f, f2, z);
        } else {
            return false;
        }
    }

    public static void onNestedScrollAccepted(ViewParent viewParent, View view2, View view3, int i, int i2) {
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent).onNestedScrollAccepted(view2, view3, i, i2);
        } else if (i2 == 0) {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    viewParent.onNestedScrollAccepted(view2, view3, i);
                } catch (AbstractMethodError e) {
                    Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onNestedScrollAccepted", e);
                }
            } else if (viewParent instanceof NestedScrollingParent) {
                ((NestedScrollingParent) viewParent).onNestedScrollAccepted(view2, view3, i);
            }
        }
    }

    public static boolean onStartNestedScroll(ViewParent viewParent, View view2, View view3, int i, int i2) {
        if (viewParent instanceof NestedScrollingParent2) {
            return ((NestedScrollingParent2) viewParent).onStartNestedScroll(view2, view3, i, i2);
        }
        if (i2 == 0) {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    return viewParent.onStartNestedScroll(view2, view3, i);
                } catch (AbstractMethodError e) {
                    Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onStartNestedScroll", e);
                    return false;
                }
            } else if (viewParent instanceof NestedScrollingParent) {
                return ((NestedScrollingParent) viewParent).onStartNestedScroll(view2, view3, i);
            } else {
                return false;
            }
        }
        return false;
    }

    public static boolean onNestedPreFling(ViewParent viewParent, View view2, float f, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                return viewParent.onNestedPreFling(view2, f, f2);
            } catch (AbstractMethodError e) {
                Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onNestedPreFling", e);
                return false;
            }
        } else if (viewParent instanceof NestedScrollingParent) {
            return ((NestedScrollingParent) viewParent).onNestedPreFling(view2, f, f2);
        } else {
            return false;
        }
    }

    public static void onNestedPreScroll(ViewParent viewParent, View view2, int i, int i2, int[] iArr) {
        onNestedPreScroll(viewParent, view2, i, i2, iArr, 0);
    }

    public static void onNestedPreScroll(ViewParent viewParent, View view2, int i, int i2, int[] iArr, int i3) {
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent).onNestedPreScroll(view2, i, i2, iArr, i3);
        } else if (i3 == 0) {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    viewParent.onNestedPreScroll(view2, i, i2, iArr);
                } catch (AbstractMethodError e) {
                    Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onNestedPreScroll", e);
                }
            } else if (viewParent instanceof NestedScrollingParent) {
                ((NestedScrollingParent) viewParent).onNestedPreScroll(view2, i, i2, iArr);
            }
        }
    }

    public static void onNestedScroll(ViewParent viewParent, View view2, int i, int i2, int i3, int i4) {
        onNestedScroll(viewParent, view2, i, i2, i3, i4, 0, getTempNestedScrollConsumed());
    }

    public static void onNestedScroll(ViewParent viewParent, View view2, int i, int i2, int i3, int i4, int i5) {
        onNestedScroll(viewParent, view2, i, i2, i3, i4, i5, getTempNestedScrollConsumed());
    }

    public static void onNestedScroll(ViewParent viewParent, View view2, int i, int i2, int i3, int i4, int i5, @NonNull int[] iArr) {
        if (viewParent instanceof NestedScrollingParent3) {
            ((NestedScrollingParent3) viewParent).onNestedScroll(view2, i, i2, i3, i4, i5, iArr);
            return;
        }
        iArr[0] = iArr[0] + i3;
        iArr[1] = iArr[1] + i4;
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent).onNestedScroll(view2, i, i2, i3, i4, i5);
        } else if (i5 == 0) {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    viewParent.onNestedScroll(view2, i, i2, i3, i4);
                } catch (AbstractMethodError e) {
                    Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onNestedScroll", e);
                }
            } else if (viewParent instanceof NestedScrollingParent) {
                ((NestedScrollingParent) viewParent).onNestedScroll(view2, i, i2, i3, i4);
            }
        }
    }

    public static void onStopNestedScroll(ViewParent viewParent, View view2) {
        onStopNestedScroll(viewParent, view2, 0);
    }

    public static void onStopNestedScroll(ViewParent viewParent, View view2, int i) {
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent).onStopNestedScroll(view2, i);
        } else if (i == 0) {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    viewParent.onStopNestedScroll(view2);
                } catch (AbstractMethodError e) {
                    Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onStopNestedScroll", e);
                }
            } else if (viewParent instanceof NestedScrollingParent) {
                ((NestedScrollingParent) viewParent).onStopNestedScroll(view2);
            }
        }
    }

    @Deprecated
    public static boolean requestSendAccessibilityEvent(ViewParent viewParent, View view2, AccessibilityEvent accessibilityEvent) {
        return viewParent.requestSendAccessibilityEvent(view2, accessibilityEvent);
    }
}
