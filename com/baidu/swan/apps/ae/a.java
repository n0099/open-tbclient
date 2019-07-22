package com.baidu.swan.apps.ae;
/* loaded from: classes2.dex */
public class a<ImplemenT> {
    private ImplemenT aQy;
    private com.baidu.swan.apps.an.d.b<ImplemenT> aQz;

    public a<ImplemenT> a(com.baidu.swan.apps.an.d.b<ImplemenT> bVar) {
        this.aQz = bVar;
        return this;
    }

    protected a<ImplemenT> Ma() {
        return b(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a<ImplemenT> b(com.baidu.swan.apps.an.d.b<ImplemenT> bVar) {
        if (bVar == null) {
            bVar = this.aQz;
        }
        if (bVar != null) {
            ImplemenT wc = bVar.wc();
            if (wc == null) {
                wc = this.aQy;
            }
            this.aQy = wc;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a<ImplemenT> Mb() {
        this.aQy = null;
        return this;
    }

    public ImplemenT get() {
        if (!Mc()) {
            Ma();
        }
        return this.aQy;
    }

    public boolean Mc() {
        return this.aQy != null;
    }
}
