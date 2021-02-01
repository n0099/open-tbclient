package com.baidu.sapi2;

import com.baidu.sapi2.service.interfaces.ISAccountManager;
/* loaded from: classes15.dex */
public class ServiceManager implements NoProguard {

    /* renamed from: b  reason: collision with root package name */
    private static ServiceManager f4736b;

    /* renamed from: a  reason: collision with root package name */
    private ISAccountManager f4737a;

    public static synchronized ServiceManager getInstance() {
        ServiceManager serviceManager;
        synchronized (ServiceManager.class) {
            if (f4736b == null) {
                f4736b = new ServiceManager();
            }
            serviceManager = f4736b;
        }
        return serviceManager;
    }

    public ISAccountManager getIsAccountManager() {
        return this.f4737a;
    }

    public void setIsAccountManager(ISAccountManager iSAccountManager) {
        this.f4737a = iSAccountManager;
    }
}
