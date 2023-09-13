package com.baidu.searchbox.anr.impl;

import android.content.Context;
import android.os.Build;
import android.os.FileObserver;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.anr.collector.ANRCollector;
import com.baidu.searchbox.anr.ioc.IANRRegister;
import com.baidu.searchbox.anr.upload.ANRBOSRegister;
import com.baidu.searchbox.anr.utils.Utils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.ruka.ioc.IANRMonitor;
import com.baidu.tieba.ig1;
import com.baidu.tieba.iub;
import com.baidu.tieba.kg1;
import com.github.anrwatchdog.ANRError;
import com.kwad.sdk.crash.handler.AnrHandler;
import java.io.File;
@Singleton
@Service
/* loaded from: classes3.dex */
public class ANRMonitor implements IANRMonitor {
    public static final long ANR_HAPPENT_TIME_LIMIT = 20000;
    public static final long ANR_TIMEOUT_MS = 25000;
    public static final String DEFAULT_ALL_STACK_TRACES_NAME = "all_stack_traces.txt";
    public static final int DEFAULT_LOGCAT_MAX_LEN = 2000;
    public static final String DEFAULT_LOGCAT_NAME = "anr_logcat.txt";
    public static final String DEFAULT_TRACES_PATH = "/data/anr/traces.txt";
    public static final int DEFAULT_WATCHDOG_ANR_TIMEOUT = 5000;
    public static final String SEPARATOR = "\r\n";
    public static String TAG = "Ruka";
    public static String sANRTimeStamp;
    public static long sLastTimes;
    public FileObserver mFileObserver;
    public ig1 nativeANRListener;
    public int mAnrWatchTimeOut = 5000;
    public iub mANRWatchDog = null;
    public boolean mMonitorStarted = false;

    /* loaded from: classes3.dex */
    public static class ANRListenerImpl implements iub.f {
        public ANRListenerImpl() {
        }

        @Override // com.baidu.tieba.iub.f
        public void onAppNotResponding(ANRError aNRError) {
            Log.d(ANRMonitor.TAG, "ANRWatchDog catch ANR", aNRError);
            ANRMonitor.filiterANR(aNRError.getSTStackTrace());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerANRSignal() {
        if (AppConfig.isDebug()) {
            Log.w(TAG, "start ANR Signal Monitor");
        }
        if (this.nativeANRListener == null) {
            ig1 ig1Var = new ig1() { // from class: com.baidu.searchbox.anr.impl.ANRMonitor.3
                @Override // com.baidu.tieba.ig1
                public void onNativeANR(int i) {
                    if (AppConfig.isDebug()) {
                        String str = ANRMonitor.TAG;
                        Log.w(str, "Java signal receiver ，sig = " + i);
                    }
                    ANRMonitor.filiterANR(null);
                }
            };
            this.nativeANRListener = ig1Var;
            kg1.a(ig1Var);
        }
        kg1.b(Build.VERSION.SDK_INT);
    }

    private void retryUpload() {
        for (IANRRegister iANRRegister : ANRRuntime.getInstance().getIANRUploadList().getList()) {
            if (iANRRegister instanceof ANRBOSRegister) {
                ((ANRBOSRegister) iANRRegister).retryUpload();
            }
        }
    }

    private void startANRListener() {
        FileObserver fileObserver = new FileObserver(AnrHandler.DEFAULT_TRACE_ROOT, 8) { // from class: com.baidu.searchbox.anr.impl.ANRMonitor.1
            @Override // android.os.FileObserver
            public void onEvent(int i, String str) {
                if (AppConfig.isDebug()) {
                    Log.d(ANRMonitor.TAG, "onEvent: " + str);
                }
                if (str != null) {
                    String str2 = AnrHandler.DEFAULT_TRACE_ROOT + str;
                    if (!str2.contains("trace")) {
                        Log.d(ANRMonitor.TAG, "not anr file " + str2);
                        return;
                    }
                    ANRMonitor.filiterANR(null);
                }
            }
        };
        this.mFileObserver = fileObserver;
        try {
            fileObserver.startWatching();
            if (AppConfig.isDebug()) {
                Log.d(TAG, "start ANR FileObserver Listener");
            }
        } catch (Throwable unused) {
            this.mFileObserver = null;
            Log.d(TAG, "start anr monitor failed!");
        }
    }

    private void startANRSignalMonitor() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            registerANRSignal();
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.searchbox.anr.impl.ANRMonitor.2
                @Override // java.lang.Runnable
                public void run() {
                    ANRMonitor.this.registerANRSignal();
                }
            });
        }
    }

    @Override // com.baidu.searchbox.ruka.ioc.IANRMonitor
    public boolean enableMonitor() {
        return ANRRuntime.getInstance().enableANR();
    }

    @Override // com.baidu.searchbox.ruka.ioc.IANRMonitor
    public void startANRMonitor() {
        if (this.mMonitorStarted) {
            return;
        }
        retryUpload();
        this.mMonitorStarted = true;
        if (Build.VERSION.SDK_INT < 21) {
            startANRListener();
        } else {
            startANRMonitor(5000);
        }
        startANRSignalMonitor();
    }

    @Override // com.baidu.searchbox.ruka.ioc.IANRMonitor
    public void stopANRMonitor() {
        if (this.mMonitorStarted) {
            iub iubVar = this.mANRWatchDog;
            if (iubVar != null) {
                iubVar.interrupt();
                this.mMonitorStarted = false;
            }
            FileObserver fileObserver = this.mFileObserver;
            if (fileObserver != null) {
                fileObserver.stopWatching();
                this.mMonitorStarted = false;
            }
            if (this.nativeANRListener != null) {
                kg1.c();
            }
        }
    }

    public static void collectData(StackTraceElement[] stackTraceElementArr) {
        String mainThreadStackTrace;
        String str;
        Context appContext = AppRuntime.getAppContext();
        if (appContext == null) {
            return;
        }
        sANRTimeStamp = String.valueOf(System.currentTimeMillis());
        if (!Utils.checkProcessAnrState(appContext, ANR_TIMEOUT_MS)) {
            return;
        }
        String str2 = appContext.getFilesDir() + "/" + DEFAULT_LOGCAT_NAME;
        Utils.storeLogcat(str2, 2000);
        if (stackTraceElementArr != null && stackTraceElementArr.length > 0) {
            mainThreadStackTrace = stack2String(stackTraceElementArr);
        } else {
            mainThreadStackTrace = ANRCollector.getMainThreadStackTrace();
        }
        String str3 = mainThreadStackTrace;
        if (!new File("/data/anr/traces.txt").canRead()) {
            str = appContext.getFilesDir() + "/" + DEFAULT_ALL_STACK_TRACES_NAME;
            Utils.storeAllTraces2File(str);
        } else {
            str = "";
        }
        ANRContext.getANRContext().onAppNotResponding(AppRuntime.getAppContext(), new ANRInfo(sANRTimeStamp, str3, str2, "/data/anr/traces.txt", str));
    }

    public static void filiterANR(StackTraceElement[] stackTraceElementArr) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - sLastTimes < 20000) {
                Log.d(TAG, "should not process ANR too more in 20000");
            } else {
                sLastTimes = currentTimeMillis;
                collectData(stackTraceElementArr);
            }
        } catch (Throwable th) {
            String str = TAG;
            Log.d(str, "handle anr error  " + th.getMessage());
        }
    }

    public static String stack2String(StackTraceElement[] stackTraceElementArr) {
        StringBuilder sb = new StringBuilder();
        if (stackTraceElementArr != null) {
            try {
                if (stackTraceElementArr.length >= 1) {
                    for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                        sb.append(stackTraceElement.toString() + "\r\n");
                    }
                }
            } catch (Exception e) {
                Log.e("ThreadCollector", "ThreadInfo Collector Interrupted!!", e);
            }
        }
        return sb.toString();
    }

    @Override // com.baidu.searchbox.ruka.ioc.IANRMonitor
    public void startANRMonitor(int i) {
        if (i < 5000) {
            this.mAnrWatchTimeOut = 5000;
        } else {
            this.mAnrWatchTimeOut = i;
        }
        iub iubVar = new iub(this.mAnrWatchTimeOut);
        this.mANRWatchDog = iubVar;
        iubVar.e();
        this.mANRWatchDog.c(new ANRListenerImpl());
        if (AppConfig.isDebug()) {
            String str = TAG;
            Log.d(str, "start mANRWatchDog = " + this.mANRWatchDog.getName() + " Monitor");
        }
        this.mANRWatchDog.start();
    }
}
