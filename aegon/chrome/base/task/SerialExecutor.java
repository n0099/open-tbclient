package aegon.chrome.base.task;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;
/* loaded from: classes5.dex */
public class SerialExecutor implements Executor {
    public Runnable mActive;
    public final ArrayDeque<Runnable> mTasks = new ArrayDeque<>();

    @Override // java.util.concurrent.Executor
    public synchronized void execute(final Runnable runnable) {
        this.mTasks.offer(new Runnable() { // from class: aegon.chrome.base.task.SerialExecutor.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    runnable.run();
                } finally {
                    SerialExecutor.this.scheduleNext();
                }
            }
        });
        if (this.mActive == null) {
            scheduleNext();
        }
    }

    public synchronized void scheduleNext() {
        Runnable poll = this.mTasks.poll();
        this.mActive = poll;
        if (poll != null) {
            AsyncTask.THREAD_POOL_EXECUTOR.execute(this.mActive);
        }
    }
}
