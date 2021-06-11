package aegon.chrome.base.task;

import aegon.chrome.base.ThreadUtils;
import android.view.Choreographer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
/* loaded from: classes.dex */
public class DefaultTaskExecutor {
    public final Map<TaskTraits, TaskRunner> mTraitsToRunnerMap = new HashMap();

    public static /* synthetic */ ChoreographerTaskRunner lambda$createChoreographerTaskRunner$0() {
        return new ChoreographerTaskRunner(Choreographer.getInstance());
    }

    public final synchronized ChoreographerTaskRunner createChoreographerTaskRunner() {
        Callable callable;
        callable = DefaultTaskExecutor$$Lambda$1.instance;
        return (ChoreographerTaskRunner) ThreadUtils.runOnUiThreadBlockingNoException(callable);
    }

    public TaskRunner createTaskRunner(TaskTraits taskTraits) {
        return taskTraits.mIsChoreographerFrame ? createChoreographerTaskRunner() : new TaskRunnerImpl(taskTraits, "TaskRunnerImpl", 0);
    }

    public synchronized void postDelayedTask(TaskTraits taskTraits, Runnable runnable, long j) {
        if (taskTraits.mExtensionId != 0) {
            TaskRunner createTaskRunner = createTaskRunner(taskTraits);
            createTaskRunner.postDelayedTask(runnable, j);
            createTaskRunner.destroy();
        } else {
            TaskRunner taskRunner = this.mTraitsToRunnerMap.get(taskTraits);
            if (taskRunner == null) {
                taskRunner = createTaskRunner(taskTraits);
                taskRunner.disableLifetimeCheck();
                this.mTraitsToRunnerMap.put(taskTraits, taskRunner);
            }
            taskRunner.postDelayedTask(runnable, j);
        }
    }
}
