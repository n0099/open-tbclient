package aegon.chrome.base;

import aegon.chrome.base.annotations.CalledByNative;
import java.lang.Thread;
/* loaded from: classes4.dex */
public class JavaExceptionReporter implements Thread.UncaughtExceptionHandler {
    public final boolean mCrashAfterReport;
    public boolean mHandlingException;
    public final Thread.UncaughtExceptionHandler mParent;

    static {
        JavaExceptionReporter.class.desiredAssertionStatus();
    }

    public JavaExceptionReporter(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, boolean z) {
        this.mParent = uncaughtExceptionHandler;
        this.mCrashAfterReport = z;
    }

    @CalledByNative
    public static void installHandler(boolean z) {
        Thread.setDefaultUncaughtExceptionHandler(new JavaExceptionReporter(Thread.getDefaultUncaughtExceptionHandler(), z));
    }

    public static native void nativeReportJavaException(boolean z, Throwable th);

    public static native void nativeReportJavaStackTrace(String str);

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        if (!this.mHandlingException) {
            this.mHandlingException = true;
            nativeReportJavaException(this.mCrashAfterReport, th);
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.mParent;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }
}
