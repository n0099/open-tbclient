package com.baidu.swan.apps.aq.d;
/* loaded from: classes11.dex */
public abstract class a implements Runnable {
    private b cLb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(b bVar) {
        this.cLb = bVar;
        return this;
    }

    public void finish() {
        if (this.cLb != null) {
            this.cLb.a(this);
            this.cLb = null;
        }
    }
}
