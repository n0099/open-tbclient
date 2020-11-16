package com.baidu.swan.apps.ap.d;
/* loaded from: classes7.dex */
public abstract class a implements Runnable {
    private b dDk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(b bVar) {
        this.dDk = bVar;
        return this;
    }

    public void finish() {
        if (this.dDk != null) {
            this.dDk.a(this);
            this.dDk = null;
        }
    }
}
