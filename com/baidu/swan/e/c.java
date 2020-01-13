package com.baidu.swan.e;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.webkit.sdk.WebKitFactory;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class c {
    private static c cBX;
    private boolean cBY = false;
    private List<a> mListeners = new ArrayList();

    private c() {
    }

    public static c aul() {
        if (cBX == null) {
            synchronized (c.class) {
                if (cBX == null) {
                    cBX = new c();
                }
            }
        }
        return cBX;
    }

    public synchronized void aum() {
        if (!this.cBY) {
            if (b.auf()) {
                aun();
            } else {
                this.cBY = true;
                com.baidu.swan.a.d.a(new com.baidu.swan.a.a.a(b.aui(), b.auh()), new com.baidu.swan.a.a.d(new com.baidu.swan.a.e<com.baidu.swan.a.a.c>() { // from class: com.baidu.swan.e.c.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.a.e
                    /* renamed from: j */
                    public void N(com.baidu.swan.a.a.c cVar) {
                        c.this.g(cVar);
                    }

                    @Override // com.baidu.swan.a.e
                    public void C(int i, String str) {
                        c.this.cBY = false;
                        if (i == 1010) {
                            c.this.aun();
                        } else {
                            c.this.auo();
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
    public synchronized void aun() {
        for (a aVar : this.mListeners) {
            aVar.onSuccess();
        }
        this.mListeners.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void auo() {
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
            b.fa(true);
            h(cVar);
        } else {
            b.fa(false);
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
                if (!c.this.aup()) {
                    c.this.cBY = false;
                    c.this.auo();
                    return;
                }
                b.W(cVar.versionName, cVar.versionCode);
                c.this.cBY = false;
                c.this.aun();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean aup() {
        return new d(AppRuntime.getAppContext()).aur();
    }

    private synchronized void i(com.baidu.swan.a.a.c cVar) {
        if (e.unzipFile(cVar.filePath, b.bmY)) {
            b.W(cVar.versionName, cVar.versionCode);
            this.cBY = false;
            aun();
        } else {
            this.cBY = false;
            auo();
        }
    }
}
