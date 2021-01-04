package com.baidu.ar.b.b;
/* loaded from: classes6.dex */
public abstract class b extends com.baidu.ar.c.a<a> {
    private int cI;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a {
        int cJ;
        int type;

        a(int i, int i2) {
            this.type = i;
            this.cJ = i2;
        }
    }

    public b(int i) {
        this.cI = i;
    }

    public abstract int a(com.baidu.ar.mdl.a aVar);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.ar.c.a
    /* renamed from: az */
    public a ay() {
        int i = 0;
        if (!com.baidu.ar.b.a.as().c(this.cI) && (i = a(com.baidu.ar.b.a.as().g(this.cI))) == 0) {
            com.baidu.ar.b.a.as().d(this.cI);
        }
        return new a(this.cI, i);
    }
}
