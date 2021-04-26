package com.baidu.searchbox.anr.impl;

import android.content.Context;
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
import com.github.anrwatchdog.ANRError;
import d.f.a.a;
import java.io.File;
@Singleton
@Service
/* loaded from: classes2.dex */
public class ANRMonitor implements IANRMonitor {
    public static final int DEFAULT_WATCHDOG_ANR_TIMEOUT = 5000;
    public static String sANRTimeStamp;
    public int mAnrWatchTimeOut = 5000;
    public a mANRWatchDog = null;
    public boolean mMonitorStarted = false;

    /* loaded from: classes2.dex */
    public static class ANRListenerImpl implements a.f {
        public static final String DEFAULT_ALL_STACK_TRACES_NAME = "all_stack_traces.txt";
        public static final int DEFAULT_LOGCAT_MAX_LEN = 2000;
        public static final String DEFAULT_LOGCAT_NAME = "anr_logcat.txt";
        public static final String DEFAULT_TRACES_PATH = "/data/anr/traces.txt";

        public ANRListenerImpl() {
        }

        @Override // d.f.a.a.f
        public void onAppNotResponding(ANRError aNRError) {
            Context appContext;
            String str;
            if (AppRuntime.getAppContext() == null) {
                return;
            }
            String str2 = appContext.getFilesDir() + "/" + DEFAULT_LOGCAT_NAME;
            if (Utils.storeIfRealANR(str2, 2000)) {
                ANRMonitor.sANRTimeStamp = String.valueOf(System.currentTimeMillis());
                String mainThreadStackTrace = ANRCollector.getMainThreadStackTrace();
                if (new File("/data/anr/traces.txt").canRead()) {
                    str = "";
                } else {
                    str = appContext.getFilesDir() + "/" + DEFAULT_ALL_STACK_TRACES_NAME;
                    Utils.storeAllTraces2File(str);
                }
                ANRContext.getANRContext().onAppNotResponding(AppRuntime.getAppContext(), new ANRInfo(ANRMonitor.sANRTimeStamp, mainThreadStackTrace, str2, "/data/anr/traces.txt", str));
            }
        }
    }

    private void retryUpload() {
        for (IANRRegister iANRRegister : ANRRuntime.getInstance().getIANRUploadList().getList()) {
            if (iANRRegister instanceof ANRBOSRegister) {
                ((ANRBOSRegister) iANRRegister).retryUpload();
            }
        }
    }

    @Override // com.baidu.searchbox.ruka.ioc.IANRMonitor
    public boolean enableMonitor() {
        return ANRRuntime.getInstance().enableANR();
    }

    @Override // com.baidu.searchbox.ruka.ioc.IANRMonitor
    public void startANRMonitor(int i2) {
        if (this.mMonitorStarted) {
            return;
        }
        retryUpload();
        this.mMonitorStarted = true;
        if (i2 < 5000) {
            this.mAnrWatchTimeOut = 5000;
        } else {
            this.mAnrWatchTimeOut = i2;
        }
        a aVar = new a(this.mAnrWatchTimeOut);
        this.mANRWatchDog = aVar;
        aVar.d();
        this.mANRWatchDog.c(new ANRListenerImpl());
        if (AppConfig.isDebug()) {
            Log.d("Ruka", "mANRWatchDog = " + this.mANRWatchDog.getName());
        }
        this.mANRWatchDog.start();
    }

    @Override // com.baidu.searchbox.ruka.ioc.IANRMonitor
    public void stopANRMonitor() {
        a aVar;
        if (!this.mMonitorStarted || (aVar = this.mANRWatchDog) == null) {
            return;
        }
        aVar.interrupt();
        this.mMonitorStarted = false;
    }

    @Override // com.baidu.searchbox.ruka.ioc.IANRMonitor
    public void startANRMonitor() {
        startANRMonitor(5000);
    }
}
