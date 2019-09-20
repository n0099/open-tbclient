package com.baidu.swan.apps.an.c;
/* loaded from: classes2.dex */
public abstract class a implements Runnable {
    private b bbh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(b bVar) {
        this.bbh = bVar;
        return this;
    }

    public void finish() {
        if (this.bbh != null) {
            this.bbh.a(this);
            this.bbh = null;
        }
    }
}
