package cn.jiguang.d.h;

import java.util.concurrent.ExecutorService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class o extends s {
    @Override // cn.jiguang.d.h.s
    final ExecutorService a() {
        v i = v.i("REPORT_HISTORY", 3, 1);
        i.setRejectedExecutionHandler(new p(this));
        return i;
    }
}
