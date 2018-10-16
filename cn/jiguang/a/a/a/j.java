package cn.jiguang.a.a.a;

import cn.jiguang.g.l;
/* loaded from: classes3.dex */
final class j implements g {
    final /* synthetic */ int b;
    final /* synthetic */ l ku;
    final /* synthetic */ h kv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar, l lVar, int i) {
        this.kv = hVar;
        this.ku = lVar;
        this.b = i;
    }

    @Override // cn.jiguang.a.a.a.g
    public final void a() {
        Object obj;
        boolean[] zArr;
        Object obj2;
        obj = h.i;
        synchronized (obj) {
            this.ku.a("thread" + this.b);
            zArr = this.kv.ks;
            zArr[this.b] = true;
            obj2 = h.i;
            obj2.notifyAll();
        }
    }
}
