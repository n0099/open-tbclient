package aegon.chrome.base.task;

import aegon.chrome.base.annotations.CalledByNative;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public class PostTask {
    public static final Object sLock;
    public static Set<TaskRunner> sPreNativeTaskRunners;
    public static final Executor sPrenativeThreadPoolExecutor;
    public static Executor sPrenativeThreadPoolExecutorOverride;
    public static final DefaultTaskExecutor[] sTaskExecutors;

    static {
        PostTask.class.desiredAssertionStatus();
        sLock = new Object();
        sPreNativeTaskRunners = Collections.newSetFromMap(new WeakHashMap());
        sPrenativeThreadPoolExecutor = new ChromeThreadPoolExecutor();
        DefaultTaskExecutor[] defaultTaskExecutorArr = new DefaultTaskExecutor[5];
        defaultTaskExecutorArr[0] = new DefaultTaskExecutor();
        sTaskExecutors = defaultTaskExecutorArr;
    }

    public static Executor getPrenativeThreadPoolExecutor() {
        synchronized (sLock) {
            if (sPrenativeThreadPoolExecutorOverride != null) {
                return sPrenativeThreadPoolExecutorOverride;
            }
            return sPrenativeThreadPoolExecutor;
        }
    }

    public static native void nativePostDelayedTask(boolean z, int i, boolean z2, boolean z3, byte b2, byte[] bArr, Runnable runnable, long j);

    @CalledByNative
    public static void onNativeSchedulerReady() {
        synchronized (sLock) {
            Set<TaskRunner> set = sPreNativeTaskRunners;
            sPreNativeTaskRunners = null;
            for (TaskRunner taskRunner : set) {
                taskRunner.initNativeTaskRunner();
            }
        }
    }

    @CalledByNative
    public static void onNativeSchedulerShutdown() {
        synchronized (sLock) {
            sPreNativeTaskRunners = Collections.newSetFromMap(new WeakHashMap());
        }
    }

    public static void postDelayedTask(TaskTraits taskTraits, Runnable runnable, long j) {
        synchronized (sLock) {
            if (sPreNativeTaskRunners == null && !taskTraits.mIsChoreographerFrame) {
                nativePostDelayedTask(taskTraits.mPrioritySetExplicitly, taskTraits.mPriority, taskTraits.mMayBlock, taskTraits.mUseThreadPool, taskTraits.mExtensionId, taskTraits.mExtensionData, runnable, j);
            }
            sTaskExecutors[taskTraits.mExtensionId].postDelayedTask(taskTraits, runnable, j);
        }
    }
}
