package com.baidu.down.plugin;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.common.FileMsg;
import com.baidu.down.common.IDownloadWrapper;
import com.baidu.down.common.StatisticInfo;
import com.baidu.down.common.TaskManagerConfiguration;
import com.baidu.down.common.TaskObserver;
import com.baidu.down.request.taskmanager.BinaryTaskMng;
import com.baidu.down.request.taskmanager.TaskFacade;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class DownloadWrapperImpl implements IDownloadWrapper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String TAG = "DownloadWrapperImpl";
    public transient /* synthetic */ FieldHolder $fh;
    public BinaryTaskMng mTaskManager;

    @Override // com.baidu.down.common.IDownloadWrapper
    public int getDownloadCommonVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 7;
        }
        return invokeV.intValue;
    }

    public DownloadWrapperImpl() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.down.common.IDownloadWrapper
    public int getCurrentVacant() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mTaskManager.getCurrentVacant();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.down.common.IDownloadWrapper
    public void pauseAllTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.mTaskManager.pauseAllTask();
        }
    }

    @Override // com.baidu.down.common.IDownloadWrapper
    public void addObserver(TaskObserver taskObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, taskObserver) == null) {
            this.mTaskManager.addObserver(taskObserver);
        }
    }

    @Override // com.baidu.down.common.IDownloadWrapper
    public StatisticInfo getStatisticInfo(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) {
            return this.mTaskManager.getStatsticInfo(j);
        }
        return (StatisticInfo) invokeJ.objValue;
    }

    @Override // com.baidu.down.common.IDownloadWrapper
    public void setMaxDownloadThread(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.mTaskManager.setMaxDownloadThread(i);
        }
    }

    @Override // com.baidu.down.common.IDownloadWrapper
    public long startDownload(FileMsg fileMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fileMsg)) == null) {
            return this.mTaskManager.startDownload(fileMsg);
        }
        return invokeL.longValue;
    }

    @Override // com.baidu.down.common.IDownloadWrapper
    public void pauseDownload(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048581, this, str, j) == null) {
            this.mTaskManager.pauseDownload(str, j);
        }
    }

    @Override // com.baidu.down.common.IDownloadWrapper
    public void setup(Context context, TaskManagerConfiguration taskManagerConfiguration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, context, taskManagerConfiguration) == null) {
            this.mTaskManager = TaskFacade.getInstanceByConfig(context, taskManagerConfiguration).getBinaryTaskMng();
        }
    }

    @Override // com.baidu.down.common.IDownloadWrapper
    public void stopDownload(String str, long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{str, Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            this.mTaskManager.stopDownload(str, j, z);
        }
    }
}
