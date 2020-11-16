package com.baidu.ar.b.b;
/* loaded from: classes12.dex */
public abstract class b extends com.baidu.ar.c.a<a> {
    private int cD;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public class a {
        int cE;
        int type;

        a(int i, int i2) {
            this.type = i;
            this.cE = i2;
        }
    }

    public b(int i) {
        this.cD = i;
    }

    public abstract int a(com.baidu.ar.mdl.a aVar);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.ar.c.a
    /* renamed from: ay */
    public a ax() {
        int i = 0;
        if (!com.baidu.ar.b.a.ar().b(this.cD) && (i = a(com.baidu.ar.b.a.ar().f(this.cD))) == 0) {
            com.baidu.ar.b.a.ar().c(this.cD);
        }
        return new a(this.cD, i);
    }
}
