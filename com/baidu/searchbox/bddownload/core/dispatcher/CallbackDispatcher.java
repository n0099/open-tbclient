package com.baidu.searchbox.bddownload.core.dispatcher;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class CallbackDispatcher {
    public static final String TAG = "CallbackDispatcher";
    public final DownloadListener transmit;
    public final Handler uiHandler;

    /* loaded from: classes2.dex */
    public static class DefaultTransmitListener implements DownloadListener {
        @NonNull
        public final Handler uiHandler;

        public DefaultTransmitListener(@NonNull Handler handler) {
            this.uiHandler = handler;
        }

        @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
        public void connectEnd(@NonNull final DownloadTask downloadTask, final int i2, final int i3, @NonNull final Map<String, List<String>> map) {
            Util.d(CallbackDispatcher.TAG, "<----- finish connection task(" + downloadTask.getId() + ") block(" + i2 + ") code[" + i3 + "]" + map);
            if (downloadTask.isAutoCallbackToUIThread()) {
                this.uiHandler.post(new Runnable() { // from class: com.baidu.searchbox.bddownload.core.dispatcher.CallbackDispatcher.DefaultTransmitListener.7
                    @Override // java.lang.Runnable
                    public void run() {
                        downloadTask.getListener().connectEnd(downloadTask, i2, i3, map);
                    }
                });
            } else {
                downloadTask.getListener().connectEnd(downloadTask, i2, i3, map);
            }
        }

        @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
        public void connectStart(@NonNull final DownloadTask downloadTask, final int i2, @NonNull final Map<String, List<String>> map) {
            Util.d(CallbackDispatcher.TAG, "-----> start connection task(" + downloadTask.getId() + ") block(" + i2 + ") " + map);
            if (downloadTask.isAutoCallbackToUIThread()) {
                this.uiHandler.post(new Runnable() { // from class: com.baidu.searchbox.bddownload.core.dispatcher.CallbackDispatcher.DefaultTransmitListener.6
                    @Override // java.lang.Runnable
                    public void run() {
                        downloadTask.getListener().connectStart(downloadTask, i2, map);
                    }
                });
            } else {
                downloadTask.getListener().connectStart(downloadTask, i2, map);
            }
        }

        @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
        public void connectTrialEnd(@NonNull final DownloadTask downloadTask, final int i2, @NonNull final Map<String, List<String>> map) {
            Util.d(CallbackDispatcher.TAG, "<----- finish trial task(" + downloadTask.getId() + ") code[" + i2 + "]" + map);
            if (downloadTask.isAutoCallbackToUIThread()) {
                this.uiHandler.post(new Runnable() { // from class: com.baidu.searchbox.bddownload.core.dispatcher.CallbackDispatcher.DefaultTransmitListener.3
                    @Override // java.lang.Runnable
                    public void run() {
                        downloadTask.getListener().connectTrialEnd(downloadTask, i2, map);
                    }
                });
            } else {
                downloadTask.getListener().connectTrialEnd(downloadTask, i2, map);
            }
        }

        @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
        public void connectTrialStart(@NonNull final DownloadTask downloadTask, @NonNull final Map<String, List<String>> map) {
            Util.d(CallbackDispatcher.TAG, "-----> start trial task(" + downloadTask.getId() + ") " + map);
            if (downloadTask.isAutoCallbackToUIThread()) {
                this.uiHandler.post(new Runnable() { // from class: com.baidu.searchbox.bddownload.core.dispatcher.CallbackDispatcher.DefaultTransmitListener.2
                    @Override // java.lang.Runnable
                    public void run() {
                        downloadTask.getListener().connectTrialStart(downloadTask, map);
                    }
                });
            } else {
                downloadTask.getListener().connectTrialStart(downloadTask, map);
            }
        }

        @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
        public void downloadFromBeginning(@NonNull final DownloadTask downloadTask, @NonNull final BreakpointInfo breakpointInfo, @NonNull final ResumeFailedCause resumeFailedCause) {
            Util.d(CallbackDispatcher.TAG, "downloadFromBeginning: " + downloadTask.getId());
            inspectDownloadFromBeginning(downloadTask, breakpointInfo, resumeFailedCause);
            if (downloadTask.isAutoCallbackToUIThread()) {
                this.uiHandler.post(new Runnable() { // from class: com.baidu.searchbox.bddownload.core.dispatcher.CallbackDispatcher.DefaultTransmitListener.4
                    @Override // java.lang.Runnable
                    public void run() {
                        downloadTask.getListener().downloadFromBeginning(downloadTask, breakpointInfo, resumeFailedCause);
                    }
                });
            } else {
                downloadTask.getListener().downloadFromBeginning(downloadTask, breakpointInfo, resumeFailedCause);
            }
        }

        @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
        public void downloadFromBreakpoint(@NonNull final DownloadTask downloadTask, @NonNull final BreakpointInfo breakpointInfo) {
            Util.d(CallbackDispatcher.TAG, "downloadFromBreakpoint: " + downloadTask.getId());
            inspectDownloadFromBreakpoint(downloadTask, breakpointInfo);
            if (downloadTask.isAutoCallbackToUIThread()) {
                this.uiHandler.post(new Runnable() { // from class: com.baidu.searchbox.bddownload.core.dispatcher.CallbackDispatcher.DefaultTransmitListener.5
                    @Override // java.lang.Runnable
                    public void run() {
                        downloadTask.getListener().downloadFromBreakpoint(downloadTask, breakpointInfo);
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

        @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
        public void fetchEnd(@NonNull final DownloadTask downloadTask, final int i2, final long j) {
            Util.d(CallbackDispatcher.TAG, "fetchEnd: " + downloadTask.getId());
            if (downloadTask.isAutoCallbackToUIThread()) {
                this.uiHandler.post(new Runnable() { // from class: com.baidu.searchbox.bddownload.core.dispatcher.CallbackDispatcher.DefaultTransmitListener.10
                    @Override // java.lang.Runnable
                    public void run() {
                        downloadTask.getListener().fetchEnd(downloadTask, i2, j);
                    }
                });
            } else {
                downloadTask.getListener().fetchEnd(downloadTask, i2, j);
            }
        }

        @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
        public void fetchProgress(@NonNull final DownloadTask downloadTask, final int i2, final long j) {
            if (downloadTask.getMinIntervalMillisCallbackProcess() > 0) {
                DownloadTask.TaskHideWrapper.setLastCallbackProcessTs(downloadTask, SystemClock.uptimeMillis());
                DownloadTask.TaskHideWrapper.setSpeedIncreaseBytes(downloadTask, j);
            }
            if (downloadTask.isAutoCallbackToUIThread()) {
                this.uiHandler.post(new Runnable() { // from class: com.baidu.searchbox.bddownload.core.dispatcher.CallbackDispatcher.DefaultTransmitListener.9
                    @Override // java.lang.Runnable
                    public void run() {
                        downloadTask.getListener().fetchProgress(downloadTask, i2, j);
                    }
                });
            } else {
                downloadTask.getListener().fetchProgress(downloadTask, i2, j);
            }
        }

        @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
        public void fetchStart(@NonNull final DownloadTask downloadTask, final int i2, final long j) {
            Util.d(CallbackDispatcher.TAG, "fetchStart: " + downloadTask.getId());
            if (downloadTask.isAutoCallbackToUIThread()) {
                this.uiHandler.post(new Runnable() { // from class: com.baidu.searchbox.bddownload.core.dispatcher.CallbackDispatcher.DefaultTransmitListener.8
                    @Override // java.lang.Runnable
                    public void run() {
                        downloadTask.getListener().fetchStart(downloadTask, i2, j);
                    }
                });
            } else {
                downloadTask.getListener().fetchStart(downloadTask, i2, j);
            }
        }

        public void inspectDownloadFromBeginning(@NonNull DownloadTask downloadTask, @NonNull BreakpointInfo breakpointInfo, @NonNull ResumeFailedCause resumeFailedCause) {
            DownloadMonitor monitor = BdDownload.with().getMonitor();
            if (monitor != null) {
                monitor.taskDownloadFromBeginning(downloadTask, breakpointInfo, resumeFailedCause);
            }
        }

        public void inspectDownloadFromBreakpoint(@NonNull DownloadTask downloadTask, @NonNull BreakpointInfo breakpointInfo) {
            DownloadMonitor monitor = BdDownload.with().getMonitor();
            if (monitor != null) {
                monitor.taskDownloadFromBreakpoint(downloadTask, breakpointInfo);
            }
        }

        public void inspectTaskEnd(DownloadTask downloadTask, EndCause endCause, @Nullable Exception exc) {
            DownloadMonitor monitor = BdDownload.with().getMonitor();
            if (monitor != null) {
                monitor.taskEnd(downloadTask, endCause, exc);
            }
        }

        public void inspectTaskStart(DownloadTask downloadTask) {
            DownloadMonitor monitor = BdDownload.with().getMonitor();
            if (monitor != null) {
                monitor.taskStart(downloadTask);
            }
        }

        @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
        public void taskEnd(@NonNull final DownloadTask downloadTask, @NonNull final EndCause endCause, @Nullable final Exception exc) {
            if (endCause == EndCause.ERROR) {
                Util.d(CallbackDispatcher.TAG, "taskEnd: " + downloadTask.getId() + " " + endCause + " " + exc);
            }
            inspectTaskEnd(downloadTask, endCause, exc);
            if (downloadTask.isAutoCallbackToUIThread()) {
                this.uiHandler.post(new Runnable() { // from class: com.baidu.searchbox.bddownload.core.dispatcher.CallbackDispatcher.DefaultTransmitListener.11
                    @Override // java.lang.Runnable
                    public void run() {
                        downloadTask.getListener().taskEnd(downloadTask, endCause, exc);
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

        @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
        public void taskStart(@NonNull final DownloadTask downloadTask) {
            Util.d(CallbackDispatcher.TAG, "taskStart: " + downloadTask.getId());
            inspectTaskStart(downloadTask);
            if (downloadTask.isAutoCallbackToUIThread()) {
                this.uiHandler.post(new Runnable() { // from class: com.baidu.searchbox.bddownload.core.dispatcher.CallbackDispatcher.DefaultTransmitListener.1
                    @Override // java.lang.Runnable
                    public void run() {
                        downloadTask.getListener().taskStart(downloadTask);
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

    public CallbackDispatcher(@NonNull Handler handler, @NonNull DownloadListener downloadListener) {
        this.uiHandler = handler;
        this.transmit = downloadListener;
    }

    public DownloadListener dispatch() {
        return this.transmit;
    }

    public void endTasks(@NonNull final Collection<DownloadTask> collection, @NonNull final Collection<DownloadTask> collection2, @NonNull final Collection<DownloadTask> collection3) {
        if (collection.size() == 0 && collection2.size() == 0 && collection3.size() == 0) {
            return;
        }
        Util.d(TAG, "endTasks completed[" + collection.size() + "] sameTask[" + collection2.size() + "] fileBusy[" + collection3.size() + "]");
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
        this.uiHandler.post(new Runnable() { // from class: com.baidu.searchbox.bddownload.core.dispatcher.CallbackDispatcher.2
            @Override // java.lang.Runnable
            public void run() {
                for (DownloadTask downloadTask : collection) {
                    downloadTask.getListener().taskEnd(downloadTask, EndCause.COMPLETED, null);
                }
                for (DownloadTask downloadTask2 : collection2) {
                    downloadTask2.getListener().taskEnd(downloadTask2, EndCause.SAME_TASK_BUSY, null);
                }
                for (DownloadTask downloadTask3 : collection3) {
                    downloadTask3.getListener().taskEnd(downloadTask3, EndCause.FILE_BUSY, null);
                }
            }
        });
    }

    public void endTasksWithCanceled(@NonNull final Collection<DownloadTask> collection) {
        if (collection.size() <= 0) {
            return;
        }
        Util.d(TAG, "endTasksWithCanceled canceled[" + collection.size() + "]");
        Iterator<DownloadTask> it = collection.iterator();
        while (it.hasNext()) {
            DownloadTask next = it.next();
            if (!next.isAutoCallbackToUIThread()) {
                next.getListener().taskEnd(next, EndCause.CANCELED, null);
                it.remove();
            }
        }
        this.uiHandler.post(new Runnable() { // from class: com.baidu.searchbox.bddownload.core.dispatcher.CallbackDispatcher.3
            @Override // java.lang.Runnable
            public void run() {
                for (DownloadTask downloadTask : collection) {
                    downloadTask.getListener().taskEnd(downloadTask, EndCause.CANCELED, null);
                }
            }
        });
    }

    public void endTasksWithError(@NonNull final Collection<DownloadTask> collection, @NonNull final Exception exc) {
        if (collection.size() <= 0) {
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
        this.uiHandler.post(new Runnable() { // from class: com.baidu.searchbox.bddownload.core.dispatcher.CallbackDispatcher.1
            @Override // java.lang.Runnable
            public void run() {
                for (DownloadTask downloadTask : collection) {
                    downloadTask.getListener().taskEnd(downloadTask, EndCause.ERROR, exc);
                }
            }
        });
    }

    public boolean isFetchProcessMoment(DownloadTask downloadTask) {
        long minIntervalMillisCallbackProcess = downloadTask.getMinIntervalMillisCallbackProcess();
        return minIntervalMillisCallbackProcess <= 0 || SystemClock.uptimeMillis() - DownloadTask.TaskHideWrapper.getLastCallbackProcessTs(downloadTask) >= minIntervalMillisCallbackProcess;
    }

    public CallbackDispatcher() {
        Handler handler = new Handler(Looper.getMainLooper());
        this.uiHandler = handler;
        this.transmit = new DefaultTransmitListener(handler);
    }
}
