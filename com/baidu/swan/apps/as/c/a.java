package com.baidu.swan.apps.as.c;
/* loaded from: classes9.dex */
public abstract class a implements Runnable {
    private b bUG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(b bVar) {
        this.bUG = bVar;
        return this;
    }

    public void finish() {
        if (this.bUG != null) {
            this.bUG.a(this);
            this.bUG = null;
        }
    }
}
