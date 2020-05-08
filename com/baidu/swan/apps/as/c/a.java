package com.baidu.swan.apps.as.c;
/* loaded from: classes11.dex */
public abstract class a implements Runnable {
    private b cyi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(b bVar) {
        this.cyi = bVar;
        return this;
    }

    public void finish() {
        if (this.cyi != null) {
            this.cyi.a(this);
            this.cyi = null;
        }
    }
}
