package com.baidu.android.util.time;

import com.baidu.android.util.time.CountDownTimer;
@Deprecated
/* loaded from: classes.dex */
public class UniversalCountDownTimer {
    public CountDownTimer mCountDownTimer;

    /* loaded from: classes.dex */
    public static abstract class StatusListener {
        public void onCancel() {
        }

        public void onFinish() {
        }

        public void onPause() {
        }

        public void onResume() {
        }

        public void onStart() {
        }

        public void onTick(long j) {
        }
    }

    public UniversalCountDownTimer(long j, long j2) {
        this.mCountDownTimer = new CountDownTimer(j, j2);
    }

    public final synchronized void cancel() {
        this.mCountDownTimer.cancel();
    }

    public final synchronized void pause() {
        this.mCountDownTimer.pause();
    }

    public final synchronized void resume() {
        this.mCountDownTimer.resume();
    }

    public void setCountDownMillis(long j) {
        this.mCountDownTimer.setCountDownMillis(j);
    }

    public UniversalCountDownTimer setStausListener(final StatusListener statusListener) {
        if (statusListener == null) {
            return this;
        }
        this.mCountDownTimer.setStatusListener(new CountDownTimer.StatusListener() { // from class: com.baidu.android.util.time.UniversalCountDownTimer.1
            @Override // com.baidu.android.util.time.CountDownTimer.StatusListener
            public void onCancel() {
                super.onCancel();
                statusListener.onCancel();
            }

            @Override // com.baidu.android.util.time.CountDownTimer.StatusListener
            public void onFinish() {
                super.onFinish();
                statusListener.onFinish();
            }

            @Override // com.baidu.android.util.time.CountDownTimer.StatusListener
            public void onPause() {
                super.onPause();
                statusListener.onPause();
            }

            @Override // com.baidu.android.util.time.CountDownTimer.StatusListener
            public void onResume() {
                super.onResume();
                statusListener.onResume();
            }

            @Override // com.baidu.android.util.time.CountDownTimer.StatusListener
            public void onStart() {
                super.onStart();
                statusListener.onStart();
            }

            @Override // com.baidu.android.util.time.CountDownTimer.StatusListener
            public void onTick(long j) {
                super.onTick(j);
                statusListener.onTick(j);
            }
        });
        return this;
    }

    public final synchronized UniversalCountDownTimer start() {
        this.mCountDownTimer.start();
        return this;
    }
}
