package com.baidu.searchbox.retrieve;

import android.app.Application;
import android.text.TextUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.cloudcontrol.CloudControlManager;
import com.baidu.searchbox.cloudcontrolblcp.CloudControlBlCPManager;
import com.baidu.searchbox.common.runtime.AppRuntimeInit;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.retrieve.connect.FetchConnManager;
import com.baidu.tieba.fj1;
import com.baidu.tieba.jj1;
import com.baidu.tieba.q70;
import com.baidu.tieba.sja;
import com.baidu.tieba.u00;
import com.baidu.voyager.impl.service.VoyagerIPCManager;
import com.baidu.yalog.LoggerManager;
/* loaded from: classes2.dex */
public class YaLogInitManager {
    public static final int OPEN_TYPE = 1;
    public static volatile YaLogInitManager mInstance;
    public Application mApp;

    public static YaLogInitManager getInstance() {
        if (mInstance == null) {
            synchronized (YaLogInitManager.class) {
                if (mInstance == null) {
                    mInstance = new YaLogInitManager();
                }
            }
        }
        return mInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initConnect(boolean z, String str) {
        if (z && this.mApp != null && !TextUtils.isEmpty(str)) {
            CloudControlBlCPManager.getInstance().registerConnectStateListener(this.mApp);
            FetchConnManager.getInstance().init();
            q70.a(this.mApp, str, u00.a().getDeviceId(), 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void retryTask(boolean z) {
        sja sjaVar;
        if (z && (sjaVar = (sja) ServiceManager.getService(sja.a)) != null) {
            sjaVar.retry();
        }
    }

    public void initYaLogBaseContext(Application application) {
        if (application != null) {
            AppRuntimeInit.onApplicationattachBaseContext(application);
            jj1.b(application);
            if (fj1.g()) {
                VoyagerIPCManager.b();
            }
            this.mApp = application;
        }
    }

    public void initYaLog(boolean z, final boolean z2, final boolean z3, final String str) {
        if (!fj1.g()) {
            return;
        }
        if (z) {
            CloudControlManager.getInstance().requestCloudControl("0");
        }
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.searchbox.retrieve.YaLogInitManager.1
            @Override // java.lang.Runnable
            public void run() {
                LoggerManager.getDefaultLogger();
                YaLogInitManager.this.initConnect(z2, str);
                YaLogInitManager.this.retryTask(z3);
            }
        }, "initYaLog", 0);
    }
}
