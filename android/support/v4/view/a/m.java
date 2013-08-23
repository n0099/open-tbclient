package android.support.v4.view.a;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;
/* loaded from: classes.dex */
final class m extends AccessibilityNodeProvider {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ n f314a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(n nVar) {
        this.f314a = nVar;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
        return (AccessibilityNodeInfo) this.f314a.a(i);
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public List findAccessibilityNodeInfosByText(String str, int i) {
        return this.f314a.a(str, i);
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public boolean performAction(int i, int i2, Bundle bundle) {
        return this.f314a.a(i, i2, bundle);
    }
}
