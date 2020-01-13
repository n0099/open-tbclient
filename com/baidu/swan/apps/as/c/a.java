package com.baidu.swan.apps.as.c;
/* loaded from: classes10.dex */
public abstract class a implements Runnable {
    private b bUS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(b bVar) {
        this.bUS = bVar;
        return this;
    }

    public void finish() {
        if (this.bUS != null) {
            this.bUS.a(this);
            this.bUS = null;
        }
    }
}
