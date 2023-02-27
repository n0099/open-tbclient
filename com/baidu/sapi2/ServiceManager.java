package com.baidu.sapi2;

import com.baidu.sapi2.service.interfaces.ISAccountManager;
/* loaded from: classes2.dex */
public class ServiceManager implements NoProguard {
    public static ServiceManager instance;
    public ISAccountManager isAccountManager;

    public static synchronized ServiceManager getInstance() {
        ServiceManager serviceManager;
        synchronized (ServiceManager.class) {
            if (instance == null) {
                instance = new ServiceManager();
            }
            serviceManager = instance;
        }
        return serviceManager;
    }

    public ISAccountManager getIsAccountManager() {
        return this.isAccountManager;
    }

    public void setIsAccountManager(ISAccountManager iSAccountManager) {
        this.isAccountManager = iSAccountManager;
    }
}
