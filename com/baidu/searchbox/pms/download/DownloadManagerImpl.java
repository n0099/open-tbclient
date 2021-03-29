package com.baidu.searchbox.pms.download;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.util.devices.NetWorkUtils;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.bddownload.DownloadTask;
import com.baidu.searchbox.bddownload.core.cause.EndCause;
import com.baidu.searchbox.bddownload.core.cause.ResumeFailedCause;
import com.baidu.searchbox.bddownload.core.listener.DownloadTaskProgressListener;
import com.baidu.searchbox.bddownload.core.listener.assist.TaskProgressListenerAssist;
import com.baidu.searchbox.bddownload.core.priority.PriorityStrategy;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.pms.bean.PackageInfo;
import com.baidu.searchbox.pms.callback.DownloadCallback;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.searchbox.pms.db.PackageManager;
import com.baidu.searchbox.pms.utils.CommonUtils;
import com.baidu.searchbox.pms.utils.DebugUtils;
import com.baidu.searchbox.pms.utils.DownloadUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Singleton
@Service
/* loaded from: classes2.dex */
public class DownloadManagerImpl implements IDownloadManager {
    public DownloadTaskProgressListener mDownloadListener = new DownloadTaskProgressListener() { // from class: com.baidu.searchbox.pms.download.DownloadManagerImpl.2
        @Override // com.baidu.searchbox.bddownload.core.listener.assist.TaskProgressListenerAssist.TaskProgressListenerCallback
        public void connected(@NonNull DownloadTask downloadTask, int i, long j, long j2) {
            DownloadTaskExt downloadTaskExt = (DownloadTaskExt) DownloadManagerImpl.this.mTasks.get(downloadTask.getTag());
            if (downloadTaskExt == null) {
                return;
            }
            PackageInfo packageInfo = downloadTaskExt.info;
            packageInfo.currentSize = j;
            packageInfo.totalSize = j2;
        }

        @Override // com.baidu.searchbox.bddownload.core.listener.assist.TaskProgressListenerAssist.TaskProgressListenerCallback
        public void progress(@NonNull DownloadTask downloadTask, long j, long j2) {
            DownloadTaskExt downloadTaskExt = (DownloadTaskExt) DownloadManagerImpl.this.mTasks.get(downloadTask.getTag());
            if (downloadTaskExt == null) {
                return;
            }
            downloadTaskExt.mergeCallback.onProgress(j, j2);
        }

        @Override // com.baidu.searchbox.bddownload.core.listener.assist.TaskProgressListenerAssist.TaskProgressListenerCallback
        public void retry(@NonNull DownloadTask downloadTask, @NonNull ResumeFailedCause resumeFailedCause) {
            DebugUtils.log(downloadTask);
            DownloadTaskExt downloadTaskExt = (DownloadTaskExt) DownloadManagerImpl.this.mTasks.get(downloadTask.getTag());
            if (downloadTaskExt == null) {
                return;
            }
            downloadTaskExt.mergeCallback.onRetry();
        }

        @Override // com.baidu.searchbox.bddownload.core.listener.assist.TaskProgressListenerAssist.TaskProgressListenerCallback
        public void taskEnd(@NonNull DownloadTask downloadTask, @NonNull EndCause endCause, @Nullable Exception exc, @NonNull TaskProgressListenerAssist.Listener1Model listener1Model) {
            DownloadTaskExt downloadTaskExt = (DownloadTaskExt) DownloadManagerImpl.this.mTasks.get(downloadTask.getTag());
            if (downloadTaskExt == null) {
                return;
            }
            int i = AnonymousClass3.$SwitchMap$com$baidu$searchbox$bddownload$core$cause$EndCause[endCause.ordinal()];
            if (i == 3) {
                downloadTaskExt.mergeCallback.onSuccess(downloadTaskExt.info.filePath);
            } else if (i == 4) {
                downloadTaskExt.mergeCallback.onPause();
            } else if (i != 5) {
                StringBuilder sb = new StringBuilder();
                sb.append("by bdownload:EndCause:");
                sb.append(endCause.name());
                sb.append(";Exception:");
                if (exc != null) {
                    sb.append(Log.getStackTraceString(exc));
                }
                int i2 = AnonymousClass3.$SwitchMap$com$baidu$searchbox$bddownload$core$cause$EndCause[endCause.ordinal()];
                downloadTaskExt.mergeCallback.onError((i2 == 1 || i2 == 2) ? ErrorConstant.Code.DOWNLOAD_ERROR_WRITE : 2201, sb.toString());
            } else if (downloadTaskExt.info.type == 3) {
                downloadTaskExt.mergeCallback.onPause();
            } else {
                downloadTaskExt.mergeCallback.onCancel();
                DownloadManagerImpl.this.mTasks.remove(downloadTask.getTag());
            }
        }

        @Override // com.baidu.searchbox.bddownload.core.listener.assist.TaskProgressListenerAssist.TaskProgressListenerCallback
        public void taskStart(@NonNull DownloadTask downloadTask, @NonNull TaskProgressListenerAssist.Listener1Model listener1Model) {
            DownloadTaskExt downloadTaskExt = (DownloadTaskExt) DownloadManagerImpl.this.mTasks.get(downloadTask.getTag());
            if (downloadTaskExt == null) {
                return;
            }
            if (downloadTaskExt.info.type != 4 && downloadTaskExt.info.type != 3) {
                downloadTaskExt.mergeCallback.onStart();
            } else {
                downloadTaskExt.mergeCallback.onResume();
            }
        }
    };
    public Map<String, DownloadTaskExt> mTasks = Collections.synchronizedMap(new HashMap());

    /* renamed from: com.baidu.searchbox.pms.download.DownloadManagerImpl$3  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass3 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$bddownload$core$cause$EndCause;

        static {
            int[] iArr = new int[EndCause.values().length];
            $SwitchMap$com$baidu$searchbox$bddownload$core$cause$EndCause = iArr;
            try {
                iArr[EndCause.FILE_BUSY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$bddownload$core$cause$EndCause[EndCause.PRE_ALLOCATE_FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$bddownload$core$cause$EndCause[EndCause.COMPLETED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$bddownload$core$cause$EndCause[EndCause.ADJUSTMENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$bddownload$core$cause$EndCause[EndCause.CANCELED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public class DownloadTaskExt {
        @NonNull
        public PackageInfo info;
        @NonNull
        public final MergeCallback mergeCallback;
        @NonNull
        public DownloadTask task;

        public DownloadTaskExt(@NonNull DownloadTask downloadTask, @NonNull PackageInfo packageInfo, @NonNull InnerCallback innerCallback) {
            this.task = downloadTask;
            this.info = packageInfo;
            MergeCallback mergeCallback = new MergeCallback();
            this.mergeCallback = mergeCallback;
            mergeCallback.add(packageInfo, innerCallback);
        }
    }

    @NonNull
    private DownloadTask createTask(@NonNull PackageInfo packageInfo, DownloadOptions downloadOptions) {
        PriorityStrategy.Priority priority;
        if (downloadOptions != null) {
            priority = getPriority(downloadOptions.priority);
        } else {
            priority = getPriority(1);
        }
        DownloadTask build = new DownloadTask.Builder(packageInfo.downloadUrl, new File(packageInfo.filePath)).setMinIntervalMillisCallbackProcess(100).setPassIfAlreadyCompleted(false).setConnectionCount(1).setPriority(priority).build();
        build.setTag(packageInfo.getKey());
        return build;
    }

    private PriorityStrategy.Priority getPriority(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return PriorityStrategy.Priority.DEFAULT;
                    }
                    return PriorityStrategy.Priority.SPECIAL;
                }
                return PriorityStrategy.Priority.USER_INTERACTIVE;
            }
            return PriorityStrategy.Priority.BACKGROUND;
        }
        return PriorityStrategy.Priority.DEFAULT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void innerStart(@NonNull List<PackageInfo> list, @Nullable DownloadOptions downloadOptions, @NonNull InnerCallback innerCallback) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            PackageInfo packageInfo = list.get(i);
            if (packageInfo != null && prepareDownload(packageInfo, downloadOptions, innerCallback)) {
                DownloadTask createTask = createTask(packageInfo, downloadOptions);
                DownloadTaskExt downloadTaskExt = new DownloadTaskExt(createTask, packageInfo, innerCallback);
                arrayList.add(createTask);
                this.mTasks.put(packageInfo.getKey(), downloadTaskExt);
            }
        }
        if (arrayList.size() > 0) {
            DownloadTask[] downloadTaskArr = new DownloadTask[arrayList.size()];
            arrayList.toArray(downloadTaskArr);
            DownloadTask.enqueue(downloadTaskArr, this.mDownloadListener);
        }
    }

    private boolean prepareDownload(PackageInfo packageInfo, DownloadOptions downloadOptions, InnerCallback innerCallback) {
        if (downloadOptions == null) {
            downloadOptions = new DownloadOptions();
        }
        if (packageInfo.isOnlyWifi() && !downloadOptions.forceAnyEnv && !NetWorkUtils.isWifiNetworkConnected()) {
            innerCallback.onError(packageInfo, ErrorConstant.Code.DOWNLOAD_ERROR_NETWROK_LIMIT, null);
            return false;
        }
        packageInfo.filePath = DownloadUtils.getOutputFile(packageInfo, downloadOptions.fileDir);
        if (!DownloadUtils.makeDirs(new File(packageInfo.filePath).getParentFile())) {
            DebugUtils.log("[下载错误] 无法创建文件夹");
            innerCallback.onError(packageInfo, ErrorConstant.Code.DOWNLOAD_ERROR_PATH, null);
            return false;
        } else if (DownloadUtils.isSameMD5(packageInfo.filePath, packageInfo.md5)) {
            DebugUtils.log("[无需下载] 本地存在相同的资源,不需要下载:", packageInfo.filePath);
            innerCallback.onSuccess(packageInfo);
            return false;
        } else {
            PackageInfo lastPackageFile = PackageManager.getLastPackageFile(packageInfo.channelId, packageInfo.packageName, packageInfo.md5);
            if (lastPackageFile != null && DownloadUtils.isSameMD5(lastPackageFile.filePath, packageInfo.md5)) {
                DebugUtils.log("[无需下载] 数据库里存在相同的资源:", lastPackageFile.filePath, ",正在复制到:", packageInfo.filePath);
                DownloadUtils.copyTo(lastPackageFile.filePath, packageInfo.filePath);
                innerCallback.onSuccess(packageInfo);
                return false;
            }
            DownloadTaskExt downloadTaskExt = this.mTasks.get(packageInfo.getKey());
            if (downloadTaskExt != null) {
                if (downloadTaskExt.info.type == 2) {
                    innerCallback.onStart(packageInfo);
                    downloadTaskExt.mergeCallback.add(packageInfo, innerCallback);
                    DebugUtils.log("【合并下载】 ", packageInfo.toString());
                    return false;
                }
                this.mTasks.remove(packageInfo.getKey());
            }
            DebugUtils.log("【开始下载】 ", packageInfo.toString());
            packageInfo.type = 2;
            return true;
        }
    }

    @Override // com.baidu.searchbox.pms.download.IDownloadManager
    public void cancel(PackageInfo packageInfo) {
        DownloadTaskExt downloadTaskExt = this.mTasks.get(packageInfo.getKey());
        if (downloadTaskExt != null) {
            downloadTaskExt.info.type = 5;
            downloadTaskExt.task.cancel();
        }
    }

    @Override // com.baidu.searchbox.pms.download.IDownloadManager
    public int getStatus(PackageInfo packageInfo) {
        DownloadTaskExt downloadTaskExt = this.mTasks.get(packageInfo.getKey());
        if (downloadTaskExt != null) {
            return downloadTaskExt.info.type;
        }
        return 0;
    }

    @Override // com.baidu.searchbox.pms.download.IDownloadManager
    public void pause(PackageInfo packageInfo) {
        DownloadTaskExt downloadTaskExt = this.mTasks.get(packageInfo.getKey());
        if (downloadTaskExt != null) {
            downloadTaskExt.info.type = 3;
            downloadTaskExt.task.cancel();
        }
    }

    @Override // com.baidu.searchbox.pms.download.IDownloadManager
    public void resume(PackageInfo packageInfo) {
        DownloadTaskExt downloadTaskExt = this.mTasks.get(packageInfo.getKey());
        if (downloadTaskExt != null) {
            downloadTaskExt.info.type = 4;
            downloadTaskExt.task.enqueue(this.mDownloadListener);
        }
    }

    @Override // com.baidu.searchbox.pms.download.IDownloadManager
    public void start(@NonNull final List<PackageInfo> list, @Nullable final DownloadOptions downloadOptions, @NonNull final DownloadCallback downloadCallback) {
        if (AppConfig.isDebug() && list == null) {
            throw new RuntimeException("start() method params:infoList must not be empty");
        }
        if (list == null) {
            return;
        }
        CommonUtils.postThread(new Runnable() { // from class: com.baidu.searchbox.pms.download.DownloadManagerImpl.1
            @Override // java.lang.Runnable
            public void run() {
                DownloadManagerImpl downloadManagerImpl = DownloadManagerImpl.this;
                List list2 = list;
                DownloadOptions downloadOptions2 = downloadOptions;
                downloadManagerImpl.innerStart(list2, downloadOptions2, new DownloadCallbackWrap(list2, downloadCallback, downloadOptions2));
            }
        }, "DownloadManagerImpl_start");
    }
}
