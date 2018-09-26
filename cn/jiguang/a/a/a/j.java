package cn.jiguang.a.a.a;

import cn.jiguang.g.l;
/* loaded from: classes3.dex */
final class j implements g {
    final /* synthetic */ int b;
    final /* synthetic */ l jP;
    final /* synthetic */ h jQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar, l lVar, int i) {
        this.jQ = hVar;
        this.jP = lVar;
        this.b = i;
    }

    @Override // cn.jiguang.a.a.a.g
    public final void a() {
        Object obj;
        boolean[] zArr;
        Object obj2;
        obj = h.i;
        synchronized (obj) {
            this.jP.a("thread" + this.b);
            zArr = this.jQ.jN;
            zArr[this.b] = true;
            obj2 = h.i;
            obj2.notifyAll();
        }
    }
}
