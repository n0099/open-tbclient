package com.baidu.searchbox.bddownload.core.listener;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.DownloadTask;
import com.baidu.searchbox.bddownload.core.breakpoint.BreakpointInfo;
import com.baidu.searchbox.bddownload.core.cause.EndCause;
import com.baidu.searchbox.bddownload.core.cause.ResumeFailedCause;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes10.dex */
public class DownloadListenerBunch implements DownloadListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final DownloadListener[] listenerList;

    /* loaded from: classes10.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<DownloadListener> listenerList;

        public Builder() {
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
            this.listenerList = new ArrayList();
        }

        public Builder append(@Nullable DownloadListener downloadListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, downloadListener)) == null) {
                if (downloadListener != null && !this.listenerList.contains(downloadListener)) {
                    this.listenerList.add(downloadListener);
                }
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public DownloadListenerBunch build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                List<DownloadListener> list = this.listenerList;
                return new DownloadListenerBunch((DownloadListener[]) list.toArray(new DownloadListener[list.size()]));
            }
            return (DownloadListenerBunch) invokeV.objValue;
        }

        public boolean remove(DownloadListener downloadListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadListener)) == null) ? this.listenerList.remove(downloadListener) : invokeL.booleanValue;
        }
    }

    public DownloadListenerBunch(@NonNull DownloadListener[] downloadListenerArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {downloadListenerArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.listenerList = downloadListenerArr;
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
    public void connectEnd(@NonNull DownloadTask downloadTask, int i2, int i3, @NonNull Map<String, List<String>> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{downloadTask, Integer.valueOf(i2), Integer.valueOf(i3), map}) == null) {
            for (DownloadListener downloadListener : this.listenerList) {
                downloadListener.connectEnd(downloadTask, i2, i3, map);
            }
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
    public void connectStart(@NonNull DownloadTask downloadTask, int i2, @NonNull Map<String, List<String>> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadTask, i2, map) == null) {
            for (DownloadListener downloadListener : this.listenerList) {
                downloadListener.connectStart(downloadTask, i2, map);
            }
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
    public void connectTrialEnd(@NonNull DownloadTask downloadTask, int i2, @NonNull Map<String, List<String>> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, downloadTask, i2, map) == null) {
            for (DownloadListener downloadListener : this.listenerList) {
                downloadListener.connectTrialEnd(downloadTask, i2, map);
            }
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
    public void connectTrialStart(@NonNull DownloadTask downloadTask, @NonNull Map<String, List<String>> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, downloadTask, map) == null) {
            for (DownloadListener downloadListener : this.listenerList) {
                downloadListener.connectTrialStart(downloadTask, map);
            }
        }
    }

    public boolean contain(DownloadListener downloadListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, downloadListener)) == null) {
            for (DownloadListener downloadListener2 : this.listenerList) {
                if (downloadListener2 == downloadListener) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
    public void downloadFromBeginning(@NonNull DownloadTask downloadTask, @NonNull BreakpointInfo breakpointInfo, @NonNull ResumeFailedCause resumeFailedCause) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, downloadTask, breakpointInfo, resumeFailedCause) == null) {
            for (DownloadListener downloadListener : this.listenerList) {
                downloadListener.downloadFromBeginning(downloadTask, breakpointInfo, resumeFailedCause);
            }
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
    public void downloadFromBreakpoint(@NonNull DownloadTask downloadTask, @NonNull BreakpointInfo breakpointInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, downloadTask, breakpointInfo) == null) {
            for (DownloadListener downloadListener : this.listenerList) {
                downloadListener.downloadFromBreakpoint(downloadTask, breakpointInfo);
            }
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
    public void fetchEnd(@NonNull DownloadTask downloadTask, int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{downloadTask, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            for (DownloadListener downloadListener : this.listenerList) {
                downloadListener.fetchEnd(downloadTask, i2, j2);
            }
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
    public void fetchProgress(@NonNull DownloadTask downloadTask, int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{downloadTask, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            for (DownloadListener downloadListener : this.listenerList) {
                downloadListener.fetchProgress(downloadTask, i2, j2);
            }
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
    public void fetchStart(@NonNull DownloadTask downloadTask, int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{downloadTask, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            for (DownloadListener downloadListener : this.listenerList) {
                downloadListener.fetchStart(downloadTask, i2, j2);
            }
        }
    }

    public int indexOf(DownloadListener downloadListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048586, this, downloadListener)) != null) {
            return invokeL.intValue;
        }
        int i2 = 0;
        while (true) {
            DownloadListener[] downloadListenerArr = this.listenerList;
            if (i2 >= downloadListenerArr.length) {
                return -1;
            }
            if (downloadListenerArr[i2] == downloadListener) {
                return i2;
            }
            i2++;
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
    public void taskEnd(@NonNull DownloadTask downloadTask, @NonNull EndCause endCause, @Nullable Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, downloadTask, endCause, exc) == null) {
            for (DownloadListener downloadListener : this.listenerList) {
                downloadListener.taskEnd(downloadTask, endCause, exc);
            }
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
    public void taskStart(@NonNull DownloadTask downloadTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, downloadTask) == null) {
            for (DownloadListener downloadListener : this.listenerList) {
                downloadListener.taskStart(downloadTask);
            }
        }
    }
}
