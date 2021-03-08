package com.baidu.swan.apps.ao.d;
/* loaded from: classes8.dex */
public abstract class a implements Runnable {
    private b dRN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(b bVar) {
        this.dRN = bVar;
        return this;
    }

    public void finish() {
        if (this.dRN != null) {
            this.dRN.a(this);
            this.dRN = null;
        }
    }
}
