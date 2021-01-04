package aegon.chrome.base.task;
/* loaded from: classes5.dex */
final /* synthetic */ class TaskRunnerImpl$$Lambda$1 implements Runnable {
    private final TaskRunnerImpl arg$1;

    private TaskRunnerImpl$$Lambda$1(TaskRunnerImpl taskRunnerImpl) {
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
