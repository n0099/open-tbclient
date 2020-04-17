package com.baidu.swan.e;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.webkit.sdk.WebKitFactory;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class c {
    private static c dfj;
    private boolean dfk = false;
    private List<a> mListeners = new ArrayList();

    private c() {
    }

    public static c aEP() {
        if (dfj == null) {
            synchronized (c.class) {
                if (dfj == null) {
                    dfj = new c();
                }
            }
        }
        return dfj;
    }

    public synchronized void aEQ() {
        if (!this.dfk) {
            if (b.aEJ()) {
                aER();
            } else {
                this.dfk = true;
                com.baidu.swan.a.d.a(new com.baidu.swan.a.a.a(b.aEM(), b.aEL()), new com.baidu.swan.a.a.d(new com.baidu.swan.a.e<com.baidu.swan.a.a.c>() { // from class: com.baidu.swan.e.c.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.a.e
                    /* renamed from: j */
                    public void Q(com.baidu.swan.a.a.c cVar) {
                        c.this.g(cVar);
                    }

                    @Override // com.baidu.swan.a.e
                    public void V(int i, String str) {
                        c.this.dfk = false;
                        if (i == 1010) {
                            c.this.aER();
                        } else {
                            c.this.aES();
                        }
                    }

                    @Override // com.baidu.swan.a.e
                    public void o(long j, long j2) {
                        c.this.s(j, j2);
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
    public synchronized void aER() {
        for (a aVar : this.mListeners) {
            aVar.onSuccess();
        }
        this.mListeners.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aES() {
        for (a aVar : this.mListeners) {
            aVar.onFail();
        }
        this.mListeners.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void s(long j, long j2) {
        for (a aVar : this.mListeners) {
            aVar.onProgress(j, j2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void g(com.baidu.swan.a.a.c cVar) {
        if (e.k(cVar)) {
            b.gf(true);
            h(cVar);
        } else {
            b.gf(false);
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
                if (!c.this.aET()) {
                    c.this.dfk = false;
                    c.this.aES();
                    return;
                }
                b.ac(cVar.versionName, cVar.versionCode);
                c.this.dfk = false;
                c.this.aER();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean aET() {
        return new d(AppRuntime.getAppContext()).aEV();
    }

    private synchronized void i(com.baidu.swan.a.a.c cVar) {
        if (e.unzipFile(cVar.filePath, b.bPC)) {
            b.ac(cVar.versionName, cVar.versionCode);
            this.dfk = false;
            aER();
        } else {
            this.dfk = false;
            aES();
        }
    }
}
