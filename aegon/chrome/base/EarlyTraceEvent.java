package aegon.chrome.base;

import aegon.chrome.base.annotations.CalledByNative;
import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.net.tnc.TNCManager;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class EarlyTraceEvent {
    public static /* synthetic */ Interceptable $ic;
    public static List<AsyncEvent> sAsyncEvents;
    public static boolean sCachedBackgroundStartupTracingFlag;
    public static List<Event> sCompletedEvents;
    public static final Object sLock;
    public static List<String> sPendingAsyncEvents;
    public static Map<String, Event> sPendingEventByKey;
    public static volatile int sState;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static final class AsyncEvent {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final long mId;
        public final boolean mIsStart;
        public final String mName;
        public final long mTimestampNanos;
    }

    /* loaded from: classes.dex */
    public static final class Event {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final long mBeginThreadTimeMillis;
        public final long mBeginTimeNanos;
        public long mEndThreadTimeMillis;
        public long mEndTimeNanos;
        public final String mName;
        public final int mThreadId;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-142480977, "Laegon/chrome/base/EarlyTraceEvent$Event;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-142480977, "Laegon/chrome/base/EarlyTraceEvent$Event;");
            }
        }

        public Event(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mName = str;
            this.mThreadId = Process.myTid();
            this.mBeginTimeNanos = elapsedRealtimeNanos();
            this.mBeginThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        }

        @SuppressLint({"NewApi"})
        public static long elapsedRealtimeNanos() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? Build.VERSION.SDK_INT >= 17 ? SystemClock.elapsedRealtimeNanos() : SystemClock.elapsedRealtime() * 1000000 : invokeV.longValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1167832901, "Laegon/chrome/base/EarlyTraceEvent;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1167832901, "Laegon/chrome/base/EarlyTraceEvent;");
                return;
            }
        }
        sLock = new Object();
    }

    public EarlyTraceEvent() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void begin(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, str) == null) && enabled()) {
            Event event = new Event(str);
            synchronized (sLock) {
                if (enabled()) {
                    Map<String, Event> map = sPendingEventByKey;
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append(TNCManager.TNC_PROBE_HEADER_SECEPTOR);
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            synchronized (sLock) {
                if (enabled()) {
                    sState = 2;
                    maybeFinishLocked();
                }
            }
        }
    }

    public static boolean enabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) ? sState == 1 : invokeV.booleanValue;
    }

    public static void end(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str) == null) && isActive()) {
            synchronized (sLock) {
                if (isActive()) {
                    Map<String, Event> map = sPendingEventByKey;
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append(TNCManager.TNC_PROBE_HEADER_SECEPTOR);
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
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? sCachedBackgroundStartupTracingFlag : invokeV.booleanValue;
    }

    public static long getOffsetNanos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? (TimeUtils.nativeGetTimeTicksNowUs() * 1000) - Event.elapsedRealtimeNanos() : invokeV.longValue;
    }

    public static boolean isActive() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            int i2 = sState;
            return i2 == 1 || i2 == 2;
        }
        return invokeV.booleanValue;
    }

    public static void maybeFinishLocked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
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
    }

    public static native void nativeRecordEarlyEvent(String str, long j, long j2, int i2, long j3);

    public static native void nativeRecordEarlyFinishAsyncEvent(String str, long j, long j2);

    public static native void nativeRecordEarlyStartAsyncEvent(String str, long j, long j2);

    @CalledByNative
    public static void setBackgroundStartupTracingFlag(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65549, null, z) == null) {
            ContextUtils.getAppSharedPreferences().edit().putBoolean("bg_startup_tracing", z).apply();
        }
    }
}
