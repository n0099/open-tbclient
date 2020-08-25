package com.baidu.swan.apps.ap.d;
/* loaded from: classes8.dex */
public abstract class a implements Runnable {
    private b dcm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(b bVar) {
        this.dcm = bVar;
        return this;
    }

    public void finish() {
        if (this.dcm != null) {
            this.dcm.a(this);
            this.dcm = null;
        }
    }
}
