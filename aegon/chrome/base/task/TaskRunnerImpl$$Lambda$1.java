package aegon.chrome.base.task;
/* loaded from: classes.dex */
public final /* synthetic */ class TaskRunnerImpl$$Lambda$1 implements Runnable {
    public final TaskRunnerImpl arg$1;

    public TaskRunnerImpl$$Lambda$1(TaskRunnerImpl taskRunnerImpl) {
        this.arg$1 = taskRunnerImpl;
    }

    public static Runnable lambdaFactory$(TaskRunnerImpl taskRunnerImpl) {
        return new TaskRunnerImpl$$Lambda$1(taskRunnerImpl);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.arg$1.runPreNativeTask();
    }
}
