package com.baidu.swan.e;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.webkit.sdk.WebKitFactory;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class c {
    private static c cFW;
    private boolean cFX = false;
    private List<a> mListeners = new ArrayList();

    private c() {
    }

    public static c awB() {
        if (cFW == null) {
            synchronized (c.class) {
                if (cFW == null) {
                    cFW = new c();
                }
            }
        }
        return cFW;
    }

    public synchronized void awC() {
        if (!this.cFX) {
            if (b.awv()) {
                awD();
            } else {
                this.cFX = true;
                com.baidu.swan.a.d.a(new com.baidu.swan.a.a.a(b.awy(), b.awx()), new com.baidu.swan.a.a.d(new com.baidu.swan.a.e<com.baidu.swan.a.a.c>() { // from class: com.baidu.swan.e.c.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.a.e
                    /* renamed from: j */
                    public void P(com.baidu.swan.a.a.c cVar) {
                        c.this.g(cVar);
                    }

                    @Override // com.baidu.swan.a.e
                    public void E(int i, String str) {
                        c.this.cFX = false;
                        if (i == 1010) {
                            c.this.awD();
                        } else {
                            c.this.awE();
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
    public synchronized void awD() {
        for (a aVar : this.mListeners) {
            aVar.onSuccess();
        }
        this.mListeners.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void awE() {
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
            b.fh(true);
            h(cVar);
        } else {
            b.fh(false);
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
                if (!c.this.awF()) {
                    c.this.cFX = false;
                    c.this.awE();
                    return;
                }
                b.U(cVar.versionName, cVar.versionCode);
                c.this.cFX = false;
                c.this.awD();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean awF() {
        return new d(AppRuntime.getAppContext()).awH();
    }

    private synchronized void i(com.baidu.swan.a.a.c cVar) {
        if (e.unzipFile(cVar.filePath, b.bri)) {
            b.U(cVar.versionName, cVar.versionCode);
            this.cFX = false;
            awD();
        } else {
            this.cFX = false;
            awE();
        }
    }
}
