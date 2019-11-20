package com.baidu.swan.apps.an.c;
/* loaded from: classes2.dex */
public abstract class a implements Runnable {
    private b btp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(b bVar) {
        this.btp = bVar;
        return this;
    }

    public void finish() {
        if (this.btp != null) {
            this.btp.a(this);
            this.btp = null;
        }
    }
}
