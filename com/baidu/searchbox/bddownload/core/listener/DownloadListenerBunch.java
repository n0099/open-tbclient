package com.baidu.searchbox.bddownload.core.listener;

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
/* loaded from: classes2.dex */
public class DownloadListenerBunch implements DownloadListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final DownloadListener[] listenerList;

    /* loaded from: classes2.dex */
    public class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List listenerList;

        public Builder() {
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
            this.listenerList = new ArrayList();
        }

        public DownloadListenerBunch build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                List list = this.listenerList;
                return new DownloadListenerBunch((DownloadListener[]) list.toArray(new DownloadListener[list.size()]));
            }
            return (DownloadListenerBunch) invokeV.objValue;
        }

        public Builder append(DownloadListener downloadListener) {
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

        public boolean remove(DownloadListener downloadListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadListener)) == null) {
                return this.listenerList.remove(downloadListener);
            }
            return invokeL.booleanValue;
        }
    }

    public DownloadListenerBunch(DownloadListener[] downloadListenerArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {downloadListenerArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.listenerList = downloadListenerArr;
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

    public int indexOf(DownloadListener downloadListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, downloadListener)) == null) {
            int i = 0;
            while (true) {
                DownloadListener[] downloadListenerArr = this.listenerList;
                if (i < downloadListenerArr.length) {
                    if (downloadListenerArr[i] == downloadListener) {
                        return i;
                    }
                    i++;
                } else {
                    return -1;
                }
            }
        } else {
            return invokeL.intValue;
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
    public void taskStart(DownloadTask downloadTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, downloadTask) == null) {
            for (DownloadListener downloadListener : this.listenerList) {
                downloadListener.taskStart(downloadTask);
            }
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
    public void connectEnd(DownloadTask downloadTask, int i, int i2, Map map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{downloadTask, Integer.valueOf(i), Integer.valueOf(i2), map}) == null) {
            for (DownloadListener downloadListener : this.listenerList) {
                downloadListener.connectEnd(downloadTask, i, i2, map);
            }
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
    public void connectStart(DownloadTask downloadTask, int i, Map map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadTask, i, map) == null) {
            for (DownloadListener downloadListener : this.listenerList) {
                downloadListener.connectStart(downloadTask, i, map);
            }
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
    public void connectTrialEnd(DownloadTask downloadTask, int i, Map map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, downloadTask, i, map) == null) {
            for (DownloadListener downloadListener : this.listenerList) {
                downloadListener.connectTrialEnd(downloadTask, i, map);
            }
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
    public void downloadFromBeginning(DownloadTask downloadTask, BreakpointInfo breakpointInfo, ResumeFailedCause resumeFailedCause) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, downloadTask, breakpointInfo, resumeFailedCause) == null) {
            for (DownloadListener downloadListener : this.listenerList) {
                downloadListener.downloadFromBeginning(downloadTask, breakpointInfo, resumeFailedCause);
            }
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
    public void taskEnd(DownloadTask downloadTask, EndCause endCause, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, downloadTask, endCause, exc) == null) {
            for (DownloadListener downloadListener : this.listenerList) {
                downloadListener.taskEnd(downloadTask, endCause, exc);
            }
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
    public void connectTrialStart(DownloadTask downloadTask, Map map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, downloadTask, map) == null) {
            for (DownloadListener downloadListener : this.listenerList) {
                downloadListener.connectTrialStart(downloadTask, map);
            }
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
    public void downloadFromBreakpoint(DownloadTask downloadTask, BreakpointInfo breakpointInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, downloadTask, breakpointInfo) == null) {
            for (DownloadListener downloadListener : this.listenerList) {
                downloadListener.downloadFromBreakpoint(downloadTask, breakpointInfo);
            }
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
    public void fetchEnd(DownloadTask downloadTask, int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{downloadTask, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            for (DownloadListener downloadListener : this.listenerList) {
                downloadListener.fetchEnd(downloadTask, i, j);
            }
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
    public void fetchProgress(DownloadTask downloadTask, int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{downloadTask, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            for (DownloadListener downloadListener : this.listenerList) {
                downloadListener.fetchProgress(downloadTask, i, j);
            }
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
    public void fetchStart(DownloadTask downloadTask, int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{downloadTask, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            for (DownloadListener downloadListener : this.listenerList) {
                downloadListener.fetchStart(downloadTask, i, j);
            }
        }
    }
}
