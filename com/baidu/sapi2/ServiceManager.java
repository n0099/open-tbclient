package com.baidu.sapi2;

import com.baidu.sapi2.service.interfaces.ISAccountManager;
/* loaded from: classes2.dex */
public class ServiceManager implements NoProguard {

    /* renamed from: b  reason: collision with root package name */
    public static ServiceManager f10886b;

    /* renamed from: a  reason: collision with root package name */
    public ISAccountManager f10887a;

    public static synchronized ServiceManager getInstance() {
        ServiceManager serviceManager;
        synchronized (ServiceManager.class) {
            if (f10886b == null) {
                f10886b = new ServiceManager();
            }
            serviceManager = f10886b;
        }
        return serviceManager;
    }

    public ISAccountManager getIsAccountManager() {
        return this.f10887a;
    }

    public void setIsAccountManager(ISAccountManager iSAccountManager) {
        this.f10887a = iSAccountManager;
    }
}
