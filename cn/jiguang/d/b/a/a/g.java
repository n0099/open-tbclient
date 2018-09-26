package cn.jiguang.d.b.a.a;

import android.text.TextUtils;
/* loaded from: classes3.dex */
public final class g extends i {
    public g(cn.jiguang.d.b.a.d dVar) {
        super(dVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // cn.jiguang.d.b.a.a.i
    public final int a() {
        String b = cn.jiguang.d.a.a.b();
        if (TextUtils.isEmpty(b)) {
            return -1;
        }
        cn.jiguang.d.b.a.a aVar = new cn.jiguang.d.b.a.a();
        aVar.a(b, cn.jiguang.d.a.a.c(), "LastGoodConnPolicy");
        return b(aVar);
    }
}
