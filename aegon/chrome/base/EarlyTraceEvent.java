package aegon.chrome.base;

import aegon.chrome.base.annotations.CalledByNative;
import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class EarlyTraceEvent {
    public static List<AsyncEvent> sAsyncEvents;
    public static boolean sCachedBackgroundStartupTracingFlag;
    public static List<Event> sCompletedEvents;
    public static final Object sLock = new Object();
    public static List<String> sPendingAsyncEvents;
    public static Map<String, Event> sPendingEventByKey;
    public static volatile int sState;

    /* loaded from: classes.dex */
    public static final class AsyncEvent {
        public final long mId;
        public final boolean mIsStart;
        public final String mName;
        public final long mTimestampNanos;
    }

    /* loaded from: classes.dex */
    public static final class Event {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        public long mEndThreadTimeMillis;
        public long mEndTimeNanos;
        public final String mName;
        public final int mThreadId = Process.myTid();
        public final long mBeginTimeNanos = elapsedRealtimeNanos();
        public final long mBeginThreadTimeMillis = SystemClock.currentThreadTimeMillis();

        public Event(String str) {
            this.mName = str;
        }

        @SuppressLint({"NewApi"})
        public static long elapsedRealtimeNanos() {
            return Build.VERSION.SDK_INT >= 17 ? SystemClock.elapsedRealtimeNanos() : SystemClock.elapsedRealtime() * 1000000;
        }
    }

    public static void begin(String str) {
        if (enabled()) {
            Event event = new Event(str);
            synchronized (sLock) {
                if (enabled()) {
                    Map<String, Event> map = sPendingEventByKey;
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append("@");
                    sb.append(Process.myTid());
                    Event put = map.put(sb.toString(), event);
                    if (put == null) {
                        return;
                    }
                    throw new IllegalArgumentException("Multiple pending trace events can't have the same name: " + str);
                }
            }
        }
    }

    public static void disable() {
        synchronized (sLock) {
            if (enabled()) {
                sState = 2;
                maybeFinishLocked();
            }
        }
    }

    public static boolean enabled() {
        return sState == 1;
    }

    public static void end(String str) {
        if (isActive()) {
            synchronized (sLock) {
                if (isActive()) {
                    Map<String, Event> map = sPendingEventByKey;
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append("@");
                    sb.append(Process.myTid());
                    Event remove = map.remove(sb.toString());
                    if (remove == null) {
                        return;
                    }
                    if (!Event.$assertionsDisabled && remove.mEndTimeNanos != 0) {
                        throw new AssertionError();
                    }
                    if (!Event.$assertionsDisabled && remove.mEndThreadTimeMillis != 0) {
                        throw new AssertionError();
                    }
                    remove.mEndTimeNanos = Event.elapsedRealtimeNanos();
                    remove.mEndThreadTimeMillis = SystemClock.currentThreadTimeMillis();
                    sCompletedEvents.add(remove);
                    if (sState == 2) {
                        maybeFinishLocked();
                    }
                }
            }
        }
    }

    @CalledByNative
    public static boolean getBackgroundStartupTracingFlag() {
        return sCachedBackgroundStartupTracingFlag;
    }

    public static long getOffsetNanos() {
        return (TimeUtils.nativeGetTimeTicksNowUs() * 1000) - Event.elapsedRealtimeNanos();
    }

    public static boolean isActive() {
        int i = sState;
        return i == 1 || i == 2;
    }

    public static void maybeFinishLocked() {
        if (!sCompletedEvents.isEmpty()) {
            List<Event> list = sCompletedEvents;
            long offsetNanos = getOffsetNanos();
            for (Event event : list) {
                nativeRecordEarlyEvent(event.mName, event.mBeginTimeNanos + offsetNanos, event.mEndTimeNanos + offsetNanos, event.mThreadId, event.mEndThreadTimeMillis - event.mBeginThreadTimeMillis);
            }
            sCompletedEvents.clear();
        }
        if (!sAsyncEvents.isEmpty()) {
            List<AsyncEvent> list2 = sAsyncEvents;
            long offsetNanos2 = getOffsetNanos();
            for (AsyncEvent asyncEvent : list2) {
                if (asyncEvent.mIsStart) {
                    nativeRecordEarlyStartAsyncEvent(asyncEvent.mName, asyncEvent.mId, asyncEvent.mTimestampNanos + offsetNanos2);
                } else {
                    nativeRecordEarlyFinishAsyncEvent(asyncEvent.mName, asyncEvent.mId, asyncEvent.mTimestampNanos + offsetNanos2);
                }
            }
            sAsyncEvents.clear();
        }
        if (sPendingEventByKey.isEmpty() && sPendingAsyncEvents.isEmpty()) {
            sState = 3;
            sPendingEventByKey = null;
            sCompletedEvents = null;
            sPendingAsyncEvents = null;
            sAsyncEvents = null;
        }
    }

    public static native void nativeRecordEarlyEvent(String str, long j, long j2, int i, long j3);

    public static native void nativeRecordEarlyFinishAsyncEvent(String str, long j, long j2);

    public static native void nativeRecordEarlyStartAsyncEvent(String str, long j, long j2);

    @CalledByNative
    public static void setBackgroundStartupTracingFlag(boolean z) {
        ContextUtils.getAppSharedPreferences().edit().putBoolean("bg_startup_tracing", z).apply();
    }
}
