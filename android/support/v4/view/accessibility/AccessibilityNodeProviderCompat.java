package android.support.v4.view.accessibility;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompatJellyBean;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompatKitKat;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class AccessibilityNodeProviderCompat {
    public static final int HOST_VIEW_ID = -1;
    private static final AccessibilityNodeProviderImpl IMPL;
    private final Object mProvider;

    /* loaded from: classes2.dex */
    interface AccessibilityNodeProviderImpl {
        Object newAccessibilityNodeProviderBridge(AccessibilityNodeProviderCompat accessibilityNodeProviderCompat);
    }

    /* loaded from: classes2.dex */
    static class AccessibilityNodeProviderStubImpl implements AccessibilityNodeProviderImpl {
        AccessibilityNodeProviderStubImpl() {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeProviderCompat.AccessibilityNodeProviderImpl
        public Object newAccessibilityNodeProviderBridge(AccessibilityNodeProviderCompat accessibilityNodeProviderCompat) {
            return null;
        }
    }

    @RequiresApi(16)
    /* loaded from: classes2.dex */
    private static class AccessibilityNodeProviderJellyBeanImpl extends AccessibilityNodeProviderStubImpl {
        AccessibilityNodeProviderJellyBeanImpl() {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeProviderCompat.AccessibilityNodeProviderStubImpl, android.support.v4.view.accessibility.AccessibilityNodeProviderCompat.AccessibilityNodeProviderImpl
        public Object newAccessibilityNodeProviderBridge(final AccessibilityNodeProviderCompat accessibilityNodeProviderCompat) {
            return AccessibilityNodeProviderCompatJellyBean.newAccessibilityNodeProviderBridge(new AccessibilityNodeProviderCompatJellyBean.AccessibilityNodeInfoBridge() { // from class: android.support.v4.view.accessibility.AccessibilityNodeProviderCompat.AccessibilityNodeProviderJellyBeanImpl.1
                @Override // android.support.v4.view.accessibility.AccessibilityNodeProviderCompatJellyBean.AccessibilityNodeInfoBridge
                public boolean performAction(int i, int i2, Bundle bundle) {
                    return accessibilityNodeProviderCompat.performAction(i, i2, bundle);
                }

                @Override // android.support.v4.view.accessibility.AccessibilityNodeProviderCompatJellyBean.AccessibilityNodeInfoBridge
                public List<Object> findAccessibilityNodeInfosByText(String str, int i) {
                    List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText = accessibilityNodeProviderCompat.findAccessibilityNodeInfosByText(str, i);
                    if (findAccessibilityNodeInfosByText == null) {
                        return null;
                    }
                    ArrayList arrayList = new ArrayList();
                    int size = findAccessibilityNodeInfosByText.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        arrayList.add(findAccessibilityNodeInfosByText.get(i2).unwrap());
                    }
                    return arrayList;
                }

                @Override // android.support.v4.view.accessibility.AccessibilityNodeProviderCompatJellyBean.AccessibilityNodeInfoBridge
                public Object createAccessibilityNodeInfo(int i) {
                    AccessibilityNodeInfoCompat createAccessibilityNodeInfo = accessibilityNodeProviderCompat.createAccessibilityNodeInfo(i);
                    if (createAccessibilityNodeInfo == null) {
                        return null;
                    }
                    return createAccessibilityNodeInfo.unwrap();
                }
            });
        }
    }

    @RequiresApi(19)
    /* loaded from: classes2.dex */
    private static class AccessibilityNodeProviderKitKatImpl extends AccessibilityNodeProviderStubImpl {
        AccessibilityNodeProviderKitKatImpl() {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeProviderCompat.AccessibilityNodeProviderStubImpl, android.support.v4.view.accessibility.AccessibilityNodeProviderCompat.AccessibilityNodeProviderImpl
        public Object newAccessibilityNodeProviderBridge(final AccessibilityNodeProviderCompat accessibilityNodeProviderCompat) {
            return AccessibilityNodeProviderCompatKitKat.newAccessibilityNodeProviderBridge(new AccessibilityNodeProviderCompatKitKat.AccessibilityNodeInfoBridge() { // from class: android.support.v4.view.accessibility.AccessibilityNodeProviderCompat.AccessibilityNodeProviderKitKatImpl.1
                @Override // android.support.v4.view.accessibility.AccessibilityNodeProviderCompatKitKat.AccessibilityNodeInfoBridge
                public boolean performAction(int i, int i2, Bundle bundle) {
                    return accessibilityNodeProviderCompat.performAction(i, i2, bundle);
                }

                @Override // android.support.v4.view.accessibility.AccessibilityNodeProviderCompatKitKat.AccessibilityNodeInfoBridge
                public List<Object> findAccessibilityNodeInfosByText(String str, int i) {
                    List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText = accessibilityNodeProviderCompat.findAccessibilityNodeInfosByText(str, i);
                    if (findAccessibilityNodeInfosByText == null) {
                        return null;
                    }
                    ArrayList arrayList = new ArrayList();
                    int size = findAccessibilityNodeInfosByText.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        arrayList.add(findAccessibilityNodeInfosByText.get(i2).unwrap());
                    }
                    return arrayList;
                }

                @Override // android.support.v4.view.accessibility.AccessibilityNodeProviderCompatKitKat.AccessibilityNodeInfoBridge
                public Object createAccessibilityNodeInfo(int i) {
                    AccessibilityNodeInfoCompat createAccessibilityNodeInfo = accessibilityNodeProviderCompat.createAccessibilityNodeInfo(i);
                    if (createAccessibilityNodeInfo == null) {
                        return null;
                    }
                    return createAccessibilityNodeInfo.unwrap();
                }

                @Override // android.support.v4.view.accessibility.AccessibilityNodeProviderCompatKitKat.AccessibilityNodeInfoBridge
                public Object findFocus(int i) {
                    AccessibilityNodeInfoCompat findFocus = accessibilityNodeProviderCompat.findFocus(i);
                    if (findFocus == null) {
                        return null;
                    }
                    return findFocus.unwrap();
                }
            });
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            IMPL = new AccessibilityNodeProviderKitKatImpl();
        } else if (Build.VERSION.SDK_INT >= 16) {
            IMPL = new AccessibilityNodeProviderJellyBeanImpl();
        } else {
            IMPL = new AccessibilityNodeProviderStubImpl();
        }
    }

    public AccessibilityNodeProviderCompat() {
        this.mProvider = IMPL.newAccessibilityNodeProviderBridge(this);
    }

    public AccessibilityNodeProviderCompat(Object obj) {
        this.mProvider = obj;
    }

    public Object getProvider() {
        return this.mProvider;
    }

    @Nullable
    public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int i) {
        return null;
    }

    public boolean performAction(int i, int i2, Bundle bundle) {
        return false;
    }

    @Nullable
    public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText(String str, int i) {
        return null;
    }

    @Nullable
    public AccessibilityNodeInfoCompat findFocus(int i) {
        return null;
    }
}
