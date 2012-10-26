package android.support.v4.view;

import android.os.Build;
import android.support.v4.view.AccessibilityDelegateCompatIcs;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
/* loaded from: classes.dex */
public class AccessibilityDelegateCompat {
    private static final Object DEFAULT_DELEGATE;
    private static final AccessibilityDelegateImpl IMPL;
    final Object mBridge = IMPL.newAccessiblityDelegateBridge(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface AccessibilityDelegateImpl {
        boolean dispatchPopulateAccessibilityEvent(Object obj, View view, AccessibilityEvent accessibilityEvent);

        Object newAccessiblityDelegateBridge(AccessibilityDelegateCompat accessibilityDelegateCompat);

        Object newAccessiblityDelegateDefaultImpl();

        void onInitializeAccessibilityEvent(Object obj, View view, AccessibilityEvent accessibilityEvent);

        void onInitializeAccessibilityNodeInfo(Object obj, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat);

        void onPopulateAccessibilityEvent(Object obj, View view, AccessibilityEvent accessibilityEvent);

        boolean onRequestSendAccessibilityEvent(Object obj, ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent);

        void sendAccessibilityEvent(Object obj, View view, int i);

        void sendAccessibilityEventUnchecked(Object obj, View view, AccessibilityEvent accessibilityEvent);
    }

    /* loaded from: classes.dex */
    static class AccessibilityDelegateStubImpl implements AccessibilityDelegateImpl {
        AccessibilityDelegateStubImpl() {
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateImpl
        public Object newAccessiblityDelegateDefaultImpl() {
            return null;
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateImpl
        public Object newAccessiblityDelegateBridge(AccessibilityDelegateCompat listener) {
            return null;
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateImpl
        public boolean dispatchPopulateAccessibilityEvent(Object delegate, View host, AccessibilityEvent event) {
            return false;
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateImpl
        public void onInitializeAccessibilityEvent(Object delegate, View host, AccessibilityEvent event) {
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateImpl
        public void onInitializeAccessibilityNodeInfo(Object delegate, View host, AccessibilityNodeInfoCompat info) {
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateImpl
        public void onPopulateAccessibilityEvent(Object delegate, View host, AccessibilityEvent event) {
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateImpl
        public boolean onRequestSendAccessibilityEvent(Object delegate, ViewGroup host, View child, AccessibilityEvent event) {
            return true;
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateImpl
        public void sendAccessibilityEvent(Object delegate, View host, int eventType) {
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateImpl
        public void sendAccessibilityEventUnchecked(Object delegate, View host, AccessibilityEvent event) {
        }
    }

    /* loaded from: classes.dex */
    static class AccessibilityDelegateIcsImpl extends AccessibilityDelegateStubImpl {
        AccessibilityDelegateIcsImpl() {
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateStubImpl, android.support.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateImpl
        public Object newAccessiblityDelegateDefaultImpl() {
            return AccessibilityDelegateCompatIcs.newAccessibilityDelegateDefaultImpl();
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateStubImpl, android.support.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateImpl
        public Object newAccessiblityDelegateBridge(final AccessibilityDelegateCompat compat) {
            return AccessibilityDelegateCompatIcs.newAccessibilityDelegateBridge(new AccessibilityDelegateCompatIcs.AccessibilityDelegateBridge() { // from class: android.support.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateIcsImpl.1
                @Override // android.support.v4.view.AccessibilityDelegateCompatIcs.AccessibilityDelegateBridge
                public boolean dispatchPopulateAccessibilityEvent(View host, AccessibilityEvent event) {
                    return compat.dispatchPopulateAccessibilityEvent(host, event);
                }

                @Override // android.support.v4.view.AccessibilityDelegateCompatIcs.AccessibilityDelegateBridge
                public void onInitializeAccessibilityEvent(View host, AccessibilityEvent event) {
                    compat.onInitializeAccessibilityEvent(host, event);
                }

                @Override // android.support.v4.view.AccessibilityDelegateCompatIcs.AccessibilityDelegateBridge
                public void onInitializeAccessibilityNodeInfo(View host, Object info) {
                    compat.onInitializeAccessibilityNodeInfo(host, new AccessibilityNodeInfoCompat(info));
                }

                @Override // android.support.v4.view.AccessibilityDelegateCompatIcs.AccessibilityDelegateBridge
                public void onPopulateAccessibilityEvent(View host, AccessibilityEvent event) {
                    compat.onPopulateAccessibilityEvent(host, event);
                }

                @Override // android.support.v4.view.AccessibilityDelegateCompatIcs.AccessibilityDelegateBridge
                public boolean onRequestSendAccessibilityEvent(ViewGroup host, View child, AccessibilityEvent event) {
                    return compat.onRequestSendAccessibilityEvent(host, child, event);
                }

                @Override // android.support.v4.view.AccessibilityDelegateCompatIcs.AccessibilityDelegateBridge
                public void sendAccessibilityEvent(View host, int eventType) {
                    compat.sendAccessibilityEvent(host, eventType);
                }

                @Override // android.support.v4.view.AccessibilityDelegateCompatIcs.AccessibilityDelegateBridge
                public void sendAccessibilityEventUnchecked(View host, AccessibilityEvent event) {
                    compat.sendAccessibilityEventUnchecked(host, event);
                }
            });
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateStubImpl, android.support.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateImpl
        public boolean dispatchPopulateAccessibilityEvent(Object delegate, View host, AccessibilityEvent event) {
            return AccessibilityDelegateCompatIcs.dispatchPopulateAccessibilityEvent(delegate, host, event);
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateStubImpl, android.support.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateImpl
        public void onInitializeAccessibilityEvent(Object delegate, View host, AccessibilityEvent event) {
            AccessibilityDelegateCompatIcs.onInitializeAccessibilityEvent(delegate, host, event);
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateStubImpl, android.support.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateImpl
        public void onInitializeAccessibilityNodeInfo(Object delegate, View host, AccessibilityNodeInfoCompat info) {
            AccessibilityDelegateCompatIcs.onInitializeAccessibilityNodeInfo(delegate, host, info.getImpl());
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateStubImpl, android.support.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateImpl
        public void onPopulateAccessibilityEvent(Object delegate, View host, AccessibilityEvent event) {
            AccessibilityDelegateCompatIcs.onPopulateAccessibilityEvent(delegate, host, event);
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateStubImpl, android.support.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateImpl
        public boolean onRequestSendAccessibilityEvent(Object delegate, ViewGroup host, View child, AccessibilityEvent event) {
            return AccessibilityDelegateCompatIcs.onRequestSendAccessibilityEvent(delegate, host, child, event);
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateStubImpl, android.support.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateImpl
        public void sendAccessibilityEvent(Object delegate, View host, int eventType) {
            AccessibilityDelegateCompatIcs.sendAccessibilityEvent(delegate, host, eventType);
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateStubImpl, android.support.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateImpl
        public void sendAccessibilityEventUnchecked(Object delegate, View host, AccessibilityEvent event) {
            AccessibilityDelegateCompatIcs.sendAccessibilityEventUnchecked(delegate, host, event);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 14) {
            IMPL = new AccessibilityDelegateIcsImpl();
        } else {
            IMPL = new AccessibilityDelegateStubImpl();
        }
        DEFAULT_DELEGATE = IMPL.newAccessiblityDelegateDefaultImpl();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object getBridge() {
        return this.mBridge;
    }

    public void sendAccessibilityEvent(View host, int eventType) {
        IMPL.sendAccessibilityEvent(DEFAULT_DELEGATE, host, eventType);
    }

    public void sendAccessibilityEventUnchecked(View host, AccessibilityEvent event) {
        IMPL.sendAccessibilityEventUnchecked(DEFAULT_DELEGATE, host, event);
    }

    public boolean dispatchPopulateAccessibilityEvent(View host, AccessibilityEvent event) {
        return IMPL.dispatchPopulateAccessibilityEvent(DEFAULT_DELEGATE, host, event);
    }

    public void onPopulateAccessibilityEvent(View host, AccessibilityEvent event) {
        IMPL.onPopulateAccessibilityEvent(DEFAULT_DELEGATE, host, event);
    }

    public void onInitializeAccessibilityEvent(View host, AccessibilityEvent event) {
        IMPL.onInitializeAccessibilityEvent(DEFAULT_DELEGATE, host, event);
    }

    public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfoCompat info) {
        IMPL.onInitializeAccessibilityNodeInfo(DEFAULT_DELEGATE, host, info);
    }

    public boolean onRequestSendAccessibilityEvent(ViewGroup host, View child, AccessibilityEvent event) {
        return IMPL.onRequestSendAccessibilityEvent(DEFAULT_DELEGATE, host, child, event);
    }
}
