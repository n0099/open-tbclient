package com.baidu.swan.apps.ae;
/* loaded from: classes2.dex */
public class a<ImplemenT> {
    private ImplemenT aNG;
    private com.baidu.swan.apps.an.c.b<ImplemenT> aNH;

    public a<ImplemenT> a(com.baidu.swan.apps.an.c.b<ImplemenT> bVar) {
        this.aNH = bVar;
        return this;
    }

    protected a<ImplemenT> IU() {
        return b(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a<ImplemenT> b(com.baidu.swan.apps.an.c.b<ImplemenT> bVar) {
        if (bVar == null) {
            bVar = this.aNH;
        }
        if (bVar != null) {
            ImplemenT uS = bVar.uS();
            if (uS == null) {
                uS = this.aNG;
            }
            this.aNG = uS;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a<ImplemenT> IV() {
        this.aNG = null;
        return this;
    }

    public ImplemenT get() {
        if (!IW()) {
            IU();
        }
        return this.aNG;
    }

    public boolean IW() {
        return this.aNG != null;
    }
}
