package cn.jiguang.a.a.c;

import android.content.Context;
/* loaded from: classes3.dex */
final class c implements cn.jiguang.api.j {
    final /* synthetic */ Context a;
    final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context, String str) {
        this.a = context;
        this.b = str;
    }

    @Override // cn.jiguang.api.j
    public final void a(int i) {
        if (i == 0) {
            b.a(this.a, this.b);
            cn.jiguang.d.a.d.a(this.a, "last_report_device_info", Long.valueOf(System.currentTimeMillis()));
        }
    }
}
