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
import com.baidu.down.common.DownDetail;
import com.baidu.down.common.FileMsg;
import com.baidu.down.common.TaskObserver;
import com.baidu.down.common.intercepter.IIntercepter;
import com.baidu.down.common.intercepter.InterceptResult;
import com.baidu.down.manage.Download;
import com.baidu.down.request.task.AbstractTask;
import com.baidu.down.request.task.BinaryReqTask;
import com.baidu.down.request.taskmanager.BinaryTaskMng;
import com.baidu.down.request.taskmanager.TaskFacade;
import com.baidu.down.utils.NamingThreadFactory;
import com.baidu.mobstat.Config;
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
/* loaded from: classes2.dex */
public final class DownloadManager {
    public static final String ACTION_WEBSUITE_PROGRESS_CHANGE = "com.baidu.appsearch.websuite.download.PROGRESS_CHANGE";
    public static final String ACTION_WEBSUITE_STATE_CHANGE = "com.baidu.appsearch.websuite.download.STATE_CHANGE";
    public static final String BAIDU_DOMAIN_KEYWORD = "baidu.com/";
    public static final boolean DEBUG = DownloadConstants.mDebug;
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
    public Context mContext;
    public DownloadDao mDownloadDao;
    public long mProgressNotifyDownloadId;
    public int mProgressNotifyPercentage;
    public BinaryTaskMng mTaskManager;
    public ConcurrentHashMap<Long, Download> mDownloadMap = new ConcurrentHashMap<>();
    public ConcurrentHashMap<String, Download> mDownloadKeyMap = new ConcurrentHashMap<>();
    public CopyOnWriteArrayList<OnStateChangeListener> mOnStateChangeListeners = new CopyOnWriteArrayList<>();
    public CopyOnWriteArrayList<OnProgressChangeListener> mOnProgressChangeListeners = new CopyOnWriteArrayList<>();
    public Handler mHandler = new Handler(Looper.getMainLooper());
    public ExecutorService mExecutor = Executors.newFixedThreadPool(1, new NamingThreadFactory("DownloadManagerAsync"));
    public IIntercepter mWifiOnlyIntercepter = null;
    public List<String> mBadFileDir = new ArrayList();
    public Runnable mProgressNotifyRunnable = new Runnable() { // from class: com.baidu.down.manage.DownloadManager.10
        @Override // java.lang.Runnable
        public void run() {
            synchronized (DownloadManager.this.mOnProgressChangeListeners) {
                Download download = (Download) DownloadManager.this.mDownloadMap.get(Long.valueOf(DownloadManager.this.mProgressNotifyDownloadId));
                if (download != null) {
                    Iterator it = DownloadManager.this.mOnProgressChangeListeners.iterator();
                    while (it.hasNext()) {
                        ((OnProgressChangeListener) it.next()).onProgressChanged(DownloadManager.this.mProgressNotifyDownloadId, DownloadManager.this.mProgressNotifyPercentage, download.mLastSpeed);
                    }
                }
                if (download != null && download.getNotificationNeeded()) {
                    Intent intent = new Intent(DownloadManager.ACTION_WEBSUITE_PROGRESS_CHANGE);
                    intent.putExtra("downloadid", DownloadManager.this.mProgressNotifyDownloadId);
                    intent.putExtra("progress", DownloadManager.this.mProgressNotifyPercentage);
                    DownloadManager.this.mContext.sendBroadcast(intent);
                }
            }
        }
    };
    public TaskObserver mtaskObserver = new TaskObserver() { // from class: com.baidu.down.manage.DownloadManager.11
        @Override // com.baidu.down.common.TaskObserver
        public void onDownloadCancel(String str, long j, long j2, long j3, String str2) {
            if (DownloadManager.DEBUG) {
                Log.d("DownloadManager", "--- onDownloadCancel : " + j + " filePath =" + str2);
            }
            DownloadManager.this.changeState(Download.DownloadState.CANCEL, j);
        }

        @Override // com.baidu.down.common.TaskObserver
        public void onDownloadFail(String str, long j, long j2, String str2, String str3, int i2, DownDetail downDetail) {
            Download download = (Download) DownloadManager.this.mDownloadMap.get(Long.valueOf(j));
            if (download != null) {
                if (j2 <= download.getTotalbytes().longValue()) {
                    download.setCurrentbytes(Long.valueOf(j2));
                }
                download.setFailedReason(str3);
                download.setFailedType(Integer.valueOf(i2));
                if (downDetail != null) {
                    download.mDownDetail = downDetail;
                }
                if (DownloadManager.DEBUG) {
                    Log.i("DownloadManager", "failed_type : " + i2 + ", filePath: " + str2 + ", failreason : " + str3 + ", downDetail" + download.mDownDetail);
                    StringBuilder sb = new StringBuilder();
                    sb.append("mDownDetail:");
                    sb.append(download.mDownDetail.toString());
                    Log.i("DownloadManager", sb.toString());
                }
                download.mLastSpeed = 0L;
            }
            DownloadManager.this.changeState(Download.DownloadState.FAILED, j);
        }

        @Override // com.baidu.down.common.TaskObserverInterface
        public void onDownloadMsgType(String str, long j, int i2, Object obj) {
        }

        @Override // com.baidu.down.common.TaskObserver
        public void onDownloadPause(String str, long j, long j2, long j3, String str2) {
            if (DownloadManager.DEBUG) {
                Log.d("DownloadManager", "--- onDownloadPause : " + j + " filePath =" + str2);
            }
            Download download = (Download) DownloadManager.this.mDownloadMap.get(Long.valueOf(j));
            if (download != null) {
                download.setCurrentbytes(Long.valueOf(j2));
                download.mLastSpeed = 0L;
            }
            DownloadManager.this.changeState(Download.DownloadState.PAUSE, j);
        }

        @Override // com.baidu.down.common.TaskObserver
        public void onDownloadRunning(String str, long j, long j2, long j3) {
            if (((Download) DownloadManager.this.mDownloadMap.get(Long.valueOf(j))) == null) {
                if (DownloadManager.DEBUG) {
                    Log.w("DownloadManager", "### onDownloadRunning, download not found : " + str + ", id=" + j);
                    return;
                }
                return;
            }
            if (DownloadManager.DEBUG) {
                Log.d("DownloadManager", "--- onDownloadRunning, download : " + str + ", id=" + j);
            }
            DownloadManager.this.changeState(Download.DownloadState.WAITING, j);
        }

        @Override // com.baidu.down.common.TaskObserver
        public void onDownloadStart(String str, long j, long j2, String str2, String str3, String str4, String str5, boolean z, DownDetail downDetail) {
            Download download = (Download) DownloadManager.this.mDownloadMap.get(Long.valueOf(j));
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
            DownloadManager.this.changeState(Download.DownloadState.DOWNLOADING, j);
        }

        @Override // com.baidu.down.common.TaskObserver
        public void onDownloadSuccess(String str, long j, long j2, long j3, String str2, long j4) {
            if (DownloadManager.DEBUG) {
                Log.d("DownloadManager", "--- onDownloadSuccess : " + j);
            }
        }

        @Override // com.baidu.down.common.TaskObserver
        public void onDownloadWait(String str, long j) {
            if (DownloadManager.DEBUG) {
                Log.d("DownloadManager", "--- onDownloadWait : " + j);
            }
            Download download = (Download) DownloadManager.this.mDownloadMap.get(Long.valueOf(j));
            if (download != null) {
                download.mLastSpeed = 0L;
            }
            DownloadManager.this.changeState(Download.DownloadState.WAITING, j);
        }

        @Override // com.baidu.down.common.TaskObserver
        public void onDownloading(String str, long j, long j2, long j3, long j4, String str2) {
            if (j3 == 0 || j2 == 0 || j2 > j3) {
                return;
            }
            final Download download = (Download) DownloadManager.this.mDownloadMap.get(Long.valueOf(j));
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
            AbstractTask taskByKey = TaskFacade.getInstance(DownloadManager.this.mContext).getBinaryTaskMng().getTaskByKey(str);
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
                DownloadManager.this.notifyProgressChange(j, progress);
                download.mLastProgressNoti = currentProgress;
            }
            if (currentTimeMillis - download.mLastProgressSaveStamp > 2000) {
                download.mLastProgressSaveStamp = currentTimeMillis;
                DownloadManager.this.runAsync(new Runnable() { // from class: com.baidu.down.manage.DownloadManager.11.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DownloadManager.this.mDownloadDao.update(download);
                    }
                });
            }
        }

        @Override // com.baidu.down.common.TaskObserver
        public void onWriteFinish(String str, long j, long j2, long j3, DownDetail downDetail) {
            if (DownloadManager.DEBUG) {
                Log.d("DownloadManager", "--- onWriteFinish : " + j);
            }
            Download download = (Download) DownloadManager.this.mDownloadMap.get(Long.valueOf(j));
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
            DownloadManager.this.notifyProgressChange(j, 100);
            DownloadManager.this.changeState(Download.DownloadState.FINISH, j);
        }
    };

    /* loaded from: classes2.dex */
    public interface DownloadItemFilter {
        boolean filter(Download download);
    }

    /* loaded from: classes2.dex */
    public interface OnProgressChangeListener {
        void onProgressChanged(long j, int i2, long j2);
    }

    /* loaded from: classes2.dex */
    public interface OnStateChangeListener {
        void onStateChanged(long j, Download download);
    }

    public DownloadManager(Context context) {
        this.mContext = context.getApplicationContext();
        setup(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeState(Download.DownloadState downloadState, final long j) {
        final Download download = this.mDownloadMap.get(Long.valueOf(j));
        if (download != null) {
            if (downloadState == Download.DownloadState.DOWNLOADING && download.getState() == Download.DownloadState.PAUSE) {
                return;
            }
            if (downloadState == Download.DownloadState.CANCEL) {
                if (download.mNeedDeleteFile) {
                    try {
                        new File(download.getSavedPathForUser(), download.getFileName()).delete();
                    } catch (Exception e2) {
                        if (DEBUG) {
                            Log.e("DownloadManager", "delete download file error!!");
                            e2.printStackTrace();
                        }
                    }
                }
                download.setState(downloadState);
                this.mDownloadMap.remove(Long.valueOf(j));
                this.mDownloadKeyMap.remove(download.getKeyByUser());
                if (DEBUG) {
                    Log.i("DownloadManager", "mDownloadMap remove downloadId: " + j + "  mDownloadMap size: " + this.mDownloadMap.size());
                }
                runAsync(new Runnable() { // from class: com.baidu.down.manage.DownloadManager.7
                    @Override // java.lang.Runnable
                    public void run() {
                        DownloadManager.this.mDownloadDao.deleteByKey(j);
                    }
                });
            } else if (download.getState() == Download.DownloadState.FINISH) {
                return;
            } else {
                download.setState(downloadState);
                runAsync(new Runnable() { // from class: com.baidu.down.manage.DownloadManager.8
                    @Override // java.lang.Runnable
                    public void run() {
                        DownloadManager.this.mDownloadDao.update(download);
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
        String savedPathForUser = download.getSavedPathForUser();
        File file = !TextUtils.isEmpty(savedPathForUser) ? new File(savedPathForUser) : null;
        return (file == null || !file.canWrite()) ? this.mContext.getExternalFilesDir("asyncdownload") : file;
    }

    public static DownloadManager getInstance(Context context) {
        if (sInstance == null) {
            synchronized (DownloadManager.class) {
                if (sInstance == null) {
                    sInstance = new DownloadManager(context);
                }
            }
        }
        return sInstance;
    }

    private void initDownloadJar() {
        TaskFacade instanceByConfig;
        if (DEBUG) {
            Log.i("DownloadManager", "initDownloadJar");
        }
        try {
            if (this.mTaskManager != null || (instanceByConfig = TaskFacade.getInstanceByConfig(this.mContext, null)) == null) {
                return;
            }
            this.mTaskManager = instanceByConfig.getBinaryTaskMng();
        } catch (Throwable th) {
            if (DEBUG) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyProgressChange(long j, int i2) {
        if (DEBUG && getDownloadInfo(j) != null) {
            Log.d("DownloadManager", "notifyProgressChange downloadId " + j + " percentage " + i2);
        }
        this.mProgressNotifyDownloadId = j;
        this.mProgressNotifyPercentage = i2;
        this.mHandler.removeCallbacks(this.mProgressNotifyRunnable);
        this.mHandler.post(this.mProgressNotifyRunnable);
    }

    private void notifyStateChange(final long j, final Download download, final Download.DownloadState downloadState) {
        if (DEBUG) {
            Log.d("DownloadManager", "notifyStateChange downloadId " + j + " state " + download.getState());
        }
        this.mHandler.post(new Runnable() { // from class: com.baidu.down.manage.DownloadManager.6
            @Override // java.lang.Runnable
            public void run() {
                if (downloadState != download.getState()) {
                    return;
                }
                Iterator it = DownloadManager.this.mOnStateChangeListeners.iterator();
                while (it.hasNext()) {
                    ((OnStateChangeListener) it.next()).onStateChanged(j, download);
                }
                if (download.getNotificationNeeded()) {
                    Intent intent = new Intent(DownloadManager.ACTION_WEBSUITE_STATE_CHANGE);
                    intent.putExtra("downloadid", j);
                    intent.putExtra("state", download.getState());
                    intent.putExtra("savepath", download.getDownloadFileName());
                    intent.putExtra("error", download.getFailedReason());
                    DownloadManager.this.mContext.sendBroadcast(intent);
                }
            }
        });
    }

    private void readAllDownload() {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void runAsync(Runnable runnable) {
        try {
            this.mExecutor.submit(runnable);
        } catch (Exception e2) {
            if (DEBUG) {
                throw e2;
            }
        }
    }

    private void setup(Context context) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public long startDownload(Download download) {
        long j;
        long j2;
        if (download == null || TextUtils.isEmpty(download.getUrl())) {
            return -1L;
        }
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
        if (generateDownloadPath == null || TextUtils.equals(generateDownloadPath.getPath(), download.getSavedPathForUser())) {
            j = longValue;
            j2 = longValue2;
        } else {
            savedPathForUser = generateDownloadPath.getPath();
            download.setProgressmap("");
            j2 = 0;
            j = 0;
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
                this.mWifiOnlyIntercepter = new IIntercepter() { // from class: com.baidu.down.manage.DownloadManager.2
                    @Override // com.baidu.down.common.intercepter.IIntercepter
                    public InterceptResult process(Context context, String str, long j3, Object obj) {
                        if (DownloadManager.this.isWifiNetWork()) {
                            return null;
                        }
                        if (DownloadManager.DEBUG) {
                            Log.i("DownloadManager", "--- None Wifi checked : " + str);
                        }
                        Download download2 = (Download) DownloadManager.this.mDownloadMap.get(Long.valueOf(j3));
                        if (download2 == null) {
                            if (DownloadManager.DEBUG) {
                                Log.e("DownloadManager", "--- None Wifi set auto paused, can not find download : " + str);
                            }
                        } else {
                            download2.setAutoPause(Boolean.TRUE);
                            if (DownloadManager.DEBUG) {
                                Log.i("DownloadManager", "--- None Wifi set auto paused : " + str);
                            }
                        }
                        return new InterceptResult(1);
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

    public void cancel(long... jArr) {
        for (long j : jArr) {
            final Download download = this.mDownloadMap.get(Long.valueOf(j));
            if (download != null) {
                runAsync(new Runnable() { // from class: com.baidu.down.manage.DownloadManager.3
                    @Override // java.lang.Runnable
                    public void run() {
                        DownloadManager.this.mTaskManager.stopDownload(download.getUrl(), download.getId().longValue(), download.mNeedDeleteFile);
                    }
                });
            }
        }
    }

    public Collection<Download> getAllDownloads() {
        return this.mDownloadMap.values();
    }

    public Download getDownloadByUserKey(String str) {
        return this.mDownloadKeyMap.get(str);
    }

    public Download getDownloadInfo(long j) {
        return this.mDownloadMap.get(Long.valueOf(j));
    }

    public Collection<Download> getDownloadListByFilter(DownloadItemFilter downloadItemFilter) {
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

    /* JADX WARN: Removed duplicated region for block: B:5:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean hasDownloading() {
        for (Download download : this.mDownloadMap.values()) {
            if (download.getState() == Download.DownloadState.WAITING || download.getState() == Download.DownloadState.DOWNLOADING) {
                return true;
            }
            while (r0.hasNext()) {
            }
        }
        return false;
    }

    public boolean isWifiNetWork() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.mContext.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            return false;
        }
        if (DEBUG) {
            Log.d("DownloadManager", "netWorkInfo: " + activeNetworkInfo);
        }
        return activeNetworkInfo.getTypeName().toLowerCase().equalsIgnoreCase("wifi");
    }

    public void pause(final long... jArr) {
        if (jArr == null || jArr.length <= 0) {
            return;
        }
        for (long j : jArr) {
            Download download = this.mDownloadMap.get(Long.valueOf(j));
            if (download != null) {
                download.setState(Download.DownloadState.PAUSE);
            }
        }
        runAsync(new Runnable() { // from class: com.baidu.down.manage.DownloadManager.4
            @Override // java.lang.Runnable
            public void run() {
                long[] jArr2;
                for (long j2 : jArr) {
                    Download download2 = (Download) DownloadManager.this.mDownloadMap.get(Long.valueOf(j2));
                    if (download2 != null) {
                        DownloadManager.this.mTaskManager.pauseDownload(download2.getUrl(), j2);
                    }
                }
            }
        });
    }

    public void registerOnProgressChangeListener(OnProgressChangeListener onProgressChangeListener) {
        if (onProgressChangeListener == null || this.mOnProgressChangeListeners.contains(onProgressChangeListener)) {
            return;
        }
        this.mOnProgressChangeListeners.add(onProgressChangeListener);
    }

    public void registerOnStateChangeListener(OnStateChangeListener onStateChangeListener) {
        if (onStateChangeListener == null || this.mOnStateChangeListeners.contains(onStateChangeListener)) {
            return;
        }
        this.mOnStateChangeListeners.add(onStateChangeListener);
    }

    public void resume(long j) {
        final Download download = this.mDownloadMap.get(Long.valueOf(j));
        if (download == null || download.getState() == Download.DownloadState.DOWNLOADING) {
            if (download != null) {
                notifyStateChange(j, download, download.getState());
                return;
            }
            return;
        }
        changeState(Download.DownloadState.WAITING, j);
        if (!new File(download.getSavedPathForUser(), download.getFileName()).exists()) {
            download.setCurrentbytes(0L);
        }
        runAsync(new Runnable() { // from class: com.baidu.down.manage.DownloadManager.5
            @Override // java.lang.Runnable
            public void run() {
                Process.setThreadPriority(10);
                Download download2 = download;
                if (download2 != null) {
                    DownloadManager.this.startDownload(download2);
                }
            }
        });
    }

    public void setDebug(boolean z) {
        DownloadConstants.mDebug = z;
    }

    public void setMaxDownloadTask(int i2) {
        this.mTaskManager.setMaxDownloadThread((i2 <= 0 || i2 > 3) ? 3 : 3);
    }

    public long start(String str) {
        return start(str, true);
    }

    public void unRegisterOnProgressChangeListener(OnProgressChangeListener onProgressChangeListener) {
        if (onProgressChangeListener == null) {
            return;
        }
        this.mOnProgressChangeListeners.remove(onProgressChangeListener);
    }

    public void unRegisterOnStateChangeListener(OnStateChangeListener onStateChangeListener) {
        if (onStateChangeListener == null) {
            return;
        }
        this.mOnStateChangeListeners.remove(onStateChangeListener);
    }

    public void updateDownload(final Download download) {
        runAsync(new Runnable() { // from class: com.baidu.down.manage.DownloadManager.9
            @Override // java.lang.Runnable
            public void run() {
                DownloadManager.this.mDownloadDao.update(download);
            }
        });
    }

    public void updatePriority(Download download, int i2) {
        download.setPriority(i2);
        this.mTaskManager.updateTaskPrioirty(download.getId().longValue(), i2);
        updateDownload(download);
    }

    public long start(String str, boolean z) {
        return start(str, z, null);
    }

    public long start(String str, boolean z, String str2) {
        return start(str, z, str2, null);
    }

    public long start(String str, boolean z, String str2, String str3) {
        return start(str, z, str2, str3, null);
    }

    public long start(String str, boolean z, String str2, String str3, String str4) {
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

    public long start(final Download download) {
        if (download == null || TextUtils.isEmpty(download.getUrl())) {
            return -1L;
        }
        long insert = this.mDownloadDao.insert(download);
        this.mDownloadMap.put(Long.valueOf(insert), download);
        if (!TextUtils.isEmpty(download.getKeyByUser())) {
            this.mDownloadKeyMap.put(download.getKeyByUser(), download);
        }
        runAsync(new Runnable() { // from class: com.baidu.down.manage.DownloadManager.1
            @Override // java.lang.Runnable
            public void run() {
                Process.setThreadPriority(10);
                DownloadManager.this.startDownload(download);
            }
        });
        return insert;
    }
}
