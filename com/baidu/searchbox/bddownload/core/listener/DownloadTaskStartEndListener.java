package com.baidu.searchbox.bddownload.core.listener;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.DownloadTask;
import com.baidu.searchbox.bddownload.core.breakpoint.BreakpointInfo;
import com.baidu.searchbox.bddownload.core.cause.ResumeFailedCause;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.Map;
/* loaded from: classes10.dex */
public abstract class DownloadTaskStartEndListener implements DownloadListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public DownloadTaskStartEndListener() {
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

    @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
    public void connectEnd(@NonNull DownloadTask downloadTask, int i2, int i3, @NonNull Map<String, List<String>> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{downloadTask, Integer.valueOf(i2), Integer.valueOf(i3), map}) == null) {
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
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
    public void downloadFromBreakpoint(@NonNull DownloadTask downloadTask, @NonNull BreakpointInfo breakpointInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, downloadTask, breakpointInfo) == null) {
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
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
    public void fetchStart(@NonNull DownloadTask downloadTask, int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{downloadTask, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
        }
    }
}
