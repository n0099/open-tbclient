package com.baidu.adp.idlehelp;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.searchbox.taskmanager.IdleTaskRegister;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class IdleHandlerManager {
    public static /* synthetic */ Interceptable $ic;
    public static IdleHandlerManager instance;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean hasLaunched;
    public boolean hasRunImmediately;
    public final IdleTaskRegister mManager;

    public IdleHandlerManager() {
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
        this.mManager = new IdleTaskRegister();
        this.hasLaunched = !ProcessUtils.isMainProcess();
        this.hasRunImmediately = false;
    }

    public static IdleHandlerManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (instance == null) {
                instance = new IdleHandlerManager();
            }
            return instance;
        }
        return (IdleHandlerManager) invokeV.objValue;
    }

    public boolean hasRunImmediately() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.hasRunImmediately;
        }
        return invokeV.booleanValue;
    }

    public void runIdleTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.hasLaunched = true;
            this.mManager.scheduleIdleTask(true);
        }
    }

    public void runIdleTaskImmediately() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.hasLaunched = true;
            this.hasRunImmediately = true;
            this.mManager.scheduleIdleTask(false);
        }
    }

    public void addOrRunTask(String str, Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, runnable) == null) {
            if (!this.hasLaunched) {
                this.mManager.registerIdleTask(str, runnable);
            } else {
                runnable.run();
            }
        }
    }

    public void removeRunnable(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.mManager.removeRunnable(str);
        }
    }
}
