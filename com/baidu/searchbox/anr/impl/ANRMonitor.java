package com.baidu.searchbox.anr.impl;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.anr.collector.ANRCollector;
import com.baidu.searchbox.anr.ioc.IANRRegister;
import com.baidu.searchbox.anr.upload.ANRBOSRegister;
import com.baidu.searchbox.anr.utils.Utils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.ruka.ioc.IANRMonitor;
import com.github.anrwatchdog.ANRError;
import com.github.anrwatchdog.a;
import java.io.File;
/* loaded from: classes5.dex */
public class ANRMonitor implements IANRMonitor {
    private static final int DEFAULT_WATCHDOG_ANR_TIMEOUT = 5000;
    public static String sANRTimeStamp = null;
    private int mAnrWatchTimeOut = 5000;
    private a mANRWatchDog = null;
    private boolean mMonitorStarted = false;

    @Override // com.baidu.searchbox.ruka.ioc.IANRMonitor
    public boolean enableMonitor() {
        return ANRRuntime.getInstance().enableANR();
    }

    private void retryUpload() {
        for (IANRRegister iANRRegister : ANRRuntime.getInstance().getIANRUploadList().getList()) {
            if (iANRRegister instanceof ANRBOSRegister) {
                ((ANRBOSRegister) iANRRegister).retryUpload();
            }
        }
    }

    @Override // com.baidu.searchbox.ruka.ioc.IANRMonitor
    public void startANRMonitor(int i) {
        if (!this.mMonitorStarted) {
            retryUpload();
            this.mMonitorStarted = true;
            if (i < 5000) {
                this.mAnrWatchTimeOut = 5000;
            } else {
                this.mAnrWatchTimeOut = i;
            }
            this.mANRWatchDog = new a(this.mAnrWatchTimeOut);
            this.mANRWatchDog.eAB();
            this.mANRWatchDog.a(new ANRListenerImpl());
            if (AppConfig.isDebug()) {
                Log.d("Ruka", "mANRWatchDog = " + this.mANRWatchDog.getName());
            }
            this.mANRWatchDog.start();
        }
    }

    @Override // com.baidu.searchbox.ruka.ioc.IANRMonitor
    public void startANRMonitor() {
        startANRMonitor(5000);
    }

    @Override // com.baidu.searchbox.ruka.ioc.IANRMonitor
    public void stopANRMonitor() {
        if (this.mMonitorStarted && this.mANRWatchDog != null) {
            this.mANRWatchDog.interrupt();
            this.mMonitorStarted = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class ANRListenerImpl implements a.b {
        private static final String DEFAULT_ALL_STACK_TRACES_NAME = "all_stack_traces.txt";
        private static final int DEFAULT_LOGCAT_MAX_LEN = 2000;
        private static final String DEFAULT_LOGCAT_NAME = "anr_logcat.txt";
        private static final String DEFAULT_TRACES_PATH = "/data/anr/traces.txt";

        private ANRListenerImpl() {
        }

        @Override // com.github.anrwatchdog.a.b
        public void onAppNotResponding(ANRError aNRError) {
            Context appContext;
            if (AppRuntime.getAppContext() != null) {
                String str = appContext.getFilesDir() + "/" + DEFAULT_LOGCAT_NAME;
                if (Utils.storeIfRealANR(str, 2000)) {
                    ANRMonitor.sANRTimeStamp = String.valueOf(System.currentTimeMillis());
                    String mainThreadStackTrace = ANRCollector.getMainThreadStackTrace();
                    String str2 = "";
                    if (!new File(DEFAULT_TRACES_PATH).canRead()) {
                        str2 = appContext.getFilesDir() + "/" + DEFAULT_ALL_STACK_TRACES_NAME;
                        Utils.storeAllTraces2File(str2);
                    }
                    ANRContext.getANRContext().onAppNotResponding(AppRuntime.getAppContext(), new ANRInfo(ANRMonitor.sANRTimeStamp, mainThreadStackTrace, str, DEFAULT_TRACES_PATH, str2));
                }
            }
        }
    }
}
