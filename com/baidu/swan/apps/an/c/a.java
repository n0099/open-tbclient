package com.baidu.swan.apps.an.c;
/* loaded from: classes2.dex */
public abstract class a implements Runnable {
    private b buh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(b bVar) {
        this.buh = bVar;
        return this;
    }

    public void finish() {
        if (this.buh != null) {
            this.buh.a(this);
            this.buh = null;
        }
    }
}
