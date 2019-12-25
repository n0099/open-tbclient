package com.baidu.swan.e;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.webkit.sdk.WebKitFactory;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class c {
    private static c cBM;
    private boolean cBN = false;
    private List<a> mListeners = new ArrayList();

    private c() {
    }

    public static c atS() {
        if (cBM == null) {
            synchronized (c.class) {
                if (cBM == null) {
                    cBM = new c();
                }
            }
        }
        return cBM;
    }

    public synchronized void atT() {
        if (!this.cBN) {
            if (b.atM()) {
                atU();
            } else {
                this.cBN = true;
                com.baidu.swan.a.d.a(new com.baidu.swan.a.a.a(b.atP(), b.atO()), new com.baidu.swan.a.a.d(new com.baidu.swan.a.e<com.baidu.swan.a.a.c>() { // from class: com.baidu.swan.e.c.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.a.e
                    /* renamed from: j */
                    public void N(com.baidu.swan.a.a.c cVar) {
                        c.this.g(cVar);
                    }

                    @Override // com.baidu.swan.a.e
                    public void A(int i, String str) {
                        c.this.cBN = false;
                        if (i == 1010) {
                            c.this.atU();
                        } else {
                            c.this.atV();
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
    public synchronized void atU() {
        for (a aVar : this.mListeners) {
            aVar.onSuccess();
        }
        this.mListeners.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void atV() {
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
            b.eV(true);
            h(cVar);
        } else {
            b.eV(false);
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
                if (!c.this.atW()) {
                    c.this.cBN = false;
                    c.this.atV();
                    return;
                }
                b.W(cVar.versionName, cVar.versionCode);
                c.this.cBN = false;
                c.this.atU();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean atW() {
        return new d(AppRuntime.getAppContext()).atY();
    }

    private synchronized void i(com.baidu.swan.a.a.c cVar) {
        if (e.unzipFile(cVar.filePath, b.bmi)) {
            b.W(cVar.versionName, cVar.versionCode);
            this.cBN = false;
            atU();
        } else {
            this.cBN = false;
            atV();
        }
    }
}
