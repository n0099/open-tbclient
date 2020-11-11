package com.baidu.swan.d;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.pms.e.b;
import com.baidu.webkit.sdk.WebKitFactory;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes19.dex */
public final class c implements com.baidu.swan.pms.e.b {
    private static boolean eps = false;
    private static final Set<b.a> ept = new HashSet();

    @Override // com.baidu.swan.pms.e.b
    public void a(String str, b.a aVar) {
        synchronized (ept) {
            ept.add(aVar);
            if (!eps) {
                eps = true;
                WebKitFactory.installAsync("file://" + str, new WebKitFactory.WebkitInstallListener() { // from class: com.baidu.swan.d.c.1
                    @Override // com.baidu.webkit.sdk.WebKitFactory.WebkitInstallListener
                    public void onInstallStart() {
                    }

                    @Override // com.baidu.webkit.sdk.WebKitFactory.WebkitInstallListener
                    public void onInstallFinish(int i, String str2) {
                        synchronized (c.ept) {
                            a.ih(true);
                            c.this.ii(new b(AppRuntime.getAppContext()).bfm());
                            boolean unused = c.eps = false;
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ii(boolean z) {
        synchronized (ept) {
            for (b.a aVar : ept) {
                if (aVar != null) {
                    aVar.fd(z);
                }
            }
            ept.clear();
        }
    }
}
