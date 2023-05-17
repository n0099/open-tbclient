package com.baidu.live.arch.thread;

import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\bÆ\u0002\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0004\u0010\nJ\u0015\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u000b\u0010\u0005J\u0015\u0010\f\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\f\u0010\u0005J\u0015\u0010\r\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\r\u0010\u0005J\u0015\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u000e\u0010\u0005¨\u0006\u0011"}, d2 = {"Lcom/baidu/live/arch/thread/MiniElasticExecutor;", "Ljava/lang/Runnable;", "runnable", "", "execute", "(Ljava/lang/Runnable;)V", "", "taskName", "", "priority", "(Ljava/lang/Runnable;Ljava/lang/String;I)V", "executeBackground", "executeImmediate", "executeIntime", "executeSerial", "<init>", "()V", "lib-live-mini-arch_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class MiniElasticExecutor {
    public static final MiniElasticExecutor INSTANCE = new MiniElasticExecutor();

    public final void execute(Runnable runnable) {
        ExecutorUtilsExt.postOnElastic(runnable, "bd-live-runtime", 1);
    }

    public final void executeBackground(Runnable runnable) {
        ExecutorUtilsExt.postOnElastic(runnable, "bd-live-runtime", 3);
    }

    public final void executeImmediate(Runnable runnable) {
        ExecutorUtilsExt.postOnElastic(runnable, "bd-live-runtime", 0);
    }

    public final void executeIntime(Runnable runnable) {
        ExecutorUtilsExt.postOnElastic(runnable, "bd-live-runtime", 2);
    }

    public final void executeSerial(Runnable runnable) {
        ExecutorUtilsExt.postOnElastic(runnable, "bd-live-runtime", 4);
    }

    public final void execute(Runnable runnable, String str, int i) {
        ExecutorUtilsExt.postOnElastic(runnable, str, i);
    }
}
