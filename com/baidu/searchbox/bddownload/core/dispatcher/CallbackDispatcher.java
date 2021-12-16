package com.baidu.searchbox.bddownload.core.dispatcher;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.bddownload.BdDownload;
import com.baidu.searchbox.bddownload.DownloadMonitor;
import com.baidu.searchbox.bddownload.DownloadTask;
import com.baidu.searchbox.bddownload.core.Util;
import com.baidu.searchbox.bddownload.core.breakpoint.BreakpointInfo;
import com.baidu.searchbox.bddownload.core.cause.EndCause;
import com.baidu.searchbox.bddownload.core.cause.ResumeFailedCause;
import com.baidu.searchbox.bddownload.core.listener.DownloadListener;
import com.baidu.searchbox.bddownload.statistic.StatisticManager;
import com.baidu.searchbox.bddownload.statistic.StatisticsInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes10.dex */
public class CallbackDispatcher {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "CallbackDispatcher";
    public transient /* synthetic */ FieldHolder $fh;
    public final DownloadListener transmit;
    public final Handler uiHandler;

    /* loaded from: classes10.dex */
    public static class DefaultTransmitListener implements DownloadListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public final Handler uiHandler;

        public DefaultTransmitListener(@NonNull Handler handler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {handler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.uiHandler = handler;
        }

        @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
        public void connectEnd(@NonNull DownloadTask downloadTask, int i2, int i3, @NonNull Map<String, List<String>> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{downloadTask, Integer.valueOf(i2), Integer.valueOf(i3), map}) == null) {
                Util.d(CallbackDispatcher.TAG, "<----- finish connection task(" + downloadTask.getId() + ") block(" + i2 + ") code[" + i3 + PreferencesUtil.RIGHT_MOUNT + map);
                if (downloadTask.isAutoCallbackToUIThread()) {
                    this.uiHandler.post(new Runnable(this, downloadTask, i2, i3, map) { // from class: com.baidu.searchbox.bddownload.core.dispatcher.CallbackDispatcher.DefaultTransmitListener.7
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ DefaultTransmitListener this$0;
                        public final /* synthetic */ int val$blockIndex;
                        public final /* synthetic */ Map val$requestHeaderFields;
                        public final /* synthetic */ int val$responseCode;
                        public final /* synthetic */ DownloadTask val$task;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, downloadTask, Integer.valueOf(i2), Integer.valueOf(i3), map};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i4 = newInitContext.flag;
                                if ((i4 & 1) != 0) {
                                    int i5 = i4 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$task = downloadTask;
                            this.val$blockIndex = i2;
                            this.val$responseCode = i3;
                            this.val$requestHeaderFields = map;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.val$task.getListener().connectEnd(this.val$task, this.val$blockIndex, this.val$responseCode, this.val$requestHeaderFields);
                            }
                        }
                    });
                } else {
                    downloadTask.getListener().connectEnd(downloadTask, i2, i3, map);
                }
            }
        }

        @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
        public void connectStart(@NonNull DownloadTask downloadTask, int i2, @NonNull Map<String, List<String>> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadTask, i2, map) == null) {
                Util.d(CallbackDispatcher.TAG, "-----> start connection task(" + downloadTask.getId() + ") block(" + i2 + ") " + map);
                if (downloadTask.isAutoCallbackToUIThread()) {
                    this.uiHandler.post(new Runnable(this, downloadTask, i2, map) { // from class: com.baidu.searchbox.bddownload.core.dispatcher.CallbackDispatcher.DefaultTransmitListener.6
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ DefaultTransmitListener this$0;
                        public final /* synthetic */ int val$blockIndex;
                        public final /* synthetic */ Map val$requestHeaderFields;
                        public final /* synthetic */ DownloadTask val$task;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, downloadTask, Integer.valueOf(i2), map};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$task = downloadTask;
                            this.val$blockIndex = i2;
                            this.val$requestHeaderFields = map;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.val$task.getListener().connectStart(this.val$task, this.val$blockIndex, this.val$requestHeaderFields);
                            }
                        }
                    });
                } else {
                    downloadTask.getListener().connectStart(downloadTask, i2, map);
                }
            }
        }

        @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
        public void connectTrialEnd(@NonNull DownloadTask downloadTask, int i2, @NonNull Map<String, List<String>> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, downloadTask, i2, map) == null) {
                Util.d(CallbackDispatcher.TAG, "<----- finish trial task(" + downloadTask.getId() + ") code[" + i2 + PreferencesUtil.RIGHT_MOUNT + map);
                if (downloadTask.isAutoCallbackToUIThread()) {
                    this.uiHandler.post(new Runnable(this, downloadTask, i2, map) { // from class: com.baidu.searchbox.bddownload.core.dispatcher.CallbackDispatcher.DefaultTransmitListener.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ DefaultTransmitListener this$0;
                        public final /* synthetic */ Map val$headerFields;
                        public final /* synthetic */ int val$responseCode;
                        public final /* synthetic */ DownloadTask val$task;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, downloadTask, Integer.valueOf(i2), map};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$task = downloadTask;
                            this.val$responseCode = i2;
                            this.val$headerFields = map;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.val$task.getListener().connectTrialEnd(this.val$task, this.val$responseCode, this.val$headerFields);
                            }
                        }
                    });
                } else {
                    downloadTask.getListener().connectTrialEnd(downloadTask, i2, map);
                }
            }
        }

        @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
        public void connectTrialStart(@NonNull DownloadTask downloadTask, @NonNull Map<String, List<String>> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, downloadTask, map) == null) {
                Util.d(CallbackDispatcher.TAG, "-----> start trial task(" + downloadTask.getId() + ") " + map);
                if (downloadTask.isAutoCallbackToUIThread()) {
                    this.uiHandler.post(new Runnable(this, downloadTask, map) { // from class: com.baidu.searchbox.bddownload.core.dispatcher.CallbackDispatcher.DefaultTransmitListener.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ DefaultTransmitListener this$0;
                        public final /* synthetic */ Map val$headerFields;
                        public final /* synthetic */ DownloadTask val$task;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, downloadTask, map};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$task = downloadTask;
                            this.val$headerFields = map;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.val$task.getListener().connectTrialStart(this.val$task, this.val$headerFields);
                            }
                        }
                    });
                } else {
                    downloadTask.getListener().connectTrialStart(downloadTask, map);
                }
            }
        }

        @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
        public void downloadFromBeginning(@NonNull DownloadTask downloadTask, @NonNull BreakpointInfo breakpointInfo, @NonNull ResumeFailedCause resumeFailedCause) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048580, this, downloadTask, breakpointInfo, resumeFailedCause) == null) {
                Util.d(CallbackDispatcher.TAG, "downloadFromBeginning: " + downloadTask.getId());
                inspectDownloadFromBeginning(downloadTask, breakpointInfo, resumeFailedCause);
                if (downloadTask.isAutoCallbackToUIThread()) {
                    this.uiHandler.post(new Runnable(this, downloadTask, breakpointInfo, resumeFailedCause) { // from class: com.baidu.searchbox.bddownload.core.dispatcher.CallbackDispatcher.DefaultTransmitListener.4
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ DefaultTransmitListener this$0;
                        public final /* synthetic */ ResumeFailedCause val$cause;
                        public final /* synthetic */ BreakpointInfo val$info;
                        public final /* synthetic */ DownloadTask val$task;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, downloadTask, breakpointInfo, resumeFailedCause};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$task = downloadTask;
                            this.val$info = breakpointInfo;
                            this.val$cause = resumeFailedCause;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.val$task.getListener().downloadFromBeginning(this.val$task, this.val$info, this.val$cause);
                            }
                        }
                    });
                } else {
                    downloadTask.getListener().downloadFromBeginning(downloadTask, breakpointInfo, resumeFailedCause);
                }
            }
        }

        @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
        public void downloadFromBreakpoint(@NonNull DownloadTask downloadTask, @NonNull BreakpointInfo breakpointInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, downloadTask, breakpointInfo) == null) {
                Util.d(CallbackDispatcher.TAG, "downloadFromBreakpoint: " + downloadTask.getId());
                inspectDownloadFromBreakpoint(downloadTask, breakpointInfo);
                if (downloadTask.isAutoCallbackToUIThread()) {
                    this.uiHandler.post(new Runnable(this, downloadTask, breakpointInfo) { // from class: com.baidu.searchbox.bddownload.core.dispatcher.CallbackDispatcher.DefaultTransmitListener.5
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ DefaultTransmitListener this$0;
                        public final /* synthetic */ BreakpointInfo val$info;
                        public final /* synthetic */ DownloadTask val$task;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, downloadTask, breakpointInfo};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$task = downloadTask;
                            this.val$info = breakpointInfo;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.val$task.getListener().downloadFromBreakpoint(this.val$task, this.val$info);
                            }
                        }
                    });
                } else {
                    downloadTask.getListener().downloadFromBreakpoint(downloadTask, breakpointInfo);
                }
                StatisticsInfo.Builder builder = new StatisticsInfo.Builder();
                builder.buildDownloadUrl(downloadTask.getUrl());
                String mimeType = downloadTask.getInfo() != null ? downloadTask.getInfo().getMimeType() : "";
                if (TextUtils.isEmpty(mimeType)) {
                    mimeType = "unknown";
                }
                builder.buildFileType(mimeType);
                StatisticManager.Companion.get().downloadResumeReport(builder.build());
            }
        }

        @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
        public void fetchEnd(@NonNull DownloadTask downloadTask, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{downloadTask, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                Util.d(CallbackDispatcher.TAG, "fetchEnd: " + downloadTask.getId());
                if (downloadTask.isAutoCallbackToUIThread()) {
                    this.uiHandler.post(new Runnable(this, downloadTask, i2, j2) { // from class: com.baidu.searchbox.bddownload.core.dispatcher.CallbackDispatcher.DefaultTransmitListener.10
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ DefaultTransmitListener this$0;
                        public final /* synthetic */ int val$blockIndex;
                        public final /* synthetic */ long val$contentLength;
                        public final /* synthetic */ DownloadTask val$task;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, downloadTask, Integer.valueOf(i2), Long.valueOf(j2)};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$task = downloadTask;
                            this.val$blockIndex = i2;
                            this.val$contentLength = j2;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.val$task.getListener().fetchEnd(this.val$task, this.val$blockIndex, this.val$contentLength);
                            }
                        }
                    });
                } else {
                    downloadTask.getListener().fetchEnd(downloadTask, i2, j2);
                }
            }
        }

        @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
        public void fetchProgress(@NonNull DownloadTask downloadTask, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{downloadTask, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                if (downloadTask.getMinIntervalMillisCallbackProcess() > 0) {
                    DownloadTask.TaskHideWrapper.setLastCallbackProcessTs(downloadTask, SystemClock.uptimeMillis());
                    DownloadTask.TaskHideWrapper.setSpeedIncreaseBytes(downloadTask, j2);
                }
                if (downloadTask.isAutoCallbackToUIThread()) {
                    this.uiHandler.post(new Runnable(this, downloadTask, i2, j2) { // from class: com.baidu.searchbox.bddownload.core.dispatcher.CallbackDispatcher.DefaultTransmitListener.9
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ DefaultTransmitListener this$0;
                        public final /* synthetic */ int val$blockIndex;
                        public final /* synthetic */ long val$increaseBytes;
                        public final /* synthetic */ DownloadTask val$task;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, downloadTask, Integer.valueOf(i2), Long.valueOf(j2)};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$task = downloadTask;
                            this.val$blockIndex = i2;
                            this.val$increaseBytes = j2;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.val$task.getListener().fetchProgress(this.val$task, this.val$blockIndex, this.val$increaseBytes);
                            }
                        }
                    });
                } else {
                    downloadTask.getListener().fetchProgress(downloadTask, i2, j2);
                }
            }
        }

        @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
        public void fetchStart(@NonNull DownloadTask downloadTask, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{downloadTask, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                Util.d(CallbackDispatcher.TAG, "fetchStart: " + downloadTask.getId());
                if (downloadTask.isAutoCallbackToUIThread()) {
                    this.uiHandler.post(new Runnable(this, downloadTask, i2, j2) { // from class: com.baidu.searchbox.bddownload.core.dispatcher.CallbackDispatcher.DefaultTransmitListener.8
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ DefaultTransmitListener this$0;
                        public final /* synthetic */ int val$blockIndex;
                        public final /* synthetic */ long val$contentLength;
                        public final /* synthetic */ DownloadTask val$task;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, downloadTask, Integer.valueOf(i2), Long.valueOf(j2)};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$task = downloadTask;
                            this.val$blockIndex = i2;
                            this.val$contentLength = j2;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.val$task.getListener().fetchStart(this.val$task, this.val$blockIndex, this.val$contentLength);
                            }
                        }
                    });
                } else {
                    downloadTask.getListener().fetchStart(downloadTask, i2, j2);
                }
            }
        }

        public void inspectDownloadFromBeginning(@NonNull DownloadTask downloadTask, @NonNull BreakpointInfo breakpointInfo, @NonNull ResumeFailedCause resumeFailedCause) {
            DownloadMonitor monitor;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(1048585, this, downloadTask, breakpointInfo, resumeFailedCause) == null) || (monitor = BdDownload.with().getMonitor()) == null) {
                return;
            }
            monitor.taskDownloadFromBeginning(downloadTask, breakpointInfo, resumeFailedCause);
        }

        public void inspectDownloadFromBreakpoint(@NonNull DownloadTask downloadTask, @NonNull BreakpointInfo breakpointInfo) {
            DownloadMonitor monitor;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048586, this, downloadTask, breakpointInfo) == null) || (monitor = BdDownload.with().getMonitor()) == null) {
                return;
            }
            monitor.taskDownloadFromBreakpoint(downloadTask, breakpointInfo);
        }

        public void inspectTaskEnd(DownloadTask downloadTask, EndCause endCause, @Nullable Exception exc) {
            DownloadMonitor monitor;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(1048587, this, downloadTask, endCause, exc) == null) || (monitor = BdDownload.with().getMonitor()) == null) {
                return;
            }
            monitor.taskEnd(downloadTask, endCause, exc);
        }

        public void inspectTaskStart(DownloadTask downloadTask) {
            DownloadMonitor monitor;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048588, this, downloadTask) == null) || (monitor = BdDownload.with().getMonitor()) == null) {
                return;
            }
            monitor.taskStart(downloadTask);
        }

        @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
        public void taskEnd(@NonNull DownloadTask downloadTask, @NonNull EndCause endCause, @Nullable Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048589, this, downloadTask, endCause, exc) == null) {
                if (endCause == EndCause.ERROR) {
                    Util.d(CallbackDispatcher.TAG, "taskEnd: " + downloadTask.getId() + " " + endCause + " " + exc);
                }
                inspectTaskEnd(downloadTask, endCause, exc);
                if (downloadTask.isAutoCallbackToUIThread()) {
                    this.uiHandler.post(new Runnable(this, downloadTask, endCause, exc) { // from class: com.baidu.searchbox.bddownload.core.dispatcher.CallbackDispatcher.DefaultTransmitListener.11
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ DefaultTransmitListener this$0;
                        public final /* synthetic */ EndCause val$cause;
                        public final /* synthetic */ Exception val$realCause;
                        public final /* synthetic */ DownloadTask val$task;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, downloadTask, endCause, exc};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$task = downloadTask;
                            this.val$cause = endCause;
                            this.val$realCause = exc;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.val$task.getListener().taskEnd(this.val$task, this.val$cause, this.val$realCause);
                            }
                        }
                    });
                } else {
                    downloadTask.getListener().taskEnd(downloadTask, endCause, exc);
                }
                StatisticsInfo.Builder builder = new StatisticsInfo.Builder();
                builder.buildDownloadUrl(downloadTask.getUrl());
                String mimeType = downloadTask.getInfo() != null ? downloadTask.getInfo().getMimeType() : "";
                if (TextUtils.isEmpty(mimeType)) {
                    mimeType = "unknown";
                }
                builder.buildFileType(mimeType);
                if (endCause == EndCause.ERROR && exc != null) {
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("cause", exc.toString());
                    builder.buildExtraInfo(hashMap);
                }
                StatisticsInfo build = builder.build();
                if (endCause == EndCause.CANCELED) {
                    StatisticManager.Companion.get().downloadPauseReport(build);
                } else if (endCause == EndCause.COMPLETED) {
                    StatisticManager.Companion.get().downloadSuccessReport(build);
                } else {
                    StatisticManager.Companion.get().downloadFailedReport(build);
                }
            }
        }

        @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
        public void taskStart(@NonNull DownloadTask downloadTask) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048590, this, downloadTask) == null) {
                Util.d(CallbackDispatcher.TAG, "taskStart: " + downloadTask.getId());
                inspectTaskStart(downloadTask);
                if (downloadTask.isAutoCallbackToUIThread()) {
                    this.uiHandler.post(new Runnable(this, downloadTask) { // from class: com.baidu.searchbox.bddownload.core.dispatcher.CallbackDispatcher.DefaultTransmitListener.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ DefaultTransmitListener this$0;
                        public final /* synthetic */ DownloadTask val$task;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, downloadTask};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$task = downloadTask;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.val$task.getListener().taskStart(this.val$task);
                            }
                        }
                    });
                } else {
                    downloadTask.getListener().taskStart(downloadTask);
                }
                StatisticsInfo.Builder builder = new StatisticsInfo.Builder();
                builder.buildDownloadUrl(downloadTask.getUrl());
                String mimeType = downloadTask.getInfo() != null ? downloadTask.getInfo().getMimeType() : "";
                if (TextUtils.isEmpty(mimeType)) {
                    mimeType = "unknown";
                }
                builder.buildFileType(mimeType);
                StatisticManager.Companion.get().downloadStartReport(builder.build());
            }
        }
    }

    public CallbackDispatcher(@NonNull Handler handler, @NonNull DownloadListener downloadListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {handler, downloadListener};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.uiHandler = handler;
        this.transmit = downloadListener;
    }

    public DownloadListener dispatch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.transmit : (DownloadListener) invokeV.objValue;
    }

    public void endTasks(@NonNull Collection<DownloadTask> collection, @NonNull Collection<DownloadTask> collection2, @NonNull Collection<DownloadTask> collection3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, collection, collection2, collection3) == null) {
            if (collection.size() == 0 && collection2.size() == 0 && collection3.size() == 0) {
                return;
            }
            Util.d(TAG, "endTasks completed[" + collection.size() + "] sameTask[" + collection2.size() + "] fileBusy[" + collection3.size() + PreferencesUtil.RIGHT_MOUNT);
            if (collection.size() > 0) {
                Iterator<DownloadTask> it = collection.iterator();
                while (it.hasNext()) {
                    DownloadTask next = it.next();
                    if (!next.isAutoCallbackToUIThread()) {
                        next.getListener().taskEnd(next, EndCause.COMPLETED, null);
                        it.remove();
                    }
                }
            }
            if (collection2.size() > 0) {
                Iterator<DownloadTask> it2 = collection2.iterator();
                while (it2.hasNext()) {
                    DownloadTask next2 = it2.next();
                    if (!next2.isAutoCallbackToUIThread()) {
                        next2.getListener().taskEnd(next2, EndCause.SAME_TASK_BUSY, null);
                        it2.remove();
                    }
                }
            }
            if (collection3.size() > 0) {
                Iterator<DownloadTask> it3 = collection3.iterator();
                while (it3.hasNext()) {
                    DownloadTask next3 = it3.next();
                    if (!next3.isAutoCallbackToUIThread()) {
                        next3.getListener().taskEnd(next3, EndCause.FILE_BUSY, null);
                        it3.remove();
                    }
                }
            }
            if (collection.size() == 0 && collection2.size() == 0 && collection3.size() == 0) {
                return;
            }
            this.uiHandler.post(new Runnable(this, collection, collection2, collection3) { // from class: com.baidu.searchbox.bddownload.core.dispatcher.CallbackDispatcher.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ CallbackDispatcher this$0;
                public final /* synthetic */ Collection val$completedTaskCollection;
                public final /* synthetic */ Collection val$fileBusyCollection;
                public final /* synthetic */ Collection val$sameTaskConflictCollection;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, collection, collection2, collection3};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$completedTaskCollection = collection;
                    this.val$sameTaskConflictCollection = collection2;
                    this.val$fileBusyCollection = collection3;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        for (DownloadTask downloadTask : this.val$completedTaskCollection) {
                            downloadTask.getListener().taskEnd(downloadTask, EndCause.COMPLETED, null);
                        }
                        for (DownloadTask downloadTask2 : this.val$sameTaskConflictCollection) {
                            downloadTask2.getListener().taskEnd(downloadTask2, EndCause.SAME_TASK_BUSY, null);
                        }
                        for (DownloadTask downloadTask3 : this.val$fileBusyCollection) {
                            downloadTask3.getListener().taskEnd(downloadTask3, EndCause.FILE_BUSY, null);
                        }
                    }
                }
            });
        }
    }

    public void endTasksWithCanceled(@NonNull Collection<DownloadTask> collection) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, collection) == null) || collection.size() <= 0) {
            return;
        }
        Util.d(TAG, "endTasksWithCanceled canceled[" + collection.size() + PreferencesUtil.RIGHT_MOUNT);
        Iterator<DownloadTask> it = collection.iterator();
        while (it.hasNext()) {
            DownloadTask next = it.next();
            if (!next.isAutoCallbackToUIThread()) {
                next.getListener().taskEnd(next, EndCause.CANCELED, null);
                it.remove();
            }
        }
        this.uiHandler.post(new Runnable(this, collection) { // from class: com.baidu.searchbox.bddownload.core.dispatcher.CallbackDispatcher.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CallbackDispatcher this$0;
            public final /* synthetic */ Collection val$canceledCollection;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, collection};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$canceledCollection = collection;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    for (DownloadTask downloadTask : this.val$canceledCollection) {
                        downloadTask.getListener().taskEnd(downloadTask, EndCause.CANCELED, null);
                    }
                }
            }
        });
    }

    public void endTasksWithError(@NonNull Collection<DownloadTask> collection, @NonNull Exception exc) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, collection, exc) == null) || collection.size() <= 0) {
            return;
        }
        Util.d(TAG, "endTasksWithError error[" + collection.size() + "] realCause: " + exc);
        Iterator<DownloadTask> it = collection.iterator();
        while (it.hasNext()) {
            DownloadTask next = it.next();
            if (!next.isAutoCallbackToUIThread()) {
                next.getListener().taskEnd(next, EndCause.ERROR, exc);
                it.remove();
            }
        }
        this.uiHandler.post(new Runnable(this, collection, exc) { // from class: com.baidu.searchbox.bddownload.core.dispatcher.CallbackDispatcher.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CallbackDispatcher this$0;
            public final /* synthetic */ Collection val$errorCollection;
            public final /* synthetic */ Exception val$realCause;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, collection, exc};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$errorCollection = collection;
                this.val$realCause = exc;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    for (DownloadTask downloadTask : this.val$errorCollection) {
                        downloadTask.getListener().taskEnd(downloadTask, EndCause.ERROR, this.val$realCause);
                    }
                }
            }
        });
    }

    public boolean isFetchProcessMoment(DownloadTask downloadTask) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, downloadTask)) == null) {
            long minIntervalMillisCallbackProcess = downloadTask.getMinIntervalMillisCallbackProcess();
            return minIntervalMillisCallbackProcess <= 0 || SystemClock.uptimeMillis() - DownloadTask.TaskHideWrapper.getLastCallbackProcessTs(downloadTask) >= minIntervalMillisCallbackProcess;
        }
        return invokeL.booleanValue;
    }

    public CallbackDispatcher() {
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
        Handler handler = new Handler(Looper.getMainLooper());
        this.uiHandler = handler;
        this.transmit = new DefaultTransmitListener(handler);
    }
}
