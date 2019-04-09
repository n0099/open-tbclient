package com.baidu.swan.apps.an.b;
/* loaded from: classes2.dex */
public abstract class a implements Runnable {
    private b aWG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(b bVar) {
        this.aWG = bVar;
        return this;
    }

    public void finish() {
        if (this.aWG != null) {
            this.aWG.a(this);
            this.aWG = null;
        }
    }
}
