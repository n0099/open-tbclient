package com.baidu.swan.apps.aq.d;
/* loaded from: classes11.dex */
public abstract class a implements Runnable {
    private b cPL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(b bVar) {
        this.cPL = bVar;
        return this;
    }

    public void finish() {
        if (this.cPL != null) {
            this.cPL.a(this);
            this.cPL = null;
        }
    }
}
