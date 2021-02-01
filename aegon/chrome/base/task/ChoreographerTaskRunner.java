package aegon.chrome.base.task;

import android.view.Choreographer;
/* loaded from: classes3.dex */
public final class ChoreographerTaskRunner implements SingleThreadTaskRunner {
    public final Choreographer mChoreographer;

    public ChoreographerTaskRunner(Choreographer choreographer) {
        this.mChoreographer = choreographer;
    }

    @Override // aegon.chrome.base.task.TaskRunner
    public void destroy() {
    }

    @Override // aegon.chrome.base.task.TaskRunner
    public void disableLifetimeCheck() {
    }

    @Override // aegon.chrome.base.task.TaskRunner
    public void initNativeTaskRunner() {
    }

    @Override // aegon.chrome.base.task.TaskRunner
    public void postDelayedTask(final Runnable runnable, long j) {
        this.mChoreographer.postFrameCallbackDelayed(new Choreographer.FrameCallback(this) { // from class: aegon.chrome.base.task.ChoreographerTaskRunner.2
            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j2) {
                runnable.run();
            }
        }, j);
    }
}
