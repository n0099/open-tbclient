package com.baidu.sapi2;

import com.baidu.sapi2.service.interfaces.ISAccountManager;
/* loaded from: classes3.dex */
public class ServiceManager implements NoProguard {

    /* renamed from: b  reason: collision with root package name */
    private static ServiceManager f5017b;

    /* renamed from: a  reason: collision with root package name */
    private ISAccountManager f5018a;

    public static synchronized ServiceManager getInstance() {
        ServiceManager serviceManager;
        synchronized (ServiceManager.class) {
            if (f5017b == null) {
                f5017b = new ServiceManager();
            }
            serviceManager = f5017b;
        }
        return serviceManager;
    }

    public ISAccountManager getIsAccountManager() {
        return this.f5018a;
    }

    public void setIsAccountManager(ISAccountManager iSAccountManager) {
        this.f5018a = iSAccountManager;
    }
}
