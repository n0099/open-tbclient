package com.baidu.swan.f;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.webkit.sdk.WebKitFactory;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class c {
    private static c dtc;
    private boolean dtd = false;
    private List<a> mListeners = new ArrayList();

    private c() {
    }

    public static c aKk() {
        if (dtc == null) {
            synchronized (c.class) {
                if (dtc == null) {
                    dtc = new c();
                }
            }
        }
        return dtc;
    }

    public synchronized void aKl() {
        if (!this.dtd) {
            if (b.aKe()) {
                aKm();
            } else {
                this.dtd = true;
                com.baidu.swan.a.d.a(new com.baidu.swan.a.a.a(b.aKh(), b.aKg()), new com.baidu.swan.a.a.d(new com.baidu.swan.a.e<com.baidu.swan.a.a.c>() { // from class: com.baidu.swan.f.c.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.a.e
                    /* renamed from: j */
                    public void V(com.baidu.swan.a.a.c cVar) {
                        c.this.g(cVar);
                    }

                    @Override // com.baidu.swan.a.e
                    public void W(int i, String str) {
                        c.this.dtd = false;
                        if (i == 1010) {
                            c.this.aKm();
                        } else {
                            c.this.aKn();
                        }
                    }

                    @Override // com.baidu.swan.a.e
                    public void p(long j, long j2) {
                        c.this.t(j, j2);
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
    public synchronized void aKm() {
        for (a aVar : this.mListeners) {
            aVar.onSuccess();
        }
        this.mListeners.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aKn() {
        for (a aVar : this.mListeners) {
            aVar.onFail();
        }
        this.mListeners.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void t(long j, long j2) {
        for (a aVar : this.mListeners) {
            aVar.onProgress(j, j2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void g(com.baidu.swan.a.a.c cVar) {
        if (e.k(cVar)) {
            b.gx(true);
            h(cVar);
        } else {
            b.gx(false);
            i(cVar);
        }
    }

    private synchronized void h(final com.baidu.swan.a.a.c cVar) {
        WebKitFactory.installAsync("file://" + cVar.filePath, new WebKitFactory.WebkitInstallListener() { // from class: com.baidu.swan.f.c.2
            @Override // com.baidu.webkit.sdk.WebKitFactory.WebkitInstallListener
            public void onInstallStart() {
            }

            @Override // com.baidu.webkit.sdk.WebKitFactory.WebkitInstallListener
            public void onInstallFinish(int i, String str) {
                if (!c.this.aKo()) {
                    c.this.dtd = false;
                    c.this.aKn();
                    return;
                }
                b.ad(cVar.versionName, cVar.versionCode);
                c.this.dtd = false;
                c.this.aKm();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean aKo() {
        return new d(AppRuntime.getAppContext()).aKq();
    }

    private synchronized void i(com.baidu.swan.a.a.c cVar) {
        if (e.unzipFile(cVar.filePath, b.bZt)) {
            b.ad(cVar.versionName, cVar.versionCode);
            this.dtd = false;
            aKm();
        } else {
            this.dtd = false;
            aKn();
        }
    }
}
