package aegon.chrome.base;

import aegon.chrome.base.annotations.CalledByNative;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.SystemClock;
import android.util.Printer;
import com.baidu.tbadk.core.data.SmallTailInfo;
/* loaded from: classes.dex */
public class TraceEvent implements AutoCloseable {
    public static volatile boolean sEnabled;
    public final String mName;

    /* loaded from: classes.dex */
    public static class BasicLooperMonitor implements Printer {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        public static final int SHORTEST_LOG_PREFIX_LENGTH = 18;
        public String mCurrentTarget;

        public /* synthetic */ BasicLooperMonitor(AnonymousClass1 anonymousClass1) {
        }

        public void beginHandling(String str) {
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

        public void endHandling(String str) {
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

        @Override // android.util.Printer
        public void println(String str) {
            if (str.startsWith(">")) {
                beginHandling(str);
            } else {
                endHandling(str);
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class IdleTracingLooperMonitor extends BasicLooperMonitor implements MessageQueue.IdleHandler {
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

        @Override // aegon.chrome.base.TraceEvent.BasicLooperMonitor
        public final void endHandling(String str) {
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

        @Override // android.os.MessageQueue.IdleHandler
        public final boolean queueIdle() {
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

        public final void syncIdleMonitoring() {
            String str;
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

    /* loaded from: classes.dex */
    public static final class LooperMonitorHolder {
        public static final BasicLooperMonitor sInstance;

        static {
            sInstance = CommandLine.getInstance().hasSwitch("enable-idle-tracing") ? new IdleTracingLooperMonitor(null) : new BasicLooperMonitor(null);
        }
    }

    public TraceEvent(String str, String str2) {
        this.mName = str;
        begin(str, str2);
    }

    public static void begin(String str, String str2) {
        EarlyTraceEvent.begin(str);
        if (sEnabled) {
            nativeBegin(str, str2);
        }
    }

    public static void end(String str) {
        EarlyTraceEvent.end(str);
        if (sEnabled) {
            nativeEnd(str, null);
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
        if (EarlyTraceEvent.enabled() || sEnabled) {
            return new TraceEvent(str, null);
        }
        return null;
    }

    @CalledByNative
    public static void setEnabled(boolean z) {
        if (z) {
            EarlyTraceEvent.disable();
        }
        if (sEnabled != z) {
            sEnabled = z;
            ThreadUtils.getUiThreadHandler().getLooper().setMessageLogging(z ? LooperMonitorHolder.sInstance : null);
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        end(this.mName);
    }
}
