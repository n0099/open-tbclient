package cn.jiguang.d.h;

import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes3.dex */
final class p extends ThreadPoolExecutor.DiscardPolicy {
    final /* synthetic */ o mE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.mE = oVar;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor.DiscardPolicy, java.util.concurrent.RejectedExecutionHandler
    public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        super.rejectedExecution(runnable, threadPoolExecutor);
    }
}
