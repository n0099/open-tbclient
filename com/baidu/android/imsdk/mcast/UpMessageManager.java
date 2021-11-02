package com.baidu.android.imsdk.mcast;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes6.dex */
public class UpMessageManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "UpMessageManager";
    public static UpMessageManager mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public EventHandler mEventHandler;
    public HandlerThread mHandlerThread;
    public ConcurrentLinkedQueue<Task> mTaskList;
    public ThreadPoolExecutor mThreadPool;
    public boolean onDispath;
    public boolean onTaskRunning;

    /* loaded from: classes6.dex */
    public class EventHandler extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<UpMessageManager> mActivity;
        public final /* synthetic */ UpMessageManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EventHandler(UpMessageManager upMessageManager, UpMessageManager upMessageManager2, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {upMessageManager, upMessageManager2, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = upMessageManager;
            this.mActivity = new WeakReference<>(upMessageManager2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                this.this$0.onTaskRunning = false;
                UpMessageManager upMessageManager = this.mActivity.get();
                if (upMessageManager != null) {
                    if (this.this$0.mTaskList.size() > 0) {
                        upMessageManager.dispatch();
                    } else {
                        this.this$0.onDispath = false;
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class Task {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String mAction;
        public boolean mIsRunning;
        public String mJson;

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
                }
            }
        }

        public void work() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        public Task(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mAction = str;
            this.mJson = str2;
            this.mIsRunning = false;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-942530416, "Lcom/baidu/android/imsdk/mcast/UpMessageManager;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-942530416, "Lcom/baidu/android/imsdk/mcast/UpMessageManager;");
        }
    }

    public UpMessageManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mTaskList = new ConcurrentLinkedQueue<>();
        this.mThreadPool = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
        this.onDispath = false;
        this.onTaskRunning = false;
        HandlerThread handlerThread = new HandlerThread("task listeners handler thread", 0);
        this.mHandlerThread = handlerThread;
        handlerThread.start();
        this.mEventHandler = new EventHandler(this, this, this.mHandlerThread.getLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatch() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            this.onDispath = true;
            if (this.mThreadPool.getActiveCount() >= this.mThreadPool.getCorePoolSize()) {
                LogUtils.d(TAG, "FXF  没有空闲线程 ");
                return;
            }
            int corePoolSize = this.mThreadPool.getCorePoolSize() - this.mThreadPool.getActiveCount();
            if (!this.onTaskRunning && corePoolSize > 0) {
                execute(this.mTaskList.poll());
            }
        }
    }

    private void execute(Task task) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, task) == null) {
            this.mThreadPool.execute(new Runnable(this, task) { // from class: com.baidu.android.imsdk.mcast.UpMessageManager.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ UpMessageManager this$0;
                public final /* synthetic */ Task val$request;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, task};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$request = task;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.onTaskRunning = true;
                        try {
                            this.val$request.work();
                        } catch (Exception e2) {
                            this.this$0.onTaskRunning = false;
                            LogUtils.e(UpMessageManager.TAG, "request work excepation", e2);
                        }
                        LogUtils.d(UpMessageManager.TAG, "FXF  finish a work task ");
                        this.this$0.mEventHandler.sendMessage(this.this$0.mEventHandler.obtainMessage());
                    }
                }
            });
        }
    }

    public static synchronized UpMessageManager getInstance(Context context) {
        InterceptResult invokeL;
        UpMessageManager upMessageManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            synchronized (UpMessageManager.class) {
                if (mInstance == null) {
                    mInstance = new UpMessageManager();
                }
                upMessageManager = mInstance;
            }
            return upMessageManager;
        }
        return (UpMessageManager) invokeL.objValue;
    }

    public void addTaskRequest(Task task) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, task) == null) || task == null) {
            return;
        }
        this.mTaskList.add(task);
        if (this.onDispath) {
            return;
        }
        dispatch();
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.mTaskList.clear();
        }
    }
}
