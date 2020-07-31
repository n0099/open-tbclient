package com.baidu.swan.e;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.webkit.sdk.WebKitFactory;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes18.dex */
public class c {
    private static c dDI;
    private boolean dDJ = false;
    private List<a> mListeners = new ArrayList();

    private c() {
    }

    public static c aPe() {
        if (dDI == null) {
            synchronized (c.class) {
                if (dDI == null) {
                    dDI = new c();
                }
            }
        }
        return dDI;
    }

    public synchronized void aPf() {
        if (!this.dDJ) {
            if (b.aOY()) {
                aPg();
            } else {
                this.dDJ = true;
                com.baidu.swan.a.d.a(new com.baidu.swan.a.a.a(b.aPb(), b.aPa()), new com.baidu.swan.a.a.d(new com.baidu.swan.a.e<com.baidu.swan.a.a.c>() { // from class: com.baidu.swan.e.c.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.a.e
                    /* renamed from: j */
                    public void V(com.baidu.swan.a.a.c cVar) {
                        c.this.g(cVar);
                    }

                    @Override // com.baidu.swan.a.e
                    public void Z(int i, String str) {
                        c.this.dDJ = false;
                        if (i == 1010) {
                            c.this.aPg();
                        } else {
                            c.this.aPh();
                        }
                    }

                    @Override // com.baidu.swan.a.e
                    public void q(long j, long j2) {
                        c.this.u(j, j2);
                    }
                }));
            }
        }
    }

    public synchronized c a(a aVar) {
        c cVar;
        if (aVar == null) {
            cVar = this;
        } else {
            if (!this.mListeners.contains(aVar)) {
                this.mListeners.add(aVar);
            }
            cVar = this;
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aPg() {
        for (a aVar : this.mListeners) {
            aVar.onSuccess();
        }
        this.mListeners.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aPh() {
        for (a aVar : this.mListeners) {
            aVar.onFail();
        }
        this.mListeners.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void u(long j, long j2) {
        for (a aVar : this.mListeners) {
            aVar.onProgress(j, j2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void g(com.baidu.swan.a.a.c cVar) {
        if (e.k(cVar)) {
            b.gX(true);
            h(cVar);
        } else {
            b.gX(false);
            i(cVar);
        }
    }

    private synchronized void h(final com.baidu.swan.a.a.c cVar) {
        WebKitFactory.installAsync("file://" + cVar.filePath, new WebKitFactory.WebkitInstallListener() { // from class: com.baidu.swan.e.c.2
            @Override // com.baidu.webkit.sdk.WebKitFactory.WebkitInstallListener
            public void onInstallStart() {
            }

            @Override // com.baidu.webkit.sdk.WebKitFactory.WebkitInstallListener
            public void onInstallFinish(int i, String str) {
                if (!c.this.aPi()) {
                    c.this.dDJ = false;
                    c.this.aPh();
                    return;
                }
                b.ae(cVar.versionName, cVar.versionCode);
                c.this.dDJ = false;
                c.this.aPg();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean aPi() {
        return new d(AppRuntime.getAppContext()).aPk();
    }

    private synchronized void i(com.baidu.swan.a.a.c cVar) {
        if (e.unzipFile(cVar.filePath, b.cfS)) {
            b.ae(cVar.versionName, cVar.versionCode);
            this.dDJ = false;
            aPg();
        } else {
            this.dDJ = false;
            aPh();
        }
    }
}
