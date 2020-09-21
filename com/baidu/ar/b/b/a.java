package com.baidu.ar.b.b;
/* loaded from: classes10.dex */
public abstract class a extends com.baidu.ar.c.a<C0079a> {
    private int cD;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.ar.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0079a {
        int cE;
        int type;

        C0079a(int i, int i2) {
            this.type = i;
            this.cE = i2;
        }
    }

    public a(int i) {
        this.cD = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.ar.c.a
    /* renamed from: av */
    public C0079a ax() {
        int i = 0;
        if (com.baidu.ar.b.a.ar().b(this.cD)) {
            com.baidu.ar.b.a.ar().d(this.cD);
            i = aw();
        }
        return new C0079a(this.cD, i);
    }

    public abstract int aw();
}
