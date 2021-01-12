package com.baidu.swan.apps.ao.d;
/* loaded from: classes8.dex */
public abstract class a implements Runnable {
    private b dOg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(b bVar) {
        this.dOg = bVar;
        return this;
    }

    public void finish() {
        if (this.dOg != null) {
            this.dOg.a(this);
            this.dOg = null;
        }
    }
}
