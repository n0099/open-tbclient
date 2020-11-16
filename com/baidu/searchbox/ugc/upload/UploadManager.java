package com.baidu.searchbox.ugc.upload;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.ugc.upload.HttpRequestTokenModule;
import com.baidu.searchbox.ugc.upload.UploadFileTask;
import com.baidu.searchbox.ugc.utils.FileUtils;
import com.baidu.searchbox.upload.provider.UploadProviderManager;
import com.baidubce.BceClientConfiguration;
import com.baidubce.auth.DefaultBceSessionCredentials;
import com.baidubce.http.DefaultRetryPolicy;
import com.baidubce.services.bos.BosClient;
import com.baidubce.services.bos.BosClientConfiguration;
import com.baidubce.services.vod.VodClient;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes19.dex */
public class UploadManager {
    private static final String BOS_ENDPOINT = "bj.bcebos.com";
    private static final int RETRY_DELAY = 3000;
    private static final int RETRY_MAX = 2;
    private static final String VOD_ENDPIONT = "vod.bj.baidubce.com";
    private static volatile UploadManager instance;
    private UploadCallback mCallback;
    private ProcessTasksCallable mCurrCallable;
    private ThreadPoolExecutor sThreadPool;
    private static final String TAG = UploadManager.class.getSimpleName();
    public static final boolean DEBUG = AppConfig.isDebug();
    private int mSourceType = 0;
    private String mFrom = "";
    private UploadFileTask.TaskCallback mTaskCallback = new UploadFileTask.TaskCallback() { // from class: com.baidu.searchbox.ugc.upload.UploadManager.2
        @Override // com.baidu.searchbox.ugc.upload.UploadFileTask.TaskCallback
        public void onProgress(final UploadFileTask uploadFileTask, final long j, final long j2) {
            UploadManager.this.mHandler.post(new Runnable() { // from class: com.baidu.searchbox.ugc.upload.UploadManager.2.1
                @Override // java.lang.Runnable
                public void run() {
                    if (UploadManager.this.mCallback != null) {
                        UploadManager.this.mCallback.onProgress(uploadFileTask, j, j2);
                    }
                }
            });
        }

        @Override // com.baidu.searchbox.ugc.upload.UploadFileTask.TaskCallback
        public void onStart(final UploadFileTask uploadFileTask) {
            UploadManager.this.mHandler.post(new Runnable() { // from class: com.baidu.searchbox.ugc.upload.UploadManager.2.2
                @Override // java.lang.Runnable
                public void run() {
                    if (UploadManager.this.mCallback != null) {
                        UploadManager.this.mCallback.onStart(uploadFileTask);
                    }
                }
            });
        }

        @Override // com.baidu.searchbox.ugc.upload.UploadFileTask.TaskCallback
        public void onSuccess(final UploadFileTask uploadFileTask) {
            UploadManager.this.mHandler.post(new Runnable() { // from class: com.baidu.searchbox.ugc.upload.UploadManager.2.3
                @Override // java.lang.Runnable
                public void run() {
                    if (UploadManager.this.mCallback != null) {
                        UploadManager.this.mCallback.onSuccess(uploadFileTask);
                    }
                }
            });
        }

        @Override // com.baidu.searchbox.ugc.upload.UploadFileTask.TaskCallback
        public void onFailed(final UploadFileTask uploadFileTask) {
            UploadManager.this.mHandler.post(new Runnable() { // from class: com.baidu.searchbox.ugc.upload.UploadManager.2.4
                @Override // java.lang.Runnable
                public void run() {
                    if (UploadManager.this.mCallback != null) {
                        UploadManager.this.mCallback.onFailed(uploadFileTask);
                    }
                }
            });
        }
    };
    private Handler mHandler = new Handler(Looper.getMainLooper());

    /* loaded from: classes19.dex */
    public interface UploadCallback extends UploadFileTask.TaskCallback {
        void onError(String str);
    }

    public static UploadManager getInstance() {
        if (instance == null) {
            synchronized (UploadManager.class) {
                if (instance == null) {
                    instance = new UploadManager();
                }
            }
        }
        return instance;
    }

    private UploadManager() {
    }

    public void startAll(List<UploadFileTask> list, int i, String str) {
        if (list != null && list.size() != 0) {
            this.mSourceType = i;
            this.mFrom = str;
            ArrayList arrayList = new ArrayList(list);
            if (this.sThreadPool == null) {
                this.sThreadPool = new ThreadPoolExecutor(1, 1, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.baidu.searchbox.ugc.upload.UploadManager.1
                    private final AtomicInteger mCount = new AtomicInteger(1);

                    @Override // java.util.concurrent.ThreadFactory
                    public Thread newThread(Runnable runnable) {
                        return new Thread(runnable, "UploadManager #" + this.mCount.getAndIncrement());
                    }
                });
                this.sThreadPool.allowCoreThreadTimeOut(true);
            }
            stopAll();
            startProcessTasks(arrayList);
        }
    }

    private void startProcessTasks(List<UploadFileTask> list) {
        if (list != null && list.size() != 0) {
            this.mCurrCallable = new ProcessTasksCallable(list);
            if (this.sThreadPool != null) {
                this.mCurrCallable.setFuture(this.sThreadPool.submit(this.mCurrCallable));
            }
        }
    }

    public void stopAll() {
        if (this.mCurrCallable != null) {
            this.mCurrCallable.cancel();
        }
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public void release() {
        this.mCallback = null;
        this.mHandler.removeCallbacksAndMessages(null);
        stopAll();
        FileUtils.deleteAllFiles(FileUtils.getUploadCacheDir());
        if (this.sThreadPool != null) {
            this.sThreadPool.shutdownNow();
        }
        this.sThreadPool = null;
    }

    public void setUploadCallback(UploadCallback uploadCallback) {
        this.mCallback = uploadCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes19.dex */
    public class ProcessTasksCallable implements Callable<Void> {
        private Future mFuture;
        private List<UploadFileTask> mTasks;

        public void setFuture(Future future) {
            this.mFuture = future;
        }

        public void cancel() {
            if (this.mFuture != null) {
                this.mFuture.cancel(true);
            }
            if (this.mTasks != null && this.mTasks.size() != 0) {
                for (UploadFileTask uploadFileTask : this.mTasks) {
                    uploadFileTask.stop();
                }
            }
        }

        public boolean isCanceled() {
            if (this.mFuture != null) {
                return this.mFuture.isCancelled();
            }
            return false;
        }

        public ProcessTasksCallable(List<UploadFileTask> list) {
            this.mTasks = list;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        public Void call() {
            if (UploadManager.DEBUG) {
                Log.e(UploadManager.TAG, "处理线程开始执行");
            }
            if (this.mTasks != null && this.mTasks.size() != 0) {
                Iterator<UploadFileTask> it = this.mTasks.iterator();
                while (true) {
                    if (it.hasNext()) {
                        UploadFileTask next = it.next();
                        if (!isCanceled()) {
                            next.setCallback(UploadManager.this.mTaskCallback);
                            if (!next.handleCompress()) {
                                notifyError(null);
                                break;
                            }
                        } else {
                            break;
                        }
                    } else if (!isCanceled()) {
                        if (this.mTasks.get(0) instanceof UploadVideoTask) {
                            uploadVideo(this.mTasks, UploadManager.this.mSourceType, UploadManager.this.mFrom);
                        } else {
                            uploadImage(this.mTasks, UploadManager.this.mSourceType, UploadManager.this.mFrom);
                        }
                    }
                }
            }
            return null;
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x004c  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void uploadVideo(List<UploadFileTask> list, int i, String str) {
            ArrayList arrayList = new ArrayList();
            for (UploadFileTask uploadFileTask : list) {
                arrayList.add(uploadFileTask.getCompressFileName());
            }
            HttpRequestTokenModule.STSInfo requestToken = new HttpRequestTokenModule().requestToken(arrayList, true, i, str);
            if (requestToken == null) {
                notifyError(null);
                return;
            }
            VodClient createVodClient = createVodClient(requestToken.ak, requestToken.sk, requestToken.token);
            BosClient createBosClient = createBosClient(requestToken.ak, requestToken.sk, requestToken.token);
            for (UploadFileTask uploadFileTask2 : list) {
                uploadFileTask2.setVodClient(createVodClient);
                uploadFileTask2.setBosClient(createBosClient);
                if (isCanceled() || !uploadFileTask2.startSync()) {
                    return;
                }
                while (r3.hasNext()) {
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0041  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void uploadImage(List<UploadFileTask> list, int i, String str) {
            ArrayList arrayList = new ArrayList();
            for (UploadFileTask uploadFileTask : list) {
                arrayList.add(uploadFileTask.getCompressFileName());
            }
            HttpRequestTokenModule.STSInfo requestPublisherToken = UploadProviderManager.getUploadProvider().requestPublisherToken(arrayList, false, i, str);
            if (requestPublisherToken == null) {
                notifyError(null);
                return;
            }
            BosClient createBosClient = createBosClient(requestPublisherToken.ak, requestPublisherToken.sk, requestPublisherToken.token);
            for (UploadFileTask uploadFileTask2 : list) {
                HttpRequestTokenModule.STSInfo.BosInfo bosInfo = requestPublisherToken.map.get(uploadFileTask2.getCompressFileName());
                uploadFileTask2.setUrl(bosInfo.url);
                uploadFileTask2.setBosKey(bosInfo.bosobject);
                uploadFileTask2.setBucketName(requestPublisherToken.bucket);
                uploadFileTask2.setBosClient(createBosClient);
                if (isCanceled() || !uploadFileTask2.startSync()) {
                    return;
                }
                while (r4.hasNext()) {
                }
            }
        }

        private void notifyError(final String str) {
            UploadManager.this.mHandler.post(new Runnable() { // from class: com.baidu.searchbox.ugc.upload.UploadManager.ProcessTasksCallable.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!ProcessTasksCallable.this.isCanceled() && UploadManager.this.mCallback != null) {
                        UploadManager.this.mCallback.onError(str);
                    }
                }
            });
        }

        public BosClient createBosClient(String str, String str2, String str3) {
            BosClientConfiguration bosClientConfiguration = new BosClientConfiguration();
            bosClientConfiguration.setCredentials(new DefaultBceSessionCredentials(str, str2, str3));
            bosClientConfiguration.setEndpoint(UploadManager.BOS_ENDPOINT);
            bosClientConfiguration.setRetryPolicy(new DefaultRetryPolicy(2, IMConnection.RETRY_DELAY_TIMES));
            return new BosClient(bosClientConfiguration);
        }

        public VodClient createVodClient(String str, String str2, String str3) {
            DefaultBceSessionCredentials defaultBceSessionCredentials = new DefaultBceSessionCredentials(str, str2, str3);
            BceClientConfiguration bceClientConfiguration = new BceClientConfiguration();
            bceClientConfiguration.withCredentials(defaultBceSessionCredentials);
            bceClientConfiguration.setEndpoint(UploadManager.VOD_ENDPIONT);
            return new VodClient(bceClientConfiguration);
        }
    }
}
