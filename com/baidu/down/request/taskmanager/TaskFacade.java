package com.baidu.down.request.taskmanager;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.common.FileMsg;
import com.baidu.down.common.TaskManagerConfiguration;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public final class TaskFacade {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "TaskFacade";
    public static TaskFacade instance;
    public transient /* synthetic */ FieldHolder $fh;
    public BinaryTaskMng mBinaryTaskMng;
    public Context mContext;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-586312810, "Lcom/baidu/down/request/taskmanager/TaskFacade;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-586312810, "Lcom/baidu/down/request/taskmanager/TaskFacade;");
        }
    }

    public TaskFacade(Context context, TaskManagerConfiguration taskManagerConfiguration) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, taskManagerConfiguration};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mContext = context;
        this.mBinaryTaskMng = new BinaryTaskMng(this.mContext, taskManagerConfiguration);
    }

    public static TaskFacade getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) ? getInstanceByConfig(context, null) : (TaskFacade) invokeL.objValue;
    }

    public static TaskFacade getInstanceByConfig(Context context, TaskManagerConfiguration taskManagerConfiguration) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, taskManagerConfiguration)) == null) {
            if (instance == null) {
                synchronized (TaskFacade.class) {
                    if (instance == null) {
                        if (context == null) {
                            return null;
                        }
                        instance = new TaskFacade(context.getApplicationContext(), taskManagerConfiguration);
                    }
                }
            }
            return instance;
        }
        return (TaskFacade) invokeLL.objValue;
    }

    public static synchronized void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65540, null) == null) {
            synchronized (TaskFacade.class) {
                if (instance != null) {
                    instance.mBinaryTaskMng.release();
                    instance = null;
                }
            }
        }
    }

    public long findTaskCurrentLength(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048576, this, str, j)) == null) ? this.mBinaryTaskMng.findTaskCurrentLength(str, j) : invokeLJ.longValue;
    }

    public String findTaskFilename(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j)) == null) ? this.mBinaryTaskMng.findTaskFilename(str, j) : (String) invokeLJ.objValue;
    }

    public String findTaskFilepath(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, str, j)) == null) ? this.mBinaryTaskMng.findTaskFilepath(str, j) : (String) invokeLJ.objValue;
    }

    public String findTaskMimetype(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048579, this, str, j)) == null) ? this.mBinaryTaskMng.findTaskMimetype(str, j) : (String) invokeLJ.objValue;
    }

    public int findTaskStatus(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048580, this, str, j)) == null) ? this.mBinaryTaskMng.findTaskStatus(str, j) : invokeLJ.intValue;
    }

    public long findTaskTotalLength(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048581, this, str, j)) == null) ? this.mBinaryTaskMng.findTaskTotalLength(str, j) : invokeLJ.longValue;
    }

    public BinaryTaskMng getBinaryTaskMng() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mBinaryTaskMng : (BinaryTaskMng) invokeV.objValue;
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mContext : (Context) invokeV.objValue;
    }

    public int getCurrentTaskVacant() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mBinaryTaskMng.getCurrentVacant() : invokeV.intValue;
    }

    public int getMaxTask() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mBinaryTaskMng.getMaxDownloadThread() : invokeV.intValue;
    }

    public void pauseAllTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.mBinaryTaskMng.pauseAllTask();
        }
    }

    public void pauseDownload(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048587, this, str, j) == null) {
            this.mBinaryTaskMng.pauseDownload(str, j);
        }
    }

    public void setMaxTask(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.mBinaryTaskMng.setMaxDownloadThread(i2);
        }
    }

    public void startAllTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.mBinaryTaskMng.runAllTask();
        }
    }

    public long startDownload(FileMsg fileMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, fileMsg)) == null) ? this.mBinaryTaskMng.startDownload(fileMsg) : invokeL.longValue;
    }

    public void stopAllTask(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.mBinaryTaskMng.stopAllTask(z);
        }
    }

    public void stopDownload(String str, long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{str, Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            this.mBinaryTaskMng.stopDownload(str, j, z);
        }
    }
}
