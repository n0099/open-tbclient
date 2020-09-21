package com.baidu.swan.apps.ap.d;
/* loaded from: classes3.dex */
public abstract class a implements Runnable {
    private b det;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(b bVar) {
        this.det = bVar;
        return this;
    }

    public void finish() {
        if (this.det != null) {
            this.det.a(this);
            this.det = null;
        }
    }
}
