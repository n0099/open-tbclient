package android.support.v4.view.accessibility;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.os.Build;
import android.support.v4.view.accessibility.AccessibilityManagerCompatIcs;
import android.support.v4.view.accessibility.AccessibilityManagerCompatKitKat;
import android.view.accessibility.AccessibilityManager;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public final class AccessibilityManagerCompat {
    private static final AccessibilityManagerVersionImpl IMPL;

    /* loaded from: classes2.dex */
    interface AccessibilityManagerVersionImpl {
        boolean addAccessibilityStateChangeListener(AccessibilityManager accessibilityManager, AccessibilityStateChangeListener accessibilityStateChangeListener);

        boolean addTouchExplorationStateChangeListener(AccessibilityManager accessibilityManager, TouchExplorationStateChangeListener touchExplorationStateChangeListener);

        List<AccessibilityServiceInfo> getEnabledAccessibilityServiceList(AccessibilityManager accessibilityManager, int i);

        List<AccessibilityServiceInfo> getInstalledAccessibilityServiceList(AccessibilityManager accessibilityManager);

        boolean isTouchExplorationEnabled(AccessibilityManager accessibilityManager);

        boolean removeAccessibilityStateChangeListener(AccessibilityManager accessibilityManager, AccessibilityStateChangeListener accessibilityStateChangeListener);

        boolean removeTouchExplorationStateChangeListener(AccessibilityManager accessibilityManager, TouchExplorationStateChangeListener touchExplorationStateChangeListener);
    }

    /* loaded from: classes2.dex */
    public interface AccessibilityStateChangeListener {
        void onAccessibilityStateChanged(boolean z);
    }

    @Deprecated
    /* loaded from: classes2.dex */
    public static abstract class AccessibilityStateChangeListenerCompat implements AccessibilityStateChangeListener {
    }

    /* loaded from: classes2.dex */
    public interface TouchExplorationStateChangeListener {
        void onTouchExplorationStateChanged(boolean z);
    }

    /* loaded from: classes2.dex */
    static class AccessibilityManagerStubImpl implements AccessibilityManagerVersionImpl {
        AccessibilityManagerStubImpl() {
        }

        public AccessibilityManagerCompatIcs.AccessibilityStateChangeListenerWrapper newAccessibilityStateChangeListener(AccessibilityStateChangeListener accessibilityStateChangeListener) {
            return null;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityManagerCompat.AccessibilityManagerVersionImpl
        public boolean addAccessibilityStateChangeListener(AccessibilityManager accessibilityManager, AccessibilityStateChangeListener accessibilityStateChangeListener) {
            return false;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityManagerCompat.AccessibilityManagerVersionImpl
        public boolean removeAccessibilityStateChangeListener(AccessibilityManager accessibilityManager, AccessibilityStateChangeListener accessibilityStateChangeListener) {
            return false;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityManagerCompat.AccessibilityManagerVersionImpl
        public List<AccessibilityServiceInfo> getEnabledAccessibilityServiceList(AccessibilityManager accessibilityManager, int i) {
            return Collections.emptyList();
        }

        @Override // android.support.v4.view.accessibility.AccessibilityManagerCompat.AccessibilityManagerVersionImpl
        public List<AccessibilityServiceInfo> getInstalledAccessibilityServiceList(AccessibilityManager accessibilityManager) {
            return Collections.emptyList();
        }

        @Override // android.support.v4.view.accessibility.AccessibilityManagerCompat.AccessibilityManagerVersionImpl
        public boolean isTouchExplorationEnabled(AccessibilityManager accessibilityManager) {
            return false;
        }

        public AccessibilityManagerCompatKitKat.TouchExplorationStateChangeListenerWrapper newTouchExplorationStateChangeListener(TouchExplorationStateChangeListener touchExplorationStateChangeListener) {
            return null;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityManagerCompat.AccessibilityManagerVersionImpl
        public boolean addTouchExplorationStateChangeListener(AccessibilityManager accessibilityManager, TouchExplorationStateChangeListener touchExplorationStateChangeListener) {
            return false;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityManagerCompat.AccessibilityManagerVersionImpl
        public boolean removeTouchExplorationStateChangeListener(AccessibilityManager accessibilityManager, TouchExplorationStateChangeListener touchExplorationStateChangeListener) {
            return false;
        }
    }

    /* loaded from: classes2.dex */
    static class AccessibilityManagerIcsImpl extends AccessibilityManagerStubImpl {
        AccessibilityManagerIcsImpl() {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityManagerCompat.AccessibilityManagerStubImpl
        public AccessibilityManagerCompatIcs.AccessibilityStateChangeListenerWrapper newAccessibilityStateChangeListener(final AccessibilityStateChangeListener accessibilityStateChangeListener) {
            return new AccessibilityManagerCompatIcs.AccessibilityStateChangeListenerWrapper(accessibilityStateChangeListener, new AccessibilityManagerCompatIcs.AccessibilityStateChangeListenerBridge() { // from class: android.support.v4.view.accessibility.AccessibilityManagerCompat.AccessibilityManagerIcsImpl.1
                @Override // android.support.v4.view.accessibility.AccessibilityManagerCompatIcs.AccessibilityStateChangeListenerBridge
                public void onAccessibilityStateChanged(boolean z) {
                    accessibilityStateChangeListener.onAccessibilityStateChanged(z);
                }
            });
        }

        @Override // android.support.v4.view.accessibility.AccessibilityManagerCompat.AccessibilityManagerStubImpl, android.support.v4.view.accessibility.AccessibilityManagerCompat.AccessibilityManagerVersionImpl
        public boolean addAccessibilityStateChangeListener(AccessibilityManager accessibilityManager, AccessibilityStateChangeListener accessibilityStateChangeListener) {
            return AccessibilityManagerCompatIcs.addAccessibilityStateChangeListener(accessibilityManager, newAccessibilityStateChangeListener(accessibilityStateChangeListener));
        }

        @Override // android.support.v4.view.accessibility.AccessibilityManagerCompat.AccessibilityManagerStubImpl, android.support.v4.view.accessibility.AccessibilityManagerCompat.AccessibilityManagerVersionImpl
        public boolean removeAccessibilityStateChangeListener(AccessibilityManager accessibilityManager, AccessibilityStateChangeListener accessibilityStateChangeListener) {
            return AccessibilityManagerCompatIcs.removeAccessibilityStateChangeListener(accessibilityManager, newAccessibilityStateChangeListener(accessibilityStateChangeListener));
        }

        @Override // android.support.v4.view.accessibility.AccessibilityManagerCompat.AccessibilityManagerStubImpl, android.support.v4.view.accessibility.AccessibilityManagerCompat.AccessibilityManagerVersionImpl
        public List<AccessibilityServiceInfo> getEnabledAccessibilityServiceList(AccessibilityManager accessibilityManager, int i) {
            return AccessibilityManagerCompatIcs.getEnabledAccessibilityServiceList(accessibilityManager, i);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityManagerCompat.AccessibilityManagerStubImpl, android.support.v4.view.accessibility.AccessibilityManagerCompat.AccessibilityManagerVersionImpl
        public List<AccessibilityServiceInfo> getInstalledAccessibilityServiceList(AccessibilityManager accessibilityManager) {
            return AccessibilityManagerCompatIcs.getInstalledAccessibilityServiceList(accessibilityManager);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityManagerCompat.AccessibilityManagerStubImpl, android.support.v4.view.accessibility.AccessibilityManagerCompat.AccessibilityManagerVersionImpl
        public boolean isTouchExplorationEnabled(AccessibilityManager accessibilityManager) {
            return AccessibilityManagerCompatIcs.isTouchExplorationEnabled(accessibilityManager);
        }
    }

    /* loaded from: classes2.dex */
    static class AccessibilityManagerKitKatImpl extends AccessibilityManagerIcsImpl {
        AccessibilityManagerKitKatImpl() {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityManagerCompat.AccessibilityManagerStubImpl
        public AccessibilityManagerCompatKitKat.TouchExplorationStateChangeListenerWrapper newTouchExplorationStateChangeListener(final TouchExplorationStateChangeListener touchExplorationStateChangeListener) {
            return new AccessibilityManagerCompatKitKat.TouchExplorationStateChangeListenerWrapper(touchExplorationStateChangeListener, new AccessibilityManagerCompatKitKat.TouchExplorationStateChangeListenerBridge() { // from class: android.support.v4.view.accessibility.AccessibilityManagerCompat.AccessibilityManagerKitKatImpl.1
                @Override // android.support.v4.view.accessibility.AccessibilityManagerCompatKitKat.TouchExplorationStateChangeListenerBridge
                public void onTouchExplorationStateChanged(boolean z) {
                    touchExplorationStateChangeListener.onTouchExplorationStateChanged(z);
                }
            });
        }

        @Override // android.support.v4.view.accessibility.AccessibilityManagerCompat.AccessibilityManagerStubImpl, android.support.v4.view.accessibility.AccessibilityManagerCompat.AccessibilityManagerVersionImpl
        public boolean addTouchExplorationStateChangeListener(AccessibilityManager accessibilityManager, TouchExplorationStateChangeListener touchExplorationStateChangeListener) {
            return AccessibilityManagerCompatKitKat.addTouchExplorationStateChangeListener(accessibilityManager, newTouchExplorationStateChangeListener(touchExplorationStateChangeListener));
        }

        @Override // android.support.v4.view.accessibility.AccessibilityManagerCompat.AccessibilityManagerStubImpl, android.support.v4.view.accessibility.AccessibilityManagerCompat.AccessibilityManagerVersionImpl
        public boolean removeTouchExplorationStateChangeListener(AccessibilityManager accessibilityManager, TouchExplorationStateChangeListener touchExplorationStateChangeListener) {
            return AccessibilityManagerCompatKitKat.removeTouchExplorationStateChangeListener(accessibilityManager, newTouchExplorationStateChangeListener(touchExplorationStateChangeListener));
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            IMPL = new AccessibilityManagerKitKatImpl();
        } else if (Build.VERSION.SDK_INT >= 14) {
            IMPL = new AccessibilityManagerIcsImpl();
        } else {
            IMPL = new AccessibilityManagerStubImpl();
        }
    }

    public static boolean addAccessibilityStateChangeListener(AccessibilityManager accessibilityManager, AccessibilityStateChangeListener accessibilityStateChangeListener) {
        return IMPL.addAccessibilityStateChangeListener(accessibilityManager, accessibilityStateChangeListener);
    }

    public static boolean removeAccessibilityStateChangeListener(AccessibilityManager accessibilityManager, AccessibilityStateChangeListener accessibilityStateChangeListener) {
        return IMPL.removeAccessibilityStateChangeListener(accessibilityManager, accessibilityStateChangeListener);
    }

    public static List<AccessibilityServiceInfo> getInstalledAccessibilityServiceList(AccessibilityManager accessibilityManager) {
        return IMPL.getInstalledAccessibilityServiceList(accessibilityManager);
    }

    public static List<AccessibilityServiceInfo> getEnabledAccessibilityServiceList(AccessibilityManager accessibilityManager, int i) {
        return IMPL.getEnabledAccessibilityServiceList(accessibilityManager, i);
    }

    public static boolean isTouchExplorationEnabled(AccessibilityManager accessibilityManager) {
        return IMPL.isTouchExplorationEnabled(accessibilityManager);
    }

    public static boolean addTouchExplorationStateChangeListener(AccessibilityManager accessibilityManager, TouchExplorationStateChangeListener touchExplorationStateChangeListener) {
        return IMPL.addTouchExplorationStateChangeListener(accessibilityManager, touchExplorationStateChangeListener);
    }

    public static boolean removeTouchExplorationStateChangeListener(AccessibilityManager accessibilityManager, TouchExplorationStateChangeListener touchExplorationStateChangeListener) {
        return IMPL.removeTouchExplorationStateChangeListener(accessibilityManager, touchExplorationStateChangeListener);
    }

    private AccessibilityManagerCompat() {
    }
}
