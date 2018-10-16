package cn.jiguang.a.a.a;

import android.content.Context;
/* loaded from: classes3.dex */
final class i implements cn.jiguang.api.j {
    final /* synthetic */ h kt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.kt = hVar;
    }

    @Override // cn.jiguang.api.j
    public final void a(int i) {
        Context context;
        String str;
        if (i == 0) {
            a bm = a.bm();
            context = this.kt.b;
            str = this.kt.f;
            bm.a(context, str);
        }
    }
}
