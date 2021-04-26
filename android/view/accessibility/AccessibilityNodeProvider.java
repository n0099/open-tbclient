package android.view.accessibility;

import android.os.Bundle;
import java.util.List;
/* loaded from: classes.dex */
public abstract class AccessibilityNodeProvider {
    public static final int HOST_VIEW_ID = -1;

    public AccessibilityNodeInfo createAccessibilityNodeInfo(int i2) {
        return null;
    }

    public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i2) {
        return null;
    }

    public AccessibilityNodeInfo findFocus(int i2) {
        return null;
    }

    public boolean performAction(int i2, int i3, Bundle bundle) {
        return false;
    }
}
