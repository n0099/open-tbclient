package com.baidu.mobads.container.util;

import com.baidu.mobads.container.executor.BaseTask;
import com.baidu.mobads.container.executor.TaskScheduler;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public class OAdTimer {
    public static final int DELAY = 300;
    public static final int INITIALIZED = -1;
    public static final int PAUSED = 1;
    public static final int RUNNING = 0;
    public static final int STOPED = 2;
    public static String TAG = "OAdTimer";
    public EventHandler handler;
    public int interval;
    public int mCounteDown;
    public int mCurrentCount;
    public int mRepeatCount;
    public BaseTask mTockFuture;
    public AtomicInteger state;

    /* loaded from: classes2.dex */
    public interface EventHandler {
        void onTimer(int i2);

        void onTimerComplete();
    }

    public OAdTimer(int i2) {
        this(i2, 300);
    }

    public static /* synthetic */ int access$410(OAdTimer oAdTimer) {
        int i2 = oAdTimer.mCounteDown;
        oAdTimer.mCounteDown = i2 - 1;
        return i2;
    }

    public int getCurrentCount() {
        return this.mCurrentCount;
    }

    public int getRepeatCount() {
        return this.mRepeatCount;
    }

    public void pause() {
        RemoteXAdLogger.getInstance().d(TAG, "pause");
        this.state.set(1);
    }

    public void reset() {
        RemoteXAdLogger.getInstance().d(TAG, "reset");
        this.state.set(-1);
        this.mCounteDown = this.mRepeatCount;
    }

    public void resume() {
        RemoteXAdLogger.getInstance().d(TAG, "resume");
        this.state.set(0);
    }

    public void setEventHandler(EventHandler eventHandler) {
        this.handler = eventHandler;
    }

    public void start() {
        RemoteXAdLogger.getInstance().d(TAG, IntentConfig.START);
        this.state.set(0);
        try {
            this.mTockFuture = new BaseTask() { // from class: com.baidu.mobads.container.util.OAdTimer.1
                @Override // com.baidu.mobads.container.executor.BaseTask
                public Object doInBackground() {
                    if (OAdTimer.this.state.get() != 0) {
                        return null;
                    }
                    if (OAdTimer.this.handler != null) {
                        OAdTimer oAdTimer = OAdTimer.this;
                        oAdTimer.mCurrentCount = oAdTimer.mRepeatCount - OAdTimer.this.mCounteDown;
                        try {
                            OAdTimer.this.handler.onTimer(OAdTimer.this.mCurrentCount);
                        } catch (Throwable unused) {
                        }
                    }
                    if (OAdTimer.this.mCounteDown <= 0) {
                        if (OAdTimer.this.handler != null) {
                            try {
                                OAdTimer.this.handler.onTimerComplete();
                            } catch (Throwable unused2) {
                            }
                        }
                        OAdTimer.this.stop();
                    } else {
                        OAdTimer.access$410(OAdTimer.this);
                    }
                    return null;
                }
            };
            TaskScheduler.getInstance().submitAtFixedRate(this.mTockFuture, 0L, this.interval, TimeUnit.MILLISECONDS);
        } catch (Throwable unused) {
        }
    }

    public void stop() {
        try {
            RemoteXAdLogger.getInstance().d(TAG, IntentConfig.STOP);
            this.state.set(2);
            synchronized (this) {
                if (this.mTockFuture != null) {
                    this.mTockFuture.cancel(true);
                    this.mTockFuture = null;
                }
                if (this.handler != null) {
                    this.handler = null;
                }
            }
        } catch (Throwable unused) {
        }
    }

    public OAdTimer(int i2, int i3) {
        this.interval = 300;
        this.interval = i3;
        int i4 = i2 / i3;
        RemoteXAdLogger remoteXAdLogger = RemoteXAdLogger.getInstance();
        String str = TAG;
        remoteXAdLogger.d(str, "RendererTimer(duration=" + i4 + SmallTailInfo.EMOTION_SUFFIX);
        this.mRepeatCount = i4;
        this.mCounteDown = i4;
        this.state = new AtomicInteger(-1);
    }
}
