package cn.jiguang.d.h;

import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes3.dex */
final class p extends ThreadPoolExecutor.DiscardPolicy {
    final /* synthetic */ o mz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.mz = oVar;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor.DiscardPolicy, java.util.concurrent.RejectedExecutionHandler
    public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        super.rejectedExecution(runnable, threadPoolExecutor);
    }
}
