package com.baidu.swan.apps.an.c;
/* loaded from: classes2.dex */
public abstract class a implements Runnable {
    private b baJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(b bVar) {
        this.baJ = bVar;
        return this;
    }

    public void finish() {
        if (this.baJ != null) {
            this.baJ.a(this);
            this.baJ = null;
        }
    }
}
