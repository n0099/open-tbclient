package com.baidu.swan.d;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.pms.e.b;
import com.baidu.webkit.sdk.WebKitFactory;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes14.dex */
public final class c implements com.baidu.swan.pms.e.b {
    private static boolean eDm = false;
    private static final Set<b.a> eDn = new HashSet();

    @Override // com.baidu.swan.pms.e.b
    public void a(String str, b.a aVar) {
        synchronized (eDn) {
            eDn.add(aVar);
            if (!eDm) {
                eDm = true;
                WebKitFactory.installAsync("file://" + str, new WebKitFactory.WebkitInstallListener() { // from class: com.baidu.swan.d.c.1
                    @Override // com.baidu.webkit.sdk.WebKitFactory.WebkitInstallListener
                    public void onInstallStart() {
                    }

                    @Override // com.baidu.webkit.sdk.WebKitFactory.WebkitInstallListener
                    public void onInstallFinish(int i, String str2) {
                        synchronized (c.eDn) {
                            a.iS(true);
                            c.this.iT(new b(AppRuntime.getAppContext()).bgC());
                            boolean unused = c.eDm = false;
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iT(boolean z) {
        synchronized (eDn) {
            for (b.a aVar : eDn) {
                if (aVar != null) {
                    aVar.fC(z);
                }
            }
            eDn.clear();
        }
    }
}
