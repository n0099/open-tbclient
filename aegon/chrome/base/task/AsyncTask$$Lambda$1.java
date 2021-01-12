package aegon.chrome.base.task;

import java.util.concurrent.Executor;
/* loaded from: classes4.dex */
final /* synthetic */ class AsyncTask$$Lambda$1 implements Executor {
    private static final AsyncTask$$Lambda$1 instance = new AsyncTask$$Lambda$1();

    private AsyncTask$$Lambda$1() {
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        AsyncTask.lambda$static$0(runnable);
    }
}
