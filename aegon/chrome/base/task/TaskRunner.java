package aegon.chrome.base.task;
/* loaded from: classes.dex */
public interface TaskRunner {
    void destroy();

    void disableLifetimeCheck();

    void initNativeTaskRunner();

    void postDelayedTask(Runnable runnable, long j);
}
