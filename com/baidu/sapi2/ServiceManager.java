package com.baidu.sapi2;

import com.baidu.sapi2.service.interfaces.ISAccountManager;
/* loaded from: classes12.dex */
public class ServiceManager implements NoProguard {
    private static ServiceManager b;
    private ISAccountManager a;

    public static synchronized ServiceManager getInstance() {
        ServiceManager serviceManager;
        synchronized (ServiceManager.class) {
            if (b == null) {
                b = new ServiceManager();
            }
            serviceManager = b;
        }
        return serviceManager;
    }

    public ISAccountManager getIsAccountManager() {
        return this.a;
    }

    public void setIsAccountManager(ISAccountManager iSAccountManager) {
        this.a = iSAccountManager;
    }
}
