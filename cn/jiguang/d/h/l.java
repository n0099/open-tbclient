package cn.jiguang.d.h;

import java.util.concurrent.ExecutorService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class l extends s {
    @Override // cn.jiguang.d.h.s
    final ExecutorService a() {
        v e = v.e("BUILD_REPORT", 30);
        e.setRejectedExecutionHandler(new m(this));
        return e;
    }
}
