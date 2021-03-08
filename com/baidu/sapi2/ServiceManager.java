package com.baidu.sapi2;

import com.baidu.sapi2.service.interfaces.ISAccountManager;
/* loaded from: classes3.dex */
public class ServiceManager implements NoProguard {
    private static ServiceManager b;

    /* renamed from: a  reason: collision with root package name */
    private ISAccountManager f3195a;

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
        return this.f3195a;
    }

    public void setIsAccountManager(ISAccountManager iSAccountManager) {
        this.f3195a = iSAccountManager;
    }
}
