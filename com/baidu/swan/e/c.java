package com.baidu.swan.e;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.webkit.sdk.WebKitFactory;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class c {
    private static c cGi;
    private boolean cGj = false;
    private List<a> mListeners = new ArrayList();

    private c() {
    }

    public static c awE() {
        if (cGi == null) {
            synchronized (c.class) {
                if (cGi == null) {
                    cGi = new c();
                }
            }
        }
        return cGi;
    }

    public synchronized void awF() {
        if (!this.cGj) {
            if (b.awy()) {
                awG();
            } else {
                this.cGj = true;
                com.baidu.swan.a.d.a(new com.baidu.swan.a.a.a(b.awB(), b.awA()), new com.baidu.swan.a.a.d(new com.baidu.swan.a.e<com.baidu.swan.a.a.c>() { // from class: com.baidu.swan.e.c.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.a.e
                    /* renamed from: j */
                    public void P(com.baidu.swan.a.a.c cVar) {
                        c.this.g(cVar);
                    }

                    @Override // com.baidu.swan.a.e
                    public void E(int i, String str) {
                        c.this.cGj = false;
                        if (i == 1010) {
                            c.this.awG();
                        } else {
                            c.this.awH();
                        }
                    }

                    @Override // com.baidu.swan.a.e
                    public void n(long j, long j2) {
                        c.this.r(j, j2);
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
    public synchronized void awG() {
        for (a aVar : this.mListeners) {
            aVar.onSuccess();
        }
        this.mListeners.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void awH() {
        for (a aVar : this.mListeners) {
            aVar.onFail();
        }
        this.mListeners.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void r(long j, long j2) {
        for (a aVar : this.mListeners) {
            aVar.onProgress(j, j2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void g(com.baidu.swan.a.a.c cVar) {
        if (e.k(cVar)) {
            b.fi(true);
            h(cVar);
        } else {
            b.fi(false);
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
                if (!c.this.awI()) {
                    c.this.cGj = false;
                    c.this.awH();
                    return;
                }
                b.U(cVar.versionName, cVar.versionCode);
                c.this.cGj = false;
                c.this.awG();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean awI() {
        return new d(AppRuntime.getAppContext()).awK();
    }

    private synchronized void i(com.baidu.swan.a.a.c cVar) {
        if (e.unzipFile(cVar.filePath, b.brv)) {
            b.U(cVar.versionName, cVar.versionCode);
            this.cGj = false;
            awG();
        } else {
            this.cGj = false;
            awH();
        }
    }
}
