package aegon.chrome.base.task;

import java.util.concurrent.Callable;
/* loaded from: classes5.dex */
final /* synthetic */ class DefaultTaskExecutor$$Lambda$1 implements Callable {
    private static final DefaultTaskExecutor$$Lambda$1 instance = new DefaultTaskExecutor$$Lambda$1();

    private DefaultTaskExecutor$$Lambda$1() {
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        return DefaultTaskExecutor.lambda$createChoreographerTaskRunner$0();
    }
}
