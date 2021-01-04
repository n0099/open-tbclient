package com.baidu.swan.apps.ao.d;
/* loaded from: classes9.dex */
public abstract class a implements Runnable {
    private b dSS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(b bVar) {
        this.dSS = bVar;
        return this;
    }

    public void finish() {
        if (this.dSS != null) {
            this.dSS.a(this);
            this.dSS = null;
        }
    }
}
