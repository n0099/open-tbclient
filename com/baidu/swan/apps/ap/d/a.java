package com.baidu.swan.apps.ap.d;
/* loaded from: classes10.dex */
public abstract class a implements Runnable {
    private b dqz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(b bVar) {
        this.dqz = bVar;
        return this;
    }

    public void finish() {
        if (this.dqz != null) {
            this.dqz.a(this);
            this.dqz = null;
        }
    }
}
