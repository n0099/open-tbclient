package com.baidu.searchbox.dns.transmit.task;

import android.os.Process;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public abstract class AsyncTask implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String mName;
    public final Dispatcher mTaskDispatcher;

    public abstract String getTaskType();

    public abstract void onCancel();

    public abstract void onExecute();

    public Object tag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this : invokeV.objValue;
    }

    public AsyncTask() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mName = "searchbox task: " + getTaskType();
        this.mTaskDispatcher = SimpleDispatcherHolder.getDispatcher();
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            Process.setThreadPriority(10);
            String name = Thread.currentThread().getName();
            Thread.currentThread().setName(this.mName);
            try {
                onExecute();
                this.mTaskDispatcher.finished(this);
            } finally {
                Thread.currentThread().setName(name);
            }
        }
    }

    public AsyncTask(Dispatcher dispatcher) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dispatcher};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mName = "searchbox task: " + getTaskType();
        this.mTaskDispatcher = dispatcher;
    }

    public AsyncTask(Dispatcher dispatcher, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dispatcher, str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mName = str;
        this.mTaskDispatcher = dispatcher;
    }

    public AsyncTask(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.mName = str;
        this.mTaskDispatcher = SimpleDispatcherHolder.getDispatcher();
    }

    public void cancel() {
        Dispatcher dispatcher;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (dispatcher = this.mTaskDispatcher) != null) {
            dispatcher.cancelTask(this);
        }
    }

    public Dispatcher getTaskDispatcher() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mTaskDispatcher;
        }
        return (Dispatcher) invokeV.objValue;
    }

    public void start() {
        Dispatcher dispatcher;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (dispatcher = this.mTaskDispatcher) != null) {
            dispatcher.enqueue(this);
        }
    }
}
