package aegon.chrome.base.task;

import aegon.chrome.base.BuildConfig;
import aegon.chrome.base.LifetimeAssert;
import aegon.chrome.base.TraceEvent;
import android.os.Process;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class TaskRunnerImpl implements TaskRunner {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mIsDestroying;
    public final LifetimeAssert mLifetimeAssert;
    public final Object mLock;
    public long mNativeTaskRunnerAndroid;
    @Nullable
    public List<Pair<Runnable, Long>> mPreNativeDelayedTasks;
    @Nullable
    public LinkedList<Runnable> mPreNativeTasks;
    public final Runnable mRunPreNativeTaskClosure;
    public final int mTaskRunnerType;
    public final TaskTraits mTaskTraits;
    public final String mTraceEvent;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-952380322, "Laegon/chrome/base/task/TaskRunnerImpl;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-952380322, "Laegon/chrome/base/task/TaskRunnerImpl;");
        }
    }

    public TaskRunnerImpl(TaskTraits taskTraits, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {taskTraits, str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mLock = new Object();
        this.mRunPreNativeTaskClosure = TaskRunnerImpl$$Lambda$1.$ic;
        boolean z = false;
        this.mLifetimeAssert = !BuildConfig.DCHECK_IS_ON ? null : new LifetimeAssert(new LifetimeAssert.WrappedReference(this, new LifetimeAssert.CreationException(), false));
        this.mPreNativeTasks = new LinkedList<>();
        this.mPreNativeDelayedTasks = new ArrayList();
        this.mTaskTraits = taskTraits;
        this.mTraceEvent = str + ".PreNativeTask.run";
        this.mTaskRunnerType = i2;
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

    private native long nativeInit(int i2, boolean z, int i3, boolean z2, boolean z3, byte b2, byte[] bArr);

    private native void nativePostDelayedTask(long j, Runnable runnable, long j2);

    @Override // aegon.chrome.base.task.TaskRunner
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this.mLock) {
                LifetimeAssert lifetimeAssert = this.mLifetimeAssert;
                if (BuildConfig.DCHECK_IS_ON) {
                    lifetimeAssert.mWrapper.mSafeToGc = true;
                }
                this.mIsDestroying = true;
                destroyInternal();
            }
        }
    }

    public void destroyInternal() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            long j = this.mNativeTaskRunnerAndroid;
            if (j != 0) {
                nativeDestroy(j);
            }
            this.mNativeTaskRunnerAndroid = 0L;
        }
    }

    @Override // aegon.chrome.base.task.TaskRunner
    public void disableLifetimeCheck() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            LifetimeAssert lifetimeAssert = this.mLifetimeAssert;
            if (BuildConfig.DCHECK_IS_ON) {
                lifetimeAssert.mWrapper.mSafeToGc = true;
            }
        }
    }

    @Override // aegon.chrome.base.task.TaskRunner
    public void initNativeTaskRunner() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this.mLock) {
                initNativeTaskRunnerInternal();
                migratePreNativeTasksToNative();
            }
        }
    }

    public void initNativeTaskRunnerInternal() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.mNativeTaskRunnerAndroid == 0) {
            int i2 = this.mTaskRunnerType;
            TaskTraits taskTraits = this.mTaskTraits;
            this.mNativeTaskRunnerAndroid = nativeInit(i2, taskTraits.mPrioritySetExplicitly, taskTraits.mPriority, taskTraits.mMayBlock, taskTraits.mUseThreadPool, taskTraits.mExtensionId, taskTraits.mExtensionData);
        }
    }

    public void migratePreNativeTasksToNative() {
        LinkedList<Runnable> linkedList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (linkedList = this.mPreNativeTasks) == null) {
            return;
        }
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

    public native boolean nativeBelongsToCurrentThread(long j);

    @Override // aegon.chrome.base.task.TaskRunner
    public void postDelayedTask(Runnable runnable, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048583, this, runnable, j) == null) {
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
    }

    public void postDelayedTaskToNative(Runnable runnable, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, runnable, j) == null) {
            nativePostDelayedTask(this.mNativeTaskRunnerAndroid, runnable, j);
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public void runPreNativeTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
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
                    int i2 = this.mTaskTraits.mPriority;
                    Process.setThreadPriority(i2 != 1 ? i2 != 2 ? 10 : -1 : 0);
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
    }

    public void schedulePreNativeTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            PostTask.getPrenativeThreadPoolExecutor().execute(this.mRunPreNativeTaskClosure);
        }
    }
}
