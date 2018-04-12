package android.support.v4.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
/* loaded from: classes2.dex */
class AccessibilityDelegateCompatIcs {

    /* loaded from: classes2.dex */
    public interface AccessibilityDelegateBridge {
        boolean dispatchPopulateAccessibilityEvent(View view2, AccessibilityEvent accessibilityEvent);

        void onInitializeAccessibilityEvent(View view2, AccessibilityEvent accessibilityEvent);

        void onInitializeAccessibilityNodeInfo(View view2, Object obj);

        void onPopulateAccessibilityEvent(View view2, AccessibilityEvent accessibilityEvent);

        boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view2, AccessibilityEvent accessibilityEvent);

        void sendAccessibilityEvent(View view2, int i);

        void sendAccessibilityEventUnchecked(View view2, AccessibilityEvent accessibilityEvent);
    }

    AccessibilityDelegateCompatIcs() {
    }

    public static Object newAccessibilityDelegateDefaultImpl() {
        return new View.AccessibilityDelegate();
    }

    public static Object newAccessibilityDelegateBridge(final AccessibilityDelegateBridge accessibilityDelegateBridge) {
        return new View.AccessibilityDelegate() { // from class: android.support.v4.view.AccessibilityDelegateCompatIcs.1
            @Override // android.view.View.AccessibilityDelegate
            public boolean dispatchPopulateAccessibilityEvent(View view2, AccessibilityEvent accessibilityEvent) {
                return AccessibilityDelegateBridge.this.dispatchPopulateAccessibilityEvent(view2, accessibilityEvent);
            }

            @Override // android.view.View.AccessibilityDelegate
            public void onInitializeAccessibilityEvent(View view2, AccessibilityEvent accessibilityEvent) {
                AccessibilityDelegateBridge.this.onInitializeAccessibilityEvent(view2, accessibilityEvent);
            }

            @Override // android.view.View.AccessibilityDelegate
            public void onInitializeAccessibilityNodeInfo(View view2, AccessibilityNodeInfo accessibilityNodeInfo) {
                AccessibilityDelegateBridge.this.onInitializeAccessibilityNodeInfo(view2, accessibilityNodeInfo);
            }

            @Override // android.view.View.AccessibilityDelegate
            public void onPopulateAccessibilityEvent(View view2, AccessibilityEvent accessibilityEvent) {
                AccessibilityDelegateBridge.this.onPopulateAccessibilityEvent(view2, accessibilityEvent);
            }

            @Override // android.view.View.AccessibilityDelegate
            public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view2, AccessibilityEvent accessibilityEvent) {
                return AccessibilityDelegateBridge.this.onRequestSendAccessibilityEvent(viewGroup, view2, accessibilityEvent);
            }

            @Override // android.view.View.AccessibilityDelegate
            public void sendAccessibilityEvent(View view2, int i) {
                AccessibilityDelegateBridge.this.sendAccessibilityEvent(view2, i);
            }

            @Override // android.view.View.AccessibilityDelegate
            public void sendAccessibilityEventUnchecked(View view2, AccessibilityEvent accessibilityEvent) {
                AccessibilityDelegateBridge.this.sendAccessibilityEventUnchecked(view2, accessibilityEvent);
            }
        };
    }

    public static boolean dispatchPopulateAccessibilityEvent(Object obj, View view2, AccessibilityEvent accessibilityEvent) {
        return ((View.AccessibilityDelegate) obj).dispatchPopulateAccessibilityEvent(view2, accessibilityEvent);
    }

    public static void onInitializeAccessibilityEvent(Object obj, View view2, AccessibilityEvent accessibilityEvent) {
        ((View.AccessibilityDelegate) obj).onInitializeAccessibilityEvent(view2, accessibilityEvent);
    }

    public static void onInitializeAccessibilityNodeInfo(Object obj, View view2, Object obj2) {
        ((View.AccessibilityDelegate) obj).onInitializeAccessibilityNodeInfo(view2, (AccessibilityNodeInfo) obj2);
    }

    public static void onPopulateAccessibilityEvent(Object obj, View view2, AccessibilityEvent accessibilityEvent) {
        ((View.AccessibilityDelegate) obj).onPopulateAccessibilityEvent(view2, accessibilityEvent);
    }

    public static boolean onRequestSendAccessibilityEvent(Object obj, ViewGroup viewGroup, View view2, AccessibilityEvent accessibilityEvent) {
        return ((View.AccessibilityDelegate) obj).onRequestSendAccessibilityEvent(viewGroup, view2, accessibilityEvent);
    }

    public static void sendAccessibilityEvent(Object obj, View view2, int i) {
        ((View.AccessibilityDelegate) obj).sendAccessibilityEvent(view2, i);
    }

    public static void sendAccessibilityEventUnchecked(Object obj, View view2, AccessibilityEvent accessibilityEvent) {
        ((View.AccessibilityDelegate) obj).sendAccessibilityEventUnchecked(view2, accessibilityEvent);
    }
}
