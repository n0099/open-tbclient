package aegon.chrome.base.task;

import aegon.chrome.base.task.ChromeThreadPoolExecutor;
/* loaded from: classes4.dex */
final /* synthetic */ class ChromeThreadPoolExecutor$1$$Lambda$1 implements Runnable {
    private final Runnable arg$1;

    private ChromeThreadPoolExecutor$1$$Lambda$1(Runnable runnable) {
        this.arg$1 = runnable;
    }

    public static Runnable lambdaFactory$(Runnable runnable) {
        return new ChromeThreadPoolExecutor$1$$Lambda$1(runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        ChromeThreadPoolExecutor.AnonymousClass1.lambda$newThread$0(this.arg$1);
    }
}
