package com.baidu.swan.apps.ao.d;
/* loaded from: classes9.dex */
public abstract class a implements Runnable {
    private b dQm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(b bVar) {
        this.dQm = bVar;
        return this;
    }

    public void finish() {
        if (this.dQm != null) {
            this.dQm.a(this);
            this.dQm = null;
        }
    }
}
