package com.baidu.swan.apps.ae;
/* loaded from: classes2.dex */
public class a<ImplemenT> {
    private ImplemenT aPO;
    private com.baidu.swan.apps.an.d.b<ImplemenT> aPP;

    public a<ImplemenT> a(com.baidu.swan.apps.an.d.b<ImplemenT> bVar) {
        this.aPP = bVar;
        return this;
    }

    protected a<ImplemenT> Ln() {
        return b(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a<ImplemenT> b(com.baidu.swan.apps.an.d.b<ImplemenT> bVar) {
        if (bVar == null) {
            bVar = this.aPP;
        }
        if (bVar != null) {
            ImplemenT vB = bVar.vB();
            if (vB == null) {
                vB = this.aPO;
            }
            this.aPO = vB;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a<ImplemenT> Lo() {
        this.aPO = null;
        return this;
    }

    public ImplemenT get() {
        if (!Lp()) {
            Ln();
        }
        return this.aPO;
    }

    public boolean Lp() {
        return this.aPO != null;
    }
}
