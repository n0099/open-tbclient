package com.baidu.searchbox.ng.ai.apps.core.aps;

import com.baidu.searchbox.ng.ai.apps.util.AiAppExecutorUtils;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes2.dex */
public final class AiAppsInfoLatch {
    private static final boolean DEBUG = false;
    private static final int OPERATION_COUNT = 2;
    private static final String OPERATION_NAME = "save aiapps DB";
    private static final String TAG = "AiAppsInfoLatch";
    private Runnable mFinalRunnable;
    private boolean mIsCancel = false;
    private Runnable mWaitRunnable = new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.core.aps.AiAppsInfoLatch.1
        @Override // java.lang.Runnable
        public void run() {
            try {
                AiAppsInfoLatch.this.mCountDownLatch.await();
                if (!AiAppsInfoLatch.this.mIsCancel) {
                    AiAppExecutorUtils.postOnSerial(AiAppsInfoLatch.this.mFinalRunnable, AiAppsInfoLatch.OPERATION_NAME);
                }
            } catch (InterruptedException e) {
            }
        }
    };
    private CountDownLatch mCountDownLatch = new CountDownLatch(2);

    public AiAppsInfoLatch(Runnable runnable) {
        this.mFinalRunnable = runnable;
        AiAppExecutorUtils.postOnSerial(this.mWaitRunnable, "aiapps await getInfo");
    }

    public void packageDownloadSuccess() {
        this.mCountDownLatch.countDown();
    }

    public void packageDownloadFailed() {
        this.mCountDownLatch.countDown();
    }

    public void iconDownloadFinish() {
        this.mCountDownLatch.countDown();
    }

    public void cancel() {
        this.mIsCancel = true;
        for (int i = 0; i < this.mCountDownLatch.getCount(); i++) {
            this.mCountDownLatch.countDown();
        }
    }
}
