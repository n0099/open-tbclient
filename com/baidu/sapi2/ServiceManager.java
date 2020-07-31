package com.baidu.sapi2;

import com.baidu.sapi2.service.interfaces.ISAccountManager;
/* loaded from: classes19.dex */
public class ServiceManager implements c {
    private static ServiceManager a;
    private ISAccountManager b;

    public static synchronized ServiceManager getInstance() {
        ServiceManager serviceManager;
        synchronized (ServiceManager.class) {
            if (a == null) {
                a = new ServiceManager();
            }
            serviceManager = a;
        }
        return serviceManager;
    }

    public ISAccountManager getIsAccountManager() {
        return this.b;
    }

    public void setIsAccountManager(ISAccountManager iSAccountManager) {
        this.b = iSAccountManager;
    }
}
