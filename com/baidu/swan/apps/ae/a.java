package com.baidu.swan.apps.ae;
/* loaded from: classes2.dex */
public class a<ImplemenT> {
    private ImplemenT bka;
    private com.baidu.swan.apps.an.d.b<ImplemenT> bkb;

    public a<ImplemenT> a(com.baidu.swan.apps.an.d.b<ImplemenT> bVar) {
        this.bkb = bVar;
        return this;
    }

    protected a<ImplemenT> QW() {
        return b(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a<ImplemenT> b(com.baidu.swan.apps.an.d.b<ImplemenT> bVar) {
        if (bVar == null) {
            bVar = this.bkb;
        }
        if (bVar != null) {
            ImplemenT Ba = bVar.Ba();
            if (Ba == null) {
                Ba = this.bka;
            }
            this.bka = Ba;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a<ImplemenT> QX() {
        this.bka = null;
        return this;
    }

    public ImplemenT get() {
        if (!QY()) {
            QW();
        }
        return this.bka;
    }

    public boolean QY() {
        return this.bka != null;
    }
}
