package com.baidu.swan.apps.ap.d;
/* loaded from: classes10.dex */
public abstract class a implements Runnable {
    private b dyZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(b bVar) {
        this.dyZ = bVar;
        return this;
    }

    public void finish() {
        if (this.dyZ != null) {
            this.dyZ.a(this);
            this.dyZ = null;
        }
    }
}
