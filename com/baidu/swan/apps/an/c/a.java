package com.baidu.swan.apps.an.c;
/* loaded from: classes2.dex */
public abstract class a implements Runnable {
    private b aZZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(b bVar) {
        this.aZZ = bVar;
        return this;
    }

    public void finish() {
        if (this.aZZ != null) {
            this.aZZ.a(this);
            this.aZZ = null;
        }
    }
}
