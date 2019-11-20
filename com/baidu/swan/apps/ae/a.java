package com.baidu.swan.apps.ae;
/* loaded from: classes2.dex */
public class a<ImplemenT> {
    private ImplemenT bjI;
    private com.baidu.swan.apps.an.d.b<ImplemenT> bjJ;

    public a<ImplemenT> a(com.baidu.swan.apps.an.d.b<ImplemenT> bVar) {
        this.bjJ = bVar;
        return this;
    }

    protected a<ImplemenT> QX() {
        return b(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a<ImplemenT> b(com.baidu.swan.apps.an.d.b<ImplemenT> bVar) {
        if (bVar == null) {
            bVar = this.bjJ;
        }
        if (bVar != null) {
            ImplemenT Bb = bVar.Bb();
            if (Bb == null) {
                Bb = this.bjI;
            }
            this.bjI = Bb;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a<ImplemenT> QY() {
        this.bjI = null;
        return this;
    }

    public ImplemenT get() {
        if (!QZ()) {
            QX();
        }
        return this.bjI;
    }

    public boolean QZ() {
        return this.bjI != null;
    }
}
