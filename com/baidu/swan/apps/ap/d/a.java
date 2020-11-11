package com.baidu.swan.apps.ap.d;
/* loaded from: classes10.dex */
public abstract class a implements Runnable {
    private b dER;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(b bVar) {
        this.dER = bVar;
        return this;
    }

    public void finish() {
        if (this.dER != null) {
            this.dER.a(this);
            this.dER = null;
        }
    }
}
