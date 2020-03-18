package com.baidu.swan.apps.as.c;
/* loaded from: classes11.dex */
public abstract class a implements Runnable {
    private b bZj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(b bVar) {
        this.bZj = bVar;
        return this;
    }

    public void finish() {
        if (this.bZj != null) {
            this.bZj.a(this);
            this.bZj = null;
        }
    }
}
