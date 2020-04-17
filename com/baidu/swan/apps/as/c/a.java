package com.baidu.swan.apps.as.c;
/* loaded from: classes11.dex */
public abstract class a implements Runnable {
    private b cyc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(b bVar) {
        this.cyc = bVar;
        return this;
    }

    public void finish() {
        if (this.cyc != null) {
            this.cyc.a(this);
            this.cyc = null;
        }
    }
}
