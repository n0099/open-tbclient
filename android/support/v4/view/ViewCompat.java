package android.support.v4.view;

import android.os.Build;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
/* loaded from: classes.dex */
public class ViewCompat {
    static final ViewCompatImpl IMPL;
    public static final int OVER_SCROLL_ALWAYS = 0;
    public static final int OVER_SCROLL_IF_CONTENT_SCROLLS = 1;
    public static final int OVER_SCROLL_NEVER = 2;

    /* loaded from: classes.dex */
    interface ViewCompatImpl {
        boolean canScrollHorizontally(View view, int i);

        boolean canScrollVertically(View view, int i);

        int getOverScrollMode(View view);

        void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent);

        void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat);

        void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent);

        void setAccessibilityDelegate(View view, AccessibilityDelegateCompat accessibilityDelegateCompat);

        void setOverScrollMode(View view, int i);
    }

    /* loaded from: classes.dex */
    static class BaseViewCompatImpl implements ViewCompatImpl {
        BaseViewCompatImpl() {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean canScrollHorizontally(View v, int direction) {
            return false;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean canScrollVertically(View v, int direction) {
            return false;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public int getOverScrollMode(View v) {
            return 2;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setOverScrollMode(View v, int mode) {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setAccessibilityDelegate(View v, AccessibilityDelegateCompat delegate) {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void onPopulateAccessibilityEvent(View v, AccessibilityEvent event) {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void onInitializeAccessibilityEvent(View v, AccessibilityEvent event) {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void onInitializeAccessibilityNodeInfo(View v, AccessibilityNodeInfoCompat info) {
        }
    }

    /* loaded from: classes.dex */
    static class GBViewCompatImpl extends BaseViewCompatImpl {
        GBViewCompatImpl() {
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public int getOverScrollMode(View v) {
            return ViewCompatGingerbread.getOverScrollMode(v);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setOverScrollMode(View v, int mode) {
            ViewCompatGingerbread.setOverScrollMode(v, mode);
        }
    }

    /* loaded from: classes.dex */
    static class ICSViewCompatImpl extends GBViewCompatImpl {
        ICSViewCompatImpl() {
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean canScrollHorizontally(View v, int direction) {
            return ViewCompatICS.canScrollHorizontally(v, direction);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean canScrollVertically(View v, int direction) {
            return ViewCompatICS.canScrollVertically(v, direction);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void onPopulateAccessibilityEvent(View v, AccessibilityEvent event) {
            ViewCompatICS.onPopulateAccessibilityEvent(v, event);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void onInitializeAccessibilityEvent(View v, AccessibilityEvent event) {
            ViewCompatICS.onInitializeAccessibilityEvent(v, event);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void onInitializeAccessibilityNodeInfo(View v, AccessibilityNodeInfoCompat info) {
            ViewCompatICS.onInitializeAccessibilityNodeInfo(v, info.getImpl());
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setAccessibilityDelegate(View v, AccessibilityDelegateCompat delegate) {
            ViewCompatICS.setAccessibilityDelegate(v, delegate.getBridge());
        }
    }

    static {
        int version = Build.VERSION.SDK_INT;
        if (version >= 14) {
            IMPL = new ICSViewCompatImpl();
        } else if (version >= 9) {
            IMPL = new GBViewCompatImpl();
        } else {
            IMPL = new BaseViewCompatImpl();
        }
    }

    public static boolean canScrollHorizontally(View v, int direction) {
        return IMPL.canScrollHorizontally(v, direction);
    }

    public static boolean canScrollVertically(View v, int direction) {
        return IMPL.canScrollVertically(v, direction);
    }

    public static int getOverScrollMode(View v) {
        return IMPL.getOverScrollMode(v);
    }

    public static void setOverScrollMode(View v, int overScrollMode) {
        IMPL.setOverScrollMode(v, overScrollMode);
    }

    public static void onPopulateAccessibilityEvent(View v, AccessibilityEvent event) {
        IMPL.onPopulateAccessibilityEvent(v, event);
    }

    public static void onInitializeAccessibilityEvent(View v, AccessibilityEvent event) {
        IMPL.onInitializeAccessibilityEvent(v, event);
    }

    public static void onInitializeAccessibilityNodeInfo(View v, AccessibilityNodeInfoCompat info) {
        IMPL.onInitializeAccessibilityNodeInfo(v, info);
    }

    public static void setAccessibilityDelegate(View v, AccessibilityDelegateCompat delegate) {
        IMPL.setAccessibilityDelegate(v, delegate);
    }
}
