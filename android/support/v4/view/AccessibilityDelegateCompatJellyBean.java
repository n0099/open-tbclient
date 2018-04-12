package android.support.v4.view;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
/* loaded from: classes2.dex */
class AccessibilityDelegateCompatJellyBean {

    /* loaded from: classes2.dex */
    public interface AccessibilityDelegateBridgeJellyBean {
        boolean dispatchPopulateAccessibilityEvent(View view2, AccessibilityEvent accessibilityEvent);

        Object getAccessibilityNodeProvider(View view2);

        void onInitializeAccessibilityEvent(View view2, AccessibilityEvent accessibilityEvent);

        void onInitializeAccessibilityNodeInfo(View view2, Object obj);

        void onPopulateAccessibilityEvent(View view2, AccessibilityEvent accessibilityEvent);

        boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view2, AccessibilityEvent accessibilityEvent);

        boolean performAccessibilityAction(View view2, int i, Bundle bundle);

        void sendAccessibilityEvent(View view2, int i);

        void sendAccessibilityEventUnchecked(View view2, AccessibilityEvent accessibilityEvent);
    }

    AccessibilityDelegateCompatJellyBean() {
    }

    public static Object newAccessibilityDelegateBridge(final AccessibilityDelegateBridgeJellyBean accessibilityDelegateBridgeJellyBean) {
        return new View.AccessibilityDelegate() { // from class: android.support.v4.view.AccessibilityDelegateCompatJellyBean.1
            @Override // android.view.View.AccessibilityDelegate
            public boolean dispatchPopulateAccessibilityEvent(View view2, AccessibilityEvent accessibilityEvent) {
                return AccessibilityDelegateBridgeJellyBean.this.dispatchPopulateAccessibilityEvent(view2, accessibilityEvent);
            }

            @Override // android.view.View.AccessibilityDelegate
            public void onInitializeAccessibilityEvent(View view2, AccessibilityEvent accessibilityEvent) {
                AccessibilityDelegateBridgeJellyBean.this.onInitializeAccessibilityEvent(view2, accessibilityEvent);
            }

            @Override // android.view.View.AccessibilityDelegate
            public void onInitializeAccessibilityNodeInfo(View view2, AccessibilityNodeInfo accessibilityNodeInfo) {
                AccessibilityDelegateBridgeJellyBean.this.onInitializeAccessibilityNodeInfo(view2, accessibilityNodeInfo);
            }

            @Override // android.view.View.AccessibilityDelegate
            public void onPopulateAccessibilityEvent(View view2, AccessibilityEvent accessibilityEvent) {
                AccessibilityDelegateBridgeJellyBean.this.onPopulateAccessibilityEvent(view2, accessibilityEvent);
            }

            @Override // android.view.View.AccessibilityDelegate
            public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view2, AccessibilityEvent accessibilityEvent) {
                return AccessibilityDelegateBridgeJellyBean.this.onRequestSendAccessibilityEvent(viewGroup, view2, accessibilityEvent);
            }

            @Override // android.view.View.AccessibilityDelegate
            public void sendAccessibilityEvent(View view2, int i) {
                AccessibilityDelegateBridgeJellyBean.this.sendAccessibilityEvent(view2, i);
            }

            @Override // android.view.View.AccessibilityDelegate
            public void sendAccessibilityEventUnchecked(View view2, AccessibilityEvent accessibilityEvent) {
                AccessibilityDelegateBridgeJellyBean.this.sendAccessibilityEventUnchecked(view2, accessibilityEvent);
            }

            @Override // android.view.View.AccessibilityDelegate
            public AccessibilityNodeProvider getAccessibilityNodeProvider(View view2) {
                return (AccessibilityNodeProvider) AccessibilityDelegateBridgeJellyBean.this.getAccessibilityNodeProvider(view2);
            }

            @Override // android.view.View.AccessibilityDelegate
            public boolean performAccessibilityAction(View view2, int i, Bundle bundle) {
                return AccessibilityDelegateBridgeJellyBean.this.performAccessibilityAction(view2, i, bundle);
            }
        };
    }

    public static Object getAccessibilityNodeProvider(Object obj, View view2) {
        return ((View.AccessibilityDelegate) obj).getAccessibilityNodeProvider(view2);
    }

    public static boolean performAccessibilityAction(Object obj, View view2, int i, Bundle bundle) {
        return ((View.AccessibilityDelegate) obj).performAccessibilityAction(view2, i, bundle);
    }
}
