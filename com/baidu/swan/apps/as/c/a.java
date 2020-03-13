package com.baidu.swan.apps.as.c;
/* loaded from: classes11.dex */
public abstract class a implements Runnable {
    private b bYY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(b bVar) {
        this.bYY = bVar;
        return this;
    }

    public void finish() {
        if (this.bYY != null) {
            this.bYY.a(this);
            this.bYY = null;
        }
    }
}
