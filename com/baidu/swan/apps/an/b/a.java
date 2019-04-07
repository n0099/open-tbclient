package com.baidu.swan.apps.an.b;
/* loaded from: classes2.dex */
public abstract class a implements Runnable {
    private b aWF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(b bVar) {
        this.aWF = bVar;
        return this;
    }

    public void finish() {
        if (this.aWF != null) {
            this.aWF.a(this);
            this.aWF = null;
        }
    }
}
