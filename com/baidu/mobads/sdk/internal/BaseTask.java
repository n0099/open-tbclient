package com.baidu.mobads.sdk.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.Future;
/* loaded from: classes5.dex */
public abstract class BaseTask<T> implements Runnable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String LOG_TAG = "BaseTask";
    public static final int MESSAGE_POST_CANCEL = 3;
    public static final int MESSAGE_POST_FAIL = 2;
    public static final int MESSAGE_POST_SUCCESS = 1;
    public static InternalHandler sHandler;
    public transient /* synthetic */ FieldHolder $fh;
    public long mCompleteTime;
    public long mExecuteTime;
    public String mName;
    public Future<T> mTask;
    public long mTaskAddTime;

    /* loaded from: classes5.dex */
    public static class BaseTaskResult<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final T mData;
        public final BaseTask mTask;

        public BaseTaskResult(BaseTask baseTask, T t) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseTask, t};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mTask = baseTask;
            this.mData = t;
        }
    }

    /* loaded from: classes5.dex */
    public static class InternalHandler extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InternalHandler(Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {looper};
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
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                BaseTaskResult baseTaskResult = (BaseTaskResult) message.obj;
                int i2 = message.what;
                if (i2 == 1) {
                    baseTaskResult.mTask.onTaskSuccess(baseTaskResult.mData);
                } else if (i2 == 2) {
                    baseTaskResult.mTask.onTaskFailed((Throwable) baseTaskResult.mData);
                } else if (i2 != 3) {
                } else {
                    baseTaskResult.mTask.onTaskCancelled();
                }
            }
        }
    }

    public BaseTask() {
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
        this.mName = "default";
    }

    public static Handler getMainHandler() {
        InterceptResult invokeV;
        InternalHandler internalHandler;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (BaseTask.class) {
                if (sHandler == null) {
                    sHandler = new InternalHandler(Looper.getMainLooper());
                }
                internalHandler = sHandler;
            }
            return internalHandler;
        }
        return (Handler) invokeV.objValue;
    }

    public void cancel(boolean z) {
        Future<T> future;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (future = this.mTask) == null) {
            return;
        }
        future.cancel(z);
        getMainHandler().obtainMessage(3, new BaseTaskResult(this, null)).sendToTarget();
    }

    public abstract T doInBackground();

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, IPUT, MOVE_EXCEPTION, INVOKE, CONST, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, IPUT, MOVE_EXCEPTION] complete} */
    public BaseTask enterExecute() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            try {
                this.mExecuteTime = System.currentTimeMillis();
                getMainHandler().obtainMessage(1, new BaseTaskResult(this, doInBackground())).sendToTarget();
            } finally {
                try {
                    return this;
                } finally {
                }
            }
            return this;
        }
        return (BaseTask) invokeV.objValue;
    }

    public long getCreateToComplete() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mCompleteTime - this.mTaskAddTime : invokeV.longValue;
    }

    public long getCreateToExecuteTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mExecuteTime - this.mTaskAddTime : invokeV.longValue;
    }

    public long getExecuteToComplete() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mCompleteTime - this.mExecuteTime : invokeV.longValue;
    }

    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mName : (String) invokeV.objValue;
    }

    public boolean isCanceled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            Future<T> future = this.mTask;
            if (future != null) {
                return future.isCancelled();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isComplete() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            Future<T> future = this.mTask;
            if (future != null) {
                return future.isDone();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void onTaskCancelled() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }

    public void onTaskFailed(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, th) == null) {
        }
    }

    public void onTaskSuccess(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, t) == null) {
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            enterExecute();
        }
    }

    public void setTask(Future future) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, future) == null) {
            this.mTask = future;
        }
    }

    public void setTaskAddTime(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048591, this, j2) == null) {
            this.mTaskAddTime = j2;
        }
    }

    public BaseTask(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mName = str;
    }

    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            cancel(false);
        }
    }
}
