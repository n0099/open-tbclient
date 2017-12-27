package android.support.v4.view.accessibility;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.view.accessibility.AccessibilityManager;
import java.util.List;
/* loaded from: classes2.dex */
class AccessibilityManagerCompatIcs {

    /* loaded from: classes2.dex */
    interface AccessibilityStateChangeListenerBridge {
        void onAccessibilityStateChanged(boolean z);
    }

    /* loaded from: classes2.dex */
    public static class AccessibilityStateChangeListenerWrapper implements AccessibilityManager.AccessibilityStateChangeListener {
        Object mListener;
        AccessibilityStateChangeListenerBridge mListenerBridge;

        public AccessibilityStateChangeListenerWrapper(Object obj, AccessibilityStateChangeListenerBridge accessibilityStateChangeListenerBridge) {
            this.mListener = obj;
            this.mListenerBridge = accessibilityStateChangeListenerBridge;
        }

        public int hashCode() {
            if (this.mListener == null) {
                return 0;
            }
            return this.mListener.hashCode();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            AccessibilityStateChangeListenerWrapper accessibilityStateChangeListenerWrapper = (AccessibilityStateChangeListenerWrapper) obj;
            return this.mListener == null ? accessibilityStateChangeListenerWrapper.mListener == null : this.mListener.equals(accessibilityStateChangeListenerWrapper.mListener);
        }

        @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
        public void onAccessibilityStateChanged(boolean z) {
            this.mListenerBridge.onAccessibilityStateChanged(z);
        }
    }

    public static boolean addAccessibilityStateChangeListener(AccessibilityManager accessibilityManager, AccessibilityStateChangeListenerWrapper accessibilityStateChangeListenerWrapper) {
        return accessibilityManager.addAccessibilityStateChangeListener(accessibilityStateChangeListenerWrapper);
    }

    public static boolean removeAccessibilityStateChangeListener(AccessibilityManager accessibilityManager, AccessibilityStateChangeListenerWrapper accessibilityStateChangeListenerWrapper) {
        return accessibilityManager.removeAccessibilityStateChangeListener(accessibilityStateChangeListenerWrapper);
    }

    public static List<AccessibilityServiceInfo> getEnabledAccessibilityServiceList(AccessibilityManager accessibilityManager, int i) {
        return accessibilityManager.getEnabledAccessibilityServiceList(i);
    }

    public static List<AccessibilityServiceInfo> getInstalledAccessibilityServiceList(AccessibilityManager accessibilityManager) {
        return accessibilityManager.getInstalledAccessibilityServiceList();
    }

    public static boolean isTouchExplorationEnabled(AccessibilityManager accessibilityManager) {
        return accessibilityManager.isTouchExplorationEnabled();
    }
}
