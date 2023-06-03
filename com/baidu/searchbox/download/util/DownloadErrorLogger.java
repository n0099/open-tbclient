package com.baidu.searchbox.download.util;

import androidx.transition.Transition;
import com.baidu.yalog.Logger;
import com.baidu.yalog.LoggerManager;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/download/util/DownloadErrorLogger;", "", "()V", "mLogger", "Lcom/baidu/yalog/Logger;", "Companion", "lib-download_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DownloadErrorLogger {
    public static final String LOGGER_SPACE = "download_error";
    public static final String LOG_ID = "download_error_logger";
    public Logger mLogger;
    public static final Companion Companion = new Companion(null);
    public static final Lazy<DownloadErrorLogger> instance$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<DownloadErrorLogger>() { // from class: com.baidu.searchbox.download.util.DownloadErrorLogger$Companion$instance$2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DownloadErrorLogger invoke() {
            return new DownloadErrorLogger();
        }
    });

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004J\u0016\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004J\u000e\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/download/util/DownloadErrorLogger$Companion;", "", "()V", "LOGGER_SPACE", "", "LOG_ID", Transition.MATCH_INSTANCE_STR, "Lcom/baidu/searchbox/download/util/DownloadErrorLogger;", "getInstance", "()Lcom/baidu/searchbox/download/util/DownloadErrorLogger;", "instance$delegate", "Lkotlin/Lazy;", "debugLog", "", "tag", "message", "errorLog", "flush", "waitFinished", "", "lib-download_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }

        public final DownloadErrorLogger getInstance() {
            return (DownloadErrorLogger) DownloadErrorLogger.instance$delegate.getValue();
        }

        public final void debugLog(String tag, String message) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(message, "message");
            getInstance().mLogger.d(DownloadErrorLogger.LOG_ID, tag, message);
        }

        public final void errorLog(String tag, String message) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(message, "message");
            getInstance().mLogger.e(DownloadErrorLogger.LOG_ID, tag, message);
        }

        public final void flush(boolean z) {
            getInstance().mLogger.flush(z);
        }
    }

    public DownloadErrorLogger() {
        Logger logger = LoggerManager.getLogger(LOGGER_SPACE);
        Intrinsics.checkNotNullExpressionValue(logger, "getLogger(LOGGER_SPACE)");
        this.mLogger = logger;
    }
}
