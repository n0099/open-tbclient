package android.support.v4.view;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
/* loaded from: classes.dex */
class AccessibilityDelegateCompatJellyBean {

    /* loaded from: classes.dex */
    public interface AccessibilityDelegateBridgeJellyBean {
        boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent);

        Object getAccessibilityNodeProvider(View view);

        void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent);

        void onInitializeAccessibilityNodeInfo(View view, Object obj);

        void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent);

        boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent);

        boolean performAccessibilityAction(View view, int i, Bundle bundle);

        void sendAccessibilityEvent(View view, int i);

        void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent);
    }

    AccessibilityDelegateCompatJellyBean() {
    }

    public static Object newAccessibilityDelegateBridge(final AccessibilityDelegateBridgeJellyBean bridge) {
        return new View.AccessibilityDelegate() { // from class: android.support.v4.view.AccessibilityDelegateCompatJellyBean.1
            @Override // android.view.View.AccessibilityDelegate
            public boolean dispatchPopulateAccessibilityEvent(View host, AccessibilityEvent event) {
                return AccessibilityDelegateBridgeJellyBean.this.dispatchPopulateAccessibilityEvent(host, event);
            }

            @Override // android.view.View.AccessibilityDelegate
            public void onInitializeAccessibilityEvent(View host, AccessibilityEvent event) {
                AccessibilityDelegateBridgeJellyBean.this.onInitializeAccessibilityEvent(host, event);
            }

            @Override // android.view.View.AccessibilityDelegate
            public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfo info) {
                AccessibilityDelegateBridgeJellyBean.this.onInitializeAccessibilityNodeInfo(host, info);
            }

            @Override // android.view.View.AccessibilityDelegate
            public void onPopulateAccessibilityEvent(View host, AccessibilityEvent event) {
                AccessibilityDelegateBridgeJellyBean.this.onPopulateAccessibilityEvent(host, event);
            }

            @Override // android.view.View.AccessibilityDelegate
            public boolean onRequestSendAccessibilityEvent(ViewGroup host, View child, AccessibilityEvent event) {
                return AccessibilityDelegateBridgeJellyBean.this.onRequestSendAccessibilityEvent(host, child, event);
            }

            @Override // android.view.View.AccessibilityDelegate
            public void sendAccessibilityEvent(View host, int eventType) {
                AccessibilityDelegateBridgeJellyBean.this.sendAccessibilityEvent(host, eventType);
            }

            @Override // android.view.View.AccessibilityDelegate
            public void sendAccessibilityEventUnchecked(View host, AccessibilityEvent event) {
                AccessibilityDelegateBridgeJellyBean.this.sendAccessibilityEventUnchecked(host, event);
            }

            @Override // android.view.View.AccessibilityDelegate
            public AccessibilityNodeProvider getAccessibilityNodeProvider(View host) {
                return (AccessibilityNodeProvider) AccessibilityDelegateBridgeJellyBean.this.getAccessibilityNodeProvider(host);
            }

            @Override // android.view.View.AccessibilityDelegate
            public boolean performAccessibilityAction(View host, int action, Bundle args) {
                return AccessibilityDelegateBridgeJellyBean.this.performAccessibilityAction(host, action, args);
            }
        };
    }

    public static Object getAccessibilityNodeProvider(Object delegate, View host) {
        return ((View.AccessibilityDelegate) delegate).getAccessibilityNodeProvider(host);
    }

    public static boolean performAccessibilityAction(Object delegate, View host, int action, Bundle args) {
        return ((View.AccessibilityDelegate) delegate).performAccessibilityAction(host, action, args);
    }
}
