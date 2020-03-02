package com.baidu.swan.apps.as.c;
/* loaded from: classes11.dex */
public abstract class a implements Runnable {
    private b bYX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(b bVar) {
        this.bYX = bVar;
        return this;
    }

    public void finish() {
        if (this.bYX != null) {
            this.bYX.a(this);
            this.bYX = null;
        }
    }
}
