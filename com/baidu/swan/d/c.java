package com.baidu.swan.d;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.pms.e.b;
import com.baidu.webkit.sdk.WebKitFactory;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes25.dex */
public final class c implements com.baidu.swan.pms.e.b {
    private static boolean dPb = false;
    private static final Set<b.a> dPc = new HashSet();

    @Override // com.baidu.swan.pms.e.b
    public void a(String str, b.a aVar) {
        synchronized (dPc) {
            dPc.add(aVar);
            if (!dPb) {
                dPb = true;
                WebKitFactory.installAsync("file://" + str, new WebKitFactory.WebkitInstallListener() { // from class: com.baidu.swan.d.c.1
                    @Override // com.baidu.webkit.sdk.WebKitFactory.WebkitInstallListener
                    public void onInstallStart() {
                    }

                    @Override // com.baidu.webkit.sdk.WebKitFactory.WebkitInstallListener
                    public void onInstallFinish(int i, String str2) {
                        synchronized (c.dPc) {
                            a.hq(true);
                            c.this.hr(new b(AppRuntime.getAppContext()).aYl());
                            boolean unused = c.dPb = false;
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hr(boolean z) {
        synchronized (dPc) {
            for (b.a aVar : dPc) {
                if (aVar != null) {
                    aVar.el(z);
                }
            }
            dPc.clear();
        }
    }
}
