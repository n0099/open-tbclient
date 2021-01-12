package com.baidu.swan.d;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.pms.e.b;
import com.baidu.webkit.sdk.WebKitFactory;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public final class c implements com.baidu.swan.pms.e.b {
    private static boolean ezF = false;
    private static final Set<b.a> ezG = new HashSet();

    @Override // com.baidu.swan.pms.e.b
    public void a(String str, b.a aVar) {
        synchronized (ezG) {
            ezG.add(aVar);
            if (!ezF) {
                ezF = true;
                WebKitFactory.installAsync("file://" + str, new WebKitFactory.WebkitInstallListener() { // from class: com.baidu.swan.d.c.1
                    @Override // com.baidu.webkit.sdk.WebKitFactory.WebkitInstallListener
                    public void onInstallStart() {
                    }

                    @Override // com.baidu.webkit.sdk.WebKitFactory.WebkitInstallListener
                    public void onInstallFinish(int i, String str2) {
                        synchronized (c.ezG) {
                            a.iQ(true);
                            c.this.iR(new b(AppRuntime.getAppContext()).bgn());
                            boolean unused = c.ezF = false;
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iR(boolean z) {
        synchronized (ezG) {
            for (b.a aVar : ezG) {
                if (aVar != null) {
                    aVar.fA(z);
                }
            }
            ezG.clear();
        }
    }
}
