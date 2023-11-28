package com.baidu.searchbox.logsystem.basic;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.crashpad.ZwCrashpad;
import com.baidu.disasterrecovery.jnicrash.NativeCrashCapture;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.searchbox.aop.annotation.TimeSpendTrace;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.logsystem.basic.javacrash.BaseUncaughtExceptionHandler;
import com.baidu.searchbox.logsystem.basic.track.LokiTrackUISaver;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import com.baidu.searchbox.logsystem.util.AppExtraUtil;
import com.baidu.searchbox.track.Track;
import com.baidu.tieba.jx;
import com.baidu.tieba.rf1;
/* loaded from: classes4.dex */
public class Loki {
    public static final String CRASHPAD_DUMPER_PROCESS_NAME = ":dumper";
    public static final String CRASH_PAD_PROCESS_NAME = ":crashpad";
    public static volatile boolean sIsInitialized;
    public static volatile boolean sIsStartTrack;

    public static void initService() {
        if (isLokiService(rf1.b())) {
            LokiService.mProcessor = new LogSystemProcessor();
        }
    }

    public static boolean isStartTrack() {
        return sIsInitialized;
    }

    public static void startTrack() {
        if (!sIsStartTrack) {
            sIsStartTrack = true;
            Track.getInstance().addTrackUIListener(LokiTrackUISaver.getTrackUiListener());
            Track.getInstance().startTrack(AppRuntime.getAppContext());
        }
    }

    public static void init(@NonNull Context context) {
        init(context, new BaseUncaughtExceptionHandler(context));
        startTrack();
    }

    public static void initNative(@NonNull Context context) {
        initNative(context, true);
    }

    public static void initService(@Nullable LogSystemProcessor logSystemProcessor) {
        if (isLokiService(rf1.b())) {
            LokiService.mProcessor = logSystemProcessor;
        }
    }

    public static boolean isCrashpadService(@NonNull String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!str.endsWith(CRASH_PAD_PROCESS_NAME) && !str.endsWith(CRASHPAD_DUMPER_PROCESS_NAME)) {
            return false;
        }
        return true;
    }

    public static boolean isLokiService(@NonNull String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.endsWith(LokiService.LOG_SYSTEM_SERVICE);
        }
        return false;
    }

    public static void retryUpload(Context context) {
        if (rf1.f() && LogSystemUploaderStrategy.checkFlag()) {
            LogSystemServiceUtil.startLogHandlerService(context);
        }
    }

    public static void setAppExtraCall(AppExtraUtil.AppExtraCall appExtraCall) {
        AppExtraUtil.setAppExtraCall(appExtraCall);
    }

    public static boolean setCyberVersion(String str) {
        return ZwCrashpad.setCyberVersion(str);
    }

    @DebugTrace
    @TimeSpendTrace(tag = "AppInit")
    public static void init(@NonNull Context context, @NonNull BaseUncaughtExceptionHandler baseUncaughtExceptionHandler) {
        if (isLokiService(rf1.b())) {
            return;
        }
        retryUpload(context);
        if (sIsInitialized || baseUncaughtExceptionHandler == null) {
            return;
        }
        sIsInitialized = true;
        Thread.setDefaultUncaughtExceptionHandler(baseUncaughtExceptionHandler);
    }

    public static void initNative(@NonNull Context context, @NonNull jx jxVar) {
        initNative(context, jxVar, true);
    }

    public static void initNative(@NonNull Context context, @NonNull jx jxVar, boolean z) {
        if (isLokiService(rf1.b())) {
            return;
        }
        NativeCrashCapture.init(context, jxVar, z);
    }

    public static void initNative(@NonNull Context context, boolean z) {
        if (isLokiService(rf1.b())) {
            return;
        }
        NativeCrashCapture.init(context, new jx(context), z);
    }
}
