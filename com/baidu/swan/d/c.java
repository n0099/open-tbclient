package com.baidu.swan.d;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.pms.e.b;
import com.baidu.webkit.sdk.WebKitFactory;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes6.dex */
public final class c implements com.baidu.swan.pms.e.b {
    private static boolean enK = false;
    private static final Set<b.a> enL = new HashSet();

    @Override // com.baidu.swan.pms.e.b
    public void a(String str, b.a aVar) {
        synchronized (enL) {
            enL.add(aVar);
            if (!enK) {
                enK = true;
                WebKitFactory.installAsync("file://" + str, new WebKitFactory.WebkitInstallListener() { // from class: com.baidu.swan.d.c.1
                    @Override // com.baidu.webkit.sdk.WebKitFactory.WebkitInstallListener
                    public void onInstallStart() {
                    }

                    @Override // com.baidu.webkit.sdk.WebKitFactory.WebkitInstallListener
                    public void onInstallFinish(int i, String str2) {
                        synchronized (c.enL) {
                            a.ik(true);
                            c.this.il(new b(AppRuntime.getAppContext()).beF());
                            boolean unused = c.enK = false;
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void il(boolean z) {
        synchronized (enL) {
            for (b.a aVar : enL) {
                if (aVar != null) {
                    aVar.fg(z);
                }
            }
            enL.clear();
        }
    }
}
