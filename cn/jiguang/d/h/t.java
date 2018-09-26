package cn.jiguang.d.h;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public final class t {
    public static void a(ExecutorService executorService) {
        if (executorService == null) {
            return;
        }
        try {
            executorService.shutdown();
            if (executorService.awaitTermination(100L, TimeUnit.MILLISECONDS)) {
                return;
            }
            executorService.shutdownNow();
            executorService.awaitTermination(100L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        } catch (Throwable th) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001d, code lost:
        r0 = ((cn.jiguang.d.h.v) r2).a;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(ExecutorService executorService, w wVar) {
        int i;
        if ((executorService instanceof ThreadPoolExecutor) && ((ThreadPoolExecutor) executorService).getQueue().size() > 30) {
            ((ThreadPoolExecutor) executorService).getPoolSize();
        }
        if ((executorService instanceof v) && i > 0) {
            wVar.a = i;
        }
        executorService.execute(wVar);
    }
}
