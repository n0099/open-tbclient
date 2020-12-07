package com.baidu.swan.d;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.pms.e.b;
import com.baidu.webkit.sdk.WebKitFactory;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes6.dex */
public final class c implements com.baidu.swan.pms.e.b {
    private static boolean euK = false;
    private static final Set<b.a> euL = new HashSet();

    @Override // com.baidu.swan.pms.e.b
    public void a(String str, b.a aVar) {
        synchronized (euL) {
            euL.add(aVar);
            if (!euK) {
                euK = true;
                WebKitFactory.installAsync("file://" + str, new WebKitFactory.WebkitInstallListener() { // from class: com.baidu.swan.d.c.1
                    @Override // com.baidu.webkit.sdk.WebKitFactory.WebkitInstallListener
                    public void onInstallStart() {
                    }

                    @Override // com.baidu.webkit.sdk.WebKitFactory.WebkitInstallListener
                    public void onInstallFinish(int i, String str2) {
                        synchronized (c.euL) {
                            a.iz(true);
                            c.this.iA(new b(AppRuntime.getAppContext()).bhK());
                            boolean unused = c.euK = false;
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iA(boolean z) {
        synchronized (euL) {
            for (b.a aVar : euL) {
                if (aVar != null) {
                    aVar.fv(z);
                }
            }
            euL.clear();
        }
    }
}
