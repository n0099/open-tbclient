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
import com.baidu.searchbox.logsystem.util.Common;
import com.baidu.searchbox.track.Track;
import d.a.f0.b.a.a;
import d.a.n.a.b;
/* loaded from: classes2.dex */
public class Loki {
    public static final String CRASH_PAD_PROCESS_NAME = ":crashpad";
    public static volatile boolean sIsInitialized = false;
    public static volatile boolean sIsStartTrack = false;

    @DebugTrace
    @TimeSpendTrace(tag = "AppInit")
    public static void init(@NonNull Context context, @NonNull BaseUncaughtExceptionHandler baseUncaughtExceptionHandler) {
        if (isLokiService(a.b())) {
            return;
        }
        retryUpload(context);
        if (sIsInitialized || baseUncaughtExceptionHandler == null) {
            return;
        }
        sIsInitialized = true;
        Thread.setDefaultUncaughtExceptionHandler(baseUncaughtExceptionHandler);
    }

    public static void initNative(@NonNull Context context) {
        initNative(context, true);
    }

    public static void initService(@Nullable LogSystemProcessor logSystemProcessor) {
        if (isLokiService(a.b())) {
            LokiService.mProcessor = logSystemProcessor;
        }
    }

    public static boolean isCrashpadService(@NonNull String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.endsWith(CRASH_PAD_PROCESS_NAME);
    }

    public static boolean isLokiService(@NonNull String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.endsWith(LokiService.LOG_SYSTEM_SERVICE);
    }

    public static boolean isStartTrack() {
        return sIsInitialized;
    }

    public static void retryUpload(Context context) {
        if (a.f() && LogSystemUploaderStrategy.checkFlag()) {
            LogSystemServiceUtil.startLogHandlerService(context);
        }
    }

    public static void setAppExtraCall(Common.AppExtraCall appExtraCall) {
        Common.setAppExtraCall(appExtraCall);
    }

    public static boolean setCyberVersion(String str) {
        return ZwCrashpad.setCyberVersion(str);
    }

    public static void startTrack() {
        if (sIsStartTrack) {
            return;
        }
        sIsStartTrack = true;
        Track.getInstance().addTrackUIListener(LokiTrackUISaver.getTrackUiListener());
        Track.getInstance().startTrack(AppRuntime.getAppContext());
    }

    public static void initNative(@NonNull Context context, @NonNull b bVar) {
        initNative(context, bVar, true);
    }

    public static void initNative(@NonNull Context context, boolean z) {
        if (isLokiService(a.b())) {
            return;
        }
        NativeCrashCapture.init(context, new b(context), z);
    }

    public static void initService() {
        if (isLokiService(a.b())) {
            LokiService.mProcessor = new LogSystemProcessor();
        }
    }

    public static void initNative(@NonNull Context context, @NonNull b bVar, boolean z) {
        if (isLokiService(a.b())) {
            return;
        }
        NativeCrashCapture.init(context, bVar, z);
    }

    public static void init(@NonNull Context context) {
        init(context, new BaseUncaughtExceptionHandler(context));
        startTrack();
    }
}
