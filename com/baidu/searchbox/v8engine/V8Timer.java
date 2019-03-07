package com.baidu.searchbox.v8engine;

import android.os.Handler;
import com.baidu.searchbox.v8engine.V8Engine;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeSet;
@NotProguard
/* loaded from: classes2.dex */
public class V8Timer implements V8Engine.V8StatusListener {
    static final /* synthetic */ boolean $assertionsDisabled;
    static final String TAG = "V8Timer";
    private Handler mUiHandler = null;
    private V8Engine mV8Engine = null;
    private boolean mInitialized = false;
    private volatile boolean mDestroyed = false;
    private LinkedHashMap<Long, TimeTask> mActiveTimer = new LinkedHashMap<>(30);

    native void nativeRemoveTimer(long j);

    native void nativeTimeOutCallback(long j);

    static {
        $assertionsDisabled = !V8Timer.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void initialize(V8Engine v8Engine, Handler handler) {
        this.mV8Engine = v8Engine;
        this.mV8Engine.addStatusHandler(this);
        this.mUiHandler = handler;
        this.mInitialized = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void destroy() {
        this.mDestroyed = true;
        for (Long l : new TreeSet(this.mActiveTimer.keySet())) {
            removeTimeTask(l.longValue());
        }
        this.mV8Engine = null;
        this.mActiveTimer.clear();
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8StatusListener
    public synchronized void onReady() {
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8StatusListener
    public synchronized void onPause() {
        if (!this.mActiveTimer.isEmpty()) {
            for (Map.Entry<Long, TimeTask> entry : this.mActiveTimer.entrySet()) {
                this.mUiHandler.removeCallbacks(entry.getValue());
            }
        }
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8StatusListener
    public synchronized void onResume() {
        if (!this.mActiveTimer.isEmpty()) {
            for (Map.Entry<Long, TimeTask> entry : this.mActiveTimer.entrySet()) {
                TimeTask value = entry.getValue();
                this.mUiHandler.postDelayed(value, value.nextFireTime());
            }
        }
    }

    public synchronized void addTimeTask(long j, long j2, boolean z) {
        if (!$assertionsDisabled && (!this.mInitialized || this.mDestroyed)) {
            throw new AssertionError();
        }
        TimeTask timeTask = new TimeTask(j, j2, z);
        this.mActiveTimer.put(Long.valueOf(j), timeTask);
        if (!this.mV8Engine.isPaused()) {
            this.mUiHandler.postDelayed(timeTask, j2);
        }
    }

    public synchronized void removeTimeTask(long j) {
        if (!$assertionsDisabled && !this.mInitialized) {
            throw new AssertionError();
        }
        TimeTask timeTask = this.mActiveTimer.get(Long.valueOf(j));
        if (timeTask != null) {
            timeTask.mRemoved = true;
            this.mUiHandler.removeCallbacks(timeTask);
            this.mActiveTimer.remove(Long.valueOf(j));
            nativeRemoveTimer(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class TimeTask implements Runnable {
        volatile boolean mRemoved;
        boolean mRepeat;
        long mStart = System.currentTimeMillis();
        long mTimeOut;
        long mTimerID;

        public TimeTask(long j, long j2, boolean z) {
            this.mRemoved = false;
            this.mTimerID = j;
            this.mTimeOut = j2;
            this.mRepeat = z;
            this.mRemoved = false;
        }

        public long nextFireTime() {
            long currentTimeMillis = this.mTimeOut - (System.currentTimeMillis() - this.mStart);
            this.mStart = System.currentTimeMillis();
            if (currentTimeMillis < 0) {
                return 0L;
            }
            return currentTimeMillis;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.mRemoved && !V8Timer.this.mDestroyed) {
                V8Timer.this.mV8Engine.postOnJSThread(new Runnable() { // from class: com.baidu.searchbox.v8engine.V8Timer.TimeTask.1
                    static final /* synthetic */ boolean $assertionsDisabled;

                    static {
                        $assertionsDisabled = !V8Timer.class.desiredAssertionStatus();
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (!TimeTask.this.mRemoved && !V8Timer.this.mDestroyed && !V8Timer.this.mV8Engine.isPaused()) {
                            if (!$assertionsDisabled && V8Timer.this.mV8Engine.isPaused()) {
                                throw new AssertionError();
                            }
                            V8Timer.this.nativeTimeOutCallback(TimeTask.this.mTimerID);
                            if (TimeTask.this.mRepeat) {
                                V8Timer.this.mUiHandler.postDelayed(TimeTask.this, TimeTask.this.mTimeOut);
                            } else {
                                V8Timer.this.removeTimeTask(TimeTask.this.mTimerID);
                            }
                        }
                    }
                });
            }
        }
    }
}
