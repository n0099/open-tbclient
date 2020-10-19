package com.baidu.swan.d;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.pms.e.b;
import com.baidu.webkit.sdk.WebKitFactory;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes19.dex */
public final class c implements com.baidu.swan.pms.e.b {
    private static boolean ebc = false;
    private static final Set<b.a> ebd = new HashSet();

    @Override // com.baidu.swan.pms.e.b
    public void a(String str, b.a aVar) {
        synchronized (ebd) {
            ebd.add(aVar);
            if (!ebc) {
                ebc = true;
                WebKitFactory.installAsync("file://" + str, new WebKitFactory.WebkitInstallListener() { // from class: com.baidu.swan.d.c.1
                    @Override // com.baidu.webkit.sdk.WebKitFactory.WebkitInstallListener
                    public void onInstallStart() {
                    }

                    @Override // com.baidu.webkit.sdk.WebKitFactory.WebkitInstallListener
                    public void onInstallFinish(int i, String str2) {
                        synchronized (c.ebd) {
                            a.hL(true);
                            c.this.hM(new b(AppRuntime.getAppContext()).baT());
                            boolean unused = c.ebc = false;
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hM(boolean z) {
        synchronized (ebd) {
            for (b.a aVar : ebd) {
                if (aVar != null) {
                    aVar.eH(z);
                }
            }
            ebd.clear();
        }
    }
}
