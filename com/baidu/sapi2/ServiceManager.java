package com.baidu.sapi2;

import com.baidu.sapi2.service.interfaces.ISAccountManager;
/* loaded from: classes15.dex */
public class ServiceManager implements NoProguard {
    private static ServiceManager b;

    /* renamed from: a  reason: collision with root package name */
    private ISAccountManager f3289a;

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
        return this.f3289a;
    }

    public void setIsAccountManager(ISAccountManager iSAccountManager) {
        this.f3289a = iSAccountManager;
    }
}
