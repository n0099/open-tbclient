package com.baidu.swan.apps.an.b;
/* loaded from: classes2.dex */
public abstract class a implements Runnable {
    private b aWC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(b bVar) {
        this.aWC = bVar;
        return this;
    }

    public void finish() {
        if (this.aWC != null) {
            this.aWC.a(this);
            this.aWC = null;
        }
    }
}
