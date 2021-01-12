package com.baidu.sapi2;

import com.baidu.sapi2.service.interfaces.ISAccountManager;
/* loaded from: classes3.dex */
public class ServiceManager implements NoProguard {

    /* renamed from: b  reason: collision with root package name */
    private static ServiceManager f4734b;

    /* renamed from: a  reason: collision with root package name */
    private ISAccountManager f4735a;

    public static synchronized ServiceManager getInstance() {
        ServiceManager serviceManager;
        synchronized (ServiceManager.class) {
            if (f4734b == null) {
                f4734b = new ServiceManager();
            }
            serviceManager = f4734b;
        }
        return serviceManager;
    }

    public ISAccountManager getIsAccountManager() {
        return this.f4735a;
    }

    public void setIsAccountManager(ISAccountManager iSAccountManager) {
        this.f4735a = iSAccountManager;
    }
}
