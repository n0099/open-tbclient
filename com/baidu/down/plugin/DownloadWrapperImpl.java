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
/* loaded from: classes10.dex */
public class DownloadWrapperImpl implements IDownloadWrapper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String TAG = "DownloadWrapperImpl";
    public transient /* synthetic */ FieldHolder $fh;
    public BinaryTaskMng mTaskManager;

    public DownloadWrapperImpl() {
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

    @Override // com.baidu.down.common.IDownloadWrapper
    public void addObserver(TaskObserver taskObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, taskObserver) == null) {
            this.mTaskManager.addObserver(taskObserver);
        }
    }

    @Override // com.baidu.down.common.IDownloadWrapper
    public int getCurrentVacant() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mTaskManager.getCurrentVacant() : invokeV.intValue;
    }

    @Override // com.baidu.down.common.IDownloadWrapper
    public int getDownloadCommonVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 7;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.down.common.IDownloadWrapper
    public StatisticInfo getStatisticInfo(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j2)) == null) ? this.mTaskManager.getStatsticInfo(j2) : (StatisticInfo) invokeJ.objValue;
    }

    @Override // com.baidu.down.common.IDownloadWrapper
    public void pauseAllTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.mTaskManager.pauseAllTask();
        }
    }

    @Override // com.baidu.down.common.IDownloadWrapper
    public void pauseDownload(String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048581, this, str, j2) == null) {
            this.mTaskManager.pauseDownload(str, j2);
        }
    }

    @Override // com.baidu.down.common.IDownloadWrapper
    public void setMaxDownloadThread(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.mTaskManager.setMaxDownloadThread(i2);
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
    public long startDownload(FileMsg fileMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fileMsg)) == null) ? this.mTaskManager.startDownload(fileMsg) : invokeL.longValue;
    }

    @Override // com.baidu.down.common.IDownloadWrapper
    public void stopDownload(String str, long j2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{str, Long.valueOf(j2), Boolean.valueOf(z)}) == null) {
            this.mTaskManager.stopDownload(str, j2, z);
        }
    }
}
