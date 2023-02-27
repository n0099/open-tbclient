package com.baidu.ar.b.b;
/* loaded from: classes.dex */
public abstract class b extends com.baidu.ar.c.a<a> {
    public int cI;

    /* loaded from: classes.dex */
    public class a {
        public int cJ;
        public int type;

        public a(int i, int i2) {
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
        int i;
        if (com.baidu.ar.b.a.as().c(this.cI)) {
            i = 0;
        } else {
            i = a(com.baidu.ar.b.a.as().g(this.cI));
            if (i == 0) {
                com.baidu.ar.b.a.as().d(this.cI);
            }
        }
        return new a(this.cI, i);
    }
}
