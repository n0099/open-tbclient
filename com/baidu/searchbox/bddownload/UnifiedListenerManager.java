package com.baidu.searchbox.bddownload;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.core.breakpoint.BreakpointInfo;
import com.baidu.searchbox.bddownload.core.cause.EndCause;
import com.baidu.searchbox.bddownload.core.cause.ResumeFailedCause;
import com.baidu.searchbox.bddownload.core.listener.DownloadListener;
import com.baidu.searchbox.bddownload.core.listener.assist.ListenerAssist;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class UnifiedListenerManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<Integer> autoRemoveListenerIdList;
    public final DownloadListener hostListener;
    public final SparseArray<ArrayList<DownloadListener>> realListenerMap;

    public UnifiedListenerManager() {
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
        this.autoRemoveListenerIdList = new ArrayList();
        this.hostListener = new DownloadListener(this) { // from class: com.baidu.searchbox.bddownload.UnifiedListenerManager.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ UnifiedListenerManager this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
            public void taskStart(@NonNull DownloadTask downloadTask) {
                DownloadListener[] threadSafeArray;
                Interceptable interceptable2 = $ic;
                if ((interceptable2 != null && interceptable2.invokeL(1048586, this, downloadTask) != null) || (threadSafeArray = UnifiedListenerManager.getThreadSafeArray(downloadTask, this.this$0.realListenerMap)) == null) {
                    return;
                }
                for (DownloadListener downloadListener : threadSafeArray) {
                    if (downloadListener != null) {
                        downloadListener.taskStart(downloadTask);
                    }
                }
            }

            @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
            public void connectEnd(@NonNull DownloadTask downloadTask, int i3, int i4, @NonNull Map<String, List<String>> map) {
                DownloadListener[] threadSafeArray;
                Interceptable interceptable2 = $ic;
                if ((interceptable2 != null && interceptable2.invokeCommon(1048576, this, new Object[]{downloadTask, Integer.valueOf(i3), Integer.valueOf(i4), map}) != null) || (threadSafeArray = UnifiedListenerManager.getThreadSafeArray(downloadTask, this.this$0.realListenerMap)) == null) {
                    return;
                }
                for (DownloadListener downloadListener : threadSafeArray) {
                    if (downloadListener != null) {
                        downloadListener.connectEnd(downloadTask, i3, i4, map);
                    }
                }
            }

            @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
            public void connectStart(@NonNull DownloadTask downloadTask, int i3, @NonNull Map<String, List<String>> map) {
                DownloadListener[] threadSafeArray;
                Interceptable interceptable2 = $ic;
                if ((interceptable2 != null && interceptable2.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadTask, i3, map) != null) || (threadSafeArray = UnifiedListenerManager.getThreadSafeArray(downloadTask, this.this$0.realListenerMap)) == null) {
                    return;
                }
                for (DownloadListener downloadListener : threadSafeArray) {
                    if (downloadListener != null) {
                        downloadListener.connectStart(downloadTask, i3, map);
                    }
                }
            }

            @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
            public void connectTrialEnd(@NonNull DownloadTask downloadTask, int i3, @NonNull Map<String, List<String>> map) {
                DownloadListener[] threadSafeArray;
                Interceptable interceptable2 = $ic;
                if ((interceptable2 != null && interceptable2.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, downloadTask, i3, map) != null) || (threadSafeArray = UnifiedListenerManager.getThreadSafeArray(downloadTask, this.this$0.realListenerMap)) == null) {
                    return;
                }
                for (DownloadListener downloadListener : threadSafeArray) {
                    if (downloadListener != null) {
                        downloadListener.connectTrialEnd(downloadTask, i3, map);
                    }
                }
            }

            @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
            public void downloadFromBeginning(@NonNull DownloadTask downloadTask, @NonNull BreakpointInfo breakpointInfo, @NonNull ResumeFailedCause resumeFailedCause) {
                DownloadListener[] threadSafeArray;
                Interceptable interceptable2 = $ic;
                if ((interceptable2 != null && interceptable2.invokeLLL(1048580, this, downloadTask, breakpointInfo, resumeFailedCause) != null) || (threadSafeArray = UnifiedListenerManager.getThreadSafeArray(downloadTask, this.this$0.realListenerMap)) == null) {
                    return;
                }
                for (DownloadListener downloadListener : threadSafeArray) {
                    if (downloadListener != null) {
                        downloadListener.downloadFromBeginning(downloadTask, breakpointInfo, resumeFailedCause);
                    }
                }
            }

            @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
            public void connectTrialStart(@NonNull DownloadTask downloadTask, @NonNull Map<String, List<String>> map) {
                DownloadListener[] threadSafeArray;
                Interceptable interceptable2 = $ic;
                if ((interceptable2 != null && interceptable2.invokeLL(1048579, this, downloadTask, map) != null) || (threadSafeArray = UnifiedListenerManager.getThreadSafeArray(downloadTask, this.this$0.realListenerMap)) == null) {
                    return;
                }
                for (DownloadListener downloadListener : threadSafeArray) {
                    if (downloadListener != null) {
                        downloadListener.connectTrialStart(downloadTask, map);
                    }
                }
            }

            @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
            public void downloadFromBreakpoint(@NonNull DownloadTask downloadTask, @NonNull BreakpointInfo breakpointInfo) {
                DownloadListener[] threadSafeArray;
                Interceptable interceptable2 = $ic;
                if ((interceptable2 != null && interceptable2.invokeLL(1048581, this, downloadTask, breakpointInfo) != null) || (threadSafeArray = UnifiedListenerManager.getThreadSafeArray(downloadTask, this.this$0.realListenerMap)) == null) {
                    return;
                }
                for (DownloadListener downloadListener : threadSafeArray) {
                    if (downloadListener != null) {
                        downloadListener.downloadFromBreakpoint(downloadTask, breakpointInfo);
                    }
                }
            }

            @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
            public void fetchEnd(@NonNull DownloadTask downloadTask, int i3, long j) {
                DownloadListener[] threadSafeArray;
                Interceptable interceptable2 = $ic;
                if ((interceptable2 != null && interceptable2.invokeCommon(1048582, this, new Object[]{downloadTask, Integer.valueOf(i3), Long.valueOf(j)}) != null) || (threadSafeArray = UnifiedListenerManager.getThreadSafeArray(downloadTask, this.this$0.realListenerMap)) == null) {
                    return;
                }
                for (DownloadListener downloadListener : threadSafeArray) {
                    if (downloadListener != null) {
                        downloadListener.fetchEnd(downloadTask, i3, j);
                    }
                }
            }

            @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
            public void fetchProgress(@NonNull DownloadTask downloadTask, int i3, long j) {
                DownloadListener[] threadSafeArray;
                Interceptable interceptable2 = $ic;
                if ((interceptable2 != null && interceptable2.invokeCommon(1048583, this, new Object[]{downloadTask, Integer.valueOf(i3), Long.valueOf(j)}) != null) || (threadSafeArray = UnifiedListenerManager.getThreadSafeArray(downloadTask, this.this$0.realListenerMap)) == null) {
                    return;
                }
                for (DownloadListener downloadListener : threadSafeArray) {
                    if (downloadListener != null) {
                        downloadListener.fetchProgress(downloadTask, i3, j);
                    }
                }
            }

            @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
            public void fetchStart(@NonNull DownloadTask downloadTask, int i3, long j) {
                DownloadListener[] threadSafeArray;
                Interceptable interceptable2 = $ic;
                if ((interceptable2 != null && interceptable2.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{downloadTask, Integer.valueOf(i3), Long.valueOf(j)}) != null) || (threadSafeArray = UnifiedListenerManager.getThreadSafeArray(downloadTask, this.this$0.realListenerMap)) == null) {
                    return;
                }
                for (DownloadListener downloadListener : threadSafeArray) {
                    if (downloadListener != null) {
                        downloadListener.fetchStart(downloadTask, i3, j);
                    }
                }
            }

            @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
            public void taskEnd(@NonNull DownloadTask downloadTask, @NonNull EndCause endCause, @Nullable Exception exc) {
                DownloadListener[] threadSafeArray;
                Interceptable interceptable2 = $ic;
                if ((interceptable2 != null && interceptable2.invokeLLL(1048585, this, downloadTask, endCause, exc) != null) || (threadSafeArray = UnifiedListenerManager.getThreadSafeArray(downloadTask, this.this$0.realListenerMap)) == null) {
                    return;
                }
                for (DownloadListener downloadListener : threadSafeArray) {
                    if (downloadListener != null) {
                        downloadListener.taskEnd(downloadTask, endCause, exc);
                    }
                }
                if (this.this$0.autoRemoveListenerIdList.contains(Integer.valueOf(downloadTask.getId()))) {
                    this.this$0.detachListener(downloadTask.getId());
                }
            }
        };
        this.realListenerMap = new SparseArray<>();
    }

    public synchronized void attachAndEnqueueIfNotRun(@NonNull DownloadTask downloadTask, @NonNull DownloadListener downloadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadTask, downloadListener) == null) {
            synchronized (this) {
                attachListener(downloadTask, downloadListener);
                if (!isTaskPendingOrRunning(downloadTask)) {
                    downloadTask.enqueue(this.hostListener);
                }
            }
        }
    }

    public synchronized void enqueueTaskWithUnifiedListener(@NonNull DownloadTask downloadTask, @NonNull DownloadListener downloadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, downloadTask, downloadListener) == null) {
            synchronized (this) {
                attachListener(downloadTask, downloadListener);
                downloadTask.enqueue(this.hostListener);
            }
        }
    }

    public synchronized void executeTaskWithUnifiedListener(@NonNull DownloadTask downloadTask, @NonNull DownloadListener downloadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, downloadTask, downloadListener) == null) {
            synchronized (this) {
                attachListener(downloadTask, downloadListener);
                downloadTask.execute(this.hostListener);
            }
        }
    }

    public static DownloadListener[] getThreadSafeArray(DownloadTask downloadTask, SparseArray<ArrayList<DownloadListener>> sparseArray) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, downloadTask, sparseArray)) == null) {
            ArrayList<DownloadListener> arrayList = sparseArray.get(downloadTask.getId());
            if (arrayList != null && arrayList.size() > 0) {
                DownloadListener[] downloadListenerArr = new DownloadListener[arrayList.size()];
                arrayList.toArray(downloadListenerArr);
                return downloadListenerArr;
            }
            return null;
        }
        return (DownloadListener[]) invokeLL.objValue;
    }

    public synchronized void attachListener(@NonNull DownloadTask downloadTask, @NonNull DownloadListener downloadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, downloadTask, downloadListener) == null) {
            synchronized (this) {
                int id = downloadTask.getId();
                ArrayList<DownloadListener> arrayList = this.realListenerMap.get(id);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    this.realListenerMap.put(id, arrayList);
                }
                if (!arrayList.contains(downloadListener)) {
                    arrayList.add(downloadListener);
                    if (downloadListener instanceof ListenerAssist) {
                        ((ListenerAssist) downloadListener).setAlwaysRecoverAssistModelIfNotSet(true);
                    }
                }
            }
        }
    }

    public synchronized boolean detachListener(@NonNull DownloadTask downloadTask, DownloadListener downloadListener) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, downloadTask, downloadListener)) == null) {
            synchronized (this) {
                int id = downloadTask.getId();
                ArrayList<DownloadListener> arrayList = this.realListenerMap.get(id);
                if (arrayList == null) {
                    return false;
                }
                boolean remove = arrayList.remove(downloadListener);
                if (arrayList.isEmpty()) {
                    this.realListenerMap.remove(id);
                }
                return remove;
            }
        }
        return invokeLL.booleanValue;
    }

    public synchronized void addAutoRemoveListenersWhenTaskEnd(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            synchronized (this) {
                if (this.autoRemoveListenerIdList.contains(Integer.valueOf(i))) {
                    return;
                }
                this.autoRemoveListenerIdList.add(Integer.valueOf(i));
            }
        }
    }

    public synchronized void detachListener(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            synchronized (this) {
                this.realListenerMap.remove(i);
            }
        }
    }

    public boolean isTaskPendingOrRunning(@NonNull DownloadTask downloadTask) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, downloadTask)) == null) {
            return StatusUtil.isSameTaskPendingOrRunning(downloadTask);
        }
        return invokeL.booleanValue;
    }

    public synchronized void removeAutoRemoveListenersWhenTaskEnd(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            synchronized (this) {
                this.autoRemoveListenerIdList.remove(Integer.valueOf(i));
            }
        }
    }

    public synchronized void detachListener(DownloadListener downloadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, downloadListener) == null) {
            synchronized (this) {
                int size = this.realListenerMap.size();
                ArrayList<Integer> arrayList = new ArrayList();
                for (int i = 0; i < size; i++) {
                    ArrayList<DownloadListener> valueAt = this.realListenerMap.valueAt(i);
                    if (valueAt != null) {
                        valueAt.remove(downloadListener);
                        if (valueAt.isEmpty()) {
                            arrayList.add(Integer.valueOf(this.realListenerMap.keyAt(i)));
                        }
                    }
                }
                for (Integer num : arrayList) {
                    this.realListenerMap.remove(num.intValue());
                }
            }
        }
    }

    @NonNull
    public DownloadListener getHostListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.hostListener;
        }
        return (DownloadListener) invokeV.objValue;
    }
}
