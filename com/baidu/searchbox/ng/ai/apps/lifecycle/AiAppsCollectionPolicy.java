package com.baidu.searchbox.ng.ai.apps.lifecycle;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes2.dex */
public class AiAppsCollectionPolicy {
    public static final int COLLECT_REASON_TIME_OUT = 1;
    private static final boolean DEBUG = false;
    private static final String TAG = "AiAppsCollectionPolicy";
    private boolean mIsRegistReceiver;
    private ScreenStatusListener mScreenListener = new ScreenStatusListener(this);
    private CollectionTimer mCollectionTimer = new CollectionTimer();

    /* loaded from: classes2.dex */
    public interface RequestCollectListener {
        void onRequestedCollect(int i);
    }

    public void addScreenListener(Context context) {
        if (!this.mIsRegistReceiver) {
            this.mIsRegistReceiver = true;
            context.registerReceiver(this.mScreenListener, ScreenStatusListener.getIntentFilter());
        }
    }

    public void removeScreenListener(Context context) {
        if (this.mIsRegistReceiver) {
            this.mIsRegistReceiver = false;
            context.unregisterReceiver(this.mScreenListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onScreenStatusChanged(boolean z) {
        if (z) {
            resumeCollectionTimeOut();
        } else {
            pauseCollectionTimeOut();
        }
    }

    public void setCollectionListener(RequestCollectListener requestCollectListener) {
        this.mCollectionTimer.setCollectionListener(requestCollectListener);
    }

    public void startCollectionTimeOut() {
        this.mCollectionTimer.startTimer();
    }

    private void resumeCollectionTimeOut() {
        this.mCollectionTimer.resumeTimer();
    }

    private void pauseCollectionTimeOut() {
        this.mCollectionTimer.pauseTimer();
    }

    public void stopCollectionTimeOut() {
        this.mCollectionTimer.stopTimer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class CollectionTimer {
        private static final int PERIOD_MS = 1000;
        private static final int STATUS_IDLE = 0;
        private static final int STATUS_PAUSED = 4;
        private static final int STATUS_RESUMED = 3;
        private static final int STATUS_STARTED = 1;
        private static final int STATUS_STOPPED = 2;
        private static final int TIME_OUT_S = 300;
        private RequestCollectListener mListener;
        private Timer mTimer;
        private long mTimeOutS = 300;
        private int mStatus = 0;

        static /* synthetic */ long access$006(CollectionTimer collectionTimer) {
            long j = collectionTimer.mTimeOutS - 1;
            collectionTimer.mTimeOutS = j;
            return j;
        }

        public void startTimer() {
            this.mStatus = 1;
            resetTimeOut();
            cancelTimer();
            scheduleTimer();
        }

        public void stopTimer() {
            this.mStatus = 2;
            cancelTimer();
            resetTimeOut();
        }

        public void resumeTimer() {
            if (this.mStatus == 4) {
                this.mStatus = 3;
                cancelTimer();
                scheduleTimer();
            }
        }

        public void pauseTimer() {
            if (this.mStatus != 2) {
                this.mStatus = 4;
                cancelTimer();
            }
        }

        private synchronized void cancelTimer() {
            if (this.mTimer != null) {
                this.mTimer.cancel();
                this.mTimer.purge();
                this.mTimer = null;
            }
        }

        private void scheduleTimer() {
            this.mTimer = new Timer();
            this.mTimer.schedule(getTimerTask(), 0L, 1000L);
        }

        private void resetTimeOut() {
            this.mTimeOutS = 300L;
        }

        public void setCollectionListener(RequestCollectListener requestCollectListener) {
            this.mListener = requestCollectListener;
        }

        private TimerTask getTimerTask() {
            return new TimerTask() { // from class: com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsCollectionPolicy.CollectionTimer.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    CollectionTimer.access$006(CollectionTimer.this);
                    if (CollectionTimer.this.mTimeOutS <= 0 && CollectionTimer.this.mListener != null) {
                        CollectionTimer.this.mListener.onRequestedCollect(1);
                        CollectionTimer.this.stopTimer();
                    }
                }
            };
        }
    }

    /* loaded from: classes2.dex */
    private static class ScreenStatusListener extends BroadcastReceiver {
        private WeakReference<AiAppsCollectionPolicy> mPolicyRef;

        ScreenStatusListener(AiAppsCollectionPolicy aiAppsCollectionPolicy) {
            this.mPolicyRef = new WeakReference<>(aiAppsCollectionPolicy);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            AiAppsCollectionPolicy aiAppsCollectionPolicy;
            if (intent != null && !TextUtils.isEmpty(intent.getAction()) && (aiAppsCollectionPolicy = this.mPolicyRef.get()) != null) {
                String action = intent.getAction();
                char c = 65535;
                switch (action.hashCode()) {
                    case -2128145023:
                        if (action.equals("android.intent.action.SCREEN_OFF")) {
                            c = 1;
                            break;
                        }
                        break;
                    case -1454123155:
                        if (action.equals("android.intent.action.SCREEN_ON")) {
                            c = 0;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        aiAppsCollectionPolicy.onScreenStatusChanged(true);
                        return;
                    case 1:
                        aiAppsCollectionPolicy.onScreenStatusChanged(false);
                        return;
                    default:
                        return;
                }
            }
        }

        public static IntentFilter getIntentFilter() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            return intentFilter;
        }
    }
}
