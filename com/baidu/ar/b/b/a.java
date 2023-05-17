package com.baidu.ar.b.b;
/* loaded from: classes.dex */
public abstract class a extends com.baidu.ar.c.a<C0056a> {
    public int cI;

    /* renamed from: com.baidu.ar.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0056a {
        public int cJ;
        public int type;

        public C0056a(int i, int i2) {
            this.type = i;
            this.cJ = i2;
        }
    }

    public a(int i) {
        this.cI = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.ar.c.a
    /* renamed from: aw */
    public C0056a ay() {
        int i;
        if (com.baidu.ar.b.a.as().c(this.cI)) {
            com.baidu.ar.b.a.as().e(this.cI);
            i = ax();
        } else {
            i = 0;
        }
        return new C0056a(this.cI, i);
    }

    public abstract int ax();
}
