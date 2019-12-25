package com.baidu.searchbox.ugc.upload;

import android.animation.ValueAnimator;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.io.Closeables;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.ugc.utils.FileHelper;
import com.baidubce.BceServiceException;
import com.baidubce.services.bos.BosClient;
import com.baidubce.services.bos.callback.BosProgressCallback;
import com.baidubce.services.bos.model.ObjectMetadata;
import com.baidubce.services.bos.model.PutObjectRequest;
import com.baidubce.services.vod.VodClient;
import java.io.InputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes11.dex */
public class UploadFileTask implements Runnable {
    public static final int ERROR_COMPRESS = 3;
    public static final int ERROR_NETWORK = 2;
    public static final int ERROR_NO = 0;
    public static final int ERROR_SYSTEM_TIME = 4;
    public static final int ERROR_UNKNOWN = 1;
    public static final int STATUS_FAILED = 5;
    public static final int STATUS_READY = 1;
    public static final int STATUS_STOP = 3;
    public static final int STATUS_SUCCESS = 4;
    public static final int STATUS_UPLOADING = 2;
    public int height;
    protected BosClient mBosClient;
    protected String mBosKey;
    protected String mBucketName;
    protected TaskCallback mCallback;
    protected String mCompressFileName;
    protected String mFileName;
    protected volatile boolean mIsCompressSuccess;
    protected boolean mIsProgressStart;
    protected ObjectMetadata mObjectMetadata;
    protected ValueAnimator mProgressAnimator;
    protected int mProgressValue;
    protected String mUrl;
    protected VodClient mVodClient;
    public long size;
    public int width;
    private static final String TAG = UploadFileTask.class.getSimpleName();
    public static final boolean DEBUG = AppConfig.isDebug();
    protected volatile int mStatus = 1;
    protected volatile int mErrorCode = 0;
    protected int mProgressMax = 100;
    protected int mProgressAnimatorMax = 90;
    protected Handler mHandler = new Handler(Looper.getMainLooper());

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes11.dex */
    public @interface ErrorCode {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes11.dex */
    public @interface Status {
    }

    /* loaded from: classes11.dex */
    public interface TaskCallback {
        void onFailed(UploadFileTask uploadFileTask);

        void onProgress(UploadFileTask uploadFileTask, long j, long j2);

        void onStart(UploadFileTask uploadFileTask);

        void onSuccess(UploadFileTask uploadFileTask);
    }

    public synchronized void setStatus(int i) {
        this.mStatus = i;
    }

    public synchronized int getStatus() {
        return this.mStatus;
    }

    public String getFileName() {
        return this.mFileName;
    }

    public void setFileName(String str) {
        this.mFileName = str;
    }

    public String getCompressFileName() {
        return this.mCompressFileName;
    }

    public void setCompressFileName(String str) {
        this.mCompressFileName = str;
    }

    public boolean isCompressSuccess() {
        return this.mIsCompressSuccess;
    }

    public void setCompressSuccess(boolean z) {
        this.mIsCompressSuccess = z;
    }

    public void setBosClient(BosClient bosClient) {
        this.mBosClient = bosClient;
    }

    public void setVodClient(VodClient vodClient) {
        this.mVodClient = vodClient;
    }

    public void setObjectMetadata(ObjectMetadata objectMetadata) {
        this.mObjectMetadata = objectMetadata;
    }

    public BosClient getBosClient() {
        return this.mBosClient;
    }

    public String getBucketName() {
        return this.mBucketName;
    }

    public void setBucketName(String str) {
        this.mBucketName = str;
    }

    public String getBosKey() {
        return this.mBosKey;
    }

    public void setBosKey(String str) {
        this.mBosKey = str;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public void setUrl(String str) {
        this.mUrl = str;
    }

    public boolean startSync() {
        setStatus(2);
        run();
        return getStatus() == 4;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean uploadFile = uploadFile(this.mFileName);
        setStatus(uploadFile ? 4 : 5);
        notifySuccessOrFailed(uploadFile);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean handleCompress() {
        return true;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    /* JADX INFO: Access modifiers changed from: protected */
    public boolean uploadFile(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mErrorCode = 1;
            return false;
        }
        InputStream inputStream = FileHelper.getInputStream(str);
        if (inputStream != null) {
            try {
                try {
                    PutObjectRequest putObjectRequest = new PutObjectRequest(this.mBucketName, this.mBosKey, inputStream);
                    if (this.mObjectMetadata != null) {
                        putObjectRequest.setObjectMetadata(this.mObjectMetadata);
                    }
                    putObjectRequest.setProgressCallback(new BosProgressCallback<PutObjectRequest>() { // from class: com.baidu.searchbox.ugc.upload.UploadFileTask.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidubce.services.bos.callback.BosProgressCallback, com.baidubce.callback.BceProgressCallback
                        public void onProgress(PutObjectRequest putObjectRequest2, long j, long j2) {
                            UploadFileTask.this.mCallback.onProgress(UploadFileTask.this, j, j2);
                        }
                    });
                    this.mBosClient.putObject(putObjectRequest);
                    this.mErrorCode = 0;
                    if (inputStream != null) {
                        Closeables.closeSafely(inputStream);
                    }
                    return true;
                } catch (Exception e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                    if (e instanceof BceServiceException) {
                        String errorCode = ((BceServiceException) e).getErrorCode();
                        if (!TextUtils.isEmpty(errorCode) && TextUtils.equals(errorCode, "RequestTimeTooSkewed")) {
                            this.mErrorCode = 4;
                        }
                    }
                    if (inputStream != null) {
                        Closeables.closeSafely(inputStream);
                    }
                }
            } catch (Throwable th) {
                if (inputStream != null) {
                    Closeables.closeSafely(inputStream);
                }
                throw th;
            }
        }
        this.mErrorCode = 1;
        return false;
    }

    public void stop() {
        if (getStatus() != 4 && getStatus() != 3) {
            stopPlayProgress();
            setStatus(3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifySuccessOrFailed(boolean z) {
        if (getStatus() != 3) {
            if (z) {
                if (this.mCallback != null) {
                    this.mCallback.onSuccess(this);
                }
            } else if (this.mCallback != null) {
                this.mCallback.onFailed(this);
            }
        }
    }

    public void setCallback(TaskCallback taskCallback) {
        this.mCallback = taskCallback;
    }

    public void startPlayProgress(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.searchbox.ugc.upload.UploadFileTask.2
            @Override // java.lang.Runnable
            public void run() {
                if (UploadFileTask.DEBUG) {
                    Log.d(UploadFileTask.TAG, "startPlayProgress");
                }
                if (!UploadFileTask.this.mIsProgressStart) {
                    UploadFileTask.this.mIsProgressStart = true;
                    UploadFileTask.this.mProgressValue = 0;
                    if (UploadFileTask.this.mCallback != null) {
                        UploadFileTask.this.mCallback.onProgress(UploadFileTask.this, UploadFileTask.this.mProgressValue, UploadFileTask.this.mProgressMax);
                    }
                    UploadFileTask.this.mProgressAnimator = ValueAnimator.ofInt(0, UploadFileTask.this.mProgressAnimatorMax);
                    UploadFileTask.this.mProgressAnimator.setDuration(i);
                    UploadFileTask.this.mProgressAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.searchbox.ugc.upload.UploadFileTask.2.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            int intValue;
                            if (UploadFileTask.this.mIsProgressStart && UploadFileTask.this.mProgressValue != (intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue())) {
                                UploadFileTask.this.mProgressValue = intValue;
                                if (UploadFileTask.DEBUG) {
                                    Log.d(UploadFileTask.TAG, Thread.currentThread().getName() + " mProgressValue=" + UploadFileTask.this.mProgressValue);
                                }
                                if (UploadFileTask.this.mCallback != null) {
                                    UploadFileTask.this.mCallback.onProgress(UploadFileTask.this, UploadFileTask.this.mProgressValue, UploadFileTask.this.mProgressMax);
                                }
                            }
                        }
                    });
                    UploadFileTask.this.mProgressAnimator.start();
                }
            }
        });
    }

    public void stopPlayProgress() {
        this.mHandler.post(new Runnable() { // from class: com.baidu.searchbox.ugc.upload.UploadFileTask.3
            @Override // java.lang.Runnable
            public void run() {
                if (UploadFileTask.DEBUG) {
                    Log.d(UploadFileTask.TAG, "stopPlayProgress");
                }
                UploadFileTask.this.mIsProgressStart = false;
                if (UploadFileTask.this.mProgressAnimator != null) {
                    UploadFileTask.this.mProgressAnimator.cancel();
                }
            }
        });
    }

    protected void finishPlayProgress() {
        this.mHandler.post(new Runnable() { // from class: com.baidu.searchbox.ugc.upload.UploadFileTask.4
            @Override // java.lang.Runnable
            public void run() {
                if (UploadFileTask.DEBUG) {
                    Log.d(UploadFileTask.TAG, "finishPlayProgress");
                }
                if (UploadFileTask.this.mProgressAnimator != null) {
                    UploadFileTask.this.mProgressAnimator.cancel();
                }
                UploadFileTask.this.mIsProgressStart = false;
                UploadFileTask.this.mProgressValue = UploadFileTask.this.mProgressMax;
                if (UploadFileTask.this.mCallback != null) {
                    UploadFileTask.this.mCallback.onProgress(UploadFileTask.this, UploadFileTask.this.mProgressValue, UploadFileTask.this.mProgressMax);
                }
            }
        });
    }
}
