package com.baidu.swan.apps.as.c;
/* loaded from: classes11.dex */
public abstract class a implements Runnable {
    private b bYW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(b bVar) {
        this.bYW = bVar;
        return this;
    }

    public void finish() {
        if (this.bYW != null) {
            this.bYW.a(this);
            this.bYW = null;
        }
    }
}
