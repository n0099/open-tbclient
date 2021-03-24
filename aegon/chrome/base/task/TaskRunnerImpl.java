package aegon.chrome.base.task;

import aegon.chrome.base.BuildConfig;
import aegon.chrome.base.LifetimeAssert;
import aegon.chrome.base.TraceEvent;
import android.os.Process;
import android.util.Pair;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class TaskRunnerImpl implements TaskRunner {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public boolean mIsDestroying;
    public final LifetimeAssert mLifetimeAssert;
    public long mNativeTaskRunnerAndroid;
    @Nullable
    public List<Pair<Runnable, Long>> mPreNativeDelayedTasks;
    @Nullable
    public LinkedList<Runnable> mPreNativeTasks;
    public final int mTaskRunnerType;
    public final TaskTraits mTaskTraits;
    public final String mTraceEvent;
    public final Object mLock = new Object();
    public final Runnable mRunPreNativeTaskClosure = TaskRunnerImpl$$Lambda$1.lambdaFactory$(this);

    public TaskRunnerImpl(TaskTraits taskTraits, String str, int i) {
        boolean z = false;
        this.mLifetimeAssert = !BuildConfig.DCHECK_IS_ON ? null : new LifetimeAssert(new LifetimeAssert.WrappedReference(this, new LifetimeAssert.CreationException(), false));
        this.mPreNativeTasks = new LinkedList<>();
        this.mPreNativeDelayedTasks = new ArrayList();
        this.mTaskTraits = taskTraits;
        this.mTraceEvent = str + ".PreNativeTask.run";
        this.mTaskRunnerType = i;
        Set<TaskRunner> set = PostTask.sPreNativeTaskRunners;
        if (set != null) {
            set.add(this);
            z = true;
        }
        if (z) {
            return;
        }
        initNativeTaskRunner();
    }

    private native void nativeDestroy(long j);

    private native long nativeInit(int i, boolean z, int i2, boolean z2, boolean z3, byte b2, byte[] bArr);

    private native void nativePostDelayedTask(long j, Runnable runnable, long j2);

    @Override // aegon.chrome.base.task.TaskRunner
    public void destroy() {
        synchronized (this.mLock) {
            LifetimeAssert lifetimeAssert = this.mLifetimeAssert;
            if (BuildConfig.DCHECK_IS_ON) {
                lifetimeAssert.mWrapper.mSafeToGc = true;
            }
            this.mIsDestroying = true;
            destroyInternal();
        }
    }

    public void destroyInternal() {
        long j = this.mNativeTaskRunnerAndroid;
        if (j != 0) {
            nativeDestroy(j);
        }
        this.mNativeTaskRunnerAndroid = 0L;
    }

    @Override // aegon.chrome.base.task.TaskRunner
    public void disableLifetimeCheck() {
        LifetimeAssert lifetimeAssert = this.mLifetimeAssert;
        if (BuildConfig.DCHECK_IS_ON) {
            lifetimeAssert.mWrapper.mSafeToGc = true;
        }
    }

    @Override // aegon.chrome.base.task.TaskRunner
    public void initNativeTaskRunner() {
        synchronized (this.mLock) {
            initNativeTaskRunnerInternal();
            migratePreNativeTasksToNative();
        }
    }

    public void initNativeTaskRunnerInternal() {
        if (this.mNativeTaskRunnerAndroid == 0) {
            int i = this.mTaskRunnerType;
            TaskTraits taskTraits = this.mTaskTraits;
            this.mNativeTaskRunnerAndroid = nativeInit(i, taskTraits.mPrioritySetExplicitly, taskTraits.mPriority, taskTraits.mMayBlock, taskTraits.mUseThreadPool, taskTraits.mExtensionId, taskTraits.mExtensionData);
        }
    }

    public void migratePreNativeTasksToNative() {
        LinkedList<Runnable> linkedList = this.mPreNativeTasks;
        if (linkedList != null) {
            Iterator<Runnable> it = linkedList.iterator();
            while (it.hasNext()) {
                postDelayedTaskToNative(it.next(), 0L);
            }
            for (Pair<Runnable, Long> pair : this.mPreNativeDelayedTasks) {
                postDelayedTaskToNative((Runnable) pair.first, ((Long) pair.second).longValue());
            }
            this.mPreNativeTasks = null;
            this.mPreNativeDelayedTasks = null;
        }
    }

    public native boolean nativeBelongsToCurrentThread(long j);

    @Override // aegon.chrome.base.task.TaskRunner
    public void postDelayedTask(Runnable runnable, long j) {
        synchronized (this.mLock) {
            if (this.mPreNativeTasks == null) {
                postDelayedTaskToNative(runnable, j);
                return;
            }
            if (j == 0) {
                this.mPreNativeTasks.add(runnable);
                schedulePreNativeTask();
            } else {
                this.mPreNativeDelayedTasks.add(new Pair<>(runnable, Long.valueOf(j)));
            }
        }
    }

    public void postDelayedTaskToNative(Runnable runnable, long j) {
        nativePostDelayedTask(this.mNativeTaskRunnerAndroid, runnable, j);
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public void runPreNativeTask() {
        TraceEvent scoped = TraceEvent.scoped(this.mTraceEvent);
        try {
            synchronized (this.mLock) {
                if (this.mPreNativeTasks == null) {
                    if (scoped != null) {
                        scoped.close();
                        return;
                    }
                    return;
                }
                Runnable poll = this.mPreNativeTasks.poll();
                int i = this.mTaskTraits.mPriority;
                Process.setThreadPriority(i != 1 ? i != 2 ? 10 : -1 : 0);
                poll.run();
                if (scoped != null) {
                    scoped.close();
                }
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (scoped != null) {
                    try {
                        scoped.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public void schedulePreNativeTask() {
        PostTask.getPrenativeThreadPoolExecutor().execute(this.mRunPreNativeTaskClosure);
    }
}
