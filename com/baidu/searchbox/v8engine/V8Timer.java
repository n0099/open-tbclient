package com.baidu.searchbox.v8engine;

import android.os.Handler;
import com.baidu.searchbox.v8engine.V8Engine;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeSet;
@NotProguard
/* loaded from: classes4.dex */
public class V8Timer implements V8Engine.V8StatusListener {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final boolean DEBUG = false;
    public static final String TAG = "V8Timer";
    public Handler mUiHandler = null;
    public V8Engine mV8Engine = null;
    public boolean mInitialized = false;
    public volatile boolean mDestroyed = false;
    public LinkedHashMap<Long, TimeTask> mActiveTimer = new LinkedHashMap<>(30);

    public native void nativeRemoveTimer(long j);

    public native void nativeTimeOutCallback(long j);

    /* loaded from: classes4.dex */
    public class TimeTask implements Runnable {
        public volatile boolean mRemoved;
        public boolean mRepeat;
        public long mStart = System.currentTimeMillis();
        public long mTimeOut;
        public long mTimerID;
        public long mTimerPtr;

        public TimeTask(long j, long j2, long j3, boolean z) {
            this.mRemoved = false;
            this.mTimerID = j;
            this.mTimerPtr = j2;
            this.mTimeOut = j3;
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
                synchronized (V8Timer.this) {
                    if (V8Timer.this.mV8Engine == null) {
                        return;
                    }
                    V8Timer.this.mV8Engine.postOnJSThread(new Runnable() { // from class: com.baidu.searchbox.v8engine.V8Timer.TimeTask.1
                        public static final /* synthetic */ boolean $assertionsDisabled = false;

                        @Override // java.lang.Runnable
                        public void run() {
                            if (!TimeTask.this.mRemoved && !V8Timer.this.mDestroyed && !V8Timer.this.mV8Engine.isPaused()) {
                                TimeTask timeTask = TimeTask.this;
                                V8Timer.this.nativeTimeOutCallback(timeTask.mTimerPtr);
                                TimeTask timeTask2 = TimeTask.this;
                                if (timeTask2.mRepeat) {
                                    Handler handler = V8Timer.this.mUiHandler;
                                    TimeTask timeTask3 = TimeTask.this;
                                    handler.postDelayed(timeTask3, timeTask3.mTimeOut);
                                    return;
                                }
                                V8Timer.this.removeTimeTask(timeTask2.mTimerID, timeTask2.mTimerPtr);
                            }
                        }
                    });
                }
            }
        }

        public String toString() {
            return "TimeTask{mTimerID=" + this.mTimerID + ", mTimerPtr=" + this.mTimerPtr + ", mTimeOut=" + this.mTimeOut + ", mStart=" + this.mStart + ", mRepeat=" + this.mRepeat + ", mRemoved=" + this.mRemoved + '}';
        }
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
    public synchronized void onReady() {
    }

    public synchronized void addTimeTask(long j, long j2, long j3, boolean z) {
        TimeTask timeTask = new TimeTask(j, j2, j3, z);
        this.mActiveTimer.put(Long.valueOf(j), timeTask);
        if (this.mV8Engine.isPaused()) {
            return;
        }
        this.mUiHandler.postDelayed(timeTask, j3);
    }

    public void destroy() {
        this.mDestroyed = true;
        for (Long l : new TreeSet(this.mActiveTimer.keySet())) {
            TimeTask timeTask = this.mActiveTimer.get(l);
            if (timeTask != null) {
                removeTimeTask(timeTask.mTimerID, timeTask.mTimerPtr);
            }
        }
        synchronized (this) {
            this.mV8Engine = null;
        }
        this.mActiveTimer.clear();
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

    public void initialize(V8Engine v8Engine, Handler handler) {
        this.mV8Engine = v8Engine;
        v8Engine.addStatusHandler(this);
        this.mUiHandler = handler;
        this.mInitialized = true;
    }

    public synchronized void removeTimeTask(long j, long j2) {
        TimeTask timeTask = this.mActiveTimer.get(Long.valueOf(j));
        if (timeTask == null) {
            return;
        }
        timeTask.mRemoved = true;
        this.mUiHandler.removeCallbacks(timeTask);
        this.mActiveTimer.remove(Long.valueOf(j));
        nativeRemoveTimer(j2);
    }
}
