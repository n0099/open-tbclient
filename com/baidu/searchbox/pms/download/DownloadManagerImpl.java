package com.baidu.searchbox.pms.download;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Singleton
@Service
/* loaded from: classes4.dex */
public class DownloadManagerImpl implements IDownloadManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DownloadTaskProgressListener mDownloadListener;
    public Map<String, DownloadTaskExt> mTasks;

    /* renamed from: com.baidu.searchbox.pms.download.DownloadManagerImpl$3  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass3 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$bddownload$core$cause$EndCause;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(909357563, "Lcom/baidu/searchbox/pms/download/DownloadManagerImpl$3;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(909357563, "Lcom/baidu/searchbox/pms/download/DownloadManagerImpl$3;");
                    return;
                }
            }
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

    /* loaded from: classes4.dex */
    public class DownloadTaskExt {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public PackageInfo info;
        @NonNull
        public final MergeCallback mergeCallback;
        @NonNull
        public DownloadTask task;
        public final /* synthetic */ DownloadManagerImpl this$0;

        public DownloadTaskExt(@NonNull DownloadManagerImpl downloadManagerImpl, @NonNull DownloadTask downloadTask, @NonNull PackageInfo packageInfo, InnerCallback innerCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {downloadManagerImpl, downloadTask, packageInfo, innerCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = downloadManagerImpl;
            this.task = downloadTask;
            this.info = packageInfo;
            MergeCallback mergeCallback = new MergeCallback();
            this.mergeCallback = mergeCallback;
            mergeCallback.add(packageInfo, innerCallback);
        }
    }

    public DownloadManagerImpl() {
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
        this.mDownloadListener = new DownloadTaskProgressListener(this) { // from class: com.baidu.searchbox.pms.download.DownloadManagerImpl.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DownloadManagerImpl this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.baidu.searchbox.bddownload.core.listener.assist.TaskProgressListenerAssist.TaskProgressListenerCallback
            public void connected(@NonNull DownloadTask downloadTask, int i4, long j2, long j3) {
                DownloadTaskExt downloadTaskExt;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{downloadTask, Integer.valueOf(i4), Long.valueOf(j2), Long.valueOf(j3)}) == null) || (downloadTaskExt = (DownloadTaskExt) this.this$0.mTasks.get(downloadTask.getTag())) == null) {
                    return;
                }
                PackageInfo packageInfo = downloadTaskExt.info;
                packageInfo.currentSize = j2;
                packageInfo.totalSize = j3;
            }

            @Override // com.baidu.searchbox.bddownload.core.listener.assist.TaskProgressListenerAssist.TaskProgressListenerCallback
            public void progress(@NonNull DownloadTask downloadTask, long j2, long j3) {
                DownloadTaskExt downloadTaskExt;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{downloadTask, Long.valueOf(j2), Long.valueOf(j3)}) == null) || (downloadTaskExt = (DownloadTaskExt) this.this$0.mTasks.get(downloadTask.getTag())) == null) {
                    return;
                }
                downloadTaskExt.mergeCallback.onProgress(j2, j3);
            }

            @Override // com.baidu.searchbox.bddownload.core.listener.assist.TaskProgressListenerAssist.TaskProgressListenerCallback
            public void retry(@NonNull DownloadTask downloadTask, @NonNull ResumeFailedCause resumeFailedCause) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, downloadTask, resumeFailedCause) == null) {
                    DebugUtils.log(downloadTask);
                    DownloadTaskExt downloadTaskExt = (DownloadTaskExt) this.this$0.mTasks.get(downloadTask.getTag());
                    if (downloadTaskExt == null) {
                        return;
                    }
                    downloadTaskExt.mergeCallback.onRetry();
                }
            }

            @Override // com.baidu.searchbox.bddownload.core.listener.assist.TaskProgressListenerAssist.TaskProgressListenerCallback
            public void taskEnd(@NonNull DownloadTask downloadTask, @NonNull EndCause endCause, @Nullable Exception exc, @NonNull TaskProgressListenerAssist.Listener1Model listener1Model) {
                DownloadTaskExt downloadTaskExt;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeLLLL(1048579, this, downloadTask, endCause, exc, listener1Model) == null) || (downloadTaskExt = (DownloadTaskExt) this.this$0.mTasks.get(downloadTask.getTag())) == null) {
                    return;
                }
                int i4 = AnonymousClass3.$SwitchMap$com$baidu$searchbox$bddownload$core$cause$EndCause[endCause.ordinal()];
                if (i4 == 3) {
                    downloadTaskExt.mergeCallback.onSuccess(downloadTaskExt.info.filePath);
                } else if (i4 == 4) {
                    downloadTaskExt.mergeCallback.onPause();
                } else if (i4 != 5) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("by bdownload:EndCause:");
                    sb.append(endCause.name());
                    sb.append(";Exception:");
                    if (exc != null) {
                        sb.append(Log.getStackTraceString(exc));
                    }
                    int i5 = AnonymousClass3.$SwitchMap$com$baidu$searchbox$bddownload$core$cause$EndCause[endCause.ordinal()];
                    int i6 = (i5 == 1 || i5 == 2) ? ErrorConstant.Code.DOWNLOAD_ERROR_WRITE : 2201;
                    if (downloadTaskExt.info.isHitNetWorkStrategy() && downloadTaskExt.info.retryCount < 1 && i6 == 2201) {
                        this.this$0.onRetry(downloadTaskExt);
                    } else {
                        downloadTaskExt.mergeCallback.onError(i6, sb.toString());
                    }
                } else if (downloadTaskExt.info.type == 3) {
                    downloadTaskExt.mergeCallback.onPause();
                } else {
                    downloadTaskExt.mergeCallback.onCancel();
                    this.this$0.mTasks.remove(downloadTask.getTag());
                }
            }

            @Override // com.baidu.searchbox.bddownload.core.listener.assist.TaskProgressListenerAssist.TaskProgressListenerCallback
            public void taskStart(@NonNull DownloadTask downloadTask, @NonNull TaskProgressListenerAssist.Listener1Model listener1Model) {
                DownloadTaskExt downloadTaskExt;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeLL(1048580, this, downloadTask, listener1Model) == null) || (downloadTaskExt = (DownloadTaskExt) this.this$0.mTasks.get(downloadTask.getTag())) == null) {
                    return;
                }
                if (downloadTaskExt.info.type != 4 && downloadTaskExt.info.type != 3) {
                    downloadTaskExt.mergeCallback.onStart();
                } else {
                    downloadTaskExt.mergeCallback.onResume();
                }
            }
        };
        this.mTasks = Collections.synchronizedMap(new HashMap());
    }

    @NonNull
    private DownloadTask createTask(@NonNull PackageInfo packageInfo, DownloadOptions downloadOptions) {
        InterceptResult invokeLL;
        PriorityStrategy.Priority priority;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, packageInfo, downloadOptions)) == null) {
            if (downloadOptions != null) {
                priority = getPriority(downloadOptions.priority);
            } else {
                priority = getPriority(1);
            }
            String str = packageInfo.downloadUrl;
            if (packageInfo.isHitTrafficLimit()) {
                str = packageInfo.getTrafficUrl();
            }
            if (!TextUtils.isEmpty(packageInfo.netWorkStrategy) && packageInfo.retryCount < 1 && (downloadOptions == null || downloadOptions.priority < 3)) {
                packageInfo.setXCDNEnable(true);
                str = packageInfo.getNetWorkStrategyUrl();
            }
            DownloadTask build = new DownloadTask.Builder(str, new File(packageInfo.filePath)).setMinIntervalMillisCallbackProcess(100).setPassIfAlreadyCompleted(false).setConnectionCount(1).setPriority(priority).build();
            build.setTag(packageInfo.getKey());
            return build;
        }
        return (DownloadTask) invokeLL.objValue;
    }

    private PriorityStrategy.Priority getPriority(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65541, this, i2)) == null) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
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
        return (PriorityStrategy.Priority) invokeI.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void innerStart(@NonNull List<PackageInfo> list, @Nullable DownloadOptions downloadOptions, @NonNull InnerCallback innerCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65542, this, list, downloadOptions, innerCallback) == null) {
            synchronized (this) {
                ArrayList arrayList = new ArrayList(list.size());
                for (int i2 = 0; i2 < list.size(); i2++) {
                    PackageInfo packageInfo = list.get(i2);
                    if (packageInfo != null && prepareDownload(packageInfo, downloadOptions, innerCallback)) {
                        DownloadTask createTask = createTask(packageInfo, downloadOptions);
                        DownloadTaskExt downloadTaskExt = new DownloadTaskExt(this, createTask, packageInfo, innerCallback);
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
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRetry(DownloadTaskExt downloadTaskExt) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, downloadTaskExt) == null) {
            PackageInfo packageInfo = downloadTaskExt.info;
            packageInfo.retryCount++;
            this.mTasks.remove(packageInfo.getKey());
            downloadTaskExt.task = createTask(packageInfo, null);
            this.mTasks.put(packageInfo.getKey(), downloadTaskExt);
            resume(packageInfo);
        }
    }

    private boolean prepareDownload(PackageInfo packageInfo, DownloadOptions downloadOptions, InnerCallback innerCallback) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, this, packageInfo, downloadOptions, innerCallback)) == null) {
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
        return invokeLLL.booleanValue;
    }

    @Override // com.baidu.searchbox.pms.download.IDownloadManager
    public void cancel(PackageInfo packageInfo) {
        DownloadTaskExt downloadTaskExt;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, packageInfo) == null) || (downloadTaskExt = this.mTasks.get(packageInfo.getKey())) == null) {
            return;
        }
        downloadTaskExt.info.type = 5;
        downloadTaskExt.task.cancel();
    }

    @Override // com.baidu.searchbox.pms.download.IDownloadManager
    public int getStatus(PackageInfo packageInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, packageInfo)) == null) {
            DownloadTaskExt downloadTaskExt = this.mTasks.get(packageInfo.getKey());
            if (downloadTaskExt != null) {
                return downloadTaskExt.info.type;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    @Override // com.baidu.searchbox.pms.download.IDownloadManager
    public void pause(PackageInfo packageInfo) {
        DownloadTaskExt downloadTaskExt;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, packageInfo) == null) || (downloadTaskExt = this.mTasks.get(packageInfo.getKey())) == null) {
            return;
        }
        downloadTaskExt.info.type = 3;
        downloadTaskExt.task.cancel();
    }

    @Override // com.baidu.searchbox.pms.download.IDownloadManager
    public void resume(PackageInfo packageInfo) {
        DownloadTaskExt downloadTaskExt;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, packageInfo) == null) || (downloadTaskExt = this.mTasks.get(packageInfo.getKey())) == null) {
            return;
        }
        downloadTaskExt.info.type = 4;
        downloadTaskExt.task.enqueue(this.mDownloadListener);
    }

    @Override // com.baidu.searchbox.pms.download.IDownloadManager
    public void start(@NonNull List<PackageInfo> list, @Nullable DownloadOptions downloadOptions, @NonNull DownloadCallback downloadCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, list, downloadOptions, downloadCallback) == null) {
            if (AppConfig.isDebug() && list == null) {
                throw new RuntimeException("start() method params:infoList must not be empty");
            }
            if (list == null) {
                return;
            }
            CommonUtils.postThread(new Runnable(this, list, downloadOptions, downloadCallback) { // from class: com.baidu.searchbox.pms.download.DownloadManagerImpl.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DownloadManagerImpl this$0;
                public final /* synthetic */ DownloadCallback val$callback;
                public final /* synthetic */ List val$infoList;
                public final /* synthetic */ DownloadOptions val$options;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, list, downloadOptions, downloadCallback};
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
                    this.val$infoList = list;
                    this.val$options = downloadOptions;
                    this.val$callback = downloadCallback;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        DownloadManagerImpl downloadManagerImpl = this.this$0;
                        List list2 = this.val$infoList;
                        DownloadOptions downloadOptions2 = this.val$options;
                        downloadManagerImpl.innerStart(list2, downloadOptions2, new DownloadCallbackWrap(list2, this.val$callback, downloadOptions2));
                    }
                }
            }, "DownloadManagerImpl_start");
        }
    }
}
