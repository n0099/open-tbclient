package com.baidu.swan.apps.ae;
/* loaded from: classes2.dex */
public class a<ImplemenT> {
    private ImplemenT aNL;
    private com.baidu.swan.apps.an.c.b<ImplemenT> aNM;

    public a<ImplemenT> a(com.baidu.swan.apps.an.c.b<ImplemenT> bVar) {
        this.aNM = bVar;
        return this;
    }

    protected a<ImplemenT> IS() {
        return b(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a<ImplemenT> b(com.baidu.swan.apps.an.c.b<ImplemenT> bVar) {
        if (bVar == null) {
            bVar = this.aNM;
        }
        if (bVar != null) {
            ImplemenT uR = bVar.uR();
            if (uR == null) {
                uR = this.aNL;
            }
            this.aNL = uR;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a<ImplemenT> IT() {
        this.aNL = null;
        return this;
    }

    public ImplemenT get() {
        if (!IU()) {
            IS();
        }
        return this.aNL;
    }

    public boolean IU() {
        return this.aNL != null;
    }
}
