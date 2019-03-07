package cn.jiguang.d.h;

import java.util.concurrent.ExecutorService;
/* loaded from: classes3.dex */
final class r extends s {
    final /* synthetic */ String a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(String str, int i, int i2) {
        this.a = str;
        this.b = i;
        this.c = i2;
    }

    @Override // cn.jiguang.d.h.s
    final ExecutorService a() {
        return v.h(this.a, this.b, this.c);
    }
}
