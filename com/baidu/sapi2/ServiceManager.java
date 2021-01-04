package com.baidu.sapi2;

import com.baidu.sapi2.service.interfaces.ISAccountManager;
/* loaded from: classes3.dex */
public class ServiceManager implements NoProguard {

    /* renamed from: b  reason: collision with root package name */
    private static ServiceManager f5016b;

    /* renamed from: a  reason: collision with root package name */
    private ISAccountManager f5017a;

    public static synchronized ServiceManager getInstance() {
        ServiceManager serviceManager;
        synchronized (ServiceManager.class) {
            if (f5016b == null) {
                f5016b = new ServiceManager();
            }
            serviceManager = f5016b;
        }
        return serviceManager;
    }

    public ISAccountManager getIsAccountManager() {
        return this.f5017a;
    }

    public void setIsAccountManager(ISAccountManager iSAccountManager) {
        this.f5017a = iSAccountManager;
    }
}
