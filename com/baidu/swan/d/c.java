package com.baidu.swan.d;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.pms.e.b;
import com.baidu.webkit.sdk.WebKitFactory;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public final class c implements com.baidu.swan.pms.e.b {
    private static boolean dMU = false;
    private static final Set<b.a> dMV = new HashSet();

    @Override // com.baidu.swan.pms.e.b
    public void a(String str, b.a aVar) {
        synchronized (dMV) {
            dMV.add(aVar);
            if (!dMU) {
                dMU = true;
                WebKitFactory.installAsync("file://" + str, new WebKitFactory.WebkitInstallListener() { // from class: com.baidu.swan.d.c.1
                    @Override // com.baidu.webkit.sdk.WebKitFactory.WebkitInstallListener
                    public void onInstallStart() {
                    }

                    @Override // com.baidu.webkit.sdk.WebKitFactory.WebkitInstallListener
                    public void onInstallFinish(int i, String str2) {
                        synchronized (c.dMV) {
                            a.hr(true);
                            c.this.hs(new b(AppRuntime.getAppContext()).aXz());
                            boolean unused = c.dMU = false;
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hs(boolean z) {
        synchronized (dMV) {
            for (b.a aVar : dMV) {
                if (aVar != null) {
                    aVar.em(z);
                }
            }
            dMV.clear();
        }
    }
}
