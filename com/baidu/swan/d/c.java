package com.baidu.swan.d;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.pms.e.b;
import com.baidu.webkit.sdk.WebKitFactory;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes19.dex */
public final class c implements com.baidu.swan.pms.e.b {
    private static boolean ejy = false;
    private static final Set<b.a> ejz = new HashSet();

    @Override // com.baidu.swan.pms.e.b
    public void a(String str, b.a aVar) {
        synchronized (ejz) {
            ejz.add(aVar);
            if (!ejy) {
                ejy = true;
                WebKitFactory.installAsync("file://" + str, new WebKitFactory.WebkitInstallListener() { // from class: com.baidu.swan.d.c.1
                    @Override // com.baidu.webkit.sdk.WebKitFactory.WebkitInstallListener
                    public void onInstallStart() {
                    }

                    @Override // com.baidu.webkit.sdk.WebKitFactory.WebkitInstallListener
                    public void onInstallFinish(int i, String str2) {
                        synchronized (c.ejz) {
                            a.hY(true);
                            c.this.hZ(new b(AppRuntime.getAppContext()).bcM());
                            boolean unused = c.ejy = false;
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hZ(boolean z) {
        synchronized (ejz) {
            for (b.a aVar : ejz) {
                if (aVar != null) {
                    aVar.eU(z);
                }
            }
            ejz.clear();
        }
    }
}
