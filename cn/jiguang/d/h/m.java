package cn.jiguang.d.h;

import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes3.dex */
final class m extends ThreadPoolExecutor.CallerRunsPolicy {
    final /* synthetic */ l my;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.my = lVar;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy, java.util.concurrent.RejectedExecutionHandler
    public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        super.rejectedExecution(runnable, threadPoolExecutor);
    }
}
