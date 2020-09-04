package com.baidu.swan.apps.ap.d;
/* loaded from: classes8.dex */
public abstract class a implements Runnable {
    private b dcq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(b bVar) {
        this.dcq = bVar;
        return this;
    }

    public void finish() {
        if (this.dcq != null) {
            this.dcq.a(this);
            this.dcq = null;
        }
    }
}
