package com.baidu.swan.apps.ap.d;
/* loaded from: classes25.dex */
public abstract class a implements Runnable {
    private b dKi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(b bVar) {
        this.dKi = bVar;
        return this;
    }

    public void finish() {
        if (this.dKi != null) {
            this.dKi.a(this);
            this.dKi = null;
        }
    }
}
