package cn.jiguang.d.c;
/* loaded from: classes3.dex */
public final class p extends m {
    private int e;
    private int f;
    private int g;
    private j h;

    @Override // cn.jiguang.d.c.m
    final String a() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.e + " ");
        stringBuffer.append(this.f + " ");
        stringBuffer.append(this.g + " ");
        stringBuffer.append(this.h);
        return stringBuffer.toString();
    }

    @Override // cn.jiguang.d.c.m
    final void a(d dVar) {
        this.e = dVar.g();
        this.f = dVar.g();
        this.g = dVar.g();
        this.h = new j(dVar);
    }

    @Override // cn.jiguang.d.c.m
    final void a(e eVar, boolean z) {
        eVar.c(this.e);
        eVar.c(this.f);
        eVar.c(this.g);
        this.h.a(eVar, (b) null, true);
    }

    public final int h() {
        return this.g;
    }

    public final j i() {
        return this.h;
    }
}
