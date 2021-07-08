package com.baidu.mobads.container.components.statemachine;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.executor.BaseTask;
import com.baidu.mobads.container.executor.TaskScheduler;
import com.baidu.mobads.container.util.RemoteXAdLogger;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class StateUploadScheduler extends BaseTask {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int SCHEDULED_RATE = 15;
    public static StateUploadScheduler mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public AtomicBoolean mIsRunning;

    public StateUploadScheduler() {
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
        this.mIsRunning = new AtomicBoolean(false);
    }

    public static StateUploadScheduler getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (mInstance == null) {
                synchronized (StateUploadScheduler.class) {
                    if (mInstance == null) {
                        mInstance = new StateUploadScheduler();
                    }
                }
            }
            return mInstance;
        }
        return (StateUploadScheduler) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.executor.BaseTask
    public Object doInBackground() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.mIsRunning.get()) {
                RemoteXAdLogger.getInstance().d("StateMachine", "running!!!");
                StateMachine.markTimeoutState();
                StateMachine.uploadState();
                StateMachine.removeUnusedState();
                if (StateMachine.mAdStatusList.size() == 0) {
                    stop();
                    return null;
                }
                return null;
            }
            stop();
            return null;
        }
        return invokeV.objValue;
    }

    public synchronized void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                try {
                    if (!this.mIsRunning.get()) {
                        TaskScheduler.getInstance().submitAtFixedRate(this, 0L, 15L, TimeUnit.SECONDS);
                        this.mIsRunning.set(true);
                    }
                } catch (Exception e2) {
                    RemoteXAdLogger.getInstance().d(e2);
                }
            }
        }
    }

    public synchronized void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                try {
                    if (!isCanceled()) {
                        cancel();
                        this.mIsRunning.set(false);
                    }
                } catch (Exception e2) {
                    RemoteXAdLogger.getInstance().d(e2);
                }
            }
        }
    }
}
