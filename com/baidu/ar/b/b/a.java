package com.baidu.ar.b.b;
/* loaded from: classes6.dex */
public abstract class a extends com.baidu.ar.c.a<C0075a> {
    private int cI;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.ar.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0075a {
        int cJ;
        int type;

        C0075a(int i, int i2) {
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
    public C0075a ay() {
        int i = 0;
        if (com.baidu.ar.b.a.as().c(this.cI)) {
            com.baidu.ar.b.a.as().e(this.cI);
            i = ax();
        }
        return new C0075a(this.cI, i);
    }

    public abstract int ax();
}
