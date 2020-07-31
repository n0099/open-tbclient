package com.baidu.swan.apps.aq.d;
/* loaded from: classes7.dex */
public abstract class a implements Runnable {
    private b cTm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(b bVar) {
        this.cTm = bVar;
        return this;
    }

    public void finish() {
        if (this.cTm != null) {
            this.cTm.a(this);
            this.cTm = null;
        }
    }
}
