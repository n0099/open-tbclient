package com.baidu.searchbox.bddownload.core.listener;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.DownloadTask;
import com.baidu.searchbox.bddownload.core.breakpoint.BreakpointInfo;
import com.baidu.searchbox.bddownload.core.cause.EndCause;
import com.baidu.searchbox.bddownload.core.cause.ResumeFailedCause;
import com.baidu.searchbox.bddownload.core.listener.assist.ListenerAssist;
import com.baidu.searchbox.bddownload.core.listener.assist.TaskProgressListenerAssist;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public abstract class DownloadTaskProgressListener implements DownloadListener, TaskProgressListenerAssist.TaskProgressListenerCallback, ListenerAssist {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TaskProgressListenerAssist assist;

    public DownloadTaskProgressListener(TaskProgressListenerAssist taskProgressListenerAssist) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {taskProgressListenerAssist};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.assist = taskProgressListenerAssist;
        taskProgressListenerAssist.setCallback(this);
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
    public void connectEnd(@NonNull DownloadTask downloadTask, int i2, int i3, @NonNull Map<String, List<String>> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{downloadTask, Integer.valueOf(i2), Integer.valueOf(i3), map}) == null) {
            this.assist.connectEnd(downloadTask);
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
    public void connectStart(@NonNull DownloadTask downloadTask, int i2, @NonNull Map<String, List<String>> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadTask, i2, map) == null) {
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
    public void connectTrialEnd(@NonNull DownloadTask downloadTask, int i2, @NonNull Map<String, List<String>> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, downloadTask, i2, map) == null) {
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
    public void connectTrialStart(@NonNull DownloadTask downloadTask, @NonNull Map<String, List<String>> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, downloadTask, map) == null) {
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
    public void downloadFromBeginning(@NonNull DownloadTask downloadTask, @NonNull BreakpointInfo breakpointInfo, @NonNull ResumeFailedCause resumeFailedCause) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, downloadTask, breakpointInfo, resumeFailedCause) == null) {
            this.assist.downloadFromBeginning(downloadTask, breakpointInfo, resumeFailedCause);
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
    public void downloadFromBreakpoint(@NonNull DownloadTask downloadTask, @NonNull BreakpointInfo breakpointInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, downloadTask, breakpointInfo) == null) {
            this.assist.downloadFromBreakpoint(downloadTask, breakpointInfo);
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
    public void fetchEnd(@NonNull DownloadTask downloadTask, int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{downloadTask, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
    public void fetchProgress(@NonNull DownloadTask downloadTask, int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{downloadTask, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            this.assist.fetchProgress(downloadTask, j2);
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
    public void fetchStart(@NonNull DownloadTask downloadTask, int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{downloadTask, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.assist.ListenerAssist
    public boolean isAlwaysRecoverAssistModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.assist.isAlwaysRecoverAssistModel() : invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.assist.ListenerAssist
    public void setAlwaysRecoverAssistModel(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.assist.setAlwaysRecoverAssistModel(z);
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.assist.ListenerAssist
    public void setAlwaysRecoverAssistModelIfNotSet(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.assist.setAlwaysRecoverAssistModelIfNotSet(z);
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
    public final void taskEnd(@NonNull DownloadTask downloadTask, @NonNull EndCause endCause, @Nullable Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048588, this, downloadTask, endCause, exc) == null) {
            this.assist.taskEnd(downloadTask, endCause, exc);
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
    public final void taskStart(@NonNull DownloadTask downloadTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, downloadTask) == null) {
            this.assist.taskStart(downloadTask);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DownloadTaskProgressListener() {
        this(new TaskProgressListenerAssist());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((TaskProgressListenerAssist) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }
}
