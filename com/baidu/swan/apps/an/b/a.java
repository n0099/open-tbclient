package com.baidu.swan.apps.an.b;
/* loaded from: classes2.dex */
public abstract class a implements Runnable {
    private b aWB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(b bVar) {
        this.aWB = bVar;
        return this;
    }

    public void finish() {
        if (this.aWB != null) {
            this.aWB.a(this);
            this.aWB = null;
        }
    }
}
