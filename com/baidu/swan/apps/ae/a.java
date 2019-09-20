package com.baidu.swan.apps.ae;
/* loaded from: classes2.dex */
public class a<ImplemenT> {
    private ImplemenT aQW;
    private com.baidu.swan.apps.an.d.b<ImplemenT> aQX;

    public a<ImplemenT> a(com.baidu.swan.apps.an.d.b<ImplemenT> bVar) {
        this.aQX = bVar;
        return this;
    }

    protected a<ImplemenT> Me() {
        return b(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a<ImplemenT> b(com.baidu.swan.apps.an.d.b<ImplemenT> bVar) {
        if (bVar == null) {
            bVar = this.aQX;
        }
        if (bVar != null) {
            ImplemenT wg = bVar.wg();
            if (wg == null) {
                wg = this.aQW;
            }
            this.aQW = wg;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a<ImplemenT> Mf() {
        this.aQW = null;
        return this;
    }

    public ImplemenT get() {
        if (!Mg()) {
            Me();
        }
        return this.aQW;
    }

    public boolean Mg() {
        return this.aQW != null;
    }
}
