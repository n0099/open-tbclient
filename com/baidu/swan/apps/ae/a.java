package com.baidu.swan.apps.ae;
/* loaded from: classes2.dex */
public class a<ImplemenT> {
    private ImplemenT aNK;
    private com.baidu.swan.apps.an.c.b<ImplemenT> aNL;

    public a<ImplemenT> a(com.baidu.swan.apps.an.c.b<ImplemenT> bVar) {
        this.aNL = bVar;
        return this;
    }

    protected a<ImplemenT> IS() {
        return b(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a<ImplemenT> b(com.baidu.swan.apps.an.c.b<ImplemenT> bVar) {
        if (bVar == null) {
            bVar = this.aNL;
        }
        if (bVar != null) {
            ImplemenT uR = bVar.uR();
            if (uR == null) {
                uR = this.aNK;
            }
            this.aNK = uR;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a<ImplemenT> IT() {
        this.aNK = null;
        return this;
    }

    public ImplemenT get() {
        if (!IU()) {
            IS();
        }
        return this.aNK;
    }

    public boolean IU() {
        return this.aNK != null;
    }
}
