package com.baidu.swan.d;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.pms.e.b;
import com.baidu.webkit.sdk.WebKitFactory;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public final class c implements com.baidu.swan.pms.e.b {
    private static boolean eEr = false;
    private static final Set<b.a> eEs = new HashSet();

    @Override // com.baidu.swan.pms.e.b
    public void a(String str, b.a aVar) {
        synchronized (eEs) {
            eEs.add(aVar);
            if (!eEr) {
                eEr = true;
                WebKitFactory.installAsync("file://" + str, new WebKitFactory.WebkitInstallListener() { // from class: com.baidu.swan.d.c.1
                    @Override // com.baidu.webkit.sdk.WebKitFactory.WebkitInstallListener
                    public void onInstallStart() {
                    }

                    @Override // com.baidu.webkit.sdk.WebKitFactory.WebkitInstallListener
                    public void onInstallFinish(int i, String str2) {
                        synchronized (c.eEs) {
                            a.iU(true);
                            c.this.iV(new b(AppRuntime.getAppContext()).bkg());
                            boolean unused = c.eEr = false;
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iV(boolean z) {
        synchronized (eEs) {
            for (b.a aVar : eEs) {
                if (aVar != null) {
                    aVar.fE(z);
                }
            }
            eEs.clear();
        }
    }
}
