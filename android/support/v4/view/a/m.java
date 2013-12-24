package android.support.v4.view.a;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;
/* loaded from: classes.dex */
final class m extends AccessibilityNodeProvider {
    final /* synthetic */ n a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(n nVar) {
        this.a = nVar;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
        return (AccessibilityNodeInfo) this.a.a(i);
    }

    /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: java.util.List<java.lang.Object>, java.util.List<android.view.accessibility.AccessibilityNodeInfo> */
    @Override // android.view.accessibility.AccessibilityNodeProvider
    public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
        return this.a.a(str, i);
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public boolean performAction(int i, int i2, Bundle bundle) {
        return this.a.a(i, i2, bundle);
    }
}
