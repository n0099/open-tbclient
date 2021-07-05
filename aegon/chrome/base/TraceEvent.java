package aegon.chrome.base;

import aegon.chrome.base.annotations.CalledByNative;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.SystemClock;
import android.util.Printer;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class TraceEvent implements AutoCloseable {
    public static /* synthetic */ Interceptable $ic;
    public static volatile boolean sEnabled;
    public transient /* synthetic */ FieldHolder $fh;
    public final String mName;

    /* renamed from: aegon.chrome.base.TraceEvent$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public static class BasicLooperMonitor implements Printer {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        public static /* synthetic */ Interceptable $ic;
        public static final int SHORTEST_LOG_PREFIX_LENGTH;
        public transient /* synthetic */ FieldHolder $fh;
        public String mCurrentTarget;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-304242413, "Laegon/chrome/base/TraceEvent$BasicLooperMonitor;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-304242413, "Laegon/chrome/base/TraceEvent$BasicLooperMonitor;");
                    return;
                }
            }
            SHORTEST_LOG_PREFIX_LENGTH = 18;
        }

        public /* synthetic */ BasicLooperMonitor(AnonymousClass1 anonymousClass1) {
        }

        public void beginHandling(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                boolean isActive = EarlyTraceEvent.isActive();
                if (TraceEvent.sEnabled || isActive) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Looper.dispatch: ");
                    int indexOf = str.indexOf(40, SHORTEST_LOG_PREFIX_LENGTH);
                    int indexOf2 = indexOf == -1 ? -1 : str.indexOf(41, indexOf);
                    sb.append(indexOf2 != -1 ? str.substring(indexOf + 1, indexOf2) : "");
                    sb.append("(");
                    int indexOf3 = str.indexOf(125, SHORTEST_LOG_PREFIX_LENGTH);
                    int indexOf4 = indexOf3 == -1 ? -1 : str.indexOf(58, indexOf3);
                    if (indexOf4 == -1) {
                        indexOf4 = str.length();
                    }
                    sb.append(indexOf3 != -1 ? str.substring(indexOf3 + 2, indexOf4) : "");
                    sb.append(SmallTailInfo.EMOTION_SUFFIX);
                    this.mCurrentTarget = sb.toString();
                    if (TraceEvent.sEnabled) {
                        TraceEvent.nativeBeginToplevel(this.mCurrentTarget);
                    } else {
                        EarlyTraceEvent.begin(this.mCurrentTarget);
                    }
                }
            }
        }

        public void endHandling(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                boolean isActive = EarlyTraceEvent.isActive();
                if ((TraceEvent.sEnabled || isActive) && this.mCurrentTarget != null) {
                    if (TraceEvent.sEnabled) {
                        TraceEvent.nativeEndToplevel(this.mCurrentTarget);
                    } else {
                        EarlyTraceEvent.end(this.mCurrentTarget);
                    }
                }
                this.mCurrentTarget = null;
            }
        }

        @Override // android.util.Printer
        public void println(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                if (str.startsWith(">")) {
                    beginHandling(str);
                } else {
                    endHandling(str);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class IdleTracingLooperMonitor extends BasicLooperMonitor implements MessageQueue.IdleHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean mIdleMonitorAttached;
        public long mLastIdleStartedAt;
        public long mLastWorkStartedAt;
        public int mNumIdlesSeen;
        public int mNumTasksSeen;
        public int mNumTasksSinceLastIdle;

        public /* synthetic */ IdleTracingLooperMonitor(AnonymousClass1 anonymousClass1) {
            super(null);
        }

        @Override // aegon.chrome.base.TraceEvent.BasicLooperMonitor
        public final void beginHandling(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (this.mNumTasksSinceLastIdle == 0) {
                    TraceEvent.end("Looper.queueIdle");
                }
                this.mLastWorkStartedAt = SystemClock.elapsedRealtime();
                syncIdleMonitoring();
                boolean isActive = EarlyTraceEvent.isActive();
                if (TraceEvent.sEnabled || isActive) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Looper.dispatch: ");
                    int indexOf = str.indexOf(40, BasicLooperMonitor.SHORTEST_LOG_PREFIX_LENGTH);
                    int indexOf2 = indexOf == -1 ? -1 : str.indexOf(41, indexOf);
                    sb.append(indexOf2 != -1 ? str.substring(indexOf + 1, indexOf2) : "");
                    sb.append("(");
                    int indexOf3 = str.indexOf(125, BasicLooperMonitor.SHORTEST_LOG_PREFIX_LENGTH);
                    int indexOf4 = indexOf3 == -1 ? -1 : str.indexOf(58, indexOf3);
                    if (indexOf4 == -1) {
                        indexOf4 = str.length();
                    }
                    sb.append(indexOf3 != -1 ? str.substring(indexOf3 + 2, indexOf4) : "");
                    sb.append(SmallTailInfo.EMOTION_SUFFIX);
                    this.mCurrentTarget = sb.toString();
                    if (TraceEvent.sEnabled) {
                        TraceEvent.nativeBeginToplevel(this.mCurrentTarget);
                    } else {
                        EarlyTraceEvent.begin(this.mCurrentTarget);
                    }
                }
            }
        }

        @Override // aegon.chrome.base.TraceEvent.BasicLooperMonitor
        public final void endHandling(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                long elapsedRealtime = SystemClock.elapsedRealtime() - this.mLastWorkStartedAt;
                if (elapsedRealtime > 16) {
                    String str2 = "observed a task that took " + elapsedRealtime + "ms: " + str;
                    if (TraceEvent.sEnabled) {
                        TraceEvent.nativeInstant("TraceEvent.LooperMonitor:IdleStats", str2);
                    }
                    android.util.Log.println(5, "TraceEvent.LooperMonitor", str2);
                }
                boolean isActive = EarlyTraceEvent.isActive();
                if ((TraceEvent.sEnabled || isActive) && this.mCurrentTarget != null) {
                    if (TraceEvent.sEnabled) {
                        TraceEvent.nativeEndToplevel(this.mCurrentTarget);
                    } else {
                        EarlyTraceEvent.end(this.mCurrentTarget);
                    }
                }
                this.mCurrentTarget = null;
                syncIdleMonitoring();
                this.mNumTasksSeen++;
                this.mNumTasksSinceLastIdle++;
            }
        }

        @Override // android.os.MessageQueue.IdleHandler
        public final boolean queueIdle() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (this.mLastIdleStartedAt == 0) {
                    this.mLastIdleStartedAt = elapsedRealtime;
                }
                long j = elapsedRealtime - this.mLastIdleStartedAt;
                this.mNumIdlesSeen++;
                TraceEvent.begin("Looper.queueIdle", this.mNumTasksSinceLastIdle + " tasks since last idle.");
                if (j > 48) {
                    String str = this.mNumTasksSeen + " tasks and " + this.mNumIdlesSeen + " idles processed so far, " + this.mNumTasksSinceLastIdle + " tasks bursted and " + j + "ms elapsed since last idle";
                    if (TraceEvent.sEnabled) {
                        TraceEvent.nativeInstant("TraceEvent.LooperMonitor:IdleStats", str);
                    }
                    android.util.Log.println(3, "TraceEvent.LooperMonitor", str);
                }
                this.mLastIdleStartedAt = elapsedRealtime;
                this.mNumTasksSinceLastIdle = 0;
                return true;
            }
            return invokeV.booleanValue;
        }

        public final void syncIdleMonitoring() {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                if (TraceEvent.sEnabled && !this.mIdleMonitorAttached) {
                    this.mLastIdleStartedAt = SystemClock.elapsedRealtime();
                    Looper.myQueue().addIdleHandler(this);
                    this.mIdleMonitorAttached = true;
                    str = "attached idle handler";
                } else if (!this.mIdleMonitorAttached || TraceEvent.sEnabled) {
                    return;
                } else {
                    Looper.myQueue().removeIdleHandler(this);
                    this.mIdleMonitorAttached = false;
                    str = "detached idle handler";
                }
                android.util.Log.v("TraceEvent.LooperMonitor", str);
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class LooperMonitorHolder {
        public static /* synthetic */ Interceptable $ic;
        public static final BasicLooperMonitor sInstance;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1691384141, "Laegon/chrome/base/TraceEvent$LooperMonitorHolder;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1691384141, "Laegon/chrome/base/TraceEvent$LooperMonitorHolder;");
                    return;
                }
            }
            sInstance = CommandLine.getInstance().hasSwitch("enable-idle-tracing") ? new IdleTracingLooperMonitor(null) : new BasicLooperMonitor(null);
        }
    }

    public TraceEvent(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mName = str;
        begin(str, str2);
    }

    public static void begin(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            EarlyTraceEvent.begin(str);
            if (sEnabled) {
                nativeBegin(str, str2);
            }
        }
    }

    public static void end(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            EarlyTraceEvent.end(str);
            if (sEnabled) {
                nativeEnd(str, null);
            }
        }
    }

    public static native void nativeBegin(String str, String str2);

    public static native void nativeBeginToplevel(String str);

    public static native void nativeEnd(String str, String str2);

    public static native void nativeEndToplevel(String str);

    public static native void nativeFinishAsync(String str, long j);

    public static native void nativeInstant(String str, String str2);

    public static native void nativeRegisterEnabledObserver();

    public static native void nativeStartATrace();

    public static native void nativeStartAsync(String str, long j);

    public static native void nativeStopATrace();

    public static TraceEvent scoped(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) {
            if (EarlyTraceEvent.enabled() || sEnabled) {
                return new TraceEvent(str, null);
            }
            return null;
        }
        return (TraceEvent) invokeL.objValue;
    }

    @CalledByNative
    public static void setEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65550, null, z) == null) {
            if (z) {
                EarlyTraceEvent.disable();
            }
            if (sEnabled != z) {
                sEnabled = z;
                ThreadUtils.getUiThreadHandler().getLooper().setMessageLogging(z ? LooperMonitorHolder.sInstance : null);
            }
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            end(this.mName);
        }
    }
}
