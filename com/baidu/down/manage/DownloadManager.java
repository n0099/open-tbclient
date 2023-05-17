package com.baidu.down.manage;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.common.DownDetail;
import com.baidu.down.common.FileMsg;
import com.baidu.down.common.TaskObserver;
import com.baidu.down.common.intercepter.IIntercepter;
import com.baidu.down.manage.Download;
import com.baidu.down.request.task.AbstractTask;
import com.baidu.down.request.task.BinaryReqTask;
import com.baidu.down.request.taskmanager.BinaryTaskMng;
import com.baidu.down.request.taskmanager.TaskFacade;
import com.baidu.down.utils.NamingThreadFactory;
import com.baidu.mobstat.Config;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes3.dex */
public final class DownloadManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ACTION_WEBSUITE_PROGRESS_CHANGE = "com.baidu.appsearch.websuite.download.PROGRESS_CHANGE";
    public static final String ACTION_WEBSUITE_STATE_CHANGE = "com.baidu.appsearch.websuite.download.STATE_CHANGE";
    public static final String BAIDU_DOMAIN_KEYWORD = "baidu.com/";
    public static final boolean DEBUG;
    public static final int FAIL_TYPE_INTERCEPT = 4;
    public static final int FAIL_TYPE_INVALID_URI = 5;
    public static final int FAIL_TYPE_NETWORK = 0;
    public static final int FAIL_TYPE_NOT_SUPPORT_RANGE = 1;
    public static final int FAIL_TYPE_NO_PERMISSION = 3;
    public static final int FAIL_TYPE_SHORT_STOREAGE = 2;
    public static final int FAIL_TYPE_UNKOWN = -1;
    public static final float MIN_PROGRESS_CHANGE = 0.01f;
    public static final long MIN_PROGRESS_INTERVAL = 200;
    public static final long MIN_PROGRESS_SAVE_INTERVAL = 2000;
    public static final String TAG = "DownloadManager";
    public static DownloadManager sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public List<String> mBadFileDir;
    public Context mContext;
    public DownloadDao mDownloadDao;
    public ConcurrentHashMap<String, Download> mDownloadKeyMap;
    public ConcurrentHashMap<Long, Download> mDownloadMap;
    public ExecutorService mExecutor;
    public Handler mHandler;
    public CopyOnWriteArrayList<OnProgressChangeListener> mOnProgressChangeListeners;
    public CopyOnWriteArrayList<OnStateChangeListener> mOnStateChangeListeners;
    public long mProgressNotifyDownloadId;
    public int mProgressNotifyPercentage;
    public Runnable mProgressNotifyRunnable;
    public BinaryTaskMng mTaskManager;
    public IIntercepter mWifiOnlyIntercepter;
    public TaskObserver mtaskObserver;

    /* loaded from: classes3.dex */
    public interface DownloadItemFilter {
        boolean filter(Download download);
    }

    /* loaded from: classes3.dex */
    public interface OnProgressChangeListener {
        void onProgressChanged(long j, int i, long j2);
    }

    /* loaded from: classes3.dex */
    public interface OnStateChangeListener {
        void onStateChanged(long j, Download download);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1743821311, "Lcom/baidu/down/manage/DownloadManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1743821311, "Lcom/baidu/down/manage/DownloadManager;");
                return;
            }
        }
        DEBUG = DownloadConstants.mDebug;
    }

    public Collection<Download> getAllDownloads() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mDownloadMap.values();
        }
        return (Collection) invokeV.objValue;
    }

    public DownloadManager(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mDownloadMap = new ConcurrentHashMap<>();
        this.mDownloadKeyMap = new ConcurrentHashMap<>();
        this.mOnStateChangeListeners = new CopyOnWriteArrayList<>();
        this.mOnProgressChangeListeners = new CopyOnWriteArrayList<>();
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mExecutor = Executors.newFixedThreadPool(1, new NamingThreadFactory("DownloadManagerAsync"));
        this.mWifiOnlyIntercepter = null;
        this.mBadFileDir = new ArrayList();
        this.mProgressNotifyRunnable = new Runnable(this) { // from class: com.baidu.down.manage.DownloadManager.10
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DownloadManager this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
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

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && interceptable2.invokeV(1048576, this) != null) {
                    return;
                }
                synchronized (this.this$0.mOnProgressChangeListeners) {
                    Download download = (Download) this.this$0.mDownloadMap.get(Long.valueOf(this.this$0.mProgressNotifyDownloadId));
                    if (download != null) {
                        Iterator it = this.this$0.mOnProgressChangeListeners.iterator();
                        while (it.hasNext()) {
                            ((OnProgressChangeListener) it.next()).onProgressChanged(this.this$0.mProgressNotifyDownloadId, this.this$0.mProgressNotifyPercentage, download.mLastSpeed);
                        }
                    }
                    if (download != null && download.getNotificationNeeded()) {
                        Intent intent = new Intent(DownloadManager.ACTION_WEBSUITE_PROGRESS_CHANGE);
                        intent.putExtra("downloadid", this.this$0.mProgressNotifyDownloadId);
                        intent.putExtra("progress", this.this$0.mProgressNotifyPercentage);
                        this.this$0.mContext.sendBroadcast(intent);
                    }
                }
            }
        };
        this.mtaskObserver = new TaskObserver(this) { // from class: com.baidu.down.manage.DownloadManager.11
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DownloadManager this$0;

            @Override // com.baidu.down.common.TaskObserverInterface
            public void onDownloadMsgType(String str, long j, int i3, Object obj) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, Long.valueOf(j), Integer.valueOf(i3), obj}) == null) {
                }
            }

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
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

            @Override // com.baidu.down.common.TaskObserver
            public void onDownloadCancel(String str, long j, long j2, long j3, String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), str2}) == null) {
                    if (DownloadManager.DEBUG) {
                        Log.d("DownloadManager", "--- onDownloadCancel : " + j + " filePath =" + str2);
                    }
                    this.this$0.changeState(Download.DownloadState.CANCEL, j);
                }
            }

            @Override // com.baidu.down.common.TaskObserver
            public void onDownloadFail(String str, long j, long j2, String str2, String str3, int i3, DownDetail downDetail) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2), str2, str3, Integer.valueOf(i3), downDetail}) == null) {
                    Download download = (Download) this.this$0.mDownloadMap.get(Long.valueOf(j));
                    if (download != null) {
                        if (j2 <= download.getTotalbytes().longValue()) {
                            download.setCurrentbytes(Long.valueOf(j2));
                        }
                        download.setFailedReason(str3);
                        download.setFailedType(Integer.valueOf(i3));
                        if (downDetail != null) {
                            download.mDownDetail = downDetail;
                        }
                        if (DownloadManager.DEBUG) {
                            Log.i("DownloadManager", "failed_type : " + i3 + ", filePath: " + str2 + ", failreason : " + str3 + ", downDetail" + download.mDownDetail);
                            StringBuilder sb = new StringBuilder();
                            sb.append("mDownDetail:");
                            sb.append(download.mDownDetail.toString());
                            Log.i("DownloadManager", sb.toString());
                        }
                        download.mLastSpeed = 0L;
                    }
                    this.this$0.changeState(Download.DownloadState.FAILED, j);
                }
            }

            @Override // com.baidu.down.common.TaskObserver
            public void onDownloadPause(String str, long j, long j2, long j3, String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048579, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), str2}) == null) {
                    if (DownloadManager.DEBUG) {
                        Log.d("DownloadManager", "--- onDownloadPause : " + j + " filePath =" + str2);
                    }
                    Download download = (Download) this.this$0.mDownloadMap.get(Long.valueOf(j));
                    if (download != null) {
                        download.setCurrentbytes(Long.valueOf(j2));
                        download.mLastSpeed = 0L;
                    }
                    this.this$0.changeState(Download.DownloadState.PAUSE, j);
                }
            }

            @Override // com.baidu.down.common.TaskObserver
            public void onDownloadRunning(String str, long j, long j2, long j3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048580, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                    if (((Download) this.this$0.mDownloadMap.get(Long.valueOf(j))) == null) {
                        if (DownloadManager.DEBUG) {
                            Log.w("DownloadManager", "### onDownloadRunning, download not found : " + str + ", id=" + j);
                            return;
                        }
                        return;
                    }
                    if (DownloadManager.DEBUG) {
                        Log.d("DownloadManager", "--- onDownloadRunning, download : " + str + ", id=" + j);
                    }
                    this.this$0.changeState(Download.DownloadState.WAITING, j);
                }
            }

            @Override // com.baidu.down.common.TaskObserver
            public void onDownloadStart(String str, long j, long j2, String str2, String str3, String str4, String str5, boolean z, DownDetail downDetail) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048581, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2), str2, str3, str4, str5, Boolean.valueOf(z), downDetail}) == null) {
                    Download download = (Download) this.this$0.mDownloadMap.get(Long.valueOf(j));
                    if (DownloadManager.DEBUG) {
                        Log.d("DownloadManager", "onDownloadStart " + download + ", support range : " + z);
                        StringBuilder sb = new StringBuilder();
                        sb.append("onDownloadStart filepath ");
                        sb.append(str3);
                        Log.d("DownloadManager", sb.toString());
                    }
                    if (TextUtils.isEmpty(str3)) {
                        return;
                    }
                    if (download != null) {
                        download.setSupportrange(Boolean.valueOf(z));
                        File file = new File(str3);
                        String parent = file.getParent();
                        if (!TextUtils.equals(parent, download.getSavedPathForUser())) {
                            new File(download.getSavedPathForUser(), download.getFileName()).delete();
                            download.setSavedPathForUser(parent);
                            download.setCurrentbytes(0L);
                            download.setDownDir(parent);
                        }
                        download.setEtag(str4);
                        download.setTotalbytes(Long.valueOf(j2));
                        download.setFileName(file.getName());
                        if (!TextUtils.isEmpty(str5)) {
                            download.setRedownloadReason(str5);
                        }
                        if (downDetail != null) {
                            download.mDownDetail = downDetail;
                        }
                        if (DownloadManager.DEBUG) {
                            Log.d("DownloadManager", "--- onDownloadStart mDownDetail: " + download.mDownDetail);
                        }
                    }
                    this.this$0.changeState(Download.DownloadState.DOWNLOADING, j);
                }
            }

            @Override // com.baidu.down.common.TaskObserver
            public void onDownloadSuccess(String str, long j, long j2, long j3, String str2, long j4) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeCommon(1048582, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), str2, Long.valueOf(j4)}) == null) && DownloadManager.DEBUG) {
                    Log.d("DownloadManager", "--- onDownloadSuccess : " + j);
                }
            }

            @Override // com.baidu.down.common.TaskObserver
            public void onDownloadWait(String str, long j) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLJ(1048583, this, str, j) == null) {
                    if (DownloadManager.DEBUG) {
                        Log.d("DownloadManager", "--- onDownloadWait : " + j);
                    }
                    Download download = (Download) this.this$0.mDownloadMap.get(Long.valueOf(j));
                    if (download != null) {
                        download.mLastSpeed = 0L;
                    }
                    this.this$0.changeState(Download.DownloadState.WAITING, j);
                }
            }

            @Override // com.baidu.down.common.TaskObserver
            public void onDownloading(String str, long j, long j2, long j3, long j4, String str2) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), str2}) == null) && j3 != 0 && j2 != 0 && j2 <= j3) {
                    Download download = (Download) this.this$0.mDownloadMap.get(Long.valueOf(j));
                    if (download == null) {
                        if (DownloadManager.DEBUG) {
                            Log.e("DownloadManager", "*** onDownloading, found download is null!");
                            return;
                        }
                        return;
                    }
                    download.setCurrentbytes(Long.valueOf(j2));
                    download.setTotalbytes(Long.valueOf(j3));
                    download.setProgressmap(str2);
                    AbstractTask taskByKey = TaskFacade.getInstance(this.this$0.mContext).getBinaryTaskMng().getTaskByKey(str);
                    if (taskByKey instanceof BinaryReqTask) {
                        download.setRealUrl(taskByKey.mRealUrl);
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    if ((download.mLastSpeed == 0 || j4 != 0) && currentTimeMillis - download.mLastProgressNotiStamp < 200) {
                        return;
                    }
                    download.mLastProgressNotiStamp = currentTimeMillis;
                    int progress = download.getProgress();
                    float currentProgress = download.getCurrentProgress();
                    if ((download.mLastSpeed != 0 && j4 == 0) || j3 == Long.MAX_VALUE || Math.abs(currentProgress - download.mLastProgressNoti) >= 0.01f) {
                        download.mLastSpeed = j4;
                        this.this$0.notifyProgressChange(j, progress);
                        download.mLastProgressNoti = currentProgress;
                    }
                    if (currentTimeMillis - download.mLastProgressSaveStamp > 2000) {
                        download.mLastProgressSaveStamp = currentTimeMillis;
                        this.this$0.runAsync(new Runnable(this, download) { // from class: com.baidu.down.manage.DownloadManager.11.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass11 this$1;
                            public final /* synthetic */ Download val$download;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                                    newInitContext2.initArgs = r2;
                                    Object[] objArr2 = {this, download};
                                    interceptable3.invokeUnInit(65536, newInitContext2);
                                    int i3 = newInitContext2.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
                                        newInitContext2.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext2);
                                        return;
                                    }
                                }
                                this.this$1 = this;
                                this.val$download = download;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.this$1.this$0.mDownloadDao.update(this.val$download);
                                }
                            }
                        });
                    }
                }
            }

            @Override // com.baidu.down.common.TaskObserver
            public void onWriteFinish(String str, long j, long j2, long j3, DownDetail downDetail) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048585, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), downDetail}) == null) {
                    if (DownloadManager.DEBUG) {
                        Log.d("DownloadManager", "--- onWriteFinish : " + j);
                    }
                    Download download = (Download) this.this$0.mDownloadMap.get(Long.valueOf(j));
                    if (download != null) {
                        download.setTotalbytes(Long.valueOf(j2));
                        download.setCurrentbytes(Long.valueOf(j2));
                        if (downDetail != null) {
                            download.mDownDetail = downDetail;
                        }
                        if (DownloadManager.DEBUG) {
                            Log.d("DownloadManager", "--- onWriteFinish mDownDetail: " + download.mDownDetail);
                        }
                    }
                    this.this$0.notifyProgressChange(j, 100);
                    this.this$0.changeState(Download.DownloadState.FINISH, j);
                }
            }
        };
        this.mContext = context.getApplicationContext();
        setup(context);
    }

    public long start(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048591, this, str, z)) == null) {
            return start(str, z, null);
        }
        return invokeLZ.longValue;
    }

    public void updatePriority(Download download, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048598, this, download, i) == null) {
            download.setPriority(i);
            this.mTaskManager.updateTaskPrioirty(download.getId().longValue(), i);
            updateDownload(download);
        }
    }

    public long start(String str, boolean z, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{str, Boolean.valueOf(z), str2})) == null) {
            return start(str, z, str2, null);
        }
        return invokeCommon.longValue;
    }

    public static DownloadManager getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, context)) == null) {
            if (sInstance == null) {
                synchronized (DownloadManager.class) {
                    if (sInstance == null) {
                        sInstance = new DownloadManager(context);
                    }
                }
            }
            return sInstance;
        }
        return (DownloadManager) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runAsync(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65558, this, runnable) == null) {
            try {
                this.mExecutor.submit(runnable);
            } catch (Exception e) {
                if (!DEBUG) {
                    return;
                }
                throw e;
            }
        }
    }

    public void cancel(long... jArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jArr) == null) {
            for (long j : jArr) {
                Download download = this.mDownloadMap.get(Long.valueOf(j));
                if (download != null) {
                    runAsync(new Runnable(this, download) { // from class: com.baidu.down.manage.DownloadManager.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ DownloadManager this$0;
                        public final /* synthetic */ Download val$download;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, download};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$download = download;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.this$0.mTaskManager.stopDownload(this.val$download.getUrl(), this.val$download.getId().longValue(), this.val$download.mNeedDeleteFile);
                            }
                        }
                    });
                }
            }
        }
    }

    public Download getDownloadByUserKey(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            return this.mDownloadKeyMap.get(str);
        }
        return (Download) invokeL.objValue;
    }

    public Download getDownloadInfo(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) {
            return this.mDownloadMap.get(Long.valueOf(j));
        }
        return (Download) invokeJ.objValue;
    }

    public void registerOnProgressChangeListener(OnProgressChangeListener onProgressChangeListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onProgressChangeListener) != null) || onProgressChangeListener == null || this.mOnProgressChangeListeners.contains(onProgressChangeListener)) {
            return;
        }
        this.mOnProgressChangeListeners.add(onProgressChangeListener);
    }

    public void registerOnStateChangeListener(OnStateChangeListener onStateChangeListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, onStateChangeListener) != null) || onStateChangeListener == null || this.mOnStateChangeListeners.contains(onStateChangeListener)) {
            return;
        }
        this.mOnStateChangeListeners.add(onStateChangeListener);
    }

    public void setDebug(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            DownloadConstants.mDebug = z;
        }
    }

    public void setMaxDownloadTask(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.mTaskManager.setMaxDownloadThread((i <= 0 || i > 3) ? 3 : 3);
        }
    }

    public long start(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            return start(str, true);
        }
        return invokeL.longValue;
    }

    public void unRegisterOnProgressChangeListener(OnProgressChangeListener onProgressChangeListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048595, this, onProgressChangeListener) != null) || onProgressChangeListener == null) {
            return;
        }
        this.mOnProgressChangeListeners.remove(onProgressChangeListener);
    }

    public void unRegisterOnStateChangeListener(OnStateChangeListener onStateChangeListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048596, this, onStateChangeListener) != null) || onStateChangeListener == null) {
            return;
        }
        this.mOnStateChangeListeners.remove(onStateChangeListener);
    }

    public void updateDownload(Download download) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, download) == null) {
            runAsync(new Runnable(this, download) { // from class: com.baidu.down.manage.DownloadManager.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DownloadManager this$0;
                public final /* synthetic */ Download val$download;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, download};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$download = download;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.mDownloadDao.update(this.val$download);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeState(Download.DownloadState downloadState, long j) {
        Download download;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLJ(65551, this, downloadState, j) == null) && (download = this.mDownloadMap.get(Long.valueOf(j))) != null) {
            if (downloadState == Download.DownloadState.DOWNLOADING && download.getState() == Download.DownloadState.PAUSE) {
                return;
            }
            if (downloadState == Download.DownloadState.CANCEL) {
                if (download.mNeedDeleteFile) {
                    try {
                        new File(download.getSavedPathForUser(), download.getFileName()).delete();
                    } catch (Exception e) {
                        if (DEBUG) {
                            Log.e("DownloadManager", "delete download file error!!");
                            e.printStackTrace();
                        }
                    }
                }
                download.setState(downloadState);
                this.mDownloadMap.remove(Long.valueOf(j));
                this.mDownloadKeyMap.remove(download.getKeyByUser());
                if (DEBUG) {
                    Log.i("DownloadManager", "mDownloadMap remove downloadId: " + j + "  mDownloadMap size: " + this.mDownloadMap.size());
                }
                runAsync(new Runnable(this, j) { // from class: com.baidu.down.manage.DownloadManager.7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ DownloadManager this$0;
                    public final /* synthetic */ long val$downloadId;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Long.valueOf(j)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$downloadId = j;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.this$0.mDownloadDao.deleteByKey(this.val$downloadId);
                        }
                    }
                });
            } else if (download.getState() == Download.DownloadState.FINISH) {
                return;
            } else {
                download.setState(downloadState);
                runAsync(new Runnable(this, download) { // from class: com.baidu.down.manage.DownloadManager.8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ DownloadManager this$0;
                    public final /* synthetic */ Download val$download;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, download};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$download = download;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.this$0.mDownloadDao.update(this.val$download);
                        }
                    }
                });
                if (downloadState == Download.DownloadState.FAILED && download.getFailedType().intValue() == 3 && !this.mContext.getFilesDir().getPath().equals(download.getRealDownloadDir()) && !TextUtils.isEmpty(download.getRealDownloadDir()) && !this.mBadFileDir.contains(download.getRealDownloadDir())) {
                    if (DEBUG) {
                        Log.i("DownloadManager", "getSavedPathForUser:" + download.getRealDownloadDir());
                    }
                    this.mBadFileDir.add(download.getRealDownloadDir());
                    download.setState(Download.DownloadState.FAILED);
                    resume(download.getId().longValue());
                    return;
                }
            }
            notifyStateChange(j, download, downloadState);
        }
    }

    private File generateDownloadPath(Download download) {
        InterceptResult invokeL;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, this, download)) == null) {
            String savedPathForUser = download.getSavedPathForUser();
            if (!TextUtils.isEmpty(savedPathForUser)) {
                file = new File(savedPathForUser);
            } else {
                file = null;
            }
            if (file == null || !file.canWrite()) {
                return this.mContext.getExternalFilesDir("asyncdownload");
            }
            return file;
        }
        return (File) invokeL.objValue;
    }

    private void setup(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65559, this, context) == null) {
            Context applicationContext = context.getApplicationContext();
            this.mContext = applicationContext;
            this.mDownloadDao = DownloadDao.getInstance(applicationContext);
            initDownloadJar();
            if (this.mTaskManager == null) {
                return;
            }
            readAllDownload();
            this.mTaskManager.addObserver(this.mtaskObserver);
            this.mTaskManager.setMaxDownloadThread(3);
        }
    }

    public Collection<Download> getDownloadListByFilter(DownloadItemFilter downloadItemFilter) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, downloadItemFilter)) == null) {
            if (downloadItemFilter != null) {
                ArrayList arrayList = new ArrayList();
                for (Download download : this.mDownloadMap.values()) {
                    if (downloadItemFilter.filter(download)) {
                        arrayList.add(download);
                    }
                }
                return arrayList;
            }
            return getAllDownloads();
        }
        return (Collection) invokeL.objValue;
    }

    public void pause(long... jArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, jArr) == null) && jArr != null && jArr.length > 0) {
            for (long j : jArr) {
                Download download = this.mDownloadMap.get(Long.valueOf(j));
                if (download != null) {
                    download.setState(Download.DownloadState.PAUSE);
                }
            }
            runAsync(new Runnable(this, jArr) { // from class: com.baidu.down.manage.DownloadManager.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DownloadManager this$0;
                public final /* synthetic */ long[] val$downloadIds;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, jArr};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$downloadIds = jArr;
                }

                @Override // java.lang.Runnable
                public void run() {
                    long[] jArr2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        for (long j2 : this.val$downloadIds) {
                            Download download2 = (Download) this.this$0.mDownloadMap.get(Long.valueOf(j2));
                            if (download2 != null) {
                                this.this$0.mTaskManager.pauseDownload(download2.getUrl(), j2);
                            }
                        }
                    }
                }
            });
        }
    }

    private void initDownloadJar() {
        TaskFacade instanceByConfig;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            if (DEBUG) {
                Log.i("DownloadManager", "initDownloadJar");
            }
            try {
                if (this.mTaskManager == null && (instanceByConfig = TaskFacade.getInstanceByConfig(this.mContext, null)) != null) {
                    this.mTaskManager = instanceByConfig.getBinaryTaskMng();
                }
            } catch (Throwable th) {
                if (DEBUG) {
                    th.printStackTrace();
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean hasDownloading() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            for (Download download : this.mDownloadMap.values()) {
                if (download.getState() == Download.DownloadState.WAITING || download.getState() == Download.DownloadState.DOWNLOADING) {
                    return true;
                }
                while (r0.hasNext()) {
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyProgressChange(long j, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65555, this, new Object[]{Long.valueOf(j), Integer.valueOf(i)}) == null) {
            if (DEBUG && getDownloadInfo(j) != null) {
                Log.d("DownloadManager", "notifyProgressChange downloadId " + j + " percentage " + i);
            }
            this.mProgressNotifyDownloadId = j;
            this.mProgressNotifyPercentage = i;
            this.mHandler.removeCallbacks(this.mProgressNotifyRunnable);
            this.mHandler.post(this.mProgressNotifyRunnable);
        }
    }

    private void notifyStateChange(long j, Download download, Download.DownloadState downloadState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65556, this, new Object[]{Long.valueOf(j), download, downloadState}) == null) {
            if (DEBUG) {
                Log.d("DownloadManager", "notifyStateChange downloadId " + j + " state " + download.getState());
            }
            this.mHandler.post(new Runnable(this, downloadState, download, j) { // from class: com.baidu.down.manage.DownloadManager.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DownloadManager this$0;
                public final /* synthetic */ Download val$download;
                public final /* synthetic */ long val$downloadId;
                public final /* synthetic */ Download.DownloadState val$state;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, downloadState, download, Long.valueOf(j)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$state = downloadState;
                    this.val$download = download;
                    this.val$downloadId = j;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 != null && interceptable2.invokeV(1048576, this) != null) || this.val$state != this.val$download.getState()) {
                        return;
                    }
                    Iterator it = this.this$0.mOnStateChangeListeners.iterator();
                    while (it.hasNext()) {
                        ((OnStateChangeListener) it.next()).onStateChanged(this.val$downloadId, this.val$download);
                    }
                    if (this.val$download.getNotificationNeeded()) {
                        Intent intent = new Intent(DownloadManager.ACTION_WEBSUITE_STATE_CHANGE);
                        intent.putExtra("downloadid", this.val$downloadId);
                        intent.putExtra("state", this.val$download.getState());
                        intent.putExtra("savepath", this.val$download.getDownloadFileName());
                        intent.putExtra("error", this.val$download.getFailedReason());
                        this.this$0.mContext.sendBroadcast(intent);
                    }
                }
            });
        }
    }

    private void readAllDownload() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
            for (Download download : this.mDownloadDao.loadAll()) {
                if (download.getState() == Download.DownloadState.DOWNLOADING || download.getState() == Download.DownloadState.WAITING) {
                    download.setState(Download.DownloadState.PAUSE);
                }
                this.mDownloadMap.put(download.getId(), download);
                if (!TextUtils.isEmpty(download.getKeyByUser())) {
                    this.mDownloadKeyMap.put(download.getKeyByUser(), download);
                }
            }
        }
    }

    public boolean isWifiNetWork() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.mContext.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                if (DEBUG) {
                    Log.d("DownloadManager", "netWorkInfo: " + activeNetworkInfo);
                }
                if (activeNetworkInfo.getTypeName().toLowerCase().equalsIgnoreCase("wifi")) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long startDownload(Download download) {
        InterceptResult invokeL;
        long j;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, this, download)) == null) {
            if (download != null && !TextUtils.isEmpty(download.getUrl())) {
                if (download.isWifiOnly() && !isWifiNetWork()) {
                    download.setAutoPause(Boolean.TRUE);
                    pause(download.getId().longValue());
                    changeState(Download.DownloadState.PAUSE, download.getId().longValue());
                    return download.getId().longValue();
                }
                if (DEBUG) {
                    Log.d("DownloadManager", "--- startDownload: " + download.getUrl());
                }
                download.setFailedReason("");
                download.setAutoPause(Boolean.FALSE);
                download.mRequestHeader = "";
                String savedPathForUser = download.getSavedPathForUser();
                long longValue = download.getTotalbytes().longValue();
                long longValue2 = download.getCurrentbytes().longValue();
                File generateDownloadPath = generateDownloadPath(download);
                if (generateDownloadPath != null && !generateDownloadPath.exists()) {
                    longValue2 = 0;
                }
                if (generateDownloadPath != null && !TextUtils.equals(generateDownloadPath.getPath(), download.getSavedPathForUser())) {
                    savedPathForUser = generateDownloadPath.getPath();
                    download.setProgressmap("");
                    j2 = 0;
                    j = 0;
                } else {
                    j = longValue;
                    j2 = longValue2;
                }
                if (DEBUG) {
                    Log.d("DownloadManager", "savedPathStr:" + savedPathForUser);
                }
                download.setDownDir(savedPathForUser);
                HashMap hashMap = new HashMap();
                hashMap.put(Config.LAUNCH_REFERER, DownloadConstants.REFER);
                if (!TextUtils.isEmpty(download.getUrihost())) {
                    hashMap.put("host", download.getUrihost());
                }
                if (DEBUG) {
                    Log.d("DownloadManager", "host:" + download.getUrihost());
                    Log.d("DownloadManager", "host:" + download.getUrihost());
                }
                if (download.getUrl().contains(BAIDU_DOMAIN_KEYWORD)) {
                    if (hashMap.get(Config.LAUNCH_REFERER) == null) {
                        hashMap.put(Config.LAUNCH_REFERER, DownloadConstants.REFER);
                    }
                } else if (hashMap.get(Config.LAUNCH_REFERER) != null) {
                    hashMap.remove(Config.LAUNCH_REFERER);
                }
                FileMsg fileMsg = new FileMsg(download.getUrl(), download.getId().longValue(), savedPathForUser, download.getFileName(), download.getMimetype(), Boolean.TRUE, hashMap, j2, j, download.getEtag());
                fileMsg.mPattern = 0;
                fileMsg.mRealUrl = download.getRealUrl();
                if (DEBUG) {
                    Log.d("DownloadManager", "---startDownload  fMsg.mPattern: " + fileMsg.mPattern);
                }
                if (download.isWifiOnly()) {
                    if (DEBUG) {
                        Log.d("DownloadManager", "---startDownload isWiFiOnly");
                    }
                    if (this.mWifiOnlyIntercepter == null) {
                        this.mWifiOnlyIntercepter = new IIntercepter(this) { // from class: com.baidu.down.manage.DownloadManager.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ DownloadManager this$0;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$0 = this;
                            }

                            @Override // com.baidu.down.common.intercepter.IIntercepter
                            public com.baidu.down.common.intercepter.InterceptResult process(Context context, String str, long j3, Object obj) {
                                InterceptResult invokeCommon;
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(1048576, this, new Object[]{context, str, Long.valueOf(j3), obj})) == null) {
                                    if (!this.this$0.isWifiNetWork()) {
                                        if (DownloadManager.DEBUG) {
                                            Log.i("DownloadManager", "--- None Wifi checked : " + str);
                                        }
                                        Download download2 = (Download) this.this$0.mDownloadMap.get(Long.valueOf(j3));
                                        if (download2 != null) {
                                            download2.setAutoPause(Boolean.TRUE);
                                            if (DownloadManager.DEBUG) {
                                                Log.i("DownloadManager", "--- None Wifi set auto paused : " + str);
                                            }
                                        } else if (DownloadManager.DEBUG) {
                                            Log.e("DownloadManager", "--- None Wifi set auto paused, can not find download : " + str);
                                        }
                                        return new com.baidu.down.common.intercepter.InterceptResult(1);
                                    }
                                    return null;
                                }
                                return (com.baidu.down.common.intercepter.InterceptResult) invokeCommon.objValue;
                            }
                        };
                    }
                    fileMsg.addIntercepter("network", this.mWifiOnlyIntercepter);
                }
                fileMsg.mProgressStr = download.getProgressmap();
                fileMsg.mFromParam = download.getFromParam();
                fileMsg.mPriority = download.getPriority();
                this.mTaskManager.startDownload(fileMsg);
                return download.getId().longValue();
            }
            return -1L;
        }
        return invokeL.longValue;
    }

    public void resume(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048586, this, j) == null) {
            Download download = this.mDownloadMap.get(Long.valueOf(j));
            if (download != null && download.getState() != Download.DownloadState.DOWNLOADING) {
                changeState(Download.DownloadState.WAITING, j);
                if (!new File(download.getSavedPathForUser(), download.getFileName()).exists()) {
                    download.setCurrentbytes(0L);
                }
                runAsync(new Runnable(this, download) { // from class: com.baidu.down.manage.DownloadManager.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ DownloadManager this$0;
                    public final /* synthetic */ Download val$download;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, download};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$download = download;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            Process.setThreadPriority(10);
                            Download download2 = this.val$download;
                            if (download2 == null) {
                                return;
                            }
                            this.this$0.startDownload(download2);
                        }
                    }
                });
            } else if (download != null) {
                notifyStateChange(j, download, download.getState());
            }
        }
    }

    public long start(Download download) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, download)) == null) {
            if (download != null && !TextUtils.isEmpty(download.getUrl())) {
                long insert = this.mDownloadDao.insert(download);
                this.mDownloadMap.put(Long.valueOf(insert), download);
                if (!TextUtils.isEmpty(download.getKeyByUser())) {
                    this.mDownloadKeyMap.put(download.getKeyByUser(), download);
                }
                runAsync(new Runnable(this, download) { // from class: com.baidu.down.manage.DownloadManager.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ DownloadManager this$0;
                    public final /* synthetic */ Download val$newDownload;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, download};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$newDownload = download;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            Process.setThreadPriority(10);
                            this.this$0.startDownload(this.val$newDownload);
                        }
                    }
                });
                return insert;
            }
            return -1L;
        }
        return invokeL.longValue;
    }

    public long start(String str, boolean z, String str2, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{str, Boolean.valueOf(z), str2, str3})) == null) {
            return start(str, z, str2, str3, null);
        }
        return invokeCommon.longValue;
    }

    public long start(String str, boolean z, String str2, String str3, String str4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048594, this, new Object[]{str, Boolean.valueOf(z), str2, str3, str4})) == null) {
            Download download = new Download();
            download.setUrl(str);
            download.setMimetype(str4);
            download.setWifiOnly(z);
            download.setCheckContentType(false);
            if (!TextUtils.isEmpty(str3)) {
                download.setSavedPathForUser(str3);
            }
            if (!TextUtils.isEmpty(str2)) {
                download.setFileName(str2);
            } else if (!TextUtils.isEmpty(str3)) {
                int lastIndexOf = str3.lastIndexOf("/") + 1;
                download.setFileName(str3.substring(lastIndexOf));
                download.setSavedPathForUser(str3.substring(0, lastIndexOf));
            }
            return start(download);
        }
        return invokeCommon.longValue;
    }
}
