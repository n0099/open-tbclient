package com.baidu.swan.apps.ae;
/* loaded from: classes2.dex */
public class a<ImplemenT> {
    private ImplemenT aNH;
    private com.baidu.swan.apps.an.c.b<ImplemenT> aNI;

    public a<ImplemenT> a(com.baidu.swan.apps.an.c.b<ImplemenT> bVar) {
        this.aNI = bVar;
        return this;
    }

    protected a<ImplemenT> IU() {
        return b(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a<ImplemenT> b(com.baidu.swan.apps.an.c.b<ImplemenT> bVar) {
        if (bVar == null) {
            bVar = this.aNI;
        }
        if (bVar != null) {
            ImplemenT uS = bVar.uS();
            if (uS == null) {
                uS = this.aNH;
            }
            this.aNH = uS;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a<ImplemenT> IV() {
        this.aNH = null;
        return this;
    }

    public ImplemenT get() {
        if (!IW()) {
            IU();
        }
        return this.aNH;
    }

    public boolean IW() {
        return this.aNH != null;
    }
}
