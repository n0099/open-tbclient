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

    public static void notifySubtreeAccessibilityStateChanged(ViewParent viewParent, View view, View view2, int i2) {
        if (Build.VERSION.SDK_INT >= 19) {
            viewParent.notifySubtreeAccessibilityStateChanged(view, view2, i2);
        }
    }

    public static boolean onNestedFling(ViewParent viewParent, View view, float f2, float f3, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                return viewParent.onNestedFling(view, f2, f3, z);
            } catch (AbstractMethodError e2) {
                Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onNestedFling", e2);
                return false;
            }
        } else if (viewParent instanceof NestedScrollingParent) {
            return ((NestedScrollingParent) viewParent).onNestedFling(view, f2, f3, z);
        } else {
            return false;
        }
    }

    public static boolean onNestedPreFling(ViewParent viewParent, View view, float f2, float f3) {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                return viewParent.onNestedPreFling(view, f2, f3);
            } catch (AbstractMethodError e2) {
                Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onNestedPreFling", e2);
                return false;
            }
        } else if (viewParent instanceof NestedScrollingParent) {
            return ((NestedScrollingParent) viewParent).onNestedPreFling(view, f2, f3);
        } else {
            return false;
        }
    }

    public static void onNestedPreScroll(ViewParent viewParent, View view, int i2, int i3, int[] iArr) {
        onNestedPreScroll(viewParent, view, i2, i3, iArr, 0);
    }

    public static void onNestedScroll(ViewParent viewParent, View view, int i2, int i3, int i4, int i5) {
        onNestedScroll(viewParent, view, i2, i3, i4, i5, 0, getTempNestedScrollConsumed());
    }

    public static void onNestedScrollAccepted(ViewParent viewParent, View view, View view2, int i2) {
        onNestedScrollAccepted(viewParent, view, view2, i2, 0);
    }

    public static boolean onStartNestedScroll(ViewParent viewParent, View view, View view2, int i2) {
        return onStartNestedScroll(viewParent, view, view2, i2, 0);
    }

    public static void onStopNestedScroll(ViewParent viewParent, View view) {
        onStopNestedScroll(viewParent, view, 0);
    }

    @Deprecated
    public static boolean requestSendAccessibilityEvent(ViewParent viewParent, View view, AccessibilityEvent accessibilityEvent) {
        return viewParent.requestSendAccessibilityEvent(view, accessibilityEvent);
    }

    public static void onNestedPreScroll(ViewParent viewParent, View view, int i2, int i3, int[] iArr, int i4) {
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent).onNestedPreScroll(view, i2, i3, iArr, i4);
        } else if (i4 == 0) {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    viewParent.onNestedPreScroll(view, i2, i3, iArr);
                } catch (AbstractMethodError e2) {
                    Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onNestedPreScroll", e2);
                }
            } else if (viewParent instanceof NestedScrollingParent) {
                ((NestedScrollingParent) viewParent).onNestedPreScroll(view, i2, i3, iArr);
            }
        }
    }

    public static void onNestedScrollAccepted(ViewParent viewParent, View view, View view2, int i2, int i3) {
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent).onNestedScrollAccepted(view, view2, i2, i3);
        } else if (i3 == 0) {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    viewParent.onNestedScrollAccepted(view, view2, i2);
                } catch (AbstractMethodError e2) {
                    Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onNestedScrollAccepted", e2);
                }
            } else if (viewParent instanceof NestedScrollingParent) {
                ((NestedScrollingParent) viewParent).onNestedScrollAccepted(view, view2, i2);
            }
        }
    }

    public static boolean onStartNestedScroll(ViewParent viewParent, View view, View view2, int i2, int i3) {
        if (viewParent instanceof NestedScrollingParent2) {
            return ((NestedScrollingParent2) viewParent).onStartNestedScroll(view, view2, i2, i3);
        }
        if (i3 == 0) {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    return viewParent.onStartNestedScroll(view, view2, i2);
                } catch (AbstractMethodError e2) {
                    Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onStartNestedScroll", e2);
                    return false;
                }
            } else if (viewParent instanceof NestedScrollingParent) {
                return ((NestedScrollingParent) viewParent).onStartNestedScroll(view, view2, i2);
            } else {
                return false;
            }
        }
        return false;
    }

    public static void onStopNestedScroll(ViewParent viewParent, View view, int i2) {
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent).onStopNestedScroll(view, i2);
        } else if (i2 == 0) {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    viewParent.onStopNestedScroll(view);
                } catch (AbstractMethodError e2) {
                    Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onStopNestedScroll", e2);
                }
            } else if (viewParent instanceof NestedScrollingParent) {
                ((NestedScrollingParent) viewParent).onStopNestedScroll(view);
            }
        }
    }

    public static void onNestedScroll(ViewParent viewParent, View view, int i2, int i3, int i4, int i5, int i6) {
        onNestedScroll(viewParent, view, i2, i3, i4, i5, i6, getTempNestedScrollConsumed());
    }

    public static void onNestedScroll(ViewParent viewParent, View view, int i2, int i3, int i4, int i5, int i6, @NonNull int[] iArr) {
        if (viewParent instanceof NestedScrollingParent3) {
            ((NestedScrollingParent3) viewParent).onNestedScroll(view, i2, i3, i4, i5, i6, iArr);
            return;
        }
        iArr[0] = iArr[0] + i4;
        iArr[1] = iArr[1] + i5;
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent).onNestedScroll(view, i2, i3, i4, i5, i6);
        } else if (i6 == 0) {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    viewParent.onNestedScroll(view, i2, i3, i4, i5);
                } catch (AbstractMethodError e2) {
                    Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onNestedScroll", e2);
                }
            } else if (viewParent instanceof NestedScrollingParent) {
                ((NestedScrollingParent) viewParent).onNestedScroll(view, i2, i3, i4, i5);
            }
        }
    }
}
