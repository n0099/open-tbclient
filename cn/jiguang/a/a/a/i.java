package cn.jiguang.a.a.a;

import android.content.Context;
/* loaded from: classes3.dex */
final class i implements cn.jiguang.api.j {
    final /* synthetic */ h jO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.jO = hVar;
    }

    @Override // cn.jiguang.api.j
    public final void a(int i) {
        Context context;
        String str;
        if (i == 0) {
            a aV = a.aV();
            context = this.jO.b;
            str = this.jO.f;
            aV.a(context, str);
        }
    }
}
