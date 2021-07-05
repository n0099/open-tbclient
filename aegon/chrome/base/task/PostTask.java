package aegon.chrome.base.task;

import aegon.chrome.base.annotations.CalledByNative;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public class PostTask {
    public static /* synthetic */ Interceptable $ic;
    public static final Object sLock;
    public static Set<TaskRunner> sPreNativeTaskRunners;
    public static final Executor sPrenativeThreadPoolExecutor;
    public static Executor sPrenativeThreadPoolExecutorOverride;
    public static final DefaultTaskExecutor[] sTaskExecutors;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(447905518, "Laegon/chrome/base/task/PostTask;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(447905518, "Laegon/chrome/base/task/PostTask;");
                return;
            }
        }
        PostTask.class.desiredAssertionStatus();
        sLock = new Object();
        sPreNativeTaskRunners = Collections.newSetFromMap(new WeakHashMap());
        sPrenativeThreadPoolExecutor = new ChromeThreadPoolExecutor();
        DefaultTaskExecutor[] defaultTaskExecutorArr = new DefaultTaskExecutor[5];
        defaultTaskExecutorArr[0] = new DefaultTaskExecutor();
        sTaskExecutors = defaultTaskExecutorArr;
    }

    public PostTask() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static Executor getPrenativeThreadPoolExecutor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (sLock) {
                return sPrenativeThreadPoolExecutorOverride != null ? sPrenativeThreadPoolExecutorOverride : sPrenativeThreadPoolExecutor;
            }
        }
        return (Executor) invokeV.objValue;
    }

    public static native void nativePostDelayedTask(boolean z, int i2, boolean z2, boolean z3, byte b2, byte[] bArr, Runnable runnable, long j);

    @CalledByNative
    public static void onNativeSchedulerReady() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65540, null) == null) {
            synchronized (sLock) {
                Set<TaskRunner> set = sPreNativeTaskRunners;
                sPreNativeTaskRunners = null;
                for (TaskRunner taskRunner : set) {
                    taskRunner.initNativeTaskRunner();
                }
            }
        }
    }

    @CalledByNative
    public static void onNativeSchedulerShutdown() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null) == null) {
            synchronized (sLock) {
                sPreNativeTaskRunners = Collections.newSetFromMap(new WeakHashMap());
            }
        }
    }

    public static void postDelayedTask(TaskTraits taskTraits, Runnable runnable, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{taskTraits, runnable, Long.valueOf(j)}) == null) {
            synchronized (sLock) {
                if (sPreNativeTaskRunners == null && !taskTraits.mIsChoreographerFrame) {
                    nativePostDelayedTask(taskTraits.mPrioritySetExplicitly, taskTraits.mPriority, taskTraits.mMayBlock, taskTraits.mUseThreadPool, taskTraits.mExtensionId, taskTraits.mExtensionData, runnable, j);
                }
                sTaskExecutors[taskTraits.mExtensionId].postDelayedTask(taskTraits, runnable, j);
            }
        }
    }
}
