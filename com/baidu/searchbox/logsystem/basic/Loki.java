package com.baidu.searchbox.logsystem.basic;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.baidu.crashpad.ZwCrashpad;
import com.baidu.disasterrecovery.jnicrash.NativeCrashCapture;
import com.baidu.disasterrecovery.jnicrash.b;
import com.baidu.pyramid.runtime.multiprocess.a;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.searchbox.aop.annotation.TimeSpendTrace;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.logsystem.basic.javacrash.BaseUncaughtExceptionHandler;
import com.baidu.searchbox.logsystem.basic.track.LokiTrackUISaver;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import com.baidu.searchbox.logsystem.util.Common;
import com.baidu.searchbox.track.Track;
/* loaded from: classes11.dex */
public class Loki {
    private static final String CRASH_PAD_PROCESS_NAME = ":crashpad";
    private static volatile boolean sIsInitialized = false;
    private static volatile boolean sIsStartTrack = false;

    @DebugTrace
    @TimeSpendTrace(tag = "AppInit")
    public static void init(@NonNull Context context, @NonNull BaseUncaughtExceptionHandler baseUncaughtExceptionHandler) {
        if (!isLokiService(a.getProcessName())) {
            retryUpload(context);
            if (!sIsInitialized && baseUncaughtExceptionHandler != null) {
                sIsInitialized = true;
                Thread.setDefaultUncaughtExceptionHandler(baseUncaughtExceptionHandler);
            }
        }
    }

    public static void init(@NonNull Context context) {
        init(context, new BaseUncaughtExceptionHandler(context));
        startTrack();
    }

    public static void initService(@Nullable LogSystemProcessor logSystemProcessor) {
        if (isLokiService(a.getProcessName())) {
            LokiService.mProcessor = logSystemProcessor;
        }
    }

    public static void initService() {
        if (isLokiService(a.getProcessName())) {
            LokiService.mProcessor = new LogSystemProcessor();
        }
    }

    public static void initNative(@NonNull Context context) {
        initNative(context, true);
    }

    public static void initNative(@NonNull Context context, @NonNull b bVar) {
        initNative(context, bVar, true);
    }

    public static void initNative(@NonNull Context context, boolean z) {
        if (!isLokiService(a.getProcessName())) {
            NativeCrashCapture.init(context, new b(context), z);
        }
    }

    public static void initNative(@NonNull Context context, @NonNull b bVar, boolean z) {
        if (!isLokiService(a.getProcessName())) {
            NativeCrashCapture.init(context, bVar, z);
        }
    }

    public static boolean isLokiService(@NonNull String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.endsWith(":loki");
    }

    public static boolean isCrashpadService(@NonNull String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.endsWith(CRASH_PAD_PROCESS_NAME);
    }

    public static void startTrack() {
        if (!sIsStartTrack) {
            sIsStartTrack = true;
            Track.getInstance().addTrackUIListener(LokiTrackUISaver.getTrackUiListener());
            Track.getInstance().startTrack(AppRuntime.getAppContext());
        }
    }

    public static void retryUpload(Context context) {
        if (a.afG() && LogSystemUploaderStrategy.checkFlag()) {
            LogSystemServiceUtil.startLogHandlerService(context);
        }
    }

    public static boolean isStartTrack() {
        return sIsInitialized;
    }

    public static void setAppExtraCall(Common.AppExtraCall appExtraCall) {
        Common.setAppExtraCall(appExtraCall);
    }

    public static boolean setCyberVersion(String str) {
        return ZwCrashpad.setCyberVersion(str);
    }
}
