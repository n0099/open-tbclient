package com.baidu.swan.d;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.pms.e.b;
import com.baidu.webkit.sdk.WebKitFactory;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public final class c implements com.baidu.swan.pms.e.b {
    private static boolean dMY = false;
    private static final Set<b.a> dMZ = new HashSet();

    @Override // com.baidu.swan.pms.e.b
    public void a(String str, b.a aVar) {
        synchronized (dMZ) {
            dMZ.add(aVar);
            if (!dMY) {
                dMY = true;
                WebKitFactory.installAsync("file://" + str, new WebKitFactory.WebkitInstallListener() { // from class: com.baidu.swan.d.c.1
                    @Override // com.baidu.webkit.sdk.WebKitFactory.WebkitInstallListener
                    public void onInstallStart() {
                    }

                    @Override // com.baidu.webkit.sdk.WebKitFactory.WebkitInstallListener
                    public void onInstallFinish(int i, String str2) {
                        synchronized (c.dMZ) {
                            a.hs(true);
                            c.this.ht(new b(AppRuntime.getAppContext()).aXz());
                            boolean unused = c.dMY = false;
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ht(boolean z) {
        synchronized (dMZ) {
            for (b.a aVar : dMZ) {
                if (aVar != null) {
                    aVar.en(z);
                }
            }
            dMZ.clear();
        }
    }
}
