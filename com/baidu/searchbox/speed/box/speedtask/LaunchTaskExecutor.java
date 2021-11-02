package com.baidu.searchbox.speed.box.speedtask;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.concurrent.AsyncTaskAssistant;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
/* loaded from: classes7.dex */
public final class LaunchTaskExecutor {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final long GURANTEE_DELAY_MS = 30000;
    public static final String TAG = "LaunchTaskExecutor";
    public static boolean sAppReady;
    public static Runnable sGuaranteeRunnable;
    public static boolean sGuaranteeRunnableScheduled;
    public static LinkedList<Task> sQueue;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class Task {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long delay;
        public String name;
        public Runnable runnable;

        public Task() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.delay = 0L;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1739311321, "Lcom/baidu/searchbox/speed/box/speedtask/LaunchTaskExecutor;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1739311321, "Lcom/baidu/searchbox/speed/box/speedtask/LaunchTaskExecutor;");
                return;
            }
        }
        DEBUG = AppConfig.isDebug();
        sQueue = new LinkedList<>();
        sAppReady = false;
        sGuaranteeRunnableScheduled = false;
        sGuaranteeRunnable = new Runnable() { // from class: com.baidu.searchbox.speed.box.speedtask.LaunchTaskExecutor.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    LaunchTaskExecutor.appReady(true);
                }
            }
        };
    }

    public LaunchTaskExecutor() {
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

    public static synchronized void appReady(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65538, null, z) == null) {
            synchronized (LaunchTaskExecutor.class) {
                if (DEBUG) {
                    String str = "appReady or not : " + z;
                }
                if (!z) {
                    sAppReady = false;
                    sGuaranteeRunnableScheduled = false;
                } else if (sAppReady) {
                    boolean z2 = DEBUG;
                } else {
                    sAppReady = true;
                    while (true) {
                        Task poll = sQueue.poll();
                        if (poll == null || poll.runnable == null) {
                            break;
                        }
                        if (DEBUG) {
                            String str2 = "execute task : " + poll.name;
                        }
                        if (poll.delay > 0) {
                            AsyncTaskAssistant.execute(poll.runnable, poll.name, poll.delay);
                        } else {
                            AsyncTaskAssistant.execute(poll.runnable, poll.name);
                        }
                    }
                }
            }
        }
    }

    public static synchronized void execute(Runnable runnable, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, runnable, str) == null) {
            synchronized (LaunchTaskExecutor.class) {
                execute(runnable, str, 0L);
            }
        }
    }

    public static synchronized void execute(Runnable runnable, String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{runnable, str, Long.valueOf(j)}) == null) {
            synchronized (LaunchTaskExecutor.class) {
                if (sAppReady) {
                    if (DEBUG) {
                        String str2 = "app is ready, execute task :" + str;
                    }
                    if (j > 0) {
                        AsyncTaskAssistant.execute(runnable, str, j);
                    } else {
                        AsyncTaskAssistant.execute(runnable, str);
                    }
                } else {
                    Task task = new Task();
                    task.runnable = runnable;
                    task.name = str;
                    task.delay = j;
                    if (DEBUG) {
                        String str3 = "app not ready, add task to queue : " + str;
                    }
                    sQueue.add(task);
                    if (!sGuaranteeRunnableScheduled) {
                        sGuaranteeRunnableScheduled = true;
                        AsyncTaskAssistant.execute(sGuaranteeRunnable, "setAppReady", 30000L);
                    }
                }
            }
        }
    }
}
