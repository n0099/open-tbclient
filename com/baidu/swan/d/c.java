package com.baidu.swan.d;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.pms.e.b;
import com.baidu.webkit.sdk.WebKitFactory;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes15.dex */
public final class c implements com.baidu.swan.pms.e.b {
    private static boolean eBL = false;
    private static final Set<b.a> eBM = new HashSet();

    @Override // com.baidu.swan.pms.e.b
    public void a(String str, b.a aVar) {
        synchronized (eBM) {
            eBM.add(aVar);
            if (!eBL) {
                eBL = true;
                WebKitFactory.installAsync("file://" + str, new WebKitFactory.WebkitInstallListener() { // from class: com.baidu.swan.d.c.1
                    @Override // com.baidu.webkit.sdk.WebKitFactory.WebkitInstallListener
                    public void onInstallStart() {
                    }

                    @Override // com.baidu.webkit.sdk.WebKitFactory.WebkitInstallListener
                    public void onInstallFinish(int i, String str2) {
                        synchronized (c.eBM) {
                            a.iS(true);
                            c.this.iT(new b(AppRuntime.getAppContext()).bgA());
                            boolean unused = c.eBL = false;
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iT(boolean z) {
        synchronized (eBM) {
            for (b.a aVar : eBM) {
                if (aVar != null) {
                    aVar.fC(z);
                }
            }
            eBM.clear();
        }
    }
}
